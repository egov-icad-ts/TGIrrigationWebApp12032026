package in.ts.icad.leagal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.Tanks;

public class PDFReservoirAnnexure2  extends AbstractITextPdfView {
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
		List<ReservoirInspect> resChecksListpdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resCatListpdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn2mst2pdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn1recmmonpdf = new ArrayList<ReservoirInspect>();
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		List<ReservoirInspect> resinspectinfo = new ArrayList<ReservoirInspect>();
		List<Tanks> tankgeninfo= new ArrayList<Tanks>();
		List<ReservoirInspect> resremarksinfo = new ArrayList<ReservoirInspect>();
		
		
		
		//formdata=(ReservoirInspect) model.get("listform20Tanks");
		
		resChecksListpdf=(List<ReservoirInspect>) model.get("resChecksList");
		resCatListpdf=(List<ReservoirInspect>) model.get("resCatList");
		resAnn2mst2pdf =(List<ReservoirInspect>) model.get("resAnn2mst2info");
		
		resAnn1recmmonpdf =(List<ReservoirInspect>) model.get("resannrecommndList2");
		
resgeninfo=(List<ReservoirSalient>) model.get("resgeninfo");
		
		tankgeninfo=(List<Tanks>) model.get("tankgeninfo");
		
		resinspectinfo=(List<ReservoirInspect>) model.get("resinspectinfo");
		
		
		resremarksinfo=(List<ReservoirInspect>) model.get("resremarksinfo");
		
	    
	     
		
		
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
	       
	     //  System.out.println("resgeninfo.get(0).getYear()"+resgeninfo.get(0).getYear());
	
	       if(resgeninfo!=null){

			Paragraph sideheading = new Paragraph(" ", blackFont);		
				
			  Chunk textUnderline1 = new Chunk(" Name of the Dam : "+resgeninfo.get(0).getResName()+" ( "+resgeninfo.get(0).getNrldCode()+"  )                                                                                                      "+resgeninfo.get(0).getFreqoperationName()+" "+resgeninfo.get(0).getYear());
			  textUnderline1.setUnderline(0.8f, -3f);
			  sideheading.add(textUnderline1);
			  sideheading.setAlignment(Element.ALIGN_LEFT);
		      doc.add(sideheading);
		    
	       }
	       
	       if(tankgeninfo!=null){

				Paragraph sideheading = new Paragraph(" ", blackFont);		
					
				  Chunk textUnderline1 = new Chunk(" Name of the Dam : "+tankgeninfo.get(0).getTankName()+" ( "+tankgeninfo.get(0).getNrldCode()+"  )                                                                                                       "+tankgeninfo.get(0).getFreqoperationName()+" "+tankgeninfo.get(0).getYear());
				  textUnderline1.setUnderline(0.8f, -3f);
				  sideheading.add(textUnderline1);
				  sideheading.setAlignment(Element.ALIGN_LEFT);
			      doc.add(sideheading);
			    
		       }
			
			Paragraph title = new Paragraph("Scheduled Dam Safety Inspection Form", blacktitle);
			title.setAlignment(Element.ALIGN_CENTER);
			 doc.add(title);
			 
			 

				Paragraph subtitle = new Paragraph("Part 1a - Inspection Details", blackFont);
				subtitle.setAlignment(Element.ALIGN_LEFT);
				 doc.add(subtitle);
				 
				
		
