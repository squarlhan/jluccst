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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户档案管理</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
/*
.STYLE2 {
background-color:#d3eaef}
*/
.STYLE6 {color: #000000; font-size: 12px; }
.STYLE10 {color: #000000; font-size: 12px; background:#d3eaef; 	letter-spacing: 2pt; padding:0px 20px}
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
/*字号，字间距，颜色黑，背景色，左右边距，是查询和列表项目 */
.style11{
	color: #000000;
	font-size: 12px;
	letter-spacing: 1pt;
	background-color:#d3eaef;
	padding: 0px 10px;
}
-->
</style>
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
			
			$("#addbtn").click(function(){
				/*parent.parent.tipsWindown("添加客户信息","iframe:openAddCompanyAction.action","460","200","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="./customerList.action";
				});*/
				//window.parent.location.href = "customerTabInfo.action";
		
			});
			
			$("#searchBtn").click(function(){
				/*parent.parent.tipsWindown("添加客户信息","iframe:openAddCompanyAction.action","460","200","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="./customerList.action";
				});*/
				//window.parent.location.href = "customerTabInfo.action";
				form1.action = "autoAnalysisCustomerList.action";
				form1.submit();
		
			});
			$.fn.checkall("cbk_all");
	  		$.fn.uncheckall("ids","cbk_all");

	  		/**
	  		 * 修改客户信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				/*parent.parent.tipsWindown("修改客户信息","iframe:"+url,"460","200","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
						window.location.href="./customerList.action";
					});*/
					
	  				window.parent.location.href = url;
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个客户信息
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
	  		 * 统计
	  		 */
	  		$('a[name="static"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("客户评估信息统计图","iframe:"+url,"650","450","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
						//window.location.href=window.location.href;
					});
	  			});
	  		});
	  		
	  		/**
	  		 * 删除所选客户信息
	  		 */
	  		$("#deletepointbtn").click(function(){
  				var url = "deleteAnalysisCustomer.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
	  		});
		});
	</script>

<body>
 <s:form id="form1" name="form1" method="post" theme="simple">
<table width="100%" >

<!--总框架下的第二行（第一列），查询条件与按钮-->
<tr><td><table border="0" cellpadding="5" cellspacing="0">
	<!--  <tr>
        <td>
            <input name="deletepointbtn" type="button" class="btn_4" id="deletepointbtn" value="删除所选">
        <td align="right"></td>
      </tr>
       -->
      <tr><td><table border="0" cellpadding="5" cellspacing="0">
	<tr>  		
		<td></td>
		<td align="center">客户名称：</td>
		<td >
		<s:textfield name="customerName" id="customerName" style="width: 100px"></s:textfield></td>
		<td align="center">联 系 人：</td>
		<td><s:textfield name="contractorName" id="contractorName" style="width: 100px"></s:textfield></td>
		<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="searchBtn" value="快速查询" /></td>
	</tr>
</table></td></tr></table></td></tr>
<tr><td><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
	<tr>
	<!-- 
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg'); width: 90px;"></td>
		 --><td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">客户名称</td>
		 <td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">评估值</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">评估结论</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">消费额度</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">消费次数</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">转介绍客户情况</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">回款情况</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">开发程度</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">操作</td>
	</tr>
	<s:iterator value="pagination.data" status="obj">
        <tr>
        <!-- 
        	<td height="26" align="center" bgcolor="#FFFFFF" >  
				<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
			</td> -->
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="customerName"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><font color="#ff00ff"><s:property value="resultValue"/></font></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><font color="#ff00ff"><s:property value="result"/></font></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="totalConsumption"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="consumptionTimes"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="introduceCustomerTime"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="paymentsTimes"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="developDegree"/></td>
	          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
	          <s:url id="static_url" action="staticAnalysisCustomer">   
					<s:param name="customerId" value="customerId"></s:param>   
				</s:url>
				<a name="static" href="javascript:void(0);" url="${static_url}"><font color="#535353"><u>统计结果</u></font></a>  
				<s:url id="delete_url" action="deleteAnalysisCustomer">   
					<s:param name="ids" value="id"></s:param>   
				</s:url>
				<!-- 
	         	<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>  
	           -->
	          </td>
        </tr>
        </s:iterator>        
        <tr>
          <td height="26" colspan="11" align="center" bgcolor="#FFFFFF">
			<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		  </td>
        </tr>
</table></td></tr>
</table>
</s:form>
</body>
</html>
