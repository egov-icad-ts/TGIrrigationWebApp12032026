package in.ts.icad.leagal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CAGParas {
	
	
		
		private String parasAction;
	
		private String actionTitle;
		private String paraTitle;
		private Integer paraId;
		
		private  Integer unitId;
		private Integer circleId;
		private Integer divisionId;
		private Integer subdivisionId;
		private Integer responsibleOfficeId;
	
		private String paraStatus;
		private Integer paraStatusId;
		
		private String financialYear;
		
		
		private Integer tunitId;
		private Integer tcircleId;
		private Integer tdivisionId;
		private Integer tsubdivisionId;
		private Integer year;
		private Integer statusId;
		private Integer droppedCount;
		
		private Integer paraSequence;
		
		
		private Integer cagGistId;
		private Integer cagParaId;
		
		private String subParaNumber;
		
		private String subParaUnitList;
		
		private Integer subParaUnitId;
		private Integer subparacount;
		
		private String doctitle;
		private String docdate;
		
		private Integer replybyce;
		private Integer replybyenci;
		private Integer replybysecyag;
		private Integer replybyseccont;
		private Integer dicusspaccount;
		
		private Integer pacinclcount;
		
		
		
		
		
		
		
		
		public Integer getReplybyce() {
			return replybyce;
		}
		public void setReplybyce(Integer replybyce) {
			this.replybyce = replybyce;
		}
		public Integer getReplybyenci() {
			return replybyenci;
		}
		public void setReplybyenci(Integer replybyenci) {
			this.replybyenci = replybyenci;
		}
		public Integer getReplybysecyag() {
			return replybysecyag;
		}
		public void setReplybysecyag(Integer replybysecyag) {
			this.replybysecyag = replybysecyag;
		}
		public Integer getReplybyseccont() {
			return replybyseccont;
		}
		public void setReplybyseccont(Integer replybyseccont) {
			this.replybyseccont = replybyseccont;
		}
		public Integer getDicusspaccount() {
			return dicusspaccount;
		}
		public void setDicusspaccount(Integer dicusspaccount) {
			this.dicusspaccount = dicusspaccount;
		}
		public Integer getPacinclcount() {
			return pacinclcount;
		}
		public void setPacinclcount(Integer pacinclcount) {
			this.pacinclcount = pacinclcount;
		}
		public String getDoctitle() {
			return doctitle;
		}
		public void setDoctitle(String doctitle) {
			this.doctitle = doctitle;
		}
		public String getDocdate() {
			return docdate;
		}
		public void setDocdate(String docdate) {
			this.docdate = docdate;
		}
		public Integer getSubparacount() {
			return subparacount;
		}
		public void setSubparacount(Integer subparacount) {
			this.subparacount = subparacount;
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
		public Integer getParaSequence() {
			return paraSequence;
		}
		public void setParaSequence(Integer paraSequence) {
			this.paraSequence = paraSequence;
		}
		public String getParaTitle() {
			return paraTitle;
		}
		public void setParaTitle(String paraTitle) {
			this.paraTitle = paraTitle;
		}
		private String paraNumber;
		private String auditDateFrom;
		private String auditDateTo;
		private Integer sectionId;
		
		private String paraCAGsection;
		
		public String getParaCAGsection() {
			return paraCAGsection;
		}
		public void setParaCAGsection(String paraCAGsection) {
			this.paraCAGsection = paraCAGsection;
		}
		private String docoriginalName;
		
		
		
		public String getDocoriginalName() {
			return docoriginalName;
		}
		public void setDocoriginalName(String docoriginalName) {
			this.docoriginalName = docoriginalName;
		}
		private Integer balanceId;
		
		private String unitCode;
		
		private String circleTotal;
		private String unitTotal;
		/*private String replylatest;*/
		
		private Boolean deleteFlag;
		private Boolean editFlag;
		
		private Integer hiddenCircleId;
		private Integer hiddenDivisionId;
		private Integer hiddenSubdivisionId;
		private String hiddenFinancialYear;
		
		private String urlvalue;
		
		private Integer paraReplyId;
		
		private String paravalue;
		
		private Integer docId;
		
		private ReplyData rd;
		
		private Boolean transferFlag;
		
		private Integer hiddenTrUnitId;
		private Integer hiddenTrCircleId;
		private Integer hiddenTrDivisionId;
		private Integer hiddenTrSubdivisionId;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public Integer getHiddenTrUnitId() {
			return hiddenTrUnitId;
		}
		public void setHiddenTrUnitId(Integer hiddenTrUnitId) {
			this.hiddenTrUnitId = hiddenTrUnitId;
		}
		public Integer getHiddenTrCircleId() {
			return hiddenTrCircleId;
		}
		public void setHiddenTrCircleId(Integer hiddenTrCircleId) {
			this.hiddenTrCircleId = hiddenTrCircleId;
		}
		public Integer getHiddenTrDivisionId() {
			return hiddenTrDivisionId;
		}
		public void setHiddenTrDivisionId(Integer hiddenTrDivisionId) {
			this.hiddenTrDivisionId = hiddenTrDivisionId;
		}
		public Integer getHiddenTrSubdivisionId() {
			return hiddenTrSubdivisionId;
		}
		public void setHiddenTrSubdivisionId(Integer hiddenTrSubdivisionId) {
			this.hiddenTrSubdivisionId = hiddenTrSubdivisionId;
		}
		public Boolean getTransferFlag() {
			return transferFlag;
		}
		public void setTransferFlag(Boolean transferFlag) {
			this.transferFlag = transferFlag;
		}
		public ReplyData getRd() {
			return rd;
		}
		public void setRd(ReplyData rd) {
			this.rd = rd;
		}
		public Integer getDocId() {
			return docId;
		}
		public void setDocId(Integer docId) {
			this.docId = docId;
		}
		public String getParavalue() {
			return paravalue;
		}
		public void setParavalue(String paravalue) {
			this.paravalue = paravalue;
		}
		public Integer getParaReplyId() {
			return paraReplyId;
		}
		public void setParaReplyId(Integer paraReplyId) {
			this.paraReplyId = paraReplyId;
		}
		public String getUrlvalue() {
			return urlvalue;
		}
		public void setUrlvalue(String urlvalue) {
			this.urlvalue = urlvalue;
		}
		public String getHiddenFinancialYear() {
			return hiddenFinancialYear;
		}
		public void setHiddenFinancialYear(String hiddenFinancialYear) {
			this.hiddenFinancialYear = hiddenFinancialYear;
		}
		public Integer getHiddenCircleId() {
			return hiddenCircleId;
		}
		public void setHiddenCircleId(Integer hiddenCircleId) {
			this.hiddenCircleId = hiddenCircleId;
		}
		public Integer getHiddenDivisionId() {
			return hiddenDivisionId;
		}
		public void setHiddenDivisionId(Integer hiddenDivisionId) {
			this.hiddenDivisionId = hiddenDivisionId;
		}
		public Integer getHiddenSubdivisionId() {
			return hiddenSubdivisionId;
		}
		public void setHiddenSubdivisionId(Integer hiddenSubdivisionId) {
			this.hiddenSubdivisionId = hiddenSubdivisionId;
		}
		public Boolean getDeleteFlag() {
			return deleteFlag;
		}
		public void setDeleteFlag(Boolean deleteFlag) {
			this.deleteFlag = deleteFlag;
		}
		public Boolean getEditFlag() {
			return editFlag;
		}
		public void setEditFlag(Boolean editFlag) {
			this.editFlag = editFlag;
		}
		/*public String getReplylatest() {
			return replylatest;
		}
		public void setReplylatest(String replylatest) {
			this.replylatest = replylatest;
		}*/
		public String getCircleTotal() {
			return circleTotal;
		}
		public void setCircleTotal(String circleTotal) {
			this.circleTotal = circleTotal;
		}
		public String getUnitTotal() {
			return unitTotal;
		}
		public void setUnitTotal(String unitTotal) {
			this.unitTotal = unitTotal;
		}
		public String getUnitCode() {
			return unitCode;
		}
		public void setUnitCode(String unitCode) {
			this.unitCode = unitCode;
		}
		public Integer getBalanceId() {
			return balanceId;
		}
		public void setBalanceId(Integer balanceId) {
			this.balanceId = balanceId;
		}
		public Integer getSectionId() {
			return sectionId;
		}
		public void setSectionId(Integer sectionId) {
			this.sectionId = sectionId;
		}
		
		public String getParaNumber() {
			return paraNumber;
		}
		public void setParaNumber(String paraNumber) {
			this.paraNumber = paraNumber;
		}
		public String getAuditDateFrom() {
			return auditDateFrom;
		}
		public void setAuditDateFrom(String auditDateFrom) {
			this.auditDateFrom = auditDateFrom;
		}
		public String getAuditDateTo() {
			return auditDateTo;
		}
		public void setAuditDateTo(String auditDateTo) {
			this.auditDateTo = auditDateTo;
		}
		public Integer getDroppedCount() {
			return droppedCount;
		}
		public void setDroppedCount(Integer droppedCount) {
			this.droppedCount = droppedCount;
		}
		private Integer userId;
		private String  userName;
		
		private List<CAGParasData> paraDataList;
		private List<ParaDocuments> paradocList;
		
		private List<ReplyData> replyDataList;
		
		private List<MultipartFile>   uploadFile;
		
		private String fileLocation;
		
		private Integer replySent ;
		private Integer transfrred;
		private Integer replyNotSent;
		
		private String unitName;
		private String circleName;
		private String divisionName;
		private String subdivisionName;
		private Boolean printCAG;
		
		private Integer totalParas;
	
		private Integer balanceParas;
		
		
		
		
		
		private String printCagStatus;
		
		
		
		private String replyAction;
		private String replyRemarks;
	
		
		private String replyDate;
		
		
		
		
		
		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		public String getReplyDate() {
			return replyDate;
		}
		public void setReplyDate(String replyDate) {
			this.replyDate = replyDate;
		}
		public String getReplyAction() {
			return replyAction;
		}
		public void setReplyAction(String replyAction) {
			this.replyAction = replyAction;
		}
		public String getReplyRemarks() {
			return replyRemarks;
		}
		public void setReplyRemarks(String replyRemarks) {
			this.replyRemarks = replyRemarks;
		}
	
		public String getPrintCagStatus() {
			return printCagStatus;
		}
		public void setPrintCagStatus(String printCagStatus) {
			this.printCagStatus = printCagStatus;
		}
		
		public Integer getTotalParas() {
			return totalParas;
		}
		public void setTotalParas(Integer totalParas) {
			this.totalParas = totalParas;
		}
		
		public Integer getBalanceParas() {
			return balanceParas;
		}
		public void setBalanceParas(Integer balanceParas) {
			this.balanceParas = balanceParas;
		}
		public Boolean getPrintCAG() {
			return printCAG;
		}
		public void setPrintCAG(Boolean printCAG) {
			this.printCAG = printCAG;
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
		public Integer getReplySent() {
			return replySent;
		}
		public void setReplySent(Integer replySent) {
			this.replySent = replySent;
		}
		public Integer getTransfrred() {
			return transfrred;
		}
		public void setTransfrred(Integer transfrred) {
			this.transfrred = transfrred;
		}
		public Integer getReplyNotSent() {
			return replyNotSent;
		}
		public void setReplyNotSent(Integer replyNotSent) {
			this.replyNotSent = replyNotSent;
		}
		public String getFileLocation() {
			return fileLocation;
		}
		public void setFileLocation(String fileLocation) {
			this.fileLocation = fileLocation;
		}
		public List<CAGParasData> getParaDataList() {
			return paraDataList;
		}
		public void setParaDataList(List<CAGParasData> paraDataList) {
			this.paraDataList = paraDataList;
		}
		public List<MultipartFile> getUploadFile() {
			return uploadFile;
		}
		public void setUploadFile(List<MultipartFile> uploadFile) {
			this.uploadFile = uploadFile;
		}
		public List<ReplyData> getReplyDataList() {
			return replyDataList;
		}
		public void setReplyDataList(List<ReplyData> replyDataList) {
			this.replyDataList = replyDataList;
		}
		public List<ParaDocuments> getParadocList() {
			return paradocList;
		}
		public void setParadocList(List<ParaDocuments> paradocList) {
			this.paradocList = paradocList;
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
		
		public Integer getStatusId() {
			return statusId;
		}
		public void setStatusId(Integer statusId) {
			this.statusId = statusId;
		}
		
		public Integer getYear() {
			return year;
		}
		public void setYear(Integer year) {
			this.year = year;
		}
		public Integer getTunitId() {
			return tunitId;
		}
		public void setTunitId(Integer tunitId) {
			this.tunitId = tunitId;
		}
		public Integer getTcircleId() {
			return tcircleId;
		}
		public void setTcircleId(Integer tcircleId) {
			this.tcircleId = tcircleId;
		}
		public Integer getTdivisionId() {
			return tdivisionId;
		}
		public void setTdivisionId(Integer tdivisionId) {
			this.tdivisionId = tdivisionId;
		}
		public Integer getTsubdivisionId() {
			return tsubdivisionId;
		}
		public void setTsubdivisionId(Integer tsubdivisionId) {
			this.tsubdivisionId = tsubdivisionId;
		}
		
		
		public String getFinancialYear() {
			return financialYear;
		}
		public void setFinancialYear(String financialYear) {
			this.financialYear = financialYear;
		}
		
		public String getParasAction() {
			return parasAction;
		}
		public void setParasAction(String parasAction) {
			this.parasAction = parasAction;
		}
	
		public String getActionTitle() {
			return actionTitle;
		}
		public void setActionTitle(String actionTitle) {
			this.actionTitle = actionTitle;
		}
		
		public Integer getParaId() {
			return paraId;
		}
		public void setParaId(Integer paraId) {
			this.paraId = paraId;
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
		public Integer getResponsibleOfficeId() {
			return responsibleOfficeId;
		}
		public void setResponsibleOfficeId(Integer responsibleOfficeId) {
			this.responsibleOfficeId = responsibleOfficeId;
		}
		

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
		
		
		private String userObjUserName=null;



		public String getUserObjUserName() {
			return userObjUserName;
		}
		public void setUserObjUserName(String userObjUserName) {
			this.userObjUserName = userObjUserName;
		}
		@Override
		public String toString() {
			return "CAGParas [parasAction=" + parasAction + ", actionTitle=" + actionTitle + ", paraTitle=" + paraTitle
					+ ", paraId=" + paraId + ", unitId=" + unitId + ", circleId=" + circleId + ", divisionId="
					+ divisionId + ", subdivisionId=" + subdivisionId + ", responsibleOfficeId=" + responsibleOfficeId
					+ ", paraStatus=" + paraStatus + ", paraStatusId=" + paraStatusId + ", financialYear="
					+ financialYear + ", tunitId=" + tunitId + ", tcircleId=" + tcircleId + ", tdivisionId="
					+ tdivisionId + ", tsubdivisionId=" + tsubdivisionId + ", year=" + year + ", statusId=" + statusId
					+ ", droppedCount=" + droppedCount + ", paraSequence=" + paraSequence + ", cagGistId=" + cagGistId
					+ ", cagParaId=" + cagParaId + ", subParaNumber=" + subParaNumber + ", subParaUnitList="
					+ subParaUnitList + ", subParaUnitId=" + subParaUnitId + ", paraNumber=" + paraNumber
					+ ", auditDateFrom=" + auditDateFrom + ", auditDateTo=" + auditDateTo + ", sectionId=" + sectionId
					+ ", paraCAGsection=" + paraCAGsection + ", docoriginalName=" + docoriginalName + ", balanceId="
					+ balanceId + ", unitCode=" + unitCode + ", circleTotal=" + circleTotal + ", unitTotal=" + unitTotal
					+ ", deleteFlag=" + deleteFlag + ", editFlag=" + editFlag + ", hiddenCircleId=" + hiddenCircleId
					+ ", hiddenDivisionId=" + hiddenDivisionId + ", hiddenSubdivisionId=" + hiddenSubdivisionId
					+ ", hiddenFinancialYear=" + hiddenFinancialYear + ", urlvalue=" + urlvalue + ", paraReplyId="
					+ paraReplyId + ", paravalue=" + paravalue + ", docId=" + docId + ", rd=" + rd + ", transferFlag="
					+ transferFlag + ", hiddenTrUnitId=" + hiddenTrUnitId + ", hiddenTrCircleId=" + hiddenTrCircleId
					+ ", hiddenTrDivisionId=" + hiddenTrDivisionId + ", hiddenTrSubdivisionId=" + hiddenTrSubdivisionId
					+ ", userId=" + userId + ", userName=" + userName + ", paraDataList=" + paraDataList
					+ ", paradocList=" + paradocList + ", replyDataList=" + replyDataList + ", uploadFile=" + uploadFile
					+ ", fileLocation=" + fileLocation + ", replySent=" + replySent + ", transfrred=" + transfrred
					+ ", replyNotSent=" + replyNotSent + ", unitName=" + unitName + ", circleName=" + circleName
					+ ", divisionName=" + divisionName + ", subdivisionName=" + subdivisionName + ", printCAG="
					+ printCAG + ", totalParas=" + totalParas + ", balanceParas=" + balanceParas + ", printCagStatus="
					+ printCagStatus + ", replyAction=" + replyAction + ", replyRemarks=" + replyRemarks
					+ ", replyDate=" + replyDate + ", userObjUserName=" + userObjUserName + "]";
		}
		
		

	}



