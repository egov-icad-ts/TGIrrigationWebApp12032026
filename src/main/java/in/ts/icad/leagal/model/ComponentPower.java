package in.ts.icad.leagal.model;

public class ComponentPower {
	
	private Integer componentId;
	public Integer getComponentId() {
		return componentId;
	}
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Double getPreviousunit() {
		return previousunit;
	}
	public void setPreviousunit(Double previousunit) {
		this.previousunit = previousunit;
	}
	public Double getPresentunit() {
		return presentunit;
	}
	public void setPresentunit(Double presentunit) {
		this.presentunit = presentunit;
	}
	public Double getPresentunitcost() {
		return presentunitcost;
	}
	public void setPresentunitcost(Double presentunitcost) {
		this.presentunitcost = presentunitcost;
	}
	public Double getPreunitcost() {
		return preunitcost;
	}
	public void setPreunitcost(Double preunitcost) {
		this.preunitcost = preunitcost;
	}
	private Integer projectId;
	private Double previousunit;
	private Double presentunit;
	private Double presentunitcost;
	private Double preunitcost;
	private Double totalcostbymonth;
	private String powerConsumeMonth;
	private Integer userId;
	private String remarks;
	private Double additionalDeposit;
	private Double fixedCharges;
	private Double penalityCharges;
	private Double billCost;
	private Double netBillCost;
	private Double totalUnitsConsumed;
	private String dueDate;
	private String disconnectionDate;
	private String componentName;
	private Boolean editFlag;
	private Boolean deleteFlag;
	private Integer selectedcompId;
	private Double totalAmount;
	private Double paidAmount;
	private Double pendingAmount;
	private String paidStatusId;
	private String paidStatus;
	private String paidDate;
	private String billNumber;
	
	private Integer unitId;
	private String unitName;
	private String projectName;
	private Integer selectedUnitId;
	private Integer selectedProjId;
	private Integer selectedCompId;
	
	
	
	
	
	
	
	
	
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
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
	public String getPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(String paidStatus) {
		this.paidStatus = paidStatus;
	}
	public String getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}
	public Integer getSelectedcompId() {
		return selectedcompId;
	}
	public void setSelectedcompId(Integer selectedcompId) {
		this.selectedcompId = selectedcompId;
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
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	private Integer componentPowerId;
	
	
	
	
	public Integer getComponentPowerId() {
		return componentPowerId;
	}
	public void setComponentPowerId(Integer componentPowerId) {
		this.componentPowerId = componentPowerId;
	}
	public Double getAdditionalDeposit() {
		return additionalDeposit;
	}
	public void setAdditionalDeposit(Double additionalDeposit) {
		this.additionalDeposit = additionalDeposit;
	}
	public Double getFixedCharges() {
		return fixedCharges;
	}
	public void setFixedCharges(Double fixedCharges) {
		this.fixedCharges = fixedCharges;
	}
	public Double getPenalityCharges() {
		return penalityCharges;
	}
	public void setPenalityCharges(Double penalityCharges) {
		this.penalityCharges = penalityCharges;
	}
	public Double getBillCost() {
		return billCost;
	}
	public void setBillCost(Double billCost) {
		this.billCost = billCost;
	}
	public Double getNetBillCost() {
		return netBillCost;
	}
	public void setNetBillCost(Double netBillCost) {
		this.netBillCost = netBillCost;
	}
	public Double getTotalUnitsConsumed() {
		return totalUnitsConsumed;
	}
	public void setTotalUnitsConsumed(Double totalUnitsConsumed) {
		this.totalUnitsConsumed = totalUnitsConsumed;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDisconnectionDate() {
		return disconnectionDate;
	}
	public void setDisconnectionDate(String disconnectionDate) {
		this.disconnectionDate = disconnectionDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPowerConsumeMonth() {
		return powerConsumeMonth;
	}
	public void setPowerConsumeMonth(String powerConsumeMonth) {
		this.powerConsumeMonth = powerConsumeMonth;
	}
	public Double getTotalcostbymonth() {
		return totalcostbymonth;
	}
	public void setTotalcostbymonth(Double totalcostbymonth) {
		this.totalcostbymonth = totalcostbymonth;
	}
	
	
	

}
