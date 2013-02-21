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
    <title>客户回访信息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true"/>
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
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
				"beginDate":{dateISO:true},
				"endDate":{dateISO:true}
			}
		};
		$(function(){
			$.validator.setDefaults({
				debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
			    errorPlacement:function(error, element) {},
				invalidHandler: function(form, validator) {
		        	$.each(validator.invalid,function(key,value){
		            	alert(value);document.getElementById(key).focus();return false;
		        	}); 
		    	}
			})
			$("#addbtn").click(function(){
				parent.parent.parent.tipsWindown("添加回访信息","iframe:customer/allMyCustomerVisitInfo.action?customerId=" + $("#customerId_t").val(),"810","500","true","","true","no");
				parent.parent.parent.$("#windown-close").bind('click',function(){
					window.location.href= window.location.href;
				});
			});
			$("#searchBtn").click(function(){
				var validate_settings_submit = jQuery.extend({}, _customer_submit);
               	var validator = $("form").validate(validate_settings_submit);
               	if(!validator.form()){
					return false;
				}
				form1.action = "allMyCustomerVisitList.action";
				form1.submit();
		
			});
			$('#beginDate').datetimepicker({showTimepicker: false});
			//日期控件
			$('#endDate').datetimepicker({showTimepicker: false});
			
			$.fn.checkall("cbk_all");
	  		$.fn.uncheckall("ids","cbk_all");

	  		/**
	  		 * 修改客户回访信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.parent.tipsWindown("修改回访信息","iframe:" + url,"810","500","true","","true","no");
					parent.parent.parent.$("#windown-close").bind('click',function(){
						window.location.href= window.location.href;
					});
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个客户回访信息
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				if(window.confirm("您确定要删除这条信息吗？")){
	  					$.post(url, "", function(data){window.location.href=window.location.href;});
	  				}
	  			});
	  		});
	  		
	  		/**
	  		 * 删除所选客户回访信息
	  		 */
	  		$("#deletepointbtn").click(function(){
  				var url = "customer/deleteCustomerVisit.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
	  		});
	  		
	  	
		});
	</script>

  </head>
  
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple">
 <s:hidden id="customerId" name="customerVisitInfo.customerId"></s:hidden>
 <s:hidden id="customerId_t" name="customerId"></s:hidden>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
       		<input name="addbtn" type="button" class="btn_4" id="addbtn" value="添加回访信息" >
            <input name="deletepointbtn" type="button" class="btn_4" id="deletepointbtn" value="删除所选">
        <td align="right"></td>
      </tr>
      
      <tr><td><table border="0" cellpadding="5" cellspacing="0">
	<tr>  		
		<td align="center">客户名称：</td>
		<td >
		<s:textfield name="customerName" id="customerName" style="width: 80px"></s:textfield></td>
		<td align="center">查询开始日期：</td>
		<td >
		<s:textfield name="beginDate" id="beginDate" style="width: 80px" readOnly="true"></s:textfield></td>
		<td align="center">查询结束日期：</td>
		<td><s:textfield name="endDate" id="endDate" style="width: 80px" readOnly="true"></s:textfield></td>
		<td align="center">类型：</td>
		<td><s:select list="listVisitOption" listKey="id" listValue="name" value="visitOption" 
			id="visitOption" name="visitOption" cssStyle="width:80px" headerKey="" headerValue="--请选择--"></s:select></td>
		<td align="center">状态：</td>
		<td ><s:select list="listVisitFlag" listKey="id" listValue="name" value="visitFlag" 
			id="visitFlag" name="visitFlag" cssStyle="width:80px" headerKey="" headerValue="--请选择--"></s:select></td>
		<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="searchBtn" value="查询" /></td>
	</tr>
</table></td></tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
         <td align="center" background="../images/headerbg.jpg">  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
              <td align="center" background="../images/headerbg.jpg"><strong>预计回访时间</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>实际回访时间</strong></td>
              <td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">客户名称</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">业务进展</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">受访人</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">联系方式</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">兴趣度</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">异议点</td>
              <td align="center" background="../images/headerbg.jpg"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
        <td height="26" align="center" bgcolor="#FFFFFF" >  
				<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
			</td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="visitTimeStr"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="actualVisitTimeStr"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="customerName"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="progress"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="person.personName"/>
			</td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="tel"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="contentResult"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="remark"/></td>
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
          	<s:url id="edit_url" action="customer/allMyCustomerVisitInfo.action">   
				<s:param name="id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="customer/deleteCustomerVisit.action">   
				<s:param name="ids" value="id"></s:param>   
			</s:url>
         	<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>  
         	<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>  
          </td>
        </tr>
        </s:iterator>        
        <tr>
          <td height="26" colspan="11" align="center" bgcolor="#FFFFFF">
			<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		  </td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
