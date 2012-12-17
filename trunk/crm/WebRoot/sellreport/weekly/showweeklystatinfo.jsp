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
	<j:scriptlink jquery="true"  css="true"/>
    <script type="text/javascript" src="<%=basePath%>js/FusionCharts/FusionCharts.js"></script>
    <!--[if IE 6]>
         <script type="text/javascript">
         	$(document).ready(function(){
         		$("#msg").html("<font color='red'><strong>浏览器太落后了吧！请升级到IE6以上版本！<strong></font>");
         	});
         </script>
	<![endif]-->    
    </head>   
<body>
		
        <div id="chartdiv" align="center">Chart will load here</div>
        <script type="text/javascript">
        	var chart = new FusionCharts("<%=basePath%>js/FusionCharts/Charts/ZoomLine.swf", "ChartId", "750", "450", "0", "0");
		   chart.setDataURL( "<%=basePath%>/getWeeklyStatDataAction.action?mainInfoId=<s:property value="mainInfoId"/>");		   
		   chart.render("chartdiv");
		</script>
		<div id="msg" align="center"></div>
		<div align="center">
			<br />
			<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭" onclick='javascript:parent.$("#windown-close").click();'>
		</div>
</body>
 </html>

