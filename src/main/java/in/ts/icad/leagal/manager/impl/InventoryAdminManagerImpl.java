package in.ts.icad.leagal.manager.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.ComponentAdminDAO;
import in.ts.icad.leagal.dao.InventoryAdminDAO;
import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.manager.InventoryAdminManager;
import in.ts.icad.leagal.model.CAGParasData;
import in.ts.icad.leagal.model.Canal;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Constituency;
import in.ts.icad.leagal.model.DamInspectDocs;
import in.ts.icad.leagal.model.Designation;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.EmpApprove;
import in.ts.icad.leagal.model.Employee;
import in.ts.icad.leagal.model.EmployeeDiversion;
import in.ts.icad.leagal.model.Habitations;
import in.ts.icad.leagal.model.InvResAbstract;
import in.ts.icad.leagal.model.Mandal;
import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankInspect;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.MitankChecks;
import in.ts.icad.leagal.model.MitankComps;
import in.ts.icad.leagal.model.MstOutputWithFlag;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.PumpMaintainActivities;
import in.ts.icad.leagal.model.PumpOperationInstructions;
import in.ts.icad.leagal.model.PumpOperationType;
import in.ts.icad.leagal.model.PumpStations;
import in.ts.icad.leagal.model.ReservoirAyacut;
import in.ts.icad.leagal.model.ReservoirGates;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirMaintenanceCategory;
import in.ts.icad.leagal.model.ReservoirMaintenanceChecks;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.ReservoirUnitData;
import in.ts.icad.leagal.model.ScheduleDuty;
import in.ts.icad.leagal.model.Sectiondata;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.TankFeedDetails;
import in.ts.icad.leagal.model.Tanks;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.model.Village;

@Component
public class InventoryAdminManagerImpl implements InventoryAdminManager {
	
	@Autowired
	private InventoryAdminDAO iad;

	@Override
	public String inserReservoir(ReservoirSalient ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.inserReservoir(ressalObj);
	}

