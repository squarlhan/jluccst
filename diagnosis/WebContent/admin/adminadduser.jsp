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
    
    <title>新建用户</title>
       <script type="text/javascript">
    	function confirmAdd(){
    		
			return confirm("确认要增加吗？");
			
    	}
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
	  <h2>添加新用户</h2>
	
<div id="login">
<s:form action="adminuseraction!addUser.action" theme = "simple">
<table width="200" align="center" style="margin-left:30;width:200px;">
	<tr><td>用户名:</td><td><s:textfield size="15" label="用户名" name="user.username" /></td></tr>
	<tr><td>初始密码:</td><td><s:password size="17" label="初始密码" name="user.password" /></td></tr>
	<tr><td>姓名:</td><td><s:textfield size="17" label="姓名" name="user.name" /></td></tr>
	<tr><td>电子邮箱:</td><td><s:textfield size="17" label="电子邮箱" name="user.email" /></td></tr>
	<tr><td>电话:</td><td><s:textfield size="17" label="电话" name="user.phone" /></td></tr>
	<tr><td>工作号:</td><td><s:textfield size="17" label="工作号" name="user.jid" /></td></tr>
	<tr><td>部门:</td><td><s:textfield size="17" label="部门" name="user.dept" /></td></tr>
	 <tr><td>用户:</td><td ><s:checkbox name="user.isuser"     theme="simple"/></td></tr>
      <tr><td>管理员:</td><td><s:checkbox name="user.isadmin"   theme="simple"/></td></tr>
       <tr><td>专家:</td><td><s:checkbox name="user.isprof"   theme="simple"/></td></tr> 
	<tr>
	<td width="80" align="center"><s:submit value="添加用户" onclick="return confirmAdd();" theme="simple" /></td>
	<td width="80" align="center"> <s:reset value="取消" theme="simple" /></td>
	</tr>
	</table>
</s:form>
</div>
</div>
   
  </body>
</html>
