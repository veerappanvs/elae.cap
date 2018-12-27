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
@Table(name = "CP053OBE_OBSERVATION_EVIDENCE")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "OBE_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "OBE_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "OBE_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "OBE_UPDATED_BY"))
})
public class Evidence  extends BaseJPAEntity{
	
	@Id
	@Column(name="OBE_OBSERVATION_EVIDENCE_ID")
	@SequenceGenerator(name = "OBE_PK_GENERATOR", sequenceName = "CP053OBE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OBE_PK_GENERATOR")
	private Long evidenceId;
	
	@Column(name="OBE_OBS_ELEMENT_CODE")
	private String elementCode;
	
	@Column(name="OBE_PS_EVIDENCE")
	private String psEvidence;

	@Column(name="OBE_SP_EVIDENCE")
	private String spEvidence;
	
	@Column(name="OBE_CAL_EVIDENCE")
	private String calEvidence;
	
	@Column(name="OBE_PS_REFINE_EVIDENCE")
	private String psRefineEvidence;
	
	@Column(name="OBE_SP_REFINE_EVIDENCE")
	private String spRefineEvidence;
	
	@Column(name="OBE_CAL_REFINE_EVIDENCE")
	private String calRefineEvidence;
	
	
	@Column(name="OBE_PS_REIN_EVIDENCE")
	private String psReinEvidence;

	@Column(name="OBE_SP_REIN_EVIDENCE")
	private String spReinEvidence;
	
	@Column(name="OBE_CAL_REIN_EVIDENCE")
	private String calReinEvidence;
	
	@Column(name="OBE_EXP_DATE")
	private String expDate;
	
	@Column(name="OBE_EFF_DATE")
	private Date effDate;

	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OBE_OBSERVATION_ID", insertable = true, updatable = false,nullable=false)
	private Observation observation;
	
	public Long getEvidenceId() {
		return evidenceId;
	}

	public void setEvidenceId(Long evidenceId) {
		this.evidenceId = evidenceId;
	}

	public String getElementCode() {
		return elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}

	public String getPsEvidence() {
		return psEvidence;
	}

	public void setPsEvidence(String psEvidence) {
		this.psEvidence = psEvidence;
	}

	public String getSpEvidence() {
		return spEvidence;
	}

	public void setSpEvidence(String spEvidence) {
		this.spEvidence = spEvidence;
	}

	public String getCalEvidence() {
		return calEvidence;
	}

	public void setCalEvidence(String calEvidence) {
		this.calEvidence = calEvidence;
	}

	public String getPsRefineEvidence() {
		return psRefineEvidence;
	}

	public void setPsRefineEvidence(String psRefineEvidence) {
		this.psRefineEvidence = psRefineEvidence;
	}

	public String getSpRefineEvidence() {
		return spRefineEvidence;
	}

	public void setSpRefineEvidence(String spRefineEvidence) {
		this.spRefineEvidence = spRefineEvidence;
	}

	public String getCalRefineEvidence() {
		return calRefineEvidence;
	}

	public void setCalRefineEvidence(String calRefineEvidence) {
		this.calRefineEvidence = calRefineEvidence;
	}

	public String getPsReinEvidence() {
		return psReinEvidence;
	}

	public void setPsReinEvidence(String psReinEvidence) {
		this.psReinEvidence = psReinEvidence;
	}

	public String getSpReinEvidence() {
		return spReinEvidence;
	}

	public void setSpReinEvidence(String spReinEvidence) {
		this.spReinEvidence = spReinEvidence;
	}

	public String getCalReinEvidence() {
		return calReinEvidence;
	}

	public void setCalReinEvidence(String calReinEvidence) {
		this.calReinEvidence = calReinEvidence;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public Observation getObservation() {
		return observation;
	}

	public void setObservation(Observation observation) {
		this.observation = observation;
	}
	
	
	

}
