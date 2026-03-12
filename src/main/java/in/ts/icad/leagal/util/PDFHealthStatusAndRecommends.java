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

public class PDFHealthStatusAndRecommends  extends AbstractITextPdfView {
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
    	Font redFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0));
    	//Font yellowFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, new CMYKColor(0, 0, 255, 0));
    	Font blackFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Font.BOLD, new CMYKColor(255, 255, 255, 255));
    	Font blacktitle = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, Font.BOLD, new CMYKColor(255, 255, 255, 255));
    	Font blackHeading = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, new CMYKColor(255, 255, 255, 255));
    	Font greenFont = FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD, new CMYKColor(100, 0, 100, 60));
    	Font blackNFont = FontFactory.getFont(FontFactory.TIMES  , 14, Font.NORMAL, new CMYKColor(255, 255,255, 255));
    	
    	Font blackPlane = FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL, new CMYKColor(255, 255, 255, 255));
      
    
    	 
		@SuppressWarnings("unchecked")
		//ReservoirInspect formdata = new ReservoirInspect();
		List<ReservoirInspect> resHealthInfo = new ArrayList<ReservoirInspect>();
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		List<ReservoirInspect> resAnn2mst2pdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn1recmmonpdf = new ArrayList<ReservoirInspect>();
		
		List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		
		
		
		//formdata=(ReservoirInspect) model.get("listform20Tanks");
		
		resHealthInfo=(List<ReservoirInspect>) model.get("resHealthInfo");
		resgeninfo=(List<ReservoirSalient>) model.get("resgeninfo");
		tankgeninfo=(List<Tanks>) model.get("tankgeninfo");
		
		resAnn1recmmonpdf =(List<ReservoirInspect>) model.get("resannrecommndList");
		
		
		
		Paragraph sideheading = new Paragraph(" ", blackNFont);		
		
		String nrldcodename=null;
			String villgaename=null;
		
		if(resgeninfo!=null){
		
		  Chunk textUnderline1 = new Chunk("Guidelines for Safety Inspection of Dams                                                                                                                    "+resgeninfo.get(0).getFreqoperationName()+" "+resgeninfo.get(0).getYear());
		  textUnderline1.setUnderline(0.8f, -3f);
		  sideheading.add(textUnderline1);
		  sideheading.setAlignment(Element.ALIGN_LEFT);
	      doc.add(sideheading);
	     
		}
		
		if(tankgeninfo!=null){
			
			  Chunk textUnderline1 = new Chunk("Guidelines for Safety Inspection of Dams                                                                                                                    "+tankgeninfo.get(0).getFreqoperationName()+" "+tankgeninfo.get(0).getYear());
			  textUnderline1.setUnderline(0.8f, -3f);
			  sideheading.add(textUnderline1);
			  sideheading.setAlignment(Element.ALIGN_LEFT);
		      doc.add(sideheading);
		     
			}
	      Paragraph paragraphnewlinenewline1 = new Paragraph(" "+Chunk.NEWLINE, blackNFont);
	      paragraphnewlinenewline1.setAlignment(Element.ALIGN_LEFT);
  	  				
  	  				 
  	  				    doc.add(paragraphnewlinenewline1);
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
  	  	  				
  	  					
  	  				  Paragraph paragraphtwo = new Paragraph("Name of Dam: "+resgeninfo.get(0).getResName()+"  ("+nrldcodename+")                                                            			Location: "+resgeninfo.get(0).getDistrictName()+" (District) / "+ Chunk.NEWLINE+"                                                                                                                                                                             			"+resgeninfo.get(0).getMandalName()+" (Mandal) "+ Chunk.NEWLINE+"                                                                                                                                                               			"+villgaename +" (Village)"+ Chunk.NEWLINE+"                                                        ", blackFont);
  	  			    paragraphtwo.setAlignment(Element.ALIGN_LEFT);
  	  				
  	  				 
  	  				    doc.add(paragraphtwo);
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
  	  				
	  				  Paragraph paragraphtwo = new Paragraph("Name of Dam: "+tankgeninfo.get(0).getTankName()+"  ("+nrldcodename+")                                                            			Location: "+tankgeninfo.get(0).getDistrictName()+" (District) / "+ Chunk.NEWLINE+"                                                                                                                                                                             			"+tankgeninfo.get(0).getMandalName()+" (Mandal) "+ Chunk.NEWLINE+"                                                                                                                                                               			"+villgaename +" (Village)"+ Chunk.NEWLINE+"                                                        ", blackFont);
	  			    paragraphtwo.setAlignment(Element.ALIGN_LEFT);
	  				
	  				 
	  				    doc.add(paragraphtwo);
	  				}
		
  	  			/*	 Paragraph paragraphnewlinenewline2 = new Paragraph(" "+Chunk.NEWLINE, blackNFont);
  	  		      paragraphnewlinenewline2.setAlignment(Element.ALIGN_LEFT);
  	  	  	  				
  	  	  	  				 
  	  	  	  				    doc.add(paragraphnewlinenewline2);*/
		 
	
		 Paragraph heading = new Paragraph(" ", blacktitle);
		
			
			  Chunk textUnderline = new Chunk("Part 2b - Consolidated Dam Health Status Report" );
			  textUnderline.setUnderline(0.8f, -3f);
			  heading.add(textUnderline);
			  heading.setAlignment(Element.ALIGN_LEFT);
		      doc.add(heading);

		      Paragraph paragraphnewlinezero = new Paragraph(" "+Chunk.NEWLINE, blackNFont);
		      paragraphnewlinezero.setAlignment(Element.ALIGN_LEFT);
	  	  				
	  	  				 
	  	  				    doc.add(paragraphnewlinezero);

		    
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
	  	 	        		if((resHealthInfo!=null) && (resgeninfo!=null || tankgeninfo!=null )){
	  	 	        			
	  	 	        			cell.setPhrase(new Phrase("S.No.", blackNFont));
	  	 	        		
		 		   	 	        table.addCell(cell);
	  	 	        			
	  	 	        		 cell.setPhrase(new Phrase("Observations / Significant Deficiencies Noticed", blackNFont));
	 		   	 	        table.addCell(cell);
	 		   	 	  
	 		   	 	    
	 		   	 	cell.setPhrase(new Phrase("Remedial Measures Suggested", blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 		   	 Integer catcount=0;
	 		   	 
	 		   	 for (int m=0 ; m<resHealthInfo.size(); m++){
	 		   		 
	 		   	
		 		   	 
	 		   	   
	 		   		catcount=  catcount+1;
	 		   		
	 		 String sno=  	catcount.toString();
	 		   		
	 		   		/*System.out.println("catcount"+resHealthInfo.get(m).getDeficiencyCategoryName());*/
	 			/*cell.setPhrase(new Phrase( catcount.toString() , blackNFont));
	 		   	 table.addCell(cell);*/
	 		   	cell.setPhrase(new Phrase(sno , blackNFont));
	 		   	 table.addCell(cell);
	 		   	
	 		
	 		   	cell.setPhrase(new Phrase(resHealthInfo.get(m).getRemarks(), blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 		   	 //resHealthInfo.get(m).getDeficiencyCategoryName()+Chunk.NEWLINE+Chunk.NEWLINE+
	 		   	 
	 			
	 		   	 if(resAnn1recmmonpdf!=null){
	 		   		 
	 		   		// System.out.println("one resHealthInfo.get(m).getRemarks()"+resHealthInfo.get(m).getRemarks());
	 		  // 	 System.out.println("two resAnn1recmmonpdf.get(0)"+resAnn1recmmonpdf.size());
	 		   		 if(resAnn1recmmonpdf.size()>0){
	 		   		 if(resHealthInfo.get(m).getResDamHealthId()==resAnn1recmmonpdf.get(0).getResDamHealthId()){
	 		   	
	 			cell.setPhrase(new Phrase("Recommendation by : "+resAnn1recmmonpdf.get(0).getInspectOfficeName()+Chunk.NEWLINE+Chunk.NEWLINE+resAnn1recmmonpdf.get(0).getRemarks(), blackNFont));
	 		   	 table.addCell(cell);
	 		   	 
	 		   		 }
	 		   	 
	 		   		 
	 		   	 }else {
	 		   		 
 	 		   		cell.setPhrase(new Phrase(" ", blackNFont));
 		 		   	 table.addCell(cell);
 	 		   	 }
	 		   	 }
	 		   	 
	 		   	 
	 		   
	 		   	 }
	 		   	
		   	 	        
		   	 	        
		   	 	    doc.add(table);
		   	 	    
		   	 	    
		   	 	    
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
	  	 	        			
        	     doc.newPage(); 
        	     
        	     if(resgeninfo!=null){
        	     obs.setPhrase(new Phrase(" Overall condition of dam based on above inspection - Unsatisfactory / Poor / Fair / Satisfactory ("+resgeninfo.get(0).getTotalDamCondition()+")", blackFont ));
		   	 	    obstable.addCell(obs);
        	     }else if(tankgeninfo!=null){
        	    	 obs.setPhrase(new Phrase(" Overall condition of dam based on above inspection - Unsatisfactory / Poor / Fair / Satisfactory ("+tankgeninfo.get(0).getTotalDamCondition()+")", blackFont ));
 		   	 	    obstable.addCell(obs); 
        	    	 
        	     }
		   	 	   
        	  if(resHealthInfo.size()>0){
        		  
        			 for (int k=0 ; k<resHealthInfo.size(); k++){
        				 
        				 if(resHealthInfo.get(k).getLatestHealthCategory()==true){
        	   
		   	 	 obs.setPhrase(new Phrase(" Overall Safety Category of the Dam - "+resHealthInfo.get(k).getDeficiencyCategoryName(), blackFont ));
		   	 	    obstable.addCell(obs);
        				 }
		   	 	    
        			 }
        	  }else{
        		  obs.setPhrase(new Phrase(" Overall Safety Category of the Dam - ", blackFont ));
		   	 	    obstable.addCell(obs); 
        		  
        	  }
		   	 	
		   	 	    
		   	 	 Paragraph paragraphnewline1 = new Paragraph(" "+Chunk.NEWLINE, blackNFont);
		   	 	paragraphnewline1.setAlignment(Element.ALIGN_LEFT);
	  	  				
	  	  				 
	  	  				    doc.add(paragraphnewline1);
	  	  				    doc.add(obstable);	
	  	  				    
	  	  				 Paragraph paragraphnewline2 = new Paragraph(" "+Chunk.NEWLINE, blackNFont);
	  			   	 	paragraphnewline2.setAlignment(Element.ALIGN_LEFT);
	  		  	  				
	  		  	  				 
	  		  	  				    doc.add(paragraphnewline2);
	  	  				    
	  	  				
	  	  				    
	  	  				    
	  	  				  Paragraph paragraphthree = new Paragraph(" *Category I- deficiencies which may lead to failure"+Chunk.NEWLINE, blackNFont);
	  	  				paragraphthree.setAlignment(Element.ALIGN_LEFT);
	  	  	  				
	  	  	  				 
	  	  	  				    doc.add(paragraphthree);
	  	  	  				    
	  	  	  				 Paragraph paragraphfour = new Paragraph("Category II- major deficiencies requiring prompt remedial measures;"+Chunk.NEWLINE, blackNFont);
	  	  	  			paragraphfour.setAlignment(Element.ALIGN_LEFT);
	 	  	  	  				
	 	  	  	  				 
	 	  	  	  				    doc.add(paragraphfour);
	 	  	  	  				    
	 	  	  	  				Paragraph paragraphfive = new Paragraph("Category III- minor remedial measures which are rectifiable during the year;"+Chunk.NEWLINE+Chunk.NEWLINE, blackNFont);
	 	  	  	  			paragraphfive.setAlignment(Element.ALIGN_LEFT);
	 		 	  	  	  				
	 		 	  	  	  				 
	 		 	  	  	  				    doc.add(paragraphfive);
	 		 	  	  	  				    
	 		 	  	  	  				    
	 		 	  	  	  			Paragraph paragraphsix = new Paragraph(" Name of Official (s) , Designation (s) and Signature (s);"+Chunk.NEWLINE, blackNFont);
	 		 	  	  	  	paragraphsix.setAlignment(Element.ALIGN_LEFT);
	 		 		 	  	  	  				
	 		 		 	  	  	  				 
	 		 		 	  	  	  				    doc.add(paragraphsix);
	 		 		 	  	  	  				    
	 		 		 	  	  	  			Paragraph paragraphseven = new Paragraph("Date : "+Chunk.NEWLINE, blackNFont);
	 		 		 	  	  	  	paragraphseven.setAlignment(Element.ALIGN_LEFT);
	 		 		 		 		 	  	  	  				
	 		 		 		 		 	  	  	  				 
	 		 		 		 		 	  	  	  				    doc.add(paragraphseven);
	  	 	  	 	
	  	 	  	 		 
	  	 	  	 	
	 	      
	 	        
	 	      
	 	     i++;
	 	    doc.newPage();
	 	   
	        		
	        		}
	         
	
	 	   	 	  
	 	   	 
	
	 	     onEndPage(writer ,doc);
 
	}

}

