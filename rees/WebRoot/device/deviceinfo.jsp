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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>设备管理维护</title>
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true" jfunction="true"/>
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _device_submit = {
				rules: {
					"device.deviceNum":{required:true,maxlength:20},
					"device.deviceName":{required:true,maxlength:20},
					"device.deviceModel":{maxlength:20},
					"device.deviceFactory":{maxlength:50},
					"device.controlpoint":{digits:true},
	                "device.centerHeight":{number:true},
	                "device.speed":{number:true},
	                "device.power":{number:true}
				},messages:{
					"device.deviceNum":
					{
					    required:"设备编号为必填项！",
						maxlength:"设备编号最多输入20个字符！"
					},
					"device.deviceModel":
					{
						maxlength:"设备型号最多输入20个字符！"
					},
					"device.deviceFactory":
					{
						maxlength:"设备厂商最多输入20个字符！"
					},
					"device.deviceName":
					{
						number:"设备名称为必填项！",
						maxlength:"设备名称最多输入20个字符！"
					},
					"device.centerHeight":
					{
						number:"中心高必须为数字！"
					},
					"device.speed":
					{
						number:"转速必须为数字！"
					},
					"device.power":
					{
						number:"功率必须为数字！"
					}
				}
			};
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
				
		  		$.validator.setDefaults({
		  			//验证框架的验证器的默认设置区
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
		  		$.fn.download();
		  		$.fn.deviceTypeChange();
		  	});
			/**
		  	 * 保存
		  	 */
			$.fn.save = function(){
				//如果有id就说明是修改action
				$("#addBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _device_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
					if($("#hid_deviceTypeId").val()==""){
						alert("请选择设备类型！");
						$('#sel_deviceType').focus();
						return false;
					}
	               	var deviceId = $("#hid_deviceId").val();
	               	if( $.trim(deviceId) == "" )
	               	{
	               		form1.action = "toAddDeviceAction.action";
	               	}
	               	else
	               	{
		               	form1.action = "toModifyDeviceAction.action";
	               	}
	               	form1.submit();
	           	});
          	}
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			var message = $("#lb_message").html();
					if(message!=null && $.trim(message)!="" ){
						//parent.window.location.href= parent.window.location.href;
						//刷新
						//parent.$("iframe[name='mainFrame']").attr("src","datamanage/devicemanage.jsp");
						//alert("先手动刷新列表吧！！！");
					}
					parent.$("#windown-close").click();
		  		});
			}
			/**
			 * 初始化页面
			 */
			$.fn.initpage = function(){
				//在设备类别中增加一个其他选项
				//$("#sel_deviceType option:last").after("<option value='other'>其他</option>");
				$("#txt_deviceNum").focus();
				//回显上传时的错误信息
				var uploadErr = $("#lb_error").html();
				if(uploadErr!=null && $.trim(uploadErr)!="" ){
					alert(uploadErr);
				}
				
				var message = $("#lb_message").html();
				if(message!=null && $.trim(message)!="" ){
					alert(message);
				}
			}
			
			/**
			 * 下载图片
			 */
			$.fn.download = function(){
				$("#download").click(function(){
					var oldAction = form1.action;
					form1.action = "toDownloadDeviceImageAction.action";
					form1.submit();
					form1.action = oldAction;
				});
			}
			
			/**
			 * 删除设备图片
			 */
			$.fn.delImg = function(id){
				
				if(window.confirm("您确定要删除设备图片吗？")){
					$.post("toDeleteDeviceImageAction.action", {"device.id":id}, function(data){});
					var row = $("#table1 tr:last").prev();
					row.find("strong").replaceWith("<strong>添加设备图片：</strong>");
					row.find("a:first").remove();
					row.find("a:first").replaceWith('<input type="file" name="files" value="" id="form1_files" style="width: 250px;"/>');
				}
			}
			
			/**
			 * 选择设备类别
			 */
			$.fn.deviceTypeChange = function(){
				$("#sel_deviceType").change(function(){
					var deviceTypeId =$('#sel_deviceType option:selected').attr("value");
					var deviceTypeName =$('#sel_deviceType option:selected').attr("text");
					$("#hid_deviceTypeId").val(deviceTypeId);
					$("#hid_deviceType").val(deviceTypeName);
					if(deviceTypeId=="other" || deviceTypeId=="nothing"){
						if(deviceTypeId=="nothing"){
							$("#hid_deviceTypeId").val("");
							$("#hid_deviceType").val("");
						}
						$("#txt_centerHeight").val("");
						$("#txt_speed").val("");
						$("#txt_power").val("");
					}else{
						var url = "toGetDeviceTypeInfoAction.action";
						$.post(url, {deviceTypeId:deviceTypeId}, function(data){
							if(data!=null ){
								if( data.deviceType.id!=null){
									var typeId = data.deviceType.id;
									var typeName = data.deviceType.typeName;
									var centerHeight = data.deviceType.centerHeight;
									var speed = data.deviceType.speed;
									var power = data.deviceType.power;

									$("#txt_centerHeight").val(centerHeight);
									$("#txt_speed").val(speed);
									$("#txt_power").val(power);
								}
							}
						});
					}
					
					if(deviceTypeId=="other"){
						$("#txt_centerHeight").attr("readonly","");
						$("#txt_centerHeight").attr("title","");
						$("#txt_speed").attr("readonly","");
						$("#txt_speed").attr("title","");
						$("#txt_power").attr("readonly","");
						$("#txt_power").attr("title","");
						$("#txt_speed").focus();
					}else{
						$("#txt_centerHeight").attr("readonly","readonly");
						$("#txt_centerHeight").attr("title","不能修改！");
						$("#txt_speed").attr("readonly","readonly");
						$("#txt_speed").attr("title","不能修改！");
						$("#txt_power").attr("readonly","readonly");
						$("#txt_power").attr("title","不能修改！");
						$("#txt_deviceFactory").focus();
					}
				});
			}
			
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple" enctype="multipart/form-data">
		<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<s:hidden id="hid_deviceId" name="device.id"></s:hidden>
		<s:hidden id="hid_deviceType" name="device.deviceType"></s:hidden>
		<s:hidden id="hid_deviceFilePath" name="device.filePath"></s:hidden>
		<s:hidden id="hid_controlpoint" name="device.controlpoint"></s:hidden>
		<s:hidden id="hid_sortIndex" name="device.sortIndex"></s:hidden>
		<s:hidden id="hid_creatTime" name="device.creatTime"></s:hidden>
		<s:hidden id="hid_isDelete" name="device.isDelete"></s:hidden>
		<s:hidden id="hid_factoryId" name="device.factoryId"></s:hidden>
		<s:hidden id="hid_workshopId" name="device.workshopId"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table id="table1" width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备编号：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceNum" name="device.deviceNum"  maxlength="25" cssStyle="width: 250px;"></s:textfield><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceName" name="device.deviceName" maxlength="25" cssStyle="width: 250px;"></s:textfield><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备型号：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceModel" name="device.deviceModel"  maxlength="25" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备类型：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:select id="sel_deviceType" list="deviceTypeList" listKey="id" listValue="typeName" headerKey="nothing" headerValue="---请选择---" name="device.deviceTypeId" cssStyle="width: 250px;"></s:select>
										</td>
									</tr>
									
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>转速：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_speed" name="device.speed" cssStyle="width: 250px;" readonly="true"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>功率：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_power" name="device.power" cssStyle="width: 250px;" readonly="true"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>中心高：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_centerHeight" name="device.centerHeight" cssStyle="width: 250px;" readonly="true"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备厂商：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceFactory" name="device.deviceFactory"  maxlength="20" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<!-- 
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>检测点数量：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_controlpoint" name="device.controlpoint" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									-->
									<s:if test='device.filePath!=null && device.filePath!=""'>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>设备图片：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<a id="download" href="javascript:void(0);"><img src="<%=basePath%>/images/picture_link.png" style="height:32px;width:32px;cursor:pointer" title="查看"></img></a>
											<a id="delImg" href="javascript:void(0);" onclick="$.fn.delImg('${device.id}')"><img src="<%=basePath%>/images/cross.png" style="height:32px;width:32px;cursor:pointer" title="删除"></img></a>
										</td>
									</tr>	
									</s:if>
									<s:else>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>添加设备图片：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:file name="files" cssStyle="width: 250px;"></s:file>
										</td>
									</tr>
									</s:else>
									
									<tr>
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="确定">
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
		<s:if test="hasFieldErrors()">
			<s:iterator value="fieldErrors">
				<s:label id="lb_error" name="value[0]" cssStyle="display:none"></s:label>
			</s:iterator>
		</s:if>
		</s:form>
	</body>
</html>