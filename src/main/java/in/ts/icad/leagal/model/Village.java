package in.ts.icad.leagal.model;

public class Village {

	private Integer	villageId;
	private String villageName;
	private String villageCode;
	private String mcode;
	private String dcode;
	private String statusCode;
	private String statusModifiedDate;
	
	private Integer mandalId;
	
	
	
	
	public Integer getMandalId() {
		return mandalId;
	}
	public void setMandalId(Integer mandalId) {
		this.mandalId = mandalId;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getDcode() {
		return dcode;
	}
	public void setDcode(String dcode) {
		this.dcode = dcode;
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
	public Integer getVillageId() {
		return villageId;
	}
	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getVillageCode() {
		return villageCode;
	}
	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}
}
