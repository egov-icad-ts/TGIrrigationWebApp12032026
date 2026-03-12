package in.ts.icad.leagal.model;

public class EmpApprove {
	
	private Integer empId;
	private String empName;
	private Integer designationId;
	private Integer unitId;
	private Integer circleId;
	
	private Integer sectionId;
	
	
	
	private Long postId;
	
	
	
	public Long getPostId() {
		return postId;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	private Integer divisionId;
	
	private Integer subdivisionId;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
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

	@Override
	public String toString() {
		return "EmpApprove [empId=" + empId + ", empName=" + empName + ", designationId=" + designationId + ", unitId="
				+ unitId + ", circleId=" + circleId + ", divisionId=" + divisionId + ", subdivisionId=" + subdivisionId
				+ "]";
	}
	
	
	
	
	

}
