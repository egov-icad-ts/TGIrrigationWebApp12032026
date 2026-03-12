package in.ts.icad.leagal.model;

import java.util.Date;

public class Packages {
private Integer pkgId;
private Integer projectId;
private Integer unitId;

private Integer userId;
private String userName;

private String packageCode;



private String createDate;


private Double agmtValue;

private Boolean isProforma;

private Long postId;


public Boolean getIsLatest() {
	return isLatest;
}
public void setIsLatest(Boolean isLatest) {
	this.isLatest = isLatest;
}
public Long getPostId() {
	return postId;
}
public void setPostId(Long postId) {
	this.postId = postId;
}
public String getPackageCode() {
	return packageCode;
}
public void setPackageCode(String packageCode) {
	this.packageCode = packageCode;
}
public String getCreateDate() {
	return createDate;
}
public void setCreateDate(String createDate) {
	this.createDate = createDate;
}
public Double getAgmtValue() {
	return agmtValue;
}
public void setAgmtValue(Double agmtValue) {
	this.agmtValue = agmtValue;
}
public Boolean getIsProforma() {
	return isProforma;
}
public void setIsProforma(Boolean isProforma) {
	this.isProforma = isProforma;
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
public Integer getUnitId() {
	return unitId;
}
public void setUnitId(Integer unitId) {
	this.unitId = unitId;
}
public Integer getPkgId() {
	return pkgId;
}
public Integer getCircleId() {
	return circleId;
}
public Integer getDivisionId() {
	return divisionId;
}
public Integer getProjectId() {
	return projectId;
}
private Integer circleId;
private Integer divisionId;
private Integer subdivisionId;
public Integer getSubdivisionId() {
	return subdivisionId;
}
public void setSubdivisionId(Integer subdivisionId) {
	this.subdivisionId = subdivisionId;
}
public void setPkgId(Integer pkgId) {
	this.pkgId = pkgId;
}
public void setProjectId(Integer projectId) {
	this.projectId = projectId;
}
public void setCircleId(Integer circleId) {
	this.circleId = circleId;
}
public void setDivisionId(Integer divisionId) {
	this.divisionId = divisionId;
}
private String pkgName;
private String pkgCode;
private String createdBy;
private Date createdDate;
private Boolean deleteFlag;
private String projectCode;
private Boolean isLatest;
private Integer ceWorkAssignId;
private String circleName;
private String projectName;
private String divisionName;
private String hoa;
private Date toDate;
private Double extent;
private Integer  selectedProjId;



public Boolean isLatest() {
	return isLatest;
}
public void setLatest(Boolean isLatest) {
	this.isLatest = isLatest;
}

public Integer getSelectedProjId() {
	return selectedProjId;
}
public void setSelectedProjId(Integer selectedProjId) {
	this.selectedProjId = selectedProjId;
}
public Double getExtent() {
	return extent;
}
public void setExtent(Double extent) {
	this.extent = extent;
}
public String getDivisionName() {
	return divisionName;
}
public void setDivisionName(String divisionName) {
	this.divisionName = divisionName;
}

public Date getToDate() {
	return toDate;
}
public void setToDate(Date toDate) {
	this.toDate = toDate;
}
public String getHoa() {
	return hoa;
}
public void setHoa(String hoa) {
	this.hoa = hoa;
}

public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public Integer getCeWorkAssignId() {
	return ceWorkAssignId;
}
public void setCeWorkAssignId(Integer ceWorkAssignId) {
	this.ceWorkAssignId = ceWorkAssignId;
}
public String getProjectCode() {
	return projectCode;
}
public void setProjectCode(String projectCode) {
	this.projectCode = projectCode;
}


public String getPkgName() {
	return pkgName;
}
public String getPkgCode() {
	return pkgCode;
}
public String getCreatedBy() {
	return createdBy;
}
public Date getCreatedDate() {
	return createdDate;
}


public void setPkgName(String pkgName) {
	this.pkgName = pkgName;
}
public void setPkgCode(String pkgCode) {
	this.pkgCode = pkgCode;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}

public String getCircleName() {
	return circleName;
}
public void setCircleName(String circleName) {
	this.circleName = circleName;
}
public Boolean getDeleteFlag() {
	return deleteFlag;
}
public void setDeleteFlag(Boolean deleteFlag) {
	this.deleteFlag = deleteFlag;
}

}
