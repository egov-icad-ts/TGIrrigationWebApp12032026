package in.ts.icad.leagal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.manager.ComponentAdminManager;
import in.ts.icad.leagal.manager.ComponentReportManager;
import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.manager.TaskAdminManager;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.ComponentAyacut;
import in.ts.icad.leagal.model.ComponentLineSegment;
import in.ts.icad.leagal.model.ComponentsCapacity;
import in.ts.icad.leagal.model.Constituency;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Task;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.TaskType;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.project.graphs.ComponentStructureCoordinates;

@Controller
public class ComponentReportController {
	@Autowired
	 private TaskAdminManager tam;
	
	@Autowired
	 private ComponentReportManager crm;
	
	@Autowired
	 private ComponentAdminManager cam;
	
	@Autowired
	private LeagalAdminManager lam;
	
	@Autowired
	private ServletContext servletContext;
	
	

	
	//@Autowired
	//private  ComponentReportManager   crm;
	
	
	@RequestMapping(value="/compReport/projCompDia")
	public ModelAndView ProjectCompDiagram(@ModelAttribute("projdiagram") Component compObject,SessionStatus status, HttpSession session,ModelMap model){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("projectCompDiagram");
		List<Unit> unitList = new ArrayList<Unit>();
		List<Component> compList=new ArrayList<Component>();
		
		List<Component> componentsList = new ArrayList<Component>();
		List<ComponentLineSegment> segments = new ArrayList<ComponentLineSegment>();
		try {
			//System.out.println("coming here");
			unitList=tam.getUnitList();
			mav.addObject("unitList",unitList);
			Integer projectId=0;
			if(compObject!=null){
				projectId=compObject.getProjectId();
				
				//System.out.println("projectId"+projectId);
				
				if(projectId!=null){
					if(projectId>0){
					
						compList=crm.getComponentProgress(projectId);
						
						//System.out.println("compList"+compList);
						
						
						if(compList!=null){
							
							if(compList.size()>0){
								
								componentsList.addAll(compList);
								
								segments = ComponentStructureCoordinates.getImages(componentsList, compObject.getProjectName() + " Project Component Diagram");
								
								//System.out.println("segments"+segments);
								
								compObject.setSegments(segments);
								List<Map<String, Object>> listAll = new ArrayList<Map<String, Object>>();
								if (segments != null && segments.size() > 0) {
									for (ComponentLineSegment objects : segments) {
										Map<String, Object> map = new HashMap<String, Object>();
										map.put("componentId", objects.getComponentId());
										map.put("actualLength", objects.getActualLength());
										map.put("componentWidth", objects.getComponentWidth());
										map.put("xCoord", objects.getxCoord());
										map.put("yCoord", objects.getyCoord());
										map.put("angle", objects.getAngle());
										map.put("colour", objects.getColour());
										listAll.add(map);
									}
								}
								ObjectMapper mapper = new ObjectMapper();
								String permissionList = null;
								try {
									permissionList = mapper.writeValueAsString(listAll);
								} catch (JsonProcessingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								//System.out.println("component"+compObject);
								mav.addObject("segments", permissionList);
								mav.addObject("segmentsList", segments);
								mav.addObject("component", compObject);
								
								
							}
							
						}
			}
			}
				
			
		}
			
			
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
		
	}
	
	@RequestMapping(value = "/compReport/getProjects")
	@ResponseBody
	public String getProjects(Integer unitId, SessionStatus status,
			HttpServletRequest request) throws TaskUserException {
		
		
		List<Project> projectList= new ArrayList<Project>();
		try {
			projectList = tam.getProjectList(unitId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return new Gson().toJson(projectList);
		
	}
	
	@RequestMapping(value = "/compReport/getPackages")
	@ResponseBody
	public String getPackages(Integer projectId, SessionStatus status,
			HttpServletRequest request) throws TaskUserException {
		
	
		List<Packages> packagesList = new ArrayList<Packages>();
		try {
			packagesList = tam.getPackageList(projectId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return new Gson().toJson(packagesList);
		
	

}
	
	
	@RequestMapping(value = "/compReport/projectComponents")
	@ResponseBody
	public ModelAndView ComponentProjectReport(@ModelAttribute("comp") Component comp, SessionStatus status,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("componentprojectreport");

		List<Unit> unitList = new ArrayList<Unit>();
		List<Circle> circleList = new ArrayList<Circle>();
		List<Division> divisionList = new ArrayList<Division>();
		List<Subdivision> subdivisionList = new ArrayList<Subdivision>();
		
		List<Project> prList = new ArrayList<Project>();
		
		List<Component> compList = new ArrayList<Component>();

	/*	List<Task> taskAllList = new ArrayList<Task>();
		List<TaskFiles> taskFilesList = new ArrayList<TaskFiles>();

		List<TaskType> taskTypeList = new ArrayList<TaskType>();*/

		Integer unitId = 0;
		Integer circleId = 0;
		Integer divisionId = 0;
		Integer subdivisionId = 0;
		Integer typeId = 0;
		
		Integer projectId=comp.getProjectId();
		Double totalMW=0.0;
		Double totalAnnualPowerConsumption=0.0;
		Double totaldischargecusecs=0.0;
		Double totalayacutAcres=0.0;

		if (comp != null) {

			unitId = comp.getUnitId();
			circleId = comp.getCircleId();
			divisionId = comp.getDivisionId();
			subdivisionId = comp.getSubdivisionId();
			

		}

		try {
			unitList = tam.getunitpostList();
			circleList = tam.getcirclepostList();
			divisionList = tam.getdivisionpostList();
			subdivisionList = tam.getsubdivisionpostList();
			prList=tam.getprojListbypostgres();
			

			if(projectId!=null){
              if(projectId>0){
            	  
            	 // System.out.println("projectId"+projectId);
            	  compList= crm.getProjectLiftData(projectId);
            	  
            	  if(compList!=null){
            		  if(compList.size()>0){
            			  
            			  int len=compList.size();
            			  for(int i=0; i<len; i++){
            				  
            				  totalMW=totalMW+compList.get(i).getMotormegawatts(); 
            				  
            				  totalAnnualPowerConsumption=totalAnnualPowerConsumption+compList.get(i).getAnnualpowerconsumption();
            				  
            				  totaldischargecusecs=totaldischargecusecs+compList.get(i).getDischrgecusecs();
            						  totalayacutAcres=totalayacutAcres+compList.get(i).getAyacutacres();
            			  }
            			  
            			  
            			  
            		  }
            		  
            		  
            	  }
            	  
            	  mav.addObject("compList",compList);
            	  mav.addObject("totalMW",totalMW);
            	  mav.addObject("totalAnnualPowerConsumption",totalAnnualPowerConsumption);
            	  mav.addObject("totaldischargecusecs",totaldischargecusecs);
            	  mav.addObject("totalayacutAcres",totalayacutAcres);
            	  
            	  
              }
			}
/*
			if (unitId == null && (typeId == null || typeId == -1)) {

				// System.out.println("not coming here");
				taskAllList = taskReportManager.getAllTasks();
				typeId = -1;

			}
*/
			// System.out.println("unitnames"+unitId+""+circleId+""+divisionId+""+subdivisionId);
		/*	if (unitId != null && (typeId == null || typeId == -1)) {

				if (unitId > 0) {

					if (circleId == null || circleId.equals(null)) {
						circleId = 0;
					}
					if (divisionId == null || divisionId.equals(null)) {
						divisionId = 0;
					}
					if (subdivisionId == null || subdivisionId.equals(null)) {
						subdivisionId = 0;
					}
					// System.out.println("coming here");
					// System.out.println("unitnames2"+unitId+""+circleId+""+divisionId+""+subdivisionId);
					taskAllList = taskReportManager.getAllTasksbyunit(unitId, circleId, divisionId, subdivisionId);
					typeId = -1;
				}

			}
*/
		/*	if (unitId != null && typeId != null) {

				if (unitId > 0 && typeId > 0) {

					if (circleId == null || circleId.equals(null)) {
						circleId = 0;
					}
					if (divisionId == null || divisionId.equals(null)) {
						divisionId = 0;
					}
					if (subdivisionId == null || subdivisionId.equals(null)) {
						subdivisionId = 0;
					}

					// System.out.println("coming here");

					taskAllList = taskReportManager.getAllTasksbyUnitbyType(unitId, circleId, divisionId, subdivisionId,
							typeId);
				}

			}*/

			// System.out.println("unitId"+unitId);
			// System.out.println("circleId"+circleId);
			// System.out.println("divisionId"+divisionId);
			// System.out.println("subdivisionId"+subdivisionId);

		} catch (TaskUserException | ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String displaytype = null;
		String displayunit = null;
		String displayvalue = null;

		/*for (int i = 0; i < taskTypeList.size(); i++) {

			if (typeId == taskTypeList.get(i).getTaskTypeId()) {

				displaytype = taskTypeList.get(i).getTaskTypeName();

			}

		}*/
	/*	if (typeId != null) {
			if (typeId == -1) {
				displaytype = "All";
			}
			;
		}
*/
	//	System.out.println("u there" + unitId + circleId + divisionId + subdivisionId);
		/*if (unitId == null && circleId == null && divisionId == null && subdivisionId == null) {

			displayvalue = "All";

			displayunit = "Unit/ Circle/ Division/ Subdivision";

		}*/

		/*if (unitId != null) {

			if (circleId == null || circleId.equals(null)) {
				circleId = 0;
			}
			if (divisionId == null || divisionId.equals(null)) {
				divisionId = 0;
			}
			if (subdivisionId == null || subdivisionId.equals(null)) {
				subdivisionId = 0;
			}*/

			/*if (unitId > 0) {

				for (int i = 0; i < unitList.size(); i++) {

					if (unitId == unitList.get(i).getUnitId()) {

						displayvalue = unitList.get(i).getUnitName();
					}

				}

				displayunit = "Unit";

			}*/

			/*if (unitId > 0 && circleId > 0) {

				if (divisionId == null || divisionId.equals(null)) {
					divisionId = 0;
				}
				if (subdivisionId == null || subdivisionId.equals(null)) {
					subdivisionId = 0;
				}

				for (int i = 0; i < circleList.size(); i++) {

					if (circleId == circleList.get(i).getCircleId()) {

						displayvalue = circleList.get(i).getCircleName();
					}

				}

				displayunit = "Circle";

			}
*/
			/*if (unitId > 0 && circleId > 0 && divisionId > 0) {

				if (subdivisionId == null || subdivisionId.equals(null)) {
					subdivisionId = 0;
				}

				for (int i = 0; i < divisionList.size(); i++) {

					if (divisionId == divisionList.get(i).getDivisionId()) {

						displayvalue = divisionList.get(i).getDivisionName();
					}

				}

				displayunit = "Division";

			}*/

		/*	if (unitId > 0 && circleId > 0 && divisionId > 0 && subdivisionId > 0) {

				for (int i = 0; i < subdivisionList.size(); i++) {

					if (subdivisionId == subdivisionList.get(i).getSubdivisionId()) {

						displayvalue = subdivisionList.get(i).getSubdivisionName();
					}

				}

				displayunit = "Subdivision";

			}*/

		/*}*/

		mav.addObject("unitList", unitList);
		mav.addObject("circleList", circleList);
		mav.addObject("divisionList", divisionList);
		mav.addObject("subdivisionList", subdivisionList);
		mav.addObject("prList", prList);
		
		
		/*mav.addObject("taskAllList", taskAllList);
		mav.addObject("taskFilesList", taskFilesList);
		mav.addObject("taskTypeList", taskTypeList);
		mav.addObject("selectedTask", typeId);
		mav.addObject("displaytype", displaytype);
		mav.addObject("displayvalue", displayvalue);
		mav.addObject("displayunit", displayunit);*/

		return mav;
	}
	
	
	@RequestMapping(value = "/compReport/getliftsall")	
	public ModelAndView Allliftloads(@ModelAttribute("complifts") ComponentsCapacity compcap, SessionStatus status,
			HttpSession session)  {
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("loadoflifts");
		
		Double totalsmallconnected=0.0;
		 Double totalsmallactual=0.0;
		 Double totalmajorconnected=0.0;
		 Double totalmajoractual=0.0;
		 Double totalmediumconnected=0.0;
		 Double totalmediumacttual=0.0;
		 Double abstractconnectedload=0.0;
		 Double abstractactualload=0.0;
		
		List<ComponentsCapacity> compCapList = new ArrayList<ComponentsCapacity>();
		try {
		if(compcap!=null){
			
			if(compcap.getStatusId()!=null){
				if(compcap.getStatusId()>0){
				
			
					compCapList=crm.getComponentCapacityAllLifts(compcap.getStatusId());
					
					if(compCapList!=null){
						
						if(compCapList.size()>0){
							
							Integer len= compCapList.size();
							
							for(int i=0; i<len; i++){
								
								totalsmallconnected=totalsmallconnected+compCapList.get(i).getSmallconnected();
								totalsmallactual=totalsmallactual+compCapList.get(i).getSmallactual();
								totalmediumconnected=totalmediumconnected+compCapList.get(i).getMediumconnected();
								totalmediumacttual=totalmediumacttual+compCapList.get(i).getMediumactual();
								totalmajorconnected=totalmajorconnected+compCapList.get(i).getMajorconnected();
								totalmajoractual=totalmajoractual+compCapList.get(i).getMajoractual();
								
								abstractconnectedload=totalsmallconnected+totalmediumconnected+totalmajorconnected;
								abstractactualload=totalsmallactual+totalmediumacttual+totalmajoractual;
								
								mav.addObject("totalsmallconnected",totalsmallconnected);
								mav.addObject("totalsmallactual",totalsmallactual);
								mav.addObject("totalmediumconnected",totalmediumconnected);
								mav.addObject("totalmediumacttual",totalmediumacttual);
								mav.addObject("totalmajorconnected",totalmajorconnected);
								mav.addObject("totalmajoractual",totalmajoractual);
								mav.addObject("abstractconnectedload",abstractconnectedload);
								mav.addObject("abstractactualload",abstractactualload);
								
								
							}
							
							
						}
						
						
						
					}
					
					mav.addObject("compCapList",compCapList);
				
				
				}
			}
			
			
			
		}
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		return mav;
		
	}
	
	
	@RequestMapping(value = "/compReport/getSummeryAll")	
	public ModelAndView SummeryLiftLoads(@ModelAttribute("comp") Component comp, SessionStatus status,
			HttpSession session) {
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("summeryoflifts");
		
		
	
		return mav;
		
	}
	
	@RequestMapping(value = "/compReport/comppowerinfo")
	@ResponseBody
	public ModelAndView ComponentPowerinforeport(@ModelAttribute("comp") Component comp, SessionStatus status,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("comppowerinfo");

		List<Unit> unitList = new ArrayList<Unit>();
		List<Circle> circleList = new ArrayList<Circle>();
		List<Division> divisionList = new ArrayList<Division>();
		List<Subdivision> subdivisionList = new ArrayList<Subdivision>();
		
		List<Project> prList = new ArrayList<Project>();
		
		List<Component> compList = new ArrayList<Component>();

	/*	List<Task> taskAllList = new ArrayList<Task>();
		List<TaskFiles> taskFilesList = new ArrayList<TaskFiles>();

		List<TaskType> taskTypeList = new ArrayList<TaskType>();*/

		Integer unitId = 0;
		Integer circleId = 0;
		Integer divisionId = 0;
		Integer subdivisionId = 0;
		Integer typeId = 0;
		
		Integer projectId=comp.getProjectId();
		Double totalMW=0.0;
		Double newtotalPowerWithAux=0.0;
		Double totaldischargecusecs=0.0;
		Double totalayacutAcres=0.0;

		if (comp != null) {

			unitId = comp.getUnitId();
			circleId = comp.getCircleId();
			divisionId = comp.getDivisionId();
			subdivisionId = comp.getSubdivisionId();
			

		}

		try {
			unitList = tam.getunitpostList();
			circleList = tam.getcirclepostList();
			divisionList = tam.getdivisionpostList();
			subdivisionList = tam.getsubdivisionpostList();
			prList=tam.getprojListbypostgres();
			

			if(projectId!=null){
              if(projectId>0){
            	  
            	 // System.out.println("projectId"+projectId);
            	  compList= crm.getCompPowerInfo(projectId);
            	  
            	  if(compList!=null){
            		  if(compList.size()>0){
            			  
            			  int len=compList.size();
            			  for(int i=0; i<len; i++){
            				  
            				  totalMW=totalMW+compList.get(i).getMotormegawatts(); 
            				  
            				  newtotalPowerWithAux=newtotalPowerWithAux+compList.get(i).getTotalpowerwithAux();
            				  
            				  totaldischargecusecs=totaldischargecusecs+compList.get(i).getDischrgecusecs();
            						  totalayacutAcres=totalayacutAcres+compList.get(i).getAyacutacres();
            			  }
            			  
            			  
            			  
            		  }
            		  
            		  
            	  }
            	  
            	  mav.addObject("compList",compList);
            	  mav.addObject("totalMW",totalMW);
            	  mav.addObject("newtotalPowerWithAux",Math.round(newtotalPowerWithAux));
            	  mav.addObject("totaldischargecusecs",totaldischargecusecs);
            	  mav.addObject("totalayacutAcres",totalayacutAcres);
            	  
            	  
              }
			}

		

		} catch (TaskUserException | ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String displaytype = null;
		String displayunit = null;
		String displayvalue = null;

		
	
	
			

			
		
		mav.addObject("unitList", unitList);
		mav.addObject("circleList", circleList);
		mav.addObject("divisionList", divisionList);
		mav.addObject("subdivisionList", subdivisionList);
		mav.addObject("prList", prList);
		
		
		

		return mav;
	}
	
	 @RequestMapping(value="/compReport/componentMap")
		public ModelAndView componentMap(@ModelAttribute("compMap") Component compMap, SessionStatus status,
				HttpSession session){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("compMap");
			
			
			List<Unit> unitList = new ArrayList<Unit>();
			List<Circle> circleList = new ArrayList<Circle>();
			List<Division> divisionList = new ArrayList<Division>();
			List<Subdivision> subdivisionList = new ArrayList<Subdivision>();
			
			List<Project> prList = new ArrayList<Project>();
			
			List<Component> compList=new ArrayList<Component>();
			
			List<Component> componentsList = new ArrayList<Component>();
			List<ComponentLineSegment> segments = new ArrayList<ComponentLineSegment>();

		
			

			Integer unitId = 0;
			Integer circleId = 0;
			Integer divisionId = 0;
			Integer subdivisionId = 0;
			Integer typeId = 0;
			
			Integer projectId=compMap.getProjectId();
			Double totalMW=0.0;
			Double newtotalPowerWithAux=0.0;
			Double totaldischargecusecs=0.0;
			Double totalayacutAcres=0.0;

			if (compMap != null) {

				unitId = compMap.getUnitId();
				circleId = compMap.getCircleId();
				divisionId = compMap.getDivisionId();
				subdivisionId = compMap.getSubdivisionId();
				

			}

			try {
				unitList = tam.getunitpostList();
				circleList = tam.getcirclepostList();
				divisionList = tam.getdivisionpostList();
				subdivisionList = tam.getsubdivisionpostList();
				prList=tam.getprojListbypostgres();
				
				//map starts here
				
			
				
				//map ends here
				

			

			} catch (TaskUserException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
				

				
			
			mav.addObject("unitList", unitList);
			mav.addObject("circleList", circleList);
			mav.addObject("divisionList", divisionList);
			mav.addObject("subdivisionList", subdivisionList);
			mav.addObject("prList", prList);
			
			
			

			return mav;
			
		}
	 
	 
	 
		
		@RequestMapping(value = "/compReport/getcomp-ayacut-report")	
		public ModelAndView compAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("compAyacutReport");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			List<District> distList =new ArrayList<District>();
			
			
			
			
			
			Double totalManayacut=0.0;
			Double totalManStableayacut=0.0;
			Double totalIrrayacut=0.0;
			Double totalContemplatedAyacut=0.0;
			try {
				
				distList=lam.getDistricts();
						
						//crm.getOldDistricts();
				
				mav.addObject("distList",distList);
				
				if(compayacut.getDistrictId()!=null){
					if(compayacut.getDistrictId()>0){
				ayacutList=crm.getMandalAyacutInfo(compayacut.getDistrictId());
				}
				}
				
			
				
				
				Integer len1=ayacutList.size();
				
				
				
				for(int i=0; i<len1 ; i++){
					
					if(ayacutList.get(i).getDistrictId()!=-3){
					totalManayacut=totalManayacut+ayacutList.get(i).getAyacutCreated();
					totalIrrayacut=totalIrrayacut+ayacutList.get(i).getIrriagtedAyacut();
					totalManStableayacut=totalManStableayacut+ayacutList.get(i).getStableAyacut();					
					totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();	
					}
				}
				
				mav.addObject("totalManayacut",Math.round(totalManayacut));
				
				mav.addObject("totalManStableayacut",Math.round(totalManStableayacut));
				mav.addObject("totalIrrayacut",Math.round(totalIrrayacut));
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				
			/*	System.out.println(" totalManayacut"+totalManayacut);
				System.out.println("dist totalManStableayacut"+totalManStableayacut);
				System.out.println("dist totalIrrayacut"+totalIrrayacut);
				System.out.println("dist totalContemplatedAyacut"+totalContemplatedAyacut);*/
				
				
			/*	int [] conarray;
				int m=0;
				int n=0;
				for(int i=0; i<len ;i++){
					
					for(int j=0;j<conslen;j++){
						
						m=0;
						if(ayacutList.get(i).getConstId()==cons.get(j).getConstId()){
							totalAyacut[0]=0.0;
							totaleStable[0]=0.0;
						
						System.out.println("cons[j]"+cons.get(j).getConstName());
						System.out.println("ayacut[i]"+ayacutList.get(i).getConstName());
						totalAyacut[m]=totalAyacut[m]+ayacutList.get(i).getAyacutCreated();
	                	totaleStable[n]=totaleStable[n]+ayacutList.get(i).getStableAyacut();
						
                            m=m+1;
						
						System.out.println("m"+m);
						
						}	
						
						
					}
					
					
					
				}
				*/
				
				/*int f=0;
				
				for (int i = 0; i < len; i++) {
					System.out.println("i"+ayacutList.get(i).getConstName());
		            for (int j = 0; j < conslen; j++) {
		            	
		            	System.out.println("j"+ayacutList.get(j).getConstName());
		                if (ayacutList.get(i).getConstId()==ayacutList.get(j).getConstId()   && ayacutList.get(i).getDistrictId()==ayacutList.get(j).getDistrictId()  && ayacutList.get(i).getProjectId()==ayacutList.get(j).getProjectId() && ayacutList.get(i).getUnitId() ==ayacutList.get(j).getUnitId()) {
		                	
		                	System.out.println("inside"+ayacutList.get(j).getConstName());
		                	//f=f+1;
		                	
		                	//System.out.println("f"+f);
		                	
		                	//System.out.println("totalAyacut"+totalAyacut[j]);
		                	//totalAyacut[j]=totalAyacut[j]+ayacutList.get(i).getAyacutCreated();
		                	//totaleStable[j]=totaleStable[j]+ayacutList.get(i).getStableAyacut();
		                	
		                	//auyacutSum.put(ayacutList.get(i).getConstId(), totalAyacut);
		                	
		                	
		                	
		                	
		                	
		                	
		                	
		                }
		            }
		        }*/


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LeagalUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    mav.addObject("ayacutList",ayacutList);
		 
		  
			return mav;
			
		}
		
		
		
		@RequestMapping(value = "/compReport/ce-ayacut")	
		public ModelAndView ceAyacut(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("ce-ayacut");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			//List<District> distList =new ArrayList<District>();
			Double totalContemplatedAyacut=0.0;
			Double totalManayacut=0.0;
		
			Double totalIrrayacut=0.0;
			Double totalManStableayacut=0.0;
			
			
			try {
				//distList=lam.getDistricts();
						//crm.getOldDistricts();
			//	mav.addObject("distList",distList);
				ayacutList=crm.getUnitAyacutInfo();
				

				
				//System.out.println("ayacutList"+ayacutList);

			
			
				if(ayacutList!=null){
				
					if(ayacutList.size()>0){
				Integer len1=ayacutList.size();
				
				
			
				for(int i=0; i<len1 ; i++){
					
					if(ayacutList.get(i).getAyacutCreated()!=null){
					
					if(ayacutList.get(i).getProjectId()!=-3){
						totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();	
					totalManayacut=totalManayacut+ayacutList.get(i).getAyacutCreated();
					totalIrrayacut=totalIrrayacut+ayacutList.get(i).getIrriagtedAyacut();
					totalManStableayacut=totalManStableayacut+ayacutList.get(i).getStableAyacut();		
						
					
					}
					
					}
				}
				}
				}
				
				mav.addObject("totalManayacut",Math.round(totalManayacut));
				
				mav.addObject("totalManStableayacut",Math.round(totalManStableayacut));
				mav.addObject("totalIrrayacut",Math.round(totalIrrayacut));
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				/*System.out.println("CE totalManayacut"+totalManayacut);
				System.out.println("CE totalManStableayacut"+totalManStableayacut);
				System.out.println("CE totalIrrayacut"+totalIrrayacut);
				System.out.println("CE totalContemplatedAyacut"+totalContemplatedAyacut);*/
			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    mav.addObject("ayacutList",ayacutList);
		 
		  
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/ce-district-ayacut")	
		public ModelAndView ceDistrictAyacut(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("ce-district-ayacut");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			//List<District> distList =new ArrayList<District>();
			Double totalContemplatedAyacut=0.0;
			Double totalManayacut=0.0;
		
			Double totalIrrayacut=0.0;
			Double totalManStableayacut=0.0;
			
			
			try {
				//distList=lam.getDistricts();
						//crm.getOldDistricts();
			//	mav.addObject("distList",distList);
				ayacutList=crm.getUnitDistrictAyacutInfo();
				

				
				//System.out.println("ayacutList"+ayacutList);

			
			
				if(ayacutList!=null){
				
					if(ayacutList.size()>0){
				Integer len1=ayacutList.size();
				
				
			
				for(int i=0; i<len1 ; i++){
					
					if(ayacutList.get(i).getAyacutCreated()!=null){
					
					if(ayacutList.get(i).getDistrictId()!=-3){
						totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();	
					totalManayacut=totalManayacut+ayacutList.get(i).getAyacutCreated();
					totalIrrayacut=totalIrrayacut+ayacutList.get(i).getIrriagtedAyacut();
					totalManStableayacut=totalManStableayacut+ayacutList.get(i).getStableAyacut();		
						
					
					}
					
					}
				}
				}
				}
				
				mav.addObject("totalManayacut",Math.round(totalManayacut));
				
				mav.addObject("totalManStableayacut",Math.round(totalManStableayacut));
				mav.addObject("totalIrrayacut",Math.round(totalIrrayacut));
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				/*System.out.println("CE totalManayacut"+totalManayacut);
				System.out.println("CE totalManStableayacut"+totalManStableayacut);
				System.out.println("CE totalIrrayacut"+totalIrrayacut);
				System.out.println("CE totalContemplatedAyacut"+totalContemplatedAyacut);*/
			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    mav.addObject("ayacutList",ayacutList);
		 
		  
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/proj-pack-man")	
		public ModelAndView ProjPackMan(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("proj-pack-man");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			//List<District> distList =new ArrayList<District>();
			Double totalContemplatedAyacut=0.0;
			Double totalManayacut=0.0;
		
			Double totalIrrayacut=0.0;
			Double totalManStableayacut=0.0;
			
			
			try {
				//distList=lam.getDistricts();
						//crm.getOldDistricts();
			//	mav.addObject("distList",distList);
				ayacutList=crm.getProjPackManTotal();
				

				
				//System.out.println("ayacutList"+ayacutList);

			
			
				if(ayacutList!=null){
				
					if(ayacutList.size()>0){
				Integer len1=ayacutList.size();
				
				
			
				for(int i=0; i<len1 ; i++){
					
					if(ayacutList.get(i).getAyacutCreated()!=null){
					
					if(ayacutList.get(i).getMandalId()!=-2 && ayacutList.get(i).getPackageId()!=-3 && ayacutList.get(i).getMandalId()!=-3){
						totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();	
					totalManayacut=totalManayacut+ayacutList.get(i).getAyacutCreated();
					totalIrrayacut=totalIrrayacut+ayacutList.get(i).getIrriagtedAyacut();
					totalManStableayacut=totalManStableayacut+ayacutList.get(i).getStableAyacut();		
						
					
					}
					
					}
				}
				}
				}
				
				mav.addObject("totalManayacut",Math.round(totalManayacut));
				
				mav.addObject("totalManStableayacut",Math.round(totalManStableayacut));
				mav.addObject("totalIrrayacut",Math.round(totalIrrayacut));
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				/*System.out.println("CE totalManayacut"+totalManayacut);
				System.out.println("CE totalManStableayacut"+totalManStableayacut);
				System.out.println("CE totalIrrayacut"+totalIrrayacut);
				System.out.println("CE totalContemplatedAyacut"+totalContemplatedAyacut);*/
			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    mav.addObject("ayacutList",ayacutList);
		 
		  
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/dist-man-proj-total")	
		public ModelAndView DistManProjTotal(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("dist-man-proj-total");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			//List<District> distList =new ArrayList<District>();
			Double totalContemplatedAyacut=0.0;
			Double totalManayacut=0.0;
		
			Double totalIrrayacut=0.0;
			Double totalManStableayacut=0.0;
			
			
			try {
				//distList=lam.getDistricts();
						//crm.getOldDistricts();
			//	mav.addObject("distList",distList);
				ayacutList=crm.getDistrictManprojTotal();
				

				
				//System.out.println("ayacutList"+ayacutList);

			
			
				if(ayacutList!=null){
				
					if(ayacutList.size()>0){
				Integer len1=ayacutList.size();
				
				
			
				for(int i=0; i<len1 ; i++){
					
					if(ayacutList.get(i).getAyacutCreated()!=null){
					
					if(ayacutList.get(i).getProjectId()!=-1 && ayacutList.get(i).getProjectId()!=-5 && ayacutList.get(i).getProjectId()!=-2){
						totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();	
					totalManayacut=totalManayacut+ayacutList.get(i).getAyacutCreated();
					totalIrrayacut=totalIrrayacut+ayacutList.get(i).getIrriagtedAyacut();
					totalManStableayacut=totalManStableayacut+ayacutList.get(i).getStableAyacut();		
						
					
					}
					
					}
				}
				}
				}
				
				mav.addObject("totalManayacut",Math.round(totalManayacut));
				
				mav.addObject("totalManStableayacut",Math.round(totalManStableayacut));
				mav.addObject("totalIrrayacut",Math.round(totalIrrayacut));
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				/*System.out.println("CE totalManayacut"+totalManayacut);
				System.out.println("CE totalManStableayacut"+totalManStableayacut);
				System.out.println("CE totalIrrayacut"+totalIrrayacut);
				System.out.println("CE totalContemplatedAyacut"+totalContemplatedAyacut);*/
			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    mav.addObject("ayacutList",ayacutList);
		 
		  
			return mav;
			
		}
		
		
		
		@RequestMapping(value = "/compReport/proj-man")	
		public ModelAndView ProjMan(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("proj-man");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			//List<District> distList =new ArrayList<District>();
			Double totalContemplatedAyacut=0.0;
			Double totalManayacut=0.0;
		
			Double totalIrrayacut=0.0;
			Double totalManStableayacut=0.0;
			
			
			try {
				//distList=lam.getDistricts();
						//crm.getOldDistricts();
			//	mav.addObject("distList",distList);
				ayacutList=crm.getProjManTotal();
				

				
				//System.out.println("ayacutList"+ayacutList);

			
			
				if(ayacutList!=null){
				
					if(ayacutList.size()>0){
				Integer len1=ayacutList.size();
				
				
			
				for(int i=0; i<len1 ; i++){
					
					if(ayacutList.get(i).getAyacutCreated()!=null){
					
					if(ayacutList.get(i).getMandalId()!=-3 ){
						totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();	
					totalManayacut=totalManayacut+ayacutList.get(i).getAyacutCreated();
					totalIrrayacut=totalIrrayacut+ayacutList.get(i).getIrriagtedAyacut();
					totalManStableayacut=totalManStableayacut+ayacutList.get(i).getStableAyacut();		
						
					
					}
					
					}
				}
				}
				}
				
				mav.addObject("totalManayacut",Math.round(totalManayacut));
				
				mav.addObject("totalManStableayacut",Math.round(totalManStableayacut));
				mav.addObject("totalIrrayacut",Math.round(totalIrrayacut));
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				/*System.out.println("CE totalManayacut"+totalManayacut);
				System.out.println("CE totalManStableayacut"+totalManStableayacut);
				System.out.println("CE totalIrrayacut"+totalIrrayacut);
				System.out.println("CE totalContemplatedAyacut"+totalContemplatedAyacut);*/
			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    mav.addObject("ayacutList",ayacutList);
		 
		  
			return mav;
			
		}
		
		
		
		@RequestMapping(value = "/compReport/proj-man-village")	
		public ModelAndView ProjManVillage(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("proj-man-village");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			//List<District> distList =new ArrayList<District>();
			Double totalContemplatedAyacut=0.0;
			Double totalManayacut=0.0;
		
			Double totalIrrayacut=0.0;
			Double totalManStableayacut=0.0;
			
			
			try {
				//distList=lam.getDistricts();
						//crm.getOldDistricts();
			//	mav.addObject("distList",distList);
				ayacutList=crm.getProjManVillageTotal();
				

				
				//System.out.println("ayacutList"+ayacutList);

			
			
				if(ayacutList!=null){
				
					if(ayacutList.size()>0){
				Integer len1=ayacutList.size();
				
				
			
				for(int i=0; i<len1 ; i++){
					
					if(ayacutList.get(i).getAyacutCreated()!=null){
					
					if(ayacutList.get(i).getMandalId()!=-3 ){
						totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();	
					totalManayacut=totalManayacut+ayacutList.get(i).getAyacutCreated();
					totalIrrayacut=totalIrrayacut+ayacutList.get(i).getIrriagtedAyacut();
					totalManStableayacut=totalManStableayacut+ayacutList.get(i).getStableAyacut();		
						
					
					}
					
					}
				}
				}
				}
				
				mav.addObject("totalManayacut",Math.round(totalManayacut));
				
				mav.addObject("totalManStableayacut",Math.round(totalManStableayacut));
				mav.addObject("totalIrrayacut",Math.round(totalIrrayacut));
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				/*System.out.println("CE totalManayacut"+totalManayacut);
				System.out.println("CE totalManStableayacut"+totalManStableayacut);
				System.out.println("CE totalIrrayacut"+totalIrrayacut);
				System.out.println("CE totalContemplatedAyacut"+totalContemplatedAyacut);*/
			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    mav.addObject("ayacutList",ayacutList);
		 
		  
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/district-ayacut")	
		public ModelAndView districtAyacut(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("district-ayacut");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			//List<District> distList =new ArrayList<District>();
			
			Double totalManayacut=0.0;
			Double totalManStableayacut=0.0;
			Double totalIrrayacut=0.0;
			Double totalContemplatedAyacut=0.0;
			try {
				//distList=lam.getDistricts();
						//crm.getOldDistricts();
			//	mav.addObject("distList",distList);
				ayacutList=crm.getDistprojAyacutInfo();   
				
				//System.out.println("ayacutList"+ayacutList);
			
				if(ayacutList!=null){
				
					if(ayacutList.size()>0){
				Integer len1=ayacutList.size();
				
				
			
				for(int i=0; i<len1 ; i++){
					
					if(ayacutList.get(i).getAyacutCreated()!=null){
					
					if(ayacutList.get(i).getProjectId()!=-3){
					totalManayacut=totalManayacut+ayacutList.get(i).getAyacutCreated();
					totalIrrayacut=totalIrrayacut+ayacutList.get(i).getIrriagtedAyacut();
					totalManStableayacut=totalManStableayacut+ayacutList.get(i).getStableAyacut();	
					totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();	
					
					}
					
					}
				}
				}
				}
				
				mav.addObject("totalManayacut",Math.round(totalManayacut));
				
				mav.addObject("totalManStableayacut",Math.round(totalManStableayacut));
				mav.addObject("totalIrrayacut",Math.round(totalIrrayacut));
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				
			/*	System.out.println("dist totalManayacut"+totalManayacut);
				System.out.println("dist totalManStableayacut"+totalManStableayacut);
				System.out.println("dist totalIrrayacut"+totalIrrayacut);
				System.out.println("dist totalContemplatedAyacut"+totalContemplatedAyacut);*/

			
			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    mav.addObject("ayacutList",ayacutList);
		 
		  
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/getconst-proj-ayacut-report")	
		public ModelAndView getConstProjAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("constProjectAyacutReport");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			//List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			List<District> distList =new ArrayList<District>();
			
			Double totalConstContemplatedAyacut=0.0;
			Double totalConstayacutcreated=0.0;
			Double totalConstIrrigatedAyacut=0.0;
			Double totalConstStableayacut=0.0;			
			
			
			
			
			try {
			
				distList=lam.getDistricts();
				
				mav.addObject("distList",distList);
				
				
				if(compayacut.getDistrictId()!=null){
							if(compayacut.getDistrictId()>0){
								ayacutList=crm.getConstAyacutSum(compayacut.getDistrictId());
							}
				}
				
				Integer len2=ayacutList.size();
				
				
				
				

				for(int i=0; i<len2 ; i++){
					
					if(ayacutList.get(i).getProjectId()!=-3){
						totalConstContemplatedAyacut=totalConstContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();
						totalConstayacutcreated=totalConstayacutcreated+ayacutList.get(i).getAyacutCreated();
						totalConstIrrigatedAyacut=totalConstIrrigatedAyacut+ayacutList.get(i).getIrriagtedAyacut();
						totalConstStableayacut=totalConstStableayacut+ayacutList.get(i).getStableAyacut();
					}
					
				}
				
				mav.addObject("totalConstContemplatedAyacut",Math.round(totalConstContemplatedAyacut));
				
				mav.addObject("totalConstayacutcreated",Math.round(totalConstayacutcreated));
				
                mav.addObject("totalConstIrrigatedAyacut",Math.round(totalConstIrrigatedAyacut));
				
				mav.addObject("totalConstStableayacut",Math.round(totalConstStableayacut));
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LeagalUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("ayacutList",ayacutList);
		   
			return mav;
			
		}
		
		
		
		@RequestMapping(value = "/compReport/dist-man-proj")	
		public ModelAndView distManProj(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("dist-man-proj");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			//List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			List<District> distList =new ArrayList<District>();
			
			Double totalConstContemplatedAyacut=0.0;
			Double totalConstayacutcreated=0.0;
			Double totalConstIrrigatedAyacut=0.0;
			Double totalConstStableayacut=0.0;	
			
			Double MajorConstContemplatedAyacut=0.0;
			Double MajorConstayacutcreated=0.0;
			Double MajorConstIrrigatedAyacut=0.0;
			Double MajorConstStableayacut=0.0;	
			
			Double MediumConstContemplatedAyacut=0.0;
			Double MediumConstayacutcreated=0.0;
			Double MediumConstIrrigatedAyacut=0.0;
			Double MediumConstStableayacut=0.0;	
			
			
			
			
			try {
			
				distList=lam.getDistricts();
				
				mav.addObject("distList",distList);
				
				
				if(compayacut.getDistrictId()!=null){
							if(compayacut.getDistrictId()>0){
								ayacutList=crm.getDistManProjAyacutSum(compayacut.getDistrictId());
							}
				}
				
				Integer len2=ayacutList.size();
				
				
				
				

				for(int i=0; i<len2 ; i++){
					
					if(ayacutList.get(i).getProjectId()!=-5 && ayacutList.get(i).getProjectId()!=-1){
						totalConstContemplatedAyacut=totalConstContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();
						totalConstayacutcreated=totalConstayacutcreated+ayacutList.get(i).getAyacutCreated();
						totalConstIrrigatedAyacut=totalConstIrrigatedAyacut+ayacutList.get(i).getIrriagtedAyacut();
						totalConstStableayacut=totalConstStableayacut+ayacutList.get(i).getStableAyacut();
					}
					
					if(ayacutList.get(i).getProjectId()!=-5 && ayacutList.get(i).getProjectId()!=-1){
						
						if(ayacutList.get(i).getProjectTypeId()==1){
						
							MajorConstContemplatedAyacut=MajorConstContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();
							MajorConstayacutcreated=MajorConstayacutcreated+ayacutList.get(i).getAyacutCreated();
							MajorConstIrrigatedAyacut=MajorConstIrrigatedAyacut+ayacutList.get(i).getIrriagtedAyacut();
							MajorConstStableayacut=MajorConstStableayacut+ayacutList.get(i).getStableAyacut();
						
						
					}
						
						if(ayacutList.get(i).getProjectTypeId()==2){
							
							MediumConstContemplatedAyacut=MediumConstContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();
							MediumConstayacutcreated=MediumConstayacutcreated+ayacutList.get(i).getAyacutCreated();
							MediumConstIrrigatedAyacut=MediumConstIrrigatedAyacut+ayacutList.get(i).getIrriagtedAyacut();
							MediumConstStableayacut=MediumConstStableayacut+ayacutList.get(i).getStableAyacut();
							
							
						}
					
				}
				}
				
				mav.addObject("totalConstContemplatedAyacut",Math.round(totalConstContemplatedAyacut));
				
				mav.addObject("totalConstayacutcreated",Math.round(totalConstayacutcreated));
				
                mav.addObject("totalConstIrrigatedAyacut",Math.round(totalConstIrrigatedAyacut));
				
				mav.addObject("totalConstStableayacut",Math.round(totalConstStableayacut));
				
                  mav.addObject("MajorConstContemplatedAyacut",Math.round(MajorConstContemplatedAyacut));
				
				mav.addObject("MajorConstayacutcreated",Math.round(MajorConstayacutcreated));
				
                mav.addObject("MajorConstIrrigatedAyacut",Math.round(MajorConstIrrigatedAyacut));
				
				mav.addObject("MajorConstStableayacut",Math.round(MajorConstStableayacut));
				
            mav.addObject("MediumConstContemplatedAyacut",Math.round(MediumConstContemplatedAyacut));
				
				mav.addObject("MediumConstayacutcreated",Math.round(MediumConstayacutcreated));
				
                mav.addObject("MediumConstIrrigatedAyacut",Math.round(MediumConstIrrigatedAyacut));
				
				mav.addObject("MediumConstStableayacut",Math.round(MediumConstStableayacut));
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LeagalUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("ayacutList",ayacutList);
		   
			return mav;
			
		}
		
		
		
		

		@RequestMapping(value = "/compReport/getconsttotal-ayacut-report")	
		public ModelAndView getConsttotalAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("consttotalayacutsp");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalConstContemplatedAyacyt=0.0;
			Double totalConstayacutCreated=0.0;
			Double totalConstIrrigatedayacut=0.0;			
			
			Double totalConstStableayacut=0.0;
			
			
			
			
			try {
			
			
				
				constList=crm.getConstTotalSum();
				
				Integer len2=constList.size();
				
				
				
				

				for(int i=0; i<len2 ; i++){
					
					
					totalConstContemplatedAyacyt=totalConstContemplatedAyacyt+constList.get(i).getContemplatedAyacut();
					totalConstayacutCreated=totalConstayacutCreated+constList.get(i).getAyacutCreated();
					totalConstIrrigatedayacut=totalConstIrrigatedayacut+constList.get(i).getIrriagtedAyacut();
					totalConstStableayacut=totalConstStableayacut+constList.get(i).getStableAyacut();
					
					
				}
				
				mav.addObject("totalConstContemplatedAyacyt",Math.round(totalConstContemplatedAyacyt));
				
				mav.addObject("totalConstayacutCreated",Math.round(totalConstayacutCreated));
				
                mav.addObject("totalConstIrrigatedayacut",Math.round(totalConstIrrigatedayacut));
				
				mav.addObject("totalConstStableayacut",Math.round(totalConstStableayacut));
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("constList",constList);
		   
			return mav;
			
		}
		
		@RequestMapping(value = "/compReport/getprojtotalAyacutReport")	
		public ModelAndView getprojtotalconstAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("projtotalayacut");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalContemplatedAyacut=0.0;
			Double totalAyacutCreated=0.0;
			Double totalIrrigatedAyacut=0.0;
			Double totalStableAyacut=0.0;
			
			
			try {
			
			
				if(compayacut.getConstId()!=null){
					if(compayacut.getConstId()>0){
				constList=crm.getprojTotalbyconstSum(compayacut.getConstId());
					}
				}
				
				Integer len2=constList.size();
				
				
				
				

				for(int i=0; i<len2 ; i++){
					
					
					totalContemplatedAyacut=totalContemplatedAyacut+constList.get(i).getContemplatedAyacut();
					totalAyacutCreated=totalAyacutCreated+constList.get(i).getAyacutCreated();
					totalIrrigatedAyacut=totalIrrigatedAyacut+constList.get(i).getIrriagtedAyacut();
							totalStableAyacut=totalStableAyacut+constList.get(i).getStableAyacut();
							
					
					
				}
				
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				mav.addObject("totalAyacutCreated",Math.round(totalAyacutCreated));
				
                 mav.addObject("totalIrrigatedAyacut",Math.round(totalIrrigatedAyacut));
				
				mav.addObject("totalStableAyacut",Math.round(totalStableAyacut));
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("constList",constList);
		   
			return mav;
			
		}
		
		@RequestMapping(value = "/compReport/getprojtotalDistAyacutReport")	
		public ModelAndView getprojtotalDistconstAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("projTotalDistConstAyacut");
			
			//List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalContemplatedAyacut=0.0;
			Double totalayacutCreated=0.0;
			Double totalIrrigatedAyacut=0.0;
			Double totalStableAyacut=0.0;
			
			
			try {
			
			
				if(compayacut.getConstId()!=null){
					if(compayacut.getConstId()>0){
				constList=crm.getprojTotalbydistconstSum(compayacut.getConstId());
					}
				}
				
				Integer len2=constList.size();
				
				
				
				

				for(int i=0; i<len2 ; i++){
					
					
					totalContemplatedAyacut=totalContemplatedAyacut+constList.get(i).getContemplatedAyacut();
					totalayacutCreated=totalayacutCreated+constList.get(i).getAyacutCreated();
					totalIrrigatedAyacut=totalIrrigatedAyacut+constList.get(i).getIrriagtedAyacut();
					totalStableAyacut=totalStableAyacut+constList.get(i).getStableAyacut();
					
					
				}
				
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				mav.addObject("totalayacutCreated",Math.round(totalayacutCreated));
				
         mav.addObject("totalIrrigatedAyacut",Math.round(totalIrrigatedAyacut));
				
				mav.addObject("totalStableAyacut",Math.round(totalStableAyacut));
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("constList",constList);
		   
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/getdist-total-ayacut-report")	
		public ModelAndView getDistTotalconstAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			//System.out.println("i am not coming here");
			ModelAndView mav= new ModelAndView();
			mav.setViewName("distTotalConstAyacut");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalContemplatedAycut=0.0;
			Double totalConstAyacutCreated=0.0;
			Double totalConstIrrigatedAyacut=0.0;
			Double totalConstStableAyacut=0.0;
			
			
			try {
			
			
				if(compayacut.getConstId()!=null){
					if(compayacut.getConstId()>0){
				constList=crm.getDistTotalbyconstSum(compayacut.getConstId());
					}
				}
				
				Integer len2=constList.size();
				
				
				
				

				for(int i=0; i<len2 ; i++){
					
					
					totalContemplatedAycut=totalContemplatedAycut+constList.get(i).getContemplatedAyacut();
					totalConstAyacutCreated=totalConstAyacutCreated+constList.get(i).getAyacutCreated();				
					totalConstIrrigatedAyacut=totalConstIrrigatedAyacut+constList.get(i).getIrriagtedAyacut();
					totalConstStableAyacut=totalConstStableAyacut+constList.get(i).getStableAyacut();
				}
				
				mav.addObject("totalContemplatedAycut",Math.round(totalContemplatedAycut));
				
				mav.addObject("totalConstAyacutCreated",Math.round(totalConstAyacutCreated));
				
                mav.addObject("totalConstIrrigatedAyacut",Math.round(totalConstIrrigatedAyacut));
				
				mav.addObject("totalConstStableAyacut",Math.round(totalConstStableAyacut));
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("constList",constList);
		   
			return mav;
			
		}
		
		@RequestMapping(value = "/compReport/getMandalTotalAyacutReport")	
		public ModelAndView getMandalTotalconstAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("mandalTotalAyacut");
			
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalConstContemplatedAyacut=0.0;
			Double totalConstAyacutCreated=0.0;
			
			Double totalConstIrrigatedAyacut=0.0;
			Double totalConstStableAyacut=0.0;
			
			
			try {
			
			
				if(compayacut.getDistrictId()!=null && compayacut.getConstId()!=null ){
					if(compayacut.getDistrictId()>0 && compayacut.getConstId()>0){
				constList=crm.getMandalTotalbyconstSum(compayacut.getDistrictId(),compayacut.getConstId());
					}
				}
				
				Integer len2=constList.size();
				
				
			
				for(int i=0; i<len2 ; i++){
					
					
					totalConstContemplatedAyacut=totalConstContemplatedAyacut+constList.get(i).getContemplatedAyacut();
					totalConstAyacutCreated=totalConstAyacutCreated+constList.get(i).getAyacutCreated();
					totalConstIrrigatedAyacut=totalConstIrrigatedAyacut+constList.get(i).getIrriagtedAyacut();
					totalConstStableAyacut=totalConstStableAyacut+constList.get(i).getStableAyacut();
					
					
				}
				
				mav.addObject("totalConstContemplatedAyacut",Math.round(totalConstContemplatedAyacut));
				
				mav.addObject("totalConstAyacutCreated",Math.round(totalConstAyacutCreated));
				
				mav.addObject("totalConstIrrigatedAyacut",Math.round(totalConstIrrigatedAyacut));
				
				mav.addObject("totalConstStableAyacut",Math.round(totalConstStableAyacut));
				
				
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("constList",constList);
		   
			return mav;
			
		}
		
		
/*		
		@RequestMapping(value = "/compReport/getconstTotalprojAyacut")	
		public ModelAndView getConstTotalprojAyacut(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("consttotalprojayacut");
			
			
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   newconstList = new ArrayList<ComponentAyacut>();
			List<Constituency> cons=new ArrayList<Constituency>();
			
			List<ComponentAyacut>   totalconstayacutList = new ArrayList<ComponentAyacut>();
			
			
			
			
			Double totalConstayacut=0.0;
			Double totalConstStableayacut=0.0;
			
			
			try {
			
				
				
				//cons=cam.getConstList();
				ayacutList=crm.getprojTotalAllconstSum();
				//newconstList=crm.getConstTotalSum();
			
				
				
			
				
				mav.addObject("ayacutList",ayacutList);
				//mav.addObject("newconstList",newconstList);

				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		   
		   
			return mav;
			
		}
		
		*/
		
		
		@RequestMapping(value = "/compReport/getproject-ayacut-report")	
		public ModelAndView getProjectTotalAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("projectTotalReport");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalContemplatedAyacut=0.0;
			Double totalAyacutCreated=0.0;
			Double totalIrrigatedAyacut=0.0;
			Double totalStableayacut=0.0;
			
			
			try {
			
			
				ayacutList=crm.getprojTotal();
				
				
				Integer len2=ayacutList.size();
				
				
				
				

				for(int i=0; i<len2 ; i++){
					
					
					totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();
					totalAyacutCreated=totalAyacutCreated+ayacutList.get(i).getAyacutCreated();
					totalIrrigatedAyacut=totalIrrigatedAyacut+ayacutList.get(i).getIrriagtedAyacut();
					totalStableayacut=totalStableayacut+ayacutList.get(i).getStableAyacut();
					
					
				}
				
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				mav.addObject("totalAyacutCreated",Math.round(totalAyacutCreated));
				
                 mav.addObject("totalIrrigatedAyacut",Math.round(totalIrrigatedAyacut));
				
				mav.addObject("totalStableayacut",Math.round(totalStableayacut));
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("ayacutList",ayacutList);
		   
			return mav;
			
		}
		
		

		@RequestMapping(value = "/compReport/getVillageByIdAyacutReport")	
		public ModelAndView getVillageByidAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("villageByConstDistMan");
			
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalConstContemplatedAyacut=0.0;
			Double totalConstAyacutCreated=0.0;			
			Double totalConstIrrigatedAyacut=0.0;
			Double totalConstStableayacut=0.0;
			
			
			try {
			
			if(compayacut!=null){
				if(compayacut.getConstId()!=null&& compayacut.getDistrictId()!=null&& compayacut.getMandalId()!=null){
					
					if(compayacut.getConstId()>0&& compayacut.getDistrictId()>0 && compayacut.getMandalId()>0){
			
				constList=crm.getConstDistManVillageByID(compayacut.getConstId(), compayacut.getDistrictId(), compayacut.getMandalId());
					}
				
				}
				
			}
			
				Integer len2=constList.size();
				
					

				for(int i=0; i<len2 ; i++){
					
					
					totalConstContemplatedAyacut=totalConstContemplatedAyacut+constList.get(i).getContemplatedAyacut();
					totalConstAyacutCreated=totalConstAyacutCreated+constList.get(i).getAyacutCreated();
					totalConstIrrigatedAyacut=totalConstIrrigatedAyacut+constList.get(i).getIrriagtedAyacut();
					totalConstStableayacut=totalConstStableayacut+constList.get(i).getStableAyacut();
					
					
				}
				
				mav.addObject("totalConstContemplatedAyacut",Math.round(totalConstContemplatedAyacut));
				
				mav.addObject("totalConstAyacutCreated",Math.round(totalConstAyacutCreated));
				
				mav.addObject("totalConstIrrigatedAyacut",Math.round(totalConstIrrigatedAyacut));
				
				mav.addObject("totalConstStableayacut",Math.round(totalConstStableayacut));
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("constList",constList);
		   
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/getVillageAyacutReport")	
		public ModelAndView getVillageAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("villageAyacutReport");
			List<District> distList =new ArrayList<District>();
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			
			List<Constituency> cons=new ArrayList<Constituency>();
			Double totalConstayacut=0.0;
			Double totalConstStableayacut=0.0;
			Double totalIrrigatedAyacut=0.0;
			Double totalContemplatedAyacut=0.0;
			
			try {
				distList=lam.getDistricts();
			//	distList=crm.getOldDistricts();
				mav.addObject("distList",distList);
				if(compayacut.getDistrictId()!=null){
					if(compayacut.getDistrictId()>0){
					
				constList=crm.getConstDistManVillage(compayacut.getDistrictId());
					}
				}
			
				Integer len2=constList.size();
			
				for(int i=0; i<len2 ; i++){
					
					if(constList.get(i).getDistrictId()!=-3){
					totalConstayacut=totalConstayacut+constList.get(i).getAyacutCreated();
					totalConstStableayacut=totalConstStableayacut+constList.get(i).getStableAyacut();	
					totalIrrigatedAyacut=totalIrrigatedAyacut+constList.get(i).getIrriagtedAyacut();
					totalContemplatedAyacut=totalContemplatedAyacut+constList.get(i).getContemplatedAyacut();		
					}
					
				}
				
				mav.addObject("totalConstayacut",Math.round(totalConstayacut));
				
				mav.addObject("totalConstStableayacut",Math.round(totalConstStableayacut));
				mav.addObject("totalIrrigatedAyacut",Math.round(totalIrrigatedAyacut));
				
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
	
			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LeagalUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("constList",constList);
		   
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/getvillage-byconst-ayacut")	
		public ModelAndView getVillageByconst(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("villageByConst");
			
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			List<District> distList =new ArrayList<District>();
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalConstayacut=0.0;
			Double totalConstStableayacut=0.0;
			Double totalIrrigatedAyacut=0.0;
			Double totalContemplatedAyacut=0.0;
			
			
			try {
				distList=lam.getDistricts();
			//	distList=crm.getOldDistricts();
				mav.addObject("distList",distList);
				
				cons=cam.getConstList();
				
				mav.addObject("constituencies",cons);
			if(compayacut!=null){
				if(compayacut.getConstId()!=null){
					//System.out.println("compayacut.getConstId()"+compayacut.getConstId());
					if(compayacut.getConstId()>0){
			
				constList=crm.getVillageByConst(compayacut.getConstId());
				//System.out.println("constList"+constList);
					}
				}
			}
			
				Integer len2=constList.size();
			//	System.out.println("len: "+len2);
				
				for(int i=0; i<len2 ; i++){
					totalConstayacut=totalConstayacut+constList.get(i).getAyacutCreated();
					totalConstStableayacut=totalConstStableayacut+constList.get(i).getStableAyacut();	
					totalIrrigatedAyacut=totalIrrigatedAyacut+constList.get(i).getIrriagtedAyacut();
					totalContemplatedAyacut=totalContemplatedAyacut+constList.get(i).getContemplatedAyacut();
				}
				
				mav.addObject("totalConstayacut",Math.round(totalConstayacut));
				mav.addObject("totalConstStableayacut",Math.round(totalConstStableayacut));
			    mav.addObject("totalIrrigatedAyacut",Math.round(totalIrrigatedAyacut));
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
	

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (LeagalUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("constList",constList);
		   
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/unit-proj-mandal-ayacut")	
		public ModelAndView getUnitProjMandalAyacut(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("mandalayacutbyunitproj");
			
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			List<Unit> unitList = new ArrayList<Unit>();
			List<Project> prList = new ArrayList<Project>();
			
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalConstayacut=0.0;
			Double totalConstStableayacut=0.0;
			Double totalIrrayacut=0.0;
			Double totalContemplatedAyacut=0.0;
			
			Integer reporttype=0;
			
			
			
			try {
			
			//	unitList = tam.getunitpostList();
			unitList = tam.getprojListNew();
				prList=tam.getprojListbypostgres();
		//		prList=tam.getprojListNew();
			//	System.out.println("prList"+prList);	
			//	System.out.println("unitList"+unitList);
				
				mav.addObject("prList", prList);
				mav.addObject("unitList", unitList);
			if(compayacut!=null){
				if(compayacut.getProjectId()!=null){
					
					if(compayacut.getProjectId()>0){
			
				constList=crm.getMandalbyProj(compayacut.getProjectId());
				
				reporttype=1;
			//	System.out.println("constList"+constList);	
					}
				
				}
				
			}
			
		
			if(compayacut!=null){
				if(compayacut.getUnitId()!=null){
					
				//System.out.println("compayacut.getUnitId()"+compayacut.getUnitId());	
					
					if(compayacut.getUnitId()>0){
			
				constList=crm.getMandalbyUnit(compayacut.getUnitId());
				
				reporttype=2;
				
				//System.out.println("constList"+constList);	
					}
				
				}
				
			}
			
				Integer len2=constList.size();
		
				for(int i=0; i<len2 ; i++){
					
					
					totalConstayacut=totalConstayacut+constList.get(i).getAyacutCreated();
					totalConstStableayacut=totalConstStableayacut+constList.get(i).getStableAyacut();	
					totalIrrayacut=totalIrrayacut+constList.get(i).getIrriagtedAyacut();
					totalContemplatedAyacut=totalContemplatedAyacut+constList.get(i).getContemplatedAyacut();					
					
					
					
				}
				
				mav.addObject("totalConstayacut",Math.round(totalConstayacut));
				
				mav.addObject("totalConstStableayacut",Math.round(totalConstStableayacut));
				
					mav.addObject("totalIrrayacut",Math.round(totalIrrayacut));
				
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				mav.addObject("reporttype",reporttype);
				
				
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TaskUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("constList",constList);
		   
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/getProjSeasonActionPlan")	
		public ModelAndView getProjSeasonActionPlan(@ModelAttribute("projSeasonReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			//System.out.println("compayacut"+compayacut);
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("proj-season-act-plan");
			
			
			
			List<ComponentAyacut>   projseasonList = new ArrayList<ComponentAyacut>();
			List<ComponentAyacut>   constList = new ArrayList<ComponentAyacut>();
			List<Unit> unitList = new ArrayList<Unit>();
			List<Project> prList = new ArrayList<Project>();
			
			
			
			
			
			User user = (User) session.getAttribute("userObj");
			
			
			try {
				
				if (user!=null){
					
					ComponentAyacut compObj= new ComponentAyacut();
							
					compayacut.setUserName(user.getUserName());
					compayacut.setUnitId(user.getUnitId());
					compayacut.setCircleId(user.getCircleId());
							
					compayacut.setDivisionId(user.getDivisionId());
					compayacut.setSubdivisionId(user.getSubdivisionId());
							
						
							
							
						}
			
				
				if(compayacut!=null){
					if(compayacut.getSeasonId()!=null && compayacut.getActplanYear()!=null){
						
						if(compayacut.getSeasonId()==1){
							
							String actYear=compayacut.getActplanYear();
							
							String[] parts = actYear.split("-");
							
							     Integer act1=Integer.parseInt(parts[0])-1 ;
							     
							     //System.out.println("act1"+act1);
							     
                               Integer act2=Integer.parseInt(parts[1])-1 ;
							     
							     //System.out.println("act2"+act2);
							     
							     String actYear2=act1+"-"+act2;
							     
							    // System.out.println("rabi"+actYear2);
							
							     compayacut.setKhrifactplanYear(actYear);
							     
							     compayacut.setRabiactplanYear(actYear2);
						}
						
if(compayacut.getSeasonId()==2){
							
							String actYear=compayacut.getActplanYear();
							
							String actYear2=compayacut.getActplanYear();
							
							     compayacut.setKhrifactplanYear(actYear);
							     
							     compayacut.setRabiactplanYear(actYear2);
						}
						
						
				projseasonList=crm.getReportProjSeasonCap(compayacut);
					}
				
				}


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  
		   mav.addObject("projseasonList",projseasonList);
		   
		   mav.addObject("seasoninfo",compayacut.getSeasonId());
			return mav;
			
		}
		
		@RequestMapping(value = "/compReport/getjurisdiction-ayacut-report")	
		public ModelAndView getJurisdictionAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("jurisdictionAyacutReport");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalContemplatedAyacut=0.0;
			Double totalAyacutCreated=0.0;
			Double totalIrrigatedAyacut=0.0;
			Double totalStableayacut=0.0;
			
			
			try {
			
			
				ayacutList=crm.getAyacutJurisdiction();
				
				
				Integer len2=ayacutList.size();
				
				

				
				

				for(int i=0; i<len2 ; i++){
					if(ayacutList.get(i).getAyacutCreated()!=null){
						
						if(((ayacutList.get(i).getDivisionId()!=-2) )&&( ayacutList.get(i).getCircleId()!=-3 && ayacutList.get(i).getDivisionId()!=-3)){
					
					totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();
					totalAyacutCreated=totalAyacutCreated+ayacutList.get(i).getAyacutCreated();
					totalIrrigatedAyacut=totalIrrigatedAyacut+ayacutList.get(i).getIrriagtedAyacut();
					totalStableayacut=totalStableayacut+ayacutList.get(i).getStableAyacut();
					
						}
					}
				}
				
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				mav.addObject("totalAyacutCreated",Math.round(totalAyacutCreated));
				
                 mav.addObject("totalIrrigatedAyacut",Math.round(totalIrrigatedAyacut));
				
				mav.addObject("totalStableayacut",Math.round(totalStableayacut));
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("ayacutList",ayacutList);
		   
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/getdivision-mandal-ayacut")	
		public ModelAndView getDivisionMandalAyacutReport(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("division-mandal-ayacut");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalContemplatedAyacut=0.0;
			Double totalAyacutCreated=0.0;
			Double totalIrrigatedAyacut=0.0;
			Double totalStableayacut=0.0;
			
			
			try {
			
			
				ayacutList=crm.getAyacutdivisionMandal();
				
				
				Integer len2=ayacutList.size();
				
				

				
				

				for(int i=0; i<len2 ; i++){
					if(ayacutList.get(i).getContemplatedAyacut()!=null){
						
						if(ayacutList.get(i).getUnitId()>0&& ayacutList.get(i).getCircleId()==-3 &&  ayacutList.get(i).getDivisionId()==-3 &&  ayacutList.get(i).getDistrictId()==-3 && ayacutList.get(i).getMandalId()==-3){
					
							//System.out.println("unitId ---- "+ayacutList.get(i).getUnitId());
							//System.out.println("circle ---- "+ayacutList.get(i).getCircleId());
							//System.out.println("division ---- "+ayacutList.get(i).getDivisionId());
							//System.out.println("division ---- "+ayacutList.get(i).getDistrictId());
							//System.out.println("division ---- "+ayacutList.get(i).getMandalId());
							
							
							
					totalContemplatedAyacut=totalContemplatedAyacut+ayacutList.get(i).getContemplatedAyacut();
					totalAyacutCreated=totalAyacutCreated+ayacutList.get(i).getAyacutCreated();
					totalIrrigatedAyacut=totalIrrigatedAyacut+ayacutList.get(i).getIrriagtedAyacut();
					totalStableayacut=totalStableayacut+ayacutList.get(i).getStableAyacut();
					
						}
					}
				}
				
				mav.addObject("totalContemplatedAyacut",Math.round(totalContemplatedAyacut));
				
				mav.addObject("totalAyacutCreated",Math.round(totalAyacutCreated));
				
                 mav.addObject("totalIrrigatedAyacut",Math.round(totalIrrigatedAyacut));
				
				mav.addObject("totalStableayacut",Math.round(totalStableayacut));
				
			


		

			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("ayacutList",ayacutList);
		   
			return mav;
			
		}
		
		
		@RequestMapping(value = "/compReport/gettestdataforpms")	
		public ModelAndView getTestDataForPMS(@ModelAttribute("compAyacutReport") ComponentAyacut compayacut, SessionStatus status,
				HttpSession session) {
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("division-mandal-ayacut");
			
			List<ComponentAyacut>   ayacutList = new ArrayList<ComponentAyacut>();
			
			
			
			
			List<Constituency> cons=new ArrayList<Constituency>();
			
			Double totalContemplatedAyacut=0.0;
			Double totalAyacutCreated=0.0;
			Double totalIrrigatedAyacut=0.0;
			Double totalStableayacut=0.0;
			
			
			try {
			
			
				ayacutList=crm.gettestdataforpms();
				
			
			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    mav.addObject("ayacutList",ayacutList);
		   
			return mav;
			
		}
		
		 // private static final String FILE_DIRECTORY = "E:/Uploads/tsimis/uploadedFiles/AyacutKmls/";
		 
		//private static final String RELATIVE_DIR = "/uploadedFiles/Ayacutkmls/";
		
		private static final String FILE_DIRECTORY = "/app/tomcat8/webapps/tsimis/uploadedFiles/Ayacutkmls/";


		    @GetMapping("/compReport/viewKML")
		    public void serveFile(@RequestParam String fileName, HttpServletResponse response ) throws IOException {
		    	
		    	  System.out.println("Entered viewKML, File Name: "+ fileName);
		    	 // String absolutePath = servletContext.getRealPath(RELATIVE_DIR);
		    	 // Path filePath = Paths.get(absolutePath, fileName);
		    	  Path filePath = Paths.get(FILE_DIRECTORY, fileName);
		    	  File kmlFile = filePath.toFile();

		    	  if (!kmlFile.exists() || !kmlFile.isFile()) {
		                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
		                return;
		            }

		        
		    	  response.setContentType("application/vnd.google-earth.kml+xml");
		            response.setContentLengthLong(kmlFile.length());
		            response.setHeader("Content-Disposition", "attachment; filename=\"" + kmlFile.getName() + "\"");

		            try (InputStream inputStream = new FileInputStream(kmlFile);
		                    OutputStream outputStream = response.getOutputStream()) {

		                   byte[] buffer = new byte[8192]; // 8KB buffer for efficient reading
		                   int bytesRead;
		                   while ((bytesRead = inputStream.read(buffer)) != -1) {
		                       outputStream.write(buffer, 0, bytesRead);
		                   }
		                   outputStream.flush();

		               } catch (IOException e) {
		                   System.err.println("Error serving KML file: " + e.getMessage());
		                   e.printStackTrace();

		                   try {
		                       response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing KML file");
		                   } catch (IOException ioException) {
		                       System.err.println("Error sending 500 response: " + ioException.getMessage());
		                   }
		               }
		    }
		
		
		
}
