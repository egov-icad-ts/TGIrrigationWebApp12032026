package in.ts.icad.leagal.model;

public class ReservoirAyacut {
	
	private String ayacutreservoirId;
	
	private Integer ayacutsluiceId;
	
	private Double ayacutContemplated;
	
	private String resCode;
	
	private String resName;
	
	private String ayacutSluice;
	
	private Integer userId;
	
	private String userName;
	private Integer resAyacutId;
	
	
	
	public Integer getResAyacutId() {
		return resAyacutId;
	}

	public void setResAyacutId(Integer resAyacutId) {
		this.resAyacutId = resAyacutId;
	}

	private String resRegulatorCode;
	private String resRegulatorName;

	public String getResRegulatorCode() {
		return resRegulatorCode;
	}

	public void setResRegulatorCode(String resRegulatorCode) {
		this.resRegulatorCode = resRegulatorCode;
	}

	public String getResRegulatorName() {
		return resRegulatorName;
	}

	public void setResRegulatorName(String resRegulatorName) {
		this.resRegulatorName = resRegulatorName;
	}

	public String getAyacutreservoirId() {
		return ayacutreservoirId;
	}

	public void setAyacutreservoirId(String ayacutreservoirId) {
		this.ayacutreservoirId = ayacutreservoirId;
	}

	public Integer getAyacutsluiceId() {
		return ayacutsluiceId;
	}

	public void setAyacutsluiceId(Integer ayacutsluiceId) {
		this.ayacutsluiceId = ayacutsluiceId;
	}

	public Double getAyacutContemplated() {
		return ayacutContemplated;
	}

	public void setAyacutContemplated(Double ayacutContemplated) {
		this.ayacutContemplated = ayacutContemplated;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getAyacutSluice() {
		return ayacutSluice;
	}

	public void setAyacutSluice(String ayacutSluice) {
		this.ayacutSluice = ayacutSluice;
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
		return "ReservoirAyacut [ayacutreservoirId=" + ayacutreservoirId + ", ayacutsluiceId=" + ayacutsluiceId
				+ ", ayacutContemplated=" + ayacutContemplated + ", resCode=" + resCode + ", resName=" + resName
				+ ", ayacutSluice=" + ayacutSluice + ", userId=" + userId + ", userName=" + userName + ", resAyacutId="
				+ resAyacutId + ", resRegulatorCode=" + resRegulatorCode + ", resRegulatorName=" + resRegulatorName
				+ "]";
	}
	
	
	

}
