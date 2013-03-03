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
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
	<script src="<%=basePath %>/js/ui/jquery.ui.core.js"></script>
	<script src="<%=basePath %>/js/ui/jquery.ui.widget.js"></script>
	<script src="<%=basePath %>/js/ui/jquery.ui.position.js"></script>
	<script src="<%=basePath %>/js/ui/jquery.autocomplete.js"></script>
	<style type="text/css">
			.auto-style1 {
			background: #d3eaef; font-size: 18px; font-family: 仿宋;}
		
		.auto-style2 {
			font-size: x-large;
		}
		.auto-style3 {
			text-align: right;
		}
		.ui-autocomplete-loading { background: white url('images/ui-anim_basic_16x16.gif') right center no-repeat; }
		</style>
		<link rel='stylesheet' type='text/css'  href='<%=path %>/css/jquery.autocomplete.css' />
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<script type="text/javascript">
	
		/**
	  	 * 验证条件
	  	 */
		var _customer_submit = {
			rules: {
				"queryBeginTime":{required:true,strangecode:true},
				"queryAmountEnd":{required:true,strangecode:false}
			},messages:{
				"queryBeginTime":
				{
				    required:"请选择成交起始日期！",
				    strangecode:"成交起始日期包含特殊字符！"
				},
				"queryAmountEnd":
				{
					required:"请选择成交结束日期！",
				    strangecode:"成交结束日期包含特殊字符！"
				}
			}
		};
		
		function onlyNumbers(id) {
			re = /^\d+\.?\d*$/;
			var str = $("#"+id).val();
			if(str!=""){
				if (!re.test(str)) {
					$("#"+id).focus();
					$("#"+id).select();
					return false;
				}else{
					return true;
				}
			}else{
				return true;
			}
		}
		
		$(function(){
			$.validator.setDefaults({
				debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
			    errorPlacement:function(error, element) {},
				invalidHandler: function(form, validator) {
		        	$.each(validator.invalid,function(key,value){
		            	alert(value);document.getElementById(key).focus();return false;
		        	}); 
		    	}
			});
			//日期控件
			$('#queryBeginTime').datetimepicker({showTimepicker: false});
			$('#queryEndTime').datetimepicker({showTimepicker: false});
			
			$("#searchBtn").click(function(){
				if( !onlyNumbers("queryAmountBegin")){
            	   alert("总销售额起始值请填写数字，如：10000！");
            	   return false;
                }
				if( !onlyNumbers("queryAmountEnd")){
            	   alert("总销售额结束值请填写数字，如：10000！");
            	   return false;
                }
				form1.action = "queryCustomerBySellAmountForEditAction.action";
				form1.submit();
		
			});

	  		/**
	  		 * 查看客户信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("销售记录","iframe:"+url,"6800","1800","true","","true","yes");
	  			});
	  		});
		});
	</script>

  </head>
  
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple">
 <s:hidden name="deptId"></s:hidden>
 <s:hidden name="salesmanId"></s:hidden>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top">
    <fieldset >
		  	<legend>查询条件</legend>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
				<tr>
					<!-- 
					<td height="26"  align="right" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>客户名称：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:textfield name="customerName" id="customerName" style="width: 100px"></s:textfield>
					</td>
					<td height="26"  align="right" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>联 系 人：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:textfield name="contractorName" id="contractorName" style="width: 100px"></s:textfield>
					</td>
					<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>客户分类：</strong>
					</td>
					<td height="26"  align="left" bgcolor="#FFFFFF">
						<s:select list="listCategory" listKey="id" listValue="name" value="customerCategory"  id="categoryId" name="customerCategory" cssStyle="width:100px" headerKey="" headerValue="--请选择--"></s:select>
					</td>
					<td height="26"  align="right" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>业务员：：</strong>
					</td>
					<td height="26"  align="left" bgcolor="#FFFFFF">
						<s:select list="userList" listKey="id" listValue="userCName" value="salesmanId"  id="salesmanId" name="salesmanId" cssStyle="width:100px" headerKey="" headerValue="--请选择--"></s:select>
					</td>
					 -->
					 
					<td height="26"  align="right" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>成交日期：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:textfield name="queryBeginTime" id="queryBeginTime" style="width: 100px"></s:textfield>
						-
						<s:textfield name="queryEndTime" id="queryEndTime" style="width: 100px"></s:textfield>
					</td>
					<td height="26"  align="right" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>总销售额范围：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:textfield name="queryAmountBegin" id="queryAmountBegin" style="width: 100px"></s:textfield>
						-
						<s:textfield name="queryAmountEnd" id="queryAmountEnd" style="width: 100px"></s:textfield>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<input type="button" style="width: 80px;" class="btn_4" id="searchBtn" value="查询" />
					</td>
				</tr>
			</table>
			</fieldset>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
              <td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>客户名称</strong></td>
              <td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')"><strong>联系人/联系方式</strong></td>
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')"><strong>业务员</strong></td>
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')"><strong>客户分类</strong></td>
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')"><strong>业务进展</strong></td>
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')"><strong>成熟度</strong></td>
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')"><strong>开发程度</strong></td>
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')"><strong>客户来源</strong></td>
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')"><strong>交易总额</strong></td>
            <td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="customerName"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF">
            <s:iterator value="contractPersonList" status="obj1">
            <s:property value="personName"/>&nbsp;
            <s:property value="phone"/>&nbsp;<s:property value="tel"/><br/>
            </s:iterator>
			</td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="salesman"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="category"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="progress"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="maturity"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="levelId"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="source"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="totalConsumption"/></td>
          	<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
          	<s:url id="edit_url" action="openSellRecordListForCustomerAction.action">   
				<s:param name="customerId" value="id"></s:param>   
			</s:url>
         	<a name="edit" href="javascript:void(0);" url="${edit_url}">维护</a>  
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
