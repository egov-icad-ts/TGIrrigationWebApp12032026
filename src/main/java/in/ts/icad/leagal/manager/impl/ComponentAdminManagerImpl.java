package in.ts.icad.leagal.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.ComponentAdminDAO;
import in.ts.icad.leagal.dao.LeagalAdminDAO;
import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.manager.ComponentAdminManager;
import in.ts.icad.leagal.model.CadAyacutKmlDocs;
import in.ts.icad.leagal.model.CompInfo;
import in.ts.icad.leagal.model.ComponentAyacut;
import in.ts.icad.leagal.model.ComponentPower;
import in.ts.icad.leagal.model.Constituency;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.PowerBill;
import in.ts.icad.leagal.model.Pumpmotor;
import in.ts.icad.leagal.model.User;

@Component
public class ComponentAdminManagerImpl implements ComponentAdminManager {
	@Autowired
	private ComponentAdminDAO cad;

	@Override
	public Integer insertComponents(in.ts.icad.leagal.model.Component compObject) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertComponents(compObject);
	}

	@Override
	public in.ts.icad.leagal.model.Component getParentComponentLength(Integer compParentId)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getParentComponentLength(compParentId);
	}

	@Override
	public List<in.ts.icad.leagal.model.Component> getParentComponent(Integer projectId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getParentComponent(projectId);
	}

	@Override
	public List<Packages> getCompPackage(Integer componentId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getCompPackage(componentId);
	}

	@Override
	public List<in.ts.icad.leagal.model.Component> getCompParent(Integer componentId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getCompParent(componentId);
	}

	@Override
	public List<Pumpmotor> getPumpMakeList() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getPumpMakeList();
	}

	@Override
	public List<Pumpmotor> getPumpTypeList() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getPumpTypeList();
	}

	@Override
	public List<Pumpmotor> getMotorMakeList() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getMotorMakeList();
	}

	@Override
	public List<Pumpmotor> getMotorTypeList() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getMotorTypeList();
	}

	@Override
	public Integer insertComponentsMotorinfo(in.ts.icad.leagal.model.Component compObject)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertComponentsMotorinfo(compObject);
	}

	@Override
	public Integer insertComponentsPumpinfo(in.ts.icad.leagal.model.Component compObject)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertComponentsPumpinfo(compObject);
	}

	

	@Override
	public Integer insertComponentMonthlyPowerConsumed(ComponentPower cpObject) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertComponentMonthlyPowerConsumed(cpObject);
	}

	@Override
	public Integer insertComponentMonthlyAyacutCreated(ComponentAyacut cpObject) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertComponentMonthlyAyacutCreated(cpObject);
	}

	@Override
	public List<Map<String, Object>> generalqueryforresult(String query) {
		// TODO Auto-generated method stub
		return cad.generalqueryforresult(query);
	}

	@Override
	public List<in.ts.icad.leagal.model.Component> getCompdatfordeleteInfo(Integer projectId)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getCompdatfordeleteInfo(projectId);
	}

	@Override
	public Integer deleteComponent(Integer componentId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.deleteComponent(componentId);
	}

	@Override
	public in.ts.icad.leagal.model.Component editcompinfo(Integer componentId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.editcompinfo(componentId);
	}

	@Override
	public Integer updateComponents(in.ts.icad.leagal.model.Component compObject) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.updateComponents(compObject);
	}

	@Override
	public List<ComponentPower> getComponentMonthlyPower(Integer projectId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getComponentMonthlyPower(projectId);
	}

	@Override
	public Integer deleteCompMonPower(Integer componentPowerId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.deleteCompMonPower(componentPowerId);
	}

	@Override
	public ComponentPower editcompPowerinfo(Integer compPowerId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.editcompPowerinfo(compPowerId);
	}

	@Override
	public List<ComponentAyacut> getComponentMonthlyAyacut(Integer componentId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getComponentMonthlyAyacut(componentId);
	}

	@Override
	public Integer deleteCompMonAyacut(Integer componentAyacutId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.deleteCompMonAyacut(componentAyacutId);
	}

	@Override
	public ComponentAyacut editcompAyacutinfo(Integer compAyacutId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.editcompAyacutinfo(compAyacutId);
	}

	@Override
	public Integer updateComponentMonPower(ComponentPower compObjectPower) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.updateComponentMonPower(compObjectPower);
	}

	@Override
	public Integer updateComponentMonAyacut(ComponentAyacut compObjectAyacut) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.updateComponentMonAyacut(compObjectAyacut);
	}

	

	@Override
	public List<in.ts.icad.leagal.model.Component> getComponentPowerAyacut(Integer projectId)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getComponentPowerAyacut(projectId);
	}

	@Override
	public List<in.ts.icad.leagal.model.Component> getComponentMotorInput(Integer projectId)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getComponentMotorInput(projectId);
	}

	@Override
	public List<in.ts.icad.leagal.model.Component> getComponentPumpInput(Integer componentId)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getComponentPumpInput(componentId);
	}

	@Override
	public Integer deleteCompInput(Integer componentPowerAyacutId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.deleteCompInput(componentPowerAyacutId);
	}

	@Override
	public Integer deleteCompmotorinfo(Integer componentInfoId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.deleteCompmotorinfo(componentInfoId);
	}

	@Override
	public in.ts.icad.leagal.model.Component editcompMotorinfo(Integer compInfoId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.editcompMotorinfo(compInfoId);
	}

	@Override
	public in.ts.icad.leagal.model.Component editcompPowerAyacutinfo(Integer compPowerAyacutId)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.editcompPowerAyacutinfo(compPowerAyacutId);
	}

	@Override
	public Integer updateComponentInfo(in.ts.icad.leagal.model.Component compObject) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.updateComponentInfo(compObject);
	}

	@Override
	public Integer updateCompPowerAyacut(in.ts.icad.leagal.model.Component compObject) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.updateCompPowerAyacut(compObject);
	}

	@Override
	public List<in.ts.icad.leagal.model.Component> getPumPCapacityList() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getPumPCapacityList();
	}

	@Override
	public List<in.ts.icad.leagal.model.Component> getPhaseList() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getPhaseList();
	}

	@Override
	public List<in.ts.icad.leagal.model.Component> getStageList() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getStageList();
	}

	@Override
	public Integer insertComponentsPowerAyacutData(in.ts.icad.leagal.model.Component compObject)
			throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertComponentsPowerAyacutData(compObject);
	}

	@Override
	public List<in.ts.icad.leagal.model.Component> getCompTypeList(Integer compcatId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getCompTypeList(compcatId);
	}

	@Override
	public Integer insertPackages(Integer projectId, String packName, Integer unitId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertPackages(projectId, packName, unitId);
	}

	@Override
	public Integer insertConstituency(ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertConstituency(compAyacutObj);
	}

	/*@Override
	public Integer updateMandalConstituency(ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.updateMandalConstituency(compAyacutObj);
	}

	@Override
	public Integer updateVillageConstituency(ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.updateVillageConstituency(compAyacutObj);
	}*/

	@Override
	public Integer insertprojAyacut(ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertprojAyacut(compAyacutObj);
	}

	@Override
	public List<Constituency> getConstList() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getConstList();
	}

	@Override
	public List<Packages> getProjPacks(Integer projectId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getProjPacks(projectId);
	}

	@Override
	public List<ComponentAyacut> getProjectAyacutInfo(Integer unitId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getProjectAyacutInfo(unitId);
	}

	@Override
	public Integer deleteProjectAyacut(Integer projAyacutId,String userName) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.deleteProjectAyacut(projAyacutId,userName);
	}

	@Override
	public ComponentAyacut geteditProjectAyacutInfo(Integer projAyacutId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.geteditProjectAyacutInfo(projAyacutId);
	}

	@Override
	public Integer editprojAyacut(ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.editprojAyacut(compAyacutObj);
	}

	@Override
	public Integer editPackages(ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.editPackages(compAyacutObj);
	}

	@Override
	public Integer updateConstituency(ComponentAyacut compAyacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.updateConstituency(compAyacutObj);
	}

	@Override
	public List<Constituency> getConstListbyoldDist(Integer districtId,Integer mcode) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getConstListbyoldDist(districtId,mcode);
	}

	@Override
	public List<CompInfo> getCompPumpsInfo(Integer componentId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getCompPumpsInfo(componentId);
	}

	@Override
	public Integer insertComponentsDailyinfo(CompInfo CompInfoObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertComponentsDailyinfo(CompInfoObj);
	}

	@Override
	public Integer insertComponentsinfo(in.ts.icad.leagal.model.Component compInfoobj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertComponentsinfo(compInfoobj);
	}

	@Override
	public List<CompInfo> getCompdailyInfo(Integer componentId,String componentDate) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getCompdailyInfo(componentId,componentDate);
	}

	@Override
	public List<in.ts.icad.leagal.model.Component> getComponentList() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getComponentList();
	}

	@Override
	public Integer deleteCompDailyInput(Integer compInputId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.deleteCompDailyInput(compInputId);
	}

	@Override
	public CompInfo getEditdailyInfo(Integer compInputId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getEditdailyInfo(compInputId);
	}

	@Override
	public Integer editCompDailyInput(CompInfo compInfoObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.editCompDailyInput(compInfoObj);
	}

	@Override
	public Integer insertCompDischarge(CompInfo compInfObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertCompDischarge(compInfObj);
	}

	@Override
	public List<CompInfo> getCompDischargeList(Integer componentId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getCompDischargeList(componentId);
	}

	@Override
	public CompInfo getEditCompDischarge(Integer compDischargeId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getEditCompDischarge(compDischargeId);
	}

	@Override
	public Integer updateCompDischarge(CompInfo compInfObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.updateCompDischarge(compInfObj);
	}

	@Override
	public Integer deleteCompDischarge(Integer compDischargeId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.deleteCompDischarge(compDischargeId);
	}

	@Override
	public Integer insertPowerBill(PowerBill powerBill) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertPowerBill(powerBill);
	}

	@Override
	public Integer getDocNumber() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getDocNumber();
	}

	@Override
	public List<PowerBill> getComponentPowerInfo(Integer componentId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getComponentPowerInfo(componentId);
	}

	@Override
	public Integer deleteCompPowerBill(Integer compPowerBillId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.deleteCompPowerBill(compPowerBillId);
	}

	@Override
	public PowerBill getComponentPowerEditInfo(Integer compPowerBillId) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getComponentPowerEditInfo(compPowerBillId);
	}

	@Override
	public Integer updatePowerBill(PowerBill powerBill) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.updatePowerBill(powerBill);
	}

	@Override
	public List<ComponentAyacut> getprojactmondata(User userObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getprojactmondata(userObj);
	}

	@Override
	public Integer insertProjectSeasonCapacity(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertProjectSeasonCapacity(ayacutObj);
	}

	@Override
	public ComponentAyacut getProjectSeasonCapEdit(ComponentAyacut compAyacut) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getProjectSeasonCapEdit(compAyacut);
	}

	@Override
	public Integer UpdateProjSeasonCapacity(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.UpdateProjSeasonCapacity(ayacutObj);
	}

	@Override
	public Integer DeleteProjectSeasonCapacity(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.DeleteProjectSeasonCapacity(ayacutObj);
	}

	@Override
	public Integer insertProjectSeasonAyacut(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertProjectSeasonAyacut(ayacutObj);
	}

	@Override
	public ComponentAyacut getProjectSeasonAyacutEdit(ComponentAyacut compObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getProjectSeasonAyacutEdit(compObj);
	}

	@Override
	public Integer UpdateProjectSeasonAyacut(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.UpdateProjectSeasonAyacut(ayacutObj);
	}

	@Override
	public Integer DeleteProjectSeasonAyacut(ComponentAyacut ayacutObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.DeleteProjectSeasonAyacut(ayacutObj);
	}

	@Override
	public List<ComponentAyacut> getProjSeasonCapInfo(ComponentAyacut compObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getProjSeasonCapInfo(compObj);
	}

	@Override
	public List<ComponentAyacut> getProjSeasonAyacutInfo(ComponentAyacut compObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getProjSeasonAyacutInfo(compObj);
	}

	@Override
	public Integer getCountOfCadAyacutKmlDocs() throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getCountOfCadAyacutKmlDocs();
	}

	@Override
	public Integer insertCadAyacutKmlDocuments(ComponentAyacut compobj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.insertCadAyacutKmlDocuments(compobj);
	}

	@Override
	public Integer deleteCADKMLbyId(CadAyacutKmlDocs caddocs) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.deleteCADKMLbyId(caddocs);
	}

	@Override
	public List<CadAyacutKmlDocs> getCadAyacutkmlbyUnitInfo(ComponentAyacut compObj) throws ComponentUserException {
		// TODO Auto-generated method stub
		return cad.getCadAyacutkmlbyUnitInfo(compObj);
	}

	
	
	

	
	
	
	

}
