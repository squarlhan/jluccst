<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>污水处理工艺专家决策系统</title>
    <meta http-equiv="refresh" content="10" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <div id="rightmain">
	  <h2>一切正常</h2>
<div id="login">
<table width="200" align="center" style="margin-left:30">
	<tr>
	<td align="center">一切正常!</td>
	</tr>
	</table>
	<!--  <div align="center">
      <input name="button" type=button onClick="window.location.href('errorlogaction.action')" value="手工数据报警日志">
      </div>-->
	<br/>
</div>
</div>
   
  </body>
</html>
