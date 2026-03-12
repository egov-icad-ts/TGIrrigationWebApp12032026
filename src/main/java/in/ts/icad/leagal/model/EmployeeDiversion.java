package in.ts.icad.leagal.model;

public class EmployeeDiversion {
	
	private String empId;
	private Long actualPostId;
	private Integer unitId;
	private Integer circleId;
	
	private Integer divisionId;
	private Integer subdivisionId;
	private Integer sectionId;
	private String odFromDate;
	private String odToDate;
	private Long postId;
	private Integer designationId;
	private Integer empDivId;
	private String isLatest;
	private String isDelete;
	private String otherOfficeDetails;
	private String odType;
	private String cancelledRefDate;
	private String cancelledOn;
	private String cancelledSubmittedDate;
	
	
	public String getCancelledRefDate() {
		return cancelledRefDate;
	}

	public void setCancelledRefDate(String cancelledRefDate) {
		this.cancelledRefDate = cancelledRefDate;
	}

	

	public String getCancelledOn() {
		return cancelledOn;
	}

	public void setCancelledOn(String cancelledOn) {
		this.cancelledOn = cancelledOn;
	}

	public String getCancelledSubmittedDate() {
		return cancelledSubmittedDate;
	}

	public void setCancelledSubmittedDate(String cancelledSubmittedDate) {
		this.cancelledSubmittedDate = cancelledSubmittedDate;
	}

	@Override
	public String toString() {
		return "EmployeeDiversion [empId=" + empId + ", actualPostId=" + actualPostId + ", unitId=" + unitId
				+ ", circleId=" + circleId + ", divisionId=" + divisionId + ", subdivisionId=" + subdivisionId
				+ ", sectionId=" + sectionId + ", odFromDate=" + odFromDate + ", odToDate=" + odToDate + ", postId="
				+ postId + ", designationId=" + designationId + ", empDivId=" + empDivId + ", isLatest=" + isLatest
				+ ", isDelete=" + isDelete + ", otherOfficeDetails=" + otherOfficeDetails + ", odType=" + odType
				+ ", cancelledRefDate=" + cancelledRefDate + ", cancelledOn=" + cancelledOn
				+ ", cancelledSubmittedDate=" + cancelledSubmittedDate + "]";
	}

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Long getActualPostId() {
		return actualPostId;
	}
	public void setActualPostId(Long actualPostId) {
		this.actualPostId = actualPostId;
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
	public Integer getSectionId() {
		return sectionId;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	public String getOdFromDate() {
		return odFromDate;
	}
	public void setOdFromDate(String odFromDate) {
		this.odFromDate = odFromDate;
	}
	public String getOdToDate() {
		return odToDate;
	}
	public void setOdToDate(String odToDate) {
		this.odToDate = odToDate;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public Integer getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}
	public Integer getEmpDivId() {
		return empDivId;
	}
	public void setEmpDivId(Integer empDivId) {
		this.empDivId = empDivId;
	}
	public String getIsLatest() {
		return isLatest;
	}
	public void setIsLatest(String isLatest) {
		this.isLatest = isLatest;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getOtherOfficeDetails() {
		return otherOfficeDetails;
	}
	public void setOtherOfficeDetails(String otherOfficeDetails) {
		this.otherOfficeDetails = otherOfficeDetails;
	}
	public String getOdType() {
		return odType;
	}
	public void setOdType(String odType) {
		this.odType = odType;
	}

	
	

}
