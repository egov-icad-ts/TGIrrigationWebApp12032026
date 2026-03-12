package in.ts.icad.leagal.model;

public class ReservoirMaintenanceChecks {
	
	private Integer resCheckId;
	
	private String resCheck;
	
	private Integer resCategoryId;
	
	private String resCategory;
	
	private Integer resCheckSeq;
	
	private Boolean isTitle;
	
	private Integer annxId;
	
	private String checkdisplayNum;
	
	
	
	
	
	

	public Integer getAnnxId() {
		return annxId;
	}

	public void setAnnxId(Integer annxId) {
		this.annxId = annxId;
	}

	public String getCheckdisplayNum() {
		return checkdisplayNum;
	}

	public void setCheckdisplayNum(String checkdisplayNum) {
		this.checkdisplayNum = checkdisplayNum;
	}

	public Boolean getIsTitle() {
		return isTitle;
	}

	public void setIsTitle(Boolean isTitle) {
		this.isTitle = isTitle;
	}

	public Integer getResCheckSeq() {
		return resCheckSeq;
	}

	public void setResCheckSeq(Integer resCheckSeq) {
		this.resCheckSeq = resCheckSeq;
	}

	public Integer getResCheckId() {
		return resCheckId;
	}

	public void setResCheckId(Integer resCheckId) {
		this.resCheckId = resCheckId;
	}

	public String getResCheck() {
		return resCheck;
	}

	public void setResCheck(String resCheck) {
		this.resCheck = resCheck;
	}

	public Integer getResCategoryId() {
		return resCategoryId;
	}

	public void setResCategoryId(Integer resCategoryId) {
		this.resCategoryId = resCategoryId;
	}

	public String getResCategory() {
		return resCategory;
	}

	public void setResCategory(String resCategory) {
		this.resCategory = resCategory;
	}

	@Override
	public String toString() {
		return "ReservoirMaintenanceChecks [resCheckId=" + resCheckId
				+ ", resCheck=" + resCheck + ", resCategoryId=" + resCategoryId
				+ ", resCategory=" + resCategory + "]";
	}
	
    
	
	
	
	

}
