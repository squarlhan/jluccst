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
		 * 修改
		 */
		$('a[name="edit"]').each(function() {$(this).click(
				function() {
					var url = $(this).attr("url");
					parent.parent.tipsWindown("查看反馈", "iframe:"+ url, "600","800", "true", "","true", "no");
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
			var url = "./suggestionAction!deleteItems.action";
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
			<table width="100%" style="height: 100%;" border="0" cellspacing="5"
				cellpadding="0">
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="5" cellpadding="0">
							<tr>
								<td align="left">
									<input name="deletepointbtn" type="button" class="btn_4"
										id="deletepointbtn" value="删除所选">
										<!-- 
									<input name="closewin" type="button" class="btn_2_3"
										id="closewin" value="关闭" onclick="parent.$('#windown-close').click();">
										 -->
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
									<strong>功能分类</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>意见内容</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>所在单位</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>所在部门</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>提出人</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>意见时间</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>是否反馈</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{id}" name="suggestionIds" fieldValue="%{id}" value="false" theme="simple" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="menuName" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="content" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="unitName" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="organName" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="userName" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="createTime" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="replyStatusCn" />
									</td>
									<td height="26"  align="center" bgcolor="#FFFFFF">
										<s:url id="edit_url" action="suggestionAction!showSuggestionAndReply.action">
											<s:param name="suggestionId" value="id"></s:param>
										</s:url>
										<s:url id="delete_url" action="suggestionAction!deleteItem.action">
											<s:param name="suggestionId" value="id"></s:param>
										</s:url>
										<a name="edit" href="javascript:void(0);" url="${edit_url}">查看详情</a>
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
