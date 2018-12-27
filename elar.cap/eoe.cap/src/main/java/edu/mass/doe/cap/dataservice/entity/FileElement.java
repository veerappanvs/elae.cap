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
@Table(name = "CP066EFE_EVIDENCE_FILE_ELEMENT")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "EFE_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "EFE_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "EFE_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "EFE_UPDATED_BY"))
})
public class FileElement  extends BaseJPAEntity{
	
	
	@Id
	@Column(name="EFE_FILE_ELEMENT_ID")
	@SequenceGenerator(name = "EFE_PK_GENERATOR", sequenceName = "CP066EFE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EFE_PK_GENERATOR")
	private Long elementId;
	
	@Column(name="EFE_ELEMENT_CODE")
	private String elementCode;

	@Column(name="EFE_EVT_CODE")
	private String evidenceCode;
	
	@Column(name="EFE_EFF_DATE")
	private Date effdate;
	
	@Column(name="EFE_EXP_DATE")
	private Date expdate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EFE_EVF_FILE_ID", insertable = true, updatable = false,nullable=false)
	private EvidenceFile evidenceFile;


	public Long getElementId() {
		return elementId;
	}


	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}


	public String getElementCode() {
		return elementCode;
	}


	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}


	public Date getEffdate() {
		return effdate;
	}


	public void setEffdate(Date effdate) {
		this.effdate = effdate;
	}


	public Date getExpdate() {
		return expdate;
	}


	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}


	public EvidenceFile getEvidenceFile() {
		return evidenceFile;
	}


	public void setEvidenceFile(EvidenceFile evidenceFile) {
		this.evidenceFile = evidenceFile;
	}


	public String getEvidenceCode() {
		return evidenceCode;
	}


	public void setEvidenceCode(String evidenceCode) {
		this.evidenceCode = evidenceCode;
	}
	
	
	
}
