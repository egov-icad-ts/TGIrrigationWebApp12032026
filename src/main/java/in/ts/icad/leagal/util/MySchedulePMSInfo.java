package in.ts.icad.leagal.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import in.ts.icad.leagal.manager.InventoryAdminManager;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Designation;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Employee;
import in.ts.icad.leagal.model.EmployeeDiversion;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.Sectiondata;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;

public class MySchedulePMSInfo {
	
	
	@Autowired
	private InventoryAdminManager invam;

	@Scheduled(cron="0  20  */3  *  *  ?") //Or use this  
    public   void cronInvResBasicMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageinvrestoutput=0;
		
		String message=null;
		
		List<ReservoirSalient> resList= new ArrayList<ReservoirSalient>();
		try {
			resList = invam.getSourcePmsInvResBasic();
			
			//System.out.println("i am in cronempList"+resList);
			
			if(resList!=null){
				
				if(resList.size()>0){
					flag=true;
					
					output=invam.DeleteStagePMSinvRes(flag);
					
					
					if(output>0 || output==0){
						
						//System.out.println("i am in output"+output);
						
						stageinvrestoutput=invam.StagePmsinsertReservoir(resList);
						
						//System.out.println("i am in stageinvrestoutput"+stageinvrestoutput);
						
						//if(stageinvrestoutput>0){
							
							//System.out.println("i am in kalyan");
							
							//invam.getbaseupdatesEmpMaster();
							
						//}
						
						
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
	
	
	@Scheduled(cron="0  22  */3  *  *  ?") //Or use this  
    public   void cronInvProjMstMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageinvprojmsttoutput=0;
		
		String message=null;
		
		List<Project> projList= new ArrayList<Project>();
		try {
			projList = invam.getSourcePmsInvProjectMst();
			
			//System.out.println("i am in cronempList"+resList);
			
			if(projList!=null){
				
				if(projList.size()>0){
					flag=true;
					
					output=invam.DeleteStagePMSinvprojMst(flag);
					
					
					if(output>0 || output==0){
						
						//System.out.println("i am in output"+output);
						
						stageinvprojmsttoutput=invam.StagePmsinsertProjMst(projList);
						
						//System.out.println("i am in stageinvprojmsttoutput"+stageinvprojmsttoutput);
						
						if(stageinvprojmsttoutput>0){
							
							//System.out.println("i am in kalyan proj mst");
							
							//invam.getbaseupdatesEmpMaster();
							
						}
						
						
					}
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0  25  */3  *  *  ?") //Or use this  
    public   void cronInvProjUnitMapMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageinvprojunittoutput=0;
		
		String message=null;
		
		List<Project> projUnitList= new ArrayList<Project>();
		try {
			projUnitList = invam.getSourcePmsInvProjectUnitMap();
			
			//System.out.println("i am in cronempList"+resList);
			
			if(projUnitList!=null){
				
				if(projUnitList.size()>0){
					flag=true;
					
					output=invam.DeleteStagePMSinvprojUnitMap(flag);
					
					
					if(output>0 || output==0){
						
						//System.out.println("i am in output"+output);
						
						stageinvprojunittoutput=invam.StagePmsinsertProjUnitMap(projUnitList);
						
						//System.out.println("i am in stageinvprojunittoutput"+stageinvprojunittoutput);
						
						if(stageinvprojunittoutput>0){
							
							//System.out.println("i am in kalyan"+stageinvprojunittoutput);
							
							//invam.getbaseupdatesEmpMaster();
							
						}
						
						
					}
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0  28  */3  *  *  ?") //Or use this  
    public   void cronInvPackagesMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageinvpackagestoutput=0;
		
		String message=null;
		
		List<Packages> packList= new ArrayList<Packages>();
		try {
			packList = invam.getSourcePmsInvPackages();
			
		//	System.out.println("i am in packList"+packList);
			
			if(packList!=null){
				
				if(packList.size()>0){
					flag=true;
					
					output=invam.DeleteStagePMSinvPackages(flag);
					
					
					if(output>0 || output==0){
						
						//System.out.println("i am in output"+output);
						
						stageinvpackagestoutput=invam.StagePmsinsertPackages(packList);
						
					//	System.out.println("i am in stageinvpackagestoutput"+stageinvpackagestoutput);
						
						if(stageinvpackagestoutput>0){
							
						//	System.out.println("i am in kalyan");
							
							//invam.getbaseupdatesEmpMaster();
							
						}
						
						
					}
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
     


}
