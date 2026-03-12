package in.ts.icad.leagal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.manager.InventoryAdminManager;
import in.ts.icad.leagal.manager.InventoryReportManager;
import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.manager.TaskAdminManager;
import in.ts.icad.leagal.model.DamInspectDocs;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.InvResAbstract;
import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankInspect;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.MkBillData;
import in.ts.icad.leagal.model.MkEstmtData;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.PumpMaintainActivities;
import in.ts.icad.leagal.model.PumpStations;
import in.ts.icad.leagal.model.ReservoirAyacut;
import in.ts.icad.leagal.model.ReservoirGates;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.ReservoirUnitData;
import in.ts.icad.leagal.model.ScheduleDuty;
import in.ts.icad.leagal.model.Tanks;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.model.mkAdminSanctionData;
import in.ts.icad.leagal.model.mkAgmtData;
import in.ts.icad.leagal.model.mkRepairData;
import in.ts.icad.leagal.model.mkTankData;
import in.ts.icad.leagal.model.mkTankRepairHistory;
import in.ts.icad.leagal.model.mkTenderData;
import in.ts.icad.leagal.util.DateUtil;
import in.ts.icad.leagal.util.TankRepairHistory;

@Controller
public class InventoryReportController {
	
	@Autowired
	private InventoryReportManager irm;
	
	@Autowired
	private InventoryAdminManager invam;
	
	@Autowired
	private LeagalAdminManager lam;  
	
