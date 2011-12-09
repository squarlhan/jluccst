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
    
    <title>管理员登陆错误</title>
     <script type="text/javascript">
    	alert("密码错误，请重新输入！")
    </script>
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
	  <h2>管理员登陆页面</h2>
<div id="login">
<s:form action="adminaction!exitsadmin.action">
<table width="200" align="center" style="margin-left:30">
	<tr>
	<td align="center"><s:textfield size="15" label="用户名" name="user.username" /></td>
	</tr>
	<tr>
	<td align="center"><s:password size="17" label="密码" name="user.password" /></td>
	</tr>
	</table>
	<br/>
	<table width="150" align="center">
	<tr>
	<td width="80" align="center"><s:submit value="登陆" theme="simple" />
	</td>
	
	<td width="80" align="center"> <s:reset value="取消"
		theme="simple" /></td></tr></table>
</s:form></div>
</div>
   
  </body>
</html>
