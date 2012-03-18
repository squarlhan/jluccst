/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ScriptJsTag.java 1.1 2011-2-11
 */
package com.boan.rees.utils.script;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.boan.rees.utils.path.PathUtil;

/**
 * 页面中Css，Js库的引用类
 * 
 * @author JiangHY
 * @version 1.0.0
 */
public class ScriptJsTag extends SimpleTagSupport
{
	/**
	 * 是否显示css链接
	 */
	private String css; 
	
	/**
	 * 是否显示jquery-lib支持
	 */
	private String jquerylib;
	
	/**
	 * 是否显示validate验证框架
	 */
	private String validate;
	
	/**
	 * 是否显示日期框
	 */
	private String date;
	
	/**
	 * 是否显示树型
	 */
	private String tree;
	
	
	@Override
	public void doTag() throws JspException, IOException
	{
		String contextPath = null;
		try
		{
			contextPath = PathUtil.getInstance().getContextPath();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		if( "true".equalsIgnoreCase( css ))
		{
			getJspContext().getOut().write( "<!--css-->\r\n" );
			getJspContext().getOut().write( "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7\" />\r\n" );
			getJspContext().getOut().write( "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + contextPath + "/css/style.css\"/>\r\n" );
		}
		if( "true".equalsIgnoreCase( jquerylib ))
		{
			getJspContext().getOut().write( "<!--jquery-lib-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery-1.4.2.min.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( validate ))
		{
			getJspContext().getOut().write( "<!--validate-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery-validate/jquery.validate.js\"></script>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery-validate/localization/messages_cn.js\"></script>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery-validate/custom-methods.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( date ))
		{
			getJspContext().getOut().write( "<!--css-->\r\n" );
			getJspContext().getOut().write( "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + contextPath + "/css/style.css\"/>\r\n" );
			getJspContext().getOut().write( "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + contextPath + "/css/font.css\"/>\r\n" );
		}
		if( "true".equalsIgnoreCase( tree ))
		{
			getJspContext().getOut().write( "<!--css-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/tree/dtree.js\"></script>\r\n" );
		}
		
	}

	public String getCss()
	{
		return css;
	}

	public void setCss( String css )
	{
		this.css = css;
	}

	public String getJquerylib()
	{
		return jquerylib;
	}

	public void setJquerylib( String jquerylib )
	{
		this.jquerylib = jquerylib;
	}

	public String getValidate()
	{
		return validate;
	}

	public void setValidate( String validate )
	{
		this.validate = validate;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate( String date )
	{
		this.date = date;
	}

	public String getTree()
	{
		return tree;
	}

	public void setTree( String tree )
	{
		this.tree = tree;
	}
}
