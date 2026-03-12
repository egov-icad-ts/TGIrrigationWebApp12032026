package in.ts.icad.leagal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CadAyacutKmlDocs {
	
	private Integer cadkmlId;
	private String docName;
	private String  docLocation;
	private String docOriginalName;

	

	private String userName;
	
	private Integer updateduserId;
	private String updateduserName;
	
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	private Integer subdivisionId;
	private Long postId;
	private String unitName;
	private String circleName;
	private String divisionName;
	private String subdivisionName;
	private String postName;
	
	private String submitteddate;
	
	
	
	
	public String getSubmitteddate() {
		return submitteddate;
	}


	public void setSubmitteddate(String submitteddate) {
		this.submitteddate = submitteddate;
	}


	private List<MultipartFile> kmlfiles;
	
	
	public List<MultipartFile> getKmlfiles() {
		return kmlfiles;
	}


	public void setKmlfiles(List<MultipartFile> kmlfiles) {
		this.kmlfiles = kmlfiles;
	}


	private Integer projectId;
	private String projectName;
	
	
	public Integer getCadkmlId() {
		return cadkmlId;
	}


	public void setCadkmlId(Integer cadkmlId) {
		this.cadkmlId = cadkmlId;
	}


	public String getDocName() {
		return docName;
	}


	public void setDocName(String docName) {
		this.docName = docName;
	}


	public String getDocLocation() {
		return docLocation;
	}


	public void setDocLocation(String docLocation) {
		this.docLocation = docLocation;
	}


	public String getDocOriginalName() {
		return docOriginalName;
	}


	public void setDocOriginalName(String docOriginalName) {
		this.docOriginalName = docOriginalName;
	}


	public String getUserName() {
		return userName;
	}


	@Override
	public String toString() {
		return "CadAyacutKmlDocs [cadkmlId=" + cadkmlId + ", docName=" + docName + ", docLocation=" + docLocation
				+ ", docOriginalName=" + docOriginalName + ", userName=" + userName + ", updateduserId=" + updateduserId
				+ ", updateduserName=" + updateduserName + ", unitId=" + unitId + ", circleId=" + circleId
				+ ", divisionId=" + divisionId + ", subdivisionId=" + subdivisionId + ", postId=" + postId
				+ ", unitName=" + unitName + ", circleName=" + circleName + ", divisionName=" + divisionName
				+ ", subdivisionName=" + subdivisionName + ", postName=" + postName + ", kmlfiles=" + kmlfiles
				+ ", projectId=" + projectId + ", projectName=" + projectName + ", olddocId=" + olddocId + "]";
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


	public Long getPostId() {
		return postId;
	}


	public void setPostId(Long postId) {
		this.postId = postId;
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


	public String getPostName() {
		return postName;
	}


	public void setPostName(String postName) {
		this.postName = postName;
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


	public Integer getOlddocId() {
		return olddocId;
	}


	public void setOlddocId(Integer olddocId) {
		this.olddocId = olddocId;
	}


	private Integer olddocId;
	
	

}
