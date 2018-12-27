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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import edu.mass.doe.cap.dataservice.pojo.CapData;

@Entity
@Table(name = "CP068CFU_FILE_UPLOAD_HDR")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "CFU_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "CFU_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "CFU_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "CFU_UPDATED_BY"))
})
public class Batch  extends BaseJPAEntity{
	
	@Id
	@Column(name="CFU_FILE_UPLOAD_ID")
	@SequenceGenerator(name = "CFU_PK_GENERATOR", sequenceName = "CP068CFU_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CFU_PK_GENERATOR")
	private Long uploadId;
	
	@Column(name="CFU_FILE_NAME")
	private String fileName;
	
	@Column(name="CFU_INT_FILE_NAME")
	private String internalFileName;
	
	@Column(name="CFU_FUT_CODE")
	private String code;
	
	@Column(name="CFU_DA_PERSON_ID")
	private Long personId;
	
	@Column(name="CFU_EXP_DATE")
	private Date expDate;
	
	@Column(name="CFU_EFF_DATE")
	private Date effDate;
	
	@OneToMany(mappedBy = "batch", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "FUS_EXP_DATE is null")
	private List<BatchStaging> records;
	

	public Long getUploadId() {
		return uploadId;
	}

	public void setUploadId(Long uploadId) {
		this.uploadId = uploadId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getInternalFileName() {
		return internalFileName;
	}

	public void setInternalFileName(String internalFileName) {
		this.internalFileName = internalFileName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
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

	public List<BatchStaging> getRecords() {
		return records;
	}

	public void setRecords(List<BatchStaging> records) {
		this.records = records;
	}
	

}
