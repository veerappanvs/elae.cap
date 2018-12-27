package edu.mass.doe.cap.dataservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class CapCycleInfo {
	
	private Long cycleId;
	
	private String candidateFirstName;
	private String candidateLastName;
	private String candidateMiddleName;
	private String candidateName;
	private Long candidateMEPID;
	private Long candidatePersonId;
	
	
	private String supervisorFirstName;
	private String supervisorLastName;
	private String supervisorMiddleName;
	private String supervisorName;
	private Long supervisorMEPID;
	private Long supervisorPersonId;
	
	
	private SupervisorInfo supervisor;
	
	
	private SupervisorInfo practitioner;
	private SupervisorInfo origPractitioner;

	private List<SupervisorInfo> practitioners=new ArrayList<SupervisorInfo>();
	
	
	private String programName;
	private Long programId;
	
	private Date startDate;
	private Date cycleCloseDate;
	private Integer schoolYear;	
	
	private String practitionerInputMEPID;
	
	private Long orgId;	
	
	private String orgCode;	
	
	private Character waived;
		
	private String practicumTypeCode;
	
	private String practicumTypeDesc;
	
	private String statusReasonTypeCode;
	
	private String programAreaGradLevel;

	private String courseTitle;

	private String courseNumber;
	
	private String gradLevel;
	
	private Integer hours;
	
	private String hoursFullResponsibility;
	
	private String practicumHours;
	
	private String creditHours;
	
	private Character readyToTeach;

	private String selfAssessment;
	private String announcedObs1;
	private String goalPlan;
	private String unAnnouncedObs1;
	private String announcedObs2;
	private String formativeAssessment;
	private String unAnnouncedObs2;
	private String summativeAssessment;
	private Date latestActDate;
	private String cycleStatus;
	private String cycleStatusCode;
	private String practicumSchoolName;
	
	private String incompleteWorksString;
	
	private String reOpenCycleFlag;

	private Date reOpenDate;
	private Date endDate;
	
	private String autoCloseIndictor;
	
	private Date autoCloseFirstEmailDate;
	
	private Date autoCloseEmailDate;
	
	
	private List<CapManagerInfo> managers=new ArrayList<CapManagerInfo>();
	
	
	
	public Long getCycleId() {
		return cycleId;
	}

	public void setCycleId(Long cycleId) {
		this.cycleId = cycleId;
	}

	public String getCandidateFirstName() {
		return candidateFirstName;
	}

	public void setCandidateFirstName(String candidateFirstName) {
		this.candidateFirstName = candidateFirstName;
	}



	public String getCandidateLastName() {
		return candidateLastName;
	}



	public void setCandidateLastName(String candidateLastName) {
		this.candidateLastName = candidateLastName;
	}



	public String getCandidateMiddleName() {
		return candidateMiddleName;
	}



	public void setCandidateMiddleName(String candidateMiddleName) {
		this.candidateMiddleName = candidateMiddleName;
	}



	public Long getCandidateMEPID() {
		return candidateMEPID;
	}



	public void setCandidateMEPID(Long candidateMEPID) {
		this.candidateMEPID = candidateMEPID;
	}



	public Long getCandidatePersonId() {
		return candidatePersonId;
	}



	public void setCandidatePersonId(Long candidatePersonId) {
		this.candidatePersonId = candidatePersonId;
	}



	public String getSupervisorFirstName() {
		return supervisorFirstName;
	}



	public void setSupervisorFirstName(String supervisorFirstName) {
		this.supervisorFirstName = supervisorFirstName;
	}



	public String getSupervisorLastName() {
		return supervisorLastName;
	}



	public void setSupervisorLastName(String supervisorLastName) {
		this.supervisorLastName = supervisorLastName;
	}



	public String getSupervisorMiddleName() {
		return supervisorMiddleName;
	}



	public void setSupervisorMiddleName(String supervisorMiddleName) {
		this.supervisorMiddleName = supervisorMiddleName;
	}



	public Long getSupervisorMEPID() {
		return supervisorMEPID;
	}



	public void setSupervisorMEPID(Long supervisorMEPID) {
		this.supervisorMEPID = supervisorMEPID;
	}



	public Long getSupervisorPersonId() {
		return supervisorPersonId;
	}



	public void setSupervisorPersonId(Long supervisorPersonId) {
		this.supervisorPersonId = supervisorPersonId;
	}



	public SupervisorInfo getPractitioner() {
		return practitioner;
	}



	public void setPractitioner(SupervisorInfo practitioner) {
		this.practitioner = practitioner;
	}



	public String getProgramName() {
		return programName;
	}



	public void setProgramName(String programName) {
		this.programName = programName;
	}



	public Long getProgramId() {
		return programId;
	}



	public void setProgramId(Long programId) {
		this.programId = programId;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Integer getSchoolYear() {
		return schoolYear;
	}



	public void setSchoolYear(Integer schoolYear) {
		this.schoolYear = schoolYear;
	}



	public Character getWaived() {
		return waived;
	}



	public void setWaived(Character waived) {
		this.waived = waived;
	}



	public String getPracticumTypeCode() {
		return practicumTypeCode;
	}



	public void setPracticumTypeCode(String practicumTypeCode) {
		this.practicumTypeCode = practicumTypeCode;
	}


	public String getStatusReasonTypeCode() {
		return statusReasonTypeCode;
	}



	public void setStatusReasonTypeCode(String statusReasonTypeCode) {
		this.statusReasonTypeCode = statusReasonTypeCode;
	}


	public String getpractitionerInputMEPID() {
		return practitionerInputMEPID;
	}



	public void setpractitionerInputMEPID(String practitionerInputMEPID) {
		this.practitionerInputMEPID = practitionerInputMEPID;
	}



	public String getPractitionerInputMEPID() {
		return practitionerInputMEPID;
	}



	public void setPractitionerInputMEPID(String practitionerInputMEPID) {
		this.practitionerInputMEPID = practitionerInputMEPID;
	}



	public Long getOrgId() {
		return orgId;
	}



	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}



	public SupervisorInfo getOrigPractitioner() {
		return origPractitioner;
	}



	public void setOrigPractitioner(SupervisorInfo origPractitioner) {
		this.origPractitioner = origPractitioner;
	}



	public String getProgramAreaGradLevel() {
		return programAreaGradLevel;
	}



	public void setProgramAreaGradLevel(String programAreaGradLevel) {
		this.programAreaGradLevel = programAreaGradLevel;
	}



	public String getCourseTitle() {
		return courseTitle;
	}



	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}



	public String getCourseNumber() {
		return courseNumber;
	}



	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}



	public String getGradLevel() {
		return gradLevel;
	}



	public void setGradLevel(String gradLevel) {
		this.gradLevel = gradLevel;
	}



	public Integer getHours() {
		return hours;
	}



	public void setHours(Integer hours) {
		this.hours = hours;
	}



	public String getHoursFullResponsibility() {
		return hoursFullResponsibility;
	}



	public void setHoursFullResponsibility(String hoursFullResponsibility) {
		this.hoursFullResponsibility = hoursFullResponsibility;
	}



	public String getCreditHours() {
		return creditHours;
	}



	public void setCreditHours(String creditHours) {
		this.creditHours = creditHours;
	}



	public String getPracticumHours() {
		return practicumHours;
	}



	public void setPracticumHours(String practicumHours) {
		this.practicumHours = practicumHours;
	}



	public List<SupervisorInfo> getPractitioners() {
		return practitioners;
	}



	public void setPractitioners(List<SupervisorInfo> practitioners) {
		this.practitioners = practitioners;
	}

	public SupervisorInfo getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(SupervisorInfo supervisor) {
		this.supervisor = supervisor;
	}



	public Character getReadyToTeach() {
		return readyToTeach;
	}



	public void setReadyToTeach(Character readyToTeach) {
		this.readyToTeach = readyToTeach;
	} 
	
	////////////////////
	public String getSelfAssessment() {
		return selfAssessment;
	}

	public void setSelfAssessment(String sa) {
		this.selfAssessment = sa;
	}
	
	public String getAnnouncedObs1() {
		return announcedObs1;
	}

	public void setAnnouncedObs1(String aobs1) {
		this.announcedObs1 = aobs1;
	}
	
	public String getGoalPlan() {
		return goalPlan;
	}

	public void setGoalPlan(String gp) {
		this.goalPlan = gp;
	}
	
	public String getUnAnnouncedObs1() {
		return unAnnouncedObs1;
	}

	public void setUnAnnouncedObs1(String uaobs1) {
		this.unAnnouncedObs1 = uaobs1;
	}
	
	public String getAnnouncedObs2() {
		return announcedObs2;
	}

	public void setAnnouncedObs2(String aobs2) {
		this.announcedObs2 = aobs2;
	}
	
	public String getFormativeAssessment() {
		return formativeAssessment;
	}

	public void setFormativeAssessment(String fa) {
		this.formativeAssessment = fa;
	}
		
	public String getUnAnnouncedObs2() {
		return unAnnouncedObs2;
	}

	public void setUnAnnouncedObs2(String uaobs2) {
		this.unAnnouncedObs2 = uaobs2;
	}
	
	public String getSummativeAssessment() {
		return summativeAssessment;
	}

	public void setSummativeAssessment(String sa) {
		this.summativeAssessment = sa;
	}
	
	public Date getLatestActDate() {
		return  latestActDate;
	}

	public void setLatestActDate(Date laDate) {
		this.latestActDate = laDate;
	}
	
	public String getCycleStatus() {
		return cycleStatus;
	}

	public void setCycleStatus(String cs) {
		this.cycleStatus = cs;
	}
	
	public String getPracticumSchoolName() {
		return practicumSchoolName;
	}

	public void setPracticumSchoolName(String practicumSchool) {
		this.practicumSchoolName = practicumSchool;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getCycleStatusCode() {
		return cycleStatusCode;
	}

	public void setCycleStatusCode(String cycleStatusCode) {
		this.cycleStatusCode = cycleStatusCode;
	}
	public Date getCycleCloseDate() {
		return cycleCloseDate;
	}

	public void setCycleCloseDate(Date cycleCloseDate) {
		this.cycleCloseDate = cycleCloseDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date eDate) {
		this.endDate = eDate;
	}
	
	public String getIncompleteWorksString() {
		return incompleteWorksString;
	}

	public void setIncompleteWorksString(String incompleteWorksString) {
		this.incompleteWorksString = incompleteWorksString;
	}

	public String getPracticumTypeDesc() {
		return practicumTypeDesc;
	}

	public void setPracticumTypeDesc(String practicumTypeDesc) {
		this.practicumTypeDesc = practicumTypeDesc;
	}
	
	public String getReOpenCycleFlag() {
		return reOpenCycleFlag;
	}
	
	public void setReOpenCycleFlag(String rocf) {
		this.reOpenCycleFlag = rocf;
	}
	
	public Date getReOpenDate() {
		return reOpenDate;
	}

	public void setReOpenDate(Date reopenDate) {
		this.reOpenDate = reopenDate;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getAutoCloseIndictor() {
		return autoCloseIndictor;
	}

	public void setAutoCloseIndictor(String autoCloseIndictor) {
		this.autoCloseIndictor = autoCloseIndictor;
	}

	public Date getAutoCloseFirstEmailDate() {
		return autoCloseFirstEmailDate;
	}

	public void setAutoCloseFirstEmailDate(Date autoCloseFirstEmailDate) {
		this.autoCloseFirstEmailDate = autoCloseFirstEmailDate;
	}

	public Date getAutoCloseEmailDate() {
		return autoCloseEmailDate;
	}

	public void setAutoCloseEmailDate(Date autoCloseEmailDate) {
		this.autoCloseEmailDate = autoCloseEmailDate;
	}

	public List<CapManagerInfo> getManagers() {
		return managers;
	}

	public void setManagers(List<CapManagerInfo> managers) {
		this.managers = managers;
	}
}
