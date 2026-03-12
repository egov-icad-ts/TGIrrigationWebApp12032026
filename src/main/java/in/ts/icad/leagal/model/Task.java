package in.ts.icad.leagal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Task {
	
	
	@Override
	public String toString() {
		return "Task [projectId=" + projectId + ", packageId=" + packageId + ", priorId=" + priorId + ", statusId="
				+ statusId + ", responsibleEmpId=" + responsibleEmpId + ", assignedDate=" + assignedDate
				+ ", targetDate=" + targetDate + ", upfile=" + upfile + ", subject=" + subject + ", remarks=" + remarks
				+ ", empId=" + empId + ", employeeName=" + employeeName + ", designationId=" + designationId
				+ ", designationName=" + designationName + ", phoneNum1=" + phoneNum1 + ", phoneNum2=" + phoneNum2
				+ ", emailId=" + emailId + ", unitId=" + unitId + ", circleId=" + circleId + ", divisionId="
				+ divisionId + ", subdivisionId=" + subdivisionId + ", taskTypeId=" + taskTypeId + ", taskTypeName="
				+ taskTypeName + ", responsibleName=" + responsibleName + ", userpost=" + userpost + ", allfilenames="
				+ allfilenames + ", filelocation=" + filelocation + ", taskId=" + taskId + ", projectName="
				+ projectName + ", packageName=" + packageName + ", unitName=" + unitName + ", circleName=" + circleName
				+ ", divisionName=" + divisionName + ", subdivisionName=" + subdivisionName + ", priorityName="
				+ priorityName + ", statusName=" + statusName + ", typeName=" + typeName + ", hiddentaskTypeId="
				+ hiddentaskTypeId + ", urlvalue=" + urlvalue + ", responsibleSEId=" + responsibleSEId
				+ ", responsibleEEId=" + responsibleEEId + ", responsibleDEEId=" + responsibleDEEId
				+ ", responsibleAEEId=" + responsibleAEEId + ", filedataList=" + filedataList + ", useroracle="
				+ useroracle + ", priority=" + priority + ", status=" + status + "]";
	}
	private Integer projectId;
	private Integer packageId;
	private Integer priorId;
	private Integer statusId;
	private Integer responsibleEmpId;
	private String assignedDate;
	private String targetDate;
	private List<MultipartFile> upfile;
	
	private String subject;
	private String remarks;
	
	private String empId;
	private String employeeName;
	private String designationId;
	private String designationName;
	private String phoneNum1;
	private String phoneNum2;
	private String emailId;
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	private Integer subdivisionId;
	private Integer taskTypeId;
	private String taskTypeName;
	private String responsibleName;
	private String userpost;
	private String allfilenames;
	private String filelocation;
	private Integer taskId;
	private String projectName;
	private String packageName;
	private  String unitName;
	private String circleName;
	private String divisionName;
	private String subdivisionName;
	private String priorityName;
	private String statusName;
	private String typeName;
	private Integer  hiddentaskTypeId;
	private String urlvalue;
	private Boolean deleteFlag;
	
	private Integer officeType;
	
	public Integer getOfficeType() {
		return officeType;
	}
	public void setOfficeType(Integer officeType) {
		this.officeType = officeType;
	}
	private Integer editNumber;
	public Integer getEditNumber() {
		return editNumber;
	}
	public void setEditNumber(Integer editNumber) {
		this.editNumber = editNumber;
	}
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Boolean getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(Boolean editFlag) {
		this.editFlag = editFlag;
	}
	private Boolean editFlag;
	
	
	private String responsibleSEName;
	public String getResponsibleSEName() {
		return responsibleSEName;
	}
	public void setResponsibleSEName(String responsibleSEName) {
		this.responsibleSEName = responsibleSEName;
	}
	public String getResponsibleEEName() {
		return responsibleEEName;
	}
	public void setResponsibleEEName(String responsibleEEName) {
		this.responsibleEEName = responsibleEEName;
	}
	public String getResponsibleDEEName() {
		return responsibleDEEName;
	}
	public void setResponsibleDEEName(String responsibleDEEName) {
		this.responsibleDEEName = responsibleDEEName;
	}
	public String getResponsibleAEEName() {
		return responsibleAEEName;
	}
	public void setResponsibleAEEName(String responsibleAEEName) {
		this.responsibleAEEName = responsibleAEEName;
	}
	private String responsibleEEName;
	private String responsibleDEEName;
	private String responsibleAEEName;
	
	
	
	
	private Integer  responsibleSEId;
	private Integer  responsibleEEId;
	private Integer  responsibleDEEId;
	private Integer  responsibleAEEId;
	
	private Integer hiddenresSEId;
	private Integer hiddenresEEId;
	private Integer hiddenresDEEId;
	private Integer hiddenresAEEId;
	
	private Integer responsibleSEEmpId;
	private Integer responsibleEEEmpId;
	private Integer responsibleDEEEmpId;
	
	private String unitRemarks;
	private String circleRemarks;
	private String divisionRemarks;
	private String subdivisionRemarks;
	private String aeeRemarks;
	
	
	public String getUnitRemarks() {
		return unitRemarks;
	}
	public void setUnitRemarks(String unitRemarks) {
		this.unitRemarks = unitRemarks;
	}
	public String getCircleRemarks() {
		return circleRemarks;
	}
	public void setCircleRemarks(String circleRemarks) {
		this.circleRemarks = circleRemarks;
	}
	public String getDivisionRemarks() {
		return divisionRemarks;
	}
	public void setDivisionRemarks(String divisionRemarks) {
		this.divisionRemarks = divisionRemarks;
	}
	public String getSubdivisionRemarks() {
		return subdivisionRemarks;
	}
	public void setSubdivisionRemarks(String subdivisionRemarks) {
		this.subdivisionRemarks = subdivisionRemarks;
	}
	public String getAeeRemarks() {
		return aeeRemarks;
	}
	public void setAeeRemarks(String aeeRemarks) {
		this.aeeRemarks = aeeRemarks;
	}
	public Integer getResponsibleSEEmpId() {
		return responsibleSEEmpId;
	}
	public void setResponsibleSEEmpId(Integer responsibleSEEmpId) {
		this.responsibleSEEmpId = responsibleSEEmpId;
	}
	public Integer getResponsibleEEEmpId() {
		return responsibleEEEmpId;
	}
	public void setResponsibleEEEmpId(Integer responsibleEEEmpId) {
		this.responsibleEEEmpId = responsibleEEEmpId;
	}
	public Integer getResponsibleDEEEmpId() {
		return responsibleDEEEmpId;
	}
	public void setResponsibleDEEEmpId(Integer responsibleDEEEmpId) {
		this.responsibleDEEEmpId = responsibleDEEEmpId;
	}
	public Integer getResponsibleAEEEmpId() {
		return responsibleAEEEmpId;
	}
	public void setResponsibleAEEEmpId(Integer responsibleAEEEmpId) {
		this.responsibleAEEEmpId = responsibleAEEEmpId;
	}
	private Integer responsibleAEEEmpId;
	
	
	public Integer getHiddenresSEId() {
		return hiddenresSEId;
	}
	public void setHiddenresSEId(Integer hiddenresSEId) {
		this.hiddenresSEId = hiddenresSEId;
	}
	public Integer getHiddenresEEId() {
		return hiddenresEEId;
	}
	public void setHiddenresEEId(Integer hiddenresEEId) {
		this.hiddenresEEId = hiddenresEEId;
	}
	public Integer getHiddenresDEEId() {
		return hiddenresDEEId;
	}
	public void setHiddenresDEEId(Integer hiddenresDEEId) {
		this.hiddenresDEEId = hiddenresDEEId;
	}
	public Integer getHiddenresAEEId() {
		return hiddenresAEEId;
	}
	public void setHiddenresAEEId(Integer hiddenresAEEId) {
		this.hiddenresAEEId = hiddenresAEEId;
	}
	public Integer getResponsibleSEId() {
		return responsibleSEId;
	}
	public void setResponsibleSEId(Integer responsibleSEId) {
		this.responsibleSEId = responsibleSEId;
	}
	public Integer getResponsibleEEId() {
		return responsibleEEId;
	}
	public void setResponsibleEEId(Integer responsibleEEId) {
		this.responsibleEEId = responsibleEEId;
	}
	public Integer getResponsibleDEEId() {
		return responsibleDEEId;
	}
	public void setResponsibleDEEId(Integer responsibleDEEId) {
		this.responsibleDEEId = responsibleDEEId;
	}
	public Integer getResponsibleAEEId() {
		return responsibleAEEId;
	}
	public void setResponsibleAEEId(Integer responsibleAEEId) {
		this.responsibleAEEId = responsibleAEEId;
	}
	public String getUrlvalue() {
		return urlvalue;
	}
	public void setUrlvalue(String urlvalue) {
		this.urlvalue = urlvalue;
	}
	public Integer getHiddentaskTypeId() {
		return hiddentaskTypeId;
	}
	public void setHiddentaskTypeId(Integer hiddentaskTypeId) {
		this.hiddentaskTypeId = hiddentaskTypeId;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	private List<TaskFiles> filedataList;
	
	
	public List<TaskFiles> getFiledataList() {
		return filedataList;
	}
	public void setFiledataList(List<TaskFiles> filedataList) {
		this.filedataList = filedataList;
	}
	public String getAllfilenames() {
		return allfilenames;
	}
	public void setAllfilenames(String allfilenames) {
		this.allfilenames = allfilenames;
	}
	public String getFilelocation() {
		return filelocation;
	}
	public void setFilelocation(String filelocation) {
		this.filelocation = filelocation;
	}
	public List<MultipartFile> getUpfile() {
		return upfile;
	}
	public void setUpfile(List<MultipartFile> upfile) {
		this.upfile = upfile;
	}
	public String getUserpost() {
		return userpost;
	}
	public void setUserpost(String userpost) {
		this.userpost = userpost;
	}
	public String getUseroracle() {
		return useroracle;
	}
	public void setUseroracle(String useroracle) {
		this.useroracle = useroracle;
	}
	private String useroracle;
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
	public String getPriorityName() {
		return priorityName;
	}
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getResponsibleName() {
		return responsibleName;
	}
	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}
	private String priority;
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;

	
	
	
	public Integer getTaskTypeId() {
		return taskTypeId;
	}
	public void setTaskTypeId(Integer taskTypeId) {
		this.taskTypeId = taskTypeId;
	}
	public String getTaskTypeName() {
		return taskTypeName;
	}
	public void setTaskTypeName(String taskTypeName) {
		this.taskTypeName = taskTypeName;
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
	public Integer getPriorId() {
		return priorId;
	}
	public void setPriorId(Integer priorId) {
		this.priorId = priorId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getResponsibleEmpId() {
		return responsibleEmpId;
	}
	public void setResponsibleEmpId(Integer responsibleEmpId) {
		this.responsibleEmpId = responsibleEmpId;
	}
	public String getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}


	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignationId() {
		return designationId;
	}
	public void setDesignationId(String designationId) {
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

	
	

}
