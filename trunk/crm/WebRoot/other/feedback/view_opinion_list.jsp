<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/page-tags"%>
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
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>意见反馈列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true"
			jquery="true" validate="true" jfunction="true" />
		<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>
		<script type="text/javascript">
	$(function() {
		$("#addbtn").click(
				function() {
					parent.parent.tipsWindown("添加职务信息","iframe:openAddRoleAction.action?companyId=<s:property value="companyId"/>", "460", "150", "true", "", "true", "no");
					parent.parent.$("#windown-close").bind('click', function() {
						window.location.href = "./openRoleAction.action?companyId=<s:property value="companyId"/>";
					});

				});
		$.fn.checkall("cbk_all");
		$.fn.uncheckall("ids", "cbk_all");

		/**
		 * 修改角色信息
		 */
		$('a[name="edit"]')
				.each(
						function() {
							$(this)
									.click(
											function() {
												var url = $(this).attr("url");
												parent.parent.tipsWindown(
														"修改职务信息", "iframe:"
																+ url, "460",
														"150", "true", "",
														"true", "no");
												parent.parent
														.$("#windown-close")
														.bind(
																'click',
																function() {
																	window.location.href = "./openRoleAction.action?companyId=<s:property value="companyId"/>";
																});
											});
						});

		/**
		 * 删除单个角色信息
		 */
		$('a[name="delete"]').each(function() {
			$(this).click(function() {
				var url = $(this).attr("url");
				if (window.confirm("您确定要删除这条信息吗？")) {
					$.post(url, "", function(data) {
						window.location.href = window.location.href;
					});
				}
			});
		});

		/**
		 * 删除所选角色信息
		 */
		$("#deletepointbtn").click(function() {
			var url = "deleteRoleAction.action";
			if (window.confirm("您确定要删除所选信息吗？")) {
				$.post(url, $('#form1').serialize(), function(data) {
					window.location.href = window.location.href;
				});
			}
		});
	});
</script>
	</head>
	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
			<s:hidden name="companyId" id="companyId"></s:hidden>
			<table width="100%" style="height: 100%;" border="0" cellspacing="5"
				cellpadding="0">
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="5" cellpadding="0">
							<tr>
								<td>
									<input name="deletepointbtn" type="button" class="btn_4"
										id="deletepointbtn" value="删除所选">
								<td align="right"></td>
							</tr>
						</table>
						<table width="100%" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#d5e4fd">
							<tr>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>职务名称</strong>
								</td>
									<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>职务标识</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}"
											value="false" theme="simple" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="roleName" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="roleKeyCn" />
									</td>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										<s:url id="edit_url" action="openModifyRoleAction">
											<s:param name="role.id" value="id"></s:param>
											<s:param name="role.companyId" value="companyId"></s:param>
										</s:url>
										<s:url id="delete_url" action="deleteRoleAction">
											<s:param name="ids" value="id"></s:param>
										</s:url>
										<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>
										<a name="delete" href="javascript:void(0);"
											url="${delete_url}">删除</a>
									</td>
								</tr>
							</s:iterator>
							<tr>
								<td height="26" colspan="9" align="center" bgcolor="#FFFFFF">
									<page:pages currentPage="pagination.currentPage"
										totalPages="pagination.totalPages"
										totalRows="pagination.totalRows" styleClass="page"
										theme="text"></page:pages>

								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
