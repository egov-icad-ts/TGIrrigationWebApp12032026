package in.ts.icad.leagal.manager;

import java.util.List;
import java.util.Map;

import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.model.CadAyacutKmlDocs;
import in.ts.icad.leagal.model.CompInfo;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.ComponentAyacut;
import in.ts.icad.leagal.model.ComponentPower;
import in.ts.icad.leagal.model.Constituency;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.PowerBill;
import in.ts.icad.leagal.model.Pumpmotor;
import in.ts.icad.leagal.model.User;

public interface ComponentAdminManager {
	
	Integer insertComponents(Component compObject) throws ComponentUserException;
	Component getParentComponentLength(Integer compParentId) throws ComponentUserException;
	List<Component> getParentComponent(Integer projectId) throws ComponentUserException;
	List<Packages> getCompPackage(Integer componentId) throws ComponentUserException;
	List<Component> getCompParent(Integer componentId) throws ComponentUserException;
	List<Pumpmotor> getPumpMakeList() throws ComponentUserException;
	List<Pumpmotor> getPumpTypeList() throws ComponentUserException;
	List<Pumpmotor> getMotorMakeList() throws ComponentUserException;
	List<Pumpmotor> getMotorTypeList() throws ComponentUserException;
	
	 Integer insertComponentsMotorinfo(final Component compObject) throws ComponentUserException;
	 Integer insertComponentsPumpinfo(final Component compObject) throws ComponentUserException;
 Integer insertComponentsPowerAyacutData(final Component compObject) throws ComponentUserException;
	
