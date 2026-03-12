package in.ts.icad.leagal.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankformData;


public class pdfFORM20builder extends AbstractITextPdfView {
	
	
	 
	   
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
		MiTankformData formdata = new MiTankformData();
		List<MiTankformData> formDetailList = new ArrayList<MiTankformData>();
		List<MiTankformData> IrrisrcList = new ArrayList<MiTankformData>();
		List<MiTankFormDocs> form20DocsList = new ArrayList<MiTankFormDocs>();
		
		formdata=(MiTankformData) model.get("listform20Tanks");
		
		formDetailList=(List<MiTankformData>) model.get("listform20Detail");
		form20DocsList=(List<MiTankFormDocs>) model.get("form20DocsList");
		IrrisrcList =(List<MiTankformData>) model.get("IrrisrcList");
	    
		String villageName=null;
		
		Paragraph title = new Paragraph("T.S.F.C. FormNo.20", blacktitle);
		title.setAlignment(Element.ALIGN_CENTER);
		 doc.add(title);
		 
		 Paragraph paragraphOne = new Paragraph("Report of Damage of immovable Govt. Property to be sent to the Accountant General", blackHeading);
		 paragraphOne.setAlignment(Element.ALIGN_CENTER);
		
		 
		    doc.add(paragraphOne);
		    
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
	        	
