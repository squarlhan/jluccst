<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%if(request.getSession().getAttribute("ad")==null) 
  { 
  response.sendRedirect("adminlogin.jsp"); 
   }  
                
   %>  
    <base href="<%=basePath%>">
   <script type="text/javascript">
    	alert("新密码不能为空！")
    </script> 
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
	  <h2>管理员修改信息</h2>
	 
      <div id="login">
<s:form action="adminaction!alterAdmin.action">
<table width="320" align="center" style="margin-left:30">
	<tr>
	 <td ><label>
	   <s:property value="#session.ad.username"/>
	  
	    </label></td>
	  </tr>
	<tr>
	 <td align="center"><label>
	    <s:textfield name="admin.name" key="姓名" value="%{#session.ad.name}" />
	    </label></td>
	  </tr>
	<tr>
	  <td >当前密码</td>
	  <td ><label>
	    <input type="password" name="currentpassword">
	  </label></td>
	  </tr>
	<tr>
	<tr>
	  <td >新密码</td>
	  <td ><label>
	    <input type="password" name="newpassword">
	  </label></td>
	  </tr>
	<tr>
	
	 <td align="center"><label>
	    <s:textfield name="admin.email" key="电子邮箱" value="%{#session.ad.email}" />
	    </label></td>
	  </tr>
	<tr>
	 <td align="center"><label>
	    <s:textfield name="admin.jid" key="工作号" value="%{#session.ad.jid}" />
	    </label></td>
	  </tr>
	<tr>
	 <td align="center"><label>
	    <s:textfield name="admin.phone" key="电话" value="%{#session.ad.phone}" />
	    </label></td>
	  </tr>
	   <tr>
	 <td align="center"><label>
	    <s:textfield name="admin.dept" key="部门" value="%{#session.ad.dept}" />
	    </label></td>
	  </tr>
	</table>
	<br/>
	<table width="150" align="center">
	<tr>
	<td width="80" align="center"><s:submit value="修改" theme="simple" />
	  <div align="center"></div></td>
	
	<td width="80" align="center"> <s:reset value="取消"
		theme="simple" /></td></tr></table>
</s:form></div>
</div>
   
  </body>
</html>
