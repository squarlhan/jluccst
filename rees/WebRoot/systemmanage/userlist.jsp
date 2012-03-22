<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="p" uri="/page-tags"%>
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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" jquery="true"></j:scriptlink>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		$("#addBtn").click(function(){
			parent.parent.tipsWindown("用户信息","iframe:./userAction!showUser.action?user.id=","400","430","true","","true","no");
		});
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
<s:form id="form1" name="form1" method="post" theme="simple">
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td><input name="button" type="button" class="btn_2_3" id="addBtn" value="添加">
            <input name="button2" type="button" class="btn_4" id="button2" value="删除所选">
            <input name="button3" type="button" class="btn_2_3" id="button" value="排序">
            <input name="button3" type="button" class="btn_2_3" id="button" value="锁定">
            <input name="button3" type="button" class="btn_2_3" id="button" value="解锁">
            <input name="button3" type="button" class="btn_4" id="button" value="初始化密码">
            </td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
            <tr>
              <td height="26" align="center" background="../images/headerbg.jpg">&nbsp;</td>
              <td align="center" background="../images/headerbg.jpg"><strong>用户名</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>中文姓名</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>办公电话</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>个人手机</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>邮箱</strong></td>
            </tr>
            <s:iterator value="pagination.data" status="obj">
            <tr>
              <td height="26" align="center" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox"></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="username"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="userCName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="officePhone"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="phone"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="email"/></td>
            </tr>
            </s:iterator>
            <tr>
              <td height="26" colspan="6" align="center" bgcolor="#FFFFFF">
              		<p:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></p:pages>
              </td>
            </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
