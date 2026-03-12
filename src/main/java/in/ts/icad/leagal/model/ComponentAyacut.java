package in.ts.icad.leagal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ComponentAyacut {
	
	private Integer projectId;
	private Integer packageId;
	private Integer componentId;
	private Double previousAyacutCreated;
	private Double previousAyacutContemplated;
	private Double presentAyacutCreated;
	private Double presentAyacutContemplated;
	private String presentAyacutmonth;
	private Integer contemplatedId;
	private Integer contemplatedName;
	private String componentName;
	
	private Integer projectTypeId;
	
	private String projectType;
	
	private Integer ayacutYear;
	
	
	
	public Integer getAyacutYear() {
		return ayacutYear;
	}
	public void setAyacutYear(Integer ayacutYear) {
		this.ayacutYear = ayacutYear;
	}
	public Integer getProjectTypeId() {
		return projectTypeId;
	}
	public void setProjectTypeId(Integer projectTypeId) {
		this.projectTypeId = projectTypeId;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	private Long postId;
	
	
	
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	private String remarks;
	private Integer userId;
	private Double totalayacutCreated;
	private Double totalayacutContemplated;
	
	private Integer comppackid;
	private Integer districtId;
	private Integer mandalId;
	private Integer villageId;
	private Integer compMonAyacutId;
	private Integer selectedcompId;
	private Integer selectedmanId;
	private Integer selectedvillId;
	private String packageName;
	private String constName;
	
	private List<CadAyacutKmlDocs> cadkmldocs;
	
	/*public List<MultipartFile> uploadFiles	;
	
	
	
	public List<MultipartFile> getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(List<MultipartFile> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}*/
	public List<CadAyacutKmlDocs> getCadkmldocs() {
		return cadkmldocs;
	}
	public void setCadkmldocs(List<CadAyacutKmlDocs> cadkmldocs) {
		this.cadkmldocs = cadkmldocs;
	}
	private Integer constId;
	private Double stableAyacut;
	private Integer componentTypeId;
	private String componentType;
	private Double fromKM;
	private Double toKM;
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	private Integer subdivisionId;
	
	private Integer selectedProjectId;
	
	private Integer selectedUnitId;
	private String	selectedPackName;
	private Integer	selectedDistrictId;
	private Integer selectedMandalId;
	private Integer selectedConstId;
	private String userName;
	private Integer selectpackId;
	private String projectName;
	private String unitName;
	
	private String circleName;
	private String divisionName;
	
	
	
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
	private Integer oldProjAyacutId;
	private Boolean jursFlag;
	
	
	public Integer getOldProjAyacutId() {
		return oldProjAyacutId;
	}
	public void setOldProjAyacutId(Integer oldProjAyacutId) {
		this.oldProjAyacutId = oldProjAyacutId;
	}
	public Boolean getJursFlag() {
		return jursFlag;
	}
	public void setJursFlag(Boolean jursFlag) {
		this.jursFlag = jursFlag;
	}
	private Integer projAyacutId;
	
	private Integer constdistMapId;
	
	private Integer  resayacutCon;
	private Integer resayacutstable;
	
	private Integer oldDistrictId;
	private String oldDistrictName;
	private Integer selectedolddistId;
	
	private String urlvalue;
	
	private Integer noOfWettings;
	private String  cropNames;
	
	
	
	
	public Integer getNoOfWettings() {
		return noOfWettings;
	}
	public void setNoOfWettings(Integer noOfWettings) {
		this.noOfWettings = noOfWettings;
	}
	public String getCropNames() {
		return cropNames;
	}
	public void setCropNames(String cropNames) {
		this.cropNames = cropNames;
	}
	private Double irriagtedAyacut;
	private Double ayacutCreated;
	private Double contemplatedAyacut;
	
	private String mandalCode;
	
	
	private Integer seasonId;
	private String seasonName;
	private String actplanYear;
	private Double preWaterLevel;
	private Double preWaterCap;
	private Double waterUtil;
	private Double BalWaterRequired;
	private Double waterRequired;
	private String ObsDate;
	private Integer projectseasonId;
	private Integer cropId;
	private Double proposedAyacut;
	private Integer projSeasonAyacutId;
	
	private Integer projseasonCapIdKh;
	private Integer projseasonCapIdRabi;
	private Integer projIdRabi;
	private Integer projIdKh;
	private Double  khtotal;
	private Double rabitotal;
	

	
	
	//Report Variables
	
	public Double getKhtotal() {
		return khtotal;
	}
	public void setKhtotal(Double khtotal) {
		this.khtotal = khtotal;
	}
	public Double getRabitotal() {
		return rabitotal;
	}
	public void setRabitotal(Double rabitotal) {
		this.rabitotal = rabitotal;
	}
	private Double netAvailablewaterKhrif;
	private Double netAvailablewaterrabi;
	private Double irrigatedAyacutKharifID;
	private Double irrigatedAyacutKharifWet;
	private Double irrigatedAyacutRabiID;
	private Double irrigatedAyacutRabiWet;
	private Double proposedAyacutKharifID;
	private Double proposedAyacutRabiID;
	private Double proposedAyacutKharifWet;
	private Double proposedAyacutRabiWet;
	private String khrifactplanYear;
	private String rabiactplanYear;
	private String obsdatekh;
	private String obsdaterabi;

	
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	private String cropName;
	
	
	
	
	
	
	
	public String getObsdatekh() {
		return obsdatekh;
	}
	public void setObsdatekh(String obsdatekh) {
		this.obsdatekh = obsdatekh;
	}
	public String getObsdaterabi() {
		return obsdaterabi;
	}
	public void setObsdaterabi(String obsdaterabi) {
		this.obsdaterabi = obsdaterabi;
	}
	public Double getNetAvailablewaterKhrif() {
		return netAvailablewaterKhrif;
	}
	public void setNetAvailablewaterKhrif(Double netAvailablewaterKhrif) {
		this.netAvailablewaterKhrif = netAvailablewaterKhrif;
	}
	public Double getNetAvailablewaterrabi() {
		return netAvailablewaterrabi;
	}
	public void setNetAvailablewaterrabi(Double netAvailablewaterrabi) {
		this.netAvailablewaterrabi = netAvailablewaterrabi;
	}
	public Double getIrrigatedAyacutKharifID() {
		return irrigatedAyacutKharifID;
	}
	public void setIrrigatedAyacutKharifID(Double irrigatedAyacutKharifID) {
		this.irrigatedAyacutKharifID = irrigatedAyacutKharifID;
	}
	public Double getIrrigatedAyacutKharifWet() {
		return irrigatedAyacutKharifWet;
	}
	public void setIrrigatedAyacutKharifWet(Double irrigatedAyacutKharifWet) {
		this.irrigatedAyacutKharifWet = irrigatedAyacutKharifWet;
	}
	public Double getIrrigatedAyacutRabiID() {
		return irrigatedAyacutRabiID;
	}
	public void setIrrigatedAyacutRabiID(Double irrigatedAyacutRabiID) {
		this.irrigatedAyacutRabiID = irrigatedAyacutRabiID;
	}
	public Double getIrrigatedAyacutRabiWet() {
		return irrigatedAyacutRabiWet;
	}
	public void setIrrigatedAyacutRabiWet(Double irrigatedAyacutRabiWet) {
		this.irrigatedAyacutRabiWet = irrigatedAyacutRabiWet;
	}
	public Double getProposedAyacutKharifID() {
		return proposedAyacutKharifID;
	}
	public void setProposedAyacutKharifID(Double proposedAyacutKharifID) {
		this.proposedAyacutKharifID = proposedAyacutKharifID;
	}
	public Double getProposedAyacutRabiID() {
		return proposedAyacutRabiID;
	}
	public void setProposedAyacutRabiID(Double proposedAyacutRabiID) {
		this.proposedAyacutRabiID = proposedAyacutRabiID;
	}
	public Double getProposedAyacutKharifWet() {
		return proposedAyacutKharifWet;
	}
	public void setProposedAyacutKharifWet(Double proposedAyacutKharifWet) {
		this.proposedAyacutKharifWet = proposedAyacutKharifWet;
	}
	public Double getProposedAyacutRabiWet() {
		return proposedAyacutRabiWet;
	}
	public void setProposedAyacutRabiWet(Double proposedAyacutRabiWet) {
		this.proposedAyacutRabiWet = proposedAyacutRabiWet;
	}
	public String getKhrifactplanYear() {
		return khrifactplanYear;
	}
	public void setKhrifactplanYear(String khrifactplanYear) {
		this.khrifactplanYear = khrifactplanYear;
	}
	public String getRabiactplanYear() {
		return rabiactplanYear;
	}
	public void setRabiactplanYear(String rabiactplanYear) {
		this.rabiactplanYear = rabiactplanYear;
	}
	public Integer getProjSeasonAyacutId() {
		return projSeasonAyacutId;
	}
	public void setProjSeasonAyacutId(Integer projSeasonAyacutId) {
		this.projSeasonAyacutId = projSeasonAyacutId;
	}
	public Double getProposedAyacut() {
		return proposedAyacut;
	}
	public void setProposedAyacut(Double proposedAyacut) {
		this.proposedAyacut = proposedAyacut;
	}
	public Integer getCropId() {
		return cropId;
	}
	public void setCropId(Integer cropId) {
		this.cropId = cropId;
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
	public String getActplanYear() {
		return actplanYear;
	}
	public void setActplanYear(String actplanYear) {
		this.actplanYear = actplanYear;
	}
	public Double getPreWaterLevel() {
		return preWaterLevel;
	}
	public void setPreWaterLevel(Double preWaterLevel) {
		this.preWaterLevel = preWaterLevel;
	}
	public Double getPreWaterCap() {
		return preWaterCap;
	}
	public void setPreWaterCap(Double preWaterCap) {
		this.preWaterCap = preWaterCap;
	}
	
	public Double getBalWaterRequired() {
		return BalWaterRequired;
	}
	public void setBalWaterRequired(Double balWaterRequired) {
		BalWaterRequired = balWaterRequired;
	}
	public Double getWaterRequired() {
		return waterRequired;
	}
	public void setWaterRequired(Double waterRequired) {
		this.waterRequired = waterRequired;
	}
	public String getObsDate() {
		return ObsDate;
	}
	public void setObsDate(String obsDate) {
		ObsDate = obsDate;
	}
	public Integer getProjectseasonId() {
		return projectseasonId;
	}
	public void setProjectseasonId(Integer projectseasonId) {
		this.projectseasonId = projectseasonId;
	}
	public String getMandalCode() {
		return mandalCode;
	}
	public void setMandalCode(String mandalCode) {
		this.mandalCode = mandalCode;
	}
	public Double getContemplatedAyacut() {
		return contemplatedAyacut;
	}
	public void setContemplatedAyacut(Double contemplatedAyacut) {
		this.contemplatedAyacut = contemplatedAyacut;
	}
	public Double getAyacutCreated() {
		return ayacutCreated;
	}
	public void setAyacutCreated(Double ayacutCreated) {
		this.ayacutCreated = ayacutCreated;
	}
	public Double getIrriagtedAyacut() {
		return irriagtedAyacut;
	}
	public void setIrriagtedAyacut(Double irriagtedAyacut) {
		this.irriagtedAyacut = irriagtedAyacut;
	}
	public String getUrlvalue() {
		return urlvalue;
	}
	public void setUrlvalue(String urlvalue) {
		this.urlvalue = urlvalue;
	}
	public Integer getSelectedolddistId() {
		return selectedolddistId;
	}
	public void setSelectedolddistId(Integer selectedolddistId) {
		this.selectedolddistId = selectedolddistId;
	}
	public Integer getOldDistrictId() {
		return oldDistrictId;
	}
	public void setOldDistrictId(Integer oldDistrictId) {
		this.oldDistrictId = oldDistrictId;
	}
	public String getOldDistrictName() {
		return oldDistrictName;
	}
	public void setOldDistrictName(String oldDistrictName) {
		this.oldDistrictName = oldDistrictName;
	}
	public Integer getResayacutCon() {
		return resayacutCon;
	}
	public void setResayacutCon(Integer resayacutCon) {
		this.resayacutCon = resayacutCon;
	}
	public Integer getResayacutstable() {
		return resayacutstable;
	}
	public void setResayacutstable(Integer resayacutstable) {
		this.resayacutstable = resayacutstable;
	}
	public Integer getConstdistMapId() {
		return constdistMapId;
	}
	public void setConstdistMapId(Integer constdistMapId) {
		this.constdistMapId = constdistMapId;
	}
	public Integer getProjAyacutId() {
		return projAyacutId;
	}
	public void setProjAyacutId(Integer projAyacutId) {
		this.projAyacutId = projAyacutId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getSelectpackId() {
		return selectpackId;
	}
	public void setSelectpackId(Integer selectpackId) {
		this.selectpackId = selectpackId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getSelectedProjectId() {
		return selectedProjectId;
	}
	public void setSelectedProjectId(Integer selectedProjectId) {
		this.selectedProjectId = selectedProjectId;
	}
	public Integer getSelectedUnitId() {
		return selectedUnitId;
	}
	public void setSelectedUnitId(Integer selectedUnitId) {
		this.selectedUnitId = selectedUnitId;
	}
	public String getSelectedPackName() {
		return selectedPackName;
	}
	public void setSelectedPackName(String selectedPackName) {
		this.selectedPackName = selectedPackName;
	}
	public Integer getSelectedDistrictId() {
		return selectedDistrictId;
	}
	public void setSelectedDistrictId(Integer selectedDistrictId) {
		this.selectedDistrictId = selectedDistrictId;
	}
	public Integer getSelectedMandalId() {
		return selectedMandalId;
	}
	public void setSelectedMandalId(Integer selectedMandalId) {
		this.selectedMandalId = selectedMandalId;
	}
	public Integer getSelectedConstId() {
		return selectedConstId;
	}
	public void setSelectedConstId(Integer selectedConstId) {
		this.selectedConstId = selectedConstId;
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
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getConstName() {
		return constName;
	}
	public void setConstName(String constName) {
		this.constName = constName;
	}
	public Integer getConstId() {
		return constId;
	}
	public void setConstId(Integer constId) {
		this.constId = constId;
	}
	public Double getStableAyacut() {
		return stableAyacut;
	}
	public void setStableAyacut(Double stableAyacut) {
		this.stableAyacut = stableAyacut;
	}
	public Integer getComponentTypeId() {
		return componentTypeId;
	}
	public void setComponentTypeId(Integer componentTypeId) {
		this.componentTypeId = componentTypeId;
	}
	public String getComponentType() {
		return componentType;
	}
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}
	public Double getFromKM() {
		return fromKM;
	}
	public void setFromKM(Double fromKM) {
		this.fromKM = fromKM;
	}
	public Double getToKM() {
		return toKM;
	}
	public void setToKM(Double toKM) {
		this.toKM = toKM;
	}
	public String getOtherDistrict() {
		return otherDistrict;
	}
	public void setOtherDistrict(String otherDistrict) {
		this.otherDistrict = otherDistrict;
	}
	public String getOtherdMandal() {
		return otherdMandal;
	}
	public void setOtherdMandal(String otherdMandal) {
		this.otherdMandal = otherdMandal;
	}
	public String getOtherVillage() {
		return otherVillage;
	}
	public void setOtherVillage(String otherVillage) {
		this.otherVillage = otherVillage;
	}
	private String  otherDistrict;
	private String  otherdMandal;
	private String  otherVillage;
	
	
	
	
	
	
	
	
	
	
	public Integer getSelectedmanId() {
		return selectedmanId;
	}
	public void setSelectedmanId(Integer selectedmanId) {
		this.selectedmanId = selectedmanId;
	}
	public Integer getSelectedvillId() {
		return selectedvillId;
	}
	public void setSelectedvillId(Integer selectedvillId) {
		this.selectedvillId = selectedvillId;
	}
	public Integer getSelectedcompId() {
		return selectedcompId;
	}
	public void setSelectedcompId(Integer selectedcompId) {
		this.selectedcompId = selectedcompId;
	}
	@Override
	public String toString() {
		return "ComponentAyacut [projectId=" + projectId + ", packageId=" + packageId + ", componentId=" + componentId
				+ ", previousAyacutCreated=" + previousAyacutCreated + ", previousAyacutContemplated="
				+ previousAyacutContemplated + ", presentAyacutCreated=" + presentAyacutCreated
				+ ", presentAyacutContemplated=" + presentAyacutContemplated + ", presentAyacutmonth="
				+ presentAyacutmonth + ", contemplatedId=" + contemplatedId + ", contemplatedName=" + contemplatedName
				+ ", componentName=" + componentName + ", remarks=" + remarks + ", userId=" + userId
				+ ", totalayacutCreated=" + totalayacutCreated + ", totalayacutContemplated=" + totalayacutContemplated
				+ ", comppackid=" + comppackid + ", districtId=" + districtId + ", mandalId=" + mandalId
				+ ", villageId=" + villageId + ", compMonAyacutId=" + compMonAyacutId + ", selectedcompId="
				+ selectedcompId + ", selectedmanId=" + selectedmanId + ", selectedvillId=" + selectedvillId
				+ ", packageName=" + packageName + ", constName=" + constName + ", constId=" + constId
				+ ", stableAyacut=" + stableAyacut + ", componentTypeId=" + componentTypeId + ", componentType="
				+ componentType + ", fromKM=" + fromKM + ", toKM=" + toKM + ", unitId=" + unitId + ", circleId="
				+ circleId + ", divisionId=" + divisionId + ", subdivisionId=" + subdivisionId + ", selectedProjectId="
				+ selectedProjectId + ", selectedUnitId=" + selectedUnitId + ", selectedPackName=" + selectedPackName
				+ ", selectedDistrictId=" + selectedDistrictId + ", selectedMandalId=" + selectedMandalId
				+ ", selectedConstId=" + selectedConstId + ", userName=" + userName + ", selectpackId=" + selectpackId
				+ ", projectName=" + projectName + ", unitName=" + unitName + ", projAyacutId=" + projAyacutId
				+ ", constdistMapId=" + constdistMapId + ", resayacutCon=" + resayacutCon + ", resayacutstable="
				+ resayacutstable + ", oldDistrictId=" + oldDistrictId + ", oldDistrictName=" + oldDistrictName
				+ ", selectedolddistId=" + selectedolddistId + ", urlvalue=" + urlvalue + ", irriagtedAyacut="
				+ irriagtedAyacut + ", ayacutCreated=" + ayacutCreated + ", contemplatedAyacut=" + contemplatedAyacut
				+ ", mandalCode=" + mandalCode + ", seasonId=" + seasonId + ", seasonName=" + seasonName
				+ ", actplanYear=" + actplanYear + ", preWaterLevel=" + preWaterLevel + ", preWaterCap=" + preWaterCap
				+ ", waterUtil=" + waterUtil + ", BalWaterRequired=" + BalWaterRequired + ", waterRequired="
				+ waterRequired + ", ObsDate=" + ObsDate + ", projectseasonId=" + projectseasonId + ", cropId=" + cropId
				+ ", proposedAyacut=" + proposedAyacut + ", projSeasonAyacutId=" + projSeasonAyacutId
				+ ", netAvailablewaterKhrif=" + netAvailablewaterKhrif + ", netAvailablewaterrabi="
				+ netAvailablewaterrabi + ", irrigatedAyacutKharifID=" + irrigatedAyacutKharifID
				+ ", irrigatedAyacutKharifWet=" + irrigatedAyacutKharifWet + ", irrigatedAyacutRabiID="
				+ irrigatedAyacutRabiID + ", irrigatedAyacutRabiWet=" + irrigatedAyacutRabiWet
				+ ", proposedAyacutKharifID=" + proposedAyacutKharifID + ", proposedAyacutRabiID="
				+ proposedAyacutRabiID + ", proposedAyacutKharifWet=" + proposedAyacutKharifWet
				+ ", proposedAyacutRabiWet=" + proposedAyacutRabiWet + ", khrifactplanYear=" + khrifactplanYear
				+ ", rabiactplanYear=" + rabiactplanYear + ", obsdatekh=" + obsdatekh + ", obsdaterabi=" + obsdaterabi
				+ ", cropName=" + cropName + ", otherDistrict=" + otherDistrict + ", otherdMandal=" + otherdMandal
				+ ", otherVillage=" + otherVillage + ", editFlag=" + editFlag + ", deleteFlag=" + deleteFlag
				+ ", districtName=" + districtName + ", mandalName=" + mandalName + ", villageName=" + villageName
				+ ", selectvillage=" + selectvillage + "]";
	}
	public Double getWaterUtil() {
		return waterUtil;
	}
	public void setWaterUtil(Double waterUtil) {
		this.waterUtil = waterUtil;
	}
	private Boolean editFlag;
	private Boolean deleteFlag;
	private String  districtName;
	private String  mandalName;
	private String  villageName;
	private Integer selectvillage;
	
	
	
	
	
	public Integer getSelectvillage() {
		return selectvillage;
	}
	public void setSelectvillage(Integer selectvillage) {
		this.selectvillage = selectvillage;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getMandalName() {
		return mandalName;
	}
	public void setMandalName(String mandalName) {
		this.mandalName = mandalName;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public Boolean getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(Boolean editFlag) {
		this.editFlag = editFlag;
	}
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getCompMonAyacutId() {
		return compMonAyacutId;
	}
	public void setCompMonAyacutId(Integer compMonAyacutId) {
		this.compMonAyacutId = compMonAyacutId;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public Integer getMandalId() {
		return mandalId;
	}
	public void setMandalId(Integer mandalId) {
		this.mandalId = mandalId;
	}
	public Integer getVillageId() {
		return villageId;
	}
	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}
	public Double getPreviousAyacutCreated() {
		return previousAyacutCreated;
	}
	public void setPreviousAyacutCreated(Double previousAyacutCreated) {
		this.previousAyacutCreated = previousAyacutCreated;
	}
	public Double getPreviousAyacutContemplated() {
		return previousAyacutContemplated;
	}
	public void setPreviousAyacutContemplated(Double previousAyacutContemplated) {
		this.previousAyacutContemplated = previousAyacutContemplated;
	}
	public Double getPresentAyacutCreated() {
		return presentAyacutCreated;
	}
	public void setPresentAyacutCreated(Double presentAyacutCreated) {
		this.presentAyacutCreated = presentAyacutCreated;
	}
	public Double getPresentAyacutContemplated() {
		return presentAyacutContemplated;
	}
	public void setPresentAyacutContemplated(Double presentAyacutContemplated) {
		this.presentAyacutContemplated = presentAyacutContemplated;
	}
	public Integer getContemplatedId() {
		return contemplatedId;
	}
	public void setContemplatedId(Integer contemplatedId) {
		this.contemplatedId = contemplatedId;
	}
	public Integer getContemplatedName() {
		return contemplatedName;
	}
	public void setContemplatedName(Integer contemplatedName) {
		this.contemplatedName = contemplatedName;
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
	public Integer getComponentId() {
		return componentId;
	}
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	
	public String getPresentAyacutmonth() {
		return presentAyacutmonth;
	}
	public void setPresentAyacutmonth(String presentAyacutmonth) {
		this.presentAyacutmonth = presentAyacutmonth;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Double getTotalayacutCreated() {
		return totalayacutCreated;
	}
	public void setTotalayacutCreated(Double totalayacutCreated) {
		this.totalayacutCreated = totalayacutCreated;
	}
	public Double getTotalayacutContemplated() {
		return totalayacutContemplated;
	}
	public void setTotalayacutContemplated(Double totalayacutContemplated) {
		this.totalayacutContemplated = totalayacutContemplated;
	}
	public Integer getComppackid() {
		return comppackid;
	}
	public void setComppackid(Integer comppackid) {
		this.comppackid = comppackid;
	}
	public Integer getProjseasonCapIdKh() {
		return projseasonCapIdKh;
	}
	public void setProjseasonCapIdKh(Integer projseasonCapIdKh) {
		this.projseasonCapIdKh = projseasonCapIdKh;
	}
	public Integer getProjseasonCapIdRabi() {
		return projseasonCapIdRabi;
	}
	public void setProjseasonCapIdRabi(Integer projseasonCapIdRabi) {
		this.projseasonCapIdRabi = projseasonCapIdRabi;
	}
	public Integer getProjIdRabi() {
		return projIdRabi;
	}
	public void setProjIdRabi(Integer projIdRabi) {
		this.projIdRabi = projIdRabi;
	}
	public Integer getProjIdKh() {
		return projIdKh;
	}
	public void setProjIdKh(Integer projIdKh) {
		this.projIdKh = projIdKh;
	}
	

}
