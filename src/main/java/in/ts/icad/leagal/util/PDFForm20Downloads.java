package in.ts.icad.leagal.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
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
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankformData;

public class PDFForm20Downloads extends AbstractITextPdfView {
	
	
	 
	   
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
	
		List<MiTankFormDocs> form20DocsList = new ArrayList<MiTankFormDocs>();
		
		formdata=(MiTankformData) model.get("listform20Tanks");
		
		//formDetailList=(List<MiTankformData>) model.get("listform20Detail");
		form20DocsList=(List<MiTankFormDocs>) model.get("form20DocsList");
	
	    
	     
		
		Paragraph title = new Paragraph("T.S.F.C. FormNo.20", blacktitle);
		title.setAlignment(Element.ALIGN_CENTER);
		 doc.add(title);
		 
		 Paragraph TankNameID = new Paragraph(formdata.getTankName()+"    GeoId:  "+formdata.getTankGeoId(), blackHeading);
		 TankNameID.setAlignment(Element.ALIGN_CENTER);
			
			 
			    doc.add(TankNameID);
		 
		
		 
		     
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
    

       String docname=null;
       
       String photoOriginalName=null;
       
  	 /*doc.newPage();*/  // commeted as table is displayed in new page--15/dec/2021 sowjanya
	       
	       // for (int m=0; m<j ; m++){
	        	
     /*  PdfPTable table = new PdfPTable(2);
		   	 
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {6.0f, 6.0f, });
	       table.setWidths(new float[] { 20.0f});
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
      
      PdfPCell contact = new PdfPCell();
     
      cell.setBorder(0);// for removing lines around cells
       cell.setNoWrap(false);
       cell.setPadding(5);
      
     cell.getVerticalAlignment();*/
	  	 	        		
	  	 	        		//System.out.println("doc"+docname);
	  	 	        		if(formdata.getTankId()>0 &&formdata.getMandalId()>0 && formdata.getDistrictId()>0){
  	 	        		
	  	 	        		
	 	        
	  	 	        		 int e=form20DocsList.size();
	  	 	 	 	   ///  System.out.println("e"+e);
	  	 	  	 		      
	  	 	 	 	   	 	  if(e>0){
	  	 	 	 	   	 		
	  	 	 	 	 	       
	  	 	 	        		for(int f=0; f<e ; f++){
	  	 	 	        		if(formdata.getFormDataId()==form20DocsList.get(f).getFormDataId())	{	
	  	 	 	        			
	  	 	 	        			
	  	 	 	        			if(f==0){
	  	 	 	        				
	  	 	 	        			docname=form20DocsList.get(f).getFormDocName();
	  	 	 	        					
	  	 	 	        	/*	photoOriginalName= form20DocsList.get(f).getFormDocOriginalName();
	  	 	 	        		
	  	 	 	        	 Paragraph photoName = new Paragraph(photoOriginalName, blackHeading);
	  	 	 	        	photoName.setAlignment(Element.ALIGN_CENTER);*/
	  	 	 				
	  	 	 				 
	  	 	 				   // doc.add(photoName);
	  	 	 	        			
	  	 	 	        			String extone = FilenameUtils.getExtension(docname);
	  	 	 	        			//System.out.println("docname0"+docname +"----"+ext);
	  	 	 	        			// Creating an ImageData object 
	  	 	 	        			 String imageFile0 = form20DocsList.get(f).getFormDocLocation();
	  	 	 	        					 
	  	 	 	        					
	  	 	 	        			 
	  	 	 	        			 if(extone.equals("jpg") || extone.equals("png") || extone.equals("jpeg") ){
	  	 	 	        				 
	  	 	 	        					//System.out.println("in jpg0"+ext);
	  	 	 	        			 Image img0 = Image.getInstance(imageFile0);
	  	 	 	        			 doc.add(img0);   
	  	 	 	        			 }}
	  	 	 	        			if(f>=1){
	  	 	 	        				
	  	 	 	        				
	  	 	 	        		
	  	 	 	        				
	  	 	 	        			docname=form20DocsList.get(f).getFormDocName();
	  	 	 	        			
	  	 	 	        		/*photoOriginalName= form20DocsList.get(f).getFormDocOriginalName();
	  	 	 	        		
		  	 	 	        	 Paragraph photoNamenew = new Paragraph(photoOriginalName, blackHeading);
		  	 	 	        	photoNamenew.setAlignment(Element.ALIGN_CENTER);
		  	 	 				*/
		  	 	 				 
		  	 	 				   // doc.add(photoNamenew);
	  	 	 	        			
	  	 	 	        		//form20DocsList.get(f).getFormDocOriginalName()
	  	 	 	        					
	  	 	 	        					//docname+","+
	  	 	 	        		String exttwo = FilenameUtils.getExtension(docname);
	  	 	 	        			//System.out.println("docname1"+form20DocsList.get(f).getFormDocName());
	  	 	 	        			String imageFile1 = form20DocsList.get(f).getFormDocLocation();
	  	 	 	        					
	  	 	 	        					
	  	 	 	        				
	  	 	 	        			 if(exttwo.equals("jpg") || exttwo.equals("png") || exttwo.equals("jpeg")){
	  	 	 	        			//	 System.out.println(f+"in jpg1-----"+ext+ "imageFile" +imageFile +"---"+docname);
	  	 	 	        			Image img1 =Image.getInstance(imageFile1);
	  	 	 	        			 doc.add(img1);    
	  	 	 	        			 }
	  	 	 	        			}
	  	 	 	        	
	  	 	 	        		
	  	 	 	        		}
	  	 	 	         
	  	 	 	        		}
	  	 	 	 	   	 	  }
	  	 	 	 	   	 	  else{
	  	 	 	 	   	 		
	  	 	 	 	   	 	 Paragraph msg = new Paragraph("  No images attached  ", blueFont);
	  	 	  	 		
	  	 	  	 			
	  	 	  	 			 
	  	 	  	 			    doc.add(msg);
	  	 	 	 	   	 		//System.out.println("No images to display");
	  	 	 	 	   	 	  }
	  	 	 	
	
	 	        
	 	       
		 	      
		 	     
		 	     
		 	
		 	      
	 	     
	 	
	  	 	        		}
	 	
	 	     
	 	    
	 	     i++;
	 	    doc.newPage();
	 	   
	 	      
	 	     onEndPage(writer ,doc);
 
	}
}
