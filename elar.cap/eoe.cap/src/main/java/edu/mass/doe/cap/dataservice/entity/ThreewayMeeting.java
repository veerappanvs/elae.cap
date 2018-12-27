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
@Table(name = "CP055TWM_THREE_WAY_MEETING")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "TWM_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "TWM_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "TWM_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "TWM_UPDATED_BY"))
})
public class ThreewayMeeting extends BaseJPAEntity {

	@Id
	@Column(name="TWM_MEETING_ID")
	@SequenceGenerator(name = "MEETING_PK_GENERATOR", sequenceName = "CP055TWM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEETING_PK_GENERATOR")
	private Long meetingId;
	
	@Column(name="TWM_MEETING_NUMBER")
	private Long meetingNumber;
	
	@Column(name="TWM_MEETING_DATE")
	private Date meetingDate;
	
	@Column(name="TWM_EFF_DATE")
	private Date effDate;
	
	@Column(name="TWM_EXP_DATE")
	private Date expDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TWM_CYCLE_ID", insertable = true, updatable = false,nullable=false)
	private CapCycle capCycle;

	public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	

	public Long getMeetingNumber() {
		return meetingNumber;
	}

	public void setMeetingNumber(Long meetingNumber) {
		this.meetingNumber = meetingNumber;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public CapCycle getCapCycle() {
		return capCycle;
	}

	public void setCapCycle(CapCycle capCycle) {
		this.capCycle = capCycle;
	}
	
	

}
