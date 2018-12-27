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
@Table(name = "CP004RET_RUBRIC_ELEMENT_TYP")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "RET_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "RET_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "RET_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "RET_UPDATED_BY"))
})
public class ElementType extends BaseJPAEntity {
	
	
	@Id
	@Column(name="RET_ELEMENT_CODE")	
	private String elementCode;
	
	@Column(name="RET_ELEMENT_LABEL")	
	private String label;
	
	@Column(name="RET_ELEMENT_LONG_DESC")	
	private String longDesc;
	
	@Column(name="RET_ELEMENT_ALT_LONG_DESC")	
	private String altDesc;
	
	
	@Column(name="RET_EXP_DATE")	
	private Date expDate;	
	
	@Column(name="RET_EFF_DATE")	
	private Date effDate;
	
	
	public String getElementCode() {
		return elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getAltDesc() {
		return altDesc;
	}

	public void setAltDesc(String altDesc) {
		this.altDesc = altDesc;
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
