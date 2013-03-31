<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author zhuyf
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>销售记录编辑</title>
	<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
	<script type="text/javascript" src="<%=basePath%>js/jquery.cookie.pack.js"></script>
	<style type="text/css"> 
		#ui-datepicker-div, .ui-datepicker{ font-size: 85%; }	
		.tips { color:#999; padding:0 5px; }
		.tips strong { color:#1E9300; }
		.tips .js_txtFull strong { color:#F00; }
		textarea.text { width:474px; }	
	</style> 
	<script type="text/javascript">
	/*
		if(window.confirm("您确定要删除所选信息吗？")){
			$.post(url, $('#form1').serialize(), function(data){
				url = window.location.href;
				var array=url.split("?");
				url = array[0]+"?"+param;
				window.location.href=url;
			});
		}
	//*/
	
		/**
	  	 * 验证条件
	  	 */
		var _customer_submit = {
			rules: {
				"goods.goodsProductId":{required:true,strangecode:true},
				"goods.standard":{strangecode:true},
				"goods.weight":{strangecode:true},
				"goods.allPrice":{required:true,strangecode:true,number:true},
				"goods.number":{required:true,strangecode:true,number:true},
				"goods.price":{required:true,strangecode:true,number:true},
				"goods.memo":{strangecode:true}
			}
		};
	  	$(function(){
	  		$("#goodsProductId").focus();
	  		try{
	  		$.validator.setDefaults({
				debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
			    errorPlacement:function(error, element) {},
				invalidHandler: function(form, validator) {
		        	$.each(validator.invalid,function(key,value){
		            	alert(value);document.getElementById(key).focus();return false;
		        	}); 
		    	}
			});
	  		//选择商品事件
	  		$.fn.goodsInfoBaseListChange();
	  		
	  		$("#btn_add").click(function(){
	  			var validate_settings_submit = jQuery.extend({}, _customer_submit);
               	var validator = $("#form1").validate(validate_settings_submit);
               	if(!validator.form()){
					return false;
				}
	  			
	  			var info="";
	  			var goodsProductId= $("#goodsProductId").val();
	  			var goodsName= 	$('#goodsProductId option:selected').text();
	  			var standard= $("#txt_standard").val();
	  			var factory= $("#txt_factory").val();
	  			var number= $("#txt_number").val();
	  			var price= $("#txt_price").val();
	  			var allPrice= $("#txt_allPrice").val();
	  			var memo= $("#txt_memo").val()+" ";
	  			info = goodsProductId+"☆"+goodsName+"☆" + standard+"☆" + factory+"☆" + price+"☆"+number+"☆"+allPrice +"☆" + memo +"☆";
	  			$.cookie('detial',info); 
	  			parent.$("#windown-close").click();
			});
	  		$.fn.close();
	  		}catch(e){
	  			alert(e.description);
	  		}
		});
	  	/**
		 * 关闭
		 */
	 	$.fn.close = function(){ 
	 		$("#closeBtn").click(function(){
	  			$.cookie('detial',''); 
	  			parent.$("#windown-close").click();
	  		});
		};
		
		$.fn.goodsInfoBaseListChange = function(){
			$("#goodsProductId").change(function(){
				var goodsInfoBaseId = $("#goodsProductId").val();
				$.ajax({
  					type:"post",
  					url: "getGoodsInfoForAjaxAction.action",
  					data:{goodsInfoBaseId:goodsInfoBaseId},
  					success: function(data, textStatus){
  						try{
  							$("#txt_standard").val(data.goodsInfoBase.goodsStandard);
  							$("#txt_price").val((data.goodsInfoBase.goodsPrice));
  							$("#txt_factory").val((data.goodsInfoBase.factoryName));
  						}catch(e){
  							alert(e.description);
  						}
  					}
				});
			});
		};
		
	</script>
  </head>
  
  <body>
	<s:form id="form1" name="form1" method="post" theme="simple">
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0" cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
											<strong>品名：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
<%--											<s:textfield id="txt_goodsName" name="goods.goodsName" cssStyle="width: 160px;" maxlength="25"></s:textfield>--%>
												<s:select list="goodsInfoBaseList" listKey="id" listValue="name" value="goodsProductId"  id="goodsProductId" name="goods.goodsProductId" cssStyle="width:150px" headerKey="" headerValue="--请选择产品--"  cssStyle="width: 165px;"></s:select>
											<font color="red">*</font>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
											<strong>规格：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"> 
												<s:textfield id="txt_standard" name="goods.standard" cssStyle="width: 160px;" maxlength="25"></s:textfield>
											</span>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
											<strong>厂商：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"> 
												<s:textfield id="txt_factory" name="goods.factory" cssStyle="width: 160px;" maxlength="25"></s:textfield>
											</span>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF"  nowrap="nowrap">
											<strong>单价：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"> 
												<s:textfield id="txt_price" name="goods.price" cssStyle="width: 160px;" maxlength="25"></s:textfield>元
											</span>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>数量：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_number" name="goods.number" cssStyle="width: 160px;" maxlength="25"></s:textfield><font color="red">*</font>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>预付：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_allPrice" name="goods.allPrice" cssStyle="width: 160px;" maxlength="25"></s:textfield>元<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>备注：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="5">
											<s:textarea  id="txt_memo" name="goods.memo" cssStyle="width: 645px;height:100px;resize:none;" maxlength="500"></s:textarea>
										</td>
									</tr>
									
									<tr>
										<td height="26" colspan="6" align="center" bgcolor="#FFFFFF">
											<input name="btn_add" type="button" class="btn_2_3" id="btn_add" value="确定">
											&nbsp;&nbsp;
											<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="取消">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</s:form>
</body>
</html>
