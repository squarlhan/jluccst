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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>公司信息管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink css="true" jmessagebox="true" jquery="true"
			tipswindow="true" validate="true" />
		<script type="text/javascript">
			/**
			 * 准备工作
			 */
			$(document).ready(function() {
				$.fn.close();
			});
		
			/**
			 * 返回
			 */
			$.fn.close = function() {
				$("#closeBtn").click(function() {
					window.location.href="./failureDiagnosisAction!showFailureDiagnosisInfo.action";
				});
			}
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
			<table width="100%" border="0" cellspacing="5" cellpadding="0">
				<tr>
					<td>
						<table width="100%" style="height: 100%;" border="0"
							cellspacing="6" cellpadding="0">
							<tr>
								<td style="height: 36px;">
									<table width="100%" border="0" cellpadding="5" cellspacing="1"
										bgcolor="#d5e4fd">
										<tr>
											<td colspan="2" align="center" background="<%=path %>/images/headerbg.jpg">
												<strong>故障诊断结果</strong>
											</td>
										</tr>
										<tr>
											<td colspan="2" height="26" align="left" bgcolor="#FFFFFF" width="40%">
												<strong>诊断条件：</strong>压机类-》硝酸泵-》，故障现象：转子不对中，振动方向：xxxxx
											</td>
										</tr>
										<tr>
											<td height="26" align="center" bgcolor="#FFFFFF" width="40%">
												<strong>故障原因</strong>
											</td>
											<td height="26" align="center" bgcolor="#FFFFFF">
												<strong>故障结果</strong>
											</td>
										</tr>
										<tr>
											<td height="26" align="left" bgcolor="#FFFFFF" width="40%">
												1. 转子不平衡
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												1.建议更换转子
											</td>
										</tr>
										<tr>
											<td height="26" align="left" bgcolor="#FFFFFF" width="40%">
												1. 转子不平衡
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												1.建议更换转子
											</td>
										</tr>
										<tr>
											<td height="26" align="left" bgcolor="#FFFFFF" width="40%">
												1. 转子不平衡
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												1.建议更换转子
											</td>
										</tr>
										<tr>
											<td height="26" align="left" bgcolor="#FFFFFF" width="40%">
												1. 转子不平衡
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												1.建议更换转子
												1.建议更换转子
												1.建议更换转子
											</td>
										</tr>
										<tr>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												&nbsp;&nbsp;
												<input name="closeBtn" type="button" class="btn_2_3"
													id="closeBtn" value="返回">
											</td>
										</tr>
									</table>
							</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<iframe id="iframe1" name="iframe1" width="1px" height="1px"></iframe>
		</s:form>
	</body>
</html>
