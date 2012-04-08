<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>添加个人报表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true"
			jquery="true" validate="true" />
	 	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
	/**
	 * 验证条件
	 */
	var _report_submit = {
		rules : {
			"report.reportType":{required:true,maxlength:20},
			"report.reportSubject":{required:true,maxlength:20},
			"report.reportPerson":{required:true,maxlength:20},
			"report.reportContent":{maxlength:500}
			},messages:{
				"report.reportType":
				{
				    required:"汇报类别为必填项！",
					maxlength:"汇报类别最多输入20个字符！"
				},
				"report.reportSubject":
				{
					required:"汇报题目为必填项！",
					maxlength:"汇报题目最多输入20个字符！"
				},
				"report.reportPerson":
				{
					required:"汇报人为必填项！",
					maxlength:"汇报人最多输入20个字符！"
				},
				"report.reportContent":
				{
					maxlength:"汇报内容最多输入500个字符！"
				}
				}
			};
	
	/**
	 * 准备工作
	 */
	$(document).ready(function() {
		$.fn.initpage();
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
		$.fn.exportReport();
		$.fn.close();
  	});

	/**
	 * 初始化页面
	 */
	$.fn.initpage = function(){
		var message = $("#lb_message").html();
		if(message!=null && $.trim(message)!="" ){
			alert(message);
		}
	}

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
			if ($.trim(reportId) == "") {
				repform.action = "toAddReportAction.action";
			} else {
				repform.action = "toModifyReportAction.action";
			}
			repform.submit();
		});
	}
	
	/**
	 * 导出
	 */
	$.fn.exportReport = function(){
		$("#exportBtn").click(function(){
			$("#repform").attr("action","toExportReportAction.action");
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
	<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
	<s:hidden id="hid_reportId" name="report.id"></s:hidden>
	<s:hidden id="hid_templateId" name="report.templateId"></s:hidden>
	<s:hidden id="hid_reportState" name="report.reportState"></s:hidden>
	<s:hidden id="hid_isDelete" name="report.isDelete"></s:hidden>
	<s:hidden id="hid_deptId" name="report.deptId"></s:hidden>
	<s:hidden id="hid_creatTime" name="report.creatTime"></s:hidden>
	<table width="100%" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td>
				<table width="100%" style="height: 100%;" border="0" cellspacing="6" cellpadding="0">
					<tr>
						<td style="height: 36px;">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>汇报类别：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_reportType" name="report.reportType" maxlength="25" cssStyle="width: 250px;"/><font color="red">*</font>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>汇报题目：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_reportSubject" name="report.reportSubject" maxlength="25" cssStyle="width: 250px;"/><font color="red">*</font>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>汇报人：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_reportPerson" name="report.reportPerson" maxlength="25" cssStyle="width: 250px;"/><font color="red">*</font>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>汇报时间：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_reportDate" name="report.reportDate" onClick="WdatePicker()" maxlength="25" cssClass="Wdate" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="147" align="right" bgcolor="#FFFFFF">
										<strong>汇报内容：</strong>
									</td>
									<td height="147" align="left" bgcolor="#FFFFFF">
										<s:textarea id="txt_reportContent" name="report.reportContent" maxlength="510" cssStyle="width:250px;height:100px; resize: none;" />
									</td>
								</tr>
								<tr>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										&nbsp;&nbsp;
										<input name="addBtn" type="button" value="确定" class="btn_2_3" id="addBtn" />
										<s:if test="report.id!=null && report.id!=''">
											&nbsp;&nbsp;
											<input name="exportBtn" type="button" value="导出" class="btn_2_3" id="exportBtn"/>
										</s:if>
										&nbsp;&nbsp;
										<input name="closeBtn" type="button" value="关闭" class="btn_2_3" id="closeBtn" />
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

