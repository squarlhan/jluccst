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
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户信息统计管理</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
/*
.STYLE2 {
background-color:#d3eaef}
*/
.STYLE6 {color: #000000; font-size: 12px; }
.STYLE10 {color: #000000; font-size: 12px; background:#d3eaef; 	letter-spacing: 2pt; padding:0px 20px}
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
/*字号，字间距，颜色黑，背景色，左右边距，是查询和列表项目 */
.style11{
	color: #000000;
	font-size: 12px;
	letter-spacing: 1pt;
	background-color:#d3eaef;
	padding: 0px 10px;
}
-->
</style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true"/>
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<j:scriptlink css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true" />
	<script type="text/javascript">
	$(document).ready(function(){
		var recordCount = document.getElementById("form1_totalCustomerCount").value;
		var yMaxValue = parseInt(recordCount);
		if(recordCount < 10 )
		{
			recordCount = 10;
		}
		//link=\"aaa.action\"
		<s:if test="flag.equals('category')">
			var xml = "<graph caption='客户分类信息统计' baseFontSize='16'　showNames='1' showValues='1' xAxisName='客户分类' yAxisMinValue='0' yAxisMaxValue='"+recordCount+"' yAxisName='客户个数' showLabels='1'  decimalPrecision='0'>";
			<s:iterator value="listCategoryStatic" status="obj">
				xml = xml + "<set label=\""+document.getElementById("category<s:property value="#obj.index"/>").textStr+"\"  name=\""+document.getElementById("category<s:property value="#obj.index"/>").textStr+"\" value=\""+document.getElementById("category<s:property value="#obj.index"/>").valueStr+"\" />";
			</s:iterator>
			xml = xml + "</graph>";
			var chart = new FusionCharts("../js/FusionCharts/Charts/Column3D.swf", "chartdiv1", "500", "350");
			chart.setDataXML(xml);
			chart.render("chartdiv1");
		</s:if>
		<s:if test="flag.equals('source')">
			var xml2 = "<graph caption='客户来源信息统计' baseFontSize='16' xAxisName='客户来源' yAxisName='客户个数' showNames='1' yAxisMaxValue='"+recordCount+"'  decimalPrecision='0' showLegend='1'>";
			<s:iterator value="listSourceStatic" status="obj">
				xml2 = xml2 + "<set name=\""+document.getElementById("source<s:property value="#obj.index"/>").textStr+"\" value=\""+document.getElementById("source<s:property value="#obj.index"/>").valueStr+"\" />";
			</s:iterator>
			xml2 = xml2 + "</graph>";
			var chart2 = new FusionCharts("../js/FusionCharts/Charts/Column3D.swf", "chartdiv2", "600", "450");
			chart2.setDataXML(xml2);
			chart2.render("chartdiv2");
		</s:if>
		<s:if test="flag.equals('maturity')">
			var xml3 = "<graph caption='客户忠诚度信息统计' baseFontSize='16' xAxisName='客户忠诚度' showNames='1' yAxisMaxValue='"+recordCount+"' decimalPrecision='0' showLegend='1'>";
			<s:iterator value="listMaturityStatic" status="obj">
				xml3 = xml3 + "<set name=\""+document.getElementById("maturity<s:property value="#obj.index"/>").textStr+"\" value=\""+document.getElementById("maturity<s:property value="#obj.index"/>").valueStr+"\" />";
			</s:iterator>
			xml3 = xml3 + "</graph>";
			var chart3 = new FusionCharts("../js/FusionCharts/Charts/Column3D.swf", "chartdiv3", "600", "450");
			chart3.setDataXML(xml3);
			chart3.render("chartdiv3");
		</s:if>
		<s:if test="flag.equals('progress')">
			var xml4 = "<graph caption='客户业务进展信息统计' baseFontSize='16' xAxisName='客户业务进展' showNames='1' yAxisMaxValue='"+recordCount+"' decimalPrecision='0' showLegend='1'>";
			<s:iterator value="listProgressStatic" status="obj">
				xml4 = xml4 + "<set name=\""+document.getElementById("progress<s:property value="#obj.index"/>").textStr+"\" value=\""+document.getElementById("progress<s:property value="#obj.index"/>").valueStr+"\" />";
			</s:iterator>
			xml4 = xml4 + "</graph>";
			var chart4 = new FusionCharts("../js/FusionCharts/Charts/Column3D.swf", "chartdiv4", "600", "450");
			chart4.setDataXML(xml4);
			chart4.render("chartdiv4");
		</s:if>
		<s:if test="flag.equals('level')">
			var xml5 = "<graph caption='客户开发程度信息统计' baseFontSize='16' xAxisName='客户开发程度' showNames='1' yAxisMaxValue='"+recordCount+"'  decimalPrecision='0' showLegend='1'>";
			<s:iterator value="listLevelStatic" status="obj">
				xml5 = xml5 + "<set name=\""+document.getElementById("level<s:property value="#obj.index"/>").textStr+"\" value=\""+document.getElementById("level<s:property value="#obj.index"/>").valueStr+"\" />";
			</s:iterator>
			xml5 = xml5 + "</graph>";
			var chart5 = new FusionCharts("../js/FusionCharts/Charts/Column3D.swf", "chartdiv5", "600", "450");
			chart5.setDataXML(xml5);
			chart5.render("chartdiv5");
		</s:if>
	});
	</script>
	<script type="text/javascript" src="../js/FusionCharts/FusionCharts.js"></script>
	</head>
	<body style="margin:2px;">
	<s:form id="form1" name="form1" method="post" theme="simple">
	<s:hidden name="totalCustomerCount" />
	当前客户总数：<s:property value="totalCustomerCount"></s:property>人
		<s:if test="flag.equals('category')">
			<s:iterator value="listCategoryStatic" status="obj">
				<span name="category" id="category<s:property value="#obj.index"/>" textStr="<s:property value='category'/>" valueStr="<s:property value='count'/>"></span>
			</s:iterator>
		</s:if>
		<s:if test="flag.equals('source')">
			<s:iterator value="listSourceStatic" status="obj">
				<span name="source" id="source<s:property value="#obj.index"/>" textStr="<s:property value='category'/>" valueStr="<s:property value='count'/>"></span>
			</s:iterator>
		</s:if>
		<s:if test="flag.equals('maturity')">
			<s:iterator value="listMaturityStatic" status="obj">
				<span name="maturity" id="maturity<s:property value="#obj.index"/>" textStr="<s:property value='category'/>" valueStr="<s:property value='count'/>"></span>
			</s:iterator>
		</s:if>
		<s:if test="flag.equals('progress')">
			<s:iterator value="listProgressStatic" status="obj">
				<span name="progress" id="progress<s:property value="#obj.index"/>" textStr="<s:property value='category'/>" valueStr="<s:property value='count'/>"></span>
			</s:iterator>
   		</s:if>
		<s:if test="flag.equals('level')">
			<s:iterator value="listLevelStatic" status="obj">
				<span name="level" id="level<s:property value="#obj.index"/>" textStr="<s:property value='category'/>" valueStr="<s:property value='count'/>"></span>
			</s:iterator>
		</s:if>
<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
  <tr> 
    <td valign="top" class="text" align="center">
     <s:if test="flag.equals('category')">
     <div id="chartdiv1" align="center"> 
        FusionCharts. </div>
        </s:if>
      </td> <td valign="top" class="text" align="center"> 
       <s:if test="flag.equals('source')">
      <div id="chartdiv2" align="center"> 
        FusionCharts. </div>
        </s:if>
      </td>
  </tr>
   <tr> 
    <td valign="top" class="text" align="center"> 
     <s:if test="flag.equals('maturity')">
    <div id="chartdiv3" align="center"> 
        FusionCharts. </div>
        </s:if>
      </td> <td valign="top" class="text" align="center"> 
       <s:if test="flag.equals('progress')">
      <div id="chartdiv4" align="center"> 
        FusionCharts. </div>
        </s:if>
      </td>
  </tr>
   <tr> 
    <td valign="top" class="text" align="center"> 
     <s:if test="flag.equals('level')">
    <div id="chartdiv5" align="center"> 
        FusionCharts. </div>
        </s:if>
      </td> <td valign="top" class="text" align="center">
      </td>
  </tr>
</table>
</s:form>
</body>
</html>