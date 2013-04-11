<%@page import="com.boan.crm.groupmanage.security.CheckProductKey"%>
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
		<script type="text/javascript" src="<%=path %>/js/My97DatePicker/WdatePicker.js"></script>
		<!-- 
		<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/timepicke/jquery-ui-1.7.3.custom.css" />
		<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/timepicke/jquery-ui-timepicker-addon.css" />
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-timepicker-addon.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-sliderAccess.js"></script>
		 -->
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
					<%if (CheckProductKey.isPinLoginMethod()){%>
					if(!Validate()){
						return false;
					}
					<%}%>
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
		<%if(CheckProductKey.isPinLoginMethod()){ %>
		<script language=javascript>
		function ShowErr(Msg){
			alert(Msg);
		}
		function Validate(){
			var oldPin = document.getElementById("password").value;
			var newPin = document.getElementById("newPassword").value;
			var validPin = document.getElementById("validPassword").value;
			
			if (oldPin.length == 0){
				ShowErr( "请输入原PIN码！" );
				document.getElementById("password").focus();
				return false;
			}
			
			if (oldPin.length < 4){
				ShowErr( "原PIN码长度至少为4位！" );
				document.getElementById("password").focus();
				return false;
			}
		
			try{
				ePass.GetLibVersion();
			}catch( e ) {
				ShowErr ("请安装ePass 1000安全控件！如有问题请联系管理人员。");
				return false;
			}
			try
			{
				ePass.OpenDevice( 1, "");
			}catch(e)
			{
				ShowErr ("请检查USB锁是否连接正确！");
				return false;
			}
			try
			{
	        	ePass.VerifyPIN (0, oldPin);
			}catch(e)
			{
				ePass.CloseDevice();
				ShowErr ("原PIN码校验失败，请重新输入！");
				document.getElementById("password").value="";
				return false;
			}
			//判断是否要修改PIN码
			if( newPin != "" )
			{
				if (newPin.length < 4){
					ePass.CloseDevice();
					ShowErr( "新PIN码长度至少为4位！" );
					document.getElementById("newPassword").focus();
					return false;
				}
				if( newPin == validPin )
				{
					try
					{
						//改PIN
						ePass.ChangeCode(0,oldPin,newPin);
						ShowErr ("PIN码修改成功！");
					}catch(e)
					{
						ePass.CloseDevice();
						ShowErr ("PIN码修改失败！");
						return false;
					}
				}
			}
			ePass.CloseDevice();
			return true;
		}
		</script>
		<%}%>
	</head>
	<body>
		<%if(CheckProductKey.isPinLoginMethod()){ %>
				<OBJECT classid="clsid:0AA5300D-42FC-42A0-9487-357CCC060A7A" height="0" id="ePass"  name="ePass" style="LEFT: 0px; TOP: 0px" width="0"></OBJECT>
		<%} %>
		<s:form name="form1" id="form1" method="post" theme="simple">
			<s:hidden name="user.id" id="userId"></s:hidden>
			<s:hidden name="companyId" id="companyId"></s:hidden>
			<s:hidden name="factoryId" id="factoryId"></s:hidden>
			<s:hidden name="workshopId" id="workshowId"></s:hidden>
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
												<s:label name="user.username" id="labelusername" title="用户名不能修改"></s:label>
												<s:hidden name="user.username" id="username"></s:hidden>
											</td>
										</tr>
										
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>中文姓名：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="user.userCName" id="userCName" cssStyle="width: 240px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
												<strong>
												<%if(CheckProductKey.isPinLoginMethod()){ %>
													用户PIN码：
												<%}else{%>
													用户密码：
												<% }%>
												</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:password name="user.password" id="password" maxlength="25" cssStyle="width: 240px;"></s:password>
												<span style="color: #ff0000">*</span>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>
												<%if(CheckProductKey.isPinLoginMethod()){ %>
													新PIN码：
													<%}else{%>
													新 密 码：
													<%} %>
												</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:password name="newPassword" id="newPassword" maxlength="25" cssStyle="width: 250px;"></s:password>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>
												<%if(CheckProductKey.isPinLoginMethod()){ %>
													效验PIN码：
													<%}else{%>
													效验密码：
													<%} %>
												</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:password name="validPassword" id="validPassword" maxlength="25" cssStyle="width: 250px;"></s:password>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>出生日期：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="user.birthday" id="birthday" cssStyle="width: 250px;" maxlength="25" onclick="WdatePicker()"></s:textfield>
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
											<span  onMouseMove="this.setCapture();" onMouseOut="this.releaseCapture();" onfocus="this.blur();">
												<s:select title="您不能修改自己的职务" list="roleList"
													listKey="id" listValue="roleName" value="user.roleId"
													id="roleId" name="user.roleId" cssStyle="width:100%"
													headerKey="" headerValue="--请选择职务--"></s:select>
											</span>
											<font color="#FF0000" title="不能修改自己的职务" style="font-size:9pt;">[ 不能修改自己的职务]</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>权限类型：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<span  onMouseMove="this.setCapture();" onMouseOut="this.releaseCapture();" onfocus="this.blur();">
													<s:radio list="userTypeList" listKey="key" listValue="value" id="userType" name="user.userType" value="user.userType">
													</s:radio>
												</span>
												<br/>
												<font color="#FF0000" title="不能修改自己的用户类别" style="font-size:9pt;">[ 不能修改自己的用户类别 ]</font>
											</td>
										</tr>
										<tr>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												<font style="font-size: 9pt;color=#FF0000">注：新密码为空时，保存功能不会对原用户密码进行修改。</font>
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
