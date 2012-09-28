<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>柱状图</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<j:scriptlink css="true" jquery="true" chart="true"/>
	<script type="text/javascript">
	<!--
	$(document).ready(function() {
		$("#gotoBtn").click(function() {
			window.location.href="${pageContext.request.contextPath}/datamanage/devicestatline.action?deviceId=" + $("#deviceId").val() + "&pointId=" + $("#pointlist").val() + "&selectYear=" + $("#yearlist").val() + "&selectFromWeek=" + $("#weekfromlist").val() + "&selectWeek=" + $("#weektolist").val() + "";
		});
	});
	//-->
	</script>
</head>

<body>
	<div id="pointdiv" align="center" style="padding:5px;">
		<s:hidden name="deviceId" />
		<s:select name="yearlist" id="yearlist" list="yearList" cssStyle="width:80px;" listKey="value" listValue="text" value="selectYear"></s:select>
		<s:select name="weekfromlist" id="weekfromlist" list="weekList" cssStyle="width:80px;" listKey="value" listValue="text" value="selectFromWeek"></s:select>
		<s:select name="weektolist" id="weektolist" list="weekList" cssStyle="width:80px;" listKey="value" listValue="text" value="selectWeek"></s:select>
		<s:select name="pointlist" id="pointlist" list="pointInfos" cssStyle="width:120px;" listKey="id" listValue="controlPointName"  value="pointId"></s:select>
		<input id="gotoBtn" class="btn_4" type="button" value="查看"  />
	</div>
	<div id="chartdiv" align="center"></div>
	<script type="text/javascript">
		var chart = new FusionCharts("${pageContext.request.contextPath}/js/FusionCharts/Charts/FCF_MSLine.swf", "ChartId", "820", "490");
		chart.setDataURL("${pageContext.request.contextPath}/datamanage/deviceColumnStatLineAction.action?chart=<s:property value='pointId'/>|<s:property value='selectYear'/>|<s:property value='selectFromWeek'/>|<s:property value='selectWeek'/>|<s:property value='deviceId'/>");
		chart.render("chartdiv");
	</script>
</body>
</html>
