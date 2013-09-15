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
<title>客户档案管理</title>
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
	<j:scriptlink css="true" jmessagebox="true" jquery="true"
	tipswindow="true" validate="true" />
	
	<script type="text/javascript">
	$(document).ready(function(){
		loadData($("#customerId").val());
		function loadData(customerId) {
             $.ajax({
                 url:"<%=basePath%>customerassessment/getCustomerAssessmentXML.action?customerId=" + customerId,
                 type: 'POST',
                 dataType: 'JSON',
                 timeout: 5000,
                 error: function() { alert('Error loading data!'); },
                 success: function(msg) {
                	 var xml = "<graph caption='客户评估信息统计图' rotateNames='1' baseFontSize='18' subcaption='' xAxisName='日期' yAxisMinValue='0' yAxisMaxValue='100' yAxisName='assessment values' decimalPrecision='0' formatNumberScale='0' numberPrefix='' showNames='1' showValues='0'  showAlternateHGridColor='1' AlternateHGridColor='ff5904' divLineColor='ff5904' divLineAlpha='20' alternateHGridAlpha='5' >";
                	 //xml = xml + "<set name='Jan' value='17400' hoverText='January'/>";
                     $.each(eval(msg), function(i, item) {
                         //$("<option value='" + item.id + "'>" + item.name + "</option>").appendTo($("#city"));
                    	 xml = xml + "<set name='"+item.date+"' value='"+item.resultValue+"' hoverText='["+item.date+"]评估结果："+item.result+"'/>";
                     });
                     xml = xml + "</graph>";
                     var chart = new FusionCharts("../js/FusionCharts/Charts/FCF_Line.swf", "chartdiv", "600", "350");
	          		 chart.setDataXML(xml);
	          		 chart.render("chartdiv");
                 }
             });
         };
         $("#closeBtn").click(function(){
	  			//parent.$("#windown-close").click();
	  			parent.location.href = "../customer/mycustomermanage.jsp";
	  		});
         $("#closeBtn1").click(function(){
	  			//parent.$("#windown-close").click();
        	 	parent.$("#windown-close").click();
	  			//parent.location.href = "autoAnalysisCustomerList.action";
	  		});
         $("#closeBtn2").click(function(){
	  			//parent.$("#windown-close").click();
     	 	parent.location.href = "../customer/customermanage.jsp";
	  			//parent.location.href = "autoAnalysisCustomerList.action";
	  		});
	  	 $("#closeBtn3").click(function(){
	  			//parent.$("#windown-close").click();
     	 	parent.location.href = "../customer/customersearch.jsp";
	  			//parent.location.href = "autoAnalysisCustomerList.action";
	  		});	
	  		
	  		
         /*
 		$.fn.close();
		
	 	$.fn.close = function(){
	 		$("#closeBtn").click(function(){
	  			parent.$("#windown-close").click();
	  			parent.location.href = "autoAnalysisCustomerList.action";
	  		});
		};
		*/
	});
	</script>
	<script type="text/javascript" src="../js/FusionCharts/FusionCharts.js"></script>
	</head>
	<body>
	<s:form id="form1" name="form1" method="post" theme="simple">
	<s:hidden id="customerId" name="customerId"></s:hidden>
	<s:hidden id="options" name="autoAssessmentSetting.options"></s:hidden>
<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
  <tr> 
    <td valign="top" class="text" align="center"> <div id="chartdiv" align="center"> 
        FusionCharts. </div>
      </td>
  </tr>
  <s:if test='option!=null && option.length() > 0 && option.equals("mycustomer")'>
  <tr><td align="center"><input type="button" name="closeBtn" id="closeBtn" value="返回客户列表" class="btn_5" /></td></tr>
  </s:if>
  <s:if test='option!=null && option.length() > 0 && option.equals("customer")'>
  <tr><td align="center"><input type="button" name="closeBtn2" id="closeBtn2" value="返回客户列表" class="btn_5" /></td></tr>
  </s:if>
  <s:if test='option!=null && option.length() > 0 && option.equals("search")'>
  <tr><td align="center"><input type="button" name="closeBtn3" id="closeBtn3" value="返回客户列表" class="btn_5" /></td></tr>
  </s:if>
  <s:if test='option == null || option.length() ==0 '>
  <tr><td align="center"><input type="button" name="closeBtn1" id="closeBtn1" value="关闭" class="btn_2_3" /></td></tr>
  </s:if>
</table>
</s:form>
</body>
</html>