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

import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "CP060GOP_GOAL_PLAN")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "GOP_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "GOP_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "GOP_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "GOP_UPDATED_BY"))
})
public class GoalPlan extends BaseJPAEntity  {

	@Id
	@Column(name="GOP_GOAL_PLAN_ID")
	@SequenceGenerator(name = "GOP_PK_GENERATOR", sequenceName = "CP060GOP_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOP_PK_GENERATOR")
	private Long planId;
	
	@Column(name="GOP_GOAL_PLAN_TYPE_CODE")
	private String typeCode;
	
	@Column(name="GOP_PPG_GOAL_DESC")
	private String goalDesc;
	
	@Column(name="GOP_PPG_IMPORTANCE")
	private String importance;
	
	@Column(name="GOP_PPG_ACTION")
	private String action;
	
	
	@Column(name="GOP_PPG_SUPPORT")
	private String support;
	
	@Column(name="GOP_LEARNING_MEASURE")
	private String learningMeasure;
	
	
	@Column(name="GOP_SMART_SKILLS_ACQUIRED")
	private String acquired;
	
	@Column(name="GOP_SMART_SUCCESS_EVAL")
	private String successEval;
	
	@Column(name="GOP_SMART_PROGRESS_MEASURE")
	private String progressMeasure;
	
	@Column(name="GOP_SMART_REALISTIC_MEASURE")
	private String realisticMeasure;
	
	@Column(name="GOP_SMART_ACHIEVEMENT_TIME")
	private String achievementTime;
	
	@Column(name="GOP_FEEDBACK")
	private String feedback;
	
	@Column(name="GOP_COMPLETE")
	private Character complete;
	
	@Column(name="GOP_EXP_DATE")
	private Date expDate;
	
	@Column(name="GOP_EFF_DATE")
	private Date effDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GOP_CYCLE_ID", insertable = true, updatable = false,nullable=false)
	private CapCycle capCycle;	
	

	@OneToMany(mappedBy = "goalPlan", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "GFE_EXP_DATE is null")
	private List<GoalPlanElement > goalPlanElements;
	
	@OneToMany(mappedBy = "goalPlan", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "GPA_EXP_DATE is null")
	@OrderBy(clause="GPA_ACTION_NUMBER")
	private List<GoalPlanImplementation > goalPlanImplementations;
	
	@OneToMany(mappedBy = "goalPlan", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "GLM_EXP_DATE is null")
	private List<GoalLearningMeasure > GoalLearningMeasure;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getGoalDesc() {
		return goalDesc;
	}

	public void setGoalDesc(String goalDesc) {
		this.goalDesc = goalDesc;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public String getLearningMeasure() {
		return learningMeasure;
	}

	public void setLearningMeasure(String learningMeasure) {
		this.learningMeasure = learningMeasure;
	}

	public String getAcquired() {
		return acquired;
	}

	public void setAcquired(String acquired) {
		this.acquired = acquired;
	}

	public String getSuccessEval() {
		return successEval;
	}

	public void setSuccessEval(String successEval) {
		this.successEval = successEval;
	}

	public String getProgressMeasure() {
		return progressMeasure;
	}

	public void setProgressMeasure(String progressMeasure) {
		this.progressMeasure = progressMeasure;
	}

	public String getRealisticMeasure() {
		return realisticMeasure;
	}

	public void setRealisticMeasure(String realisticMeasure) {
		this.realisticMeasure = realisticMeasure;
	}

	public String getAchievementTime() {
		return achievementTime;
	}

	public void setAchievementTime(String achievementTime) {
		this.achievementTime = achievementTime;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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

	public List<GoalPlanElement> getGoalPlanElements() {
		return goalPlanElements;
	}

	public void setGoalPlanElements(List<GoalPlanElement> goalPlanElements) {
		this.goalPlanElements = goalPlanElements;
	}

	
	public List<GoalPlanImplementation> getGoalPlanImplementations() {
		return goalPlanImplementations;
	}

	public void setGoalPlanImplementations(List<GoalPlanImplementation> goalPlanImplementations) {
		this.goalPlanImplementations = goalPlanImplementations;
	}

	public List<GoalLearningMeasure> getGoalLearningMeasure() {
		return GoalLearningMeasure;
	}

	public void setGoalLearningMeasure(List<GoalLearningMeasure> goalLearningMeasure) {
		GoalLearningMeasure = goalLearningMeasure;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public CapCycle getCapCycle() {
		return capCycle;
	}

	public void setCapCycle(CapCycle capCycle) {
		this.capCycle = capCycle;
	}

	 
}
