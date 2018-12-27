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

import org.hibernate.annotations.Where;

@Entity
@Table(name = "CP006RDT_RUBRIC_DIMENSION_TYP")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "RDT_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "RDT_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "RDT_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "RDT_UPDATED_BY"))
})
public class DimensionType extends BaseJPAEntity {
	

	
	
	@Id
	@Column(name="RDT_RUBRIC_DIMENSION_CODE")	
	private String dimensionCode;
	
	@Column(name="RDT_DIMENSION_DESC")	
	private String desc;
	
	@Column(name="RDT_DIMENSION_SHORT_DESC")	
	private String shortDesc;
	
	@Column(name="RDT_LONG_DESC")	
	private String longDesc;
	
	
	@Column(name="RDT_EXP_DATE")	
	private Date expDate;	
	
	@Column(name="RDT_EFF_DATE")	
	private Date effDate;
	

	public String getDimensionCode() {
		return dimensionCode;
	}

	public void setDimensionCode(String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
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
