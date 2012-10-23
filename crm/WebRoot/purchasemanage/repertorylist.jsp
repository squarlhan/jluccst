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
		<title></title>

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
		/**
		 * 添加
		 */
		$("#addbtn").click(
				function() {
					window.location.href="showPurchaseRecordListAction.action?purchaseRecord.batchId=";
					return;
				});
		$.fn.checkall("cbk_all");
		$.fn.uncheckall("purchaseBatchIds", "cbk_all");

		/**
		 * 修改
		 */
		$('a[name="edit"]').each(function() {
				$(this).click( function() {
						var url = $(this).attr("url");
						window.location.href= url;
						return ;
					});
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
						<table width="100%" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#d5e4fd">
							<tr>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									序号
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>产品名称</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>库存量</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>应付总额</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>实付总额</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>欠款</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>总价值<font style="font-size:9pt;color:#888888">[单价x数量]</font></strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
											${(pagination.pageSize * (pagination.currentPage-1))+ obj.index+1}
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="productName" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="amount" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="accountPayable" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="actualPayment" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="amountInArrear" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="totalValue" />
									</td>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										<s:url id="edit_url" action="showPurchaseDetailAction">
											<s:param name="productId" value="productId"></s:param>
										</s:url>
										<a name="edit" href="javascript:void(0);" url="${edit_url}">查看详细记录</a>
									</td>
								</tr>
							</s:iterator>
							<tr>
								<td height="26" colspan="11" align="center" bgcolor="#FFFFFF">
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
