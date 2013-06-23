  <%@ page language="java" contentType="text/html; charset=utf-8"
import="com.boan.crm.groupmanage.common.UserSession,com.boan.crm.groupmanage.service.IPopedomService,com.boan.crm.groupmanage.service.impl.PopedomServiceImpl"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
	IPopedomService popedomService = new PopedomServiceImpl();
	UserSession us = (UserSession) session.getAttribute("userSession");
	String deptId = us.getDeptId();
	String personId = us.getUserId();
	boolean popodomFlag = popedomService.isCompanyAdministrator(us.getUserId(), String.valueOf(us.getUserType()) ) 
			||popedomService.isHasDeptPopedom(us.getRoleKey()) || popedomService.isHasCompanyPopedom(us.getRoleKey());
	if( popodomFlag ){
		//经理级人员
	}else{
		//部门人员
	}
	//*/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
 
	<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/timepicke/jquery-ui-1.7.3.custom.css" />
	<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/timepicke/jquery-ui-timepicker-addon.css" />
	<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-sliderAccess.js"></script>
	<script src="<%=path %>/js/ui/jquery.ui.core.js"></script>
	<script src="<%=path %>/js/ui/jquery.ui.position.js"></script>
	<script src="<%=path %>/js/ui/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="<%=path%>/js/FusionCharts/FusionCharts.js"></script>
	<style type="text/css">
		.auto-style1 {
		background: #d3eaef; font-size: 18px; font-family: 仿宋;}
	
	.auto-style2 {
		font-size: x-large;
	}
	.auto-style3 {
		text-align: right;
	}
	.ui-autocomplete-loading { background: white url('images/ui-anim_basic_16x16.gif') right center no-repeat; }
	</style>
	<link rel='stylesheet' type='text/css'  href='<%=path %>/css/jquery.autocomplete.css' />
	
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<script type="text/javascript">
	
		$(function(){
			//日期控件
			//$('#txt_statBeginDate').datetimepicker({showTimepicker: false});
			//$('#txt_statEndDate').datetimepicker({showTimepicker: false});
			
			var chart = new FusionCharts("<%=path%>/js/FusionCharts/Charts/ZoomLine.swf", "ChartId", "100%", "500", "0", "0");
			chart.setDataURL( escape("<%=path%>/getStatDataForTargetAction.action?deptId=<s:property value='deptId'/>&personId=<s:property value='personId'/>&statYear=<s:property value='statYear'/>&statMonth=<s:property value='statMonth'/>"));		     
			chart.render("chartdiv");
			
			$("#chk_month").change(function(){
				if($("#chk_month").attr("checked")==true){
					$("#statMonth").attr("disabled","");
					$("#chk_year").attr("checked","checked");
					$("#chk_year").attr("disabled","disabled");
				}else{
					$("#statMonth").attr("disabled","disabled");
					$("#chk_year").attr("disabled","");
					$("#statMonth").get(0).selectedIndex=0;
				}
			});
		});
	</script>
 
  </head>
  
  <body>
 <form id="form1" name="form1" action="openSellReportStatTargetAction.action" method="post">
 <s:hidden name="deptId"></s:hidden>
  <s:hidden name="personId"></s:hidden>
<table width="99%"  border="0" cellspacing="2" cellpadding="0">
	<tr>
		<td colspan="2">
		<fieldset>
		<legend>查询条件</legend>
   		<span>
      		<table width="99%"   border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
		      <tr>
		      		<td height="26" width = "100px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>统计时间：</strong>
					</td>
					<td height="26"   width = "200px"   align="left" bgcolor="#FFFFFF">
						<s:select name="statYear" list="{2012,2013,2014,2015,2016}"></s:select>
						年<input type="checkbox" checked="checked"  id="chk_year" ></input>
						<s:if test='statMonth==null || statMonth==""'>
							<s:select name="statMonth" id="statMonth" list="{1,2,3,4,5,6,7,8,9,10,11,12}" disabled="true"></s:select>月
							<input type="checkbox"  id="chk_month" ></input>
						</s:if>
						<s:else>
							<s:select name="statMonth" id="statMonth" list="{1,2,3,4,5,6,7,8,9,10,11,12}" disabled="false"></s:select>月
							<input type="checkbox"  id="chk_month" checked="checked"></input>
						</s:else>
					</td>
					<td height="26"  align="left" bgcolor="#FFFFFF">
						<input name="queryBtn" type="submit" class="btn_2_3" id="queryBtn" value="查询">
					</td>
				</tr>
			</table>
			</span>
		</fieldset>
		</td>
	</tr>
</table>
<table width="99%" border="0" cellspacing="2" cellpadding="0">
	<tr>
		<td colspan="2">
			<div id="chartdiv" align="center" ></div>
		</td>
	</tr>
</table>
	</form>
</body>
</html>

