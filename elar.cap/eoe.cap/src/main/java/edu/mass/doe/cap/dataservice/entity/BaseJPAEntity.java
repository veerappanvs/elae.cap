package edu.mass.doe.cap.dataservice.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OptimisticLockException;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import edu.mass.doe.cap.security.EOEUser;


@SuppressWarnings("serial")
@MappedSuperclass
public class BaseJPAEntity implements Serializable {

	private static Logger logger = LoggerFactory.getLogger(BaseJPAEntity.class);

	@Temporal(TemporalType.TIMESTAMP)
	@Column( insertable = true, updatable = false)
	private Date createDate;

	@Column(insertable = true, updatable = false)
	private Long createUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column( insertable = true, updatable = true)
	private Date modifyDate;

	@Column(insertable = true, updatable = true)
	private Long modifyUser;
/*
	@Version
	private Long version;
*/	
	

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		BaseJPAEntity.logger = logger;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(Long modifyUser) {
		this.modifyUser = modifyUser;
	}

	
	
	public Long getUserId(){
		Long userId=25L;
		if(SecurityContextHolder.getContext().getAuthentication()!=null){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		EOEUser userContext = (EOEUser) authentication.getPrincipal();
		userId=userContext.getPersonId();
		}
		return userId;
	}


	@PreUpdate
	public void processAuditValueForUpdate() {
		setModifyUser(getUserId());
		Date now = new Date();
		setModifyDate(now);	}

	@PrePersist
	public void handleCreation() {
		setCreateUser(getUserId());
		setModifyUser(getUserId());
		Date now = new Date();
		setCreateDate(now);
		setModifyDate(now);
	}
	
	
	

}
