package in.ts.icad.leagal.dao;

import java.util.List;

import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.DamInspectDocs;
import in.ts.icad.leagal.model.InvResAbstract;
import in.ts.icad.leagal.model.MiTankInspect;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.PumpMaintainActivities;
import in.ts.icad.leagal.model.PumpStations;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.ReservoirUnitData;
import in.ts.icad.leagal.model.ScheduleDuty;
import in.ts.icad.leagal.model.Tanks;
import in.ts.icad.leagal.model.User;

public interface InventoryReportDAO {
	
	public List<InvResAbstract> getResAbstractList() throws InventoryUserException;
	public List<ReservoirUnitData> getrestotalList(Integer unitId, Integer resStatus) throws InventoryUserException;
	public ReservoirSalient getResInfoBYCode(String rescode) throws InventoryUserException;
	
	public List<ReservoirUnitData> getresinfoBycodePDF() throws InventoryUserException ;
	public List<ReservoirSalient> resinfopdf(Integer unitId, Integer resStatus) throws InventoryUserException;
	
	
	/*o and m*/
	public List<MiTankInspect> getMiTankChecksAbstractDetail(MiTankInspect miinspect) throws InventoryUserException;
	public List<MiTankInspect> getMiTankChecksAbstract(MiTankInspect miinspect) throws InventoryUserException;
	public List<MiTankInspect> getMiTankChecksTankInfo(MiTankInspect miinspect) throws InventoryUserException;
	
	public List<MiTankInspect> getMiTankChecksEmbInfo(MiTankInspect miinspect) throws InventoryUserException ;
	
	public List<InvResAbstract> getInvomResAbstractList(ReservoirInspect reservoirObj) throws InventoryUserException;
	
	public List<ReservoirInspect> getinvomrestotalList(ReservoirInspect resObj) throws InventoryUserException;
	public List<ReservoirUnitData> getinvomresann1resInfobyrescode(ReservoirInspect resObj) throws InventoryUserException;
	public List<ReservoirInspect> getResAnn1tabsInfo(ReservoirInspect resObj) throws InventoryUserException ;
	public List<InvResAbstract> getResAbstractAnn2List(ReservoirInspect reservoirObj) throws InventoryUserException;
	public List<ReservoirUnitData> getinvomresann2resInfobyrescode(Integer mst1Id) throws InventoryUserException;
	public List<ReservoirInspect> getResAnn2tabsInfo(Integer mst1Id) throws InventoryUserException;
	
	public List<ScheduleDuty> getScheduledutyaeedaily(ScheduleDuty scObj) throws InventoryUserException;
	public List<ReservoirUnitData> getschaeedailyresinfo(ReservoirInspect resObj) throws InventoryUserException;
	
	public List<ScheduleDuty> getSchInspectinfo(ScheduleDuty schObj) throws InventoryUserException;
	
	public List<PumpMaintainActivities> getpumpmaintainActivity(PumpMaintainActivities pmpObj) throws InventoryUserException;
	
	public List<PumpStations> getpumpmaintainpumpinfo(PumpStations pumpObj) throws InventoryUserException;
	public List<PumpMaintainActivities> getpumpmaintainInspectinfo(PumpMaintainActivities pumpObj) throws InventoryUserException;
	
	public List<MiTankInspect> getInnoutBytankIdyear(Long tankId , Integer year) throws InventoryUserException;
	public List<MiTankInspect> getMiRepairsbytankidyear(Long tankId,Integer year) throws InventoryUserException ;
	public List<MiTankInspect> getMiCapacityTankIdYear(Long tankId,Integer year ) throws InventoryUserException;
	public List<MiTankInspect> getMiTankUnitAbstract(MiTankInspect miinspect) throws InventoryUserException;
	
	public List<MiTankInspect> getMiTankUnitAbstractDetail(MiTankInspect miinspect) throws InventoryUserException;
	
	public List<MiTankInspect> getMiTankCapAyacutAbstract(MiTankInspect miinspect) throws InventoryUserException ;
	public List<MiTankInspect> getMiTankCapAayacutDetail(MiTankInspect miinspect) throws InventoryUserException ;
	public List<MiTankformData> getMiTankFormAbstractDetail(MiTankformData miobj) throws InventoryUserException;
	public List<MiTankformData> getMiTankForm20Abstract(MiTankformData miinspect) throws InventoryUserException;
	public MiTankformData getform20TankDataByIdPdf(MiTankformData formData) throws InventoryUserException;
	public List<MiTankformData> getform20TankDetailListByIdPdf(MiTankformData formData) throws InventoryUserException;
	public List<MiTankFormDocs> getForm20AllDocs(MiTankformData formData)throws InventoryUserException;
	public List<MiTankformData> getForm20SelectYear() throws InventoryUserException;
	public List<MiTankInspect> getmiTankSelectYear() throws InventoryUserException;
	
	public List<ReservoirInspect> getResChecksCategory() throws InventoryUserException;

	public List<ReservoirInspect> getResChecks() throws InventoryUserException;;

	public List<ReservoirInspect> getResAnn1mst2(Integer resInspectAnn1mst1Id) throws InventoryUserException;
	
	public List<MiTankformData> getMiTankForm20DistrictAbstract(MiTankformData miinspect) throws InventoryUserException;

	// start of nrld
	
	public List<ReservoirInspect> getResAnnRecomndbymst1(ReservoirInspect resObj) throws InventoryUserException;
	public List<ReservoirInspect> getResInspectInfobyUnitId(ReservoirInspect resObj) throws InventoryUserException;
	public List<ReservoirInspect> getResDamInspectRemarksByresmst1Id(ReservoirInspect resObj) throws InventoryUserException;
	
	public List<ReservoirInspect> getDamHealthDetailsBYmst1IdReport(ReservoirInspect resObj) throws InventoryUserException;
	
	public List<DamInspectDocs> getDamInspectPhotosByResInspectMst1Id(DamInspectDocs resObj) throws InventoryUserException;
	
	public List<ReservoirInspect> getinvomrestotalnrldresList(ReservoirInspect resObj) throws InventoryUserException;
	// end of nrld
	public List<InvResAbstract> getInvomResEEAbstractList(ReservoirInspect reservoirObj) throws InventoryUserException;
	
	public List<InvResAbstract> getInvomResCategorywiseAbstractList(ReservoirInspect reservoirObj) throws InventoryUserException;
	
	public List<ReservoirInspect> getinvomresCattotalList(ReservoirInspect resObj) throws InventoryUserException;
	
	public List<ReservoirInspect> getResCategoryInspectInfobyUnitId(ReservoirInspect resObj) throws InventoryUserException;
	
	public List<InvResAbstract> getInvomCategoryResEEAbstractList(ReservoirInspect reservoirObj) throws InventoryUserException;
	
	public List<ReservoirInspect> getAllrestotalnrldresList(ReservoirInspect resObj) throws InventoryUserException;
	
	public List<ReservoirInspect> getResHealthInfobyUnitId(ReservoirInspect resObj) throws InventoryUserException;
	
	public List<ReservoirSalient> getDamSalientDetailsBYmst1IdReport(ReservoirInspect resObj) throws InventoryUserException;
	
	public List<Tanks> getTanksSalientDetailsBYmst1IdReport(ReservoirInspect resObj) throws InventoryUserException;
	
	public List<ReservoirInspect> getDamsafetySelectYear() throws InventoryUserException;
	public List<MiTankformData> getMiTankFDRAbstract(MiTankformData miinspect) throws InventoryUserException;
	public List<MiTankformData> getMiTankFDRAbstractDetail(MiTankformData miinspect) throws InventoryUserException;
}
