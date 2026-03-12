package in.ts.icad.leagal.model;

public class CaseHearingDates {
	
	private Integer caseDateHearId;
	
	private Integer caseId;
	
	private String hearingDate;
	
	private String userName;
	
	private Integer userid;

	public Integer getCaseDateHearId() {
		return caseDateHearId;
	}

	public void setCaseDateHearId(Integer caseDateHearId) {
		this.caseDateHearId = caseDateHearId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getHearingDate() {
		return hearingDate;
	}

	public void setHearingDate(String hearingDate) {
		this.hearingDate = hearingDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "CaseHearingDates [caseDateHearId=" + caseDateHearId + ", caseId=" + caseId + ", hearingDate="
				+ hearingDate + ", userName=" + userName + ", userid=" + userid + "]";
	}
	
}
