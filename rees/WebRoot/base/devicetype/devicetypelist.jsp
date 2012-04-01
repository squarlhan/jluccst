<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/WEB-INF/page-tags.tld"%>

<%
	/**
	 * All right reserved.
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 */
	/**
	 * @author Jiangmeidi
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
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>设备类型列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" />

		<script type="text/javascript">
		$(function(){
			/**
			 * 添加设备类型
			 */
			$("#addbtn").click(function(){
				parent.parent.parent.tipsWindown("添加设备类型","iframe:openAddDeviceTypeAction.action","400","200","true","","true","no");
			});
			
			/**
			 * 修改设备类型
			 */
			$('a[name="edit"]').each(function(){
				$(this).click(function(){
					var url = $(this).attr("url");
					parent.parent.parent.tipsWindown("修改设备类型","iframe:"+url,"400","200","true","","true","no");
				});
			});
			
			/**
			 * 删除单个设备类型
			 */
			$('a[name="delete"]').each(function(){
				$(this).click(function(){
					var url = $(this).attr("url");
					if(window.confirm("您确定要删除这条信息吗？")){
						$.post(url, $('').serialize(), function(data){window.location.href=window.location.href;});
					}
				});
			});
			
			/**
			 * 删除所选设备类型
			 */
			$("#deletepointbtn").click(function(){
				var url = "deleteDeviceTypeAction.action";
				if(window.confirm("您确定要删除所选信息吗？")){
					$.post(url, $('#dtplist').serialize(), function(data){window.location.href=window.location.href;});
				}
			});
	  		$.fn.checkall("cbk_all");
			$.fn.uncheckall("ids","cbk_all");
	  	});
		</script>
	</head>
	<body>
		<s:form action="openDeviceTypeAction" id="dtplist" method="post" theme="simple">
			<table width="100%" style="height: 100%;" border="0" cellspacing="5" cellpadding="0">
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="5" cellpadding="0">
							<tr>
								<td>
									<input name="addbtn" type="button" class="btn_4" id="addbtn" value="添加">
									<input name="deletepointbtn" type="button" class="btn_4" id="deletepointbtn" value="删除所选">
								</td>
							</tr>
						</table>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
							<tr>
								<td width="8%" height="26" align="center" background="../images/headerbg.jpg">
									<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
								</td>
								<td width="22%" align="center" background="../images/headerbg.jpg">
									<strong>名称</strong>
								</td>
								<td width="15%" align="center" background="../images/headerbg.jpg">
									<strong>转速</strong>
								</td>
								<td width="15%" align="center" background="../images/headerbg.jpg">
									<strong>功率</strong>
								</td>
								<td width="15%" align="center" background="../images/headerbg.jpg">
									<strong>中心高</strong>
								</td>
								<td width="15%" align="center" background="../images/headerbg.jpg">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="typeName" />
										&nbsp;
									</td>
									
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="speed" />
										&nbsp;
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="power" />
										&nbsp;
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="centerHeight" />
										&nbsp;
									</td>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										<s:url id="edit_url" action="openModifyDeviceTypeAction">
											<s:param name="deviceType.id" value="id"></s:param>
										</s:url>
										<s:url id="delete_url" action="deleteDeviceTypeAction">
											<s:param name="ids" value="id"></s:param>
										</s:url>
										<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>
										<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>
									</td>
								</tr>
							</s:iterator>
							<tr>
								<td height="26" colspan="9" align="center" bgcolor="#FFFFFF">
									<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text">
									</page:pages>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
