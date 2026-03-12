package in.ts.icad.leagal.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Project {
	
private Integer projectId;
private String projectName;
private String projectCode;
private BigDecimal adminSanctionAmount;
private String goNo;
private Date goDate;
private String goDate1;
private String goFilePath;
private Integer noOfPackages;
private MultipartFile goFile;
private Integer pkgno;
private Integer projectAsId;
private String goType;
private Integer projectTypeId;
private Integer isEpc;

private Integer unitId;

private String unitName;

private String pkgCode;

private Double acres;
private Double guntas;
private String pkgName;

private Double reqAcres;

private Double reqGuntas;

private BigDecimal laSanctionAmount;



private String remarks;

private Integer circleId;

private String  circleName;

private Integer divisionId;

private String divisionName;

private Integer projParentId;

private Boolean deleteFlag;

private Boolean isEPC;

private String projOldName;

private Integer projOldId;

private Integer projStatusId;

private Integer projUnitId;

private Boolean isLatest;








public Boolean getIsLatest() {
	return isLatest;
}
public void setIsLatest(Boolean isLatest) {
	this.isLatest = isLatest;
}
public Integer getProjUnitId() {
	return projUnitId;
}
public void setProjUnitId(Integer projUnitId) {
	this.projUnitId = projUnitId;
}
public Integer getProjParentId() {
	return projParentId;
}
public void setProjParentId(Integer projParentId) {
	this.projParentId = projParentId;
}
public Boolean getDeleteFlag() {
	return deleteFlag;
}
public void setDeleteFlag(Boolean deleteFlag) {
	this.deleteFlag = deleteFlag;
}
public Boolean getIsEPC() {
	return isEPC;
}
public void setIsEPC(Boolean isEPC) {
	this.isEPC = isEPC;
}
public String getProjOldName() {
	return projOldName;
}
public void setProjOldName(String projOldName) {
	this.projOldName = projOldName;
}
public Integer getProjOldId() {
	return projOldId;
}
public void setProjOldId(Integer projOldId) {
	this.projOldId = projOldId;
}
public Integer getProjStatusId() {
	return projStatusId;
}
public void setProjStatusId(Integer projStatusId) {
	this.projStatusId = projStatusId;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public BigDecimal getLaSanctionAmount() {
	return laSanctionAmount;
}
public void setLaSanctionAmount(BigDecimal laSanctionAmount) {
	this.laSanctionAmount = laSanctionAmount;
}
public Double getReqAcres() {
	return reqAcres;
}
public void setReqAcres(Double reqAcres) {
	this.reqAcres = reqAcres;
}
public Double getReqGuntas() {
	return reqGuntas;
}
public void setReqGuntas(Double reqGuntas) {
	this.reqGuntas = reqGuntas;
}
public String getPkgName() {
	return pkgName;
}
public void setPkgName(String pkgName) {
	this.pkgName = pkgName;
}
public String getPkgCode() {
	return pkgCode;
}
public void setPkgCode(String pkgCode) {
	this.pkgCode = pkgCode;
}
public Double getAcres() {
	return acres;
}
public void setAcres(Double acres) {
	this.acres = acres;
}
public Double getGuntas() {
	return guntas;
}
public void setGuntas(Double guntas) {
	this.guntas = guntas;
}
public Integer getUnitId() {
	return unitId;
}
public void setUnitId(Integer unitId) {
	this.unitId = unitId;
}
public String getUnitName() {
	return unitName;
}
public void setUnitName(String unitName) {
	this.unitName = unitName;
}
public String getGoType() {
	return goType;
}
public void setGoType(String goType) {
	this.goType = goType;
}
public Integer getPkgno() {
	return pkgno;
}
public void setPkgno(Integer pkgno) {
	this.pkgno = pkgno;
}
public Integer getProjectId() {
	return projectId;
}
public void setProjectId(Integer projectId) {
	this.projectId = projectId;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getProjectCode() {
	return projectCode;
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
public void setProjectCode(String projectCode) {
	this.projectCode = projectCode;
}
public BigDecimal getAdminSanctionAmount() {
	return adminSanctionAmount;
}
public void setAdminSanctionAmount(BigDecimal adminSanctionAmount) {
	this.adminSanctionAmount = adminSanctionAmount;
}
public String getGoNo() {
	return goNo;
}
public void setGoNo(String goNo) {
	this.goNo = goNo;
}
public String getGoFilePath() {
	return goFilePath;
}
public void setGoFilePath(String goFilePath) {
	this.goFilePath = goFilePath;
}
public Integer getNoOfPackages() {
	return noOfPackages;
}
public void setNoOfPackages(Integer noOfPackages) {
	this.noOfPackages = noOfPackages;
}
public MultipartFile getGoFile() {
	return goFile;
}
public void setGoFile(MultipartFile goFile) {
	this.goFile = goFile;
}
public Date getGoDate() {
	return goDate;
}
public void setGoDate(Date goDate) {
	this.goDate = goDate;
}
public String getGoDate1() {
	return goDate1;
}
public void setGoDate1(String goDate1) {
	this.goDate1 = goDate1;
}
public Integer getProjectAsId() {
	return projectAsId;
}
public void setProjectAsId(Integer projectAsId) {
	this.projectAsId = projectAsId;
}
public Integer getProjectTypeId() {
	return projectTypeId;
}
public void setProjectTypeId(Integer projectTypeId) {
	this.projectTypeId = projectTypeId;
}
public Integer getIsEpc() {
	return isEpc;
}
public void setIsEpc(Integer isEpc) {
	this.isEpc = isEpc;
}

}
