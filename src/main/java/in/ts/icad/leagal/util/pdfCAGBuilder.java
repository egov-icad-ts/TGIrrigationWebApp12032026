package in.ts.icad.leagal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;

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


public class pdfCAGBuilder extends AbstractITextPdfView {
	
	
	 
	   
	@Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
    	
    	Font blueFont = FontFactory.getFont(FontFactory.TIMES_BOLD   , 14, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
    	Font redFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0));
    	//Font yellowFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, new CMYKColor(0, 0, 255, 0));
    	Font blackFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, new CMYKColor(255, 255, 255, 255));
    	Font greenFont = FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD, new CMYKColor(100, 0, 100, 60));
    	
    	Font blackPlane = FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL, new CMYKColor(255, 255, 255, 255));
      
    
    	 
		@SuppressWarnings("unchecked")
		CAGParas listParas = new CAGParas();
		List<CAGParasData> listparaData = new ArrayList<CAGParasData>();
		List<ReplyData> listreplyData = new ArrayList<ReplyData>();
		List<ParaDocuments> listparadocs = new ArrayList<ParaDocuments>();
		
		listParas=(CAGParas) model.get("cagparas");
		listparaData=(List<CAGParasData>) model.get("paraDataTotal");
		listreplyData=(List<ReplyData>) model.get("replyDataTotal");
		listparadocs=(List<ParaDocuments>) model.get("paradocsList");
	
		
		doc.addTitle("CAG Paras Report");
		 Paragraph paragraphOne = new Paragraph("CAG Paras Report", blackFont);
		 paragraphOne.setAlignment(Element.ALIGN_CENTER);
		    doc.add(paragraphOne);
		    
		   
		     
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
       
        
      /*  XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
		fontImp.register(FONT);*/
        
      //  System.out.println("i am not here");
        // write table row data
       Integer i=1;
    
