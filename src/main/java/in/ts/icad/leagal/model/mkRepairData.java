package in.ts.icad.leagal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class mkRepairData {
	@XmlElement	private String unit_name;
	@XmlElement	private String approved_boq_id;
	
	@XmlElement	private String boq_sr_item_number;
	
	@XmlElement	private String quantity;
	
	@XmlElement	private String typeofwork;
	
	@XmlElement	private String itemtypeid;  
	
	@XmlElement	private String item_name;
	
	@XmlElement	private String work_done_quantity;
	
	
	
	
	@XmlElement private String rate_per_unit;
	
	@XmlElement	private String customized_description;
	
	
	@XmlElement	private List<mkRepairData>   mkRepairData ;
	
	private String work_id;
	
	private String unit_id;
	
	
	
	
	
	
	
	
	
	

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}

	public String getWork_id() {
		return work_id;
	}

	public void setWork_id(String work_id) {
		this.work_id = work_id;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getApproved_boq_id() {
		return approved_boq_id;
	}

	public void setApproved_boq_id(String approved_boq_id) {
		this.approved_boq_id = approved_boq_id;
	}

	public String getBoq_sr_item_number() {
		return boq_sr_item_number;
	}

	public void setBoq_sr_item_number(String boq_sr_item_number) {
		this.boq_sr_item_number = boq_sr_item_number;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTypeofwork() {
		return typeofwork;
	}

	public void setTypeofwork(String typeofwork) {
		this.typeofwork = typeofwork;
	}

	public String getItemtypeid() {
		return itemtypeid;
	}

	public void setItemtypeid(String itemtypeid) {
		this.itemtypeid = itemtypeid;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getWork_done_quantity() {
		return work_done_quantity;
	}

	public void setWork_done_quantity(String work_done_quantity) {
		this.work_done_quantity = work_done_quantity;
	}

	
	public String getRate_per_unit() {
		return rate_per_unit;
	}

	public void setRate_per_unit(String rate_per_unit) {
		this.rate_per_unit = rate_per_unit;
	}

	public String getCustomized_description() {
		return customized_description;
	}

	public void setCustomized_description(String customized_description) {
		this.customized_description = customized_description;
	}

	public List<mkRepairData> getMkRepairData() {
		return mkRepairData;
	}

	public void setMkRepairData(List<mkRepairData> mkRepairData) {
		this.mkRepairData = mkRepairData;
	}

	@Override
	public String toString() {
		return "mkRepairData [unit_name=" + unit_name + ", approved_boq_id=" + approved_boq_id + ", boq_sr_item_number="
				+ boq_sr_item_number + ", quantity=" + quantity + ", typeofwork=" + typeofwork + ", itemtypeid="
				+ itemtypeid + ", item_name=" + item_name + ", work_done_quantity=" + work_done_quantity + ", unit_id="
				+ unit_id + ", rate_per_unit=" + rate_per_unit + ", customized_description=" + customized_description
				+ ", mkRepairData=" + mkRepairData + "]";
	}
	

	
	
	
}
