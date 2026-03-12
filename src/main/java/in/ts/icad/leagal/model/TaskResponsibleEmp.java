package in.ts.icad.leagal.model;

public class TaskResponsibleEmp {
	
	private Integer responsibleEmpId;
	private String responsibleEmpName;
	private Integer designationId;
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	private Integer subdivisionId;
	
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
	public Integer getResponsibleEmpId() {
		return responsibleEmpId;
	}
	public void setResponsibleEmpId(Integer responsibleEmpId) {
		this.responsibleEmpId = responsibleEmpId;
	}
	public String getResponsibleEmpName() {
		return responsibleEmpName;
	}
	public void setResponsibleEmpName(String responsibleEmpName) {
		this.responsibleEmpName = responsibleEmpName;
	}
	@Override
	public String toString() {
		return "TaskResponsibleEmp [responsibleEmpId=" + responsibleEmpId + ", responsibleEmpName=" + responsibleEmpName
				+ ", designationId=" + designationId + ", unitId=" + unitId + ", circleId=" + circleId + ", divisionId="
				+ divisionId + ", subdivisionId=" + subdivisionId + "]";
	}
	

}
