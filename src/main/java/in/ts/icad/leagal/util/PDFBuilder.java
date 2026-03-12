package in.ts.icad.leagal.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;





import in.ts.icad.leagal.model.Paras;



import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;

public class PDFBuilder extends AbstractITextPdfView {
	
	
		 
	   
		@Override
	    protected void buildPdfDocument(Map<String, Object> model, Document doc,
	            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        // get data model which is passed by the Spring container
	    	
	    	Font blueFont = FontFactory.getFont(FontFactory.TIMES_BOLD   , 16, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
	    	Font redFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, Font.BOLD, new CMYKColor(0, 255, 0, 0));
	    	//Font yellowFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, new CMYKColor(0, 0, 255, 0));
	    	Font blackFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, Font.BOLD, new CMYKColor(255, 255, 255, 255));
	    	Font greenFont = FontFactory.getFont(FontFactory.TIMES, 16, Font.BOLD, new CMYKColor(100, 0, 100, 60));
	    	
	    	Font blackPlane = FontFactory.getFont(FontFactory.TIMES, 16, Font.NORMAL, new CMYKColor(255, 255, 255, 255));
	      
	    
	    	 
			@SuppressWarnings("unchecked")
			List<Paras> listParas = new ArrayList<Paras>();
			
			listParas=(List<Paras>) model.get("Paras");
		
			
			doc.addTitle("IR Paras AG Paras Report");
			 Paragraph paragraphOne = new Paragraph("IR Paras AG Paras Report", blackFont);
			 paragraphOne.setAlignment(Element.ALIGN_CENTER);
			    doc.add(paragraphOne);
			    
			   
			     
		 	       BaseFont bf = BaseFont.createFont(
	                       BaseFont.TIMES_ROMAN,
	                       BaseFont.CP1252,
	                       BaseFont.EMBEDDED );
	               Font font = new Font(bf, 20);
		 	        // define font for table header row
		 	       // Font font = FontFactory.getFont(FontFactory.TIMES);
		 	        font.setColor(BaseColor.WHITE);
		 	      
		 	         
	         
	    
				 PdfContentByte cb = writer.getDirectContent();
		    	 cb.setFontAndSize(bf, 20);
	       
	        
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
 	        
