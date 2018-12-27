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
@Table(name = "CP073COM_COMMUNICATION")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "COM_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "COM_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "COM_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "COM_UPDATED_BY"))
})
public class Message extends BaseJPAEntity{
	
	
	@Id
	@Column(name="COM_COUMMUNICATION_ID")
	@SequenceGenerator(name = "COM_PK_GENERATOR", sequenceName = "CP073COM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COM_PK_GENERATOR")
	private Long messageId;
	
	
	@Column(name="COM_CPC_ID")
	private Long cycleId;
	
	@Column(name="COM_COMM_TYPE_CODE")
	private String  typeCode;
	
	@Column(name="COM_DA_PERSON_ID")
	private Long daPersonId;
	
	@Column(name="COM_MESSAGE")
	private String message;
	
	@Column(name="COM_MESSAGE_DATE")
	private Date messageDate;
	
	@Column(name="COM_EXP_DATE")
	private Date expDate;
	
	@Column(name="COM_EFF_DATE")
	private Date effDate;
	

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
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

	public Long getDaPersonId() {
		return daPersonId;
	}

	public void setDaPersonId(Long daPersonId) {
		this.daPersonId = daPersonId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
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
