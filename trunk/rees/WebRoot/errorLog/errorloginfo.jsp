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
				form1.action = "toAddErrorLogAction.action";
				form1.submit();		
			});
		});
  	</script>
  	</head>
  
  
  <body>
    <s:form name="form1" id="form1" theme="simple" method="post">
	<table width="100%" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td>
				<table width="100%" style="height: 100%;" border="0" cellspacing="6" cellpadding="0">
					<tr>
						<td style="height: 36px;">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>设备编号：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_deviceNum" name="errorLog.deviceNum" maxlength="25" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>设备名称：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_deviceName" name="errorLog.deviceName" maxlength="25" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>部门名称：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_deptName" name="errorLog.deptName" maxlength="25" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>故障时间：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_errorTime" name="errorLog.errorTime" onClick="WdatePicker()" maxlength="25" cssClass="Wdate" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>是否解除：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_isRemove" name="errorLog.isRemove" maxlength="25" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										&nbsp;&nbsp;
										<input id="addBtn" name="addBtn" type="button" value="确定" class="btn_2_3"/>
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

