<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
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
<?xml version="1.0" encoding="iso-8859-1"?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<title>周报表曲线图</title>
    <script type="text/javascript" src="<%=basePath%>js/FusionCharts/FusionCharts.js"></script></head>   
<body>
        <div id="chartdiv" align="center">Chart will load here</div>
        <script type="text/javascript">
           var chart = new FusionCharts("<%=basePath%>js/FusionCharts/Charts/MSLine.swf", "ChartId", "750", "450", "0", "0");
		   chart.setDataURL( "<%=basePath%>/getWeeklyStatDataAction.action");		   
		   chart.render("chartdiv");
		</script>
</body>
 </html>

