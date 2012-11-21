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
 * @author zhuyf
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>短信记录</title>
	<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
	<script type="text/javascript">
	  	$(function(){
	  		//日期控件
	  		//$('#txt_begin').val((new Date()).getYear()+"-"+(((new Date()).getMonth()+1)<10 ? "0"+((new Date()).getMonth()+1) : (new Date()).getMonth()+1)+"-"+((new Date()).getDate()-15<10 ? "0"+(new Date()).getDate()-15 : (new Date()).getDate()-15));
	  		//$('#txt_end').val((new Date()).getYear()+"-"+(((new Date()).getMonth()+1)<10 ? "0"+((new Date()).getMonth()+1) : (new Date()).getMonth()+1)+"-"+((new Date()).getDate()<10 ? "0"+(new Date()).getDate() : (new Date()).getDate()));
			$('#txt_begin').datetimepicker({showTimepicker: false});
			//日期控件
			$('#txt_end').datetimepicker({showTimepicker: false});
	  		/**
	  		 * 短信发送
	  		 */
	  		 /*
	  		$('a[name="send"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				$("#form1").attr("action",url);
	  				$("#form1").submit();
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个设备信息
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				$("#form1").attr("action",url);
	  				$("#form1").submit();
	  			});
	  		});
	  		//*/
	  		$("#queryBtn").click(function(){
	  			$("#form1").attr("action","loadSendedRecordAction.action");
  				$("#form1").submit();
	  		});
		});
	  	
	  	function send(obj){
	  		var url = obj.attr("url");
			var oldAction = $("#form1").attr("action");
			$("#form1").attr("action",url);
			$("#form1").submit();
			 $("#form1").attr("action",oldAction);
	  	}
	  	function deleteInfo(obj){
	  		var url = obj.attr("url");
			var oldAction = $("#form1").attr("action");
			$("#form1").attr("action",url);
			$("#form1").submit();
			 $("#form1").attr("action",oldAction);
	  	}
	</script>
  </head>
  
  
  <body>
  <s:form id="form1">
	<fieldset >
		<legend>查询</legend>
		<span>
		<table id="table1" width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
			<tr>
				<td height="26" align="right" bgcolor="#FFFFFF">
					<strong>接收人：</strong>
				</td>
				<td height="26" align="left" bgcolor="#FFFFFF">
					<s:textfield id="txt_person" name="queryPersonName"  maxlength="50" cssStyle="width: 200px;" />
				</td>
				<td height="26" align="right" bgcolor="#FFFFFF">
					<strong>手机号：</strong>
				</td>
				<td height="26" align="left" bgcolor="#FFFFFF">
					<s:textfield id="txt_phone" name="queryPhone"  maxlength="50" cssStyle="width: 200px;" />
				</td>
				<td height="26" align="right" bgcolor="#FFFFFF">
					<strong>公司名：</strong>
				</td>
				<td height="26" align="left" bgcolor="#FFFFFF">
					<s:textfield id="txt_company" name="queryCompany" maxlength="50" cssStyle="width: 200px;" />
				</td>
				<td height="26" align="right" bgcolor="#FFFFFF" rowspan="2">
					<input name="queryBtn" type="button" class="btn_2_3" id="queryBtn" value="查询">
				</td>
			</tr>
			<tr>
				<td height="26" align="right" bgcolor="#FFFFFF">
					<strong>发送时间：</strong>
				</td>
				<td height="26" align="left" bgcolor="#FFFFFF">
					<s:textfield id="txt_begin" name="queryBegin" maxlength="50" cssStyle="width: 92px;" />-
					<s:textfield id="txt_end" name="queryEnd" maxlength="50" cssStyle="width: 92px;" />
				</td>
				<td height="26" align="right" bgcolor="#FFFFFF">
					<strong>发送类型：</strong>
				</td>
				<td height="26" align="left" bgcolor="#FFFFFF">
					<s:select list="#{-1:'---全部---',0:'立即发送',1:'定时发送'}" cssStyle="width: 207px;"  name="queryType"></s:select>
				</td>
				<td height="26" align="right" bgcolor="#FFFFFF">
					<strong>发送状态：</strong>
				</td>
				<td height="26" align="left" bgcolor="#FFFFFF">
					<s:select list="#{-1:'---全部---',0:'准备', 1:'等待',2:'成功',3:'失败'}" cssStyle="width: 207px;"  name="queryState"></s:select>
				</td>
			</tr>
		</table>					
		</span>
	</fieldset>
    <table width="100%" height="50%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
		<thead>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>接收人</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>手机号</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>公司</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>昵称</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>发送类型</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>发送状态</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>发送时间</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>短信内容</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>操作</strong></td>
		</thead>
		<s:iterator value="pagination.data" status="obj">
		<tr>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap">
   				<s:property value="personName"/>
   			</td>
   			<td align="left" bgcolor="#FFFFFF" ><s:property value="phone"/></td>
   			<td align="left" bgcolor="#FFFFFF" >
   				<s:property value="personCompany"/>
   			</td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap"><s:property value="customerInfo.nickname"/></td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap">
	   			<s:if test="isImmediately==0">
	   				立即发送
	   			</s:if>
	   			<s:else>
	   				定时发送
	   			</s:else>
   			</td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap">
				<s:if test="state==0">
	   				<font color="orange">准备</font>
	   			</s:if>
	   			<s:if test="state==1">
	   				<font color="blue">等待</font>
	   			</s:if>
	   			<s:if test="state==2">
	   				<font color="green">成功</font>
	   			</s:if>
	   			<s:if test="state==3">
	   				<font color="red">失败</font>
	   			</s:if>
			</td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap"><s:date  name="sendTime" format="yyyy-MM-dd HH:mm" /></td>
   			<td align="left" bgcolor="#FFFFFF" ><s:property value="info"/></td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap">
          	<s:url id="reSend_url" action="reSendSMSInfoAction">   
				<s:param name="SMSInfoId" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteSMSInfoAction">   
				<s:param name="SMSInfoId" value="id"></s:param>   
			</s:url>
         	<a name="send" href="javascript:void(0);" url="${reSend_url}"  onclick="send($(this));return false;">发送</a>  
			<s:if test="state!=2">
   				<a name="delete" href="javascript:void(0);" url="${delete_url}"  onclick="deleteInfo($(this));return false;">删除</a>
   			</s:if>
          </td>
		</tr>
		</s:iterator> 
		<tr>
          <td height="26" colspan="10" align="center" bgcolor="#FFFFFF">
			<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		  </td>
        </tr>
	</table>
	 </s:form>
  </body>
</html>
