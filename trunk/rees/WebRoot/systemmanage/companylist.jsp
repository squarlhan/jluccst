<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/WEB-INF/page-tags.tld"%>
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
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="=true" jquery="true" tipswindow="true" validate="true" jmessagebox="true"></j:scriptlink>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		$("#addBtn").click(function(){
			parent.parent.tipsWindown("公司信息","iframe:openAddCompanyAction.action","350","1200","true","","true","no");
		});
		$("#editbtn").click(function(){
				parent.parent.parent.tipsWindown("修改公司信息","iframe:openModifyCompanyAction.action","460","1200","true","","true","no");
			});
	});
	/**
	  		 * 修改公司信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.parent.tipsWindown("修改设备信息","iframe:"+url,"460","350","true","","true","no");
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个公司信息
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				if(window.confirm("您确定要删除这条信息吗？")){
	  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
	  				}
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个公司信息
	  		 */
	  		$("#deletepointbtn").click(function(){
  				var url = "deleteDeviceAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
	  		});
//-->
</script>
<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
.STYLE2 {color: #FF0000}
-->
</style>
</head>
<body>
<s:form id="companyForm" action="openCompanyAction.action">
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td><input name="button" type="button" class="btn_2_3" id="addBtn" value="添加">
            <input name="button2" type="button" class="btn_4" id="button2" value="删除所选">
            </td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
            <tr>
              <td align="center" ><s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox></td>
              
              <td align="center" background="../images/headerbg.jpg"><strong>公司编号</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>公司名称</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>公司地址</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>公司电话</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>排序号</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>根节点标识</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>操作</strong></td>
            </tr>
            <s:iterator value="pagination.data" status="obj">
            <tr>
              <td height="26" align="center" bgcolor="#FFFFFF">
          	     <s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
              </td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="id"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="companyName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="address"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="phone"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="sortIndex"/></td>             
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="rootId"/></td>
              <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
          	     <s:url id="edit_url" action="openModifyCompanyAction">   
				      <s:param name="device.id" value="id"></s:param>   
			     </s:url>
			     <s:url id="delete_url" action="deleteCompanyAction">   
				      <s:param name="ids" value="id"></s:param>   
			     </s:url>
         	     <a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>  
         	     <a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>  
          </td>
            </tr>
            </s:iterator>
             <tr>
           <td height="26" colspan="8" align="center" bgcolor="#FFFFFF">
			   <page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		   </td>
           </tr>
          </table></td>
        </tr>
      </table>
  
</s:form>
</body>
</html>