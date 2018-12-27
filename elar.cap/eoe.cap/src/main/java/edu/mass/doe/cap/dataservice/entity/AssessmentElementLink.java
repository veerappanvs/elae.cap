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
@Table(name = "CP059AEL_ASMT_ELEMENT_LINK")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "AEL_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "AEL_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "AEL_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "AEL_UPDATED_BY"))
})
public class AssessmentElementLink extends BaseJPAEntity  {
	
	@Id
	@Column(name="AEL_ELEMENT_LINK_ID")
	@SequenceGenerator(name = "AEL_PK_GENERATOR", sequenceName = "CP059AEL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AEL_PK_GENERATOR")
	private Long linkId;
	
	@Column(name="AEL_AAT_ATTRIBUTE_TYPE")
	private String attributeType;
	
	@Column(name="AEL_RET_ELEMENT_CODE")
	private String elementCode;

	
	@Column(name="AEL_EXP_DATE")
	private Date expDate;
	
	@Column(name="AEL_EFF_DATE")
	private Date effdate;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AEL_AAT_ASSESSMENT_ID", insertable = true, updatable = false,nullable=false)
	private Assessment assessment;
	

	public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getEffdate() {
		return effdate;
	}

	public void setEffdate(Date effdate) {
		this.effdate = effdate;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	public String getElementCode() {
		return elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}

	
	
}
