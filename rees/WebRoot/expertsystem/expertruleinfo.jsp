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
           "ruleInfo.result":{required:true}
         
          
		},messages:{
			"ruleInfo.result":
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
		var devicetype = $("#hid_ruleId").val();
		
			$("#btn_save").click(function() {
			var validate_settings_submit = jQuery.extend({}, _devicetype_submit);
           	var validator = $("form").validate(validate_settings_submit);
           	if(!validator.form()){
				return false;
			}
           	if( $.trim(devicetype) == "0" )
           	{
           		form1.action = "toAddRuleInfoAction.action";
           	}
           	else
           	{
           		form1.action = "toModifyRuleInfoAction.action";
           	}
           	form1.submit();
       	});
     	}
	
	/**
	 * 关闭
	 */
 	$.fn.close = function(){
 		$("#btn_close").click(function(){
  			parent.$("#windown-close").click();
  		});
	}
	
 	/**
	 * 初始化页面元素
	 */
	$.fn.initPage = function(){
		$("#txt_typeName").focus();
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
		<s:hidden id="hid_ruleId" name="ruleInfo.id"></s:hidden>
    	<table width="100%" border="0" cellspacing="5" cellpadding="0">
    		<tr>
    			<td colspan="2" style="color:red">
	    			<s:property value="initString"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    			请选择设备类型
    			</td>
    			<td height="26" align="left" bgcolor="#FFFFFF">
				<s:select id="sel_deviceType" list="deviceTypeList" listKey="id" listValue="typeName" headerKey="nothing" headerValue="---请选择---" name="ruleInfo.deviceTypeId" cssStyle="width: 250px;"></s:select>
				</td>
    		</tr>
    		<tr>
    			<td>
    			请选择现象
    			</td>
    			<td height="26" align="left" bgcolor="#FFFFFF">
				<s:select id="sel_resultType" list="resultList" listKey="id" listValue="result" headerKey="nothing" headerValue="---请选择---" name="ruleInfo.resultId" cssStyle="width: 250px;"></s:select>
				</td>
    		</tr>
    		<tr>
    			<td>
    			请选择原因
    			</td>
    			<td height="26" align="left" bgcolor="#FFFFFF">
				<s:select id="sel_reasonType" list="reasonList" listKey="id" listValue="reason" headerKey="nothing" headerValue="---请选择---" name="ruleInfo.reasonId" cssStyle="width: 250px;"></s:select>
				</td>
    		</tr>
    		<tr>
    			<td>
    			请选择建议
    			</td>
    			<td height="26" align="left" bgcolor="#FFFFFF">
				<s:select id="sel_adviceType" list="adviceList" listKey="id" listValue="advice" headerKey="nothing" headerValue="---请选择---" name="ruleInfo.adviceId" cssStyle="width: 250px;"></s:select>
				</td>
    		</tr>
    		
    		<tr>
    			<td colspan="2">
    				<input type="button" id="btn_save" value="保存"/>
    				<input type="button" id="btn_close" value="关闭"/>
    			</td>
    		</tr>
    	</table>
	</s:form>
  </body>
</html>
