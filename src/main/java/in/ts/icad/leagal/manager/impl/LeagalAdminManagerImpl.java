package in.ts.icad.leagal.manager.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.LeagalAdminDAO;
import in.ts.icad.leagal.dao.LeagalWebDAO;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.model.CaseGenSub;
import in.ts.icad.leagal.model.CaseStages;
import in.ts.icad.leagal.model.CaseStatus;
import in.ts.icad.leagal.model.CaseType;
import in.ts.icad.leagal.model.CaseTypeOrder;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.CasesGeneral;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.ContactPerson;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Mandal;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.Petitioner;
import in.ts.icad.leagal.model.PetitionerAdvocate;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.Respondent;
import in.ts.icad.leagal.model.RespondentAdvocate;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.model.Village;

@Component
public class LeagalAdminManagerImpl implements LeagalAdminManager {
	
	@Autowired
	private LeagalAdminDAO leagalAdminDAO;
	
	@Override
	public List<District> getDistricts() throws LeagalUserException {
		return leagalAdminDAO.getDistricts();
	}

	@Override
	public List<Mandal> getMandals(final Integer distId) throws LeagalUserException {
		return leagalAdminDAO.getMandals(distId);
	}

	@Override
	public List<Village> getVillages(Integer dcode, Integer mcode) throws LeagalUserException {
		return leagalAdminDAO.getVillages(dcode,mcode);
	}
	
	@Override
	public	List<Division> getDivisions (Integer circleId)throws LeagalUserException {
		return leagalAdminDAO.getDivisions(circleId);
	}

	

	

	@Override
	public List<Unit> getUnitList() throws LeagalUserException {
		// TODO Auto-generated method stub
		 return leagalAdminDAO.getUnitList();
	}

	@Override
	public List<Project> getProjectList(Integer unitId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getProjectList(unitId);
	}

	@Override
	public List<Packages> getPackageList(Integer projectId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getPackageList(projectId);
	}

