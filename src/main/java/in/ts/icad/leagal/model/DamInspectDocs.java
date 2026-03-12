package in.ts.icad.leagal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class DamInspectDocs {
	
	
		private Integer damdocId;
		private String damDocName;
		private String  damDocLocation;
		private String damDocOriginalName;

		private Integer  userId;
		private Integer damDataId;
		

		private String userName;
		
		private Integer updateduserId;
		private String updateduserName;
		
		private Integer unitId;
		private String unitName;
		
		private Integer olddamdocId;
		
		private String sourceName;
		
		private String damTitle;
		
		private Integer resInspectMst1Id; 
		
		private Integer inspectOfficeInfoId;
		
		private String docTitle;
		
		private Integer annexureId;
		
		private Integer tankId;
		
		private Integer reservoirId;
		
		private Integer resinspectInfoId;
		
		private Long postId;
		
		
		
		

		
		public Integer getAnnexureId() {
			return annexureId;
		}




		public void setAnnexureId(Integer annexureId) {
			this.annexureId = annexureId;
		}




		public Integer getTankId() {
			return tankId;
		}




		public void setTankId(Integer tankId) {
			this.tankId = tankId;
		}




		public Integer getReservoirId() {
			return reservoirId;
		}




		public void setReservoirId(Integer reservoirId) {
			this.reservoirId = reservoirId;
		}




		public Integer getResinspectInfoId() {
			return resinspectInfoId;
		}




		public void setResinspectInfoId(Integer resinspectInfoId) {
			this.resinspectInfoId = resinspectInfoId;
		}




		public Long getPostId() {
			return postId;
		}




		public void setPostId(Long postId) {
			this.postId = postId;
		}




		private Boolean isLatest;
		
		private String inspectOfficeName;
		
		
		
		


		public String getInspectOfficeName() {
			return inspectOfficeName;
		}




		public void setInspectOfficeName(String inspectOfficeName) {
			this.inspectOfficeName = inspectOfficeName;
		}




		public Boolean getIsLatest() {
			return isLatest;
		}




		public void setIsLatest(Boolean isLatest) {
			this.isLatest = isLatest;
		}




		public String getDocTitle() {
			return docTitle;
		}




		public void setDocTitle(String docTitle) {
			this.docTitle = docTitle;
		}




		public Integer getResInspectMst1Id() {
			return resInspectMst1Id;
		}




		public void setResInspectMst1Id(Integer resInspectMst1Id) {
			this.resInspectMst1Id = resInspectMst1Id;
		}




		public Integer getInspectOfficeInfoId() {
			return inspectOfficeInfoId;
		}




		public void setInspectOfficeInfoId(Integer inspectOfficeInfoId) {
			this.inspectOfficeInfoId = inspectOfficeInfoId;
		}




		public String getDamTitle() {
			return damTitle;
		}




		public void setDamTitle(String damTitle) {
			this.damTitle = damTitle;
		}




		public String getSourceName() {
			return sourceName;
		}




		public void setSourceName(String sourceName) {
			this.sourceName = sourceName;
		}




		private List<MultipartFile> damPhotos;

		

		
	


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




		public Integer getUpdateduserId() {
			return updateduserId;
		}




		public void setUpdateduserId(Integer updateduserId) {
			this.updateduserId = updateduserId;
		}




		public String getUpdateduserName() {
			return updateduserName;
		}




		public void setUpdateduserName(String updateduserName) {
			this.updateduserName = updateduserName;
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




		public Integer getDamdocId() {
			return damdocId;
		}




		public void setDamdocId(Integer damdocId) {
			this.damdocId = damdocId;
		}




		public String getDamDocName() {
			return damDocName;
		}




		public void setDamDocName(String damDocName) {
			this.damDocName = damDocName;
		}




		public String getDamDocLocation() {
			return damDocLocation;
		}




		public void setDamDocLocation(String damDocLocation) {
			this.damDocLocation = damDocLocation;
		}




		public String getDamDocOriginalName() {
			return damDocOriginalName;
		}




		public void setDamDocOriginalName(String damDocOriginalName) {
			this.damDocOriginalName = damDocOriginalName;
		}




		public Integer getDamDataId() {
			return damDataId;
		}




		public void setDamDataId(Integer damDataId) {
			this.damDataId = damDataId;
		}




		public Integer getOlddamdocId() {
			return olddamdocId;
		}




		public void setOlddamdocId(Integer olddamdocId) {
			this.olddamdocId = olddamdocId;
		}




		public List<MultipartFile> getDamPhotos() {
			return damPhotos;
		}




		public void setDamPhotos(List<MultipartFile> damPhotos) {
			this.damPhotos = damPhotos;
		}




		@Override
		public String toString() {
			return "DamInspectDocs [damdocId=" + damdocId + ", damDocName=" + damDocName + ", damDocLocation="
					+ damDocLocation + ", damDocOriginalName=" + damDocOriginalName + ", userId=" + userId
					+ ", damDataId=" + damDataId + ", userName=" + userName + ", updateduserId=" + updateduserId
					+ ", updateduserName=" + updateduserName + ", unitId=" + unitId + ", unitName=" + unitName
					+ ", olddamdocId=" + olddamdocId + ", sourceName=" + sourceName + ", damPhotos=" + damPhotos + "]";
		}




		


		
		

	}


