<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/page-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author yangGY
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
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>月计划报表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<j:scriptlink css="true" tipswindow="false" jmessagebox="true" jquery="true" validate="true" jfunction="true" />
<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
.myTable,.myTable td {   
    border:1px solid #000000;   
    border-collapse:collapse;  
}   
-->
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#closeBtn").click(function(){
		parent.$("#windown-close").click();
	});
});
</script>

</head>

<body>
	<center>
	<table width="100%" border="0" >
		<tr>
			<td>
				<div style="border:0px;padding:3px; PADDING:0px; height:470px; LINE-HEIGHT: 20px; OVERFLOW: auto; ">
				<table border="1" width="100%"   height="50%"   class="myTable">
					<tr>
						<td colspan="15"><strong><b>日期：<s:property value="weeklyMainInfo.planInterzone"></s:property></strong></b></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><strong><b>提交人：</strong></b></td>
						<td nowrap="nowrap"><strong><b><s:property value="weeklyMainInfo.personName"></s:property></strong></b></td>
						<td nowrap="nowrap"><strong><b>部门：</strong></b></td>
						<td nowrap="nowrap"><strong><b><s:property value="weeklyMainInfo.deptName"></s:property></strong></b></td>
						<td nowrap="nowrap"><strong><b>职务：</strong></b></td>
						<td nowrap="nowrap"><strong><b><s:property value="weeklyMainInfo.position"></s:property></strong></b></td>
						<td nowrap="nowrap"><strong><b>直接领导：</strong></b></td>
						<td nowrap="nowrap"><strong><b><s:property value="weeklyMainInfo.superior"></s:property></strong></b></td>
						<td nowrap="nowrap"><strong><b>检查人：</strong></b></td>
						<td nowrap="nowrap" colspan="6"><strong><b><s:property value="weeklyMainInfo.checker"></s:property></strong></b></td>
					</tr>
					<tr>
						<td nowrap="nowrap" rowspan="2"><strong><b>职责</strong></b></td>
						<td nowrap="nowrap" rowspan="2"><strong><b>周结果定义</strong></b></td>
						<td nowrap="nowrap" colspan="7"><strong><b>过程节点和完成时间</strong></b></td>
						<td nowrap="nowrap" rowspan="2"><strong><b>执行基金</strong></b></td>
						<td nowrap="nowrap" rowspan="2"><strong><b>实际完成的结果</strong></b></td>
						<td nowrap="nowrap" rowspan="2"><strong><b>未完成的原因</strong></b></td>
						<td nowrap="nowrap" rowspan="2"><strong><b>改进的措施</strong></b></td>
						<td nowrap="nowrap" rowspan="2" ><strong><b>新结果定义（承诺）</strong></b></td>
						<td nowrap="nowrap" rowspan="2"><strong><b>备注</strong></b></td>
					</tr>
					<tr>
						<td nowrap="nowrap"><strong><b>周一</strong></b></td>
						<td nowrap="nowrap"><strong><b>周二</strong></b></td>
						<td nowrap="nowrap"><strong><b>周三</strong></b></td>
						<td nowrap="nowrap"><strong><b>周四</strong></b></td>
						<td nowrap="nowrap"><strong><b>周五</strong></b></td>
						<td nowrap="nowrap"><strong><b>周六</strong></b></td>
						<td nowrap="nowrap"><strong><b>周日</strong></b></td>
					</tr>
					<s:iterator value="weeklyItemInfoList" status="obj">
					<tr>
						<td  style="word-break : break-all; "><s:property value="sellDutyName"/></td>
						<td  style="word-break : break-all; "><s:property value="weekResult"/></td>
						<td  style="word-break : break-all; "><s:property value="monday"/></td>
						<td  style="word-break : break-all; "><s:property value="tuesday"/></td>
						<td  style="word-break : break-all; "><s:property value="wednesday"/></td>
						<td  style="word-break : break-all; "><s:property value="thursday"/></td>
						<td  style="word-break : break-all; "><s:property value="friday"/></td>
						<td  style="word-break : break-all; "><s:property value="saturday"/></td>
						<td  style="word-break : break-all; "><s:property value="sunday"/></td>
						<td  style="word-break : break-all; "><s:property value="executeMoney"/></td>
						<td  style="word-break : break-all; "><s:property value="superiorResult"/></td>
						<td  style="word-break : break-all; "><s:property value="superiorReason"/></td>
						<td  style="word-break : break-all; "><s:property value="superiorMethod"/></td>
						<td  style="word-break : break-all; "><s:property value="nextMonthlyResult"/></td>
						<td  style="word-break : break-all; "><s:property value="memo"/></td>
					</tr>
					</s:iterator>
				</table>
			</div>
				
			</td>
		</tr>
		<tr>
			<td align="center" height="30">
				<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="打印"  onclick="javascript:window.print();" >&nbsp;&nbsp;
				<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
			</td>
		</tr>
	</table>
	
	</center>
</body>
</html>
