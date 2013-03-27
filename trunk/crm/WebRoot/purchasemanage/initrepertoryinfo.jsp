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
				"initRepertory.productType":{required:true,strangecode:true},
				"initRepertory.productId":{required:true,strangecode:true},
				"initRepertory.productName":{required:true,strangecode:true},
				"initRepertory.amount":{required:true,isPositiveNum:true},
				"initRepertory.accountPayable":{required : true,isNotNegativeNum:true},
				"initRepertory.actualPayment":{required : true,isNotNegativeNum:true},
				"initRepertory.amountInArrear":{required : true,isNotNegativeNum:true},
				"initRepertory.totalValue":{required : true,isNotNegativeNum:true}
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
	               	form1.action = "./initRepertoryAction!saveInitRepertoryInfo.action";
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
				$("#productTypeId").focus();
			}
			function productTypeIdChange(){
				form1.action = "./initRepertoryAction!showInitRepertoryInfo.action";
				document.getElementById("changeFlag").value="change";
				form1.submit();
			}
			function productIdChange(){
				form1.action = "./initRepertoryAction!showInitRepertoryInfo.action";
				document.getElementById("changeFlag").value="change";
				form1.submit();
			}
			function calculation(){
				//应付
				var f1 = document.getElementById("accountPayable").value;
				//实付
				var f2 = document.getElementById("actualPayment").value;
				//欠款
				document.getElementById("amountInArrear").value = (eval(f1)-eval(f2)).toFixed(2);
			}
			Number.prototype.toFixed = function(d) //d表示小数位保留几位小数   

			{    

			    var s=this+"";if(!d)d=0;    

			    if(s.indexOf(".")==-1)s+=".";s+=new Array(d+1).join("0");    

			    if (new RegExp("^(-|\\+)?(\\d+(\\.\\d{0,"+ (d+1) +"})?)\\d*$").test(s))    

			   {    

			       var s="0"+ RegExp.$2, pm=RegExp.$1, a=RegExp.$3.length, b=true;    

			      if (a==d+2){a=s.match(/\d/g); if (parseInt(a[a.length-1])>4)    

			      {    

			           for(var i=a.length-2; i>=0; i--) {a[i] = parseInt(a[i])+1;    

			            if(a[i]==10){a[i]=0; b=i!=1;} else break;}    

			        }    

			        s=a.join("").replace(new RegExp("(\\d+)(\\d{"+d+"})\\d$"),"$1.$2");    

			    }if(b)s=s.substr(1);return (pm+s).replace(/\.$/, "");} return this+"";    

			}; 
		//-->
		</script>
	</head>
	<body>
		<s:form name="form1" id="form1" method="post" theme="simple">
			<s:hidden name="initRepertory.id" id="initRepertoryId"></s:hidden>
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
											 	<s:select list="productTypeList" name="initRepertory.productType" id="productTypeId"  cssStyle="width: 290px;" 
											 	headerKey="" headerValue="==请选择产品类别==" listKey="id" listValue="name" onchange="productTypeIdChange();"></s:select>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>产品名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
											 	<s:select list="productList" name="initRepertory.productId" id="productId"  cssStyle="width: 290px;" 
											 	headerKey="" headerValue="==请选择产品==" listKey="id" listValue="name" onchange="productIdChange();"></s:select>
												<font color="red">*</font>
											</td>
										</tr>
										<!-- 
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>产品名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="initRepertory.productName" id="productName" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										 -->
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 库存量：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="initRepertory.amount" id="amount" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 应付总额：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="initRepertory.accountPayable" id="accountPayable" cssStyle="width: 290px;" maxlength="25" onkeyup="calculation();"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 实付总额：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="initRepertory.actualPayment" id="actualPayment" cssStyle="width: 290px;" maxlength="25" onkeyup="calculation();"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 欠款：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="initRepertory.amountInArrear" id="amountInArrear" cssStyle="width: 290px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong> 总价值：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="initRepertory.totalValue" id="totalValue" cssStyle="width: 290px;" maxlength="25"></s:textfield>
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
