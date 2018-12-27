package edu.mass.doe.cap.dataservice.entity;

import java.io.Serializable;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import edu.mass.doe.cap.security.EOEUser;

public class SimpleAuditIdentity  implements AuditIdentity, Serializable  {

	private static final long serialVersionUID = -3426657714422211111L;
	private Long personId;

    public SimpleAuditIdentity() {
    	
    	
    	
    };

    /**
     * Returns the string to be logged in the create_user and/or modify_user audit columns of GMAS DB tables.
     * @return String - The audit identity String 
     */
    public Long getAuditIdentity(){
        return personId;
    }

    public SimpleAuditIdentity(Long personId) {
    	personId =this.personId;
    } 

}
