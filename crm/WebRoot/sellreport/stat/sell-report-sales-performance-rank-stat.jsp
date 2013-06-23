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
    <title>时间管理列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true"/>
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/xdate.js" ></script>
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
			$('#statBeginDate').datetimepicker({showTimepicker: false});
			$('#statEndDate').datetimepicker({showTimepicker: false});
			$("#rdb_year").change(function(){
				if($("#rdb_year").attr("checked")==true){
					var year = (new Date()).getYear();
					$("#statBeginDate").val(year+"-"+"01-01");
					$("#statEndDate").val(year+"-"+"12-31");
					$("#shortcutType").val("year");
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
				}
			});
		});
	</script>

  </head>
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple" action="openSellSalesPerformanceRankAction.action">
 <s:hidden name="companyId"></s:hidden>
 <s:hidden name="deptId"></s:hidden>
 <s:hidden id="shortcutType" name="shortcutType"></s:hidden>
<table width="100%"  border="0" cellspacing="5" cellpadding="0">
	<tr>
		<td colspan="2">
		<fieldset >
		<legend>查询条件</legend>
   		<span>
      		<table width="100%"   border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
		      <tr>
					<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>统计时间：</strong>
					</td>
					<td height="26" width = "270px"  align="left" bgcolor="#FFFFFF">
						<s:textfield id="statBeginDate" name="statBeginDate" cssStyle="width:120px" ></s:textfield> -
						<s:textfield id="statEndDate" name="statEndDate" cssStyle="width:120px"></s:textfield>
					</td>
					<td height="26" width = "100px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>快捷时间：</strong>
					</td>
					<td height="26"   width = "250px"   align="left" bgcolor="#FFFFFF">
						<s:if test='shortcutType=="month"'>
							<input type="radio"  id="rdb_year"  name="group"></input>当前年
							<input type="radio"  id="rdb_month"  checked="checked" name="group" ></input>当前月
						</s:if>
						<s:else>
							<input type="radio" checked="checked"  id="rdb_year"  name="group"></input>当前年
							<input type="radio"  id="rdb_month" name="group" ></input>当前月
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
  <tr>
    <td valign="top">
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
              <td align="center" background="<%=path %>/images/headerbg.jpg" width="80"><strong>名次</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>业务员</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>所在部门</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>销售额</strong></td>
        </tr>
        <s:iterator value="salesPerformanceRankList" status="obj">
        <tr>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="sequenceNumber"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"  nowrap="nowrap"><s:property value="salesmanName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="deptName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="salesAmount"/></td>
        </tr>
        </s:iterator>
        <s:if test="salesPerformanceRankList==null || salesPerformanceRankList.size()==0">
        <tr>
              <td height="26" align="center" colspan="4" bgcolor="#FFFFFF">
				暂无信息！
			  </td>
        </tr>
        </s:if>
      </table>
      </td>
  </tr>
</table>
</s:form>
</body>
</html>
