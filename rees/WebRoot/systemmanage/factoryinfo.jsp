<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author yangGY
 * @version 1.0
 * @audit  
 */
/**
 * Modified Person：
 * Modified Time：
 * Modified Explain：
 */
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>工厂信息管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true" jfunction="true"/>
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
		  	var _customer_submit = {
				rules: {
					"factory.factoryName":{required:true,strangecode:true},
					"factory.phone":{strangecode:true},
					"factory.principal":{strangecode:true}
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
		  		$.fn.initpage();
		  	});
			/**
		  	 * 保存
		  	 */
			$.fn.save = function(){
				$("#addBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _customer_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
					if( $.trim( $("#factoryId").val() ) != ""){
						form1.action = "toModifyFactoryAction.action";
					}else{
		               	form1.action = "toAddFactoryAction.action";					
					}
					form1.target = "iframe1";
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
			 * 初始化页面
			 */
			$.fn.initpage = function(){
				$("#factoryName").focus();
			}
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="factoryId" name="factory.id"></s:hidden>
		<s:hidden id="companyId" name="companyId"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
										<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>工厂名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="factoryName" name="factory.factoryName" cssStyle="width: 250px;" maxlength="25"></s:textfield>
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>工厂电话：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="phone" name="factory.phone" cssStyle="width: 250px;" maxlength="100"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>工厂负责人：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="pricipal" name="factory.principal" cssStyle="width: 250px;" maxlength="25"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="确定">
											&nbsp;&nbsp;
											<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="取消">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<iframe id="iframe1" name="iframe1" width="1px" height="1px"></iframe>
		</s:form>
	</body>
</html>
