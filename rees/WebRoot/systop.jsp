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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="style.css" />
<j:scriptlink css="true"/>
<style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
-->
</style>
</head>
<body>
<table width="100%" height="85" border="0" cellpadding="0" cellspacing="0" id="__01">
  <tr>
    <td width="886"><img src="images/top_01.jpg" width="886" height="85" alt=""></td>
    <td background="images/top_02.jpg">&nbsp;</td>
    <td width="138"><img src="images/top_03.jpg" width="138" height="85" alt=""></td>
  </tr>
  <tr>
    <td height="36" colspan="3" background="images/top_bg2.jpg" style="padding-left:20px;">
	    <table width="870" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="20" style="padding-bottom:2px;"><img src="images/user.gif" width="16" height="16" /></td>
	        <td width="850" style="padding-top:2px;">
	        	<span class="STYLE1">
	        		今天是2012年12月12日 星期三  欢迎您：系统管理员, 您的部门：动力一砀-》第二柄烯车间-》动力一砀-》第二柄烯车间
	        		个人资料 退出
	        	</span>
	        </td>
	      </tr>
	    </table>
    </td>
  </tr>
</table>
</body>
</html>
