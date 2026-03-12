package in.ts.icad.leagal.model;

public class PumpCommonData {
	
	private Integer pumpCommonDataId;
	private String pumpCommonDataItem;
	private Integer pumpCommonDataItemType;
	private String pumpCommonDataShortForm;
	public Integer getPumpCommonDataId() {
		return pumpCommonDataId;
	}
	public void setPumpCommonDataId(Integer pumpCommonDataId) {
		this.pumpCommonDataId = pumpCommonDataId;
	}
	public String getPumpCommonDataItem() {
		return pumpCommonDataItem;
	}
	public void setPumpCommonDataItem(String pumpCommonDataItem) {
		this.pumpCommonDataItem = pumpCommonDataItem;
	}
	public Integer getPumpCommonDataItemType() {
		return pumpCommonDataItemType;
	}
	public void setPumpCommonDataItemType(Integer pumpCommonDataItemType) {
		this.pumpCommonDataItemType = pumpCommonDataItemType;
	}
	public String getPumpCommonDataShortForm() {
		return pumpCommonDataShortForm;
	}
	public void setPumpCommonDataShortForm(String pumpCommonDataShortForm) {
		this.pumpCommonDataShortForm = pumpCommonDataShortForm;
	}
	@Override
	public String toString() {
		return "PumpCommonData [pumpCommonDataId=" + pumpCommonDataId + ", pumpCommonDataItem=" + pumpCommonDataItem
				+ ", pumpCommonDataItemType=" + pumpCommonDataItemType + ", pumpCommonDataShortForm="
				+ pumpCommonDataShortForm + "]";
	}
	

}
