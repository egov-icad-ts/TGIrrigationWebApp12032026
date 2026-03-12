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

public class PDFReservoirAnnexure1  extends AbstractITextPdfView {
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
		List<ReservoirInspect> resChecksListpdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resCatListpdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn1mst2pdf = new ArrayList<ReservoirInspect>();
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		
		List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		//formdata=(ReservoirInspect) model.get("listform20Tanks");
		
		resChecksListpdf=(List<ReservoirInspect>) model.get("resChecksList");
		resCatListpdf=(List<ReservoirInspect>) model.get("resCatList");
		resAnn1mst2pdf =(List<ReservoirInspect>) model.get("resAnn1mst2info");
		resgeninfo=(List<ReservoirSalient>) model.get("resgeninfo");
		
		resgeninfo=(List<ReservoirSalient>) model.get("resgeninfo");
	     
		tankgeninfo=(List<Tanks>) model.get("tankgeninfo");
		
		Paragraph title = new Paragraph("Annexure 1", blacktitle);
		title.setAlignment(Element.ALIGN_RIGHT);
		 doc.add(title);
		 
		  
		 
		 Paragraph paragraphOne = new Paragraph("CHECKLIST OF VARIOUS INSTRUMENTS INSTALLED ON LARGE DAMS", blackHeading);
		 paragraphOne.setAlignment(Element.ALIGN_CENTER);
		
		 
		    doc.add(paragraphOne);
		   
		  
		    Paragraph paragraphnewlinenewline1 = new Paragraph(" "+Chunk.NEWLINE, blackNFont);
		      paragraphnewlinenewline1.setAlignment(Element.ALIGN_LEFT);
	  	  				
	  	  		
		    
	  	  				    doc.add(paragraphnewlinenewline1);
	  	  				    
	  	  				 
	  	  				    
	  	  				if(resgeninfo!=null){  
	  	  					if(resgeninfo.size()>0){
	  	  				  Paragraph paragraphtwo = new Paragraph("Name of Dam: "+resgeninfo.get(0).getResName()+" ( "+resgeninfo.get(0).getNrldCode()+")"+Chunk.NEWLINE+"Location: "+resgeninfo.get(0).getDistrictName()+" (District) / "+resgeninfo.get(0).getMandalName()+" (Mandal) / "+resgeninfo.get(0).getVillageName() +" (Village)", blackFont);
	  	  			    paragraphtwo.setAlignment(Element.ALIGN_LEFT);
	  	  				
	  	  				 
	  	  				    doc.add(paragraphtwo);
	  	  					}
	  	  				}
	  	  				
	  	  			if(tankgeninfo!=null){  
	  	  			if(tankgeninfo.size()>0){ 
	  	  				  Paragraph paragraphtwo = new Paragraph("Name of Dam: "+tankgeninfo.get(0).getTankName()+" ( "+tankgeninfo.get(0).getNrldCode()+")"+Chunk.NEWLINE+"Location: "+tankgeninfo.get(0).getDistrictName()+" (District) / " +tankgeninfo.get(0).getMandalName()+" (Mandal) / " +tankgeninfo.get(0).getVillageName() +" (Village)", blackFont);
	  	  			    paragraphtwo.setAlignment(Element.ALIGN_LEFT);
	  	  				
	  	  				 
	  	  				    doc.add(paragraphtwo);
	  	  			}
	  	  				}
			
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
	        	
