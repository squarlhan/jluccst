<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	/**
	 * Copyright (c) 2005 Changchun Boan (BOAN) Co. Ltd.
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
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
%>
<html>
	<head>
		<title>用户信息</title>
		<META http-equiv=Content-Type content="text/html; charset=utf-8">
		<j:scriptlink css="true" jquery="true" validate="true" jfunction="true"></j:scriptlink>
		<script type="text/javascript">
			var _customer_submit = {
				rules: {
					"user.userCName":{required:true,strangecode:true},
					"user.password":{required:true},
					"newPassword":{equalTo:"#validPassword"},
					"user.sex":{required:true},
					"user.officePhone":{strangecode:true},
					"user.phone":{strangecode:true},
					"user.roleId":{selectvalidate:true}
				},
				messages:{
					"user.userCName":{required:"用户中文名必须填写！",strangecode:"【用户中文名】中存在 \'\"\\/<>*:?|%$#@&~^ 非法字符， \n\n请更正或以中文符号替换 ！"},
					"user.password":{required:"用户登录密码必须填写！"},
					"newPassword":{equalTo:"您两输入的密码不一样，请重新输入！"},
					"user.sex":{required:"请选择性别！"},
					"user.phone":{strangecode:"【用户中文名】中存在 \'\"\\/<>*:?|%$#@&~^ 非法字符， \n\n请更正或以中文符号替换 ！"},
					"user.roleId":{selectvalidate:"请选择角色！"}
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
		</script>
	</head>
	<body>
		<s:form name="form1" method="post" id="form1" theme="simple">
			<div class="centerDiv">
				<table cellpadding="5" cellspacing="5" border="0"
					style="margin: 0px; width: 600px;">
					<tr>
						<td style="width: 175px">
							登录用户名
						</td>
						<td style="width: 499px">
							<s:textfield name="user.username" id="userName" maxlength="25"
								readonly="true"></s:textfield>
							<font style="font-size: 9pt">（不可修改）</font>
						</td>
					</tr>
					<tr>
						<td style="width: 175px">
							真实姓名
						</td>
						<td style="width: 499px">
							<s:textfield name="user.userCName" id="userCName" maxlength="25"></s:textfield>
							<font color="red">*</font>
						</td>
					</tr>

					<tr>
						<td style="width: 175px">
							性别
						</td>
						<td style="width: 499px">
							
						</td>
					</tr>

					<tr>
						<td style="width: 175px">
							登录密码
						</td>
						<td style="width: 499px">
							<s:password name="user.password" id="password" maxlength="25"></s:password>
							<span style="color: #ff0000">*</span>
						</td>
					</tr>
					<tr>
						<td style="width: 175px">
							新密码
						</td>
						<td style="width: 499px">
							<s:password name="newPassword" id="newPassword" maxlength="25"></s:password>
						</td>
					</tr>
					<tr>
						<td style="width: 175px">
							校验密码
						</td>
						<td style="width: 499px">
							<s:password name="validPassword" id="validPassword"
								maxlength="25"></s:password>
						</td>
					</tr>
					<tr>
						<td style="width: 175px">
							单位电话
						</td>
						<td style="width: 499px">
							<s:textfield name="user.officePhone" id="officePhone"
								cssStyle="width:100%" maxlength="100"></s:textfield>
						</td>
					</tr>
					<tr>
						<td style="width: 175px">
							联系方式
						</td>
						<td style="width: 499px">
							<s:textfield name="user.phone" id="phone" cssStyle="width:100%"
								maxlength="100"></s:textfield>
						</td>
					</tr>
					<tr>
						<td style="width: 175px">
							角色
						</td>
						<td style="width: 499px">
						</td>
					</tr>
					<tr>
						<td style="width: 175px">
							用户类别
						</td>
						<td style="width: 499px">
						</td>
					</tr>
					<tr>
						<td align="center" class="FooterStyle" colspan="2">
							<div style="margin-bottom: 3px">
								<font style="font-size: 9pt;color:red">注：新密码为空时，保存功能不会对原用户密码进行修改。</font>
								<br>
								<input type="button" name="button1" value="保 存" id="button1"
									class="SkinImg Btn_2" />
								<input type="reset" name="button2" value="重 置" id="button2"
									class="SkinImg Btn_2" />
							</div>
						</td>
					</tr>
				</table>
			</div>
		</s:form>
		<iframe id="iframe1" name="iframe1" width="1px" height="1px"></iframe>
	</body>
</html>
