package in.ts.icad.leagal.model;

public class ReservoirMaintenanceCategory {
	
	private Integer resCategoryId;
	
	private String resCategory;
	
	private Integer resCatParentId;
	
	private Boolean resCatHasChild;
	
	private Integer catType;
	
	private String catNumDisplay;
	
	private Boolean catTitle;
	
	private Integer catseq;
	
	
	
	

	public Integer getCatseq() {
		return catseq;
	}

	public void setCatseq(Integer catseq) {
		this.catseq = catseq;
	}

	public Integer getCatType() {
		return catType;
	}

	public void setCatType(Integer catType) {
		this.catType = catType;
	}

	public String getCatNumDisplay() {
		return catNumDisplay;
	}

	public void setCatNumDisplay(String catNumDisplay) {
		this.catNumDisplay = catNumDisplay;
	}

	public Boolean getCatTitle() {
		return catTitle;
	}

	public void setCatTitle(Boolean catTitle) {
		this.catTitle = catTitle;
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

	public Integer getResCatParentId() {
		return resCatParentId;
	}

	public void setResCatParentId(Integer resCatParentId) {
		this.resCatParentId = resCatParentId;
	}

	public Boolean getResCatHasChild() {
		return resCatHasChild;
	}

	public void setResCatHasChild(Boolean resCatHasChild) {
		this.resCatHasChild = resCatHasChild;
	}

	@Override
	public String toString() {
		return "ReservoirMaintenanceCategory [resCategoryId=" + resCategoryId
				+ ", resCategory=" + resCategory + ", resCatParentId="
				+ resCatParentId + ", resCatHasChild=" + resCatHasChild + "]";
	}
	
	
	

}
