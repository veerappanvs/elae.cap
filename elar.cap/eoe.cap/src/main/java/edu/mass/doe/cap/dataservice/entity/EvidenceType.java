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
@Table(name = "CP017EVT_EVIDENCE_TYP")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "EVT_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "EVT_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "EVT_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "EVT_UPDATED_BY"))
})
public class EvidenceType  extends BaseJPAEntity{
	
	
	@Id
	@Column(name="EVT_EVIDENCE_TYPE_CODE")
	private String typeCode;
	
	@Column(name="EVT_EVIDENCE_TYPE_DESC")
	private String typeDesc;

	@Column(name="EVT_EVIDENCE_TYPE_NAME")
	private String typeName;
	
	@Column(name="EVT_DISPLAY_IND")
	private String displayInd;
	
	@Column(name="EVT_EXP_DATE")
	private Date expdate;

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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDisplayInd() {
		return displayInd;
	}

	public void setDisplayInd(String displayInd) {
		this.displayInd = displayInd;
	}

	public Date getExpdate() {
		return expdate;
	}

	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
	
	

	
}