 	        int j=listParas.size();
 	        for (int m=0; m<j ; m++){
 	        	
 	        	 doc.newPage();
 		       PdfPTable table = new PdfPTable(2);
 		   	 
 		        table.setWidthPercentage(100.0f);
 		        table.setWidths(new float[] {2.0f, 10.0f});
 		        table.setSpacingBefore(10);
 		        table.setTotalWidth(100.0f);
 		        table.getHorizontalAlignment();
 		        table.completeRow();
 		        
 		        
 		        //table.setSplitRows(false);
 		        table.setSplitLate(false);
 		        
 		       table.setSpacingAfter(-3);
 		       
 		       table.setComplete(false);
 		       table.setLockedWidth(false);
 		   
 		       
 		    
 		       table.setSkipFirstHeader(false);
 		       
 		       table.setSkipLastFooter(true);
 		       
 		      
		        PdfPCell cell = new PdfPCell();
		        
		       
	 	      
	 	       
	 	        cell.setNoWrap(false);
	 	       
	 	      cell.getVerticalAlignment();
	 	      
	 	     
	 	      
	 	    /* cell.setPhrase(new Phrase("S.No : ", blueFont));
	 	        table.addCell(cell);
	 	        
	 	   	
	        	String sno=i.toString();
	          
     		  
     		  cell.setPhrase(new Phrase(sno, blackPlane));
	 	        table.addCell(cell);
 		    */
                   
 		        
	 	        if(listParas.get(m).getUnitId()>0 &&listParas.get(m).getCircleId()==0 && listParas.get(m).getDivisionId()==0){
	        		  
	        	
	 	        	
	 	        	 cell.setPhrase(new Phrase("Office Name : ", blueFont));
	 	 	        table.addCell(cell);  
	        		  
	        		  cell.setPhrase(new Phrase(listParas.get(m).getUnitName(), blackFont));
	   	 	        table.addCell(cell);
	   	 	        
	   	 	    cell.setPhrase(new Phrase("Financial Year : ", redFont));
 	 	        table.addCell(cell);  
 	 	        
 	 	      cell.setPhrase(new Phrase(listParas.get(m).getFinancialYear(), blackFont));
	 	        table.addCell(cell);
	        		    
	   	 	     
	   	 	        
	   	 	    cell.setPhrase(new Phrase("Lar Number : ", redFont));
 	 	        table.addCell(cell);  
 	 	        
 	 	      
      		  cell.setPhrase(new Phrase(listParas.get(m).getLarNumber(), blackFont));
 	 	        table.addCell(cell);
 	 	        
 	 	      cell.setPhrase(new Phrase("File Number : ", blueFont));
	 	        table.addCell(cell);  
	 	        
	 	      
    		  cell.setPhrase(new Phrase(listParas.get(m).getFileNumber(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	        

					  
	  	            }
	  	            if(listParas.get(m).getUnitId()>0 && listParas.get(m).getCircleId()>0 && listParas.get(m).getDivisionId()==0){
	  	            	 cell.setPhrase(new Phrase("Office Name : ", blueFont));
	 	 	 	        table.addCell(cell);  
	 	        		  
	 	        		  cell.setPhrase(new Phrase(listParas.get(m).getCircleName(), blackFont));
	 	   	 	        table.addCell(cell);
	 	        		  
	 					   
	 	   	 	   cell.setPhrase(new Phrase("Financial Year : ", redFont));
	 	 	        table.addCell(cell);  
	 	 	        
	 	 	      cell.setPhrase(new Phrase(listParas.get(m).getFinancialYear(), blackFont));
		 	        table.addCell(cell);  
	 	   	 	    cell.setPhrase(new Phrase("Lar Number : ", redFont));
	  	 	        table.addCell(cell);  
	  	 	        
	  	 	      
	       		  cell.setPhrase(new Phrase(listParas.get(m).getLarNumber(), blackFont));
	  	 	        table.addCell(cell);
	  	 	        
	  	 	      cell.setPhrase(new Phrase("File Number : ", blueFont));
	 	 	        table.addCell(cell);  
	 	 	        
	 	 	        
	 	 	        
	 	 	        
	 	 	      
	     		  cell.setPhrase(new Phrase(listParas.get(m).getFileNumber(), blackFont));
	 	 	        table.addCell(cell);
	  		            }
	  	            if(listParas.get(m).getUnitId()>0 && listParas.get(m).getCircleId()>0 && listParas.get(m).getDivisionId()>0){
	  	            	
	  	            	 cell.setPhrase(new Phrase("Office Name : ", blueFont));
	 	 	 	        table.addCell(cell);  
	 	        		  
	 	        		  cell.setPhrase(new Phrase(listParas.get(m).getDivisionName(), blackFont));
	 	   	 	        table.addCell(cell);
	 	        		    // doc.add(OfficeName);
	 	   	 	   cell.setPhrase(new Phrase("Financial Year : ", redFont));
	 	 	        table.addCell(cell);  
	 	 	        
	 	 	      cell.setPhrase(new Phrase(listParas.get(m).getFinancialYear(), blackFont));
		 	        table.addCell(cell);	   
	 	   	 	        
	 	   	 	    cell.setPhrase(new Phrase("Lar Number : ", redFont));
	  	 	        table.addCell(cell);  
	  	 	        
	  	 	      
	       		  cell.setPhrase(new Phrase(listParas.get(m).getLarNumber(), blackFont));
	  	 	        table.addCell(cell);
	  	 	        
	  	 	      cell.setPhrase(new Phrase("File Number : ", blueFont));
	 	 	        table.addCell(cell);  
	 	 	        
	 	 	      
	     		  cell.setPhrase(new Phrase(listParas.get(m).getFileNumber(), blackFont));
	 	 	        table.addCell(cell);
	  		            }
	  	            
	  	          cell.setPhrase(new Phrase("Section A : ", redFont));
	 	 	        table.addCell(cell);  
	 	 	        
	 	 	      
	     		  cell.setPhrase(new Phrase(listParas.get(m).getParaNumsectionA(), blackFont));
	 	 	        table.addCell(cell);
	 	 	        
	 	 	      cell.setPhrase(new Phrase("Section B : ", blueFont));
	 	 	        table.addCell(cell);  
	 	 	        
	 	 	      
	     		  cell.setPhrase(new Phrase( listParas.get(m).getParaNumsectionB(), blackFont));
	 	 	        table.addCell(cell);
	  	          
		          
	  	            
	  	          cell.setPhrase(new Phrase("Gist of Para : ", greenFont));
	  	 	        table.addCell(cell);  
	  	 	        
	  	 	      
	       		  cell.setPhrase(new Phrase(listParas.get(m).getActionTitle(), blackFont));
	  	 	        table.addCell(cell);
	  	 	        
	  	 	     cell.setPhrase(new Phrase("Para : ", redFont));
	  	 	        table.addCell(cell);  
	  	          
	  	 	    

	        
 	            PdfPCell cell1 = new PdfPCell();
 	            cell1.setNoWrap(false);
 	            cell1.setPadding(5);
 	            
 	            
 	          
	            	
 	            for (Element e : XMLWorkerHelper.parseToElementList(listParas.get(m).getParasAction(), " ")) {
 	            	cell1.setNoWrap(false);
 	            	
 	            	
 	           // System.out.println(m+"m"+e.PARAGRAPH);
 	                cell1.addElement(e);
 	             
 	             
 	            }         
 	      
	         // cell1.isNestable();
	          
	        
	        
	          table.addCell(cell1);
 	            
 	         cell.setPhrase(new Phrase("Reply : ", blueFont));
	 	        table.addCell(cell);  
	          
 	          
 	         PdfPCell cell2 = new PdfPCell();
	            cell2.setNoWrap(false);
	            for (Element e : XMLWorkerHelper.parseToElementList(listParas.get(m).getReplyAction(), " ")) {
	            	cell2.setNoWrap(false);
  			  cell2.setPadding(5);
	                cell2.addElement(e);
	             
	            }
	            
	            
	          
	         
	            table.addCell(cell2);
	            
	            cell.setPhrase(new Phrase("Documents : ", blueFont));
  	 	        table.addCell(cell);  
 	 	      
 	 	    
 	        
 	 	  
	  	          
			
	         
 	 	      cell.setPhrase(new Phrase(listParas.get(m).getDocoriginalName(), blackPlane));
	 	        table.addCell(cell);
	        
	          
	          
	          
	   
	           
	           
	            
	           
	            
	            
	          
	            i++;
	            
	        
	           
	            onEndPage(writer ,doc);
	            
	            table.setComplete(true);
	         
	            doc.add(table);
	            
	            doc.newPage();
	            
	          
	            
	          
	          
	           
	        
 	        	
 	        	
 	        	
 	        }
 	        
 	        
	       
	         
	    }
		
		
	 
	}


