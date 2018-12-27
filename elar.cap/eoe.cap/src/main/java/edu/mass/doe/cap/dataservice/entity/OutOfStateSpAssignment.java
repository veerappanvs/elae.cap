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
@Table(name = "CP052SOA_SP_OUTOFSTATE_ASGNMT")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "SOA_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "SOA_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "SOA_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "SOA_UPDATED_BY"))
})
public class OutOfStateSpAssignment extends BaseJPAEntity {

	
	@Id
	@Column(name="SOA_PER_ID")
	@SequenceGenerator(name = "CYCLE_PK_GENERATOR", sequenceName = "CP051CPA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CYCLE_PK_GENERATOR")
	private Long personId;
	
	@Column(name="SOA_PER_FIRST_NAME" )
	private String firstName;
	
	@Column(name="SOA_PER_LAST_NAME" )
	private String lastName;
	
	@Column(name="SOA_PRACTICUM_STATE" )
	private String state;
	
	@Column(name="SOA_PRACTICUM_DISTRICT" )
	private String district;
	
	@Column(name="SOA_PRACTICUM_SCHOOL_NAME" )
	private String school;
	
	@Column(name="SOA_PRACTICUM_SCHOOL" )
	private String districtType;
	
	@Column(name="SOA_EFF_DATE" )
	private Date effDate;
	
	@Column(name="SOA_EXP_DATE" )
	private Date expDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOA_CYCLE_ID", insertable = true, updatable = false,nullable=false)
	private CapCycle capCycle;


	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
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

	public String getDistrictType() {
		return districtType;
	}

	public void setDistrictType(String districtType) {
		this.districtType = districtType;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
