package in.ts.icad.leagal.model;

public class ComponentsCapacity {
	
	private Integer componentId;
	private String componentName;
	private Double smallconnected;
	private Double smallactual;
	private Double mediumconnected;
	private Double mediumactual;
	private Double majorconnected;
	private Double majoractual;
	private Double totalsmallconnected;
	private Double totalsmallactual;
	private Double totalmajorconnected;
	private Double totalmajoractual;
	private Double totalmediumconnected;
	private Double totalmediumacttual;
	private Integer statusId;
	private Integer userId;
	private Integer projectid;
	
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProjectid() {
		return projectid;
	}
	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}
	public Integer getComponentId() {
		return componentId;
	}
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public Double getSmallconnected() {
		return smallconnected;
	}
	public void setSmallconnected(Double smallconnected) {
		this.smallconnected = smallconnected;
	}
	public Double getSmallactual() {
		return smallactual;
	}
	public void setSmallactual(Double smallactual) {
		this.smallactual = smallactual;
	}
	public Double getMediumconnected() {
		return mediumconnected;
	}
	public void setMediumconnected(Double mediumconnected) {
		this.mediumconnected = mediumconnected;
	}
	public Double getMediumactual() {
		return mediumactual;
	}
	public void setMediumactual(Double mediumactual) {
		this.mediumactual = mediumactual;
	}
	public Double getMajorconnected() {
		return majorconnected;
	}
	public void setMajorconnected(Double majorconnected) {
		this.majorconnected = majorconnected;
	}
	public Double getMajoractual() {
		return majoractual;
	}
	public void setMajoractual(Double majoractual) {
		this.majoractual = majoractual;
	}
	public Double getTotalsmallconnected() {
		return totalsmallconnected;
	}
	public void setTotalsmallconnected(Double totalsmallconnected) {
		this.totalsmallconnected = totalsmallconnected;
	}
	public Double getTotalsmallactual() {
		return totalsmallactual;
	}
	public void setTotalsmallactual(Double totalsmallactual) {
		this.totalsmallactual = totalsmallactual;
	}
	public Double getTotalmajorconnected() {
		return totalmajorconnected;
	}
	public void setTotalmajorconnected(Double totalmajorconnected) {
		this.totalmajorconnected = totalmajorconnected;
	}
	public Double getTotalmajoractual() {
		return totalmajoractual;
	}
	public void setTotalmajoractual(Double totalmajoractual) {
		this.totalmajoractual = totalmajoractual;
	}
	public Double getTotalmediumconnected() {
		return totalmediumconnected;
	}
	public void setTotalmediumconnected(Double totalmediumconnected) {
		this.totalmediumconnected = totalmediumconnected;
	}
	public Double getTotalmediumacttual() {
		return totalmediumacttual;
	}
	public void setTotalmediumacttual(Double totalmediumacttual) {
		this.totalmediumacttual = totalmediumacttual;
	}
	@Override
	public String toString() {
		return "ComponentsCapacity [componentId=" + componentId + ", componentName=" + componentName
				+ ", smallconnected=" + smallconnected + ", smallactual=" + smallactual + ", mediumconnected="
				+ mediumconnected + ", mediumactual=" + mediumactual + ", majorconnected=" + majorconnected
				+ ", majoractual=" + majoractual + ", totalsmallconnected=" + totalsmallconnected
				+ ", totalsmallactual=" + totalsmallactual + ", totalmajorconnected=" + totalmajorconnected
				+ ", totalmajoractual=" + totalmajoractual + ", totalmediumconnected=" + totalmediumconnected
				+ ", totalmediumacttual=" + totalmediumacttual + "]";
	}

}
