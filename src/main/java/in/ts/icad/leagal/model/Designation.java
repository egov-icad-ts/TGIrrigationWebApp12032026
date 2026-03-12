package in.ts.icad.leagal.model;

public class Designation {
	
	private Integer designationId;
	
	private Integer hierarchy ;
	
	private String designation_type;
	
	
	
	public Integer getHierarchy() {
		return hierarchy;
	}
	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}
	public String getDesignation_type() {
		return designation_type;
	}
	public void setDesignation_type(String designation_type) {
		this.designation_type = designation_type;
	}
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
	private String  designationName;
	
	

}
