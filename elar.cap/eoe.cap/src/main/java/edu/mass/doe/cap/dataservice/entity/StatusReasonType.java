package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CP006CST_CYCLE_STATREASON_TYP")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "CST_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "CST_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "CST_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "CST_UPDATED_BY"))
})

public class StatusReasonType extends BaseJPAEntity  {
	
	@Id
	@Column(name="CST_STATUS_CODE")	
	private String typeCode;
	
	@Column(name="CST_STATUS_DESC")	
	private String typeDesc;
	
	@Column(name="CST_EXP_DATE")	
	private Date expDate;
	
	@Column(name="CST_EFF_DATE")	
	private Date effDate;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
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
