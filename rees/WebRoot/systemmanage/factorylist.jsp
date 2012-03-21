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

	$(document).ready(function() {
		$("#addBtn").click(function(){
			parent.parent.tipsWindown("工厂信息","iframe:openAddFactoryAction.action","400","230","true","","true","no");
		});
	});
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
<s:form id="factoryForm" action="openAddFactoryAction.action">
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
              <td height="26" align="center" background="../images/headerbg.jpg">&nbsp;</td>
              <td align="center" background="../images/headerbg.jpg"><strong>工厂编号</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>公司编号</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>工厂名称</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>电话</strong></td>
               <td align="center" background="../images/headerbg.jpg"><strong>负责人</strong></td>
            </tr>
            <s:iterator value="pagination.data" status="obj">
            <tr>
              <td height="26" align="center" bgcolor="#FFFFFF">
          	     <input type="checkbox" name="checkbox" id="checkbox">
              </td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="id"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="companyId"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="factoryName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="phone"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="principal"/></td>
            </tr>
            </s:iterator>
             <tr>
           <td height="26" colspan="7" align="center" bgcolor="#FFFFFF">
			   <page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		   </td>
           </tr>
          </table></td>
        </tr>
      </table>
</s:form>
</body>
</html>