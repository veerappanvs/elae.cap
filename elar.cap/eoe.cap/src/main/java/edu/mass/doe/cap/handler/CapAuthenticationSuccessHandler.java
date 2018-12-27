package edu.mass.doe.cap.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import edu.mass.doe.cap.security.EOEUser;


/**
 * The Class CapAuthenticationSuccessHandler.
 */
@Component
public class CapAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	

	@Autowired
	private Environment env;
	
	
	protected Logger logger = LoggerFactory.getLogger(CapAuthenticationSuccessHandler.class);
	 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		EOEUser eoeUser=	(EOEUser) authentication.getPrincipal();
		
		
		if(eoeUser.getAuthorities().size()>1)		
		response.sendRedirect("/cap/switchuser");
			
	}
	
	
 

}
