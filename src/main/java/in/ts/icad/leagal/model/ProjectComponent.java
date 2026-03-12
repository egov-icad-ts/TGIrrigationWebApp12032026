package in.ts.icad.leagal.model;

public class ProjectComponent {
	private Integer componentId;

	private String componentName;

	private Integer statusId;

	private String statusName;

	private Double reachFrom;

	private Double reachTo;

	public Double getReachFrom() {
		return reachFrom;
	}

	public void setReachFrom(Double reachFrom) {
		this.reachFrom = reachFrom;
	}

	public Double getReachTo() {
		return reachTo;
	}

	public void setReachTo(Double reachTo) {
		this.reachTo = reachTo;
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

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "ProjectComponent [componentId=" + componentId + ", componentName=" + componentName + ", statusId="
				+ statusId + ", statusName=" + statusName + ", reachFrom=" + reachFrom + ", reachTo=" + reachTo + "]";
	}


}
