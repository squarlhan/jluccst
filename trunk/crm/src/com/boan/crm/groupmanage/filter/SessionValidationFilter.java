/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)SessionValidationFilter.java 1.1 Jun 8, 2010
 */
package com.boan.crm.groupmanage.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boan.crm.groupmanage.common.UserSession;

/**
 * XXX 类
 * @author XXX
 * @version 1.0.0
 */
public class SessionValidationFilter implements Filter
{
	private String logon_page;
	private String logon_action;
	private String logout_action;
	private String pin_login_action;
	private String pin_logon_valid;
	private String logon_page_admin;
	protected FilterConfig filterConfig;   
	private String targetEncoding="utf-8";   
	public void init( FilterConfig filterconfig ) throws ServletException
	{
		logon_page = "/default.jsp";
		logon_page_admin = "/admin.jsp";
		logon_action = "/logonValidAction.action";
		logout_action = "/logoutAction.action";
		pin_login_action = "/pinLoginAction.action";
		pin_logon_valid = "/pinLogonValidAction.action";
		this.filterConfig=filterconfig;   
	    this.targetEncoding=filterconfig.getInitParameter("encoding"); 
	}

	public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain ) throws IOException, ServletException
	{

		HttpServletRequest httpReq = ( HttpServletRequest ) req;
		HttpServletResponse httpResp = ( HttpServletResponse ) resp;
		HttpSession session = httpReq.getSession( false );
		String request_uri = httpReq.getRequestURI();
		String ctxPath = httpReq.getContextPath();
		String uri = request_uri.substring( ctxPath.length() );
		if( !logon_page.equalsIgnoreCase( uri ) &&  !logon_action.equalsIgnoreCase( uri ) 
					&&  !"/".equalsIgnoreCase( uri ) && !logout_action.equalsIgnoreCase( uri ) 
					&&  !pin_login_action.equalsIgnoreCase( uri )
					&&  !pin_logon_valid.equalsIgnoreCase( uri )
					&& !logon_page_admin.equalsIgnoreCase(uri))
		{
			if( uri.indexOf("ForPhone") != -1 )
			{
				chain.doFilter(req, resp);    
				return;
			}
			if( session == null )
			{
				popToError( httpResp, ctxPath + logon_page );
				return;
			}
			UserSession userSession = (UserSession)session.getAttribute( "userSession" );
			
			if( userSession == null )
			{
				popToError( httpResp, ctxPath + logon_page );
				return;
			}
		}
		//req.setCharacterEncoding(targetEncoding);   
		chain.doFilter(req, resp);    
	}

	private void popToError( HttpServletResponse response, String loginURL )
	{

		try
		{
			String inErrStr = "\u7528\u6237\u4F1A\u8BDD\u8D85\u65F6\uFF0C\u8BF7\u91CD\u65B0\u767B\u5F55\uFF01";
			PrintWriter out = response.getWriter();
			response.setContentType( "text/html;charset=utf-8" );
			response.addHeader( "Cache-Control", "no-store,no-cache,must-revalidate" );
			response.addHeader( "Cache-Control", "post-check=0,pre-check=0" );
			response.addHeader( "Expires", "0" );
			response.addHeader( "Pragma", "no-cache" );
			response.setCharacterEncoding( "utf-8" );
			out.println( "<html><head>" );
			out.println( "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" );
			out.println( "<title>" + inErrStr + "</title></head>" );
			out.println( "<script language=javascript>" );
			out.println( "alert(\'"+ inErrStr +"\');" );
			out.println( "top.location.href=\"" + loginURL + "\"" );
			out.println( "</script>" );
			out.println( "<body></body></html>" );
			out.flush();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}

	public void destroy()
	{
	}
}
