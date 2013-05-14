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
		<title></title>

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
		$(document).ready(function(){
	  		$.validator.setDefaults({
				debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
			    errorPlacement:function(error, element) {},
				invalidHandler: function(form, validator) {
		        	$.each(validator.invalid,function(key,value){
		            	alert(value);document.getElementById(key).focus();return false;
		        	}); 
		    	}
			})
	  		$.fn.goback();
	  	});
	/**
	 * 返回
	 */
 	$.fn.goback = function(){
	 	$("#btnreturn").click(function() {
			window.location.href="./showRepertoryListAction.action";
		});
	}
</script>

	</head>


	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
			<s:hidden name="companyId" id="companyId"></s:hidden>
			<s:hidden name="purchaseBatch.id" id="batchId"></s:hidden>
			<table width="100%" style="height: 100%;" border="0" cellspacing="5"
				cellpadding="0">
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="5" cellpadding="0">
							<tr>
								<td>
									<input name="btnreturn" type="button" class="btn_2_3" id="btnreturn" value="返回">
									</td>
							</tr>
						</table>
						<table width="100%" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#d5e4fd">
							<tr>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									序号
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>供应商名称</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>供应商编号</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>产品名称</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>规格</strong>
								</td>
								<!-- 
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>克重</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>吨</strong>
								</td>
								 -->
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>数量</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>单价</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>运费</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>应付款</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>实付款</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>欠款</strong>
								</td>
							</tr>
							<s:iterator value="paginationRecord.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										${(paginationRecord.pageSize * (paginationRecord.currentPage-1))+ obj.index+1}
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="supplierName" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="supplierNumber" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="productName" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="specification" />
									</td>
									<!-- 
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="gramWeight" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="ton" />
									</td>
									 -->
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="amount" />
									</td>
										<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="unitPrice" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="freight" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="accountPayable" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="actualPayment" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="amountInArrear" />
									</td>
								</tr>
							</s:iterator>
							<tr>
								<td height="26" colspan="13" align="center" bgcolor="#FFFFFF">
									<page:pages currentPage="paginationRecord.currentPage"
										totalPages="paginationRecord.totalPages"
										totalRows="paginationRecord.totalRows" styleClass="page"
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
