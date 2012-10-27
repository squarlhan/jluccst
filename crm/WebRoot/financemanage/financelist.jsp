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
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true" />
		<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/timepicke/jquery-ui-1.7.3.custom.css" />
		<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/timepicke/jquery-ui-timepicker-addon.css" />
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-timepicker-addon.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-sliderAccess.js"></script>
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
		$.fn.checkall("cbk_all");
		$.fn.uncheckall("financeIds", "cbk_all");
		$.fn.initpage();
		/**
		 * 查询并添加记录
		 */
		$("#addbtn").click(
			function() {
				if( $("#beginDate").val() == "" || $("#endDate").val() == "" ){
					alert("请输入完成的起始日期！");
					return false;
				}
				if( $("#beginDate").val()  > $("#endDate").val()  ){
					alert("结束日期要在开始日期之后！");
					return false;
				}
				form1.action ="./saveFinanceAction.action";
				form1.submit();
			}
		);
		/**
		 * 删除单个角色信息
		 */
		$('a[name="delete"]').each(function() {
			$(this).click(function() {
				if (window.confirm("您确定要删除这条信息吗？")) {
					var url = $(this).attr("url");
					$.post(url, "", function(data) {
						window.location.href = "./showFinanceListAction.action"
					});
				}
			});
		});

		/**
		 * 删除所选角色信息
		 */
		$("#deletepointbtn").click(function() {
			if (window.confirm("您确定要删除所选信息吗？")) {
				var url = "deleteFinanceAction.action";
				$.post(url, $('#form1').serialize(), function(data) {
					window.location.href = "./showFinanceListAction.action"
				});
			}
		});
	});
	/**
	 * 初始化页面
	 */
	$.fn.initpage = function(){
		$('#beginDate').datetimepicker({showTimepicker: false});
		$('#endDate').datetimepicker({showTimepicker: false});
	}
</script>

	</head>


	<body>
		<s:form id="form1" name="form1" method="post" theme="simple" action="./showFinanceListAction.action">
			<table width="100%" style="height: 100%;" border="0" cellspacing="5"
				cellpadding="0">
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="5" cellpadding="0">
							<tr>
								<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap" width="80px">
									<strong>起始日期：</strong>
								</td>
								<td>
									<input type="text" name="beginDate"  id="beginDate" style="width:100px" readonly="true" value="<s:property value="beginDate" />"/>
									- <input type="text" name="endDate"  id="endDate" style="width:100px" readonly="true" value="<s:property value="endDate" />"/>
									&nbsp;
									<input name="addbtn" type="button" class="btn_2_3" id="addbtn" value="生成清单">
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
									<strong>日期</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>销售总额</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>应收款总额</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>实际收入</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>欠款</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>进货总额</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>应付款总额</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>实际支出</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>库存总额</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>总利润</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{#obj.id}" name="financeIds" fieldValue="%{id}"
											value="false" theme="simple" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="beginDate" />~<s:property value="endDate" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="totalSellAmount" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="totalAccountDue" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="totalActualReceipt" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="totalAmountInArrear" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="totalAmountPurchase" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="totalAmountDue" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="totalActualOutlay" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="totalInventory" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="totalProfit" />
									</td>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										<s:url id="delete_url" action="deleteFinanceAction.action">
											<s:param name="financeIds" value="id"></s:param>
										</s:url>
										<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>
									</td>
								</tr>
							</s:iterator>
							<tr>
								<td height="26" colspan="13" align="center" bgcolor="#FFFFFF">
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
