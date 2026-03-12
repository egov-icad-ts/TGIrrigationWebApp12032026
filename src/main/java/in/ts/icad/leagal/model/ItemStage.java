package in.ts.icad.leagal.model;

public class ItemStage {
	private Integer mainItemId;
	private Integer primaryItemId;
	private Integer secondaryItemId;
	private Integer stageId;
	private Integer projectId;
	private Integer packageId;
	private String mainItemName;
	private String secondaryItemName;
	private String primaryItemName;
	private String stageName;
	private String packageName;
	private String projectName;

	private String itemDescription;
	
	

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Integer getMainItemId() {
		return mainItemId;
	}

	public void setMainItemId(Integer mainItemId) {
		this.mainItemId = mainItemId;
	}

	public Integer getPrimaryItemId() {
		return primaryItemId;
	}

	public void setPrimaryItemId(Integer primaryItemId) {
		this.primaryItemId = primaryItemId;
	}

	public Integer getSecondaryItemId() {
		return secondaryItemId;
	}

	public void setSecondaryItemId(Integer secondaryItemId) {
		this.secondaryItemId = secondaryItemId;
	}

	public Integer getStageId() {
		return stageId;
	}

	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getMainItemName() {
		return mainItemName;
	}

	public void setMainItemName(String mainItemName) {
		this.mainItemName = mainItemName;
	}

	public String getSecondaryItemName() {
		return secondaryItemName;
	}

	public void setSecondaryItemName(String secondaryItemName) {
		this.secondaryItemName = secondaryItemName;
	}

	public String getPrimaryItemName() {
		return primaryItemName;
	}

	public void setPrimaryItemName(String primaryItemName) {
		this.primaryItemName = primaryItemName;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "ItemStage [mainItemId=" + mainItemId + ", primaryItemId=" + primaryItemId + ", secondaryItemId="
				+ secondaryItemId + ", stageId=" + stageId + ", projectId=" + projectId + ", packageId=" + packageId
				+ ", mainItemName=" + mainItemName + ", secondaryItemName=" + secondaryItemName + ", primaryItemName="
				+ primaryItemName + ", stageName=" + stageName + ", packageName=" + packageName + ", projectName="
				+ projectName + ", itemDescription=" + itemDescription + "]";
	}

	
}
