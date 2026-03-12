package in.ts.icad.leagal.model;

import org.springframework.web.multipart.MultipartFile;

public class CaseOrderStatus {
	
	private Integer caseOrderStatusId;
	
	private Integer caseTypeOrderId;
	
	private Integer caseId;
	
	private String userName;
	
	private String userId;
	
	private String orderDate;
	
	private String OrderfileName;
	
	private String OrderfilePath;
	
	private MultipartFile orderFile;

	public MultipartFile getOrderFile() {
		return orderFile;
	}

	public void setOrderFile(MultipartFile orderFile) {
		this.orderFile = orderFile;
	}

	public Integer getCaseOrderStatusId() {
		return caseOrderStatusId;
	}

	public void setCaseOrderStatusId(Integer caseOrderStatusId) {
		this.caseOrderStatusId = caseOrderStatusId;
	}

	public Integer getCaseTypeOrderId() {
		return caseTypeOrderId;
	}

	public void setCaseTypeOrderId(Integer caseTypeOrderId) {
		this.caseTypeOrderId = caseTypeOrderId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public String getOrderfileName() {
		return OrderfileName;
	}

	public void setOrderfileName(String orderfileName) {
		OrderfileName = orderfileName;
	}

	public String getOrderfilePath() {
		return OrderfilePath;
	}

	public void setOrderfilePath(String orderfilePath) {
		OrderfilePath = orderfilePath;
	}

	@Override
	public String toString() {
		return "CaseOrderStatus [caseOrderStatusId=" + caseOrderStatusId + ", caseTypeOrderId=" + caseTypeOrderId
				+ ", caseId=" + caseId + ", userName=" + userName + ", userId=" + userId + ", orderDate=" + orderDate
				+ ", OrderfileName=" + OrderfileName + ", OrderfilePath=" + OrderfilePath + ", orderFile=" + orderFile
				+ "]";
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
	
	

}
