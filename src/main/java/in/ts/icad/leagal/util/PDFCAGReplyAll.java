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

public class PDFCAGReplyAll extends AbstractITextpdfPortraitView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        writer.setPageEvent(event);
        
		Font blueFont = FontFactory.getFont(FontFactory.TIMES_BOLD   , 14, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
    	Font redFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0));
    	//Font yellowFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, new CMYKColor(0, 0, 255, 0));
    	Font blackFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, new CMYKColor(255, 255, 255, 255));
    	Font greenFont = FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD, new CMYKColor(100, 0, 100, 60));
    	
    	Font blackPlane = FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL, new CMYKColor(255, 255, 255, 255));
      
    	CAGParas listParas = new CAGParas();
		List<CAGParasData> listparaData = new ArrayList<CAGParasData>();
		List<ReplyData> listreplyData = new ArrayList<ReplyData>();
		List<ParaDocuments> listparadocs = new ArrayList<ParaDocuments>();
		
		//listParas=(CAGParas) model.get("cagparas");
		//listparaData=(List<CAGParasData>) model.get("paraDataTotal");
		listreplyData=(List<ReplyData>) model.get("replyDatabypara");
		//listparadocs=(List<ParaDocuments>) model.get("paradocsList");
		
	
		    
		   
		     
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
	         
	    //  	 doc.newPage();
	    	       
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
	    	       
	    	      
	          PdfPCell cell = new PdfPCell();
	          
	         
	         
	          cell.setBorder(0);
	           cell.setNoWrap(false);
	          
	         cell.getVerticalAlignment();
	         
	      
		  	 	
		            if(listreplyData!=null){
		            
		            int c=listreplyData.size();
			          
	 	        		for(int d=0; d<c ; d++){
	 	        			
	 	        		
		  	  	 	  
		  		      
		  	    
		  	  	 	        		
	 	        		
	 	        	
	 	        		
	 	        	
	 	        			
	 	        		 cell.setPhrase(new Phrase(listreplyData.get(d).getUnitName(), redFont));
	  		 	         table.addCell(cell);
	  		 	         
	  		 	         
	  		 	         
	  		 
	 	        
	  		 	        
	  		 	     PdfPCell childcell2 = new PdfPCell();
	  		 	  childcell2.setBorder(0);
		 	         childcell2.setNoWrap(false);
		 	        childcell2.setPadding(5);
		 	     

		            for (Element e : XMLWorkerHelper.parseToElementList(listreplyData.get(d).getReplyAction(), " ")) {
		            	childcell2.setNoWrap(false);
		            	
		            	childcell2.setPadding(5);
		         
		            	childcell2.addElement(e);
		                
		              
		             
		             
		            }         
		          childcell2.setPadding(5);
		         
		          table.addCell(childcell2);	
           if(listreplyData.get(d).getReplyRemarks()!=null ){
         	  
         	  if(listreplyData.get(d).getReplyRemarks().length()>0){
		          cell.setPhrase(new Phrase("Remarks", redFont));
		 	        table.addCell(cell);
		          cell.setPhrase(new Phrase(listreplyData.get(d).getReplyRemarks(), blackPlane));
		 	        table.addCell(cell);
         	  }
           }
		 	  
           
          
	        	    
	 	        		}
	 	        	
	 	        
		 	       
	  	 	        		
    			
	 	        	
    		}	
	 	     
	    	 	        
	    	 	       table.setComplete(true);
	  	 	             doc.add(table);
	  	 	             
	  	 	          i++;
	 	             
	  	 	        	 
  	 	        	  
	  	 	        	
	  	 	       
  	 	        	  onEndPage(writer ,doc);
	
		
	}

}
