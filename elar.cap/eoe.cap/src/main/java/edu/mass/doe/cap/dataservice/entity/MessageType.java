package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CP016COT_COMMUNICATION_TYP")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "COT_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "COT_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "COT_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "COT_UPDATED_BY"))
})
public class MessageType extends BaseJPAEntity {
	
	@Id
	@Column(name="COT_COMM_TYPE_CODE")
	private String typeCode;
	
	@Column(name="COT_COMM_TYPE_DESC")
	private String desc;
	
	
	@Column(name="COT_COMM_TYPE_NAME")
	private String name;
	
	@Column(name="COT_EXP_DATE")
	private Date expDate ;
	
	@Column(name="COT_EFF_DATE")
	private Date effDate ;

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

}
