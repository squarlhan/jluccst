<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/page-tags"%> 
<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 * All right reserved.
	 */
	/**
	 * @author zhaomengxue
	 * @version 1.0
	 * @audit  
	 */
	/**
	 * Modified Person：
	 * Modified Time：
	 * Modified Explain：
	 */
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>添加页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true"
			jquery="true" validate="true" />
	 	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
 		$(document).ready(function(){
			$("#addBtn").click(function(){
				form1.action = "toSetIsRemoveAction.action";
				form1.submit();	
				parent.$("#windown-close").click();
			});
			
			$.fn.close();
		});
 		/**
		 * 关闭
		 */
	 	$.fn.close = function(){
	 		$("#closeBtn").click(function(){
	  			parent.$("#windown-close").click();
	  			parent.window.location.href=parent.window.location.href;
	  		});
		}
  	</script>
  	</head>
  
  
  <body>
    <s:form name="form1" id="form1" theme="simple" method="post">
    <s:hidden name="errorLog.id"></s:hidden>
	<table width="100%" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td>
				<table width="100%" style="height: 100%;" border="0" cellspacing="6" cellpadding="0">
					<tr>
						<td style="height: 36px;">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>报警数据：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_deviceNum" name="errorLog.errorData" maxlength="25" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>故障阈值：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_deviceName" name="errorLog.errorThresh" maxlength="25" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>故障现象：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textarea id="txt_deptName" name="errorLog.errorPhen" maxlength="25" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>故障原因：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textarea id="txt_errorTime" name="errorLog.errorReason" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>专家意见：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textarea id="txt_errorTime" name="errorLog.opinion" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										<s:if test="errorLog.isRemove==0">
										&nbsp;&nbsp;
										<input id="addBtn" name="addBtn" type="button" value="解除报警" class="btn_2_3"/>
										</s:if>
										&nbsp;&nbsp;
										<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</s:form>
</body>
</html>

