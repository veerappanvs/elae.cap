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

import org.hibernate.annotations.Where;

@Entity
@Table(name = "CP057SAA_SELF_ASMT_ATTRIBUTES")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "SAA_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "SAA_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "SAA_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "SAA_UPDATED_BY"))
})
public class SelfAssessmentAttribute extends BaseJPAEntity  {

	@Id
	@Column(name="SAA_ATTRIBUTE_ID")
	@SequenceGenerator(name = "SAA_PK_GENERATOR", sequenceName = "CP057SAA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SAA_PK_GENERATOR")
	private Long id;
	
	@Column(name="SAA_ATTRIBUTE_TYPE_CODE")	
	private String typeCode;
	
	@Column(name="SAA_ATTRIBUTE_AREA")	
	private String area;
	
	@Column(name="SAA_ATTRIBUTE_RATIONALE")	
	private String rationale;
	
	@Column(name="SAA_EXP_DATE")	
	private Date expDate;	

	@Column(name="SAA_EFF_DATE")	
	private Date effDate;
	
	@Column(name="SAA_ATTRIBUTE_NUMBER")	
	private Long attributeNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SAA_ASSESSMENT_ID", insertable = true, updatable = false,nullable=false)
	private Assessment assessment;
	
	@OneToMany(mappedBy = "selfAssessmentAttribute", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "SEL_EXP_DATE is null")
	private List<SelfassessmentElement > selfassessmentElements;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public String getRationale() {
		return rationale;
	}

	public void setRationale(String rationale) {
		this.rationale = rationale;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	public List<SelfassessmentElement> getSelfassessmentElements() {
		return selfassessmentElements;
	}

	public void setSelfassessmentElements(List<SelfassessmentElement> selfassessmentElements) {
		this.selfassessmentElements = selfassessmentElements;
	}

	public Long getAttributeNumber() {
		return attributeNumber;
	}

	public void setAttributeNumber(Long attributeNumber) {
		this.attributeNumber = attributeNumber;
	}
	
	
	
}
