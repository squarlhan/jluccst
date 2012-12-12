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
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _device_submit = {
				rules: {
					"sellDuty.name":{required:true,maxlength:25}
				},messages:{
					"sellDuty.name":
					{
					    required:"城市名称为必填项！",
						maxlength:"城市名称最多输入25个汉字！"
					}
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
				//如果有id就说明是修改action
				$("#addBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _device_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
	               	
					form1.name.value = $("#name").val();
					if($("#sellDutyId").val()!=""){
						form1.action = "modifySellDutyAction.action";
					}else{
						form1.action = "addSellDutyAction.action";
					}
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
				$("#name").focus();
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
			<s:hidden id="sellDutyId" name="sellDuty.id"></s:hidden>
			<s:hidden id="companyId" name="companyId"></s:hidden>
			<s:hidden id="companyName" name="companyName"></s:hidden>
			<s:hidden id="createTime" name="createTime"></s:hidden>
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
												<strong>职责名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="name" name="sellDuty.name"
													maxlength="25" cssStyle="width: 230px;"></s:textfield> 数值型
													<s:checkbox id="chk_numberType"  name="sellDuty.numberType" fieldvalue="true"  title="数值型表示是销售额" ></s:checkbox>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>职责类型：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:radio list="#{'0':'周报/周计划','1':'月报/月计划'}" name="sellDuty.dutyType"></s:radio>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>职责说明：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textarea  id="remark" name="sellDuty.remark" cssStyle="width: 300px;height:80px;" maxlength="100" ></s:textarea>
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