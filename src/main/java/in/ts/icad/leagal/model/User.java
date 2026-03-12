package in.ts.icad.leagal.model;

import java.sql.Date;
import java.util.List;

public class User {
	
	private String userEmpId;
	
	public String getUserEmpId() {
		return userEmpId;
	}

	public void setUserEmpId(String userEmpId) {
		this.userEmpId = userEmpId;
	}

	private String userName;
	private String password;
	private Integer empId;
	private Integer roleId;
	private Integer designationId;
	private String postId;
	private Integer unitId;
	private Integer circleId;
	private Integer divisionId;
	private Integer subdivisionId;
	private Integer sectionId;
	private Integer projectId;
	private Integer userId;
	private String employeeName;
	private Integer laoId;
	private String laoDistrict;
	private String laoMandal;
	private String divisionName;
	
	private String  unitName ;
	private String circleName;
	
	private String subdivisionName;
	private String sectionName;
	private Integer packageId;
	
	
	  private String captcha;
	  
	  private String oldPassword;
	  private String newPassword;
	  
	  private String email;
	  private String phoneno;
	  
	  private Long phone;
	  
	  private Long post;
	  
	  private String access;  
	  
	  private Boolean addtnlCharge;
	  
	  private Integer userCategory;
	  
	  private String odType;
	  
	  private Date logouttime;
	  
      private String remarks;
      
      
	  
	
	

	

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(Date logouttime) {
		this.logouttime = logouttime;
	}

	public String getOdType() {
		return odType;
	}

	public void setOdType(String odType) {
		this.odType = odType;
	}

	public Integer getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(Integer userCategory) {
		this.userCategory = userCategory;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public Long getPost() {
		return post;
	}

	public void setPost(Long post) {
		this.post = post;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	

	@Override
	public String toString() {
		return "User [userEmpId=" + userEmpId + ", userName=" + userName + ", password=" + password + ", empId=" + empId
				+ ", roleId=" + roleId + ", designationId=" + designationId + ", postId=" + postId + ", unitId="
				+ unitId + ", circleId=" + circleId + ", divisionId=" + divisionId + ", subdivisionId=" + subdivisionId
				+ ", sectionId=" + sectionId + ", projectId=" + projectId + ", userId=" + userId + ", employeeName="
				+ employeeName + ", laoId=" + laoId + ", laoDistrict=" + laoDistrict + ", laoMandal=" + laoMandal
				+ ", divisionName=" + divisionName + ", unitName=" + unitName + ", circleName=" + circleName
				+ ", subdivisionName=" + subdivisionName + ", sectionName=" + sectionName + ", packageId=" + packageId
				+ ", captcha=" + captcha + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword + ", email="
				+ email + ", phoneno=" + phoneno + ", phone=" + phone + ", post=" + post + ", access=" + access
				+ ", addtnlCharge=" + addtnlCharge + ", userDesc=" + userDesc + ", designationName=" + designationName
				+ "]";
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	private String userDesc;
	
	
	
	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	private String designationName;
	
	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getSubdivisionName() {
		return subdivisionName;
	}

	public void setSubdivisionName(String subdivisionName) {
		this.subdivisionName = subdivisionName;
	}

	

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public Integer getLaoId() {
		return laoId;
	}

	public void setLaoId(Integer laoId) {
		this.laoId = laoId;
	}

	public String getLaoDistrict() {
		return laoDistrict;
	}

	public void setLaoDistrict(String laoDistrict) {
		this.laoDistrict = laoDistrict;
	}

	public String getLaoMandal() {
		return laoMandal;
	}

	public void setLaoMandal(String laoMandal) {
		this.laoMandal = laoMandal;
	}


	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getCircleId() {
		return circleId;
	}

	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}

	public Integer getSubdivisionId() {
		return subdivisionId;
	}

	public void setSubdivisionId(Integer subdivisionId) {
		this.subdivisionId = subdivisionId;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public Boolean getAddtnlCharge() {
		return addtnlCharge;
	}

	public void setAddtnlCharge(Boolean addtnlCharge) {
		this.addtnlCharge = addtnlCharge;
	}

	

	
	
	
}
