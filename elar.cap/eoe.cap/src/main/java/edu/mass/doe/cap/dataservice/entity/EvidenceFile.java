package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CP065EVF_EVIDENCE_FILES")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "EVF_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "EVF_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "EVF_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "EVF_UPDATED_BY"))
})
public class EvidenceFile extends BaseJPAEntity {
	
	@Id
	@Column(name="EVF_EVIDENCE_FILE_ID")
	@SequenceGenerator(name = "EVF_PK_GENERATOR", sequenceName = "CP065EVF_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVF_PK_GENERATOR")
	private Long fileId;
	
	@Column(name="EVF_INTERNAL_FILE_NAME")
	private String internalFileName;
	
	@Column(name="EVF_EXTERNAL_FILE_NAME")
	private String externalFileName;
	
	
	@Column(name="EVF_DA_PERSON_ID")
	private Long  personId;
	
	@Column(name="EVF_FILE_SIZE")
	private Long  fileSize;
	

	@Column(name="EVF_EFF_DATE")
	private Date effdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVF_CPC_ID", insertable = true, updatable = false,nullable=false)
	private CapCycle capCycle;
	
	@OneToMany(mappedBy = "evidenceFile", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private List<FileElement > elements;

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getInternalFileName() {
		return internalFileName;
	}

	public void setInternalFileName(String internalFileName) {
		this.internalFileName = internalFileName;
	}

	public String getExternalFileName() {
		return externalFileName;
	}

	public void setExternalFileName(String externalFileName) {
		this.externalFileName = externalFileName;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Date getEffdate() {
		return effdate;
	}

	public void setEffdate(Date effdate) {
		this.effdate = effdate;
	}

	public CapCycle getCapCycle() {
		return capCycle;
	}

	public void setCapCycle(CapCycle capCycle) {
		this.capCycle = capCycle;
	}

	public List<FileElement> getElements() {
		return elements;
	}

	public void setElements(List<FileElement> elements) {
		this.elements = elements;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	

}
