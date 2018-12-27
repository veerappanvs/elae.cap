package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CP018EEV_ELEMENT_EVIDENCE")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "EEV_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "EEV_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "EEV_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "EEV_UPDATED_BY"))
})
public class EvidenceSourceFocus {
	
	@Id
	@Column(name="EEV_ID")	
	private Long eevId;
	
	@Column(name="EEV_EVT_EVIDENCE_CODE")	
	private String evidenceCode;
	
		
	@Column(name="EEV_RET_ELEMENT_CODE")	
	private String elementCode;
	
	@Column(name="EEV_EXP_DATE")	
	private Date expDate;
	
	@Column(name="EEV_EFF_DATE")	
	private Date effDate;

	public Long getEevId() {
		return eevId;
	}

	public void setEevId(Long eevId) {
		this.eevId = eevId;
	}

	public String getEvidenceCode() {
		return evidenceCode;
	}

	public void setEvidenceCode(String evidenceCode) {
		this.evidenceCode = evidenceCode;
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
