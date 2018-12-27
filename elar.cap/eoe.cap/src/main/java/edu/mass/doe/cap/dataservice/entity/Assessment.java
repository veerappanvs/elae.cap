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
@Table(name = "CP056AST_ASSESSMENT")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "AST_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "AST_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "AST_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "AST_UPDATED_BY"))
})
public class Assessment extends BaseJPAEntity {
	
	
	
	@Id
	@Column(name="AST_ASSESSMENT_ID")
	@SequenceGenerator(name = "AST_PK_GENERATOR", sequenceName = "CP056AST_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AST_PK_GENERATOR")
	private Long assessmentId;
	

	@Column(name="AST_ASMT_TYPE_CODE")
	private String typeCode;
	
	@Column(name="AST_LOCKED")
	private Character locked;
	
	@Column(name="AST_COMPLETED")
	private Character completed;
	
	@Column(name="AST_CALIBRATED_FEEDBACK")
	private String calFeedback;
	
	@Column(name="AST_ADDL_OBS_REQ")
	private Character addlObservationRequired;
	
	@Column(name="AST_REIN_FEEDBACK")
	private String reinFeedback;
	
	@Column(name="AST_REFINE_FEEDBACK")
	private String refineFeedback;
	
	@Column(name="AST_EVIDENCE_FEEDBACK")
	private String evidenceFeedback;
	
	@Column(name="AST_RECOMENDED_FOCUS")
	private String recommendedfocus;
	
	@Column(name="AST_SP_APPROVED")
	private Character spApproved;
	
	@Column(name="AST_SP_APPROVE_DATE")
	private Date spApprovedDate;
	
	@Column(name="AST_PS_APPROVED")
	private Character psApproved;
	
	@Column(name="AST_PS_APPROVE_DATE")
	private Date psApprovedDate;
	
	@Column(name="AST_EXP_DATE")
	private Date expDate;
	
	@Column(name="AST_EFF_DATE")
	private Date effdate;
	
	
	@OneToMany(mappedBy = "assessment", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "RUM_EXP_DATE is null")
	private List<RubricMap> rubrics;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AST_CYCLE_ID", insertable = true, updatable = false,nullable=false)
	private CapCycle capCycle;
	
	@OneToMany(mappedBy = "assessment", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "AEL_EXP_DATE is null")
	private List<AssessmentElementLink> assessmentElementLinks;
	
	
	@OneToMany(mappedBy = "assessment", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "REI_EXP_DATE is null")
	private List<RubricElement > rubricElements;
	
	@OneToMany(mappedBy = "assessment", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "SAA_EXP_DATE is null")
	private List<SelfAssessmentAttribute > selfAssessmentAttributes;
	
	

	public Long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}

	

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Character getLocked() {
		return locked;
	}

	public void setLocked(Character locked) {
		this.locked = locked;
	}

	public Character getCompleted() {
		return completed;
	}

	public void setCompleted(Character completed) {
		this.completed = completed;
	}

	public String getCalFeedback() {
		return calFeedback;
	}

	public void setCalFeedback(String calFeedback) {
		this.calFeedback = calFeedback;
	}

	public Character getAddlObservationRequired() {
		return addlObservationRequired;
	}

	public void setAddlObservationRequired(Character addlObservationRequired) {
		this.addlObservationRequired = addlObservationRequired;
	}

	public String getReinFeedback() {
		return reinFeedback;
	}

	public void setReinFeedback(String reinFeedback) {
		this.reinFeedback = reinFeedback;
	}

	public String getRefineFeedback() {
		return refineFeedback;
	}

	public void setRefineFeedback(String refineFeedback) {
		this.refineFeedback = refineFeedback;
	}

	public String getEvidenceFeedback() {
		return evidenceFeedback;
	}

	public void setEvidenceFeedback(String evidenceFeedback) {
		this.evidenceFeedback = evidenceFeedback;
	}

	public String getRecommendedfocus() {
		return recommendedfocus;
	}

	public void setRecommendedfocus(String recommendedfocus) {
		this.recommendedfocus = recommendedfocus;
	}

	public Character getSpApproved() {
		return spApproved;
	}

	public void setSpApproved(Character spApproved) {
		this.spApproved = spApproved;
	}

	public Date getSpApprovedDate() {
		return spApprovedDate;
	}

	public void setSpApprovedDate(Date spApprovedDate) {
		this.spApprovedDate = spApprovedDate;
	}

	public Character getPsApproved() {
		return psApproved;
	}

	public void setPsApproved(Character psApproved) {
		this.psApproved = psApproved;
	}

	public Date getPsApprovedDate() {
		return psApprovedDate;
	}

	public void setPsApprovedDate(Date psApprovedDate) {
		this.psApprovedDate = psApprovedDate;
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

	public List<RubricMap> getRubrics() {
		return rubrics;
	}

	public void setRubrics(List<RubricMap> rubrics) {
		this.rubrics = rubrics;
	}

	public CapCycle getCapCycle() {
		return capCycle;
	}

	public void setCapCycle(CapCycle capCycle) {
		this.capCycle = capCycle;
	}

	public List<AssessmentElementLink> getAssessmentElementLinks() {
		return assessmentElementLinks;
	}

	public void setAssessmentElementLinks(List<AssessmentElementLink> assessmentElementLinks) {
		this.assessmentElementLinks = assessmentElementLinks;
	}

	public List<RubricElement> getRubricElements() {
		return rubricElements;
	}

	public void setRubricElements(List<RubricElement> rubricElements) {
		this.rubricElements = rubricElements;
	}

	public List<SelfAssessmentAttribute> getSelfAssessmentAttributes() {
		return selfAssessmentAttributes;
	}

	public void setSelfAssessmentAttributes(List<SelfAssessmentAttribute> selfAssessmentAttributes) {
		this.selfAssessmentAttributes = selfAssessmentAttributes;
	}
		

}
