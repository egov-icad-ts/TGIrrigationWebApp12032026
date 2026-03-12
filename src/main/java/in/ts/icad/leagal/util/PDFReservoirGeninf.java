package in.ts.icad.leagal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirSalient;

public class PDFReservoirGeninf extends AbstractITextPdfView {
	@Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		 doc.setPageSize(PageSize.A4.rotate());
		 doc.resetPageCount();//without this, page number is incremented by one
			doc.open();//after setting size then open new doc, so that for first page also orientation is set
			HeaderFooterPageEvent event = new HeaderFooterPageEvent();
	        writer.setPageEvent(event);
			//System.out.println("doc.getPageSize()"+doc.getPageSize());
        // get data model which is passed by the Spring container
    	
	    	Font blueFont = FontFactory.getFont(FontFactory.TIMES_BOLD   , 14, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
	    	Font redFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, Font.BOLD, new CMYKColor(0, 255, 0, 0));
	    	//Font yellowFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, new CMYKColor(0, 0, 255, 0));
	    	Font blackFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, Font.BOLD, new CMYKColor(255, 255, 255, 255));
	    	Font blacktitle = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, Font.BOLD, new CMYKColor(255, 255, 255, 255));
	    	Font blackHeading = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, new CMYKColor(255, 255, 255, 255));
	    	Font greenFont = FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD, new CMYKColor(100, 0, 100, 60));
	    	Font blackNFont = FontFactory.getFont(FontFactory.TIMES  , 11, Font.NORMAL, new CMYKColor(255, 255,255, 255));
	    	
	    	Font blackPlane = FontFactory.getFont(FontFactory.TIMES, 11, Font.NORMAL, new CMYKColor(255, 255, 255, 255));
	      
    
    	 
		@SuppressWarnings("unchecked")
		//ReservoirInspect formdata = new ReservoirInspect();
		List<ReservoirSalient> resGeninfo = new ArrayList<ReservoirSalient>();
		List<ReservoirInspect> resinspectinfo = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resremarksinfo = new ArrayList<ReservoirInspect>();
		
		
		
		//formdata=(ReservoirInspect) model.get("listform20Tanks");
		
		resGeninfo=(List<ReservoirSalient>) model.get("resgeninfo");
		resinspectinfo=(List<ReservoirInspect>) model.get("resinspectinfo");
		
		resremarksinfo=(List<ReservoirInspect>) model.get("resremarksinfo");
		
		
		Paragraph sideheading = new Paragraph(" ", blackPlane);		
		
		if(resGeninfo!=null){
			
			if(resGeninfo.size()>0){
			
		  Chunk textUnderline = new Chunk(" Name of the Dam : "+resGeninfo.get(0).getResName()+" ( "+resGeninfo.get(0).getNrldCode()+"  )                                                      "+resGeninfo.get(0).getFreqoperationName()+" "+resGeninfo.get(0).getYear());
		  textUnderline.setUnderline(0.8f, -3f);
		  sideheading.add(textUnderline);
		  sideheading.setAlignment(Element.ALIGN_LEFT);
	      doc.add(sideheading);
	      
			}
	      
		}
	    
	     
		
		Paragraph title = new Paragraph("Scheduled Dam Safety Inspection Form", blacktitle);
		title.setAlignment(Element.ALIGN_CENTER);
		 doc.add(title);
		 
		 

			Paragraph subtitle = new Paragraph("Part 1a - Inspection Details", blackFont);
			subtitle.setAlignment(Element.ALIGN_LEFT);
			 doc.add(subtitle);
			 
			
		 
		
		 
		 
		 
		 //Paragraph heading = new Paragraph(" ", blacktitle);
		 
		 
		
			
			/*  Chunk textUnderline = new Chunk("INSPECTION OF DAMS AND ANCILLIARY WORKS");
			  textUnderline.setUnderline(0.8f, -3f);
			  heading.add(textUnderline);
			  heading.setAlignment(Element.ALIGN_CENTER);
		      doc.add(heading);*/

		    

		    
		  // doc.left(5.0f);
		//   doc.right(5.0f);
		     
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
       
     
        
      
        // write table row data
       Integer i=1;
    

       String docname=" ";
       
  	 /*doc.newPage();*/  // commeted as table is displayed in new page--15/dec/2021 sowjanya
	       
	       // for (int m=0; m<j ; m++){
	        	
       PdfPTable table = new PdfPTable(4);
		   	 
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {15.0f, 35.0f,30.0f, 20.0f});
	      /* table.setWidths(new float[] { 20.0f});*/
	        table.setSpacingBefore(10);
	        table.setTotalWidth(100.0f);
	        table.getHorizontalAlignment();
	        table.completeRow();
	      
	        
	       // table.setSplitRows(true);
	        
	       table.setSpacingAfter(-3);
	       table.setSplitLate(false);
	      
	       
	       table.setComplete(false);
	       
	       table.setLockedWidth(false);
	       table.setSkipFirstHeader(false);
	       table.setSkipLastFooter(true);
	       
	       
	       
	       PdfPTable table1 = new PdfPTable(1);
		   	 
	        table1.setWidthPercentage(100.0f);
	        table1.setWidths(new float[] {100.0f});
	      /* table.setWidths(new float[] { 20.0f});*/
	        table1.setSpacingBefore(10);
	        table1.setTotalWidth(100.0f);
	        table1.getHorizontalAlignment();
	        table1.completeRow();
	      
	        
	       // table.setSplitRows(true);
	        
	       table1.setSpacingAfter(-3);
	       table1.setSplitLate(false);
	      
	       
	       table1.setComplete(false);
	       
	       table1.setLockedWidth(false);
	       table1.setSkipFirstHeader(false);
	       table1.setSkipLastFooter(true);
	       
	       Chunk linebreak= new Chunk(" ");  
	     
      PdfPCell cell = new PdfPCell();
      
      PdfPCell cell2 = new PdfPCell();
      
    
     
     // cell.setBorder(0);// for removing lines around cells
       cell.setNoWrap(false);
       cell.setPadding(5);
      
     cell.getVerticalAlignment();
     
     cell2.setNoWrap(false);
     cell2.setPadding(5);
    
   cell2.getVerticalAlignment();
	  	 	        		
	  	 	        		//System.out.println("doc"+docname);
	  	 	        		if(resGeninfo!=null){
	  	 	        			
	  	 	        			if(resGeninfo.size()>0){
	  	 	        			
	  	 	        		
	  	 	        			
	  	 	        		 cell.setPhrase(new Phrase("Dam Name", blackFont));
	 		   	 	        table.addCell(cell);
	 		   	 	        
	 		   	 	     cell.setPhrase(new Phrase(resGeninfo.get(0).getResName(), blackNFont));
		   	 	         table.addCell(cell);
		   	 	         
		   	 	          cell.setPhrase(new Phrase("Project ID Code (PIC) ", blackFont));
	   	 	               table.addCell(cell);
	   	 	           cell.setPhrase(new Phrase(resGeninfo.get(0).getNrldCode(), blackNFont));
   	 	               table.addCell(cell);
   	 	               
   	 	           cell.setPhrase(new Phrase("Dam Type ", blackFont));
	 	               table.addCell(cell);
	 	           cell.setPhrase(new Phrase(resGeninfo.get(0).getTypeOfDam(), blackNFont));
	               table.addCell(cell);
	               
	               cell.setPhrase(new Phrase("Dam Purpose ", blackFont));
 	               table.addCell(cell);
 	           cell.setPhrase(new Phrase(resGeninfo.get(0).getDamPurpose(), blackNFont));
               table.addCell(cell);
               
               cell.setPhrase(new Phrase("Dam Owner ", blackFont));
	               table.addCell(cell);
	           cell.setPhrase(new Phrase(resinspectinfo.get(0).getOwnerOfDam(), blackNFont));
           table.addCell(cell);
           
           cell.setPhrase(new Phrase("Hazard Classification ", blackFont));
           table.addCell(cell);
       cell.setPhrase(new Phrase(resGeninfo.get(0).getHazardClass(), blackNFont));
   table.addCell(cell);
   
   cell.setPhrase(new Phrase("Dam Operator ", blackFont));
   table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getDamOperator(), blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Type of Inspection ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getTypeofinspection(), blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Commissioning Date ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resGeninfo.get(0).getCommisionDate(), blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Inspection by ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getInspectOfficeName()+" ("+resinspectinfo.get(0).getInspectdesignationName()+") ", blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" City/ State / PIN ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resGeninfo.get(0).getMandalName() +"	(Mandal)	"+Chunk.NEWLINE+resGeninfo.get(0).getVillageName()+" (Village)" , blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Date of Inspection ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getInspectDate(), blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" District ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase( resGeninfo.get(0).getDistrictName(), blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Reservoir water level in metre on the date  of inspection ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getPresentWaterlevel().toString(), blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Latitude ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase( resGeninfo.get(0).getRes_lat_d()+" \u00B0 "+resGeninfo.get(0).getRes_lat_m()+" \' "+resGeninfo.get(0).getRes_lat_s()+" \" ", blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Storage Capacity (MCM) :", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase("	(i)	Gross...."+resGeninfo.get(0).getGrossStorageatFrl()  +Chunk.NEWLINE+"	(ii)	Live...."+ resinspectinfo.get(0).getStorageCapacity(), blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Longitude :", blackNFont ));
table.addCell(cell);
cell.setPhrase(new Phrase( resGeninfo.get(0).getRes_long_d()+" \u00B0 "+resGeninfo.get(0).getRes_long_m()+" \' "+resGeninfo.get(0).getRes_long_s()+" \" ", blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Weather Conditions :", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getWeathercondition(), blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Important Controlling Level :", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase( Chunk.NEWLINE+
		"a) TBL RL (meters)..... "+resGeninfo.get(0).getTrlLevel()+Chunk.NEWLINE+
		Chunk.NEWLINE+
		"b) MWL RL (meters)..... "+resGeninfo.get(0).getMwlLevel()+Chunk.NEWLINE+
		Chunk.NEWLINE+
		"c) FRL RL (meters)..... "+resGeninfo.get(0).getFrlLevel()+Chunk.NEWLINE+
		Chunk.NEWLINE+
	    "d) Spillway Crest RL (meters)....."+resGeninfo.get(0).getSpillWayCrestLevel()+Chunk.NEWLINE+
	    Chunk.NEWLINE+
	    "e)MDDL RL  (meters)....."+resGeninfo.get(0).getMddlLevel()+Chunk.NEWLINE+
	    Chunk.NEWLINE+
	    "f)Lowest River bed RL (meters)..... "+resGeninfo.get(0).getLowestRiverBed()+Chunk.NEWLINE+
	    Chunk.NEWLINE+
	    "g)Deepest Foundation level RL (meters).....  "+resGeninfo.get(0).getDeepestfoundationLevel()+
	    Chunk.NEWLINE+Chunk.NEWLINE , blackFont));
table.addCell(cell);

/*cell.setPhrase(new Phrase( Chunk.NEWLINE+
		"a) "+resGeninfo.get(0).getTrlLevel()+Chunk.NEWLINE+
		Chunk.NEWLINE+
		"b) "+resGeninfo.get(0).getMwlLevel()+Chunk.NEWLINE+
		Chunk.NEWLINE+
		"c) "+resGeninfo.get(0).getFrlLevel()+Chunk.NEWLINE+
		Chunk.NEWLINE+
	    "d) "+resGeninfo.get(0).getSpillWayCrestLevel()+Chunk.NEWLINE+
	    Chunk.NEWLINE+
	    "e) "+resGeninfo.get(0).getMddlLevel()+Chunk.NEWLINE+
	    Chunk.NEWLINE+
	    "f) "+resGeninfo.get(0).getLowestRiverBed()+Chunk.NEWLINE+
	    Chunk.NEWLINE+
	    "g) "+resGeninfo.get(0).getDeepestfoundationLevel()+
	    Chunk.NEWLINE+Chunk.NEWLINE, blackNFont));*/

cell.setPhrase(new Phrase(" ",blackFont));
table.addCell(cell);

table.addCell(cell);
	 		   	 	 
table.addCell(cell);
	 		   	 	      doc.add(table);
	 		   	 	    
	 		   	 	 doc.newPage();
		   	 	 
	  	 	        if(resremarksinfo!=null){	
	  	 	        	
	  	 	         int k=resremarksinfo.size();
	  	 	         
	  	 	    	for(int a=0; a<k ; a++){
	  	 	    		
	  	 	    		//System.out.println("resremarksinfo.get(a).getResinspectInfoId()"+resremarksinfo.get(a).getResinspectInfoId()+a);
	  	 	    		//System.out.println("resinspectinfo.get(0).getResinspectInfoId()"+resinspectinfo.get(0).getResinspectInfoId()+a);
	  	 	    		if(resremarksinfo.get(a).getRemarksinclindoc()==true && resremarksinfo.get(a).getResinspectInfoId()==resinspectinfo.get(0).getResinspectInfoId()){
	 		   	 		Paragraph subtitleremarks = new Paragraph("Part 1b - Inspection Remarks", blackFont);
	 		   	 	subtitleremarks.setAlignment(Element.ALIGN_LEFT);
	 					 doc.add(subtitleremarks); 
	 					 
	 					Paragraph subtitleremarks1 = new Paragraph("Please provide any additional information or comments not covered by Part 1a from above.", blackPlane);
	 					subtitleremarks1.setAlignment(Element.ALIGN_LEFT);
		 					 doc.add(subtitleremarks1); 
	  	 	        		   
		 					cell2.setPhrase(new Phrase(resremarksinfo.get(a).getRemarks(), blackNFont));
		 					table1.addCell(cell2);
	  	 	  	 	
		 					  doc.add(table1);
	  	 	    		}
	  	 	    	}
	  	 	        }
	 	    //  doc.newPage(); //shows table in new page
	 	        
	 	      
	 	        
	 	      
	 	     i++;
	 	    doc.newPage();
	 	   
	        		
	        		}
	  	 	        		}
	        		
	 	   	 	  
	 	   	 
	
	 	     onEndPage(writer ,doc);
 
	}

}