package in.ts.icad.leagal.model;;

public class Division {
	private int divisionId;
	private String divisionName;
	private int circleId;
	private String circleName;
	
	private Integer headquarterId;
	private String status;
	private String officeaddress;
	private String email;
	private Integer oldCircleId;
	private Integer OldDivisionId;
	
	private String effectiveFrom;
	
	
	
	
	
	
	
	
	public Integer getHeadquarterId() {
		return headquarterId;
	}
	public void setHeadquarterId(Integer headquarterId) {
		this.headquarterId = headquarterId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOfficeaddress() {
		return officeaddress;
	}
	public void setOfficeaddress(String officeaddress) {
		this.officeaddress = officeaddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getOldCircleId() {
		return oldCircleId;
	}
	public void setOldCircleId(Integer oldCircleId) {
		this.oldCircleId = oldCircleId;
	}
	public Integer getOldDivisionId() {
		return OldDivisionId;
	}
	public void setOldDivisionId(Integer oldDivisionId) {
		OldDivisionId = oldDivisionId;
	}
	public String getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	public int getDivisionId() {
		return divisionId;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public int getCircleId() {
		return circleId;
	}
	public String getCircleName() {
		return circleName;
	}
	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
}
