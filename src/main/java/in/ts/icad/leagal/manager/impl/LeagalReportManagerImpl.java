package in.ts.icad.leagal.manager.impl;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.LeagalReportDAO;
import in.ts.icad.leagal.dao.LeagalWebDAO;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.manager.LeagalReportManager;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.Courts;
import in.ts.icad.leagal.model.abstractCounterData;

@Component
public class LeagalReportManagerImpl implements LeagalReportManager {
	
	@Autowired
	private LeagalReportDAO leagalReportDAO;

	
	
	@Override
	public List<Courts> setCourts() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getCourts();
	}



	@Override
	public List<Cases> getcasesCourt(Integer courtId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesCourt(courtId);
	}



	@Override
	public List<Cases> getcasesGen(Integer caseGenId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesGen(caseGenId);
	}



	@Override
	public List<Cases> getcasesGenAll() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesGenAll();
	}



	@Override
	public List<Cases> getcasesGenCourt(Integer courtId, Integer caseGenId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesGenCourt(courtId, caseGenId);
	}



	@Override
	public List<Cases> getcasesdraftfiled(Integer unitId, Integer caseGenId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesdraftfiled(unitId,caseGenId);
	}



	@Override
	public List<Cases> getcasesjudgefiled(Integer unitId,Integer caseGenId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesjudgefiled(unitId,caseGenId);
	}



	@Override
	public List<Cases> getcasesCounterfiled(Integer unitId, Integer caseGenId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesCounterfiled(unitId, caseGenId);
	}



	@Override
	public List<Cases> getcasesfiled(Integer unitId, Integer caseGenId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesfiled(unitId, caseGenId);
	}



	@Override
	public List<Cases> getcasescounternotfiled(Integer unitId, Integer caseGenId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasescounternotfiled(unitId, caseGenId);
	}



	@Override
	public List<abstractCounterData> getCountEPdata(Integer courtId, Integer caseTypeId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getCountEPdata(courtId, caseTypeId);
	}



	

	


	@Override
	public List<abstractCounterData> getabstractcountGenAll() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getabstractcountGenAll();
	}



	@Override
	public List<abstractCounterData> getabstractcountGenCourt(Integer caseGenId, Integer courtId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getabstractcountGenCourt(caseGenId, courtId);
	}



	@Override
	public List<abstractCounterData> getabstractcountCourt(Integer courtId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getabstractcountCourt(courtId);
	}



	@Override
	public List<abstractCounterData> getabstractcountGen(Integer caseGenId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getabstractcountGen(caseGenId);
	}



	@Override
	public List<Cases> getcasesAbstractGenCourtcasefiled(Integer unitId, Integer courtId, Integer caseGenId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractGenCourtcasefiled(unitId, courtId, caseGenId);
	}



	@Override
	public List<Cases> getcasesAbstractGenCourtcounterfiled(Integer unitId, Integer courtId, Integer caseGenId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractGenCourtcounterfiled(unitId, courtId, caseGenId);
	}



	@Override
	public List<Cases> getcasesAbstractGenCourtjudgefiled(Integer unitId, Integer courtId, Integer caseGenId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractGenCourtjudgefiled(unitId, courtId, caseGenId);
	}



	@Override
	public List<Cases> getcasesAbstractGenCourtdraftfiled(Integer unitId, Integer courtId, Integer caseGenId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractGenCourtdraftfiled(unitId, courtId, caseGenId);
	}



	@Override
	public List<Cases> getcasesAbstractGenCourtcounternotfiled(Integer unitId, Integer courtId, Integer caseGenId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractGenCourtcounternotfiled(unitId, courtId, caseGenId);
	}



	@Override
	public List<Cases> getcasesAbstractcasefiled(Integer unitId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractcasefiled(unitId);
	}



	@Override
	public List<Cases> getcasesAbstractcounterfiled(Integer unitId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractcounterfiled(unitId);
	}



	@Override
	public List<Cases> getcasesAbstractjudgefiled(Integer unitId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractjudgefiled(unitId);
	}



	@Override
	public List<Cases> getcasesAbstractdraftfiled(Integer unitId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractdraftfiled(unitId);
	}



	@Override
	public List<Cases> getcasesAbstractcounternotfiled(Integer unitId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractcounternotfiled(unitId);
	}



	@Override
	public List<Cases> getcasesAbstractcourtcasefiled(Integer unitId, Integer courtId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractcourtcasefiled(unitId, courtId);
	}



	@Override
	public List<Cases> getcasesAbstractcourtcounterfiled(Integer unitId, Integer courtId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractcourtcounterfiled(unitId, courtId);
	}



	@Override
	public List<Cases> getcasesAbstractcourtjudgefiled(Integer unitId, Integer courtId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractcourtjudgefiled(unitId, courtId);
	}



	@Override
	public List<Cases> getcasesAbstractcourtdraftfiled(Integer unitId, Integer courtId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractcourtdraftfiled(unitId, courtId);
	}



	@Override
	public List<Cases> getcasesAbstractcourtcounternotfiled(Integer unitId, Integer courtId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractcourtcounternotfiled(unitId, courtId);
	}



	@Override
	public List<abstractCounterData> getabstractPetAdvCourt(Integer advocateId, Integer courtId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getabstractPetAdvCourt(advocateId, courtId);
	}



	



	@Override
	public List<abstractCounterData> getabstractPetAdvAll(Integer advocateId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getabstractPetAdvAll(advocateId);
	}



	@Override
	public List<Cases> getcasesAbstractAllPetAdvAll(Integer unitId, Integer filingtype, Integer advocateId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractAllPetAdvAll(unitId, filingtype, advocateId);
	}



	@Override
	public List<abstractCounterData> getabstractPetCourt(Integer petitionerId, Integer courtId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getabstractPetCourt(petitionerId, courtId);
	}



	@Override
	public List<abstractCounterData> getabstractPetAll(Integer petitionerId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getabstractPetAll(petitionerId);
	}



	@Override
	public List<Cases> getcasesAbstractPetCourt(Integer unitId, Integer filingtype, Integer courtId,
			Integer petitionerId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractPetCourt(unitId, filingtype, courtId, petitionerId);
	}



	@Override
	public List<Cases> getcasesAbstractPetAll(Integer unitId, Integer filingtype, Integer petitionerId)
			throws LeagalUserException {
		// TODO Auto-generated method stub;
		return leagalReportDAO.getcasesAbstractPetAll(unitId, filingtype, petitionerId);
	}



	@Override
	public List<Cases> getcasesAbstractCourtPetAdvCourt(Integer unitId, Integer courtId, Integer filingtype,
			Integer advocateId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractCourtPetAdvCourt(unitId, courtId, filingtype, advocateId);
	}



	@Override
	public List<Cases> getcasesAbstractTotCourtGen(Integer filingtype, Integer courtId, Integer caseGenId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractTotCourtGen(filingtype, courtId, caseGenId);
	}



	@Override
	public List<Cases> getcasesAbstractTotCourt(Integer filingtype, Integer courtId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractTotCourt(filingtype, courtId);
	}



	@Override
	public List<Cases> getcasesAbstractTotGen(Integer filingtype, Integer caseGenId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractTotGen(filingtype, caseGenId);
	}



	@Override
	public List<Cases> getcasesAbstractTotAll(Integer filingtype) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractTotAll(filingtype);
	}



	@Override
	public List<Cases> getcasesAbstractEPTotType(Integer filingtype, Integer caseTypeId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractEPTotType(filingtype, caseTypeId);
	}



	@Override
	public List<Cases> getcasesAbstractTotPetAll(Integer filingtype, Integer petitionerId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractTotPetAll(filingtype, petitionerId);
		}



	@Override
	public List<Cases> getcasesAbstractTotPetCourt(Integer filingtype, Integer courtId, Integer petitionerId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractTotPetCourt(filingtype, courtId, petitionerId);
	}



	@Override
	public List<Cases> getcasesAbstractTotPetAdvAll(Integer filingtype, Integer advocateId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractTotPetAdvAll( filingtype, advocateId);
	}



	@Override
	public List<Cases> getcasesAbstractTotPetAdvCourt(Integer filingtype, Integer courtId, Integer advocateId)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getcasesAbstractTotPetAdvCourt(filingtype, courtId, advocateId);
	}



	@Override
	public List<Cases> getEPcasesfiled(Integer unitId, Integer caseTypeId, Integer filingtype)
			throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalReportDAO.getEPcasesfiled(unitId, caseTypeId, filingtype);
	}

}
