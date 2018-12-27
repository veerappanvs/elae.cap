package edu.mass.doe.cap.dataservice.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CP076EGN_EMAIL_GENERATION")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "EGN_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "EGN_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "EGN_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "EGN_UPDATED_BY"))
})
public class EmailGenerationControl extends BaseJPAEntity {
	
	
	@Id
	@Column(name="EGN_ID")
	private Long egnId;
	
	@Column(name="EGN_EMAIL_TRIGGER_QUERY")
	private String slectionQuery;
	
	@Column(name="EGN_RECIPIENT_QUERY" )
	private String emailQuery;
	
	@Column(name="EGN_RECIPIENT_COLPARAMS" )
	private String params;
	
	@Column(name="EGN_UPDATE_QUERY" )
	private String updateQuery;
	
	@Column(name="EGN_UPDATE_COLPARAMS" )
	private String updateParams;
	
	@Column(name="EGN_CET_TYPE_CODE" )
	private String typeCode;

	public Long getEgnId() {
		return egnId;
	}

	public void setEgnId(Long egnId) {
		this.egnId = egnId;
	}

	public String getSlectionQuery() {
		return slectionQuery;
	}

	public void setSlectionQuery(String slectionQuery) {
		this.slectionQuery = slectionQuery;
	}

	public String getEmailQuery() {
		return emailQuery;
	}

	public void setEmailQuery(String emailQuery) {
		this.emailQuery = emailQuery;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getUpdateQuery() {
		return updateQuery;
	}

	public void setUpdateQuery(String updateQuery) {
		this.updateQuery = updateQuery;
	}

	public String getUpdateParams() {
		return updateParams;
	}

	public void setUpdateParams(String updateParams) {
		this.updateParams = updateParams;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	
	
	

}

