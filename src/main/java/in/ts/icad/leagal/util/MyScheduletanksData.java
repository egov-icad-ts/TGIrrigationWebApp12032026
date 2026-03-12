package in.ts.icad.leagal.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import in.ts.icad.leagal.manager.InventoryAdminManager;
import in.ts.icad.leagal.model.Constituency;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.Habitations;
import in.ts.icad.leagal.model.Mandal;
import in.ts.icad.leagal.model.Tanks;
import in.ts.icad.leagal.model.Village;

public class MyScheduletanksData {
	
	@Autowired
	private InventoryAdminManager invam;
	

	
	@Scheduled(cron="0 30 */4 *  * ?") //Or use this  
    public   void cronDistrictsMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageDistoutput=0;
		
		String message=null;
		
		List<District> newdistrictList= new ArrayList<District>();
		try {
			newdistrictList = invam.source_mk_districts();
			
			//System.out.println("i am in select"+newdistrictList);
			
			if(newdistrictList!=null){
				
				if(newdistrictList.size()>0){
					flag=true;
					
					output=invam.DeleteStageDistricts(flag);
					
					
					if(output>0 || output==0){
						
						stageDistoutput=invam.stageinsertDistricts(newdistrictList);
						
						
					}
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	
	@Scheduled(cron="0 35 */4 *  * ?") //Or use this 
    public   void cronMandalsMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageMandaloutput=0;
		
		String message=null;
		
		List<Mandal> newmandalList= new ArrayList<Mandal>();
		try {
			newmandalList = invam.source_mk_mandals();
			
			//System.out.println("i am in select Mandal"+newmandalList);
			
			if(newmandalList!=null){
				
				if(newmandalList.size()>0){
					flag=true;
					
					output=invam.DeleteStageMandals(flag);
					
					
					if(output>0 || output==0){
						
						stageMandaloutput=invam.stageinsertMandals(newmandalList);
						
						
					}
					
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0 40 */4  *  * ?") //Or use this 
    public   void cronAssemblyMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageAssemblyoutput=0;
		
		String message=null;
		
		List<Constituency> newassemblyList= new ArrayList<Constituency>();
		try {
			newassemblyList = invam.sourceMkAssembly();
			
			//System.out.println("i am in select assembly"+newassemblyList);
			
			if(newassemblyList!=null){
				
				if(newassemblyList.size()>0){
					flag=true;
					
					output=invam.DeleteStageAssembly(flag);
					
					
					if(output>0 || output==0){
						
						stageAssemblyoutput=invam.stageinsertAssembly(newassemblyList);
						
						
					}
					
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0 45 */4  * *  ?") //Or use this 
    public   void cronAssemblyMandalsMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageAssemblyMandaloutput=0;
		
		String message=null;
		
		List<Constituency> newassemblyMandalList= new ArrayList<Constituency>();
		try {
			newassemblyMandalList = invam.sourceMkAssemblyMandals();
			
			//System.out.println("i am in select assemblyMandal"+newassemblyMandalList);
			
			if(newassemblyMandalList!=null){
				
				if(newassemblyMandalList.size()>0){
					flag=true;
					
					output=invam.DeleteStageAssemblyMandals(flag);
					
					
					
					//System.out.println("i am in delete"+output);
					if(output > 0 || output ==0){
					
					//	System.out.println("i am iNSIDE loop"+output);
						
						stageAssemblyMandaloutput=invam.stageinsertAssemblyMandals(newassemblyMandalList);
						
						
					}
					
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0 50 */4  *  * ?") //Or use this 
    public   void cronVillagesMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageVillagesoutput=0;
		
		String message=null;
		
		List<Village> newmkvillages= new ArrayList<Village>();
		try {
			newmkvillages = invam.sourceMkVillages();
			
			//System.out.println("i am in select newmkvillages"+newmkvillages);
			
			if(newmkvillages!=null){
				
				if(newmkvillages.size()>0){
					flag=true;
					
					output=invam.DeleteStageVillages(flag);
					
					
					
					//System.out.println("i am in delete"+output);
					if(output > 0 || output ==0){
					
					//	System.out.println("i am iNSIDE loop"+output);
						
						stageVillagesoutput=invam.stageinsertVillages(newmkvillages);
						
						
					}
				
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0 53 */4  *  * ?") //Or use this 
    public   void cronHabitationsMethod()
    
    
    {
		
		//System.out.println("coming here");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stageHabitationsoutput=0;
		
		String message=null;
		
		List<Habitations> newmkhabitations= new ArrayList<Habitations>();
		try {
			newmkhabitations = invam.sourceMkHabitations();
			
			//System.out.println("i am in select newmkhabitations"+newmkhabitations);
			
			if(newmkhabitations!=null){
				
				if(newmkhabitations.size()>0){
					flag=true;
					
					output=invam.DeleteStageHabitations(flag);
					
					
					
					//System.out.println("i am in delete"+output);
					if(output > 0 || output ==0){
					
					//	System.out.println("i am iNSIDE loop"+output);
						
						stageHabitationsoutput=invam.stageinsertHabitations(newmkhabitations);
						
						
					}
					
					
				}
				
				
				
			}
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	@Scheduled(cron="0  25  */2  *  * ?") //Or use this 
    public   void cronTanksinfoMethod()
    
    
    {
		
		//System.out.println("coming here tanks");
       Boolean flag=false;
		
		Integer output=0;
		
		Integer stagetanksoutput=0;
		
		String message=null;
		
		List<Tanks> newmktanks= new ArrayList<Tanks>();
		try {
			newmktanks = invam.sourceMkTanksInfo();
			
			//System.out.println("i am in select newmktanks"+newmktanks);
			
			if(newmktanks!=null){
				
				if(newmktanks.size()>0){
					flag=true;
					
					output=invam.DeleteStageTanks(flag);
					
				
					
				//	System.out.println("i am in delete"+output);
					if(output > 0 || output ==0){
					
						//System.out.println("i am iNSIDE loop"+output);
						
						stagetanksoutput=invam.stageinsertTanksInfo(newmktanks);
						
					//System.out.println("i am iNSIDE loop"+stagetanksoutput);
						
						if(stagetanksoutput>0){
							
							invam.getbaseupdatesTanksInfo();
						}
						
						
					}
					
					
				}
				
				
				
			}
			
			//System.out.println("i am ouside loop"+stagetanksoutput);
			
			//invam.getbaseupdatesTanksInfo();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
     
    }
	
	
	

}
