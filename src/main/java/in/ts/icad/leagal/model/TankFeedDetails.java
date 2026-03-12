package in.ts.icad.leagal.model;

public class TankFeedDetails {
	
	private Integer tankId;
	private Boolean canfeed ;
	private Integer feedtankCount;
	private Integer cannotfeedtankCount;
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	private Integer subdivisionId;
	private Integer tankdataCount;
	private String unitName;
	private String circleName;
	private String divisionName;
	private String subdivisionName;
	private String userName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getTankId() {
		return tankId;
	}
	public void setTankId(Integer tankId) {
		this.tankId = tankId;
	}
	public Boolean getCanfeed() {
		return canfeed;
	}
	public void setCanfeed(Boolean canfeed) {
		this.canfeed = canfeed;
	}
	public Integer getFeedtankCount() {
		return feedtankCount;
	}
	public void setFeedtankCount(Integer feedtankCount) {
		this.feedtankCount = feedtankCount;
	}
	public Integer getCannotfeedtankCount() {
		return cannotfeedtankCount;
	}
	public void setCannotfeedtankCount(Integer cannotfeedtankCount) {
		this.cannotfeedtankCount = cannotfeedtankCount;
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
	public Integer getTankdataCount() {
		return tankdataCount;
	}
	public void setTankdataCount(Integer tankdataCount) {
		this.tankdataCount = tankdataCount;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getSubdivisionName() {
		return subdivisionName;
	}
	public void setSubdivisionName(String subdivisionName) {
		this.subdivisionName = subdivisionName;
	}
	@Override
	public String toString() {
		return "TankFeedDetails [tankId=" + tankId + ", canfeed=" + canfeed + ", feedtankCount=" + feedtankCount
				+ ", cannotfeedtankCount=" + cannotfeedtankCount + ", unitId=" + unitId + ", circleId=" + circleId
				+ ", divisionId=" + divisionId + ", subdivisionId=" + subdivisionId + ", tankdataCount=" + tankdataCount
				+ ", unitName=" + unitName + ", circleName=" + circleName + ", divisionName=" + divisionName
				+ ", subdivisionName=" + subdivisionName + "]";
	}
	

}
