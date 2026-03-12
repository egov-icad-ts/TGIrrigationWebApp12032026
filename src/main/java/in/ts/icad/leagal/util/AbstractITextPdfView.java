package in.ts.icad.leagal.util;


	
	
	import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
	import java.util.Map;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.springframework.web.servlet.view.AbstractView;

	import com.itextpdf.text.Document;
	import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

	/**
	 * This class is a work around for working with iText 5.x in Spring.
	 * The code here is almost identical to the AbstractPdfView class. 
	 *
	 */
	public abstract class AbstractITextPdfView extends AbstractView {
		
		  PdfTemplate total;

		public AbstractITextPdfView() {
			setContentType("application/pdf");
		}

		@Override
		protected boolean generatesDownloadContent() {
			return true;
		}
			
		@Override
		protected void renderMergedOutputModel(Map<String, Object> model,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// IE workaround: write into byte array first.
			ByteArrayOutputStream baos = createTemporaryOutputStream();

			// Apply preferences and build metadata.
			Document document = newDocument();
			
			 PdfWriter writer = PdfWriter.getInstance(document,baos);
			//PdfWriter writer = newWriter(document, baos);
			prepareWriter(model, writer, request);
			buildPdfMetadata(model, document, request);
			
			
			// Build PDF document.
			document.open();
			document.setMargins(60,20,50,40);// left,right,left,bottom 80 , 20 , 50, 20
			document.newPage();
			
			buildPdfDocument(model, document, writer, request, response);
			document.close();

			// Flush to HTTP response.
			writeToResponse(response, baos);
		}

		protected Document newDocument() {
			return new Document(PageSize.A3.rotate());
		}
		
		protected PdfWriter newWriter(Document document, OutputStream os) throws DocumentException {
			return PdfWriter.getInstance(document, os);
		}
		
		protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request)
				throws DocumentException {

			writer.setViewerPreferences(getViewerPreferences());
		}
		
		protected int getViewerPreferences() {
			return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
		}
		
		protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
		}
		
		protected abstract void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
				HttpServletRequest request, HttpServletResponse response) throws Exception;	
		
		public void onEndPage(PdfWriter writer, Document document) {
            PdfPTable table = new PdfPTable(2);
              total = writer.getDirectContent().createTemplate(30, 16);
            try {
               
                table.setWidths(new int[]{48, 2});
                table.setTotalWidth(document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin());
                table.setLockedWidth(true);
                
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
                table.getDefaultCell().setBorder(Rectangle.NO_BORDER); 
                table.addCell(String.format("Page %d  ", writer.getPageNumber()));
                PdfPCell cell = new PdfPCell(Image.getInstance(total));
                cell.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell);
               // table.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin(), writer.getDirectContent());
            }
            catch(DocumentException de) {
                throw new ExceptionConverter(de);
            }
        }
		
		public void onCloseDocument(PdfWriter writer, Document document) {
			
			
		     
            ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
                    new Phrase(String.valueOf(writer.getPageNumber() - 1)),
                    2, 2, 0);
        }


	}


