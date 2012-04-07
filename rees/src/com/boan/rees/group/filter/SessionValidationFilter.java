/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)SessionValidationFilter.java 1.1 Jun 8, 2010
 */
package com.boan.rees.group.filter;

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

import com.boan.rees.group.common.UserSession;


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
	protected FilterConfig filterConfig;   
	private String targetEncoding="utf-8";   
	public void init( FilterConfig filterconfig ) throws ServletException
	{
		logon_page = "/default.jsp";
		logon_action = "/logonValidAction.action";
		logout_action = "/logoutAction.action";
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
					&& !"/".equalsIgnoreCase( uri ) && !logout_action.equalsIgnoreCase( uri ) )
		{
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
			//String inErrStr = new String("\u83b7\u53d6\u767b\u5f55\u4fe1\u606f\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\uff01".getBytes("utf-8"),"iso-8859-1");//获取登录信息失败，请重新登录！
			String inErrStr = "session is null !";
			PrintWriter out = response.getWriter();
			response.setContentType( "text/html;charset=utf-8" );
			response.addHeader( "Cache-Control", "no-store,no-cache,must-revalidate" );
			response.addHeader( "Cache-Control", "post-check=0,pre-check=0" );
			response.addHeader( "Expires", "0" );
			response.addHeader( "Pragma", "no-cache" );
			response.setCharacterEncoding( "utf-8" );
			out.println( "<html><head>" );
			out.println( "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" );
			out.println( "<title>Session is null</title></head>" );
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
