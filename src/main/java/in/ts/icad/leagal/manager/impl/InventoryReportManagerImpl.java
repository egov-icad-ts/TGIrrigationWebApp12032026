package in.ts.icad.leagal.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.InventoryAdminDAO;
import in.ts.icad.leagal.dao.InventoryReportDAO;
import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.manager.InventoryAdminManager;
import in.ts.icad.leagal.manager.InventoryReportManager;
import in.ts.icad.leagal.model.DamInspectDocs;
import in.ts.icad.leagal.model.InvResAbstract;
import in.ts.icad.leagal.model.MiTankInspect;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.PumpMaintainActivities;
import in.ts.icad.leagal.model.PumpStations;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.ReservoirUnitData;
import in.ts.icad.leagal.model.ScheduleDuty;
import in.ts.icad.leagal.model.Tanks;
import in.ts.icad.leagal.model.User;

@Component
public class InventoryReportManagerImpl implements InventoryReportManager {
	
	@Autowired
	private InventoryReportDAO ird;

	@Override
	public List<InvResAbstract> getResAbstractList() throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResAbstractList();
	}

	@Override
	public List<ReservoirUnitData> getrestotalList(Integer unitId, Integer resStatus) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getrestotalList(unitId, resStatus);
	}

	@Override
	public ReservoirSalient getResInfoBYCode(String rescode) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResInfoBYCode(rescode);
	}

	@Override
	public List<ReservoirUnitData> getresinfoBycodePDF() throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getresinfoBycodePDF();
	}

	@Override
	public List<ReservoirSalient> resinfopdf(Integer unitId, Integer resStatus) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.resinfopdf(unitId, resStatus);
	}
	
	@Override
	public List<MiTankInspect> getMiTankChecksAbstract(MiTankInspect miinspect)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankChecksAbstract(miinspect);
	}

	@Override
	public List<MiTankInspect> getMiTankChecksAbstractDetail(
			MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankChecksAbstractDetail(miinspect);
	}

	@Override
	public List<MiTankInspect> getMiTankChecksTankInfo(MiTankInspect miinspect)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankChecksTankInfo(miinspect);
	}

	@Override
	public List<MiTankInspect> getMiTankChecksEmbInfo(MiTankInspect miinspect)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankChecksEmbInfo(miinspect);
	}

	@Override
	public List<InvResAbstract> getInvomResAbstractList(ReservoirInspect reservoirObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getInvomResAbstractList(reservoirObj);
	}

	@Override
	public List<ReservoirInspect> getinvomrestotalList(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getinvomrestotalList(resObj);
	}

	@Override
	public List<ReservoirUnitData> getinvomresann1resInfobyrescode(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getinvomresann1resInfobyrescode(resObj);
	}

	@Override
	public List<ReservoirInspect> getResAnn1tabsInfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResAnn1tabsInfo(resObj)	;
		
	
	}

	@Override
	public List<InvResAbstract> getResAbstractAnn2List(ReservoirInspect reservoirObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResAbstractAnn2List(reservoirObj);
	}

	@Override
	public List<ReservoirUnitData> getinvomresann2resInfobyrescode(Integer mst1Id)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getinvomresann2resInfobyrescode(mst1Id);
	}

	@Override
	public List<ReservoirInspect> getResAnn2tabsInfo(Integer mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResAnn2tabsInfo(mst1Id);
	}

	@Override
	public List<ScheduleDuty> getScheduledutyaeedaily(ScheduleDuty scObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getScheduledutyaeedaily(scObj);
	}

	@Override
	public List<ReservoirUnitData> getschaeedailyresinfo(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getschaeedailyresinfo(resObj);
	}

	@Override
	public List<ScheduleDuty> getSchInspectinfo(ScheduleDuty schObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getSchInspectinfo(schObj);
	}

	@Override
	public List<PumpMaintainActivities> getpumpmaintainActivity(PumpMaintainActivities pmpObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getpumpmaintainActivity(pmpObj);
	}

	@Override
	public List<PumpStations> getpumpmaintainpumpinfo(PumpStations pumpObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getpumpmaintainpumpinfo(pumpObj);
	}

	@Override
	public List<PumpMaintainActivities> getpumpmaintainInspectinfo(PumpMaintainActivities pumpObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getpumpmaintainInspectinfo(pumpObj);
	}

	@Override
	public List<MiTankInspect> getInnoutBytankIdyear(Long tankId, Integer year) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getInnoutBytankIdyear(tankId, year);
	}

	@Override
	public List<MiTankInspect> getMiRepairsbytankidyear(Long tankId, Integer year) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiRepairsbytankidyear(tankId, year);
	}

	@Override
	public List<MiTankInspect> getMiCapacityTankIdYear(Long tankId, Integer year) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiCapacityTankIdYear(tankId, year);
	}

	@Override
	public List<MiTankInspect> getMiTankUnitAbstract(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankUnitAbstract(miinspect);
	}
	
	@Override
	public List<MiTankformData> getMiTankFormAbstractDetail(MiTankformData miobj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankFormAbstractDetail(miobj);
	}

	@Override
	public List<MiTankInspect> getMiTankUnitAbstractDetail(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankUnitAbstractDetail(miinspect);
	}

	@Override
	public List<MiTankInspect> getMiTankCapAyacutAbstract(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankCapAyacutAbstract(miinspect);
	}
	
	@Override
	public MiTankformData getform20TankDataByIdPdf(MiTankformData  formData) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getform20TankDataByIdPdf(formData);
	}
	
	@Override
	public List<MiTankformData> getform20TankDetailListByIdPdf(MiTankformData  formData) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getform20TankDetailListByIdPdf(formData);
	}
	
	@Override
	public List<MiTankformData> getMiTankForm20Abstract(MiTankformData miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankForm20Abstract(miinspect);
	}
	
	@Override
	public List<MiTankformData> getForm20SelectYear() throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getForm20SelectYear();
	}
	
	@Override
	public List<MiTankInspect> getmiTankSelectYear() throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getmiTankSelectYear();
	}

	@Override
	public List<MiTankInspect> getMiTankCapAayacutDetail(MiTankInspect miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankCapAayacutDetail(miinspect);
	}

	@Override
	public List<MiTankFormDocs> getForm20AllDocs(MiTankformData  formData)  throws InventoryUserException  {
		// TODO Auto-generated method stub
		return ird.getForm20AllDocs(formData);
	}

	@Override
	public List<ReservoirInspect> getResChecksCategory() throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResChecksCategory();
	}

	@Override
	public List<ReservoirInspect> getResChecks() throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResChecks();
	}

	@Override
	public List<ReservoirInspect> getResAnn1mst2(Integer resInspectAnn1mst1Id) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResAnn1mst2(resInspectAnn1mst1Id);
	}

	@Override
	public List<MiTankformData> getMiTankForm20DistrictAbstract(MiTankformData miinspect)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankForm20DistrictAbstract(miinspect);
	}

	
	//start of nrld
	@Override
	public List<ReservoirInspect> getResAnnRecomndbymst1(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResAnnRecomndbymst1(resObj);
	}
