package in.ts.icad.leagal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import in.ts.icad.leagal.model.CAGParas;
import in.ts.icad.leagal.model.CAGParasData;
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.ReplyData;

public class PDFCAGpara extends AbstractITextpdfPortraitView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        writer.setPageEvent(event);
		
		 doc.resetPageCount();//without this page number is incremented by one
		
			doc.open();//after setting size then open new doc, so that for first page also orientation is set
		
		
		Font blueFont = FontFactory.getFont(FontFactory.TIMES_BOLD   , 14, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
    	Font redFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0));
    	//Font yellowFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, new CMYKColor(0, 0, 255, 0));
    	Font blackFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, new CMYKColor(255, 255, 255, 255));
    	Font greenFont = FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD, new CMYKColor(100, 0, 100, 60));
    	
    	Font blackPlane = FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL, new CMYKColor(255, 255, 255, 255));
      
    
    	
    	
		List<CAGParasData> listparaData = new ArrayList<CAGParasData>();
		
		
		
		listparaData=(List<CAGParasData>) model.get("cagparas");
		
		//doc.addTitle("CAG Paras Report");
		// Paragraph paragraphOne = new Paragraph("CAG Paras Report", blackFont);
		// paragraphOne.setAlignment(Element.ALIGN_CENTER);
		 //   doc.add(paragraphOne);
		    
		   
		     
	 	       BaseFont bf = BaseFont.createFont(
                      BaseFont.TIMES_ROMAN,
                      BaseFont.CP1252,
                      BaseFont.EMBEDDED);
              Font font = new Font(bf, 14);
	 	        // define font for table header row
	 	       // Font font = FontFactory.getFont(FontFactory.TIMES);
	 	        font.setColor(BaseColor.WHITE);
	 	      
	 	         
        
   
			 PdfContentByte cb = writer.getDirectContent();
	    	 cb.setFontAndSize(bf, 14);
	
	    	 Integer i=1;
	    	 
	    	 String docname=" ";
	    	 
	    	// System.out.println("doc.bottomMargin();"+doc.bottomMargin());
	      //	 doc.newPage();
	    	       
	    	       // for (int m=0; m<j ; m++){
	    	        	
	           PdfPTable table = new PdfPTable(1);
	    		   	 
	    	        table.setWidthPercentage(100.0f);
	    	        table.setWidths(new float[] { 10.0f});
	    	        table.setSpacingBefore(10);
	    	        table.setTotalWidth(100.0f);
	    	        table.getHorizontalAlignment();
	    	        table.completeRow();
	    	        
	    	        //table.setSplitRows(true);
	    	        
	    	       table.setSpacingAfter(-3);
	    	       table.setSplitLate(false);
	    	       
	    	       table.setComplete(false);
	    	       
	    	    
	    	       table.setSkipFirstHeader(false);
	    	       
	    	       
	    	       
	    	       
	    	   	Paragraph title = new Paragraph(listparaData.get(0).getFinancialYear(), blackFont);
	    		title.setAlignment(Element.ALIGN_CENTER);
	    		 doc.add(title);
	    		 
	    		 Paragraph paragraphtwo = new Paragraph(listparaData.get(0).getParaNumber()+"  "+listparaData.get(0).getCagGistPara(), blackFont);
	    		 paragraphtwo.setAlignment(Element.ALIGN_CENTER);
	    		
	    		 
	    		    doc.add(paragraphtwo);
	    	       
	    	      
	          PdfPCell cell = new PdfPCell();
	          
	         
	         
	          cell.setBorder(0);
	           cell.setNoWrap(false);
	           
	           cell.setPadding(5);
	          
	         cell.getVerticalAlignment();
	         
	      			
	      		
	      		   
	      		 
	    	 	     
	    	 	   
	    	 	      
	     		 
	    	 	 
	    	 	     
	    	 	   
	    	 	      
	     		
	    	 	       int k=listparaData.size();
	    	 	        
	    	 	   	for(int a=0; a<k ; a++){
	    	 	   		
	    	 	   	if(!listparaData.get(a).getSubParaNumber().equals("0")){
	    		 	   	
	  	 	 	   	  cell.setPhrase(new Phrase(listparaData.get(a).getSubParaNumber()+"  "+listparaData.get(a).getParaTitle(), blackFont));
	  	 		 	        table.addCell(cell);
	   	   			
	   	   			
	   	   		}
	  		 	     //cell.setPhrase(new Phrase(listparaData.get(a).getParasAction(), blackFont));
	  		 	       // table.addCell(cell);
	  		 	        
	  		 	     PdfPCell childcell1 = new PdfPCell();
	  		 	  childcell1.setBorder(0);
			 	      childcell1.setNoWrap(false);
			 	     childcell1.setPadding(5);
			 	     
			 	    for (Element e : XMLWorkerHelper.parseToElementList(listparaData.get(a).getParasAction(), " ")) {
		            	childcell1.setNoWrap(false);
		            	
		            	childcell1.setPadding(5);
		           // System.out.println(m+"m"+e.PARAGRAPH);
		            	childcell1.addElement(e);
		                
		              
		             
		             
		            }         
		            childcell1.setPadding(5);
		            table.addCell(childcell1);	
	    	 	   		
	    	 	   		
	    	 	   	}
	    	 	        
	    	 	        
	    	 	       table.setComplete(true);
	  	 	             doc.add(table);
	  	 	             
	  	 	          i++;
	 	             
	  	 	        	 
  	 	        	  
	  	 	        	
	  	 	       
  	 	        	  onEndPage(writer ,doc);
  	 	        	//onCloseDocument(writer ,doc);
	 
		
	}

}
