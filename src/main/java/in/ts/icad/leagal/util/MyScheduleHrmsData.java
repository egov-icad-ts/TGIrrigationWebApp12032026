package in.ts.icad.leagal.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import in.ts.icad.leagal.manager.InventoryAdminManager;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Designation;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Employee;
import in.ts.icad.leagal.model.EmployeeDiversion;
import in.ts.icad.leagal.model.Sectiondata;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;

public class MyScheduleHrmsData {
	
	
	@Autowired
	private InventoryAdminManager invam;

	@Scheduled(cron="0  5  */3  *  *  ?") //Or use this  
    public   void cronEmpmstMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageEmpMstoutput=0;
		
		String message=null;
		
		List<Employee> empList= new ArrayList<Employee>();
		try {
			empList = invam.sourceHrmsEmpMst();
			
			//System.out.println("i am in cronempList"+empList);
			
			if(empList!=null){
				
				if(empList.size()>0){
					flag=true;
					
					output=invam.DeleteStageEmpMst(flag);
					
					
					if(output>0 || output==0){
						
					//	System.out.println("i am in output"+output);
						
						stageEmpMstoutput=invam.stageinsertEmpMst(empList);
						
						//System.out.println("i am in stageEmpMstoutput"+stageEmpMstoutput);
						
						if(stageEmpMstoutput>0){
							
							invam.getbaseupdatesEmpMaster();
							
						}
						
						
					}
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	//Or use this  
	//System.out.println("coming here");
	//System.out.println("i am in cronaddnlChrageList"+addnlChrageList);
	//System.out.println("i am in output"+output);
	
	//System.out.println("i am in stageAddnlChargeoutput"+stageAddnlChargeoutput);
	
      @Scheduled(cron="0  7  */3  *  *  ?") 
    public   void cronAddnlChargeMethod()
    
   
    {
		
		
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageAddnlChargeoutput=0;
		
		String message=null;
		
		List<Employee> addnlChrageList= new ArrayList<Employee>();
		try {
			addnlChrageList = invam.sourceHrmsAdditionalCharge();
			
			
			
			if(addnlChrageList!=null){
				
				if(addnlChrageList.size()>0){
					flag=true;
					
					output=invam.DeleteStageAdditionalCharge(flag);
					
					if(output>0 || output==0){
						
						
						
						stageAddnlChargeoutput=invam.stageinsertAdditionalCharge(addnlChrageList);
				
                    if(stageAddnlChargeoutput>0){
							
							invam.getbaseupdatesAddnlChargeMaster();
							
						}
						
					}
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
   }
	
	
	@Scheduled(cron="0  9  */3  *  *  ?") //Or use this  
    public   void cronDesignationMstMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stagedesignationoutput=0;
		
		String message=null;
		
		List<Designation> designationList= new ArrayList<Designation>();
		try {
			designationList = invam.sourceHrmsDesignationMst();
			
			//System.out.println("i am in cronaddnlChrageList"+designationList);
			
			if(designationList!=null){
				
				if(designationList.size()>0){
					flag=true;
					
					output=invam.DeleteStageDesignationMst(flag);
					
					if(output>0 || output==0){
						
						//System.out.println("i am in output"+output);
						
						stagedesignationoutput=invam.stageinsertDesignationMst(designationList);
						
					//	System.out.println("i am in stagedesignationoutput"+stagedesignationoutput);
						
						if(stagedesignationoutput>0){
							
							invam.getbaseupdatesDesgMaster();
						}
						
						
					}
					
				}
				
				
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0  11  */3  *  *  ?") //Or use this  
    public   void cronPPEMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageppeoutput=0;
		
		String message=null;
		
		List<Employee> ppeList= new ArrayList<Employee>();
		try {
			ppeList = invam.sourceHrmsPreaentPostEmp();
			
			//System.out.println("i am in ppeList"+ppeList);
			
			if(ppeList!=null){
				
				if(ppeList.size()>0){
					flag=true;
					
					output=invam.DeleteStagePresentPostEMP(flag);
					
					if(output>0 || output==0){
						
						
						//System.out.println("i am in output"+output);
						
						stageppeoutput=invam.stageinsertPresentPostEmp(ppeList);
						
						//System.out.println("i am in stageppeoutput"+stageppeoutput);
						
						if(stageppeoutput>0){
							
							invam.getbaseupdatesPPeMaster();
							
						}
						
						
					}
					
				}
				
				
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0   13  */3  *  *  ?") //Or use this  
    public   void cronSubPostsMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stagsuboutput=0;
		
		String message=null;
		
		List<Employee> subList= new ArrayList<Employee>();
		try {
			subList = invam.sourceHrmsSubposts();
			
			//System.out.println("i am in subList"+subList);
			
			if(subList!=null){
				
				if(subList.size()>0){
					flag=true;
					
					output=invam.DeleteStageSubPosts(flag);
					
					if(output>0 || output==0){
						
						
						//System.out.println("i am in output"+output);
						
						stagsuboutput=invam.stageinsertSubpostsEmp(subList);
						
						
						if(stagsuboutput>0){
							
							invam.getbaseupdatesSubpostsMaster();
							
						}
						//System.out.println("i am in stagsuboutput"+stagsuboutput);
						
						
					}
					
				}
				
				
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0   15  */3  *  *  ?") //Or use this  
    public   void cronUnitMstMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageUnitMstoutput=0;
		
		String message=null;
		
		List<Unit> unitList= new ArrayList<Unit>();
		try {
			unitList = invam.sourceHrmsUnitMst();
			
			//System.out.println("i am in subList"+subList);
			
			if(unitList!=null){
				
				if(unitList.size()>0){
					flag=true;
					
					output=invam.DeleteStageUnitMst(flag);
					
					if(output>0 || output==0){
						
						
						//System.out.println("i am in output"+output);
						
						stageUnitMstoutput=invam.stageinsertUnitMst(unitList);
						
						//System.out.println("i am in stageUnitMstoutput"+stageUnitMstoutput);
						
						if(stageUnitMstoutput>0){
							
							
							invam.getbaseupdatesUnitMaster();
						}
						
						
					}
					
				}
				
				
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0    17  */3  *  *  ?") //Or use this  
    public   void cronCircleMstMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageCircleMstoutput=0;
		
		String message=null;
		
		List<Circle> circleList= new ArrayList<Circle>();
		try {
			circleList = invam.sourceHrmsCircleMst();
			
		//	System.out.println("i am in circleList"+circleList);
			
			if(circleList!=null){
				
				if(circleList.size()>0){
					flag=true;
					
					output=invam.DeleteStageCircleMst(flag);
					
					if(output>0 || output==0){
						
						
						//System.out.println("i am in output"+output);
						
						stageCircleMstoutput=invam.stageinsertCircleMst(circleList);
						
					if(stageCircleMstoutput>0){
							
							
							invam.getbaseupdatesCircleMaster();
							
						}
						
					//	System.out.println("i am in stageCircleMstoutput"+stageCircleMstoutput);
						
						
					}
					
				}
				
				
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0    19  */3  *  *  ?") //Or use this  
    public   void cronDivisionMstMethod()    
    
    {		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageDivisionMstoutput=0;
		
		String message=null;
		
		List<Division> DivisionList= new ArrayList<Division>();
		try {
			DivisionList = invam.sourceHrmsDivisionMst();
			
		//	System.out.println("i am in circleList"+circleList);
			
			if(DivisionList!=null){
				
				if(DivisionList.size()>0){
					flag=true;
					
					output=invam.DeleteStageDivisionMst(flag);
					
					if(output>0 || output==0){
						
						
						//System.out.println("i am in output"+output);
						
						stageDivisionMstoutput=invam.stageinsertDivisionMst(DivisionList);
						
					//	System.out.println("i am in stageCircleMstoutput"+stageCircleMstoutput);
						if(stageDivisionMstoutput>0){
							
							invam.getbaseupdatesDivisionMaster();
							
						}
						
					}
					
				}
				
				
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0   21  */3  *  *  ?") //Or use this  
    public   void cronSubDivisionMstMethod()    
    
    {		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageSubDivisionMstoutput=0;
		
		String message=null;
		
		List<Subdivision> SubDivisionList= new ArrayList<Subdivision>();
		try {
			SubDivisionList = invam.sourceHrmsSubDivisionMst();
			
		//	System.out.println("i am in circleList"+circleList);
			
			if(SubDivisionList!=null){
				
				if(SubDivisionList.size()>0){
					flag=true;
					
					output=invam.DeleteStageSubDivisionMst(flag);
					
					if(output>0 || output==0){
						
						
						//System.out.println("i am in output"+output);
						
						stageSubDivisionMstoutput=invam.stageinsertSubDivisionMst(SubDivisionList);
						
						//System.out.println("i am in stageSubDivisionMstoutput"+stageSubDivisionMstoutput);
						
						
						if(stageSubDivisionMstoutput>0){
							
							invam.getbaseupdatesSubDivisionMaster();
							
						}
						
						
					}
					
				}
				
				
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0   23  */3  *  *  ?") //Or use this  
    public   void cronSectionMstMethod()    
    
    {		
		//System.out.println("coming heresection");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageSectionMstoutput=0;
		
		String message=null;
		
		List<Sectiondata> sectionList= new ArrayList<Sectiondata>();
		try {
			
			//System.out.println("i am in sectionList");
			sectionList = invam.sourceHrmsSectionMst();
			
			//System.out.println("i am in sectionList"+sectionList);
			
			if(sectionList!=null){
				
				if(sectionList.size()>0){
					flag=true;
					
					output=invam.DeleteStageSectionMst(flag);
					
					if(output>0 || output==0){
						
						
						//System.out.println("i am in output"+output);
						
						stageSectionMstoutput=invam.stageinsertSectionMst(sectionList);
						
						//System.out.println("i am in stageSectionMstoutput"+stageSectionMstoutput);
						
						
						if(stageSectionMstoutput>0){
							
							invam.getbaseupdatesSectionMaster();
							
						}
						
						
					}
					
				}
				
				
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	
	@Scheduled(cron="0   26  */3  *  *  ?") //Or use this  
    public   void cronUsersMethod()    
    
    {		
		//System.out.println("coming hereusers");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageUsersoutput=0;
		
		String message=null;
		
		List<User> userList= new ArrayList<User>();
		try {
			
		//	System.out.println("i am in userlist");
			userList = invam.sourceHrmsUserEmp();
			
		//	System.out.println("i am in userList"+userList);
			
			if(userList!=null){
				
				if(userList.size()>0){
					flag=true;
					
					output=invam.DeleteStageUsers(flag);
					
					if(output>0 || output==0){
						
						
						//System.out.println("i am in output"+output);
						
						stageUsersoutput=invam.stageinsertUserMst(userList);
						
						//System.out.println("i am in stageUsersoutput"+stageUsersoutput);
						if(stageUsersoutput>0){
							
							invam.getbaseupdatesUsersMaster();
							
						}
						
					}
					
				}
							
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0   27  */3  *  *  ?") //Or use this  
    public void cronEmpDiversionMethod()    
    
    {		
		//System.out.println("coming hereusers");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageEmpDivoutput=0;
		
		String message=null;
		
		List<EmployeeDiversion> empdivList= new ArrayList<EmployeeDiversion>();
		try {
			
			//System.out.println("i am in empdivList");
			empdivList = invam.sourceHrmsEmpDiversion();
			
			//System.out.println("i am in empdivList"+empdivList);
			
			if(empdivList!=null){
				
				if(empdivList.size()>0){
					flag=true;
					
					output=invam.DeleteStageEmpDiversion(flag);
					
					if(output>0 || output==0){
						
						
						//System.out.println("i am in output"+output);
						
						stageEmpDivoutput=invam.stageinsertEmpDiversion(empdivList);
						
						if(stageEmpDivoutput>0){
							
							invam.getbaseupdatesEmpdivMaster();
						}
						
						//System.out.println("i am in empdivList"+empdivList);
						
						//System.out.println("i am in empdivList"+stageEmpDivoutput);
						
					}
					
				}
							
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }




}
