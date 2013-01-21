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
		<title>公司信息管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _customer_submit = {
				rules: {
					"company.companyName":{required:true,strangecode:true},
					"company.corporation":{strangecode:true},
					"company.address":{strangecode:true},
					"company.phone":{strangecode:true},
					"company.fax":{strangecode:true},
					"company.smsSN":{strangecode:true},
					"company.smsPassword":{strangecode:true},
					"company.smsKey":{strangecode:true}
				}
			};
			/**
		  	 * 准备工作
		  	 */
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
				$("#addBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _customer_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
					if( $("#companyId").val()  != ""){
						form1.action = "toModifyCompanyAction.action";
					}else{
		               	form1.action = "toAddCompanyAction.action";					
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
		  			$("#txt_principle").val("");
		  			$("#txt_adress").val("");
		  			$("#txt_phone").val("");
		  			$("#txt_fax").val("");
		  			$("#smsSN").val("");
		  			$("#smsPassword").val("");
		  			$("#smsKey").val("");
		  		});
			}
			/**
			 * 初始化页面
			 */
			$.fn.initpage = function(){
				$("#txt_principle").focus();
			}
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="companyId" name="company.id"></s:hidden>
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
											<strong>公司名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_companyName" name="company.companyName" cssStyle="width: 250px;" maxlength="25" readonly="true"></s:textfield><font style="font-size:9pt;color:#cccccc">（不能修改）</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>法人：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_principle" name="company.corporation" cssStyle="width: 250px;" maxlength="100"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>公司地址：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_adress" name="company.address" cssStyle="width: 250px;" maxlength="100"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>公司电话：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_phone" name="company.phone" cssStyle="width: 250px;" maxlength="100"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>传真：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_fax" name="company.fax" cssStyle="width: 250px;" maxlength="100"></s:textfield>
										</td>
									</tr>
										<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>短信序列号：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="smsSN" name="company.smsSN" cssStyle="width: 250px;" maxlength="100"></s:textfield>
										</td>
									</tr>
										<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>短信密码：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="smsPassword" name="company.smsPassword" cssStyle="width: 250px;" maxlength="100"></s:textfield>
										</td>
									</tr>
										<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>短信Key值：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="smsKey" name="company.smsKey" cssStyle="width: 250px;" maxlength="100"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>短信选项：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<input type="checkbox" name="smsActivation" id="smsActivation" value="1"
											<s:if test='company.smsActivationStatus =="1"'>
											checked="checked"
											</s:if>/> 选中激活短信服务，不选中为注销短信服务
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>服务截至日期：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<strong><s:property value="company.serviceTermCn"/></strong>
											<s:hidden id="serviceTerm" name="company.serviceTerm" />
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>试用限制：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<strong><s:property value="company.trialFlagCn" escape="false"/></strong>
											<s:hidden id="trialFlag" name="company.trialFlag" />
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>产品类型：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<strong><s:property value="company.productTypeCn" escape="false"/></strong>
											<s:hidden id="productType" name="company.productType" />
										</td>
									</tr>
									<tr>
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="保 存">
											&nbsp;&nbsp;
											<input name="closeBtn"  type="button" class="btn_2_3" id="closeBtn" value="清 空">
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
