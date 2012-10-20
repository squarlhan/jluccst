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
				parent.parent.tipsWindown("添加采购记录","iframe:showPurchaseRecordInfoAction.action?companyId=<s:property value="companyId"/>&purchaseRecord.id=", "460", "450", "true", "", "true", "no");
				parent.parent.$("#windown-close").bind('click', function() {
					window.location.href = "./showPurchaseBatchInfoAction.action?companyId=<s:property value="companyId"/>";
				});

			});
		$.fn.checkall("cbk_all");
		$.fn.uncheckall("purchaseBatchIds", "cbk_all");

		/**
		 * 修改
		 */
		$('a[name="edit"]').each(function() {
				$(this).click( function() {
						var url = $(this).attr("url");
						parent.parent.tipsWindown( "修改采购批次", "iframe:" + url, "460","350", "true", "","true", "no");
						parent.parent.$("#windown-close").bind('click',function() {
								window.location.href = "./showPurchaseBatchListAction.action?companyId=<s:property value="companyId"/>";
							});
					});
			});

		/**
		 * 删除单个角色信息
		 */
		$('a[name="delete"]').each(function() {
			$(this).click(function() {
				if (window.confirm("您确定要删除这条信息吗？")) {
					var url = $(this).attr("url");
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
			if (window.confirm("您确定要删除所选信息吗？")) {
				var url = "deletePurchaseBatchAction.action";
				$.post(url, $('#form1').serialize(), function(data) {
					window.location.href = window.location.href;
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
	}
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
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>供应商名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:select list="supplierList"  id="supplierId"  name="purchaseBatch.supplierId"  headerKey=""  headerValue="==请选择供应商=="  listKey="id"  listValue="supplierName"  cssStyle="width: 200px;" >
												</s:select>
												<font color="red">*</font>
											</td>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>供应商编号：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseBatch.supplierNumber" id="supplierNumber" cssStyle="width: 200px;" maxlength="25" readonly="true"></s:textfield>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>成交日期：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textfield name="purchaseBatch.transactionDate"  id="transactionDate"  cssStyle="width: 200px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</td>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												<input type="checkbox">已到货
												<input type="checkbox">已结账
												<input name="button1" type="button" class="btn_2_3"
													id="button1" value="确定">
												<input name="addbtn" type="button" class="btn_2_3" id="addbtn"
													value="添加记录">
												<input name="deletepointbtn" type="button" class="btn_4"
													id="deletepointbtn" value="删除记录">
												<input name="button2" type="button" class="btn_2_3"
													id="button2" value="返回">
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
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{#obj.id}" name="purchaseBatchIds" fieldValue="%{id}"
											value="false" theme="simple" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="supplierName" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="transactionDate" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF" style="work-break:break-all;">
										<s:property value="product" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="memo" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="memo" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="memo" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="memo" />
									</td>
									
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:property value="memo" />
									</td>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
										<s:url id="edit_url" action="showSupplierInfoAction">
											<s:param name="purchaseBatch.id" value="id"></s:param>
											<s:param name="purchaseBatch.companyId" value="companyId"></s:param>
										</s:url>
										<s:url id="delete_url" action="deletePurchaseBatchAction">
											<s:param name="purchaseBatchIds" value="id"></s:param>
										</s:url>
										<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>
										<a name="delete" href="javascript:void(0);"
											url="${delete_url}">删除</a>
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
