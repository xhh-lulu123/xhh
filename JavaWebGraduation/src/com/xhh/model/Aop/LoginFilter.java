package com.xhh.model.Aop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;









/**
 * Servlet Filter implementation class LoginFolret
 */
public class LoginFilter implements Filter {
	 
    
    public LoginFilter() {
       
    }

	
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsq = (HttpServletRequest)request;
		HttpServletResponse hsp = (HttpServletResponse)response;
		HttpSession session = hsq.getSession(false);
		String path = hsq.getRequestURI();
		String contextPath = hsq.getContextPath();
		System.out.println(path);
		System.out.println(contextPath);
		System.out.println("Ö´ÐÐÀ¹½ØÆ÷*************************");
		if(path.contains("index")||path.contains("login")){
			chain.doFilter(hsq, hsp);
			return;
		}
		if(session==null){
			hsp.sendRedirect(contextPath+"/index.jsp");
		}else if(session.getAttribute("user")==null){
			System.out.println("Ö´ÐÐÀ¹½ØÆ÷*************ÎÞuser");
			request.setAttribute("path", path);
			hsp.sendRedirect(contextPath+"/index.jsp");
		}else{
			chain.doFilter(hsq, hsp);
			
		}
	}	 
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
