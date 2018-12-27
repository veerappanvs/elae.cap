package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "CP050CPC_CAP_CYCLE")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "CPC_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "CPC_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "CPC_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "CPC_UPDATED_BY"))
})
public class CapCycle extends BaseJPAEntity {
	
	
	@Id
	@Column(name="CPC_CYCLE_ID")
	@SequenceGenerator(name = "CYCLE_PK_GENERATOR", sequenceName = "CP050CPC_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CYCLE_PK_GENERATOR")
	private Long cycleId;
	
	@Column(name="CPC_CYCLE_DATAENTRY_TYPE")
	private String cycleDataEntryType;
	
	@Column(name="CPC_SCHOOL_YEAR" )
	private Integer schoolYear;
	
	@Column(name="CPC_PCOM_ID" )
	private Long pcomId;
	
	@Column(name="CPC_WAIVED" )
	private Character waived;
	
	@Column(name="CPC_CREDIT_HOURS" )
	private Long creditHours;
	
	@Column(name="CPC_TOTAL_HOURS" )
	private Long totalHours;
	
	@Column(name="CPC_START_DATE" )
	private Date startDate;
	
	@Column(name="CPC_END_DATE" )
	private Date endDate;
	
	@Column(name="CPC_EFF_DATE" )
	private Date effDate;
	
	@Column(name="CPC_READY_TO_TEACH" )
	private Character readyToTeach;
	
	@Column(name="CPC_CST_STATUS_CODE" )
	private String cstStatusCode;
	
	
	@Column(name="CPC_CPT_PRACTICUM_TYPE_CODE")
	private String cptPracticumTypeCode;
	
	@Column(name="CPC_PRACTICUM_COURSE_NUMBER")
	private String practicumCourseNumber;
	
	@Column(name="CPC_PRACTICUM_COURSE_TITLE")
	private String practicumCourseTitle;
	
	@Column(name="CPC_PRACTICUM_GRADE_LEVEL")
	private String practicumGradeLevel;
		
		
	
	@Column(name="CPC_PRACTICUM_HOURS")
	private Long practicumHours;
	
	
	@Column(name="CPC_FULLRESP_HOURS")
	private Long fullRespHours;
	
	@Column(name="CPC_REOPEN_DATE")
	private Date reopenDate;
	
	@Column(name="CPC_AUTOCLOSE_IND")
	private String autoCloseIndictor;
	
	@Column(name="CPC_AUTOCLOSE_FIRST_EMAILDATE")
	private Date autoCloseFirstEmailDate;
	
	@Column(name="CPC_AUTOCLOSE_EMAIL_DATE")
	private Date autoCloseEmailDate;
	
	
	
