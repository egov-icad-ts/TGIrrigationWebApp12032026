package in.ts.icad.leagal.manager;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.exception.InventoryUserException;
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
import in.ts.icad.leagal.model.ReservoirAyacut;
import in.ts.icad.leagal.model.ReservoirGates;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirMaintenanceCategory;
import in.ts.icad.leagal.model.ReservoirMaintenanceChecks;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.ReservoirUnitData;
import in.ts.icad.leagal.model.MitankChecks;
import in.ts.icad.leagal.model.MitankComps;
import in.ts.icad.leagal.model.MstOutputWithFlag;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.PumpCommonData;
import in.ts.icad.leagal.model.PumpMaintainActivities;
import in.ts.icad.leagal.model.PumpOperationInstructions;
import in.ts.icad.leagal.model.PumpOperationType;
import in.ts.icad.leagal.model.PumpPumpsData;
import in.ts.icad.leagal.model.PumpStations;
import in.ts.icad.leagal.model.ScheduleDuty;
import in.ts.icad.leagal.model.Sectiondata;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.TankFeedDetails;
import in.ts.icad.leagal.model.Tanks;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.model.Village;

public interface InventoryAdminManager {
	
	String inserReservoir(final ReservoirSalient ressalObj) throws InventoryUserException;
	public List<ReservoirSalient> getResList() throws InventoryUserException;
	public ReservoirSalient getResListBYCode(String resocde) throws InventoryUserException;
	public Integer inserResUnitMap(final ReservoirUnitData resunitObj) throws InventoryUserException;
	public List<ReservoirUnitData> getResUnitMapListById(Integer unitId) throws InventoryUserException;
	public Integer deleteReservoirInfo(final ReservoirSalient ressalObj) throws InventoryUserException;
	 public Integer editReservoirInfo(final ReservoirSalient ressalObj) throws InventoryUserException;
	 
