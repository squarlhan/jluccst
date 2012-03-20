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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.boan.rees.utils.path.PathUtil;

/**
 * 页面中Css，Js库的引用类
 * 
 * @author JiangHY, Leon
 * @version 1.0.0
 */
public class ScriptJsTag extends SimpleTagSupport
{
	/**
	 * 是否显示css链接
	 */
	private String css; 
	
	/**
	 * 是否显示jquery支持
	 */
	private String jquery;
	
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
	
	/**
	 * 气泡提示插件
	 */
	private String poshytip;
	
	/**
	 * jquery绑定插件
	 */
	private String livequery;
	
	/**
	 * jqueryUI
	 */
	private String jqueryui;
	
	/**
	 * 右键菜单
	 */
	private String contextmenu;
	
	/**
	 * 弹出窗口
	 */
	private String tipswindow;
	
	/**
	 * jquery界面布局框架
	 */
	private String jquerylayout;
	
	/**
	 * jquery提示插件
	 */
	private String jmessagebox;
	
	/**
	 * jqueryTab插件
	 */
	private String tab;
	
	/**
	 * MzTreeView树
	 */
	private String mztreeview;
	
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
		if( "true".equalsIgnoreCase( jquery ))
		{
			getJspContext().getOut().write( "<!--jquery-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery-1.4.2.min.js\"></script>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/external/bgiframe/jquery.bgiframe.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( validate ))
		{
			getJspContext().getOut().write( "<!--validate-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery-validation-1.9.0/jquery.validate.js\"></script>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery-validation-1.9.0/localization/messages_cn.js\"></script>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery-validation-1.9.0/custom-methods.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( date ))
		{
			getJspContext().getOut().write( "<!--date-->\r\n" );
			//getJspContext().getOut().write( "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + contextPath + "/css/style.css\"/>\r\n" );
			//getJspContext().getOut().write( "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + contextPath + "/css/font.css\"/>\r\n" );
		}
		if( "true".equalsIgnoreCase( tree ))
		{
			getJspContext().getOut().write( "<!--tree-->\r\n" );
			getJspContext().getOut().write( "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + contextPath + "/js/tree/dtree.css\"/>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/tree/dtree.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( poshytip ))
		{
			getJspContext().getOut().write( "<!--poshytip-->\r\n" );
			getJspContext().getOut().write( "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + contextPath + "/js/poshytip/tip-twitter.css\"/>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/poshytip/jquery.poshytip.min.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( livequery ))
		{
			getJspContext().getOut().write( "<!--livequery-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery.livequery.min.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( jqueryui ))
		{
			getJspContext().getOut().write( "<!--jqueryui-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/ui/jquery.ui.core.js\"></script>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/ui/jquery.ui.widget.js\"></script>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/ui/jquery.ui.mouse.js\"></script>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/ui/jquery.ui.draggable.js\"></script>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/ui/jquery.ui.droppable.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( contextmenu ))
		{
			getJspContext().getOut().write( "<!--contextmenu-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery.contextmenu.r2.packed.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( tipswindow ))
		{
			getJspContext().getOut().write( "<!--tipswindow-->\r\n" );
			getJspContext().getOut().write( "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + contextPath + "/js/tipswindow/tipswindow.css\"/>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/tipswindow/tipswindow.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( jquerylayout ))
		{
			getJspContext().getOut().write( "<!--jquerylayout-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jquery.layout-latest.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( jmessagebox ))
		{
			getJspContext().getOut().write( "<!--jmessagebox-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/jmessagebox-1.0.1.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( tab ))
		{
			getJspContext().getOut().write( "<!--tab-->\r\n" );
			getJspContext().getOut().write( "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + contextPath + "/js/tab/tabs.css\"/>\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/tab/jquery.tab.js\"></script>\r\n" );
		}
		if( "true".equalsIgnoreCase( mztreeview ))
		{
			getJspContext().getOut().write( "<!--MzTreeView-->\r\n" );
			getJspContext().getOut().write( "<script type=\"text/javascript\" src=\"" + contextPath + "/js/mztreeview/jsframework.js\"></script>\r\n" );
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

	public String getJquery()
	{
		return jquery;
	}

	public void setJquery( String jquery )
	{
		this.jquery = jquery;
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

	public String getPoshytip() {
		return poshytip;
	}

	public void setPoshytip(String poshytip) {
		this.poshytip = poshytip;
	}

	public String getLivequery() {
		return livequery;
	}

	public void setLivequery(String livequery) {
		this.livequery = livequery;
	}

	public String getJqueryui() {
		return jqueryui;
	}

	public void setJqueryui(String jqueryui) {
		this.jqueryui = jqueryui;
	}

	public String getContextmenu() {
		return contextmenu;
	}

	public void setContextmenu(String contextmenu) {
		this.contextmenu = contextmenu;
	}

	public String getTipswindow() {
		return tipswindow;
	}

	public void setTipswindow(String tipswindow) {
		this.tipswindow = tipswindow;
	}

	public String getJquerylayout() {
		return jquerylayout;
	}

	public void setJquerylayout(String jquerylayout) {
		this.jquerylayout = jquerylayout;
	}

	public String getJmessagebox() {
		return jmessagebox;
	}

	public void setJmessagebox(String jmessagebox) {
		this.jmessagebox = jmessagebox;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getMztreeview() {
		return mztreeview;
	}

	public void setMztreeview(String mztreeview) {
		this.mztreeview = mztreeview;
	}
}
