package in.ts.icad.leagal.model;

import java.util.ArrayList;
import java.util.List;

public class CasesListWrapper {
	
	private List<Cases> casesList = new ArrayList<Cases>();
	/*private List<ComponentWorkQty> componentQtys = new ArrayList<ComponentWorkQty>();
	private List<ComponentWorkProgress> compsWorkProgress = new ArrayList<ComponentWorkProgress>();
	private List<EeApproveReq> eeaprList = new ArrayList<EeApproveReq>();
	private List<Canal> canal = new ArrayList<Canal>();
	private List<LAStructures> lastructure = new ArrayList<LAStructures>();
	private List<OwnerDetails> odList = new ArrayList<OwnerDetails>();
	private List<ProjectIP> ipList = new ArrayList<ProjectIP>();
	private List<DeeAcqTemp> deeAcqReqs = new ArrayList<DeeAcqTemp>();*/

	public List<Cases> getCasesList() {
		return casesList;
	}

	public void setCasesList(List<Cases> casesList) {
		this.casesList = casesList;
	}
	
	

}
