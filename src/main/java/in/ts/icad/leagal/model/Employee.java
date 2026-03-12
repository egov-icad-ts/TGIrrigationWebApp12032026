package in.ts.icad.leagal.model;

public class Employee {
	
private Integer  empId;
private String employeeName;
private Integer designationId;
private String designationName;
private String phoneNum1;
private String phoneNum2;
private String emailId;
private Integer unitId;
private Integer circleId;
private Integer divisionId;
private Integer subdivisionId;
private Long postId;
private String firstName;
private String lastName;
private Integer userId;

private Integer empStatus;

private String fromDate;
private String toDate;
private String postType;

private Integer sectionId;


private String postFromDate;
private String workType;
private String updateStatus;

private Long postNo;
private Integer status;
private Integer headquarterId;

public Long getPostNo() {
	return postNo;
}
public void setPostNo(Long postNo) {
	this.postNo = postNo;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Integer getHeadquarterId() {
	return headquarterId;
}
public void setHeadquarterId(Integer headquarterId) {
	this.headquarterId = headquarterId;
}

public Long getOldPostId() {
	return oldPostId;
}
public void setOldPostId(Long oldPostId) {
	this.oldPostId = oldPostId;
}
public String getEffectiveFrom() {
	return effectiveFrom;
}
public void setEffectiveFrom(String effectiveFrom) {
	this.effectiveFrom = effectiveFrom;
}
private Long oldPostId;
private String effectiveFrom;

private Integer OfficeId;

private String postName;

private String postStatus;

private Integer presentStatusId;







public Integer getPresentStatusId() {
	return presentStatusId;
}
public void setPresentStatusId(Integer presentStatusId) {
	this.presentStatusId = presentStatusId;
}
public String getPostStatus() {
	return postStatus;
}
public void setPostStatus(String postStatus) {
	this.postStatus = postStatus;
}
public String getPostName() {
	return postName;
}
public void setPostName(String postName) {
	this.postName = postName;
}
public Integer getOfficeId() {
	return OfficeId;
}
public void setOfficeId(Integer officeId) {
	OfficeId = officeId;
}
public String getPostFromDate() {
	return postFromDate;
}
public void setPostFromDate(String postFromDate) {
	this.postFromDate = postFromDate;
}
public String getWorkType() {
	return workType;
}
public void setWorkType(String workType) {
	this.workType = workType;
}
public String getUpdateStatus() {
	return updateStatus;
}
public void setUpdateStatus(String updateStatus) {
	this.updateStatus = updateStatus;
}
public String getFromDate() {
	return fromDate;
}
public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}
public String getToDate() {
	return toDate;
}
public void setToDate(String toDate) {
	this.toDate = toDate;
}
public String getPostType() {
	return postType;
}
public void setPostType(String postType) {
	this.postType = postType;
}
public Integer getSectionId() {
	return sectionId;
}
public void setSectionId(Integer sectionId) {
	this.sectionId = sectionId;
}
public Integer getEmpStatus() {
	return empStatus;
}
public void setEmpStatus(Integer empStatus) {
	this.empStatus = empStatus;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public Integer getUserName() {
	return userName;
}
public void setUserName(Integer userName) {
	this.userName = userName;
}
private Integer userName;
public Long getPostId() {
	
	return postId;
}
public void setPostId(Long postId) {
	this.postId = postId;
}
public Long getHrmsId() {
	return hrmsId;
}
public void setHrmsId(Long hrmsId) {
	this.hrmsId = hrmsId;
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
public String getSubdivisionName() {
	return subdivisionName;
}
public void setSubdivisionName(String subdivisionName) {
	this.subdivisionName = subdivisionName;
}
private Long hrmsId;
private String  unitName;
private String circleName;
private String  divisionName;
private String subdivisionName;



public Integer getDesignationId() {
	return designationId;
}
public void setDesignationId(Integer designationId) {
	this.designationId = designationId;
}
public String getDesignationName() {
	return designationName;
}
public void setDesignationName(String designationName) {
	this.designationName = designationName;
}
public String getPhoneNum1() {
	return phoneNum1;
}
public void setPhoneNum1(String phoneNum1) {
	this.phoneNum1 = phoneNum1;
}
public String getPhoneNum2() {
	return phoneNum2;
}
public void setPhoneNum2(String phoneNum2) {
	this.phoneNum2 = phoneNum2;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public Integer getUnitId() {
	return unitId;
}
public void setUnitId(Integer unitId) {
	this.unitId = unitId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
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
public Integer getEmpId() {
	return empId;
}
public void setEmpId(Integer empId) {
	this.empId = empId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", employeeName=" + employeeName + ", designationId=" + designationId
			+ ", designationName=" + designationName + ", phoneNum1=" + phoneNum1 + ", phoneNum2=" + phoneNum2
			+ ", emailId=" + emailId + ", unitId=" + unitId + ", circleId=" + circleId + ", divisionId=" + divisionId
			+ ", subdivisionId=" + subdivisionId + ", postId=" + postId + ", firstName=" + firstName + ", lastName="
			+ lastName + ", userId=" + userId + ", userName=" + userName + ", hrmsId=" + hrmsId + ", unitName="
			+ unitName + ", circleName=" + circleName + ", divisionName=" + divisionName + ", subdivisionName="
			+ subdivisionName + "]";
}

}