/*        
        for (Paras para : listParas) {  	
       
 	        
 	     
 	        
 	    
 	        // define table header cell
 	        
        	
 	      
        	
        	  if(para.getUnitId()>0 && para.getCircleId()==0 && para.getDivisionId()==0){
        		  
        		  Paragraph OfficeName = new Paragraph("Office Name : "+para.getUnitName(), blackFont);
        		  OfficeName.setAlignment(Element.ALIGN_LEFT);
        		     doc.add(OfficeName);
				    

				    Paragraph larNumber = new Paragraph("LAR Number : "+para.getLarNumber(), redFont);
				    larNumber.setAlignment(Element.ALIGN_LEFT);
        		     doc.add(larNumber);
				 
				    Paragraph fileNumber = new Paragraph("File Number : "+para.getFileNumber(), blueFont);
				    fileNumber.setAlignment(Element.ALIGN_LEFT);
        		     doc.add(fileNumber);
  	            }
  	            if(para.getUnitId()>0 && para.getCircleId()>0 && para.getDivisionId()==0){
  	            	 Paragraph OfficeName = new Paragraph("Office Name : "+para.getCircleName(), blackFont);
  	            	  OfficeName.setAlignment(Element.ALIGN_LEFT);
	        		     doc.add(OfficeName);
					    
 				   Paragraph larNumber = new Paragraph("LAR Number : "+para.getLarNumber(), redFont);
 				  larNumber.setAlignment(Element.ALIGN_LEFT);
        		     doc.add(larNumber);
				 
				    Paragraph fileNumber = new Paragraph("File Number : "+para.getFileNumber(), blueFont);
				    fileNumber.setAlignment(Element.ALIGN_LEFT);
        		     doc.add(fileNumber);
  		            }
  	            if(para.getUnitId()>0 && para.getCircleId()>0 && para.getDivisionId()>0){
  	            	 Paragraph OfficeName = new Paragraph("Office Name : "+para.getDivisionName(), blackFont);
  	            	 OfficeName.setAlignment(Element.ALIGN_LEFT);
        		     doc.add(OfficeName);
				    
 				   Paragraph larNumber = new Paragraph("LAR Number : "+para.getLarNumber(), redFont);
 				  larNumber.setAlignment(Element.ALIGN_LEFT);
        		     doc.add(larNumber);
				 
				    Paragraph fileNumber = new Paragraph("File Number : "+para.getFileNumber(), blueFont);
				    fileNumber.setAlignment(Element.ALIGN_LEFT);
        		     doc.add(fileNumber);
  		            }
  	            
        	
  	          
			 
        	
        	String sno=i.toString();
            table.addCell(sno);
            
          
            
          
            table.addCell(para.getParaNumsectionA());
            table.addCell(para.getParaNumsectionB());
            
        
          
          
          
          
           
         
           
            PdfPCell cell1 = new PdfPCell();
            cell1.setNoWrap(false);
            cell1.setPadding(5);
            for (Element e : XMLWorkerHelper.parseToElementList(para.getParasAction(), " ")) {
            	cell1.setNoWrap(false);
  			  cell1.setPadding(5);
                cell1.addElement(e);
             
            }
        
            cell1.setPadding(5);
            table.addCell(cell1);
         
           
            PdfPCell cell2 = new PdfPCell();
            cell2.setNoWrap(false);
            for (Element e : XMLWorkerHelper.parseToElementList(para.getReplyAction(), " ")) {
            	cell2.setNoWrap(false);
  			  cell2.setPadding(5);
                cell2.addElement(e);
             
            }
            
            cell2.setPadding(5);
            table.addCell(cell2);
            
            table.addCell(para.getDocoriginalName());
            
            
          
            i++;
            
          //  table.addCell(String.format("Page %d of", writer.getPageNumber()));
            
           // table.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
            
           
	        //
           
            onEndPage(writer ,doc);
           // onCloseDocument(writer,doc);
            doc.add(table);
            
          
            
          
          
           
          
           PdfPCell cell3 = new PdfPCell(total);
           cell.setBorder(Rectangle.BOTTOM);
           table.addCell(cell);
            
           
            
        }
         */
       String docname=" ";
       
  	 doc.newPage();
	       
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
      
     
     
      
       cell.setNoWrap(false);
      
     cell.getVerticalAlignment();
     
  			
  		
  		   
  		  cell.setPhrase(new Phrase("Finacial Year	:	"+listParas.getFinancialYear(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	     
	 	        
	 	      
 		  cell.setPhrase(new Phrase("Para Number	:	"+listParas.getParaNumber(), redFont));
	 	        table.addCell(cell);
	 	        
	 	    
	 	        
	 	      
		 
	            
	      
	 	      
    		  cell.setPhrase(new Phrase("Gist of Para	:	"+listParas.getActionTitle(), blackFont));
	 	        table.addCell(cell); 
  
   
  	
 	   
               
		        
	 	      
  	        
	 	   
  	 	        
  	 	   
  	 	        
  	 	        int k=listparaData.size();
  	 	    
  	 	        		
  	 	        		for(int a=0; a<k ; a++){
  	 	        		
  	 	        	
  	 	        		 
  	 	        		if(listParas.getCagGistId()==listparaData.get(a).getCagGistId())	{
  	 	       			
  	 	        		 
  	 	        			      
  	 	        		 	        		
  	 		 	        
  	 		 	    cell.setPhrase(new Phrase("Sub Para : "+listparaData.get(a).getSubParaNumber()+"  "+listparaData.get(a).getParaTitle(), blackFont));
  		 	        table.addCell(cell);
  		 	        
  		 	        
  		 	  	cell.setPhrase(new Phrase("Para Status :	"+listparaData.get(a).getParaStatus()+"   Whether Discussed in PAC :	"+listparaData.get(a).getDiscussPac(), blueFont));
 			      table.addCell(cell);
  		 	        
  		 	        
  		 	        
		 	        
		 	       PdfPCell childcell1 = new PdfPCell();
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
		            
		            int c=listreplyData.size();
		          
	  	  	 	        		for(int d=0; d<c ; d++){
	  	  	 	        			
	  	  	 	        		
	  	  		  	  	 	  
	  	  		  		      
	  	  		  	    
	  	  		  	  	 	        		
	  	  	 	        		
	  	  	 	        		if(listparaData.get(a).getCagParaId()==listreplyData.get(d).getCagParaId()){
	  	  	 	        		
	  	  	 	        	
	  	  	 	        			
	  	  	 	        		 cell.setPhrase(new Phrase("EXPLANATORY NOTE OF THE DEPARTMENT", redFont));
	  	  	  		 	         table.addCell(cell);
	  	  	  		 	         
	  	  	  		 	         
	  	  	  		 	         
	  	  	  		 
	   		 	        
	  	  	  		 	        
	  	  	  		 	     PdfPCell childcell2 = new PdfPCell();
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
	  	  	 	        		
	  	  	 	        		
  	 	        		}
  	 	        	
  	 	        	  int e=listparadocs.size();
  	  	 	          
  	  	 		      
  	 	   	 	  
  	 	    	 	 
	  	 	        		for(int f=0; f<e ; f++){
	  	 	        		if(listParas.getCagGistId()==listparadocs.get(f).getCagGistId())	{	
	  	 	        			
	  	 	        			
	  	 	        			if(f==0){
	  	 	        				
	  	 	        			docname=listparadocs.get(f).getParaDocOriginalName();
	  	 	        			}
	  	 	        			if(f>1){
	  	 	        				
	  	 	        			docname=docname+","+listparadocs.get(f).getParaDocOriginalName();
	  	 	        			}
	  	 	        	
	  	 	        		
	  	 	        		}
	  	 	         
	  	 	        		}
	  	 	        		
	  	 	        		//System.out.println("doc"+docname);
	  	 	        	
	        	  
 	             
 	             
 	           
	  	 	        	    
	  	 	        		
	  	 	        	

  	 	        		}
  	 	        		
  	 	        
 		 	          
 		  	 	      
  	 	        	 table.setComplete(true);
  	 	             doc.add(table);
 
  	 	  	        
  	 	          /* cell.setPhrase(new Phrase("Documents", redFont));
	  		 	        table.addCell(cell);
	  		 	  cell.setPhrase(new Phrase(docname, blackFont));
	        	  table.addCell(cell);	*/
	        			
	        	  i++;
	             
  	 	        	 
  	 	        	  
  	 	        	
      
  	 	        	  onEndPage(writer ,doc);
  	 	             
  	 	           
  	 	             
          
   
           
           
            
           
            
            
          
          
          
            
          
          
           
        
	        	
	        	
	        	
	      //}
	        
	        
       
         
    }
	
	
 
}