	@Autowired
	private ServletContext servletContext;
	
	
	@RequestMapping(value = "/invReport/resAbstract")
	public ModelAndView resAbstract( SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("resvoirabstract");
	List<InvResAbstract> invResList = new ArrayList<InvResAbstract>()	;
	
	Integer totalres=0;
	Integer ongoingtotal=0;
	Integer completedtotal=0;
		
		try {
			invResList=irm.getResAbstractList() ;
			
			
			if(invResList!=null){
				
				if(invResList.size()>0){
			
			Integer len =invResList.size();
			
			for(int i=0; i<len ;i++){
				
				totalres=totalres+invResList.get(i).getResTotalCount();
				ongoingtotal=ongoingtotal+invResList.get(i).getResOngoingCount();
				completedtotal=completedtotal+invResList.get(i).getResCompleted();
						
						
						
						
				
				
			}
			
				}
			
			}
	
			
			mav.addObject("invResList",invResList);
			mav.addObject("totalres",totalres);
			mav.addObject("ongoingtotal",ongoingtotal);
			mav.addObject("completedtotal",completedtotal);
			
			
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		return mav;

	}
    
	
	@RequestMapping(value = "/invReport/resUnitMapDetail")
	public ModelAndView resUnitMapDetail(Integer unitId,Integer resStatus, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("reservoirUnitMapDetail");
		List<ReservoirUnitData> resUnitData= new ArrayList<ReservoirUnitData>();
		
		try {
			resUnitData=irm.getrestotalList(unitId, resStatus);
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		mav.addObject("resUnitData",resUnitData);
		mav.addObject("selectedunitId",unitId);
		mav.addObject("selectedStatusId",resStatus);
		 
		return mav;

	}
	
	@RequestMapping(value = "/invReport/resInfo")
	public ModelAndView res( SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("reservoirinfo");
		
		
		 
		 
		 
		return mav;

	}
	
	@RequestMapping(value = "/invReport/resinfobycode")
	@ResponseBody	
	public String resinfobycode( String resCode, HttpServletRequest request,HttpSession session,SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		
		
		
		ReservoirSalient resInfoByCode = new  ReservoirSalient();
		
		
		
		 try {
			 
			 if(resCode!=null){
				 resInfoByCode=irm.getResInfoBYCode(resCode);
			 }
	
		
			//System.out.println("resInfoByCode"+resInfoByCode);
			
		
		

		} catch ( InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		
		 return new Gson().toJson(resInfoByCode);

	}
	
	
	@RequestMapping(value = "/invtsimis/resinfoPDF", method = RequestMethod.GET)
	public ModelAndView resinfoPDF(Integer unitId, Integer resStatusId,SessionStatus status, HttpSession session) {
		// create some sample data
		
		ModelAndView mav = new ModelAndView();
		List<ReservoirSalient> resinfo= new ArrayList<ReservoirSalient>();
		List<ReservoirUnitData> resunitdata= new ArrayList<ReservoirUnitData>();
		List<InvResAbstract> resabstract= new ArrayList<InvResAbstract>();
		
		try {
			
                  if(unitId!=null &&resStatusId!=null){
				
				if(unitId>0 && resStatusId>=0){	
		resinfo=irm.resinfopdf(unitId, resStatusId);
			
				}
                  }
                  resunitdata=irm.getresinfoBycodePDF();
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("resInfo",resinfo);
		
		mav.addObject("resunitdata",resunitdata);
	mav.setViewName("reservoirinfopdfabstract");//check in views properties file under resources
		
	
		// return a view which will be resolved by an excel view resolver
		return mav ;
				//new ModelAndView("pdfView", "Paras", listParas);
	}
	
	@RequestMapping(value = "/invReport/Tank-checks")
	@ResponseBody	
	public String Tankchecks( MiTankInspect mitankObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("left-menu-home");
	//	List<MiTankInspect> miTankAbstract= new ArrayList<MiTankInspect>();
	//	List<MiTankInspect> mCapacityAbstract= new ArrayList<MiTankInspect>();
		List<MiTankInspect> miunitAbstract= new ArrayList<MiTankInspect>();
		//List<MiTankInspect> inflowlist= new ArrayList<MiTankInspect>();
		List<District> districts = new ArrayList<District>();
		/*List<MiTankInspect> repairlist= new ArrayList<MiTankInspect>();
		List<MiTankInspect> capacitylist= new ArrayList<MiTankInspect>();
		List<MiTankInspect> feedlist= new ArrayList<MiTankInspect>();*/
		   Long totalPreCount=0l;
		   Long totalPostCount=0l;
		   Long totalDuringCount=0l;
		try {
			districts = lam.getDistricts();
			User user = (User) session.getAttribute("userObj");
			//System.out.println("miobj"+mitankObj);
			//System.out.println("Tankchecks: mitankObj "+mitankObj);
			if (mitankObj!=null ){
			if(mitankObj.getYear()!=null & mitankObj.getMiTankFreqId()!=null){
if(mitankObj.getYear()>0  ){		
	/*System.out.println(mitankObj.getUnitId());
	System.out.println(mitankObj.getCircleId());
	System.out.println(mitankObj.getDivisionId());
	System.out.println(mitankObj.getSubdivisionId());
	System.out.println(mitankObj.getDesignationId());
	System.out.println(mitankObj.getPostId());*/
	miunitAbstract = irm.getMiTankUnitAbstract(mitankObj);
//	System.out.println("miunitAbstract"+miunitAbstract);
	//System.out.println("miunitAbstract.size() "+miunitAbstract.size());
	
		/*		
			if(miunitAbstract!=null){
				mav.addObject("miunitAbstract",miunitAbstract);
			}*/
			}
			}
			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//mav.addObject("districtList",districts);
		 return new Gson().toJson(miunitAbstract);
	}
	
	
	
	@RequestMapping(value = "/invReport/Tank-capacity-abstract")
	@ResponseBody	
	public String Tankcapacityabstract( MiTankInspect mitankObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("left-menu-home");
		List<MiTankInspect> mCapacityAbstract= new ArrayList<MiTankInspect>();
		try {

		//	System.out.println("in report controller(Tank-capacity): user"+mitankObj);

			//System.out.println("in report controller(Tank-capacity): user"+mitankObj);
			//System.out.println(mitankObj.getDesignationId());

			//System.out.println(" i am here"+mitankObj);
			if (mitankObj!=null ){
			if(mitankObj.getYear()!=null ){
            if(mitankObj.getYear()>0  ){		
	/*System.out.println(mitankObj.getUnitId());
	System.out.println(mitankObj.getCircleId());
	System.out.println(mitankObj.getDivisionId());
	System.out.println(mitankObj.getSubdivisionId());
	System.out.println(mitankObj.getDesignationId());
	System.out.println(mitankObj.getPostId());*/
            	mCapacityAbstract = irm.getMiTankCapAyacutAbstract(mitankObj);
            	//System.out.println(" mCapacityAbstract"+mCapacityAbstract);
            	//System.out.println(" mCapacityAbstract"+mCapacityAbstract);

			}
			}
			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//mav.addObject("districtList",districts);
		 return new Gson().toJson(mCapacityAbstract);
	}
	
	
	
	
	
	@RequestMapping(value = "/invReport/Tank-inoutflow")
	public ModelAndView Inoutflow(@ModelAttribute("mitankinspect") MiTankInspect mitankObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("Tank-checks-abstract");
		
		
		List<MiTankInspect> inflowlist= new ArrayList<MiTankInspect>();
		List<MiTankInspect> repairlist= new ArrayList<MiTankInspect>();
		List<District> districts = new ArrayList<District>();
		List<MiTankInspect> capacitylist= new ArrayList<MiTankInspect>();
		
		
	
			
		try {
			
			districts = lam.getDistricts();
			
		//	System.out.println("miobj"+mitankObj);
			
			//System.out.println(" i am here"+mitankObj);
			
			if (mitankObj!=null && mitankObj.getTabId()!=null){

			
			if(mitankObj.getTabId()==2){
				
			//	System.out.println("i am in tab2"+mitankObj.getTabId());
				
			//	System.out.println("miobj"+mitankObj);
				
				if(mitankObj.getTankId()!=null && mitankObj.getYear()!=null){
					
					inflowlist=irm.getInnoutBytankIdyear(mitankObj.getTankId(), mitankObj.getYear());
					
					mav.addObject("inflowlist",inflowlist);
				}
				
			}
			

			
			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	
		
		mav.addObject("districtList",districts);
		 
		 
		return mav;

	}
	
	
	
	@RequestMapping(value = "/invReport/Tank-repairs")
	@ResponseBody
	public String  tankRepairs(MiTankInspect mitankObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		
		List<MiTankInspect> repairlist = new ArrayList<MiTankInspect>();
		//System.out.println("come to emb");

		try {

			if(mitankObj.getTankId()!=null && mitankObj.getYear()!=null){
				
				repairlist=irm.getMiRepairsbytankidyear(mitankObj.getTankId(), mitankObj.getYear());
				
			
			}
			

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(repairlist);
		

		

	}
	
	
	@RequestMapping(value = "/invReport/Tank-capacity")
	@ResponseBody
	public String  tankCapacity(MiTankInspect mitankObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		
		List<MiTankInspect> capacitylist = new ArrayList<MiTankInspect>();
		//System.out.println("come to emb");

		try {

			if(mitankObj.getTankId()!=null && mitankObj.getYear()!=null){
				
				capacitylist=irm.getMiCapacityTankIdYear(mitankObj.getTankId(), mitankObj.getYear());
				
				
			}
			

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(capacitylist);
		

		

	}
	
	/*@RequestMapping(value = "/invReport/Tank-repairs")
	public ModelAndView tankRepairs(@ModelAttribute("mitankinspect") MiTankInspect mitankObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("Tank-checks-abstract");
		
		
		List<MiTankInspect> inflowlist= new ArrayList<MiTankInspect>();
		List<MiTankInspect> repairlist= new ArrayList<MiTankInspect>();
		List<District> districts = new ArrayList<District>();
		List<MiTankInspect> capacitylist= new ArrayList<MiTankInspect>();
		
		
	
			
		try {
			
			districts = lam.getDistricts();
			
		//	System.out.println("miobj"+mitankObj);
			
			//System.out.println(" i am here"+mitankObj);
			
			if (mitankObj!=null && mitankObj.getTabId()!=null){

			
			
			
if(mitankObj.getTabId()==3){
				
				if(mitankObj.getTankId()!=null && mitankObj.getYear()!=null){
					
					repairlist=irm.getMiRepairsbytankidyear(mitankObj.getTankId(), mitankObj.getYear());
					
					mav.addObject("repairlist",repairlist);
				}
				
			}


	

			
			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	
		
		mav.addObject("districtList",districts);
		 
		 
		return mav;

	}*/
	
	/*@RequestMapping(value = "/invReport/Tank-capacity")
	public ModelAndView tankCapacity(@ModelAttribute("mitankinspect") MiTankInspect mitankObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("Tank-checks-abstract");
		
		
		List<MiTankInspect> inflowlist= new ArrayList<MiTankInspect>();
		List<MiTankInspect> repairlist= new ArrayList<MiTankInspect>();
		List<District> districts = new ArrayList<District>();
		List<MiTankInspect> capacitylist= new ArrayList<MiTankInspect>();
		
		
	
			
		try {
			
			districts = lam.getDistricts();
			
			//System.out.println("miobj"+mitankObj);
			
			//System.out.println(" i am here"+mitankObj);
			
			if (mitankObj!=null && mitankObj.getTabId()!=null){

			
			
			


if(mitankObj.getTabId()==4){
	
	if(mitankObj.getTankId()!=null && mitankObj.getYear()!=null){
		
		capacitylist=irm.getMiCapacityTankIdYear(mitankObj.getTankId(), mitankObj.getYear());
		
		mav.addObject("capacitylist",capacitylist);
	}
	
}
			
			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	
		
		mav.addObject("districtList",districts);
		 
		 
		return mav;

	}*/

	@RequestMapping(value = "/invReport/TankDetail")
	public ModelAndView Tankdetail(@ModelAttribute("mitankinspect2") MiTankInspect mitankObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("TankchecksDetail");
		
	//	System.out.println("mitankObj"+mitankObj);
		List<MiTankInspect> miTankdetail= new ArrayList<MiTankInspect>();
		try{
		
		if(mitankObj.getNewDistrictId()!=null && mitankObj.getMiTankFreqId()!=null ){
			
			miTankdetail=   irm.getMiTankChecksAbstractDetail(mitankObj);
			
			
			mav.addObject("miTankdetail",miTankdetail);
			
			////miTankAbstract2 = invam.getReservoirScheduleofDuties();
			
			//System.out.println("miTankAbstract2"+miTankAbstract2);
			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		return mav;

	}
	
	@RequestMapping(value = "/invReport/Tank-Info")
	@ResponseBody
	public String TankchecksTankInfo(MiTankInspect mitankObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miinspect = new ArrayList<MiTankInspect>();

		try {

			if (mitankObj.getTankId() != null) {
				miinspect = irm.getMiTankChecksTankInfo(mitankObj);
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miinspect);
		

		

	}
	

	@RequestMapping(value = "/invReport/embInfo")
	@ResponseBody
	public String embInfo(MiTankInspect mitankObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miinspect = new ArrayList<MiTankInspect>();
		List<MiTankInspect> embinspect = new ArrayList<MiTankInspect>();
		//System.out.println("come to emb");

		try {

			if (mitankObj.getTankId() != null) {
				miinspect = irm.getMiTankChecksEmbInfo(mitankObj);
			}
			if(miinspect!=null){
				if(miinspect.size()>0){
for(int i=0; i<miinspect.size(); i++){
				
				if(miinspect.get(i).getMiCompId()<=4 ){
					
					embinspect.add(miinspect.get(i));
				}
			}
			}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miinspect);
	}
	
	@RequestMapping(value = "/invReport/sluInfo")
	@ResponseBody
	public String  sluInfo(MiTankInspect mitankObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miinspect = new ArrayList<MiTankInspect>();
		List<MiTankInspect> slumiinspect = new ArrayList<MiTankInspect>();
		//System.out.println("come to emb");

		try {

			if (mitankObj.getTankId() != null) {
				miinspect = irm.getMiTankChecksEmbInfo(mitankObj);
			}
			if(miinspect!=null){
				if(miinspect.size()>0){	
for(int i=0; i<miinspect.size(); i++){
				
				if(miinspect.get(i).getMiCompId()==5 ){
					
					slumiinspect.add(miinspect.get(i));
					
				}
				
			}
				}}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(slumiinspect);
		

		

	}
	
	@RequestMapping(value = "/invReport/weirInfo")
	@ResponseBody
	public String weirInfo(MiTankInspect mitankObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miinspect = new ArrayList<MiTankInspect>();
		List<MiTankInspect> weirmiinspect = new ArrayList<MiTankInspect>();
	//	System.out.println("come to emb");

		try {

			if (mitankObj.getTankId() != null) {
				miinspect = irm.getMiTankChecksEmbInfo(mitankObj);
			}
			if(miinspect!=null){
				if(miinspect.size()>0){
			for(int i=0; i<miinspect.size(); i++){
				
				if(miinspect.get(i).getMiCompId()==6 || miinspect.get(i).getMiCompId() ==7){
					
					weirmiinspect.add(miinspect.get(i));
					
				}
				
			}
				}}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(weirmiinspect);
		

		

	}
	@RequestMapping(value = "/omrest/repair-history",method = RequestMethod.GET)
	@ResponseBody
	public String TankInfo(Long tankId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		
	
		JSONObject repairjarray = new JSONObject();


		try {
			 repairjarray=TankRepairHistory.getTankRepairHistory(tankId);
		
			
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(repairjarray);

		

	}


	@RequestMapping(value = "/invReport/res-ann1-abstract")
	public ModelAndView resann1abstract(@ModelAttribute("reservoirInspect1") ReservoirInspect reservoirObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("res-ann1-abstract");
		
		//System.out.println("reservoirObj"+reservoirObj.getPostId());
	
		
		List<InvResAbstract> invResList = new ArrayList<InvResAbstract>()	;
		
		List<InvResAbstract> invResCatList = new ArrayList<InvResAbstract>()	;
		
		List<InvResAbstract> invResListEE = new ArrayList<InvResAbstract>()	;
		
		List<InvResAbstract> invResCatListEE = new ArrayList<InvResAbstract>()	;
		
		
		
		Integer totalres=0;
		Integer restotalsubmitted=0;
		Integer resunsatisfactory=0;
		Integer respoor=0;
		Integer resfair=0;
		Integer ressatisfactory=0;
		
		Integer totalcatres=0;
		Integer cattotalsubmitted=0;
		Integer cat1=0;
		Integer cat2=0;
		Integer cat3=0;
		Integer catna=0;
		
		List<ReservoirInspect> selectDamSafetyYear=null;
			
			try {
				
				
				selectDamSafetyYear = irm.getDamsafetySelectYear();
	 			   if(selectDamSafetyYear!=null){
	                mav.addObject("selectDamSafetyYear",selectDamSafetyYear);
	 			   }
				if(reservoirObj!=null){
					
					
					//System.out.println("year"+reservoirObj.getYear());
					//System.out.println("reservoirObj.getDutyFrequencyId()"+reservoirObj.getDutyFrequencyId());
						
					
					if(reservoirObj.getYear()!=null && reservoirObj.getDutyFrequencyId()!=null ){
				if(reservoirObj.getYear()>0 && reservoirObj.getDutyFrequencyId()>0){
					
					//System.out.println("unit"+reservoirObj.getUnitId());
					//System.out.println("circle"+reservoirObj.getCircleId());
					//System.out.println("division"+reservoirObj.getDivisionId());
				 //  System.out.println("subdivision"+reservoirObj.getSubdivisionId());
				//	System.out.println("designation"+reservoirObj.getDesignationId());
				//	System.out.println("list"+reservoirObj.getListDesignationId());
					//System.out.println("post"+reservoirObj.getPostId());
					//System.out.println("offaccess "+reservoirObj.getOffAccess());
					//System.out.println("getTsfcFormYear "+reservoirObj.getYear());
					//System.out.println("dutyfreq "+reservoirObj.getDutyFrequencyId());
					
					//System.out.println("getBackdesignationId "+reservoirObj.getBackdesignationId());
					
					
					
					
				invResList=irm.getInvomResAbstractList(reservoirObj) ;
				
				invResListEE=irm.getInvomResEEAbstractList(reservoirObj);
				
				invResCatList=irm.getInvomResCategorywiseAbstractList(reservoirObj);
				
				invResCatListEE=irm.getInvomCategoryResEEAbstractList(reservoirObj);
				
				//System.out.println("invResListEEsize"+invResListEE.size());
				
				//System.out.println("invResCatListEE"+invResCatListEE);
				}
					}
					
					if(invResCatList!=null){
						
						if(invResCatList.size()>0){
							
							Integer len1 =invResCatList.size();
							
							for(int k=0; k<len1 ; k++){
								
								totalcatres=totalcatres+invResCatList.get(k).getResTotalCount();
								cattotalsubmitted=cattotalsubmitted+invResCatList.get(k).getResSubmittedCount();
								
								cat1=cat1+invResCatList.get(k).getCategory1();
								
								cat2=cat2+invResCatList.get(k).getCategory2();
								
								cat3=cat3+invResCatList.get(k).getCategory3();
								
								catna=catna+invResCatList.get(k).getCategoryNA();
								
								
							}
							
							
						}
						
						
					}
				
				
				if(invResList!=null){
					
					if(invResList.size()>0){
				
				Integer len =invResList.size();
				
				for(int i=0; i<len ;i++){
					
					totalres=totalres+invResList.get(i).getResTotalCount();
					restotalsubmitted=restotalsubmitted+invResList.get(i).getResSubmittedCount();
					
					resunsatisfactory=resunsatisfactory+invResList.get(i).getResUnsatisfactory();
					
					respoor=respoor+invResList.get(i).getResPoor();
					
					resfair=resfair+invResList.get(i).getResFair();
					
					ressatisfactory=ressatisfactory+invResList.get(i).getResSatisfactory();
					//completedtotal=completedtotal+invResList.get(i).getResCompleted();
							
							
							
							
					
					
				}
				
				
				
				mav.addObject("frmdesgId",reservoirObj.getDesignationId());
				mav.addObject("frmListdesgId",reservoirObj.getListDesignationId());
				
				mav.addObject("frmunitId",reservoirObj.getUnitId());
				mav.addObject("frmcircleId",reservoirObj.getCircleId());
				mav.addObject("fmdivId",reservoirObj.getDivisionId());
				mav.addObject("frmsubdivId",reservoirObj.getSubdivisionId());
				mav.addObject("frmyear",reservoirObj.getYear());
				mav.addObject("frmpost",reservoirObj.getPostId());
				mav.addObject("frmOffAccess",reservoirObj.getOffAccess());
				
				
				//start 
				
				if(reservoirObj.getOffAccess()>=1   && reservoirObj.getUserDesignationId()!=null && reservoirObj.getBackdesignationId()!=null ){
					
					/*System.out.println("after list"+miobj.getOffAccess());
					System.out.println("miobj.getDesignationId()"+miobj.getDesignationId());
					System.out.println("miobj.getUserDesignationId()"+miobj.getUserDesignationId());*/
					
					mav.addObject("formcontbackdesgId",reservoirObj.getBackdesignationId());
					//System.out.println("miobj.getBackdesignationId()"+miobj.getBackdesignationId());
					
 if(reservoirObj.getOffAccess()==1){
if(reservoirObj.getBackdesignationId()==5){
if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){

//	System.out.println("coming here5 office 1");
						
						mav.addObject("prefrm20desgId",7);
						mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
						mav.addObject("prefrm20unitId", reservoirObj.getUnitId());
						mav.addObject("prefrm20circleId",reservoirObj.getCircleId());
						mav.addObject("prefrm20divisionId",reservoirObj.getDivisionId());
						mav.addObject("prefrm20subdivisionId",0);
						mav.addObject("prefrm20post",reservoirObj.getPostId());
						mav.addObject("prefrm20year",reservoirObj.getYear());
                    }					
                   }

if(reservoirObj.getBackdesignationId()==7){

if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){

//	System.out.println("coming here7 office 1");

mav.addObject("prefrm20desgId",9);
mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
mav.addObject("prefrm20unitId", reservoirObj.getUnitId());
mav.addObject("prefrm20circleId",reservoirObj.getCircleId());
mav.addObject("prefrm20divisionId",0);
mav.addObject("prefrm20subdivisionId",reservoirObj.getSubdivisionId());
mav.addObject("prefrm20post",reservoirObj.getPostId());
mav.addObject("prefrm20year",reservoirObj.getYear());

}	  
}

if(reservoirObj.getBackdesignationId()==9){

if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){

//	System.out.println("coming here9 office 1");

mav.addObject("prefrm20desgId",10);
mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
mav.addObject("prefrm20unitId", reservoirObj.getUnitId());
mav.addObject("prefrm20circleId",0);
mav.addObject("prefrm20divisionId",reservoirObj.getDivisionId());
mav.addObject("prefrm20subdivisionId",reservoirObj.getSubdivisionId());
mav.addObject("prefrm20post",reservoirObj.getPostId());
mav.addObject("prefrm20year",reservoirObj.getYear());

}	  
}

if(reservoirObj.getBackdesignationId()==10){

if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){

//	System.out.println("coming here10 office 1");

mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
mav.addObject("prefrm20year",reservoirObj.getYear());

}	  
}
					}
					
					if(reservoirObj.getOffAccess()==2){
						
						reservoirObj.setUserDesignationId(9);
						
						if(reservoirObj.getBackdesignationId()==5){
							
						//	System.out.println("cming here office acees 2 designation 5");
							
							if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){
								
								mav.addObject("prefrm20desgId",7);
								mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
								mav.addObject("prefrm20unitId", reservoirObj.getUnitId());
								mav.addObject("prefrm20circleId",reservoirObj.getCircleId());
								mav.addObject("prefrm20divisionId",reservoirObj.getDivisionId());
								mav.addObject("prefrm20subdivisionId",0);
								mav.addObject("prefrm20post",reservoirObj.getPostId());
								mav.addObject("prefrm20year",reservoirObj.getYear());
							
							
							}
						}
						
						if(reservoirObj.getBackdesignationId()==7){
							
						//	System.out.println("cming here office acees 2 designation 7");
							
							if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){
							
							mav.addObject("prefrm20desgId",9);
							mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
							mav.addObject("prefrm20unitId", reservoirObj.getUnitId());
							mav.addObject("prefrm20circleId",reservoirObj.getCircleId());
							mav.addObject("prefrm20divisionId",0);
							mav.addObject("prefrm20subdivisionId",reservoirObj.getSubdivisionId());
							mav.addObject("prefrm20post",reservoirObj.getPostId());
							mav.addObject("prefrm20year",reservoirObj.getYear());
					 
							}
						}
                        if(reservoirObj.getBackdesignationId()==9){
                        	
                        //	System.out.println("cming here office acees 2 designation 9");
							
							if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){
							
							mav.addObject("prefrm20desgId",10);
							mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
							mav.addObject("prefrm20unitId", reservoirObj.getUnitId());
							mav.addObject("prefrm20circleId",0);
							mav.addObject("prefrm20divisionId",reservoirObj.getDivisionId());
							mav.addObject("prefrm20subdivisionId",reservoirObj.getSubdivisionId());
							mav.addObject("prefrm20post",reservoirObj.getPostId());
							mav.addObject("prefrm20year",reservoirObj.getYear());
							}
						}
                        
                        if(reservoirObj.getBackdesignationId()==10){
                        	
                        //	System.out.println("cming here office acees 2 designation 10");
							
							if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){
							mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
							mav.addObject("prefrm20year",reservoirObj.getYear());
					 
							}
						}
					}
					
					
					if(reservoirObj.getOffAccess()==3){
						
						reservoirObj.setUserDesignationId(10);
						
						if(reservoirObj.getBackdesignationId()==5){
							
						//	System.out.println("cming here office acees 3 designation 5");
							
							if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){
							
							mav.addObject("prefrm20desgId",7);
							mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
							mav.addObject("prefrm20unitId", reservoirObj.getUnitId());
							mav.addObject("prefrm20circleId",reservoirObj.getCircleId());
							mav.addObject("prefrm20divisionId",reservoirObj.getDivisionId());
							mav.addObject("prefrm20subdivisionId",0);
							mav.addObject("prefrm20post",reservoirObj.getPostId());
							mav.addObject("prefrm20year",reservoirObj.getYear());
							}
						
						}
					
                         if(reservoirObj.getBackdesignationId()==7){
                        	 
                        	//	System.out.println("cming here office acees 3 designation 7");
                        	 
                        	 if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){
						
						mav.addObject("prefrm20desgId",9);
						mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
						mav.addObject("prefrm20unitId", reservoirObj.getUnitId());
						mav.addObject("prefrm20circleId",reservoirObj.getCircleId());
						mav.addObject("prefrm20divisionId",0);
						mav.addObject("prefrm20subdivisionId",reservoirObj.getSubdivisionId());
						mav.addObject("prefrm20post",reservoirObj.getPostId());
						mav.addObject("prefrm20year",reservoirObj.getYear());
                        	 }
					}
                          if(reservoirObj.getBackdesignationId()==9){
                        	  
                        	//	System.out.println("cming here office acees 3 designation 9");
                        	 
                        	 if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){
						
						mav.addObject("prefrm20desgId",10);
						mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
						mav.addObject("prefrm20unitId", reservoirObj.getUnitId());
						mav.addObject("prefrm20circleId",0);
						mav.addObject("prefrm20divisionId",reservoirObj.getDivisionId());
						mav.addObject("prefrm20subdivisionId",reservoirObj.getSubdivisionId());
						mav.addObject("prefrm20post",reservoirObj.getPostId());
					
						mav.addObject("prefrm20year",reservoirObj.getYear());
                        	 }
					
					}
                          
                          if(reservoirObj.getBackdesignationId()==10){
                        	 
                        		//System.out.println("cming here office acees 3 designation 10");
                         	 
                         	 if(reservoirObj.getUserDesignationId()>=reservoirObj.getBackdesignationId()){
							
                         		mav.addObject("prefrm20desgId",10);
							mav.addObject("prefrm20offAccess",reservoirObj.getOffAccess());
						mav.addObject("prefrm20unitId", reservoirObj.getUserUnitId());
							
							
							mav.addObject("prefrm20year",reservoirObj.getYear());
							
                         	 }
						
						} 
				} // office access 3 not null
					
			}//back desigId  not null
				
				
				
			//	end
				
				
					}
				
				}
		
				}
				mav.addObject("invResList",invResList);
				
				mav.addObject("invResListEE",invResListEE);
				
				mav.addObject("invResCatList",invResCatList);
				
				mav.addObject("invResCatListEE",invResCatListEE);
				
				
				mav.addObject("totalres",totalres);
				mav.addObject("restotalsubmitted",restotalsubmitted);
				mav.addObject("resunsatisfactory",resunsatisfactory);
				mav.addObject("respoor",respoor);
				mav.addObject("resfair",resfair);
				mav.addObject("ressatisfactory",ressatisfactory);
				
				mav.addObject("rdutyFrequencyId",reservoirObj.getDutyFrequencyId());
				mav.addObject("ryear",reservoirObj.getYear());
				mav.addObject("runit",reservoirObj.getUnitId());
				mav.addObject("rcircle",reservoirObj.getCircleId());
				mav.addObject("rdivision",reservoirObj.getDivisionId());
				mav.addObject("rsubdivision",reservoirObj.getSubdivisionId());
				mav.addObject("rpost",reservoirObj.getPostId());
				
				
		
				
				mav.addObject("totalcatres",totalcatres);
				mav.addObject("cattotalsubmitted",cattotalsubmitted);
				mav.addObject("cat1",cat1);
				mav.addObject("cat2",cat2);
				mav.addObject("cat3",cat3);
				mav.addObject("catna",catna);
			
				
				
			} catch (InventoryUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		
		
		 
		 
		return mav;

	}
	
	
	@RequestMapping(value = "/invReport/res-ann1-Detail")
	public ModelAndView ResAnn1detail(@ModelAttribute("reservoirInspect1") ReservoirInspect reservoirObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("res-ann1-Detail");
		
              List<ReservoirInspect> resUnitData= new ArrayList<ReservoirInspect>();
              List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();
              
              List<ReservoirInspect> resHealthinf = new ArrayList<ReservoirInspect>();
		
		try {
			if(reservoirObj!=null){
				
				//System.out.println("reservoirObj.getUnitId()"+reservoirObj.getUnitId());
				//System.out.println("reservoirObj.getdutyfreqId"+reservoirObj.getDutyFrequencyId());
				//System.out.println("reservoirObj.getYear()"+reservoirObj.getYear());
				if(reservoirObj.getUnitId()!=null && reservoirObj.getDutyFrequencyId()!=null && reservoirObj.getYear()!=null   ){
					
					if(reservoirObj.getUnitId()>0 && reservoirObj.getYear()>0 && reservoirObj.getDutyFrequencyId()>0 ){
			resUnitData=irm.getinvomrestotalList(reservoirObj);
			resInspectinf = irm.getResInspectInfobyUnitId(reservoirObj);
			
			resHealthinf=irm.getResHealthInfobyUnitId(reservoirObj);
			
			for (int i=0; i<resUnitData.size();i++){
				
				 boolean foundMatch = false;
				 
				 boolean foundinspectoffice=false;
				
				// System.out.println("i"+resUnitData.get(i).getResInspectMst1Id());
				
				for(int j=0; j<resHealthinf.size();j++){
				
					
					
					///System.out.println(resHealthinf.get(j).getResInspectMst1Id());
					
					if(resUnitData.get(i).getResInspectMst1Id().equals(resHealthinf.get(j).getResInspectMst1Id())){
						
						//System.out.println("j"+resUnitData.get(i).getResName());
						
						
						
						
						
						resUnitData.get(i).setDeficiencyCategory(resHealthinf.get(j).getDeficiencyCategory());
						
						foundMatch = true;
			            break; 
						
					}
				    
				}	
				
				if (!foundMatch) {
			        // Set DeficiencyCategory to 4 when no match is found
			        resUnitData.get(i).setDeficiencyCategory(4);
			    }
				
                   for(int k=0; k<resInspectinf.size();k++){
				
					
					
					//System.out.println(resHealthinf.get(k).getResInspectMst1Id());
					
					if(resUnitData.get(i).getResInspectMst1Id().equals(resInspectinf.get(k).getResInspectMst1Id())){
						
					
						
						
						//System.out.println("k"+resUnitData.get(i).getResName());
					//	System.out.println("k"+resInspectinf.get(k).getInspectOfficeId());
						
						
						resUnitData.get(i).setInspectOfficeId(resInspectinf.get(k).getInspectOfficeId());;
						
						foundinspectoffice = true;
			            break; 
						
					}
				    
				}
                   
                   if (!foundinspectoffice) {
   			        // Set DeficiencyCategory to 4 when no match is found
   			        resUnitData.get(i).setInspectOfficeId(-1);
   			    }
				
			}
			
			
			//System.out.println("resUnitData"+resUnitData);
			//System.out.println("resInspectinf"+resInspectinf);
					}
				}
			}
			
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		mav.addObject("resUnitData",resUnitData);
		mav.addObject("resInspectinf",resInspectinf);
		mav.addObject("resHealthinf",resHealthinf);
		
		mav.addObject("selectedunitId",reservoirObj.getUnitId());
		mav.addObject("selectedStatusId",reservoirObj.getResStatusId());
		 
		return mav;
		
		 
		

	}
	
	
	@RequestMapping(value = "/invReport/res-category-Detail")
	public ModelAndView categorydetail(@ModelAttribute("reservoirInspect1") ReservoirInspect reservoirObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("res-category-Detail");
		
              List<ReservoirInspect> resUnitData= new ArrayList<ReservoirInspect>();
              List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();
		
		try {
			if(reservoirObj!=null){
				
				//System.out.println("reservoirObj.getUnitId()"+reservoirObj.getUnitId());
				//System.out.println("reservoirObj.getdutyfreqId"+reservoirObj.getDutyFrequencyId());
				//System.out.println("reservoirObj.getYear()"+reservoirObj.getYear());
				//System.out.println("reservoirObj.getdefficeincycategory"+reservoirObj.getDeficiencyCategory());
				if(reservoirObj.getUnitId()!=null && reservoirObj.getDutyFrequencyId()!=null && reservoirObj.getYear()!=null   ){
					
					if(reservoirObj.getUnitId()>0 && reservoirObj.getYear()>0 && reservoirObj.getDutyFrequencyId()>0 ){
			resUnitData=irm.getinvomresCattotalList(reservoirObj);
			resInspectinf = irm.getResCategoryInspectInfobyUnitId(reservoirObj);
			
			if(reservoirObj.getDeficiencyCategory()!=null ){
				
				if(reservoirObj.getDeficiencyCategory()>0){
					
					
					mav.addObject("catinfo",reservoirObj.getDeficiencyCategory());
					
				}
				
				
			}
			
			
			//System.out.println("resUnitData"+resUnitData);
			//System.out.println("resInspectinf"+resInspectinf);
					}
				}
			}
			
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		mav.addObject("resUnitData",resUnitData);
		mav.addObject("resInspectinf",resInspectinf);
		mav.addObject("selectedunitId",reservoirObj.getUnitId());
		mav.addObject("selectedStatusId",reservoirObj.getResStatusId());
		 
		return mav;
		
		 
		

	}
	
	
	@RequestMapping(value = "/invReport/res-ann1-Total-res")
	public ModelAndView resann1Totalres(@ModelAttribute("reservoirInspect1") ReservoirInspect reservoirObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("res-ann1-Total-res");
		
              List<ReservoirInspect> resUnitData= new ArrayList<ReservoirInspect>();
              List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();
		
		try {
			if(reservoirObj!=null){
				
				//System.out.println("reservoirObj.getUnitId()"+reservoirObj.getUnitId());
				//System.out.println("reservoirObj.getdutyfreqId"+reservoirObj.getDutyFrequencyId());
				//System.out.println("reservoirObj.getYear()"+reservoirObj.getYear());
				//System.out.println("reservoirObj.getDesignationId()"+reservoirObj.getDesignationId());
				
				if(reservoirObj.getUnitId()!=null && reservoirObj.getDutyFrequencyId()!=null && reservoirObj.getYear()!=null   ){
					
					if(reservoirObj.getUnitId()>0  ){
			resUnitData=irm.getinvomrestotalnrldresList(reservoirObj);
			//resInspectinf = irm.getResInspectInfobyUnitId(reservoirObj);
			
			
			//System.out.println("resUnitData"+resUnitData);
			//System.out.println("resInspectinf"+resInspectinf);
					}
				}
			}
			
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		mav.addObject("resUnitData",resUnitData);
		
		mav.addObject("resYear",reservoirObj.getYear());
		mav.addObject("resFrequency",reservoirObj.getDutyFrequencyId());
	//	mav.addObject("resInspectinf",resInspectinf);
		//mav.addObject("selectedunitId",reservoirObj.getUnitId());
		//mav.addObject("selectedStatusId",reservoirObj.getResStatusId());
		 
		return mav;
		
		 
		

	}
	
	
	@RequestMapping(value = "/invReport/res-All-ann1-Total-res")
	public ModelAndView resALLann1Totalres(@ModelAttribute("reservoirInspect1") ReservoirInspect reservoirObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("res-ann1-Total-res");
		
              List<ReservoirInspect> resUnitData= new ArrayList<ReservoirInspect>();
              List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();
		
		try {
			if(reservoirObj!=null){
				
				//System.out.println("reservoirObj.getUnitId()"+reservoirObj.getUnitId());
				//System.out.println("reservoirObj.getdutyfreqId"+reservoirObj.getDutyFrequencyId());
				//System.out.println("reservoirObj.getYear()"+reservoirObj.getYear());
				//System.out.println("reservoirObj.getDesignationId()"+reservoirObj.getDesignationId());
				
				if(reservoirObj.getUnitId()==null && reservoirObj.getDutyFrequencyId()!=null && reservoirObj.getYear()!=null   ){
					
					/*if(reservoirObj.getUnitId()>0  ){*/
			resUnitData=irm.getAllrestotalnrldresList(reservoirObj);
			//resInspectinf = irm.getResInspectInfobyUnitId(reservoirObj);
			
			
			//System.out.println("resUnitData"+resUnitData);
			//System.out.println("resInspectinf"+resInspectinf);
					/*}*/
				}
			}
			
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		mav.addObject("resUnitData",resUnitData);
		
		mav.addObject("resYear",reservoirObj.getYear());
		mav.addObject("resFrequency",reservoirObj.getDutyFrequencyId());
	//	mav.addObject("resInspectinf",resInspectinf);
		//mav.addObject("selectedunitId",reservoirObj.getUnitId());
		//mav.addObject("selectedStatusId",reservoirObj.getResStatusId());
		 
		return mav;
		
		 
		

	}
	
	
	
	
	
	

	@RequestMapping(value = "/invReport/res-ann1-res-Info")
	@ResponseBody
	public String Resann1resInfo(ReservoirInspect resObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirUnitData> resinfoann1 = new ArrayList<ReservoirUnitData>();

		try {

			if (resObj.getReservoirId() != null && resObj.getYear()!=null && resObj.getUnitId()!=null ) {
				resinfoann1 = irm.getinvomresann1resInfobyrescode(resObj);
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resinfoann1);
		

		

	}
	
	@RequestMapping(value = "/invReport/res-ann1-gen-Info")
	@ResponseBody
	public String Resann1genInfo(ReservoirInspect resObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resinfoann1 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resinfoann1List = new ArrayList<ReservoirInspect>();

		try {

			if (resObj.getReservoirId() != null && resObj.getYear()!=null && resObj.getUnitId()!=null ) {
				resinfoann1 = irm.getResAnn1tabsInfo(resObj);
			}

			
for(int i=0; i<resinfoann1.size(); i++){
				
				if(resinfoann1.get(i).getResCatId()==1 ){
			// System.out.println("resListbyId"+resListbyId);
					
					resinfoann1List.add(resinfoann1.get(i));
				}
}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("resinfoann1Listgen"+resinfoann1List);

		return new Gson().toJson(resinfoann1List);
		

		

	}
	
	@RequestMapping(value = "/invReport/res-ann1-ear-Info")
	@ResponseBody
	public String Resann1earInfo(ReservoirInspect resObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resinfoann1 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resinfoann1List = new ArrayList<ReservoirInspect>();

		try {

			if (resObj.getReservoirId() != null && resObj.getYear()!=null && resObj.getUnitId()!=null ) {
				resinfoann1 = irm.getResAnn1tabsInfo(resObj);
			}

			
for(int i=0; i<resinfoann1.size(); i++){
				
				if(resinfoann1.get(i).getResCatId()==2 ){
			// System.out.println("resListbyId"+resListbyId);
					
					resinfoann1List.add(resinfoann1.get(i));
				}
}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println("resinfoann1Listear"+resinfoann1List);
		return new Gson().toJson(resinfoann1List);
		

		

	}
	
	@RequestMapping(value = "/invReport/res-ann1-con-Info")
	@ResponseBody
	public String Resann1conInfo(ReservoirInspect resObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resinfoann1 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resinfoann1List = new ArrayList<ReservoirInspect>();

		try {

			if (resObj.getReservoirId() != null && resObj.getYear()!=null && resObj.getUnitId()!=null ) {
				resinfoann1 = irm.getResAnn1tabsInfo(resObj);
			}

			
for(int i=0; i<resinfoann1.size(); i++){
				
				if(resinfoann1.get(i).getResCatId()==3 ){
			// System.out.println("resListbyId"+resListbyId);
					
					resinfoann1List.add(resinfoann1.get(i));
				}
}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("resinfoann1Listcon"+resinfoann1List);
		return new Gson().toJson(resinfoann1List);
		

		

	}
	
	@RequestMapping(value = "/invReport/res-ann1-om-Info")
	@ResponseBody
	public String Resann1omInfo(ReservoirInspect resObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resinfoann1 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resinfoann1List = new ArrayList<ReservoirInspect>();

		try {

			if (resObj.getReservoirId() != null && resObj.getYear()!=null && resObj.getUnitId()!=null ) {
				resinfoann1 = irm.getResAnn1tabsInfo(resObj);
			}

			
for(int i=0; i<resinfoann1.size(); i++){
				
				if(resinfoann1.get(i).getResCatId()==4 ){
			// System.out.println("resListbyId"+resListbyId);
					
					resinfoann1List.add(resinfoann1.get(i));
				}
}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("resinfoann1Listom"+resinfoann1List);

		return new Gson().toJson(resinfoann1List);
		

		

	}
	
	@RequestMapping(value = "/invReport/res-ann2-abstract")
	public ModelAndView resann2abstract(@ModelAttribute("reservoirInspect2") ReservoirInspect reservoirObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("res-ann2-Abstract");
		
		
	
		
		List<InvResAbstract> invResList = new ArrayList<InvResAbstract>()	;
		
	
			
			try {
				if(reservoirObj!=null){
					if(reservoirObj.getYear()!=null){
				if(reservoirObj.getYear()>0){
				invResList=irm.getResAbstractAnn2List(reservoirObj);
				}
					}
				}
				
				mav.addObject("invResList",invResList);	
			
				
			} catch (InventoryUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		
		
		 
		 
		return mav;

	}
	
	
	@RequestMapping(value = "/invReport/res-ann2-res-Info")
	@ResponseBody
	public String Resann2resInfo(Integer mst1Id, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirUnitData> resinfoann2 = new ArrayList<ReservoirUnitData>();

		try {

			if (mst1Id!=null) {
				resinfoann2 = irm.getinvomresann2resInfobyrescode(mst1Id);
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resinfoann2);
		

		

	}
	
	@RequestMapping(value = "/invReport/res-ann2-gen-Info")
	@ResponseBody
	public String Resann2genInfo(Integer mst1Id, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resinfoann2 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resinfoann2List = new ArrayList<ReservoirInspect>();

		try {

			if (mst1Id!=null ) {
				resinfoann2 = irm.getResAnn2tabsInfo(mst1Id);
			}

			
for(int i=0; i<resinfoann2.size(); i++){
				
				if(resinfoann2.get(i).getResCatId()>=9 && resinfoann2.get(i).getResCatId()<=17 ){
			// System.out.println("resListbyId"+resListbyId);
					
					resinfoann2List.add(resinfoann2.get(i));
				}
}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resinfoann2List);
		

		

	}
	
	@RequestMapping(value = "/invReport/res-ann2-con-Info")
	@ResponseBody
	public String Resann2conInfo(Integer mst1Id, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resinfoann2 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resinfoann2List = new ArrayList<ReservoirInspect>();

		try {

			if (mst1Id!=null ) {
				resinfoann2 = irm.getResAnn2tabsInfo(mst1Id);
			}

			
for(int i=0; i<resinfoann2.size(); i++){
				
				if(resinfoann2.get(i).getResCatId()>=18 && resinfoann2.get(i).getResCatId()<=33 ){
			// System.out.println("resListbyId"+resListbyId);
					
					resinfoann2List.add(resinfoann2.get(i));
				}
}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resinfoann2List);
		

		

	}

	
	@RequestMapping(value = "/invReport/res-ann2-comm-Info")
	@ResponseBody
	public String Resann2commInfo(Integer mst1Id, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resinfoann2 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resinfoann2List = new ArrayList<ReservoirInspect>();

		try {

			if (mst1Id!=null ) {
				resinfoann2 = irm.getResAnn2tabsInfo(mst1Id);
			}

			
for(int i=0; i<resinfoann2.size(); i++){
				
				if(resinfoann2.get(i).getResCatId()==7 ){
			// System.out.println("resListbyId"+resListbyId);
					
					resinfoann2List.add(resinfoann2.get(i));
				}
}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resinfoann2List);
		

		

	}

	
	@RequestMapping(value = "/invReport/res-ann2-asses-Info")
	@ResponseBody
	public String Resann2geassesInfo(Integer mst1Id, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resinfoann2 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resinfoann2List = new ArrayList<ReservoirInspect>();

		try {

			if (mst1Id!=null ) {
				resinfoann2 = irm.getResAnn2tabsInfo(mst1Id);
			}

			
for(int i=0; i<resinfoann2.size(); i++){
				
				if(resinfoann2.get(i).getResCatId()==8 ){
			// System.out.println("resListbyId"+resListbyId);
					
					resinfoann2List.add(resinfoann2.get(i));
				}
}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resinfoann2List);
		

		

	}


	
	
	@RequestMapping(value = "/invReport/Schedule-Duty-Report")
	public ModelAndView ScheduleDutyReport(@ModelAttribute("scheduleduty") ScheduleDuty scResObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("Schedule-Duty-Report");
		
		
	
		
		List<ScheduleDuty> listdata = new ArrayList<ScheduleDuty>()	;
		
	Integer totaldutycount=0;
			
			try {
				if(scResObj!=null){
					
					//System.out.println("date1"+scResObj.getFromDate1()+"date2"+scResObj.getFromDate2());
					if(scResObj.getFromDate1()!=null && scResObj.getFromDate2()!=null && scResObj.getDutyFrequencyId()!=null){
			
						listdata=irm.getScheduledutyaeedaily(scResObj);
						
					//	System.out.println("listdata"+listdata);	
						if(listdata!=null){
							
							for(int i=0;i<listdata.size();i++){
								
								totaldutycount=listdata.get(i).getTotalDutyCount();
								
							}
							
							if(totaldutycount>0){
								
								mav.addObject("totaldutycount",totaldutycount);	
								
							}
							
						}
				
				if(scResObj.getDutyFrequencyId()>0){
					
					if(scResObj.getDutyFrequencyId()==1){
						
						mav.addObject("headth","Daily");
						
						mav.addObject("aeedaily",listdata);	
						
					}
if(scResObj.getDutyFrequencyId()==2){
						
						mav.addObject("headth","Weekly");
						
						mav.addObject("aeeweekly",listdata);	
						
					}
					
				}
				
					}
					
				
				}
				
				
			
				
			} catch (InventoryUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		
		
		 
		 
		return mav;

	}
	
	@RequestMapping(value = "/invReport/sch-res-Info")
	@ResponseBody
	public String schresInfo(ReservoirInspect resObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirUnitData> resinfosch = new ArrayList<ReservoirUnitData>();

		try {

			if (resObj.getResCode() != null  && resObj.getUnitId()!=null && resObj.getDesignationId()!=null && resObj.getDutyFrequencyId()!=null ) {
				resinfosch = irm.getschaeedailyresinfo(resObj);
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resinfosch);

		

	}
	
	@RequestMapping(value = "/invReport/sch-inpsect-info")
	@ResponseBody
	public String schinspectinfo(ScheduleDuty scobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ScheduleDuty> sch1 = new ArrayList<ScheduleDuty>();
		
	//	List<ScheduleDuty> sch2 = new ArrayList<ScheduleDuty>();

		try {

			if (scobj.getResCode() != null  && scobj.getUnitId()!=null ) {
				sch1 = irm.getSchInspectinfo(scobj);
			}

			

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(sch1);
		

		

	}

	
	
	
	@RequestMapping(value = "/invReport/pump-station-maintenance")
	public ModelAndView pumpStationMaintenance(@ModelAttribute("Pumpmainactivity") PumpMaintainActivities pumpObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("pump-station-maintenance");
		
		
	
		
		List<PumpMaintainActivities> listdata = new ArrayList<PumpMaintainActivities>()	;
		
	Integer totaldutycount=0;
			
		try {
				if(pumpObj!=null){
					
					//System.out.println("date1"+scResObj.getFromDate1()+"date2"+scResObj.getFromDate2());
					if(pumpObj.getFromDate1()!=null && pumpObj.getFromDate2()!=null && pumpObj.getDutyFrequencyId()!=null){
			
						listdata=irm.getpumpmaintainActivity(pumpObj);
						
					//	System.out.println("listdata"+listdata);	
						if(listdata!=null){
							
							for(int i=0;i<listdata.size();i++){
								
								totaldutycount=listdata.get(i).getTotalDutyCount();
								
							}
							
							if(totaldutycount>0){
								
								mav.addObject("totaldutycount",totaldutycount);	
								
							}
							
						}
				
				if(pumpObj.getDutyFrequencyId()>0){
					
					if(pumpObj.getDutyFrequencyId()==1){
						
						mav.addObject("headth","Daily");
						
						mav.addObject("pumpdaily",listdata);	
						
					}
if(pumpObj.getDutyFrequencyId()==2){
						
						mav.addObject("headth","Weekly");
						
						mav.addObject("pumpweekly",listdata);	
						
					}
					
				}
				
					}
					
				
				}
				
				
			
				
			} catch (InventoryUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		
		
		 
		 
		return mav;

	}
	
	@RequestMapping(value = "/invReport/pump-main-Info")
	@ResponseBody
	public String pumpmainInfo(PumpStations pumpObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<PumpStations> pumpmaininfo = new ArrayList<PumpStations>();

		 ///System.out.println("coming here"+pumpObj);
		try {
			
			// System.out.println("coming here"+pumpObj.getPumpStationId()+"sdd"+pumpObj.getUnitId()+"ds"+pumpObj.getDutyFrequencyId());

			if (pumpObj.getPumpStationId() != null  && pumpObj.getUnitId()!=null  && pumpObj.getDutyFrequencyId()!=null ) {
				
				
				pumpmaininfo = irm.getpumpmaintainpumpinfo(pumpObj);
			}

			

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(pumpmaininfo);

		

	}
	
	@RequestMapping(value = "/invReport/pump-inpsect-info")
	@ResponseBody
	public String pumpinspectinfo(PumpMaintainActivities pumpObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<PumpMaintainActivities> sch1 = new ArrayList<PumpMaintainActivities>();
		
	//	List<ScheduleDuty> sch2 = new ArrayList<ScheduleDuty>();

		try {

			if (pumpObj.getPumpStationId() != null  && pumpObj.getUnitId()!=null ) {
				sch1 = irm.getpumpmaintainInspectinfo(pumpObj);
			}

			

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(sch1);
		

		

	}
	
	
	@RequestMapping(value = "/invReport/TankUnitDetails")
	@ResponseBody
	public String TankUnitDetails( MiTankInspect mitankObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
	//	mav.setViewName("TankchecksDetail");
		
	//	System.out.println(" TankUnitDetails mitankObj"+mitankObj);
		List<MiTankInspect> miTankUnitdetail= new ArrayList<MiTankInspect>();
		try{
		
		if(mitankObj.getUnitId()!=null &&  mitankObj.getTankStatusId()!=null && mitankObj.getMiTankFreqId()!=null && mitankObj.getYear()!=null ){
			
			/*System.out.println(mitankObj.getUnitId());
			System.out.println(mitankObj.getCircleId());
			System.out.println(mitankObj.getDivisionId());
			System.out.println(mitankObj.getSubdivisionId());
			System.out.println(mitankObj.getDesignationId());
			System.out.println(mitankObj.getPostId());*/
			
			miTankUnitdetail=   irm.getMiTankUnitAbstractDetail(mitankObj);
			
			
			//mav.addObject("miTankUnitdetail",miTankUnitdetail);
			
			////miTankAbstract2 = invam.getReservoirScheduleofDuties();

			

		//	System.out.println("miTankUnitdetail"+miTankUnitdetail);
			String jsonstr=new Gson().toJson(miTankUnitdetail);
	//		System.out.println("jsonstr "+jsonstr);

			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Gson().toJson(miTankUnitdetail);
		

	}
	
	@RequestMapping(value = "/invReport/TankcapayacutDetail")
	@ResponseBody
	public String Tankcapayacutdetail(MiTankInspect mitankObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("TankchecksDetail");
		
		//System.out.println("capacity-detail-mitankObj "+mitankObj);
		
	
		List<MiTankInspect> miTankcapayacutdetail= new ArrayList<MiTankInspect>();
		try{
		
		if(mitankObj.getUnitId()!=null  ){
			
			miTankcapayacutdetail=   irm.getMiTankCapAayacutDetail(mitankObj);
			
			//System.out.println("miTankcapayacutdetail "+miTankcapayacutdetail);
			
			//mav.addObject("miTankcapayacutdetail",miTankcapayacutdetail);
			
			////miTankAbstract2 = invam.getReservoirScheduleofDuties();
			
			//System.out.println("miTankAbstract2"+miTankAbstract2);
			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return new Gson().toJson(miTankcapayacutdetail);

	}
	
	@RequestMapping(value = "/invtsimis/get-mst1-remarks-bysluiceid")
	@ResponseBody
	public String getMst1RemarksbysluiceId(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		List<MiTankInspect> tabwiseremarks = new ArrayList<MiTankInspect>();
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(miobj.getMiInpsectMst1Id()!=null){
				if (miobj.getMiInpsectMst1Id()>0 ) {
					miTankInspect = invam.viewMst1Remarks(miobj.getMiInpsectMst1Id());
				}
				/*
				if(miobj.getTabId()!=null){
					
					if(miTankInspect!=null){
						
						for(int i=0; i<miTankInspect.size(); i++){
							
							if(miTankInspect.get(i).getTabId()==miobj.getTabId()){
							tabwiseremarks.add(miTankInspect.get(i));
							}
							
						}
						
					}
					
				}*/
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	
	
	
	@RequestMapping(value = "/form20report/downloadform20PDF")
	public ModelAndView downloadForm20PDF(MiTankformData  formData )throws InventoryUserException  {
		// create some sample data
		//System.out.println("cont formDataId"+formDataId);
		ModelAndView mav = new ModelAndView();
		MiTankformData  formdata = new MiTankformData();
		List<MiTankformData> formDetailList = new ArrayList<MiTankformData>();
		List<MiTankFormDocs> form20DocsList = new ArrayList<MiTankFormDocs>();
		List<MiTankformData> IrrisrcList = new ArrayList<MiTankformData>();
try {
			if(formData!=null){
			if(formData.getFormDataId()!=0){
				formdata=irm.getform20TankDataByIdPdf(formData);
				formDetailList=irm.getform20TankDetailListByIdPdf(formData);
				IrrisrcList=invam.getFrmIrrSrcList();
				
			//	System.out.println("cont formdata"+formdata);
				//System.out.println("cont formDetailList"+formDetailList);
				form20DocsList=irm.getForm20AllDocs(formData);
			//	System.out.println("cont form20DocsList"+form20DocsList);
				//System.out.println("cont formDetailList"+formDetailList.size());
			}
			
		}
}

catch (InventoryUserException e) {
			e.printStackTrace();
		} 
		mav.setViewName("Form20DetailPDFView");//check in views properties file
		
		mav.addObject("listform20Tanks" ,formdata);
		mav.addObject("listform20Detail" ,formDetailList);
		mav.addObject("form20DocsList" ,form20DocsList);
		mav.addObject("IrrisrcList" ,IrrisrcList);
		// return a view which will be resolved by an excel view resolver
		return mav ;
	}
	
	
	@RequestMapping(value = "/form20report/form20PDFDownloaddata")
	public ModelAndView form20PDFDownloaddata(MiTankformData  formData )throws InventoryUserException  {
		// create some sample data
		//System.out.println("cont formDataId"+formDataId);
		ModelAndView mav = new ModelAndView();
		MiTankformData  formdata = new MiTankformData();
		//List<MiTankformData> formDetailList = new ArrayList<MiTankformData>();
		List<MiTankFormDocs> form20DocsList = new ArrayList<MiTankFormDocs>();
		//List<MiTankformData> IrrisrcList = new ArrayList<MiTankformData>();
try {
			
			if(formData.getFormDataId()!=0){
				formdata=irm.getform20TankDataByIdPdf(formData);
				//formDetailList=irm.getform20TankDetailListByIdPdf(formDataId);
				//IrrisrcList=invam.getFrmIrrSrcList();
				
			//	System.out.println("cont formdata"+formdata);
				//System.out.println("cont formDetailList"+formDetailList);
				form20DocsList=irm.getForm20AllDocs(formData);
			//	System.out.println("cont form20DocsList"+form20DocsList);
				//System.out.println("cont formDetailList"+formDetailList.size());
			}
			
		}

catch (InventoryUserException e) {
			e.printStackTrace();
		} 
		mav.setViewName("pdfForm20Downloads");//check in views properties file
		
		mav.addObject("listform20Tanks" ,formdata);
		//mav.addObject("listform20Detail" ,formDetailList);
		mav.addObject("form20DocsList" ,form20DocsList);
	//	mav.addObject("IrrisrcList" ,IrrisrcList);
		// return a view which will be resolved by an excel view resolver
		return mav ;
	}
	
	@RequestMapping(value = "/invReport/tank-form20-ab-detail")
	public ModelAndView TankForm20abreport(@ModelAttribute("mitankform20rpt") MiTankformData miobj, SessionStatus status,
			HttpSession session) throws InventoryUserException {
		ModelAndView mav = new ModelAndView();
		//System.out.println("miformObj"+miobj.getCatId());
		
	//System.out.println("miformObj"+miobj.getOffAccess());
	//	mav.setViewName("tank-form20-report");  
		//mav.setViewName("left-menu-home");  
		mav.setViewName("form20-abstract");
		List<MiTankformData> selectFormYear = new ArrayList<MiTankformData>();
		//List<MiTankInspect> selectTankYear= new ArrayList<MiTankInspect>();
		
	try{	
		if(miobj.getUnitId()!=null && (miobj.getTsfcFormYear()!=null  ||  (miobj.getFrmFromDate()!=null && miobj.getFrmToDate()!=null) )   ){
			
			/*System.out.println("form 20 detail");
			System.out.println(miobj.getUnitId());
			System.out.println(miobj.getCircleId());
			System.out.println(miobj.getDivisionId());
			System.out.println(miobj.getSubDivisionId());
			System.out.println(miobj.getDesignationId());
			System.out.println(miobj.getPostId());*/
		/*System.out.println(miobj.getTankStatusId());
			System.out.println(miobj.getMiTankFreqId());*/
			//System.out.println("year"+miobj.getTsfcFormYear());
			//System.out.println("frmdate"+miobj.getFrmFromDate());
			//System.out.println("todate"+miobj.getFrmToDate());
			//System.out.println("catid"+miobj.getCatId());
			
		/*	selectTankYear = irm.getmiTankSelectYear();
			if(selectTankYear!=null){
        mav.addObject("selectTankYear",selectTankYear);
       // System.out.println("inrc selectTankYear "+selectTankYear);
		}*/
			selectFormYear = irm.getForm20SelectYear();
			   if(selectFormYear!=null){
             mav.addObject("selectFormYear",selectFormYear);
            // System.out.println("selectFormYear "+selectFormYear);
			   }
			List<MiTankformData> miTankForm20detail= new ArrayList<MiTankformData>();
			miTankForm20detail = irm.getMiTankFormAbstractDetail(miobj);
			//miTankForm20detail=   irm.getMiTankFormAbstractDetail(miobj); 
			
			//System.out.println("miTankForm20detail"+miTankForm20detail);
			if(miobj.getCatId()==1){
			mav.addObject("miTankForm20detail",miTankForm20detail);
			}
			
			if(miobj.getCatId()==2){
				mav.addObject("miReservoirForm20detail",miTankForm20detail);
				}
			
			if(miobj.getCatId()==3){
				mav.addObject("miCanalForm20detail",miTankForm20detail);
				}
			
			mav.addObject("frmdetailYear",miobj.getTsfcFormYear());
			
			mav.addObject("frmdetailFromDate",miobj.getFrmFromDate());
			
			mav.addObject("frmdetailToDate",miobj.getFrmToDate());
			
			//System.out.println("frmdetailYear"+miobj.getTsfcFormYear());
			
		
		
	
	}

	}	
		catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 	 mav;

	}
	
	
	@RequestMapping(value = "/invReport/tank-fdr-ab-detail")
	public ModelAndView TankFdrabreport(@ModelAttribute("mitankform20rpt") MiTankformData miobj, SessionStatus status,
			HttpSession session) throws InventoryUserException {
		ModelAndView mav = new ModelAndView();
		System.out.println("miformObj"+miobj.getUnitId());
		System.out.println("miformObj"+miobj.getTsfcFormYear());
		
	//System.out.println("miformObj"+miobj.getOffAccess());
	//	mav.setViewName("tank-form20-report");  
		//mav.setViewName("left-menu-home");  
		mav.setViewName("fdr-abstract");
		List<MiTankformData> selectFormYear = new ArrayList<MiTankformData>();
		//List<MiTankInspect> selectTankYear= new ArrayList<MiTankInspect>();
		
	try{	
		if(miobj.getUnitId()!=null && (miobj.getTsfcFormYear()!=null  ||  (miobj.getFrmFromDate()!=null && miobj.getFrmToDate()!=null) )   ){
			
			
			selectFormYear = irm.getForm20SelectYear();
			   if(selectFormYear!=null){
             mav.addObject("selectFormYear",selectFormYear);
             System.out.println("selectFormYear "+selectFormYear);
			   }
			List<MiTankformData> miTankForm20detail= new ArrayList<MiTankformData>();
			miTankForm20detail = irm.getMiTankFDRAbstractDetail(miobj);
		
			
			System.out.println("miTankForm20detail"+miTankForm20detail);
			if(miobj.getUnitId()!=null){
			mav.addObject("miTankForm20detail",miTankForm20detail);
			}
			
			
			
			
			
			mav.addObject("frmdetailYear",miobj.getTsfcFormYear());
			
			mav.addObject("frmdetailFromDate",miobj.getFrmFromDate());
			
			mav.addObject("frmdetailToDate",miobj.getFrmToDate());
			
			//System.out.println("frmdetailYear"+miobj.getTsfcFormYear());
			
		
		
	
	}

	}	
		catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 	 mav;

	}
	
	
	@RequestMapping(value = "/invrest/repeatedTanksBreach",  method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String getRepeatedTanksDataBreach( )  {
		
		
//	System.out.println("nextcome"+paraId);	
		  List<MiTankformData> repeatedCountAbstBreach= new ArrayList<MiTankformData>();
	try {
		repeatedCountAbstBreach=invam.getRepeatedTankResCanalBreachList();
		
		//mav.addObject("repeatedCountAbst",repeatedCountAbst);
		
	} catch (InventoryUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new Gson().toJson(repeatedCountAbstBreach);
	}
	
	@RequestMapping(value = "/invrest/repeatedTanksDamage",  method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String getRepeatedTanksDataDamage( )  {
		
		
//	System.out.println("nextcome"+paraId);	
		  List<MiTankformData> repeatedCountAbstdamage= new ArrayList<MiTankformData>();
	try {
			repeatedCountAbstdamage=invam.getRepeatedTankResCanalLDamageist();
		
		//mav.addObject("repeatedCountAbst",repeatedCountAbst);
		
	} catch (InventoryUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new Gson().toJson(repeatedCountAbstdamage);
	}
	
	
	@RequestMapping(value = "/invReport/tank-form20-ab")
	public ModelAndView tankForm20ab(@ModelAttribute("mitankform20rpt") MiTankformData miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		//System.out.println("Hi");
	//	live
//	mav.setViewName("left-menu-home");
	//local	
		mav.setViewName("form20-abstract");
		
		//System.out.println("miobj came here "+miobj.getFrmFromDate());
		//System.out.println("miobj came here "+miobj.getFrmToDate());
		
		
		
	//	System.out.println("cont tankForm20ab"+miobj);
		List<MiTankformData> mifrom20Abst= new ArrayList<MiTankformData>();
		List<MiTankformData> miTankUnitdetail= new ArrayList<MiTankformData>();
		List<MiTankformData> mifromAbst= new ArrayList<MiTankformData>();
		List<MiTankInspect> selectTankYear= new ArrayList<MiTankInspect>();
		List<MiTankformData> selectFormYear = new ArrayList<MiTankformData>();
		
		
		List<MiTankformData> mifrom20tankabst= new ArrayList<MiTankformData>();
		List<MiTankformData> mifrom20resabst= new ArrayList<MiTankformData>();
		List<MiTankformData> mifrom20canalabst= new ArrayList<MiTankformData>();
		Integer dbdesg=0;
		
        Double tankstotalApc=0.0;        
        Double tankstotalAtc=0.0;        
        Double tankstotalAtr=0.0;        
        Integer tankstotalbc=0;        
        Integer tankstotaldc=0;        
        Integer tankstotaltc=0;
        
        Double restotalApc=0.0;        
        Double restotalAtc=0.0;        
        Double restotalAtr=0.0;        
        Integer restotalbc=0;        
        Integer restotaldc=0;        
        Integer restotaltc=0;
        
        Double cantotalApc=0.0;        
        Double cantotalAtc=0.0;        
        Double cantotalAtr=0.0;        
        Integer cantotalbc=0;        
        Integer cantotaldc=0;        
        Integer cantotaltc=0;
        
        Integer frmYear=0;
        
        String finalSumtankstotalApc=null;
        String finalSumtankstotalAtc=null;
        String finalSumtankstotalAtr=null;
        
        String finalSumrestotalApc=null;
        String finalSumrestotalAtc=null;
        String finalSumrestotalAtr=null;
        
        String finalSumcantotalApc=null;
        String finalSumcantotalAtc=null;
        String finalSumcantotalAtr=null;
        
        String dateRange=null;
        
      
		
		try {
			
		
			
			selectTankYear = irm.getmiTankSelectYear();
			if(selectTankYear!=null){
        mav.addObject("selectTankYear",selectTankYear);
      //  System.out.println("inrc selectTankYear "+selectTankYear);
		}
			
			   selectFormYear = irm.getForm20SelectYear();
 			   if(selectFormYear!=null){
                mav.addObject("selectFormYear",selectFormYear);
            //   System.out.println("selectFormYear "+selectFormYear);
 			   }
		if(miobj.getTsfcFormYear()!=null || (miobj.getFrmFromDate()!=null && miobj.getFrmToDate()!=null )   ){
			if(miobj.getTsfcFormYear()>0  ||  (miobj.getFrmFromDate().length()>0 && miobj.getFrmToDate().length()>0 ) ){	
				if(miobj.getCircleId()==null){
					miobj.setCircleId(0);
				}
	                if(miobj.getDivisionId()==null){
					miobj.setDivisionId(0);
				}
	                if(miobj.getSubDivisionId()==null){
						miobj.setSubDivisionId(0);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
					}
	                
				/*System.out.println(miobj.getUnitId());
				System.out.println(miobj.getCircleId());
				System.out.println(miobj.getDivisionId());
			    System.out.println(miobj.getSubDivisionId());
				System.out.println(miobj.getDesignationId());
				System.out.println(miobj.getListDesignationId());
				System.out.println(miobj.getPostId());
				System.out.println("offaccess "+miobj.getOffAccess());
				System.out.println("getTsfcFormYear "+miobj.getTsfcFormYear());
				
				System.out.println("userdesg "+miobj.getUserDesignationId());*/
				/*System.out.println("userunit "+miobj.getUserUnitId());
				System.out.println("usercircle "+miobj.getUserCircleId());
				System.out.println("userdivision "+miobj.getUserDivisionId());
				System.out.println("userSubdivision "+miobj.getUserSubdivisionId());
				System.out.println("backdesg "+miobj.getBackdesignationId());*/
	                
	              
	                
	              
	                
	                mifrom20Abst = irm.getMiTankForm20Abstract(miobj);
	                
	             
	                frmYear=miobj.getTsfcFormYear();
	                
	                
	                
	                mav.addObject("frmYear",frmYear);
	                
	                mav.addObject("fromdate",miobj.getFrmFromDate());
	                
	                mav.addObject("todate",miobj.getFrmToDate());
	                
	                
	             
	             
				//	System.out.println("mifrom20Abst "+mifrom20Abst);
					
						if(mifrom20Abst!=null ){
							
							 /*Double sacp=rs.getDouble(16);
					        Double sacplakhs=(sacp/100000.00);
					        DecimalFormat f2 = new DecimalFormat("##.00"); 
							 String finalSumAprxCostPermt=  f2.format(sacplakhs);
							 
							 Double sact=rs.getDouble(17);
						        Double sactlakhs=(sact/100000.00);
							 DecimalFormat f3 = new DecimalFormat("##.00"); 
							 String finalSumAprxCostTemp=  f3.format(sactlakhs);
							 
							 Double srpt=rs.getDouble(18);
						        Double srptlakhs=(srpt/100000.00);
							 DecimalFormat f4 = new DecimalFormat("##.00"); 
							 String finalSumRepairsPermTemp=  f4.format(srptlakhs);*/
							
							Integer ablength=mifrom20Abst.size();
							
						for(int k=0 ; k<ablength ; k++){
							
							
							
							if(mifrom20Abst.get(k).getCatId()==1  ){
							
								
								
								mifrom20tankabst.add(mifrom20Abst.get(k));
								
								
								
								
								 
                            	
								//System.out.println("mifrom20Abst.get(k).getSumAprxCostTemp()"+mifrom20Abst.get(k).getSumAprxCostTemp());
								
								tankstotalApc=tankstotalApc+mifrom20Abst.get(k).getSumAprxCostPermt();
								
								 DecimalFormat acp = new DecimalFormat("##.00"); 
								  finalSumtankstotalApc=  acp.format(tankstotalApc);
								 
								tankstotalAtc=tankstotalAtc+mifrom20Abst.get(k).getSumAprxCostTemp();
								
								DecimalFormat atc = new DecimalFormat("##.00"); 
								  finalSumtankstotalAtc=  atc.format(tankstotalAtc);
								 
								tankstotalAtr=tankstotalAtr+mifrom20Abst.get(k).getSumRepairsPermTemp();
								
								 DecimalFormat atr = new DecimalFormat("##.00"); 
								  finalSumtankstotalAtr=  atr.format(tankstotalAtr);
								
								
								
								tankstotalbc=tankstotalbc+mifrom20Abst.get(k).getBreachCount();
								tankstotaldc=tankstotaldc+mifrom20Abst.get(k).getDamageCount();
								tankstotaltc=tankstotaltc+mifrom20Abst.get(k).getTotalTankCount();
								
								//System.out.println("tankstotalAtc"+tankstotalAtc);
								
								
								
								
								
                            		
								 
							}
							
							
							
                             if(mifrom20Abst.get(k).getCatId()==2  ){
								
								
                            	// System.out.println("before res"+mifrom20Abst.get(k).getTotalTankCount());
                            	 mifrom20resabst.add(mifrom20Abst.get(k));
                            	 
                            	 
                            	
                       
 								
 								restotalApc=restotalApc+mifrom20Abst.get(k).getSumAprxCostPermt();
 								
 								 DecimalFormat resacp = new DecimalFormat("##.00"); 
								  finalSumrestotalApc=  resacp.format(restotalApc);
 								
 								restotalAtc=restotalAtc+mifrom20Abst.get(k).getSumAprxCostTemp();
 								
 								 DecimalFormat resatc = new DecimalFormat("##.00"); 
								  finalSumrestotalAtc=  resatc.format(restotalAtc);
								  
 								restotalAtr=restotalAtr+mifrom20Abst.get(k).getSumRepairsPermTemp();
 								
 								 DecimalFormat resatr = new DecimalFormat("##.00"); 
								  finalSumrestotalAtr=  resatr.format(restotalAtr);
 								
 								
 								restotalbc=restotalbc+mifrom20Abst.get(k).getBreachCount();
 								restotaldc=restotaldc+mifrom20Abst.get(k).getDamageCount();
 								restotaltc=restotaltc+mifrom20Abst.get(k).getTotalTankCount();
                            		
                            	 
							}
                            
                             
                             if(mifrom20Abst.get(k).getCatId()==3  ){
                            	 
                            	
 								
 								
                            	 mifrom20canalabst.add(mifrom20Abst.get(k));
                            	 
                            	
                            		
                            	 cantotalApc=cantotalApc+mifrom20Abst.get(k).getSumAprxCostPermt();
                            	 
                            	 DecimalFormat canapc = new DecimalFormat("##.00"); 
								  finalSumcantotalApc=  canapc.format(cantotalApc);
								  
  								cantotalAtc=cantotalAtc+mifrom20Abst.get(k).getSumAprxCostTemp();
  								
  								 DecimalFormat canatc = new DecimalFormat("##.00"); 
								  finalSumcantotalAtc=  canatc.format(cantotalAtc);
								  
  								cantotalAtr=cantotalAtr+mifrom20Abst.get(k).getSumRepairsPermTemp();
  								
  								 DecimalFormat canatr = new DecimalFormat("##.00"); 
								  finalSumcantotalAtr=  canatr.format(cantotalAtr);
								  
  								cantotalbc=cantotalbc+mifrom20Abst.get(k).getBreachCount();
  								cantotaldc=cantotaldc+mifrom20Abst.get(k).getDamageCount();
  								cantotaltc=cantotaltc+mifrom20Abst.get(k).getTotalTankCount();
  								
                            		
                            	 
							}
							
							
						}	
							
							
						mav.addObject("mifrom20tankabst",mifrom20tankabst);
						mav.addObject("mifrom20resabst",mifrom20resabst);
						mav.addObject("mifrom20canalabst",mifrom20canalabst);
						
						//System.out.println("mifrom20tankabst"+mifrom20tankabst);
						//System.out.println("mifrom20resabst"+mifrom20resabst);
						//System.out.println("mifrom20canalabst"+mifrom20canalabst);
					
						
						
						//totals of tank
						
						//tankstotalAtc=(double) Math.round(tankstotalAtc);
						
						//System.out.println("tankstotalAtc"+tankstotalAtc);
						
						mav.addObject("tankstotalApc",finalSumtankstotalApc);
						mav.addObject("tankstotalAtc",finalSumtankstotalAtc);
						mav.addObject("tankstotalAtr",finalSumtankstotalAtr);
						
						mav.addObject("tankstotalbc",tankstotalbc);
						mav.addObject("tankstotaldc",tankstotaldc);
						mav.addObject("tankstotaltc",tankstotaltc);
						
						
                                //totals of res
						
						mav.addObject("restotalApc",finalSumrestotalApc);
						mav.addObject("restotalAtc",finalSumrestotalAtc);
						mav.addObject("restotalAtr",finalSumrestotalAtr);
						
						mav.addObject("restotalbc",restotalbc);
						mav.addObject("restotaldc",restotaldc);
						mav.addObject("restotaltc",restotaltc);
						
						
                                     //totals of canal
						
						mav.addObject("cantotalApc", finalSumcantotalApc);
						mav.addObject("cantotalAtc",finalSumcantotalAtc);
						mav.addObject("cantotalAtr",finalSumcantotalAtr);
						
						mav.addObject("cantotalbc",cantotalbc);
						mav.addObject("cantotaldc",cantotaldc);
						mav.addObject("cantotaltc",cantotaltc);
						
						
						
							//mav.addObject("mifrom20Abst",mifrom20Abst);
							
							mav.addObject("frmdesgId",miobj.getDesignationId());
							mav.addObject("frmListdesgId",miobj.getListDesignationId());
							
							mav.addObject("frmunitId",miobj.getUnitId());
							mav.addObject("frmcircleId",miobj.getCircleId());
							mav.addObject("fmdivId",miobj.getDivisionId());
							mav.addObject("frmsubdivId",miobj.getSubDivisionId());
							mav.addObject("frmyear",miobj.getTsfcFormYear());
							mav.addObject("frmpost",miobj.getPostId());
							mav.addObject("frmOffAccess",miobj.getOffAccess());
							
							/*System.out.println("frmunitId"+miobj.getUnitId());
							System.out.println("frmcircleId"+miobj.getCircleId());
							System.out.println("fmdivId"+miobj.getDivisionId());
						    System.out.println("frmsubdivId"+miobj.getSubDivisionId());
							System.out.println("frmdesgId"+miobj.getDesignationId());
							System.out.println("frmpost"+miobj.getPostId());
							System.out.println("frmOffaccess "+miobj.getOffAccess());
							System.out.println("frmyear"+miobj.getTsfcFormYear());*/
							
							/*&& miobj.getUserUnitId()!=null*/
							if(miobj.getOffAccess()>=1   && miobj.getUserDesignationId()!=null && miobj.getBackdesignationId()!=null ){
								
								/*System.out.println("after list"+miobj.getOffAccess());
								System.out.println("miobj.getDesignationId()"+miobj.getDesignationId());
								System.out.println("miobj.getUserDesignationId()"+miobj.getUserDesignationId());*/
								
								mav.addObject("formcontbackdesgId",miobj.getBackdesignationId());
								//System.out.println("miobj.getBackdesignationId()"+miobj.getBackdesignationId());
								
             if(miobj.getOffAccess()==1){
	if(miobj.getBackdesignationId()==5){
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here5 office 1");
									
									mav.addObject("prefrm20desgId",7);
									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
									mav.addObject("prefrm20unitId", miobj.getUnitId());
									mav.addObject("prefrm20circleId",miobj.getCircleId());
									mav.addObject("prefrm20divisionId",miobj.getDivisionId());
									mav.addObject("prefrm20subdivisionId",0);
									mav.addObject("prefrm20post",miobj.getPostId());
									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
		                        }					
	                           }
	
	if(miobj.getBackdesignationId()==7){
		
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here7 office 1");
		
		mav.addObject("prefrm20desgId",9);
		mav.addObject("prefrm20offAccess",miobj.getOffAccess());
		mav.addObject("prefrm20unitId", miobj.getUnitId());
		mav.addObject("prefrm20circleId",miobj.getCircleId());
		mav.addObject("prefrm20divisionId",0);
		mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
		mav.addObject("prefrm20post",miobj.getPostId());
		mav.addObject("prefrm20year",miobj.getTsfcFormYear());

		}	  
	}
	
if(miobj.getBackdesignationId()==9){
		
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here9 office 1");
		
		mav.addObject("prefrm20desgId",10);
		mav.addObject("prefrm20offAccess",miobj.getOffAccess());
		mav.addObject("prefrm20unitId", miobj.getUnitId());
		mav.addObject("prefrm20circleId",0);
		mav.addObject("prefrm20divisionId",miobj.getDivisionId());
		mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
		mav.addObject("prefrm20post",miobj.getPostId());
		mav.addObject("prefrm20year",miobj.getTsfcFormYear());

		}	  
	}

if(miobj.getBackdesignationId()==10){
	
	if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
		
	//	System.out.println("coming here10 office 1");
	
	mav.addObject("prefrm20offAccess",miobj.getOffAccess());
	mav.addObject("prefrm20year",miobj.getTsfcFormYear());

	}	  
}
								}
								
								if(miobj.getOffAccess()==2){
									
									miobj.setUserDesignationId(9);
									
									if(miobj.getBackdesignationId()==5){
										
									//	System.out.println("cming here office acees 2 designation 5");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
											
											mav.addObject("prefrm20desgId",7);
											mav.addObject("prefrm20offAccess",miobj.getOffAccess());
											mav.addObject("prefrm20unitId", miobj.getUnitId());
											mav.addObject("prefrm20circleId",miobj.getCircleId());
											mav.addObject("prefrm20divisionId",miobj.getDivisionId());
											mav.addObject("prefrm20subdivisionId",0);
											mav.addObject("prefrm20post",miobj.getPostId());
											mav.addObject("prefrm20year",miobj.getTsfcFormYear());
										
										
										}
									}
									
									if(miobj.getBackdesignationId()==7){
										
									//	System.out.println("cming here office acees 2 designation 7");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("prefrm20desgId",9);
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20unitId", miobj.getUnitId());
										mav.addObject("prefrm20circleId",miobj.getCircleId());
										mav.addObject("prefrm20divisionId",0);
										mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
										mav.addObject("prefrm20post",miobj.getPostId());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
								 
										}
									}
                                    if(miobj.getBackdesignationId()==9){
                                    	
                                    //	System.out.println("cming here office acees 2 designation 9");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("prefrm20desgId",10);
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20unitId", miobj.getUnitId());
										mav.addObject("prefrm20circleId",0);
										mav.addObject("prefrm20divisionId",miobj.getDivisionId());
										mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
										mav.addObject("prefrm20post",miobj.getPostId());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
										}
									}
                                    
                                    if(miobj.getBackdesignationId()==10){
                                    	
                                    //	System.out.println("cming here office acees 2 designation 10");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
								 
										}
									}
								}
								
								
								if(miobj.getOffAccess()==3){
									
									miobj.setUserDesignationId(10);
									
									if(miobj.getBackdesignationId()==5){
										
									//	System.out.println("cming here office acees 3 designation 5");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("prefrm20desgId",7);
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20unitId", miobj.getUnitId());
										mav.addObject("prefrm20circleId",miobj.getCircleId());
										mav.addObject("prefrm20divisionId",miobj.getDivisionId());
										mav.addObject("prefrm20subdivisionId",0);
										mav.addObject("prefrm20post",miobj.getPostId());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
										}
									
									}
								
                                     if(miobj.getBackdesignationId()==7){
                                    	 
                                    	//	System.out.println("cming here office acees 3 designation 7");
                                    	 
                                    	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
									
									mav.addObject("prefrm20desgId",9);
									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
									mav.addObject("prefrm20unitId", miobj.getUnitId());
									mav.addObject("prefrm20circleId",miobj.getCircleId());
									mav.addObject("prefrm20divisionId",0);
									mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
									mav.addObject("prefrm20post",miobj.getPostId());
									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
                                    	 }
								}
                                      if(miobj.getBackdesignationId()==9){
                                    	  
                                    	//	System.out.println("cming here office acees 3 designation 9");
                                    	 
                                    	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
									
									mav.addObject("prefrm20desgId",10);
									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
									mav.addObject("prefrm20unitId", miobj.getUnitId());
									mav.addObject("prefrm20circleId",0);
									mav.addObject("prefrm20divisionId",miobj.getDivisionId());
									mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
									mav.addObject("prefrm20post",miobj.getPostId());
								
									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
                                    	 }
								
								}
                                      
                                      if(miobj.getBackdesignationId()==10){
                                    	 
                                    		//System.out.println("cming here office acees 3 designation 10");
                                     	 
                                     	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
 									
                                     		mav.addObject("prefrm20desgId",10);
 									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
 								mav.addObject("prefrm20unitId", miobj.getUserUnitId());
 									
 									
 									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
 									
                                     	 }
 								
 								} 
							} // office access 3 not null
								
						}//back desigId  not null
						
						}//mifrom20Abst list not null
		
		}//miobj.getTsfcFormYear()>0
		
		
	}	//miobj.getTsfcFormYear()!=null	
		
		
		
		}
		 catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
						
		return mav;

	}
	
	
	
	
	@RequestMapping(value = "/invReport/tank-fdr-ab")
	public ModelAndView tankFdrab(@ModelAttribute("mitankform20rpt") MiTankformData miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		//System.out.println("Hi");
	//	live
//	mav.setViewName("left-menu-home");
	//local	
		mav.setViewName("fdr-abstract");
		
		//System.out.println("miobj came here "+miobj.getFrmFromDate());
		//System.out.println("miobj came here "+miobj.getFrmToDate());
		
		
		
	//	System.out.println("cont tankForm20ab"+miobj);
		List<MiTankformData> mifrom20Abst= new ArrayList<MiTankformData>();
		List<MiTankformData> miTankUnitdetail= new ArrayList<MiTankformData>();
		List<MiTankformData> mifromAbst= new ArrayList<MiTankformData>();
		List<MiTankInspect> selectTankYear= new ArrayList<MiTankInspect>();
		List<MiTankformData> selectFormYear = new ArrayList<MiTankformData>();
		
		
		List<MiTankformData> mifrom20tankabst= new ArrayList<MiTankformData>();
		List<MiTankformData> mifrom20resabst= new ArrayList<MiTankformData>();
		List<MiTankformData> mifrom20canalabst= new ArrayList<MiTankformData>();
		
		List<MiTankformData> mifdrabstract= new ArrayList<MiTankformData>();
		Integer dbdesg=0;
		
        Double tankstotalApc=0.0;        
        Double tankstotalAtc=0.0;        
        Double tankstotalAtr=0.0;        
        Integer tankstotalbc=0;        
        Integer tankstotaldc=0;        
        Integer tankstotaltc=0;
        
        Double restotalApc=0.0;        
        Double restotalAtc=0.0;        
        Double restotalAtr=0.0;        
        Integer restotalbc=0;        
        Integer restotaldc=0;        
        Integer restotaltc=0;
        
        Double cantotalApc=0.0;        
        Double cantotalAtc=0.0;        
        Double cantotalAtr=0.0;        
        Integer cantotalbc=0;        
        Integer cantotaldc=0;        
        Integer cantotaltc=0;
        
        Integer frmYear=0;
        
        String finalSumtankstotalApc=null;
        String finalSumtankstotalAtc=null;
        String finalSumtankstotalAtr=null;
        
        String finalSumrestotalApc=null;
        String finalSumrestotalAtc=null;
        String finalSumrestotalAtr=null;
        
        String finalSumcantotalApc=null;
        String finalSumcantotalAtc=null;
        String finalSumcantotalAtr=null;
        
        String dateRange=null;
        
      
		
		try {
			
		
			
			selectTankYear = irm.getmiTankSelectYear();
			if(selectTankYear!=null){
        mav.addObject("selectTankYear",selectTankYear);
      //  System.out.println("inrc selectTankYear "+selectTankYear);
		}
			
			   selectFormYear = irm.getForm20SelectYear();
 			   if(selectFormYear!=null){
                mav.addObject("selectFormYear",selectFormYear);
            //   System.out.println("selectFormYear "+selectFormYear);
 			   }
		if(miobj.getTsfcFormYear()!=null || (miobj.getFrmFromDate()!=null && miobj.getFrmToDate()!=null )   ){
			if(miobj.getTsfcFormYear()>0  ||  (miobj.getFrmFromDate().length()>0 && miobj.getFrmToDate().length()>0 ) ){	
				if(miobj.getCircleId()==null){
					miobj.setCircleId(0);
				}
	                if(miobj.getDivisionId()==null){
					miobj.setDivisionId(0);
				}
	                if(miobj.getSubDivisionId()==null){
						miobj.setSubDivisionId(0);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
					}
	                
				/*System.out.println(miobj.getUnitId());
				System.out.println(miobj.getCircleId());
				System.out.println(miobj.getDivisionId());
			    System.out.println(miobj.getSubDivisionId());
				System.out.println(miobj.getDesignationId());
				System.out.println(miobj.getListDesignationId());
				System.out.println(miobj.getPostId());
				System.out.println("offaccess "+miobj.getOffAccess());
				System.out.println("getTsfcFormYear "+miobj.getTsfcFormYear());
				
				System.out.println("userdesg "+miobj.getUserDesignationId());*/
				/*System.out.println("userunit "+miobj.getUserUnitId());
				System.out.println("usercircle "+miobj.getUserCircleId());
				System.out.println("userdivision "+miobj.getUserDivisionId());
				System.out.println("userSubdivision "+miobj.getUserSubdivisionId());
				System.out.println("backdesg "+miobj.getBackdesignationId());*/
	                
	              
	                
	              
	                
	                mifrom20Abst = irm.getMiTankFDRAbstract(miobj);
	                
	             
	                frmYear=miobj.getTsfcFormYear();
	                
	                
	                
	                mav.addObject("frmYear",frmYear);
	                
	                mav.addObject("fromdate",miobj.getFrmFromDate());
	                
	                mav.addObject("todate",miobj.getFrmToDate());
	                
	                
	             
	             
				//	System.out.println("mifrom20Abst "+mifrom20Abst);
					
						if(mifrom20Abst!=null ){
							
							 /*Double sacp=rs.getDouble(16);
					        Double sacplakhs=(sacp/100000.00);
					        DecimalFormat f2 = new DecimalFormat("##.00"); 
							 String finalSumAprxCostPermt=  f2.format(sacplakhs);
							 
							 Double sact=rs.getDouble(17);
						        Double sactlakhs=(sact/100000.00);
							 DecimalFormat f3 = new DecimalFormat("##.00"); 
							 String finalSumAprxCostTemp=  f3.format(sactlakhs);
							 
							 Double srpt=rs.getDouble(18);
						        Double srptlakhs=(srpt/100000.00);
							 DecimalFormat f4 = new DecimalFormat("##.00"); 
							 String finalSumRepairsPermTemp=  f4.format(srptlakhs);*/
							
							Integer ablength=mifrom20Abst.size();
							Map<Integer, MiTankformData> unitMap = new HashMap<>();
							double stotalApc = 0.0;
							double stotalAtc = 0.0;
							double stotalAtr = 0.0;
							int totalTankDamages = 0;
							int totalTankBreaches = 0;
							int totalResDamages = 0;
							int totalResBreaches = 0;
							int totalCanalDamages = 0;
							int totalCanalBreaches = 0;
							// new totals
							int totalPermanentCount = 0;
							double totalPermanentAmount = 0.0;
							int totalTemporaryCount = 0;
							double totalTemporaryAmount = 0.0;
							int totalRestoredCount = 0;
							int totalUnderRestoredCount = 0;

							
						for(int k=0 ; k<ablength ; k++){
							
							
					
							
							
							MiTankformData item = mifrom20Abst.get(k);
						    int unitId = item.getUnitId();

						    // check if already exists in map
						    MiTankformData fdrgroup = unitMap.get(unitId);
						    if (fdrgroup == null) {
						        fdrgroup = new MiTankformData();
						        fdrgroup.setUnitId(unitId);
						        fdrgroup.setUnitName(item.getUnitName());

						        // initialize all counts
						        fdrgroup.setTankDamages(0);
						        fdrgroup.setTankBreaches(0);
						        fdrgroup.setResDamages(0);
						        fdrgroup.setResBreaches(0);
						        fdrgroup.setCanalDamages(0);
						        fdrgroup.setCanalBreaches(0);
						        fdrgroup.setSumAprxCostPermt(0.0);
						        fdrgroup.setSumAprxCostTemp(0.0);
						        fdrgroup.setSumRepairsPermTemp(0.0);
						        
						        fdrgroup.setPermanentCount(0);
						        fdrgroup.setPermanentAmount(0.0);
						        
						        fdrgroup.setTemporaryCount(0);
						        fdrgroup.setTemporaryAmount(0.0);
						        
						        fdrgroup.setRestoredCount(0);
						        fdrgroup.setUnderRestoredCount(0);

						        unitMap.put(unitId, fdrgroup);
						    }

						    // update category values
						    if (item.getCatId() == 1) {
						        fdrgroup.setTankDamages(fdrgroup.getTankDamages() + item.getDamageCount());
						        fdrgroup.setTankBreaches(fdrgroup.getTankBreaches() + item.getBreachCount());
						        totalTankDamages += item.getDamageCount();
						        totalTankBreaches += item.getBreachCount();
						        
						    } else if (item.getCatId() == 2) {
						        fdrgroup.setResDamages(fdrgroup.getResDamages() + item.getDamageCount());
						        fdrgroup.setResBreaches(fdrgroup.getResBreaches() + item.getBreachCount());
						        totalResDamages += item.getDamageCount();
						        totalResBreaches += item.getBreachCount();
						    } else if (item.getCatId() == 3) {
						        fdrgroup.setCanalDamages(fdrgroup.getCanalDamages() + item.getDamageCount());
						        fdrgroup.setCanalBreaches(fdrgroup.getCanalBreaches() + item.getBreachCount());
						        totalCanalDamages += item.getDamageCount();
						        totalCanalBreaches += item.getBreachCount();
						    }

						    // update cost values (per unit)
						    fdrgroup.setSumAprxCostPermt(fdrgroup.getSumAprxCostPermt() + item.getSumAprxCostPermt());
						    fdrgroup.setSumAprxCostTemp(fdrgroup.getSumAprxCostTemp() + item.getSumAprxCostTemp());
						    fdrgroup.setSumRepairsPermTemp(fdrgroup.getSumRepairsPermTemp() + item.getSumRepairsPermTemp());
						    
						    fdrgroup.setPermanentCount( fdrgroup.getPermanentCount()+item.getPermanentCount());
						    fdrgroup.setPermanentAmount( fdrgroup.getPermanentAmount()+item.getPermanentAmount());
						    fdrgroup.setTemporaryCount( fdrgroup.getTemporaryCount()+item.getTemporaryCount());
						    fdrgroup.setTemporaryAmount( fdrgroup.getTemporaryAmount()+item.getTemporaryAmount());
						    
						    fdrgroup.setRestoredCount(fdrgroup.getRestoredCount()+item.getRestoredCount());
						    
						    fdrgroup.setUnderRestoredCount(fdrgroup.getUnderRestoredCount()+item.getUnderRestoredCount());

						    // update overall totals
						    stotalApc += item.getSumAprxCostPermt();
						    stotalAtc += item.getSumAprxCostTemp();
						    stotalAtr += item.getSumRepairsPermTemp();
						    
						    
						    totalPermanentCount += item.getPermanentCount();
						    totalPermanentAmount += item.getPermanentAmount();
						    totalTemporaryCount += item.getTemporaryCount();
						    totalTemporaryAmount += item.getTemporaryAmount();
						    totalRestoredCount += item.getRestoredCount();
						    totalUnderRestoredCount += item.getUnderRestoredCount();
						}

						// format totals
						DecimalFormat df = new DecimalFormat("##.00");
						String sumrtotalApc = df.format(stotalApc);
						String finalSumtotalAtc = df.format(stotalAtc);
						String finalSumtotalAtr = df.format(stotalAtr);

						// final list for mav
						List<MiTankformData> finalList = new ArrayList<>(unitMap.values());
						mav.addObject("form20Abstract", finalList);

						// also add totals to mav
						mav.addObject("sumrtotalApc", sumrtotalApc);
						mav.addObject("finalSumtotalAtc", finalSumtotalAtc);
						mav.addObject("finalSumtotalAtr", finalSumtotalAtr);
						mav.addObject("totalTankDamages", totalTankDamages);
						mav.addObject("totalTankBreaches", totalTankBreaches);
						mav.addObject("totalResDamages", totalResDamages);
						mav.addObject("totalResBreaches", totalResBreaches);
						mav.addObject("totalCanalDamages", totalCanalDamages);
						mav.addObject("totalCanalBreaches", totalCanalBreaches);
						
						mav.addObject("totalPermanentCount", totalPermanentCount);
						mav.addObject("totalPermanentAmount", df.format(totalPermanentAmount));
						mav.addObject("totalTemporaryCount", totalTemporaryCount);
						mav.addObject("totalTemporaryAmount", df.format(totalTemporaryAmount));
						mav.addObject("totalRestoredCount", totalRestoredCount);
						mav.addObject("totalUnderRestoredCount", totalUnderRestoredCount);
							
							
						
						
						
						for(int k=0 ; k<ablength ; k++){
							if(mifrom20Abst.get(k).getCatId()==1  ){
							
								
								
								mifrom20tankabst.add(mifrom20Abst.get(k));
								
								
								
								
								 
                            	
								//System.out.println("mifrom20Abst.get(k).getSumAprxCostTemp()"+mifrom20Abst.get(k).getSumAprxCostTemp());
								
								tankstotalApc=tankstotalApc+mifrom20Abst.get(k).getSumAprxCostPermt();
								
								 DecimalFormat acp = new DecimalFormat("##.00"); 
								  finalSumtankstotalApc=  acp.format(tankstotalApc);
								 
								tankstotalAtc=tankstotalAtc+mifrom20Abst.get(k).getSumAprxCostTemp();
								
								DecimalFormat atc = new DecimalFormat("##.00"); 
								  finalSumtankstotalAtc=  atc.format(tankstotalAtc);
								 
								tankstotalAtr=tankstotalAtr+mifrom20Abst.get(k).getSumRepairsPermTemp();
								
								 DecimalFormat atr = new DecimalFormat("##.00"); 
								  finalSumtankstotalAtr=  atr.format(tankstotalAtr);
								
								
								
								tankstotalbc=tankstotalbc+mifrom20Abst.get(k).getBreachCount();
								tankstotaldc=tankstotaldc+mifrom20Abst.get(k).getDamageCount();
								tankstotaltc=tankstotaltc+mifrom20Abst.get(k).getTotalTankCount();
								
								//System.out.println("tankstotalAtc"+tankstotalAtc);
								
								
								
								
								
                            		
								 
							}
							
							
							
                             if(mifrom20Abst.get(k).getCatId()==2  ){
								
								
                            	// System.out.println("before res"+mifrom20Abst.get(k).getTotalTankCount());
                            	 mifrom20resabst.add(mifrom20Abst.get(k));
                            	 
                            	 
                            	
                       
 								
 								restotalApc=restotalApc+mifrom20Abst.get(k).getSumAprxCostPermt();
 								
 								 DecimalFormat resacp = new DecimalFormat("##.00"); 
								  finalSumrestotalApc=  resacp.format(restotalApc);
 								
 								restotalAtc=restotalAtc+mifrom20Abst.get(k).getSumAprxCostTemp();
 								
 								 DecimalFormat resatc = new DecimalFormat("##.00"); 
								  finalSumrestotalAtc=  resatc.format(restotalAtc);
								  
 								restotalAtr=restotalAtr+mifrom20Abst.get(k).getSumRepairsPermTemp();
 								
 								 DecimalFormat resatr = new DecimalFormat("##.00"); 
								  finalSumrestotalAtr=  resatr.format(restotalAtr);
 								
 								
 								restotalbc=restotalbc+mifrom20Abst.get(k).getBreachCount();
 								restotaldc=restotaldc+mifrom20Abst.get(k).getDamageCount();
 								restotaltc=restotaltc+mifrom20Abst.get(k).getTotalTankCount();
                            		
                            	 
							}
                            
                             
                             if(mifrom20Abst.get(k).getCatId()==3  ){
                            	 
                            	
 								
 								
                            	 mifrom20canalabst.add(mifrom20Abst.get(k));
                            	 
                            	
                            		
                            	 cantotalApc=cantotalApc+mifrom20Abst.get(k).getSumAprxCostPermt();
                            	 
                            	 DecimalFormat canapc = new DecimalFormat("##.00"); 
								  finalSumcantotalApc=  canapc.format(cantotalApc);
								  
  								cantotalAtc=cantotalAtc+mifrom20Abst.get(k).getSumAprxCostTemp();
  								
  								 DecimalFormat canatc = new DecimalFormat("##.00"); 
								  finalSumcantotalAtc=  canatc.format(cantotalAtc);
								  
  								cantotalAtr=cantotalAtr+mifrom20Abst.get(k).getSumRepairsPermTemp();
  								
  								 DecimalFormat canatr = new DecimalFormat("##.00"); 
								  finalSumcantotalAtr=  canatr.format(cantotalAtr);
								  
  								cantotalbc=cantotalbc+mifrom20Abst.get(k).getBreachCount();
  								cantotaldc=cantotaldc+mifrom20Abst.get(k).getDamageCount();
  								cantotaltc=cantotaltc+mifrom20Abst.get(k).getTotalTankCount();
  								
                            		
                            	 
							}
							
							
						}	
							
							
						mav.addObject("mifrom20tankabst",mifrom20tankabst);
						mav.addObject("mifrom20resabst",mifrom20resabst);
						mav.addObject("mifrom20canalabst",mifrom20canalabst);
					
						
						
						//totals of tank
						
						//tankstotalAtc=(double) Math.round(tankstotalAtc);
						
						//System.out.println("tankstotalAtc"+tankstotalAtc);
						
						mav.addObject("tankstotalApc",finalSumtankstotalApc);
						mav.addObject("tankstotalAtc",finalSumtankstotalAtc);
						mav.addObject("tankstotalAtr",finalSumtankstotalAtr);
						
						mav.addObject("tankstotalbc",tankstotalbc);
						mav.addObject("tankstotaldc",tankstotaldc);
						mav.addObject("tankstotaltc",tankstotaltc);
						
						
                                //totals of res
						
						mav.addObject("restotalApc",finalSumrestotalApc);
						mav.addObject("restotalAtc",finalSumrestotalAtc);
						mav.addObject("restotalAtr",finalSumrestotalAtr);
						
						mav.addObject("restotalbc",restotalbc);
						mav.addObject("restotaldc",restotaldc);
						mav.addObject("restotaltc",restotaltc);
						
						
                                     //totals of canal
						
						mav.addObject("cantotalApc", finalSumcantotalApc);
						mav.addObject("cantotalAtc",finalSumcantotalAtc);
						mav.addObject("cantotalAtr",finalSumcantotalAtr);
						
						mav.addObject("cantotalbc",cantotalbc);
						mav.addObject("cantotaldc",cantotaldc);
						mav.addObject("cantotaltc",cantotaltc);
						
						
						
							//mav.addObject("mifrom20Abst",mifrom20Abst);
							
							mav.addObject("frmdesgId",miobj.getDesignationId());
							mav.addObject("frmListdesgId",miobj.getListDesignationId());
							
							mav.addObject("frmunitId",miobj.getUnitId());
							mav.addObject("frmcircleId",miobj.getCircleId());
							mav.addObject("fmdivId",miobj.getDivisionId());
							mav.addObject("frmsubdivId",miobj.getSubDivisionId());
							mav.addObject("frmyear",miobj.getTsfcFormYear());
							mav.addObject("frmpost",miobj.getPostId());
							mav.addObject("frmOffAccess",miobj.getOffAccess());
							
							/*System.out.println("frmunitId"+miobj.getUnitId());
							System.out.println("frmcircleId"+miobj.getCircleId());
							System.out.println("fmdivId"+miobj.getDivisionId());
						    System.out.println("frmsubdivId"+miobj.getSubDivisionId());
							System.out.println("frmdesgId"+miobj.getDesignationId());
							System.out.println("frmpost"+miobj.getPostId());
							System.out.println("frmOffaccess "+miobj.getOffAccess());
							System.out.println("frmyear"+miobj.getTsfcFormYear());*/
							
							/*&& miobj.getUserUnitId()!=null*/
							if(miobj.getOffAccess()>=1   && miobj.getUserDesignationId()!=null && miobj.getBackdesignationId()!=null ){
								
								/*System.out.println("after list"+miobj.getOffAccess());
								System.out.println("miobj.getDesignationId()"+miobj.getDesignationId());
								System.out.println("miobj.getUserDesignationId()"+miobj.getUserDesignationId());*/
								
								mav.addObject("formcontbackdesgId",miobj.getBackdesignationId());
								//System.out.println("miobj.getBackdesignationId()"+miobj.getBackdesignationId());
								
             if(miobj.getOffAccess()==1){
	if(miobj.getBackdesignationId()==5){
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here5 office 1");
									
									mav.addObject("prefrm20desgId",7);
									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
									mav.addObject("prefrm20unitId", miobj.getUnitId());
									mav.addObject("prefrm20circleId",miobj.getCircleId());
									mav.addObject("prefrm20divisionId",miobj.getDivisionId());
									mav.addObject("prefrm20subdivisionId",0);
									mav.addObject("prefrm20post",miobj.getPostId());
									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
		                        }					
	                           }
	
	if(miobj.getBackdesignationId()==7){
		
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here7 office 1");
		
		mav.addObject("prefrm20desgId",9);
		mav.addObject("prefrm20offAccess",miobj.getOffAccess());
		mav.addObject("prefrm20unitId", miobj.getUnitId());
		mav.addObject("prefrm20circleId",miobj.getCircleId());
		mav.addObject("prefrm20divisionId",0);
		mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
		mav.addObject("prefrm20post",miobj.getPostId());
		mav.addObject("prefrm20year",miobj.getTsfcFormYear());

		}	  
	}
	
if(miobj.getBackdesignationId()==9){
		
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here9 office 1");
		
		mav.addObject("prefrm20desgId",10);
		mav.addObject("prefrm20offAccess",miobj.getOffAccess());
		mav.addObject("prefrm20unitId", miobj.getUnitId());
		mav.addObject("prefrm20circleId",0);
		mav.addObject("prefrm20divisionId",miobj.getDivisionId());
		mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
		mav.addObject("prefrm20post",miobj.getPostId());
		mav.addObject("prefrm20year",miobj.getTsfcFormYear());

		}	  
	}

if(miobj.getBackdesignationId()==10){
	
	if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
		
	//	System.out.println("coming here10 office 1");
	
	mav.addObject("prefrm20offAccess",miobj.getOffAccess());
	mav.addObject("prefrm20year",miobj.getTsfcFormYear());

	}	  
}
								}
								
								if(miobj.getOffAccess()==2){
									
									miobj.setUserDesignationId(9);
									
									if(miobj.getBackdesignationId()==5){
										
									//	System.out.println("cming here office acees 2 designation 5");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
											
											mav.addObject("prefrm20desgId",7);
											mav.addObject("prefrm20offAccess",miobj.getOffAccess());
											mav.addObject("prefrm20unitId", miobj.getUnitId());
											mav.addObject("prefrm20circleId",miobj.getCircleId());
											mav.addObject("prefrm20divisionId",miobj.getDivisionId());
											mav.addObject("prefrm20subdivisionId",0);
											mav.addObject("prefrm20post",miobj.getPostId());
											mav.addObject("prefrm20year",miobj.getTsfcFormYear());
										
										
										}
									}
									
									if(miobj.getBackdesignationId()==7){
										
									//	System.out.println("cming here office acees 2 designation 7");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("prefrm20desgId",9);
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20unitId", miobj.getUnitId());
										mav.addObject("prefrm20circleId",miobj.getCircleId());
										mav.addObject("prefrm20divisionId",0);
										mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
										mav.addObject("prefrm20post",miobj.getPostId());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
								 
										}
									}
                                    if(miobj.getBackdesignationId()==9){
                                    	
                                    //	System.out.println("cming here office acees 2 designation 9");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("prefrm20desgId",10);
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20unitId", miobj.getUnitId());
										mav.addObject("prefrm20circleId",0);
										mav.addObject("prefrm20divisionId",miobj.getDivisionId());
										mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
										mav.addObject("prefrm20post",miobj.getPostId());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
										}
									}
                                    
                                    if(miobj.getBackdesignationId()==10){
                                    	
                                    //	System.out.println("cming here office acees 2 designation 10");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
								 
										}
									}
								}
								
								
								if(miobj.getOffAccess()==3){
									
									miobj.setUserDesignationId(10);
									
									if(miobj.getBackdesignationId()==5){
										
									//	System.out.println("cming here office acees 3 designation 5");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("prefrm20desgId",7);
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20unitId", miobj.getUnitId());
										mav.addObject("prefrm20circleId",miobj.getCircleId());
										mav.addObject("prefrm20divisionId",miobj.getDivisionId());
										mav.addObject("prefrm20subdivisionId",0);
										mav.addObject("prefrm20post",miobj.getPostId());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
										}
									
									}
								
                                     if(miobj.getBackdesignationId()==7){
                                    	 
                                    	//	System.out.println("cming here office acees 3 designation 7");
                                    	 
                                    	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
									
									mav.addObject("prefrm20desgId",9);
									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
									mav.addObject("prefrm20unitId", miobj.getUnitId());
									mav.addObject("prefrm20circleId",miobj.getCircleId());
									mav.addObject("prefrm20divisionId",0);
									mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
									mav.addObject("prefrm20post",miobj.getPostId());
									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
                                    	 }
								}
                                      if(miobj.getBackdesignationId()==9){
                                    	  
                                    	//	System.out.println("cming here office acees 3 designation 9");
                                    	 
                                    	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
									
									mav.addObject("prefrm20desgId",10);
									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
									mav.addObject("prefrm20unitId", miobj.getUnitId());
									mav.addObject("prefrm20circleId",0);
									mav.addObject("prefrm20divisionId",miobj.getDivisionId());
									mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
									mav.addObject("prefrm20post",miobj.getPostId());
								
									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
                                    	 }
								
								}
                                      
                                      if(miobj.getBackdesignationId()==10){
                                    	 
                                    		//System.out.println("cming here office acees 3 designation 10");
                                     	 
                                     	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
 									
                                     		mav.addObject("prefrm20desgId",10);
 									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
 								mav.addObject("prefrm20unitId", miobj.getUserUnitId());
 									
 									
 									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
 									
                                     	 }
 								
 								} 
							} // office access 3 not null
								
						}//back desigId  not null
							
							mav.addObject("mifrom20Abst",mifrom20Abst);
							mav.addObject("mifdrabstract",mifdrabstract);
							
							
						
						}//mifrom20Abst list not null
		
		}//miobj.getTsfcFormYear()>0
		
		
	}	//miobj.getTsfcFormYear()!=null	
		
		
		
		}
		 catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
						
		return mav;

	}
	
	
	@RequestMapping(value = "/invReport/get-frm-photos")	
	public ModelAndView getfrmphotos(MiTankFormDocs formDataObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		
		ModelAndView mav= new ModelAndView();

		List<MiTankFormDocs> getFrmDocs = new ArrayList<MiTankFormDocs>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		 //System.out.println("kalPostId"+postId);
		 //System.out.println("mst1Id"+mst1Id);
		
		mav.setViewName("form20-viewphoto");
		

		try {

			if (formDataObj != null  ) {
				
				if (formDataObj.getFormDataId() !=null ) {

				if (formDataObj.getFormDataId() >0  ) {
					getFrmDocs = invam.getFrmDocsList(formDataObj.getFormDataId());
				}
				}

			}

		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("form20docList",getFrmDocs);
		
		if(formDataObj.getSourceName()!=null){
			
			//System.out.println("formDataObj.getSourceName()"+formDataObj.getSourceName());
			
		mav.addObject("sourceName",formDataObj.getSourceName());
		}
		return mav;
				
				//new Gson().toJson(getFrmDocs);

	}
	
	
	// private static final String FILE_DIRECTORY = "E:/Uploads/tsimis/uploadedFiles/FormDocs/";
	
	private static final String FILE_DIRECTORY = "/app/tomcat8/webapps/tsimis/uploadedFiles/FormDocs/";
	  

         //private static final String RELATIVE_DIR  = "/uploadedFiles/FormDocs/";


		    @GetMapping("/invReport/viewphotos")
		    public void serveFile(@RequestParam String fileName, HttpServletResponse response ) throws IOException {
		    	
		    	 // System.out.println("Entered viewPhotos, File Name: "+ fileName);
		        //String absolutePath = servletContext.getRealPath(RELATIVE_DIR);
		       // Path filePath = Paths.get(absolutePath, fileName);
		       // System.out.println("Using absolute path: " + absolutePath);
		    	  Path filePath = Paths.get(FILE_DIRECTORY, fileName);
		    	  File imageFile  = filePath.toFile();

		    	  if (!imageFile .exists() || !imageFile .isFile()) {
		                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
		                return;
		            }
		    	  
		    	  // Determine content type dynamically
		    	    String lowerCaseName = fileName.toLowerCase();
		    	    String contentType = lowerCaseName.endsWith(".png") ? "image/png" :
		    	                         lowerCaseName.endsWith(".jpg") || lowerCaseName.endsWith(".jpeg") ? "image/jpeg" :
		    	                         "application/octet-stream"; // Fallback

		        
		    	    response.setContentType(contentType);
		    	    response.setContentLengthLong(imageFile.length());
		    	    response.setHeader("Content-Disposition", "inline; filename=\"" + imageFile.getName() + "\"");


		            try (InputStream inputStream = new FileInputStream(imageFile);
		                    OutputStream outputStream = response.getOutputStream()) {

		                   byte[] buffer = new byte[8192]; // 8KB buffer for efficient reading
		                   int bytesRead;
		                   while ((bytesRead = inputStream.read(buffer)) != -1) {
		                       outputStream.write(buffer, 0, bytesRead);
		                   }
		                   outputStream.flush();

		               } catch (IOException e) {
		                   System.err.println("Error serving imageFile: " + e.getMessage());
		                   e.printStackTrace();

		                   try {
		                       response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing image file");
		                   } catch (IOException ioException) {
		                       System.err.println("Error sending 500 response: " + ioException.getMessage());
		                   }
		               }
		    }
	
	
	
	@RequestMapping(value = "/invReport/tank-form20-district-ab")
	public ModelAndView tankForm20districtab(@ModelAttribute("mitankform20rpt") MiTankformData miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		//System.out.println("Hi");
	//	live
	mav.setViewName("tank-form20-district");
	//local	
		//mav.setViewName("form20-abstract");
		
		
		
	//	System.out.println("cont tankForm20ab"+miobj);
		List<MiTankformData> mifrom20Abst= new ArrayList<MiTankformData>();
	//	List<MiTankformData> miTankUnitdetail= new ArrayList<MiTankformData>();
	//	List<MiTankformData> mifromAbst= new ArrayList<MiTankformData>();
	//	List<MiTankInspect> selectTankYear= new ArrayList<MiTankInspect>();
		List<MiTankformData> selectFormYear = new ArrayList<MiTankformData>();
		Integer dbdesg=0;
		
		User user = (User) session.getAttribute("userObj");
		
		try {
			//selectTankYear = irm.getmiTankSelectYear();
			/*if(selectTankYear!=null){
        mav.addObject("selectTankYear",selectTankYear);
      //  System.out.println("inrc selectTankYear "+selectTankYear);
		}*/
			
			   selectFormYear = irm.getForm20SelectYear();
 			   if(selectFormYear!=null){
                mav.addObject("selectFormYear",selectFormYear);
            //   System.out.println("selectFormYear "+selectFormYear);
 			   }
 			   
 			 // System.out.println("miobj.getTsfcFormYear() "+miobj.getTsfcFormYear());
		if(miobj.getTsfcFormYear()!=null   ){
			if(miobj.getTsfcFormYear()>0  ){
				
				// System.out.println("i am at 1");	
				if (user != null) {
					
					if(user.getUnitId()!=null){
						miobj.setUnitId(user.getUnitId());
						
					}
					
					if(user.getCircleId()!=null){
						miobj.setCircleId(user.getCircleId());
						
					}
					
					if(user.getDivisionId()!=null){
						miobj.setDivisionId(user.getDivisionId());
						
					}
					
					if(user.getSubdivisionId()!=null){
						miobj.setSubDivisionId(user.getSubdivisionId());
						
					}
					
					if(user.getSectionId()!=null){
						
						miobj.setSectionId(user.getSectionId());
					}
					
               if(user.getPost()!=null){
	miobj.setPostId(user.getPost());
						
					}
               
               if(user.getDesignationId()!=null){
            		miobj.setDesignationId(user.getDesignationId());
            							
            						}

					
				}
				
				
			/*	if(miobj.getCircleId()==null){
					miobj.setCircleId(0);
				}
	                if(miobj.getDivisionId()==null){
					miobj.setDivisionId(0);
				}
	                if(miobj.getSubDivisionId()==null){
						miobj.setSubDivisionId(0);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
					}
	                */
	                
	                
				/*System.out.println(miobj.getUnitId());
				System.out.println(miobj.getCircleId());
				System.out.println(miobj.getDivisionId());
			    System.out.println(miobj.getSubDivisionId());
				System.out.println(miobj.getDesignationId());
				System.out.println(miobj.getListDesignationId());
				System.out.println(miobj.getPostId());
				System.out.println("offaccess "+miobj.getOffAccess());
				System.out.println("getTsfcFormYear "+miobj.getTsfcFormYear());
				
				System.out.println("userdesg "+miobj.getUserDesignationId());*/
				/*System.out.println("userunit "+miobj.getUserUnitId());
				System.out.println("usercircle "+miobj.getUserCircleId());
				System.out.println("userdivision "+miobj.getUserDivisionId());
				System.out.println("userSubdivision "+miobj.getUserSubdivisionId());
				System.out.println("backdesg "+miobj.getBackdesignationId());*/
				
				 //System.out.println("i am at 2");	
	                
	                mifrom20Abst = irm.getMiTankForm20DistrictAbstract(miobj);
	                
	             //   System.out.println("i am at 3");	
	                
	            	if(mifrom20Abst!=null ){
	            		
	            		  // System.out.println("i am at 4");
						mav.addObject("mifrom20Abst",mifrom20Abst);
	            	}
	             
				//	System.out.println("mifrom20Abst "+mifrom20Abst);
					
						/*if(mifrom20Abst!=null ){
							mav.addObject("mifrom20Abst",mifrom20Abst);
							
							mav.addObject("frmdesgId",miobj.getDesignationId());
							mav.addObject("frmListdesgId",miobj.getListDesignationId());
							
							mav.addObject("frmunitId",miobj.getUnitId());
							mav.addObject("frmcircleId",miobj.getCircleId());
							mav.addObject("fmdivId",miobj.getDivisionId());
							mav.addObject("frmsubdivId",miobj.getSubDivisionId());
							mav.addObject("frmyear",miobj.getTsfcFormYear());
							mav.addObject("frmpost",miobj.getPostId());
							mav.addObject("frmOffAccess",miobj.getOffAccess());
							
							System.out.println("frmunitId"+miobj.getUnitId());
							System.out.println("frmcircleId"+miobj.getCircleId());
							System.out.println("fmdivId"+miobj.getDivisionId());
						    System.out.println("frmsubdivId"+miobj.getSubDivisionId());
							System.out.println("frmdesgId"+miobj.getDesignationId());
							System.out.println("frmpost"+miobj.getPostId());
							System.out.println("frmOffaccess "+miobj.getOffAccess());
							System.out.println("frmyear"+miobj.getTsfcFormYear());
							
							&& miobj.getUserUnitId()!=null
							if(miobj.getOffAccess()>=1   && miobj.getUserDesignationId()!=null && miobj.getBackdesignationId()!=null ){
								
								System.out.println("after list"+miobj.getOffAccess());
								System.out.println("miobj.getDesignationId()"+miobj.getDesignationId());
								System.out.println("miobj.getUserDesignationId()"+miobj.getUserDesignationId());
								
								mav.addObject("formcontbackdesgId",miobj.getBackdesignationId());
								//System.out.println("miobj.getBackdesignationId()"+miobj.getBackdesignationId());
								
             if(miobj.getOffAccess()==1){
	if(miobj.getBackdesignationId()==5){
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here5 office 1");
									
									mav.addObject("prefrm20desgId",7);
									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
									mav.addObject("prefrm20unitId", miobj.getUnitId());
									mav.addObject("prefrm20circleId",miobj.getCircleId());
									mav.addObject("prefrm20divisionId",miobj.getDivisionId());
									mav.addObject("prefrm20subdivisionId",0);
									mav.addObject("prefrm20post",miobj.getPostId());
									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
		                        }					
	                           }
	
	if(miobj.getBackdesignationId()==7){
		
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here7 office 1");
		
		mav.addObject("prefrm20desgId",9);
		mav.addObject("prefrm20offAccess",miobj.getOffAccess());
		mav.addObject("prefrm20unitId", miobj.getUnitId());
		mav.addObject("prefrm20circleId",miobj.getCircleId());
		mav.addObject("prefrm20divisionId",0);
		mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
		mav.addObject("prefrm20post",miobj.getPostId());
		mav.addObject("prefrm20year",miobj.getTsfcFormYear());

		}	  
	}
	
if(miobj.getBackdesignationId()==9){
		
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here9 office 1");
		
		mav.addObject("prefrm20desgId",10);
		mav.addObject("prefrm20offAccess",miobj.getOffAccess());
		mav.addObject("prefrm20unitId", miobj.getUnitId());
		mav.addObject("prefrm20circleId",0);
		mav.addObject("prefrm20divisionId",miobj.getDivisionId());
		mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
		mav.addObject("prefrm20post",miobj.getPostId());
		mav.addObject("prefrm20year",miobj.getTsfcFormYear());

		}	  
	}

if(miobj.getBackdesignationId()==10){
	
	if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
		
	//	System.out.println("coming here10 office 1");
	
	mav.addObject("prefrm20offAccess",miobj.getOffAccess());
	mav.addObject("prefrm20year",miobj.getTsfcFormYear());

	}	  
}
								}
								
								if(miobj.getOffAccess()==2){
									
									miobj.setUserDesignationId(9);
									
									if(miobj.getBackdesignationId()==5){
										
									//	System.out.println("cming here office acees 2 designation 5");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
											
											mav.addObject("prefrm20desgId",7);
											mav.addObject("prefrm20offAccess",miobj.getOffAccess());
											mav.addObject("prefrm20unitId", miobj.getUnitId());
											mav.addObject("prefrm20circleId",miobj.getCircleId());
											mav.addObject("prefrm20divisionId",miobj.getDivisionId());
											mav.addObject("prefrm20subdivisionId",0);
											mav.addObject("prefrm20post",miobj.getPostId());
											mav.addObject("prefrm20year",miobj.getTsfcFormYear());
										
										
										}
									}
									
									if(miobj.getBackdesignationId()==7){
										
									//	System.out.println("cming here office acees 2 designation 7");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("prefrm20desgId",9);
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20unitId", miobj.getUnitId());
										mav.addObject("prefrm20circleId",miobj.getCircleId());
										mav.addObject("prefrm20divisionId",0);
										mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
										mav.addObject("prefrm20post",miobj.getPostId());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
								 
										}
									}
                                    if(miobj.getBackdesignationId()==9){
                                    	
                                    //	System.out.println("cming here office acees 2 designation 9");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("prefrm20desgId",10);
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20unitId", miobj.getUnitId());
										mav.addObject("prefrm20circleId",0);
										mav.addObject("prefrm20divisionId",miobj.getDivisionId());
										mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
										mav.addObject("prefrm20post",miobj.getPostId());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
										}
									}
                                    
                                    if(miobj.getBackdesignationId()==10){
                                    	
                                    //	System.out.println("cming here office acees 2 designation 10");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
								 
										}
									}
								}
								
								
								if(miobj.getOffAccess()==3){
									
									miobj.setUserDesignationId(10);
									
									if(miobj.getBackdesignationId()==5){
										
									//	System.out.println("cming here office acees 3 designation 5");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("prefrm20desgId",7);
										mav.addObject("prefrm20offAccess",miobj.getOffAccess());
										mav.addObject("prefrm20unitId", miobj.getUnitId());
										mav.addObject("prefrm20circleId",miobj.getCircleId());
										mav.addObject("prefrm20divisionId",miobj.getDivisionId());
										mav.addObject("prefrm20subdivisionId",0);
										mav.addObject("prefrm20post",miobj.getPostId());
										mav.addObject("prefrm20year",miobj.getTsfcFormYear());
										}
									
									}
								
                                     if(miobj.getBackdesignationId()==7){
                                    	 
                                    	//	System.out.println("cming here office acees 3 designation 7");
                                    	 
                                    	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
									
									mav.addObject("prefrm20desgId",9);
									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
									mav.addObject("prefrm20unitId", miobj.getUnitId());
									mav.addObject("prefrm20circleId",miobj.getCircleId());
									mav.addObject("prefrm20divisionId",0);
									mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
									mav.addObject("prefrm20post",miobj.getPostId());
									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
                                    	 }
								}
                                      if(miobj.getBackdesignationId()==9){
                                    	  
                                    	//	System.out.println("cming here office acees 3 designation 9");
                                    	 
                                    	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
									
									mav.addObject("prefrm20desgId",10);
									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
									mav.addObject("prefrm20unitId", miobj.getUnitId());
									mav.addObject("prefrm20circleId",0);
									mav.addObject("prefrm20divisionId",miobj.getDivisionId());
									mav.addObject("prefrm20subdivisionId",miobj.getSubDivisionId());
									mav.addObject("prefrm20post",miobj.getPostId());
								
									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
                                    	 }
								
								}
                                      
                                      if(miobj.getBackdesignationId()==10){
                                    	 
                                    		//System.out.println("cming here office acees 3 designation 10");
                                     	 
                                     	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
 									
                                     		mav.addObject("prefrm20desgId",10);
 									mav.addObject("prefrm20offAccess",miobj.getOffAccess());
 								mav.addObject("prefrm20unitId", miobj.getUserUnitId());
 									
 									
 									mav.addObject("prefrm20year",miobj.getTsfcFormYear());
 									
                                     	 }
 								
 								} 
							} // office access 3 not null
								
						}//back desigId  not null
						
						}*///mifrom20Abst list not null
		//end of designations
	                
	               
		}//miobj.getTsfcFormYear()>0
		
		
	}	//miobj.getTsfcFormYear()!=null	
		
		
		
		}
		 catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		return mav;

	}
	
	
	@RequestMapping(value = "/invReport/tank-chk-data")
	public ModelAndView TankChkData(@ModelAttribute("tankchkdata") MiTankInspect michkObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
	//	System.out.println("michkObj"+michkObj);
		mav.setViewName("repair-history-data");
		
		List<MiTankInspect> miinspect = new ArrayList<MiTankInspect>();
		List<MiTankInspect> miemblist = new ArrayList<MiTankInspect>();
		List<MiTankInspect> embinspect = new ArrayList<MiTankInspect>();
		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();
		List<MiTankInspect> capacityList = new ArrayList<MiTankInspect>();
		
		List<MiTankInspect> newcapacityList = new ArrayList<MiTankInspect>();
		
		
		
		List<mkAdminSanctionData> adminsanctionList = new ArrayList<mkAdminSanctionData>();
		List<mkAgmtData> mkAgmtList = new ArrayList<mkAgmtData>();
		List<mkRepairData> mkRepairList = new ArrayList<mkRepairData>();
		List<mkTankData> mkTankList = new ArrayList<mkTankData>();
		List<MkBillData> mkBillList = new ArrayList<MkBillData>();
		List<MkEstmtData> mkEstmtList = new ArrayList<MkEstmtData>();

		List<MiTankInspect> tabwiseremarks = new ArrayList<MiTankInspect>();
		
		
		
		JSONObject repairjarray = new JSONObject();
		//System.out.println("come to emb");
		try {
		if(michkObj!=null){
			
			if(michkObj.getTankId()!=null && michkObj.getMiInpsectMst1Id()!=null  && michkObj.getYear()!=null  ){
				if (michkObj.getTankId() != null) {
				
						miinspect = irm.getMiTankChecksTankInfo(michkObj);
						miemblist = irm.getMiTankChecksEmbInfo(michkObj);
						
						 repairjarray=TankRepairHistory.getTankRepairHistory(michkObj.getTankId());
						 
						// System.out.println("repairjarray"+repairjarray );
						 
						 capacityList = invam.getMiCapacity(michkObj.getTankId());
						 
						
						if(miinspect!=null){
							
							// System.out.println("TankCheckList"+miinspect );
							
							mav.addObject("TankCheckList",miinspect);
						}
						if(miemblist!=null){
							
							// System.out.println("EmbCheckList"+miinspect2 );
							
							mav.addObject("EmbCheckList",miemblist);	
							
						}
						
						if(michkObj.getMiInpsectMst1Id()!=null){
							if (michkObj.getMiInpsectMst1Id()>0 ) {
								miTankInspect = invam.viewMst1Remarks(michkObj.getMiInpsectMst1Id());
							}
							
							if(miTankInspect!=null){
								
								mav.addObject("AllRemarksList",miTankInspect);	
							}
							
					}
					
					if(capacityList!=null){
						//System.out.println("coming here capacity"+capacityList);
						int len=capacityList.size();
						
						for(int i=0 ; i<len ; i++){
							
						MiTankInspect capdata = new MiTankInspect();
						Double gcp=Double.parseDouble(capacityList.get(i).getGrossCapacity());
						 DecimalFormat f = new DecimalFormat("##.00"); 
						 String finalcapacity=  f.format(gcp);
						 
						 Double gcp2=Double.parseDouble(capacityList.get(i).getAvailableCapacity());
						 DecimalFormat f2 = new DecimalFormat("##.00"); 
						 String finalavailcapacity=  f2.format(gcp2);
						 
						capdata.setGrossCapacity(finalcapacity);
						capdata.setAvailableCapacity(finalavailcapacity);
						capdata.setTankLevel(capacityList.get(i).getTankLevel());
						capdata.setInflow(capacityList.get(i).getInflow());
						
						capdata.setOutfow(capacityList.get(i).getOutfow());
						capdata.setAyacut(capacityList.get(i).getAyacut());
						capdata.setSurplus(capacityList.get(i).getSurplus());
						capdata.setInspectDate(capacityList.get(i).getInspectDate());
						newcapacityList.add(capdata);
						}
						
						mav.addObject("CapacityInspectObj",newcapacityList);	
					}
					

						
						if(repairjarray!=null){
							
							JSONArray repairdata = new JSONArray();
							JSONArray agmt_data = new JSONArray();
							JSONArray tender_data = new JSONArray();
							JSONArray admin_sanction_data = new JSONArray();
							JSONArray tank_data = new JSONArray();
							JSONArray bill_data = new JSONArray();
							
						
							
							if(repairjarray.get("tank_data")!=null){
								
								tank_data =  (JSONArray) repairjarray.get("tank_data");
								
								if (tank_data != null && tank_data.size() > 0) {
								Integer tanklen=tank_data.size();
								
								for(int i=0; i<tanklen ; i++){
							
									
									JSONObject jsonObject1 = (JSONObject) tank_data.get(i);
									mkTankData tdl = new mkTankData();
									
					                tdl.setTank_code((String.valueOf(jsonObject1.get("tank_code").toString())));
					              
									tdl.setTank_name(String.valueOf(jsonObject1.get("tank_name").toString()));
									tdl.setVname(String.valueOf(jsonObject1.get("vname").toString()));
									tdl.setTank_id(jsonObject1.get("tank_id").toString());
									tdl.setDname(jsonObject1.get("dname").toString());
									tdl.setMname(jsonObject1.get("mname").toString());
									tdl.setHname(jsonObject1.get("hname").toString());
									tdl.setGeo_id(jsonObject1.get("geo_id").toString());									
									
									mkTankList.add(tdl);
									
								}
								}
								
							}
							
                                if(repairjarray.get("admin_sanction_data")!=null){
								
                                	admin_sanction_data =  (JSONArray) repairjarray.get("admin_sanction_data");
                                //	System.out.println("admin_sanction_data"+admin_sanction_data );
								if (admin_sanction_data != null && admin_sanction_data.size() > 0) {
								Integer adminsanctionlen=admin_sanction_data.size();
								
								for(int i=0; i<adminsanctionlen ; i++){
							
								
									
									JSONObject jsonObject2 = (JSONObject) admin_sanction_data.get(i);
									mkAdminSanctionData asdl = new mkAdminSanctionData();
									
									asdl.setPhase((String.valueOf(jsonObject2.get("phase").toString())));
					              
									asdl.setGo_number((String.valueOf(jsonObject2.get("go_number").toString())));
									
									//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
									//String strDate=null;
									//String godate=null;
									
										//godate=jsonObject2.get("go_issued_date").toString();
										
										//strDate= formatter.format(godate).toString();
										
									
									//
									asdl.setGo_issued_date((String.valueOf(jsonObject2.get("go_issued_date").toString())));
									asdl.setTank_id(jsonObject2.get("tank_id").toString());
								//	asdl.setGo_amount((jsonObject2.get("go_amount").toString()));
									
									String tempGO=jsonObject2.get("go_amount").toString();
									Double lakhGO=100000.0;
									//System.out.println("tempGO"+ tempGO.length() );
									if((!tempGO.equals(null) && tempGO.length()>0)  ){
										Double goamount=Double.parseDouble(tempGO);
										Double goamountlakhs=(goamount/lakhGO);
										   DecimalFormat f = new DecimalFormat("##.00"); 
										 String finalgoamount=  f.format(goamountlakhs);
									
										 asdl.setGo_amount(Double.parseDouble(finalgoamount));
									
										 }
										 else {
											 asdl.setGo_amount(0.0);
										//	 System.out.println("go_amount"+ asdl.getGo_amount() );
										 }
									
									String tempAdAmount=jsonObject2.get("admin_amount").toString();
									
									//System.out.println("tempAdAmount"+ tempAdAmount );
									if((!tempAdAmount.equals(null)&& tempAdAmount.length()>0)){
										Double adAmount=Double.parseDouble(tempAdAmount);
										Double adAmounttlakhs=(adAmount/lakhGO);
										   DecimalFormat f = new DecimalFormat("##.00"); 
										 String finaladAmount=  f.format(adAmounttlakhs);
									
										 asdl.setAdmin_amount(Double.parseDouble(finaladAmount));
									
										 }
										 else {
											 asdl.setAdmin_amount(0.0);
											// System.out.println("Admin_amount"+ asdl.getAdmin_amount() );
										 }
									//String temp=jsonObject2.get("admin_amount").toString();
									// if(temp!=null||temp!=""){
									//asdl.setAdmin_amount((new BigDecimal((jsonObject2.get("admin_amount").toString()))).setScale(2, RoundingMode.HALF_EVEN));
										//	System.out.println("admin_sanction_data"+admin_sanction_data );
									// }
									/* if(temp==null||temp==""){
										 asdl.setAdmin_amountLakhs(0.00);
									 }*/
									// asdl.setAdmin_amount((new BigDecimal((jsonObject2.get("admin_amount").toString()))).setScale(2, RoundingMode.HALF_EVEN));
									adminsanctionList.add(asdl);
									
								}
								mav.addObject("adminsanctionObj",adminsanctionList);
								}
								
							}
							
                                if(repairjarray.get("agmt_data")!=null){
    								
                                	agmt_data =  (JSONArray) repairjarray.get("agmt_data");
                                	//System.out.println("agmt_data"+agmt_data );
								if (agmt_data != null && agmt_data.size() > 0) {
								Integer agmt_datalen=agmt_data.size();
								
								for(int i=0; i<agmt_datalen ; i++){
							
									
									JSONObject jsonObject3 = (JSONObject) agmt_data.get(i);
									mkAgmtData mad = new mkAgmtData();
									
									mad.setWork_id((String.valueOf(jsonObject3.get("work_id").toString())));
					              
									mad.setAgreement_type_id((String.valueOf(jsonObject3.get("agreement_type_id").toString())));
									
									//06062022 check key//
									
									
									//JSONParser parser  = new JSONParser();
									
									//JSONObject 	name1 = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream("jsonObject3")));
									//JSONObject jsonObjectkey = parser.parse(jsonObject3.toString()).
									//return jsonObjectkey.has(key);

									
									// System.out.println("jsonObject3.containsKey"+ jsonObject3.containsKey("agreement_amount") );
									 if(jsonObject3.containsKey("agreement_amount")){
									// System.out.println("jsonObject3getagmt data"+ jsonObject3.get("agreement_amount").toString() );
									String temp=jsonObject3.get("agreement_amount").toString();
									
									if((!temp.equals(null)&& temp.length()>0)){
										
									  
										Double lakh=100000.0;
									//	System.out.println("temp"+ temp );
										Double amtdata=Double.parseDouble(temp);
										
										//System.out.println("amtdata"+ amtdata );
										Double amtdatalakhs=(amtdata/lakh);
										
										//System.out.println("amtdatalakhs"+ amtdatalakhs );
										   DecimalFormat f = new DecimalFormat("##.00"); 
										 String finalagmtdata=  f.format(amtdatalakhs);
										 
										// System.out.println("finalagmtdata"+ finalagmtdata );
									
										 mad.setAgreement_amount((Double.parseDouble(finalagmtdata)));
										 
										// System.out.println("finalagmtdata"+ mad.getAgreement_amount() );
									
										 }
										 else {
											 mad.setAgreement_amount(0.00);
											// System.out.println("agmt_amtLakhs"+ mad.getAgreement_amountLakhs() );
										 }
									 }
									//mad.setAgreement_amount((new BigDecimal((jsonObject3.get("agreement_amount").toString()))).setScale(2, RoundingMode.HALF_EVEN));
									//System.out.println("agmt_amt"+ mad.getAgreement_amount() );
									 if(jsonObject3.containsKey("agency_name")){
									mad.setAgency_name(jsonObject3.get("agency_name").toString());
									 }
									mad.setAgreement_number((jsonObject3.get("agreement_number").toString()));
									mad.setAgreement_date((jsonObject3.get("agreement_date").toString()));
									mad.setPremium_percentage((jsonObject3.get("premium_percentage").toString()));
									mad.setWork_id((jsonObject3.get("work_id").toString()));
									
									mkAgmtList.add(mad);
									
								}
								mav.addObject("agmtObj",mkAgmtList);
								}
								
							}
                                
                         if(repairjarray.get("repairdata")!=null){
    								
                        	 repairdata =  (JSONArray) repairjarray.get("repairdata");
								
								if (repairdata != null && repairdata.size() > 0) {
								Integer repairdatalen=repairdata.size();
								
								for(int i=0; i<repairdatalen ; i++){
							
									
									JSONObject jsonObject4 = (JSONObject) repairdata.get(i);
									mkRepairData mrd = new mkRepairData();
									
									mrd.setUnit_name((String.valueOf(jsonObject4.get("unit_name").toString())));
									 if(jsonObject4.containsKey("approved_boq_id")){
									mrd.setApproved_boq_id((String.valueOf(jsonObject4.get("approved_boq_id").toString())));
									 }
									 if(jsonObject4.containsKey("work_id")){
									mrd.setWork_id((String.valueOf(jsonObject4.get("work_id").toString())));
									 }
									mrd.setBoq_sr_item_number((jsonObject4.get("boq_sr_item_number").toString()));
									mrd.setQuantity((jsonObject4.get("quantity").toString()));
									mrd.setTypeofwork((jsonObject4.get("typeofwork").toString()));
									mrd.setItemtypeid((jsonObject4.get("itemtypeid").toString()));
									mrd.setItem_name((jsonObject4.get("item_name").toString()));
									mrd.setWork_done_quantity((jsonObject4.get("work_done_quantity").toString()));
									mrd.setUnit_id((jsonObject4.get("unit_id").toString()));
									mrd.setRate_per_unit((jsonObject4.get("rate_per_unit").toString()));
									mrd.setCustomized_description((jsonObject4.get("customized_description").toString()));
									
											mkRepairList.add(mrd);
									
								}
								
								mav.addObject("repairObj",mkRepairList);	
								}
								
							}
                         
                         
                         if(repairjarray.get("bill_data")!=null){
								
                        	 bill_data =  (JSONArray) repairjarray.get("bill_data");
								
								if (bill_data != null && bill_data.size() > 0) {
								Integer bill_datalen=bill_data.size();
								
								for(int i=0; i<bill_datalen ; i++){
							
									
									JSONObject jsonObject5 = (JSONObject) bill_data.get(i);
									MkBillData mbd = new MkBillData();
									
									mbd.setUpdated_on((String.valueOf(jsonObject5.get("updated_on").toString())));
					              
									mbd.setPhase((String.valueOf(jsonObject5.get("phase").toString())));
									mbd.setBill_type((String.valueOf(jsonObject5.get("bill_type").toString())));
									mbd.setBill_status((jsonObject5.get("bill_status").toString()));
									mbd.setBill_status_id((jsonObject5.get("bill_status_id").toString()));
									
									
									mkBillList.add(mbd);
									
								}
								
								mav.addObject("billObj",mkBillList);	
								}
								
							}
							
							
						}
					
				}
				
		
			}
			}
			
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
       
		 
		return mav;
		
		 
		

	}
	
	@RequestMapping(value = "/invomReport/downloadResAnnexure1")
	public ModelAndView downloadResAnnexure1(ReservoirInspect  resObj )throws InventoryUserException  {
		// create some sample data
		//System.out.println("cont formDataId"+formDataId);
		ModelAndView mav = new ModelAndView();
		
		List<ReservoirInspect> resChecksList = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resCatList = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn1mst2total = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resAnn1mst2info = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resChecksListtotal = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resCatListtotal = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resannrecommndList = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resannrecommndList2 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resAnn2mst2info = new ArrayList<ReservoirInspect>();
		
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		
		List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		
		List<ReservoirInspect> resremarksinfo = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resinspectinfo = new ArrayList<ReservoirInspect>();
		
		
		
		

		
	
		
try {
	
	//System.out.println("resInspectAnn1Mst1Id"+resInspectAnn1Mst1Id);
	
	         if(resObj!=null){
	        	 
	        	// System.out.println("resgeninfo"+resObj.getReservoirId()+ resObj.getTankId());
	        	 
	        	 if(resObj.getReservoirId()>0 && resObj.getTankId()==0){
						resgeninfo=invam.getresDaminfoandControlLevelInfo(resObj);
						
						//System.out.println("resgeninfo"+resgeninfo);
					
					mav.addObject("resgeninfo",resgeninfo);
					
	        		}
	        		
	        	// System.out.println("resObj.getReservoirId()"+resObj.getReservoirId());
	        //	 System.out.println("resObj.getTankId()"+resObj.getTankId());
	        		if(resObj.getReservoirId()==0 && resObj.getTankId()>0){
						tankgeninfo=invam.getTankinfoandControlLevelInfo(resObj);
						
						//System.out.println("tankgeninfo"+tankgeninfo);
						
						mav.addObject("tankgeninfo",tankgeninfo);
						
	        		}
			
			if(resObj.getResInspectMst1Id()>0){
				
				//System.out.println("1");
				resChecksListtotal=irm.getResChecks();
				//System.out.println("2");
				resCatListtotal=irm.getResChecksCategory();
				//System.out.println("3");
				resAnn1mst2total=irm.getResAnn1mst2(resObj.getResInspectMst1Id());
				//System.out.println("4");
				resannrecommndList=irm.getResAnnRecomndbymst1(resObj);
				
				//System.out.println("5");
				
				
				
				
				
				if(resObj.getAnnexureId()==1) {
				
			if(resChecksListtotal!=null){
				
				int l=resChecksListtotal.size();
				
				for(int i=0; i<l ; i++){
					
					if(resChecksListtotal.get(i).getAnnexureId()==1){
					
						resChecksList.add( resChecksListtotal.get(i));
					
					}
				}
				
				
   
				
			}
			
           if(resCatListtotal!=null){
				
				int l=resCatListtotal.size();
				
				for(int i=0; i<l ; i++){
					
					if(resCatListtotal.get(i).getResCategoryId()<=4){
					
						resCatList.add( resCatListtotal.get(i));
					
					}
				}
				
				
			}
           
           if(resAnn1mst2total!=null){
				
				int l=resAnn1mst2total.size();
				
				for(int i=0; i<l ; i++){
					
					if(resAnn1mst2total.get(i).getAnnexureId()==1){
					
						resAnn1mst2info.add( resAnn1mst2total.get(i));
						// System.out.println("resAnn1mst2total.get(1)"+resAnn1mst2total.get(i).getResCheckId());
							
					}
				}
				
				
			}
           
           
			
           mav.addObject("resChecksList" ,resChecksList);
   		mav.addObject("resCatList" ,resCatList);
   		mav.addObject("resAnn1mst2info" ,resAnn1mst2info);
   		mav.addObject("resannrecommndList",resannrecommndList);
   		mav.setViewName("pdfReservoirAnnexure1");//check in views properties file
			
			}
				
				if(resObj.getAnnexureId()==2) {
					
				//System.out.println("coming annexure2"+resObj.getAnnexureId());
					
					if(resChecksListtotal!=null){
						
						int len=resChecksListtotal.size();
						
						for(int i=0; i<len ; i++){
							
							if(resChecksListtotal.get(i).getAnnexureId()==2){
							
								resChecksList.add( resChecksListtotal.get(i));
							
							}
						}
						
						
		
						
					}
					
		           if(resCatListtotal!=null){
						
						int l=resCatListtotal.size();
						
						for(int i=0; i<l ; i++){
							
							if(resCatListtotal.get(i).getResCategoryId()>4){
								
								//System.out.println("resCatListtotal.get(i).getResCategoryId()"+resCatListtotal.get(i).getResCategoryId());
							
								resCatList.add( resCatListtotal.get(i));
							
							}
							
							
						}
						
						
						
						
					}
		           
		           if(resAnn1mst2total!=null){
		        	   
		        	 // System.out.println("resAnn1mst2total.get(i)ann2 "+resAnn1mst2total);
						
						int len2=resAnn1mst2total.size();
						
						for(int i=0; i<len2 ; i++){
							
							if(resAnn1mst2total.get(i).getAnnexureId()==2){
								
								//System.out.println("resCatListtotal.get(i).getResCategoryId()"+resCatListtotal.get(i).getResCategoryId());
								//System.out.println("1");
								resAnn2mst2info.add( resAnn1mst2total.get(i));
							//	System.out.println("2");
								
								// System.out.println("in ann2)"+resAnn1mst2total.get(i).getResCheckId());
							
							}
							
							
						}
						
						
						
						
					}
		           
		           if(resannrecommndList!=null){
		        	   
		        	   int len3=resannrecommndList.size();
		        	   
		        	   
		        	   for(int i=0; i<len3 ; i++){
							
							if(resannrecommndList.get(i).getResInspectMst2Id()>0 && resannrecommndList.get(i).getResDamHealthId()==0){
								
								//System.out.println("resCatListtotal.get(i).getResCategoryId()"+resCatListtotal.get(i).getResCategoryId());
								//System.out.println("1");
								
								 if(resObj.getResinspectInfoId().equals(resannrecommndList.get(i).getInspectOfficeInfoId())){
								resannrecommndList2.add( resannrecommndList.get(i));
								 }
							//	System.out.println("2");
								
								// System.out.println("resannrecommndList.get(i)"+resannrecommndList.get(i).getResInspectMst2Id());
							
							}
							
							
						}
		        	   
		           }
		           
		           if(resObj.getResInspectMst1Id()>0){
						
						resremarksinfo=irm.getResDamInspectRemarksByresmst1Id(resObj);
						
						mav.addObject("resremarksinfo",resremarksinfo);
					}
					
					if(resObj.getResinspectInfoId()!=null){
						
						resinspectinfo=invam.getResInspectInfobyInspectOfficeInfoId(resObj);
						mav.addObject("resinspectinfo",resinspectinfo);
					}

		         
		           mav.addObject("resChecksList" ,resChecksList);
		   		mav.addObject("resCatList" ,resCatList);
		   		mav.addObject("resAnn2mst2info" ,resAnn2mst2info);
		   		mav.addObject("resannrecommndList2",resannrecommndList2);
		   		mav.setViewName("pdfReservoirAnnexure2");
		   		
		  // 	System.out.println("2resgeninfo"+resgeninfo);//check in views properties file	
					}
				
			}
			
		}
}

catch (InventoryUserException e) {
			e.printStackTrace();
		} 
	
		
		
		
		
		
		

		// return a view which will be resolved by an excel view resolver
		return mav ;
	}
	
	
	@RequestMapping(value = "/invomReport/EvaluatAnn2")
	public ModelAndView EvaluateAnn2(ReservoirInspect  resObj )throws InventoryUserException  {
		// create some sample data
		//System.out.println("cont formDataId"+formDataId);
		ModelAndView mav = new ModelAndView();
		
		List<ReservoirInspect> resChecksList = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resCatList = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn1mst2total = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resAnn1mst2info = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resChecksListtotal = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resCatListtotal = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resannrecommndList = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resannrecommndList2 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		
		List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		
		
		List<ReservoirInspect> resremarksinfo = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resinspectinfo = new ArrayList<ReservoirInspect>();
		
		
		
	
		
try {
	
	//System.out.println("resInspectAnn1Mst1Id"+resInspectAnn1Mst1Id);
	
	         if(resObj!=null){
	        	 
	        	
		        	 
		        		if(resObj.getReservoirId()>0 && resObj.getTankId()==0){
							resgeninfo=invam.getresDaminfoandControlLevelInfo(resObj);
						
						mav.addObject("resgeninfo",resgeninfo);
						
		        		}
		        		
		        		if(resObj.getReservoirId()==0 && resObj.getTankId()>0){
							tankgeninfo=invam.getTankinfoandControlLevelInfo(resObj);
							
							mav.addObject("tankgeninfo",tankgeninfo);
							
		        		}
		        		
		        		if(resObj.getResInspectMst1Id()>0){
							
							resremarksinfo=irm.getResDamInspectRemarksByresmst1Id(resObj);
							
							mav.addObject("resremarksinfo",resremarksinfo);
						}
						
						if(resObj.getResinspectInfoId()!=null){
							
							resinspectinfo=invam.getResInspectInfobyInspectOfficeInfoId(resObj);
							mav.addObject("resinspectinfo",resinspectinfo);
						}
						
			if(resObj.getResInspectMst1Id()>0){
				
				//System.out.println("1");
				resChecksListtotal=irm.getResChecks();
				//System.out.println("2");
				resCatListtotal=irm.getResChecksCategory();
				//System.out.println("3");
				resAnn1mst2total=irm.getResAnn1mst2(resObj.getResInspectMst1Id());
				//System.out.println("4");
				resannrecommndList=irm.getResAnnRecomndbymst1(resObj);
				//System.out.println("5"+resannrecommndList);
				
				
				
				if(resObj.getAnnexureId()==2) {
					
					//System.out.println("coming annexure2"+resObj.getAnnexureId());
					
					if(resChecksListtotal!=null){
						
						int len=resChecksListtotal.size();
						
						for(int i=0; i<len ; i++){
							
							if(resChecksListtotal.get(i).getAnnexureId()==2){
							
								resChecksList.add( resChecksListtotal.get(i));
							
							}
						}
						
						
		
						
					}
					
		           if(resCatListtotal!=null){
						
						int l=resCatListtotal.size();
						
						for(int i=0; i<l ; i++){
							
							if(resCatListtotal.get(i).getResCategoryId()>4){
								
								//System.out.println("resCatListtotal.get(i).getResCategoryId()"+resCatListtotal.get(i).getResCategoryId());
							
								resCatList.add( resCatListtotal.get(i));
							
							}
							
							
						}
						
						
						
						
					}
		           
		           if(resAnn1mst2total!=null){
		        	   
		        	  // System.out.println("resAnn1mst2total.get(i)"+resAnn1mst2total);
						
						int len2=resAnn1mst2total.size();
						
						for(int i=0; i<len2 ; i++){
							
							if(resAnn1mst2total.get(i).getAnnexureId()==2){
								
								//System.out.println("resCatListtotal.get(i).getResCategoryId()"+resCatListtotal.get(i).getResCategoryId());
								//System.out.println("1");
								resAnn1mst2info.add( resAnn1mst2total.get(i));
							//	System.out.println("2");
								
								// System.out.println("resAnn1mst2total.get(i)"+resAnn1mst2total.get(i).getResCheckId());
							
							}
							
							
						}
						
						
						
						
					}
		           
		           
		           if(resannrecommndList!=null){
		        	   
			        	  // System.out.println("resAnn1mst2total.get(i)"+resAnn1mst2total);
							
							int len3=resannrecommndList.size();
							
							for(int i=0; i<len3 ; i++){   
								
								// System.out.println("resannrecommndList.get(i).getInspectOfficeInfoId()"+resannrecommndList.get(i).getInspectOfficeInfoId());
					        	//   System.out.println("resObj.getResinspectInfoId()"+resObj.getResinspectInfoId());
		           
		           if(resannrecommndList.get(i).getResInspectMst2Id()>0 && resannrecommndList.get(i).getResDamHealthId()==0 &&  resannrecommndList.get(i).getInspectOfficeInfoId()>0){
						
						//System.out.println("resCatListtotal.get(i).getResCategoryId()"+resCatListtotal.get(i).getResCategoryId());
						//System.out.println("1");
		        	   
		        	   
		        	  
		        	   if(resObj.getResinspectInfoId().equals(resannrecommndList.get(i).getInspectOfficeInfoId())){
						resannrecommndList2.add( resannrecommndList.get(i));
		        	   }
					//	System.out.println("2");
						
						// System.out.println("resannrecommndList.get(i)"+resannrecommndList.get(i).getResInspectMst2Id());
					
					}
					
							}
		           }
		           
				}
		         
		           mav.addObject("resChecksList" ,resChecksList);
		   		mav.addObject("resCatList" ,resCatList);
		   		mav.addObject("resAnn1mst2info" ,resAnn1mst2info);
		   		mav.addObject("resannrecommndList",resannrecommndList2);
		   		mav.setViewName("pdfEvaluateResAnnexure2");//check in views properties file	
					
				
			
				
				}
		}
}

catch (InventoryUserException e) {
			e.printStackTrace();
		} 
	
		
		
		
		
		
		

		// return a view which will be resolved by an excel view resolver
		return mav ;
	}
	
	
	@RequestMapping(value = "/invomReport/pdfhealthstatus")
	public ModelAndView pdfhealthstatus(ReservoirInspect  resObj )throws InventoryUserException  {
		// create some sample data
		//System.out.println("cont formDataId"+formDataId);
		ModelAndView mav = new ModelAndView();
		
		List<ReservoirInspect> resChecksList = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resCatList = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resAnn1mst2total = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resAnn1mst2info = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resChecksListtotal = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> resCatListtotal = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resannrecommndList = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resannrecommndList2 = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resHealthInfo= new ArrayList<ReservoirInspect>();
		
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		
		List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		
		
		
try {
	
	//System.out.println("resInspectAnn1Mst1Id"+resInspectAnn1Mst1Id);
	
	         if(resObj!=null){
	        	 
	        		if(resObj.getReservoirId()>0 && resObj.getTankId()==0){
						resgeninfo=invam.getresDaminfoandControlLevelInfo(resObj);
					
					mav.addObject("resgeninfo",resgeninfo);
					
					
					}
	        		
	        		if(resObj.getReservoirId()==0 && resObj.getTankId()>0){
	        			tankgeninfo=invam.getTankinfoandControlLevelInfo(resObj);
					
					mav.addObject("tankgeninfo",tankgeninfo);
					
					
					}
	        		
	        		
			
			if(resObj.getResInspectMst1Id()>0){
				
				resHealthInfo=irm.getDamHealthDetailsBYmst1IdReport(resObj);
				
				resannrecommndList=irm.getResAnnRecomndbymst1(resObj);
				
				if(resannrecommndList!=null){
		        	   
		        	  // System.out.println("resAnn1mst2total.get(i)"+resAnn1mst2total);
						
						int len3=resannrecommndList.size();
						
						for(int i=0; i<len3 ; i++){   
	           
	           if(resannrecommndList.get(i).getResInspectMst2Id()==0 && resannrecommndList.get(i).getResDamHealthId()>0){
					
					//System.out.println("resCatListtotal.get(i).getResCategoryId()"+resCatListtotal.get(i).getResCategoryId());
					//System.out.println("1");
					resannrecommndList2.add( resannrecommndList.get(i));
				//	System.out.println("2");
					
					// System.out.println("resannrecommndList.get(i)"+resannrecommndList.get(i).getResInspectMst2Id());
				
				}
				
						}
	           }
				
		           
		          
		         
		         /*  mav.addObject("resChecksList" ,resChecksList);
		   		mav.addObject("resCatList" ,resCatList);
		   		mav.addObject("resAnn2mst2info" ,resAnn2mst2info);
		   		mav.addObject("resannrecommndList2",resannrecommndList2);*/
				
				mav.addObject("resHealthInfo",resHealthInfo);
				mav.addObject("resannrecommndList",resannrecommndList2);
				
		   		mav.setViewName("PDFHealthStatusAndRecommends");//check in views properties file	
					}
				
			
			
		}
}

catch (InventoryUserException e) {
			e.printStackTrace();
		} 
	
		
		
		
		
		
		

		// return a view which will be resolved by an excel view resolver
		return mav ;
	}
	
	
	
	@RequestMapping(value = "/invomReport/getRemarksinfo")
	public ModelAndView getRemarksinfo(ReservoirInspect  resObj )throws InventoryUserException  {
		// create some sample data
		//System.out.println("cont formDataId"+formDataId);
		ModelAndView mav = new ModelAndView();
		
		List<ReservoirInspect> resRemarksList = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resHealthInfo = new ArrayList<ReservoirInspect>();
		
		
		
		 List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
  		
  		List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		
		
try {
	
	//System.out.println("resInspectAnn1Mst1Id"+resInspectAnn1Mst1Id);
	
	         if(resObj!=null){
	        	 
	        		
	        
	        	
	        	 if(resObj.getReservoirId()>0 && resObj.getTankId()==0){
						resgeninfo=invam.getresDaminfoandControlLevelInfo(resObj);
					
					mav.addObject("resgeninfo",resgeninfo);
					
					
					}
	        		
	        		if(resObj.getReservoirId()==0 && resObj.getTankId()>0){
	        			tankgeninfo=invam.getTankinfoandControlLevelInfo(resObj);
					
					mav.addObject("tankgeninfo",tankgeninfo);
					
					
					}
	        		
	        		
			
			if(resObj.getResInspectMst1Id()>0){
				
				resRemarksList=irm.getResDamInspectRemarksByresmst1Id(resObj);
				
				resHealthInfo=irm.getDamHealthDetailsBYmst1IdReport(resObj);
				
			
				
			}
				
		           
		          
		         
		         /*  mav.addObject("resChecksList" ,resChecksList);
		   		mav.addObject("resCatList" ,resCatList);
		   		mav.addObject("resAnn2mst2info" ,resAnn2mst2info);
		   		mav.addObject("resannrecommndList2",resannrecommndList2);*/
				
				mav.addObject("resRemarksList",resRemarksList);
				mav.addObject("resgeninfo",resgeninfo);
				mav.addObject("tankgeninfo",tankgeninfo);
				
				mav.addObject("resHealthInfo",resHealthInfo);
			
				
		   		mav.setViewName("damsafety-remarks");//check in views properties file	
					}
				
	

}catch (InventoryUserException e) {
			e.printStackTrace();
		} 
	
		
	
		// return a view which will be resolved by an excel view resolver
		return mav ;
	}
	
	
	@RequestMapping(value = "/invomReport/resgeninf")
	public ModelAndView Resgeninf(ReservoirInspect  resObj )throws InventoryUserException  {
		// create some sample data
		//System.out.println("cont formDataId"+formDataId);
		ModelAndView mav = new ModelAndView();
		
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		
		List<ReservoirInspect> resinspectinfo = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resremarksinfo = new ArrayList<ReservoirInspect>();
		
		
		List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		
		
		
		List<Tanks> tanksinfo = new ArrayList<Tanks>();
		
		
		

		
	
		
try {
	
	//System.out.println("resObj1"+resObj.getResInspectMst1Id());
	//System.out.println("resObj2"+resObj.getReservoirId());
	//System.out.println("resObj3"+resObj.getTankId());
	//System.out.println("resObj4"+resObj.getResinspectInfoId());
	
	         if(resObj!=null){
			
			if(resObj.getResInspectMst1Id()>0 && resObj.getReservoirId()!=null && resObj.getTankId()!=null){
				
				
				if(resObj.getReservoirId()>0 && resObj.getTankId()==0){
					resgeninfo=invam.getresDaminfoandControlLevelInfo(resObj);
				
				mav.addObject("resgeninfo",resgeninfo);
				
if(resObj.getResInspectMst1Id()>0){
					
					resremarksinfo=irm.getResDamInspectRemarksByresmst1Id(resObj);
					
					mav.addObject("resremarksinfo",resremarksinfo);
				}
				
				if(resObj.getResinspectInfoId()!=null){
					
					resinspectinfo=invam.getResInspectInfobyInspectOfficeInfoId(resObj);
					mav.addObject("resinspectinfo",resinspectinfo);
				}
				
				
				mav.setViewName("pdfReservoirGeninf");//check in views properties file	
				
				}
				
				
				
				if(resObj.getReservoirId()==0 && resObj.getTankId()>0){
					tankgeninfo=invam.getTankinfoandControlLevelInfo(resObj);
					
					mav.addObject("tankgeninfo",tankgeninfo);
					
					if(resObj.getResInspectMst1Id()>0){
						
						resremarksinfo=irm.getResDamInspectRemarksByresmst1Id(resObj);
						
						mav.addObject("resremarksinfo",resremarksinfo);
					}
					
					if(resObj.getResinspectInfoId()!=null){
						
						resinspectinfo=invam.getResInspectInfobyInspectOfficeInfoId(resObj);
						mav.addObject("resinspectinfo",resinspectinfo);
					}
					
					
					mav.setViewName("PDFTankGeninf");//check in views properties file	
					}
				
			 
				
				
			}
			
		}
}

catch (InventoryUserException e) {
			e.printStackTrace();
		} 
	
		
		
		
		
		
		

		// return a view which will be resolved by an excel view resolver
		return mav ;
	}
	
	@RequestMapping(value = "/invomReport/resinspectinf")
	public ModelAndView Resinspectinf(ReservoirInspect  resObj )throws InventoryUserException  {
		// create some sample data
		//System.out.println("cont formDataId"+formDataId);
		ModelAndView mav = new ModelAndView();
		
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		
		List<ReservoirInspect> resinspectinfo = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resremarksinfo = new ArrayList<ReservoirInspect>();
		
		List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		
		List<Tanks> tanksinfo = new ArrayList<Tanks>();
		
		
		

		
	
		
try {
	
	//System.out.println("resObj1"+resObj.getResInspectMst1Id());
	//System.out.println("resObj2"+resObj.getReservoirId());
	//System.out.println("resObj3"+resObj.getTankId());
	//System.out.println("resObj4"+resObj.getResinspectInfoId());
	
	         if(resObj!=null){
			
			if(resObj.getResInspectMst1Id()>0 && resObj.getReservoirId()!=null && resObj.getTankId()!=null){
				
				
				if(resObj.getReservoirId()>0 && resObj.getTankId()==0){
					resgeninfo=invam.getresDaminfoandControlLevelInfo(resObj);
				
				mav.addObject("resgeninfo",resgeninfo);
				
          if(resObj.getResInspectMst1Id()>0){
					
					resremarksinfo=irm.getResDamInspectRemarksByresmst1Id(resObj);
					
					mav.addObject("resremarksinfo",resremarksinfo);
				}
				
				if(resObj.getResinspectInfoId()!=null){
					
					resinspectinfo=invam.getResInspectInfobyInspectOfficeInfoId(resObj);
					mav.addObject("resinspectinfo",resinspectinfo);
				}
				mav.setViewName("PDFReservoirInspectionInfo");//check in views properties file	
				
				}
				
				
				
				if(resObj.getReservoirId()==0 && resObj.getTankId()>0){
					tankgeninfo=invam.getTankinfoandControlLevelInfo(resObj);
					
					mav.addObject("tankgeninfo",tankgeninfo);
					
					 if(resObj.getResInspectMst1Id()>0){
							
							resremarksinfo=irm.getResDamInspectRemarksByresmst1Id(resObj);
							
							mav.addObject("resremarksinfo",resremarksinfo);
						}
						
						if(resObj.getResinspectInfoId()!=null){
							
							resinspectinfo=invam.getResInspectInfobyInspectOfficeInfoId(resObj);
							mav.addObject("resinspectinfo",resinspectinfo);
						}
						
						mav.setViewName("PDFTankInspectionInfo");//check in views properties file
					}
				
			 
				
				
			}
			
		}
}

catch (InventoryUserException e) {
			e.printStackTrace();
		} 
	
		
		
		
		
		
		

		// return a view which will be resolved by an excel view resolver
		return mav ;
	}
	
	
	@RequestMapping(value = "/invReport/get-daminspect-photos")	
	public ModelAndView getdamsafetyphotos(DamInspectDocs damdocsDataObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		
		ModelAndView mav= new ModelAndView();

		List<DamInspectDocs> getdamDocs = new ArrayList<DamInspectDocs>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		 //System.out.println("kalPostId"+postId);
		 //System.out.println("mst1Id"+mst1Id);
		
		mav.setViewName("damsafety-viewphoto");
		

		try {

			if (damdocsDataObj != null  ) {
				
				if (damdocsDataObj.getResInspectMst1Id() !=null ) {

				if (damdocsDataObj.getResInspectMst1Id() >0  ) {
					
					getdamDocs=irm.getDamInspectPhotosByResInspectMst1Id(damdocsDataObj);
					//getdamDocs = invam.getFrmDocsList(formDataObj.getFormDataId());
				}
				}

			}

		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("getdamDocsList",getdamDocs);
		
		if(damdocsDataObj.getSourceName()!=null){
			
			//System.out.println("damdocsDataObj.getSourceName()"+damdocsDataObj.getSourceName());
			
		mav.addObject("sourceName",damdocsDataObj.getSourceName());
		}
		return mav;
				
				//new Gson().toJson(getFrmDocs);

	}
	
	  private static final String FILE_DIRECTORYDAM = "E:/Uploads/tsimis/uploadedFiles/DamInspectDocs/";
	  

	//live  private static final String FILE_DIRECTORY = "/Uploads/tsimis/uploadedFiles/AyacutKmls/";


	  @GetMapping("/invReport/viewDamphotos")
	    public void serveDamFile(@RequestParam String fileName, HttpServletResponse response ) throws IOException {
	    	
	    	  System.out.println("Entered viewPhotos, File Name: "+ fileName);
	    	  Path filePath = Paths.get(FILE_DIRECTORYDAM, fileName);
	    	  File imageFile  = filePath.toFile();

	    	  if (!imageFile .exists() || !imageFile .isFile()) {
	                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
	                return;
	            }
	    	  
	    	  // Determine content type dynamically
	    	    String lowerCaseName = fileName.toLowerCase();
	    	    String contentType;
	    	    if (lowerCaseName.endsWith(".png")) {
	    	        contentType = "image/png";
	    	    } else if (lowerCaseName.endsWith(".jpg") || lowerCaseName.endsWith(".jpeg")) {
	    	        contentType = "image/jpeg";
	    	    } else if (lowerCaseName.endsWith(".pdf")) {
	    	        contentType = "application/pdf";
	    	    } else {
	    	        contentType = "application/octet-stream"; // default fallback
	    	    }


	        
	    	    response.setContentType(contentType);
	    	    response.setContentLengthLong(imageFile.length());
	    	    response.setHeader("Content-Disposition", "inline; filename=\"" + imageFile.getName() + "\"");


	            try (InputStream inputStream = new FileInputStream(imageFile);
	                    OutputStream outputStream = response.getOutputStream()) {

	                   byte[] buffer = new byte[8192]; // 8KB buffer for efficient reading
	                   int bytesRead;
	                   while ((bytesRead = inputStream.read(buffer)) != -1) {
	                       outputStream.write(buffer, 0, bytesRead);
	                   }
	                   outputStream.flush();

	               } catch (IOException e) {
	                   System.err.println("Error serving imageFile: " + e.getMessage());
	                   e.printStackTrace();

	                   try {
	                       response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing image file");
	                   } catch (IOException ioException) {
	                       System.err.println("Error sending 500 response: " + ioException.getMessage());
	                   }
	               }
	    }
	
	
	
	
	@RequestMapping(value = "/invReport/get-dam-total-info")
	public ModelAndView Getdamtotalinfo(@ModelAttribute("reservoirInspect1") ReservoirInspect resObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("damsafety-getinfo");
		
              List<ReservoirInspect> resremarksinfo= new ArrayList<ReservoirInspect>();
              List<ReservoirInspect> resinspectinfo= new ArrayList<ReservoirInspect>();
              List<ReservoirSalient> resgeninfo= new ArrayList<ReservoirSalient>();
              List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();
              List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		
		try {
			if(resObj!=null){
				
				 if(resObj.getReservoirId()>0 && resObj.getTankId()==0){
					 resgeninfo=invam.getresDaminfoandControlLevelInfo(resObj);
						
						//System.out.println("resgeninfo"+resgeninfo);
					
					mav.addObject("resgeninfo",resgeninfo);
					
	        		}
	        		
	        	// System.out.println("resObj.getReservoirId()"+resObj.getReservoirId());
	        //	 System.out.println("resObj.getTankId()"+resObj.getTankId());
	        		if(resObj.getReservoirId()==0 && resObj.getTankId()>0){
						tankgeninfo=invam.getTankinfoandControlLevelInfo(resObj);
						
					//	System.out.println("tankgeninfo"+tankgeninfo);
						
						mav.addObject("tankgeninfo",tankgeninfo);
						
	        		}
	        		
	        		 if(resObj.getResInspectMst1Id()>0){
							
							resremarksinfo=irm.getResDamInspectRemarksByresmst1Id(resObj);
							
							mav.addObject("resremarksinfo",resremarksinfo);
						}
						
						if(resObj.getResinspectInfoId()!=null){
							
							resinspectinfo=invam.getResInspectInfobyInspectOfficeInfoId(resObj);
							mav.addObject("resinspectinfo",resinspectinfo);
						}
				
			
					}
				
			
			
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//mav.addObject("resUnitData",resUnitData);
		//mav.addObject("resInspectinf",resInspectinf);
		//mav.addObject("selectedunitId",reservoirObj.getUnitId());
		//mav.addObject("selectedStatusId",reservoirObj.getResStatusId());
		 
		return mav;
		
		 
		

	}
	
	
	@RequestMapping(value = "/invomReport/pdfReservoirSalient")
	public ModelAndView pdfReservoirSalient(ReservoirInspect  resObj )throws InventoryUserException  {
		// create some sample data
		//System.out.println("cont formDataId"+formDataId);
		ModelAndView mav = new ModelAndView();
		

		
	
		List<ReservoirSalient> resSalInfo= new ArrayList<ReservoirSalient>();
		
		List<Tanks> tanksSalInfo= new ArrayList<Tanks>();
		
		List<ReservoirSalient> resgeninfo = new ArrayList<ReservoirSalient>();
		
		List<Tanks> tankgeninfo = new ArrayList<Tanks>();
		 List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();
		
		
try {
	
	//System.out.println("resInspectAnn1Mst1Id"+resInspectAnn1Mst1Id);
	
	         if(resObj!=null){
	        	 
	        		if(resObj.getReservoirId()>0 && resObj.getTankId()==0){
						resgeninfo=invam.getresDaminfoandControlLevelInfo(resObj);
						
						if(resgeninfo!=null){
							
							if(resgeninfo.size()>0){
								
								if(!resgeninfo.get(0).getCommisionDate().equals("NA")){
						
						String commdate=resgeninfo.get(0).getCommisionDate();
						
						String newCommYear=commdate.substring(6,commdate.length());
						
						resgeninfo.get(0).setCommisionDate(newCommYear);
						
								}
						
							}
						
						}
					
					mav.addObject("resgeninfo",resgeninfo);
					
					if(resObj.getResInspectMst1Id()>0){
						
						resSalInfo=irm.getDamSalientDetailsBYmst1IdReport(resObj);
						
						
						
					
						
						
						if(resObj.getResinspectInfoId()!=null){
							
							resInspectinf=invam.getResInspectInfobyInspectOfficeInfoId(resObj);
							mav.addObject("resinspectinfo",resInspectinf);
						}
				          
				         
				       
						
						mav.addObject("resSalInfo",resSalInfo);
					
						
				   		mav.setViewName("PDFReservoirSalient");//check in views properties file	
							}
					
					
					}
	        		
	        		if(resObj.getReservoirId()==0 && resObj.getTankId()>0){
	        			tankgeninfo=invam.getTankinfoandControlLevelInfo(resObj);
	        			
                     if(tankgeninfo!=null){
							
							if(tankgeninfo.size()>0){
								
								if(!tankgeninfo.get(0).getCommisionDate().equals("NA")){
						
						String commdate=tankgeninfo.get(0).getCommisionDate();
						
						String newCommYear=commdate.substring(6,commdate.length());
						
						tankgeninfo.get(0).setCommisionDate(newCommYear);
						
								}
						
							}
						
						}
					
					mav.addObject("tankgeninfo",tankgeninfo);
					
					if(resObj.getResInspectMst1Id()>0){
						
						tanksSalInfo=irm.getTanksSalientDetailsBYmst1IdReport(resObj);
						
						
						
					
						
						
						if(resObj.getResinspectInfoId()!=null){
							
							resInspectinf=invam.getResInspectInfobyInspectOfficeInfoId(resObj);
							mav.addObject("resinspectinfo",resInspectinf);
						}
				          
				         
				       
						
						mav.addObject("tanksSalInfo",tanksSalInfo);
					
						
				   		mav.setViewName("PDFReservoirSalient");//check in views properties file	
							}
					
					
					}
	        		
	        		
			
			
				
			//System.out.println("resgeninfo"+resgeninfo);
			
			//System.out.println("tankgeninfo"+tankgeninfo);
			
		}
}

catch (InventoryUserException e) {
			e.printStackTrace();
		} 
	
		
		
		
		
		
		

		// return a view which will be resolved by an excel view resolver
		return mav ;
	}
	
}