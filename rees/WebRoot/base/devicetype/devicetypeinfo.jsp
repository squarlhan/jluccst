<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	/**
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
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>设备类型维护管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"/>

	<script type="text/javascript">

		/**
	  	 * 验证条件
	  	 */
		var _devicetype_submit = {
			rules: {
               "deviceType.typeName":{required:true,maxlength:20},
               "deviceType.centerHeight":{number:true},
               "deviceType.speed":{number:true},
               "deviceType.power":{number:true}
			},messages:{
				"deviceType.typeName":
				{
					required:"名称为必填项！",
					maxlength:"名称最多输入20个字符！"
				},
				"deviceType.centerHeight":
				{
					number:"中心高必须为数字！"
				},
				"deviceType.speed":
				{
					number:"转速必须为数字！"
				},
				"deviceType.power":
				{
					number:"功率必须为数字！"
				}
			}
		};

		/**
 		* 准备工作
 		*/
		$(document).ready(function(){
			$.fn.initPage();
			
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

	  	});
		
		/**
	  	 * 保存
	  	 */
		$.fn.save = function(){
			
			//如果有id就说明是修改action
			var devicetype = $("#hid_devicetypeId").val();
			
				$("#addBtn").click(function() {
				var validate_settings_submit = jQuery.extend({}, _devicetype_submit);
               	var validator = $("form").validate(validate_settings_submit);
               	if(!validator.form()){
					return false;
				}
               	if( $.trim(devicetype) == "" )
               	{
               		repform.action = "toAddDeviceTypeAction.action";
               	}
               	else
               	{
	               	repform.action = "toModifyDeviceTypeAction.action";
               	}
               	repform.submit();
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
		 * 初始化页面元素
		 */
		$.fn.initPage = function(){
			var message = $("#lb_message").html();
			if(message!=null && $.trim(message)!="" ){
				alert(message);
				parent.$("#windown-close").click();
			}
		}
	</script>
</head>
<body>
	<s:form  id="repform"  theme="simple" >
		<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<s:hidden id="hid_devicetypeId" name="deviceType.id"></s:hidden>
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
											<strong>名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_typeName" name="deviceType.typeName" maxlength="25" cssStyle="width: 250px;"/><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>转速：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_speed" name="deviceType.speed" maxlength="8" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>功率：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_power" name="deviceType.power" maxlength="8" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>中心高：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_centerHeight" name="deviceType.centerHeight" maxlength="8" cssStyle="width: 250px;"/>
										</td>
									</tr>
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
	</s:form>
</body>
</html>