	@Override
	public List<ReservoirSalient> getResList() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResList();
	}

	@Override
	public ReservoirSalient getResListBYCode(String resocde) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResListBYCode(resocde);
	}

	@Override
	public Integer inserResUnitMap(ReservoirUnitData resunitObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.inserResUnitMap(resunitObj);
	}

	@Override
	public List<ReservoirUnitData> getResUnitMapListById(Integer unitId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResUnitMapListById(unitId);
	}

	@Override
	public Integer deleteReservoirInfo(ReservoirSalient ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteReservoirInfo(ressalObj);
	}

	@Override
	public Integer editReservoirInfo(ReservoirSalient ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.editReservoirInfo(ressalObj);
	}

	@Override
	public Integer DeleteResUnitMapById(ReservoirUnitData resunitObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteResUnitMapById(resunitObj);
	}

	@Override
	public Integer UpdateResUnitMapById(ReservoirUnitData resunitObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateResUnitMapById(resunitObj);
	}

	@Override
	public ReservoirUnitData getResUnitMapListByMapId(Integer resunitId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResUnitMapListByMapId(resunitId);
	}

	@Override
	public List<ReservoirUnitData> getResUnitMapListByResCode(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResUnitMapListByResCode(rescode);
	}

	@Override
	public Integer insertResRegulator(ReservoirGates ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResRegulator(ressalObj);
	}

	@Override
	public Integer insertInvAyacutByResReg(ReservoirAyacut resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertInvAyacutByResReg(resObj);
	}

	@Override
	public List<ReservoirGates> getResRegList(String resCode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResRegList(resCode);
	}

	@Override
	public Integer insertResGates(ReservoirGates ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResGates(ressalObj);
	}

	@Override
	public ReservoirGates getResRegByRegCode(String regCode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResRegByRegCode(regCode);
	}

	@Override
	public List<ReservoirGates> getResGateList(String resCode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResGateList(resCode);
	}

	@Override
	public List<ReservoirAyacut> getResRegAyacutList(String resCode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResRegAyacutList(resCode);
	}

	@Override
	public ReservoirAyacut getResAyacutById(Integer ayacutId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAyacutById(ayacutId);
	}

	@Override
	public ReservoirGates getResGateByGateId(Integer gateId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResGateByGateId(gateId);
	}

	@Override
	public Integer UpdateResGateById(ReservoirGates ressalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateResGateById(ressalObj);
	}

	@Override
	public Integer DeleteResGateById(ReservoirGates resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteResGateById(resObj);
	}

	@Override
	public Integer UpdateResAyacutById(ReservoirAyacut resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateResAyacutById(resObj);
	}

	@Override
	public Integer DeleteResAyacutById(ReservoirAyacut resunitObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteResAyacutById(resunitObj);
	}

	@Override
	public List<Map<String, Object>> generalqueryforresult(String generalquery) {
		// TODO Auto-generated method stub
		return iad.generalqueryforresult(generalquery);
	}

	@Override
	public List<in.ts.icad.leagal.model.PumpCommonData> getPumpsCommonList() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getPumpsCommonList();
	}

	@Override
	public List<in.ts.icad.leagal.model.PumpPumpsData> getPumpsdataList() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getPumpsdataList();
	}

	@Override
	public List<PumpMaintainActivities> getPumpMaintainActivities() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getPumpMaintainActivities();
	}

	@Override
	public List<MitankChecks> getMitankChecks() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMitankChecks();
	}

	@Override
	public List<MitankComps> getMiTankComps() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMiTankComps();
	}

	@Override
	public List<PumpOperationType> getPumpOperationTypes() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getPumpOperationTypes();
	}

	@Override
	public List<PumpOperationInstructions> getPumpOperationInstructions() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getPumpOperationInstructions();
	}

	@Override
	public List<ScheduleDuty> getReservoirScheduleofDuties()
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getReservoirScheduleofDuties();
	}

	@Override
	public Integer insertMiinspect(List<MiTankInspect> miObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiinspect(miObj);
	}

	@Override
	public List<Tanks> getTanks(Habitations habitObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTanks(habitObj);
	}

	@Override
	public List<ReservoirMaintenanceChecks> getResCheckAnn1()
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResCheckAnn1();
	}

	@Override
	public List<ReservoirMaintenanceCategory> getResCatAnn2()
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResCatAnn2();
	}

	@Override
	public Integer insertResinspect(List<ReservoirInspect> resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResinspect(resObj);
	}

	@Override
	public List<ReservoirSalient> getInvomResList(Integer unitId)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getInvomResList(unitId);
	}

	@Override
	public Integer insertResinspectann2(List<ReservoirInspect> resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResinspectann2(resObj);
	}

	@Override
	public Integer insertResDamDutyinspect(List<ScheduleDuty> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResDamDutyinspect(resObj);
	}

	@Override
	public List<PumpStations> getBasinData() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getBasinData();
	}

	@Override
	public List<PumpStations> getPumpLinks() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getPumpLinks();
	}

	@Override
	public List<PumpStations> getPumpStations(Integer pumpLinkId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getPumpStations(pumpLinkId);
	}

	@Override
	public Integer insertpumpMainActivityInspect(List<PumpMaintainActivities> pumpObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertpumpMainActivityInspect(pumpObj);
	}

	@Override
	public Integer insertMiinspectMst2(List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiinspectMst2(miObj);
	}

	@Override
	public MstOutputWithFlag insertMiinspectMst1(List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiinspectMst1(miObj);
	}

	@Override
	public Integer insertMiinspectRepairs(List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiinspectRepairs(miObj);
	}

	/*@Override
	public Integer insertMiinspectInOut(List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiinspectInOut(miObj);
	}*/

	@Override
	public Integer insertMiinspectCapacity(List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiinspectCapacity(miObj);
	}

	@Override
	public List<MiTankInspect> getMimst2IdByMst1Id(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMimst2IdByMst1Id(mst1Id);
	}

	@Override
	public List<MiTankInspect> getMimst2IdByYearFreq(Integer year, Long tankId, Integer miFreqId)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMimst2IdByYearFreq(year, tankId, miFreqId);
	}

	/*@Override
	public List<MiTankInspect> selectMiInoutBytankId(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.selectMiInoutBytankId(tankId);
	}*/

	@Override
	public List<MiTankInspect> getMiRepairs(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMiRepairs(tankId);
	}

	@Override
	public List<MiTankInspect> getMiCapacity(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMiCapacity(tankId);
	}

	@Override
	public List<Map<String, Object>> generalqueryforinvomresult(String generalquery) {
		// TODO Auto-generated method stub
		return iad.generalqueryforinvomresult(generalquery);
	}

	@Override
	public List<EmpApprove> getEmployeeApprove(EmpApprove empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getEmployeeApprove(empObj);
	}

	@Override
	public MstOutputWithFlag insertResAnn2Mst1(List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResAnn2Mst1(resObj);
	}

	@Override
	public Integer insertresAnn2inspectMst2(List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertresAnn2inspectMst2(resObj);
	}

	@Override
	public List<ReservoirInspect> getResAnn2mst2IdByMst1Id(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnn2mst2IdByMst1Id(mst1Id);
	}

	@Override
	public Integer insertResRecommend(List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResRecommend(resObj);
	}

	@Override
	public Integer insertResHealth(List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResHealth(resObj);
	}

	@Override
	public Integer insertResActiontaken(List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResActiontaken(resObj);
	}

	@Override
	public List<ReservoirInspect> getResAnn2mst2InspectData(Integer year, String rescode, Integer frequency_oper)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnn2mst2InspectData(year, rescode, frequency_oper);
	}

	@Override
	public List<ReservoirInspect> getResAnn2health(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnn2health(rescode);
	}

	@Override
	public List<ReservoirInspect> getResAnn2Recommendations(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnn2Recommendations(rescode);
	}

	@Override
	public List<ReservoirInspect> getResAnn2latesthealth(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnn2latesthealth(rescode);
	}

	@Override
	public List<ReservoirInspect> getResAnn2latestRecommend(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnn2latestRecommend(rescode);
	}

	@Override
	public List<ReservoirInspect> getResAnn2ActionTakenData(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnn2ActionTakenData(rescode);
	}

	@Override
	public MstOutputWithFlag insertResAnn1Mst1(List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResAnn1Mst1(resObj);
	}

	@Override
	public Integer insertresAnn1inspectMst2(List<ReservoirInspect> resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertresAnn1inspectMst2(resObj);
	}

	@Override
	public List<ReservoirInspect> getResAnn1mst2IdByMst1Id(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnn1mst2IdByMst1Id(mst1Id);
	}

	@Override
	public List<ReservoirInspect> getResAnn1mst2InspectData(Integer year, Integer reservoirId, Integer frequency_oper)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnn1mst2InspectData(year, reservoirId, frequency_oper);
	}

	@Override
	public Integer insertMiTankFeedDetails(List<MiTankInspect> miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiTankFeedDetails(miObj);
	}

	@Override
	public List<MiTankInspect> getMiTankFeedData(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMiTankFeedData(tankId);
	}

	@Override
	public Integer insertMiTankFeedRemarks(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiTankFeedRemarks(miObj);
	}

	@Override
	public List<MiTankInspect> getMiTankFeedRemarks(Long tankId,Integer empId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMiTankFeedRemarks(tankId,empId);
	}

	/*@Override
	public List<MiTankInspect> getMiTankInoutFlowRemarks(Long tankId, Integer empId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMiTankInoutFlowRemarks(tankId, empId);
	}

	@Override
	public Integer insertMiTankInOutFlowRemarks(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiTankInOutFlowRemarks(miObj);
	}
*/
	@Override
	public List<MiTankInspect> getMiTankRepairsRemarks(Long tankId, Long nextPostId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMiTankRepairsRemarks(tankId, nextPostId);
	}

	@Override
	public Integer insertMiTankRepairsRemarks(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiTankRepairsRemarks(miObj);
	}

	@Override
	public List<MiTankInspect> getMiTankCapacityRemarks(Long tankId, Long postId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMiTankCapacityRemarks(tankId, postId);
	}

	@Override
	public Integer insertMiTankCapacityRemarks(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiTankCapacityRemarks(miObj);
	}

	@Override
	public List<MiTankInspect> getMiTankMst1Remarks(Integer mst1Id,Long postId ) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMiTankMst1Remarks(mst1Id, postId);
	}

	@Override
	public Integer insertMiTankMst1Remarks(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertMiTankMst1Remarks(miObj);
	}

	@Override
	public Integer deleteMitankRepairsRemarks(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMitankRepairsRemarks(miObj);
	}

	@Override
	public Integer deleteMitankRepairs(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMitankRepairs(miObj);
	}

	/*@Override
	public Integer deleteMitankInoutFlowRemarks(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMitankInoutFlowRemarks(miObj);
	}*/

	@Override
	public Integer deleteMitankInoutFlow(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMitankInoutFlow(miObj);
	}

	@Override
	public Integer deleteMitankCapacityRemarks(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMitankCapacityRemarks(miObj);
	}

	@Override
	public Integer deleteMitankCapacity(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMitankCapacity(miObj);
	}

	@Override
	public Integer deleteMitankFeedRemarks(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMitankFeedRemarks(miObj);
	}

	@Override
	public Integer deleteMitankFeedDetails(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMitankFeedDetails(miObj);
	}

	@Override
	public Integer deleteMiTankMst2(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMiTankMst2(miObj);
	}

	@Override
	public Integer deleteMiTankMst1Remarks(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMiTankMst1Remarks(miObj);
	}

	@Override
	public Integer deleteMiTankMst1(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteMiTankMst1(miObj);
	}

	@Override
	public Integer editMitankMst2(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.editMitankMst2(miObj);
	}

	@Override
	public List<MiTankInspect> getEditMiTankMst2Checks(Integer mst2Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getEditMiTankMst2Checks(mst2Id);
	}

	/*@Override
	public List<MiTankInspect> getEditInoutflowTank(Integer mstinoutflowId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getEditInoutflowTank(mstinoutflowId);
	}

	@Override
	public Integer UpdateInoutflowTank(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateInoutflowTank(miObj);
	}*/

	@Override
	public List<MiTankInspect> getEditMiRepairs(Integer repairId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getEditMiRepairs(repairId);
	}

	@Override
	public Integer UpdateRepairsTank(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateRepairsTank(miObj);
	}

	@Override
	public Integer UpdateCapacityTank(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateCapacityTank(miObj);
	}

	@Override
	public List<MiTankInspect> getEditMiCapacity(Integer capacityId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getEditMiCapacity(capacityId);
	}

	@Override
	public List<MiTankInspect> getEditMiFeed(Integer feedId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getEditMiFeed(feedId);
	}

	@Override
	public Integer UpdateFeedTank(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateFeedTank(miObj);
	}

	@Override
	public List<MiTankInspect> viewMst1Remarks(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.viewMst1Remarks(mst1Id);
	}

	@Override
	public List<MiTankInspect> getTankWeirSluicelist(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankWeirSluicelist(tankId);
	}

	@Override
	public Integer insertTankWeirSluice(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertTankWeirSluice(miObj);
	}

	@Override
	public List<Tanks> getTanksCapacityBYTankId(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTanksCapacityBYTankId(tankId);
	}

	@Override
	public Integer updateTankCrticalStatus(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateTankCrticalStatus(miObj);
	}

	@Override
	public Integer insertTankRepairsDescription(MiTankInspect moobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertTankRepairsDescription(moobj);
	}

	@Override
	public List<MiTankInspect> getTankRepairdescList(Long tankId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankRepairdescList(tankId);
	}

	@Override
	public Integer deleteTankRepairsDescription(MiTankInspect miobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteTankRepairsDescription(miobj);
	}

	@Override
	public Integer editTankRepairsDescription(MiTankInspect miobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.editTankRepairsDescription(miobj);
	}

	@Override
	public List<MiTankInspect> getTankRepairdatabyId(Integer tankRepairdescId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankRepairdatabyId(tankRepairdescId);
	}
	
	@Override
	public MiTankInspect getTankSuiceNamebyId(Integer tankWeirSluiceId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankSuiceNamebyId(tankWeirSluiceId);
	}

	@Override
	public List<Constituency> getConstByDistId(Integer distId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getConstByDistId(distId);
	}

	/*@Override
	public List<MiTankInspect> viewInflowRemarks(Integer inoutId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.viewInflowRemarks(inoutId);
	}*/

	@Override
	public List<MiTankInspect> viewRepairRemarks(Integer repairId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.viewRepairRemarks(repairId);
	}

	@Override
	public List<MiTankInspect> viewCapacityRemarks(Integer capacityId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.viewCapacityRemarks(capacityId);
	}

	@Override
	public List<District> source_mk_districts() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.source_mk_districts();
	}

	@Override
	public Integer DeleteStageDistricts(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageDistricts(flag);
	}

	@Override
	public Integer stageinsertDistricts(List<District> distObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertDistricts(distObj);
	}

	@Override
	public Integer stageinsertMandals(List<Mandal> mandalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertMandals(mandalObj);
	}

	@Override
	public Integer DeleteStageMandals(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageMandals(flag);
	}

	@Override
	public List<Mandal> source_mk_mandals() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.source_mk_mandals();
	}

	@Override
	public Integer stageinsertAssembly(List<Constituency> constObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertAssembly(constObj);
	}

	@Override
	public Integer DeleteStageAssembly(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageAssembly(flag);
	}

	@Override
	public List<Constituency> sourceMkAssembly() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceMkAssembly();
	}

	@Override
	public Integer stageinsertAssemblyMandals(List<Constituency> constObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertAssemblyMandals(constObj);
	}

	@Override
	public Integer DeleteStageAssemblyMandals(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageAssemblyMandals(flag);
	}

	@Override
	public List<Constituency> sourceMkAssemblyMandals() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceMkAssemblyMandals();
	}

	@Override
	public Integer stageinsertVillages(List<Village> villageObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertVillages(villageObj);
	}

	@Override
	public Integer DeleteStageVillages(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageVillages(flag);
	}

	@Override
	public List<Village> sourceMkVillages() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceMkVillages();
	}

	@Override
	public List<Habitations> sourceMkHabitations() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceMkHabitations();
	}

	@Override
	public Integer DeleteStageHabitations(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageHabitations(flag);
	}

	@Override
	public Integer stageinsertHabitations(List<Habitations> habitationObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertHabitations(habitationObj);
	}

	@Override
	public List<Tanks> sourceMkTanksInfo() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceMkTanksInfo();
	}

	@Override
	public Integer DeleteStageTanks(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageTanks(flag);
	}

	@Override
	public Integer stageinsertTanksInfo(List<Tanks> tanksObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertTanksInfo(tanksObj);
	}

	@Override
	public List<Map<String, Object>> generalqueryformisviews(String generalquery) {
		// TODO Auto-generated method stub
		return iad.generalqueryformisviews(generalquery);
	}

	@Override
	public List<Map<String, Object>> generalqueryforstagetims(String generalquery) {
		// TODO Auto-generated method stub
		return iad.generalqueryforstagetims(generalquery);
	}

	@Override
	public List<Habitations> getHabitations(Integer dcode, Integer mcode, Integer vcode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getHabitations(dcode, mcode, vcode);
	}

	@Override
	public List<Employee> sourceHrmsEmpMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsEmpMst();
	}

	@Override
	public Integer stageinsertEmpMst(List<Employee> empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertEmpMst(empObj);
	}

	@Override
	public Integer DeleteStageEmpMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageEmpMst(flag);
	}

	@Override
	public List<Employee> sourceHrmsAdditionalCharge() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsAdditionalCharge();
	}

	@Override
	public Integer DeleteStageAdditionalCharge(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageAdditionalCharge(flag);
	}

	@Override
	public Integer stageinsertAdditionalCharge(List<Employee> empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertAdditionalCharge(empObj);
	}

	@Override
	public List<Tanks> getTankSectionMap(User user) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankSectionMap(user);
	}

	@Override
	public Integer DeleteStageDesignationMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageDesignationMst(flag);
	}

	@Override
	public List<Designation> sourceHrmsDesignationMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsDesignationMst();
	}

	@Override
	public Integer stageinsertDesignationMst(List<Designation> desObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertDesignationMst(desObj);
	}

	@Override
	public List<Employee> sourceHrmsPreaentPostEmp() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsPreaentPostEmp();
	}

	@Override
	public Integer DeleteStagePresentPostEMP(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStagePresentPostEMP(flag);
	}

	@Override
	public Integer stageinsertPresentPostEmp(List<Employee> empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertPresentPostEmp(empObj);
	}

	@Override
	public Integer stageinsertSubpostsEmp(List<Employee> empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertSubpostsEmp(empObj);
	}

	@Override
	public List<Employee> sourceHrmsSubposts() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsSubposts();
	}

	@Override
	public Integer DeleteStageSubPosts(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageSubPosts(flag);
	}

	@Override
	public Integer stageinsertUnitMst(List<Unit> unitObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertUnitMst(unitObj);
	}

	@Override
	public Integer DeleteStageUnitMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageUnitMst(flag);
	}

	@Override
	public List<Unit> sourceHrmsUnitMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsUnitMst();
	}

	@Override
	public Integer DeleteStageCircleMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageCircleMst(flag);
	}

	@Override
	public List<Circle> sourceHrmsCircleMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsCircleMst();
	}

	@Override
	public Integer stageinsertCircleMst(List<Circle> circleObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertCircleMst(circleObj);
	}

	@Override
	public List<Division> sourceHrmsDivisionMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsDivisionMst();
	}

	@Override
	public Integer stageinsertDivisionMst(List<Division> divisionObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertDivisionMst(divisionObj);
	}

	@Override
	public Integer DeleteStageDivisionMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageDivisionMst(flag);
	}

	@Override
	public Integer stageinsertSubDivisionMst(List<Subdivision> subdivisionObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertSubDivisionMst(subdivisionObj);
	}

	@Override
	public Integer DeleteStageSubDivisionMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageSubDivisionMst(flag);
	}

	@Override
	public List<Subdivision> sourceHrmsSubDivisionMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsSubDivisionMst();
	}

	@Override
	public List<Sectiondata> sourceHrmsSectionMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsSectionMst();
	}

	@Override
	public Integer DeleteStageSectionMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageSectionMst(flag);
	}

	@Override
	public Integer stageinsertSectionMst(List<Sectiondata> sectiondataObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertSectionMst(sectiondataObj);
	}

	@Override
	public Integer stageinsertUserMst(List<User> usObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertUserMst(usObj);
	}

	@Override
	public Integer DeleteStageUsers(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageUsers(flag);
	}

	@Override
	public List<User> sourceHrmsUserEmp() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsUserEmp();
	}

	@Override
	public Integer getbaseupdatesUnitMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesUnitMaster();
	}

	@Override
	public Integer getbaseupdatesTanksInfo() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesTanksInfo();
	}

	@Override
	public Integer getbaseupdatesUsersMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesUsersMaster();
	}

	@Override
	public Integer getbaseupdatesDesgMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesDesgMaster();
	}

	@Override
	public Integer getbaseupdatesEmpMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesEmpMaster();
	}

	@Override
	public Integer getbaseupdatesPPeMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesPPeMaster();
	}

	@Override
	public Integer getbaseupdatesAddnlChargeMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesAddnlChargeMaster();
	}

	@Override
	public Integer getbaseupdatesSubpostsMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesSubpostsMaster();
	}

	@Override
	public Integer getbaseupdatesSectionMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesSectionMaster();
	}

	@Override
	public Integer getbaseupdatesSubDivisionMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesSubDivisionMaster();
	}

	@Override
	public Integer getbaseupdatesDivisionMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesDivisionMaster();
	}

	@Override
	public Integer getbaseupdatesCircleMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesCircleMaster();
	}

	@Override
	public List<EmployeeDiversion> sourceHrmsEmpDiversion() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.sourceHrmsEmpDiversion();
	}

	@Override
	public Integer stageinsertEmpDiversion(List<EmployeeDiversion> empObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.stageinsertEmpDiversion(empObj);
	}

	@Override
	public Integer DeleteStageEmpDiversion(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStageEmpDiversion(flag);
	}

	@Override
	public List<Map<String, Object>> generalqueryforstagehrms(String generalquery) {
		// TODO Auto-generated method stub
		return iad.generalqueryforstagehrms(generalquery);
	}

	@Override

	public Integer updateSluicenamebyid(MiTankInspect miobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateSluicenamebyid(miobj);
	}
	
	@Override
	public Integer updateMst1remarksByreviewid(MiTankInspect miobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateMst1remarksByreviewid(miobj);
	}


	@Override
	public MiTankInspect getMst1remarksbyreviewId(Integer miInpsectMst1IdReviewId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getMst1remarksbyreviewId(miInpsectMst1IdReviewId);
	}

	public Integer getbaseupdatesEmpdivMaster() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getbaseupdatesEmpdivMaster();
	}

	@Override
	public MiTankInspect getCapacityremarksbyreviewId(Integer mitankCapacityReviewId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getCapacityremarksbyreviewId(mitankCapacityReviewId);
	}

	@Override
	public Integer updateMstCapacityremarksByreviewid(MiTankInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateMstCapacityremarksByreviewid(miObj);
	}

	@Override
	public MstOutputWithFlag insertForm20Data(List<MiTankformData> miFormObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertForm20Data(miFormObj);
	}

	@Override
	public Integer insertForm20Detail(List<MiTankformData> miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertForm20Detail(miformObj);
	}

	@Override
	public Integer getCountOfform20Docs() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getCountOfform20Docs();
	}

	@Override
	public Integer insertFormDocuments(MiTankformData midocObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertFormDocuments(midocObj);
	}

	@Override
	public List<MiTankformData> getFrmIrrSrcList() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getFrmIrrSrcList();
	}

	@Override
	public List<MiTankformData> getFrmSentList(MiTankformData miobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getFrmSentList( miobj);
	}

	@Override
	public List<MiTankformData> getFrmDataList(Integer formDataId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getFrmDataList(formDataId);
	}

	@Override
	public List<MiTankformData> getFrmDetailList(Integer formDataId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getFrmDetailList(formDataId);
	}

	@Override
	public List<MiTankFormDocs> getFrmDocsList(Integer formDataId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getFrmDocsList(formDataId);
	}

	@Override
	public Integer updateForm20Data(List<MiTankformData> miFormObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateForm20Data(miFormObj);
	}

	@Override
	public Integer updateForm20Detail(List<MiTankformData> miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateForm20Detail(miformObj);
	}

	@Override
	public Integer deleteFormdocsbydocId(MiTankFormDocs miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteFormdocsbydocId(miformObj);
	}

	@Override
	public Integer deleteFormdocs(MiTankformData miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteFormdocs(miformObj);
	}

	@Override
	public Integer deleteFormDetail(MiTankformData miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteFormDetail(miformObj);
	}

	@Override
	public Integer deleteFormData(MiTankformData miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteFormData(miformObj);
	}

	@Override
	public Integer insertForm20approv(List<MiTankformData> miFormObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertForm20approv(miFormObj);
	}

	@Override
	public Integer deleteFormdetailsbydetailId(List<MiTankformData> miformObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteFormdetailsbydetailId(miformObj);
	}

	@Override
	public List<TankFeedDetails> getTankFedUnitMap(User user) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankFedUnitMap(user);
	}

	@Override
	public List<TankFeedDetails> getTankFedCircleMap(User user) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankFedCircleMap(user);
	}

	@Override
	public List<TankFeedDetails> getTankFedDivisionMap(User user) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankFedDivisionMap(user);
	}

	@Override
	public List<TankFeedDetails> getTankFedSubdivisionMap(User user) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankFedSubdivisionMap(user);
	}

	@Override
	public Integer insertResAnn1Mst1Remarks(ReservoirInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertResAnn1Mst1Remarks(miObj);
	}

	@Override
	public List<Map<String, Object>> generalqueryformtanksview(String generalquery) {
		// TODO Auto-generated method stub
		return iad.generalqueryformtanksview(generalquery);
	}

	@Override
	public List<Map<String, Object>> generalqueryforresultirrinv(String generalquery) {
		// TODO Auto-generated method stub
		return iad.generalqueryforresultirrinv(generalquery);
	}

	@Override
	public List<Map<String, Object>> generalqueryforresultpmsstage(String generalquery) {
		// TODO Auto-generated method stub
		return iad.generalqueryforresultpmsstage(generalquery);
	}

	@Override
	public Integer insertform20CanalsLocation(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertform20CanalsLocation(canalObj);
	}

	@Override
	public Integer updateform20CanalsLocation(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateform20CanalsLocation(canalObj);
	}

	@Override
	public Integer insertform20CanalsunitMap(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertform20CanalsunitMap(canalObj);
	}

	@Override
	public Integer updateform20ReservoirLocation(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateform20ReservoirLocation(resObj);
	}

	@Override
	public Integer insertform20ReservoirUnitMap(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertform20ReservoirUnitMap(resObj);
	}

	@Override
	public List<ReservoirSalient> getform20ResLocByResId(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getform20ResLocByResId(resObj);
	}

	@Override
	public List<Canal> getform20CanLocByCanalId(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getform20CanLocByCanalId(canalObj);
	}

	@Override
	public List<Canal> getCanalsByProjectId(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getCanalsByProjectId(canalObj);
	}

	@Override
	public List<ReservoirSalient> getSourcePmsInvResBasic() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getSourcePmsInvResBasic();
	}

	@Override
	public Integer DeleteStagePMSinvRes(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStagePMSinvRes(flag);
	}

	@Override
	public Integer StagePmsinsertReservoir(List<ReservoirSalient> ressalObj) throws InventoryUserException, ParseException {
		// TODO Auto-generated method stub
		return iad.StagePmsinsertReservoir(ressalObj);
	}

	@Override
	public Integer StagePmsinsertPackages(List<Packages> projObj) throws InventoryUserException, ParseException {
		// TODO Auto-generated method stub
		return iad.StagePmsinsertPackages(projObj);
	}

	@Override
	public Integer DeleteStagePMSinvPackages(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStagePMSinvPackages(flag);
	}

	@Override
	public List<Packages> getSourcePmsInvPackages() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getSourcePmsInvPackages();
	}

	@Override
	public Integer StagePmsinsertProjUnitMap(List<Project> projObj) throws InventoryUserException, ParseException {
		// TODO Auto-generated method stub
		return iad.StagePmsinsertProjUnitMap(projObj);
	}

	@Override
	public Integer DeleteStagePMSinvprojUnitMap(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStagePMSinvprojUnitMap(flag);
	}

	@Override
	public List<Project> getSourcePmsInvProjectUnitMap() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getSourcePmsInvProjectUnitMap();
	}

	@Override
	public List<Project> getSourcePmsInvProjectMst() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getSourcePmsInvProjectMst();
	}

	@Override
	public Integer DeleteStagePMSinvprojMst(Boolean flag) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.DeleteStagePMSinvprojMst(flag);
	}

	@Override
	public Integer StagePmsinsertProjMst(List<Project> projObj) throws InventoryUserException, ParseException {
		// TODO Auto-generated method stub
		return iad.StagePmsinsertProjMst(projObj);
	}

	@Override
	public Integer insertform20Canals(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertform20Canals(canalObj);
	}

	@Override
	public Integer updateform20Canals(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateform20Canals(canalObj);
	}

	@Override
	public List<Canal> getCanalLocationByCanallocId(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getCanalLocationByCanallocId(canalObj);
	}

	@Override
	public List<Canal> getCanalsByProjectedit(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getCanalsByProjectedit(canalObj);
	}

	@Override
	public List<Canal> getCanalsByCanalIdedit(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getCanalsByCanalIdedit(canalObj);
	}

	@Override
	public List<Canal> getCanalsNotInLoc(Canal canalObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getCanalsNotInLoc(canalObj);
	}

	@Override
	public List<Project> getProjectCodesList(Integer projectId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getProjectCodesList(projectId);
	}

	/*@Override
	public Integer insertNrldAnnMst1Remarks(ReservoirInspect miObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertNrldAnnMst1Remarks(miObj);
	}*/

	@Override
	public Integer insertNrldAnninspectMst2(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertNrldAnninspectMst2(resObj);
	}

	@Override
	public MstOutputWithFlag insertNrldAnnMst1(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertNrldAnnMst1(resObj);
	}

	@Override
	public List<ReservoirInspect> getNrldAnnmst2IdByMst1Id(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getNrldAnnmst2IdByMst1Id(mst1Id);
	}

	@Override
	public Integer AddAnnRemarks(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.AddAnnRemarks(resobj);
	}

	@Override
	public Integer AddNrldInspectionInfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.AddNrldInspectionInfo(resobj);
	}

	@Override
	public Integer AddNrldRecommendationInfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.AddNrldRecommendationInfo(resobj);
	}

	@Override
	public List<ReservoirInspect> getResmst2andmst1ByYearFreq(ReservoirInspect reservoirInspect)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResmst2andmst1ByYearFreq(reservoirInspect);
	}

	@Override
	public List<ReservoirInspect> getResInspectInfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResInspectInfo(resObj);
	}

	@Override
	public Integer AddDamHealthStatusInfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.AddDamHealthStatusInfo(resobj);
	}

	@Override
	public List<ReservoirInspect> getDamHealthDetailsBYmst1Id(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getDamHealthDetailsBYmst1Id(resObj);
	}

	@Override
	public List<ReservoirInspect> getDamHealthDetailsBYInspectInfo(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getDamHealthDetailsBYInspectInfo(resObj);
	}

	@Override
	public List<ReservoirInspect> getResInspectInfobyInspectOfficeInfoId(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResInspectInfobyInspectOfficeInfoId(resObj);
	}

	@Override
	public List<ReservoirInspect> getResAnnRecomndbyhealthInspectInfo(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnnRecomndbyhealthInspectInfo(resObj);
	}

	@Override
	public Integer AddActionTakenStatusInfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.AddActionTakenStatusInfo(resobj);
	}

	@Override
	public List<ReservoirInspect> getActionTakenDetailsBYmst1Id(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getActionTakenDetailsBYmst1Id(resObj);
	}

	@Override
	public Integer AddDamInspectphotosInfo(DamInspectDocs damobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.AddDamInspectphotosInfo(damobj);
	}

	@Override
	public Integer getCountOfDamInpsectDocs() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getCountOfDamInpsectDocs();
	}

	@Override
	public Integer insertDamDocuments(ReservoirInspect resdocObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertDamDocuments(resdocObj);
	}

	@Override
	public List<ReservoirInspect> getResDamInspectRemarksByReservoirId(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResDamInspectRemarksByReservoirId(resObj);
	}

	@Override
	public List<DamInspectDocs> getDamInspectPhotosByReservoirId(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getDamInspectPhotosByReservoirId(resObj);
	}

	@Override
	public List<ReservoirSalient> getresDamInfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getresDamInfo(resObj);
	}

	@Override
	public List<ReservoirSalient> getresImpControlLevelInfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getresImpControlLevelInfo(resObj);
	}

	@Override
	public List<ReservoirSalient> getresDaminfoandControlLevelInfo(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getresDaminfoandControlLevelInfo(resObj);
	}

	@Override
	public List<Tanks> getTanksDaminfo(MiTankInspect tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTanksDaminfo(tankObj);
	}

	@Override
	public List<Tanks> getTanksImpControlinfo(MiTankInspect tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTanksImpControlinfo(tankObj);
	}

	@Override
	public Integer updateTankImpControlInfo(Tanks tankobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateTankImpControlInfo(tankobj);
	}

	@Override
	public Integer updateTankDemoInfo(Tanks tankobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return  iad.updateTankDemoInfo(tankobj);
	}

	@Override
	public Integer updateResDemoInfo(ReservoirSalient resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateResDemoInfo(resobj);
	}

	@Override
	public Integer updateResImpControlInfo(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateResImpControlInfo(resObj);
	}

	@Override
	public List<Tanks> getTankinfoandControlLevelInfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankinfoandControlLevelInfo(resObj);
	}

	@Override
	public Integer updateDamConditionStatus(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateDamConditionStatus(resObj);
	}

	@Override
	public Integer deleteAnnRemarksReviewId(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteAnnRemarksReviewId(resobj);
	}

	@Override
	public Integer deleteAnnMst2byMst2Id(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteAnnMst2byMst2Id(resobj);
	}

	@Override
	public Integer deleteAnnRecommendationbyRecommendId(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteAnnRecommendationbyRecommendId(resobj);
	}

	@Override
	public Integer deleteResAnnDocs(DamInspectDocs resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteResAnnDocs(resobj);
	}

	@Override
	public Integer deleteResHealthDetails(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteResHealthDetails(resobj);
	}

	@Override
	public Integer deleteResInspectInfoDetails(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteResInspectInfoDetails(resobj);
	}

	@Override
	public Integer deleteResActionTakeninfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteResActionTakeninfo(resobj);
	}

	@Override
	public Integer UpdateNrldInspectionInfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateNrldInspectionInfo(resobj);
	}

	@Override
	public Integer UpdateNrldAnnmst2Info(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateNrldAnnmst2Info(resobj);
	}

	@Override
	public List<ReservoirInspect> getResDamInspectRemarksByReviewId(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResDamInspectRemarksByReviewId(resObj);
	}

	@Override
	public Integer UpdateNrldDamRemarksinfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateNrldDamRemarksinfo(resobj);
	}

	@Override
	public List<ReservoirInspect> getResAnnRecomndbytankresyear(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnnRecomndbytankresyear(resObj);
	}

	@Override
	public List<ReservoirInspect> getResAnnRecomndbyRecId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResAnnRecomndbyRecId(resObj);
	}

	@Override
	public Integer deleteNrldAnnRecommendationsinfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteNrldAnnRecommendationsinfo(resobj);
	}

	@Override
	public Integer UpdateNrldAnnRecommendationsinfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateNrldAnnRecommendationsinfo(resobj);
	}

	@Override
	public List<ReservoirInspect> getDamHealthDetailsBYHealthId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getDamHealthDetailsBYHealthId(resObj);
	}

	@Override
	public Integer UpdateNrldAnnHealthinfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateNrldAnnHealthinfo(resobj);
	}

	@Override
	public List<ReservoirInspect> getActionTakenDetailsBYActionId(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getActionTakenDetailsBYActionId(resObj);
	}

	@Override
	public Integer updateActionTakenDetailsActionId(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateActionTakenDetailsActionId(resobj);
	}

	@Override
	public List<Tanks> getTankSectionMapNrld(User user) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankSectionMapNrld(user);
	}

	@Override
	public List<ReservoirSalient> getNrldResList(User userObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getNrldResList(userObj);
	}

	@Override
	public List<Project> getNrldProjectList(User user) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getNrldProjectList(user);
	}

	@Override
	public MstOutputWithFlag inserprevtNrldAnnMst1(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.inserprevtNrldAnnMst1(resObj);
	}

	@Override
	public Integer insertPrevNrldAnninspectMst2(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertPrevNrldAnninspectMst2(resObj);
	}

	@Override
	public List<ReservoirInspect> getPrevAnnMst1IdByNewMst1Id(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getPrevAnnMst1IdByNewMst1Id(mst1Id);
	}

	@Override
	public Integer AddPrevNrldInspectionInfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.AddPrevNrldInspectionInfo(resobj);
	}

	@Override
	public Integer AddPrevDamHealthStatusInfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.AddPrevDamHealthStatusInfo(resobj);
	}

	@Override
	public Integer AddPrevAnnRemarks(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.AddPrevAnnRemarks(resobj);
	}

	@Override
	public Integer insertPrevDamDocuments(ReservoirInspect resdocObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertPrevDamDocuments(resdocObj);
	}

	@Override
	public Integer AddPrevNrldRecommendationInfo(ReservoirInspect resobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.AddPrevNrldRecommendationInfo(resobj);
	}

	@Override
	public List<ReservoirInspect> getAnnMst1IdByYearandMonsoonMst1Id(ReservoirInspect resobj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getAnnMst1IdByYearandMonsoonMst1Id(resobj);
	}

	@Override
	public List<ReservoirInspect> getResDamInspectRemarksByMst1Id(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResDamInspectRemarksByMst1Id(resObj);
	}

	@Override
	public List<ReservoirSalient> getInvomResListAdmin(Integer unitId) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getInvomResListAdmin(unitId);
	}

	@Override
	public Integer UpdateResNrldCode(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.UpdateResNrldCode(resObj);
	}

	@Override
	public List<ReservoirInspect> getResPostEmpId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getResPostEmpId(resObj);
	}

	@Override
	public Integer insertRespostaccess(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.insertRespostaccess(resObj);
	}

	@Override
	public Integer deleteRespostaccess(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.deleteRespostaccess(resObj);
	}

	@Override
	public List<Employee> getempdatabyoffice(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getempdatabyoffice(resObj);
	}

	@Override
	public List<ReservoirSalient> getresDamSalientInfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getresDamSalientInfo(resObj);
	}

	@Override
	public Integer updateResSalientInfo9(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateResSalientInfo9(resObj);
	}

	@Override
	public Integer updateResSalientInfo8(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateResSalientInfo8(resObj);
	}

	@Override
	public Integer updateResSalientInfo7(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateResSalientInfo7(resObj);
	}

	@Override
	public Integer updateResSalientInfo5(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateResSalientInfo5(resObj);
	}

	@Override
	public Integer updateResSalientInfo4(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateResSalientInfo4(resObj);
	}

	@Override
	public Integer updateResSalientInfo3(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateResSalientInfo3(resObj);
	}

	@Override
	public Integer updateResSalientInfo2(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateResSalientInfo2(resObj);
	}

	@Override
	public Integer updateResSalientInfo1(ReservoirSalient resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateResSalientInfo1(resObj);
	}

	@Override
	public List<Tanks> getTankDamSalientInfo(MiTankInspect tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getTankDamSalientInfo(tankObj);
	}

	@Override
	public Integer updateTankSalientInfo9(Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateTankSalientInfo9(tankObj);
	}

	@Override
	public Integer updateTankSalientInfo8(Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateTankSalientInfo8(tankObj);
	}

	@Override
	public Integer updateTankSalientInfo7(Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateTankSalientInfo7(tankObj);
	}

	@Override
	public Integer updateTankSalientInfo5(Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateTankSalientInfo5(tankObj);
	}

	@Override
	public Integer updateTankSalientInfo4(Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateTankSalientInfo4(tankObj);
	}

	@Override
	public Integer updateTankSalientInfo3(Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateTankSalientInfo3(tankObj);
	}

	@Override
	public Integer updateTankSalientInfo2(Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateTankSalientInfo2(tankObj);
	}

	@Override
	public Integer updateTankSalientInfo1(Tanks tankObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.updateTankSalientInfo1(tankObj);
	}

	@Override
	public List<MiTankformData> getRepeatedTankResCanalBreachList() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getRepeatedTankResCanalBreachList();
	}

	@Override
	public List<MiTankformData> getRepeatedTankResCanalLDamageist() throws InventoryUserException {
		// TODO Auto-generated method stub
		return iad.getRepeatedTankResCanalLDamageist();
	}

	

	

	




	
	
	

	

	
}
