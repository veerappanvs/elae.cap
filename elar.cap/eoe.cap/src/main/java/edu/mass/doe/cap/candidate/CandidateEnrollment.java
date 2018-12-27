package edu.mass.doe.cap.candidate;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import edu.mass.doe.cap.dataservice.pojo.CandidateInfo;
import edu.mass.doe.cap.dataservice.pojo.SupervisorInfo;

public class CandidateEnrollment {
	
	private Long orgId; 
	private String selectProgramId;
	
	
	@Pattern(regexp="^5\\d{7}")
	private String inputmepid;
	
	
	private Long programCompleterId;
	
	private Long programId;
	private String programName;
	
	private String candidateName;
	
	private Long candidatePersonId;
	private Long candidatedaPersonId;
	private Long mepid;
	
	private String supervisorName;
	private Long supervisorPersonId;
	private Long supervisordaPersonId;
	
	private Integer schoolYear;
	
		
	private SupervisorInfo practitioner;
	
	

	
	@DateTimeFormat(pattern = "MM/dd/yyyy") 
	private Date cycleStartDate;
	
	
	private String practitionerInputMEPID;
	
	private String schoolYearName;
	
	
	
	public CandidateEnrollment() {
		practitioner=new SupervisorInfo();
	}



	public Long getOrgId() {
		return orgId;
	}



	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}



	public String getSelectProgramId() {
		return selectProgramId;
	}



	public void setSelectProgramId(String selectProgramId) {
		this.selectProgramId = selectProgramId;
	}



	public String getInputmepid() {
		return inputmepid;
	}



	public void setInputmepid(String inputmepid) {
		this.inputmepid = inputmepid;
	}



	public Long getProgramCompleterId() {
		return programCompleterId;
	}



	public void setProgramCompleterId(Long programCompleterId) {
		this.programCompleterId = programCompleterId;
	}



	public Long getProgramId() {
		return programId;
	}



	public void setProgramId(Long programId) {
		this.programId = programId;
	}



	public String getProgramName() {
		return programName;
	}



	public void setProgramName(String programName) {
		this.programName = programName;
	}



	public String getCandidateName() {
		return candidateName;
	}



	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}



	public Long getCandidatePersonId() {
		return candidatePersonId;
	}



	public void setCandidatePersonId(Long candidatePersonId) {
		this.candidatePersonId = candidatePersonId;
	}



	public Long getCandidatedaPersonId() {
		return candidatedaPersonId;
	}



	public void setCandidatedaPersonId(Long candidatedaPersonId) {
		this.candidatedaPersonId = candidatedaPersonId;
	}



	public Long getMepid() {
		return mepid;
	}



	public void setMepid(Long mepid) {
		this.mepid = mepid;
	}



	public String getSupervisorName() {
		return supervisorName;
	}



	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}



	public Long getSupervisorPersonId() {
		return supervisorPersonId;
	}



	public void setSupervisorPersonId(Long supervisorPersonId) {
		this.supervisorPersonId = supervisorPersonId;
	}



	public Long getSupervisordaPersonId() {
		return supervisordaPersonId;
	}



	public void setSupervisordaPersonId(Long supervisordaPersonId) {
		this.supervisordaPersonId = supervisordaPersonId;
	}



	public Integer getSchoolYear() {
		return schoolYear;
	}



	public void setSchoolYear(Integer schoolYear) {
		this.schoolYear = schoolYear;
	}



	public SupervisorInfo getPractitioner() {
		return practitioner;
	}



	public void setPractitioner(SupervisorInfo practitioner) {
		this.practitioner = practitioner;
	}




	public Date getCycleStartDate() {
		return cycleStartDate;
	}



	public void setCycleStartDate(Date cycleStartDate) {
		this.cycleStartDate = cycleStartDate;
	}



	public String getPractitionerInputMEPID() {
		return practitionerInputMEPID;
	}



	public void setPractitionerInputMEPID(String practitionerInputMEPID) {
		this.practitionerInputMEPID = practitionerInputMEPID;
	}



	public String getSchoolYearName() {
		return schoolYearName;
	}



	public void setSchoolYearName(String schoolYearName) {
		this.schoolYearName = schoolYearName;
	}


	

}
