package in.ts.icad.leagal.model;

public class officeDataSend {
	
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	private String latestemailId ;
	private Integer userId;
	private String  userName;
	private String  pwd;
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public String getLatestemailId() {
		return latestemailId;
	}
	public void setLatestemailId(String latestemailId) {
		this.latestemailId = latestemailId;
	}
	@Override
	public String toString() {
		return "officeDataSend [unitId=" + unitId + ", circleId=" + circleId + ", divisionId=" + divisionId
				+ ", latestemailId=" + latestemailId + "]";
	}
	
	

}
