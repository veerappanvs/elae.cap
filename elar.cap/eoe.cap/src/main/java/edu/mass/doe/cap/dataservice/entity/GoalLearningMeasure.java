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
@Table(name = "CP063GLM_GOAL_LEARNING_MEASURE")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "GLM_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "GLM_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "GLM_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "GLM_UPDATED_BY"))
})
public class GoalLearningMeasure  extends BaseJPAEntity {
	
	
	
	@Id
	@Column(name="GLM_GOAL_LEARNING_MEASURE_ID")
	@SequenceGenerator(name = "GLM_PK_GENERATOR", sequenceName = "CP063GLM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLM_PK_GENERATOR")
	private Long id;
	
	@Column(name="GLM_IMPACT_CODE")
	private String impactCode;
	
	@Column(name="GLM_PARAMETER")
	private String parameter;
	
	
	@Column(name="GLM_EXP_DATE")	
	private Date expDate;	
	
	@Column(name="GLM_EFF_DATE")	
	private Date effDate;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GLM_GOAL_PLAN_ID", insertable = true, updatable = false,nullable=false)
	private GoalPlan goalPlan;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getImpactCode() {
		return impactCode;
	}


	public void setImpactCode(String impactCode) {
		this.impactCode = impactCode;
	}


	public String getParameter() {
		return parameter;
	}


	public void setParameter(String parameter) {
		this.parameter = parameter;
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


	public GoalPlan getGoalPlan() {
		return goalPlan;
	}


	public void setGoalPlan(GoalPlan goalPlan) {
		this.goalPlan = goalPlan;
	}

	
	

}
