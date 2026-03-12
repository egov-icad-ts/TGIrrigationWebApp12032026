package in.ts.icad.leagal.model;

import java.math.BigDecimal;
import java.util.List;

public class mkAgmtData {
	private String work_id;
	
	private String agreement_type_id;
	
	private String premium_percentage;
	
	private String agreement_number;
	
	private String agreement_date;
	
	private String agency_name;
	
	private Double agreement_amount;
	
	private Double agreement_amountLakhs;
	
	
	
	
	public Double getAgreement_amount() {
		return agreement_amount;
	}

	public void setAgreement_amount(Double agreement_amount) {
		this.agreement_amount = agreement_amount;
	}

	public Double getAgreement_amountLakhs() {
		return agreement_amountLakhs;
	}

	public void setAgreement_amountLakhs(Double agreement_amountLakhs) {
		this.agreement_amountLakhs = agreement_amountLakhs;
	}

	public String getAgency_name() {
		return agency_name;
	}

	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}

	private List<mkAgmtData>   mkAgmtData ;
	
	
	

	public String getWork_id() {
		return work_id;
	}

	public void setWork_id(String work_id) {
		this.work_id = work_id;
	}

	public String getAgreement_type_id() {
		return agreement_type_id;
	}

	public void setAgreement_type_id(String agreement_type_id) {
		this.agreement_type_id = agreement_type_id;
	}

	public String getPremium_percentage() {
		return premium_percentage;
	}

	public void setPremium_percentage(String premium_percentage) {
		this.premium_percentage = premium_percentage;
	}

	public String getAgreement_number() {
		return agreement_number;
	}

	public void setAgreement_number(String agreement_number) {
		this.agreement_number = agreement_number;
	}

	public String getAgreement_date() {
		return agreement_date;
	}

	public void setAgreement_date(String agreement_date) {
		this.agreement_date = agreement_date;
	}

	public List<mkAgmtData> getMkAgmtData() {
		return mkAgmtData;
	}

	public void setMkAgmtData(List<mkAgmtData> mkAgmtData) {
		this.mkAgmtData = mkAgmtData;
	}

	@Override
	public String toString() {
		return "mkAgmtData [work_id=" + work_id + ", agreement_type_id=" + agreement_type_id + ", premium_percentage="
				+ premium_percentage + ", agreement_number=" + agreement_number + ", agreement_date=" + agreement_date
				+ "]";
	}
	
	
	
	

}
