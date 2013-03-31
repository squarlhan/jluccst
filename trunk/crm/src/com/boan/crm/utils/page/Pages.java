/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)Pages.java 1.1 2012-3-4
 */

package com.boan.crm.utils.page;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.components.Component;
import org.apache.struts2.dispatcher.StrutsRequestWrapper;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 构建分页标签体的类
 * 
 * @author ZhuYF
 * @version 1.0.0
 */
public class Pages extends Component {
	
	/**
	 * 请求对象
	 */
	private HttpServletRequest request;
	
	/**
	 * 当前页码
	 */
	private String currentPage;
	
	/**
	 * 总行数
	 */
	private String totalRows;
	
	/**
	 * 总页数
	 */
	private String totalPages;
	
	/**
	 * 分页的样式
	 */
	private String styleClass;
	
	/**
	 * 分页的主题
	 */
	private String theme;
	
	/**
	 * action的路径
	 */
	private String url;
	
	/**
	 * 路径的类型，主要用于URL重写的扩展
	 */
	private String urlType;
	
	/**
	 * 表单提交前的验证函数名称
	 */
	private String validateFunction;

	public Pages(ValueStack arg0, HttpServletRequest request) {
		super(arg0);
		this.request = request;
	}

	@Override
	public boolean end(Writer writer, String body) {
		boolean result = super.start(writer);
		try {
			// 从ValueStack中取出数值
			Object obj = this.getStack().findValue(currentPage);
			//保存绑定的字符串
			String currentPageBindStr = currentPage;
			currentPage = String.valueOf((Integer) obj);
			obj = this.getStack().findValue(totalPages);
			totalPages = String.valueOf((Integer) obj);
			obj = this.getStack().findValue(totalRows);
			totalRows = String.valueOf((Integer) obj);
          StringBuilder  urlParamStrB = new StringBuilder();	
//			Enumeration enumeration = request.getParameterNames();  
//            String name = null;  
//            String value = null;  

//            while (enumeration.hasMoreElements()) {  
//                name = (String) enumeration.nextElement();  
//                value = request.getParameter(name);  
//                value = new String( value.getBytes( "ISO8859-1" ), "GB2312" );
//                
//                urlParamStrB.append(name).append("=").append(value).append("&");
//            }
            
			StringBuilder str = new StringBuilder();
			Map cont = this.getStack().getContext();
			StrutsRequestWrapper req = (StrutsRequestWrapper) cont.get(StrutsStatics.HTTP_REQUEST);
			if (url == null || "".equals(url)) {
				url = (String) req.getAttribute("javax.servlet.forward.request_uri");
			}
			
			//存储Url参数和动态参数
			String urlParam = urlParamStrB.length()==0 ? "" : "?" + urlParamStrB.substring(0, urlParamStrB.toString().length()-1);
			
			//用来处理动态查询的参数，并拼接成url
			StringBuffer perUrl = new StringBuffer("");
			if (this.getParameters().size() != 0) {
				Iterator iter = this.getParameters().keySet().iterator();
				while (iter.hasNext()) {
					String key = (String) iter.next();
					Object o = this.getParameters().get(key);
					perUrl.append("&").append(key).append("=").append(o);
				}
				urlParam = urlParam.contains("?") ? urlParam + perUrl : urlParam + "?" + perUrl.substring(1);
			}
			
			
			if ("dir".equals(urlType)) {
				urlParam = "";
				if ("1".equals(currentPage)) {// 第一页时
					if (url.lastIndexOf("/") != url.length() - 1) {
						if (url.lastIndexOf("1") == url.length() - 1) {// 如果有页码1，则去掉1
							url = url.substring(0, url.length() - 1);
						} else if (url.lastIndexOf("/") != url.length() - 1) {// 如果没有页码1，并且最后不是'/'时，加上'/'
							url = url + "/";
						}
					}
				} else {
					url = url.substring(0, url.lastIndexOf("/") + 1);
				}
			}
			
			Integer cpageInt = Integer.valueOf(currentPage);
			str.append("<span ");
			if (styleClass != null) {
				str.append(" class='" + styleClass + "'>");
			} else {
				str.append(">");
			}
			// 文本样式
			if (theme == null || "text".equals(theme)) {
				// 当前页与总页数相等
				str.append(" 共[ " + totalRows + " ]条记录&nbsp;&nbsp;&nbsp;&nbsp;");
				String hrefStyle = "style=\"cursor:hand\" onmouseover=\"this.style.color='red'\" onmouseout=\"this.style.color='#0e4871'\" ";
				if (currentPage.equals(totalPages)) {
					if(currentPage.equals("1")){
						str.append("<a >首　页&nbsp;&nbsp;&nbsp;&nbsp;</a> ");
						str.append("<a >上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("下一页&nbsp;&nbsp;&nbsp;&nbsp;");
						str.append("尾　页&nbsp;&nbsp;&nbsp;&nbsp;");
						str.append("当前["+ currentPage + "/" + totalPages + "]页");
					}else{
						str.append("<a "+ hrefStyle +" onclick='javascript:turnOverPage(1)'>首　页&nbsp;&nbsp;&nbsp;&nbsp;</a> ");
						str.append("<a "+ hrefStyle +" onclick='javascript:turnOverPage("+ ( cpageInt - 1) + ")'>上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("下一页&nbsp;&nbsp;&nbsp;&nbsp;");
						str.append("尾　页&nbsp;&nbsp;&nbsp;&nbsp;");
						str.append("当前["+ currentPage + "/" + totalPages + "]页");
					}
				} else {
					// 当前页与总页数不相同
					if ("1".equals(currentPage)) {
						str.append("首　页&nbsp;&nbsp;&nbsp;&nbsp;");
						str.append("上一页&nbsp;&nbsp;&nbsp;&nbsp;");
						str.append("<a "+ hrefStyle +" onclick='javascript:turnOverPage("+ (cpageInt + 1) + ")'>下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("<a "+ hrefStyle +" onclick='javascript:turnOverPage("+totalPages + ")'>尾　页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("当前["+ currentPage + "/" + totalPages + "]页");
					} else {
						str.append("<a "+ hrefStyle +"  onclick='javascript:turnOverPage(1)'>首　页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("<a "+ hrefStyle +" onclick='javascript:turnOverPage("+ ( cpageInt - 1) + ")'>上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("<a "+ hrefStyle +" onclick='javascript:turnOverPage("+ (cpageInt + 1) + ")'>下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("<a  "+ hrefStyle +" onclick='javascript:turnOverPage("+totalPages + ")'>尾　页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
						str.append("当前["+ currentPage + "/" + totalPages + "]页");
					}
				}
			} else if ("number".equals(theme)) {//定义其他样式的分页条
				
			}
			str.append( "\r\n " );
			str.append( "<input type=\"hidden\" name=\"" + currentPageBindStr + "\" id=\"currentPage\" value=\"" + cpageInt + "\">\r\n " );
			// 分页用的javascript脚本
			str.append( "\r\n " );
			
			str.append( "<script language=\"javascript\">\r\n");  
			str.append( "  function turnOverPage(no){\r\n");  
			str.append( "    if(no>").append(totalPages).append("){");  
			str.append( "      no=").append(totalPages).append(";}\r\n");  
			str.append( "    if(no<1){no=1;}\r\n");  
			str.append( "document.forms[0].action = '" + url + urlParam + "';\r\n " );
			str.append( "document.forms[0].target = '';\r\n " );
			str.append( "document.getElementById(\"currentPage\").value = no;\r\n " );
			if(validateFunction!=null){
				str.append( "if(!" + validateFunction + "){\r\n");  
				str.append( "	return false;\r\n");  
				str.append( "}else{\r\n");  
				str.append( "	document.forms[0].submit();\r\n ");  
				str.append( "}\r\n");  
			}else{
				str.append( "document.forms[0].submit();\r\n " );
			}
			str.append("  }\r\n");  
			str.append("</script>\r\n");  
			str.append("</span>");

			writer.write(str.toString());

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlType() {
		return urlType;
	}

	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}

	public String getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(String totalRows) {
		this.totalRows = totalRows;
	}

	public String getValidateFunction() {
		return validateFunction;
	}

	public void setValidateFunction(String validateFunction) {
		this.validateFunction = validateFunction;
	}
}
