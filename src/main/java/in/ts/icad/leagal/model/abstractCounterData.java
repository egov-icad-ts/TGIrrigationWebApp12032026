package in.ts.icad.leagal.model;

public class abstractCounterData {
	
	private Integer unitId;
	private String unitName;
	private Integer casesFiled;
	private Integer draftCountFile;
	private Integer caseGenId;
	private Integer courtId;
    private String courtName;
    private String categoryName;
    private Integer hiddencaseType;
    private Integer hiddencourtId;
    private String caseType;
    private Integer petitionerId;
    private String petitionerName;
    
    public Integer getPetitionerId() {
		return petitionerId;
	}

	public void setPetitionerId(Integer petitionerId) {
		this.petitionerId = petitionerId;
	}

	public String getPetitionerName() {
		return petitionerName;
	}

	public void setPetitionerName(String petitionerName) {
		this.petitionerName = petitionerName;
	}

	private Integer advocateId;
    
    private String  advocateName;
	
	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public Integer getHiddencourtId() {
		return hiddencourtId;
	}

	public void setHiddencourtId(Integer hiddencourtId) {
		this.hiddencourtId = hiddencourtId;
	}

	public Integer getHiddencaseType() {
		return hiddencaseType;
	}

	public void setHiddencaseType(Integer hiddencaseType) {
		this.hiddencaseType = hiddencaseType;
	}

	public Integer getCourtId() {
		return courtId;
	}

	public void setCourtId(Integer courtId) {
		this.courtId = courtId;
	}

	private Integer caseTypeId;
	public Integer getCaseTypeId() {
		return caseTypeId;
	}

	public void setCaseTypeId(Integer caseTypeId) {
		this.caseTypeId = caseTypeId;
	}

	public Integer getCaseGenId() {
		return caseGenId;
	}

	public void setCaseGenId(Integer caseGenId) {
		this.caseGenId = caseGenId;
	}

	public Integer getDraftCountFile() {
		return draftCountFile;
	}

	public void setDraftCountFile(Integer draftCountFile) {
		this.draftCountFile = draftCountFile;
	}

	private Integer  counterFiled;
	private Integer casesToFile;
	
	private Integer casesDirected;
	
	private Integer casesJudged;

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

	public Integer getCasesFiled() {
		return casesFiled;
	}

	public void setCasesFiled(Integer casesFiled) {
		this.casesFiled = casesFiled;
	}

	public Integer getCounterFiled() {
		return counterFiled;
	}

	public void setCounterFiled(Integer counterFiled) {
		this.counterFiled = counterFiled;
	}

	public Integer getCasesToFile() {
		return casesToFile;
	}

	public void setCasesToFile(Integer casesToFile) {
		this.casesToFile = casesToFile;
	}

	public Integer getAdvocateId() {
		return advocateId;
	}

	public void setAdvocateId(Integer advocateId) {
		this.advocateId = advocateId;
	}

	public String getAdvocateName() {
		return advocateName;
	}

	public void setAdvocateName(String advocateName) {
		this.advocateName = advocateName;
	}

	public Integer getCasesDirected() {
		return casesDirected;
	}

	public void setCasesDirected(Integer casesDirected) {
		this.casesDirected = casesDirected;
	}

	public Integer getCasesJudged() {
		return casesJudged;
	}

	public void setCasesJudged(Integer casesJudged) {
		this.casesJudged = casesJudged;
	}

	@Override
	public String toString() {
		return "abstractCounterData [unitId=" + unitId + ", unitName=" + unitName + ", casesFiled=" + casesFiled
				+ ", counterFiled=" + counterFiled + ", casesToFile=" + casesToFile + ", casesDirected=" + casesDirected
				+ ", casesJudged=" + casesJudged + "]";
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
