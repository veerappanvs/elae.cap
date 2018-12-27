package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CP002OBT_OSBSERVATION_TYP")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "OBT_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "OBT_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "OBT_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "OBT_UPDATED_BY"))
})
public class ObservationType extends BaseJPAEntity {
	
	@Id
	@Column(name="OBT_OBSERVATION_TYPE_CODE")	
	private String typeCode;
	
	@Column(name="OBT_OBSERVATION_TYPE_DESC")	
	private String typeDesc;
	
	
	@Column(name="OBT_EXP_DATE")	
	private Date expDate;
	
	@Column(name="OBT_EFF_DATE")	
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
	
	@OneToMany(mappedBy = "observation", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Evidence> evidences;
}
