package in.ts.icad.leagal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PowerBill {
	
	private Integer unitId;
	private String unitName;
	private Integer projectId;
	private String projectName;
	private Integer componentId;
	private String componentName;
	private String billNumber;
	
	private String billDate;
	private String billDueDate;
	private String disconnectionDate;
	private String paidDate;
	private Double additionalSecurityDeposit;
	private Double consumedUnits;
	private Double energyChargeRate;
	private Double energyCharges;
	private Double electricityDutyRate;
	private Double electricityDuty;
	private Double eletricityDutyInterest;
	private Double variableCharges;
	private Double demandRate;
	private Double demandCharges;
	
	private Double customerCharges;
	private Double fixedCharges;
	private Double delayPayInPaise;
	private Double delayPayPerDay;
	private Integer dateDifference;
	private Double latePaySurCharge;
	private Double ACDSurCharges;
	private Double interestSecurityDeposite;
	private Double totalAmount;
	private Double paidAmount;
	private String paidStatus;
	private Integer billYear ;
	private Integer billMonth;
	private String  billMonthName;
	private Double liftMetres;
	private Double unitrate;
	private Double quantity;
	private Double variableOthers;
	private String paidStatusId;
	private Double pendingAmount;
	private Integer selectedUnitId;
	private Integer selectedProjId;
	private Integer selectedCompId;
	private Integer compPowerBillId;
	
	
	public Integer getCompPowerBillId() {
		return compPowerBillId;
	}
	public void setCompPowerBillId(Integer compPowerBillId) {
		this.compPowerBillId = compPowerBillId;
	}
	private MultipartFile uploadBill;
	
	private String remarks;
	
	private String documentNumer;
	private String documentName;
	private String documentPath;
	
	private Boolean deleteFlag;
	private Boolean editFlag;
	
	
	
	
	
	
	
	
	
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
	public String getDocumentNumer() {
		return documentNumer;
	}
	public void setDocumentNumer(String documentNumer) {
		this.documentNumer = documentNumer;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentPath() {
		return documentPath;
	}
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public MultipartFile getUploadBill() {
		return uploadBill;
	}
	public void setUploadBill(MultipartFile uploadBill) {
		this.uploadBill = uploadBill;
	}
	public Integer getSelectedUnitId() {
		return selectedUnitId;
	}
	public void setSelectedUnitId(Integer selectedUnitId) {
		this.selectedUnitId = selectedUnitId;
	}
	public Integer getSelectedProjId() {
		return selectedProjId;
	}
	public void setSelectedProjId(Integer selectedProjId) {
		this.selectedProjId = selectedProjId;
	}
	public Integer getSelectedCompId() {
		return selectedCompId;
	}
	public void setSelectedCompId(Integer selectedCompId) {
		this.selectedCompId = selectedCompId;
	}
	public Double getPendingAmount() {
		return pendingAmount;
	}
	public void setPendingAmount(Double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}
	public String getPaidStatusId() {
		return paidStatusId;
	}
	public void setPaidStatusId(String paidStatusId) {
		this.paidStatusId = paidStatusId;
	}
	public Double getVariableOthers() {
		return variableOthers;
	}
	public void setVariableOthers(Double variableOthers) {
		this.variableOthers = variableOthers;
	}
	private Integer  userId;
	private String userName;
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
	public Integer getComponentId() {
		return componentId;
	}
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getBillDueDate() {
		return billDueDate;
	}
	public void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
	}
	public String getDisconnectionDate() {
		return disconnectionDate;
	}
	public void setDisconnectionDate(String disconnectionDate) {
		this.disconnectionDate = disconnectionDate;
	}
	public String getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}
	public Double getAdditionalSecurityDeposit() {
		return additionalSecurityDeposit;
	}
	public void setAdditionalSecurityDeposit(Double additionalSecurityDeposit) {
		this.additionalSecurityDeposit = additionalSecurityDeposit;
	}
	public Double getConsumedUnits() {
		return consumedUnits;
	}
	public void setConsumedUnits(Double consumedUnits) {
		this.consumedUnits = consumedUnits;
	}
	public Double getEnergyChargeRate() {
		return energyChargeRate;
	}
	public void setEnergyChargeRate(Double energyChargeRate) {
		this.energyChargeRate = energyChargeRate;
	}
	public Double getEnergyCharges() {
		return energyCharges;
	}
	public void setEnergyCharges(Double energyCharges) {
		this.energyCharges = energyCharges;
	}
	public Double getElectricityDutyRate() {
		return electricityDutyRate;
	}
	public void setElectricityDutyRate(Double electricityDutyRate) {
		this.electricityDutyRate = electricityDutyRate;
	}
	public Double getElectricityDuty() {
		return electricityDuty;
	}
	public void setElectricityDuty(Double electricityDuty) {
		this.electricityDuty = electricityDuty;
	}
	public Double getEletricityDutyInterest() {
		return eletricityDutyInterest;
	}
	public void setEletricityDutyInterest(Double eletricityDutyInterest) {
		this.eletricityDutyInterest = eletricityDutyInterest;
	}
	public Double getVariableCharges() {
		return variableCharges;
	}
	public void setVariableCharges(Double variableCharges) {
		this.variableCharges = variableCharges;
	}
	public Double getDemandRate() {
		return demandRate;
	}
	public void setDemandRate(Double demandRate) {
		this.demandRate = demandRate;
	}
	public Double getDemandCharges() {
		return demandCharges;
	}
	public void setDemandCharges(Double demandCharges) {
		this.demandCharges = demandCharges;
	}
	public Double getCustomerCharges() {
		return customerCharges;
	}
	public void setCustomerCharges(Double customerCharges) {
		this.customerCharges = customerCharges;
	}
	public Double getFixedCharges() {
		return fixedCharges;
	}
	public void setFixedCharges(Double fixedCharges) {
		this.fixedCharges = fixedCharges;
	}
	public Double getDelayPayInPaise() {
		return delayPayInPaise;
	}
	public void setDelayPayInPaise(Double delayPayInPaise) {
		this.delayPayInPaise = delayPayInPaise;
	}
	public Double getDelayPayPerDay() {
		return delayPayPerDay;
	}
	public void setDelayPayPerDay(Double delayPayPerDay) {
		this.delayPayPerDay = delayPayPerDay;
	}
	public Integer getDateDifference() {
		return dateDifference;
	}
	public void setDateDifference(Integer dateDifference) {
		this.dateDifference = dateDifference;
	}
	public Double getLatePaySurCharge() {
		return latePaySurCharge;
	}
	public void setLatePaySurCharge(Double latePaySurCharge) {
		this.latePaySurCharge = latePaySurCharge;
	}
	public Double getACDSurCharges() {
		return ACDSurCharges;
	}
	public void setACDSurCharges(Double aCDSurCharges) {
		ACDSurCharges = aCDSurCharges;
	}
	public Double getInterestSecurityDeposite() {
		return interestSecurityDeposite;
	}
	public void setInterestSecurityDeposite(Double interestSecurityDeposite) {
		this.interestSecurityDeposite = interestSecurityDeposite;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(String paidStatus) {
		this.paidStatus = paidStatus;
	}
	public Integer getBillYear() {
		return billYear;
	}
	public void setBillYear(Integer billYear) {
		this.billYear = billYear;
	}
	public Integer getBillMonth() {
		return billMonth;
	}
	public void setBillMonth(Integer billMonth) {
		this.billMonth = billMonth;
	}
	public String getBillMonthName() {
		return billMonthName;
	}
	public void setBillMonthName(String billMonthName) {
		this.billMonthName = billMonthName;
	}
	public Double getLiftMetres() {
		return liftMetres;
	}
	public void setLiftMetres(Double liftMetres) {
		this.liftMetres = liftMetres;
	}
	public Double getUnitrate() {
		return unitrate;
	}
	public void setUnitrate(Double unitrate) {
		this.unitrate = unitrate;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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
	@Override
	public String toString() {
		return "PowerBill [unitId=" + unitId + ", unitName=" + unitName + ", projectId=" + projectId + ", projectName="
				+ projectName + ", componentId=" + componentId + ", componentName=" + componentName + ", billNumber="
				+ billNumber + ", billDate=" + billDate + ", billDueDate=" + billDueDate + ", disconnectionDate="
				+ disconnectionDate + ", paidDate=" + paidDate + ", additionalSecurityDeposit="
				+ additionalSecurityDeposit + ", consumedUnits=" + consumedUnits + ", energyChargeRate="
				+ energyChargeRate + ", energyCharges=" + energyCharges + ", electricityDutyRate=" + electricityDutyRate
				+ ", electricityDuty=" + electricityDuty + ", eletricityDutyInterest=" + eletricityDutyInterest
				+ ", variableCharges=" + variableCharges + ", demandRate=" + demandRate + ", demandCharges="
				+ demandCharges + ", customerCharges=" + customerCharges + ", fixedCharges=" + fixedCharges
				+ ", delayPayInPaise=" + delayPayInPaise + ", delayPayPerDay=" + delayPayPerDay + ", dateDifference="
				+ dateDifference + ", latePaySurCharge=" + latePaySurCharge + ", ACDSurCharges=" + ACDSurCharges
				+ ", interestSecurityDeposite=" + interestSecurityDeposite + ", totalAmount=" + totalAmount
				+ ", paidAmount=" + paidAmount + ", paidStatus=" + paidStatus + ", billYear=" + billYear
				+ ", billMonth=" + billMonth + ", billMonthName=" + billMonthName + ", liftMetres=" + liftMetres
				+ ", unitrate=" + unitrate + ", quantity=" + quantity + ", variableOthers=" + variableOthers
				+ ", paidStatusId=" + paidStatusId + ", pendingAmount=" + pendingAmount + ", selectedUnitId="
				+ selectedUnitId + ", selectedProjId=" + selectedProjId + ", selectedCompId=" + selectedCompId
				+ ", uploadBill=" + uploadBill + ", remarks=" + remarks + ", documentNumer=" + documentNumer
				+ ", documentName=" + documentName + ", documentPath=" + documentPath + ", userId=" + userId
				+ ", userName=" + userName + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
