<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>

<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 * All right reserved.
	 */
	/**
	 * @author XXX
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
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" jquery="true" validate="true" date="true"></j:scriptlink>
		<script type="text/javascript">
		<!--
			var _customer_submit = {
			rules: {
				"user.userCName":{required:true,strangecode:true},
				"user.password":{required:true},
				"newPassword":{equalTo:"#validPassword"},
				"user.birthday":{validatedate:true},
				"user.officePhone":{strangecode:true},
				"user.phone":{strangecode:true},
				"user.email":{email:true}
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
				$("#button1").click(function() {
					var validate_settings_submit = jQuery.extend({}, _customer_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
	               	$("#roleId").attr("disabled",false);
	               	form1.action="./saveOrUpdateMyInfoAction.action"
	               	form1.target = "iframe1";
	               	form1.submit();
	           	});
          	}
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
			 	$("#button2").click(function() {
					parent.$("#windown-close").click();
				});
			}
			/**
			 * 初始化页面
			 */
			$.fn.initpage = function(){
				$("#userCName").focus();
				//$("#birthday").datetimepicker({showTimepicker: false});
			}
		//-->
		</script>
	</head>
	<body>
		<s:form name="form1" id="form1" method="post" theme="simple">
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
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>功能分类：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:label name="user.username" id="labelusername" title="用户名不能修改"></s:label>
												<s:hidden name="user.username" id="username"></s:hidden>
											</td>
										</tr>
										
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>意见内容：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textarea name="user.userCName" id="userCName" cssStyle="width: 450px;" rows="12" ></s:textarea>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												<input name="button1" type="button" class="btn_2_3"
													id="button1" value="确定">
												<input name="button2" type="button" class="btn_2_3"
													id="button2" value="取消">
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
		<iframe id="iframe1" name="iframe1" width="1px" height="1px"></iframe>
	</body>
</html>
