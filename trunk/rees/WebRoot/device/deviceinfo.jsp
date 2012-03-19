<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author JiangMD
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

		<title>My JSP 'deviceinfo.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<script type="text/javascript">
      $(document).ready( function() {
  		$("#addBtn").click(function(){
  			parent.$("#windown-close").click();
  			parent.location.href = $.fn.change_url(parent.location.href);
  		});
  		$("#closeBtn").click(function(){
  			parent.$("#windown-close").click();
  		});
  	});
</script>
	</head>

	<body>
		<s:form id="form1" action="toAddDeviceAction.action"  >
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备编号：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceNum" name="device.deviceNum" value="%{#device.deviceNum}" style="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备类型：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceType" name="device.deviceType" value="%{#device.deviceType}" style="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceName" name="device.deviceName"  value="%{#device.deviceName}" style="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备型号：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceModel" name="device.deviceModel" value="%{#device.deviceModel}" width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备厂商：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceFactory" name="device.deviceFactory"  value="%{#device.deviceFactory}" style="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>检测点数量：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_controlpoint" name="device.controlpoint"  value="%{#device.controlpoint}" style="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>添加设备图片：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_filePath" name="device.filePath"  value="%{#device.filePath}" style="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="button" type="submit" class="btn_2_3" id="addBtn" value="确定">
											&nbsp;&nbsp;
											<input name="addBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
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
