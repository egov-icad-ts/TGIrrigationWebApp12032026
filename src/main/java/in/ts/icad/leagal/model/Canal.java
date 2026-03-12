package in.ts.icad.leagal.model;

import java.util.List;

public class Canal {

	private Integer canalId;
	private String canalName;
	private Integer canalLevelId;
	private String canalType;
	private Double offtakeChainage;
	private String canalDirection;
	private Double cubicCapacity;
	private Double canalLength;
	private String tailendStructure;
	private String structureType;
	private Integer projectId;
	private String parentCanal;
	private Integer parentId;
	private Integer parentLevelId;
	private String creationDate;
	private String lastUpdatedDate;
	private String createdByUser;
	private String lastUpdatedByUser;
	private Integer reservoirId;
	private CanalComponent component;
	// private Canal canal;
	private String progressString;
	private String remarks;
	private List<LineSegment> segments;
	private Integer structureTypeId;
	private String StructureType;
	private Integer canalPackageId;

	private Integer canalId0;

	private Integer canalId1;

	private Integer canalId2;

	private Integer canalId3;

	private Integer canalId4;

	private Integer canalId5;

	private Integer packageId;
	
	private Integer unitId;
	private Integer circleId;
	
	private Integer divisionId;
	
	private Integer subdivisionId;
	
	private Integer sectionId;
	
	private Long postId;
	
	private Integer canalTypeId;
	
	
	
	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	private String resName;
	
	private Double chainageFromkm;
	
	private Double chainageTokm;
	
	

	
	
	
	public Double getChainageFromkm() {
		return chainageFromkm;
	}

	public void setChainageFromkm(Double chainageFromkm) {
		this.chainageFromkm = chainageFromkm;
	}

	public Double getChainageTokm() {
		return chainageTokm;
	}

	public void setChainageTokm(Double chainageTokm) {
		this.chainageTokm = chainageTokm;
	}

	public Integer getCanalTypeId() {
		return canalTypeId;
	}

	public void setCanalTypeId(Integer canalTypeId) {
		this.canalTypeId = canalTypeId;
	}

	private Integer districtId;
	private Integer mandalId;
	
	private Integer  villageId;
	
	private String districtName;
	private String mandalName;
	
	private String villageName;
	
	private String remarksVillage;
	
	private Integer canalLocId;
	
	private String captcha;
	
	
	

	
	
	
	

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

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
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

	public String getRemarksVillage() {
		return remarksVillage;
	}

	public void setRemarksVillage(String remarksVillage) {
		this.remarksVillage = remarksVillage;
	}

	public Integer getCanalId0() {
		return canalId0;
	}

	public void setCanalId0(Integer canalId0) {
		this.canalId0 = canalId0;
	}

	public Integer getCanalId1() {
		return canalId1;
	}

	public void setCanalId1(Integer canalId1) {
		this.canalId1 = canalId1;
	}

	public Integer getCanalId2() {
		return canalId2;
	}

	public void setCanalId2(Integer canalId2) {
		this.canalId2 = canalId2;
	}

	public Integer getCanalId3() {
		return canalId3;
	}

	public void setCanalId3(Integer canalId3) {
		this.canalId3 = canalId3;
	}

	public Integer getCanalId4() {
		return canalId4;
	}

	public void setCanalId4(Integer canalId4) {
		this.canalId4 = canalId4;
	}

	public Integer getCanalId5() {
		return canalId5;
	}

	public void setCanalId5(Integer canalId5) {
		this.canalId5 = canalId5;
	}

	public Integer getStructureTypeId() {
		return structureTypeId;
	}

	public void setStructureTypeId(Integer structureTypeId) {
		this.structureTypeId = structureTypeId;
	}

	private User user;

	private String fromKm;
	private String toKm;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFromKm() {
		return fromKm;
	}

	public void setFromKm(String fromKm) {
		this.fromKm = fromKm;
	}

	public String getToKm() {
		return toKm;
	}

	public void setToKm(String toKm) {
		this.toKm = toKm;
	}

	public List<LineSegment> getSegments() {
		return segments;
	}

	public void setSegments(List<LineSegment> segments) {
		this.segments = segments;
	}

