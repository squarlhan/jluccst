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
		<j:scriptlink css="true" jmessagebox="true" jquery="true"
			tipswindow="true" validate="true" />
		<script type="text/javascript">
	/**
	 * 验证条件
	 */
	var _customer_submit = {
		rules : {
			"company.companyName" : {
				required : true,
				strangecode : true
			},
			"company.address" : {
				strangecode : true
			},
			"company.phone" : {
				strangecode : true
			}
		}
	};
	/**
	 * 准备工作
	 */
	$(document).ready(function() {
		$.validator.setDefaults({
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
		$("#addBtn").click(function() {
			/*
			var validate_settings_submit = jQuery.extend({}, _customer_submit);
			var validator = $("form").validate(validate_settings_submit);
			if (!validator.form()) {
				return false;
			}
			if ($.trim($("#companyId").val()) != "") {
				form1.action = "toModifyCompanyAction.action";
			} else {
				form1.action = "toAddCompanyAction.action";
			}
			*/
			form1.action = "./failureDiagnosisAction!showFailureDiagnosisResult.action";
			//form1.target = "iframe1";
			form1.submit();
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
	$.fn.selectdevicetype = function(){
		form1.action = "./failureDiagnosisAction!showFailureDiagnosisInfo.action";
		form1.submit();
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
									<table width="100%" border="0" cellpadding="5" cellspacing="1"
										bgcolor="#d5e4fd">
										<tr>
											<td colspan="2" align="center" background="<%=path %>/images/headerbg.jpg">
												<strong>请选择故障诊断的条件</strong>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>设备类型：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:select list="deviceTypeList" listKey="id" listValue="typeName" name="deviceTypeId" id="deviceTypeId"
												value="deviceTypeId" headerKey="" headerValue="==请选择设备类型==" cssStyle="width:250px;" onchange="$.fn.selectdevicetype();"></s:select>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>设备名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<select style="width:250px;"></select>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>故障现象：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<select style="width:250px;"></select>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>振动方向：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield id="txt_companyName" name="company.companyName"
													cssStyle="width: 250px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												<input name="addBtn" type="button" class="btn_2_3"
													id="addBtn" value="看结果">
												&nbsp;&nbsp;
												<input name="closeBtn" type="button" class="btn_2_3"
													id="closeBtn" value="重置">
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
