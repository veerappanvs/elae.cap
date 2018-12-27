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
@Table(name = "CP0064REI_RUBRIC_ELEMENT_INFO")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "REI_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "REI_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "REI_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "REI_UPDATED_BY"))
})
public class RubricElement extends BaseJPAEntity  {
	
	@Id
	@Column(name="REI_ASSESS_ELEMENT_ID")
	@SequenceGenerator(name = "REI_PK_GENERATOR", sequenceName = "CP0064REI_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REI_PK_GENERATOR")
	private Long id;
		
	@Column(name="REI_ELEMENT_CODE")	
	private String elementCode;
	
	
	@Column(name="REI_RATIONALE")
	private String rationale;
	
	@Column(name="REI_MET_THRESHOLD")
	private Character metThreshold;
	
	@Column(name="REI_RUBRIC_COMPLETE")
	private Character complete;
	
	@Column(name="REI_EXP_DATE")	
	private Date expDate;	
	
	@Column(name="REI_EFF_DATE")	
	private Date effDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REI_ASSESSMENT_ID", insertable = true, updatable = false,nullable=false)
	private Assessment assessment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getElementCode() {
		return elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}

	public String getRationale() {
		return rationale;
	}

	public void setRationale(String rationale) {
		this.rationale = rationale;
	}

	public Character getMetThreshold() {
		return metThreshold;
	}

	public void setMetThreshold(Character metThreshold) {
		this.metThreshold = metThreshold;
	}

	public Character getComplete() {
		return complete;
	}

	public void setComplete(Character complete) {
		this.complete = complete;
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

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}
	
	

}
