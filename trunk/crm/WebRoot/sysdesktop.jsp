<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
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
<j:scriptlink css="true"/>
<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>
</head>
<body>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td style="height:36px;"><table id="__01" width="100%" height="36" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="11"><img src="images/header_01.jpg" width="11" height="36" alt=""></td>
                <td background="images/header_02.jpg"><span class="STYLE1">您当前的位置：我的桌面</span></td>
                <td width="12"><img src="images/header_03.jpg" width="12" height="36" alt=""></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td valign="top" style="border-left:1px solid #54a4e3; border-bottom:1px solid #54a4e3; border-right:1px solid #54a4e3; padding:5px;"><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
            <tr>
              <td height="26" align="center" background="images/headerbg.jpg"><strong>序号</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>登录名</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>姓名</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>电话</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>地址</strong></td>
            </tr>
            <tr>
              <td height="26" bgcolor="#FFFFFF">&nbsp;</td>
              <td height="26" bgcolor="#FFFFFF">&nbsp;</td>
              <td height="26" bgcolor="#FFFFFF">&nbsp;</td>
              <td height="26" bgcolor="#FFFFFF">&nbsp;</td>
              <td height="26" bgcolor="#FFFFFF">&nbsp;</td>
            </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
