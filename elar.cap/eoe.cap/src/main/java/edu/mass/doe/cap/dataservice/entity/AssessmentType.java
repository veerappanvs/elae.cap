package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CP005ATP_ASSESMENT_TYPE")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "AST_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "AST_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "AST_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "AST_UPDATED_BY"))
})
public class AssessmentType  extends BaseJPAEntity {


	@Id
	@Column(name="ATP_ASMT_TYPE_CODE")	
	private String typeCode;
	
	@Column(name="ATP_ASMT_TYPE_DESC")	
	private String typeDesc;
	
	@Column(name="ATP_ASMT_REPORTABLE")	
	private Character reportable;
		
	@Column(name="AST_EXP_DATE")	
	private Date expDate;	
	
	@Column(name="AST_EFF_DATE")	
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

	public Character getReportable() {
		return reportable;
	}

	public void setReportable(Character reportable) {
		this.reportable = reportable;
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
