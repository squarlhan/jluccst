<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 * All right reserved.
	 */
	/**
	 * @author XXX
	 * @version 1.0
	 * @audit  
	 */
	/**
	 * Modified Person：
	 * Modified Time：
	 * Modified Explain：
	 */
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
	String companyId = StringUtils.defaultIfEmpty(request.getParameter("companyId"),"");
	String productId = StringUtils.defaultIfEmpty(request.getParameter("productId"),"-1");
	String parentKey = StringUtils.defaultIfEmpty(request.getParameter("parentKey"),"0");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true" />
		<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>
	</head>
	<body>
					<table width="100%" style="height: 100%;" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="200" valign="top" style="border-left: 1px solid #54a4e3; border-bottom: 1px solid #54a4e3;border-top: 1px solid #54a4e3;  border-right: 1px solid #54a4e3; padding: 5px;"><iframe width="100%" height="100%" id="menutree" name="menutree"frameborder="0" scrolling="auto" src="./menuAction!showMenuListForPopedom.action?companyId=<%=companyId%>&productId=<%=productId%>&parentKey=<%=parentKey%>"></iframe></td>
							<td valign="top" style="border-left: 1px solid #54a4e3; border-bottom: 1px solid #54a4e3; border-top: 1px solid #54a4e3; border-right: 1px solid #54a4e3; padding: 5px;"><iframe width="100%" height="100%" id="groupmain" name="groupmain" frameborder="0" scrolling="auto" src="about:blank"></iframe></td>
						</tr>
					</table>
	</body>
</html>