		 // start of dam details
	       
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
cellgen.setPhrase(new Phrase(resgeninfo.get(0).getMandalName() +"	(Mandal)	 / "+resgeninfo.get(0).getVillageName()+" (Village)" , blackNFont));
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
cellgen.setPhrase(new Phrase( resgeninfo.get(0).getRes_long_d()+" \u00B0 "+resgeninfo.get(0).getRes_long_m()+" \' "+resgeninfo.get(0).getRes_long_s()+" \" ", blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Weather Conditions :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getWeathercondition(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Important Controlling Level :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase( 
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
      cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getOwnerOfDam(), blackNFont));
      tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase("Hazard Classification ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getHazardClass(), blackNFont));
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
cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getCommisionDate(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Inspection by ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getInspectOfficeName()+" ("+resinspectinfo.get(0).getInspectdesignationName()+") ", blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" City/ State / PIN ", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getMandalName() +"	(Mandal)	/ "+tankgeninfo.get(0).getVillageName()+" (Village)" , blackNFont));
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
cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getLatdegree()+" \u00B0 "+tankgeninfo.get(0).getLatminutes()+" \' "+tankgeninfo.get(0).getLatseconds()+" \" ", blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Storage Capacity (MCM) :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase("	(i)	Gross...."+tankgeninfo.get(0).getGrossStorageatFrl()  +Chunk.NEWLINE+"	(ii)	Live...."+ resinspectinfo.get(0).getStorageCapacity(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Longitude :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(tankgeninfo.get(0).getLongdegree()+" \u00B0 "+tankgeninfo.get(0).getLongminutes()+" \' "+tankgeninfo.get(0).getLongseconds()+" \" ", blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Weather Conditions :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase(resinspectinfo.get(0).getWeathercondition(), blackNFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" Important Controlling Level :", blackFont));
tablegen.addCell(cellgen);
cellgen.setPhrase(new Phrase( 
"a) TBL RL (meters)..... "+tankgeninfo.get(0).getTrlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"b) MWL RL (meters)..... "+tankgeninfo.get(0).getMwlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"c) FRL RL (meters)..... "+tankgeninfo.get(0).getFrlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"d) Spillway Crest RL (meters)....."+tankgeninfo.get(0).getSpillWayCrestLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"e)MDDL RL (meters)....."+tankgeninfo.get(0).getMddlLevel()+Chunk.NEWLINE+
Chunk.NEWLINE+
"f)Lowest River bed RL (meters)..... "+tankgeninfo.get(0).getLowestRiverBed()+Chunk.NEWLINE+
Chunk.NEWLINE+
"g)Deepest Foundation level RL  (meters).....  "+tankgeninfo.get(0).getDeepestfoundationLevel()+
Chunk.NEWLINE+Chunk.NEWLINE , blackFont));
tablegen.addCell(cellgen);

cellgen.setPhrase(new Phrase(" ",blackFont));
tablegen.addCell(cellgen);

tablegen.addCell(cellgen);
   	 	 
   	 	      doc.add(tablegen);
	    	   
	    	   
	       }
	       
	       doc.newPage();
	       
	       // end of general info display
    
	       // start of remraks info
	       
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
  	 	        		   
	 					cellremarks.setPhrase(new Phrase(resremarksinfo.get(a).getRemarks(), blackNFont));
	 					tableremarks.addCell(cellremarks);
  	 	  	 	
	 					  doc.add(tableremarks);
  	 	    		}
  	 	    	}
  	 	        }
	       
	       // end of remarks info
	       
	       doc.newPage();
  
	       
	       // end of dam details
		 
	
		 Paragraph heading = new Paragraph(" ", blacktitle);
		
			
			  Chunk textUnderline = new Chunk("Part 2a - Inspection Checklist");
			  textUnderline.setUnderline(0.8f, -3f);
			  heading.add(textUnderline);
			  heading.setAlignment(Element.ALIGN_LEFT);
		      doc.add(heading);

		    

		    
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
	        	
