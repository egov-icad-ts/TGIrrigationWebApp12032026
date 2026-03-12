package in.ts.icad.leagal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.manager.LeagalReportManager;
import in.ts.icad.leagal.manager.LeagalWebManager;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.CasesGeneral;
import in.ts.icad.leagal.model.Courts;
import in.ts.icad.leagal.model.Petitioner;
import in.ts.icad.leagal.model.PetitionerAdvocate;
import in.ts.icad.leagal.model.abstractCounterData;


@Controller
public class LeagalReportController {
	@Autowired
	LeagalWebManager leagalWebManager;
	
	@Autowired
	LeagalReportManager leagalReportManager;
	
	@Autowired
	LeagalAdminManager leagalAdminManager;
	
	

	
	
	@RequestMapping(value = "/webReports/casesview")
	@ResponseBody
	public ModelAndView Casesview(@ModelAttribute("casesview") Cases caseview,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("casesview");
		List<Courts> courtList = new ArrayList<Courts>();
		List<Cases>   caseList = new ArrayList<Cases>();
		
		courtList = leagalReportManager.setCourts();
		
		List<CasesGeneral> caseGenralList = new ArrayList<CasesGeneral>();
		
		caseGenralList=leagalAdminManager.getCaseGeneralList();
		
		 mav.addObject("courtList",courtList);
		 
		
		mav.addObject("caseGenList",caseGenralList);
		Integer 		courtId=0;
		
		Integer caseGenType=0;
		
		if(caseview.getCourtId()!=null){
			
			courtId = caseview.getCourtId();
			
			
		}
		
		if(caseview.getCaseGenId()!=null){
			
			caseGenType=caseview.getCaseGenId();
			
		}
		
		//System.out.println("courtId"+courtId);
		//System.out.println("caseGenType"+caseGenType);
		
if(courtId>0 && caseGenType ==0){
			
			caseList=leagalReportManager.getcasesCourt(courtId);
			
			mav.addObject("caseList",caseList);
			
			//System.out.println("caseList"+caseList);
			
		}

     
		
		if(courtId>0 && caseGenType >0){
			
			caseList=leagalReportManager.getcasesGenCourt(courtId, caseGenType);
			
			mav.addObject("caseList",caseList);
			
			//System.out.println("caseList"+caseList);
			
		}
		
		
		      if(caseGenType ==0 && courtId==-1  ){
				
				caseList=leagalReportManager.getcasesGenAll();
				
				mav.addObject("caseList",caseList);
				
				//System.out.println("caseList"+caseList);
				
			      }
		      
		      
		      if(caseGenType >0  && courtId==0  ){
					
					caseList=leagalReportManager.getcasesGen(caseGenType);
					
					mav.addObject("caseList",caseList);
					
					//System.out.println("caseList"+caseList);
					
				      }
		      
		      if(caseGenType >0  && courtId==-1  ){
					
					caseList=leagalReportManager.getcasesGen(caseGenType);
					
					mav.addObject("caseList",caseList);
					
					//System.out.println("caseList"+caseList);
					
				      }
			      
		      mav.addObject("courtList",courtList);
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/webReports/abstractCounterFiles")
	@ResponseBody
	public ModelAndView AbstractCounter( @ModelAttribute("abstract") Cases caseabstract,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("abstractCounterFileData");
		List<CasesGeneral> caseGenralList = new ArrayList<CasesGeneral>();
		List<Courts> courtList = new ArrayList<Courts>();
		
		caseGenralList=leagalAdminManager.getCaseGeneralList();
		 courtList=leagalReportManager.setCourts();
		 mav.addObject("courtList",courtList);
		 
		
		mav.addObject("caseGenList",caseGenralList);
		
		List<abstractCounterData> counterDataAll = new ArrayList<abstractCounterData>();
		List<abstractCounterData> counterDataGen = new ArrayList<abstractCounterData>();
		List<abstractCounterData> counterDataCourtGen = new ArrayList<abstractCounterData>();
		List<abstractCounterData> counterDataCourt = new ArrayList<abstractCounterData>();
		List<abstractCounterData> counterDataAllGen = new ArrayList<abstractCounterData>();
		
		
		
		//System.out.println("caseGenId"+caseGenId);
		/*if(caseGenId!=null){
		if(caseGenId>0){
			
			counterData = leagalReportManager.getCounterFileData(caseGenId);
			
			mav.addObject("counterData",counterData);
			
		}
		}*/
		
		
Integer 		courtId=0;
		
		Integer caseGenId=0;
		
		Integer courtCF=0;
		Integer courtDF=0;
		Integer courtCountF=0;
		Integer courtCountNF=0;
		Integer courtJF=0;
		
		Integer courtGenCF=0;
		Integer courtGenDF=0;
		Integer courtGenCountF=0;
		Integer courtGenCountNF=0;
		Integer courtGenJF=0;
		
		
		Integer GenCF=0;
		Integer GenDF=0;
		Integer GenCountF=0;
		Integer GenCountNF=0;
		Integer GenJF=0;
		
		
		Integer AllCF=0;
		Integer AllDF=0;
		Integer AllCountF=0;
		Integer AllNF=0;
		Integer AllJF=0;
		
		
		Integer AllGenCF=0;
		Integer AllGenDF=0;
		Integer AllGenCountF=0;
		Integer AllGenCountNF=0;
		Integer AllGenJF=0;
		
		
		
		if(caseabstract.getCourtId()!=null){
			
			courtId = caseabstract.getCourtId();
			
			
		}
		
		if(caseabstract.getCaseGenId()!=null){
			
			caseGenId=caseabstract.getCaseGenId();
			
		}
		
		//System.out.println("courtId"+courtId);
		//System.out.println("caseGenId"+caseGenId);
		
if(courtId>0 && caseGenId ==0){
			
	counterDataCourt=leagalReportManager.getabstractcountCourt(courtId);
	
	Integer len =counterDataCourt.size();
	if(len>0){
		
		for (int i = 0; i < len ; i++) {
			
			 courtCF=courtCF+counterDataCourt.get(i).getCasesFiled();
			 courtDF=courtDF+counterDataCourt.get(i).getDraftCountFile();
			 courtCountF=courtCountF+counterDataCourt.get(i).getCounterFiled();
			 courtJF=courtJF+counterDataCourt.get(i).getCasesJudged();
			 courtCountNF=courtCountNF+counterDataCourt.get(i).getCasesToFile();
		
	}
		
		
		mav.addObject("courtCF",courtCF);
		mav.addObject("courtDF",courtDF);
		mav.addObject("courtCountF",courtCountF);
		mav.addObject("courtJF",courtJF);
		mav.addObject("courtCountNF",courtCountNF);
		
		if(courtId==counterDataCourt.get(0).getCourtId()){
			
			String court=counterDataCourt.get(0).getCourtName();
			String category="NA";
			
			mav.addObject("court",court);
			mav.addObject("category",category);
			
		}
		
	}
	
			mav.addObject("selectedCourt",courtId);
			mav.addObject("selectedCategory",caseGenId);
			
			mav.addObject("counterDataCourt",counterDataCourt);
			
			//System.out.println("caseList"+caseList);
			
		}

     
		
		if(courtId>0 && caseGenId >0){
			
			counterDataCourtGen=leagalReportManager.getabstractcountGenCourt(caseGenId, courtId);
			
			mav.addObject("counterDataCourtGen",counterDataCourtGen);
			
			mav.addObject("selectedCourt",courtId);
			mav.addObject("selectedCategory",caseGenId);
			
			//System.out.println("caseList"+caseList);
			
			Integer len =counterDataCourtGen.size();
			if(len>0){
				
				for (int i = 0; i < len ; i++) {
					
					courtGenCF=courtGenCF+counterDataCourtGen.get(i).getCasesFiled();
					courtGenDF=courtGenDF+counterDataCourtGen.get(i).getDraftCountFile();
					courtGenCountF=courtGenCountF+counterDataCourtGen.get(i).getCounterFiled();
					courtGenJF=courtGenJF+counterDataCourtGen.get(i).getCasesJudged();
					courtGenCountNF=courtGenCountNF+counterDataCourtGen.get(i).getCasesToFile();
				
			}
				
				mav.addObject("courtGenCF",courtGenCF);
				mav.addObject("courtGenDF",courtGenDF);
				mav.addObject("courtGenCountF",courtGenCountF);
				mav.addObject("courtGenJF",courtGenJF);
				mav.addObject("courtGenCountNF",courtGenCountNF);
				
				if(courtId==counterDataCourtGen.get(0).getCourtId() &&  caseGenId==counterDataCourtGen.get(0).getCaseGenId() ){
					
					String court=counterDataCourtGen.get(0).getCourtName();
					String category=counterDataCourtGen.get(0).getCategoryName();
					
					mav.addObject("court",court);
					mav.addObject("category",category);
					
				}
				
			}
			
		}
		
		
		      if(caseGenId ==0 && courtId==-1  ){
				
		    	  counterDataAll=leagalReportManager.getabstractcountGenAll();
				
				mav.addObject("counterDataAll",counterDataAll);
				mav.addObject("selectedCourt",courtId);
				mav.addObject("selectedCategory",caseGenId);
				
				
				Integer len =counterDataAll.size();
				if(len>0){
					
					for (int i = 0; i < len ; i++) {
						
						AllCF=AllCF+counterDataAll.get(i).getCasesFiled();
						AllDF=AllDF+counterDataAll.get(i).getDraftCountFile();
						AllCountF=AllCountF+counterDataAll.get(i).getCounterFiled();
						AllJF=AllJF+counterDataAll.get(i).getCasesJudged();
						AllNF=AllNF+counterDataAll.get(i).getCasesToFile();
					
				}
					
					mav.addObject("AllCF",AllCF);
					mav.addObject("AllDF",AllDF);
					mav.addObject("AllCountF",AllCountF);
					mav.addObject("AllNF",AllNF);
					mav.addObject("AllJF",AllJF);
					
				}
				
				//System.out.println("counterDataAll"+counterDataAll);
				
				

					
					String court="All Cases";
					String category="NA";
					
					mav.addObject("court",court);
					mav.addObject("category",category);
					
				
				
			      }
		      
		      
		      if(caseGenId >0  && courtId==0  ){
		    	  
		    	  mav.addObject("selectedCourt",courtId);
					mav.addObject("selectedCategory",caseGenId);
					
		    	  counterDataGen=leagalReportManager.getabstractcountGen(caseGenId);
					
					mav.addObject("counterDataGen",counterDataGen);
					
					Integer len =counterDataGen.size();
					if(len>0){
						
						for (int i = 0; i < len ; i++) {
							
							GenCF=GenCF+counterDataGen.get(i).getCasesFiled();
							GenDF=GenDF+counterDataGen.get(i).getDraftCountFile();
							GenCountF=GenCountF+counterDataGen.get(i).getCounterFiled();
							GenJF=GenJF+counterDataGen.get(i).getCasesJudged();
							GenCountNF=GenCountNF+counterDataGen.get(i).getCasesToFile();
						
					}
						
						mav.addObject("GenCF",GenCF);
						mav.addObject("GenDF",GenDF);
						mav.addObject("GenCountF",GenCountF);
						mav.addObject("GenCountNF",GenCountNF);
						mav.addObject("GenJF",GenJF);
						
						
						if(  caseGenId==counterDataGen.get(0).getCaseGenId() ){
							
							String court="NA";
							String category=counterDataGen.get(0).getCategoryName();
							
							mav.addObject("court",court);
							mav.addObject("category",category);
							
						}
						
					}
					
					//System.out.println("caseList"+caseList);
					
				      }
		      
		      if(caseGenId >0  && courtId==-1  ){
		    	  
		    	  mav.addObject("selectedCourt",courtId);
					mav.addObject("selectedCategory",caseGenId);
					
		    	  counterDataAllGen=leagalReportManager.getabstractcountGen(caseGenId);
					
					mav.addObject("counterDataAllGen",counterDataAllGen);
					
					Integer len =counterDataAllGen.size();
					if(len>0){
						
						for (int i = 0; i < len ; i++) {
							
							AllGenCF=AllGenCF+counterDataAllGen.get(i).getCasesFiled();
							AllGenDF=AllGenDF+counterDataAllGen.get(i).getDraftCountFile();
							AllGenCountF=AllGenCountF+counterDataAllGen.get(i).getCounterFiled();
							AllGenJF=AllGenJF+counterDataAllGen.get(i).getCasesJudged();
							AllGenCountNF=AllGenCountNF+counterDataAllGen.get(i).getCasesToFile();
						
					}
						
						mav.addObject("AllGenCF",AllGenCF);
						mav.addObject("AllGenDF",AllGenDF);
						mav.addObject("AllGenCountF",AllGenCountF);
						mav.addObject("AllGenCountNF",AllGenCountNF);
						mav.addObject("AllGenJF",AllGenJF);
						
						
                        if(  caseGenId==counterDataAllGen.get(0).getCaseGenId() ){
							
							String court="All Cases";
							String category=counterDataAllGen.get(0).getCategoryName();
							
							mav.addObject("court",court);
							mav.addObject("category",category);
							
						}
						
					}
					
					//System.out.println("caseList"+caseList);
					
				      }
		
		return mav;
	}
	
	@RequestMapping(value = "/webReports/caseDetails")
	@ResponseBody
	public ModelAndView CaseDetails( Integer unitId, String filingDate, String counterDate,String judgementDate,String  draftdateconttoGP, String casesToFile, Integer caseGenId,Integer courtId,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("caseDetails");
		
		List<Cases> caseDetail = new ArrayList<Cases>();
	//	List<Cases> caseDetailAll = new ArrayList<Cases>();
	//	List<Cases> caseDetailCourt = new ArrayList<Cases>();
	//	List<Cases> caseDetailCourtGen = new ArrayList<Cases>();
		
		
	// start of unit all cases
		
		if(unitId!=null  && caseGenId==null &&  filingDate!=null && courtId==null){
			//System.out.println("coming here");
		if((unitId>0 )  && (filingDate.equals("1"))    ){
			//System.out.println(" not coming here");
			
			caseDetail = leagalReportManager.getcasesAbstractcasefiled(unitId);
			
	//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		if(unitId!=null  && caseGenId==null && judgementDate!=null && courtId==null ){
		if(unitId>0  && judgementDate.equals("5")){
			
			caseDetail = leagalReportManager.getcasesAbstractjudgefiled(unitId);
				
				mav.addObject("caseDetail",caseDetail);
				
			}
		}
		if(unitId!=null && caseGenId==null && casesToFile!=null && courtId==null ){		
if(unitId>0   && casesToFile.equals("4")){
			
	caseDetail = leagalReportManager.getcasesAbstractcounternotfiled(unitId);
				
				mav.addObject("caseDetail",caseDetail);
				
			}
		}
		if(unitId!=null  && caseGenId==null && counterDate!=null && courtId==null){			
if(unitId>0  && counterDate.equals("3")){
			
	caseDetail = leagalReportManager.getcasesAbstractcounterfiled(unitId);
				
				mav.addObject("caseDetail",caseDetail);
				
			}
		}

		if(unitId!=null && caseGenId==null && draftdateconttoGP!=null && courtId==null){	
if(unitId>0   && draftdateconttoGP.equals("2")){
	
	caseDetail = leagalReportManager.getcasesAbstractdraftfiled(unitId);
		
		mav.addObject("caseDetail",caseDetail);
		
	}
		}
		
		
		
		
		
		
		///start of Genreal case	
		
		//System.out.println("caseGenId"+caseGenId+"filingDate"+filingDate);
		if(unitId!=null  && caseGenId!=null &&  filingDate!=null && courtId==null){
			//System.out.println("coming here");
		if((unitId>0 ) && caseGenId>0 && (filingDate.equals("1"))    ){
			//System.out.println(" not coming here");
			
			caseDetail = leagalReportManager.getcasesfiled(unitId,caseGenId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		if(unitId!=null  && caseGenId!=null && judgementDate!=null && courtId==null ){
		if(unitId>0 && caseGenId>0 && judgementDate.equals("5")){
			
			caseDetail = leagalReportManager.getcasesjudgefiled(unitId,caseGenId);
				
				mav.addObject("caseDetail",caseDetail);
				
			}
		}
		if(unitId!=null && caseGenId!=null && casesToFile!=null && courtId==null ){		
if(unitId>0  && caseGenId>0 && casesToFile.equals("4")){
			
	caseDetail = leagalReportManager.getcasescounternotfiled(unitId,caseGenId);
				
				mav.addObject("caseDetail",caseDetail);
				
			}
		}
		if(unitId!=null  && caseGenId!=null && counterDate!=null && courtId==null){			
if(unitId>0 && caseGenId>0 && counterDate.equals("3")){
			
	caseDetail = leagalReportManager.getcasesCounterfiled(unitId,caseGenId);
				
				mav.addObject("caseDetail",caseDetail);
				
			}
		}

		if(unitId!=null && caseGenId!=null && draftdateconttoGP!=null && courtId==null){	
if(unitId>0  && caseGenId>0 && draftdateconttoGP.equals("2")){
	
	caseDetail = leagalReportManager.getcasesdraftfiled(unitId,caseGenId);
		
		mav.addObject("caseDetail",caseDetail);
		
	}
		}
		
// start of court and General cases 
		
		
		
		if(unitId!=null  && caseGenId!=null &&  filingDate!=null && courtId!=null){
			//System.out.println("coming here");
		if((unitId>0 ) && (caseGenId>0) && courtId>0  && (filingDate.equals("1"))    ){
			//System.out.println(" not coming here");
			
			caseDetail = leagalReportManager.getcasesAbstractGenCourtcasefiled(unitId, courtId, caseGenId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		if(unitId!=null  && caseGenId!=null && judgementDate!=null && courtId!=null ){
		if(unitId>0 && caseGenId>0 && courtId>0   && judgementDate.equals("5")){
			
			caseDetail = leagalReportManager.getcasesAbstractGenCourtjudgefiled(unitId, courtId, caseGenId);
				
				mav.addObject("caseDetail",caseDetail);
				
			}
		}
		if(unitId!=null && caseGenId!=null && casesToFile!=null && courtId!=null ){		
if(unitId>0  && caseGenId>0  && courtId>0  && casesToFile.equals("4")){
			
	caseDetail = leagalReportManager.getcasesAbstractGenCourtcounternotfiled(unitId, courtId, caseGenId);
				
				mav.addObject("caseDetail",caseDetail);
				
			}
		}
		if(unitId!=null  && caseGenId!=null && counterDate!=null && courtId!=null){			
if(unitId>0 && caseGenId>0 && courtId>0  && counterDate.equals("3")){
			
	caseDetail = leagalReportManager.getcasesAbstractGenCourtcounterfiled(unitId, courtId, caseGenId);
				
				mav.addObject("caseDetail",caseDetail);
				
			}
		}

		if(unitId!=null && caseGenId!=null && draftdateconttoGP!=null && courtId!=null){	
if(unitId>0  && caseGenId>0 && courtId>0  && draftdateconttoGP.equals("2")){
	
	caseDetail = leagalReportManager.getcasesAbstractGenCourtdraftfiled(unitId, courtId, caseGenId);
		
		mav.addObject("caseDetail",caseDetail);
		
	}
		}
		
		
		// start of court cases
		
				if(unitId!=null  && caseGenId==null &&  filingDate!=null && courtId!=null){
					//System.out.println("coming here");
				if((unitId>0 ) && courtId>0  && (filingDate.equals("1"))    ){
					//System.out.println(" not coming here");
					
					caseDetail = leagalReportManager.getcasesAbstractcourtcasefiled(unitId, courtId);
					
				//System.out.println("caseDetail"+caseDetail);
					mav.addObject("caseDetail",caseDetail);
					
				}
				}
				if(unitId!=null  && caseGenId==null && judgementDate!=null && courtId!=null ){
				if(unitId>0   && courtId>0  && judgementDate.equals("5")){
					
					caseDetail = leagalReportManager.getcasesAbstractcourtjudgefiled(unitId, courtId);
						
						mav.addObject("caseDetail",caseDetail);
						
					}
				}
				if(unitId!=null && caseGenId==null && casesToFile!=null && courtId!=null ){		
		if(unitId>0   && courtId>0  && casesToFile.equals("4")){
					
			caseDetail = leagalReportManager.getcasesAbstractcourtcounternotfiled(unitId, courtId);
						
						mav.addObject("caseDetail",caseDetail);
						
					}
				}
				if(unitId!=null  && caseGenId==null && counterDate!=null && courtId!=null){			
		if(unitId>0   && courtId>0  && counterDate.equals("3")){
					
			caseDetail = leagalReportManager.getcasesAbstractcourtcounterfiled(unitId, courtId);
						
						mav.addObject("caseDetail",caseDetail);
						
					}
				}

				if(unitId!=null && caseGenId==null && draftdateconttoGP!=null && courtId!=null){	
		if(unitId>0  && courtId>0   && draftdateconttoGP.equals("2")){
			
			caseDetail = leagalReportManager.getcasesAbstractcourtdraftfiled(unitId, courtId);
				
				mav.addObject("caseDetail",caseDetail);
				
			}
				}
				
		
		return mav;
	}
	
	
	@RequestMapping(value = "/webReports/EPFileStatus")
	@ResponseBody
	public ModelAndView EPFileStatus( Integer courtId,Integer caseTypeId,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("abstractEPdata");
		List<Courts> courtList = new ArrayList<Courts>();
	
		 courtList=leagalReportManager.setCourts();
		 
			mav.addObject("courtList",courtList);
		
		List<abstractCounterData> counterEPData = new ArrayList<abstractCounterData>();
		
		Integer courtTypeCF=0;
		Integer courtTypeDF=0;
		Integer courtTypeCountF=0;
		Integer courtTypeCountNF=0;
		Integer courtTypeJF=0;
		
		//System.out.println("caseGenId"+caseGenId);
		if(courtId!=null && caseTypeId!=null){
		if(courtId>0 && caseTypeId>0){
			
			
			counterEPData = leagalReportManager.getCountEPdata(courtId, caseTypeId);
			
			mav.addObject("counterData",counterEPData);
			
			mav.addObject("selectedCourt",courtId);
			mav.addObject("selectedCaseType",caseTypeId);
			
			Integer len =counterEPData.size();
			if(len>0){
				
				for (int i = 0; i < len ; i++) {
					
					courtTypeCF=courtTypeCF+counterEPData.get(i).getCasesFiled();
					courtTypeDF=courtTypeDF+counterEPData.get(i).getDraftCountFile();
					courtTypeCountF=courtTypeCountF+counterEPData.get(i).getCounterFiled();
					courtTypeJF=courtTypeJF+counterEPData.get(i).getCasesJudged();
					courtTypeCountNF=courtTypeCountNF+counterEPData.get(i).getCasesToFile();
				
			}
				
				mav.addObject("courtTypeCF",courtTypeCF);
				mav.addObject("courtTypeDF",courtTypeDF);
				mav.addObject("courtTypeCountF",courtTypeCountF);
				mav.addObject("courtTypeJF",courtTypeJF);
				mav.addObject("courtTypeCountNF",courtTypeCountNF);
				
				 if(  courtId==counterEPData.get(0).getCourtId() && caseTypeId==counterEPData.get(0).getCaseTypeId() ){
						
						String court=counterEPData.get(0).getCourtName();
						String caseType=counterEPData.get(0).getCaseType();
						
						//System.out.println("court"+court);
						//System.out.println("caseType"+caseType);
						
						mav.addObject("court",court);
						mav.addObject("caseType",caseType);
						
					}
				
			}
			
			
		}
		}
		
		return mav;
	}
	
	
	@RequestMapping(value = "/webReports/petAdvDetails")
	@ResponseBody
	public ModelAndView CasePetAdvDetails( Integer unitId, String filingDate, String counterDate,String judgementDate,String  draftdateconttoGP, String casesToFile, Integer advocateId,Integer courtId,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("petAdvDetails");
		
		List<Cases> caseDetail = new ArrayList<Cases>();
		
		//System.out.println("caseGenId"+advocateId+"filingDate"+filingDate);
		
		if(unitId!=null  && advocateId!=null &&  filingDate!=null && courtId==null){
			//System.out.println("coming here");
		if((unitId>0 )  && (Integer.parseInt(filingDate)>0) && (advocateId>0)  ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractAllPetAdvAll(unitId, Integer.parseInt(filingDate), advocateId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		if(unitId!=null  && advocateId!=null &&  filingDate!=null && courtId!=null){
			//System.out.println("coming here");
		if((unitId>0 )  && (Integer.parseInt(filingDate)>0) && (advocateId>0)  && courtId>0  ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractCourtPetAdvCourt(unitId, courtId, Integer.parseInt(filingDate), advocateId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		
		
		return mav;
	}
	
	@RequestMapping(value = "/webReports/PetAdvStatus")
	@ResponseBody
	public ModelAndView PetAdveStatus( Integer courtId,Integer advocateId,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("abstractPetAdvdata");
		List<Courts> courtList = new ArrayList<Courts>();
	
		 courtList=leagalReportManager.setCourts();
		 
			mav.addObject("courtList",courtList);
			List<PetitionerAdvocate> petitionerAdvList = new ArrayList<PetitionerAdvocate>();
			
			
			
			 petitionerAdvList=leagalAdminManager.getPetitionerAdvocatebyCountList();
			 
			 mav.addObject("petAdvList",petitionerAdvList);
		
		List<abstractCounterData> petadvData = new ArrayList<abstractCounterData>();
		
		Integer petAdvCF=0;
		Integer petAdvDF=0;
		Integer petAdvCountF=0;
		Integer  petAdvCountNF=0;
		Integer  petAdvJF=0;
		
		//System.out.println("caseGenId"+caseGenId);
		if(courtId!=null && advocateId!=null){
			
			
			if(courtId==-1 && advocateId>0){
				
				petadvData = leagalReportManager.getabstractPetAdvAll(advocateId);
				
				mav.addObject("petadvData",petadvData);
				
				mav.addObject("selectedCourt",courtId);
				mav.addObject("selectedAdvocate",advocateId);
				if(petadvData!=null){
				Integer len =petadvData.size();
				if(len>0){
					
					for (int i = 0; i < len ; i++) {
						
						petAdvCF=petAdvCF+petadvData.get(i).getCasesFiled();
						petAdvDF=petAdvDF+petadvData.get(i).getDraftCountFile();
						petAdvCountF=petAdvCountF+petadvData.get(i).getCounterFiled();
						petAdvJF=petAdvJF+petadvData.get(i).getCasesJudged();
						petAdvCountNF=petAdvCountNF+petadvData.get(i).getCasesToFile();
					
				}
					
					mav.addObject("petAdvCF",petAdvCF);
					mav.addObject("petAdvDF",petAdvDF);
					mav.addObject("petAdvCountF",petAdvCountF);
					mav.addObject("petAdvJF",petAdvJF);
					mav.addObject("petAdvCountNF",petAdvCountNF);
					
				 if(  courtId==-1 && advocateId==petadvData.get(0).getAdvocateId() ){
							
							String court=petadvData.get(0).getCourtName();
							String advocateName=petadvData.get(0).getAdvocateName();
							
							//System.out.println("court"+court);
							//System.out.println("caseType"+caseType);
							
							mav.addObject("court","All Cases");
							mav.addObject("advocateName",advocateName);
							
						}
					
				}
				}
				
				
			}
			
			
			
			
			
			
		if(courtId>0 && advocateId>0){
			
			petadvData = leagalReportManager.getabstractPetAdvCourt(advocateId, courtId);
			
			mav.addObject("petadvData",petadvData);
			
			mav.addObject("selectedCourt",courtId);
			mav.addObject("selectedAdvocate",advocateId);
			if(petadvData!=null){
			Integer len =petadvData.size();
			if(len>0){
				
				for (int i = 0; i < len ; i++) {
					
					petAdvCF=petAdvCF+petadvData.get(i).getCasesFiled();
					petAdvDF=petAdvDF+petadvData.get(i).getDraftCountFile();
					petAdvCountF=petAdvCountF+petadvData.get(i).getCounterFiled();
					petAdvJF=petAdvJF+petadvData.get(i).getCasesJudged();
					petAdvCountNF=petAdvCountNF+petadvData.get(i).getCasesToFile();
				
			}
				
				mav.addObject("petAdvCF",petAdvCF);
				mav.addObject("petAdvDF",petAdvDF);
				mav.addObject("petAdvCountF",petAdvCountF);
				mav.addObject("petAdvJF",petAdvJF);
				mav.addObject("petAdvCountNF",petAdvCountNF);
				
			 if(  courtId==petadvData.get(0).getCourtId() && advocateId==petadvData.get(0).getAdvocateId() ){
						
						String court=petadvData.get(0).getCourtName();
						String advocateName=petadvData.get(0).getAdvocateName();
						
						//System.out.println("court"+court);
						//System.out.println("caseType"+caseType);
						
						mav.addObject("court",court);
						mav.addObject("advocateName",advocateName);
						
					}
				
			}
			
			}	
		}
		}
		
		return mav;
	}
	
	
	@RequestMapping(value = "/webReports/caseEPDetails")
	@ResponseBody
	public ModelAndView CaseEPDetails( Integer unitId, String filingDate, Integer caseTypeId,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("caseTypeDetails");
		
		List<Cases> caseDetail = new ArrayList<Cases>();
		/*
		Integer unitId=0;
		Integer caseTypeId=0;
		
		String filingDate=null;
		
		System.out.println("caseGenId"+caseEPabstract.getUnitId()+"filingDate"+filingDate+"--"+caseEPabstract.getCaseTypeId());
		
		if(caseEPabstract!=null){
			unitId=caseEPabstract.getUnitId();
			caseTypeId=caseEPabstract.getCaseTypeId();
			filingDate=caseEPabstract.getFilingDate();
			
			
		}
		*/
		//System.out.println("caseGenId"+caseGenId+"filingDate"+filingDate);
		if(unitId!=null  && caseTypeId!=null &&  filingDate!=null){
			//System.out.println("coming here");
		if((unitId>0 )  && (Integer.parseInt(filingDate)>0) && (caseTypeId>0)   ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getEPcasesfiled(unitId,caseTypeId,Integer.parseInt(filingDate));
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		
		
		return mav;
	}
	
	
	@RequestMapping(value = "/webReports/PetStatus")
	@ResponseBody
	public ModelAndView PetStatus( Integer courtId,Integer petitionerId,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("petStatus");
		List<Courts> courtList = new ArrayList<Courts>();
	
		 courtList=leagalReportManager.setCourts();
		 
			mav.addObject("courtList",courtList);
			List<Petitioner> petitionerList = new ArrayList<Petitioner>();
			
			
			
			petitionerList=leagalAdminManager.getPetitionerbyCountList();
			 
			 mav.addObject("petList",petitionerList);
		
		List<abstractCounterData> petData = new ArrayList<abstractCounterData>();
		
		Integer petCF=0;
		Integer petDF=0;
		Integer petCountF=0;
		Integer  petCountNF=0;
		Integer  petJF=0;
		
		//System.out.println("coming"+petitionerId);
		if(courtId!=null && petitionerId!=null){
			
			
			if(courtId==-1 && petitionerId>0){
				
				petData = leagalReportManager.getabstractPetAll(petitionerId);
				
				mav.addObject("petData",petData);
				
				mav.addObject("selectedCourt",courtId);
				mav.addObject("selectedpetitioner",petitionerId);
				if(petData!=null){
				Integer len =petData.size();
				if(len>0){
					
					for (int i = 0; i < len ; i++) {
						
						petCF=petCF+petData.get(i).getCasesFiled();
						petDF=petDF+petData.get(i).getDraftCountFile();
						petCountF=petCountF+petData.get(i).getCounterFiled();
						petJF=petJF+petData.get(i).getCasesJudged();
						petCountNF=petCountNF+petData.get(i).getCasesToFile();
					
				}
					
					mav.addObject("petCF",petCF);
					mav.addObject("petDF",petDF);
					mav.addObject("petCountF",petCountF);
					mav.addObject("petJF",petJF);
					mav.addObject("petCountNF",petCountNF);
					
				 if(  courtId==-1 && petitionerId==petData.get(0).getPetitionerId() ){
							
							String court=petData.get(0).getCourtName();
							String petitionerName=petData.get(0).getPetitionerName();
							
							//System.out.println("court"+court);
							//System.out.println("caseType"+caseType);
							
							mav.addObject("court","All Cases");
							mav.addObject("petitionerName",petitionerName);
							
						}
					
				}
				}
				
				
			}
			
			
			
			
			
			
		if(courtId>0 && petitionerId>0){
			
			petData = leagalReportManager.getabstractPetCourt(petitionerId, courtId);
			
			mav.addObject("petData",petData);
			
			mav.addObject("selectedCourt",courtId);
			mav.addObject("selectedpetitioner",petitionerId);
			if(petData!=null){
			Integer len =petData.size();
			if(len>0){
				
				for (int i = 0; i < len ; i++) {
					
					petCF=petCF+petData.get(i).getCasesFiled();
					petDF=petDF+petData.get(i).getDraftCountFile();
					petCountF=petCountF+petData.get(i).getCounterFiled();
					petJF=petJF+petData.get(i).getCasesJudged();
					petCountNF=petCountNF+petData.get(i).getCasesToFile();
				
			}
				
				mav.addObject("petCF",petCF);
				mav.addObject("petDF",petDF);
				mav.addObject("petCountF",petCountF);
				mav.addObject("petJF",petJF);
				mav.addObject("petCountNF",petCountNF);
				
			 if(  courtId==petData.get(0).getCourtId() && petitionerId==petData.get(0).getPetitionerId()){
						
						String court=petData.get(0).getCourtName();
						String petitionerName=petData.get(0).getPetitionerName();
						
						//System.out.println("court"+court);
						//System.out.println("caseType"+caseType);
						
						mav.addObject("court",court);
						mav.addObject("petitionerName",petitionerName);
						
					}
				
			}
			
			}	
		}
		}
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/webReports/petDetails")
	@ResponseBody
	public ModelAndView CasePetDetails( Integer unitId, String filingDate, String counterDate,String judgementDate,String  draftdateconttoGP, String casesToFile, Integer petitionerId,Integer courtId,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("petDetails");
		
		List<Cases> caseDetail = new ArrayList<Cases>();
		
		//System.out.println("caseGenId"+advocateId+"filingDate"+filingDate);
		
		if(unitId!=null  && petitionerId!=null &&  filingDate!=null && courtId==null){
			//System.out.println("coming here");
		if((unitId>0 )  && (Integer.parseInt(filingDate)>0) && (petitionerId>0)  ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractPetAll(unitId, Integer.parseInt(filingDate), petitionerId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		if(unitId!=null  && petitionerId!=null &&  filingDate!=null && courtId!=null){
			//System.out.println("coming here");
		if((unitId>0 )  && (Integer.parseInt(filingDate)>0) && (petitionerId>0)  && courtId>0  ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractPetCourt(unitId, Integer.parseInt(filingDate), courtId, petitionerId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		
		
		
		return mav;
	}
	
	
	@RequestMapping(value = "/webReports/viewCaseTotalDetails")
	@ResponseBody
	public ModelAndView viewCaseTotalDetails(Integer caseGenId, Integer courtId,String filingDate, 
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("caseDetails");
		
		List<Cases> caseDetail = new ArrayList<Cases>();
		
		//System.out.println("caseGenId"+filingDate+"filingDate"+filingDate);
		
		if(filingDate!=null && caseGenId==null  && courtId==null){
			//System.out.println("coming here");
		if( (Integer.parseInt(filingDate)>0)   ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractTotAll(Integer.parseInt(filingDate));
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		if(filingDate!=null  && caseGenId==null  && courtId!=null){
			//System.out.println("coming here");
		if((courtId>0 )  && (Integer.parseInt(filingDate)>0)   ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractTotCourt((Integer.parseInt(filingDate)), courtId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		
		if(filingDate!=null  && caseGenId!=null  && courtId!=null){
			//System.out.println("coming here");
		if((courtId>0 )  && (Integer.parseInt(filingDate)>0) && caseGenId>0   ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractTotCourtGen((Integer.parseInt(filingDate)), courtId, caseGenId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		

		if(filingDate!=null  && caseGenId!=null  && courtId==null){
			//System.out.println("coming here");
		if( (Integer.parseInt(filingDate)>0) && caseGenId>0   ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractTotGen((Integer.parseInt(filingDate)), caseGenId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		
		
		
		return mav;
	}
	
	
	@RequestMapping(value = "/webReports/viewCaseTypeTotalDetails")
	@ResponseBody
	public ModelAndView viewCaseTotalEPDetails(Integer caseTypeId, String filingDate, 
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("caseTypeDetails");
		
		List<Cases> caseDetail = new ArrayList<Cases>();
		
		//System.out.println("caseGenId"+filingDate+"filingDate"+filingDate);
		
		if(filingDate!=null && caseTypeId!=null  ){
			//System.out.println("coming here");
		if( (Integer.parseInt(filingDate)>0) && caseTypeId>0   ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractEPTotType((Integer.parseInt(filingDate)), caseTypeId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		
		
		
		return mav;
	}
	
	
	@RequestMapping(value = "/webReports/viewCasePetAdvTotalDetails")
	@ResponseBody
	public ModelAndView viewCasePetAdvTotalDetails(Integer courtId, String filingDate, Integer advocateId,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("petAdvDetails");
		
		List<Cases> caseDetail = new ArrayList<Cases>();
		
		//System.out.println("caseGenId"+filingDate+"filingDate"+filingDate);
		
		if(filingDate!=null && courtId!=null &&  advocateId!=null ){
			//System.out.println("coming here");
		if( (Integer.parseInt(filingDate)>0) && courtId>0 && advocateId>0  ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractTotPetAdvCourt((Integer.parseInt(filingDate)), courtId, advocateId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		if(filingDate!=null && courtId==null &&  advocateId!=null ){
			//System.out.println("coming here");
		if( (Integer.parseInt(filingDate)>0)  && advocateId>0  ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractTotPetAdvAll((Integer.parseInt(filingDate)), advocateId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		
		
		
		
		return mav;
	}

	
	
	@RequestMapping(value = "/webReports/viewCasePetTotalDetails")
	@ResponseBody
	public ModelAndView viewCasePetTotalDetails(Integer courtId, String filingDate, Integer petitionerId,
			HttpSession session, ModelMap model, SessionStatus status,
			HttpServletRequest request ) throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("petDetails");
		
		List<Cases> caseDetail = new ArrayList<Cases>();
		
		//System.out.println("caseGenId"+filingDate+"filingDate"+filingDate);
		
		if(filingDate!=null && courtId!=null && petitionerId!=null   ){
			//System.out.println("coming here");
		if( (Integer.parseInt(filingDate)>0) && petitionerId>0  && courtId>0  ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractTotPetCourt((Integer.parseInt(filingDate)), courtId, petitionerId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		if(filingDate!=null && courtId==null && petitionerId!=null   ){
			//System.out.println("coming here");
		if( (Integer.parseInt(filingDate)>0) && petitionerId>0   ){
			//System.out.println(" not coming here");
			
		caseDetail = leagalReportManager.getcasesAbstractTotPetAll((Integer.parseInt(filingDate)),  petitionerId);
			
		//System.out.println("caseDetail"+caseDetail);
			mav.addObject("caseDetail",caseDetail);
			
		}
		}
		
		
		
		
		return mav;
	}


}
