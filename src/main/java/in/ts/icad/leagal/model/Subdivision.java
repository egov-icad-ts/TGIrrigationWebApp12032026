package in.ts.icad.leagal.model;

public class Subdivision {
	
	@Override
	public String toString() {
		return "Subdivision [subdivisionId=" + subdivisionId + ", subdivisionName=" + subdivisionName + ", sectionId="
				+ sectionId + ", sectionName=" + sectionName + "]";
	}
	private int subdivisionId;
	private String subdivisionName;
	private int sectionId;
	private String sectionName;
	
	private Integer divisionId;
	
	private Integer circleId;
	
	private Integer headquarterId;
	
	private String  status;
	
	
	private String officeAddress;
	private String email;
	
	private Integer oldsubdivisionId;
	
	public Integer getOldsubdivisionId() {
		return oldsubdivisionId;
	}
	public void setOldsubdivisionId(Integer oldsubdivisionId) {
		this.oldsubdivisionId = oldsubdivisionId;
	}
	private Integer olddivisionId;
	
	private Integer oldCircleId;
	
	private String effectiveFrom;
	
	
	
	
	public Integer getCircleId() {
		return circleId;
	}
	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}
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
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getOlddivisionId() {
		return olddivisionId;
	}
	public void setOlddivisionId(Integer olddivisionId) {
		this.olddivisionId = olddivisionId;
	}
	public Integer getOldCircleId() {
		return oldCircleId;
	}
	public void setOldCircleId(Integer oldCircleId) {
		this.oldCircleId = oldCircleId;
	}
	public String getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	public Integer getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}
	private Long subdivisionPost;
	
	public Long getSubdivisionPost() {
		return subdivisionPost;
	}
	public void setSubdivisionPost(Long subdivisionPost) {
		this.subdivisionPost = subdivisionPost;
	}
	public int getSubdivisionId() {
		return subdivisionId;
	}
	public void setSubdivisionId(int subdivisionId) {
		this.subdivisionId = subdivisionId;
	}
	public String getSubdivisionName() {
		return subdivisionName;
	}
	public void setSubdivisionName(String subdivisionName) {
		this.subdivisionName = subdivisionName;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
	
}