	 public Integer DeleteResUnitMapById(final ReservoirUnitData resunitObj) throws InventoryUserException;
	 public Integer UpdateResUnitMapById(final ReservoirUnitData resunitObj) throws InventoryUserException;
	 public ReservoirUnitData getResUnitMapListByMapId(Integer resunitId) throws InventoryUserException;
	 public List<ReservoirUnitData> getResUnitMapListByResCode(String rescode) throws InventoryUserException;
	 public Integer insertResRegulator(final ReservoirGates ressalObj) throws InventoryUserException;
	 public Integer insertInvAyacutByResReg(final ReservoirAyacut resObj) throws InventoryUserException;
	 public List<ReservoirGates> getResRegList(String resCode) throws InventoryUserException ;
	 public Integer insertResGates(final ReservoirGates ressalObj) throws InventoryUserException;
	 public ReservoirGates getResRegByRegCode(String regCode) throws InventoryUserException;
	 public List<ReservoirGates> getResGateList(String resCode) throws InventoryUserException ;
	 public List<ReservoirAyacut> getResRegAyacutList(String resCode) throws InventoryUserException;
	 public ReservoirAyacut getResAyacutById(Integer ayacutId) throws InventoryUserException;
	 public ReservoirGates getResGateByGateId(Integer gateId) throws InventoryUserException;
	 

public Integer UpdateResGateById(final ReservoirGates ressalObj) throws InventoryUserException;
public Integer DeleteResGateById(final ReservoirGates resObj) throws InventoryUserException;
public Integer UpdateResAyacutById(final ReservoirAyacut resObj) throws InventoryUserException;
public Integer DeleteResAyacutById(final ReservoirAyacut resunitObj) throws InventoryUserException;
public List<Map<String, Object>> generalqueryforresult(String generalquery);


public List<PumpCommonData> getPumpsCommonList() throws InventoryUserException;

public List<PumpPumpsData> getPumpsdataList() throws InventoryUserException;

public List<PumpMaintainActivities> getPumpMaintainActivities() throws InventoryUserException;

public List<MitankChecks> getMitankChecks() throws InventoryUserException;
public List<MitankComps> getMiTankComps() throws InventoryUserException;

public List<PumpOperationType> getPumpOperationTypes() throws InventoryUserException ;
public List<PumpOperationInstructions> getPumpOperationInstructions() throws InventoryUserException;

public List<ScheduleDuty> getReservoirScheduleofDuties() throws InventoryUserException;

public Integer insertMiinspect(final List<MiTankInspect> miObj) throws InventoryUserException;
public List<Tanks> getTanks(Habitations habitObj) throws InventoryUserException;
public List<ReservoirMaintenanceChecks> getResCheckAnn1() throws InventoryUserException ;
public List<ReservoirMaintenanceCategory> getResCatAnn2() throws InventoryUserException ;

public Integer insertResinspect(final List<ReservoirInspect> resObj) throws InventoryUserException;

public List<ReservoirSalient> getInvomResList(Integer unitId) throws InventoryUserException;

public Integer  insertResinspectann2(final List<ReservoirInspect> resObj) throws InventoryUserException ;

public Integer  insertResDamDutyinspect(final List<ScheduleDuty> resObj) throws InventoryUserException ;


public List<PumpStations> getBasinData( ) throws InventoryUserException;
public List<PumpStations> getPumpLinks( ) throws InventoryUserException;
public List<PumpStations> getPumpStations(Integer pumpLinkId ) throws InventoryUserException;


public Integer  insertpumpMainActivityInspect(final List<PumpMaintainActivities> pumpObj) throws InventoryUserException;

public Integer insertMiinspectMst2(final List<MiTankInspect> miObj) throws InventoryUserException;
public MstOutputWithFlag insertMiinspectMst1(final List<MiTankInspect> miObj) throws InventoryUserException;
public Integer insertMiinspectRepairs(final List<MiTankInspect> miObj) throws InventoryUserException;

//public Integer insertMiinspectInOut(final List<MiTankInspect> miObj) throws InventoryUserException;

public Integer insertMiinspectCapacity(final List<MiTankInspect> miObj) throws InventoryUserException;

public List<MiTankInspect> getMimst2IdByMst1Id(Integer mst1Id) throws InventoryUserException;
public List<MiTankInspect> getMimst2IdByYearFreq(Integer year, Long tankId, Integer miFreqId) throws InventoryUserException;

//public List<MiTankInspect> selectMiInoutBytankId( Long tankId) throws InventoryUserException;

public List<MiTankInspect> getMiRepairs(Long tankId) throws InventoryUserException;
public List<MiTankInspect> getMiCapacity(Long tankId) throws InventoryUserException;

public List<Map<String, Object>> generalqueryforinvomresult(String generalquery);

public List<EmpApprove> getEmployeeApprove(EmpApprove empObj) throws InventoryUserException ;

public MstOutputWithFlag insertResAnn2Mst1(final List<ReservoirInspect> resObj) throws InventoryUserException;
public Integer insertresAnn2inspectMst2(final List<ReservoirInspect> resObj) throws InventoryUserException;

public List<ReservoirInspect> getResAnn2mst2IdByMst1Id(Integer mst1Id) throws InventoryUserException;

public Integer insertResRecommend(final List<ReservoirInspect> resObj) throws InventoryUserException;
public Integer insertResHealth(final List<ReservoirInspect> resObj) throws InventoryUserException;
public Integer insertResActiontaken(final List<ReservoirInspect> resObj) throws InventoryUserException;

public List<ReservoirInspect> getResAnn2mst2InspectData(Integer year, String rescode, Integer frequency_oper) throws InventoryUserException;

public List<ReservoirInspect> getResAnn2health(String rescode) throws InventoryUserException;

public List<ReservoirInspect> getResAnn2Recommendations(String rescode) throws InventoryUserException;

public List<ReservoirInspect> getResAnn2latesthealth(String rescode) throws InventoryUserException;
public List<ReservoirInspect> getResAnn2latestRecommend(String rescode) throws InventoryUserException;
public List<ReservoirInspect> getResAnn2ActionTakenData(String rescode) throws InventoryUserException;

public MstOutputWithFlag insertResAnn1Mst1(final List<ReservoirInspect> resObj) throws InventoryUserException;
public Integer insertresAnn1inspectMst2(final List<ReservoirInspect> resObj) throws InventoryUserException;

public List<ReservoirInspect> getResAnn1mst2IdByMst1Id(Integer mst1Id) throws InventoryUserException;

public List<ReservoirInspect> getResAnn1mst2InspectData(Integer year, Integer reservoirId, Integer frequency_oper) throws InventoryUserException;

public Integer insertMiTankFeedDetails(final List<MiTankInspect> miObj) throws InventoryUserException;
public List<MiTankInspect> getMiTankFeedData(Long tankId) throws InventoryUserException;

public Integer insertMiTankFeedRemarks(final MiTankInspect miObj) throws InventoryUserException;
public List<MiTankInspect> getMiTankFeedRemarks (Long tankId,Integer empId) throws InventoryUserException;

//public List<MiTankInspect> getMiTankInoutFlowRemarks (Long tankId,Integer empId) throws InventoryUserException;
//public Integer insertMiTankInOutFlowRemarks(final MiTankInspect miObj) throws InventoryUserException;
public List<MiTankInspect> getMiTankRepairsRemarks (Long tankId,Long postId) throws InventoryUserException;
public Integer insertMiTankRepairsRemarks(final MiTankInspect miObj) throws InventoryUserException;

public List<MiTankInspect> getMiTankCapacityRemarks (Long tankId,Long postId) throws InventoryUserException;

public Integer insertMiTankCapacityRemarks(final MiTankInspect miObj) throws InventoryUserException;


public List<MiTankInspect> getMiTankMst1Remarks (Integer mst1Id,Long nextPostId) throws InventoryUserException;
public Integer insertMiTankMst1Remarks(final MiTankInspect miObj) throws InventoryUserException;
	 
public Integer deleteMitankRepairsRemarks(final MiTankInspect miObj) throws InventoryUserException;
public Integer deleteMitankRepairs(final MiTankInspect miObj) throws InventoryUserException;
//public Integer deleteMitankInoutFlowRemarks(final MiTankInspect miObj) throws InventoryUserException;
public Integer deleteMitankInoutFlow(final MiTankInspect miObj) throws InventoryUserException;
public Integer deleteMitankCapacityRemarks(final MiTankInspect miObj) throws InventoryUserException;
public Integer deleteMitankCapacity(final MiTankInspect miObj) throws InventoryUserException;
public Integer deleteMitankFeedRemarks(final MiTankInspect miObj) throws InventoryUserException;	

public Integer deleteMitankFeedDetails(final MiTankInspect miObj) throws InventoryUserException;
public Integer deleteMiTankMst2(final MiTankInspect miObj) throws InventoryUserException;
public Integer deleteMiTankMst1Remarks(final MiTankInspect miObj) throws InventoryUserException;
public Integer deleteMiTankMst1(final MiTankInspect miObj) throws InventoryUserException;

public Integer editMitankMst2(final MiTankInspect miObj) throws InventoryUserException;
public List<MiTankInspect> getEditMiTankMst2Checks (Integer mst2Id) throws InventoryUserException;
//public List<MiTankInspect> getEditInoutflowTank (Integer mstinoutflowId) throws InventoryUserException;
//public Integer UpdateInoutflowTank(final MiTankInspect miObj) throws InventoryUserException;
public List<MiTankInspect> getEditMiRepairs(Integer repairId) throws InventoryUserException;
public Integer UpdateRepairsTank(final MiTankInspect miObj) throws InventoryUserException;

public Integer UpdateCapacityTank(final MiTankInspect miObj) throws InventoryUserException;
public List<MiTankInspect> getEditMiCapacity(Integer capacityId) throws InventoryUserException;

public List<MiTankInspect> getEditMiFeed(Integer feedId) throws InventoryUserException;
public Integer UpdateFeedTank(final MiTankInspect miObj) throws InventoryUserException;

public List<MiTankInspect> viewMst1Remarks(Integer mst1Id) throws InventoryUserException;


public List<MiTankInspect> getTankWeirSluicelist(Long tankId) throws InventoryUserException;
public Integer insertTankWeirSluice(final MiTankInspect miObj) throws InventoryUserException;

public List<Tanks> getTanksCapacityBYTankId(Long tankId) throws InventoryUserException;

public Integer updateTankCrticalStatus(final MiTankInspect miObj) throws InventoryUserException ;

public Integer insertTankRepairsDescription(final MiTankInspect moobj) throws InventoryUserException;

public List<MiTankInspect> getTankRepairdescList(Long tankId) throws InventoryUserException;

public Integer deleteTankRepairsDescription(final MiTankInspect miobj) throws InventoryUserException;
public Integer editTankRepairsDescription(final MiTankInspect miobj) throws InventoryUserException;

public List<MiTankInspect> getTankRepairdatabyId(Integer tankRepairdescId) throws InventoryUserException;

public List<Constituency> getConstByDistId(Integer distId) throws InventoryUserException;

//public List<MiTankInspect> viewInflowRemarks(Integer inoutId) throws InventoryUserException ;
public List<MiTankInspect> viewRepairRemarks(Integer repairId) throws InventoryUserException ;
public List<MiTankInspect> viewCapacityRemarks(Integer capacityId) throws InventoryUserException;


public List<District> source_mk_districts() throws InventoryUserException;
public Integer DeleteStageDistricts(Boolean flag) throws InventoryUserException;

public Integer stageinsertDistricts(final List<District> distObj) throws InventoryUserException;

public Integer stageinsertMandals(final List<Mandal> mandalObj) throws InventoryUserException;
public Integer DeleteStageMandals(Boolean flag) throws InventoryUserException;
public List<Mandal> source_mk_mandals()throws InventoryUserException;

public Integer stageinsertAssembly(final List<Constituency> constObj) throws InventoryUserException;
public Integer DeleteStageAssembly(Boolean flag) throws InventoryUserException;
public List<Constituency> sourceMkAssembly() throws InventoryUserException;

public Integer stageinsertAssemblyMandals(final List<Constituency> constObj) throws InventoryUserException;
public Integer DeleteStageAssemblyMandals(Boolean flag) throws InventoryUserException;
public List<Constituency> sourceMkAssemblyMandals() throws InventoryUserException;

public Integer stageinsertVillages(final List<Village> villageObj) throws InventoryUserException;
public Integer DeleteStageVillages(Boolean flag) throws InventoryUserException;
public List<Village> sourceMkVillages() throws InventoryUserException;

public List<Habitations> sourceMkHabitations() throws InventoryUserException;

public Integer DeleteStageHabitations(Boolean flag) throws InventoryUserException;

public Integer stageinsertHabitations(final List<Habitations> habitationObj) throws InventoryUserException;

public List<Tanks> sourceMkTanksInfo() throws InventoryUserException;
public Integer DeleteStageTanks(Boolean flag) throws InventoryUserException;
public Integer stageinsertTanksInfo(final List<Tanks> tanksObj) throws InventoryUserException;
public List<Map<String, Object>> generalqueryformisviews(String generalquery);
public List<Map<String, Object>> generalqueryforstagetims(String generalquery);

public List<Habitations> getHabitations(Integer dcode,Integer mcode,Integer vcode) throws InventoryUserException;

public List<Employee> sourceHrmsEmpMst() throws InventoryUserException;

public Integer stageinsertEmpMst(final List<Employee> empObj) throws InventoryUserException;
public Integer DeleteStageEmpMst(Boolean flag) throws InventoryUserException;

public List<Employee> sourceHrmsAdditionalCharge() throws InventoryUserException;
public Integer DeleteStageAdditionalCharge(Boolean flag) throws InventoryUserException;
public Integer stageinsertAdditionalCharge(final List<Employee> empObj) throws InventoryUserException;

public List<Tanks> getTankSectionMap(User user) throws InventoryUserException;;

public Integer DeleteStageDesignationMst(Boolean flag) throws InventoryUserException;
public List<Designation> sourceHrmsDesignationMst() throws InventoryUserException;
public Integer stageinsertDesignationMst(final List<Designation> desObj) throws InventoryUserException;


public List<Employee> sourceHrmsPreaentPostEmp() throws InventoryUserException ;
public Integer DeleteStagePresentPostEMP(Boolean flag) throws InventoryUserException;
public Integer stageinsertPresentPostEmp(final List<Employee> empObj) throws InventoryUserException;

public Integer stageinsertSubpostsEmp(final List<Employee> empObj) throws InventoryUserException ;
public List<Employee> sourceHrmsSubposts() throws InventoryUserException;
public Integer DeleteStageSubPosts(Boolean flag) throws InventoryUserException;


public Integer stageinsertUnitMst(final List<Unit>  unitObj) throws InventoryUserException;
public Integer DeleteStageUnitMst(Boolean flag) throws InventoryUserException;
public List<Unit> sourceHrmsUnitMst() throws InventoryUserException;
public Integer getbaseupdatesUnitMaster() throws InventoryUserException;

public Integer DeleteStageCircleMst(Boolean flag) throws InventoryUserException;
public List<Circle> sourceHrmsCircleMst() throws InventoryUserException ;
public Integer stageinsertCircleMst(final List<Circle>  circleObj) throws InventoryUserException ;


public List<Division> sourceHrmsDivisionMst() throws InventoryUserException;
public Integer stageinsertDivisionMst(final List<Division>  divisionObj) throws InventoryUserException;
public Integer DeleteStageDivisionMst(Boolean flag) throws InventoryUserException;

public Integer stageinsertSubDivisionMst(final List<Subdivision>  subdivisionObj) throws InventoryUserException;
public Integer DeleteStageSubDivisionMst(Boolean flag) throws InventoryUserException;
public List<Subdivision> sourceHrmsSubDivisionMst() throws InventoryUserException;

public List<Sectiondata> sourceHrmsSectionMst() throws InventoryUserException;
public Integer DeleteStageSectionMst(Boolean flag) throws InventoryUserException;
public Integer stageinsertSectionMst(final List<Sectiondata>  sectiondataObj) throws InventoryUserException;


public Integer stageinsertUserMst(final List<User>  usObj) throws InventoryUserException;
public Integer DeleteStageUsers(Boolean flag) throws InventoryUserException;
public List<User> sourceHrmsUserEmp() throws InventoryUserException;

public List<EmployeeDiversion> sourceHrmsEmpDiversion() throws InventoryUserException;
public Integer stageinsertEmpDiversion(final List<EmployeeDiversion> empObj) throws InventoryUserException;
public Integer DeleteStageEmpDiversion(Boolean flag) throws InventoryUserException;
public List<Map<String, Object>> generalqueryforstagehrms(String generalquery);


public Integer getbaseupdatesTanksInfo() throws InventoryUserException;
public Integer getbaseupdatesUsersMaster() throws InventoryUserException;
public Integer getbaseupdatesDesgMaster() throws InventoryUserException;
public Integer getbaseupdatesEmpMaster() throws InventoryUserException;
public Integer getbaseupdatesPPeMaster() throws InventoryUserException;
public Integer getbaseupdatesAddnlChargeMaster() throws InventoryUserException;
public Integer getbaseupdatesSubpostsMaster() throws InventoryUserException;
public Integer getbaseupdatesSectionMaster() throws InventoryUserException;
public Integer getbaseupdatesSubDivisionMaster() throws InventoryUserException;
public Integer getbaseupdatesDivisionMaster() throws InventoryUserException;
public Integer getbaseupdatesCircleMaster() throws InventoryUserException;

public MiTankInspect getTankSuiceNamebyId(Integer tankWeirSluiceId) throws InventoryUserException;
public Integer updateSluicenamebyid(MiTankInspect miobj) throws InventoryUserException;
public Integer updateMst1remarksByreviewid(MiTankInspect miobj) throws InventoryUserException;
public MiTankInspect getMst1remarksbyreviewId(Integer miInpsectMst1IdReviewId) throws InventoryUserException;

public Integer getbaseupdatesEmpdivMaster() throws InventoryUserException;
public MiTankInspect getCapacityremarksbyreviewId(Integer mitankCapacityReviewId) throws InventoryUserException;
public Integer updateMstCapacityremarksByreviewid(final MiTankInspect miObj) throws InventoryUserException;

public MstOutputWithFlag insertForm20Data(final List<MiTankformData> miFormObj) throws InventoryUserException;

public Integer insertForm20Detail(final List<MiTankformData> miformObj) throws InventoryUserException;

public Integer getCountOfform20Docs() throws InventoryUserException;

public Integer insertFormDocuments(final MiTankformData midocObj) throws InventoryUserException;

public List<MiTankformData> getFrmIrrSrcList() throws InventoryUserException ;

public List<MiTankformData> getFrmSentList(MiTankformData  miobj) throws InventoryUserException;

public List<MiTankformData> getFrmDataList(Integer formDataId) throws InventoryUserException ;
public List<MiTankformData> getFrmDetailList(Integer formDataId) throws InventoryUserException;
public List<MiTankFormDocs> getFrmDocsList(Integer formDataId) throws InventoryUserException;

public Integer  updateForm20Data(final List<MiTankformData> miFormObj) throws InventoryUserException ;
public Integer updateForm20Detail(final List<MiTankformData> miformObj) throws InventoryUserException;

public Integer deleteFormdocsbydocId(final MiTankFormDocs miformObj) throws InventoryUserException;
public Integer deleteFormdocs(final MiTankformData miformObj) throws InventoryUserException;
public Integer deleteFormDetail(final MiTankformData miformObj) throws InventoryUserException;
public Integer deleteFormData(final MiTankformData miformObj) throws InventoryUserException;

public Integer  insertForm20approv(final List<MiTankformData> miFormObj) throws InventoryUserException;

public Integer deleteFormdetailsbydetailId(final List<MiTankformData> miformObj) throws InventoryUserException;



public List<TankFeedDetails> getTankFedUnitMap(User user) throws InventoryUserException;
public List<TankFeedDetails> getTankFedCircleMap(User user) throws InventoryUserException ;
public List<TankFeedDetails> getTankFedDivisionMap(User user) throws InventoryUserException;
public List<TankFeedDetails> getTankFedSubdivisionMap(User user) throws InventoryUserException;

public Integer insertResAnn1Mst1Remarks(final ReservoirInspect miObj) throws InventoryUserException;

public List<Map<String, Object>> generalqueryformtanksview(String generalquery);

public List<Map<String, Object>> generalqueryforresultirrinv(String generalquery);

public List<Map<String, Object>> generalqueryforresultpmsstage(String generalquery);


public Integer insertform20CanalsLocation(final Canal canalObj) throws InventoryUserException;
public Integer updateform20CanalsLocation(final Canal canalObj) throws InventoryUserException;
public Integer insertform20CanalsunitMap(final Canal canalObj) throws InventoryUserException;
public Integer updateform20ReservoirLocation(final ReservoirSalient resObj) throws InventoryUserException;
public Integer insertform20ReservoirUnitMap(final ReservoirSalient resObj) throws InventoryUserException;
public List<ReservoirSalient> getform20ResLocByResId(ReservoirSalient resObj) throws InventoryUserException;

public List<Canal> getform20CanLocByCanalId(Canal canalObj) throws InventoryUserException;
public List<Canal> getCanalsByProjectId(Canal canalObj) throws InventoryUserException;




public List<ReservoirSalient> getSourcePmsInvResBasic( ) throws InventoryUserException;
public Integer DeleteStagePMSinvRes(Boolean flag) throws InventoryUserException;
public Integer StagePmsinsertReservoir( List<ReservoirSalient> ressalObj) throws InventoryUserException, ParseException;

public Integer StagePmsinsertPackages(List<Packages> projObj) throws InventoryUserException, ParseException;

public Integer DeleteStagePMSinvPackages(Boolean flag) throws InventoryUserException;

public List<Packages> getSourcePmsInvPackages( ) throws InventoryUserException ;

public Integer StagePmsinsertProjUnitMap(List<Project> projObj) throws InventoryUserException, ParseException;
public Integer DeleteStagePMSinvprojUnitMap(Boolean flag) throws InventoryUserException;
public List<Project> getSourcePmsInvProjectUnitMap( ) throws InventoryUserException;

public List<Project> getSourcePmsInvProjectMst( ) throws InventoryUserException;
public Integer DeleteStagePMSinvprojMst(Boolean flag) throws InventoryUserException;
public Integer StagePmsinsertProjMst(List<Project> projObj) throws InventoryUserException, ParseException;

public Integer insertform20Canals(final Canal canalObj) throws InventoryUserException;
public Integer updateform20Canals(final Canal canalObj) throws InventoryUserException;
public List<Canal> getCanalLocationByCanallocId(Canal canalObj) throws InventoryUserException;

public List<Canal> getCanalsByProjectedit(Canal canalObj) throws InventoryUserException;
public List<Canal> getCanalsByCanalIdedit(Canal canalObj) throws InventoryUserException;
public List<Canal> getCanalsNotInLoc(Canal canalObj) throws InventoryUserException;
public List<Project> getProjectCodesList(Integer projectId) throws InventoryUserException;

//start nrld

//public Integer insertNrldAnnMst1Remarks(final ReservoirInspect miObj) throws InventoryUserException;
public Integer insertNrldAnninspectMst2(final ReservoirInspect resObj) throws InventoryUserException;
public MstOutputWithFlag insertNrldAnnMst1(final ReservoirInspect resObj) throws InventoryUserException;
public List<ReservoirInspect> getNrldAnnmst2IdByMst1Id(Integer mst1Id) throws InventoryUserException;
public Integer AddAnnRemarks(final ReservoirInspect resobj) throws InventoryUserException;
public Integer AddNrldInspectionInfo(final ReservoirInspect resobj) throws InventoryUserException;;
public Integer AddNrldRecommendationInfo(final ReservoirInspect resobj) throws InventoryUserException;
public List<ReservoirInspect> getResmst2andmst1ByYearFreq(ReservoirInspect reservoirInspect) throws InventoryUserException;

public List<ReservoirInspect> getResInspectInfo(ReservoirInspect resObj) throws InventoryUserException;

public Integer AddDamHealthStatusInfo(final ReservoirInspect resobj) throws InventoryUserException;

public List<ReservoirInspect> getDamHealthDetailsBYmst1Id(ReservoirInspect resObj) throws InventoryUserException;

public List<ReservoirInspect> getDamHealthDetailsBYInspectInfo(ReservoirInspect resObj) throws InventoryUserException;


public List<ReservoirInspect> getResAnnRecomndbyhealthInspectInfo(ReservoirInspect resObj) throws InventoryUserException;

public List<ReservoirInspect> getActionTakenDetailsBYmst1Id(ReservoirInspect resObj) throws InventoryUserException;


public Integer AddDamInspectphotosInfo(final DamInspectDocs damobj) throws InventoryUserException;
//end nrld
public List<ReservoirInspect> getResInspectInfobyInspectOfficeInfoId(ReservoirInspect resObj) throws InventoryUserException;

public Integer AddActionTakenStatusInfo(final ReservoirInspect resobj) throws InventoryUserException;

public Integer getCountOfDamInpsectDocs() throws InventoryUserException;

public Integer insertDamDocuments(final ReservoirInspect resdocObj) throws InventoryUserException;

public List<ReservoirInspect> getResDamInspectRemarksByReservoirId(ReservoirInspect resObj) throws InventoryUserException;

public List<DamInspectDocs> getDamInspectPhotosByReservoirId(ReservoirInspect resObj) throws InventoryUserException;

