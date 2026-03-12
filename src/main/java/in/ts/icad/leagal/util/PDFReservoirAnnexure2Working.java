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

public class PDFReservoirAnnexure2Working  extends AbstractITextPdfView {
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
		//ReservoirInspect formdata = new ReservoirInspect();
		List<ReservoirInspect> resChecksListpdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resCatListpdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn1mst2pdf = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn1recmmonpdf = new ArrayList<ReservoirInspect>();
		
		
		
		//formdata=(ReservoirInspect) model.get("listform20Tanks");
		
		resChecksListpdf=(List<ReservoirInspect>) model.get("resChecksList");
		resCatListpdf=(List<ReservoirInspect>) model.get("resCatList");
		resAnn1mst2pdf =(List<ReservoirInspect>) model.get("resAnn1mst2info");
		
		resAnn1recmmonpdf =(List<ReservoirInspect>) model.get("resannrecommndList");
		
		
		
	    
	     
		
		Paragraph title = new Paragraph("Annexure II", blacktitle);
		title.setAlignment(Element.ALIGN_CENTER);
		 doc.add(title);
		 
		
		 
		 
	
		 Paragraph heading = new Paragraph(" ", blacktitle);
		
			
			  Chunk textUnderline = new Chunk("INSPECTION OF DAMS AND ANCILLIARY WORKS");
			  textUnderline.setUnderline(0.8f, -3f);
			  heading.add(textUnderline);
			  heading.setAlignment(Element.ALIGN_CENTER);
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
	        	
