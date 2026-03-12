package in.ts.icad.leagal.model;
public class PumpOperationType {
	
	private Integer pumpOperationTypeId;
	
	private String pumpOperationType;
	
	private Integer pumpOperationSequence;
	private Integer pumpOPerationParentId;
	
	@Override
	public String toString() {
		return "PumpOperationType [pumpOperationTypeId=" + pumpOperationTypeId + ", pumpOperationType="
				+ pumpOperationType + ", pumpOperationSequence=" + pumpOperationSequence + ", pumpOPerationParentId="
				+ pumpOPerationParentId + "]";
	}
	public Integer getPumpOperationTypeId() {
		return pumpOperationTypeId;
	}
	public void setPumpOperationTypeId(Integer pumpOperationTypeId) {
		this.pumpOperationTypeId = pumpOperationTypeId;
	}
	public String getPumpOperationType() {
		return pumpOperationType;
	}
	public void setPumpOperationType(String pumpOperationType) {
		this.pumpOperationType = pumpOperationType;
	}
	public Integer getPumpOperationSequence() {
		return pumpOperationSequence;
	}
	public void setPumpOperationSequence(Integer pumpOperationSequence) {
		this.pumpOperationSequence = pumpOperationSequence;
	}
	public Integer getPumpOPerationParentId() {
		return pumpOPerationParentId;
	}
	public void setPumpOPerationParentId(Integer pumpOPerationParentId) {
		this.pumpOPerationParentId = pumpOPerationParentId;
	}
	
	
	
	
	

}
