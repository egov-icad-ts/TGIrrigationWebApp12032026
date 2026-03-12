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

public class PDFReservoirInspectionInfo extends AbstractITextPdfView {
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
		List<ReservoirSalient> resGeninfo = new ArrayList<ReservoirSalient>();
		List<ReservoirInspect> resinspectinfo = new ArrayList<ReservoirInspect>();
		
	
		
		
		//formdata=(ReservoirInspect) model.get("listform20Tanks");
		
		resGeninfo=(List<ReservoirSalient>) model.get("resgeninfo");
		resinspectinfo=(List<ReservoirInspect>) model.get("resinspectinfo");
		
	
		
		

	     
		
		Paragraph title = new Paragraph( resinspectinfo.get(0).getInspectOfficeName() +"  Inspection Details of  "+resGeninfo.get(0).getResName(), blacktitle);
		title.setAlignment(Element.ALIGN_CENTER);
		 doc.add(title);
		 
		 
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
	        
	        table.setWidths(new float[] {15.0f, 35.0f,30.0f, 20.0f });
	        //table.setWidths(new float[] {6.0f, 6.0f,6.0f, 6.0f });
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
	        table1.setWidths(new float[] {6.0f});
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
	  	 	        			
	  	 	        		
	  	 	        			
	  	 	        		 cell.setPhrase(new Phrase("Dam Name", blackFont));
	 		   	 	        table.addCell(cell);
	 		   	 	        
	 		   	 	     cell.setPhrase(new Phrase(resGeninfo.get(0).getResName(), blackFont));
		   	 	         table.addCell(cell);
		   	 	         
		   	 	          cell.setPhrase(new Phrase("Project ID Code (PIC) ", blackFont));
	   	 	               table.addCell(cell);
	   	 	           cell.setPhrase(new Phrase(resGeninfo.get(0).getNrldCode(), blackFont));
   	 	               table.addCell(cell);
   	 	               
   	 	           cell.setPhrase(new Phrase("Dam Type ", blackFont));
	 	               table.addCell(cell);
	 	           cell.setPhrase(new Phrase(resGeninfo.get(0).getTypeOfDam(), blackFont));
	               table.addCell(cell);
	               
	               cell.setPhrase(new Phrase("Dam Purpose ", blackFont));
 	               table.addCell(cell);
 	           cell.setPhrase(new Phrase(resGeninfo.get(0).getDamPurpose(), blackFont));
               table.addCell(cell);
               
               cell.setPhrase(new Phrase("Dam Owner ", blackFont));
	               table.addCell(cell);
	           cell.setPhrase(new Phrase(resinspectinfo.get(0).getOwnerOfDam(), blackFont));
           table.addCell(cell);
           
           cell.setPhrase(new Phrase("Hazard Classification ", blackFont));
           table.addCell(cell);
       cell.setPhrase(new Phrase(resGeninfo.get(0).getHazardClass(), blackFont));
   table.addCell(cell);
   
   cell.setPhrase(new Phrase("Dam Operator ", blackFont));
   table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getDamOperator(), blackFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Type of Inspection ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getTypeofinspection(), blackFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Commissioning Date ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resGeninfo.get(0).getCommisionDate(), blackFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Inspection by ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getInspectOfficeName(), blackFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" City/ State / PIN ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resGeninfo.get(0).getDistrictName()+" (District) /"+resGeninfo.get(0).getMandalName() +" (Mandal) /"+resGeninfo.get(0).getVillageName()+" Village" , blackFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Date of Inspection ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getInspectDate(), blackFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" District ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase( resGeninfo.get(0).getDistrictName(), blackFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Reservoir water level in metre on the date  of inspection ", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getPresentWaterlevel().toString(), blackFont));
table.addCell(cell);


cell.setPhrase(new Phrase(" Storage Capacity (MCM) :", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(" (i) Gross...."+resGeninfo.get(0).getGrossStorageatFrl()  +"(ii) Live...."+ resinspectinfo.get(0).getStorageCapacity(), blackFont));
table.addCell(cell);



cell.setPhrase(new Phrase(" Weather Conditions :", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getWeathercondition(), blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Inspection Officers present:", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getInspectOfficerData(), blackNFont));
table.addCell(cell);

cell.setPhrase(new Phrase(" Field Officers present:", blackFont));
table.addCell(cell);
cell.setPhrase(new Phrase(resinspectinfo.get(0).getFieldOfficerData(), blackNFont));
table.addCell(cell);





	 		   	 	 
	 		   	 	      doc.add(table);
	 		   	 	    
	 		   	 	 doc.newPage();
		   	 	 
	  	 	        
	 	    //  doc.newPage(); //shows table in new page
	 	        
	 	      
	 	        
	 	      
	 	     i++;
	 	    doc.newPage();
	 	   
	        		
	        		}
	         
	        		
	 	   	 	  
	 	   	 
	
	 	     onEndPage(writer ,doc);
 
	}

}
