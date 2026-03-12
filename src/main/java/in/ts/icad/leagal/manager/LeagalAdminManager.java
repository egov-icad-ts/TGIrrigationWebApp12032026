package in.ts.icad.leagal.manager;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import in.ts.icad.leagal.exception.LeagalUserException;
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

public interface LeagalAdminManager {
	
	//User getRole(String userName) throws LeagalUserException ;
	
   
List<District> getDistricts() throws LeagalUserException;
	
	/**
	 * Get all mandals of a particular district.
	 * @param distId - district id.
	 * @return list of Mandal.
	 * @throws PMSUserException
	 */
	List<Mandal> getMandals(Integer distId) throws LeagalUserException;
	
	/**
	 * Get all villages of a particular district and mandal.
	 * @param distId - district id.
	 * @param mandalId - mandal id.
	 * @return list of Village.
	 * @throws PMSUserException
	 */
	List<Village> getVillages(Integer dcode, Integer mcode) throws LeagalUserException;
	
	List<Division> getDivisions (Integer circleId) throws LeagalUserException;
	
	
List<Unit> getUnitList() throws LeagalUserException;
	
	List<Project> getProjectList(Integer unitId) throws LeagalUserException;
	List<Packages> getPackageList(Integer projectId) throws LeagalUserException;
	List<Petitioner> getPetitionerList() throws LeagalUserException;
	List<PetitionerAdvocate> getPetitionerAdvocateList() throws LeagalUserException;
	List<Respondent> getRespondentList() throws LeagalUserException;
	List<RespondentAdvocate> getRespondentAdvocateList() throws LeagalUserException;
	
	List<CaseType> getCaseTypeList(Integer courtId) throws LeagalUserException;
	List<CaseStatus> getCaseStatusList() throws LeagalUserException;
	List<CaseStages> getCaseStagesList() throws LeagalUserException;
	List<CaseGenSub> getCaseGenSubList(Integer caseGenId) throws LeagalUserException;
	List<CasesGeneral> getCaseGeneralList() throws LeagalUserException;
	
	Integer insertCases(Cases caseObject) throws LeagalUserException, SQLException,ParseException;
	Integer insertPet(List<Integer> petId, Integer caseId) throws LeagalUserException;
	Integer insertPetAdv(List<Integer> petAdvId, Integer caseId) throws LeagalUserException;
	Integer insertRes(List<Integer> resId, Integer caseId) throws LeagalUserException;
	Integer insertResAdv(List<Integer> resAdvId, Integer caseId) throws LeagalUserException;
	Integer insertCaseContact(List<ContactPerson> contactList,Integer caseId) throws LeagalUserException;
	List<Circle> getCircleList(Integer unitId) throws LeagalUserException;
	List<Subdivision> getSubDivisionList(Integer divisionId) throws LeagalUserException ;
	List<Division> getDivisionList(Integer circleId) throws LeagalUserException;
	List<User> getUserDetails(String userName, String password)  throws LeagalUserException;
	public Integer editData(String query);
	public List<Map<String, Object>> generalqueryforresult(String query);	
	
	public Petitioner getPetitionerbyId(Integer petId) throws LeagalUserException;
	
	Integer insertpetitionermst(Petitioner pet) throws LeagalUserException;
	Integer insertpetitionerAdvmst(PetitionerAdvocate petAdv) throws LeagalUserException;
	Integer insertrespondentmst(Respondent res) throws LeagalUserException;
	Integer inrespondentAdvmst(RespondentAdvocate resAdv) throws LeagalUserException;
	Integer insertPackmst(Packages pack) throws LeagalUserException;
	
	public List<Cases> getCasesList() throws LeagalUserException ;
	List<Cases> getcasesbycaseid(Integer caseId) throws LeagalUserException;
	Integer insertcasegenmst(CasesGeneral caseGen) throws LeagalUserException;
	Integer insertcasetypemst(CaseType castype) throws LeagalUserException;
	Integer insertcasegensubmst(CaseGenSub casegensub) throws LeagalUserException;
	User getUserPostDetails(String userName, String password)throws LeagalUserException;
	Integer deleteAllforcase(final  Integer caseId) throws LeagalUserException;
	Integer editAllforcase(final Cases caseObject) throws LeagalUserException, ParseException;
	List<CaseTypeOrder> getTypeOrderList() throws LeagalUserException;

List<Petitioner> getPetitionerbyCountList() throws LeagalUserException;
List<PetitionerAdvocate> getPetitionerAdvocatebyCountList() throws LeagalUserException;

public PetitionerAdvocate getPetitionerAdvListbyId(Integer petadvId) throws LeagalUserException;
public Respondent getRespondentListById(Integer resId) throws LeagalUserException;
public RespondentAdvocate getRespondentAdvocateListById(Integer resAdvId) throws LeagalUserException;
public Boolean changePassword(User user) throws LeagalUserException ;

public List<User> getEmpDetails(String userName, String password) throws LeagalUserException;

public Boolean getUservalidity(String userName, String password)		throws LeagalUserException;

public List<Project> getProjectListadmin(Integer unitId) throws LeagalUserException ;

public Boolean insertfailedattempt(String userName,String ipAddress)		throws LeagalUserException;

public Boolean insertLoginAttempt(String userName,String ipAddress)		throws LeagalUserException;

public Boolean updateUserLogout(User user)		throws LeagalUserException;


public List<User> logDetails(String username) throws LeagalUserException;

public Boolean getUserConcurrentLogin(String userName) throws LeagalUserException;

public Integer getFailedLoginCount(String userName) throws LeagalUserException;


}
