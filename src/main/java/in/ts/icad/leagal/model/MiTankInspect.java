package in.ts.icad.leagal.model;


import java.util.Arrays;
import java.util.List;

public class MiTankInspect {
	
	private Integer newDistrictId;
	
	private String districtName;
	
	private Long preTankCount;
	
	private Long postTankCount;
	
	private Long duringTankCount;
	
	private Integer prefreq;
	
	private Integer postfreq;
	
	private Integer duringfreq;
	
	private Integer miTankFreqId;
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	private Integer subdivisionId;
	
	private Long selectedPostId;
	
	private Integer selectedEmpId;
	
	
	
	
	
	


	public Integer getSelectedEmpId() {
		return selectedEmpId;
	}

	public void setSelectedEmpId(Integer selectedEmpId) {
		this.selectedEmpId = selectedEmpId;
	}

	public Long getSelectedPostId() {
		return selectedPostId;
	}

	public void setSelectedPostId(Long selectedPostId) {
		this.selectedPostId = selectedPostId;
	}


	private Integer projectId;
	private Long tankId;
	private Long tankCode;
	public Long getTankCode() {
		return tankCode;
	}

	public void setTankCode(Long tankCode) {
		this.tankCode = tankCode;
	}


	private String tankName;
	
	private String circleName;
	private String unitName;
	private String divisionName;
	private String subdivisionName;
	
	private String activityFrequency;
	
	private Integer mandalId;
	
	private Integer villageId;
	
	private String mandalName;
	
	private String villageName;
	
	private double waterLevelInspect;
	
	private double capacitymcft;
	
	
	private Integer userId;
	
	private String userName;
	
	private Integer miInspectTypeId;
	
	private Integer miInspectMapId;
	
	private Integer miCompId;
	
	private Integer micheckboxId;
	
	private String inspectDate;
	
	private Boolean actionreq;
	
	
	private Integer actionrequireqId;
	
	private String remarks;
	
	private Integer constId;
	
	private Integer miTankInspectId;
	
	private String inpsectComplete;
	
	private Integer tankWeirSluiceId;
	
	private Integer tankInspectApproveId;
	
	private Integer tankInspectApproveStatusId;
	
	private String tankInspectApproveStatus;
	
	private String miInspectTypeName;
	
	private String miCompName;
	
	
	private Integer miCompParentId;
	
	private String miActionReqTypeName;
	
	private String actionReqName;
	
	private String urlvalue;
	
	private String userEmpId;
	
  private Integer designationId;
  
  private String repairDescription;
  
  private double rate;
  
  private Integer  unitMeasureId;
  
  private double quantity;
  
  private String schemeTaken;
  
  private Double amount;
  
  private Integer miInpsectMst1Id;
  
  private Integer miInpsectMst2Id;
  
  private double inflow;
  
  private double outfow;
  
  private double ayacut;
  
  private String grossCapacity;
  
  private String availableCapacity;
  
  private Boolean surplus;
  
  private Integer tabId;
  
  private  Integer levelId;
  
  private Integer inflowoutflowId;
  
  private String projectName;
  
  private String designation;
  
  private Integer ommirepairId;
  
  private Integer ommicapacityId;
  
  private String unitMeasureName;
  
  private Integer nextEmpId;
	
	private String nextEmpName;
	
	
	private Boolean canFeed;
	
	private Integer chainLinkId;
	
	private Integer sourceTypeId;
	
	private Integer sourceCompTypeId;
	
	private Integer sourceCompId;
	private String sourceDetails;
	
	private String otLocationKm;
	
	
	private Integer  empId;
	
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
	
	private Integer offAccess;
	
	private Integer userUnitId;
	private Integer userCircleId;
	private Integer userDivisionId;
	private Integer userSubdivisionId;
	private Integer userDesignationId;
	
	private Integer backdesignationId;
	
	private Integer reportType;
	
	
	
	
	
	
	


	

