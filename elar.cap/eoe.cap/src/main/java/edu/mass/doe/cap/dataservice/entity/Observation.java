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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CP052OBS_OBSERVATION")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "OBS_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "OBS_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "OBS_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "OBS_UPDATED_BY"))
})
public class Observation extends BaseJPAEntity {
	
	@Id
	@Column(name="OBS_OBSERVATION_ID")
	@SequenceGenerator(name = "OBS_PK_GENERATOR", sequenceName = "CP052OBS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OBS_PK_GENERATOR")
	private Long observationId;
	
	@Column(name="OBS_CYCLE_ID")
	private Long cycleId;
	
	
	
	@Column(name="OBS_OBSERVATION_NUMBER")
	private Long observationNumber;
	
	@Column(name="OBS_OBSERVATION_DATE")
	private Date observationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OBS_START_TIME")
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="OBS_END_TIME")
	private Date endTime;
	
	@Column(name="OBS_OBS_TOPIC_OBJECTIVE")
	private String topicObjective;
	
	@Column(name="OBS_GROUP_CODE")
	private String groupCode;
	
	@Column(name="OBS_SP_REFINE_FEEDBACK")
	private String spRefineFeedback;
	
	@Column(name="OBS_PS_REFINE_FEEDBACK")
	private String psRefineFeedback;
	
	@Column(name="OBS_REFINE_CALIBRATED_FEEDBACK")
	private String calRefineFeedback;
	
	@Column(name="OBS_SP_REIN_FEEDBACK")
	private String spReinFeedback;
	
	@Column(name="OBS_PS_REIN_FEEDBACK")
	private String psReinFeedback;
	
	@Column(name="OBS_REIN_CALIBRATED_FEEDBACK")
	private String calReinFeedback;
	
	@Column(name="OBS_COMPLETED")
	private Character completed;
	
	@Column(name="OBS_BOTH_PSSP_COMPLETED")
	private Character bothPSSPCompleted;
	
	@Column(name="OBS_COMPLETE_DATE")
	private Date obsCompleteDate;
	
	@Column(name="OBS_COMPLETED_BY")
	private Long completedBy;
	
	@Column(name="OBS_EXP_DATE")
	private Date expDate;
	
	@Column(name="OBS_EFF_DATE")
	private Date effDate;

	
	@OneToMany(mappedBy = "observation", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Evidence> evidences;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OBS_OBSERVATION_TYPE_CODE", insertable = true, updatable = false,nullable=false)
	private ObservationType observationType;
	
	public Long getObservationId() {
		return observationId;
	}

	public void setObservationId(Long observationId) {
		this.observationId = observationId;
	}

	public Long getCycleId() {
		return cycleId;
	}

	public void setCycleId(Long cycleId) {
		this.cycleId = cycleId;
	}

	
	public Long getObservationNumber() {
		return observationNumber;
	}

	public void setObservationNumber(Long observationNumber) {
		this.observationNumber = observationNumber;
	}

	public Date getObservationDate() {
		return observationDate;
	}

	public void setObservationDate(Date observationDate) {
		this.observationDate = observationDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTopicObjective() {
		return topicObjective;
	}

	public void setTopicObjective(String topicObjective) {
		this.topicObjective = topicObjective;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getSpRefineFeedback() {
		return spRefineFeedback;
	}

	public void setSpRefineFeedback(String spRefineFeedback) {
		this.spRefineFeedback = spRefineFeedback;
	}

	public String getPsRefineFeedback() {
		return psRefineFeedback;
	}

	public void setPsRefineFeedback(String psRefineFeedback) {
		this.psRefineFeedback = psRefineFeedback;
	}

	public String getCalRefineFeedback() {
		return calRefineFeedback;
	}

	public void setCalRefineFeedback(String calRefineFeedback) {
		this.calRefineFeedback = calRefineFeedback;
	}

	public String getSpReinFeedback() {
		return spReinFeedback;
	}

	public void setSpReinFeedback(String spReinFeedback) {
		this.spReinFeedback = spReinFeedback;
	}

	public String getPsReinFeedback() {
		return psReinFeedback;
	}

	public void setPsReinFeedback(String psReinFeedback) {
		this.psReinFeedback = psReinFeedback;
	}

	public String getCalReinFeedback() {
		return calReinFeedback;
	}

	public void setCalReinFeedback(String calReinFeedback) {
		this.calReinFeedback = calReinFeedback;
	}

	public Character getCompleted() {
		return completed;
	}

	public void setCompleted(Character completed) {
		this.completed = completed;
	}

	public Character getBothPSSPCompleted() {
		return bothPSSPCompleted;
	}

	public void setBothPSSPCompleted(Character bothPSSPCompleted) {
		this.bothPSSPCompleted = bothPSSPCompleted;
	}

	public Date getObsCompleteDate() {
		return obsCompleteDate;
	}

	public void setObsCompleteDate(Date obsCompleteDate) {
		this.obsCompleteDate = obsCompleteDate;
	}

	public Long getCompletedBy() {
		return completedBy;
	}

	public void setCompletedBy(Long completedBy) {
		this.completedBy = completedBy;
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

	public List<Evidence> getEvidences() {
		return evidences;
	}

	public void setEvidences(List<Evidence> evidences) {
		this.evidences = evidences;
	}

	public ObservationType getObservationType() {
		return observationType;
	}

	public void setObservationType(ObservationType observationType) {
		this.observationType = observationType;
	}
		
	

}
