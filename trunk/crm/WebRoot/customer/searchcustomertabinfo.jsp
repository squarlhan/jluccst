<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author Luojx
 * @version 1.0
 * @audit  
 */
/**
 * Modified Person：
 * Modified Time：
 * Modified Explain：
 */
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String id = request.getParameter("id");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
<link type="text/css" rel="stylesheet" href="../css/tabs.css">
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../js/tab/jquery.tab.js"></script>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		$("#tt").css("width",$("#groupmain",parent.document).width());
		$("#tt").css("height",$("#groupmain",parent.document).height());
		$("#tt").tabs();
	});
//-->
</script>
</head>
<title>客户信息录入</title>
<body>
<div id="tt" class="tabs-container" style="width:100%">
	<div title="基本信息"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:450px"
			src="searchCustomerInfo.action?id=<s:property value='id'/>"></iframe>
	</div>
	<s:if test='id!=null && id.length() > 0'>
	<div title="客户跟进"
		style="padding: 1px; display: none;" id="traceDiv">
		<iframe id="traceDivFrame" scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="searchCustomerTraceList.action?customerId=<s:property value='id'/>"></iframe>
	</div>
	<div title="销售记录"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="../openSellRecordListForCustomerViewAction.action?customerId=<s:property value='id'/>"></iframe>
	</div>
	<div title="客户回访"
		style="padding: 1px; display: none;" id="visitDiv">
		<iframe id="visitDivFrame" scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="searchCustomerVisitList.action?customerId=<s:property value='id'/>"></iframe>
	</div>
	<div title="服务记录"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="../service/serviceloglist.action?companyId=<s:property value='id'/>"></iframe>
	</div>
	</s:if>
</div>
</body>
</html>

