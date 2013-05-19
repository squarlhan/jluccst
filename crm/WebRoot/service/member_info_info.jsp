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
			$("#memberType").val($("#selMemberType").val());
			form1.action = "savememberinfo.action";
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
		$("#txt_companyName").focus();
		//回显上传时的错误信息
		var message = $("#message").val();
		if (message != null && $.trim(message) != "") {
			alert(message);
		}
	};
</script>
</head>
<body>
	<form id="form1" name="form1" method="post">
		<s:hidden id="message" name="message" />
		<s:hidden id="infoId" name="infoId"></s:hidden>
		<s:hidden id="hdCompanyId" name="companyId"></s:hidden>
		<s:hidden id="hdCompanyName" name="companyName"></s:hidden>
		<s:hidden id="memberType" name="memberType"></s:hidden>
		<center>
			<table>
				<tr>
					<td><table>
							<tr>
								<td style="padding:10px;"><fieldset>
										<legend>
											<span>会员信息</span>
										</legend>
										<table>

											<tr>
												<td><table cellpadding="3" cellspacing="3">
														<tr>
															<td align="center" nowrap="nowrap">客户名称</td>
															<td><s:textfield id="txt_companyName"
																	name="memberInfo.companyName" cssStyle="width:150px;" readonly="true" /></td>
															<td align="center" nowrap="nowrap">会员类别</td>
															<td align="left">
																<s:select list="listSource" listKey="name"
																	listValue="name" value="memberInfo.memberType"
																	id="selMemberType" name="memberInfo.memberType"
																	cssStyle="width:150px" headerKey=""
																	headerValue="--请选择会员类别--"></s:select>
															</td>
															<td align="center" nowrap="nowrap">业务员 </td>
															<td align="left"><s:textfield id="txt_salespeople"
																	name="memberInfo.salespeople" cssStyle="width:150px;" readonly="true"/>
															</td>
														</tr>
														<tr>
															<td align="center" nowrap="nowrap">成为时间</td>
															<td align="left"><s:textfield id="txt_createTime"
																	name="memberInfo.createTime" cssStyle="width:150px;" readonly="true"/>
															</td>
															<td align="center" nowrap="nowrap">消费总额</td>
															<td align="left"><s:textfield id="txt_consumptionAmount"
																	name="memberInfo.consumptionAmount" cssStyle="width:150px;" readonly="true"/>
															</td>
															<td align="center" nowrap="nowrap">总积分</td>
															<td align="left"><s:textfield id="txt_totalPoint"
																	name="memberInfo.totalPoint" cssStyle="width:150px;" readonly="true"/></td>
														</tr>
														<tr>
															<td align="center" nowrap="nowrap">备注</td>
															<td colspan="5" align="left"><s:textarea id="txtRemark"
																	name="memberInfo.remark" cssStyle="width:648px; height:120px"/>
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
