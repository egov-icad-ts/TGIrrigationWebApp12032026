package in.ts.icad.leagal.model;

public class TaskFiles {
	
	private Integer fileDataId;
	private String fileName;
	private String fileLocation;
	private Integer taskId;
	private String userId;
	private Integer designationId;
	
	
	
	public Integer getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}
	public Integer getFileDataId() {
		return fileDataId;
	}
	public void setFileDataId(Integer fileDataId) {
		this.fileDataId = fileDataId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "TaskFiles [fileDataId=" + fileDataId + ", fileName=" + fileName + ", fileLocation=" + fileLocation
				+ ", taskId=" + taskId + ", userId=" + userId + "]";
	}
	

}
