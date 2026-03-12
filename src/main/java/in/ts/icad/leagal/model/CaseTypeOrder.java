package in.ts.icad.leagal.model;

public class CaseTypeOrder {
	
	private Integer caseTypeOrderId;
	private  String caseTypeOrder;
	

	public Integer getCaseTypeOrderId() {
		return caseTypeOrderId;
	}

	public void setCaseTypeOrderId(Integer caseTypeOrderId) {
		this.caseTypeOrderId = caseTypeOrderId;
	}

	public String getCaseTypeOrder() {
		return caseTypeOrder;
	}

	public void setCaseTypeOrder(String caseTypeOrder) {
		this.caseTypeOrder = caseTypeOrder;
	}

	
	
	@Override
	public String toString() {
		return "CaseTypeOrder [caseTypeOrderId=" + caseTypeOrderId + ", caseTypeOrder=" + caseTypeOrder + "]";
	}
	
	
	

}