// end of nrld

	@Override
	public List<ReservoirInspect> getResInspectInfobyUnitId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResInspectInfobyUnitId(resObj);
	}

	@Override
	public List<ReservoirInspect> getResDamInspectRemarksByresmst1Id(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResDamInspectRemarksByresmst1Id(resObj);
	}

	@Override
	public List<ReservoirInspect> getDamHealthDetailsBYmst1IdReport(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getDamHealthDetailsBYmst1IdReport(resObj);
	}

	@Override
	public List<DamInspectDocs> getDamInspectPhotosByResInspectMst1Id(DamInspectDocs resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getDamInspectPhotosByResInspectMst1Id(resObj);
	}

	@Override
	public List<ReservoirInspect> getinvomrestotalnrldresList(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getinvomrestotalnrldresList(resObj);
	}

	@Override
	public List<InvResAbstract> getInvomResEEAbstractList(ReservoirInspect reservoirObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getInvomResEEAbstractList(reservoirObj);
	}

	@Override
	public List<InvResAbstract> getInvomResCategorywiseAbstractList(ReservoirInspect reservoirObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getInvomResCategorywiseAbstractList(reservoirObj);
	}

	@Override
	public List<ReservoirInspect> getinvomresCattotalList(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getinvomresCattotalList(resObj);
	}

	@Override
	public List<ReservoirInspect> getResCategoryInspectInfobyUnitId(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResCategoryInspectInfobyUnitId(resObj);
	}

	@Override
	public List<InvResAbstract> getInvomCategoryResEEAbstractList(ReservoirInspect reservoirObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getInvomCategoryResEEAbstractList(reservoirObj);
	}

	@Override
	public List<ReservoirInspect> getAllrestotalnrldresList(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getAllrestotalnrldresList(resObj);
	}

	@Override
	public List<ReservoirInspect> getResHealthInfobyUnitId(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getResHealthInfobyUnitId(resObj);
	}

	@Override
	public List<ReservoirSalient> getDamSalientDetailsBYmst1IdReport(ReservoirInspect resObj)
			throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getDamSalientDetailsBYmst1IdReport(resObj);
	}

	@Override
	public List<Tanks> getTanksSalientDetailsBYmst1IdReport(ReservoirInspect resObj) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getTanksSalientDetailsBYmst1IdReport(resObj);
	}

	@Override
	public List<ReservoirInspect> getDamsafetySelectYear() throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getDamsafetySelectYear();
	}

	@Override
	public List<MiTankformData> getMiTankFDRAbstract(MiTankformData miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankFDRAbstract(miinspect);
	}

	@Override
	public List<MiTankformData> getMiTankFDRAbstractDetail(MiTankformData miinspect) throws InventoryUserException {
		// TODO Auto-generated method stub
		return ird.getMiTankFDRAbstractDetail(miinspect);
	}


}
