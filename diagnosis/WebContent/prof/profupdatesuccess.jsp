<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%if(request.getSession().getAttribute("pr")==null) 
  { 
  response.sendRedirect("proflogin.jsp"); 
   }  
                
   %>  
    <base href="<%=basePath%>">
    
    <title>修改成功</title>
    
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
         <table width = "200" align="center">
   <tr><td style="align:center;"> <div style="color: red;">修改成功</div><br></td></tr>
  
   <tr><td style="align:center;"> 用户名:  <s:property value="#session.pr.username"/></td></tr>
   <tr><td style="align:center;">电子邮箱:  <s:property value="#session.pr.email"/></td></tr>
   <tr><td style="align:center;">工作号:   <s:property value="#session.pr.jid"/></td></tr>
   <tr><td style="align:center;">电话 :    <s:property value="#session.pr.phone"/></td></tr>
   <tr><td style="align:center;">部门:    <s:property value="#session.pr.dept"/></td></tr>
   <tr><td style="align:center;">姓名 :    <s:property value="#session.pr.name"/></td></tr>

   </table>
   <p><s:a href="rule/ruledsc.jsp"> 
						   <p><div style="color:red;"><p align="center"><u>返回首页</u></p></div></p>
				  </s:a>	
  </body>
</html>
