package in.ts.icad.leagal.model;

public class PumpPumpsData {
	
	private Integer pumpdataId;
	private String pumpDataItem;
	private Integer pumpDataItemType;
	private String pumpDataShortForm;
	public Integer getPumpdataId() {
		return pumpdataId;
	}
	public void setPumpdataId(Integer pumpdataId) {
		this.pumpdataId = pumpdataId;
	}
	public String getPumpDataItem() {
		return pumpDataItem;
	}
	public void setPumpDataItem(String pumpDataItem) {
		this.pumpDataItem = pumpDataItem;
	}
	public Integer getPumpDataItemType() {
		return pumpDataItemType;
	}
	public void setPumpDataItemType(Integer pumpDataItemType) {
		this.pumpDataItemType = pumpDataItemType;
	}
	public String getPumpDataShortForm() {
		return pumpDataShortForm;
	}
	public void setPumpDataShortForm(String pumpDataShortForm) {
		this.pumpDataShortForm = pumpDataShortForm;
	}
	@Override
	public String toString() {
		return "PumpPumpsData [pumpdataId=" + pumpdataId + ", pumpDataItem=" + pumpDataItem + ", pumpDataItemType="
				+ pumpDataItemType + ", pumpDataShortForm=" + pumpDataShortForm + "]";
	}
	
	

}
