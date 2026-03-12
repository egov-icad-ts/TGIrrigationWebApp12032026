package in.ts.icad.leagal.model;

public class ContactPerson {
	
	private Integer contactPid;
	
	private String contactPname;
	
	private String contactPhone1;
	private String contactPhone;
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public void setContactPname(String contactPname) {
		this.contactPname = contactPname;
	}
	private String contactPhone2;
	private String  contactEmail;
	private String  contactCaseId;
	@Override
	public String toString() {
		return "ContactPerson [contactPid=" + contactPid + ", cntactPname=" + contactPname + ", contactPhone1="
				+ contactPhone1 + ", contactPhone2=" + contactPhone2 + ", contactEmail=" + contactEmail
				+ ", contactCaseId=" + contactCaseId + ", contactAddress=" + contactAddress + "]";
	}
	private String contactAddress;
	public Integer getContactPid() {
		return contactPid;
	}
	public void setContactPid(Integer contactPid) {
		this.contactPid = contactPid;
	}
	public String getContactPname() {
		return contactPname;
	}
	public void setCntactPname(String contactPname) {
		this.contactPname = contactPname;
	}
	public String getContactPhone1() {
		return contactPhone1;
	}
	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}
	public String getContactPhone2() {
		return contactPhone2;
	}
	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactCaseId() {
		return contactCaseId;
	}
	public void setContactCaseId(String contactCaseId) {
		this.contactCaseId = contactCaseId;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	
	

}
