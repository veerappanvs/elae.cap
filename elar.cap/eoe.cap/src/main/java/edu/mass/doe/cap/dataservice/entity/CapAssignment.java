package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CP051CPA_CAP_ASSIGNMENT")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "CPA_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "CPA_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "CPA_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "CPA_UPDATED_BY"))
})
public class CapAssignment extends BaseJPAEntity {
	
	
	@Id
	@Column(name="CPA_ASSIGNMENT_ID")
	@SequenceGenerator(name = "ASSIGNMENT_PK_GENERATOR", sequenceName = "CP051CPA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSIGNMENT_PK_GENERATOR")
	private Long assignmentId;
	
	
	
	@Column(name="CPA_SOA_PERSON_ID")
	private Long soaPersonId;
	
	@Column(name="CPA_DA_PERSON_ID")
	private Long daPersonId;
	
	
	@Column(name="CPA_DA_ROLE_CODE")
	private Long daRoleCode;

	
	@Column(name="CPA_START_DATE")
	private Date startDate;
	
	@Column(name="CPA_END_DATE")
	private Date endDate;
	
	@Column(name="CPA_EXP_DATE")
	private Date expDate;	
	
	@Column(name="CPA_EFF_DATE")
	private Date effDate;
	
	
	@Column(name="CPA_PRACTICUM_ORG_ID")
	private Long practicumOrgId;
	
	public Long getPracticumOrgId() {
		return practicumOrgId;
	}

	public void setPracticumOrgId(Long practicumOrgId) {
		this.practicumOrgId = practicumOrgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CPA_CYCLE_ID", insertable = true, updatable = false,nullable=false)
	private CapCycle capCycle;

	
	public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	

	public Long getSoaPersonId() {
		return soaPersonId;
	}

	public void setSoaPersonId(Long soaPersonId) {
		this.soaPersonId = soaPersonId;
	}

	public Long getDaPersonId() {
		return daPersonId;
	}

	public void setDaPersonId(Long daPersonId) {
		this.daPersonId = daPersonId;
	}

	public Long getDaRoleCode() {
		return daRoleCode;
	}

	public void setDaRoleCode(Long daRoleCode) {
		this.daRoleCode = daRoleCode;
	}

	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	
	public CapCycle getCapCycle() {
		return capCycle;
	}

	public void setCapCycle(CapCycle capCycle) {
		this.capCycle = capCycle;
	}
	

	
	
	
	

}
