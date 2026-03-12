package in.ts.icad.leagal.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Cases {
	
	private Integer caseId;
	private String caseWpNumber;
	private Integer caseYear;
	private Integer caseStatusId;
	private boolean caseisLatest;
	private Integer caseTypeId;
	private Integer caseGenId;
	private boolean deleteFlag;
	private String Remarks;
	private Integer userId;
	private Integer courtId;
	private String briefPrayer;
	
	private String filingDate;
	private String counterDate;
	private String judgementDate;
	
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	private Integer  subdivisionId;
	private String   createdBy;
	private Integer  projectId;
	private Integer  packageId;
	private String petitioner;
	private String petetionerAdvocate;
	private String respondent;
	private String respondentAdvocate;
	private String caseStatus;
	private String caseType;
	private String remarks;
	private String courtName;
	private String unitName;
	private String circleName;
	private String divisionName;
	private String subDivisionName;
	private String packageName;
	private String projectName;
	private Integer petitionerId;
	private Integer petetionerAdvId;
	private Integer respondentId;
	private Integer respondentAdvId;
	
	private String petitionerIdArray;
	private String petetionerAdvIdArray;
	private String respondentIdArray;
	private String respondentAdvIdArray;
	
	private Integer caseGenSubId;
	
	private Integer courtdistrictId;
	
	private String caseNum;
	
	private String orderDate;
	private String hearingDate;
	private String fileName;
	private String filePath;
	private Integer hiddenOrderId;
	private Integer hiddenChildCase;
	private String  contactName;
	private String   contactPhone;
	
	private Integer hiddenprojectId;
	private Integer hiddenpackageId;
	private Integer hiddencircleId;
	private Integer hiddendivisionId;
	private Integer hiddensubdivisionId;
	private Integer hiddencaseTypeId;
	private Integer hiddencaseGenSubId;
	
	
	
	
	
	public Integer getHiddenprojectId() {
		return hiddenprojectId;
	}
	public void setHiddenprojectId(Integer hiddenprojectId) {
		this.hiddenprojectId = hiddenprojectId;
	}
	public Integer getHiddenpackageId() {
		return hiddenpackageId;
	}
	public void setHiddenpackageId(Integer hiddenpackageId) {
		this.hiddenpackageId = hiddenpackageId;
	}
	public Integer getHiddencircleId() {
		return hiddencircleId;
	}
	public void setHiddencircleId(Integer hiddencircleId) {
		this.hiddencircleId = hiddencircleId;
	}
	public Integer getHiddendivisionId() {
		return hiddendivisionId;
	}
	public void setHiddendivisionId(Integer hiddendivisionId) {
		this.hiddendivisionId = hiddendivisionId;
	}
	public Integer getHiddensubdivisionId() {
		return hiddensubdivisionId;
	}
	public void setHiddensubdivisionId(Integer hiddensubdivisionId) {
		this.hiddensubdivisionId = hiddensubdivisionId;
	}
	public Integer getHiddencaseTypeId() {
		return hiddencaseTypeId;
	}
	public void setHiddencaseTypeId(Integer hiddencaseTypeId) {
		this.hiddencaseTypeId = hiddencaseTypeId;
	}
	public Integer getHiddencaseGenSubId() {
		return hiddencaseGenSubId;
	}
	public void setHiddencaseGenSubId(Integer hiddencaseGenSubId) {
		this.hiddencaseGenSubId = hiddencaseGenSubId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public Integer getHiddenChildCase() {
		return hiddenChildCase;
	}
	public void setHiddenChildCase(Integer hiddenChildCase) {
		this.hiddenChildCase = hiddenChildCase;
	}
	public Integer getHiddenOrderId() {
		return hiddenOrderId;
	}
	public void setHiddenOrderId(Integer hiddenOrderId) {
		this.hiddenOrderId = hiddenOrderId;
	}
	private Integer caseTypeOrderId;
	public Integer getCaseTypeOrderId() {
		return caseTypeOrderId;
	}
	public void setCaseTypeOrderId(Integer caseTypeOrderId) {
		this.caseTypeOrderId = caseTypeOrderId;
	}
	private MultipartFile orderFile;
	
	
	public MultipartFile getOrderFile() {
		return orderFile;
	}
	public void setOrderFile(MultipartFile orderFile) {
		this.orderFile = orderFile;
	}
	public String getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(String caseNum) {
		this.caseNum = caseNum;
	}
	private String  caseGenSubName;
	private String  caseGeneral;
	public String getCaseGeneral() {
		return caseGeneral;
	}
	public void setCaseGeneral(String caseGeneral) {
		this.caseGeneral = caseGeneral;
	}
	private String caseStageName;
	private Integer caseStageId;
	
	private String contactPerson;
	private String phoneNumber;
	
	private Integer petOthers;
	
	private Integer resOthers;
	
	private  String draftdateconttoGP;
	
	private Integer isChildCase;
	
	private List<ContactPerson> contactPlist = new ArrayList<ContactPerson>();
	private List<Integer> resAdvIdlist = new ArrayList<Integer>();
	private List<Integer> resIdlist = new ArrayList<Integer>();
	private List<Integer> petAdvIdlist = new ArrayList<Integer>();
	private List<Integer> petIdlist = new ArrayList<Integer>();
	private List<CaseOrderStatus> CaseOrderStatusList = new ArrayList<CaseOrderStatus>();
	private List<CaseHearingDates> CaseHearingDatesList = new ArrayList<CaseHearingDates>();
	
	
	
	
	
	
	
	public List<Integer> getResAdvIdlist() {
		return resAdvIdlist;
	}
	public void setResAdvIdlist(List<Integer> resAdvIdlist) {
		this.resAdvIdlist = resAdvIdlist;
	}
	public List<Integer> getResIdlist() {
		return resIdlist;
	}
	public void setResIdlist(List<Integer> resIdlist) {
		this.resIdlist = resIdlist;
	}
	public List<Integer> getPetAdvIdlist() {
		return petAdvIdlist;
	}
	public void setPetAdvIdlist(List<Integer> petAdvIdlist) {
		this.petAdvIdlist = petAdvIdlist;
	}
	public List<Integer> getPetIdlist() {
		return petIdlist;
	}
	public void setPetIdlist(List<Integer> petIdlist) {
		this.petIdlist = petIdlist;
	}
	private Integer postgresUser;
	private String oracleUser;
	
	private String casesToFile;
	
	private Integer parentcaseId;
	private String parentcaseName;
	
	private Boolean caseDelete;
	private Boolean caseEdit;
	
	
	
	
	
	public Boolean getCaseEdit() {
		return caseEdit;
	}
	public void setCaseEdit(Boolean caseEdit) {
		this.caseEdit = caseEdit;
	}
	public Boolean getCaseDelete() {
		return caseDelete;
	}
	public void setCaseDelete(Boolean caseDelete) {
		this.caseDelete = caseDelete;
	}
	public String getCasesToFile() {
		return casesToFile;
	}
	public void setCasesToFile(String casesToFile) {
		this.casesToFile = casesToFile;
	}
	public Integer getPostgresUser() {
		return postgresUser;
	}
	public void setPostgresUser(Integer postgresUser) {
		this.postgresUser = postgresUser;
	}
	public String getOracleUser() {
		return oracleUser;
	}
	public void setOracleUser(String oracleUser) {
		this.oracleUser = oracleUser;
	}
	public Integer getIsChildCase() {
		return isChildCase;
	}
	public void setIsChildCase(Integer isChildCase) {
		this.isChildCase = isChildCase;
	}
	public String getDraftdateconttoGP() {
		return draftdateconttoGP;
	}
	public void setDraftdateconttoGP(String draftdateconttoGP) {
		this.draftdateconttoGP = draftdateconttoGP;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getHearingDate() {
		return hearingDate;
	}
	public void setHearingDate(String hearingDate) {
		this.hearingDate = hearingDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public List<CaseOrderStatus> getCaseOrderStatusList() {
		return CaseOrderStatusList;
	}
	public void setCaseOrderStatusList(List<CaseOrderStatus> caseOrderStatusList) {
		CaseOrderStatusList = caseOrderStatusList;
	}
	public List<CaseHearingDates> getCaseHearingDatesList() {
		return CaseHearingDatesList;
	}
	public void setCaseHearingDatesList(List<CaseHearingDates> caseHearingDatesList) {
		CaseHearingDatesList = caseHearingDatesList;
	}
	public Integer getPetOthers() {
		return petOthers;
	}
	public void setPetOthers(Integer petOthers) {
		this.petOthers = petOthers;
	}
	public Integer getResOthers() {
		return resOthers;
	}
	public void setResOthers(Integer resOthers) {
		this.resOthers = resOthers;
	}
	public Integer getCourtdistrictId() {
		return courtdistrictId;
	}
	public void setCourtdistrictId(Integer courtdistrictId) {
		this.courtdistrictId = courtdistrictId;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getCaseWpNumber() {
		return caseWpNumber;
	}
	public void setCaseWpNumber(String caseWpNumber) {
		this.caseWpNumber = caseWpNumber;
	}
	public Integer getCaseYear() {
		return caseYear;
	}
	public void setCaseYear(Integer caseYear) {
		this.caseYear = caseYear;
	}
	public Integer getCaseStatusId() {
		return caseStatusId;
	}
	public void setCaseStatusId(Integer caseStatusId) {
		this.caseStatusId = caseStatusId;
	}
	public boolean isCaseisLatest() {
		return caseisLatest;
	}
	public void setCaseisLatest(boolean caseisLatest) {
		this.caseisLatest = caseisLatest;
	}
	public Integer getCaseTypeId() {
		return caseTypeId;
	}
	public void setCaseTypeId(Integer caseTypeId) {
		this.caseTypeId = caseTypeId;
	}
	public Integer getCaseGenId() {
		return caseGenId;
	}
	public Integer getParentcaseId() {
		return parentcaseId;
	}
	public void setParentcaseId(Integer parentcaseId) {
		this.parentcaseId = parentcaseId;
	}
	public String getParentcaseName() {
		return parentcaseName;
	}
	public void setParentcaseName(String parentcaseName) {
		this.parentcaseName = parentcaseName;
	}
	public void setCaseGenId(Integer caseGenId) {
		this.caseGenId = caseGenId;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public Integer getUserId() {
		return userId;
	}
	public List<ContactPerson> getContactPlist() {
		return contactPlist;
	}
	public void setContactPlist(List<ContactPerson> contactPlist) {
		this.contactPlist = contactPlist;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCourtId() {
		return courtId;
	}
	public void setCourtId(Integer courtId) {
		this.courtId = courtId;
	}
	public String getBriefPrayer() {
		return briefPrayer;
	}
	public void setBriefPrayer(String briefPrayer) {
		this.briefPrayer = briefPrayer;
	}
	public String getFilingDate() {
		return filingDate;
	}
	public void setFilingDate(String filingDate) {
		this.filingDate = filingDate;
	}
	public String getCounterDate() {
		return counterDate;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCaseGenSubName() {
		return caseGenSubName;
	}
	public void setCaseGenSubName(String caseGenSubName) {
		this.caseGenSubName = caseGenSubName;
	}
	public String getCaseStageName() {
		return caseStageName;
	}
	public void setCaseStageName(String caseStageName) {
		this.caseStageName = caseStageName;
	}
	public Integer getCaseStageId() {
		return caseStageId;
	}
	public void setCaseStageId(Integer caseStageId) {
		this.caseStageId = caseStageId;
	}
	public Integer getPetitionerId() {
		return petitionerId;
	}
	public void setPetitionerId(Integer petitionerId) {
		this.petitionerId = petitionerId;
	}
	public Integer getCaseGenSubId() {
		return caseGenSubId;
	}
	public void setCaseGenSubId(Integer caseGenSubId) {
		this.caseGenSubId = caseGenSubId;
	}
	public Integer getPetetionerAdvId() {
		return petetionerAdvId;
	}
	public void setPetetionerAdvId(Integer petetionerAdvId) {
		this.petetionerAdvId = petetionerAdvId;
	}
	public Integer getRespondentId() {
		return respondentId;
	}
	public void setRespondentId(Integer respondentId) {
		this.respondentId = respondentId;
	}
	public Integer getRespondentAdvId() {
		return respondentAdvId;
	}
	public void setRespondentAdvId(Integer respondentAdvId) {
		this.respondentAdvId = respondentAdvId;
	}
	public void setCounterDate(String counterDate) {
		this.counterDate = counterDate;
	}
	public String getJudgementDate() {
		return judgementDate;
	}
	public void setJudgementDate(String judgementDate) {
		this.judgementDate = judgementDate;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getCircleId() {
		return circleId;
	}
	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}
	public Integer getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}
	public Integer getSubdivisionId() {
		return subdivisionId;
	}
	public void setSubdivisionId(Integer subdivisionId) {
		this.subdivisionId = subdivisionId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public String getPetitioner() {
		return petitioner;
	}
	public void setPetitioner(String petitioner) {
		this.petitioner = petitioner;
	}
	public String getPetetionerAdvocate() {
		return petetionerAdvocate;
	}
	public void setPetetionerAdvocate(String petetionerAdvocate) {
		this.petetionerAdvocate = petetionerAdvocate;
	}
	public String getRespondent() {
		return respondent;
	}
	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}
	public String getRespondentAdvocate() {
		return respondentAdvocate;
	}
	public void setRespondentAdvocate(String respondentAdvocate) {
		this.respondentAdvocate = respondentAdvocate;
	}
	public String getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getCourtName() {
		return courtName;
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getSubDivisionName() {
		return subDivisionName;
	}
	public void setSubDivisionName(String subDivisionName) {
		this.subDivisionName = subDivisionName;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Override
	public String toString() {
		return "Cases [caseId=" + caseId + ", caseWpNumber=" + caseWpNumber + ", caseYear=" + caseYear
				+ ", caseStatusId=" + caseStatusId + ", caseisLatest=" + caseisLatest + ", caseTypeId=" + caseTypeId
				+ ", caseGenId=" + caseGenId + ", deleteFlag=" + deleteFlag + ", Remarks=" + Remarks + ", userId="
				+ userId + ", courtId=" + courtId + ", briefPrayer=" + briefPrayer + ", filingDate=" + filingDate
				+ ", counterDate=" + counterDate + ", judgementDate=" + judgementDate + ", unitId=" + unitId
				+ ", circleId=" + circleId + ", divisionId=" + divisionId + ", subdivisionId=" + subdivisionId
				+ ", createdBy=" + createdBy + ", projectId=" + projectId + ", packageId=" + packageId + ", petitioner="
				+ petitioner + ", petetionerAdvocate=" + petetionerAdvocate + ", respondent=" + respondent
				+ ", respondentAdvocate=" + respondentAdvocate + ", caseStatus=" + caseStatus + ", caseType=" + caseType
				+ ", remarks=" + remarks + ", courtName=" + courtName + ", unitName=" + unitName + ", circleName="
				+ circleName + ", divisionName=" + divisionName + ", subDivisionName=" + subDivisionName
				+ ", packageName=" + packageName + ", projectName=" + projectName + ", petitionerId=" + petitionerId
				+ ", petetionerAdvId=" + petetionerAdvId + ", respondentId=" + respondentId + ", respondentAdvId="
				+ respondentAdvId + ", petitionerIdArray=" + petitionerIdArray + ", petetionerAdvIdArray="
				+ petetionerAdvIdArray + ", respondentIdArray=" + respondentIdArray + ", respondentAdvIdArray="
				+ respondentAdvIdArray + ", caseGenSubId=" + caseGenSubId + ", courtdistrictId=" + courtdistrictId
				+ ", caseNum=" + caseNum + ", orderDate=" + orderDate + ", hearingDate=" + hearingDate + ", fileName="
				+ fileName + ", filePath=" + filePath + ", hiddenOrderId=" + hiddenOrderId + ", hiddenChildCase="
				+ hiddenChildCase + ", contactName=" + contactName + ", contactPhone=" + contactPhone
				+ ", hiddenprojectId=" + hiddenprojectId + ", hiddenpackageId=" + hiddenpackageId + ", hiddencircleId="
				+ hiddencircleId + ", hiddendivisionId=" + hiddendivisionId + ", hiddensubdivisionId="
				+ hiddensubdivisionId + ", hiddencaseTypeId=" + hiddencaseTypeId + ", hiddencaseGenSubId="
				+ hiddencaseGenSubId + ", caseTypeOrderId=" + caseTypeOrderId + ", orderFile=" + orderFile
				+ ", caseGenSubName=" + caseGenSubName + ", caseGeneral=" + caseGeneral + ", caseStageName="
				+ caseStageName + ", caseStageId=" + caseStageId + ", contactPerson=" + contactPerson + ", phoneNumber="
				+ phoneNumber + ", petOthers=" + petOthers + ", resOthers=" + resOthers + ", draftdateconttoGP="
				+ draftdateconttoGP + ", isChildCase=" + isChildCase + ", contactPlist=" + contactPlist
				+ ", resAdvIdlist=" + resAdvIdlist + ", resIdlist=" + resIdlist + ", petAdvIdlist=" + petAdvIdlist
				+ ", petIdlist=" + petIdlist + ", CaseOrderStatusList=" + CaseOrderStatusList
				+ ", CaseHearingDatesList=" + CaseHearingDatesList + ", postgresUser=" + postgresUser + ", oracleUser="
				+ oracleUser + ", casesToFile=" + casesToFile + ", parentcaseId=" + parentcaseId + ", parentcaseName="
				+ parentcaseName + ", caseDelete=" + caseDelete + ", caseEdit=" + caseEdit + "]";
	}
	public String getPetitionerIdArray() {
		return petitionerIdArray;
	}
	public void setPetitionerIdArray(String petitionerIdArray) {
		this.petitionerIdArray = petitionerIdArray;
	}
	public String getPetetionerAdvIdArray() {
		return petetionerAdvIdArray;
	}
	public void setPetetionerAdvIdArray(String petetionerAdvIdArray) {
		this.petetionerAdvIdArray = petetionerAdvIdArray;
	}
	public String getRespondentIdArray() {
		return respondentIdArray;
	}
	public void setRespondentIdArray(String respondentIdArray) {
		this.respondentIdArray = respondentIdArray;
	}
	public String getRespondentAdvIdArray() {
		return respondentAdvIdArray;
	}
	public void setRespondentAdvIdArray(String respondentAdvIdArray) {
		this.respondentAdvIdArray = respondentAdvIdArray;
	}
	
	
	
	
	

}
