package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CP013CET_CAP_EMAIL_TYP")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "CET_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "CET_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "CET_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "CET_UPDATED_BY"))
})
public class EmailType extends BaseJPAEntity {
	
	
	@Id
	@Column(name="CET_EMAIL_TYPE_CODE")
	private String typecode;
	
	@Column(name="CET_EMAIL_TYPE_DESC")
	private String desc;
	
	@Column(name="CET_EMAIL_SUBJECT_LINE")
	private String subject;
	
	@Column(name="CET_TEMPLATE_NAME")
	private String template;
	
	@Column(name="CET_EXP_DATE")
	private Date expDate;
	
	@Column(name="CET_EFF_DATE")
	private Date effDate;

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
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