       PdfPTable table = new PdfPTable(2);
		   	 
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {6.0f, 6.0f });
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
	  	 	        			
	  	 	        		
	  	 	        			
	  	 	        		 cell.setPhrase(new Phrase("Item No. (1). Items of Inspection (2)", blackNFont));
	 		   	 	        table.addCell(cell);
	 		   	 	    doc.add(table);
	 		   	 	    
	 		   	 	cell.setPhrase(new Phrase("Observations and recommendations of the inspecting officer (3)", blackNFont));
		   	 	        table.addCell(cell);
		   	 	    doc.add(table);
	  	 	        			
	  	 	        			
	  	 	        		   int a=resCatListpdf.size();
	  	 	        		   
	  	 	        		 int b=resChecksListpdf.size();
	  	 	        		 
	  	 	        		 int c=resAnn1mst2pdf.size();
	  	 	        		 
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
 	 	        		 
 	 	        		 cell.setPhrase(new Phrase("Item No. (1). Items of Inspection (2)", blackNFont));
	 		   	 	        table.addCell(cell);
	 		   	 	   // doc.add(table);
	 		   	 	    
	 		   	 	cell.setPhrase(new Phrase("Observations and recommendations of the inspecting officer (3)", blackNFont));
		   	 	        table.addCell(cell);
		   	 	    doc.add(table); 
 	 	        		 
 	 	        	 }
 	 	        	
	  	 	  	 	 }
	  	 	  	 	
	  	 	  	 		 
	  	 	  	 		 for(int j=0; j<a ; j++){
	  	 	  	 		 
	  	 	  	 		 Integer maincheckelseId=0;
	  	 	  	 		 
	  	 	  	 		
	  	 	  	 			 
	  	 	  	 			 if((resCatListpdf.get(k).getResCategoryId()==resCatListpdf.get(j).getResParentcatId())    ){
	  	 	  	 		
	  	 	  	 	 if( !(resCatListpdf.get(j).getResCatNumDisplay().equals("0")) ){
	  	 	  	 		 
	  	 	  	 	
		  	 	  	 	 Paragraph paragraphtwo = new Paragraph(resCatListpdf.get(j).getResCatNumDisplay()+" "+resCatListpdf.get(j).getResCategory(), blackFont);
		  			    paragraphtwo.setAlignment(Element.ALIGN_LEFT);
		  				
		  				 
		  				    doc.add(paragraphtwo);
					 	 	   
			        		 
	 	 	        	  }
	 	 	        	  
	 	 	        	 if(resCatListpdf.get(j).getResCatNumDisplay().equals("0")){
	 	 	        		 
	 	 	        		 Paragraph paragraphthree = new Paragraph(resCatListpdf.get(j).getResCategory(), blackFont);
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
		   	 	        		if(!resChecksListpdf.get(m).getResCheckNumDisplay().equals("0")){
		   	 	        			
		   	 	        		//table.getDefaultCell().setColspan(1); ;	//System.out.println ("inside"+resChecksListpdf.get(m).getResCheckNumDisplay());
		   	 	        		cell= new PdfPCell(new Phrase(resChecksListpdf.get(m).getResCheckNumDisplay()+"   "+resChecksListpdf.get(m).getResCheckName() , blackNFont));	
		   	 	              // cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckNumDisplay()+"   "+resChecksListpdf.get(m).getResCheckName() , blackNFont));
		   	 	               cell.setColspan(1);
		   	 	      	 table.addCell(cell);            
		   	 	            
		   	 	          // table.addCell(cell);	
		   	 	           
		   	 	     //  cell.setPhrase(new Phrase("" , blackNFont));
		   	 	    	
		   	 	        		
		   	 		// table.addCell(cell);
		   	 	     

		   	 	
		   	 	        		}else if(resChecksListpdf.get(m).getResCheckNumDisplay().equals("0")  &&  resChecksListpdf.get(m).getIsTitle()==true) {
		   	 	        			
		   	 	        			
		   	 	        		// Paragraph paragraphfr = new Paragraph(resChecksListpdf.get(m).getResCheckName(), blackNFont);
		   	 	        		//paragraphfr.setAlignment(Element.ALIGN_LEFT);
			 		  				
		   	 	        		
			 		  				   // doc.add(paragraphfr);
		   	 	        		//System.out.println ("else"+resChecksListpdf.get(m).getResCheckName());
		   	 	        		//cell.setColspan(2); 
		   	 	        			
		   	 	        		 cell = new PdfPCell(new Phrase(resChecksListpdf.get(m).getResCheckName() , blackNFont));
		                         //	cell.setPhrase(new Phrase(resChecksListpdf.get(m).getResCheckName() , blackNFont));
		   	
		                         	cell.setColspan(2); 
				   	 	              table.addCell(cell); 
					   	 	  
		                       	// table.addCell(cell); 
		                         	 
		                      
		                        	
		   	 	        		}
		   	 	        		
		   	 	        		
		   	 	        		
		   	 	        	//System.out.println("if maincheckelseId"+maincheckelseId);
		   	 	        	
		   	 	        	}
		   	 	        	
		   	 	        
		   	 	     
		   	 	        	
		   	 	        	
		   	 	  if(resAnn1mst2pdf!=null){      	
		   	 	        
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
		        	     
		        	     //System.out.println("resChecksListpdf.get(m).getResCheckId()"+resChecksListpdf.get(m).getResCheckId());
			   	 	      //  System.out.println("resAnn1mst2pdf.get(p).getResCheckId()"+resAnn1mst2pdf.get(p).getResCheckId());
			   	 	        	
			   	 	        if(resChecksListpdf.get(m).getResCheckId().equals(resAnn1mst2pdf.get(p).getResCheckId()) ){
			   	 	        	
			   	 	        //	System.out.println("resChecksListpdf.get(m).getResCheckId()"+resChecksListpdf.get(m).getResCheckId());
			   	 	      //  System.out.println("resAnn1mst2pdf.get(p).getResCheckId()"+resAnn1mst2pdf.get(p).getResCheckId());
			   	 	        
			   	 	       // Paragraph paragraphp = new Paragraph();
			   	 	   // paragraphp.setAlignment(Element.ALIGN_LEFT);
			   	 	        	
			   	 	        
			   	 	        	
			   	 	        	if(maincheckId==0){
			   	 	        		
			   	 	        		//System.out.println(" resAnn1mst2pdf.get(p).getRemarks()"+ resAnn1mst2pdf.get(p).getRemarks());
			   	 	        	
			   	 	        obs.setPhrase(new Phrase(" Field Observations : ", blackFont ));
			   	 	    obstable.addCell(obs);
			   	 	  
			   	 	        obs.setPhrase(new Phrase( resAnn1mst2pdf.get(p).getRemarks(), blackPlane ));
			   	 	  //  obstable.addCell(obs);  
			   	 	   
			   	 	
				   	 	//table.getDefaultCell().setColspan(1);
			   	 	
			   	 	        	}else {
			   	 	        		
			   	 	        	obs.setPhrase(new Phrase("	"+"	", redFont));
			   	 	        		
			   	 	        	}
			   	 	        obstable.addCell(obs);
			   	 	    	
						 //	   cell.addElement(obstable);
						 	//  table.addCell(cell);
			   	 	        	
			   	 	     
						 	   
						 	   if(resAnn1recmmonpdf!=null){
			   	 	        
			   	 	    for(int q=0; q<d; q++){
			   	 	    	
			   	 	    	Integer recChekId=0;
					         
			                // System.out.println("m"+m+"  p"+p);
			       
			        	
				   	 	        	
					   	 	      
				        	     
				        	  
				        	    // System.out.println("beforeresAnn1mst2pdf.get(p).getResInspectMst2Id()"+resAnn1mst2pdf.get(p).getResInspectMst2Id());
				        	   
				        	    // System.out.println("beforeresAnn1recmmonpdf.get(q).getResInspectMst2Id()"+resAnn1recmmonpdf.get(q).getResInspectMst2Id());
					   	 	      //  System.out.println("resAnn1mst2pdf.get(p).getResCheckId()"+resAnn1mst2pdf.get(p).getResCheckId());
					   	 	        	
					   	 	        if((resAnn1mst2pdf.get(p).getResInspectMst2Id().equals(resAnn1recmmonpdf.get(q).getResInspectMst2Id()))	){
					   	 	        	
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
						 
			   	 	        } 
			   	 	 
			   	 	  
			   	 	        
			   	 	    
					 	  
					 	   
					 	   
			   	 	  
			   	 	   
		   	 	   
		   	 	  } // for p loop
	   	 	        //important 1 
               if((mainnoObsCheckId==0) && (mainnoObsCheckId!=resChecksListpdf.get(m).getResCheckId()) ){
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
	  	 	  	 
	 	  
	 	    //  doc.newPage(); //shows table in new page
	 	        
	 	      
	 	        
	 	      
	 	     i++;
	 	    doc.newPage();
	 	   
	        		
	        		}
	         
	        		
	 	   	 	  
	 	   	 
	
	 	     onEndPage(writer ,doc);
 
	}

}
