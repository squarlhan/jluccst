<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 * All right reserved.
	 */
	/**
	 * @author zhaomengxue
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>报表模板维护</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true"
			jquery="true" validate="true" />
	 	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		/**
		 * 验证条件
		 */
		var _report_submit = {
			rules : {
				"template.reportDate" : {date : true},
				"template.reportType":{required:true,maxlength:20},
				"template.reportSubject":{required:true,maxlength:20},
				"template.reportPerson":{required:true,maxlength:20},
				"template.reportContent":{maxlength:500}
				},messages:{
					"template.reportType":
					{
					    required:"汇报类别为必填项！",
						maxlength:"汇报类别最多输入20个字符！"
					},
					"template.reportSubject":
					{
						required:"汇报题目为必填项！",
						maxlength:"汇报题目最多输入20个字符！"
					},
					"template.reportPerson":
					{
						required:"汇报人为必填项！",
						maxlength:"汇报人最多输入20个字符！"
					},
					"template.reportContent":
					{
						maxlength:"汇报内容最多输入20个字符！"
					}
					}
				};
		


		/**
		 * 准备工作
		 */
		$(document).ready(function() {
			$.validator.setDefaults({
				//验证框架的验证器的默认设置区
				debug : false,
				onkeyup : false,
				onfocusout : false,
				focusCleanup : true,
				errorPlacement : function(error, element) {
				},
				invalidHandler : function(form, validator) {
					$.each(validator.invalid, function(key, value) {
						alert(value);
						document.getElementById(key).focus();
						return false;
					});
				}
			})
			$.fn.save();
			$.fn.close();
	  	});


		/**
		 * 保存
		 */
		$.fn.save = function() {
			//如果有id就说明是修改action
			var reportId = $("#hid_reportId").val();
			$("#addBtn").click(function() {
				var validate_settings_submit = jQuery.extend({}, _report_submit);
				var validator = $("form").validate(validate_settings_submit);
				if (!validator.form()) {
					return false;
				}
	
				repform.action = "toAddTemplateAction.action";
			

				repform.submit();
			});
		}

		/**
		 * 关闭
		 */
		$.fn.close = function() {
			$("#closeBtn").click(function() {
				parent.$("#windown-close").click();
			});
		}
</script>
</head>
<body>
		<s:form id="repform" theme="simple">
			<s:hidden id="hid_reportId" name="report.id"></s:hidden>
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
												<strong>汇报类别：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="txt_reportType" name="report.reportType" />
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>汇报题目：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="txt_reportSubject"
													name="report.reportSubject" />
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>汇报人：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="txt_reportPerson"
													name="report.reportPerson" />
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>汇报时间：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="txt_reportDate" name="report.reportDate" />
											</td>
										</tr>
										<tr>
											<td height="147" align="right" bgcolor="#FFFFFF">
												<strong>汇报内容：</strong>
											</td>
											<td height="147" align="left" bgcolor="#FFFFFF">
												<s:textarea id="txt_reportContent"
													name="report.reportContent"
													cssStyle="width:250px;height:100px; resize: none;" />
											</td>
										</tr>
										<tr>
											<td height="26" colspan="2" align="left" bgcolor="#FFFFFF">
												<input name="addBtn" type="button" value="确定" class="btn_2_3"
													id="addBtn" />
												&nbsp;&nbsp;
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

