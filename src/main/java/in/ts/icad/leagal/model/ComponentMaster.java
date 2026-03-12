package in.ts.icad.leagal.model;

public class ComponentMaster {

	
	
	private Integer componentid;
	private String componentName;
	private Integer unitId;
	private String unitName;
	private Integer packageId;
	private Integer parentId;
	
	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getComponentid() {
		return componentid;
	}
	public void setComponentid(Integer componentid) {
		this.componentid = componentid;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	@Override
	public String toString() {
		return "ComponentMaster [componentid=" + componentid + ", componentName=" + componentName + ", unitId=" + unitId
				+ ", unitName=" + unitName + ", packageId=" + packageId + ", parentId=" + parentId + "]";
	}
	
	
	
}
