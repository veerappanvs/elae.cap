package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CP074ANN_ANNOUNCEMENT")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "ANN_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "ANN_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "ANN_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "ANN_UPDATED_BY"))
})
public class Announcement extends BaseJPAEntity {
	@Id
	@Column(name="ANN_ANNOUNCEMENT_ID")
	@SequenceGenerator(name = "ANN_PK_GENERATOR", sequenceName = "CP074ANN_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANN_PK_GENERATOR")
	private Long announcementId;
	
	@Column(name="ANN_ANNOUCEMENT")
	private String text;
	
	@Column(name="ANN_EXP_DATE")
	private Date expDate;
	
	@Column(name="ANN_EFF_DATE")
	private Date effDate;

	public Long getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
	
}
