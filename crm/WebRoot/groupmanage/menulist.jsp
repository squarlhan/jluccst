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
		<title>角色管理列表</title>

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
					parent.parent.tipsWindown("添加菜单信息","iframe:menuAction!showMenuInfo.action?menu.id=&productId=<s:property value="productId"/>&parentKey=<s:property value="parentKey"/>", "460", "210", "true", "", "true", "no");
					parent.parent.$("#windown-close").bind('click', function() {
						window.location.href = "./menuAction!showMenuList.action?productId=<s:property value="productId"/>&parentKey=<s:property value="parentKey"/>";
					});
		});
		$.fn.checkall("cbk_all");
		$.fn.uncheckall("menuIds", "cbk_all");
		$("#sortbtn").click(
				function() {
					parent.parent.tipsWindown("菜单排序","iframe:menuAction!showSortMenuList.action?productId=<s:property value="productId"/>&parentKey=<s:property value="parentKey"/>", "370", "320", "true", "", "true", "no");
					parent.parent.$("#windown-close").bind('click', function() {
						window.location.href = "./menuAction!showMenuList.action?productId=<s:property value="productId"/>&parentKey=<s:property value="parentKey"/>";
					});
		});
		/**
		 * 修改角色信息
		 */
		$('a[name="edit"]').each(function() {$(this).click(function() {
					var url = $(this).attr("url");
					parent.parent.tipsWindown("修改菜单信息", "iframe:"+ url, "460", "210", "true", "", "true", "no");
					parent.parent.$("#windown-close").bind('click',function() {
							window.location.href = "./menuAction!showMenuList.action?productId=<s:property value="productId"/>&parentKey=<s:property value="parentKey"/>";
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
			var url = "menuAction!deleteMenu.action";
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
			<s:hidden name="parentKey" id="parentKey"></s:hidden>
			<s:hidden name="productId" id="productId"></s:hidden>
			<table width="100%" style="height: 100%;" border="0" cellspacing="5"
				cellpadding="0">
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="5" cellpadding="0">
							<tr>
								<td>
									<input name="addbtn" type="button" class="btn_2_3" id="addbtn"
										value="添加">
									<input name="sortbtn" type="button" class="btn_2_3" id="sortbtn"
										value="排序">
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
									<strong>菜单名称</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>关键字</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>权限类型</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>链接地址</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="menuList" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{#obj.id}" name="menuIds" fieldValue="%{id}"
											value="false" theme="simple" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="menuName" />
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:property value="menuKey" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="popedomTypeCn" />
									</td>
									<td height="26" align="left" bgcolor="#FFFFFF">
										<s:property value="url" />
									</td>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										<s:url id="edit_url" action="menuAction!showMenuInfo.action">
											<s:param name="menu.id" value="id"></s:param>
										</s:url>
										<s:url id="delete_url" action="menuAction!deleteMenu.action">
											<s:param name="menuIds" value="id"></s:param>
										</s:url>
										<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>
										<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>
									</td>
								</tr>
							</s:iterator>
							<tr>
								<td height="26" colspan="9" align="center" bgcolor="#FFFFFF">
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
