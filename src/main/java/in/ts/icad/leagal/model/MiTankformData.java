package in.ts.icad.leagal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MiTankformData {
	
private String tsfcFormDate;
private Integer tsfcFormYear;
private Integer offAccess;

private String damageCause;
private String damageDate;
private Integer proposedId;
private String psoposedName;
private String damageTime;
private Double estmtValue;
private Double writeOffValue;
private String writeOffAction;

private Integer irrSrcId;
private String irrSrcName;
private Double regLeftChnnAcres;
private Double regRightChnnAcres;
private String rainRGStation;
private Double rainQty;
private String rainDate;
private String quartName;
private String quartType;

private String frmProposed;

private Integer frmchkboxId;

private Double  regOthAcres;

private Double frmBookValue;


private Double sumFrmBookValue;

private Double sumAprxCostPermt;

private Double sumAprxCostTemp;

private Double sumRepairsPermTemp;

private Integer totalTankCount;


private Integer apprv_status;

private Integer bldgTypeId;

private String bldgTypeName;

private String  bldgDescDamage;
private String damageBreaches;
private Double effAyacutAcres;
private Double effAyacutValue;

private Double approxRepTemp;
private Double approxRepPermanent;
private Double approxRepTotal;
private String actionStdCrops;
private String usefulRemarks;

private Integer formDataId;
private Integer formDetailId;
private Integer formDocId;
private Integer districtId;
private String districtName;
private Integer mandalId;
private String mandalName;
private Integer villageId;
private String villageName;
private Integer constituencyId;
private String constituencyName;

private Integer srcNo;

private String sourceName;

private Integer canalLocId;

private String captcha;

private String frmFromDate;

private String frmToDate;

private String formsentdatebyunit;

private String tsfcfrmFromDate;

private String tsfcfrmToDate;

private Integer tankCout;
private Integer resCount;
private Integer canalCount;

private String canalName;

private Integer repeatedTankId;

private String repeatedTankName;

private Integer repeatedCatId;

private Integer tankDamages;

private Integer tankBreaches;

private Integer resDamages;

private Integer resBreaches;

private Integer  canalDamages;

private Integer canalBreaches;

private Integer majorListDamages;

private Integer majorListBreaches;

private Integer  smallLiftDamages;

private Integer smallLiftBreaches;

private Integer  permanentCount;

private Double   permanentAmount;

private Integer  temporaryCount;


private Double   temporaryAmount ;

private Integer   restoredCount;

private Integer   underRestoredCount;

private String tankCode;

private Double ayacutAcres;

private Integer restored;

private String restoredStatus;

private String  srcname;

private Double breachLength;




































public String getSrcname() {
	return srcname;
}

public void setSrcname(String srcname) {
	this.srcname = srcname;
}

public Double getBreachLength() {
	return breachLength;
}

public void setBreachLength(Double breachLength) {
	this.breachLength = breachLength;
}

public Integer getRestored() {
	return restored;
}

public void setRestored(Integer restored) {
	this.restored = restored;
}

public String getRestoredStatus() {
	return restoredStatus;
}

public void setRestoredStatus(String restoredStatus) {
	this.restoredStatus = restoredStatus;
}

public Double getAyacutAcres() {
	return ayacutAcres;
}

public void setAyacutAcres(Double ayacutAcres) {
	this.ayacutAcres = ayacutAcres;
}

public String getTankCode() {
	return tankCode;
}

public void setTankCode(String tankCode) {
	this.tankCode = tankCode;
}

public Integer getRestoredCount() {
	return restoredCount;
}

public void setRestoredCount(Integer restoredCount) {
	this.restoredCount = restoredCount;
}

public Integer getUnderRestoredCount() {
	return underRestoredCount;
}

public void setUnderRestoredCount(Integer underRestoredCount) {
	this.underRestoredCount = underRestoredCount;
}

public Integer getPermanentCount() {
	return permanentCount;
}

public void setPermanentCount(Integer permanentCount) {
	this.permanentCount = permanentCount;
}

public Double getPermanentAmount() {
	return permanentAmount;
}

public void setPermanentAmount(Double permanentAmount) {
	this.permanentAmount = permanentAmount;
}

public Integer getTemporaryCount() {
	return temporaryCount;
}

public void setTemporaryCount(Integer temporaryCount) {
	this.temporaryCount = temporaryCount;
}

public Double getTemporaryAmount() {
	return temporaryAmount;
}

public void setTemporaryAmount(Double temporaryAmount) {
	this.temporaryAmount = temporaryAmount;
}

public Integer getTankDamages() {
	return tankDamages;
}

public void setTankDamages(Integer tankDamages) {
	this.tankDamages = tankDamages;
}

public Integer getTankBreaches() {
	return tankBreaches;
}

public void setTankBreaches(Integer tankBreaches) {
	this.tankBreaches = tankBreaches;
}

public Integer getResDamages() {
	return resDamages;
}

public void setResDamages(Integer resDamages) {
	this.resDamages = resDamages;
}

public Integer getResBreaches() {
	return resBreaches;
}

public void setResBreaches(Integer resBreaches) {
	this.resBreaches = resBreaches;
}

public Integer getCanalDamages() {
	return canalDamages;
}

public void setCanalDamages(Integer canalDamages) {
	this.canalDamages = canalDamages;
}

public Integer getCanalBreaches() {
	return canalBreaches;
}

public void setCanalBreaches(Integer canalBreaches) {
	this.canalBreaches = canalBreaches;
}

public Integer getMajorListDamages() {
	return majorListDamages;
}

public void setMajorListDamages(Integer majorListDamages) {
	this.majorListDamages = majorListDamages;
}

public Integer getMajorListBreaches() {
	return majorListBreaches;
}

public void setMajorListBreaches(Integer majorListBreaches) {
	this.majorListBreaches = majorListBreaches;
}

public Integer getSmallLiftDamages() {
	return smallLiftDamages;
}

public void setSmallLiftDamages(Integer smallLiftDamages) {
	this.smallLiftDamages = smallLiftDamages;
}

public Integer getSmallLiftBreaches() {
	return smallLiftBreaches;
}

public void setSmallLiftBreaches(Integer smallLiftBreaches) {
	this.smallLiftBreaches = smallLiftBreaches;
}

public Integer getRepeatedCatId() {
	return repeatedCatId;
}

public void setRepeatedCatId(Integer repeatedCatId) {
	this.repeatedCatId = repeatedCatId;
}

public String getRepeatedTankName() {
	return repeatedTankName;
}

public void setRepeatedTankName(String repeatedTankName) {
	this.repeatedTankName = repeatedTankName;
}

public Integer getRepeatedTankId() {
	return repeatedTankId;
}

public void setRepeatedTankId(Integer repeatedTankId) {
	this.repeatedTankId = repeatedTankId;
}

public String getTsfcfrmFromDate() {
	return tsfcfrmFromDate;
}

public void setTsfcfrmFromDate(String tsfcfrmFromDate) {
	this.tsfcfrmFromDate = tsfcfrmFromDate;
}

public String getTsfcfrmToDate() {
	return tsfcfrmToDate;
}

public void setTsfcfrmToDate(String tsfcfrmToDate) {
	this.tsfcfrmToDate = tsfcfrmToDate;
}

public Integer getTankCout() {
	return tankCout;
}

public void setTankCout(Integer tankCout) {
	this.tankCout = tankCout;
}

public Integer getResCount() {
	return resCount;
}

public void setResCount(Integer resCount) {
	this.resCount = resCount;
}

public Integer getCanalCount() {
	return canalCount;
}

public void setCanalCount(Integer canalCount) {
	this.canalCount = canalCount;
}

public String getCanalName() {
	return canalName;
}

public void setCanalName(String canalName) {
	this.canalName = canalName;
}

public String getFormsentdatebyunit() {
	return formsentdatebyunit;
}

public void setFormsentdatebyunit(String formsentdatebyunit) {
	this.formsentdatebyunit = formsentdatebyunit;
}

public String getFrmFromDate() {
	return frmFromDate;
}

public void setFrmFromDate(String frmFromDate) {
	this.frmFromDate = frmFromDate;
}

public String getFrmToDate() {
	return frmToDate;
}

public void setFrmToDate(String frmToDate) {
	this.frmToDate = frmToDate;
}

public String getCaptcha() {
	return captcha;
}

public void setCaptcha(String captcha) {
	this.captcha = captcha;
}

public Integer getCanalLocId() {
	return canalLocId;
}

public void setCanalLocId(Integer canalLocId) {
	this.canalLocId = canalLocId;
}

public String getSourceName() {
	return sourceName;
}

public void setSourceName(String sourceName) {
	this.sourceName = sourceName;
}

public Integer getSrcNo() {
	return srcNo;
}

public void setSrcNo(Integer srcNo) {
	this.srcNo = srcNo;
}
private Integer unitId;
private Integer userUnitId;

public Integer getResId() {
	return resId;
}

public void setResId(Integer resId) {
	this.resId = resId;
}

public Integer getCanId() {
	return canId;
}

public void setCanId(Integer canId) {
	this.canId = canId;
}

public Integer getCatId() {
	return catId;
}

public void setCatId(Integer catId) {
	this.catId = catId;
}

public String getResName() {
	return resName;
}

public void setResName(String resName) {
	this.resName = resName;
}

public String getCanName() {
	return canName;
}

public void setCanName(String canName) {
	this.canName = canName;
}

public String getCatName() {
	return catName;
}

public void setCatName(String catName) {
	this.catName = catName;
}
private String unitName;
private Integer circleId;

private String circleName;

private Integer divisionId;
private String divisionName;
private Integer subDivisionId;
private String subDivisionName;

private Integer sectionId;
private String sectionName;

private Integer designationId;
private Integer userDesignationId;
private Integer listDesignationId;

private Integer backdesignationId;

private Long postId;
private String postName;
private Long nextPostId;

private Long empId;

private Long nextEmpId;

private Integer tankId;
private String tankName;

private String userName;

private Double irrChFrm;
private Double irrChTo;
private Double  irrLBD;
private Double irrL;
private Double irrB;
private Double irrD;
private Double irrTempcost;
private Double irrPermcost;
private Double irrbookValue;

private Integer tabId;

private Integer levelId;

private String createDate;
private Long tankGeoId;

private List<MultipartFile> uploadPhotos;

private List<MiTankFormDocs> photosList;

private List<MiTankformData>   miTankformDataList ;


private String sumApxCtPermt;

private String sumAxCtTemp;

private String sumRepsPermTemp;

private String sumFmBkValue;


private Integer damageType;

private String damageTypeName;

private Integer damageCount;

private Integer breachCount;

private String irrStrDmaPort;


private Integer resId;

private Integer canId;

private Integer catId;


private String resName;

private String canName;

private String catName;

private Integer projectId;


















public Integer getProjectId() {
	return projectId;
}

public void setProjectId(Integer projectId) {
	this.projectId = projectId;
}

public String getIrrStrDmaPort() {
	return irrStrDmaPort;
}

public void setIrrStrDmaPort(String irrStrDmaPort) {
	this.irrStrDmaPort = irrStrDmaPort;
}

public Integer getDamageCount() {
	return damageCount;
}

public void setDamageCount(Integer damageCount) {
	this.damageCount = damageCount;
}

public Integer getBreachCount() {
	return breachCount;
}

public void setBreachCount(Integer breachCount) {
	this.breachCount = breachCount;
}

public Integer getDamageType() {
	return damageType;
}

public void setDamageType(Integer damageType) {
	this.damageType = damageType;
}



public String getDamageTypeName() {
	return damageTypeName;
}

public void setDamageTypeName(String damageTypeName) {
	this.damageTypeName = damageTypeName;
}








public String getSumFmBkValue() {
	return sumFmBkValue;
}
public void setSumFmBkValue(String sumFmBkValue) {
	this.sumFmBkValue = sumFmBkValue;
}
public String getSumApxCtPermt() {
	return sumApxCtPermt;
}
public void setSumApxCtPermt(String sumApxCtPermt) {
	this.sumApxCtPermt = sumApxCtPermt;
}
public String getSumAxCtTemp() {
	return sumAxCtTemp;
}
public void setSumAxCtTemp(String sumAxCtTemp) {
	this.sumAxCtTemp = sumAxCtTemp;
}
public String getSumRepsPermTemp() {
	return sumRepsPermTemp;
}
public void setSumRepsPermTemp(String sumRepsPermTemp) {
	this.sumRepsPermTemp = sumRepsPermTemp;
}
public Integer getApprv_status() {
	return apprv_status;
}
public void setApprv_status(Integer apprv_status) {
	this.apprv_status = apprv_status;
}
public void setSumFrmBookValue(Double sumFrmBookValue) {
	this.sumFrmBookValue = sumFrmBookValue;
}
public Double getFrmBookValue() {
	return frmBookValue;
}
public void setFrmBookValue(Double frmBookValue) {
	this.frmBookValue = frmBookValue;
}
public Double getRegOthAcres() {
	return regOthAcres;
}
public void setRegOthAcres(Double regOthAcres) {
	this.regOthAcres = regOthAcres;
}
public Integer getFrmchkboxId() {
	return frmchkboxId;
}
public void setFrmchkboxId(Integer frmchkboxId) {
	this.frmchkboxId = frmchkboxId;
}
public String getFrmProposed() {
	return frmProposed;
}
public void setFrmProposed(String frmProposed) {
	this.frmProposed = frmProposed;
}

public List<MiTankFormDocs> getPhotosList() {
	return photosList;
}
public void setPhotosList(List<MiTankFormDocs> photosList) {
	this.photosList = photosList;
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
public Double getIrrLBD() {
	return irrLBD;
}
public void setIrrLBD(Double irrLBD) {
	this.irrLBD = irrLBD;
}
public Double getIrrL() {
	return irrL;
}
public void setIrrL(Double irrL) {
	this.irrL = irrL;
}
public Double getIrrB() {
	return irrB;
}
public void setIrrB(Double irrB) {
	this.irrB = irrB;
}
public Double getIrrD() {
	return irrD;
}
public void setIrrD(Double irrD) {
	this.irrD = irrD;
}
public Double getIrrTempcost() {
	return irrTempcost;
}
public void setIrrTempcost(Double irrTempcost) {
	this.irrTempcost = irrTempcost;
}
public Double getIrrPermcost() {
	return irrPermcost;
}
public void setIrrPermcost(Double irrPermcost) {
	this.irrPermcost = irrPermcost;
}
public Double getIrrbookValue() {
	return irrbookValue;
}
public void setIrrbookValue(Double irrbookValue) {
	this.irrbookValue = irrbookValue;
}


public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
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
public List<MiTankformData> getMiTankformDataList() {
	return miTankformDataList;
}
public void setMiTankformDataList(List<MiTankformData> miTankformDataList) {
	this.miTankformDataList = miTankformDataList;
}
public Integer getTankId() {
	return tankId;
}
public void setTankId(Integer tankId) {
	this.tankId = tankId;
}
public String getTankName() {
	return tankName;
}
public void setTankName(String tankName) {
	this.tankName = tankName;
}
public Integer getUnitId() {
	return unitId;
}
public void setUnitId(Integer unitId) {
	this.unitId = unitId;
}
public Integer getDistrictId() {
	return districtId;
}
public void setDistrictId(Integer districtId) {
	this.districtId = districtId;
}
public String getDistrictName() {
	return districtName;
}
public void setDistrictName(String districtName) {
	this.districtName = districtName;
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
public Integer getConstituencyId() {
	return constituencyId;
}
public void setConstituencyId(Integer constituencyId) {
	this.constituencyId = constituencyId;
}
public String getConstituencyName() {
	return constituencyName;
}
public void setConstituencyName(String constituencyName) {
	this.constituencyName = constituencyName;
}
public Integer getUserUnitId() {
	return userUnitId;
}
public void setUserUnitId(Integer userUnitId) {
	this.userUnitId = userUnitId;
}
public String getUnitName() {
	return unitName;
}
public void setUnitName(String unitName) {
	this.unitName = unitName;
}

public Integer getCircleId() {
	return circleId;
}
public void setCircleId(Integer circleId) {
	this.circleId = circleId;
}
public String getCircleName() {
	return circleName;
}
public void setCircleName(String circleName) {
	this.circleName = circleName;
}
public Integer getDivisionId() {
	return divisionId;
}
public void setDivisionId(Integer divisionId) {
	this.divisionId = divisionId;
}
public String getDivisionName() {
	return divisionName;
}
public void setDivisionName(String divisionName) {
	this.divisionName = divisionName;
}
public Integer getSubDivisionId() {
	return subDivisionId;
}
public void setSubDivisionId(Integer subDivisionId) {
	this.subDivisionId = subDivisionId;
}
public String getSubDivisionName() {
	return subDivisionName;
}
public void setSubDivisionName(String subDivisionName) {
	this.subDivisionName = subDivisionName;
}
public Integer getDesignationId() {
	return designationId;
}
public void setDesignationId(Integer designationId) {
	this.designationId = designationId;
}
public Integer getListDesignationId() {
	return listDesignationId;
}
public void setListDesignationId(Integer listDesignationId) {
	this.listDesignationId = listDesignationId;
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
public Long getEmpId() {
	return empId;
}
public void setEmpId(Long empId) {
	this.empId = empId;
}
public Long getNextEmpId() {
	return nextEmpId;
}
public void setNextEmpId(Long nextEmpId) {
	this.nextEmpId = nextEmpId;
}
public Integer getFormDataId() {
	return formDataId;
}
public void setFormDataId(Integer formDataId) {
	this.formDataId = formDataId;
}
public Integer getFormDetailId() {
	return formDetailId;
}
public void setFormDetailId(Integer formDetailId) {
	this.formDetailId = formDetailId;
}
public Integer getFormDocId() {
	return formDocId;
}
public void setFormDocId(Integer formDocId) {
	this.formDocId = formDocId;
}
public String getTsfcFormDate() {
	return tsfcFormDate;
}
public void setTsfcFormDate(String tsfcFormDate) {
	this.tsfcFormDate = tsfcFormDate;
}
public String getDamageCause() {
	return damageCause;
}
public void setDamageCause(String damageCause) {
	this.damageCause = damageCause;
}
public String getDamageDate() {
	return damageDate;
}
public void setDamageDate(String damageDate) {
	this.damageDate = damageDate;
}
public Integer getProposedId() {
	return proposedId;
}
public void setProposedId(Integer proposedId) {
	this.proposedId = proposedId;
}
public String getPsoposedName() {
	return psoposedName;
}
public void setPsoposedName(String psoposedName) {
	this.psoposedName = psoposedName;
}
public String getDamageTime() {
	return damageTime;
}
public void setDamageTime(String damageTime) {
	this.damageTime = damageTime;
}
public Double getEstmtValue() {
	return estmtValue;
}
public void setEstmtValue(Double estmtValue) {
	this.estmtValue = estmtValue;
}
public Double getWriteOffValue() {
	return writeOffValue;
}
public void setWriteOffValue(Double writeOffValue) {
	this.writeOffValue = writeOffValue;
}
public String getWriteOffAction() {
	return writeOffAction;
}
public void setWriteOffAction(String writeOffAction) {
	this.writeOffAction = writeOffAction;
}
public Integer getIrrSrcId() {
	return irrSrcId;
}
public void setIrrSrcId(Integer irrSrcId) {
	this.irrSrcId = irrSrcId;
}
public String getIrrSrcName() {
	return irrSrcName;
}
public void setIrrSrcName(String irrSrcName) {
	this.irrSrcName = irrSrcName;
}
public Double getRegLeftChnnAcres() {
	return regLeftChnnAcres;
}
public void setRegLeftChnnAcres(Double regLeftChnnAcres) {
	this.regLeftChnnAcres = regLeftChnnAcres;
}
public Double getRegRightChnnAcres() {
	return regRightChnnAcres;
}
public void setRegRightChnnAcres(Double regRightChnnAcres) {
	this.regRightChnnAcres = regRightChnnAcres;
}
public String getRainRGStation() {
	return rainRGStation;
}
public void setRainRGStation(String rainRGStation) {
	this.rainRGStation = rainRGStation;
}
public Double getRainQty() {
	return rainQty;
}
public void setRainQty(Double rainQty) {
	this.rainQty = rainQty;
}
public String getRainDate() {
	return rainDate;
}
public void setRainDate(String rainDate) {
	this.rainDate = rainDate;
}
public String getQuartName() {
	return quartName;
}
public void setQuartName(String quartName) {
	this.quartName = quartName;
}
public String getQuartType() {
	return quartType;
}
public void setQuartType(String quartType) {
	this.quartType = quartType;
}
public Integer getBldgTypeId() {
	return bldgTypeId;
}
public void setBldgTypeId(Integer bldgTypeId) {
	this.bldgTypeId = bldgTypeId;
}
public String getBldgTypeName() {
	
	return bldgTypeName;
}
public void setBldgTypeName(String bldgTypeName) {
	this.bldgTypeName = bldgTypeName;
}
public String getBldgDescDamage() {
	return bldgDescDamage;
}
public void setBldgDescDamage(String bldgDescDamage) {
	this.bldgDescDamage = bldgDescDamage;
}

public String getDamageBreaches() {
	return damageBreaches;
}
public void setDamageBreaches(String damageBreaches) {
	this.damageBreaches = damageBreaches;
}
public Double getEffAyacutAcres() {
	return effAyacutAcres;
}
public void setEffAyacutAcres(Double effAyacutAcres) {
	this.effAyacutAcres = effAyacutAcres;
}
public Double getEffAyacutValue() {
	return effAyacutValue;
}
public void setEffAyacutValue(Double effAyacutValue) {
	this.effAyacutValue = effAyacutValue;
}
public Double getApproxRepTemp() {
	return approxRepTemp;
}
public void setApproxRepTemp(Double approxRepTemp) {
	this.approxRepTemp = approxRepTemp;
}
public Double getApproxRepPermanent() {
	return approxRepPermanent;
}
public void setApproxRepPermanent(Double approxRepPermanent) {
	this.approxRepPermanent = approxRepPermanent;
}
public Double getApproxRepTotal() {
	return approxRepTotal;
}
public void setApproxRepTotal(Double approxRepTotal) {
	this.approxRepTotal = approxRepTotal;
}
public String getActionStdCrops() {
	return actionStdCrops;
}
public void setActionStdCrops(String actionStdCrops) {
	this.actionStdCrops = actionStdCrops;
}
public String getUsefulRemarks() {
	return usefulRemarks;
}
public void setUsefulRemarks(String usefulRemarks) {
	this.usefulRemarks = usefulRemarks;
}
public Integer getTsfcFormYear() {
	return tsfcFormYear;
}
public void setTsfcFormYear(Integer tsfcFormYear) {
	this.tsfcFormYear = tsfcFormYear;
}
public Integer getOffAccess() {
	return offAccess;
}
public void setOffAccess(Integer offAccess) {
	this.offAccess = offAccess;
}
public String getPostName() {
	return postName;
}
public void setPostName(String postName) {
	this.postName = postName;
}
public Double getSumFrmBookValue() {
	return sumFrmBookValue;
}
public void setSumfrmBookValue(Double sumfrmBookValue) {
	sumFrmBookValue = sumfrmBookValue;
}
public Double getSumAprxCostPermt() {
	return sumAprxCostPermt;
}
public void setSumAprxCostPermt(Double sumAprxCostPermt) {
	this.sumAprxCostPermt = sumAprxCostPermt;
}
public Double getSumAprxCostTemp() {
	return sumAprxCostTemp;
}
public void setSumAprxCostTemp(Double sumAprxCostTemp) {
	this.sumAprxCostTemp = sumAprxCostTemp;
}
public Double getSumRepairsPermTemp() {
	return sumRepairsPermTemp;
}
public void setSumRepairsPermTemp(Double sumRepairsPermTemp) {
	this.sumRepairsPermTemp = sumRepairsPermTemp;
}
public Integer getSectionId() {
	return sectionId;
}
public void setSectionId(Integer sectionId) {
	this.sectionId = sectionId;
}
public String getSectionName() {
	return sectionName;
}
public void setSectionName(String sectionName) {
	this.sectionName = sectionName;
}
public Integer getTotalTankCount() {
	return totalTankCount;
}
public void setTotalTankCount(Integer totalTankCount) {
	this.totalTankCount = totalTankCount;
}
public Integer getUserDesignationId() {
	return userDesignationId;
}
public void setUserDesignationId(Integer userDesignationId) {
	this.userDesignationId = userDesignationId;
}
public Integer getBackdesignationId() {
	return backdesignationId;
}
public void setBackdesignationId(Integer backdesignationId) {
	this.backdesignationId = backdesignationId;
}

public List<MultipartFile> getUploadPhotos() {
	return uploadPhotos;
}
public void setUploadPhotos(List<MultipartFile> uploadPhotos) {
	this.uploadPhotos = uploadPhotos;

}


public String getCreateDate() {
	return createDate;
}
public void setCreateDate(String createDate) {
	this.createDate = createDate;
}
public Long getTankGeoId() {
	return tankGeoId;
}
public void setTankGeoId(Long tankGeoId) {
	this.tankGeoId = tankGeoId;
}
@Override
public String toString() {
	return "MiTankformData [tsfcFormDate=" + tsfcFormDate + ", tsfcFormYear=" + tsfcFormYear + ", offAccess="
			+ offAccess + ", damageCause=" + damageCause + ", damageDate=" + damageDate + ", proposedId=" + proposedId
			+ ", psoposedName=" + psoposedName + ", damageTime=" + damageTime + ", estmtValue=" + estmtValue
			+ ", writeOffValue=" + writeOffValue + ", writeOffAction=" + writeOffAction + ", irrSrcId=" + irrSrcId
			+ ", irrSrcName=" + irrSrcName + ", regLeftChnnAcres=" + regLeftChnnAcres + ", regRightChnnAcres="
			+ regRightChnnAcres + ", rainRGStation=" + rainRGStation + ", rainQty=" + rainQty + ", rainDate=" + rainDate
			+ ", quartName=" + quartName + ", quartType=" + quartType + ", frmProposed=" + frmProposed
			+ ", frmchkboxId=" + frmchkboxId + ", regOthAcres=" + regOthAcres + ", frmBookValue=" + frmBookValue
			+ ", sumFrmBookValue=" + sumFrmBookValue + ", sumAprxCostPermt=" + sumAprxCostPermt + ", sumAprxCostTemp="
			+ sumAprxCostTemp + ", sumRepairsPermTemp=" + sumRepairsPermTemp + ", totalTankCount=" + totalTankCount
			+ ", apprv_status=" + apprv_status + ", bldgTypeId=" + bldgTypeId + ", bldgTypeName=" + bldgTypeName
			+ ", bldgDescDamage=" + bldgDescDamage + ", damageBreaches=" + damageBreaches + ", effAyacutAcres="
			+ effAyacutAcres + ", effAyacutValue=" + effAyacutValue + ", approxRepTemp=" + approxRepTemp
			+ ", approxRepPermanent=" + approxRepPermanent + ", approxRepTotal=" + approxRepTotal + ", actionStdCrops="
			+ actionStdCrops + ", usefulRemarks=" + usefulRemarks + ", formDataId=" + formDataId + ", formDetailId="
			+ formDetailId + ", formDocId=" + formDocId + ", districtId=" + districtId + ", districtName="
			+ districtName + ", mandalId=" + mandalId + ", mandalName=" + mandalName + ", villageId=" + villageId
			+ ", villageName=" + villageName + ", constituencyId=" + constituencyId + ", constituencyName="
			+ constituencyName + ", srcNo=" + srcNo + ", sourceName=" + sourceName + ", canalLocId=" + canalLocId
			+ ", captcha=" + captcha + ", frmFromDate=" + frmFromDate + ", frmToDate=" + frmToDate + ", unitId="
			+ unitId + ", userUnitId=" + userUnitId + ", unitName=" + unitName + ", circleId=" + circleId
			+ ", circleName=" + circleName + ", divisionId=" + divisionId + ", divisionName=" + divisionName
			+ ", subDivisionId=" + subDivisionId + ", subDivisionName=" + subDivisionName + ", sectionId=" + sectionId
			+ ", sectionName=" + sectionName + ", designationId=" + designationId + ", userDesignationId="
			+ userDesignationId + ", listDesignationId=" + listDesignationId + ", backdesignationId="
			+ backdesignationId + ", postId=" + postId + ", postName=" + postName + ", nextPostId=" + nextPostId
			+ ", empId=" + empId + ", nextEmpId=" + nextEmpId + ", tankId=" + tankId + ", tankName=" + tankName
			+ ", userName=" + userName + ", irrChFrm=" + irrChFrm + ", irrChTo=" + irrChTo + ", irrLBD=" + irrLBD
			+ ", irrL=" + irrL + ", irrB=" + irrB + ", irrD=" + irrD + ", irrTempcost=" + irrTempcost + ", irrPermcost="
			+ irrPermcost + ", irrbookValue=" + irrbookValue + ", tabId=" + tabId + ", levelId=" + levelId
			+ ", createDate=" + createDate + ", tankGeoId=" + tankGeoId + ", uploadPhotos=" + uploadPhotos
			+ ", photosList=" + photosList + ", miTankformDataList=" + miTankformDataList + ", sumApxCtPermt="
			+ sumApxCtPermt + ", sumAxCtTemp=" + sumAxCtTemp + ", sumRepsPermTemp=" + sumRepsPermTemp
			+ ", sumFmBkValue=" + sumFmBkValue + ", damageType=" + damageType + ", damageTypeName=" + damageTypeName
			+ ", damageCount=" + damageCount + ", breachCount=" + breachCount + ", irrStrDmaPort=" + irrStrDmaPort
			+ ", resId=" + resId + ", canId=" + canId + ", catId=" + catId + ", resName=" + resName + ", canName="
			+ canName + ", catName=" + catName + ", projectId=" + projectId + "]";
}






}
