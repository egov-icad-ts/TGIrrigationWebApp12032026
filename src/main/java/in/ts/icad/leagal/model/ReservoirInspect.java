package in.ts.icad.leagal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ReservoirInspect {
	
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	private Integer subdivisionId;
	private Integer projectId;
	private Integer reservoirId;
	
	private Integer designationId;
	
	private Integer resInspectId;
	private Integer resCheckId;
	private Integer resCatId;
	private Integer resParentcatId;
	
	private String remarks;
	
	private String inspectDate;
	
	private Integer resCheckboxId;
	
	private String resCode;
	
	private Integer approvStatusId;
	
	private Integer year;
	
	private String urlvalue;
	
	private Integer resStatusId;
	
	private String resCheckName;
	
	private String actionReqName;
	
	private String actionReqTypeName;
	
	private String statusName;
	
	private Integer dutyFrequencyId;
	
	private String weekstartDate;
	
	private String weekendDate;
	
	private Integer resCategoryId;
	
	private String  resCategory;
	
	private String recomendbysdso;
	
	private Boolean actionTakeninit;
	
	private Boolean actionTakencomplete;
	
	private Integer tabId;
	private Integer levelId;
	
	private Integer empId;
	
	private String empName;
	
	private String userEmpId;
	
	private Integer resInspectMst1Id;
	
	private Integer resInspectMst2Id;
	
	private Integer roleId;
	
	
	private Integer resDamHealthId;
	
	private Integer resRecommendId;
	
	private Integer resDamActionId;
	
	private String resName;
	
	private String unitName;
	
	private String circleName;
	
	private String divisionName;
	
	private String subdivisionName;
	
	private String projectName;
	
	private String designationName;
	
	private String reasonForPending;
	
	private Integer sectionId;
	
	private Long postId;
	private Long nextPostId;
	
	private String genRemarks;
	private String erRemarks;
	private String omRemarks;
	private String cmRemarks;
	
	private Integer resCheckSeq;
	
	private Boolean isTitle;
	
	private Integer annexureId;
	
	private Boolean hasChild;
	
	private Integer catType;
	
	private Boolean resCheckAddFlag;
	
	private Integer inspectOfficeId;
	
	
	private String inspectOfficerData;
	
	private String fieldOfficerData;
	
	private Double presentWaterlevel;
	
	private Boolean inchargeofAnn1;
	
	private String preDaminspecteddata;
	
	private Boolean itemsInspected;
	
	private String itemsInspectedReason;
	
	private Boolean vigandWatchProvided;
	
	private String vigandwatchreason;
	
	private Boolean obsAnn2;
	
	private Double irrChFrm;
	
	private Double irrChTo;
	
	private Integer inspectOfficeInfoId;
	
	private String captcha;
	
	private String resCheckNumDisplay;
	
	private String resCatNumDisplay;
	
	private Boolean catistitle;
	
	private Integer resannRecommendId;
	
	private String deficiencyCategoryName;
	
	private String weathercondition;
	
	
	private Integer weatherconditionId;
	
	private String damOperator;
	
	private String ownerOfDam;
	
	private String latitude;
	
	private String longitude;
	
	private Integer inspectdesignationId;
	
	private String inspectdesignationName;
	
	
	private Integer prevYear;
	
	private Integer  prevFreq;
	
	private Integer prevResInspectMst1Id;
	
	private Integer prevResInspectMst2Id;
	
	private Integer prevResInspectHealthId;
	
	private Integer prevRecommendId;
	
	private String ptype;
	
	
	
	
	
	
	
	
	
	
	
	
	public String getPtype() {
		return ptype;
	}




	public void setPtype(String ptype) {
		this.ptype = ptype;
	}




	public Integer getPrevResInspectMst2Id() {
		return prevResInspectMst2Id;
	}




	public void setPrevResInspectMst2Id(Integer prevResInspectMst2Id) {
		this.prevResInspectMst2Id = prevResInspectMst2Id;
	}




	public Integer getPrevResInspectHealthId() {
		return prevResInspectHealthId;
	}




	public void setPrevResInspectHealthId(Integer prevResInspectHealthId) {
		this.prevResInspectHealthId = prevResInspectHealthId;
	}




	public Integer getPrevRecommendId() {
		return prevRecommendId;
	}




	public void setPrevRecommendId(Integer prevRecommendId) {
		this.prevRecommendId = prevRecommendId;
	}




	public Integer getPrevResInspectMst1Id() {
		return prevResInspectMst1Id;
	}




	public void setPrevResInspectMst1Id(Integer prevResInspectMst1Id) {
		this.prevResInspectMst1Id = prevResInspectMst1Id;
	}




	public Integer getPrevYear() {
		return prevYear;
	}




	public void setPrevYear(Integer prevYear) {
		this.prevYear = prevYear;
	}




	public Integer getPrevFreq() {
		return prevFreq;
	}




	public void setPrevFreq(Integer prevFreq) {
		this.prevFreq = prevFreq;
	}




	public String getInspectdesignationName() {
		return inspectdesignationName;
	}




	public void setInspectdesignationName(String inspectdesignationName) {
		this.inspectdesignationName = inspectdesignationName;
	}




	public Integer getInspectdesignationId() {
		return inspectdesignationId;
	}




	public void setInspectdesignationId(Integer inspectdesignationId) {
		this.inspectdesignationId = inspectdesignationId;
	}




	public String getLatitude() {
		return latitude;
	}




	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}




	public String getLongitude() {
		return longitude;
	}




	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}




	public Integer getWeatherconditionId() {
		return weatherconditionId;
	}




	public void setWeatherconditionId(Integer weatherconditionId) {
		this.weatherconditionId = weatherconditionId;
	}




	public String getDamOperator() {
		return damOperator;
	}




	public void setDamOperator(String damOperator) {
		this.damOperator = damOperator;
	}




	public String getOwnerOfDam() {
		return ownerOfDam;
	}




	public void setOwnerOfDam(String ownerOfDam) {
		this.ownerOfDam = ownerOfDam;
	}

	private Double storageCapacity;
	
	
	private Integer installedcount;
	
	private String location;
	
	private String installmonth;
	
	private Boolean workingcondition;
	
	private String datelastCalibrated;
	
	private String datenextCalibrated;
	
	private Boolean obsmaintained;
	
	
	private Boolean agencyresponsible;
	
	
	private Boolean analysisofdata;
	
	private Boolean datasenttoDSO;
	
	private Integer damcheckResponseId;
	
	private String damcheckResponse;
	
	private Integer conditionofCheckId;
	
	private String conditionofCheck;
	
	private List<DamInspectDocs>   daminspectphotoList ;
	
	private String docTitle;
	
	private Integer resRemarksMst1ReviewId;
	
	private Integer SubmitedToEmpId;
	
	private Integer tankId;
	
	
	private Integer listDesignationId;
	
	private Integer backdesignationId;
	
	private Integer userDesignationId;
	
	private Integer userUnitId;
	
	private Integer offAccess;
	
	private Boolean editFlag;
	
	


	public Boolean getEditFlag() {
		return editFlag;
	}




	public void setEditFlag(Boolean editFlag) {
		this.editFlag = editFlag;
	}




	public Integer getTankId() {
		return tankId;
	}




	public void setTankId(Integer tankId) {
		this.tankId = tankId;
	}




	public Integer getSubmitedToEmpId() {
		return SubmitedToEmpId;
	}




	public void setSubmitedToEmpId(Integer submitedToEmpId) {
		SubmitedToEmpId = submitedToEmpId;
	}




	public Integer getResRemarksMst1ReviewId() {
		return resRemarksMst1ReviewId;
	}




	public void setResRemarksMst1ReviewId(Integer resRemarksMst1ReviewId) {
		this.resRemarksMst1ReviewId = resRemarksMst1ReviewId;
	}




	public String getDocTitle() {
		return docTitle;
	}




	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}

	private List<MultipartFile> uploadPhotos;
	private List<ReservoirInspect>   resInspectList ;

	
	
	
	
	public List<MultipartFile> getUploadPhotos() {
		return uploadPhotos;
	}




	public void setUploadPhotos(List<MultipartFile> uploadPhotos) {
		this.uploadPhotos = uploadPhotos;
	}




	public List<ReservoirInspect> getResInspectList() {
		return resInspectList;
	}




	public void setResInspectList(List<ReservoirInspect> resInspectList) {
		this.resInspectList = resInspectList;
	}




	public List<DamInspectDocs> getDaminspectphotoList() {
		return daminspectphotoList;
	}




	public void setDaminspectphotoList(List<DamInspectDocs> daminspectphotoList) {
		this.daminspectphotoList = daminspectphotoList;
	}

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	public Integer getConditionofCheckId() {
		return conditionofCheckId;
	}

	public void setConditionofCheckId(Integer conditionofCheckId) {
		this.conditionofCheckId = conditionofCheckId;
	}

	public String getConditionofCheck() {
		return conditionofCheck;
	}

	public void setConditionofCheck(String conditionofCheck) {
		this.conditionofCheck = conditionofCheck;
	}

	public Integer getDamcheckResponseId() {
		return damcheckResponseId;
	}

	public void setDamcheckResponseId(Integer damcheckResponseId) {
		this.damcheckResponseId = damcheckResponseId;
	}

	public String getDamcheckResponse() {
		return damcheckResponse;
	}

	public void setDamcheckResponse(String damcheckResponse) {
		this.damcheckResponse = damcheckResponse;
	}

	public Integer getInstalledcount() {
		return installedcount;
	}

	public void setInstalledcount(Integer installedcount) {
		this.installedcount = installedcount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInstallmonth() {
		return installmonth;
	}

	public Integer getListDesignationId() {
		return listDesignationId;
	}




	public void setListDesignationId(Integer listDesignationId) {
		this.listDesignationId = listDesignationId;
	}




	public Integer getBackdesignationId() {
		return backdesignationId;
	}




	public void setBackdesignationId(Integer backdesignationId) {
		this.backdesignationId = backdesignationId;
	}




	public Integer getUserDesignationId() {
		return userDesignationId;
	}




	public void setUserDesignationId(Integer userDesignationId) {
		this.userDesignationId = userDesignationId;
	}




	public Integer getUserUnitId() {
		return userUnitId;
	}




	public void setUserUnitId(Integer userUnitId) {
		this.userUnitId = userUnitId;
	}




	public Integer getOffAccess() {
		return offAccess;
	}




	public void setOffAccess(Integer offAccess) {
		this.offAccess = offAccess;
	}




	public void setInstallmonth(String installmonth) {
		this.installmonth = installmonth;
	}

	public Boolean getWorkingcondition() {
		return workingcondition;
	}

	public void setWorkingcondition(Boolean workingcondition) {
		this.workingcondition = workingcondition;
	}

	public String getDatelastCalibrated() {
		return datelastCalibrated;
	}

	public void setDatelastCalibrated(String datelastCalibrated) {
		this.datelastCalibrated = datelastCalibrated;
	}

	public String getDatenextCalibrated() {
		return datenextCalibrated;
	}

	public void setDatenextCalibrated(String datenextCalibrated) {
		this.datenextCalibrated = datenextCalibrated;
	}

	public Boolean getObsmaintained() {
		return obsmaintained;
	}

	public void setObsmaintained(Boolean obsmaintained) {
		this.obsmaintained = obsmaintained;
	}

	public Boolean getAgencyresponsible() {
		return agencyresponsible;
	}

	public void setAgencyresponsible(Boolean agencyresponsible) {
		this.agencyresponsible = agencyresponsible;
	}

	public Boolean getAnalysisofdata() {
		return analysisofdata;
	}

	public void setAnalysisofdata(Boolean analysisofdata) {
		this.analysisofdata = analysisofdata;
	}

	public Boolean getDatasenttoDSO() {
		return datasenttoDSO;
	}

	public void setDatasenttoDSO(Boolean datasenttoDSO) {
		this.datasenttoDSO = datasenttoDSO;
	}

	public String getWeathercondition() {
		return weathercondition;
	}

	public void setWeathercondition(String weathercondition) {
		this.weathercondition = weathercondition;
	}

	public Double getStorageCapacity() {
		return storageCapacity;
	}

	public void setStorageCapacity(Double storageCapacity) {
		this.storageCapacity = storageCapacity;
	}

	public String getTypeofinspection() {
		return typeofinspection;
	}

	public void setTypeofinspection(String typeofinspection) {
		this.typeofinspection = typeofinspection;
	}

	private  String  typeofinspection;
	
	private Boolean remarksinclindoc;
	
	private String submittedToEmpName;
	
	private String remarksSubmittedBy;
	
	private String unitAddress;
	
	
	
	
	
	
	
	
	public String getUnitAddress() {
		return unitAddress;
	}




	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}




	public String getSubmittedToEmpName() {
		return submittedToEmpName;
	}




	public void setSubmittedToEmpName(String submittedToEmpName) {
		this.submittedToEmpName = submittedToEmpName;
	}




	public String getRemarksSubmittedBy() {
		return remarksSubmittedBy;
	}




	public void setRemarksSubmittedBy(String remarksSubmittedBy) {
		this.remarksSubmittedBy = remarksSubmittedBy;
	}




	public Boolean getRemarksinclindoc() {
		return remarksinclindoc;
	}

	public void setRemarksinclindoc(Boolean remarksinclindoc) {
		this.remarksinclindoc = remarksinclindoc;
	}

	public String getDeficiencyCategoryName() {
		return deficiencyCategoryName;
	}

	public void setDeficiencyCategoryName(String deficiencyCategoryName) {
		this.deficiencyCategoryName = deficiencyCategoryName;
	}

	public Integer getConditionofDamId() {
		return conditionofDamId;
	}

	public void setConditionofDamId(Integer conditionofDamId) {
		this.conditionofDamId = conditionofDamId;
	}

	private String inspectOfficeName;
	
	private Integer resinspectInfoId;
	
	private Boolean isLatest;
	
	private Integer deficiencyCategory;
	
	private Integer conditionofDamId;
	
	private Integer damDocId;
	
	private String createDate;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	
	
	
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	


	public String getCreateDate() {
		return createDate;
	}




	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}




	public Integer getDamDocId() {
		return damDocId;
	}




	public void setDamDocId(Integer damDocId) {
		this.damDocId = damDocId;
	}




	public Integer getDeficiencyCategory() {
		return deficiencyCategory;
	}

	public void setDeficiencyCategory(Integer deficiencyCategory) {
		this.deficiencyCategory = deficiencyCategory;
	}

	public Integer getResinspectInfoId() {
		return resinspectInfoId;
	}

	public void setResinspectInfoId(Integer resinspectInfoId) {
		this.resinspectInfoId = resinspectInfoId;
	}

	public Boolean getIsLatest() {
		return isLatest;
	}

	public void setIsLatest(Boolean isLatest) {
		this.isLatest = isLatest;
	}

	public Integer getResannRecommendId() {
		return resannRecommendId;
	}

	public void setResannRecommendId(Integer resannRecommendId) {
		this.resannRecommendId = resannRecommendId;
	}

	public String getInspectOfficeName() {
		return inspectOfficeName;
	}

	public void setInspectOfficeName(String inspectOfficeName) {
		this.inspectOfficeName = inspectOfficeName;
	}

	public Boolean getCatistitle() {
		return catistitle;
	}

	public void setCatistitle(Boolean catistitle) {
		this.catistitle = catistitle;
	}

	public String getResCheckNumDisplay() {
		return resCheckNumDisplay;
	}

	public void setResCheckNumDisplay(String resCheckNumDisplay) {
		this.resCheckNumDisplay = resCheckNumDisplay;
	}

	public String getResCatNumDisplay() {
		return resCatNumDisplay;
	}

	public void setResCatNumDisplay(String resCatNumDisplay) {
		this.resCatNumDisplay = resCatNumDisplay;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public Integer getInspectOfficeInfoId() {
		return inspectOfficeInfoId;
	}

	public void setInspectOfficeInfoId(Integer inspectOfficeInfoId) {
		this.inspectOfficeInfoId = inspectOfficeInfoId;
	}

	public Double getIrrChFrm() {
		return irrChFrm;
	}

	public void setIrrChFrm(Double irrChFrm) {
		this.irrChFrm = irrChFrm;
	}

	public Double getIrrChTo() {
		return irrChTo;
	}

	public void setIrrChTo(Double irrChTo) {
		this.irrChTo = irrChTo;
	}

	public Integer getInspectOfficeId() {
		return inspectOfficeId;
	}

	public void setInspectOfficeId(Integer inspectOfficeId) {
		this.inspectOfficeId = inspectOfficeId;
	}

	public String getInspectOfficerData() {
		return inspectOfficerData;
	}

	public void setInspectOfficerData(String inspectOfficerData) {
		this.inspectOfficerData = inspectOfficerData;
	}

	public String getFieldOfficerData() {
		return fieldOfficerData;
	}

	public void setFieldOfficerData(String fieldOfficerData) {
		this.fieldOfficerData = fieldOfficerData;
	}

	public Double getPresentWaterlevel() {
		return presentWaterlevel;
	}

	public void setPresentWaterlevel(Double presentWaterlevel) {
		this.presentWaterlevel = presentWaterlevel;
	}

	public Boolean getInchargeofAnn1() {
		return inchargeofAnn1;
	}

	public void setInchargeofAnn1(Boolean inchargeofAnn1) {
		this.inchargeofAnn1 = inchargeofAnn1;
	}

	public String getPreDaminspecteddata() {
		return preDaminspecteddata;
	}

	public void setPreDaminspecteddata(String preDaminspecteddata) {
		this.preDaminspecteddata = preDaminspecteddata;
	}

	public Boolean getItemsInspected() {
		return itemsInspected;
	}

	public void setItemsInspected(Boolean itemsInspected) {
		this.itemsInspected = itemsInspected;
	}

	public String getItemsInspectedReason() {
		return itemsInspectedReason;
	}

	public void setItemsInspectedReason(String itemsInspectedReason) {
		this.itemsInspectedReason = itemsInspectedReason;
	}

	public Boolean getVigandWatchProvided() {
		return vigandWatchProvided;
	}

	public void setVigandWatchProvided(Boolean vigandWatchProvided) {
		this.vigandWatchProvided = vigandWatchProvided;
	}

	public String getVigandwatchreason() {
		return vigandwatchreason;
	}

	public void setVigandwatchreason(String vigandwatchreason) {
		this.vigandwatchreason = vigandwatchreason;
	}

	public Boolean getObsAnn2() {
		return obsAnn2;
	}

	public void setObsAnn2(Boolean obsAnn2) {
		this.obsAnn2 = obsAnn2;
	}

	public Boolean getResCheckAddFlag() {
		return resCheckAddFlag;
	}

	public void setResCheckAddFlag(Boolean resCheckAddFlag) {
		this.resCheckAddFlag = resCheckAddFlag;
	}

	public Integer getCatType() {
		return catType;
	}

	public void setCatType(Integer catType) {
		this.catType = catType;
	}

	public Boolean getHasChild() {
		return hasChild;
	}

	public void setHasChild(Boolean hasChild) {
		this.hasChild = hasChild;
	}

	public Integer getAnnexureId() {
		return annexureId;
	}

	public void setAnnexureId(Integer annexureId) {
		this.annexureId = annexureId;
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

	public String getGenRemarks() {
		return genRemarks;
	}

	public void setGenRemarks(String genRemarks) {
		this.genRemarks = genRemarks;
	}

	public String getErRemarks() {
		return erRemarks;
	}

	public void setErRemarks(String erRemarks) {
		this.erRemarks = erRemarks;
	}

	public String getOmRemarks() {
		return omRemarks;
	}

	public void setOmRemarks(String omRemarks) {
		this.omRemarks = omRemarks;
	}

	public String getCmRemarks() {
		return cmRemarks;
	}

	public void setCmRemarks(String cmRemarks) {
		this.cmRemarks = cmRemarks;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getNextPostId() {
		return nextPostId;
	}

	public void setNextPostId(Long nextPostId) {
		this.nextPostId = nextPostId;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getReasonForPending() {
		return reasonForPending;
	}

	public void setReasonForPending(String reasonForPending) {
		this.reasonForPending = reasonForPending;
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public Integer getResDamHealthId() {
		return resDamHealthId;
	}

	public void setResDamHealthId(Integer resDamHealthId) {
		this.resDamHealthId = resDamHealthId;
	}

	public Integer getResRecommendId() {
		return resRecommendId;
	}

	public void setResRecommendId(Integer resRecommendId) {
		this.resRecommendId = resRecommendId;
	}

	public Integer getResDamActionId() {
		return resDamActionId;
	}

	public void setResDamActionId(Integer resDamActionId) {
		this.resDamActionId = resDamActionId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getResInspectMst1Id() {
		return resInspectMst1Id;
	}

	public void setResInspectMst1Id(Integer resInspectMst1Id) {
		this.resInspectMst1Id = resInspectMst1Id;
	}

	public Integer getResInspectMst2Id() {
		return resInspectMst2Id;
	}

	public void setResInspectMst2Id(Integer resInspectMst2Id) {
		this.resInspectMst2Id = resInspectMst2Id;
	}

	public String getUserEmpId() {
		return userEmpId;
	}

	public void setUserEmpId(String userEmpId) {
		this.userEmpId = userEmpId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getTabId() {
		return tabId;
	}

	public void setTabId(Integer tabId) {
		this.tabId = tabId;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public Boolean getActionTakeninit() {
		return actionTakeninit;
	}

	public void setActionTakeninit(Boolean actionTakeninit) {
		this.actionTakeninit = actionTakeninit;
	}

	public Boolean getActionTakencomplete() {
		return actionTakencomplete;
	}

	public void setActionTakencomplete(Boolean actionTakencomplete) {
		this.actionTakencomplete = actionTakencomplete;
	}

	public String getRecomendbysdso() {
		return recomendbysdso;
	}

	public void setRecomendbysdso(String recomendbysdso) {
		this.recomendbysdso = recomendbysdso;
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

	public String getWeekstartDate() {
		return weekstartDate;
	}

	public void setWeekstartDate(String weekstartDate) {
		this.weekstartDate = weekstartDate;
	}

	public String getWeekendDate() {
		return weekendDate;
	}

	public void setWeekendDate(String weekendDate) {
		this.weekendDate = weekendDate;
	}

	public Integer getDutyFrequencyId() {
		return dutyFrequencyId;
	}

	public void setDutyFrequencyId(Integer dutyFrequencyId) {
		this.dutyFrequencyId = dutyFrequencyId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getResCheckName() {
		return resCheckName;
	}

	public void setResCheckName(String resCheckName) {
		this.resCheckName = resCheckName;
	}

	public String getActionReqName() {
		return actionReqName;
	}

	public void setActionReqName(String actionReqName) {
		this.actionReqName = actionReqName;
	}

	public String getActionReqTypeName() {
		return actionReqTypeName;
	}

	public void setActionReqTypeName(String actionReqTypeName) {
		this.actionReqTypeName = actionReqTypeName;
	}

	public Integer getResStatusId() {
		return resStatusId;
	}

	public void setResStatusId(Integer resStatusId) {
		this.resStatusId = resStatusId;
	}

	public String getUrlvalue() {
		return urlvalue;
	}

	public void setUrlvalue(String urlvalue) {
		this.urlvalue = urlvalue;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getApprovStatusId() {
		return approvStatusId;
	}

	public void setApprovStatusId(Integer approvStatusId) {
		this.approvStatusId = approvStatusId;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public Integer getResCheckboxId() {
		return resCheckboxId;
	}

	public void setResCheckboxId(Integer resCheckboxId) {
		this.resCheckboxId = resCheckboxId;
	}

	public String getInspectDate() {
		return inspectDate;
	}

	public void setInspectDate(String inspectDate) {
		this.inspectDate = inspectDate;
	}

	private Integer userId;
	
	private String userName;
	
	private List<ReservoirInspect> reservoirInspectList;
	
	private Integer nextEmpId;
	
	private String nextEmpName;
	
	
	

	
	public Integer getNextEmpId() {
		return nextEmpId;
	}

	public void setNextEmpId(Integer nextEmpId) {
		this.nextEmpId = nextEmpId;
	}

	public String getNextEmpName() {
		return nextEmpName;
	}

	public void setNextEmpName(String nextEmpName) {
		this.nextEmpName = nextEmpName;
	}

	public List<ReservoirInspect> getReservoirInspectList() {
		return reservoirInspectList;
	}

	public void setReservoirInspectList(List<ReservoirInspect> reservoirInspectList) {
		this.reservoirInspectList = reservoirInspectList;
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

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getReservoirId() {
		return reservoirId;
	}

	public void setReservoirId(Integer reservoirId) {
		this.reservoirId = reservoirId;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	public Integer getResInspectId() {
		return resInspectId;
	}

	public void setResInspectId(Integer resInspectId) {
		this.resInspectId = resInspectId;
	}

	public Integer getResCheckId() {
		return resCheckId;
	}

	public void setResCheckId(Integer resCheckId) {
		this.resCheckId = resCheckId;
	}

	public Integer getResCatId() {
		return resCatId;
	}

	public void setResCatId(Integer resCatId) {
		this.resCatId = resCatId;
	}

	public Integer getResParentcatId() {
		return resParentcatId;
	}

	public void setResParentcatId(Integer resParentcatId) {
		this.resParentcatId = resParentcatId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
   
	
	private Integer resUnitProjMapId;
	
	private String postName;
	

	
	
	
	public String getPostName() {
		return postName;
	}




	public void setPostName(String postName) {
		this.postName = postName;
	}




	public Integer getResUnitProjMapId() {
		return resUnitProjMapId;
	}




	public void setResUnitProjMapId(Integer resUnitProjMapId) {
		this.resUnitProjMapId = resUnitProjMapId;
	}

	private String nrldCode;
	
	private Boolean latestHealthCategory;
	
	
	
	public Boolean getLatestHealthCategory() {
		return latestHealthCategory;
	}




	public void setLatestHealthCategory(Boolean latestHealthCategory) {
		this.latestHealthCategory = latestHealthCategory;
	}




	public String getNrldCode() {
		return nrldCode;
	}




	public void setNrldCode(String nrldCode) {
		this.nrldCode = nrldCode;
	}




	@Override
	public String toString() {
		return "ReservoirInspect [unitId=" + unitId + ", circleId=" + circleId + ", divisionId=" + divisionId
				+ ", subdivisionId=" + subdivisionId + ", projectId=" + projectId + ", reservoirId=" + reservoirId
				+ ", designationId=" + designationId + ", resInspectId=" + resInspectId + ", resCheckId=" + resCheckId
				+ ", resCatId=" + resCatId + ", resParentcatId=" + resParentcatId + ", remarks=" + remarks
				+ ", inspectDate=" + inspectDate + ", resCheckboxId=" + resCheckboxId + ", resCode=" + resCode
				+ ", approvStatusId=" + approvStatusId + ", year=" + year + ", urlvalue=" + urlvalue + ", resStatusId="
				+ resStatusId + ", resCheckName=" + resCheckName + ", actionReqName=" + actionReqName
				+ ", actionReqTypeName=" + actionReqTypeName + ", statusName=" + statusName + ", dutyFrequencyId="
				+ dutyFrequencyId + ", weekstartDate=" + weekstartDate + ", weekendDate=" + weekendDate
				+ ", resCategoryId=" + resCategoryId + ", resCategory=" + resCategory + ", recomendbysdso="
				+ recomendbysdso + ", actionTakeninit=" + actionTakeninit + ", actionTakencomplete="
				+ actionTakencomplete + ", tabId=" + tabId + ", levelId=" + levelId + ", empId=" + empId + ", empName="
				+ empName + ", userEmpId=" + userEmpId + ", resInspectMst1Id=" + resInspectMst1Id
				+ ", resInspectMst2Id=" + resInspectMst2Id + ", userId=" + userId + ", userName=" + userName
				+ ", reservoirInspectList=" + reservoirInspectList + ", nextEmpId=" + nextEmpId + ", nextEmpName="
				+ nextEmpName + "]";
	}
	
	

}
