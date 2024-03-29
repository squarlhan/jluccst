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
			
			$("#addbtn").click(function(){
				/*parent.parent.tipsWindown("添加客户信息","iframe:openAddCompanyAction.action","460","200","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="./customerList.action";
				});*/
				window.parent.location.href = "customerTabInfo.action?deptId=<s:property value='deptId'/>";
		
			});
			$("#importbtn").click(function(){
				parent.parent.tipsWindown("导入客户信息","iframe:customer/importCustomer.action","460","200","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href= window.location.href;
				});
				//window.parent.location.href = "customerTabInfo.action";
		
			});
			
			$("#searchBtn").click(function(){
				/*parent.parent.tipsWindown("添加客户信息","iframe:openAddCompanyAction.action","460","200","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="./customerList.action";
				});*/
				//window.parent.location.href = "customerTabInfo.action";
				if($.fn.isexiststrangecodeforsearch()){
					return false;
				}
				$("#currentPage").val(1);
				form1.action = "customerList.action";
				form1.submit();
		
			});
			$.fn.checkall("cbk_all");
	  		$.fn.uncheckall("ids","cbk_all");

	  		/**
	  		 * 修改客户信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url") + "&deptId=<s:property value='deptId'/>";
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
	  		 * 删除所选客户信息
	  		 */
	  		$("#deletepointbtn").click(function(){
  				var url = "deleteCustomer.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
	  		});
		});
	</script>

  </head>
  
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple">
 <s:hidden name="deptId"></s:hidden>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
       		<input name="addbtn" type="button" class="btn_4" id="addbtn" value="添加客户" >
            <input name="deletepointbtn" type="button" class="btn_4" id="deletepointbtn" value="删除所选">
            <input name="importbtn" type="button" class="btn_4" id="importbtn" value="导入客户" >
        <td align="right"></td>
      </tr>
      
      <tr><td><table border="0" cellpadding="5" cellspacing="0">
	<tr>  		
		<td></td>
		<td align="center">客户名称：</td>
		<td >
		<s:textfield name="customerName" id="customerName" style="width: 100px"></s:textfield></td>
		<td align="center">联系人：</td>
		<td><s:textfield name="contractorName" id="contractorName" style="width: 100px"></s:textfield></td>
		<td align="center">分类：</td>
		<td style="width:120px"><s:select list="listCategory" listKey="id" listValue="name" value="customerCategory" 
			id="categoryId" name="customerCategory" cssStyle="width:120px" headerKey="" headerValue="--请选择--"></s:select></td>
		<td align="center">业务进展：</td>
		<td style="width:120px"><select name="customerProgress" style="width:120px" >
		<option value="" >--请选择--</option>
		<option value="NEW" <s:if test="customerProgress.equals('NEW')">selected</s:if>>新建</option>
		<option value="TRACE" <s:if test="customerProgress.equals('TRACE')">selected</s:if>>跟踪</option>
		<option value="DEALING" <s:if test="customerProgress.equals('DEALING')">selected</s:if>>要成单</option>
		<option value="DEALED" <s:if test="customerProgress.equals('DEALED')">selected</s:if>>成单</option>
		<option value="VISIT" <s:if test="customerProgress.equals('VISIT')">selected</s:if>>回访</option>
		<option value="LOYAL" <s:if test="customerProgress.equals('LOYAL')">selected</s:if>>忠诚</option>
		</select></td>
		<td>业务员：</td/>
		<td style="width:120px"><s:select list="userList" listKey="id" listValue="userCName" value="salesmanId" 
			id="salesmanId" name="salesmanId" cssStyle="width:120px" headerKey="" headerValue="--请选择--"></s:select></td>
		<td></td>
		<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="searchBtn" value="快速查询" /></td>
	</tr>
</table></td></tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
         <td align="center" background="../images/headerbg.jpg">  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
              <td align="center" background="../images/headerbg.jpg"><strong>客户名称</strong></td>
              <td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">联系人/联系方式</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">业务员</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">客户分类</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">业务进展</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">忠诚度</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">开发程度</td>
			<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">客户来源</td>
              <!-- 
              <td align="center" background="../images/headerbg.jpg"><strong>公司地址</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>公司电话</strong></td>
               -->
              <td align="center" background="../images/headerbg.jpg"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
        <td height="26" align="center" bgcolor="#FFFFFF" >  
				<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
			</td>
            <td height="26" align="center" bgcolor="#FFFFFF">
            <s:if test="deleteFlag == 1">
            	<font color="#9900ff" title="被删除客户"><s:property value="customerName"/></font>
            </s:if>
            <s:else>
	            <s:if test="progressId.equals('DEALING')">
	            	<font color="#ff00ff" title="要成单客户"><s:property value="customerName"/></font>
	            </s:if>
	            <s:else>
	            	<s:property value="customerName"/>
	            </s:else>
	        </s:else>
            </td>
            <td height="26" align="center" bgcolor="#FFFFFF">
            <s:iterator value="contractPersonList" status="obj1">
            <s:property value="personName"/>&nbsp;
            <s:property value="phone"/>&nbsp;<s:property value="tel"/><br/>
            </s:iterator>
			</td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="salesman"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="category"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="progress"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="maturityId"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="levelId"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="source"/></td>
              <!-- 
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="address"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="phone"/></td>
               -->
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
          	<s:url id="edit_url" action="customerTabInfo.action">   
				<s:param name="id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteCustomer">   
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