	@Override
	public List<Petitioner> getPetitionerList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getPetitionerList();
	}

	@Override
	public List<PetitionerAdvocate> getPetitionerAdvocateList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getPetitionerAdvocateList();
	}

	@Override
	public List<Respondent> getRespondentList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getRespondentList();
	}

	@Override
	public List<RespondentAdvocate> getRespondentAdvocateList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getRespondentAdvocateList();
	}

	@Override
	public List<CaseType> getCaseTypeList(Integer courtId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getCaseTypeList(courtId);
	}

	@Override
	public List<CaseStatus> getCaseStatusList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getCaseStatusList();
	}

	@Override
	public List<CaseStages> getCaseStagesList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getCaseStagesList();
	}

	@Override
	public List<CaseGenSub> getCaseGenSubList(Integer caseGenId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getCaseGenSubList(caseGenId);
	}

	@Override
	public List<CasesGeneral> getCaseGeneralList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getCaseGeneralList();
	}

	@Override
	public Integer insertCases(Cases caseObject) throws LeagalUserException, SQLException,ParseException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertCases(caseObject);
	}

	@Override
	public Integer insertPet(List<Integer> petId, Integer caseId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertPet(petId, caseId);
	}

	@Override
	public Integer insertPetAdv(List<Integer> petAdvId, Integer caseId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertPetAdv(petAdvId, caseId);
	}

	@Override
	public Integer insertRes(List<Integer> resId, Integer caseId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertRes(resId, caseId);
	}

	@Override
	public Integer insertResAdv(List<Integer> resAdvId, Integer caseId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertResAdv(resAdvId, caseId);
	}

	@Override
	public Integer insertCaseContact(List<ContactPerson> contactList, Integer caseId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertCaseContact(contactList, caseId);
	}

	@Override
	public List<Circle> getCircleList(Integer unitId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getCircleList(unitId);
	}

	@Override
	public List<Subdivision> getSubDivisionList(Integer divisionId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getSubDivisionList(divisionId);
	}

	@Override
	public List<Division> getDivisionList(Integer circleId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getDivisionList(circleId);
	}

	@Override
	public List<User> getUserDetails(String userName, String password) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getUserDetails(userName, password);
	}
	
	@Override
	public Integer editData(String query) {
		// TODO Auto-generated method stub
		return leagalAdminDAO.editData(query);
	}

	@Override
	public List<Map<String, Object>> generalqueryforresult(String query) {
		// TODO Auto-generated method stub
		return leagalAdminDAO.generalqueryforresult(query);
	}

	@Override
	public Integer insertpetitionermst(Petitioner pet) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertpetitionermst(pet);
	}

	@Override
	public Integer insertpetitionerAdvmst(PetitionerAdvocate petAdv) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertpetitionerAdvmst(petAdv);
	}

	@Override
	public Integer insertrespondentmst(Respondent res) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertrespondentmst(res);
	}

	@Override
	public Integer inrespondentAdvmst(RespondentAdvocate resAdv) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.inrespondentAdvmst(resAdv);
	}

	@Override
	public Integer insertPackmst(Packages pack) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertPackmst(pack);
	}

	@Override
	public List<Cases> getCasesList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getCasesList();
	}

	@Override
	public List<Cases> getcasesbycaseid(Integer caseId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getcasesbycaseid(caseId);
	}

	@Override
	public Integer insertcasegenmst(CasesGeneral caseGen) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertcasegenmst(caseGen);
	}

	@Override
	public Integer insertcasetypemst(CaseType castype) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertcasetypemst(castype);
	}

	@Override
	public Integer insertcasegensubmst(CaseGenSub casegensub) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertcasegensubmst(casegensub);
	}

	@Override
	public User getUserPostDetails(String userName, String password) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getUserPostDetails(userName, password);
	}

	@Override
	public Integer deleteAllforcase(Integer caseId ) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.deleteAllforcase(caseId);
	}

	@Override
	public Integer editAllforcase(Cases caseObject) throws LeagalUserException, ParseException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.editAllforcase(caseObject);
	}

	@Override
	public List<CaseTypeOrder> getTypeOrderList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getTypeOrderList();
	}

	@Override
	public List<Petitioner> getPetitionerbyCountList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getPetitionerbyCountList();
	}

	@Override
	public List<PetitionerAdvocate> getPetitionerAdvocatebyCountList() throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getPetitionerAdvocatebyCountList();
	}

	@Override
	public Petitioner getPetitionerbyId(Integer petId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getPetitionerbyId(petId);
	}

	@Override
	public PetitionerAdvocate getPetitionerAdvListbyId(Integer petadvId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getPetitionerAdvListbyId(petadvId);
	}

	@Override
	public Respondent getRespondentListById(Integer resId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getRespondentListById(resId);
	}

	@Override
	public RespondentAdvocate getRespondentAdvocateListById(Integer resAdvId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getRespondentAdvocateListById(resAdvId);
	}

	@Override
	public Boolean changePassword(User user) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.changePassword(user);
	}

	@Override
	public List<User> getEmpDetails(String userName, String password) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getEmpDetails(userName, password);
	}

	@Override
	public Boolean getUservalidity(String userName, String password) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getUservalidity(userName, password);
	}

	@Override
	public List<Project> getProjectListadmin(Integer unitId) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getProjectListadmin(unitId);
	}
	
	@Override
	public Boolean insertfailedattempt(String userName,String ipAddress) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertfailedattempt(userName,ipAddress);
	}
	
	@Override
	public Boolean insertLoginAttempt(String userName,String ipAddress) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.insertLoginAttempt(userName,ipAddress);
	}
	
	@Override
	public Boolean updateUserLogout(User user) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.updateUserLogout(user);
	}
	
	@Override
	public List<User> logDetails(String username) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.logDetails(username);
	}
	
	@Override
	public Boolean getUserConcurrentLogin(String userName) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getUserConcurrentLogin(userName);
	}
	
	@Override
	public Integer getFailedLoginCount(String userName) throws LeagalUserException {
		// TODO Auto-generated method stub
		return leagalAdminDAO.getFailedLoginCount(userName);
	}

}
