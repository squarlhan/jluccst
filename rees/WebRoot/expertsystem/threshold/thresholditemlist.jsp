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
		<title>阈值项列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true" jfunction="true"/>
		<script type="text/javascript">
		$(function(){
			/**
			 * 添加阈值项
			 */
			$("#addbtn").click(function(){
				parent.parent.tipsWindown("添加阈值项","iframe:openAddThresholdItemAction.action","480","250","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
			});
			
			/**
			 * 修改阈值项
			 */
			$('a[name="edit"]').each(function(){
				$(this).click(function(){
					var url = $(this).attr("url");
					parent.parent.tipsWindown("修改阈值项","iframe:"+url,"480","250","true","","true","no");
					parent.parent.$("#windown-close").bind('click',function(){
						window.location.href=window.location.href;
					});
				});
			});
			
			/**
			 * 删除单个阈值项
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
			 * 删除所选阈值项
			 */
			$("#deletepointbtn").click(function(){
				var url = "deleteThresholdItemAction.action";
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
		<s:form action="openThresholdItemAction" id="dtplist" method="post" theme="simple">
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
								<td width="5%" height="26" align="center" background="<%=path %>/images/headerbg.jpg">
									<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>阈值项名称</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>所属阈值</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>阈值项区间</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>数据类型</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>是否报警</strong>
								</td>
								<td width="15%" align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="thresholdItemName" />
										&nbsp;
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="threshold.thresholdName" />
										&nbsp;
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="thresholdItemExpression" />
										&nbsp;
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:if test='dataType=="S"' >速度</s:if>
										<s:if test='dataType=="D"' >位移</s:if>
										<s:if test='dataType=="A"'  >加速度</s:if>
										&nbsp;
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:if test="sign==1">
											是
										</s:if>
										<s:else>
											否
										</s:else>
										&nbsp;
									</td>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										<s:url id="edit_url" action="openModifyThresholdItemAction">
											<s:param name="thresholdItem.id" value="id"></s:param>
										</s:url>
										<s:url id="delete_url" action="deleteThresholdItemAction">
											<s:param name="ids" value="id"></s:param>
										</s:url>
										<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>
										<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>
									</td>
								</tr>
							</s:iterator>
							<tr>
								<td height="26" colspan="9" align="center" bgcolor="#FFFFFF">
									<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text"></page:pages>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
