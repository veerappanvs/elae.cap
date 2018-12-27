package edu.mass.doe.cap.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.mass.doe.cap.controllers.HomeController;
import edu.mass.doe.cap.security.EOEUser;
import edu.mass.doe.cap.util.CapUtil;

/**
 * The Class RequestInterceptor.
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = LoggerFactory.getLogger(RequestInterceptor.class);

	private static final long MAX_INACTIVE_SESSION_TIME = 5 * 10000;

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);


	/**
	 * Executed before actual handler is executed.
	 *
	 * @param request the request
	 * @param response the response
	 * @param handler the handler
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		
		
		boolean result=true;

		HttpSession session=request.getSession();
		
		if(session==null){
			response.sendRedirect(request.getContextPath() + "/home");
			return false;
		}
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		EOEUser eoeUser=(EOEUser) principal;
		if(eoeUser.getAuthorities().size() > 1 && !request.getRequestURI().equals("/cap/role")){
			response.sendRedirect(request.getContextPath() + "/role");
			return result;
		}
		
		 
		if(!CapUtil.isAdmin()&&request.getParameter("cycleId")!=null){
			
			if(session.getAttribute("cycles")==null){
				result=false;
				response.sendRedirect(request.getContextPath() + "/home");
			}
			
			result=((List<Long>)session.getAttribute("cycles")).contains(new Long(request.getParameter("cycleId")));
		}
		if(!result)
		response.sendRedirect(request.getContextPath() + "/home");

		return result;
	}

	/**
	 * Executed before after handler is executed.
	 *
	 * @param request the request
	 * @param response the response
	 * @param handler the handler
	 * @param model the model
	 * @throws Exception the exception
	 */
	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView model) throws Exception {


	}
}
