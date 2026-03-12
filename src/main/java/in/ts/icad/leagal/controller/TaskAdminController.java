package in.ts.icad.leagal.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.exception.TaskUserException;

import in.ts.icad.leagal.manager.TaskAdminManager;
import in.ts.icad.leagal.manager.TaskReportManager;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Designation;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Employee;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Task;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.TaskPriority;
import in.ts.icad.leagal.model.TaskResponsibleEmp;
import in.ts.icad.leagal.model.TaskStatus;
import in.ts.icad.leagal.model.TaskType;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;

@Controller
@SessionAttributes({ "usersList", "userObj" })
public class TaskAdminController {
	
	
	@Autowired
	private  TaskAdminManager taskAdminManager;
	
	@Autowired
	private  TaskReportManager   taskReportManager;
	
	
	

	@RequestMapping(value = "/task/taskinput")
	@ResponseBody
	public ModelAndView Taskinput(@ModelAttribute("taskinput") Task taskObject,SessionStatus status, HttpSession session)  {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("taskinput");
		
		List<Unit> unitList = new ArrayList<Unit>();
		List<TaskType> ttList = new ArrayList<TaskType>();
		List<TaskPriority> tpList = new ArrayList<TaskPriority>();
		List<TaskStatus> tsList = new ArrayList<TaskStatus>();
		List<TaskResponsibleEmp> treList = new ArrayList<TaskResponsibleEmp>();
		List<Task> tList = new ArrayList<Task>();
		
		List<TaskResponsibleEmp> resSeList = new ArrayList<TaskResponsibleEmp>();
		List<TaskResponsibleEmp> resEeList = new ArrayList<TaskResponsibleEmp>();
		List<TaskResponsibleEmp> resDeeList = new ArrayList<TaskResponsibleEmp>();
		List<TaskResponsibleEmp> resAeeList = new ArrayList<TaskResponsibleEmp>();
		List<Task> newtList = new ArrayList<Task>();
		
		Integer returnval=0;
		
		String msg=null;
		
		String err=null;
		
		Integer unitId=0;
		Integer circleId=0;
		Integer divisionId=0;
		Integer subdivisionid=0;
		
		User user = (User) session.getAttribute("userObj");
		
		//System.out.println("user"+user.getUnitId()+user.getUnitName());
		
		if(user!=null){
			
			//System.out.println("in task user"+user.getUnitId()+"--"+user.getCircleId()+" -- "+user.getDivisionId()+"--"+user.getSubdivisionId());
		
		 try {
			 
				
				
			unitList=taskAdminManager.getUnitList();
			ttList=taskAdminManager.getTaskTypeList();
			tpList=taskAdminManager.getTaskPriorityList();
			tsList=taskAdminManager.getTaskStatusList();
			treList=taskAdminManager.getTaskResponsibleList();
			
			
			
			//System.out.println("treList intry"+treList);
			
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
			 if(user.getUnitId()>0 && user.getCircleId()==0 && user.getDivisionId()==0 && user.getDivisionId()==0 ){
			 mav.addObject("selectedunit",user.getUnitId()); 
			
			
			
			for( int i=0; i<treList.size(); i++){
				
				if( treList.get(i).getUnitId()==user.getUnitId()&& treList.get(i).getCircleId()==0 && treList.get(i).getDivisionId()==0 && treList.get(i).getSubdivisionId()==0 ){
				if((treList.get(i).getDesignationId()==7 ) ){
				TaskResponsibleEmp empobj= new TaskResponsibleEmp();
				
				empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
				empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
				
				resSeList.add(empobj);
				}
				if((treList.get(i).getDesignationId()==5 ) ){
					TaskResponsibleEmp empobj= new TaskResponsibleEmp();
					
					empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
					empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
					
					resEeList.add(empobj);
					}
				
				if((treList.get(i).getDesignationId()==4 ) ){
					TaskResponsibleEmp empobj= new TaskResponsibleEmp();
					
					empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
					empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
					
					resDeeList.add(empobj);
					}
				if((treList.get(i).getDesignationId()==2) || (treList.get(i).getDesignationId()==8 ) ){
					TaskResponsibleEmp empobj= new TaskResponsibleEmp();
					
					empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
					empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
					
					resAeeList.add(empobj);
					}
				
				}
				
				
			}
			
			 mav.addObject("resSeList",resSeList);
			 mav.addObject("resEeList",resEeList);
			 mav.addObject("resDeeList",resDeeList);
			 mav.addObject("resAeeList",resAeeList);
			 
		 }
		 
			 if(user.getUnitId()>0  && user.getCircleId()>0 && user.getDivisionId()==0 && user.getDivisionId()==0 ){
				 mav.addObject("selectedunit",user.getUnitId()); 
			     mav.addObject("selectedcircle",user.getCircleId()); 
			     
			     for( int i=0; i<treList.size(); i++){
						
						if( treList.get(i).getUnitId()==user.getUnitId()&& treList.get(i).getCircleId()==user.getCircleId() && treList.get(i).getDivisionId()==0 && treList.get(i).getSubdivisionId()==0 ){
						if((treList.get(i).getDesignationId()==7 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resSeList.add(empobj);
						}
						if((treList.get(i).getDesignationId()==5 ) ){
							TaskResponsibleEmp empobj= new TaskResponsibleEmp();
							
							empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
							empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
							
							resEeList.add(empobj);
							}
						
						if((treList.get(i).getDesignationId()==4 ) ){
							TaskResponsibleEmp empobj= new TaskResponsibleEmp();
							
							empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
							empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
							
							resDeeList.add(empobj);
							}
						if((treList.get(i).getDesignationId()==2) || (treList.get(i).getDesignationId()==8 ) ){
							TaskResponsibleEmp empobj= new TaskResponsibleEmp();
							
							empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
							empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
							
							resAeeList.add(empobj);
							}
						
						}
						
						
					}
					
					 mav.addObject("resSeList",resSeList);
					 mav.addObject("resEeList",resEeList);
					 mav.addObject("resDeeList",resDeeList);
					 mav.addObject("resAeeList",resAeeList);
			
			 
		 }
		
			 if(user.getUnitId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getSubdivisionId()==0 ){
				 
				// System.out.println(user.getUnitId()+"unit"+user.getCircleId()+"div"+user.getDivisionId());
				 mav.addObject("selectedunit",user.getUnitId()); 
				 mav.addObject("selectedcircle",user.getCircleId()); 
			 mav.addObject("selecteddivision",user.getDivisionId()); 
			 
			 for( int i=0; i<treList.size(); i++){
					
					if( treList.get(i).getUnitId()==user.getUnitId()&& treList.get(i).getCircleId()==user.getCircleId() && treList.get(i).getDivisionId()==user.getDivisionId() && treList.get(i).getSubdivisionId()==0 ){
					if((treList.get(i).getDesignationId()==7 ) ){
					TaskResponsibleEmp empobj= new TaskResponsibleEmp();
					
					empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
					empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
					
					resSeList.add(empobj);
					}
					if((treList.get(i).getDesignationId()==5 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resEeList.add(empobj);
						}
					
					if((treList.get(i).getDesignationId()==4 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resDeeList.add(empobj);
						}
					if((treList.get(i).getDesignationId()==2) || (treList.get(i).getDesignationId()==8 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resAeeList.add(empobj);
						}
					
					}
					
					
				}
				
				 mav.addObject("resSeList",resSeList);
				 mav.addObject("resEeList",resEeList);
				 mav.addObject("resDeeList",resDeeList);
				 mav.addObject("resAeeList",resAeeList);
			 
			 
			 }
			 
			 
		
			 if(user.getSubdivisionId()>0 && user.getCircleId()>0 && user.getDivisionId()>0 && user.getUnitId()>0 ){
				 mav.addObject("selectedunit",user.getUnitId()); 
				 mav.addObject("selectedcircle",user.getCircleId()); 
			 mav.addObject("selecteddivision",user.getDivisionId()); 
				 
			 mav.addObject("selectedsubdivision",user.getSubdivisionId()); 
			 
			 for( int i=0; i<treList.size(); i++){
					
					if( treList.get(i).getUnitId()==user.getUnitId()&& treList.get(i).getCircleId()==user.getCircleId() && treList.get(i).getDivisionId()==user.getDivisionId() && treList.get(i).getSubdivisionId()==user.getSubdivisionId() ){
					if((treList.get(i).getDesignationId()==7 ) ){
					TaskResponsibleEmp empobj= new TaskResponsibleEmp();
					
					empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
					empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
					
					resSeList.add(empobj);
					}
					if((treList.get(i).getDesignationId()==5 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resEeList.add(empobj);
						}
					
					if((treList.get(i).getDesignationId()==4 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resDeeList.add(empobj);
						}
					if((treList.get(i).getDesignationId()==2) || (treList.get(i).getDesignationId()==8 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resAeeList.add(empobj);
						}
					
					}
					
					
				}
				
				 mav.addObject("resSeList",resSeList);
				 mav.addObject("resEeList",resEeList);
				 mav.addObject("resDeeList",resDeeList);
				 mav.addObject("resAeeList",resAeeList);
			 }
			 
			 
		
		 
		 if(user.getUnitId()==null && user.getCircleId()==null && user.getDivisionId()==null && user.getSubdivisionId()==null ){
			
			
			
			 
			 
		 }
		
		 mav.addObject("unitList",unitList);
		 mav.addObject("ttList",ttList);
		 mav.addObject("tpList",tpList);
		 mav.addObject("tsList",tsList);
		 mav.addObject("treList",treList);
		// System.out.println("roleid"+user.getRoleId());
		 
		 

			if(taskObject!=null && taskObject.getSubject()!=null && taskObject.getStatusId()>0 &&  taskObject.getTaskTypeId()>0 && taskObject.getPriorId()>0   ){
				
				
				List<MultipartFile> files = taskObject.getUpfile();

				List<String> fileNames = new ArrayList<String>();
				
				List<TaskFiles> fileList=new ArrayList<TaskFiles>();
			 
				if(user.getRoleId()==1){
					
					//set reamrks and se/empids 
					
					taskObject.setUnitRemarks(taskObject.getRemarks());
					taskObject.setCircleRemarks("NA");
					  taskObject.setDivisionRemarks("NA");
					  taskObject.setSubdivisionRemarks("NA");
						
					  taskObject.setAeeRemarks("NA");
					
					
					
				}
				
              if(   user.getRoleId()==2){
					
					//set reamrks and se/eempid
            	  taskObject.setCircleRemarks(taskObject.getRemarks());
            	  taskObject.setUnitRemarks("NA");
				  taskObject.setDivisionRemarks("NA");
				  taskObject.setSubdivisionRemarks("NA");
					
				  taskObject.setAeeRemarks("NA");
					
            	  
            	
					
				}
			
              
              if(user.getRoleId()==3){
					
					
            	  taskObject.setDivisionRemarks(taskObject.getRemarks());
            	  taskObject.setCircleRemarks("NA");
				  taskObject.setUnitRemarks("NA");
				  taskObject.setSubdivisionRemarks("NA");
					
				  taskObject.setAeeRemarks("NA");
					
					
				}
			
              
              if(user.getRoleId()==4){
					
					//setreamrks/empids
            	  taskObject.setSubdivisionRemarks(taskObject.getRemarks());
            	  taskObject.setCircleRemarks("NA");
				  taskObject.setDivisionRemarks("NA");
				  taskObject.setUnitRemarks("NA");
					
				  taskObject.setAeeRemarks("NA");
					
				}
			
              
              if(user.getRoleId()==-1){
					
					//setremarks/empids
					
					
				}
			
			
				
				try  {
					//taskObject.setUseroracle("admin");
					taskObject.setUserpost(user.getUserId().toString());
					 String filetitile=null;
					 String  filetitilenew=null;
					//System.out.println("filesize"+files.size()+"--"+files);
					if(null != files && files.size() > 1) {
						for (MultipartFile multipartFile : files) {

							String fileName = multipartFile.getOriginalFilename();
							//String FileType = ( files).get(0).getContentType();
							fileNames.add(fileName);
							//Handle file content - multipartFile.getInputStream()

						}
					
					 
					 
					//System.out.println("2nd file size"+fileNames.size());
					 
					
					 for(int i=0; i<fileNames.size();i++){
						 filetitile=fileNames.get(i);
						 
						 if (i==0){
						 filetitilenew=filetitile;
						 }
						 
						 if(i>0){
							 
							 filetitilenew=filetitile+"@"+filetitilenew;
							 
						 }
						 
						// System.out.println("filetitilenew"+filetitilenew);
						 
						 
					 }
					 
					// System.out.println("filetitilenew"+filetitilenew);
					 String rootPath = System.getProperty("catalina.base");
					 File dir = new File(rootPath + File.separator + "webapps"
								+ File.separator + "ICADLeagalWebApp" + File.separator
								+ "uploadedFiles"+File.separator+"TaskManagement");
					 
					 if (!dir.exists())
							dir.mkdirs();
					 
					 
					 taskObject.setFilelocation(dir.getAbsolutePath()+ File.separator
								+ filetitilenew);
					 
						
					 taskObject.setAllfilenames(filetitilenew);
					 
						
						
						try {
							
							for(int i=0; i<files.size(); i++){
								
								//File serverFile = new File(dir.getAbsolutePath()+ File.separator + files.get(i).getOriginalFilename());
								
								// System.out.println("serverFile"+serverFile);
								TaskFiles tf =new TaskFiles();
								
								
								tf.setFileName(files.get(i).getOriginalFilename());
								tf.setFileLocation(dir.getAbsolutePath()+ File.separator + files.get(i).getOriginalFilename());
								tf.setUserId(user.getUserId().toString());
								tf.setDesignationId(user.getDesignationId());
								
								fileList.add(tf);
								
							files.get(i).transferTo( new File(dir.getAbsolutePath()
									+ File.separator + files.get(i).getOriginalFilename()));
							}
							} catch (IllegalStateException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
					    if(fileList.size()>0){
					    	taskObject.setFiledataList(fileList);
					    	
					    	
					    }
				
					}	
					         // System.out.println("taskObject"+taskObject.getFiledataList().size());
					
						
						

						
						

						
					 returnval=taskAdminManager.insertTasks(taskObject);
						
						
						
					//	System.out.println("returnval"+returnval);
						
						
						
						if(returnval>0){				 
							msg="Task added Successfully";
					       mav.addObject("msg",msg);	
			               
						
								
						}else{
							err="Failure to add Task";
							mav.addObject("err",err);
							
						}
						// System.out.println("listpet"+listpet.get(0)+" i am here"+listpet.get(1));
						
						 

						
							
					
					
					
					
						
				
				 
				
				} catch (TaskUserException e) {
					// TODO Auto-generated catch block
					err="caught in Task user exception";
					mav.addObject("err",err);
					e.printStackTrace();
				}
				 catch (SQLException | ParseException e) {
					// TODO Auto-generated catch block
					err="caught in exception";
					mav.addObject("err", err);
					e.printStackTrace();
				}
				
				 
				// System.out.println("returnval1"+returnval1);
				 
				 
					 
				 }
		}
				 
				 
			
		
		return mav;
	}
	
	
	@RequestMapping(value = "/task/addFileType")
	@ResponseBody
	public ModelAndView AyacutComponenet(SessionStatus status, HttpSession session)  {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addFileType");
	
		
		
		return mav;
	}
	
	
	@RequestMapping(value = "/task/taskreport1")
	@ResponseBody
	public ModelAndView taskreport1(SessionStatus status, HttpSession session)  {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("taskreport1");
	
		
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/task/addEmp")
	@ResponseBody
	public ModelAndView taskAddEmp(SessionStatus status, HttpSession session)  {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addEmp");
	
		
		
		return mav;
	}
	
	@RequestMapping(value = "/task/getProjects")
	@ResponseBody
	public String getProjects(Integer unitId, SessionStatus status,
			HttpServletRequest request) throws TaskUserException {
		
		
		List<Project> projectList= new ArrayList<Project>();
		try {
			projectList = taskAdminManager.getProjectList(unitId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return new Gson().toJson(projectList);
		
	}
	
	@RequestMapping(value = "/task/getPackages")
	@ResponseBody
	public String getPackages(Integer projectId, SessionStatus status,
			HttpServletRequest request) throws TaskUserException {
		
	
		List<Packages> packagesList = new ArrayList<Packages>();
		try {
			packagesList = taskAdminManager.getPackageList(projectId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return new Gson().toJson(packagesList);
		
	}
	
	@RequestMapping(value = "/task/getCircles")
	@ResponseBody
	public String getCircles(Integer unitId,HttpSession session, HttpServletRequest req)
			throws TaskUserException {
		

		
		List<Circle> circles = new ArrayList<Circle>();
		try {
			circles = taskAdminManager.getCircleList(unitId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("circles"+circles);
		return new Gson().toJson(circles);
		
	}
	
	@RequestMapping(value = "/task/getDivisions")
	@ResponseBody
	public String getDivisions(Integer circleId,HttpSession session, HttpServletRequest req)
			throws TaskUserException {
		

		
		List<Division> divisions= new ArrayList<Division>();
		try {
			divisions = taskAdminManager.getDivisionList(circleId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(divisions);
		
	}
	
	@RequestMapping(value = "/task/getSubDivisions")
	@ResponseBody
	public String getSubDivisions(Integer divisionId,HttpSession session, HttpServletRequest req)
			throws TaskUserException {
		

		
		List<Subdivision> subdivisions = new ArrayList<Subdivision>();
		try {
			subdivisions = taskAdminManager.getSubDivisionList(divisionId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(subdivisions);
		
	}
	
	
	@RequestMapping(value = "/task/getSEList")
	@ResponseBody
	public String getSElist(Integer circleId,HttpSession session, HttpServletRequest req)
			throws TaskUserException {
		

		
		List<TaskResponsibleEmp> se = new ArrayList<TaskResponsibleEmp>();
		try {
			se = taskAdminManager.getSEList(circleId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(se);
		
	}
	@RequestMapping(value = "/task/getEEList")
	@ResponseBody
	public String getEElist(Integer divisionId,HttpSession session, HttpServletRequest req)
			throws TaskUserException {
		

		
		List<TaskResponsibleEmp> ee = new ArrayList<TaskResponsibleEmp>();
		try {
			ee = taskAdminManager.getEEList(divisionId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(ee);
		
	}
	@RequestMapping(value = "/task/getDEEList")
	@ResponseBody
	public String getDEElist(Integer subdivisionId,HttpSession session, HttpServletRequest req)
			throws TaskUserException {
		

		
		List<TaskResponsibleEmp> dee = new ArrayList<TaskResponsibleEmp>();
		try {
			dee = taskAdminManager.getDEEList(subdivisionId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(dee);
		
	}
	@RequestMapping(value = "/task/getAEEList")
	@ResponseBody
	public String getAEElist(Integer subdivisionId,HttpSession session, HttpServletRequest req)
			throws TaskUserException {
		

		
		List<TaskResponsibleEmp> aee = new ArrayList<TaskResponsibleEmp>();
		try {
			aee= taskAdminManager.getAEEList(subdivisionId);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(aee);
		
	}
	
	@RequestMapping(value = "/task/deleteTask")
	@ResponseBody
	public ModelAndView deleteTask(@ModelAttribute("deleteTask") Task deletedata,SessionStatus status, HttpSession session)  {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteTask");
	
		
		List<Unit> unitList = new ArrayList<Unit>();
		List<Circle> circleList = new ArrayList<Circle>();
		List<Division> divisionList = new ArrayList<Division>();
		List<Subdivision> subdivisionList = new ArrayList<Subdivision>();
		
		List<Task> taskAllList = new ArrayList<Task>();
		List<TaskFiles> taskFilesList = new ArrayList<TaskFiles>();
		
		List<TaskType> taskTypeList = new ArrayList<TaskType>();
		
		User user = (User) session.getAttribute("userObj");
		
		List<Unit> unitData = new ArrayList<Unit>();
		List<Circle> circleData = new ArrayList<Circle>();
		List<Division> divisionData = new ArrayList<Division>();
		List<Subdivision> subdivisionData = new ArrayList<Subdivision>();
		
		
		Integer unitId=0;
		Integer circleId=0;
		Integer divisionId=0;
		Integer subdivisionId=0;
		Integer typeId=0;
		
		if(user!=null){
		
				 
		
		try {
			unitList=taskAdminManager.getunitpostList();
			
			for(int i=0; i<unitList.size(); i++){
				if(user.getUnitId()==unitList.get(i).getUnitId()){
					
					Unit u = new Unit();
					
					u.setUnitId(unitList.get(i).getUnitId());
					u.setUnitName(unitList.get(i).getUnitName());
					
					unitData.add(u);
					
					
					
				}
				
				
			}
			//System.out.println("unit size"+unitData.size());
			mav.addObject("unitData",unitData);
			circleList=taskAdminManager.getcirclepostList();
			
			for(int i=0; i<circleList.size(); i++){
				
				
					
					
					if(user.getCircleId()==0){
				
					
					Circle c = new Circle();
					
					c.setCircleId(circleList.get(i).getCircleId());
					c.setCircleName(circleList.get(i).getCircleName());
					
					c.setUnitId(circleList.get(i).getUnitId());
					
					circleData.add(c);
					
					
				
					}
					
					if(user.getCircleId()!=0){
				if(user.getCircleId()==circleList.get(i).getCircleId()){
					
					Circle c = new Circle();
					
					c.setCircleId(circleList.get(i).getCircleId());
					c.setCircleName(circleList.get(i).getCircleName());
					c.setUnitId(circleList.get(i).getUnitId());
					
					circleData.add(c);
					
					
				}
					}
				
				
			}
			
			
			mav.addObject("circleData",circleData);
			divisionList=taskAdminManager.getdivisionpostList();
			
			for(int i=0; i<divisionList.size(); i++){
				if(user.getDivisionId()==0){
					
					Division d = new Division();
					
					d.setDivisionId(divisionList.get(i).getDivisionId());
					d.setDivisionName(divisionList.get(i).getDivisionName());
					d.setCircleId(divisionList.get(i).getCircleId());
					
					divisionData.add(d);
					
					
					
				}
				
            if(user.getDivisionId()!=0){
	
	if(user.getDivisionId()==divisionList.get(i).getDivisionId()){
					
					Division d = new Division();
					
					d.setDivisionId(divisionList.get(i).getDivisionId());
					d.setDivisionName(divisionList.get(i).getDivisionName());
					d.setCircleId(divisionList.get(i).getCircleId());
					
					divisionData.add(d);
					
	             }		
					
				}
				
				
			}
			
			mav.addObject("divisionData",divisionData);
			subdivisionList=taskAdminManager.getsubdivisionpostList();
			
			for(int i=0; i<subdivisionList.size(); i++){
				if(user.getSubdivisionId()==0){
					
					Subdivision sd = new Subdivision();
					
					sd.setSubdivisionId(subdivisionList.get(i).getSubdivisionId());
					sd.setSubdivisionName(subdivisionList.get(i).getSubdivisionName());
					sd.setDivisionId(subdivisionList.get(i).getDivisionId());
					
					subdivisionData.add(sd);
					
					
				}
				
if(user.getSubdivisionId()!=0){
	
	if(user.getSubdivisionId()==subdivisionList.get(i).getSubdivisionId()){
					
					Subdivision sd = new Subdivision();
					
					sd.setSubdivisionId(subdivisionList.get(i).getSubdivisionId());
					sd.setSubdivisionName(subdivisionList.get(i).getSubdivisionName());
					sd.setDivisionId(subdivisionList.get(i).getDivisionId());
					
					subdivisionData.add(sd);
					
					
				}
				
}	
			}
			
			mav.addObject("subdivisionData",subdivisionData);
			
			
			taskFilesList=taskReportManager.getFilesTasks();
			taskTypeList=taskReportManager.getTaskTypes();
			

			//System.out.println("unitIdfirst"+unitId);
			//System.out.println("circleId"+circleId);
			//System.out.println("divisionId"+divisionId);
			//System.out.println("subdivisionId"+subdivisionId);
			
			//System.out.println("typeId"+typeId);
			
			/*if(unitId==null && (typeId==null || typeId==-1 )){
				
				//System.out.println("not coming here");
			taskAllList=taskReportManager.getAllTasks();
			typeId=-1;
			
			}*/
			
			
			unitId=user.getUnitId();
			circleId=user.getCircleId();
			
			divisionId=user.getDivisionId();
			subdivisionId=user.getSubdivisionId();
			
			//System.out.println("unitId"+unitId);
			
			//System.out.println("circleId"+circleId);
			//System.out.println("divisionId"+divisionId);
			//System.out.println("subdivisionId"+subdivisionId);
			
			//System.out.println("deletedata"+deletedata);
			
			if(deletedata.getUnitId()!=null){
				
				if(deletedata.getUnitId()>0){
				unitId=deletedata.getUnitId();
				circleId=deletedata.getCircleId();
				divisionId=deletedata.getDivisionId();
				subdivisionId=deletedata.getSubdivisionId();
				typeId=deletedata.getTaskTypeId();
				
				if(deletedata.getCircleId()==null){
					
					circleId=0;
					
				}
if(deletedata.getDivisionId()==null){
					
					divisionId=0;
					
				}


if(deletedata.getSubdivisionId()==null){
	
	subdivisionId=0;
	
}
				
				
				}
			}
			
//System.out.println("unitId"+unitId);
			
			//System.out.println("circleId"+circleId);
			//System.out.println("divisionId"+divisionId);
			//System.out.println("subdivisionId"+subdivisionId);
			if(unitId!=null && (typeId==null|| typeId==-1 || typeId==0  )){
				
			
				
				if(unitId>0){
					
				
				
				taskAllList=taskReportManager.getAllTasksbyunit(unitId, circleId, divisionId, subdivisionId);
				typeId=-1;
				}
				
			}
			
             if(unitId!=null && typeId!=null){
				
				if(unitId>0 && typeId>0 ){
					
					//System.out.println("coming here");
				
				taskAllList=taskReportManager.getAllTasksbyUnitbyType(unitId, circleId, divisionId, subdivisionId, typeId);
				}
				
			}
			
			
			
			
			//System.out.println("unitId"+unitId);
			//System.out.println("circleId"+circleId);
			//System.out.println("divisionId"+divisionId);
			//System.out.println("subdivisionId"+subdivisionId);
			
			
			
			
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String displaytype=null;
		  String displayunit=null;
		  String displayvalue=null;
		  
		  for(int i=0; i<taskTypeList.size(); i++){
			  
			  if(typeId==taskTypeList.get(i).getTaskTypeId()){
			  
			  displaytype=taskTypeList.get(i).getTaskTypeName();
			  
			  }
			  
		  }
		if(typeId==-1)
		{  displaytype="All" ;}; 
		
        if(unitId==null && circleId==null && divisionId==null && subdivisionId==null){
			
			
						
						displayvalue="All";
				
				displayunit="Unit/ Circle/ Division/ Subdivision";
				
		
			
			
		}
		
		
		if(unitId!=null && circleId==0 && divisionId==0 && subdivisionId==0){
			
			if(unitId>0){
				
				for(int i=0; i<unitList.size();i++){
					
					if(unitId==unitList.get(i).getUnitId()){
						
						displayvalue=unitList.get(i).getUnitName();
					}
					
				}
				
				displayunit="Unit";
				
			}
			
			
		}
		
if(unitId!=null && circleId!=null && divisionId==0 && subdivisionId==0){
			
			if(unitId>0 &&circleId>0 ){
				
				for(int i=0; i<circleList.size();i++){
					
					if(circleId==circleList.get(i).getCircleId()){
						
						displayvalue=circleList.get(i).getCircleName();
					}
					
				}
				
				displayunit="Circle";
				
			}
			
			
		}

if(unitId!=null && circleId!=null && divisionId!=null && subdivisionId==0){
	
	if(unitId>0 && circleId>0 && divisionId>0  ){
		
		for(int i=0; i<divisionList.size();i++){
			
			if(divisionId==divisionList.get(i).getDivisionId()){
				
				displayvalue=divisionList.get(i).getDivisionName();
			}
			
		}
		
		displayunit="Division";
		
	}
	
	
}

if(unitId!=null && circleId!=null && divisionId!=null && subdivisionId!=null){
	
	if(unitId>0 && circleId>0 &&  divisionId>0 && subdivisionId>0  ){
		
		for(int i=0; i<subdivisionList.size();i++){
			
			if(subdivisionId==subdivisionList.get(i).getSubdivisionId()){
				
				displayvalue=subdivisionList.get(i).getSubdivisionName();
			}
			
		}
		
		displayunit="Subdivision";
		
	}
	
	
}
		

Integer deleterows=0;
if(deletedata.getDeleteFlag()!=null){
if(deletedata.getDeleteFlag()){
	
	try {
		deleterows=taskAdminManager.deleteTask(deletedata.getTaskId());
		
		if(deleterows>0){
			
			
			mav.addObject("msg","Successfully deleted");
			
			
		}
		
if(deleterows==0){
			
			
			mav.addObject("err"," Failed to delete");
			
			
		}
		
		
	} catch (TaskUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}}
		
		
		
		 mav.addObject("taskAllList",taskAllList);
		 mav.addObject("taskFilesList",taskFilesList);
		 mav.addObject("taskTypeList",taskTypeList);
		 mav.addObject("selectedTask",typeId);
		 mav.addObject("displaytype",displaytype);
		 mav.addObject("displayvalue",displayvalue);
		 mav.addObject("displayunit",displayunit);
		 mav.addObject("userObj",user);
		
		
	
		}
		
		return mav;
		
		
		
	}
	
	@RequestMapping(value = "/task/editTask")
	@ResponseBody
	public ModelAndView EditTask(@ModelAttribute("taskinput") Task taskObject,SessionStatus status, HttpSession session)  {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editTask");
		
		List<Task> tList= new ArrayList<Task>();
		
	
		try {
			tList= taskAdminManager.getTaskList();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Unit> unitList = new ArrayList<Unit>();
		List<TaskType> ttList = new ArrayList<TaskType>();
		List<TaskPriority> tpList = new ArrayList<TaskPriority>();
		List<TaskStatus> tsList = new ArrayList<TaskStatus>();
		List<TaskResponsibleEmp> treList = new ArrayList<TaskResponsibleEmp>();
		
		List<TaskResponsibleEmp> resSeList = new ArrayList<TaskResponsibleEmp>();
		List<TaskResponsibleEmp> resEeList = new ArrayList<TaskResponsibleEmp>();
		List<TaskResponsibleEmp> resDeeList = new ArrayList<TaskResponsibleEmp>();
		List<TaskResponsibleEmp> resAeeList = new ArrayList<TaskResponsibleEmp>();
		List<Task> newtList = new ArrayList<Task>();
		
		Task taskoutput= new Task();
		
		Integer returnval=0;
		
		String msg=null;
		
		String err=null;
		
		Integer unitId=0;
		Integer circleId=0;
		Integer divisionId=0;
		Integer subdivisionid=0;
		
		User user = (User) session.getAttribute("userObj");
		
		
		
		//System.out.println("user"+user.getUnitId()+user.getUnitName());
		
		if(user!=null){
			
			//System.out.println("in task user"+user.getUnitId()+"--"+user.getCircleId()+" -- "+user.getDivisionId()+"--"+user.getSubdivisionId());
		
		 try {
			  if(taskObject.getTaskId()!=null){
			 taskoutput= taskAdminManager.getTaskObject(taskObject.getTaskId());
			  }
				
			unitList=taskAdminManager.getUnitList();
			ttList=taskAdminManager.getTaskTypeList();
			tpList=taskAdminManager.getTaskPriorityList();
			tsList=taskAdminManager.getTaskStatusList();
			treList=taskAdminManager.getTaskResponsibleList();
			
			
			
			//System.out.println("treList intry"+treList);
			
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		 if(taskoutput!=null){
				
				String Subject=taskoutput.getSubject();
				String assignDate= taskoutput.getAssignedDate();
				String targetDate=taskoutput.getTargetDate();
				Integer officeType=taskoutput.getOfficeType();
				Integer priority=taskoutput.getPriorId();
				Integer statusId=taskoutput.getStatusId();
				Integer  tasktypeId=taskoutput.getTaskTypeId();
				
				//System.out.println("assignDate"+targetDate+"Subject"+Subject+"targetDate"+targetDate);
				
				mav.addObject("Subject",Subject);
				mav.addObject("assignDate",assignDate);
				mav.addObject("targetDate",targetDate);
				mav.addObject("taskId",taskoutput.getTaskId());
				mav.addObject("officeType",officeType);
				mav.addObject("priority",priority);
				mav.addObject("statusId",statusId);
				mav.addObject("tasktypeId",tasktypeId);
				
				if(!taskoutput.getUnitRemarks().equals("NA")){
				 String remarks= taskoutput.getUnitRemarks();
				 
                  //System.out.println("remarksce"+remarks);
				 
				 
				 mav.addObject("Remarks",remarks);
				}
				if(!taskoutput.getCircleRemarks().equals("NA")){
					 String remarks= taskoutput.getUnitRemarks();
					 
	                 // System.out.println("remarksse"+remarks);
					 
					 
					 mav.addObject("Remarks",remarks);
					}
				if(!taskoutput.getDivisionRemarks().equals("NA")){
					 String remarks= taskoutput.getCircleRemarks();
					 
	                //  System.out.println("remarksee"+remarks);
					 
					 
					 mav.addObject("Remarks",remarks);
					}
				if(!taskoutput.getSubdivisionRemarks().equals("NA")){
					 String remarks= taskoutput.getDivisionRemarks();
					 
	              //    System.out.println("remarksdee"+remarks);
					 
					 
					 mav.addObject("Remarks",remarks);
					}
				
				
			
		         //  System.out.println("taskoutput"+taskoutput.getUnitId()+"---"+taskoutput.getCircleId()+"---"+taskoutput.getDivisionId()+"--"+taskoutput.getSubdivisionId());
			 if(taskoutput.getUnitId()!=null && taskoutput.getCircleId()==null && taskoutput.getDivisionId()==null && taskoutput.getSubdivisionId()==null ){
				 
				
				  
				 
			 mav.addObject("selectedunit",taskoutput.getUnitId()); 
			 
			
			 
			
			 
			 
			
			
		
			for( int i=0; i<treList.size(); i++){
				
				if( treList.get(i).getUnitId()==taskoutput.getUnitId()&& treList.get(i).getCircleId()==0 && treList.get(i).getDivisionId()==0 && treList.get(i).getSubdivisionId()==0 ){
				if((treList.get(i).getDesignationId()==7 ) ){
				TaskResponsibleEmp empobj= new TaskResponsibleEmp();
				
				empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
				empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
				
				resSeList.add(empobj);
				}
				if((treList.get(i).getDesignationId()==5 ) ){
					TaskResponsibleEmp empobj= new TaskResponsibleEmp();
					
					empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
					empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
					
					resEeList.add(empobj);
					}
				
				if((treList.get(i).getDesignationId()==4 ) ){
					TaskResponsibleEmp empobj= new TaskResponsibleEmp();
					
					empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
					empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
					
					resDeeList.add(empobj);
					}
				if((treList.get(i).getDesignationId()==2) || (treList.get(i).getDesignationId()==8 ) ){
					TaskResponsibleEmp empobj= new TaskResponsibleEmp();
					
					empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
					empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
					
					resAeeList.add(empobj);
					}
				
				}
				
				
			}
			
			 mav.addObject("resSeList",resSeList);
			 mav.addObject("resEeList",resEeList);
			 mav.addObject("resDeeList",resDeeList);
			 mav.addObject("resAeeList",resAeeList);
			 
		 }
		 
			 if(taskoutput.getCircleId()!=null  && taskoutput.getCircleId()!=null && taskoutput.getDivisionId()==null && taskoutput.getDivisionId()==null ){
				 mav.addObject("selectedunit",user.getUnitId()); 
			     mav.addObject("selectedcircle",user.getCircleId()); 
			    
			     for( int i=0; i<treList.size(); i++){
						
						if( treList.get(i).getUnitId()==taskoutput.getUnitId()&& treList.get(i).getCircleId()==user.getCircleId() && treList.get(i).getDivisionId()==0 && treList.get(i).getSubdivisionId()==0 ){
						if((treList.get(i).getDesignationId()==7 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resSeList.add(empobj);
						}
						if((treList.get(i).getDesignationId()==5 ) ){
							TaskResponsibleEmp empobj= new TaskResponsibleEmp();
							
							empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
							empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
							
							resEeList.add(empobj);
							}
						
						if((treList.get(i).getDesignationId()==4 ) ){
							TaskResponsibleEmp empobj= new TaskResponsibleEmp();
							
							empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
							empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
							
							resDeeList.add(empobj);
							}
						if((treList.get(i).getDesignationId()==2) || (treList.get(i).getDesignationId()==8 ) ){
							TaskResponsibleEmp empobj= new TaskResponsibleEmp();
							
							empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
							empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
							
							resAeeList.add(empobj);
							}
						
						}
						
						
					}
					
					 mav.addObject("resSeList",resSeList);
					 mav.addObject("resEeList",resEeList);
					 mav.addObject("resDeeList",resDeeList);
					 mav.addObject("resAeeList",resAeeList);
			
			 
		 }
		
			 if(taskoutput.getDivisionId()!=null && taskoutput.getCircleId()!=null && taskoutput.getDivisionId()!=null && taskoutput.getSubdivisionId()==null ){
				 
				// System.out.println(user.getUnitId()+"unit"+user.getCircleId()+"div"+user.getDivisionId());
				 mav.addObject("selectedunit",taskoutput.getUnitId()); 
				 mav.addObject("selectedcircle",taskoutput.getCircleId()); 
			 mav.addObject("selecteddivision",taskoutput.getDivisionId()); 
			
			 
			 for( int i=0; i<treList.size(); i++){
					
					if( treList.get(i).getUnitId()==taskoutput.getUnitId()&& treList.get(i).getCircleId()==0 && treList.get(i).getDivisionId()==user.getDivisionId() && treList.get(i).getSubdivisionId()==0 ){
					if((treList.get(i).getDesignationId()==7 ) ){
					TaskResponsibleEmp empobj= new TaskResponsibleEmp();
					
					empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
					empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
					
					resSeList.add(empobj);
					}
					if((treList.get(i).getDesignationId()==5 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resEeList.add(empobj);
						}
					
					if((treList.get(i).getDesignationId()==4 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resDeeList.add(empobj);
						}
					if((treList.get(i).getDesignationId()==2) || (treList.get(i).getDesignationId()==8 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resAeeList.add(empobj);
						}
					
					}
					
					
				}
				
				 mav.addObject("resSeList",resSeList);
				 mav.addObject("resEeList",resEeList);
				 mav.addObject("resDeeList",resDeeList);
				 mav.addObject("resAeeList",resAeeList);
			 
			 
			 }
			 
			 
		
			 if(taskoutput.getSubdivisionId()!=null && taskoutput.getCircleId()!=null && taskoutput.getDivisionId()!=null && taskoutput.getDivisionId()!=null ){
				 mav.addObject("selectedunit",taskoutput.getUnitId()); 
				 mav.addObject("selectedcircle",taskoutput.getCircleId()); 
			 mav.addObject("selecteddivision",taskoutput.getDivisionId()); 
				 
			 mav.addObject("selectedsubdivision",taskoutput.getSubdivisionId()); 
			
			
			 for( int i=0; i<treList.size(); i++){
					
					if( treList.get(i).getUnitId()==taskoutput.getUnitId()&& treList.get(i).getCircleId()==taskoutput.getCircleId() && treList.get(i).getDivisionId()==taskoutput.getDivisionId() && treList.get(i).getSubdivisionId()==taskoutput.getSubdivisionId() ){
					if((treList.get(i).getDesignationId()==7 ) ){
					TaskResponsibleEmp empobj= new TaskResponsibleEmp();
					
					empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
					empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
					
					resSeList.add(empobj);
					}
					if((treList.get(i).getDesignationId()==5 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resEeList.add(empobj);
						}
					
					if((treList.get(i).getDesignationId()==4 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resDeeList.add(empobj);
						}
					if((treList.get(i).getDesignationId()==2) || (treList.get(i).getDesignationId()==8 ) ){
						TaskResponsibleEmp empobj= new TaskResponsibleEmp();
						
						empobj.setResponsibleEmpId(treList.get(i).getResponsibleEmpId());
						empobj.setResponsibleEmpName(treList.get(i).getResponsibleEmpName());
						
						resAeeList.add(empobj);
						}
					
					}
					
					
				}
				
				 mav.addObject("resSeList",resSeList);
				 mav.addObject("resEeList",resEeList);
				 mav.addObject("resDeeList",resDeeList);
				 mav.addObject("resAeeList",resAeeList);
			 }
			 
			 
		
		 
		 if(taskoutput.getUnitId()==null && taskoutput.getCircleId()==null && taskoutput.getDivisionId()==null && taskoutput.getSubdivisionId()==null ){
			
			
			
			 
			 
		 }
		
		 mav.addObject("unitList",unitList);
		 mav.addObject("ttList",ttList);
		 mav.addObject("tpList",tpList);
		 mav.addObject("tsList",tsList);
		 mav.addObject("treList",treList);
		// System.out.println("roleid"+user.getRoleId());
		 
		 }

			if(taskObject!=null && taskObject.getSubject()!=null && taskObject.getStatusId()>0 &&  taskObject.getTaskTypeId()>0 && taskObject.getPriorId()>0   ){
				
				
				List<MultipartFile> files = taskObject.getUpfile();

				List<String> fileNames = new ArrayList<String>();
				
				List<TaskFiles> fileList=new ArrayList<TaskFiles>();
			 
				if(user.getRoleId()==1){
					
					//set reamrks and se/empids 
					
					taskObject.setUnitRemarks(taskObject.getRemarks());
					taskObject.setCircleRemarks("NA");
					  taskObject.setDivisionRemarks("NA");
					  taskObject.setSubdivisionRemarks("NA");
						
					  taskObject.setAeeRemarks("NA");
					
					
					
				}
				
              if(   user.getRoleId()==2){
					
					//set reamrks and se/eempid
            	  taskObject.setCircleRemarks(taskObject.getRemarks());
            	  taskObject.setUnitRemarks("NA");
				  taskObject.setDivisionRemarks("NA");
				  taskObject.setSubdivisionRemarks("NA");
					
				  taskObject.setAeeRemarks("NA");
					
            	  
            	
					
				}
			
              
              if(user.getRoleId()==3){
					
					
            	  taskObject.setDivisionRemarks(taskObject.getRemarks());
            	  taskObject.setCircleRemarks("NA");
				  taskObject.setUnitRemarks("NA");
				  taskObject.setSubdivisionRemarks("NA");
					
				  taskObject.setAeeRemarks("NA");
					
					
				}
			
              
              if(user.getRoleId()==4){
					
					//setreamrks/empids
            	  taskObject.setSubdivisionRemarks(taskObject.getRemarks());
            	  taskObject.setCircleRemarks("NA");
				  taskObject.setDivisionRemarks("NA");
				  taskObject.setUnitRemarks("NA");
					
				  taskObject.setAeeRemarks("NA");
					
				}
			
              
              if(user.getRoleId()==-1){
					
					//setremarks/empids
					
					
				}
			
			
				
				try  {
					//taskObject.setUseroracle("admin");
					taskObject.setUserpost(user.getUserId().toString());
					
					
					if(null != files && files.size() > 0) {
						for (MultipartFile multipartFile : files) {

							String fileName = multipartFile.getOriginalFilename();
							//String FileType = ( files).get(0).getContentType();
							fileNames.add(fileName);
							//Handle file content - multipartFile.getInputStream()

						}
					}
					 
					 
					
					 
					 String filetitile=null;
					 String  filetitilenew=null;
					 for(int i=0; i<fileNames.size();i++){
						 filetitile=fileNames.get(i);
						 
						 if (i==0){
						 filetitilenew=filetitile;
						 }
						 
						 if(i>0){
							 
							 filetitilenew=filetitile+"@"+filetitilenew;
							 
						 }
						 
						// System.out.println("filetitilenew"+filetitilenew);
						 
						 
					 }
					 
					// System.out.println("filetitilenew"+filetitilenew);
					 String rootPath = System.getProperty("catalina.base");
					 File dir = new File(rootPath + File.separator + "webapps"
								+ File.separator + "ICADLeagalWebApp" + File.separator
								+ "uploadedFiles"+File.separator+"TaskManagement");
					 
					 if (!dir.exists())
							dir.mkdirs();
					 
					 
					 taskObject.setFilelocation(dir.getAbsolutePath()+ File.separator
								+ filetitilenew);
					 
						
					 taskObject.setAllfilenames(filetitilenew);
					 
						
						
						try {
							
							for(int i=0; i<files.size(); i++){
								
								//File serverFile = new File(dir.getAbsolutePath()+ File.separator + files.get(i).getOriginalFilename());
								
								// System.out.println("serverFile"+serverFile);
								TaskFiles tf =new TaskFiles();
								
								
								tf.setFileName(files.get(i).getOriginalFilename());
								tf.setFileLocation(dir.getAbsolutePath()+ File.separator + files.get(i).getOriginalFilename());
								tf.setUserId(user.getUserId().toString());
								tf.setDesignationId(user.getDesignationId());
								
								fileList.add(tf);
								
							files.get(i).transferTo( new File(dir.getAbsolutePath()
									+ File.separator + files.get(i).getOriginalFilename()));
							}
							} catch (IllegalStateException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
					    if(fileList.size()>0){
					    	taskObject.setFiledataList(fileList);
					    	
					    	
					    }
				
						
					         // System.out.println("taskObject"+taskObject.getFiledataList().size());
					
						
						

						
						

						
					 returnval=taskAdminManager.updateTask(taskObject);
						
						
						
					//	System.out.println("returnval"+returnval);
						
						
						
						if(returnval>0){				 
							msg="Task updated Successfully";
					       mav.addObject("msg",msg);	
			               
						
								
						}else{
							err="Failure to update Task";
							mav.addObject("err",err);
							
						}
						// System.out.println("listpet"+listpet.get(0)+" i am here"+listpet.get(1));
						
						 

						
							
					
					
					
					
						
				
				 
				
				} catch (TaskUserException e) {
					// TODO Auto-generated catch block
					err="caught in Task user exception";
					mav.addObject("err",err);
					e.printStackTrace();
				}
				 catch (ParseException e) {
					// TODO Auto-generated catch block
					err="caught in exception";
					mav.addObject("err", err);
					e.printStackTrace();
				}
				
				 
				// System.out.println("returnval1"+returnval1);
				 
				 
					 
				 }
		}
				 
				 
			
		
		return mav;
	}
	
	
	@RequestMapping(value = "/task/editEmp")
	@ResponseBody
	public ModelAndView editEmployee(@ModelAttribute("editEmp") Employee empdata,SessionStatus status, HttpSession session)  {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editEmployee");
	
		
		List<Unit> unitList = new ArrayList<Unit>();
		
		
		List<Employee> empList= new ArrayList<Employee>();
		
		
		User user=(User) session.getAttribute("userObj");
		if(user!=null){
		
			try {
				unitList=taskAdminManager.getUnitList();
				mav.addObject("unitList",unitList);
				mav.addObject("selectedunit",user.getUnitId());
				
				if(empdata!=null){
					
					if(empdata.getUnitId()!=null){
						Integer unitId=empdata.getUnitId();
						Integer circleId=empdata.getCircleId();
						Integer divisionId=empdata.getDivisionId();
						Integer subdivisionId=empdata.getSubdivisionId();
						if(circleId==null){							
							
							circleId=0;
						}
if(divisionId==null){							
							
	divisionId=0;
						}
if(subdivisionId==null){							
	
	subdivisionId=0;
}
					
//System.out.println("parameter list"+unitId+circleId+divisionId+subdivisionId);
				empList=taskAdminManager.getAllEmp(unitId,circleId,divisionId,subdivisionId);
				
					}
				//System.out.println("empList"+empList);
				mav.addObject("empList", empList);
				}
			} catch (TaskUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
			
	
		
		}
		return mav;
		
		
		
	}
	
	
	
	@RequestMapping(value = "/task/editEmpData")
	@ResponseBody
	public ModelAndView editEmployeeData(@ModelAttribute("editEmpData") Employee empdata,SessionStatus status, HttpSession session) throws ParseException  {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editEmpData");
	
		
		List<Unit> unitList = new ArrayList<Unit>();
		
		List<Designation>   designationList = new ArrayList<Designation>();
		
		Integer returnval=0;
		
		Employee empObj= new Employee();
		User user=(User) session.getAttribute("userObj");
		if(user!=null){
		
			try {
				unitList=taskAdminManager.getUnitList();
				designationList         =taskAdminManager.getDesignationList();
				mav.addObject("unitList",unitList);
				mav.addObject("designationList",designationList);
				
				if(empdata!=null){
					
					if(empdata.getEmpId()>0 && empdata.getFirstName()==null ){
						
						empObj=taskAdminManager.getEmployeeObject(empdata.getEmpId());
						
						//System.out.println("empObj"+empObj);
						if(empObj!=null){
							
							mav.addObject("empObj",empObj);
							mav.addObject("selectedunit",empObj.getUnitId());
							mav.addObject("selectedcircle",empObj.getCircleId());
							mav.addObject("selecteddivision",empObj.getDivisionId());
							mav.addObject("selectedsubdivision",empObj.getSubdivisionId());
							mav.addObject("selecteddesignation",empObj.getDesignationId());
							
						}
						
					}
					
                           if(empdata.getEmpId()>0 && empdata.getFirstName()!=null  && empdata.getUnitId()>0  ){
                        	   
                        	   empdata.setUserId(user.getUserId());
						
						returnval=taskAdminManager.updateemp(empdata);
						
						
						if(returnval>0){
							
							mav.addObject("msg","Successfully updated Employee data");
							
							
						}
						
						if(returnval==0){
							
							mav.addObject("err","Failed to update Employee data");
							
						}
						
					}
					
					
					
					
				}
				
				
			} catch (TaskUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
			
	
		
		}
		return mav;
		
		
		
	}
	
	@RequestMapping(value="/tasktsimis/livetaskDB")
	public ModelAndView editData(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updatetaskDB");
		return mav;
		
	}
	
	
	
	
	@RequestMapping(value = "/tasktsimis/resultofliveDB")
	public ModelAndView generalqueryforresult(@RequestParam("Query") String Query,SessionStatus status, HttpSession session) {
		
		//System.out.println("Query"+Query);

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> count = null;
		String message = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> keys = null;
		List<String> keyslist = new ArrayList<String>();
		Set<String> values = null;
		List<List<Object>> valueslist = new ArrayList<List<Object>>();

		Object[] keysarray = null;
		try {
			count = taskAdminManager.generalqueryforresult(Query);
			if (count.size() >= 1) {
				for (int i = 0; i < count.size(); i++) {
					List<Object> vlist = new ArrayList<Object>();
					map.putAll(count.get(i));
					if (i == 0) {
						keys = map.keySet();
						keysarray = keys.toArray();
					} else {

					}
					for (int j = 0; j < keysarray.length; j++) {
						vlist.add((Object) count.get(i).get(
								keysarray[j].toString()));
					}
					valueslist.add(vlist);

				}
				mav.addObject("keys", keys);
				mav.addObject("values", valueslist);
			} else {
				map.putAll(count.get(0));
				String delete = "DELETE";
				String updated = "UPDATE";
				String inserted = "INSERT";
				String altered = "ALTER";
				if (Query.toLowerCase().contains(delete.toLowerCase())) {
					message = map.keySet() + "rows Deleted Successfully";
				} else if (Query.toLowerCase().contains(updated.toLowerCase())) {
					message = map.keySet() + "rows Updated Successfully";
				} else if (Query.toLowerCase().contains(inserted.toLowerCase())) {
					message = map.keySet() + "rows inserted Successfully";
				}else if (Query.toLowerCase().contains(altered.toLowerCase())){
					message = map.keySet() + "rows altered Successfully";
					
				}

				
				else {
					message = "Successfully updated";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
		mav.setViewName("updatetaskDB");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}
	
	

	

}
