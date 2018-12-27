package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CP007RRT_RUBRIC_RATING_TYP")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "RRT_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "RRT_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "RRT_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "RRT_UPDATED_BY"))
})
public class RatingType extends BaseJPAEntity  {
	
	
	@Id
	@Column(name="RRT_RUB_RATING_CODE")	
	private String ratingCode;
	
	@Column(name="RRT_RUB_RATING_DESC")	
	private String desc;
	
	@Column(name="RRT_RUB_RATING_SHORT_DESC")	
	private String shortDesc;
	
	@Column(name="RRT_RUB_RATING_LONG_DESC")	
	private String longDesc;
	
	
	@Column(name="RRT_EXP_DATE")	
	private Date expDate;	
	
	@Column(name="RRT_EFF_DATE")	
	private Date effDate;

	public String getRatingCode() {
		return ratingCode;
	}

	public void setRatingCode(String ratingCode) {
		this.ratingCode = ratingCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
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
