<%@page import="com.boan.crm.utils.json.CalendarJsonValueProcessor"%>
<%@page import="com.boan.crm.utils.json.JsonValueInvisibleFilter"%>
<%@page import="com.boan.crm.utils.json.CalendarJsonValueProcessor"%>
<%@page import="com.boan.crm.utils.json.JsonValueInvisible"%>
<%@page import="net.sf.json.JsonConfig"%>
<%@page import="net.sf.json.JSONSerializer"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%
	response.addHeader( "Cache-Control", "no-store,no-cache,must-revalidate" );
	response.addHeader( "Cache-Control", "post-check=0,pre-check=0" );
	response.addHeader( "Expires", "0" );
	response.addHeader( "Pragma", "no-cache" );
	request.setCharacterEncoding( "utf-8" );
	response.setCharacterEncoding( "utf-8" );

	if(request.getAttribute( "info" )!=null){
		response.getWriter().write(request.getAttribute( "info" ).toString());
	}else{
		response.getWriter().write("{}");
	}
%>