package in.ts.icad.leagal.model;

public class CAGParasData {
	
	
	private String parasAction;
	private String paraTitle;
	private Integer paraSequence;
	private Integer hidden_row_id;
	
	private Integer cagGistId;
	private Integer cagParaId;	
	
	private Integer userId;
	private String userName;
	private String subParaNumber;
	private String subParaUnitList;
	
	private Integer subParaUnitId;
	private Integer paraStatusId;
	private String paraStatus;
	private String discussPac;
	
	private String unitName;
	
	private String paraUnitIdList;
	private Integer paraUnitId;
	private Boolean paraunitFlag;
	
	private String financialYear;
	private String cagGistPara;
	private String paraNumber;
	
	private String pacincluded;
	
	private String remarks;
	
	
	private Integer cunitId;
	
	private String cagGistTitle;
	
	private Boolean transferFlag;
	
	private Integer circleId;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getCircleId() {
		return circleId;
	}
	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}
	public Boolean getTransferFlag() {
		return transferFlag;
	}
	public void setTransferFlag(Boolean transferFlag) {
		this.transferFlag = transferFlag;
	}
	public String getCagGistTitle() {
		return cagGistTitle;
	}
	public void setCagGistTitle(String cagGistTitle) {
		this.cagGistTitle = cagGistTitle;
	}
	public Integer getCunitId() {
		return cunitId;
	}
	public void setCunitId(Integer cunitId) {
		this.cunitId = cunitId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPacincluded() {
		return pacincluded;
	}
	public void setPacincluded(String pacincluded) {
		this.pacincluded = pacincluded;
	}
	public String getParaNumber() {
		return paraNumber;
	}
	public void setParaNumber(String paraNumber) {
		this.paraNumber = paraNumber;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public String getCagGistPara() {
		return cagGistPara;
	}
	public void setCagGistPara(String cagGistPara) {
		this.cagGistPara = cagGistPara;
	}
	private Integer[] hiddensubParaUnitList;
	
	
	
	
	
	
	
	
	
	public Integer[] getHiddensubParaUnitList() {
		return hiddensubParaUnitList;
	}
	public void setHiddensubParaUnitList(Integer[] hiddensubParaUnitList) {
		this.hiddensubParaUnitList = hiddensubParaUnitList;
	}
	public String getParaUnitIdList() {
		return paraUnitIdList;
	}
	public void setParaUnitIdList(String paraUnitIdList) {
		this.paraUnitIdList = paraUnitIdList;
	}
	public Integer getParaUnitId() {
		return paraUnitId;
	}
	public void setParaUnitId(Integer paraUnitId) {
		this.paraUnitId = paraUnitId;
	}
	public Boolean getParaunitFlag() {
		return paraunitFlag;
	}
	public void setParaunitFlag(Boolean paraunitFlag) {
		this.paraunitFlag = paraunitFlag;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getDiscussPac() {
		return discussPac;
	}
	public void setDiscussPac(String discussPac) {
		this.discussPac = discussPac;
	}
	public Integer getParaStatusId() {
		return paraStatusId;
	}
	public void setParaStatusId(Integer paraStatusId) {
		this.paraStatusId = paraStatusId;
	}
	public String getParaStatus() {
		return paraStatus;
	}
	public void setParaStatus(String paraStatus) {
		this.paraStatus = paraStatus;
	}
	public String getSubParaUnitList() {
		return subParaUnitList;
	}
	public void setSubParaUnitList(String subParaUnitList) {
		this.subParaUnitList = subParaUnitList;
	}
	public Integer getSubParaUnitId() {
		return subParaUnitId;
	}
	public void setSubParaUnitId(Integer subParaUnitId) {
		this.subParaUnitId = subParaUnitId;
	}
	
	
	
	
	public String getSubParaNumber() {
		return subParaNumber;
	}
	public void setSubParaNumber(String subParaNumber) {
		this.subParaNumber = subParaNumber;
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
	public Integer getHidden_row_id() {
		return hidden_row_id;
	}
	public void setHidden_row_id(Integer hidden_row_id) {
		this.hidden_row_id = hidden_row_id;
	}
	
	public String getParasAction() {
		return parasAction;
	}
	public void setParasAction(String parasAction) {
		this.parasAction = parasAction;
	}
	public String getParaTitle() {
		return paraTitle;
	}
	public void setParaTitle(String paraTitle) {
		this.paraTitle = paraTitle;
	}
	public Integer getParaSequence() {
		return paraSequence;
	}
	public void setParaSequence(Integer paraSequence) {
		this.paraSequence = paraSequence;
	}
	@Override
	public String toString() {
		return "CAGParasData [parasAction=" + parasAction + ", paraTitle=" + paraTitle + ", paraSequence="
				+ paraSequence + ", hidden_row_id=" + hidden_row_id + ", cagGistId=" + cagGistId + ", cagParaId="
				+ cagParaId + ", userId=" + userId + ", userName=" + userName + ", subParaNumber=" + subParaNumber
				+ ", subParaUnitList=" + subParaUnitList + ", subParaUnitId=" + subParaUnitId + ", paraStatusId="
				+ paraStatusId + ", paraStatus=" + paraStatus + ", discussPac=" + discussPac + ", unitName=" + unitName
				+ "]";
	}
	
	
	
	
	

}
