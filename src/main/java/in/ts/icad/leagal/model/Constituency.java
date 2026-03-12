package in.ts.icad.leagal.model;

public class Constituency {
	
	private Integer constId;
	private String constName;
	private Integer acCode;
	private String statusCode;
	private String statusmodifyDate;
	private String dcode;
	private String acode;
	
	private Integer mandalId;
	
	
	
	
	
	
	public Integer getMandalId() {
		return mandalId;
	}
	public void setMandalId(Integer mandalId) {
		this.mandalId = mandalId;
	}
	public String getAcode() {
		return acode;
	}
	public void setAcode(String acode) {
		this.acode = acode;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusmodifyDate() {
		return statusmodifyDate;
	}
	public void setStatusmodifyDate(String statusmodifyDate) {
		this.statusmodifyDate = statusmodifyDate;
	}
	public String getDcode() {
		return dcode;
	}
	public void setDcode(String dcode) {
		this.dcode = dcode;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	private String mcode;
	
	
	
	
	
	
	
	public Integer getAcCode() {
		return acCode;
	}
	public void setAcCode(Integer acCode) {
		this.acCode = acCode;
	}
	public String getConstName() {
		return constName;
	}
	public void setConstName(String constName) {
		this.constName = constName;
	}
	private Integer districtId;
	public Integer getConstId() {
		return constId;
	}
	public void setConstId(Integer constId) {
		this.constId = constId;
	}
	
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	
	
    
}