       PdfPTable table = new PdfPTable(7);
		   	 
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {5.0f, 23.0f, 4.0f, 4.0f, 4.0f, 30.0f, 10.0f });
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
	  	 	        			//cell.setPhrase(new Phrase("S.No.", blackFont));
		 		   	 	       // table.addCell(cell);
	  	 	        		 
	  	 	        		 table.addCell(createCell("Inspection Item", 1, 2, PdfPCell.BOX));
	  	 	        			
	  	 	        		// cell.setPhrase(new Phrase("Inspection Item", blackFont));
	 		   	 	       // table.addCell(cell);
	 		   	 	  
	 		   	 	   table.addCell(createCell("Response", 3, 1, PdfPCell.TOP));
	 		   	 	
	 		   	 	    
	 		   	 //	cell.setPhrase(new Phrase("Response Y", blackFont));
	 		   	// table.addCell(cell);
	 		   //	cell.setPhrase(new Phrase("Response N", blackFont));
	 		  // table.addCell(cell);
	 		   	
	 		 //  cell.setPhrase(new Phrase("Response NA", blackFont));
		   	 	//        table.addCell(cell);
	 		   	 	table.addCell(createCell("Observations and recommendations, if any , of the authorized inspecting officer", 1, 2, PdfPCell.BOX));  
	 		   	table.addCell(createCell("Condition ( Unsatisfactory /Poor/ Fair / Satisfactory )", 1, 2, PdfPCell.BOX)); 
	 		   	 	   
		   	 	    //cell.setPhrase(new Phrase("Observations and recommendations, if any , of the authorized inspecting officer", blackFont));
	   	 	       // table.addCell(cell);
	   	 	        
	   	 	   // cell.setPhrase(new Phrase("Condition ( Unsatisfactory /Poor/ Fair / Satisfactory )", blackFont));
   	 	      //  table.addCell(cell);
   	 	        
   	 	 
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
		     
   	 	        
   	 	   // cell.setPhrase(new Phrase("(1)"  , blackFont));
	 	  //  table.addCell(cell);
	 	 //  cell.setPhrase(new Phrase("(2)"  , blackFont));
	 	  //  table.addCell(cell);
	 	//   cell.setPhrase(new Phrase("(3)"  , blackFont));
	 	  //  table.addCell(cell);
	 	  // cell.setPhrase(new Phrase("(4)"  , blackFont));
	 	  //  table.addCell(cell);
	 	 //  cell.setPhrase(new Phrase("(5)"  , blackFont));
	 	 //   table.addCell(cell);
	 	 //  cell.setPhrase(new Phrase("(6)"  , blackFont));
	 	  //  table.addCell(cell);
	 	 //  cell.setPhrase(new Phrase("(7)"  , blackFont));
	 	 //   table.addCell(cell);
		   	 	        
		   	 	        
		   	 	    doc.add(table);
	  	 	        			
	  	 	        			
	  	 	        		   int a=resCatListpdf.size();
	  	 	        		   
	  	 	        		 int b=resChecksListpdf.size();
	  	 	        		 
	  	 	        		 int c=resAnn2mst2pdf.size();
	  	 	        		 
	  	 	        		 int d=resAnn1recmmonpdf.size();
	  	 	  	 	     
	  	 	  	 	  for(int k=0; k<a ; k++){	
	  	 	        		
	  	 	  	 	 if(k!=0){
	 	 	        	  doc.newPage();
	 	 	        	
	 	 	        	 }
  	 	        		
	  	 	  	 	 if(resCatListpdf.get(k).getResParentcatId()==0 ){
			 	 	   
	  	 	  	 	 if(!resCatListpdf.get(k).getResCatNumDisplay().equals("0")){
	  	 	  	 		 
	  	 	  	 	 Paragraph paragraphtwo = new Paragraph(resCatListpdf.get(k).getResCatNumDisplay()+" "+resCatListpdf.get(k).getResCategory(), redFont);
	  			    paragraphtwo.setAlignment(Element.ALIGN_LEFT);
	  				
	  				 
	  				    doc.add(paragraphtwo);
				 	 	   
		        		
 	 	        	  }
 	 	        	  
 	 	        	 if(resCatListpdf.get(k).getResCatNumDisplay().equals("0")){
 	 	        		 
 	 	        		 Paragraph paragraphthree = new Paragraph(resCatListpdf.get(k).getResCategory(), redFont);
 	 	        		paragraphthree.setAlignment(Element.ALIGN_LEFT);
 		  				
 		  				 
 		  				    doc.add(paragraphthree);
 			 	 	   
		        	
 	 	        	  }
 	 	        	 
 	 	        	 if(k!=0){
 	 	        		 
 	 	        		//cell.setPhrase(new Phrase("S.No.", blackFont));
 		   	 	       // table.addCell(cell);
	 	        			
	 	        		// cell.setPhrase(new Phrase("Inspection Item", blackFont));
		   	 	      //  table.addCell(cell);
		   	 	  
		   	 	    
		   	 	//cell.setPhrase(new Phrase("Response Y", blackFont));
		   	// table.addCell(cell);
		   	//cell.setPhrase(new Phrase("Response N", blackFont));
		   //table.addCell(cell);
		   	
		  // cell.setPhrase(new Phrase("Response NA", blackFont));
   	 	        //table.addCell(cell);
   	 	   // cell.setPhrase(new Phrase("Observations and recommendations, if any , of the authorized inspecting officer", blackFont));
	 	       // table.addCell(cell);
	 	        
	 	    //cell.setPhrase(new Phrase("Condition ( Unsatisfactory /Poor/ Fair / Satisfactory )", blackFont));
	       // table.addCell(cell);
	        
	       // cell.setPhrase(new Phrase("(1)"  , blackFont));
	 	   // table.addCell(cell);
	 	  // cell.setPhrase(new Phrase("(2)"  , blackFont));
	 	   // table.addCell(cell);
	 	  // cell.setPhrase(new Phrase("(3)"  , blackFont));
	 	  //  table.addCell(cell);
	 	  // cell.setPhrase(new Phrase("(4)"  , blackFont));
	 	  //  table.addCell(cell);
	 	  // cell.setPhrase(new Phrase("(5)"  , blackFont));
	 	   // table.addCell(cell);
	 	  // cell.setPhrase(new Phrase("(6)"  , blackFont));
	 	   // table.addCell(cell);
	 	  // cell.setPhrase(new Phrase("(7)"  , blackFont));
	 	   // table.addCell(cell);
 	 	        		 
 	 	        		table.addCell(createCell("S.No.", 1, 2, PdfPCell.BOX));
 	 	        	  table.addCell(createCell("Inspection Item", 1, 2, PdfPCell.BOX));
 	 	        	    table.addCell(createCell("Response", 3, 1, PdfPCell.TOP));
 	 	        		table.addCell(createCell("Observations and recommendations, if any , of the authorized inspecting officer", 1, 2, PdfPCell.BOX));  
 	 	        	 		   	table.addCell(createCell("Condition ( Unsatisfactory /Poor/ Fair / Satisfactory )", 1, 2, PdfPCell.BOX)); 
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
 	 	        	
	  	 	  	 	 }
	  	 	  	 	
	  	 	  	 		 
	  	 	  	 		 for(int j=0; j<a ; j++){
	  	 	  	 		 
	  	 	  	 		 Integer maincheckelseId=0;
	  	 	  	 		 
	  	 	  	 		
	  	 	  	 			 
	  	 	  	 			 if((resCatListpdf.get(k).getResCategoryId()==resCatListpdf.get(j).getResParentcatId())    ){
	  	 	  	 		
	  	 	  	 	 if( !(resCatListpdf.get(j).getResCatNumDisplay().equals("0")) ){
	  	 	  	 		 
	  	 	  	 	
		  	 	  	 	 Paragraph paragraphtwo = new Paragraph("", blackFont);
		  	 	  	 	 
		  	 	  	 Chunk textUnderline2 = new Chunk(resCatListpdf.get(j).getResCatNumDisplay()+" "+resCatListpdf.get(j).getResCategory()); 
		  	 	  	
		  	 	     textUnderline2.setUnderline(0.8f, -3f);
		  	 	       paragraphtwo.add(textUnderline2);
		  			    paragraphtwo.setAlignment(Element.ALIGN_LEFT);
		  				
		  				 
		  				    doc.add(paragraphtwo);
					 	 	   
			        		 
	 	 	        	  }
	 	 	        	  
	 	 	        	 if(resCatListpdf.get(j).getResCatNumDisplay().equals("0")){
	 	 	        		 
	 	 	        		 Paragraph paragraphthree = new Paragraph(" ", blackFont);
	 	 	        		
	 	 	        		 Chunk textUnderline3 = new Chunk(resCatListpdf.get(j).getResCategory()); 
	 			  	 	  	
	 			  	 	     textUnderline3.setUnderline(0.8f, -3f);
	 			  	 	 paragraphthree.add(textUnderline3);
	 	 	        		 
	 	 	        		 
	 	 	        		 
	 	 	        		 paragraphthree.setAlignment(Element.ALIGN_LEFT);
	 		  				
	 		  				 
	 		  				    doc.add(paragraphthree);
	 			 	 	  
	 	 	        	  }
	  	 	  	 		 
	  	 	  	 		 
	 	 	        		
	  	 	  	
		   	 	        
		   	 	        for(int m=0; m<b ; m++){
		   	 	        	
		   	 	        Integer mainnoObsCheckId=0;	  
		   	 	        	
		   	 	        	//System.out.println(j+"j"+"m"+m);
		   	 	        	
		   	 	        Integer maincatcheckId=0;
		   	 	        
		   	 	    PdfPTable obstable = new PdfPTable(1);
            	   	 
	          	      obstable.setWidthPercentage(100.0f);
	          	      obstable.setWidths(new float[] {6.0f });
	          	    obstable.setWidths(new float[] { 20.0f});
	          	      obstable.setSpacingBefore(10);
	          	      obstable.setTotalWidth(100.0f);
	          	      obstable.getHorizontalAlignment();
	          	      obstable.completeRow();
	          	   
	          	   PdfPCell obs = new PdfPCell(); 
	        	    // obs.setBorder(0);// for removing lines around cells
	        	     obs.setNoWrap(false);
	        	     obs.setPadding(5);
	        	    
	        	     obs.getVerticalAlignment();
		   	 	        
		   	 	        
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
		   	 	   
		   	 	        	
		   	 	        	if(resCatListpdf.get(j).getResCategoryId().equals(resChecksListpdf.get(m).getResCategoryId())){
		   	 	        		
		   	 	        	//System.out.println("resCatListpdf.get(j).getResCategoryId()"+resCatListpdf.get(j).getResCategoryId());
			   	 	      //  System.out.println("resChecksListpdf.get(m).getResCategoryId()"+resChecksListpdf.get(m).getResCategoryId());
			   	 	        
			   	 	    //System.out.println("resChecksListpdf.get(m).getResCheckNumDisplay()"+resChecksListpdf.get(m).getResCheckNumDisplay());
		   	 	        	if(maincatcheckId==0){
		   	 	        		if(resChecksListpdf.get(m).getIsTitle()==false){
		   	 	        			
		   	 	        		//table.getDefaultCell().setColspan(1); ;	//System.out.println ("inside"+resChecksListpdf.get(m).getResCheckNumDisplay());
		   	 	        		cell= new PdfPCell(new Phrase(resChecksListpdf.get(m).getResCheckNumDisplay() , blackNFont));	
		   	 	              // cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckNumDisplay()+"   "+resChecksListpdf.get(m).getResCheckName() , blackNFont));
		   	 	               cell.setColspan(1);
		   	 	      	 table.addCell(cell); 
		   	 	      	 
		   	 	       	 
		   	 	   
		   	 	
		   	 	           
		   	 	     cell= new PdfPCell(new Phrase(resChecksListpdf.get(m).getResCheckName() , blackNFont));	
  	 	            
  	 	             
  	 	      	 table.addCell(cell);    
  	 	      	 
  	 	     
		   	 	            
		   	 	          // table.addCell(cell);	
		   	 	           
		   	 	     //  cell.setPhrase(new Phrase("" , blackNFont));
		   	 	    	
		   	 	        		
		   	 		// table.addCell(cell);
		   	 	     

		   	 	
		   	 	        		}else if(  resChecksListpdf.get(m).getIsTitle()==true) {
		   	 	        			
		   	 	        			
		   	 	        		// Paragraph paragraphfr = new Paragraph(resChecksListpdf.get(m).getResCheckName(), blackNFont);
		   	 	        		//paragraphfr.setAlignment(Element.ALIGN_LEFT);
			 		  				
		   	 	        		
			 		  				   // doc.add(paragraphfr);
		   	 	        		//System.out.println ("else"+resChecksListpdf.get(m).getResCheckName());
		   	 	        		//cell.setColspan(2); 
		   	 	        			
		   	 	        			
		   	 	        		
		   	 	        			
		   	 	        			
		   	 	        			
		   	 	        			
		   	 	        		 cell = new PdfPCell(new Phrase(resChecksListpdf.get(m).getResCheckName() , blackNFont));
		                         //	cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckName() , blackNFont));
		   	
		                         	cell.setColspan(6); 
				   	 	              table.addCell(cell); 
					   	 	  
		                       	// table.addCell(cell); 
		                         	 
		                      
		                        	
		   	 	        		}
		   	 	        		
		   	 	        		
		   	 	        		
		   	 	        	//System.out.println("if maincheckelseId"+maincheckelseId);
		   	 	        	
		   	 	        	}
		   	 	        	
		   	 	        
		   	 	     
		   	 	        	
		   	 	        	
		   	 	  if(resAnn2mst2pdf!=null){      	
		   	 	        
               for(int p=0; p<c; p++){
	         
	                // System.out.println("m"+m+"  p"+p);
	                    Integer maincheckId=0;
	                 
	        	
		   	 	        	
			   	 	       /* PdfPTable obstable = new PdfPTable(1);
		             	   	 
		          	      obstable.setWidthPercentage(100.0f);
		          	      obstable.setWidths(new float[] {6.0f });
		          	     table.setWidths(new float[] { 20.0f});
		          	      obstable.setSpacingBefore(10);
		          	      obstable.setTotalWidth(100.0f);
		          	      obstable.getHorizontalAlignment();
		          	      obstable.completeRow();
		          	   
		          	   PdfPCell obs = new PdfPCell(); 
		        	    // obs.setBorder(0);// for removing lines around cells
		        	     obs.setNoWrap(false);
		        	     obs.setPadding(5);
		        	    
		        	     obs.getVerticalAlignment();*/
		        	     
		        	   //  System.out.println("resChecksListpdf.get(m).getResCheckId()"+resChecksListpdf.get(m).getResCheckId());
			   	 	      //  System.out.println("resAnn1mst2pdf.get(p).getResCheckId()"+resAnn2mst2pdf.get(p).getResCheckId());
			   	 	        	
			   	 	        if(resChecksListpdf.get(m).getResCheckId().equals(resAnn2mst2pdf.get(p).getResCheckId()) ){
			   	 	        	
			   	 	        //	System.out.println("resChecksListpdf.get(m).getResCheckId()"+resChecksListpdf.get(m).getResCheckId());
			   	 	       // System.out.println("resAnn1mst2pdf.get(p).getResCheckId()"+resAnn2mst2pdf.get(p).getResCheckId());
			   	 	        
			   	 	       // Paragraph paragraphp = new Paragraph();
			   	 	   // paragraphp.setAlignment(Element.ALIGN_LEFT);
			   	 	        	
			   	 	        	if(resAnn2mst2pdf.get(p).getDamcheckResponseId()==1){
			   	 	        		
			   	 	        	  cell= new PdfPCell(new Phrase("" , blackNFont));	
				  	 	            
				  	 	             
					  	 	      	 table.addCell(cell);    
			   	 	        	
			   	 	        cell= new PdfPCell(new Phrase(resAnn2mst2pdf.get(p).getDamcheckResponse() , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell);   
			  	 	      	 
			  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell); 
			   	 	        	}
			   	 	        	
			   	 	        if(resAnn2mst2pdf.get(p).getDamcheckResponseId()==2){
		   	 	        		
			   	 	        	 
			   	 	        cell= new PdfPCell(new Phrase(resAnn2mst2pdf.get(p).getDamcheckResponse() , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell);  
			  	 	      	 
			  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell);    
	   	 	        	
			  	 	      	 
			  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell); 
			   	 	        	}
			   	 	        
			   	 	    if(resAnn2mst2pdf.get(p).getDamcheckResponseId()==3){
	   	 	        		
			   	 	    cell= new PdfPCell(new Phrase("" , blackNFont));	
	  	 	            
	  	 	             
		  	 	      	 table.addCell(cell);    
  	 	        	
		  	 	      	 
		  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
	  	 	            
	  	 	             
		  	 	      	 table.addCell(cell); 
		   	 	        	 
			   	 	        cell= new PdfPCell(new Phrase(resAnn2mst2pdf.get(p).getDamcheckResponse() , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell);  
			  	 	      	 
			  	 	    
			   	 	        	}
			  	 	      	 
			   	 	        	
			   	 	        	if(maincheckId==0){
			   	 	        		
			   	 	       // System.out.println(" resAnn1mst2pdf.get(p).getRemarks().length"+ resAnn2mst2pdf.get(p).getRemarks().length());
			   	 	        	if(resAnn2mst2pdf.get(p).getRemarks().length()>1){ 	
			   	 	        obs.setPhrase(new Phrase(" Field Observations : ", blackFont ));
			   	 	    obstable.addCell(obs);
			   	 	  
			   	 	        obs.setPhrase(new Phrase( resAnn2mst2pdf.get(p).getRemarks(), blackPlane ));
			   	 	  //  obstable.addCell(obs);  
			   	 	        	}
			   	 	
				   	 	//table.getDefaultCell().setColspan(1);
			   	 	
			   	 	        	}else {
			   	 	        		
			   	 	        	obs.setPhrase(new Phrase("	"+"	", redFont));
			   	 	        		
			   	 	        	}
			   	 	    	if(resAnn2mst2pdf.get(p).getRemarks().length()>1){ 	 	
			   	 	        obstable.addCell(obs);
			   	 	    	}
			   	 	    	
						 //	   cell.addElement(obstable);
						 	//  table.addCell(cell);
			   	 	        	
			   	 	     
						 	   
						 	   if(resAnn1recmmonpdf!=null){
			   	 	        
			   	 	    for(int q=0; q<d; q++){
			   	 	    	
			   	 	    	Integer recChekId=0;
					         
			                // System.out.println("m"+m+"  p"+p);
			       
			        	
				   	 	        	
					   	 	      
				        	     
				        	  
				        	    // System.out.println("beforeresAnn1mst2pdf.get(p).getResInspectMst2Id()"+resAnn1mst2pdf.get(p).getResInspectMst2Id());
				        	   
				        	    // System.out.println("beforeresAnn1recmmonpdf.get(q).getResInspectMst2Id()"+resAnn1recmmonpdf.get(q).getResInspectMst2Id());
					   	 	      //  System.out.println("resAnn1mst2pdf.get(p).getResCheckId()"+resAnn1mst2pdf.get(p).getResCheckId());
					   	 	        	
					   	 	        if((resAnn2mst2pdf.get(p).getResInspectMst2Id().equals(resAnn1recmmonpdf.get(q).getResInspectMst2Id()))	){
					   	 	        	
						        	   //  System.out.println("after resAnn1mst2pdf.get(p).getResInspectMst2Id()"+resAnn1mst2pdf.get(p).getResInspectMst2Id());
					   	 	  //  System.out.println("after resAnn1recmmonpdf.get(q).getResInspectMst2Id()"+resAnn1recmmonpdf.get(q).getResInspectMst2Id());
					   	 	        //	System.out.println("Recommendations m"+resChecksListpdf.get(m).getResCheckId());
					   	 	        //  System.out.println("Recommendations p"+resAnn1mst2pdf.get(p).getResCheckId());
					   	 	        
					   	 	       // Paragraph paragraphp = new Paragraph();
					   	 	   // paragraphp.setAlignment(Element.ALIGN_LEFT);
					   	 	    if(recChekId==0){
					   	 	 recm.setPhrase(new Phrase("Recommendations by  : "+resAnn1recmmonpdf.get(q).getInspectOfficeName(), blackFont ));
					   	 	    rectable.addCell(recm);
					   	 	        recm.setPhrase(new Phrase("Recommendations : "+resAnn1recmmonpdf.get(q).getRemarks(), blackPlane ));
					   	 	    rectable.addCell(recm);
						   	 	//table.getDefaultCell().setColspan(1);
								 	 //  cell.addElement(rectable);
								 	 // table.addCell(cell);
								 	   
					   	 	    }   
								 	
					   	 	        }/*else{
					   	 	        	
					   	 	        recm.setPhrase(new Phrase("	"+"	", blackPlane));
					   	 	    rectable.addCell(recm);	
					   	 	        	
					   	 	        }*/
					   	 	   
					   	 	        
					   	 	       // }else  {
					   	 	        //	if((recChekId==0 && (resAnn1recmmonpdf.get(q).getRemarks().length()==0))){
					   	 	        	
					   	 	      
					   	 	       // recm.setPhrase(new Phrase("	"+"	", blackPlane));
					   	 	        
					   	 	   // rectable.addCell(recm);
						   	 	//table.getDefaultCell().setColspan(1);
								 //	   cell.addElement(rectable);
								 //	  table.addCell(cell);
					   	 	    //    }
					   	 	 
					   	 	      //  }*/
					   	 	    recChekId=recChekId+1;
					   	 	    
					   	 	// 
					   	 	   
					   	 	        } // for q loop
			   	 	    
			   	 	// table.addCell(cell);
						 	   }// resAnn1recmmonpdf not null
						 	  maincheckId=maincheckId+1;
						 	 // if(mainnoObsCheckId==0){
						 	 cell.addElement(obstable);
						 	 cell.addElement(rectable);   
						 	//  }
						 	   table.addCell(cell); 
						 	  //important 1  linked down   
						 	  mainnoObsCheckId=resChecksListpdf.get(m).getResCheckId();
					//	 System.out.println(" if "+mainnoObsCheckId+"---"+resChecksListpdf.get(m).getResCheckId()+"---"+resAnn1mst2pdf.get(p).getResCheckId()+"-p-"+p+"--m-"+m);
						 
			   	 	       
						 	  if(resAnn2mst2pdf.get(p).getConditionofCheckId()!=null){
						 		  
							 		 if(resAnn2mst2pdf.get(p).getConditionofCheckId()>=0){
							 		  
							 			 cell= new PdfPCell(new Phrase(resAnn2mst2pdf.get(p).getConditionofCheck() , blackNFont));	
						  	 	            
					  	 	             
						  	 	      	 table.addCell(cell); 
							 		  
							 		 }  
							 	  }else{
							 		  
		                       cell= new PdfPCell(new Phrase("" , blackNFont));	
				  	 	            
				  	 	             
					  	 	      	 table.addCell(cell); 
							 	  }
							 	   
			   	 	        
			   	 	        
			   	 	        } /*else {
			   	 	        	
			   	 	        cell= new PdfPCell(new Phrase("" , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell); 
			  	 	      	 
			  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell); 
			  	 	      	 
			  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell); 
			  	 	      	 
			  	 	      cell= new PdfPCell(new Phrase("" , blackNFont));	
		  	 	            
		  	 	             
			  	 	      	 table.addCell(cell); 
			  	 	      	 
			  	 	      
			  	 	     
			  	 	      	 
			  	 	    
			   	 	        	
			   	 	        	
			   	 	        }*/
			   	 	 
			   	 	  
			   	 	        
			   	 	    
					 	
					 	   
			   	 	  
			   	 	   
		   	 	   
		   	 	  } // for p loop
	   	 	        //important 1 
               if((mainnoObsCheckId==0) && (mainnoObsCheckId!=resChecksListpdf.get(m).getResCheckId()) ){
	   	 	        cell.setPhrase(new Phrase("	"+"	", blackPlane));
	   	 		  table.addCell(cell);   
	   	 		cell.setPhrase(new Phrase("  "+"	", blackPlane));
	   	 		  table.addCell(cell); 
	   	 		cell.setPhrase(new Phrase("	"+"	", blackPlane));
	   	 		  table.addCell(cell); 
	   	 		cell.setPhrase(new Phrase("	"+"	", blackPlane));
	   	 		  table.addCell(cell); 
	   	 		cell.setPhrase(new Phrase("	"+"	", blackPlane));
	   	 		  table.addCell(cell); 
	   	 	  
	   	 	       }
            
            
	   	 	   
		   	 	        	}	// resAnn1mst2pdf not null
		   	 	maincatcheckId=maincatcheckId+1;        	
		   
		   	  
		   	 	        }  // if condition of mj
		   	 	        	
		   	 	     
		   	 		//doc.add(table);	      
		   	 	   
	  	 	  	 		 } //m loop
		   	 	  
		   	 	
	  	 	  	 	 }  // if condition of jk
	  	 	  	 			 
	  	 	  	 		
	  	 	  	 	    doc.add(table);	 
	  	 	  	 
	  	 	  	 	  } // for j loop
	  	 	  	 		 
	  	 	  	 		 
	  	 	  	 	  } // for k loop
	  	 	  	 
	  	 	  	 	  
	  	 	 /* 	 Paragraph lastpara = new Paragraph(" Respond either yes (Y), no (N) or not applicable (NA)."+Chunk.NEWLINE+Chunk.NEWLINE
	  	 	  			 +"Condition: please rate the condition as either Satisfactory, Fair , Poor or Unsatisfactory as described below:"+Chunk.NEWLINE+Chunk.NEWLINE
	  	 	  			 +"1.    Satisfactory - No existing or potential dam safety deficiencies are recognized. Acceptable performance is expected under all "+Chunk.NEWLINE, blackNFont);		
					
				
	  	 	  lastpara.setAlignment(Element.ALIGN_LEFT);
			      doc.add(lastpara);*/
	 	  
	 	    //  doc.newPage(); //shows table in new page
	 	        
	 	      
	 	        
	 	      
	 	     i++;
	 	    doc.newPage();
	 	   
	        		
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
