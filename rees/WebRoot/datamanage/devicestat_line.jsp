<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>柱状图</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<j:scriptlink css="true" jquery="true" chart="true"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	<!--
	$(document).ready(function() {
		$("#beginTime").click(function(){WdatePicker({el:'beginTime',dateFmt:'yyyy-MM-dd'});});
		$("#endTime").click(function(){WdatePicker({el:'endTime',dateFmt:'yyyy-MM-dd'});});
		$("#selectBtn").click(function() {
			window.location.href="${pageContext.request.contextPath}/datamanage/devicestatline.action?deviceId=" + $("#deviceId").val() + "&pointId=" + $("#pointlist").val() + "&beginTime=" + $("#beginTime").val() + "&endTime=" + $("#endTime").val() + "";
		});
	});
	//-->
	</script>
</head>

<body>
	<div id="pointdiv" align="center" style="padding:5px;">
		<s:hidden name="deviceId" />
		开始日期: 
		<s:textfield id="beginTime" name="beginTime" cssClass="Wdate" cssStyle="width:120px;" readonly="true"/>
		结束日期: 
		<s:textfield id="endTime" name="endTime" cssClass="Wdate" cssStyle="width:120px;" readonly="true"/>
		监测点：<s:select name="pointlist" id="pointlist" list="pointInfos" listKey="id" listValue="controlPointName"  value="pointId"></s:select>
		<input name="selectBtn" id="selectBtn" type="button" class="btn_2_3" value="查看">
	</div>
	<div id="chartdiv" align="center"></div>
	<script type="text/javascript">
		var chart = new FusionCharts("${pageContext.request.contextPath}/js/FusionCharts/Charts/FCF_MSLine.swf", "ChartId", "820", "490");
		chart.setDataURL("${pageContext.request.contextPath}/datamanage/deviceColumnStatLineAction.action?chart=<s:property value='pointId'/>|<s:property value='beginTime'/>|<s:property value='endTime'/>|<s:property value='deviceId'/>");
		chart.render("chartdiv");
	</script>
</body>
</html>
