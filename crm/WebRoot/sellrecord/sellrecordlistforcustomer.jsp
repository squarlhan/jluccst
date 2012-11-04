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
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-1.3.2.min.js"></script>
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
	
		$(function(){
			$.fn.CheckBoxAll("ids","cbk_all");
			$.fn.UnCheckBoxAll("ids","cbk_all");
			//日期控件
			$('#txt_queryBargainTimeBegin').datetimepicker({showTimepicker: false});
			$('#txt_queryBargainTimeEnd').datetimepicker({showTimepicker: false});
			$("#btn_add").click(function(){
				try{
					parent.$.fn.showOrHideTab(1,true);
					parent.$.fn.selectTab(1,'openAddSellRecordAction.action');
				}catch(e){
					alert(e.description);
				}
			});
			$("#btn_delAll").click(function(){
				var url = "deleteSellRecordAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
			});
			
			
			/**
	  		 * 修改信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				try{
						parent.$.fn.showOrHideTab(1,true);
						parent.$.fn.selectTab(1,url);
					}catch(e){
						alert(e.description);
					}
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个信息
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				if(window.confirm("您确定要删除这条信息吗？")){
	  					$.post(url, "", function(data){window.location.href=window.location.href;});
	  				}
	  			});
	  		});
		});
		/**
	  	 * 点击选复选框时，执行全选/取消全选功能
	  	 * @param chkallid
	  	 * 执行全选功能的checkbox的id值
	  	 */
	  	$.fn.CheckBoxAll = function (subchkname,chkallid) {
	  		$("#" + chkallid).click(function () {
	  			var b = ($(this).attr("checked"));
	  			$(":checkbox[name='" + subchkname + "']").each(function () {
	  				if( !$(this).attr("disabled") ){
	  					$(this).attr("checked", b);
	  				}
	  			});
	  		});
	  		if($(":checkbox[name='" + subchkname + "']").length ==0){
	  			$("#" + chkallid).attr("checked", false);
	  			$("#" + chkallid).attr("disabled",true);
	  		}
	  	};

	  	/**
	  	 * 子复选框有一个处理非选中状态时，执行全选功能的复选框将置为非选中状态
	  	 * @param subchkname
	  	 * 子复选框的name
	  	 * @param chkallid
	  	 * 执行全选功能的复选框id
	  	 */
	  	$.fn.UnCheckBoxAll = function (subchkname, chkallid) {
	  		$(":checkbox[name='" + subchkname + "']").live("click",function () {
	  			var l = $(":checkbox[name='" + subchkname + "']").length;
	  			if (!$(this).attr("checked")) {
	  				$("#" + chkallid).attr("checked", false);
	  			} else {
	  				var i = 0;
	  				$(":checkbox[name='" + subchkname + "']").each(function () {
	  					if ($(this).attr("checked")) {
	  						i++;
	  					}
	  				});
	  				if (l == i) {
	  					$("#" + chkallid).attr("checked", true);
	  				}
	  			}
	  		});
	  	};
	</script>
	</head>
  <body>
   <s:form id="form1" name="form1" method="post" theme="simple" action="openSellRecordListForCustomerAction.action">
   		<s:hidden id="customerId" name="customerId"></s:hidden>
   		<fieldset >
		<legend>查询条件</legend>
   		<span>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
				<tr>
					<td height="26" align="right" bgcolor="#FFFFFF">
						<strong>成交日期：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF"  >
						<s:textfield id="txt_queryBargainTimeBegin" name="queryBargainTimeBegin" cssStyle="width:200px" ></s:textfield>
						- <s:textfield id="txt_queryBargainTimeEnd" name="queryBargainTimeEnd" cssStyle="width:200px" ></s:textfield>
						<input name="queryBtn" type="submit" class="btn_2_3" id="queryBtn" value="查询">
					</td>
				</tr>
			</table>
		</span>
		</fieldset>
   		<table id="recordsList" width="100%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
			<tr>
				<td align="center" width="50px" background="<%=basePath%>/images/headerbg.jpg">
 							<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
 						</td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>客户名称</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>业务员</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>成交日期</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>产品种类</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>交易总额（元）</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>实 收（元）</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>欠 款（元）</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>交回款情况</strong></td>
			</tr>
			 <s:iterator value="pagination.data" status="obj">
	        	<tr>
	        		<td height="26" align="center" bgcolor="#FFFFFF" >  
						<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
					</td>
           			<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="customerName"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="salesmanName"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="bargainTime"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="goodsType"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="receivable"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="realCollection"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="debt"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="realCollection/receivable"/>%</td>
            </tr>
            </s:iterator>
			 <tr>
	          <td height="26" colspan="11" align="center" bgcolor="#FFFFFF">
				<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
			  </td>
	        </tr>
		</table>
	</s:form>
  </body>
</html>
