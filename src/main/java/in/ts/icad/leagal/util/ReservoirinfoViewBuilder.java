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
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.ReservoirUnitData;

public class ReservoirinfoViewBuilder  extends AbstractITextPdfView{
	
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
    	
    	Font blueHeader = FontFactory.getFont(FontFactory.TIMES_BOLD   , 20, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
      
    
    	 
		@SuppressWarnings("unchecked")
		
		List<ReservoirSalient> resinfodata = new ArrayList<ReservoirSalient>();
		List<ReservoirUnitData> resunitdata = new ArrayList<ReservoirUnitData>();
		
		
		resunitdata=(List<ReservoirUnitData>) model.get("resunitdata");
		resinfodata=(List<ReservoirSalient>) model.get("resInfo");
		
		
	
		
		doc.addTitle("Reservoir Information");
		 Paragraph paragraphOne = new Paragraph("Reservoir Information Report", blackFont);
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
       
	    
  	 
	    
        int j=resinfodata.size();
        for (int m=0; m<j ; m++){
        	
      	 doc.newPage();
	       PdfPTable table = new PdfPTable(4);
	   	 
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {2.0f, 10.0f,2.0f, 10.0f});
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
        
        	
        	
	      
	     
	      
	   
              
	      //  System.out.println("in pdf wiriting"+listParas.get(m).getUnitId()+","+listParas.get(m).getCircleId()+","+listParas.get(m).getDivisionId());
	       // if(listParas.get(m).getUnitId()>0 &&listParas.get(m).getCircleId()==0 && listParas.get(m).getDivisionId()==0){
       		  
	      cell.setPhrase(new Phrase("Salient Features : ", blueHeader));
	      cell.setColspan(4);
	     
	      table.addCell(cell);  
	        	
	        	 cell.setPhrase(new Phrase("Reservoir Name : ", blueFont));
	        	   cell.setColspan(1);
	 	        table.addCell(cell);  
       		  
       		  cell.setPhrase(new Phrase(resinfodata.get(m).getResName(), blackFont));
  	 	        table.addCell(cell);
  	 	        
  	 	    cell.setPhrase(new Phrase("Reservoir Status : ", redFont));
 	        table.addCell(cell);  
 	       cell.setPhrase(new Phrase(resinfodata.get(m).getResStatus(), blackFont));
	        table.addCell(cell);
 	        
 	       
 	         int c=resunitdata.size();
 	         
 	        int f=1;
 	         
 	        		for(int d=0; d<c ; d++){
 	     	
 	        		//	System.out.println(listParas.get(m).getParaId()+"now listreplyData.get(d).getParaId()"+listreplyData.get(d).getParaId() );
 	        			
 	        		    if(resinfodata.get(m).getResCode().equals(resunitdata.get(d).getReservoirId()) ){
 	        		    	
 	        		    	 cell.setPhrase(new Phrase("Unit Name : ", greenFont));
 	        	 	 	        table.addCell(cell);  
 	        	 	 	        
 	        	 	 	      
 	        	      		  cell.setPhrase(new Phrase(resunitdata.get(d).getUnitName(), blackFont));
 	        	 	 	        table.addCell(cell);
 	        	 	 	        
 	        	 	 	     cell.setPhrase(new Phrase("Circle Name : ", greenFont));
	        	 	 	        table.addCell(cell);  
	        	 	 	        
	        	 	 	      
	        	      		  cell.setPhrase(new Phrase(resunitdata.get(d).getCircleName(), blackFont));
	        	 	 	        table.addCell(cell);
	        	 	 	        
	        	 	 	      cell.setPhrase(new Phrase("Division Name : ", greenFont));
	        	 	 	        table.addCell(cell);  
	        	 	 	        
	        	 	 	      
	        	      		  cell.setPhrase(new Phrase(resunitdata.get(d).getDivisionName(), blackFont));
	        	 	 	        table.addCell(cell);
	        	 	 	        
	        	 	 	      cell.setPhrase(new Phrase("Sub Division Name : ", greenFont));
	        	 	 	        table.addCell(cell);  
	        	 	 	        
	        	 	 	      
	        	      		  cell.setPhrase(new Phrase(resunitdata.get(d).getSubdivisionName(), blackFont));
	        	 	 	        table.addCell(cell);
	        	 	 	        
	        	 	 	      cell.setPhrase(new Phrase("Project Name : ", greenFont));
	        	 	 	        table.addCell(cell);  
	        	 	 	        
	        	 	 	      
	        	      		  cell.setPhrase(new Phrase(resunitdata.get(d).getProjectName(), blackFont));
	        	 	 	        table.addCell(cell);
	        	 	 	        
	        	 	 	      cell.setPhrase(new Phrase("Package Name : ", greenFont));
	        	 	 	        table.addCell(cell);  
	        	 	 	        
	        	 	 	      
	        	      		  cell.setPhrase(new Phrase(resunitdata.get(d).getPackName(), blackFont));
	        	 	 	        table.addCell(cell);
 	        		
 	        		
 	   
 	  
 	   f++;
 	        		}
 	        	
 	       
 	          
 	        		}
 	          
 	        
 	     
       		    
	        cell.setPhrase(new Phrase("Water Spread Area : ", redFont));
 	        table.addCell(cell);  
 	        
 	       cell.setPhrase(new Phrase(resinfodata.get(m).getWaterSpreadArea().toString() , blackFont));
	        table.addCell(cell);
  	 	        
  	 	    cell.setPhrase(new Phrase("Hydro Power : ", redFont));
 	        table.addCell(cell);  
 	        
 	      
 		  cell.setPhrase(new Phrase(resinfodata.get(m).getHydroPower().toString() , blackFont));
 	        table.addCell(cell);
 	        
 	       cell.setPhrase(new Phrase("Latitude : ", redFont));
	        table.addCell(cell);  
	        
	       cell.setPhrase(new Phrase(resinfodata.get(m).getResLatitude().toString() , blackFont));
	        table.addCell(cell);
 	 	        
 	 	    cell.setPhrase(new Phrase("Longitude : ", redFont));
	        table.addCell(cell);  
	        
	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getResLongitude().toString() , blackFont));
	        table.addCell(cell);
 	        
 	      cell.setPhrase(new Phrase("Land Acquisition ", blueFont));
	        table.addCell(cell);  
	        
	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getLandAcquistion().toString(), blackFont));
	        table.addCell(cell);
	        
	        

				  
 	        //
 	            
 	            
 	          cell.setPhrase(new Phrase("Catchment Area", redFont));
	 	        table.addCell(cell);  
	 	        
	 	      
    		  cell.setPhrase(new Phrase(resinfodata.get(m).getCatchmentArea().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	      cell.setPhrase(new Phrase("M.F.D (Cumecs)", blueFont));
	 	        table.addCell(cell);  
	 	        
	 	      
    		  cell.setPhrase(new Phrase( resinfodata.get(m).getMaxfloodDischarge().toString(), blackFont));
	 	        table.addCell(cell);
 	          
	 	     
 	 	        
 	 	    
 	            
 	          cell.setPhrase(new Phrase("MWL Capacity : ", greenFont));
 	 	        table.addCell(cell);  
 	 	        
 	 	      
      		  cell.setPhrase(new Phrase(resinfodata.get(m).getMwlCapacity().toString(), blackFont));
 	 	        table.addCell(cell);
 	 	        
 	 	      cell.setPhrase(new Phrase("FRL Capacity : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
    		  cell.setPhrase(new Phrase(resinfodata.get(m).getFrlCapacity().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("MDDL Capacity : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
   		  cell.setPhrase(new Phrase(resinfodata.get(m).getMddlCapacity().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Dead Storage Capacity : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
  		  cell.setPhrase(new Phrase(resinfodata.get(m).getDeadstorageCapacity().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("TRL Level : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
 		  cell.setPhrase(new Phrase(resinfodata.get(m).getTrlLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("FRL Level : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getFrlLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("MWL Level : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getMwlLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("MDDL Level : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getMddlLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Dead Storage Level : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getDeadstorageLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Spill Way Length : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getSpillwayLength().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("N.O.F Length : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getNonoverflowLength().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Max.Height of Spill Way : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getMaxhtSpillWay().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Top Width of Dam : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getTopWidthDam().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Max. Base Width Of Dam : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getMaxbaseWidthDam().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Clear Bridge Width: ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getClearBridgeWidth().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Stilling Basin Length/ Apron: ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getStillingBasinLength().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Deepest Foundation Level: ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getDeepestfoundationLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Average River Bed Level: ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getAvgRiverbedLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Spill Way Crest Level: ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getSpillWayCrestLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Bridge Top Level: ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getBridgeTopLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Invert Level of Bucket: ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getInvertLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Stilling Basin Level/Apron Level: ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getInvertLevel().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Left Length of Earth Dam : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getEarthdamLeftLength().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Right Length of Earth Dam : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getEarthdamRightLength().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Max. Height : ", greenFont));
	 	        table.addCell(cell);  
	 	        
	 	      
		  cell.setPhrase(new Phrase(resinfodata.get(m).getMaxHeight().toString(), blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("Masonary Dam Length: ", greenFont));
	 	        table.addCell(cell);  
	 			  cell.setPhrase(new Phrase(resinfodata.get(m).getMasonarydamLength().toString(), blackFont));
	 		 	        table.addCell(cell);
	 		 	        
	 		 	      cell.setPhrase(new Phrase("Rock Fill Dam Length: ", greenFont));
	 		 	        table.addCell(cell);  
	 		 			  cell.setPhrase(new Phrase(resinfodata.get(m).getRockfilldamLength().toString(), blackFont));
	 		 		 	        table.addCell(cell);
	 		 		 	        
	 		 		 	     cell.setPhrase(new Phrase("Concrete Dam Length: ", greenFont));
	 	 		 	        table.addCell(cell);  
	 	 		 			  cell.setPhrase(new Phrase(resinfodata.get(m).getConcretedamLength().toString(), blackFont));
	 	 		 		 	        table.addCell(cell);
	 	 		 		 	        
	 	 		 		 	    cell.setPhrase(new Phrase("Zonal Section Length: ", greenFont));
		 	 		 	        table.addCell(cell);  
		 	 		 			  cell.setPhrase(new Phrase(resinfodata.get(m).getZonalSectionLength().toString(), blackFont));
		 	 		 		 	        table.addCell(cell);
		 	 		 		 	        
		 	 		 		 	    cell.setPhrase(new Phrase("Homogeneous Section Length: ", greenFont));
		 	 		 		 
			 	 		 	        table.addCell(cell);  
			 	 		 			  cell.setPhrase(new Phrase(resinfodata.get(m).getHomogeneousSectionLength().toString(), blackFont));
			 	 		 		 	      
			 	 		 			 
			 	 		 			  table.addCell(cell);
			 	 		 			  cell.setPhrase(new Phrase(" "));
			 	 		 			 table.addCell(cell);
			 	 		 			 cell.setPhrase(new Phrase(" "));
			 	 		 			 table.addCell(cell);
	 	        
	 	        
 	 	        
 	 	   
 	          
 	 	    

       
           
       
       
       
     
      
           
           
         
         
           
         
         
          
       
        	
        		  table.setComplete(true);
   	 	      doc.add(table);
   		         	
   	 	    i++;
           
        }
        
     

   
   
      
       onEndPage(writer ,doc);
       
      
      
       
      
       
      
        
   }

}