	@OneToMany(mappedBy = "capCycle", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "CPA_EXP_DATE is null")
	private List<CapAssignment> assignments;
	
	
	@OneToMany(mappedBy = "capCycle", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "SOA_EXP_DATE is null")
	private List<OutOfStateSpAssignment> OutOfStateAssignments;

	
	@OneToMany(mappedBy = "capCycle", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private List<ThreewayMeeting> threewayMeetings;
	
	
	@OneToMany(mappedBy = "capCycle", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "AST_EXP_DATE is null")
	private List<Assessment> assessments;
	
	@OneToMany(mappedBy = "capCycle", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "GOP_EXP_DATE is null")
	private List<GoalPlan> goalPlans;
	
	@OneToMany(mappedBy = "capCycle", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private List<EvidenceFile > files;

	
	public Long getCycleId() {
		return cycleId;
	}

	public void setCycleId(Long cycleId) {
		this.cycleId = cycleId;
	}

	public String getCycleDataEntryType() {
		return cycleDataEntryType;
	}

	public void setCycleDataEntryType(String cycleDataEntryType) {
		this.cycleDataEntryType = cycleDataEntryType;
	}

	public Integer getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(Integer schoolYear) {
		this.schoolYear = schoolYear;
	}

	public Long getPcomId() {
		return pcomId;
	}

	public void setPcomId(Long pcomId) {
		this.pcomId = pcomId;
	}

	public Character getWaived() {
		return waived;
	}

	public void setWaived(Character waived) {
		this.waived = waived;
	}

	public Long getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(Long creditHours) {
		this.creditHours = creditHours;
	}

	public Long getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Long totalHours) {
		this.totalHours = totalHours;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public List<CapAssignment> getAssignments() {
		return assignments;
	}
	
	
	public void setAssignments(List<CapAssignment> assignments) {
		this.assignments = assignments;
	}

	public Character getReadyToTeach() {
		return readyToTeach;
	}

	public void setReadyToTeach(Character readyToTeach) {
		this.readyToTeach = readyToTeach;
	}

	public List<OutOfStateSpAssignment> getOutOfStateAssignments() {
		return OutOfStateAssignments;
	}

	public void setOutOfStateAssignments(List<OutOfStateSpAssignment> outOfStateAssignments) {
		OutOfStateAssignments = outOfStateAssignments;
	}

	public String getCstStatusCode() {
		return cstStatusCode;
	}

	public void setCstStatusCode(String cstStatusCode) {
		this.cstStatusCode = cstStatusCode;
	}

	public String getCptPracticumTypeCode() {
		return cptPracticumTypeCode;
	}

	public void setCptPracticumTypeCode(String cptPracticumTypeCode) {
		this.cptPracticumTypeCode = cptPracticumTypeCode;
	}

	public String getPracticumCourseNumber() {
		return practicumCourseNumber;
	}

	public void setPracticumCourseNumber(String practicumCourseNumber) {
		this.practicumCourseNumber = practicumCourseNumber;
	}

	public String getPracticumCourseTitle() {
		return practicumCourseTitle;
	}

	public void setPracticumCourseTitle(String practicumCourseTitle) {
		this.practicumCourseTitle = practicumCourseTitle;
	}

	public String getPracticumGradeLevel() {
		return practicumGradeLevel;
	}

	public void setPracticumGradeLevel(String practicumGradeLevel) {
		this.practicumGradeLevel = practicumGradeLevel;
	}

	

	public Long getPracticumHours() {
		return practicumHours;
	}

	public void setPracticumHours(Long practicumHours) {
		this.practicumHours = practicumHours;
	}

	public Long getFullRespHours() {
		return fullRespHours;
	}

	public void setFullRespHours(Long fullRespHours) {
		this.fullRespHours = fullRespHours;
	}

	public Date getReopenDate() {
		return reopenDate;
	}

	public void setReopenDate(Date reopenDate) {
		this.reopenDate = reopenDate;
	}

	public List<ThreewayMeeting> getThreewayMeetings() {
		return threewayMeetings;
	}

	public void setThreewayMeetings(List<ThreewayMeeting> threewayMeetings) {
		this.threewayMeetings = threewayMeetings;
	}

	public List<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<Assessment> assessments) {
		this.assessments = assessments;
	}

	

	public List<EvidenceFile> getFiles() {
		return files;
	}

	public void setFiles(List<EvidenceFile> files) {
		this.files = files;
	}

	public String getAutoCloseIndictor() {
		return autoCloseIndictor;
	}

	public void setAutoCloseIndictor(String autoCloseIndictor) {
		this.autoCloseIndictor = autoCloseIndictor;
	}

	public Date getAutoCloseFirstEmailDate() {
		return autoCloseFirstEmailDate;
	}

	public void setAutoCloseFirstEmailDate(Date autoCloseFirstEmailDate) {
		this.autoCloseFirstEmailDate = autoCloseFirstEmailDate;
	}

	public Date getAutoCloseEmailDate() {
		return autoCloseEmailDate;
	}

	public void setAutoCloseEmailDate(Date autoCloseEmailDate) {
		this.autoCloseEmailDate = autoCloseEmailDate;
	}

	public List<GoalPlan> getGoalPlans() {
		return goalPlans;
	}

	public void setGoalPlans(List<GoalPlan> goalPlans) {
		this.goalPlans = goalPlans;
	}

	

}
