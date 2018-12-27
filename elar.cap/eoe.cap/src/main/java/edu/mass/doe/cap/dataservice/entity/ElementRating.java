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
@Table(name = "CP009REL_RATING_ELEMENT_LINK")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "REL_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "REL_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "REL_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "REL_UPDATED_BY"))
})
public class ElementRating extends BaseJPAEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1898534323447844628L;

	@Id
	@Column(name="REL_RATING_ELEMENT_LINK_ID")	
	private Long linkId;
	
	@Column(name="REL_RATING_CODE")	
	private String ratingCode;
	
	@Column(name="REL_ELEMENT_CODE")	
	private String elementCode;
	
	@Column(name="REL_RUB_RATING_LONG_DESC")	
	private String longDesc;
	
	@Column(name="REL_RUB_RATING_SHORT_DESC")	
	private String shortDesc;
	
	
	@Column(name="REL_EXP_DATE")	
	private Date expDate;	
	
	@Column(name="REL_EFF_DATE")	
	private Date effDate;	
		


	public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public String getRatingCode() {
		return ratingCode;
	}

	public void setRatingCode(String ratingCode) {
		this.ratingCode = ratingCode;
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

	public String getElementCode() {
		return elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	

	
}
