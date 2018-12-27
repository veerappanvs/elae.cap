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
@Table(name = "CP0058SEL_SELFASSESS_ELEMENT")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "SEL_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "SEL_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "SEL_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "SEL_UPDATED_BY"))
})
public class SelfassessmentElement extends BaseJPAEntity  {
	
	@Id
	@Column(name="SEL_ASSMT_ELEMENT_ID")
	@SequenceGenerator(name = "SEL_PK_GENERATOR", sequenceName = "CP0058SEL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEL_PK_GENERATOR")
	private Long id;
	
	
	
	@Column(name="SEL_ELEMENT_CODE")	
	private String elementCode;

	@Column(name="SEL_EXP_DATE")	
	private Date expDate;	
	
	@Column(name="SEL_EFF_DATE")	
	private Date effDate;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEL_ATTRIBUTE_ID", insertable = true, updatable = false,nullable=false)
	private SelfAssessmentAttribute selfAssessmentAttribute;

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

	public SelfAssessmentAttribute getSelfAssessmentAttribute() {
		return selfAssessmentAttribute;
	}

	public void setSelfAssessmentAttribute(SelfAssessmentAttribute selfAssessmentAttribute) {
		this.selfAssessmentAttribute = selfAssessmentAttribute;
	}


}
