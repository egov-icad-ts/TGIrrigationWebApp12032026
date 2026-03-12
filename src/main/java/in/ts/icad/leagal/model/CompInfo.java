package in.ts.icad.leagal.model;

import java.util.List;

public class CompInfo {
	
	private Integer compInfoId;
	private String pumpName;
	private Integer componentId;
	private Integer unitId;
	private Integer projectId;
	private String unitName;
	private String  componentName;
	private Double pumpDischarge;
	private String pumpStartDate;
	private String pumpStartTime;
	private String pumpEndTime;
	private Double pumpEnergy;
	private Integer selectedUnitId;
	private Integer selectedProjId;
	private Integer selectedCompId;
	private String remarks;
	private Integer userId;
	private String userName;
	private Integer compInputId;
	private String projectName;
	private Boolean deleteFlag;
	private Boolean editFlag;
	private String componentDate;
	private Integer seasonYear;
	private Integer seasonMonth;
	private String seasonMonthName;
	private Integer seasonId;
	private String seasonName;
	private Double ayacut;
	private Integer compDischargeId;
	
	
	
	
	
	
	
	
	
	
public Integer getSeasonYear() {
		return seasonYear;
	}
	public void setSeasonYear(Integer seasonYear) {
		this.seasonYear = seasonYear;
	}
	public Integer getSeasonMonth() {
		return seasonMonth;
	}
	public void setSeasonMonth(Integer seasonMonth) {
		this.seasonMonth = seasonMonth;
	}
	
	public String getSeasonMonthName() {
		return seasonMonthName;
	}
	public void setSeasonMonthName(String seasonMonthName) {
		this.seasonMonthName = seasonMonthName;
	}
	public Integer getCompDischargeId() {
		return compDischargeId;
	}
	public void setCompDischargeId(Integer compDischargeId) {
		this.compDischargeId = compDischargeId;
	}
	public Integer getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}
	public String getSeasonName() {
		return seasonName;
	}
	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}
	public Double getAyacut() {
		return ayacut;
	}
	public void setAyacut(Double ayacut) {
		this.ayacut = ayacut;
	}
public String getComponentDate() {
		return componentDate;
	}
	public void setComponentDate(String componentDate) {
		this.componentDate = componentDate;
	}
public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Boolean getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(Boolean editFlag) {
		this.editFlag = editFlag;
	}
public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
public Integer getCompInputId() {
		return compInputId;
	}
	public void setCompInputId(Integer compInputId) {
		this.compInputId = compInputId;
	}
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
private List<CompInfo> compInfoList;
	
	
	public List<CompInfo> getCompInfoList() {
		return compInfoList;
	}
	public void setCompInfoList(List<CompInfo> compInfoList) {
		this.compInfoList = compInfoList;
	}
	
	
	
	
	
	
	
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getSelectedUnitId() {
		return selectedUnitId;
	}
	public void setSelectedUnitId(Integer selectedUnitId) {
		this.selectedUnitId = selectedUnitId;
	}
	public Integer getSelectedProjId() {
		return selectedProjId;
	}
	public void setSelectedProjId(Integer selectedProjId) {
		this.selectedProjId = selectedProjId;
	}
	public Integer getSelectedCompId() {
		return selectedCompId;
	}
	public void setSelectedCompId(Integer selectedCompId) {
		this.selectedCompId = selectedCompId;
	}
	public Double getPumpDischarge() {
		return pumpDischarge;
	}
	public void setPumpDischarge(Double pumpDischarge) {
		this.pumpDischarge = pumpDischarge;
	}
	public String getPumpStartDate() {
		return pumpStartDate;
	}
	public void setPumpStartDate(String pumpStartDate) {
		this.pumpStartDate = pumpStartDate;
	}
	public String getPumpStartTime() {
		return pumpStartTime;
	}
	public void setPumpStartTime(String pumpStartTime) {
		this.pumpStartTime = pumpStartTime;
	}
	public String getPumpEndTime() {
		return pumpEndTime;
	}
	public void setPumpEndTime(String pumpEndTime) {
		this.pumpEndTime = pumpEndTime;
	}
	public Double getPumpEnergy() {
		return pumpEnergy;
	}
	public void setPumpEnergy(Double pumpEnergy) {
		this.pumpEnergy = pumpEnergy;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	
	public Integer getCompInfoId() {
		return compInfoId;
	}
	public void setCompInfoId(Integer compInfoId) {
		this.compInfoId = compInfoId;
	}
	public String getPumpName() {
		return pumpName;
	}
	public void setPumpName(String pumpName) {
		this.pumpName = pumpName;
	}
	public Integer getComponentId() {
		return componentId;
	}
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	

}
