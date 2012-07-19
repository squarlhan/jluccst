<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>柱状图</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<j:scriptlink jquery="true" chart="true"/>
</head>

<body>
	<div id="pointdiv" align="center" style="padding:5px;">
		<input type="text" name="textfield" id="textfield" style="width:80px" />
		<input type="text" name="textfield2" id="textfield2" style="width:80px" />
		<select id="pointselect">
					<option value="fdasf">监测点一</option>
					<option value="fdasf">监测点二</option>
					<option value="fdasf">监测点三</option>
		</select>
	</div>
	<div id="chartdiv" align="center"></div>
	<script type="text/javascript">
		var chart = new FusionCharts("../js/FusionCharts/Charts/FCF_MSLine.swf", "ChartId", "650", "490");
		chart.setDataURL("datamanage/deviceColumnStatLineAction.action?chart=<s:property value='deviceId'/>|<s:property value='selectYear'/>|<s:property value='selectWeek'/>");
		chart.render("chartdiv");
	</script>
</body>
</html>
