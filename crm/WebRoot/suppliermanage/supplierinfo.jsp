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
		<script type="text/javascript">
		<!--
			var _customer_submit = {
			rules: {
				"user.username":{required:true,strangecode:true},
				"user.userCName":{required:true,strangecode:true},
				<s:if test="null==user.id||user.id.isEmpty">
				"user.password":{required:true},
				</s:if>
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
			<s:hidden name="supplier.id" id="supplierId"></s:hidden>
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
												<strong>供货商名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="supplier.supplierName" id="supplierName" cssStyle="width: 250px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>供货商编号：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="supplier.supplierNumber" id="supplierNumber" cssStyle="width: 250px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 产品：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textarea name="supplier.product" id="product" cssStyle="width: 250px;"  rows="5"></s:textarea>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 备注：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textarea name="supplier.memo" id="memo" cssStyle="width: 250px;" rows="5"></s:textarea>
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