       PdfPTable table = new PdfPTable(2);
		   	 
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {6.0f, 6.0f, });
	      /* table.setWidths(new float[] { 20.0f});*/
	        table.setSpacingBefore(5);
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
      
      PdfPCell contact = new PdfPCell();
     
      cell.setBorder(0);// for removing lines around cells
       cell.setNoWrap(false);
       cell.setPadding(5);
      
     cell.getVerticalAlignment();
     
     DecimalFormat df = new DecimalFormat("#,##0.00"); 
     
     Chunk linebreak= new Chunk(" ");
	  	 	        		
	  	 	        		//System.out.println("doc"+docname);
	  	 	        		if(formdata.getTankId()>0 &&formdata.getMandalId()>0 && formdata.getDistrictId()>0)
	  	 	        			
	  	 	        			
  	 	        		
	  	 	        	 cell.setPhrase(new Phrase("1.Department/Office	: ", blackNFont));
			 	 	        table.addCell(cell);  
			 	 	   
			        		  cell.setPhrase(new Phrase(formdata.getSubDivisionName()+";"+linebreak.NEWLINE+ formdata.getDivisionName()+";"+linebreak.NEWLINE+formdata.getCircleName()+";"+linebreak.NEWLINE+formdata.getUnitName()+";", blackNFont));
			   	 	        table.addCell(cell);
			   	 	    cell.setPhrase(new Phrase("2.Locality of I&CAD M.I. Sources: ", blackNFont));
		 	 	        table.addCell(cell);  
		        		  
		        		  cell.setPhrase(new Phrase(  formdata.getVillageName()  +"(V); "+ formdata.getMandalName()+"(M); "+formdata.getDistrictName()+"(District);", blackNFont));
		   	 	        table.addCell(cell);
		   	 	        
		   	 	    cell.setPhrase(new Phrase("3.Name of Source: ", blackNFont));
	 	 	        table.addCell(cell);  
		   	 	        
		   	 	        
		   	 	    cell.setPhrase(new Phrase(formdata.getTankName(), blackNFont));
	   	 	        table.addCell(cell);
	   	 	        
	   	 	    cell.setPhrase(new Phrase("4.Registered a) Under left side channel", blackNFont));
	 	        table.addCell(cell);  
   	 	        
	 	      // System.out.println("before"+formdata.getFrmBookValue());
   	 	    cell.setPhrase(new Phrase(df.format(formdata.getRegLeftChnnAcres())+" Acres", blackNFont));
	 	        table.addCell(cell);
	 	       cell.setPhrase(new Phrase("               	  b) Under right side channel", blackNFont));
	 	        table.addCell(cell);  
  	 	        
	 	      // System.out.println("before"+formdata.getFrmBookValue());
  	 	    cell.setPhrase(new Phrase(df.format(formdata.getRegRightChnnAcres())+" Acres", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("                	  c) Other Ayacut", blackNFont));
	 	        table.addCell(cell);  
 	 	        
	 	      // System.out.println("before"+formdata.getFrmBookValue());
 	 	    cell.setPhrase(new Phrase(df.format(formdata.getRegOthAcres())+" Acres", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("                    TOTAL (Acres)", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(df.format(formdata.getRegLeftChnnAcres()+formdata.getRegRightChnnAcres()+formdata.getRegOthAcres()), blackNFont));
	 	        table.addCell(cell);
	   	 	        
	   	 	   
   	 	        
   	 	    cell.setPhrase(new Phrase("5.Book Value: ", blackNFont));
	 	        table.addCell(cell);  
   	 	        
	 	      // System.out.println("before"+formdata.getFrmBookValue());
   	 	    cell.setPhrase(new Phrase(df.format(formdata.getFrmBookValue()), blackNFont));
	 	        table.addCell(cell);
	 	       
	 	       cell.setPhrase(new Phrase("6.a) Is it proposed to replace or reconstruct the damaged portion: ", blackNFont));
	 	        table.addCell(cell);  
	   	 	        
	   	 	        
	   	 	    cell.setPhrase(new Phrase(formdata.getFrmProposed(), blackNFont));
  	 	        table.addCell(cell);
  	 	        
  	 	     cell.setPhrase(new Phrase("b)If so, what is the estimate cost of  replace or reconstruction: ", blackNFont));
	 	        table.addCell(cell);  
	   	 	        
	   	 	        
	   	 	    cell.setPhrase(new Phrase(df.format(formdata.getApproxRepTotal()), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("7.If it is not  proposed to replace or reconstruct the damaged portion of the property that the amount to be written off. The Capital value of the property?( the amount should be estimated in the absence of book value): ", blackNFont));
	 	        table.addCell(cell);  
	   	 	        
	   	 	        
	   	 	    cell.setPhrase(new Phrase(df.format(formdata.getWriteOffValue()), blackNFont));
 	 	        table.addCell(cell);
 	 	        
 	 	       cell.setPhrase(new Phrase("8. What action is being taken to effect write off: if any mentioned as being necessary item 7 above:- ", blackNFont));
	 	        table.addCell(cell);  
	   	 	        
	   	 	        
	   	 	    cell.setPhrase(new Phrase(formdata.getWriteOffAction(), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	    
	 	        
	 	       cell.setPhrase(new Phrase("9. Date of Damage Breach ", blackNFont));
	 	        table.addCell(cell);  
	   	 	        
	   	 	        
	   	 	    cell.setPhrase(new Phrase(formdata.getDamageDate() +"       Time:  "+formdata.getDamageTime(), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("10.If due to rainfall ", blackNFont));
	 	        table.addCell(cell);  
	 	       cell.setPhrase(new Phrase("         ", blackNFont));
	 	       table.addCell(cell);
	 	       
	 	      cell.setPhrase(new Phrase("         a)Name of the nearest R.G Station: ", blackNFont));
	 	     table.addCell(cell);
	   	 	    cell.setPhrase(new Phrase(formdata.getRainRGStation(), blackNFont));
  	 	        table.addCell(cell);
  	 	        
  	 	     cell.setPhrase(new Phrase("         b)Quanatity of Rainfall:  ", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(df.format(formdata.getRainQty())+ "mm  on " +formdata.getRainDate(), blackNFont));
 	 	        table.addCell(cell);
 	 	        
 	 	        ///doc.add(linebreak);
 	 	     // doc.add(linebreak);
 	 	        
 	 	      cell.setPhrase(new Phrase("11. In case of Buildings if the damages are due to cyclone or fire accidents ", blackNFont));
	 	        table.addCell(cell);  
	 	       cell.setPhrase(new Phrase("         ", blackNFont));
	 	       table.addCell(cell);
	 	       
	 	      cell.setPhrase(new Phrase("         a)Name of the Quater : ", blackNFont));
	 	     table.addCell(cell);
	   	 	    cell.setPhrase(new Phrase(formdata.getQuartName(), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("         b)Type of the Quater : ", blackNFont));
		 	     table.addCell(cell);
		   	 	    cell.setPhrase(new Phrase(formdata.getQuartType(), blackNFont));
		 	        table.addCell(cell);
	 	        
	 	     cell.setPhrase(new Phrase("          c)Residential or Non Residential:  ", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(formdata.getBldgTypeName(), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("          d)description of damage:  ", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(formdata.getBldgDescDamage(), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	      
	 	      doc.add(table);
	 	    //  doc.newPage(); //shows table in new page
	 	        
	 	       PdfPTable nestable = new PdfPTable(5);
			   	 
	    		nestable.setWidthPercentage(100.0f);
	    		nestable.setWidths(new float[] {10.0f, 10.0f,10.0f,10.0f,10.0f });
		      /* table.setWidths(new float[] { 20.0f});*/
	    		nestable.setSpacingBefore(10);
	    		nestable.setTotalWidth(100.0f);
	    		nestable.getHorizontalAlignment();
	    		nestable.completeRow();
		      
		        
		       // table.setSplitRows(true);
		        
	    		nestable.setSpacingAfter(-3);
	    		nestable.setSplitLate(false);
		       
	    		nestable.setComplete(false);
		       
	    		nestable.setLockedWidth(false);
	    		nestable.setSkipFirstHeader(false);
		       nestable.setSkipLastFooter(true);
  	 	        
		       PdfPCell nescell = new PdfPCell();
		 	      
		 	     
		 	     
		 	  //   nescell.setBorder(0);// for removing lines around cells
		 	    nescell.setNoWrap(false);
		 	   nescell.setPadding(5);
		 	      
		 	  nescell.getVerticalAlignment();
		 	  
		 	 nescell.setPhrase(new Phrase("In case of irrigation source Name of structure of damaged portion(whether left side or right side)", blackNFont));
		 	nestable.addCell(nescell); 
		 	
		 	nescell.setPhrase(new Phrase("Chainage From : To ", blackFont));
		 	nestable.addCell(nescell);
		 	nescell.setPhrase(new Phrase("Measurement L.B.(H or Depth)", blackFont));
		 	nestable.addCell(nescell);
		 	nescell.setPhrase(new Phrase("Permanent Measure", blackFont));
		 	nestable.addCell(nescell);
		 	nescell.setPhrase(new Phrase("Temporary Measure", blackFont));
		 	nestable.addCell(nescell);
		 	nestable.setComplete(true);     
	 	       int c=formDetailList.size();
	 	      int p=IrrisrcList.size();
	 	 //  System.out.println("p"+p);
	 	  int k=1;
	 	//  int count=0;
	 	  for(int q=0; q<p ; q++){
	 		 int count=0;
	 	    	 if(c>0 ){
	 	    		 
	 	    		 if((formdata.getCatId()==1 && (IrrisrcList.get(q).getIrrSrcId()>=1 && IrrisrcList.get(q).getIrrSrcId()<9))||
	 	    				(formdata.getCatId()==2 && (IrrisrcList.get(q).getIrrSrcId()!=1 && 
	 	    				                            IrrisrcList.get(q).getIrrSrcId()!=3  &&
	 	    				                           IrrisrcList.get(q).getIrrSrcId()!=6  && 
	 	    				                          IrrisrcList.get(q).getIrrSrcId()!=7 && 
	 	    				                         IrrisrcList.get(q).getIrrSrcId()!=11 && 
	 	    				                        IrrisrcList.get(q).getIrrSrcId()<15))||
	 	    				(formdata.getCatId()==3 && (IrrisrcList.get(q).getIrrSrcId()==11 || IrrisrcList.get(q).getIrrSrcId()==8))) {
	 	    		nescell.setPhrase(new Phrase(k +") "+IrrisrcList.get(q).getIrrSrcName(), blackFont));
	 	    		nestable.addCell(nescell);
	 	      for(int d=0; d<c ; d++){
	 	    	 if(IrrisrcList.get(q).getIrrSrcId().equals(formDetailList.get(d).getIrrSrcId()) ){
	 	    	/* if(formdata.getFormDataId().equals(formDetailList.get(d).getFormDataId()) ){*/
	 	    		// System.out.println("c"+c);
	 	    	//	nescell.setPhrase(new Phrase(k +" "+formDetailList.get(d).getIrrSrcName(), blackFont));
	 	    	//	nestable.addCell(nescell);
	 	    		nescell.setPhrase(new Phrase("From Ch."+formDetailList.get(d).getIrrChFrm()+" to Ch."+formDetailList.get(d).getIrrChTo(), blackNFont));
	 	    		nestable.addCell(nescell);
	 	    		nescell.setPhrase(new Phrase(formDetailList.get(d).getIrrL()+" x "+formDetailList.get(d).getIrrB()+" x "+formDetailList.get(d).getIrrD(), blackNFont));
	 	    		nestable.addCell(nescell);
	 	    		nescell.setPhrase(new Phrase(df.format(formDetailList.get(d).getIrrPermcost()), blackNFont));
	 	    		nestable.addCell(nescell);
	 	    		nescell.setPhrase(new Phrase(df.format(formDetailList.get(d).getIrrTempcost()), blackNFont));
	 	    		nestable.addCell(nescell);
	 	    		
	 	    		count=1;
	 	    	//	 System.out.println("count in if"+count);
	 	    		 }
	 	      } 
	 	  //   System.out.println("count outside for"+count);
	 	    	 if(count<1){
	    			nescell.setPhrase(new Phrase("   ", blackNFont));
	 	    		nestable.addCell(nescell);
	 	    		nescell.setPhrase(new Phrase("  ", blackNFont));
	 	    		nestable.addCell(nescell);
	 	    		nescell.setPhrase(new Phrase("  ", blackNFont));
	 	    		nestable.addCell(nescell);
	 	    		nescell.setPhrase(new Phrase("   ", blackNFont));
	 	    		nestable.addCell(nescell);
	    		 }
	 	    			
	 	    	k++;	    	
    }
	 	    	 }
	 	  }
	 	  
	 	 nestable.setComplete(true);
	 	   ////nested table
	 	  doc.add(nestable);
	 	     
	 	     
	 	    cell.setPhrase(new Phrase("12. Approximate cost for repairs or reconstruction", blackNFont));
	 	       table.addCell(cell);
	 	        
	 	        
	 	       cell.setPhrase(new Phrase("         ", blackNFont));
	 	       table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("                  a) Temporary Measure(in Rs.)", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(df.format(formdata.getApproxRepTemp()), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("                  b) Permanent Repairs(in Rs.)", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(df.format(formdata.getApproxRepPermanent()), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("     TOTAL (in Rs.)", blackFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(df.format(formdata.getApproxRepTotal()), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	        
	 	       cell.setPhrase(new Phrase("13. Ayacut effected ", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(df.format(formdata.getEffAyacutAcres())+" Acres   Value in Rs."+df.format(formdata.getEffAyacutValue()), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("14.Whether action is being taken to protect standing crops:Proposed for temporary restoration ", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(formdata.getActionStdCrops(), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("15.Indicate whether the damage due to breaches scours whished off and silted up", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(formdata.getDamageBreaches(), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("16.Any useful information or remarks", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(formdata.getUsefulRemarks(), blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase("17.Date on which, T.S.F.C FormNo.20 is sent to Accountant General date", blackNFont));
	 	        table.addCell(cell);
	 	        
	 	       cell.setPhrase(new Phrase(formdata.getTsfcFormDate(), blackNFont));
	 	        table.addCell(cell);
	 	       table.setComplete(true);
	             doc.add(table);
	             
	             
	             Paragraph note  = new Paragraph("Note: The purpose of write off the value of temporary structure"
	             		+ " damage or destroyed which has served the period intended and which"
	             		+ "  therefore not proposed to be reconstructed. The value of the structure should be assessed"
	             		+ " at the time of damage or destruction");
	             note.setAlignment(Element.ALIGN_LEFT);
	             doc.add(note);
	             
	 	     i++;
	 	    doc.newPage();
	 	    
	 	   Paragraph certificate1 = new Paragraph(formdata.getTankName(), blackHeading);
	 	  certificate1.setAlignment(Element.ALIGN_CENTER);
			
			 
			    doc.add(certificate1);
			    
			    Paragraph certificate2 = new Paragraph("CERTIFICATE", blackHeading);
			    certificate2.setAlignment(Element.ALIGN_CENTER);
					
					 
					    doc.add(certificate2);
					    
					    Paragraph certificate3 = new Paragraph("1. Certified that the work damaged does not pertains to any subsisting "
					    		+ " contract or that damage under reference have not fallen places during the observation period following completion of work. ", blackNFont);
					    certificate3.setAlignment(Element.ALIGN_LEFT);
							
							 
							    doc.add(certificate3);
							    
							    
							    Paragraph certificate4 = new Paragraph("2. Certified that no items of improvement or extension are included in the "
							    		+ " above estimate for arriving at the cost of damage. ", blackNFont);
							    certificate4.setAlignment(Element.ALIGN_LEFT);
									
									 
									    doc.add(certificate4);
	 	    
	 	    
	 	    //commented on 10072022
	 	/*   Paragraph TankNameID = new Paragraph(formdata.getTankName()+"    GeoId:  "+formdata.getTankGeoId(), blackHeading);
			 paragraphOne.setAlignment(Element.ALIGN_CENTER);
			
			 
			    doc.add(TankNameID);
	 	       int e=form20DocsList.size();
	 	    //  System.out.println("e"+e);
 	 		      
	 	   	 	  if(e>0){
	 	   	 		
	 	 	       
	        		for(int f=0; f<e ; f++){
	        		if(formdata.getFormDataId()==form20DocsList.get(f).getFormDataId())	{	
	        			
	        			
	        			if(f==0){
	        				
	        			docname=form20DocsList.get(f).getFormDocOriginalName();
	        			
	        			String ext = FilenameUtils.getExtension(docname);
	        			//System.out.println("docname0"+docname +ext);
	        			// Creating an ImageData object 
	        			 String imageFile = form20DocsList.get(f).getFormDocLocation();
	        					 
	        					 //"../uploadedFiles/FormDocs/"+form20DocsList.get(f).getFormDocName();
	        				
	        		  // String rootPath = System.getProperty("catalina.base");
	        			 File dir = new File(rootPath + File.separator + "webapps" + File.separator
	     						+ "ICADLeagalWebApp"+File.separator + "uploadedFiles"
	    						+ File.separator + "FormDocs");
	        			 
	        			//File newf1=new File(dir.getAbsolutePath() + File.separator + form20DocsList.get(f).getFormDocName());

	        			 //System.out.println("newf1"+newf1);
	        			 
	        			
	        					//form20DocsList.get(f).getFormDocLocation();
	        			 //System.out.println("imageFile0"+imageFile);
	        			 if(ext.equals("pdf")){
	        				 System.out.println("pdf0");
	        			
	        				 PdfPTable doctable = new PdfPTable(2);
	        			   	 
	        				 doctable.setWidthPercentage(100.0f);
	        				 doctable.setWidths(new float[] {10.0f, 10.0f });
	        			       table.setWidths(new float[] { 20.0f});
	        				 doctable.setSpacingBefore(10);
	        				 doctable.setTotalWidth(100.0f);
	        				 doctable.getHorizontalAlignment();
	        				 doctable.completeRow();
	        			      
	        			        
	        			       // table.setSplitRows(true);
	        			        
	        				 doctable.setSpacingAfter(-3);
	        				 doctable.setSplitLate(false);
	        			       
	        				 doctable.setComplete(false);
	        			       
	        				 doctable.setLockedWidth(false);
	        				 doctable.setSkipFirstHeader(false);
	        				 doctable.setSkipLastFooter(true);
	        	  	 	        
	        			       PdfPCell doctablecell = new PdfPCell();
	        			 	      
	        			 	     
	        			 	     
	        			 	  //   nescell.setBorder(0);// for removing lines around cells
	        			       doctablecell.setNoWrap(false);
	        			       doctablecell.setPadding(5);
	        			 	      
	        			       doctablecell.getVerticalAlignment();
	        			 	  
	        			       doctablecell.setPhrase(new Phrase(" Download document   "+form20DocsList.get(f).getFormDocOriginalName(), blackNFont));
	        			       doctable.addCell(doctablecell); 
	        			       
	        			       Document docpdf = new Document(PageSize.A4);
	        			       
	        			       OutputStream fos = new FileOutputStream(newf1);
	        			       PdfWriter pdfwrit=  PdfWriter.getInstance(docpdf, fos);
	        		            docpdf.open();
	        		          
	        		            //docpdf.close();
	        		            //pdfwrit.close();
	        		           
	        			      
	        			      
	        			       doctablecell.setPhrase(new Phrase(imageFile, blackNFont));
	        			       
	        			       
	        			       
	        			       doctable.addCell(doctablecell); 
	        			       doc.add(doctable);   
	        			   
	        			 }
	        			 if(ext.equals("jpg") || ext.equals("png")){
	        				 
	        					//System.out.println("in jpg0");
	        			 Image img = Image.getInstance(imageFile);
	        			 doc.add(img);   
	        			 }}
	        			if(f>1){
	        				
	        				
	        				String ext = FilenameUtils.getExtension(docname);
	        				
	        			docname=docname+","+form20DocsList.get(f).getFormDocOriginalName();
	        			//System.out.println("docname1"+form20DocsList.get(f).getFormDocName());
	        			String imageFile = form20DocsList.get(f).getFormDocLocation();
	        					
	        					//"../uploadedFiles/FormDocs/"+form20DocsList.get(f).getFormDocName();
	        					//form20DocsList.get(f).getFormDocLocation(); 
	        			// System.out.println("imageFile1"+imageFile);
	        			 if(ext.equals("pdf")){
	        				 System.out.println("pdf1"+f);
	        			 PdfWriter pdfwrit = PdfWriter.getInstance(doc, 
	        				        new FileOutputStream(imageFile));
	        			 }
	        			 if(ext.equals("jpg") || ext.equals("png")){
	        				// System.out.println("in jpg1");
	        			Image img = Image.getInstance(imageFile);
	        			 doc.add(img);    
	        			 }
	        			}
	        	
	        		
	        		}
	         
	        		}
	 	   	 	  }
	 	   	 	  else{
	 	   	 		
	 	   	 	 Paragraph msg = new Paragraph("  No images attached  ", blueFont);
 	 			 paragraphOne.setAlignment(Element.ALIGN_CENTER);
 	 			
 	 			 
 	 			    doc.add(msg);
	 	   	 		//System.out.println("No images to display");
	 	   	 	  }
	*/
	 	     onEndPage(writer ,doc);
 
	}
}
