package in.ts.icad.leagal.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ParaDocuments {
	
	private Integer paraId;
	private String paraDocName;
	private String paraDocLocation;
	private String paraDocOriginalName;
	public Integer getUserId() {
		return userId;
	}
	private Integer  userId;
	private Integer docId;
	
	private Integer cagGistId;
	private Integer cagParaId;
	
	private String userName;
	
	private Integer updateduserId;
	private String updateduserName;
	
	private Integer unitId;
	private String unitName;
	
	
	private Integer subParaId;
	
	private String doctitle;
	
	private String docdate;
	
	
	
	
	
	
	public String getDoctitle() {
		return doctitle;
	}
	public void setDoctitle(String doctitle) {
		this.doctitle = doctitle;
	}
	public String getDocdate() {
		return docdate;
	}
	public void setDocdate(String docdate) {
		this.docdate = docdate;
	}
	public Integer getSubParaId() {
		return subParaId;
	}
	public void setSubParaId(Integer subParaId) {
		this.subParaId = subParaId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getCagGistId() {
		return cagGistId;
	}
	public void setCagGistId(Integer cagGistId) {
		this.cagGistId = cagGistId;
	}
	public Integer getCagParaId() {
		return cagParaId;
	}
	public void setCagParaId(Integer cagParaId) {
		this.cagParaId = cagParaId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUpdateduserId() {
		return updateduserId;
	}
	public void setUpdateduserId(Integer updateduserId) {
		this.updateduserId = updateduserId;
	}
	public String getUpdateduserName() {
		return updateduserName;
	}
	public void setUpdateduserName(String updateduserName) {
		this.updateduserName = updateduserName;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	private List<MultipartFile> paraFile;
	
	
	
	public Integer getParaId() {
		return paraId;
	}
	public void setParaId(Integer paraId) {
		this.paraId = paraId;
	}
	public List<MultipartFile> getParaFile() {
		return paraFile;
	}
	public void setParaFile(List<MultipartFile> paraFile) {
		this.paraFile = paraFile;
	}
	public String getParaDocName() {
		return paraDocName;
	}
	public void setParaDocName(String paraDocName) {
		this.paraDocName = paraDocName;
	}
	public String getParaDocLocation() {
		return paraDocLocation;
	}
	public void setParaDocLocation(String paraDocLocation) {
		this.paraDocLocation = paraDocLocation;
	}
	public String getParaDocOriginalName() {
		return paraDocOriginalName;
	}
	public void setParaDocOriginalName(String paraDocOriginalName) {
		this.paraDocOriginalName = paraDocOriginalName;
	}
	
	
	

}