	public String getProgressString() {
		return progressString;
	}

	public void setProgressString(String progressString) {
		this.progressString = progressString;
	}

	/*
	 * public Canal getCanal() { return canal; }
	 * 
	 * public void setCanal(Canal canal) { this.canal = canal; }
	 */

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public CanalComponent getComponent() {
		return component;
	}

	public void setComponent(CanalComponent component) {
		this.component = component;
	}

	public Integer getReservoirId() {
		return reservoirId;
	}

	public void setReservoirId(Integer reservoirId) {
		this.reservoirId = reservoirId;
	}

	public Integer getCanalId() {
		return canalId;
	}

	public void setCanalId(Integer canalId) {
		this.canalId = canalId;
	}

	public String getCanalName() {
		return canalName;
	}

	public void setCanalName(String canalName) {
		this.canalName = canalName;
	}

	public Integer getCanalLevelId() {
		return canalLevelId;
	}

	public void setCanalLevelId(Integer canalLevelId) {
		this.canalLevelId = canalLevelId;
	}

	public String getCanalType() {
		return canalType;
	}

	public void setCanalType(String canalType) {
		this.canalType = canalType;
	}

	public Double getOfftakeChainage() {
		return offtakeChainage;
	}

	public void setOfftakeChainage(Double offtakeChainage) {
		this.offtakeChainage = offtakeChainage;
	}

	public String getCanalDirection() {
		return canalDirection;
	}

	public void setCanalDirection(String canalDirection) {
		this.canalDirection = canalDirection;
	}

	public Double getCubicCapacity() {
		return cubicCapacity;
	}

	public void setCubicCapacity(Double cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}

	public Double getCanalLength() {
		return canalLength;
	}

	public void setCanalLength(Double canalLength) {
		this.canalLength = canalLength;
	}

	public String getTailendStructure() {
		return tailendStructure;
	}

	public void setTailendStructure(String tailendStructure) {
		this.tailendStructure = tailendStructure;
	}

	public String getStructureType() {
		return structureType;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getParentCanal() {
		return parentCanal;
	}

	public void setParentCanal(String parentCanal) {
		this.parentCanal = parentCanal;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public String getLastUpdatedByUser() {
		return lastUpdatedByUser;
	}

	public void setLastUpdatedByUser(String lastUpdatedByUser) {
		this.lastUpdatedByUser = lastUpdatedByUser;
	}

	public Integer getParentLevelId() {
		return parentLevelId;
	}

	public void setParentLevelId(Integer parentLevelId) {
		this.parentLevelId = parentLevelId;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	
	public Integer getCanalPackageId() {
		return canalPackageId;
	}

	public void setCanalPackageId(Integer canalPackageId) {
		this.canalPackageId = canalPackageId;
	}

	@Override
	public String toString() {
		return "Canal [canalId=" + canalId + ", canalName=" + canalName + ", canalLevelId=" + canalLevelId
				+ ", canalType=" + canalType + ", offtakeChainage=" + offtakeChainage + ", canalDirection="
				+ canalDirection + ", cubicCapacity=" + cubicCapacity + ", canalLength=" + canalLength
				+ ", tailendStructure=" + tailendStructure + ", structureType=" + structureType + ", projectId="
				+ projectId + ", parentCanal=" + parentCanal + ", parentId=" + parentId + ", parentLevelId="
				+ parentLevelId + ", creationDate=" + creationDate + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", createdByUser=" + createdByUser + ", lastUpdatedByUser=" + lastUpdatedByUser + ", reservoirId="
				+ reservoirId + ", component=" + component + ", progressString=" + progressString + ", remarks="
				+ remarks + ", segments=" + segments + ", structureTypeId=" + structureTypeId + ", StructureType="
				+ StructureType + ", canalPackageId=" + canalPackageId + ", canalId0=" + canalId0 + ", canalId1="
				+ canalId1 + ", canalId2=" + canalId2 + ", canalId3=" + canalId3 + ", canalId4=" + canalId4
				+ ", canalId5=" + canalId5 + ", packageId=" + packageId + ", user=" + user + ", fromKm=" + fromKm
				+ ", toKm=" + toKm + "]";
	}

	

}
