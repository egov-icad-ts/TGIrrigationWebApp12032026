package in.ts.icad.leagal.model;

public class TaskPriority {

	  private Integer priorId;
	  
	  private String priorName;

	public Integer getPriorId() {
		return priorId;
	}

	public void setPriorId(Integer priorId) {
		this.priorId = priorId;
	}

	public String getPriorName() {
		return priorName;
	}

	public void setPriorName(String priorName) {
		this.priorName = priorName;
	}

	@Override
	public String toString() {
		return "TaskPriority [priorId=" + priorId + ", priorName=" + priorName + "]";
	}
}
