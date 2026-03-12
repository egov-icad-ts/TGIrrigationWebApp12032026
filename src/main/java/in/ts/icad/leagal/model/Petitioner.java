package in.ts.icad.leagal.model;

public class Petitioner {
	
	private Integer petitionerId;
	
	private String petitionerName;
	
	private String petitionerAddress;
	
	private Integer districtId;
	private Integer mandalId;
	private Integer villageId;

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getMandalId() {
		return mandalId;
	}

	public void setMandalId(Integer mandalId) {
		this.mandalId = mandalId;
	}

	public Integer getVillageId() {
		return villageId;
	}

	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}

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

	public String getPetitionerAddress() {
		return petitionerAddress;
	}

	public void setPetitionerAddress(String petitionerAddress) {
		this.petitionerAddress = petitionerAddress;
	}

}