       PdfPTable table = new PdfPTable(12);
		   	 
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {6.0f, 13.6f,5.0f,10.3f,8.3f,7.3f,8.3f,6.3f,6.3f,6.3f,6.3f,15.6f });
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
	       
	       
	      
      PdfPCell cell = new PdfPCell();
      
      
    
      
   
     
      //cell.setBorder(0);// for removing lines around cells
       cell.setNoWrap(false);
       cell.setPadding(5);
      
     cell.getVerticalAlignment();
     

	  	 	        		
	  	 	        		//System.out.println("doc"+docname);
	  	 	        		if(resCatListpdf!=null){
	  	 	        			
	  	 	        			cell.setPhrase(new Phrase("Sl No."  , blackFont));
	  				   	 	    table.addCell(cell);
	  				   	 	cell.setPhrase(new Phrase("Name of Instruments"  , blackFont));
  				   	 	    table.addCell(cell);
  				   		cell.setPhrase(new Phrase("Nos"  , blackFont));
				   	 	    table.addCell(cell);
				   	 	cell.setPhrase(new Phrase("Location"  , blackFont));
			   	 	    table.addCell(cell);
			   	 	cell.setPhrase(new Phrase("Since when installed (Month / Year)"  , blackFont));
		   	 	    table.addCell(cell);
		   	 	    
		   	 	cell.setPhrase(new Phrase("Whether in working condition (Yes / No)"  , blackFont));
	   	 	    table.addCell(cell);
	   	 	    
	   	 	cell.setPhrase(new Phrase("Date last calibration  / Date for next calibration (dd/mm/yyyy)"  , blackFont));
   	 	    table.addCell(cell);
   	 	    
   	 	cell.setPhrase(new Phrase("Observations maintained (Yes / No)"  , blackFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("Agency responsible for data collection and processing"  , blackFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("Analysis of data done at field level (Yes/ No)"  , blackFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("Data sent to DSO regularly (Yes/ No)"  , blackFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("Remarks"  , blackFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("(1)"  , blackFont));
	 	    table.addCell(cell);
	 	   cell.setPhrase(new Phrase("(2)"  , blackFont));
	 	    table.addCell(cell);
	 	   cell.setPhrase(new Phrase("(3)"  , blackFont));
	 	    table.addCell(cell);
	 	   cell.setPhrase(new Phrase("(4)"  , blackFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("(5)"  , blackFont));
	 	    table.addCell(cell);
	 	   cell.setPhrase(new Phrase("(6)"  , blackFont));
	 	    table.addCell(cell);
	 	   cell.setPhrase(new Phrase("(7)"  , blackFont));
	 	    table.addCell(cell);
	 	   cell.setPhrase(new Phrase("(8)"  , blackFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("(9)"  , blackFont));
	 	    table.addCell(cell);
	 	   cell.setPhrase(new Phrase("(10)"  , blackFont));
	 	    table.addCell(cell);
	 	   cell.setPhrase(new Phrase("(11)"  , blackFont));
	 	    table.addCell(cell);
	 	   cell.setPhrase(new Phrase("(12)"  , blackFont));
	 	    table.addCell(cell);
	  				   	 	    
	 	   doc.add(table);  			
	  	 	        		   int a=resCatListpdf.size();
	  	 	        		   
	  	 	        		 int b=resChecksListpdf.size();
	  	 	        		 
	  	 	        		 int c=resAnn1mst2pdf.size();
	  	 	        		 
	  	 	        		
	  	 	  	 	     
	  	 	  	 	  for(int k=0; k<a ; k++){	
	  	 	  	 	//13042023	  
	  	 	  	 	/* if(k!=0){
	 	 	        	  doc.newPage();
	 	 	        	
	 	 	        	 }*/
	  	 	        		
	  	 	  	  if(resCatListpdf.get(k).getResParentcatId()==0){
	  	 	        	  if(!resCatListpdf.get(k).getResCatNumDisplay().equals("0")){
	  	 	        		  
	  	 	        		 Paragraph paragraphcheck1 = new Paragraph(resCatListpdf.get(k).getResCatNumDisplay()+" "+resCatListpdf.get(k).getResCategory(), blackFont);
	  	 	        		paragraphcheck1.setAlignment(Element.ALIGN_LEFT);
	  		  				
	  		  				 
	  		  				    doc.add(paragraphcheck1);
	  	 	        	  
			 	 	   
			        		/*  cell.setPhrase(new Phrase(resCatListpdf.get(k).getResCatNumDisplay()+" "+resCatListpdf.get(k).getResCategory() , redFont));
			   	 	        table.addCell(cell);*/
	  	 	        	  }
	  	 	        	  
	  	 	        	 if(resCatListpdf.get(k).getResCatNumDisplay().equals("0")){
	  	 	        		 
	  	 	        		 
	  	 	        		 Paragraph paragraphcheck2 = new Paragraph(resCatListpdf.get(k).getResCategory(), blackFont);
	  	 	        		paragraphcheck2.setAlignment(Element.ALIGN_LEFT);
	  		  				
	  		  				 
	  		  				    doc.add(paragraphcheck2);
	  			 	 	   
			        		/*  cell.setPhrase(new Phrase(resCatListpdf.get(k).getResCategory() , redFont));
			   	 	        table.addCell(cell);*/
	  	 	        	  }
	  	 	        	 
	  	 	  	  }//end of parentid is 0
			   	 	        
			   	 	   // cell.setPhrase(new Phrase(" " , blackNFont));
		   	 	       // table.addCell(cell);
	  	 	  	  
	  	 
	  	 		   
	  	 		Integer t=0;
		 		Integer s=0;
		 		
		 		//Integer h=0;
		   	 	       
	  	 		 for(int m=0; m<b ; m++){
	  	 			 
	  	 			
	   	 	        	
	   	 	        	if(resCatListpdf.get(k).getResCategoryId().equals(resChecksListpdf.get(m).getResCategoryId())){
	   	 	        		
	   	 	        	// h=h+1;
	   	 	        		
	   	 	        	if(resChecksListpdf.get(m).getIsTitle()==false){
			   	 	        cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckNumDisplay() , blackNFont));
			   	 	    table.addCell(cell);
			   	 	    
			   	 	    if(!(resChecksListpdf.get(m).getResCheckName() .equals("1")) && (resChecksListpdf.get(m).getResCheckName()!=null) ){
			   	 	    	/*if(resChecksListpdf.get(m).getResCheckName().length()>0){*/
			   	 	cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckName() , blackNFont));
		   	 	    table.addCell(cell);
			   	 	    	/*}*/
			   	 	    }
			   	 	    
			   	 	 //   System.out.println("resChecksListpdf.get(m).getResCheckName()"+resChecksListpdf.get(m).getResCheckName());
			   	 	// System.out.println(h+"here1");
			   	
			   	 	 
			   	 	  // doc.add(table);
			   	 	    
			   	     table.getDefaultCell().setColspan(1);
			   	 	        		}else  {
			   	 	        			
			   	 	        			
			   	 	        		// System.out.println(h+"here2");
			   	 	        		//	System.out.println(resChecksListpdf.get(m).getResCheckNumDisplay()+"here");
			   	 	        		   // System.out.println(resChecksListpdf.get(m).getResCheckName()+"here2");
			   	 	        			
			   	 	        	
				   	 	        	cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckNumDisplay() , blackNFont));
							   	 	        table.addCell(cell);
							   	 	        
							   	 	    table.getDefaultCell().setColspan(11);
			   	 	        	
			   	 	        	cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckName() , blackNFont));
						   	 	        table.addCell(cell);
						   	 	        
						   	 	
						   	 	  
						   	 	   // doc.add(table);
						   	 	
			   	 	        			
			   	 	        		}
	   	 	        table.getDefaultCell().setColspan(1);
	   	 	        
	   
	   	 		
	   	 		Integer y=0;
	   	 		
		 
	   	 	if(c>0){
	   	 	        for(int p=0; p<c; p++){	
	   	 	        	
	   	 	        
	   	 	 
	   	 	        
	   
 	   	 	        	
   		   	 	        if( resChecksListpdf.get(m).getResCheckId().equals(resAnn1mst2pdf.get(p).getResCheckId()) ){
   		   	 	        	
   		   	 	        	
   		   	 	 //    System.out.println("ystart"+y);
   		   	 	 //System.out.println(h+"hstarty");
   		   	 	     s=resAnn1mst2pdf.get(p).getResCheckId();  	
   		 	     t=resChecksListpdf.get(m).getResCheckId();
   		   	 	y=y+1;
   		   	 	        	
   		   	 	        	if(!(resAnn1mst2pdf.get(p).getResCheckName().equals("NA")) && (resChecksListpdf.get(m).getResCheckName()!=null)){
   		   	 	        		
   		   	 	        //	System.out.println("ynew"+y);
   		   	 	        	
   		   	 	   //  System.out.println("resAnn1mst2pdf.get(p).getResCheckName()"+resAnn1mst2pdf.get(p).getResCheckName());
   		   	 	        		
   		   	 	     cell.setPhrase(new Phrase(resAnn1mst2pdf.get(p).getResCheckName(), blackNFont));
 		   	 	    table.addCell(cell);
   		   	 	        	}
	   	 	       
	   	 	        cell.setPhrase(new Phrase(resAnn1mst2pdf.get(p).getInstalledcount().toString(), blackNFont));
		   	 	    table.addCell(cell);
		   	 	    
		   	 	 cell.setPhrase(new Phrase(resAnn1mst2pdf.get(p).getLocation(), blackNFont));
		   	 	    table.addCell(cell);
		   	 	    
		   	 	cell.setPhrase(new Phrase(resAnn1mst2pdf.get(p).getInstallmonth(), blackNFont));
	   	 	    table.addCell(cell);
	   	 	    if(resAnn1mst2pdf.get(p).getWorkingcondition()==true){
	   	 	cell.setPhrase(new Phrase("Yes", blackNFont));
   	 	    table.addCell(cell);
	   	 	    }else{
	   	 	    cell.setPhrase(new Phrase("No", blackNFont));
	   	 	    table.addCell(cell);
	   	 	    	
	   	 	    }
   	 	    
   	 	    
   	 	    if(!resAnn1mst2pdf.get(p).getDatelastCalibrated().equals(' ')  || ! resAnn1mst2pdf.get(p).getDatenextCalibrated().equals( ' ')){
   	 	cell.setPhrase(new Phrase(resAnn1mst2pdf.get(p).getDatelastCalibrated() +" / "+ resAnn1mst2pdf.get(p).getDatenextCalibrated(), blackNFont));
	 	    table.addCell(cell);
   	 	    } else {
   	 	    cell.setPhrase(new Phrase(" ", blackNFont));
	 	    table.addCell(cell);	
   	 	    	
   	 	    }
	 	 
	 	    if(resAnn1mst2pdf.get(p).getObsmaintained()==true){
	 	   cell.setPhrase(new Phrase("Yes", blackNFont));
	 	    table.addCell(cell);
	 	    }else{
	 	    	
	 	       cell.setPhrase(new Phrase("No", blackNFont));
		 	    table.addCell(cell);
	 	    	
	 	    }
	 	    
	 	    if(resAnn1mst2pdf.get(p).getAgencyresponsible()==true){
	 	   cell.setPhrase(new Phrase("Yes", blackNFont));
	 	    table.addCell(cell);
	 	    }else {
	 	    	
	 	    	  cell.setPhrase(new Phrase("No", blackNFont));
	 		 	    table.addCell(cell);
	 	    }
	 	    
	 	    if(resAnn1mst2pdf.get(p).getAnalysisofdata()==true){
	 	   cell.setPhrase(new Phrase("Yes", blackNFont));
	 	    table.addCell(cell);
	 	    }else{
	 	    	cell.setPhrase(new Phrase("No", blackNFont));
		 	    table.addCell(cell);	
	 	    	
	 	    }
	 	    
	 	    if(resAnn1mst2pdf.get(p).getDatasenttoDSO()==true){
	 	   cell.setPhrase(new Phrase("Yes", blackNFont));
	 	    table.addCell(cell);
	 	    }else {
	 	    	 cell.setPhrase(new Phrase("No", blackNFont));
	 	 	    table.addCell(cell);
	 	    	
	 	    }
	 	    
	 	   cell.setPhrase(new Phrase(resAnn1mst2pdf.get(p).getRemarks(), blackNFont));
	 	    table.addCell(cell);
	 	    
	 //	   System.out.println("if resChecksListpdf.get(m).getResCheckId()"+resChecksListpdf.get(m).getResCheckId());
   	 //	   System.out.println("if resAnn1mst2pdf.get(p).getResCheckId()"+resAnn1mst2pdf.get(p).getResCheckId());
   //	 	System.out.println("s"+s);
   //	 System.out.println("t"+t);
   	 
  // 	 System.out.println("y if"+y);
   	 
  // 	 h=0;
   	 
  // 	System.out.println("h if "+h);
   	
   	resAnn1mst2pdf.remove(p);
   	c=resAnn1mst2pdf.size();
   	
   /* && ((y!=0&& y!=1) || (h==1))*/
	 	    
	   	 	        } else if (((!(resChecksListpdf.get(m).getResCheckId().equals(resAnn1mst2pdf.get(p).getResCheckId()))) && ((!(resChecksListpdf.get(p).getResCheckId().equals(s))))  && ((!(resChecksListpdf.get(m).getResCheckId().equals(t))))) ) {
	   	 	  //     System.out.println("else resChecksListpdf.get(m).getResCheckId()"+resChecksListpdf.get(m).getResCheckId());
	   	 	//   System.out.println("else resAnn1mst2pdf.get(p).getResCheckId()"+resAnn1mst2pdf.get(p).getResCheckId());
	   	 //	 System.out.println("else s"+s);
	   		// System.out.println("t"+t);
	   		 
	   	  // 	System.out.println("y else"+y);
	   		 
	   		y=y+1;
	   		
	   	//	h=0;
	   //	 System.out.println("h "+h);
	      //	 System.out.println("y else next "+y);

	   	 	 s=resAnn1mst2pdf.get(p).getResCheckId();
	   	     t=resChecksListpdf.get(m).getResCheckId();
	   	 	       
	   	 	        if(resChecksListpdf.get(m).getResCheckName().equals("1")){
		   	 	    	
		   	 	     cell.setPhrase(new Phrase(" ", blackNFont));
		   	 	    table.addCell(cell);
		   	 	        	
	   	 	        }
	   	 	        	
	   	 	        cell.setPhrase(new Phrase("", blackNFont));
		   	 	    table.addCell(cell);
		   	 	    
		   	 	 cell.setPhrase(new Phrase("", blackNFont));
		   	 	    table.addCell(cell);
		   	 	    
		   	 	cell.setPhrase(new Phrase("", blackNFont));
	   	 	    table.addCell(cell);
	   	 	cell.setPhrase(new Phrase("", blackNFont));
   	 	    table.addCell(cell);
   	 	    
   	 	cell.setPhrase(new Phrase(" ", blackNFont));
	 	    table.addCell(cell);
	 	 
	 	    
	 	   cell.setPhrase(new Phrase("", blackNFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("", blackNFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("", blackNFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("", blackNFont));
	 	    table.addCell(cell);
	 	    
	 	   cell.setPhrase(new Phrase("", blackNFont));
	 	    table.addCell(cell);
	   	 	        	
	   	 	        	
	   	 	        	
	   	 	        	
	   	 	        	
	   	 	        }
	 	    
	   	 	        }
	   	 	    //c>0        
	   	 	}   else if(c==0){
	   	 		
	   	 	if(resChecksListpdf.get(m).getResCheckName().equals("1")){
   	 	    	
	   	 	     cell.setPhrase(new Phrase(" ", blackNFont));
	   	 	    table.addCell(cell);
	   	 	        	
  	 	        }
  	 	        	
  	 	        cell.setPhrase(new Phrase("", blackNFont));
	   	 	    table.addCell(cell);
	   	 	    
	   	 	 cell.setPhrase(new Phrase("", blackNFont));
	   	 	    table.addCell(cell);
	   	 	    
	   	 	cell.setPhrase(new Phrase("", blackNFont));
  	 	    table.addCell(cell);
  	 	cell.setPhrase(new Phrase("", blackNFont));
	 	    table.addCell(cell);
	 	    
	 	cell.setPhrase(new Phrase(" ", blackNFont));
	    table.addCell(cell);
	 
	    
	   cell.setPhrase(new Phrase("", blackNFont));
	    table.addCell(cell);
	    
	   cell.setPhrase(new Phrase("", blackNFont));
	    table.addCell(cell);
	    
	   cell.setPhrase(new Phrase("", blackNFont));
	    table.addCell(cell);
	    
	   cell.setPhrase(new Phrase("", blackNFont));
	    table.addCell(cell);
	    
	   cell.setPhrase(new Phrase("", blackNFont));
	    table.addCell(cell);
	   	 		
	   	 	}                                
		   	 	    
	   	 	        
                          /* for(int p=0; p<c; p++){
                        	   
                        	   PdfPTable obstable = new PdfPTable(1);
                      	   	 
                        	      obstable.setWidthPercentage(100.0f);
                        	      obstable.setWidths(new float[] {6.0f });
                        	     table.setWidths(new float[] { 20.0f});
                        	      obstable.setSpacingBefore(10);
                        	      obstable.setTotalWidth(100.0f);
                        	      obstable.getHorizontalAlignment();
                        	      obstable.completeRow();
                        	   
                        	   PdfPCell obs = new PdfPCell(); 
                      	     obs.setBorder(0);// for removing lines around cells
                      	     obs.setNoWrap(false);
                      	     obs.setPadding(5);
                      	    
                      	     obs.getVerticalAlignment();
                        	   
                        	   
		 	        	
			 	        if(resChecksListpdf.get(m).getResCheckId().equals(resAnn1mst2pdf.get(p).getResCheckId()) ){
			 	        	
			 	        	
			 	        obs.setPhrase(new Phrase("Observation: "+resAnn1mst2pdf.get(p).getRemarks(), blackNFont ));
			 	   
			 	     
			 	        }else{
			 	        	 
			 	        	obs.setPhrase(new Phrase("	"+"	", redFont));
			 	       
			 	        }
			 	   
			 	   	obstable.addCell(obs);
			 	   cell.addElement(obstable);
			 	        }*/
                       
                          
                         //  table.addCell(cell);
	   	 	   
	   	 	        
	 	        
	   	 	     
	   	 	        	
	   	 	        	}	// if inside m 
	   	 	        	
	   	 	        }   // for m looop
	   	 	   
	 	        
	 
	 	       
	 	    
	  	 	  	 
	 	      
	 	      doc.add(table);
	 	    //  doc.newPage(); //shows table in new page
	 	        
	  	 	
		        		} // for k loop
	 	        
	 	      
	 	     i++;
	 	    doc.newPage();
	 	   
	  	 	 
	  	 	        		}
	         
	        		
	 	   	 	  
	 	   	 
	
	 	     onEndPage(writer ,doc);
 
	}

}
