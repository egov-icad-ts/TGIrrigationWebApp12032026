package in.ts.icad.leagal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MiTankFormDocs {
	
	private Integer formdocId;
	private String formDocName;
	private String  formDocLocation;
	private String formDocOriginalName;

	private Integer  userId;
	private Integer formDataId;
	

	private String userName;
	
	private Integer updateduserId;
	private String updateduserName;
	
	private Integer unitId;
	private String unitName;
	
	private Integer oldFormdocId;
	
	private String sourceName;
	
	
	
	
	public String getSourceName() {
		return sourceName;
	}




	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}




	private List<MultipartFile> formPhotos;

	

	
	public Integer getOldFormdocId() {
		return oldFormdocId;
	}




	public void setOldFormdocId(Integer oldFormdocId) {
		this.oldFormdocId = oldFormdocId;
	}




	public Integer getFormdocId() {
		return formdocId;
	}




	public void setFormdocId(Integer formdocId) {
		this.formdocId = formdocId;
	}




	public String getFormDocName() {
		return formDocName;
	}




	public void setFormDocName(String formDocName) {
		this.formDocName = formDocName;
	}




	public String getFormDocLocation() {
		return formDocLocation;
	}




	public void setFormDocLocation(String formDocLocation) {
		this.formDocLocation = formDocLocation;
	}




	public String getFormDocOriginalName() {
		return formDocOriginalName;
	}




	public void setFormDocOriginalName(String formDocOriginalName) {
		this.formDocOriginalName = formDocOriginalName;
	}




	public Integer getUserId() {
		return userId;
	}




	public void setUserId(Integer userId) {
		this.userId = userId;
	}




	public Integer getFormDataId() {
		return formDataId;
	}




	public void setFormDataId(Integer formDataId) {
		this.formDataId = formDataId;
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




	public List<MultipartFile> getFormPhotos() {
		return formPhotos;
	}




	public void setFormPhotos(List<MultipartFile> formPhotos) {
		this.formPhotos = formPhotos;
	}




	@Override
	public String toString() {
		return "MiTankFormDocs [formdocId=" + formdocId + ", formDocName=" + formDocName + ", formDocLocation="
				+ formDocLocation + ", formDocOriginalName=" + formDocOriginalName + ", userId=" + userId
				+ ", formDataId=" + formDataId + ", userName=" + userName + ", updateduserId=" + updateduserId
				+ ", updateduserName=" + updateduserName + ", unitId=" + unitId + ", unitName=" + unitName
				+ ", formPhotos=" + formPhotos + "]";
	}
	
	
	

}
