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

import org.hibernate.annotations.Where;

@Entity
@Table(name = "CP055RUM_RUBRIC_MAP")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "RUM_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "RUM_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "RUM_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "RUM_UPDATED_BY"))
})
public class RubricMap  extends BaseJPAEntity  {
	
	@Id
	@Column(name="RUM_RUBRIC_MAP_ID")
	@SequenceGenerator(name = "RUM_PK_GENERATOR", sequenceName = "CP055RUM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RUM_PK_GENERATOR")
	private Long mapId;
	

	@Column(name="RUM_RUBRIC_DIMENSION_CODE")
	private String dimensionCode;

	@Column(name="RUM_RATING_ELEMENT_LINK_ID")
	private Long ratingElementLinkId;
	
	@Column(name="RUM_EXP_DATE")
	private Date expDate;
	
	@Column(name="RUM_EFF_DATE")
	private Date effdate;
		
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RUM_ASSESSMENT_ID", insertable = true, updatable = false,nullable=false)
	private Assessment assessment;	
	

	public Date getExpDate() {
		return expDate;
	}


	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}


	public Date getEffdate() {
		return effdate;
	}


	public void setEffdate(Date effdate) {
		this.effdate = effdate;
	}




	public Assessment getAssessment() {
		return assessment;
	}


	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}


	public Long getMapId() {
		return mapId;
	}


	public void setMapId(Long mapId) {
		this.mapId = mapId;
	}


	public String getDimensionCode() {
		return dimensionCode;
	}


	public void setDimensionCode(String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}


	public Long getRatingElementLinkId() {
		return ratingElementLinkId;
	}


	public void setRatingElementLinkId(Long ratingElementLinkId) {
		this.ratingElementLinkId = ratingElementLinkId;
	}


	

}




