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
@Table(name = "CP072FUR_FILE_UPLOAD_RATING")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "FUR_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "FUR_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "FUR_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "FUR_UPDATED_BY"))
})
public class UploadedRating extends BaseJPAEntity {
	
	@Id
	@Column(name="FUR_UPLD_RATING_ID")
	@SequenceGenerator(name = "FUR_PK_GENERATOR", sequenceName = "CP072FUR_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUR_PK_GENERATOR")
	private Long uploadRatingId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUR_FUP_ID", insertable = true, updatable = false,nullable=false)
	private UploadedData uploadedData;
	
	@Column(name="FUR_REL_ID")
	private Long linkId;
	
	
	@Column(name="FUR_RDT_CODE")
	private String dimensionCode;
	
	@Column(name="FUR_EXP_DATE")
	private Date expDate;
	
	@Column(name="FUR_EFF_DATE")
	private Date effDate;

	@Column(name="FUR_ASMT_TYPE_CODE")
	private String  asmtTypeCode;

	public Long getUploadRatingId() {
		return uploadRatingId;
	}

	public void setUploadRatingId(Long uploadRatingId) {
		this.uploadRatingId = uploadRatingId;
	}

	public UploadedData getUploadedData() {
		return uploadedData;
	}

	public void setUploadedData(UploadedData uploadedData) {
		this.uploadedData = uploadedData;
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

	public String getAsmtTypeCode() {
		return asmtTypeCode;
	}

	public void setAsmtTypeCode(String asmtTypeCode) {
		this.asmtTypeCode = asmtTypeCode;
	}

	public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public String getDimensionCode() {
		return dimensionCode;
	}

	public void setDimensionCode(String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}
	

}
