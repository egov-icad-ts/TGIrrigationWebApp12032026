package in.ts.icad.leagal.model;

import java.math.BigDecimal;
import java.util.List;

public class mkAdminSanctionData {
	
	private String phase;  
		
	private String tank_id;
	
	private Double go_amount;
	
	private String go_number;
	
	private String go_issued_date;
	
	private Double admin_amount;
	
	private Double admin_amountLakhs;
	
	
	private List<mkAdminSanctionData>   mkAdminSanctionData ;
	
	
	
	
	
	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getTank_id() {
		return tank_id;
	}

	public void setTank_id(String tank_id) {
		this.tank_id = tank_id;
	}

	public Double getGo_amount() {
		return go_amount;
	}

	public void setGo_amount(Double go_amount) {
		this.go_amount = go_amount;
	}

	public String getGo_number() {
		return go_number;
	}

	public void setGo_number(String go_number) {
		this.go_number = go_number;
	}

	public String getGo_issued_date() {
		return go_issued_date;
	}

	public void setGo_issued_date(String go_issued_date) {
		this.go_issued_date = go_issued_date;
	}

	public Double getAdmin_amount() {
		return admin_amount;
	}

	public void setAdmin_amount(Double admin_amount) {
		this.admin_amount = admin_amount;
	}

	public Double getAdmin_amountLakhs() {
		return admin_amountLakhs;
	}

	public void setAdmin_amountLakhs(Double admin_amountLakhs) {
		this.admin_amountLakhs = admin_amountLakhs;
	}

	public List<mkAdminSanctionData> getMkAdminSanctionData() {
		return mkAdminSanctionData;
	}

	public void setMkAdminSanctionData(List<mkAdminSanctionData> mkAdminSanctionData) {
		this.mkAdminSanctionData = mkAdminSanctionData;
	}

	@Override
	public String toString() {
		return "mkAdminSanctionData [phase=" + phase + ", tank_id=" + tank_id + ", go_amount=" + go_amount
				+ ", go_number=" + go_number + ", go_issued_date=" + go_issued_date + ", admin_amount=" + admin_amount
				+ ", mkAdminSanctionData=" + mkAdminSanctionData + "]";
	}
	
	
	
	
	
	

}
