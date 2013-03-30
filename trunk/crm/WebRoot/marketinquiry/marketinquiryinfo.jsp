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
		<title>市场调查维护</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
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
			var _customer_submit = {
				rules: {
					"marketInquiry.inquiryPersonName":{required:true,strangecode:true},
					"marketInquiry.inquiryTime" :{required:true,strangecode:true},
					"marketInquiry.inquiryAddress"  :{required:true,strangecode:true},
					"marketInquiry.txt_factoryName"  :{required:true,strangecode:true},
					"marketInquiry.goodsName"   :{required:true,strangecode:true},
					"marketInquiry.goodsWeight"   :{strangecode:true},
					"marketInquiry.goodsPrice"  :{required:true,strangecode:true}
				}
			};
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
				$("#txt_inquiryPersonName").focus();
				if($("#hid_message").val()!="" && $("#hid_marketInquiryId").val()!=null){
					alert($("#hid_message").val());
				}
				$('#txt_inquiryTime').val((new Date()).getFullYear()+"-"+(((new Date()).getMonth()+1)<10 ? "0"+((new Date()).getMonth()+1) : (new Date()).getMonth()+1)+"-"+((new Date()).getDate()<10 ? "0"+(new Date()).getDate() : (new Date()).getDate()));
		  		//日期控件
				$('#txt_inquiryTime').datetimepicker({showTimepicker: false});
				$.validator.setDefaults({
					debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
				    errorPlacement:function(error, element) {},
					invalidHandler: function(form, validator) {
			        	$.each(validator.invalid,function(key,value){
			            	alert(value);document.getElementById(key).focus();return false;
			        	}); 
			    	}
				});
				$.fn.save();
		  		$.fn.close();
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
					if( $.trim( $("#hid_marketInquiryId").val() ) != ""){
						form1.action = "modifyMarketInquiryAction.action";
					}else{
		               	form1.action = "addMarketInquiryAction.action";					
					}
	               	form1.submit();
          		});
          	};
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			parent.$("#windown-close").click();
		  		});
			};
		</script>
	</head>

<body>
	<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="hid_message" name="message"></s:hidden>
		<s:hidden id="hid_marketInquiryId" name="marketInquiry.id"></s:hidden>
		<s:hidden id="hid_marketInquirygoodsTypeId" name="marketInquiry.goodsTypeId"></s:hidden>
		<s:hidden id="hid_marketInquirygoodsId" name="marketInquiry.goodsId"></s:hidden>
		<s:hidden id="hid_marketInquiryCreateTime" name="marketInquiry.createTime"></s:hidden>
		<s:hidden id="hid_personId" name="marketInquiry.personId"></s:hidden>
		<s:hidden id="hid_organId" name="marketInquiry.organId"></s:hidden>
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
											<strong>调查人：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_inquiryPersonName" name="marketInquiry.inquiryPersonName" cssStyle="width: 160px;" maxlength="25"></s:textfield><font color="red" title="必填项">*</font>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>调查日期：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_inquiryTime" name="marketInquiry.inquiryTime" cssStyle="width: 160px;" maxlength="25"></s:textfield><font color="red" title="必填项">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>调查地点：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="3">
											<s:textfield id="txt_inquiryAddress" name="marketInquiry.inquiryAddress" cssStyle="width: 465px;" maxlength="25"></s:textfield><font color="red" title="必填项">*</font>
										</td>
									</tr>
									
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>商品名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_goodsName" name="marketInquiry.goodsName" cssStyle="width: 160px;" maxlength="25"></s:textfield><font color="red" title="必填项">*</font>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>商品规格：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_goodsStandard" name="marketInquiry.goodsStandard" cssStyle="width: 160px;" maxlength="25"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>厂商名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="3">
											<s:textfield id="txt_factoryName" name="marketInquiry.factoryName" cssStyle="width: 465px;" maxlength="25"></s:textfield><font color="red" title="必填项">*</font>
										</td>
									</tr>
									<tr>
										
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>价 格：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_goodsPrice" name="marketInquiry.goodsPrice" cssStyle="width: 160px;" maxlength="25"></s:textfield><font color="red" title="必填项">*</font>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>备 注：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_goodsWeight" name="marketInquiry.goodsWeight" cssStyle="width: 160px;" maxlength="25"></s:textfield>
										</td>
									</tr>
									
									<tr>
										<td height="26" colspan="4" align="center" bgcolor="#FFFFFF">
											<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="保存">
											&nbsp;&nbsp;
											<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
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
</body>
</html>