	public List<ReservoirSalient> getresDamInfo(ReservoirInspect resObj) throws InventoryUserException;
	
public List<ReservoirSalient> getresImpControlLevelInfo(ReservoirInspect resObj) throws InventoryUserException;

public List<ReservoirSalient> getresDaminfoandControlLevelInfo(ReservoirInspect resObj) throws InventoryUserException;


public List<Tanks> getTanksDaminfo(MiTankInspect tankObj) throws InventoryUserException;
public List<Tanks> getTanksImpControlinfo(MiTankInspect tankObj) throws InventoryUserException;

public Integer updateTankImpControlInfo(final Tanks tankobj) throws InventoryUserException;
public Integer updateTankDemoInfo(final Tanks tankobj) throws InventoryUserException;

public Integer updateResDemoInfo(final ReservoirSalient resobj) throws InventoryUserException;
public Integer updateResImpControlInfo(final ReservoirSalient resObj) throws InventoryUserException;

public List<Tanks> getTankinfoandControlLevelInfo(ReservoirInspect resObj) throws InventoryUserException;

public Integer updateDamConditionStatus(final ReservoirInspect resObj) throws InventoryUserException;

public Integer deleteAnnRemarksReviewId(final ReservoirInspect resobj) throws InventoryUserException;
public Integer deleteAnnMst2byMst2Id(final ReservoirInspect resobj) throws InventoryUserException;
public Integer deleteAnnRecommendationbyRecommendId(final ReservoirInspect resobj) throws InventoryUserException;
public Integer deleteResAnnDocs(final DamInspectDocs resobj) throws InventoryUserException;
public Integer deleteResHealthDetails(final ReservoirInspect resobj) throws InventoryUserException;
public Integer deleteResInspectInfoDetails(final ReservoirInspect resobj) throws InventoryUserException;
public Integer deleteResActionTakeninfo(final ReservoirInspect resobj) throws InventoryUserException;

public Integer UpdateNrldInspectionInfo(final ReservoirInspect resobj) throws InventoryUserException ;

public Integer UpdateNrldAnnmst2Info(final ReservoirInspect resobj) throws InventoryUserException;

public List<ReservoirInspect> getResDamInspectRemarksByReviewId(ReservoirInspect resObj) throws InventoryUserException;

public Integer UpdateNrldDamRemarksinfo(final ReservoirInspect resobj) throws InventoryUserException;

public List<ReservoirInspect> getResAnnRecomndbytankresyear(ReservoirInspect resObj) throws InventoryUserException;

public List<ReservoirInspect> getResAnnRecomndbyRecId(ReservoirInspect resObj) throws InventoryUserException;

public Integer deleteNrldAnnRecommendationsinfo(final ReservoirInspect resobj) throws InventoryUserException;
public Integer UpdateNrldAnnRecommendationsinfo(final ReservoirInspect resobj) throws InventoryUserException;

public List<ReservoirInspect> getDamHealthDetailsBYHealthId(ReservoirInspect resObj) throws InventoryUserException;

public Integer UpdateNrldAnnHealthinfo(final ReservoirInspect resobj) throws InventoryUserException;

public List<ReservoirInspect> getActionTakenDetailsBYActionId(ReservoirInspect resObj) throws InventoryUserException;

public Integer updateActionTakenDetailsActionId(final ReservoirInspect resobj) throws InventoryUserException;

public List<Tanks> getTankSectionMapNrld(User user) throws InventoryUserException;

public List<ReservoirSalient> getNrldResList(User userOb) throws InventoryUserException;

public List<Project> getNrldProjectList(User user) throws InventoryUserException;

public MstOutputWithFlag inserprevtNrldAnnMst1(final ReservoirInspect resObj) throws InventoryUserException;;

public Integer insertPrevNrldAnninspectMst2(final ReservoirInspect resObj) throws InventoryUserException;

public List<ReservoirInspect> getPrevAnnMst1IdByNewMst1Id(Integer mst1Id) throws InventoryUserException;

public Integer AddPrevNrldInspectionInfo(final ReservoirInspect resobj) throws InventoryUserException;

public Integer AddPrevDamHealthStatusInfo(final ReservoirInspect resobj) throws InventoryUserException;

public Integer AddPrevAnnRemarks(final ReservoirInspect resobj) throws InventoryUserException;

public Integer insertPrevDamDocuments(final ReservoirInspect resdocObj) throws InventoryUserException;

public Integer AddPrevNrldRecommendationInfo(final ReservoirInspect resobj) throws InventoryUserException;

public List<ReservoirInspect> getAnnMst1IdByYearandMonsoonMst1Id(ReservoirInspect resobj) throws InventoryUserException;

public List<ReservoirInspect> getResDamInspectRemarksByMst1Id(ReservoirInspect resObj) throws InventoryUserException;

public List<ReservoirSalient> getInvomResListAdmin(Integer unitId) throws InventoryUserException;

public Integer UpdateResNrldCode(final ReservoirSalient resObj) throws InventoryUserException;

public List<ReservoirInspect> getResPostEmpId(ReservoirInspect resObj) throws InventoryUserException;

public Integer insertRespostaccess(final ReservoirInspect resObj) throws InventoryUserException;
public Integer deleteRespostaccess(final ReservoirInspect resObj) throws InventoryUserException;

public List<Employee> getempdatabyoffice(ReservoirInspect resObj) throws InventoryUserException;

public List<ReservoirSalient> getresDamSalientInfo(ReservoirInspect resObj) throws InventoryUserException;

public Integer updateResSalientInfo9(final ReservoirSalient resObj) throws InventoryUserException;
public Integer updateResSalientInfo8(final ReservoirSalient resObj) throws InventoryUserException;
public Integer updateResSalientInfo7(final ReservoirSalient resObj) throws InventoryUserException;
public Integer updateResSalientInfo5(final ReservoirSalient resObj) throws InventoryUserException;
public Integer updateResSalientInfo4(final ReservoirSalient resObj) throws InventoryUserException;
public Integer updateResSalientInfo3(final ReservoirSalient resObj) throws InventoryUserException;
public Integer updateResSalientInfo2(final ReservoirSalient resObj) throws InventoryUserException;
public Integer updateResSalientInfo1(final ReservoirSalient resObj) throws InventoryUserException;

public List<Tanks> getTankDamSalientInfo(MiTankInspect tankObj) throws InventoryUserException;

public Integer updateTankSalientInfo9(Tanks tankObj) throws InventoryUserException;
public Integer updateTankSalientInfo8(final Tanks tankObj) throws InventoryUserException;
public Integer updateTankSalientInfo7(final Tanks tankObj) throws InventoryUserException;
public Integer updateTankSalientInfo5(final Tanks tankObj) throws InventoryUserException;
public Integer updateTankSalientInfo4(final Tanks tankObj) throws InventoryUserException;
public Integer updateTankSalientInfo3(final Tanks tankObj) throws InventoryUserException;
public Integer updateTankSalientInfo2(final Tanks tankObj) throws InventoryUserException;
public Integer updateTankSalientInfo1(final Tanks tankObj) throws InventoryUserException;

public List<MiTankformData> getRepeatedTankResCanalBreachList() throws InventoryUserException;
public List<MiTankformData> getRepeatedTankResCanalLDamageist() throws InventoryUserException ;




}
