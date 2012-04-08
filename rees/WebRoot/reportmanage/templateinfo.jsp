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

		<title>人报表模板维护</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true" jfunction="true"/>
	 	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
	/**
	 * 验证条件
	 */
	var _template_submit = {
		rules : {
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
		$.fn.close();
		$.fn.downloadTemplate();
  	});

	/**
	 * 初始化页面
	 */
	$.fn.initpage = function(){
		$("#txt_reportType").focus();
		//回显上传时的错误信息
		var uploadErr = $("#lb_error").html();
		if(uploadErr!=null && $.trim(uploadErr)!="" ){
			alert(uploadErr);
		}
		
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
		var templateId = $("#hid_templateId").val();
		$("#addBtn").click(function() {
			try{
			var validate_settings_submit = jQuery.extend({}, _template_submit);
			var validator = $("form").validate(validate_settings_submit);
			if (!validator.form()) {
				return false;
			}
			repform.submit();
			}catch(e){
				alert(e.description);
			}
		});
	}
	
	/**
	 * 删除模板文件 
	 */
	$.fn.delTemplate = function(id){
		if(window.confirm("您确定要删除模板吗？")){
			$.post("toDeleteTemplateReportTempleFileAction.action", {"template.id":id}, function(data){});
			$("#hid_templatePath").val("");
			var row = $("#table1 tr:last").prev();
			row.find("strong").replaceWith("<strong>添加模板文件：</strong>");
			row.find("a:first").remove();
			row.find("a:first").replaceWith('<input type="file" name="files" value="" id="form1_files" style="width: 250px;"/>');
		}
	}

	/**
	 * 下载模板文件 
	 */
	$.fn.downloadTemplate = function(){
		$("#download").click(function(){
			var oldAction = repform.action;
			repform.action = "toDownloadTempleFileAction.action";
			repform.submit();
			repform.action = oldAction;
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
	<center>
	<s:form id="repform" theme="simple" action="toAddTemplateAction"  enctype="multipart/form-data">
	<s:hidden id="hid_templateId" name="template.id"></s:hidden>
	<s:hidden id="hid_templatePath" name="template.templatePath"></s:hidden>
	<s:hidden id="hid_templateName" name="template.templateName"></s:hidden>
	<s:hidden id="hid_createTime" name="template.createTime"></s:hidden>
	<table width="100%" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td>
				<table width="100%" style="height: 100%;" border="0" cellspacing="6" cellpadding="0">
					<tr>
						<td style="height: 36px;">
							<table id="table1" width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
								<tr>
									<td height="26" align="center" bgcolor="#d5e4fd" colspan="2">
										<strong>人报表模板管理</strong>
									</td>
								</tr>
								<tr>
									<td height="26" width="40%" align="right" bgcolor="#FFFFFF">
										<strong>汇报类别：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_reportType" name="template.reportType" maxlength="25" cssStyle="width: 250px;"/><font color="red">*</font>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>汇报题目：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_reportSubject" name="template.reportSubject" maxlength="25" cssStyle="width: 250px;"/><font color="red">*</font>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>汇报人：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_reportPerson" name="template.reportPerson" maxlength="25" cssStyle="width: 250px;"/><font color="red">*</font>
									</td>
								</tr>
								<tr>
									<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>汇报时间：</strong>
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:textfield id="txt_reportDate" name="template.reportDate" onClick="WdatePicker()" maxlength="25" cssClass="Wdate" cssStyle="width: 250px;"/>
									</td>
								</tr>
								<tr>
									<td height="147" align="right" bgcolor="#FFFFFF">
										<strong>汇报内容：</strong>
									</td>
									<td height="147" align="left" bgcolor="#FFFFFF">
										<s:textarea id="txt_reportContent" name="template.reportContent" maxlength="510" cssStyle="width:250px;height:100px; resize: none;" />
									</td>
								</tr>
								<s:if test='template.templatePath!=null && template.templatePath!=""'>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
										<strong>添加模板文件：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<a id="download" href="javascript:void(0);"><img src="<%=basePath%>/images/Files-Word.png" style="height:32px;width:32px;cursor:pointer" title="查看"></img></a>
											<a id="delTemplate" href="javascript:void(0);" onclick="$.fn.delTemplate('${template.id}')"><img src="<%=basePath%>/images/cross.png" style="height:32px;width:32px;cursor:pointer" title="删除"></img></a>
										</td>
									</tr>	
									</s:if>
									<s:else>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>添加模板文件：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:file name="files" cssStyle="width: 250px;"></s:file>
										</td>
									</tr>
									</s:else>
								<tr>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										&nbsp;&nbsp;
										<input name="addBtn" type="button" value="保存" class="btn_2_3" id="addBtn" />
										&nbsp;&nbsp;
										<input name="closeBtn" type="reset"" value="重置" class="btn_2_3" id="closeBtn" />
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
	</center>
</body>
</html>

