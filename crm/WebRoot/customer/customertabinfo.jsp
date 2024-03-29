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
		$("#tt").css("width",$("#mainFrame",parent.document).width());
		$("#tt").css("height",$("#mainFrame",parent.document).height());
		$("#tt").tabs();
	});
//-->
</script>
<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>
</head>
<title>客户信息录入</title>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table id="__01" width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="11"><img src="../images/header_01.jpg" width="11" height="36" alt=""></td>
          <td background="../images/header_02.jpg"><span class="STYLE1">您当前的位置：客户管理&gt;&gt;&gt;客户详细信息</span></td>
          <td width="12"><img src="../images/header_03.jpg" width="12" height="36" alt=""></td>
        </tr>
        </table>
    </td>
  </tr>
</table>
<div id="tt" class="tabs-container" style="width:100%">
	<div title="基本信息"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="customerInfo.action?id=<s:property value='id'/>&deptId=<s:property value='deptId'/>"></iframe>
	</div>
	<s:if test='id!=null && id.length() > 0'>
	<div title="客户跟进"
		style="padding: 1px; display: none;" id="traceDiv">
		<iframe id="traceDivFrame" scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="customerTraceList.action?customerId=<s:property value='id'/>&deptId=<s:property value='deptId'/>"></iframe>
	</div>
	<div title="销售记录"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="../openSellRecordListForCustomerAction.action?customerId=<s:property value='id'/>"></iframe>
	</div>
	<s:if test="customerInfo != null && (customerInfo.progressId.equals('DEALED') || customerInfo.progressId.equals('VISIT'))">
	<div title="客户回访"
		style="padding: 1px; display: none;" id="visitDiv">
		<iframe id="visitDivFrame" scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="customerVisitList.action?customerId=<s:property value='id'/>&deptId=<s:property value='deptId'/>"></iframe>
	</div>
	</s:if>
	<s:if test='!teamFlag'>
	<div title="服务记录"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="../service/serviceloglistbycustomer.action?companyId=<s:property value='id'/>"></iframe>
	</div>
	</s:if>
	<div title="客户评估"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="../customerassessment/staticAnalysisCustomer.action?customerId=<s:property value='id'/>&option=customer"></iframe>
	</div>
	</s:if>
</div>
</body>
</html>

