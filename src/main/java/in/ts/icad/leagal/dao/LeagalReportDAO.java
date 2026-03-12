package in.ts.icad.leagal.dao;

import java.util.List;

import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Courts;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.abstractCounterData;

public interface LeagalReportDAO {
	
	//List<abstractCounterData> getCounterFileData(Integer caseGenId) throws LeagalUserException ;
	
	
	 List<Unit> getUnitList() throws LeagalUserException;
	List<Division> getDivisionList() throws LeagalUserException;
	List<Circle>   getCircleList() throws LeagalUserException;
	List<Subdivision> getSubDivisionList(Integer  divisionId) throws LeagalUserException;
	List<Courts> getCourts() throws LeagalUserException ;
	
	List<Cases> getcasesCourt(Integer courtId) throws LeagalUserException ;
	List<Cases> getcasesGen( Integer caseGenId) throws LeagalUserException;
	List<Cases> getcasesGenAll() throws LeagalUserException;
	List<Cases> getcasesGenCourt(Integer courtId, Integer caseGenId) throws LeagalUserException;
	
	List<Cases> getcasesdraftfiled(Integer unitId, Integer caseGenId) throws LeagalUserException ;
	List<Cases> getcasesjudgefiled(Integer unitId, Integer caseGenId) throws LeagalUserException;
	List<Cases> getcasesCounterfiled(Integer unitId, Integer caseGenId) throws LeagalUserException;
	List<Cases> getcasesfiled(Integer unitId, Integer caseGenId) throws LeagalUserException ;
	List<Cases> getcasescounternotfiled(Integer unitId, Integer caseGenId) throws LeagalUserException ;
	List<abstractCounterData> getCountEPdata(Integer courtId,Integer caseTypeId) throws LeagalUserException;
	List<Cases> getEPcasesfiled(Integer unitId, Integer caseTypeId,Integer filingtype) throws LeagalUserException ; 
	/*List<Cases> getEPcasesCounterfiled(Integer unitId,Integer caseTypeId) throws LeagalUserException;
	List<Cases> getEPcasesjudgefiled(Integer unitId, Integer caseTypeId) throws LeagalUserException;
	List<Cases> getEPcasesdraftfiled(Integer unitId, Integer caseTypeId) throws LeagalUserException;
	List<Cases> getEPcasescounternotfiled(Integer unitId, Integer caseTypeId) throws LeagalUserException;*/
	
	List<abstractCounterData> getabstractcountGenAll() throws LeagalUserException;
	List<abstractCounterData>  getabstractcountGenCourt( Integer caseGenId, Integer courtId) throws LeagalUserException;
	List<abstractCounterData> getabstractcountCourt(Integer courtId) throws LeagalUserException;
	List<abstractCounterData> getabstractcountGen(Integer caseGenId)throws LeagalUserException;
	
	
	List<Cases> getcasesAbstractGenCourtcasefiled( Integer unitId,Integer courtId, Integer caseGenId) throws LeagalUserException;
	List<Cases> getcasesAbstractGenCourtcounterfiled( Integer unitId,Integer courtId, Integer caseGenId) throws LeagalUserException;
	List<Cases> getcasesAbstractGenCourtjudgefiled( Integer unitId,Integer courtId, Integer caseGenId) throws LeagalUserException;
	List<Cases> getcasesAbstractGenCourtdraftfiled( Integer unitId,Integer courtId, Integer caseGenId) throws LeagalUserException ;
	List<Cases> getcasesAbstractGenCourtcounternotfiled( Integer unitId,Integer courtId, Integer caseGenId) throws LeagalUserException;
	
	
	List<Cases> getcasesAbstractcasefiled( Integer unitId) throws LeagalUserException;
	List<Cases> getcasesAbstractcounterfiled( Integer unitId) throws LeagalUserException;
	List<Cases> getcasesAbstractjudgefiled( Integer unitId) throws LeagalUserException ;
	List<Cases> getcasesAbstractdraftfiled( Integer unitId) throws LeagalUserException;
	List<Cases> getcasesAbstractcounternotfiled( Integer unitId) throws LeagalUserException;
	
	
	List<Cases> getcasesAbstractcourtcasefiled( Integer unitId , Integer courtId) throws LeagalUserException;
	List<Cases> getcasesAbstractcourtcounterfiled( Integer unitId , Integer courtId) throws LeagalUserException;
	List<Cases> getcasesAbstractcourtjudgefiled( Integer unitId , Integer courtId) throws LeagalUserException;
	List<Cases> getcasesAbstractcourtdraftfiled( Integer unitId , Integer courtId) throws LeagalUserException;
	List<Cases> getcasesAbstractcourtcounternotfiled( Integer unitId , Integer courtId) throws LeagalUserException;
	
	
	 List<abstractCounterData> getabstractPetAdvCourt(Integer advocateId,Integer courtId) throws LeagalUserException;
	
	 List<Cases> getcasesAbstractCourtPetAdvCourt( Integer unitId,Integer courtId,Integer filingtype, Integer advocateId) throws LeagalUserException;
	 List<abstractCounterData> getabstractPetAdvAll(Integer advocateId) throws LeagalUserException;
	 List<Cases> getcasesAbstractAllPetAdvAll( Integer unitId,Integer filingtype, Integer advocateId) throws LeagalUserException;
	 
	 List<abstractCounterData> getabstractPetCourt(Integer petitionerId,Integer courtId) throws LeagalUserException;
	 List<abstractCounterData> getabstractPetAll(Integer petitionerId) throws LeagalUserException	;
	 List<Cases> getcasesAbstractPetCourt( Integer unitId,Integer filingtype,Integer courtId, Integer petitionerId) throws LeagalUserException;
	 List<Cases> getcasesAbstractPetAll( Integer unitId,Integer filingtype, Integer petitionerId) throws LeagalUserException;
	 
	 
	 List<Cases> getcasesAbstractTotCourtGen( Integer filingtype,Integer courtId, Integer caseGenId) throws LeagalUserException;
	 List<Cases> getcasesAbstractTotCourt( Integer filingtype,Integer courtId) throws LeagalUserException;
	 List<Cases> getcasesAbstractTotGen( Integer filingtype, Integer caseGenId) throws LeagalUserException;
	 List<Cases> getcasesAbstractTotAll( Integer filingtype) throws LeagalUserException;
	 
	 List<Cases> getcasesAbstractEPTotType( Integer filingtype,Integer caseTypeId) throws LeagalUserException;
	 
	 List<Cases> getcasesAbstractTotPetAll( Integer filingtype,Integer petitionerId) throws LeagalUserException;
	 List<Cases> getcasesAbstractTotPetCourt( Integer filingtype,Integer courtId,Integer petitionerId) throws LeagalUserException ;
	 List<Cases> getcasesAbstractTotPetAdvAll( Integer filingtype,Integer advocateId) throws LeagalUserException;
	 List<Cases> getcasesAbstractTotPetAdvCourt( Integer filingtype,Integer courtId, Integer advocateId) throws LeagalUserException ;
}
