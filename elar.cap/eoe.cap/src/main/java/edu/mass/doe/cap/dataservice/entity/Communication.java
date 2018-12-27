package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CP067CCC_CYCLE_COMMUNICATION")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "CCC_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "CCC_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "CCC_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "CCC_UPDATED_BY"))
})
public class Communication extends BaseJPAEntity {
	
	
	@Id
	@Column(name="CCC_CAP_EMAIL_ID")
	@SequenceGenerator(name = "CCC_PK_GENERATOR", sequenceName = "CP067CCC_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CCC_PK_GENERATOR")
	private Long emailId;
	
	@Column(name="CCC_CPC_ID")
	private Long cycleId;
	
	@Column(name="CCC_CET_EMAIL_TYPE_CODE")
	private String typeCode;
	
	@Column(name="CCC_FROM_EMAIL_ADDR")
	private String from;
	
	@Column(name="CCC_TO_EMAIL_ADDR")
	private String to;
	
	@Column(name="CCC_SUBJECT_LINE")
	private String subject;
		
	@Column(name="CCC_DA_PER_ID")
	private Long personId;
	
	@Column(name="CCC_EMAIL_FILE_NAME")
	private String file;
	
	@Column(name="CCC_SENT_DATE")
	private Date sentDate;
	
	@Column(name="CCC_EXP_DATE")
	private Date expDate;
	
	@Column(name="CCC_EFF_DATE")
	private Date effDate;

	public Long getEmailId() {
		return emailId;
	}

	public void setEmailId(Long emailId) {
		this.emailId = emailId;
	}

	public Long getCycleId() {
		return cycleId;
	}

	public void setCycleId(Long cycleId) {
		this.cycleId = cycleId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
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
	

}

