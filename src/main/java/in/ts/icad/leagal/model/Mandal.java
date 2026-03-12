package in.ts.icad.leagal.model;

public class Mandal {

	private Integer mandalId;
	private String mandalName;
	private String mandalCode;
	private String districtCode;
	
	private String statusCode;
	
	private String statusModifiedDate;
	
	
	
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusModifiedDate() {
		return statusModifiedDate;
	}
	public void setStatusModifiedDate(String statusModifiedDate) {
		this.statusModifiedDate = statusModifiedDate;
	}
	public Integer getMandalId() {
		return mandalId;
	}
	public void setMandalId(Integer mandalId) {
		this.mandalId = mandalId;
	}
	public String getMandalName() {
		return mandalName;
	}
	public void setMandalName(String mandalName) {
		this.mandalName = mandalName;
	}
	public String getMandalCode() {
		return mandalCode;
	}
	public void setMandalCode(String mandalCode) {
		this.mandalCode = mandalCode;
	}
	
	
}
