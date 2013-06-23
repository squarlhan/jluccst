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
	<script type="text/javascript" src="<%=path%>/js/xdate.js" ></script>
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
			$('#statBeginDate').datetimepicker({showTimepicker: false});
			$('#statEndDate').datetimepicker({showTimepicker: false});
			
			var chart = new FusionCharts("<%=path%>/js/FusionCharts/Charts/ZoomLine.swf", "ChartId", "100%", "500", "0", "0");
			chart.setDataURL( escape("<%=path%>/getStatDataForSellTrendAction.action?deptId=<s:property value='deptId'/>&personId=<s:property value='personId'/>&shortcutType=<s:property value='shortcutType'/>&statBeginDate=<s:property value='statBeginDate'/>&statEndDate=<s:property value='statEndDate'/>"));		     
			chart.render("chartdiv");
			
			$("#rdb_year").change(function(){
				if($("#rdb_year").attr("checked")==true){
					var year = (new Date()).getYear();
					$("#statBeginDate").val(year+"-"+"01-01");
					$("#statEndDate").val(year+"-"+"12-31");
					$("#shortcutType").val("year");
					
					$('#statBeginDate').attr("disabled","disabled");
					$('#statEndDate').attr("disabled","disabled");
				}
			});
			$("#rdb_month").change(function(){
				if($("#rdb_month").attr("checked")==true){
					var firstDate = new Date();
					firstDate.setDate(1); //第一天
					var endDate = new Date(firstDate);
					endDate.setMonth(firstDate.getMonth()+1);
					endDate.setDate(0);
					$("#statBeginDate").val(new XDate(firstDate).toString('yyyy-MM-dd'));
					$("#statEndDate").val(new XDate(endDate).toString('yyyy-MM-dd'));
					$("#shortcutType").val("month");
					
					$('#statBeginDate').attr("disabled","disabled");
					$('#statEndDate').attr("disabled","disabled");
				}
			});
			$("#rdb_week").change(function(){
				if($("#rdb_week").attr("checked")==true){
					var d = new XDate();
					if(d.getDay()==0){
						var firstDate = d.addDays(-6);
						var endDate = new XDate();
						 $("#statBeginDate").val(firstDate.toString('yyyy-MM-dd'));
					     $("#statEndDate").val(endDate.toString('yyyy-MM-dd'));
					}else{
						firstDate = d.addDays(    1 - d.getDay()   );
						var endDate =( new XDate().addDays(    1 - d.getDay()   )).addDays(    6   );
						 $("#statBeginDate").val(firstDate.toString('yyyy-MM-dd'));
					     $("#statEndDate").val(endDate.toString('yyyy-MM-dd'));
					}
					$("#shortcutType").val("week");
					$('#statBeginDate').attr("disabled","disabled");
					$('#statEndDate').attr("disabled","disabled");
				}
			});
			
			$("#rdb_my").change(function(){
				if($("#rdb_my").attr("checked")==true){
					 $("#statBeginDate").val("");
				     $("#statEndDate").val("");
				     //$("#statBeginDate").focus();
				     $("#shortcutType").val("my");
				     $("#statBeginDate").attr("readonly","");
					 $("#statEndDate").attr("readonly","");
					 
					$('#statBeginDate').attr("disabled","");
					$('#statEndDate').attr("disabled","");
				}
			});
			
			$("#queryBtn").click(function(){
				$('#statBeginDate').attr("disabled","");
				$('#statEndDate').attr("disabled","");
				$("#form1").submit();
			});
		});
	</script>
 
  </head>
  
  <body>
 <form id="form1" name="form1" action="openSellTrendAction.action" method="post">
 <s:hidden name="deptId"></s:hidden>
  <s:hidden name="personId"></s:hidden>
  <s:hidden id="shortcutType" name="shortcutType"></s:hidden>
<table width="99%"  border="0" cellspacing="2" cellpadding="0">
	<tr>
		<td colspan="2">
		<fieldset>
		<legend>查询条件</legend>
   		<span>
      		<table width="99%"   border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
					<tr>
						<td height="26" width = "100px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
							<strong>快捷时间：</strong>
						</td>
						<td height="26"   width = "300px"   align="left" bgcolor="#FFFFFF">
							<s:if test='shortcutType=="month"'>
								<input type="radio"  id="rdb_year"  name="group"></input>本年
								<input type="radio"  id="rdb_month"  checked="checked" name="group" ></input>本月
								<input type="radio"  id="rdb_week"  name="group" ></input>本周
								<input type="radio"  id="rdb_my"  name="group" ></input>自定义时间
							</s:if>
							<s:elseif test='shortcutType=="week"'>
								<input type="radio" id="rdb_year"  name="group"></input>本年
								<input type="radio"  id="rdb_month" name="group" ></input>本月
								<input type="radio"  id="rdb_week"  checked="checked"  name="group" ></input>本周
								<input type="radio"  id="rdb_my"  name="group" ></input>自定义时间
							</s:elseif>
							<s:elseif test='shortcutType=="my"'>
								<input type="radio" id="rdb_year"  name="group"></input>本年
								<input type="radio"  id="rdb_month" name="group" ></input>本月
								<input type="radio"  id="rdb_week"  name="group" ></input>本周
								<input type="radio"  id="rdb_my"   checked="checked"  name="group" ></input>自定义时间
							</s:elseif>
							<s:else>
								<input type="radio"  id="rdb_year"   checked="checked"  name="group"></input>本年
								<input type="radio"  id="rdb_month" name="group" ></input>本月
								<input type="radio"  id="rdb_week"  name="group" ></input>本周
								<input type="radio"  id="rdb_my"  name="group" ></input>自定义时间
							</s:else>
						</td>
					</td>
					<td height="26" width = "100px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>自定义时间</strong>
					</td>
					<td height="26"   width = "280px"   align="left" bgcolor="#FFFFFF">
						<s:if test='shortcutType!="my"'>
							<s:textfield id="statBeginDate" name="statBeginDate" cssStyle="width:120px"  disabled="true"></s:textfield> -
							<s:textfield id="statEndDate" name="statEndDate" cssStyle="width:120px"  disabled="true"></s:textfield>
						</s:if>
						<s:else>
							<s:textfield id="statBeginDate" name="statBeginDate" cssStyle="width:120px" ></s:textfield> -
							<s:textfield id="statEndDate" name="statEndDate" cssStyle="width:120px" ></s:textfield>
						</s:else>
					</td>
					<td height="26"  align="left" bgcolor="#FFFFFF">
						<input name="queryBtn" type="button" class="btn_2_3" id="queryBtn" value="查询">
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

