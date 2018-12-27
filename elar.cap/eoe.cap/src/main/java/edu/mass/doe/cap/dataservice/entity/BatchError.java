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
@Table(name = "CP070FUE_FILE_UPLOAD_ERROR")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "FUE_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "FUE_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "FUE_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "FUE_UPDATED_BY"))
})
public class BatchError  extends BaseJPAEntity {
	

	@Id
	@Column(name="FUE_FILE_ERROR_ID")
	@SequenceGenerator(name = "FUE_PK_GENERATOR", sequenceName = "CP070FUE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUE_PK_GENERATOR")
	private Long errorId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUE_FILE_STAGING_ID", insertable = true, updatable = false,nullable=false)
	private BatchStaging batchStaging;
	
	
	@Column(name="FUE_ERROR_DESC")
	private String desc;
	
	@Column(name="FUE_EXP_DATE")
	private Date expDate;
	
	@Column(name="FUE_EFF_DATE")
	private Date effDate;

	public Long getErrorId() {
		return errorId;
	}
	public void setErrorId(Long errorId) {
		this.errorId = errorId;
	}
	public BatchStaging getBatchStaging() {
		return batchStaging;
	}
	public void setBatchStaging(BatchStaging batchStaging) {
		this.batchStaging = batchStaging;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
