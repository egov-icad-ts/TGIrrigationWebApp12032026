package in.ts.icad.leagal.model;

import java.util.Date;

public class District {

	private Integer districtId;
	private String districtName;
	private String districtCode;
	private String statusCode;
	private String statmodifieddate;
	private String oldDistrictCode;
	
	
	
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatmodifieddate() {
		return statmodifieddate;
	}
	public void setStatmodifieddate(String statmodifieddate) {
		this.statmodifieddate = statmodifieddate;
	}
	public String getOldDistrictCode() {
		return oldDistrictCode;
	}
	public void setOldDistrictCode(String oldDistrictCode) {
		this.oldDistrictCode = oldDistrictCode;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
}
