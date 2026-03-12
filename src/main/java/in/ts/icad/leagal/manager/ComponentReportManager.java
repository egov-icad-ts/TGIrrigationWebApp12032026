package in.ts.icad.leagal.manager;

import java.util.List;

import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.ComponentAyacut;
import in.ts.icad.leagal.model.ComponentsCapacity;
import in.ts.icad.leagal.model.District;

public interface ComponentReportManager {
	
	List<Component> getComponentProgress(Integer projectId) throws ComponentUserException;
	List<Component> getProjectLiftData( Integer projectId) throws ComponentUserException;
	List<ComponentsCapacity> getComponentCapacityAllLifts(Integer statusId) throws ComponentUserException;
	List<Component> getCompPowerInfo( Integer projectId) throws ComponentUserException;
	List<Component> getCompGoogleMapStatusInfo( Integer projectId) throws ComponentUserException;
	List<ComponentAyacut> getMandalAyacutInfo(Integer districtId) throws ComponentUserException ;
	List<ComponentAyacut> getConstAyacutSum(Integer districtId) throws ComponentUserException;
	List<ComponentAyacut> getConstTotalSum() throws ComponentUserException ;
	List<ComponentAyacut> getprojTotalbyconstSum(Integer constId) throws ComponentUserException;
	List<ComponentAyacut> getprojTotalbydistconstSum(Integer constId) throws ComponentUserException;
	List<ComponentAyacut> getDistTotalbyconstSum(Integer constId) throws ComponentUserException;
	List<ComponentAyacut> getMandalTotalbyconstSum(Integer districtId,Integer constId) throws ComponentUserException;
/*	List<ComponentAyacut> getprojTotalAllconstSum() throws ComponentUserException;*/
	List<ComponentAyacut> getprojTotal() throws ComponentUserException;
	List<ComponentAyacut> getConstDistManVillage(Integer districtId) throws ComponentUserException;
	List<ComponentAyacut> getConstDistManVillageByID(Integer constId,Integer districtId,Integer mandalId) throws ComponentUserException;
	List<ComponentAyacut> getVillageByConst(Integer constId) throws ComponentUserException;
	List<ComponentAyacut> getMandalbyProj(Integer projectId) throws ComponentUserException;
	List<District> getOldDistricts() throws ComponentUserException;
	public List<ComponentAyacut> getUnitAyacutInfo() throws ComponentUserException;
	public List<ComponentAyacut> getDistprojAyacutInfo() throws ComponentUserException;
	public List<ComponentAyacut> getProjPackManTotal() throws ComponentUserException ;
	public List<ComponentAyacut> getUnitDistrictAyacutInfo() throws ComponentUserException;
	public List<ComponentAyacut> getMandalbyUnit(Integer unitId) throws ComponentUserException;
	public List<ComponentAyacut> getReportProjSeasonCap(ComponentAyacut compObj) throws ComponentUserException;
	public List<ComponentAyacut> getAyacutJurisdiction() throws ComponentUserException;
	public List<ComponentAyacut> getAyacutdivisionMandal() throws ComponentUserException;
	public List<ComponentAyacut> gettestdataforpms() throws ComponentUserException;
	public List<ComponentAyacut> getProjManTotal() throws ComponentUserException;
	
	public List<ComponentAyacut> getProjManVillageTotal() throws ComponentUserException;
	public List<ComponentAyacut> getDistrictManprojTotal() throws ComponentUserException;
	public List<ComponentAyacut> getDistManProjAyacutSum(Integer districtId) throws ComponentUserException;
}