	public Integer getReportType() {
		return reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
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

	public Integer getUserCircleId() {
		return userCircleId;
	}

	public void setUserCircleId(Integer userCircleId) {
		this.userCircleId = userCircleId;
	}

	public Integer getUserDivisionId() {
		return userDivisionId;
	}

	public void setUserDivisionId(Integer userDivisionId) {
		this.userDivisionId = userDivisionId;
	}

	public Integer getUserSubdivisionId() {
		return userSubdivisionId;
	}

	public void setUserSubdivisionId(Integer userSubdivisionId) {
		this.userSubdivisionId = userSubdivisionId;
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


	private Long   postId;
	private String postName;
	
	private Long   nextPostId;
	
	private Integer nextDesignationId;
	
	
	

	
	
	
	public Integer getNextDesignationId() {
		return nextDesignationId;
	}

	public void setNextDesignationId(Integer nextDesignationId) {
		this.nextDesignationId = nextDesignationId;
	}


	private String  chainLinkName;
	
	private String sourceTypeName;
	private String sourceCompTypeName;
	private String sourceCompName;
	
	
	private Integer mitankFeedDetailsId;
	
	private String compCode;
	
	private Integer mitankFeedReviewId;
	
	private Integer mitankCapacityId;
	
	private Integer mitankCapacityReviewId;
	
	private Integer mitankRepairsId;
	private Integer mitankRepairsReviewId;
	
	private Integer mitankInoutFlowId;
	private Integer mitankInoutFlowReviewId;
	
	private Integer miInpsectMst1IdReviewId;
	
	private String embRemarks;
	
	private String sluRemarks;
	
	private String weirRemarks;
	
	private String inspectDateRepair;
	
	private String inspectDateCapacity;
	
	private String inspectDateFeed;
	
	private Boolean latestRemarks;
	private String remarksDate;
	
	private String repairRemarksDate;
	
	private String capacityRemarksDate;
	
	
	private Integer submittedTOEmp;
	private Integer submittedBy;
	
	private String submittedToEmpName;
	private String submittedByEmpName;
	
	private String remarksSubmittedBy;
	
	private String tankWeirSluiceName;
	
	private Integer  tankWeirSluiceTypeId;
	
	private Double percentageCapacity;
	
	private Integer tankStatusId;
	
	private String tankStatus;
	
	private Integer  totalCount;
	
	private Integer  office;
	
	private Integer abstracttype;
	
	private String repairStartDate;
	
	private String repairEndDate;
	
	private Integer repairdescId;
	
	private String repairdescdata;
	
	private Double tankLevel;
	
	private Double grossAyacut;
	
	private Integer sectionId;
	
	private String sectionName;
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public Double getGrossAyacut() {
		return grossAyacut;
	}

	public void setGrossAyacut(Double grossAyacut) {
		this.grossAyacut = grossAyacut;
	}

	public Double getTankLevel() {
		return tankLevel;
	}

	public void setTankLevel(Double tankLevel) {
		this.tankLevel = tankLevel;
	}

	public Integer getRepairdescId() {
		return repairdescId;
	}

	public void setRepairdescId(Integer repairdescId) {
		this.repairdescId = repairdescId;
	}

	public String getRepairdescdata() {
		return repairdescdata;
	}

	public void setRepairdescdata(String repairdescdata) {
		this.repairdescdata = repairdescdata;
	}

	public String getRepairStartDate() {
		return repairStartDate;
	}

	public void setRepairStartDate(String repairStartDate) {
		this.repairStartDate = repairStartDate;
	}

	public String getRepairEndDate() {
		return repairEndDate;
	}

	public void setRepairEndDate(String repairEndDate) {
		this.repairEndDate = repairEndDate;
	}

	public Integer getAbstracttype() {
		return abstracttype;
	}

	public void setAbstracttype(Integer abstracttype) {
		this.abstracttype = abstracttype;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getEmergencyCount() {
		return emergencyCount;
	}

	public void setEmergencyCount(Integer emergencyCount) {
		this.emergencyCount = emergencyCount;
	}

	
	public Integer getObserveCount() {
		return observeCount;
	}

	public void setObserveCount(Integer observeCount) {
		this.observeCount = observeCount;
	}

	public Integer getOriginalworkCount() {
		return originalworkCount;
	}

	public void setOriginalworkCount(Integer originalworkCount) {
		this.originalworkCount = originalworkCount;
	}

	public Integer getDefferedCount() {
		return defferedCount;
	}

	public void setDefferedCount(Integer defferedCount) {
		this.defferedCount = defferedCount;
	}


	private Integer emergencyCount;
	
	private Integer observeCount;
	
	private Integer originalworkCount;
	
	private Integer defferedCount;
	
	
	
	
	

	public Integer getTankStatusId() {
		return tankStatusId;
	}

	public void setTankStatusId(Integer tankStatusId) {
		this.tankStatusId = tankStatusId;
	}

	public String getTankStatus() {
		return tankStatus;
	}

	public void setTankStatus(String tankStatus) {
		this.tankStatus = tankStatus;
	}

	public Double getPercentageCapacity() {
		return percentageCapacity;
	}

	public void setPercentageCapacity(Double percentageCapacity) {
		this.percentageCapacity = percentageCapacity;
	}

	public Integer getTankWeirSluiceTypeId() {
		return tankWeirSluiceTypeId;
	}

	public void setTankWeirSluiceTypeId(Integer tankWeirSluiceTypeId) {
		this.tankWeirSluiceTypeId = tankWeirSluiceTypeId;
	}

	public String getTankWeirSluiceTypeName() {
		return tankWeirSluiceTypeName;
	}

	public void setTankWeirSluiceTypeName(String tankWeirSluiceTypeName) {
		this.tankWeirSluiceTypeName = tankWeirSluiceTypeName;
	}


	private String tankWeirSluiceTypeName;
	
	
	
	
	
	
	
	
	
	
	public String getTankWeirSluiceName() {
		return tankWeirSluiceName;
	}

	public void setTankWeirSluiceName(String tankWeirSluiceName) {
		this.tankWeirSluiceName = tankWeirSluiceName;
	}

	public Integer getSubmittedTOEmp() {
		return submittedTOEmp;
	}

	public void setSubmittedTOEmp(Integer submittedTOEmp) {
		this.submittedTOEmp = submittedTOEmp;
	}

	public Integer getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(Integer submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getSubmittedToEmpName() {
		return submittedToEmpName;
	}

	public void setSubmittedToEmpName(String submittedToEmpName) {
		this.submittedToEmpName = submittedToEmpName;
	}

	public String getSubmittedByEmpName() {
		return submittedByEmpName;
	}

	public void setSubmittedByEmpName(String submittedByEmpName) {
		this.submittedByEmpName = submittedByEmpName;
	}

	public String getRemarksSubmittedBy() {
		return remarksSubmittedBy;
	}

	public void setRemarksSubmittedBy(String remarksSubmittedBy) {
		this.remarksSubmittedBy = remarksSubmittedBy;
	}

	public Boolean getLatestRemarks() {
		return latestRemarks;
	}

	public void setLatestRemarks(Boolean latestRemarks) {
		this.latestRemarks = latestRemarks;
	}

	public String getRemarksDate() {
		return remarksDate;
	}

	public void setRemarksDate(String remarksDate) {
		this.remarksDate = remarksDate;
	}
	
	public String getInspectDateFeed() {
		return inspectDateFeed;
	}

	public void setInspectDateFeed(String inspectDateFeed) {
		this.inspectDateFeed = inspectDateFeed;
	}


	private String capacityRemarks;
	private String repairRemarks;
	
	private String feedRemarks;
	
	
	
	
	
	
	
	
	

	
	public String getCapacityRemarks() {
		return capacityRemarks;
	}

	public void setCapacityRemarks(String capacityRemarks) {
		this.capacityRemarks = capacityRemarks;
	}

	public String getRepairRemarks() {
		return repairRemarks;
	}

	public void setRepairRemarks(String repairRemarks) {
		this.repairRemarks = repairRemarks;
	}

	public String getFeedRemarks() {
		return feedRemarks;
	}

	public void setFeedRemarks(String feedRemarks) {
		this.feedRemarks = feedRemarks;
	}

	public String getInspectDateCapacity() {
		return inspectDateCapacity;
	}

	public void setInspectDateCapacity(String inspectDateCapacity) {
		this.inspectDateCapacity = inspectDateCapacity;
	}

	public String getInspectDateRepair() {
		return inspectDateRepair;
	}

	public void setInspectDateRepair(String inspectDateRepair) {
		this.inspectDateRepair = inspectDateRepair;
	}

	public String getEmbRemarks() {
		return embRemarks;
	}

	public void setEmbRemarks(String embRemarks) {
		this.embRemarks = embRemarks;
	}

	public String getSluRemarks() {
		return sluRemarks;
	}

	public void setSluRemarks(String sluRemarks) {
		this.sluRemarks = sluRemarks;
	}

	public String getWeirRemarks() {
		return weirRemarks;
	}

	public void setWeirRemarks(String weirRemarks) {
		this.weirRemarks = weirRemarks;
	}

	public Integer getMiInpsectMst1IdReviewId() {
		return miInpsectMst1IdReviewId;
	}

	public void setMiInpsectMst1IdReviewId(Integer miInpsectMst1IdReviewId) {
		this.miInpsectMst1IdReviewId = miInpsectMst1IdReviewId;
	}

	public Integer getMitankCapacityId() {
		return mitankCapacityId;
	}

	public void setMitankCapacityId(Integer mitankCapacityId) {
		this.mitankCapacityId = mitankCapacityId;
	}

	public Integer getMitankCapacityReviewId() {
		return mitankCapacityReviewId;
	}

	public void setMitankCapacityReviewId(Integer mitankCapacityReviewId) {
		this.mitankCapacityReviewId = mitankCapacityReviewId;
	}

	public Integer getMitankRepairsId() {
		return mitankRepairsId;
	}

	public void setMitankRepairsId(Integer mitankRepairsId) {
		this.mitankRepairsId = mitankRepairsId;
	}

	public Integer getMitankRepairsReviewId() {
		return mitankRepairsReviewId;
	}

	public void setMitankRepairsReviewId(Integer mitankRepairsReviewId) {
		this.mitankRepairsReviewId = mitankRepairsReviewId;
	}

	public Integer getMitankInoutFlowId() {
		return mitankInoutFlowId;
	}

	public void setMitankInoutFlowId(Integer mitankInoutFlowId) {
		this.mitankInoutFlowId = mitankInoutFlowId;
	}

	public Integer getMitankInoutFlowReviewId() {
		return mitankInoutFlowReviewId;
	}

	public void setMitankInoutFlowReviewId(Integer mitankInoutFlowReviewId) {
		this.mitankInoutFlowReviewId = mitankInoutFlowReviewId;
	}

	public Integer getMitankFeedReviewId() {
		return mitankFeedReviewId;
	}

	public void setMitankFeedReviewId(Integer mitankFeedReviewId) {
		this.mitankFeedReviewId = mitankFeedReviewId;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public Integer getMitankFeedDetailsId() {
		return mitankFeedDetailsId;
	}

	public void setMitankFeedDetailsId(Integer mitankFeedDetailsId) {
		this.mitankFeedDetailsId = mitankFeedDetailsId;
	}

	public String getChainLinkName() {
		return chainLinkName;
	}

	public void setChainLinkName(String chainLinkName) {
		this.chainLinkName = chainLinkName;
	}

	public String getSourceTypeName() {
		return sourceTypeName;
	}

	public void setSourceTypeName(String sourceTypeName) {
		this.sourceTypeName = sourceTypeName;
	}

	public String getSourceCompTypeName() {
		return sourceCompTypeName;
	}

	public void setSourceCompTypeName(String sourceCompTypeName) {
		this.sourceCompTypeName = sourceCompTypeName;
	}

	public String getSourceCompName() {
		return sourceCompName;
	}

	public void setSourceCompName(String sourceCompName) {
		this.sourceCompName = sourceCompName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getOtLocationKm() {
		return otLocationKm;
	}

	public void setOtLocationKm(String otLocationKm) {
		this.otLocationKm = otLocationKm;
	}

	public Boolean getCanFeed() {
		return canFeed;
	}

	public void setCanFeed(Boolean canFeed) {
		this.canFeed = canFeed;
	}

	public Integer getChainLinkId() {
		return chainLinkId;
	}

	public void setChainLinkId(Integer chainLinkId) {
		this.chainLinkId = chainLinkId;
	}

	public Integer getSourceTypeId() {
		return sourceTypeId;
	}

	public void setSourceTypeId(Integer sourceTypeId) {
		this.sourceTypeId = sourceTypeId;
	}

	public Integer getSourceCompTypeId() {
		return sourceCompTypeId;
	}

	public void setSourceCompTypeId(Integer sourceCompTypeId) {
		this.sourceCompTypeId = sourceCompTypeId;
	}

	public Integer getSourceCompId() {
		return sourceCompId;
	}

	public void setSourceCompId(Integer sourceCompId) {
		this.sourceCompId = sourceCompId;
	}



	public String getSourceDetails() {
		return sourceDetails;
	}

	public void setSourceDetails(String sourceDetails) {
		this.sourceDetails = sourceDetails;
	}

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
  
  
  
  
  
  
  
  
  
  
  
	
	
	
	
	
	
	
	
	
	


	public String getUnitMeasureName() {
	return unitMeasureName;
}


public void setUnitMeasureName(String unitMeasureName) {
	this.unitMeasureName = unitMeasureName;
}


	public Integer getOmmirepairId() {
	return ommirepairId;
}


public void setOmmirepairId(Integer ommirepairId) {
	this.ommirepairId = ommirepairId;
}


public Integer getOmmicapacityId() {
	return ommicapacityId;
}


public void setOmmicapacityId(Integer ommicapacityId) {
	this.ommicapacityId = ommicapacityId;
}


	public String getDesignation() {
	return designation;
}


public void setDesignation(String designation) {
	this.designation = designation;
}


	public String getProjectName() {
	return projectName;
}


public void setProjectName(String projectName) {
	this.projectName = projectName;
}


	public Integer getInflowoutflowId() {
	return inflowoutflowId;
}


public void setInflowoutflowId(Integer inflowoutflowId) {
	this.inflowoutflowId = inflowoutflowId;
}


	public Integer getLevelId() {
	return levelId;
}


public void setLevelId(Integer levelId) {
	this.levelId = levelId;
}


	public Integer getTabId() {
	return tabId;
}


public void setTabId(Integer tabId) {
	this.tabId = tabId;
}


	public Integer getMiInpsectMst1Id() {
	return miInpsectMst1Id;
}


public void setMiInpsectMst1Id(Integer miInpsectMst1Id) {
	this.miInpsectMst1Id = miInpsectMst1Id;
}


public Integer getMiInpsectMst2Id() {
	return miInpsectMst2Id;
}


public void setMiInpsectMst2Id(Integer miInpsectMst2Id) {
	this.miInpsectMst2Id = miInpsectMst2Id;
}


public double getInflow() {
	return inflow;
}


public void setInflow(double inflow) {
	this.inflow = inflow;
}


public double getOutfow() {
	return outfow;
}


public void setOutfow(double outfow) {
	this.outfow = outfow;
}


public double getAyacut() {
	return ayacut;
}


public void setAyacut(double ayacut) {
	this.ayacut = ayacut;
}


public String getGrossCapacity() {
	return grossCapacity;
}


public void setGrossCapacity(String grossCapacity) {
	this.grossCapacity = grossCapacity;
}


public String getAvailableCapacity() {
	return availableCapacity;
}


public void setAvailableCapacity(String availableCapacity) {
	this.availableCapacity = availableCapacity;
}


public Boolean getSurplus() {
	return surplus;
}


public void setSurplus(Boolean surplus) {
	this.surplus = surplus;
}


	public String getRepairDescription() {
	return repairDescription;
}


public void setRepairDescription(String repairDescription) {
	this.repairDescription = repairDescription;
}


public double getRate() {
	return rate;
}


public void setRate(double rate) {
	this.rate = rate;
}


public Integer getUnitMeasureId() {
	return unitMeasureId;
}


public void setUnitMeasureId(Integer unitMeasureId) {
	this.unitMeasureId = unitMeasureId;
}


public double getQuantity() {
	return quantity;
}


public void setQuantity(double quantity) {
	this.quantity = quantity;
}


public String getSchemeTaken() {
	return schemeTaken;
}


public void setSchemeTaken(String schemeTaken) {
	this.schemeTaken = schemeTaken;
}


public Double getAmount() {
	return amount;
}


public void setAmount(Double amount) {
	this.amount = amount;
}


	public Integer getDesignationId() {
	return designationId;
}


public void setDesignationId(Integer designationId) {
	this.designationId = designationId;
}


	public String getUserEmpId() {
		return userEmpId;
	}


	public void setUserEmpId(String userEmpId) {
		this.userEmpId = userEmpId;
	}


	public String getUrlvalue() {
		return urlvalue;
	}


	public void setUrlvalue(String urlvalue) {
		this.urlvalue = urlvalue;
	}


	public String getActionReqName() {
		return actionReqName;
	}


	public void setActionReqName(String actionReqName) {
		this.actionReqName = actionReqName;
	}


	public String getMiActionReqTypeName() {
		return miActionReqTypeName;
	}


	public void setMiActionReqTypeName(String miActionReqTypeName) {
		this.miActionReqTypeName = miActionReqTypeName;
	}


	public String getMiInspectTypeName() {
		return miInspectTypeName;
	}


	public void setMiInspectTypeName(String miInspectTypeName) {
		this.miInspectTypeName = miInspectTypeName;
	}


	public String getMiCompName() {
		return miCompName;
	}


	public void setMiCompName(String miCompName) {
		this.miCompName = miCompName;
	}


	public Integer getMiCompParentId() {
		return miCompParentId;
	}


	public void setMiCompParentId(Integer miCompParentId) {
		this.miCompParentId = miCompParentId;
	}


	public Integer getTankInspectApproveId() {
		return tankInspectApproveId;
	}


	public void setTankInspectApproveId(Integer tankInspectApproveId) {
		this.tankInspectApproveId = tankInspectApproveId;
	}


	public Integer getTankInspectApproveStatusId() {
		return tankInspectApproveStatusId;
	}


	public void setTankInspectApproveStatusId(Integer tankInspectApproveStatusId) {
		this.tankInspectApproveStatusId = tankInspectApproveStatusId;
	}


	public String getTankInspectApproveStatus() {
		return tankInspectApproveStatus;
	}


	public void setTankInspectApproveStatus(String tankInspectApproveStatus) {
		this.tankInspectApproveStatus = tankInspectApproveStatus;
	}


	public Integer getTankWeirSluiceId() {
		return tankWeirSluiceId;
	}


	public void setTankWeirSluiceId(Integer tankWeirSluiceId) {
		this.tankWeirSluiceId = tankWeirSluiceId;
	}


	public String getInpsectComplete() {
		return inpsectComplete;
	}


	public void setInpsectComplete(String inpsectComplete) {
		this.inpsectComplete = inpsectComplete;
	}


	public Integer getMiTankInspectId() {
		return miTankInspectId;
	}


	public void setMiTankInspectId(Integer miTankInspectId) {
		this.miTankInspectId = miTankInspectId;
	}


	public Integer getConstId() {
		return constId;
	}


	public void setConstId(Integer constId) {
		this.constId = constId;
	}


	private List<MiTankInspect>   miTankInspectList ;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





	


	public List<MiTankInspect> getMiTankInspectList() {
		return miTankInspectList;
	}


	public void setMiTankInspectList(List<MiTankInspect> miTankInspectList) {
		this.miTankInspectList = miTankInspectList;
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


	public Integer getMiTankFreqId() {
		return miTankFreqId;
	}


	public void setMiTankFreqId(Integer miTankFreqId) {
		this.miTankFreqId = miTankFreqId;
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


	public Long getTankId() {
		return tankId;
	}


	public void setTankId(Long tankId) {
		this.tankId = tankId;
	}


	public String getTankName() {
		return tankName;
	}


	public void setTankName(String tankName) {
		this.tankName = tankName;
	}


	public String getCircleName() {
		return circleName;
	}


	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}


	public String getUnitName() {
		return unitName;
	}


	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}


	public String getDivisionName() {
		return divisionName;
	}


	public double getWaterLevelInspect() {
		return waterLevelInspect;
	}


	public void setWaterLevelInspect(double waterLevelInspect) {
		this.waterLevelInspect = waterLevelInspect;
	}


	public double getCapacitymcft() {
		return capacitymcft;
	}


	public void setCapacitymcft(double capacitymcft) {
		this.capacitymcft = capacitymcft;
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


	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getActivityFrequency() {
		return activityFrequency;
	}


	public void setActivityFrequency(String activityFrequency) {
		this.activityFrequency = activityFrequency;
	}


	public Integer getPrefreq() {
		return prefreq;
	}


	public void setPrefreq(Integer prefreq) {
		this.prefreq = prefreq;
	}


	public Integer getPostfreq() {
		return postfreq;
	}


	public void setPostfreq(Integer postfreq) {
		this.postfreq = postfreq;
	}


	public Integer getDuringfreq() {
		return duringfreq;
	}


	public void setDuringfreq(Integer duringfreq) {
		this.duringfreq = duringfreq;
	}


	private Integer year;


	public Integer getNewDistrictId() {
		return newDistrictId;
	}


	public void setNewDistrictId(Integer newDistrictId) {
		this.newDistrictId = newDistrictId;
	}


	public String getDistrictName() {
		return districtName;
	}


	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}


	public Long getPreTankCount() {
		return preTankCount;
	}


	public void setPreTankCount(Long preTankCount) {
		this.preTankCount = preTankCount;
	}


	public Long getPostTankCount() {
		return postTankCount;
	}


	public void setPostTankCount(Long postTankCount) {
		this.postTankCount = postTankCount;
	}


	public Long getDuringTankCount() {
		return duringTankCount;
	}


	public void setDuringTankCount(Long duringTankCount) {
		this.duringTankCount = duringTankCount;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public Integer getMiInspectTypeId() {
		return miInspectTypeId;
	}


	public void setMiInspectTypeId(Integer miInspectTypeId) {
		this.miInspectTypeId = miInspectTypeId;
	}


	public Integer getMiInspectMapId() {
		return miInspectMapId;
	}


	public void setMiInspectMapId(Integer miInspectMapId) {
		this.miInspectMapId = miInspectMapId;
	}


	public Integer getMiCompId() {
		return miCompId;
	}


	public void setMiCompId(Integer miCompId) {
		this.miCompId = miCompId;
	}


	public Integer getMicheckboxId() {
		return micheckboxId;
	}


	public void setMicheckboxId(Integer micheckboxId) {
		this.micheckboxId = micheckboxId;
	}


	public String getInspectDate() {
		return inspectDate;
	}


	public void setInspectDate(String inspectDate) {
		this.inspectDate = inspectDate;
	}


	public Boolean getActionreq() {
		return actionreq;
	}


	public void setActionreq(Boolean actionreq) {
		this.actionreq = actionreq;
	}


	public Integer getActionrequireqId() {
		return actionrequireqId;
	}


	public void setActionrequireqId(Integer actionrequireqId) {
		this.actionrequireqId = actionrequireqId;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	

	public String getRepairRemarksDate() {
		return repairRemarksDate;
	}

	public void setRepairRemarksDate(String repairRemarksDate) {
		this.repairRemarksDate = repairRemarksDate;
	}

	public String getCapacityRemarksDate() {
		return capacityRemarksDate;
	}

	public void setCapacityRemarksDate(String capacityRemarksDate) {
		this.capacityRemarksDate = capacityRemarksDate;
	}


	public Integer getOffice() {
		return office;
	}

	public void setOffice(Integer office) {
		this.office = office;
	}


	@Override
	public String toString() {
		return "MiTankInspect [newDistrictId=" + newDistrictId + ", districtName=" + districtName + ", preTankCount="
				+ preTankCount + ", postTankCount=" + postTankCount + ", duringTankCount=" + duringTankCount
				+ ", prefreq=" + prefreq + ", postfreq=" + postfreq + ", duringfreq=" + duringfreq + ", miTankFreqId="
				+ miTankFreqId + ", unitId=" + unitId + ", circleId=" + circleId + ", divisionId=" + divisionId
				+ ", subdivisionId=" + subdivisionId + ", projectId=" + projectId + ", tankId=" + tankId + ", tankCode="
				+ tankCode + ", tankName=" + tankName + ", circleName=" + circleName + ", unitName=" + unitName
				+ ", divisionName=" + divisionName + ", subdivisionName=" + subdivisionName + ", activityFrequency="
				+ activityFrequency + ", mandalId=" + mandalId + ", villageId=" + villageId + ", mandalName="
				+ mandalName + ", villageName=" + villageName + ", waterLevelInspect=" + waterLevelInspect
				+ ", capacitymcft=" + capacitymcft + ", userId=" + userId + ", userName=" + userName
				+ ", miInspectTypeId=" + miInspectTypeId + ", miInspectMapId=" + miInspectMapId + ", miCompId="
				+ miCompId + ", micheckboxId=" + micheckboxId + ", inspectDate=" + inspectDate + ", actionreq="
				+ actionreq + ", actionrequireqId=" + actionrequireqId + ", remarks=" + remarks + ", constId=" + constId
				+ ", miTankInspectId=" + miTankInspectId + ", inpsectComplete=" + inpsectComplete
				+ ", tankWeirSluiceId=" + tankWeirSluiceId + ", tankInspectApproveId=" + tankInspectApproveId
				+ ", tankInspectApproveStatusId=" + tankInspectApproveStatusId + ", tankInspectApproveStatus="
				+ tankInspectApproveStatus + ", miInspectTypeName=" + miInspectTypeName + ", miCompName=" + miCompName
				+ ", miCompParentId=" + miCompParentId + ", miActionReqTypeName=" + miActionReqTypeName
				+ ", actionReqName=" + actionReqName + ", urlvalue=" + urlvalue + ", userEmpId=" + userEmpId
				+ ", designationId=" + designationId + ", repairDescription=" + repairDescription + ", rate=" + rate
				+ ", unitMeasureId=" + unitMeasureId + ", quantity=" + quantity + ", schemeTaken=" + schemeTaken
				+ ", amount=" + amount + ", miInpsectMst1Id=" + miInpsectMst1Id + ", miInpsectMst2Id=" + miInpsectMst2Id
				+ ", inflow=" + inflow + ", outfow=" + outfow + ", ayacut=" + ayacut + ", grossCapacity="
				+ grossCapacity + ", availableCapacity=" + availableCapacity + ", surplus=" + surplus + ", tabId="
				+ tabId + ", levelId=" + levelId + ", inflowoutflowId=" + inflowoutflowId + ", projectName="
				+ projectName + ", designation=" + designation + ", ommirepairId=" + ommirepairId + ", ommicapacityId="
				+ ommicapacityId + ", unitMeasureName=" + unitMeasureName + ", nextEmpId=" + nextEmpId
				+ ", nextEmpName=" + nextEmpName + ", canFeed=" + canFeed + ", chainLinkId=" + chainLinkId
				+ ", sourceTypeId=" + sourceTypeId + ", sourceCompTypeId=" + sourceCompTypeId + ", sourceCompId="
				+ sourceCompId + ", sourceDetails=" + sourceDetails + ", otLocationKm=" + otLocationKm + ", empId="
				+ empId + ", postId=" + postId + ", postName=" + postName + ", nextPostId=" + nextPostId
				+ ", nextDesignationId=" + nextDesignationId + ", chainLinkName=" + chainLinkName + ", sourceTypeName="
				+ sourceTypeName + ", sourceCompTypeName=" + sourceCompTypeName + ", sourceCompName=" + sourceCompName
				+ ", mitankFeedDetailsId=" + mitankFeedDetailsId + ", compCode=" + compCode + ", mitankFeedReviewId="
				+ mitankFeedReviewId + ", mitankCapacityId=" + mitankCapacityId + ", mitankCapacityReviewId="
				+ mitankCapacityReviewId + ", mitankRepairsId=" + mitankRepairsId + ", mitankRepairsReviewId="
				+ mitankRepairsReviewId + ", mitankInoutFlowId=" + mitankInoutFlowId + ", mitankInoutFlowReviewId="
				+ mitankInoutFlowReviewId + ", miInpsectMst1IdReviewId=" + miInpsectMst1IdReviewId + ", embRemarks="
				+ embRemarks + ", sluRemarks=" + sluRemarks + ", weirRemarks=" + weirRemarks + ", inspectDateRepair="
				+ inspectDateRepair + ", inspectDateCapacity=" + inspectDateCapacity + ", inspectDateFeed="
				+ inspectDateFeed + ", latestRemarks=" + latestRemarks + ", remarksDate=" + remarksDate
				+ ", repairRemarksDate=" + repairRemarksDate + ", capacityRemarksDate=" + capacityRemarksDate
				+ ", submittedTOEmp=" + submittedTOEmp + ", submittedBy=" + submittedBy + ", submittedToEmpName="
				+ submittedToEmpName + ", submittedByEmpName=" + submittedByEmpName + ", remarksSubmittedBy="
				+ remarksSubmittedBy + ", tankWeirSluiceName=" + tankWeirSluiceName + ", tankWeirSluiceTypeId="
				+ tankWeirSluiceTypeId + ", percentageCapacity=" + percentageCapacity + ", tankStatusId=" + tankStatusId
				+ ", tankStatus=" + tankStatus + ", totalCount=" + totalCount + ", office=" + office + ", abstracttype="
				+ abstracttype + ", repairStartDate=" + repairStartDate + ", repairEndDate=" + repairEndDate
				+ ", repairdescId=" + repairdescId + ", repairdescdata=" + repairdescdata + ", tankLevel=" + tankLevel
				+ ", grossAyacut=" + grossAyacut + ", sectionId=" + sectionId + ", sectionName=" + sectionName
				+ ", emergencyCount=" + emergencyCount + ", observeCount=" + observeCount + ", originalworkCount="
				+ originalworkCount + ", defferedCount=" + defferedCount + ", tankWeirSluiceTypeName="
				+ tankWeirSluiceTypeName + ", capacityRemarks=" + capacityRemarks + ", repairRemarks=" + repairRemarks
				+ ", feedRemarks=" + feedRemarks + ", miTankInspectList=" + miTankInspectList + ", year=" + year + "]";
	}


	

	

}
