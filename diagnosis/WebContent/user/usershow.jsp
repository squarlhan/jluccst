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
    
    <title>用户信息</title>
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
	  <h2>用户修改信息</h2>
	  
      <div id="login">
<s:form action="useraction!alterUser.action">
<table width="320" align="center" style="margin-left:30">
	<tr>
	 
	 <td >当前用户:</td>
	   <td ><s:property value="#session.us.username"/></td>
	  </tr>
	<tr>
	 <td align="center"><label>
	    <s:textfield name="user.name" key="姓名" value="%{#session.us.name}" />
	    </label></td>
	  </tr>
	<tr>
	  <td >当前密码:</td>
	  <td ><label>
	    <input type="password" name="currentpassword">
	  </label></td>
	  </tr>
	<tr>
	<tr>
	  <td >新密码:</td>
	  <td ><label>
	    <input type="password" name="newpassword">
	  </label></td>
	  </tr>
	<tr>
	
	 <td align="center"><label>
	    <s:textfield name="user.email" key="电子邮箱" value="%{#session.us.email}" />
	    </label></td>
	  </tr>
	<tr>
	 <td align="center"><label>
	    <s:textfield name="user.jid" key="工作号" value="%{#session.us.jid}" />
	    </label></td>
	  </tr>
	<tr>
	 <td align="center"><label>
	    <s:textfield name="user.phone" key="电话" value="%{#session.us.phone}" />
	    </label></td>
	  </tr>
	  <tr>
	 <td align="center"><label>
	    <s:textfield name="user.dept" key="部门" value="%{#session.us.dept}" />
	    </label></td>
	  </tr>
	</table>
	<br/>
	<table width="150" align="center">
	<tr>
	<td width="80" align="center"><s:submit value="修改" theme="simple" />
	  <div align="center"></div></td>
	
	<td width="80" align="center"> <s:reset value="重置"
		theme="simple" /></td></tr></table>
</s:form></div>
</div>
   
  </body>
</html>
