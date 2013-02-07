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
				"purchaseRecord.productType":{required:true,strangecode:true},
				"purchaseRecord.productId":{required:true,strangecode:true},
				"purchaseRecord.specification":{required:true,strangecode:true},
				//"purchaseRecord.gramWeight":{required:true,strangecode:true},
				//"purchaseRecord.ton":{required:true,strangecode:true},
				"purchaseRecord.amount":{required:true,isPositiveNum:true},
				"purchaseRecord.freight":{required : true,isNotNegativeNum:true},
				"purchaseRecord.accountPayable":{required : true,isNotNegativeNum:true},
				"purchaseRecord.actualPayment":{required : true,isNotNegativeNum:true},
				"purchaseRecord.amountInArrear":{required : true,isNotNegativeNum:true},
				"purchaseRecord.unitPrice":{required : true,isNotNegativeNum:true},
				"purchaseRecord.memo":{strangecode:true,maxlength:500}
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
	               	form1.action = "./savePurchaseRecordAction.action";
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
				$("#specification").focus();
			}
			function productTypeIdChange(){
				form1.action = "./showPurchaseRecordInfoAction.action";
				document.getElementById("changeFlag").value="change";
				form1.submit();
			}
			function productIdChange(){
				form1.action = "./showPurchaseRecordInfoAction.action";
				document.getElementById("changeFlag").value="change";
				form1.submit();
			}
		//-->
		</script>
	</head>
	<body>
		<s:form name="form1" id="form1" method="post" theme="simple">
			<s:hidden name="purchaseRecord.id" id="purchaseRecordId"></s:hidden>
			<s:hidden name="purchaseRecord.batchId" id="batchId"></s:hidden>
			<input type="hidden" value="" name="changeFlag" id="changeFlag" />
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
												<strong>产品类别：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
											<!-- 
												<s:textfield name="purchaseRecord.productName" id="productName" cssStyle="width: 290px;" maxlength="25"></s:textfield>
											 -->
											 	<s:select list="productTypeList" name="purchaseRecord.productType" id="productTypeId"  cssStyle="width: 290px;" 
											 	headerKey="" headerValue="==请选择产品类别==" listKey="id" listValue="name" onchange="productTypeIdChange();"></s:select>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>产品名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
											<!-- 
												<s:textfield name="purchaseRecord.productName" id="productName" cssStyle="width: 290px;" maxlength="25"></s:textfield>
											 -->
											 	<s:select list="productList" name="purchaseRecord.productId" id="productId"  cssStyle="width: 290px;" 
											 	headerKey="" headerValue="==请选择产品==" listKey="id" listValue="name" onchange="productIdChange();"></s:select>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>规格：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseRecord.specification" id="specification" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<!-- 
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 克重：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseRecord.gramWeight" id="gramWeight" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 吨：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseRecord.ton" id="ton" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										 -->
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 数量：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseRecord.amount" id="amount" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 单价：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseRecord.unitPrice" id="freight" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 运费：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseRecord.freight" id="freight" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 应付款：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseRecord.accountPayable" id="accountPayable" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 实付款：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseRecord.actualPayment" id="actualPayment" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 欠款：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseRecord.amountInArrear" id="amountInArrear" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 备注：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textarea name="purchaseRecord.memo" id="memo" cssStyle="width: 290px;" rows="3"></s:textarea>
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
