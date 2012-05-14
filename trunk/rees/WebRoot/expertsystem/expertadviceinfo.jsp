<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" jquery="true" validate="true" />
	<script type="text/javascript">
	

	/**
  	 * 验证条件
  	 */
	var _devicetype_submit = {
		rules: {
           "ruleAdviceInfo.advice":{required:true}
		},messages:{
			"ruleAdviceInfo.advice":
			{
				required:" 建议为必填项！"
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
		var devicetype = $("#hid_adviceId").val();
		
			$("#addBtn").click(function() {
			var validate_settings_submit = jQuery.extend({}, _devicetype_submit);
           	var validator = $("form").validate(validate_settings_submit);
           	if($("#sel_deviceType").val()==""){
           		alert("请选择设备类型！");
           		return false;
           	}
           	if(!validator.form()){
				return false;
			}
           	if( $.trim(devicetype) == "0" )
           	{
           		form1.action = "toAddRuleAdviceInfoAction.action";
           	}
           	else
           	{
           		form1.action = "toModifyRuleAdviceInfoAction.action";
           	}
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
	 * 初始化页面元素
	 */
	$.fn.initPage = function(){
		$("#sel_deviceType").focus();
		var err = $("#lb_error").html();
		if(err!=null && $.trim(err)!="" ){
			alert(err);
		}
		var message = $("#lb_message").html();
		if(message!=null && $.trim(message)!="" ){
			alert(message);
			parent.$("#windown-close").click();
		}
	}
</script>

  
  </head>
  
  <body>
    <s:form id="form1" name="form1" method="post"  theme="simple">
    <s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<s:hidden id="hid_adviceId" name="ruleAdviceInfo.id"></s:hidden>
		
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
											<strong>设备类型：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:select id="sel_deviceType" list="deviceTypeList" listKey="id" listValue="typeName" headerKey="" headerValue="---请选择---" name="ruleAdviceInfo.deviceTypeId" cssStyle="width: 250px;"></s:select><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>建议：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textarea id="txt_age" name="ruleAdviceInfo.advice" rows="6" cssStyle="width:250px;"/><font color="red">*</font>
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