	//Integer insertComponentsPowerAyacutData(final Component compObject,  final Component compMotorObject,final Component compPumpObject) throws ComponentUserException;
	 Integer insertComponentMonthlyPowerConsumed(final ComponentPower cpObject) throws ComponentUserException;
	 Integer insertComponentMonthlyAyacutCreated(final ComponentAyacut cpObject) throws ComponentUserException;
	 public List<Map<String, Object>> generalqueryforresult(String query);	
	 List<Component> getCompdatfordeleteInfo(Integer projectId) throws ComponentUserException ;
	 Integer deleteComponent(Integer componentId) throws ComponentUserException;
	 Component editcompinfo(Integer componentId) throws ComponentUserException;
	 Integer updateComponents(final Component compObject) throws ComponentUserException;
	 List<ComponentPower> getComponentMonthlyPower(Integer projectId) throws ComponentUserException;
	 Integer deleteCompMonPower(Integer componentPowerId) throws ComponentUserException;
	 ComponentPower editcompPowerinfo(Integer compPowerId) throws ComponentUserException;
	 List<ComponentAyacut> getComponentMonthlyAyacut(Integer componentId) throws ComponentUserException;
	 Integer deleteCompMonAyacut(Integer componentAyacutId) throws ComponentUserException;
	 ComponentAyacut editcompAyacutinfo(Integer compAyacutId) throws ComponentUserException;
	 Integer updateComponentMonPower(final ComponentPower compObjectPower) throws ComponentUserException;
	 Integer updateComponentMonAyacut(final ComponentAyacut compObjectAyacut) throws ComponentUserException;
	 List<Component> getComponentPowerAyacut(Integer projectId) throws ComponentUserException;
	 List<Component> getComponentMotorInput(Integer projectId) throws ComponentUserException ;
	 List<Component> getComponentPumpInput(Integer projectId) throws ComponentUserException ;
	 
	 

Integer deleteCompInput(Integer componentPowerAyacutId) throws ComponentUserException;
Integer deleteCompmotorinfo(Integer componentInfoId) throws ComponentUserException;
Component editcompMotorinfo(Integer compInfoId) throws ComponentUserException;
Component editcompPowerAyacutinfo(Integer compPowerAyacutId) throws ComponentUserException;
Integer updateComponentInfo(final Component compObject) throws ComponentUserException;
Integer updateCompPowerAyacut(final Component compObject) throws ComponentUserException;
List<Component> getPumPCapacityList() throws ComponentUserException;
List<Component> getPhaseList() throws ComponentUserException;
List<Component> getStageList() throws ComponentUserException;
List<Component> getCompTypeList(Integer compcatId) throws ComponentUserException;

Integer insertPackages(Integer projectId, String packName, Integer unitId) throws ComponentUserException;
Integer insertConstituency(final ComponentAyacut compAyacutObj) throws ComponentUserException;
/*Integer updateMandalConstituency(final ComponentAyacut compAyacutObj) throws ComponentUserException;
Integer updateVillageConstituency(final ComponentAyacut compAyacutObj) throws ComponentUserException;*/
Integer insertprojAyacut(final ComponentAyacut compAyacutObj) throws ComponentUserException;
List<Constituency> getConstList() throws ComponentUserException;
List<Packages> getProjPacks(Integer projectId) throws ComponentUserException;
List<ComponentAyacut> getProjectAyacutInfo(Integer unitId) throws ComponentUserException;
Integer  deleteProjectAyacut(Integer projAyacutId, String userName) throws ComponentUserException;
ComponentAyacut geteditProjectAyacutInfo(Integer projAyacutId) throws ComponentUserException;
Integer editprojAyacut(final ComponentAyacut compAyacutObj) throws ComponentUserException;
Integer editPackages(final ComponentAyacut compAyacutObj) throws ComponentUserException;
Integer updateConstituency(final ComponentAyacut compAyacutObj) throws ComponentUserException;
List<Constituency> getConstListbyoldDist(Integer districtId,Integer mcode) throws ComponentUserException ;
List<CompInfo> getCompPumpsInfo(Integer componentId) throws ComponentUserException;

Integer insertComponentsDailyinfo(final CompInfo CompInfoObj) throws ComponentUserException ;
Integer insertComponentsinfo(final Component compInfoobj) throws ComponentUserException;

List<CompInfo> getCompdailyInfo(Integer componentId,String componentDate) throws ComponentUserException;
List<Component> getComponentList() throws ComponentUserException;

Integer deleteCompDailyInput(Integer compInputId) throws ComponentUserException;
CompInfo getEditdailyInfo(Integer compInputId) throws ComponentUserException;
Integer editCompDailyInput(CompInfo compInfoObj) throws ComponentUserException;
Integer insertCompDischarge(final CompInfo compInfObj) throws ComponentUserException;

List<CompInfo> getCompDischargeList(Integer componentId) throws ComponentUserException;
CompInfo getEditCompDischarge(Integer compDischargeId) throws ComponentUserException;
Integer updateCompDischarge(final CompInfo compInfObj) throws ComponentUserException;
Integer deleteCompDischarge(Integer compDischargeId) throws ComponentUserException;
Integer insertPowerBill(final PowerBill powerBill) throws ComponentUserException;
	
Integer getDocNumber(  ) throws ComponentUserException;
List<PowerBill> getComponentPowerInfo(Integer componentId) throws ComponentUserException;
Integer deleteCompPowerBill(Integer compPowerBillId) throws ComponentUserException;
PowerBill getComponentPowerEditInfo(Integer compPowerBillId) throws ComponentUserException;
Integer updatePowerBill(final PowerBill powerBill) throws ComponentUserException;
public List<ComponentAyacut> getprojactmondata(User userObj) throws ComponentUserException ;


public Integer insertProjectSeasonCapacity(ComponentAyacut ayacutObj) throws ComponentUserException;
	 
public ComponentAyacut getProjectSeasonCapEdit(ComponentAyacut compAyacut) throws ComponentUserException;
public Integer UpdateProjSeasonCapacity(ComponentAyacut ayacutObj) throws ComponentUserException;


public Integer DeleteProjectSeasonCapacity(ComponentAyacut ayacutObj) throws ComponentUserException;

public Integer insertProjectSeasonAyacut(ComponentAyacut ayacutObj) throws ComponentUserException;

public ComponentAyacut getProjectSeasonAyacutEdit(ComponentAyacut compObj) throws ComponentUserException;

public Integer UpdateProjectSeasonAyacut(ComponentAyacut ayacutObj) throws ComponentUserException;

public Integer DeleteProjectSeasonAyacut(ComponentAyacut ayacutObj) throws ComponentUserException;

public List<ComponentAyacut> getProjSeasonCapInfo(ComponentAyacut compObj) throws ComponentUserException;
public List<ComponentAyacut> getProjSeasonAyacutInfo(ComponentAyacut compObj) throws ComponentUserException;

public Integer getCountOfCadAyacutKmlDocs() throws ComponentUserException;

public Integer insertCadAyacutKmlDocuments(final ComponentAyacut  compobj) throws ComponentUserException;

public Integer deleteCADKMLbyId(final CadAyacutKmlDocs caddocs) throws ComponentUserException;

public List<CadAyacutKmlDocs> getCadAyacutkmlbyUnitInfo(ComponentAyacut compObj) throws ComponentUserException;


}
