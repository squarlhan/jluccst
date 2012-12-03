<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" jmessagebox="true" jquery="true"
			tipswindow="true" validate="true" jfunction="true" />
			<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
		<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
		
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
		
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _device_submit = {
				rules: {
					"contractPersonInfo.personName":{required:true,maxlength:10},
					"contractPersonInfo.email":{email:true},
					"contractPersonInfo.deptOrDuty":{required:true},
					"contractPersonInfo.birthday":{dateISO:true}
					
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
				});
		  		$('#birthday').datetimepicker({showTimepicker: false,changeMonth: true, changeYear: true,yearRange:'-80:0'});
				$.fn.save();
		  		$.fn.close();
		  		$.fn.initpage();
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
					form1.personName.value = $("#dictName_t").val();
					form1.customerId_t.value = form1.customerId.value;
					form1.action = "customer/saveContractPerson.action";
	               	form1.submit();
	           	});
          	};
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			var message = $("#lb_message").html();
					if(message!=null && $.trim(message)!="" ){
					}
					parent.$("#windown-close").click();
		  		});
			};
			/**
			 * 初始化页面
			 */
			$.fn.initpage = function(){
				$("#dictName_t").focus();
				//回显上传时的错误信息
				var uploadErr = $("#lb_error").html();
				if(uploadErr!=null && $.trim(uploadErr)!="" ){
					alert(uploadErr);
				}
				
				var message = $("#lb_message").html();
				if(message!=null && $.trim(message)!="" ){
					alert(message);
					
					parent.$("#windown-close").click();
				}
			};
			
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
			<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
			<s:hidden id="customerId" name="customerId"></s:hidden>
			<s:hidden id="customerId_t" name="contractPersonInfo.customerId"></s:hidden>
			<s:hidden id="personId" name="contractPersonInfo.id"></s:hidden>
			<input type="hidden" name="personName" value="" />
			<table width="100%" border="0" cellspacing="5" cellpadding="0">
				<tr>
					<td>
						<table width="100%" style="height: 100%;" border="0"
							cellspacing="6" cellpadding="0">
							<tr>
								<td style="height: 36px;">
									<table id="table1" width="100%" border="0" cellpadding="5"
										cellspacing="1" bgcolor="#d5e4fd">
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>姓名：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="dictName_t" name="contractPersonInfo.personName"
													maxlength="25" cssStyle="width: 300px;"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>部门/职务</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="dept" name="contractPersonInfo.deptOrDuty"
													maxlength="25" cssStyle="width: 300px;"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>手 机</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="phone" name="contractPersonInfo.phone"
													maxlength="25" cssStyle="width: 300px;"></s:textfield>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>固定电话</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="tel" name="contractPersonInfo.tel"
													maxlength="25" cssStyle="width: 300px;"></s:textfield>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>昵 称</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="nickName" name="contractPersonInfo.nickName"
													maxlength="25" cssStyle="width: 300px;"></s:textfield>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>生 日<br>(1970-01-01)</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="birthday" name="contractPersonInfo.birthday"
													maxlength="25" cssStyle="width: 300px;" readOnly="true"></s:textfield>
													<br/>
													<s:if test='lunarStr.equals("1")'>
													<input type="checkbox" name="lunarStr" value="1" checked="true">农历
													</s:if>
													<s:else>
													<input type="checkbox" name="lunarStr" value="1">农历
													</s:else>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>QQ</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="qq" name="contractPersonInfo.qq"
													maxlength="25" cssStyle="width: 300px;"></s:textfield>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>E-MAIL</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="email" name="contractPersonInfo.email"
													maxlength="25" cssStyle="width: 300px;"></s:textfield>
											</td>
										</tr>
										<tr>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												<input name="addBtn" type="button" class="btn_2_3"
													id="addBtn" value="确定">
												&nbsp;&nbsp;
												<input name="closeBtn" type="button" class="btn_2_3"
													id="closeBtn" value="关闭">
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