<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%if(request.getSession().getAttribute("us")==null) 
  { 
  response.sendRedirect("userlogin.jsp"); 
   }  
                
   %>  
    <base href="<%=basePath%>">
    
    <title>净水厂设备诊断专家系统</title>
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
	
	  <div style="color: green;"> <strong><s:property value="#session.us.username"/>:</strong>  您好
    <p class="STYLE1"><a href="usershow.jsp">修改个人信息</a></p></div><br>
<div id="login">
<s:form action="adminaction.action">

<table width="300" align="center" style="margin-left:30">
	<tr>
	<td >
	 请选择故障设备名称：
	    <select name="select" size="1">
	      <option>故障设备名称1</option>
	      <option>故障设备名称2</option>
	      <option>故障设备名称3</option>
	      </select>
	    </td>
	</tr>
	<tr>
	<td >请选择故障设备现象：
	  <select name="select" size="1">
	    <option>故障设备现象1</option>
	    <option>故障设备现象2</option>
	    <option>故障设备现象3</option>
	    </select>
	  </td>
	</tr>
	</table>
	<br/>
	<table width="300" align="center" style="margin-left:10">
	<tr>
	<td width="80" ><input type="button" onclick="window.location.href('stepbystep.jsp')"  value="按步查找" /></td>
	
	<td width="80"> <input type="button" onclick="window.location.href('go.jsp')" value="直接查找" /></td>
	</tr></table>
</s:form></div>
</div>
   
  </body>
</html>
