<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = "http://"+request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" jquery="true" jfunction="true"></j:scriptlink>

</head>
<body>
<input type="hidden" name="path" id="path" value="<%=path%>"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="__01">
  <tr>
    <td height="26" background="images/bottombg.jpg" style="padding-left:10px;"><p><strong>技术支持：长春博岸信息科技有限责任公司</strong></p></td>
  </tr>
</table>
</body>
</html>
