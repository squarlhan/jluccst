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
		<title>信息管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _customer_submit = {
				rules: {
					"goodsInfoBase.name":{required:true,strangecode:true},
					"goodsInfoBase.goodsStandard":{required:true,strangecode:true},
					"goodsInfoBase.factoryName":{required:true,strangecode:true},
					"goodsInfoBase.goodsPrice":{required:true,strangecode:true},
					"goodsInfoBase.remark":{strangecode:true}
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
	               	form1.infoId.value = $("#hdInfoId").val();
	               	form1.typeId.value = $("#typeId").val();
	               	form1.name.value = $("#txt_name").val();
	               	form1.goodsStandard.value = $("#txt_goodsStandard").val();
	               	form1.factoryName.value = $("#txt_factoryName").val();
	               	form1.goodsPrice.value = $("#txt_goodsPrice").val();
	               	form1.remark.value = $("#txt_remark").val();
					form1.action = "<%=path%>/goodsmanage/savegoodsinfobase.action";
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
				$("#txt_name").focus();
				if($("#message").val()!=""){
					alert($("#message").val());
				}
			}
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="hdInfoId" name="goodsInfoBase.id"></s:hidden>
		<s:hidden id="message" name="message" />
		<s:hidden id="typeId" name="typeId" />
		<s:hidden id="infoId" name="infoId" />
		<s:hidden id="name" name="name" />
		<s:hidden id="goodsStandard" name="goodsStandard" />
		<s:hidden id="factoryName" name="factoryName" />
		<s:hidden id="goodsPrice" name="goodsPrice" />
		<s:hidden id="remark" name="remark" />
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
											<strong>商品名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_name" name="goodsInfoBase.name" cssStyle="width: 250px;" maxlength="25"></s:textfield>
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>规　　格：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_goodsStandard" name="goodsInfoBase.goodsStandard" cssStyle="width: 250px;" maxlength="100"></s:textfield>
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>厂　　家：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_factoryName" name="goodsInfoBase.factoryName" cssStyle="width: 250px;" maxlength="100"></s:textfield>
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>价　　格：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_goodsPrice" name="goodsInfoBase.goodsPrice" cssStyle="width: 250px;" maxlength="100"></s:textfield>
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>备　　注：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_remark" name="goodsInfoBase.remark" cssStyle="width: 250px;" maxlength="100"></s:textfield>
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
