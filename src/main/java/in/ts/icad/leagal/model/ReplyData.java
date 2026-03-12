package in.ts.icad.leagal.model;

public class ReplyData {
	
	private Integer paraId;
	private String replyTitle;
	private String replyAction;
	private String replyRemarks;
	private Boolean editFlag;
	private Boolean deleteFlag;
	private Integer paraReplyId;
	private String replyDate;
	private Integer paraStatusId;
	
	private Integer paramstSubId;
	
	private Integer subParaId;
	
	private String  updatedUsername;
	
	private Boolean pacincl;
	
	private String createDate;
	
	
	
	
	
	
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Boolean getPacincl() {
		return pacincl;
	}
	public void setPacincl(Boolean pacincl) {
		this.pacincl = pacincl;
	}
	public String getUpdatedUsername() {
		return updatedUsername;
	}
	public void setUpdatedUsername(String updatedUsername) {
		this.updatedUsername = updatedUsername;
	}
	public Integer getSubParaId() {
		return subParaId;
	}
	public void setSubParaId(Integer subParaId) {
		this.subParaId = subParaId;
	}
	public Integer getParamstSubId() {
		return paramstSubId;
	}
	public void setParamstSubId(Integer paramstSubId) {
		this.paramstSubId = paramstSubId;
	}
	private String paraStatus;
	
	
	public String getParaStatus() {
		return paraStatus;
	}
	public void setParaStatus(String paraStatus) {
		this.paraStatus = paraStatus;
	}
	public Integer getParaStatusId() {
		return paraStatusId;
	}
	public void setParaStatusId(Integer paraStatusId) {
		this.paraStatusId = paraStatusId;
	}
	private Integer cagGistId;
	private Integer cagParaId;
	
	private Integer paraseq;
	
	private String unitName;
	
	
	
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	private String subParaNumber;
	public String getSubParaNumber() {
		return subParaNumber;
	}
	public void setSubParaNumber(String subParaNumber) {
		this.subParaNumber = subParaNumber;
	}
	public Integer getSubParaUnitId() {
		return subParaUnitId;
	}
	public void setSubParaUnitId(Integer subParaUnitId) {
		this.subParaUnitId = subParaUnitId;
	}
	private Integer subParaUnitId;
	
	public String getUpdatedUserName() {
		return updatedUserName;
	}
	public void setUpdatedUserName(String updatedUserName) {
		this.updatedUserName = updatedUserName;
	}
	private String updatedUserName;
	
	private Integer createReplybyUnit;
	
	
	
	
	
	
	
	public Integer getCreateReplybyUnit() {
		return createReplybyUnit;
	}
	public void setCreateReplybyUnit(Integer createReplybyUnit) {
		this.createReplybyUnit = createReplybyUnit;
	}
	public Integer getParaseq() {
		return paraseq;
	}
	public void setParaseq(Integer paraseq) {
		this.paraseq = paraseq;
	}
	public Integer getCagGistId() {
		return cagGistId;
	}
	public void setCagGistId(Integer cagGistId) {
		this.cagGistId = cagGistId;
	}
	public Integer getCagParaId() {
		return cagParaId;
	}
	public void setCagParaId(Integer cagParaId) {
		this.cagParaId = cagParaId;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	@Override
	public String toString() {
		return "ReplyData [paraId=" + paraId + ", replyTitle=" + replyTitle + ", replyAction=" + replyAction
				+ ", replyRemarks=" + replyRemarks + ", editFlag=" + editFlag + ", deleteFlag=" + deleteFlag
				+ ", paraReplyId=" + paraReplyId + ", userId=" + userId + ", userName=" + userName + ", replyrow_id="
				+ replyrow_id + ", replylatest=" + replylatest + "]";
	}
	private Integer userId;
	private String userName;
	private Integer replyrow_id;
	
	private Boolean replylatest;
	
	private Integer createUserId;
	private String createUserName;
	
	
	
	
	
	
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public Boolean getReplylatest() {
		return replylatest;
	}
	public void setReplylatest(Boolean replylatest) {
		this.replylatest = replylatest;
	}
	public String getReplyAction() {
		return replyAction;
	}
	public void setReplyAction(String replyAction) {
		this.replyAction = replyAction;
	}
	public Integer getReplyrow_id() {
		return replyrow_id;
	}
	public void setReplyrow_id(Integer replyrow_id) {
		this.replyrow_id = replyrow_id;
	}
	public Integer getParaId() {
		return paraId;
	}
	public void setParaId(Integer paraId) {
		this.paraId = paraId;
	}
	public String getReplyTitle() {
		return replyTitle;
	}
	public void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}
	
	public String getReplyRemarks() {
		return replyRemarks;
	}
	public void setReplyRemarks(String replyRemarks) {
		this.replyRemarks = replyRemarks;
	}
	public Boolean getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(Boolean editFlag) {
		this.editFlag = editFlag;
	}
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getParaReplyId() {
		return paraReplyId;
	}
	public void setParaReplyId(Integer paraReplyId) {
		this.paraReplyId = paraReplyId;
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
	
	
	

}
