package in.ts.icad.leagal.model;

import java.util.List;

public class ScheduleDuty {
	
	private Integer dutyDesignationMapId;
	
	private Integer dutyId;
	
	private String  dutyName;
	
	private Integer designationId;
	
	private Integer parentDutyId;
	
	private Boolean parentHasChild;
	
	private Integer dutyDisplaySeq;
	
	private Integer  dutyFrequencyId;
	
	private String dutyFrequency;
	
	private String designationName;
	
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	
	private Integer subdivisionId;
	private Integer reservoirId;
	private Integer projectId;
	
	private Integer scheduleCheckboxId;
	
	private Boolean  actionId;
	private String  action;
	
	private Integer actionReqId;
	
	private String actionReqName;
	
	public String getActionReqName() {
		return actionReqName;
	}

	public void setActionReqName(String actionReqName) {
		this.actionReqName = actionReqName;
	}

	private String resCode;
	
	private String remarks;
	
	private Integer approveStatusId;
	
	private String fromDate1;
	
	private String fromDate2;
	
	private String resName;
	
	private String unitName;
	
	private Integer aeedailyCount;
	
	private Integer aeeweeklycount;
	
	private String weekstartDate;
	private String weekendDate;
	
	private Integer totalDutyCount;
	
	
	private Integer dutyInspectId;
	
	private String dutyparentName;
	
	private String approveStatus;
	
	private String readingValue;
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	public String getReadingValue() {
		return readingValue;
	}

	public void setReadingValue(String readingValue) {
		this.readingValue = readingValue;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getDutyparentName() {
		return dutyparentName;
	}

	public void setDutyparentName(String dutyparentName) {
		this.dutyparentName = dutyparentName;
	}

	public Integer getDutyInspectId() {
		return dutyInspectId;
	}

	public void setDutyInspectId(Integer dutyInspectId) {
		this.dutyInspectId = dutyInspectId;
	}

	public Integer getTotalDutyCount() {
		return totalDutyCount;
	}

	public void setTotalDutyCount(Integer totalDutyCount) {
		this.totalDutyCount = totalDutyCount;
	}

	public Integer getAeedailyCount() {
		return aeedailyCount;
	}

	public void setAeedailyCount(Integer aeedailyCount) {
		this.aeedailyCount = aeedailyCount;
	}

	public Integer getAeeweeklycount() {
		return aeeweeklycount;
	}

	public void setAeeweeklycount(Integer aeeweeklycount) {
		this.aeeweeklycount = aeeweeklycount;
	}

	public String getWeekstartDate() {
		return weekstartDate;
	}

	public void setWeekstartDate(String weekstartDate) {
		this.weekstartDate = weekstartDate;
	}

	public String getWeekendDate() {
		return weekendDate;
	}

	public void setWeekendDate(String weekendDate) {
		this.weekendDate = weekendDate;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getFromDate1() {
		return fromDate1;
	}

	public void setFromDate1(String fromDate1) {
		this.fromDate1 = fromDate1;
	}

	public String getFromDate2() {
		return fromDate2;
	}

	public void setFromDate2(String fromDate2) {
		this.fromDate2 = fromDate2;
	}

	public Integer getApproveStatusId() {
		return approveStatusId;
	}

	public void setApproveStatusId(Integer approveStatusId) {
		this.approveStatusId = approveStatusId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public Boolean getActionId() {
		return actionId;
	}

	public void setActionId(Boolean actionId) {
		this.actionId = actionId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getActionReqId() {
		return actionReqId;
	}

	public void setActionReqId(Integer actionReqId) {
		this.actionReqId = actionReqId;
	}

	private String inspectDate;
	
	public String getInspectDate() {
		return inspectDate;
	}

	public void setInspectDate(String inspectDate) {
		this.inspectDate = inspectDate;
	}

	public Integer getScheduleCheckboxId() {
		return scheduleCheckboxId;
	}

	public void setScheduleCheckboxId(Integer scheduleCheckboxId) {
		this.scheduleCheckboxId = scheduleCheckboxId;
	}

	private List<ScheduleDuty> resScheduleDutyList;
	
	
	
	
	
	public List<ScheduleDuty> getResScheduleDutyList() {
		return resScheduleDutyList;
	}

	public void setResScheduleDutyList(List<ScheduleDuty> resScheduleDutyList) {
		this.resScheduleDutyList = resScheduleDutyList;
	}

	public Integer getReservoirId() {
		return reservoirId;
	}

	public void setReservoirId(Integer reservoirId) {
		this.reservoirId = reservoirId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	private Integer userId;
	
	public Integer getSubdivisionId() {
		return subdivisionId;
	}

	public void setSubdivisionId(Integer subdivisionId) {
		this.subdivisionId = subdivisionId;
	}

	public Integer getDutyDesignationMapId() {
		return dutyDesignationMapId;
	}

	public void setDutyDesignationMapId(Integer dutyDesignationMapId) {
		this.dutyDesignationMapId = dutyDesignationMapId;
	}

	public Integer getDutyId() {
		return dutyId;
	}

	public void setDutyId(Integer dutyId) {
		this.dutyId = dutyId;
	}

	@Override
	public String toString() {
		return "ScheduleDuty [dutyDesignationMapId=" + dutyDesignationMapId + ", dutyId=" + dutyId + ", dutyName="
				+ dutyName + ", designationId=" + designationId + ", parentDutyId=" + parentDutyId + ", parentHasChild="
				+ parentHasChild + ", dutyDisplaySeq=" + dutyDisplaySeq + ", dutyFrequencyId=" + dutyFrequencyId
				+ ", dutyFrequency=" + dutyFrequency + ", designationName=" + designationName + ", unitId=" + unitId
				+ ", circleId=" + circleId + ", divisionId=" + divisionId + ", subdivisionId=" + subdivisionId
				+ ", reservoirId=" + reservoirId + ", projectId=" + projectId + ", scheduleCheckboxId="
				+ scheduleCheckboxId + ", actionId=" + actionId + ", action=" + action + ", actionReqId=" + actionReqId
				+ ", resCode=" + resCode + ", remarks=" + remarks + ", approveStatusId=" + approveStatusId
				+ ", inspectDate=" + inspectDate + ", resScheduleDutyList=" + resScheduleDutyList + ", userId=" + userId
				+ ", userName=" + userName + "]";
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	public Integer getParentDutyId() {
		return parentDutyId;
	}

	public void setParentDutyId(Integer parentDutyId) {
		this.parentDutyId = parentDutyId;
	}

	public Boolean getParentHasChild() {
		return parentHasChild;
	}

	public void setParentHasChild(Boolean parentHasChild) {
		this.parentHasChild = parentHasChild;
	}

	public Integer getDutyDisplaySeq() {
		return dutyDisplaySeq;
	}

	public void setDutyDisplaySeq(Integer dutyDisplaySeq) {
		this.dutyDisplaySeq = dutyDisplaySeq;
	}

	public Integer getDutyFrequencyId() {
		return dutyFrequencyId;
	}

	public void setDutyFrequencyId(Integer dutyFrequencyId) {
		this.dutyFrequencyId = dutyFrequencyId;
	}

	public String getDutyFrequency() {
		return dutyFrequency;
	}

	public void setDutyFrequency(String dutyFrequency) {
		this.dutyFrequency = dutyFrequency;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
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

	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String userName;





	
	
	
	

}
