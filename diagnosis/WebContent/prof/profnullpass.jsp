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
    
    <title>更改信息错误</title>
     <script type="text/javascript">
    	alert("新密码不能为空，请重新输入！")
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
	  <h2>专家修改信息</h2>
	  
      <div id="login">
<s:form action="profaction!alterProf.action"   theme="simple">
<table width="320" align="center" style="margin-left:30">
	<tr>
	<td >用户名：</td>
	 <td ><s:property value="#session.pr.username"/></td>
	  </tr>
	<tr>
	<td >姓名：</td>
	 <td align="center"><label>
	    <s:textfield name="user.name" key="姓名" value="%{#session.pr.name}" />
	    </label></td>
	  </tr>
	<tr>
	  <td >当前密码：</td>
	  <td ><label>
	    <input type="password" name="currentpassword">
	  </label></td>
	  </tr>
	<tr>
	<tr>
	  <td >新密码：</td>
	  <td ><label>
	    <input type="password" name="newpassword">
	  </label></td>
	  </tr>
	<tr>
	<td >电子邮箱：</td>
	 <td align="center"><label>
	    <s:textfield name="user.email" key="电子邮箱" value="%{#session.pr.email}" />
	    </label></td>
	  </tr>
	<tr>
	<td >工作号：</td>
	 <td align="center"><label>
	    <s:textfield name="user.jid" key="工作号" value="%{#session.pr.jid}" />
	    </label></td>
	  </tr>
	<tr>
	<td >电话：</td>
	 <td align="center"><label>
	    <s:textfield name="user.phone" key="电话" value="%{#session.pr.phone}" />
	    </label></td>
	  </tr>
	  <tr>
	  <td >部门：</td>
	 <td align="center"><label>
	    <s:textfield name="user.dept" key="部门" value="%{#session.pr.dept}" />
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
