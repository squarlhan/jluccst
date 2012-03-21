<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 * All right reserved.
	 */
	/**
	 * @author Guiyun Yang
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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="=true" jquery="true" tipswindow="true" validate="true" jmessagebox="true"></j:scriptlink>
<script type="text/javascript">
 $(document).ready( function() {
  		$("#addBtn").click(function(){
  			parent.$("#windown-close").click();
  			parent.location.href = $.fn.change_url(parent.location.href);
  		});
  		$("#closeBtn").click(function(){
  			parent.$("#windown-close").click();
  		});
  	});
</script>
</head>
<body>
<s:form id="addcompanyform" action="toAddCompanyAction.action">
<table width="100%" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="6" cellpadding="0">
        <tr>
          <td style="height:36px;"><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>公司编号：</strong></td><td height="26" align="right" ><s:textfield id="text_id" name="company.ID" /></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>公司名称：</strong></td><td height="26" align="right" ><s:textfield id="text_companyname" name="company.companyName" /></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>公司地址：</strong></td><td height="26" align="right" ><s:textfield id="text_address" name="company.address" /></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>公司电话：</strong></td><td height="26" align="right" ><s:textfield  id="text_phone" name="company.phone" /></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>根节点标识：</strong></td><td height="26" align="right" ><s:textfield id="text_rootid" name="company.rootId"/></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>排序号：</strong></td><td height="26" align="right" ><s:textfield id="text_indexSort"  name="company.sortIndex"/></td>
            </tr>
             <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>创建时间：</strong><s:textfield id="text_createTime" name="company.createTime"  /></td>
            </tr>
            <tr>
               <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
               <input name="button1" type="submit" class="btn_2_3"	id="button1" value="提交">
		       <input name="button2" type="reset" class="btn_2_3"id="button2" value="重置">
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
          





