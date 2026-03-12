package in.ts.icad.leagal.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class HeaderFooterPageEvent extends PdfPageEventHelper {

    private PdfTemplate t;
    private Image total;

    public void onOpenDocument(PdfWriter writer, Document document) {
        t = writer.getDirectContent().createTemplate(30, 16);
        try {
            total = Image.getInstance(t);
            total.setRole(PdfName.ARTIFACT);
        } catch (DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
      //  addHeader(writer);
        addFooter(writer);
    }
 
    private void addHeader(PdfWriter writer){
        PdfPTable header = new PdfPTable(2);
        try {
            // set defaults
            header.setWidths(new int[]{2, 24});
            header.setTotalWidth(527);
            header.setLockedWidth(true);
            header.getDefaultCell().setFixedHeight(40);
            header.getDefaultCell().setBorder(Rectangle.BOTTOM);
            header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

            // add image
            /*Image logo = Image.getInstance(HeaderFooterPageEvent.class.getResource("/memorynotfound-logo.jpg"));
            header.addCell(logo);*/
            

            // add text
            PdfPCell text = new PdfPCell();
            text.setPaddingBottom(15);
            text.setPaddingLeft(10);
            text.setBorder(Rectangle.BOTTOM);
            text.setBorderColor(BaseColor.LIGHT_GRAY);
            text.addElement(new Phrase("iText PDF Header  Example", new Font(Font.FontFamily.HELVETICA, 12)));
            text.addElement(new Phrase("Header ", new Font(Font.FontFamily.HELVETICA, 8)));
            header.addCell(text);
      

            // write content
            header.writeSelectedRows(0, -1, 60, 803, writer.getDirectContent());
        } catch(DocumentException de) {
            throw new ExceptionConverter(de);
        } /*catch (MalformedURLException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }*/
    }

    private void addFooter(PdfWriter writer){
        PdfPTable footer = new PdfPTable(3);
        t = writer.getDirectContent().createTemplate(30, 16);

        try {
            // set defaults
        	//footer.setWidths(new int[]{24});
            footer.setWidths(new int[]{20, 4, 1});
            footer.setTotalWidth(527);
            footer.setLockedWidth(true);
            footer.getDefaultCell().setFixedHeight(30);
            footer.getDefaultCell().setBorder(Rectangle.TOP);
           footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

            // add copyright
            footer.addCell(new Phrase("         ", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));

            // add current page count
            footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            footer.addCell(new Phrase(String.format("Page %d ", writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)));

            // add placeholder for total page count
            PdfPCell totalPageCount = new PdfPCell(Image.getInstance(t));
            totalPageCount.setBorder(Rectangle.TOP);
            totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
            footer.addCell(totalPageCount);
          // footer.addCell(new Phrase(String.format("hi %d ", writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)));

            // write page
            PdfContentByte canvas = writer.getDirectContent();
            canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
            footer.writeSelectedRows(0, -1, 60, 38, canvas);
            canvas.endMarkedContentSequence();
        } catch(DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    public void onCloseDocument(PdfWriter writer, Document document) {
        int totalLength = String.valueOf(writer.getPageNumber()).length();
        int totalWidth = totalLength * 5;
        /*ColumnText.showTextAligned(t, Element.ALIGN_RIGHT,
                new Phrase(String.valueOf(writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)),
                totalWidth, 6, 0);*/
    }
    
    
    /**
	 * Writes the selected rows to the document.
	 *
	 * @param rowStart the first row to be written, zero index
	 * @param rowEnd   the last row to be written + 1. If it is -1 all the
	 *                 rows to the end are written
	 * @param xPos     the x write coordinate
	 * @param yPos     the y write coordinate
	 * @param canvas   the <CODE>PdfContentByte</CODE> where the rows will
	 *                 be written to
	 * @return the y coordinate position of the bottom of the last row
	 
	public float WriteSelectedRows(int rowStart, int rowEnd, float xPos, float yPos, PdfContentByte canvas)*/
	
	/* <summary>
	 Constructs a new Document-object.
	</summary>
	 <param name="pageSize">the pageSize</param>
	 <param name="marginLeft">the margin on the left</param>
	 <param name="marginRight">the margin on the right</param>
	 <param name="marginTop">the margin on the top</param>
     <param name="marginBottom">the margin on the bottom</param>
	public Document(Rectangle pageSize, float marginLeft, float marginRight, float marginTop, float marginBottom) */  
	
	
	/*Document document = new Document(PageSize.A4, 10, 10, 10, 10);
	 * fTbl.WriteSelectedRows(0, -1, 15, 110, writer.DirectContent);
	starts drawing the table at the coordinate (15, 110) --- the origin (0, 0) here is the bottom left corner of your document.

	Thus, obviously, page content area and footer area overlap in the stripe 10 <= y <= 110. 
	You should increase the bottom margin (the last parameter in your Document constructor) and decrease the y position of 
	the table drawing call to not overlap anymore.*/
}



		


