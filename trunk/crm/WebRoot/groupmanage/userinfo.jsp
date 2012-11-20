<%@page import="com.boan.crm.common.UserConfig"%>
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
		<j:scriptlink css="true" jquery="true" validate="true"></j:scriptlink>
		<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/timepicke/jquery-ui-1.7.3.custom.css" />
		<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/timepicke/jquery-ui-timepicker-addon.css" />
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-timepicker-addon.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-sliderAccess.js"></script>
		<script type="text/javascript">
		<!--
			var _customer_submit = {
			rules: {
				"user.username":{required:true,strangecode:true},
				"user.userCName":{required:true,strangecode:true},
				<s:if test="null==user.id||user.id.isEmpty">
				"user.password":{required:true},
				</s:if>
				"user.birthday":{validatedate:true},
				"user.officePhone":{strangecode:true},
				"user.phone":{strangecode:true},
				"user.email":{email:true},
				"user.roleId":{selectvalidate:true}
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
		  		$.fn.configpasswod();
		  		$.fn.initpage();
		  		$.fn.initpassword();
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
	               	form1.action = "./saveOrUpdateUserAction.action";
	               	form1.target = "iframe1";
	               	<s:if test="user.deleteFlag==1">
	               		$("#roleId").attr("disabled",false);
	               	</s:if>
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
				$("#username").focus();
				$("#birthday").datetimepicker({showTimepicker: false});
			}
			/**
          	 * 设置初始密码，如果是新增加用户，则默认为初始密码，否则为空
          	 */
          	$.fn.configpasswod = function(){
          		if( $.trim($("#userId").val()) == "" )
          		{
	          		$("#password").val( "<%=UserConfig.DEFAULT_PASSWORD%>" );
          		}
          		else
          		{
          			$("#password").val( "" );
          		}
          	}
			/**
          	 * 初始化密码
          	 */
          	$.fn.initpassword = function(){
          		$("#button3").click(function(){
	          		if( confirm("确定要将密码初始化为[ <%=UserConfig.DEFAULT_PASSWORD%> ]吗？ ") )
	          		{
	          			$.fn.commitinitpassword();
	          		}
          		});
          	}
			/**
          	 * 异步初始化密码
          	 */
          	$.fn.commitinitpassword = function(){
				var myData;
				$.ajax({
					type: "post",
					dataType: "json",
					url: "./initUserPasswordAction.action",
					data: {"user.id": $("#userId").val() }, 
					beforeSend: function(XMLHttpRequest){
						;
					},
					success: function(data, textStatus){
						myData= eval('('+data+')');
					},
					complete: function(XMLHttpRequest, textStatus){ 
					     if(myData.jsonData=="success"){
					     	alert("密码初始化成功！");
					     }
					     else
					     {
					     	alert("无此用户，请联系管理员！");
					     }
					},
					error: function(){
						alert("异步请求处理出错！");
					}
				});
			}
		//-->
		</script>
	</head>
	<body>
		<s:form name="form1" id="form1" method="post" theme="simple">
			<s:hidden name="user.id" id="userId"></s:hidden>
			<s:hidden name="deptId" id="deptId"></s:hidden>
			<s:hidden name="companyId" id="companyId"></s:hidden>
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
												<strong>用 户 名：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="user.username" id="username" cssStyle="width: 250px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>中文姓名：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="user.userCName" id="userCName" cssStyle="width: 250px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>用户密码：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="user.password" id="password" maxlength="25"
													cssStyle="width:150px;" value=""></s:textfield>
												<s:if test="null==user.id||user.id.isEmpty">
													<span style="color: #ff0000">*</span>
												</s:if>
												<s:else>
												<input type="button" name="button3" value="初始化密码" id="button3"
													class="SkinImg Btn_4" />
												</s:else>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>出生日期：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="user.birthday" id="birthday" cssStyle="width: 250px;" maxlength="25"></s:textfield>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>生日类型：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<input type="checkbox" name="lunarSolarFlag" id="lunarSolarFlag" value="1"
												<s:if test='user.lunarSolarFlag =="1"'>
													checked="true"
												</s:if>
												>农历生日
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>办公电话：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="user.officePhone" id="officePhone" cssStyle="width: 250px;" maxlength="25"></s:textfield>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>个人手机：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="user.phone" id="phone" cssStyle="width: 250px;" maxlength="25"></s:textfield>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>电子邮箱：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="user.email" id="email" cssStyle="width: 250px;" maxlength="100"></s:textfield>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>用户职务：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
											<s:if test="user.deleteFlag==1">
												<span  onMouseMove="this.setCapture();" onMouseOut="this.releaseCapture();" onfocus="this.blur();">
												<s:select title="您不能修改自己的职务" list="roleList" listKey="id" listValue="roleName" value="user.roleId" 
													id="roleId" name="user.roleId" cssStyle="width:250px" headerKey="" headerValue="--请选择职务--"></s:select>
												</span><br/>
												<font color="#FF0000" title="不能修改自己的职务" style="font-size:9pt;">[ 不能修改自己的职务 ]</font>
											</s:if>
											<s:else>
												<s:select list="roleList" listKey="id" listValue="roleName" value="user.roleId" 
													id="roleId" name="user.roleId" cssStyle="width:250px" headerKey="" headerValue="--请选择职务--"></s:select>
											</s:else>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>权限类型：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:if test="user.deleteFlag==1">
													<span  onMouseMove="this.setCapture();" onMouseOut="this.releaseCapture();" onfocus="this.blur();">
														<s:radio list="userTypeList" listKey="key" listValue="value" id="userType" name="user.userType" value="user.userType">
														</s:radio>
													</span>
													<br/>
													<font color="#FF0000" title="不能修改自己的用户类别" style="font-size:9pt;">[ 不能修改自己的用户类别 ]</font>
												</s:if>
												<s:else>
													<s:radio list="userTypeList" listKey="key" listValue="value" id="userType" name="user.userType" value="user.userType">
													</s:radio>
												</s:else>
											</td>
										</tr>
										<tr>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												<font style="font-size: 9pt;color=#FF0000">注：用户密码为空时，保存功能不会对原用户密码进行修改。</font>
												<br/>
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
