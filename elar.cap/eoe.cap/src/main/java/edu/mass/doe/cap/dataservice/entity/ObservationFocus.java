package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CP0054OFE_OBS_FOCUS_ELEMENT")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "OFE_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "OFE_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "OFE_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "OFE_UPDATED_BY"))
})
public class ObservationFocus {
	
	@Id
	@Column(name="OFE_FOCUS_ELEMENT_ID")	
	private Long focusId;
	
	@Column(name="OFE_OBSERVATION_TYPE_CODE")	
	private String typeCode;
	
	@Column(name="OFE_OBSERVATION_NUMBER")	
	private Long observationNumber;
	
	@Column(name="OFE_ELEMENT_CODE")	
	private String elementCode;
	
	@Column(name="OFE_EXP_DATE")	
	private Date expDate;
	
	@Column(name="OFE_EFF_DATE")	
	private Date effDate;

	public Long getFocusId() {
		return focusId;
	}

	public void setFocusId(Long focusId) {
		this.focusId = focusId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Long getObservationNumber() {
		return observationNumber;
	}

	public void setObservationNumber(Long observationNumber) {
		this.observationNumber = observationNumber;
	}

	public String getElementCode() {
		return elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
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
