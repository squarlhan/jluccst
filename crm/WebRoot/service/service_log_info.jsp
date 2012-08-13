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
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	/**
	 * 准备工作
	 */
	$(document).ready(function() {
		$.fn.save();
		$.fn.close();
		$.fn.initpage();
	});
	/**
	 * 保存
	 */
	$.fn.save = function() {
		//如果有id就说明是修改action
		$("#saveBtn").click(function() {
			form1.companyId.value = $("#selCompany").val();
			form1.companyName.value = $("#selCompany").find("option:selected").text();
			form1.action = "saveservicelog.action";
			form1.submit();
		});
	};

	/**
	 * 关闭
	 */
	$.fn.close = function() {
		$("#closeBtn").click(function() {
			var message = $("#lb_message").html();
			if (message != null && $.trim(message) != "") {
			}
			parent.$("#windown-close").click();
		});
	};
	/**
	 * 初始化页面
	 */
	$.fn.initpage = function() {
		$("#txt_contact").focus();
		//回显上传时的错误信息
		var uploadErr = $("#lb_error").html();
		if (uploadErr != null && $.trim(uploadErr) != "") {
			alert(uploadErr);
		}

		var message = $("#lb_message").html();
		if (message != null && $.trim(message) != "") {
			alert(message);
		}
	};
</script>
</head>
<body>
	<form id="form1" name="form1" method="post">
		<label id="lb_message" style="display:none"></label>
		<s:hidden id="logId" name="serviceLog.id"></s:hidden>
		<s:hidden id="hdCompanyId" name="companyId"></s:hidden>
		<s:hidden id="hdCompanyName" name="companyName"></s:hidden>
		<center>
			<table>
				<tr>
					<td><table>
							<tr>
								<td style="padding:10px;"><fieldset>
										<legend>
											<span>服务记录编辑</span>
										</legend>
										<table>

											<tr>
												<td><table cellpadding="3" cellspacing="3">
														<tr>
															<td align="center" nowrap="nowrap">客户名称</td>
															<td>
															<select id="selCompany" name="name" style="width:150px">
																	<option value="cbit">长白信息科技</option>
																	<option value="easy">易得信息科技</option>
															</select></td>
															<td align="center" nowrap="nowrap">联系人</td>
															<td align="left"><s:textfield id="txt_contact"
																	name="serviceLog.contact" cssStyle="width:150px;" /></td>
															<td align="center" nowrap="nowrap">联系人手机</td>
															<td align="left"><s:textfield id="txt_mobilePhone"
																	name="serviceLog.mobilePhone" cssStyle="width:150px;" />
															</td>
														</tr>
														<tr>
															<td align="center" nowrap="nowrap">服务日期</td>
															<td align="left"><s:textfield id="txt_serviceTime"
																	name="serviceLog.serviceTime" cssStyle="width:150px;" readonly="true" onClick="WdatePicker()"/>
															</td>
															<td align="center" nowrap="nowrap">到达时间</td>
															<td align="left"><s:textfield id="txt_arriveTime"
																	name="serviceLog.arriveTime" cssStyle="width:150px;" readonly="true" onClick="WdatePicker()"/>
															</td>
															<td align="center" nowrap="nowrap">完成时间</td>
															<td align="left"><s:textfield id="txt_finishTime"
																	name="serviceLog.finishTime" cssStyle="width:150px;" readonly="true" onClick="WdatePicker()"/></td>
														</tr>
														<tr>
															<td align="center" nowrap="nowrap">品牌型号</td>
															<td align="left"><s:textfield id="txt_brandModel"
																	name="serviceLog.brandModel" cssStyle="width:150px;" /></td>
															<td align="center" nowrap="nowrap">维修员</td>
															<td align="left" colspan="3"><s:textfield id="txt_repairman"
																	name="serviceLog.repairman" cssStyle="width:150px;" /></td>
														</tr>
														<tr>
															<td align="center" nowrap="nowrap">故障情况</td>
															<td colspan="5" align="left"><s:textarea id="txt_malfunction"
																	name="serviceLog.malfunction" cssStyle="width:648px; height:60px"/>
															</td>
														</tr>
														<tr>
															<td align="center" nowrap="nowrap">解决措施</td>
															<td colspan="5" align="left"><s:textarea id="txt_solutions"
																	name="serviceLog.solutions" cssStyle="width:648px; height:60px"/>
															</td>
														</tr>
													</table></td>
											</tr>
										</table>
									</fieldset></td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td align="center"><span style="width: 680px"> <input
							type="button" id="saveBtn" value="保存" class="btn_2_3" /> <input type="button"
							id="closeBtn" value="关闭" class="btn_2_3" /> </span>
					</td>
				</tr>
			</table>
			<s:if test="hasFieldErrors()">
				<s:iterator value="fieldErrors">
					<s:label id="lb_error" name="value[0]" cssStyle="display:none"></s:label>
				</s:iterator>
			</s:if>
		</center>
	</form>
</body>
</html>
