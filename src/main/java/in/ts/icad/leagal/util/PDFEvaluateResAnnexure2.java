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
import in.ts.icad.leagal.model.Tanks;

public class PDFEvaluateResAnnexure2 extends AbstractITextPdfView {
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
    	Font greenFont = FontFactory.getFont(FontFactory.TIMES, 11, Font.BOLD, new CMYKColor(100, 0, 100, 60));
    	Font blackNFont = FontFactory.getFont(FontFactory.TIMES  , 11, Font.NORMAL, new CMYKColor(255, 255,255, 255));
    	
    	Font blackPlane = FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL, new CMYKColor(255, 255, 255, 255));
      
    
    	 
		@SuppressWarnings("unchecked")
		//ReservoirInspect formdata = new ReservoirInspect();
		List<ReservoirInspect> resChecksListpdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resCatListpdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn1mst2pdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn1recmmonpdf = new ArrayList<ReservoirInspect>();
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		List<ReservoirInspect> resinspectinfo = new ArrayList<ReservoirInspect>();
		List<Tanks> tankgeninfo= new ArrayList<Tanks>();
		List<ReservoirInspect> resremarksinfo = new ArrayList<ReservoirInspect>();
		
		
		//formdata=(ReservoirInspect) model.get("listform20Tanks");
		
		resChecksListpdf=(List<ReservoirInspect>) model.get("resChecksList");
		resCatListpdf=(List<ReservoirInspect>) model.get("resCatList");
		resAnn1mst2pdf =(List<ReservoirInspect>) model.get("resAnn1mst2info");
		
		resAnn1recmmonpdf =(List<ReservoirInspect>) model.get("resannrecommndList");
		
		resgeninfo=(List<ReservoirSalient>) model.get("resgeninfo");
		
		tankgeninfo=(List<Tanks>) model.get("tankgeninfo");
		
		resinspectinfo=(List<ReservoirInspect>) model.get("resinspectinfo");
		
		
		resremarksinfo=(List<ReservoirInspect>) model.get("resremarksinfo");
		
		//tankgeninfo=(List<Tanks>) model.get("tankgeninfo");
		
		
	    
	     
		
	/*	Paragraph title = new Paragraph("Annexure II", blacktitle);
		title.setAlignment(Element.ALIGN_CENTER);
		 doc.add(title);
		 */
		
		 
		 
	
		 Paragraph heading = new Paragraph(" ", blacktitle);
		 
		 Paragraph heading2 = new Paragraph(" ", blacktitle);
			
		
			
			 /* Chunk textUnderline = new Chunk(" EVALUATION REPORT OF PRE MONSOON INSPECTION 2022-2023 ");
			  textUnderline.setUnderline(0.8f, -3f);
			  heading.add(textUnderline);
			  heading.setAlignment(Element.ALIGN_CENTER);
		      doc.add(heading);*/
		 Paragraph sideheading = new Paragraph(" ", blackNFont);		
			
			if(resgeninfo!=null){
				
				//System.out.println("resgeninfo.get(0).getFreqoperationName()"+resgeninfo.get(0).getFreqoperationName());
				
				if(resgeninfo.get(0).getFreqoperationName()!=null){
			
			  Chunk textUnderline1 = new Chunk("EVALUATION REPORT OF  "+resgeninfo.get(0).getFreqoperationName()+" "+resgeninfo.get(0).getYear());
			  textUnderline1.setUnderline(0.8f, -3f);
			  sideheading.add(textUnderline1);
			  sideheading.setAlignment(Element.ALIGN_CENTER);
		      doc.add(sideheading);
			}
		     
			}
			
			if(tankgeninfo!=null){
				
			//	if(tankgeninfo.get(0).getFreqoperationName()!=null){
				
				  Chunk textUnderline1 = new Chunk("EVALUATION REPORT OF  "+tankgeninfo.get(0).getFreqoperationName()+" "+tankgeninfo.get(0).getYear());
				  textUnderline1.setUnderline(0.8f, -3f);
				  sideheading.add(textUnderline1);
				  sideheading.setAlignment(Element.ALIGN_CENTER);
			      doc.add(sideheading);
			//	}
				}
		 
		 
		 if(resAnn1recmmonpdf!=null){  
			 if(resAnn1recmmonpdf.size()>0){     
		      Chunk textUnderline2 = new Chunk(" BY  "+resAnn1recmmonpdf.get(0).getInspectOfficeName());
			  textUnderline2.setUnderline(0.8f, -3f);
			  heading2.add(textUnderline2);
			  heading2.setAlignment(Element.ALIGN_CENTER);
		      doc.add(heading2);

		    

		    
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
       
     //start of gen info
	    	 
	  // start of gen table 
	    	 
	    	   PdfPTable tablegen = new PdfPTable(4);
			   	 
	    	   tablegen.setWidthPercentage(100.0f);
	    	   tablegen.setWidths(new float[] {15.0f, 35.0f,30.0f, 20.0f });
		      /* table.setWidths(new float[] { 20.0f});*/
	    	   tablegen.setSpacingBefore(10);
	    	   tablegen.setTotalWidth(100.0f);
	    	   tablegen.getHorizontalAlignment();
	    	   tablegen.completeRow();
		      
		        
		       // table.setSplitRows(true);
		        
	    	   tablegen.setSpacingAfter(-3);
	    	   tablegen.setSplitLate(false);
		      
		       
	    	   tablegen.setComplete(false);
		       
	    	   tablegen.setLockedWidth(false);
	    	   tablegen.setSkipFirstHeader(false);
	    	   tablegen.setSkipLastFooter(true);
	    	   
	    	   PdfPCell cellgen = new PdfPCell();
	    	   
	    	   cellgen.setNoWrap(false);
	    	   cellgen.setPadding(5);
    	      
	    	   cellgen.getVerticalAlignment();
    	     
	    	      
	   
	    	   // end of gen info  
		       
		       PdfPTable tableremarks = new PdfPTable(1);
			   	 
		       tableremarks.setWidthPercentage(100.0f);
		       tableremarks.setWidths(new float[] {100.0f});
		      /* table.setWidths(new float[] { 20.0f});*/
		       tableremarks.setSpacingBefore(10);
		       tableremarks.setTotalWidth(100.0f);
		       tableremarks.getHorizontalAlignment();
		       tableremarks.completeRow();
		      
		        
		       // table.setSplitRows(true);
		        
		       tableremarks.setSpacingAfter(-3);
		       tableremarks.setSplitLate(false);
		      
		       
		       tableremarks.setComplete(false);
		       
		       tableremarks.setLockedWidth(false);
		       tableremarks.setSkipFirstHeader(false);
		       tableremarks.setSkipLastFooter(true);
		       
		       
		 	      PdfPCell cellremarks = new PdfPCell();
	    	      
		    	    
		    	     
		    	     // cell.setBorder(0);// for removing lines around cells
		    	      
		    	      cellremarks.setNoWrap(false);
		    	      cellremarks.setPadding(5);
		    	    
		    	      cellremarks.getVerticalAlignment();
			       
		       
		       Chunk linebreakremarks= new Chunk(" ");  
	    	 
	    	 
	 // end of remarks info
		       
		       //start of general info display
		       
		       //start of reservoir information display
		       
		       if(resgeninfo!=null){
		    	   
		    	   cellgen.setPhrase(new Phrase("Dam Name", blackFont));
		    	   tablegen.addCell(cellgen);
	   	 	        
		    	   cellgen.setPhrase(new Phrase(resgeninfo.get(0).getResName(), blackNFont));
		    	   tablegen.addCell(cellgen);
  	 	         
  	 	      cellgen.setPhrase(new Phrase("Project ID Code (PIC) ", blackFont));
  	 	   tablegen.addCell(cellgen);
	 	              cellgen.setPhrase(new Phrase(resgeninfo.get(0).getNrldCode(), blackNFont));
	 	             tablegen.addCell(cellgen);
	               
	               cellgen.setPhrase(new Phrase("Dam Type ", blackFont));
	               tablegen.addCell(cellgen);
               cellgen.setPhrase(new Phrase(resgeninfo.get(0).getTypeOfDam(), blackNFont));
               tablegen.addCell(cellgen);
          
          cellgen.setPhrase(new Phrase("Dam Purpose ", blackFont));
          tablegen.addCell(cellgen);
           cellgen.setPhrase(new Phrase(resgeninfo.get(0).getDamPurpose(), blackNFont));
           tablegen.addCell(cellgen);
      
      cellgen.setPhrase(new Phrase("Dam Owner ", blackFont));
      tablegen.addCell(cellgen);
          cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getOwnerOfDam(), blackNFont));
          tablegen.addCell(cellgen);
  
  cellgen.setPhrase(new Phrase("Hazard Classification ", blackFont));
  tablegen.addCell(cellgen);
  cellgen.setPhrase(new Phrase(resgeninfo.get(0).getHazardClass(), blackNFont));
  tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase("Dam Operator ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getDamOperator(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Type of Inspection ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getTypeofinspection(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Commissioning Date ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resgeninfo.get(0).getCommisionDate(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Inspection by ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getInspectOfficeName()+" ("+resinspectinfo.get(0).getInspectdesignationName()+") ", blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" City/ State / PIN ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resgeninfo.get(0).getMandalName() +"	(Mandal)	"+Chunk.NEWLINE+resgeninfo.get(0).getVillageName()+" (Village)" , blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Date of Inspection ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getInspectDate(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" District ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase( resgeninfo.get(0).getDistrictName(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Reservoir water level in metre on the date  of inspection ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getPresentWaterlevel().toString(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Latitude ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase( resgeninfo.get(0).getRes_lat_d()+" \u00B0 "+resgeninfo.get(0).getRes_lat_m()+" \' "+resgeninfo.get(0).getRes_lat_s()+" \" ", blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Storage Capacity (MCM) :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase("	(i)	Gross...."+resgeninfo.get(0).getGrossStorageatFrl()  +Chunk.NEWLINE+"	(ii)	Live...."+ resinspectinfo.get(0).getStorageCapacity(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Longitude :", blackNFont ));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase( resgeninfo.get(0).getRes_long_d()+"\u00B0"+resgeninfo.get(0).getRes_long_m()+" \' "+resgeninfo.get(0).getRes_long_s()+" \" ", blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Weather Conditions :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getWeathercondition(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Important Controlling Level :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase( Chunk.NEWLINE+
"a) TBL RL (meters)..... "+resgeninfo.get(0).getTrlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"b) MWL RL (meters)..... "+resgeninfo.get(0).getMwlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"c) FRL RL (meters)..... "+resgeninfo.get(0).getFrlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"d) Spillway Crest RL (meters)....."+resgeninfo.get(0).getSpillWayCrestLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"e)MDDL RL  (meters)....."+resgeninfo.get(0).getMddlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"f)Lowest River bed RL (meters)..... "+resgeninfo.get(0).getLowestRiverBed()+Chunk.NEWLINE+
Chunk.NEWLINE+
"g)Deepest Foundation level RL (meters).....  "+resgeninfo.get(0).getDeepestfoundationLevel()+
Chunk.NEWLINE+Chunk.NEWLINE , blackFont));
tablegen.addCell(cellgen);



cellgen.setPhrase(new Phrase(" ",blackFont));
tablegen.addCell(cellgen);

tablegen.addCell(cellgen);
	   	 	 
	   	 	      doc.add(tablegen);
	   	 	      
	   	 	      
	   	 	      
	   	 	    
	   	 	
		    	   
		       }
		       
		       if (tankgeninfo!=null){
		    	   
		    	   cellgen.setPhrase(new Phrase("Dam Name", blackFont));
		    	   tablegen.addCell(cellgen);
	   	 	        
	   	 	    cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getTankName(), blackNFont));
	   	 	tablegen.addCell(cellgen);
  	 	         
  	 	      cellgen.setPhrase(new Phrase("Project ID Code (PIC) ", blackFont));
  	 	   tablegen.addCell(cellgen);
	 	              cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getNrldCode(), blackNFont));
	 	             tablegen.addCell(cellgen);
	               
	               cellgen.setPhrase(new Phrase("Dam Type ", blackFont));
	               tablegen.addCell(cellgen);
               cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getTypeOfDam(), blackNFont));
               tablegen.addCell(cellgen);
          
          cellgen.setPhrase(new Phrase("Dam Purpose ", blackFont));
          tablegen.addCell(cellgen);
           cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getDamPurpose(), blackNFont));
           tablegen.addCell(cellgen);
      
      cellgen.setPhrase(new Phrase("Dam Owner ", blackFont));
      tablegen.addCell(cellgen);
          cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getOwnerOfDam(), blackNFont));
          tablegen.addCell(cellgen);
  
  cellgen.setPhrase(new Phrase("Hazard Classification ", blackFont));
  tablegen.addCell(cellgen);
  cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getHazardClass(), blackNFont));
  tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase("Dam Operator ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getDamOperator(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Type of Inspection ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getTypeofinspection(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Commissioning Date ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getCommisionDate(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Inspection by ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getInspectOfficeName()+" ("+resinspectinfo.get(0).getInspectdesignationName()+") ", blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" City/ State / PIN ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getMandalName() +"	(Mandal)	"+Chunk.NEWLINE+tankgeninfo.get(0).getVillageName()+" (Village)" , blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Date of Inspection ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getInspectDate(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" District ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase( tankgeninfo.get(0).getDistrictName(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Reservoir water level in metre on the date  of inspection ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getPresentWaterlevel().toString(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Latitude ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getLatitude(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Storage Capacity (MCM) :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase("	(i)	Gross...."+tankgeninfo.get(0).getGrossStorageatFrl()  +Chunk.NEWLINE+"	(ii)	Live...."+ resinspectinfo.get(0).getStorageCapacity(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Longitude :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getLongitude(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Weather Conditions :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getWeathercondition(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Important Controlling Level :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase( Chunk.NEWLINE+
		"a) TBL RL (meters)..... "+tankgeninfo.get(0).getTrlLevel()+Chunk.NEWLINE+
		Chunk.NEWLINE+
		"b) MWL RL (meters)..... "+tankgeninfo.get(0).getMwlLevel()+Chunk.NEWLINE+
		Chunk.NEWLINE+
		"c) FRL RL (meters)..... "+tankgeninfo.get(0).getFrlLevel()+Chunk.NEWLINE+
		Chunk.NEWLINE+
	    "d) Spillway Crest RL (meters)....."+tankgeninfo.get(0).getSpillWayCrestLevel()+Chunk.NEWLINE+
	    Chunk.NEWLINE+
	    "e)MDDL RL  (meters)....."+tankgeninfo.get(0).getMddlLevel()+Chunk.NEWLINE+
	    Chunk.NEWLINE+
	    "f)Lowest River bed RL (meters)..... "+tankgeninfo.get(0).getLowestRiverBed()+Chunk.NEWLINE+
	    Chunk.NEWLINE+
	    "g)Deepest Foundation level RL (meters).....  "+tankgeninfo.get(0).getDeepestfoundationLevel()+
	    Chunk.NEWLINE , blackFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase("   ", blackNFont));
tablegen.addCell(cellgen);

/*cellgen.setPhrase(new Phrase( Chunk.NEWLINE+
"a) "+tankgeninfo.get(0).getTrlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"b) "+tankgeninfo.get(0).getMwlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"c) "+tankgeninfo.get(0).getFrlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"d) "+tankgeninfo.get(0).getSpillWayCrestLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"e) "+tankgeninfo.get(0).getMddlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"f) "+tankgeninfo.get(0).getLowestRiverBed()+Chunk.NEWLINE+
Chunk.NEWLINE+
"g) "+tankgeninfo.get(0).getDeepestfoundationLevel()+
Chunk.NEWLINE+Chunk.NEWLINE, blackNFont));
tablegen.addCell(cellgen);*/
	   	 	 
	   	 	      doc.add(tablegen);
		    	   
		    	   
		       }
		       
		       doc.newPage();
		       
		       // end of general info display
        
		       // start of remraks info
		       
		       if(resremarksinfo!=null){	
 	 	        	
	  	 	         int k=resremarksinfo.size();
	  	 	         
	  	 	         if(k>0){
	  	 	         
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
	  	 	        		   
		 					cellremarks.setPhrase(new Phrase(resremarksinfo.get(a).getRemarks(), blackNFont));
		 					tableremarks.addCell(cellremarks);
	  	 	  	 	
		 					  doc.add(tableremarks);
	  	 	    		}
	  	 	    	}
	  	 	    	
	  	 	         }
	  	 	        }
		       
		       // end of remarks info
		       
		       doc.newPage();
      
        // write table row data
       Integer i=1;
    

       String docname=" ";
       
  	 /*doc.newPage();*/  // commeted as table is displayed in new page--15/dec/2021 sowjanya
	       
	       // for (int m=0; m<j ; m++){
	        	
       PdfPTable table = new PdfPTable(7);
		   	 
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {5.0f, 23.0f, 4.0f, 4.0f, 4.0f, 30.0f, 10.0f});
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
	  	 	        		if(resCatListpdf!=null){
	  	 	        			
	  	 	        		 table.addCell(createCell("S.No.", 1, 2, PdfPCell.BOX));
	  	 	        		 //cell.setPhrase(new Phrase("S.No", blackNFont));
		 		   	 	     //table.addCell(cell);	
	  	 	        		 table.addCell(createCell("ITEMS OF INSPECTION", 1, 2, PdfPCell.BOX));
	  	 	        		// cell.setPhrase(new Phrase("ITEMS OF INSPECTION", blackNFont));
	 		   	 	       //   table.addCell(cell);
	  	 	        		 table.addCell(createCell("RESPONSE", 3, 1, PdfPCell.TOP));    
	 		   	 	    // cell.setPhrase(new Phrase("RESPONSE Y", blackNFont));
		   	 	        //  table.addCell(cell);
		   	 	          
		   	 	     // cell.setPhrase(new Phrase("RESPONSE N", blackNFont));
	   	 	         // table.addCell(cell);
	   	 	          
	   	 	      //cell.setPhrase(new Phrase("RESPONSE NA", blackNFont));
   	 	         // table.addCell(cell);
	 		   	 	 
	  	 	        		table.addCell(createCell("OBSERVATIONS BY FIELD STAFF AND RECOMMENDATIONS BY  "+resAnn1recmmonpdf.get(0).getInspectOfficeName(), 1, 2, PdfPCell.BOX));  
	  	 		 		   	table.addCell(createCell("CONDITION  ( Unsatisfactory, / Poor/ Fair / Satisfactory ) ", 1, 2, PdfPCell.BOX));  
	  	 		 		   	
	  	 		 		 table.addCell(createCell("Y", 1, 1, PdfPCell.BOX));
	  			       table.addCell(createCell("N", 1, 1, PdfPCell.BOX));
	  			       table.addCell(createCell("NA", 1, 1, PdfPCell.BOX));
	  			       
	  			       table.addCell(createCell("(1)", 1, 1, PdfPCell.BOX));
	  			       table.addCell(createCell("(2)", 1, 1, PdfPCell.BOX));
	  			       table.addCell(createCell("(3)", 1, 1, PdfPCell.BOX));
	  			       table.addCell(createCell("(4)", 1, 1, PdfPCell.BOX));
	  			       table.addCell(createCell("(5)", 1, 1, PdfPCell.BOX));
	  			       table.addCell(createCell("(6)", 1, 1, PdfPCell.BOX));
	  			       table.addCell(createCell("(7)", 1, 1, PdfPCell.BOX));
	 		   	 //	cell.setPhrase(new Phrase("OBSERVATIONS BY FIELD STAFF AND RECOMMENDATIONS BY  "+resAnn1recmmonpdf.get(0).getInspectOfficeName(), blackNFont));
		   	 	    //    table.addCell(cell);
		   	 	        
		   	 	//	cell.setPhrase(new Phrase("CONDITION  ( Unsatisfactory, / Poor/ Fair / Satisfactory ) ", blackNFont));
	   	 	     //   table.addCell(cell);
		   	 	    doc.add(table);
	  	 	        			
	  	 	        			
	  	 	        		   int a=resCatListpdf.size();
	  	 	        		   
	  	 	        		 int b=resChecksListpdf.size();
	  	 	        		 
	  	 	        		 int c=resAnn1mst2pdf.size();
	  	 	        		 
	  	 	        		 int d=resAnn1recmmonpdf.size();
	  	 	        		 
	  	 	        		
	  	 	  	 	     
	  	 	  	 	  for(int k=0; k<a ; k++){	
	  	 	  	 		  
	  	 	  	 	 Integer h=0;
	  	 	        		
	  	 	  	 	 if(k!=0){
	 	 	        	  doc.newPage();
	 	 	        	
	 	 	        	 }
  	 	        		
	  	 	  	 	
	  	 	  	 	 //} else if (resCatListpdf.get(k).getResParentcatId()>0 ){
	  	 	  	 		 
	  	 	  	 		 for(int j=0; j<a ; j++){
	  	 	  	 		 
	  	 	  	 		// System.out.println("kout"+resCatListpdf.get(k).getResCategoryId());
	  	 	  	 	// System.out.println("jout"+resCatListpdf.get(j).getResCategoryId());
	  	 	  	 			 
	  	 	  	 		 Integer maincategory=0;
	  	 	  	 			 
	  	 	  	 			 if((resCatListpdf.get(k).getResCategoryId()==resCatListpdf.get(j).getResParentcatId())    ){
	  	 	  	 				 
	  	 	  	 			
	  	 	  	 			 for(int m=0; m<b ; m++){
	 		   	 	        	
	  	 	  	 				 
	  	 	  	 			 Integer mainCheckId=0;    
	  			   	 	        //	System.out.println(j+"j"+"m"+m);
	  			   	 	        	
	  			   	 	        	if(resCatListpdf.get(j).getResCategoryId().equals(resChecksListpdf.get(m).getResCategoryId())){
	  			   	 	        		
	  			   	 	        		
	  			   	 	        		
	  			   	 	        	 if(resAnn1mst2pdf!=null){      	
	  					   	 	        
	  			   	                for(int p=0; p<c; p++){
	  			   	                	
	  			   	                	Integer mainObserveId=0;
	  			   	 	         
	  			   	 	                // System.out.println("m"+m+"  p"+p);
	  			   	 	       
	  			   	 	        	
	  			   	 		   	 	        	
	  			   	 			   	 	        PdfPTable obstable = new PdfPTable(1);
	  			   	 		             	   	 
	  			   	 		          	      obstable.setWidthPercentage(100.0f);
	  			   	 		          	      obstable.setWidths(new float[] {6.0f });
	  			   	 		          	    /* table.setWidths(new float[] { 20.0f});*/
	  			   	 		          	      obstable.setSpacingBefore(10);
	  			   	 		          	      obstable.setTotalWidth(100.0f);
	  			   	 		          	      obstable.getHorizontalAlignment();
	  			   	 		          	      obstable.completeRow();
	  			   	 		          	   
	  			   	 		          	   PdfPCell obs = new PdfPCell(); 
	  			   	 		        	    // obs.setBorder(0);// for removing lines around cells
	  			   	 		        	     obs.setNoWrap(false);
	  			   	 		        	     obs.setPadding(5);
	  			   	 		        	    
	  			   	 		        	     obs.getVerticalAlignment();
	  			   	 		        	     
	  			   	 		        	
	  			   	 		        	
	  			   	 		   
	  	 	  	 		
			   	 	        if(resChecksListpdf.get(m).getResCheckId().equals(resAnn1mst2pdf.get(p).getResCheckId()) ){
			   	 	        	
			   	 	        	
			   	 	        if(resCatListpdf.get(k).getResParentcatId()==0 ){	
			   	 	        	
			   	 	        if(h==0 && k!=0){
			   	 	        	
			   	 	        table.addCell(createCell("S.No.", 1, 2, PdfPCell.BOX));
			   	 	        table.addCell(createCell("ITEMS OF INSPECTION", 1, 2, PdfPCell.BOX));
			   	 	        table.addCell(createCell("RESPONSE", 3, 1, PdfPCell.TOP)); 	 
		 	 	        		//cell.setPhrase(new Phrase("S.No", blackNFont));
			 		   	 	   //  table.addCell(cell);	
		 	 	        		// cell.setPhrase(new Phrase("ITEMS OF INSPECTION", blackNFont));
				   	 	        //  table.addCell(cell);
				   	 	          
				   	 	    // cell.setPhrase(new Phrase("RESPONSE Y", blackNFont));
			   	 	       //   table.addCell(cell);
			   	 	          
			   	 	     // cell.setPhrase(new Phrase("RESPONSE N", blackNFont));
		  	 	         // table.addCell(cell);
		  	 	          
		  	 	     // cell.setPhrase(new Phrase("RESPONSE NA", blackNFont));
			 	        //  table.addCell(cell);
				   	 	 
				   	 	    
				   	 	//cell.setPhrase(new Phrase("OBSERVATIONS BY FIELD STAFF AND RECOMMENDATIONS BY  "+resAnn1recmmonpdf.get(0).getInspectOfficeName(), blackNFont));
			   	 	     //   table.addCell(cell);
			   	 	        
			   	 	//	cell.setPhrase(new Phrase("CONDITION  ( Unsatisfactory, / Poor/ Fair / Satisfactory ) ", blackNFont));
		  	 	     //   table.addCell(cell);
			   	 	        
			   	 	    table.addCell(createCell("OBSERVATIONS BY FIELD STAFF AND RECOMMENDATIONS BY  "+resAnn1recmmonpdf.get(0).getInspectOfficeName(), 1, 2, PdfPCell.BOX));  
  	 		 		   	table.addCell(createCell("CONDITION  ( Unsatisfactory, / Poor/ Fair / Satisfactory ) ", 1, 2, PdfPCell.BOX));  
  	 		 		   	
  	 		 		 table.addCell(createCell("Y", 1, 1, PdfPCell.BOX));
  			       table.addCell(createCell("N", 1, 1, PdfPCell.BOX));
  			       table.addCell(createCell("NA", 1, 1, PdfPCell.BOX));
  			       
  			       table.addCell(createCell("(1)", 1, 1, PdfPCell.BOX));
  			       table.addCell(createCell("(2)", 1, 1, PdfPCell.BOX));
  			       table.addCell(createCell("(3)", 1, 1, PdfPCell.BOX));
  			       table.addCell(createCell("(4)", 1, 1, PdfPCell.BOX));
  			       table.addCell(createCell("(5)", 1, 1, PdfPCell.BOX));
  			       table.addCell(createCell("(6)", 1, 1, PdfPCell.BOX));
  			       table.addCell(createCell("(7)", 1, 1, PdfPCell.BOX));
			   	 	    doc.add(table);
		 	 	        		 
		 	 	        	 }
		  	 	  	 			 if(!resCatListpdf.get(j).getResCatNumDisplay().equals("0")){
		  	 	  	 				 
		  	 	  	 			h=h+1;
		  	 	  	 			
		  	 	  	 			//System.out.println("h"+h+resCatListpdf.get(k).getResCategory());
		  	 	  	 			
		  	 	  	                  if(h==1){
		  		  	 	  	 		 
		  	 		  	 	  	 	 Paragraph paragraphtwo = new Paragraph(resCatListpdf.get(k).getResCatNumDisplay()+" "+resCatListpdf.get(k).getResCategory(), redFont);
		  	 		  			    paragraphtwo.setAlignment(Element.ALIGN_LEFT);
		  	 		  				
		  	 		  				 
		  	 		  				    doc.add(paragraphtwo);
		  	 	  	                  }
		  	 			        		  /*cell.setPhrase(new Phrase(resCatListpdf.get(k).getResCatNumDisplay()+" "+resCatListpdf.get(k).getResCategory() , redFont));
		  	 			   	 	        table.addCell(cell);*/
		  	 	 	 	        	  }
		  	 	 	 	        	  
		  	 	 	 	        	/* if(resCatListpdf.get(j).getResCatNumDisplay().equals("0")){
		  	 	 	 	        		 
		  	 	 	 	        		 Paragraph paragraphthree = new Paragraph(resCatListpdf.get(j).getResCategory(), redFont);
		  	 	 	 	        		paragraphthree.setAlignment(Element.ALIGN_LEFT);
		  	 	 		  				
		  	 	 		  				 
		  	 	 		  				    doc.add(paragraphthree);
		  	 	 			 	 	   
		  	 			        		  cell.setPhrase(new Phrase(resCatListpdf.get(k).getResCategory() , redFont));
		  	 			   	 	        table.addCell(cell);
		  	 	 	 	        	  }*/
		  	 	  	 			 }
			   	 	        	
			   	 	        	
			   	 	    	// System.out.println("jin"+resCatListpdf.get(j).getResCategoryId()+"j"+j);
			   	 	      if(maincategory==0){
			   	 	    	  
			   	 	    	//  System.out.println("maincategory"+maincategory);
			   	 	    	  
			   	 	        if( !(resCatListpdf.get(j).getResCatNumDisplay().equals("0")) ){
			  	 	  	 		 
			  	 	  	 	
			  	 	  	 		 
			  	 	  	 //	System.out.println(resCatListpdf.get(j).getResCategoryId()+"   "+resCatListpdf.get(j).getResCatNumDisplay());
			  	 	  	 		 
				  	 	  	 	 Paragraph paragraphtwo = new Paragraph(resCatListpdf.get(j).getResCatNumDisplay()+" "+resCatListpdf.get(j).getResCategory(), blackFont);
				  			    paragraphtwo.setAlignment(Element.ALIGN_LEFT);
				  				
				  				 
				  				    doc.add(paragraphtwo);
							 	 	   
					        		  /*cell.setPhrase(new Phrase(resCatListpdf.get(k).getResCatNumDisplay()+" "+resCatListpdf.get(k).getResCategory() , redFont));
					   	 	        table.addCell(cell);*/
			 	 	        	  }
			 	 	        	  
			 	 	        	 if(resCatListpdf.get(j).getResCatNumDisplay().equals("0")){
			 	 	        		 
			 	 	        		 Paragraph paragraphthree = new Paragraph(resCatListpdf.get(j).getResCategory(), blackFont);
			 	 	        		paragraphthree.setAlignment(Element.ALIGN_LEFT);
			 		  				
			 		  				 
			 		  				    doc.add(paragraphthree);
			 			 	 	   
					        		 /* cell.setPhrase(new Phrase(resCatListpdf.get(k).getResCategory() , redFont));
					   	 	        table.addCell(cell);*/
			 	 	        	  }
			 	 	        	 
			   	 	  }//main category if
			   	 	      
			   	 	  if(mainCheckId==0){
			  	 	  	 		 
			 	 	        	if(resChecksListpdf.get(m).getIsTitle()==false){
			   	 	        			
				   	 	        		 table.getDefaultCell().setColspan(1); ;
				   	 	        		 
				   	 	        		 
				   	 	        		 //System.out.println ("inside"+resChecksListpdf.get(m).getResCheckNumDisplay());
				   	 	        		
				   	 	        		 
				   	 	        	 cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckNumDisplay() , blackNFont));
				   	 	               
	   	 	             	            
					   	 	            
					   	 	           table.addCell(cell);	
				   	 	               cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckName() , blackNFont));
				   	 	               
				   	 	             	            
				   	 	            
				   	 	           table.addCell(cell);	
				   	 	           
				   	 	     

				   	 	
				   	 	        		}else if(  resChecksListpdf.get(m).getIsTitle()==true) {
				   	 	        			
				   	 	        			
				   	 	        		// Paragraph paragraphfr = new Paragraph(resChecksListpdf.get(m).getResCheckName(), blackNFont);
				   	 	        		//paragraphfr.setAlignment(Element.ALIGN_LEFT);
					 		  				
					 		  				 
					 		  				   // doc.add(paragraphfr);
				   	 	        		//System.out.println ("else"+resChecksListpdf.get(m).getResCheckName());
				   	 	        			
				   	 	        		cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckNumDisplay() , blackNFont));
				   					   	
				   					  
								   	 	  
			                         	 table.addCell(cell);	
				   	 	        		table.getDefaultCell().setColspan(6); 
				                         	cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckName() , blackNFont));
				   	
				  
							   	 	  
				                         	 table.addCell(cell);	
				                         	 
				                         	
				                        	
				   	 	        		}
			 	 	        	
			 	 	        	//add
			 	 	        	
			 	 	        	
			 	 	        	if(resAnn1mst2pdf.get(p).getDamcheckResponseId()==1){
			   	 	        		
				   	 	        	  cell= new PdfPCell(new Phrase("" , blackNFont));	
					  	 	            
					  	 	             
						  	 	      	 table.addCell(cell);    
				   	 	        	
				   	 	        cell= new PdfPCell(new Phrase(resAnn1mst2pdf.get(p).getDamcheckResponse() , blackNFont));	
			  	 	            
			  	 	             
				  	 	      	 table.addCell(cell);   
				  	 	      	 
				  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
			  	 	            
			  	 	             
				  	 	      	 table.addCell(cell); 
				   	 	        	}
				   	 	        	
				   	 	        if(resAnn1mst2pdf.get(p).getDamcheckResponseId()==2){
			   	 	        		
				   	 	        	 
				   	 	        cell= new PdfPCell(new Phrase(resAnn1mst2pdf.get(p).getDamcheckResponse() , blackNFont));	
			  	 	            
			  	 	             
				  	 	      	 table.addCell(cell);  
				  	 	      	 
				  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
			  	 	            
			  	 	             
				  	 	      	 table.addCell(cell);    
		   	 	        	
				  	 	      	 
				  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
			  	 	            
			  	 	             
				  	 	      	 table.addCell(cell); 
				   	 	        	}
				   	 	        
				   	 	    if(resAnn1mst2pdf.get(p).getDamcheckResponseId()==3){
		   	 	        		
				   	 	    cell= new PdfPCell(new Phrase("" , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell);    
	  	 	        	
			  	 	      	 
			  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell); 
			   	 	        	 
				   	 	        cell= new PdfPCell(new Phrase(resAnn1mst2pdf.get(p).getDamcheckResponse() , blackNFont));	
			  	 	            
			  	 	             
				  	 	      	 table.addCell(cell);  
				  	 	      	 
				  	 	    
				   	 	        	}
			 	 	        	
			 	 	        	
			 	 	        	
			   	 	  }
			   	 	  
			   	   mainCheckId=mainCheckId+1;   
			   	 	        	
			   	   
			   	  // System.out.println("mainObserveId"+mainObserveId+"p"+p);
			 	 	       
			   	 	        	if(mainObserveId==0){
			   	 	        		
			   	 	        	obs.setPhrase(new Phrase("Field Observation : " , blackFont ));
				   	 	        
					   	 	    obstable.addCell(obs);
			   	 	        obs.setPhrase(new Phrase(resAnn1mst2pdf.get(p).getRemarks(), blackPlane ));
			   	 	        
			   	 	    obstable.addCell(obs);
				   	 	table.getDefaultCell().setColspan(1);
						 	   cell.addElement(obstable);
						 
						 	   
			   	 	        } // mainObserveId
			   	 	        	
			   	 	        mainObserveId=mainObserveId+1;
						 	 
						 	   if(resAnn1recmmonpdf!=null){
			   	 	        
			   	 	    for(int q=0; q<d; q++){
					         
			                // System.out.println("m"+m+"  p"+p);
			       Integer recomnId=0;
			        	
				   	 	        	
					   	 	        PdfPTable rectable = new PdfPTable(1);
				             	   	 
					   	 	    rectable.setWidthPercentage(100.0f);
					   	 	rectable.setWidths(new float[] {6.0f });
				          	    /* table.setWidths(new float[] { 20.0f});*/
					   	 rectable.setSpacingBefore(10);
					   	rectable.setTotalWidth(100.0f);
					   	rectable.getHorizontalAlignment();
					   	rectable.completeRow();
				          	   
				          	   PdfPCell recm = new PdfPCell(); 
				          	// recm.setBorder(0);// for removing lines around cells
				          	recm.setNoWrap(false);
				          	recm.setPadding(5);
				        	    
				          	recm.getVerticalAlignment();
				        	     
				        	  
				        	    // System.out.println("beforeresAnn1mst2pdf.get(p).getResInspectMst2Id()"+resAnn1mst2pdf.get(p).getResInspectMst2Id());
				        	   
				        	    // System.out.println("beforeresAnn1recmmonpdf.get(q).getResInspectMst2Id()"+resAnn1recmmonpdf.get(q).getResInspectMst2Id());
					   	 	      //  System.out.println("resAnn1mst2pdf.get(p).getResCheckId()"+resAnn1mst2pdf.get(p).getResCheckId());
					   	 	        	
					   	 	        if((resAnn1mst2pdf.get(p).getResInspectMst2Id().equals(resAnn1recmmonpdf.get(q).getResInspectMst2Id()))	){
					   	 	        	
						        	   //  System.out.println("after resAnn1mst2pdf.get(p).getResInspectMst2Id()"+resAnn1mst2pdf.get(p).getResInspectMst2Id());
					   	 	  //  System.out.println("after resAnn1recmmonpdf.get(q).getResInspectMst2Id()"+resAnn1recmmonpdf.get(q).getResInspectMst2Id());
					   	 	        //	System.out.println("resChecksListpdf.get(m).getResCheckId()"+resChecksListpdf.get(m).getResCheckId());
					   	 	      //  System.out.println("resAnn1mst2pdf.get(p).getResCheckId()"+resAnn1mst2pdf.get(p).getResCheckId());
					   	 	        
					   	 	       // Paragraph paragraphp = new Paragraph();
					   	 	   // paragraphp.setAlignment(Element.ALIGN_LEFT);
					   	 	        	
					   	 	        	if(recomnId==0){
					   	 	    
					   	 	 //recm.setPhrase(new Phrase("Recommendations by  : "+resAnn1recmmonpdf.get(q).getInspectOfficeName(), blackFont ));
					   	 	 //   rectable.addCell(recm);
					   	 	        		
					   	 	        	 recm.setPhrase(new Phrase(" Recommendation : ", blackFont ));
								   	 	    rectable.addCell(recm);
					   	 	        recm.setPhrase(new Phrase( resAnn1recmmonpdf.get(q).getRemarks(), blackPlane ));
					   	 	    rectable.addCell(recm);
						   	 	table.getDefaultCell().setColspan(1);
								 	   cell.addElement(rectable);
								 	 
					   	 	        	}
					   	 	        recomnId=recomnId+1;
					   	 	        }
					   	 	
					   	 	        } // for q loop
						 	   }// resAnn1recmmonpdf not null
			   	 	        	
						 	   maincategory= maincategory+1;
						 	   
						 	  table.addCell(cell);
						 	  
						 	  
						 	  if(resAnn1mst2pdf.get(p).getConditionofCheckId()!=null){
						 		  
							 		 if(resAnn1mst2pdf.get(p).getConditionofCheckId()>0){
							 		  
							 			 cell= new PdfPCell(new Phrase(resAnn1mst2pdf.get(p).getConditionofCheck() , blackNFont));	
						  	 	            
					  	 	             
						  	 	      	 table.addCell(cell); 
							 		  
							 		 }  
							 	  }else{
							 		  
		                       cell= new PdfPCell(new Phrase("" , blackNFont));	
				  	 	            
				  	 	             
					  	 	      	 table.addCell(cell); 
							 	  }
							 	   
			   	 	        
			   	 	        }
			   	 	 
					 	   
					 	   
			   	 	      
			   	 	        
	  			   	               
			   	 	 
	  			   	                
					 	   
			   	 	        }  // for p loop
		   	 	   
		   	 	  }// resAnn1mst2pdf not null
	   	 	       
	   	 	        
	   	 	   //
	   	 	        
	   	 	   
		   	 	        	}	
		   	 	        	
		   	 	        }  // for m loop
		   	 		doc.add(table);	      
	   	 	   
	  	 	  	 		 } ///  if condition in j
	  	 	  	 	
	 	       
	  	 	  	 	 }  // for j loop
	  	 	  	 		 
	  	 	  	 
	  	 	  	 	  } // for k loop
	  	 	  	 
	 	    //  doc.add(table);
	 	    //  doc.newPage(); //shows table in new page
	 	        
	 	      
	 	        
	 	      
	 	     i++;
	 	    doc.newPage();
	 	   
	        		
	        		}
	         
	        		
	 	   	 	  
		 }
		 }
	
	 	     onEndPage(writer ,doc);
 
	}
	
	public PdfPCell createCell(String content, int colspan, int rowspan, int border) {
		Font blackFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, Font.BOLD, new CMYKColor(255, 255, 255, 255));
	    PdfPCell cell = new PdfPCell(new Phrase(content, blackFont));
	    cell.setColspan(colspan);
	    cell.setRowspan(rowspan);
	    cell.setBorder(border);
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    return cell;
	}

}
