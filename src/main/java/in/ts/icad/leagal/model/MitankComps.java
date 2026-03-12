package in.ts.icad.leagal.model;

public class MitankComps {
	
	
	private Integer miCompId;
	private String miCompName;
	private Integer miparentId;
	private Boolean hasChild;
	public Boolean getHasChild() {
		return hasChild;
	}
	public void setHasChild(Boolean hasChild) {
		this.hasChild = hasChild;
	}
	public Integer getMiCompId() {
		return miCompId;
	}
	public void setMiCompId(Integer miCompId) {
		this.miCompId = miCompId;
	}
	public String getMiCompName() {
		return miCompName;
	}
	public void setMiCompName(String miCompName) {
		this.miCompName = miCompName;
	}
	public Integer getMiparentId() {
		return miparentId;
	}
	public void setMiparentId(Integer miparentId) {
		this.miparentId = miparentId;
	}
	@Override
	public String toString() {
		return "MitankComps [miCompId=" + miCompId + ", miCompName=" + miCompName + ", miparentId=" + miparentId
				+ ", hasChild=" + hasChild + "]";
	}
	
	
	

}
