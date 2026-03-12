package  in.ts.icad.leagal.model;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class Contactus {
	
	private String randomNumber;
	private String name;
	private String description;
	private String subject;
	private String designation;
	private String queryId;
	private String queryType;
	private String email;
	private String contactNo;
	
	private String userId;
	private String ip;
	private String lastupdatedDate; 
	private String contactUsId;
	private String filePath;
	private String contactDate;
	private String contactForId; 
	private String  contactType;
	private String  resolutionId;
	private String resolution;
	private String statusID;
	private String status;
	private String publicView;
	private String lastupdatedUserId;
	private String remarks;
	
	private MultipartFile fileUpload;
	
	
	private String fileName;

	public String getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(String randomNumber) {
		this.randomNumber = randomNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLastupdatedDate() {
		return lastupdatedDate;
	}

	public void setLastupdatedDate(String lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	public String getContactUsId() {
		return contactUsId;
	}

	public void setContactUsId(String contactUsId) {
		this.contactUsId = contactUsId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContactDate() {
		return contactDate;
	}

	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}

	public String getContactForId() {
		return contactForId;
	}

	public void setContactForId(String contactForId) {
		this.contactForId = contactForId;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getResolutionId() {
		return resolutionId;
	}

	public void setResolutionId(String resolutionId) {
		this.resolutionId = resolutionId;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getStatusID() {
		return statusID;
	}

	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPublicView() {
		return publicView;
	}

	public void setPublicView(String publicView) {
		this.publicView = publicView;
	}

	public String getLastupdatedUserId() {
		return lastupdatedUserId;
	}

	public void setLastupdatedUserId(String lastupdatedUserId) {
		this.lastupdatedUserId = lastupdatedUserId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	public MultipartFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Contactus [randomNumber=" + randomNumber + ", name=" + name
				+ ", description=" + description + ", subject=" + subject
				+ ", designation=" + designation + ", queryId=" + queryId
				+ ", queryType=" + queryType + ", email=" + email
				+ ", contactNo=" + contactNo + ", userId=" + userId + ", ip="
				+ ip + ", lastupdatedDate=" + lastupdatedDate
				+ ", contactUsId=" + contactUsId + ", filePath=" + filePath
				+ ", contactDate=" + contactDate + ", contactForId="
				+ contactForId + ", contactType=" + contactType
				+ ", resolutionId=" + resolutionId + ", resolution="
				+ resolution + ", statusID=" + statusID + ", status=" + status
				+ ", publicView=" + publicView + ", lastupdatedUserId="
				+ lastupdatedUserId + ", remarks=" + remarks + ", fileUpload="
				+ fileUpload + ", fileName=" + fileName + "]";
	}
	

}
