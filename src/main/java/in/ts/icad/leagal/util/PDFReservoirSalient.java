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


import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.Tanks;

public class PDFReservoirSalient  extends AbstractITextPdfView {
	@Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		 doc.setPageSize(PageSize.A4);
		 doc.resetPageCount();//without this, page number is incremented by one
			doc.open();//after setting size then open new doc, so that for first page also orientation is set
			HeaderFooterPageEvent event = new HeaderFooterPageEvent();
	        writer.setPageEvent(event);
			//System.out.println("doc.getPageSize()"+doc.getPageSize());
        // get data model which is passed by the Spring container
    	
	        Font blueFont = FontFactory.getFont(FontFactory.TIMES_BOLD   , 11, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
	    	Font redFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, Font.BOLD, new CMYKColor(0, 255, 0, 0));
	    	//Font yellowFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, new CMYKColor(0, 0, 255, 0));
	    	Font blackFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, Font.BOLD, new CMYKColor(255, 255, 255, 255));
	    	Font blacktitle = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, Font.BOLD, new CMYKColor(255, 255, 255, 255));
	    	Font blackHeading = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, new CMYKColor(255, 255, 255, 255));
	    	Font greenFont = FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD, new CMYKColor(100, 0, 100, 60));
	    	Font blackNFont = FontFactory.getFont(FontFactory.TIMES  , 11, Font.NORMAL, new CMYKColor(255, 255,255, 255));
	    	
	    	Font blackPlane = FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL, new CMYKColor(255, 255, 255, 255));
	      
    
    	 
		@SuppressWarnings("unchecked")
		//ReservoirInspect formdata = new ReservoirInspect();
		List<ReservoirSalient> resSalInfo = new ArrayList<ReservoirSalient>();
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		List<ReservoirInspect> resinspectinfo = new ArrayList<ReservoirInspect>();
		List<Tanks> tanksSalInfo = new ArrayList<Tanks>();
		
		
		List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		
		List<Tanks> tankSalinfo = new ArrayList<Tanks>();
		
		
		
		//formdata=(ReservoirInspect) model.get("listform20Tanks");
		
		resSalInfo=(List<ReservoirSalient>) model.get("resSalInfo");
		resgeninfo=(List<ReservoirSalient>) model.get("resgeninfo");
		tankgeninfo=(List<Tanks>) model.get("tankgeninfo");
		resinspectinfo=(List<ReservoirInspect>) model.get("resinspectinfo");
		tanksSalInfo=(List<Tanks>) model.get("tanksSalInfo");
		
		//System.out.println("resgeninfo"+resgeninfo.get(0));
		
		//System.out.println("resinspectinfo"+resinspectinfo.get(0));
		
		
		
		//System.out.println("tankgeninfo"+tankgeninfo.get(0));
		
		
		Paragraph sideheading = new Paragraph(" ", blackNFont);		
		
		String nrldcodename=null;
			String villgaename=null;
			
			
			if(resgeninfo!=null){   
					
	  				if(!resgeninfo.get(0).getNrldCode().equals("0")){
	  					
	  	  				nrldcodename=resgeninfo.get(0).getNrldCode();
	  	  				
	  	  				}else{
	  	  					
	  	  				nrldcodename="New";
	  	  				}
	  	  				
	  	  			if(resgeninfo.get(0).getVillageName()!=null){
		  					
	  	  			   villgaename=resgeninfo.get(0).getVillageName();
	  	  				
	  	  				}else{
	  	  					
	  	  				villgaename=" ";
	  	  				}
	  	  				
	  					
	  				
	  				}
	  				
	  			if(tankgeninfo!=null){ 
	  				
	  			
	  				
	  				if(!tankgeninfo.get(0).getNrldCode().equals("0")){
	  					
	  				nrldcodename=tankgeninfo.get(0).getNrldCode();
	  				
	  				}else{
	  					
	  				nrldcodename="New";
	  				}
	  				
	  			if(tankgeninfo.get(0).getVillageName()!=null){
  					
	  			   villgaename=tankgeninfo.get(0).getVillageName();
	  				
	  				}else{
	  					
	  				villgaename=" ";
	  				}
	  				
  				
  				}
		
		
			 Paragraph heading = new Paragraph(" ", blacktitle);
				
				if(resgeninfo!=null){
			  Chunk textUnderline = new Chunk("SALIENT INFORMATION OF DAM  "+Chunk.NEWLINE
			  +resgeninfo.get(0).getResName()+"  ("+nrldcodename+") " );
			  textUnderline.setUnderline(0.8f, -3f);
			  heading.add(textUnderline);
			  heading.setAlignment(Element.ALIGN_CENTER);
			  
				}
				
				if(tankgeninfo!=null){
					  Chunk textUnderline = new Chunk("SALIENT INFORMATION OF DAM  "+Chunk.NEWLINE+tankgeninfo.get(0).getTankName()+"  ("+nrldcodename+") " );
					  textUnderline.setUnderline(0.8f, -3f);
					  heading.add(textUnderline);
					  heading.setAlignment(Element.ALIGN_CENTER);
					  
						}
		      doc.add(heading);

		   
  	  				
		
  	  			/*	 Paragraph paragraphnewlinenewline2 = new Paragraph(" "+Chunk.NEWLINE, blackNFont);
  	  		      paragraphnewlinenewline2.setAlignment(Element.ALIGN_LEFT);
  	  	  	  				
  	  	  	  				 
  	  	  	  				    doc.add(paragraphnewlinenewline2);*/
		 
	

		    
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
	        	
       PdfPTable table = new PdfPTable(3);
		   	 
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {7.0f, 48.0f, 45.0f });
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
	  	 	        		if((resSalInfo!=null || tanksSalInfo!=null) && (resgeninfo!=null || tankgeninfo!=null ) && (resinspectinfo!=null )){
	  	 	        			
	  	 	        			if(resgeninfo!=null && resinspectinfo!=null ){
	  	 	        			
	  	 	        			cell.setPhrase(new Phrase("S.No.", blackNFont));
	  	 	        		
		 		   	 	        table.addCell(cell);
	  	 	        			
	  	 	        		 cell.setPhrase(new Phrase("", blackNFont));
	 		   	 	        table.addCell(cell);
	 		   	 	  
	 		   	 	    
	 		   	 	cell.setPhrase(new Phrase("", blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("1" , blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("Name of the State or UT in which the Dam is Located", blackFont));
	 		   	 table.addCell(cell);
	 		   	
	 		   	
	 		
	 		   	cell.setPhrase(new Phrase("Telangana", blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 		   	cell.setPhrase(new Phrase("2" , blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("Name of the Dam Operator ", blackFont));
	 		   	 table.addCell(cell);
	 		   	
	 		   	
	 		
	 		   	 
	 		   	cell.setPhrase(new Phrase(resinspectinfo.get(0).getDamOperator(), blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("3" , blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("Full Address of the Dam ", blackFont));
	 		   	 table.addCell(cell);
	 		   	
	 		   	
	 		
	 		   	 
	 		   	cell.setPhrase(new Phrase(resgeninfo.get(0).getDistrictName()+" (District) ,"+resgeninfo.get(0).getMandalName()+" (Mandal) ,"+resgeninfo.get(0).getVillageName()+" (Village)", blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 		   	cell.setPhrase(new Phrase(" " , blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("Global Coordinates ", blackNFont));
	 		   	 table.addCell(cell);
	 		   	
	 		   	
	 		
	 		   	 
	 		   	cell.setPhrase(new Phrase("Latitude :  "+resgeninfo.get(0).getRes_lat_d()+" \u00B0 "+resgeninfo.get(0).getRes_lat_m()+" \' "+resgeninfo.get(0).getRes_lat_s()+" \"  N"+"      Longitude: "+resgeninfo.get(0).getRes_long_d()+" \u00B0 "+resgeninfo.get(0).getRes_long_m()+" \' "+resgeninfo.get(0).getRes_long_s()+" \"  E", blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 		   	 
	 		   	cell.setPhrase(new Phrase("4" , blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("Name of the Dam Owner ", blackFont));
	 		   	 table.addCell(cell);
	 		   	
	 		   	
	 		
	 		   	 
	 		   	cell.setPhrase(new Phrase(resinspectinfo.get(0).getOwnerOfDam(), blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("5" , blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("Full Address of the Dam Owner ", blackFont));
	 		   	 table.addCell(cell);
	 		   
	 		   	cell.setPhrase(new Phrase( " Jalasoudha Buildings,Erramunzil, Hyderabad. Telangana ", blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 		   	cell.setPhrase(new Phrase("6" , blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("Year of Commissioning of the Dam", blackFont));
	 		   	 table.addCell(cell);
	 		   
	 		   	cell.setPhrase(new Phrase(resgeninfo.get(0).getCommisionDate(), blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("7" , blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("Material with which the Dam was Constructed", blackFont));
	 		   	 table.addCell(cell);
	 		   
	 		   	cell.setPhrase(new Phrase(resgeninfo.get(0).getTypeOfDam(), blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("8" , blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 			cell.setPhrase(new Phrase("Salient Features of the Dam", blackFont));
	 		   	 table.addCell(cell);
	 		   
	 		   	cell.setPhrase(new Phrase("", blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 		   	 if(resSalInfo!=null){
	 		   		 
	 		   		
	 		   		 
	 		   		cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Height(m) (above deepest foundation level )", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getSalientheightdfl().toString(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	 
		 		   	cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("length of the crest ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getSalientlengthcrest().toString(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Bottom width (m) ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getSalientbottomwidth().toString(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Top width (m) ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getSalienttopwidth().toString(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Capacity of the reservoir (in m3) ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" (a) Active Storage ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getCapacityactivestorageStr(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" (b) Dead Storage ", blackFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	// System.out.println("resSalInfob test"+resSalInfo.get(0));
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getCapacitydeadstorage().toString(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	
		 		   	 
		 			cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("Max Flood Discharge (in m3) ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" (a) Design Flood ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getMfddesignflood().toString(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" (b) Observed Flood ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getMfdobservedflood().toString(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" Specially difficult Foundation problems", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getSpecialDifficultFoundationIssues(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" Unusual Dam Design", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getUnusualDamDesign(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("If yes, Please give details", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getUnusualDamDesigndetails(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("9 " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Inspection Galleries in the Dam", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("a " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Number ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getDamGalleryNumber(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("b " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Elevation of Galleries (m) ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getGalleryElevation(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("c " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Are all Galleries Dry? ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getGalleryDryStatus(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("10 " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Gates ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Method of Operation of Gates Hydraulic or Electric ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getGateOperationMethod(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Size of each Gate", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getResgatesize(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Number of Gates", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getResgatenumber(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	
		 		   	 
		 			cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Number of Gates in working condition", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getDamGateNumberFine().toString()+" Nos", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("11" , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Operation & Maintenance Manual", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("a " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Was an Operation & Maintenance Manual prepared ? ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getOanMManualPrepared(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("b " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("If No, by when is the same likely to be prepared", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getOanMManualPreparedTime(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("12 " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Silting of Reservoir", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("a " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Does the Reservoir get silted?", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getReservoirSilted(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("b " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("If Yes, what percentage of the reservoir capacity is lost?", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getLostPercentageReservoirCapacity()+" % ", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("13 " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Leakage through the Dam Body", blackFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		 	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("Peak Water leakage (in m3)", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getPeakWaterLeakage().toString(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("14", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("Structural Safety Assessment", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
	 		   		 
		 		   	 
		 			cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("Was Structural Safety  Assessment performed", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getStructuralSafetyPerformed(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("If Yes, was the Dam found to be safe?", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getDamFoundSafe(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("If No, was the Dam retrofitted?", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getDamRetrofitStatus(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("If Yes, when was it retrofitted?", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getDamRetrofitTime(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("If Yes, what was the retrofit measure adopted?", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getDamretrofitMeausreAdopted(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("15 ", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("Dam Break Analysis", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase(" ", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("Was Dam Break Analysis", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getDamBreakAnalysis(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase(" ", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("If YES, were Disaster Management Plans prepared?", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getDisaster_manage_prepared(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("16", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("Emergency Action Plan", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
	 		   		 
		 		   	 
		 			cell.setPhrase(new Phrase(" ", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("Was an Emergency Action Plan prepared? ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getEmergencyActionPlanPrepared(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			
		 		   	 
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("If Yes, was it shared with the SDMA and DDMA?", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(resSalInfo.get(0).getEmergencyActionShared(), blackNFont));
		 		   	 table.addCell(cell);
	 		   		 
	 		   		 
	 		   		 
	 		   	 }
	 		   	 
	  	 	        			}
	 		   	 
	  	 	        			if(tankgeninfo!=null && resinspectinfo!=null ){
		  	 	        			
		  	 	        			cell.setPhrase(new Phrase("S.No.", blackNFont));
		  	 	        		
			 		   	 	        table.addCell(cell);
		  	 	        			
		  	 	        		 cell.setPhrase(new Phrase("", blackNFont));
		 		   	 	        table.addCell(cell);
		 		   	 	  
		 		   	 	    
		 		   	 	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("1" , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Name of the State or UT in which the Dam is Located", blackFont));
		 		   	 table.addCell(cell);
		 		   	
		 		   	
		 		
		 		   	cell.setPhrase(new Phrase("Telangana", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("2" , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Name of the Dam Operator ", blackFont));
		 		   	 table.addCell(cell);
		 		   	
		 		   	
		 		
		 		   	 
		 		   	cell.setPhrase(new Phrase(resinspectinfo.get(0).getDamOperator(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("3" , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Full Address of the Dam ", blackFont));
		 		   	 table.addCell(cell);
		 		   	
		 		   	
		 		
		 		   	 
		 		   	cell.setPhrase(new Phrase(tankgeninfo.get(0).getDistrictName()+" (District) ,"+tankgeninfo.get(0).getMandalName()+" (Mandal) ,"+tankgeninfo.get(0).getVillageName()+" (Village)", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase(" " , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Global Coordinates ", blackNFont));
		 		   	 table.addCell(cell);
		 		   	
		 		   	
		 		
		 		   	 
		 		   	cell.setPhrase(new Phrase("Latitude :  "+tankgeninfo.get(0).getLatdegree()+" \u00B0 "+tankgeninfo.get(0).getLatminutes()+" \' "+tankgeninfo.get(0).getLatseconds()+" \"  N "+"      Longitude: "+tankgeninfo.get(0).getLongdegree()+" \u00B0 "+tankgeninfo.get(0).getLongminutes()+" \' "+tankgeninfo.get(0).getLongseconds()+" \"  E", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	 
		 		   	cell.setPhrase(new Phrase("4" , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Name of the Dam Owner ", blackFont));
		 		   	 table.addCell(cell);
		 		   	
		 		   	
		 		
		 		   	 
		 		   	cell.setPhrase(new Phrase(resinspectinfo.get(0).getOwnerOfDam(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("5" , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Full Address of the Dam Owner ", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(" Jalasoudha Buildings,Erramunzil, Hyderabad. Telangana", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	cell.setPhrase(new Phrase("6" , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Year of Commissioning of the Dam", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(tankgeninfo.get(0).getCommisionDate(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("7" , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Material with which the Dam was Constructed", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase(tankgeninfo.get(0).getTypeOfDam(), blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("8" , blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 			cell.setPhrase(new Phrase("Salient Features of the Dam", blackFont));
		 		   	 table.addCell(cell);
		 		   
		 		   	cell.setPhrase(new Phrase("", blackNFont));
		 		   	 table.addCell(cell);
		 		   	 
		 		   	 if(tanksSalInfo!=null){
		 		   		 
		 		   		
		 		   		 
		 		   		cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Height(m) (above deepest foundation level )", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getSalientheightdfl().toString(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	 
			 		   	cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("length of the crest ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getSalientlengthcrest().toString(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Bottom width (m) ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getSalientbottomwidth().toString(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Top width (m) ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getSalienttopwidth().toString(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Capacity of the reservoir (in m3) ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" (a) Active Storage ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getCapacityactivestorageStr(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" (b) Dead Storage ", blackFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	 //System.out.println("resSalInfob test"+resSalInfo.get(0));
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getCapacitydeadstorage().toString(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	
			 		   	 
			 			cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("Max Flood Discharge (in m3) ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" (a) Design Flood ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getMfddesignflood().toString(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" (b) Observed Flood ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getMfdobservedflood().toString(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" Specially difficult Foundation problems", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getSpecialDifficultFoundationIssues(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" Unusual Dam Design", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getUnusualDamDesign(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("If yes, Please give details", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getUnusualDamDesigndetails(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("9 " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Inspection Galleries in the Dam", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("a " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Number ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getDamGalleryNumber(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("b " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Elevation of Galleries (m) ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getGalleryElevation(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("c " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Are all Galleries Dry? ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getGalleryDryStatus(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("10 " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Gates ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Method of Operation of Gates Hydraulic or Electric ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getGateOperationMethod(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Size of each Gate", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getResgatesize(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Number of Gates", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getResgatenumber(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		  
			 		   	 
			 			cell.setPhrase(new Phrase(" " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Number of Gates in working condition", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getDamGateNumberFine().toString()+" Nos", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("11" , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Operation & Maintenance Manual", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("a " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Was an Operation & Maintenance Manual prepared ? ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getOanMManualPrepared(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("b " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("If No, by when is the same likely to be prepared", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getOanMManualPreparedTime(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("12 " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Silting of Reservoir", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("a " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Does the Reservoir get silted?", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getReservoirSilted(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("b " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("If Yes, what percentage of the reservoir capacity is lost?", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getLostPercentageReservoirCapacity()+" % ", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("13 " , blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("Leakage through the Dam Body", blackFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		 	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("Peak Water leakage (in m3)", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getPeakWaterLeakage().toString(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("14", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("Structural Safety Assessment", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
		 		   		 
			 		   	 
			 			cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("Was Structural Safety  Assessment performed", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getStructuralSafetyPerformed(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("If Yes, was the Dam found to be safe?", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getDamFoundSafe(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("If No, was the Dam retrofitted?", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getDamRetrofitStatus(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("If Yes, when was it retrofitted?", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getDamRetrofitTime(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("If Yes, what was the retrofit measure adopted?", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getDamretrofitMeausreAdopted(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase("15 ", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("Dam Break Analysis", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase(" ", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("Was Dam Break Analysis", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getDamBreakAnalysis(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			cell.setPhrase(new Phrase(" ", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("If YES, were Disaster Management Plans prepared?", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getDisaster_manage_prepared(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("16", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("Emergency Action Plan", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
		 		   		 
			 		   	 
			 			cell.setPhrase(new Phrase(" ", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("Was an Emergency Action Plan prepared? ", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getEmergencyActionPlanPrepared(), blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 			
			 		   	 
			 		   	cell.setPhrase(new Phrase("", blackNFont));
			 		   	 table.addCell(cell);
			 		   	 
			 		   	cell.setPhrase(new Phrase("If Yes, was it shared with the SDMA and DDMA?", blackFont));
			 		   	 table.addCell(cell);
			 		   
			 		   	cell.setPhrase(new Phrase(tanksSalInfo.get(0).getEmergencyActionShared(), blackNFont));
			 		   	 table.addCell(cell);
		 		   		 
		 		   		 
		 		   		 
		 		   	 }
		 		   	 
		  	 	        			}
	 		   	 
	 		   	
	 		   	
		   	 	        
		   	 	        
		   	 	    doc.add(table);
		   	 	    
		   	 	    
		   	 	    
		   	 	
	  	 	  	 	
	 	      
	 	        
	 	      
	 	     i++;
	 	    doc.newPage();
	 	   
	        		
	        		}
	         
	
	 	   	 	  
	 	   	 
	
	 	     onEndPage(writer ,doc);
 
	}

}

