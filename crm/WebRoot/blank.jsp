<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
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
<j:scriptlink css="true" jquery="true" jfunction="true" tipswindow="true"></j:scriptlink>
<style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
.btnCls{
	float: left;
}
-->
</style>
</head>
<body>
<table style="width:100%" height="100%" border="0" cellpadding="0" cellspacing="0" id="__01">
  <tr>
    <td align="center"><img src="images/mainpic.jpg" /></td>
  </tr>
</table>
</body>
</html>
