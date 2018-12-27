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
@Table(name = "CP061GPA_GOAL_PLAN_ACTION")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "GPA_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "GPA_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "GPA_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "GPA_UPDATED_BY"))
})
public class GoalPlanImplementation  extends BaseJPAEntity {
	
	
	
	@Id
	@Column(name="GPA_GOAL_PLAN_ACTION_ID")
	@SequenceGenerator(name = "GPA_PK_GENERATOR", sequenceName = "CP061GPA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GPA_PK_GENERATOR")
	private Long id;
	
	@Column(name="GPA_ACTION_EVIDENCE")
	private String actionEvidence;
	
	@Column(name="GPA_ACTION_SUPPORT")
	private String actionSupport;
	
	@Column(name="GPA_ACTION_TIMELINE")
	private String actionTimeline;
	
	@Column(name="GPA_ACTION_DESC")
	private String actionDesc;
	
	
	@Column(name="GPA_EXP_DATE")	
	private Date expDate;	
	
	@Column(name="GPA_EFF_DATE")	
	private Date effDate;
	
	@Column(name="GPA_ACTION_NUMBER")	
	private Long actionNumber;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GPA_GOAL_PLAN_ID", insertable = true, updatable = false,nullable=false)
	private GoalPlan goalPlan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionEvidence() {
		return actionEvidence;
	}

	public void setActionEvidence(String actionEvidence) {
		this.actionEvidence = actionEvidence;
	}

	public String getActionSupport() {
		return actionSupport;
	}

	public void setActionSupport(String actionSupport) {
		this.actionSupport = actionSupport;
	}

	public String getActionTimeline() {
		return actionTimeline;
	}

	public void setActionTimeline(String actionTimeline) {
		this.actionTimeline = actionTimeline;
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

	public String getActionDesc() {
		return actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}

	public Long getActionNumber() {
		return actionNumber;
	}

	public void setActionNumber(Long actionNumber) {
		this.actionNumber = actionNumber;
	}
	

}
