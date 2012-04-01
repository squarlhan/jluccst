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

                "deviceType.typeName":{required:true},
                "deviceType.centerHeight":{number:true},
                "deviceType.speed":{number:true},
                "deviceType.power":{number:true}
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
</script>
</head>
<body>
<s:form  id="repform"  theme="simple" >
<s:hidden id="hid_devicetypeId" name="deviceType.id"></s:hidden>
<table width="100%" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td>
    	<table width="100%" style="height:100%;" border="0" cellspacing="6" cellpadding="0">
        <tr>
          <td style="height:36px;">
          <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>设备类型：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF">
                <s:textfield id="txt_reportType" name="deviceType.typeName"/>
              </td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>中心高：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF">
              	<s:textfield id="txt_reportSubject" name="deviceType.centerHeight"/>
              </td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>转速：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF">
              	<s:textfield id="txt_reportPerson" name="deviceType.speed"/>
              </td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>功率：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF">
              	<s:textfield id="txt_reportDate" name="deviceType.power"/>
              </td>
            </tr>
           
            <tr>
				<td height="26" colspan="2" align="left" bgcolor="#FFFFFF">
				<input name="保存" type="button" value="保存" class="btn_2_3" id="addBtn"/>
				&nbsp;&nbsp;
				<input name="关闭" type="button" value="关闭" class="btn_2_3" id="closeBtn" />
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

