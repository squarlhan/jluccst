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

	
	List list = ( List ) request.getAttribute( "object" );
	String format = (String) request.getAttribute( "format" );
	//获取请求参数
	StringBuffer sb = new StringBuffer();
	if (list != null && list.size() > 0) {
		sb.append("{");
		CalendarJsonValueProcessor processor = new CalendarJsonValueProcessor("yyyy-MM-dd");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Calendar.class, processor);
		sb.append("root:" + JSONSerializer.toJSON(list, jsonConfig ).toString());
		sb.append("}");
	} else {
		sb.append("{root:[]}");
	}
	response.getWriter().write(sb.toString(  ));
%>