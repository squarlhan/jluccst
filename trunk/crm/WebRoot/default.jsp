<%@page import="com.boan.crm.groupmanage.security.CheckProductKey"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	CheckProductKey.pinLogin = false;
%>
<html>
<head>
<title>---系统登录---</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<j:scriptlink css="true" jquery="true" jfunction="true" tipswindow="true"></j:scriptlink>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="background-color: #1675b7;" onload="validmessage()">
	<%
		if (!CheckProductKey.pinLogin) {
	%>
	<jsp:include page="default_inc_user.jsp" flush="true" />
	<%
		} else {
	%>
	<jsp:include page="default_inc_pin.jsp" flush="true" />
	<%
		}
	%>
	<iframe width="1px" height="1px" id="iframe1" name="iframe1"></iframe>
</body>
</html>