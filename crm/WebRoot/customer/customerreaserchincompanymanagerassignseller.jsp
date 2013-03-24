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
 * @author Luojx
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
    <title>客户信息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true"/>
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<script type="text/javascript">
	
		$(function(){
			if($("#message").html()!=null && $("#message").html()!=""){
				alert( $("#message").html());
				$("#selectedSellerList option").each(function(){
					  $(this).attr("selected", false); 
				  });
			}
			$("#closeBtn").click(function(){
				parent.parent.$("#windown-close").click();
			});
			
			$("#sellerList").dblclick( function () { 
				$("#sellerList option:selected").each(function(){  
                    var option = "<option value='"+$(this).val()+"'>"+$(this).text()+"</option>";                   
                    $("#selectedSellerList").append(option);  
                    $(this).remove();  
                });  
			}); 
			
			$("#addBtn").click(function(){
				$("#sellerList option:selected").each(function(){  
                    var option = "<option value='"+$(this).val()+"'>"+$(this).text()+"</option>";                   
                    $("#selectedSellerList").append(option);  
                    $(this).remove();  
                });  
			});
			
			$("#removeBtn").click(function(){
				$("#selectedSellerList option:selected").each(function(){  
                    var option = "<option value='"+$(this).val()+"'>"+$(this).text()+"</option>";                   
                    $("#sellerList").append(option);  
                    $(this).remove();  
                });  
			});
			
			$("#saveBtn").click(function(){
				  $("#selectedSellerList option").each(function(){
					  $(this).attr("selected", true); 
				  });
				  $("#form1").submit();
				  return false;
			});
		});
	</script>

  </head>
  
  
  <body>
  <center>
 <s:form id="form1" name="form1" method="post" theme="simple" action="toAssignSellerAction.action" >
 <s:hidden name="customerLibInfo.id"></s:hidden>
 <s:label  name="message" id ="message" cssStyle="display:none"></s:label>
<table width="400" border="0" cellspacing="1" cellpadding="0"  bgcolor="#FFFFFF">
	<tr>
		<td bgcolor="#FFFFFF">
			<fieldset >
			<legend>待分配</legend>
			<s:select id="sellerList" name="sellerList" list="sellerList" listKey="id" listValue="userCName" multiple="true" cssStyle="width:150;height:300"></s:select>
			</fieldset>
		</td>
		<td bgcolor="#FFFFFF" width="100" align="center">
			<table>
				<tr>
					<td>
						<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value=">>">
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td>
						<input name="removeBtn" type="button" class="btn_2_3" id="removeBtn" value="<<">
					</td>
				</tr>
			</table>
		</td>
		<td bgcolor="#FFFFFF">
			<fieldset >
				<legend>已分配</legend>
			<s:select id="selectedSellerList" name="selectedSellerIds" list="selectedSellerList" listKey="id" listValue="userCName" multiple="true" cssStyle="width:150;height:300"></s:select>
			</fieldset>
		</td>
	</tr>
	<tr>
		<td colspan="3"  bgcolor="#FFFFFF" height="35" align="center">
			<input name="saveBtn" type="button" class="btn_2_3" id="saveBtn" value="确定">
			<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="取消">
		</td>
	</tr>
</table>
</s:form>
</center>
</body>
</html>
