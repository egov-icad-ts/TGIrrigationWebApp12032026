package in.ts.icad.leagal.model;

public class MstOutputWithFlag {
	
	private Integer mstNewId;
	
	private Integer mstOldId;
	
	private Integer formdataId;
	
	private Integer oldformdataId;

	
	
	

	public Integer getOldformdataId() {
		return oldformdataId;
	}

	public void setOldformdataId(Integer oldformdataId) {
		this.oldformdataId = oldformdataId;
	}

	public Integer getFormdataId() {
		return formdataId;
	}

	public void setFormdataId(Integer formdataId) {
		this.formdataId = formdataId;
	}

	public Integer getMstNewId() {
		return mstNewId;
	}

	public void setMstNewId(Integer mstNewId) {
		this.mstNewId = mstNewId;
	}

	public Integer getMstOldId() {
		return mstOldId;
	}

	public void setMstOldId(Integer mstOldId) {
		this.mstOldId = mstOldId;
	}

	@Override
	public String toString() {
		return "MstOutputWithFlag [mstNewId=" + mstNewId + ", mstOldId=" + mstOldId + "]";
	}
	
	
	
	

}
