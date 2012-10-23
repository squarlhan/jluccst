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
	<link rel="stylesheet" media="all" type="text/css" href="http://127.0.0.1:8080/boan-crm/js/timepicke/jquery-ui-1.7.3.custom.css" />
	<link rel="stylesheet" media="all" type="text/css" href="http://127.0.0.1:8080/boan-crm/js/timepicke/jquery-ui-timepicker-addon.css" />
	<script type="text/javascript" src="http://127.0.0.1:8080/boan-crm/js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
	<script type="text/javascript" src="http://127.0.0.1:8080/boan-crm/js/timepicke/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="http://127.0.0.1:8080/boan-crm/js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript" src="http://127.0.0.1:8080/boan-crm/js/timepicke/jquery-ui-sliderAccess.js"></script>
		<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>
		<script type="text/javascript">
		var _customer_submit = {
				rules: {
					"purchaseBatch.supplierId":{required:true,strangecode:true},
					"purchaseBatch.transactionDate":{required:true}
					}
				};
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
			$.fn.save();
	  		$.fn.close();
	  		$.fn.initpage();
		/**
		 * 添加
		 */
		$("#addbtn").click(
			function() {
				var myBatchId = $("#batchId").val();
				parent.parent.tipsWindown("添加采购记录","iframe:showPurchaseRecordInfoAction.action?purchaseRecord.batchId="+ myBatchId +"&purchaseRecord.id=" , "460", "480", "true", "", "true", "no");
				parent.parent.$("#windown-close").bind('click', function() {
					window.location.href = "./showPurchaseRecordListAction.action?purchaseRecord.batchId="+myBatchId;
				});

			});
		$.fn.checkall("cbk_all");
		$.fn.uncheckall("purchaseRecordIds", "cbk_all");

		/**
		 * 修改
		 */
		$('a[name="edit"]').each(function() {
				$(this).click( function() {
						var myBatchId = $("#batchId").val();
						var url = $(this).attr("url");
						parent.parent.tipsWindown( "修改采购记录", "iframe:" + url, "460","480", "true", "","true", "no");
						parent.parent.$("#windown-close").bind('click',function() {
							window.location.href = "./showPurchaseRecordListAction.action?purchaseRecord.batchId="+myBatchId;
							});
					});
			});

		/**
		 * 删除单个角色信息
		 */
		$('a[name="delete"]').each(function() {
			$(this).click(function() {
				if (window.confirm("您确定要删除这条信息吗？")) {
					var myBatchId = $("#batchId").val();
					var url = $(this).attr("url");
					$.post(url, "", function(data) {
						window.location.href = "showPurchaseRecordListAction.action?purchaseRecord.batchId="+myBatchId ;
					});
				}
			});
		});

		/**
		 * 删除所选角色信息
		 */
		$("#deletepointbtn").click(function() {
			if (window.confirm("您确定要删除所选信息吗？")) {
				var url = "deletePurchaseRecordAction.action";
				var myBatchId = $("#batchId").val();
				$.post(url, $('#form1').serialize(), function(data) {
					window.location.href = "showPurchaseRecordListAction.action?purchaseRecord.batchId="+myBatchId ;
				});
			}
		});
	  	});
	/**
  	 * 保存
  	 */
	$.fn.save = function(){
		$("#button1").click(function() {
			var validate_settings_submit = jQuery.extend({}, _customer_submit);
           	var validator = $("form").validate(validate_settings_submit);
           	if(!validator.form()){
				return false;
			}
           	form1.action = "./savePurchaseBatchAction.action";
           	form1.submit();
       	});
  	}
	/**
	 * 关闭
	 */
 	$.fn.close = function(){
	 	$("#button2").click(function() {
			window.location.href="./showPurchaseBatchListAction.action";
		});
	}
	/**
	 * 初始化页面
	 */
	$.fn.initpage = function(){
		$("#prductName").focus();
		if( $("#batchId").val() != "" ){
			$("#addbtn").attr("disabled", false);
			$("#deletepointbtn").attr("disabled", false);
		}else{
			$("#addbtn").attr("disabled", true);
			$("#deletepointbtn").attr("disabled", true);
		}
		<s:if test="message.content != null">
		alert('${message.content}');
		</s:if>
		$('#transactionDate').datetimepicker({showTimepicker: false});
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
						<table width="100%" border="0" cellpadding="5" cellspacing="1"
										bgcolor="#d5e4fd">

										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>供应商名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:select list="supplierList"  id="supplierId"  name="purchaseBatch.supplierId"  headerKey=""  headerValue="==请选择供应商=="  listKey="id"  listValue="supplierName"  cssStyle="width: 200px;" >
												</s:select>
												<font color="red">*</font>
											</td>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>成交日期：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseBatch.transactionDate"  id="transactionDate"  cssStyle="width: 200px;" maxlength="25" readonly="true"></s:textfield>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>供应商编号：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseBatch.supplierNumber" id="supplierNumber" cssStyle="width: 200px;" maxlength="25" readonly="true"></s:textfield>
												<font style="font-size:9pt">(自动获取)</font>
											</td>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												<input type="checkbox" name="isArrive" id="isArrive" value="1"
													<s:if test="purchaseBatch.isArrive==1">
														checked="checked"
													</s:if>>已到货
												<input type="checkbox" name="isSettleAccount" id="isSettleAccount" value="1"
													<s:if test="purchaseBatch.isSettleAccount==1">
														checked="checked"
													</s:if>>已结账
												<input name="button1" type="button" class="btn_2_3"
													id="button1" value="确定">
												<input name="addbtn" type="button" class="btn_2_3" id="addbtn" value="添加记录">
												<input name="deletepointbtn" type="button" class="btn_4" id="deletepointbtn" value="删除记录">
												<input name="button2" type="button" class="btn_2_3" id="button2" value="返回">
											</td>
										</tr>
									</table>
						<table width="100%" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#d5e4fd">
							<tr>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>产品名称</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>规格</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>克重</strong>
								</td>
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>吨</strong>
								</td>
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
								<td align="center" background="<%=path %>/images/headerbg.jpg">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="paginationRecord.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{#obj.id}" name="purchaseRecordIds" fieldValue="%{id}"
											value="false" theme="simple" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="productName" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="specification" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="gramWeight" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="ton" />
									</td>
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
									<td height="26"  align="center" bgcolor="#FFFFFF">
										<s:url id="edit_url" action="showPurchaseRecordInfoAction">
											<s:param name="purchaseRecord.id" value="id"></s:param>
											<s:param name="purchaseRecord.batchId" value="batchId"></s:param>
										</s:url>
										<s:url id="delete_url" action="deletePurchaseRecordAction">
											<s:param name="purchaseRecordIds" value="id"></s:param>
										</s:url>
										<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>
										<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>
									</td>
								</tr>
							</s:iterator>
							<tr>
								<td height="26" colspan="12" align="center" bgcolor="#FFFFFF">
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
