<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <META HTTP-EQUIV="Refresh" CONTENT="1;URL=ruleaction!getall.action">
    <title>结果页面</title>
    
	
  </head>
  
  <body>
   <p>操作成功 ！</p>
  </body>
</html>