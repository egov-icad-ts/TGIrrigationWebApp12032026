package in.ts.icad.leagal.model;

public class PumpOperationInstructions {
	
	private Integer pumpInstructId;
	
	private String pumpInstruction;
	
	private Integer pumpInstructType;
	
	private Integer  pumpInstructSeq;

	public Integer getPumpInstructId() {
		return pumpInstructId;
	}

	public void setPumpInstructId(Integer pumpInstructId) {
		this.pumpInstructId = pumpInstructId;
	}

	public String getPumpInstruction() {
		return pumpInstruction;
	}

	public void setPumpInstruction(String pumpInstruction) {
		this.pumpInstruction = pumpInstruction;
	}

	public Integer getPumpInstructType() {
		return pumpInstructType;
	}

	public void setPumpInstructType(Integer pumpInstructType) {
		this.pumpInstructType = pumpInstructType;
	}

	public Integer getPumpInstructSeq() {
		return pumpInstructSeq;
	}

	public void setPumpInstructSeq(Integer pumpInstructSeq) {
		this.pumpInstructSeq = pumpInstructSeq;
	}

	@Override
	public String toString() {
		return "PumpOperationInstructions [pumpInstructId=" + pumpInstructId + ", pumpInstruction=" + pumpInstruction
				+ ", pumpInstructType=" + pumpInstructType + ", pumpInstructSeq=" + pumpInstructSeq + "]";
	}
	
	
	
	
	
	

}
