package edu.mass.doe.cap.dataservice.pojo;

public class SupervisorInfo {
	private Long assignmentId;
	 public Long getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}
	 private Long daPersonId;
	 private String userId = "";
	 private String name;
	 private String firstName;
	 private String lastName;
	 private String middleName;
	 private Long mepid;
	 private String districtOrgCode;
	 private String districtName;
	 private Long districtOrgId;
	 private Long districtOrgTypeId;	 
	 private String schoolOrgCode;
	 private String schoolName;
	 private Long schoolOrgId;
	 private String state;
	 private String email;
	 private String confirmEmail;
	 private boolean outOfStatePractitioner=false;
	 private SupervisorInfo previousPractitioner;
	 private String spName;
	 private String spPersonIdString;
	 private Long personId;
	 private String pwd;
	 private  boolean emailExist;
	 private boolean displaySupervisorInfo;
	 
	public SupervisorInfo getPreviousPractitioner() {
		return previousPractitioner;
	}
	public void setPreviousPractitioner(SupervisorInfo previousPractitioner) {
		this.previousPractitioner = previousPractitioner;
	}
	public boolean isOutOfStatePractitioner() {
		return outOfStatePractitioner;
	}
	public void setOutOfStatePractitioner(boolean outOfStatePractitioner) {
		this.outOfStatePractitioner = outOfStatePractitioner;
	}
	public Long getDaPersonId() {
		return daPersonId;
	}
	public void setDaPersonId(Long daPersonId) {
		this.daPersonId = daPersonId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserID(String userID) {
		this.userId = userID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMepid() {
		return mepid;
	}
	public void setMepid(Long mepid) {
		this.mepid = mepid;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDistrictOrgCode() {
		return districtOrgCode;
	}
	public void setDistrictOrgCode(String districtOrgCode) {
		this.districtOrgCode = districtOrgCode;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	public String getSchoolOrgCode() {
		return schoolOrgCode;
	}
	public void setSchoolOrgCode(String schoolOrgCode) {
		this.schoolOrgCode = schoolOrgCode;
	}
	public Long getSchoolOrgId() {
		return schoolOrgId;
	}
	public void setSchoolOrgId(Long schoolOrgId) {
		this.schoolOrgId = schoolOrgId;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getConfirmEmail() {
		return confirmEmail;
	}
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
	public Long getDistrictOrgId() {
		return districtOrgId;
	}
	public void setDistrictOrgId(Long districtOrgId) {
		this.districtOrgId = districtOrgId;
	}
	public Long getDistrictOrgTypeId() {
		return districtOrgTypeId;
	}
	public void setDistrictOrgTypeId(Long districtOrgTypeId) {
		this.districtOrgTypeId = districtOrgTypeId;
	}
	
	public String getSpName() {
		return spName;
	}
	public void setSpName(String sName) {
		this.spName = sName;
	}
	
	public String getSpPersonIdString() {
		return spPersonIdString;
	}
	public void setSpPersonIdString(String spPIdString) {
		this.spPersonIdString = spPIdString;
	}
	
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long daPersonId) {
		this.personId = daPersonId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isEmailExist() {
		return emailExist;
	}
	public void setEmailExist(boolean emailExist) {
		this.emailExist = emailExist;
	}
	public boolean isDisplaySupervisorInfo() {
		return displaySupervisorInfo;
	}
	public void setDisplaySupervisorInfo(boolean displaySupervisorInfo) {
		this.displaySupervisorInfo = displaySupervisorInfo;
	}
	
}
