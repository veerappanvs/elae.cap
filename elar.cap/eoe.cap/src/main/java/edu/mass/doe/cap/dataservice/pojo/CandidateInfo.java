package edu.mass.doe.cap.dataservice.pojo;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;



public class CandidateInfo {
	
		

	private Long programCompleterId;
	
	private Long elarPersonId;	
	
	private Long mepid;
	
	private Long programId;
	
	private String programName;
	
	private String programStatusCode;
	
	private String programStatus;
	
	private Long daPersonId;	
	
	private String candidateName;
	
	private String firstName;
	
	private String lastName;
	
	private Long orgId;
	
	private String orgCode;

	

	
	public Long getProgramCompleterId() {
		return programCompleterId;
	}

	public void setProgramCompleterId(Long programCompleterId) {
		this.programCompleterId = programCompleterId;
	}

	public Long getElarPersonId() {
		return elarPersonId;
	}

	public void setElarPersonId(Long elarPersonId) {
		this.elarPersonId = elarPersonId;
	}

	public Long getMepid() {
		return mepid;
	}

	public void setMepid(Long mepid) {
		this.mepid = mepid;
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

	public String getProgramStatusCode() {
		return programStatusCode;
	}

	public void setProgramStatusCode(String programStatusCode) {
		this.programStatusCode = programStatusCode;
	}

	public String getProgramStatus() {
		return programStatus;
	}

	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}

	public Long getDaPersonId() {
		return daPersonId;
	}

	public void setDaPersonId(Long daPersonId) {
		this.daPersonId = daPersonId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
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

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
