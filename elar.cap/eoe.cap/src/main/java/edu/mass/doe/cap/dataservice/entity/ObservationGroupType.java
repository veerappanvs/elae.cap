package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CP003OGT_OBS_GROUP_TYP")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "OGT_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "OGT_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "OGT_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "OGT_UPDATED_BY"))
})
public class ObservationGroupType extends BaseJPAEntity {
	@Id
	@Column(name="OGT_OBS_GROUP_CODE")	
	private String groupCode;
	
	@Column(name="OGT_OBS_GROUP_DESC")	
	private String groupDesc;
	
	@Column(name="OGT_EXP_DATE")	
	private Date expDate;
	
	@Column(name="OGT_EFF_DATE")	
	private Date effDate;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
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
