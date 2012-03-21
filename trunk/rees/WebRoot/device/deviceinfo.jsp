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

		<title>设备管理维护</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<script type="text/javascript">
		var _device_submit = {
				rules: {
					//"device.deviceNum":{},
					//"device.deviceType":{},
					"device.deviceName":{required:true},
					//"device.deviceModel":{},
					//"device.deviceFactory":{},
					"device.controlpoint":{digits:true},
					"device.filePath":{url:true}
					}
				};
				$(document).ready(function(){
			  		$.validator.setDefaults({
						debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
					    errorPlacement:function(error, element) {},
						invalidHandler: function(form, validator) {
				        	$.each(validator.invalid,function(key,value){
				            	alert(value);document.getElementById(key).focus();return false;
				        	}); 
				    	}
					})
					$.fn.save();
			  		$.fn.close();
			  		$.fn.initpage();
			  	});
				/**
			  	 * 保存
			  	 */
				$.fn.save = function(){
					var deviceId = $("#hid_deviceId").val();
					if(deviceId!=""){
						$("#addBtn").click(function() {
						var validate_settings_submit = jQuery.extend({}, _device_submit);
		               	var validator = $("form").validate(validate_settings_submit);
		               	if(!validator.form()){
							return false;
						}
		               	form1.action = "toModifyDeviceAction.action";
		               	form1.submit();
		           	});
						}
			    		
					$("#addBtn").click(function() {
						var validate_settings_submit = jQuery.extend({}, _device_submit);
		               	var validator = $("form").validate(validate_settings_submit);
		               	if(!validator.form()){
							return false;
						}
		               	form1.action = "toAddDeviceAction.action";
		               	form1.submit();
		           	});
	          	}
				
				/**
				 * 关闭
				 */
			 	$.fn.close = function(){
			 		$("#closeBtn").click(function(){
			  			parent.$("#windown-close").click();
			  		});
				}
				/**
				 * 初始化页面
				 */
				$.fn.initpage = function(){
					$("#txt_deviceNum").focus();
				}
		
     

</script>
	</head>

	<body>
		<s:form id="form1" theme="simple" >
		<s:hidden id="hid_deviceId" name="device.id"></s:hidden>
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
											<s:textfield id="txt_deviceNum" name="device.deviceNum" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备类型：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceType" name="device.deviceType" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceName" name="device.deviceName" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备型号：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceModel" name="device.deviceModel" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备厂商：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceFactory" name="device.deviceFactory" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>检测点数量：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_controlpoint" name="device.controlpoint" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>添加设备图片：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_filePath" name="device.filePath" cssStyle="width: 250px;"></s:textfield>
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
