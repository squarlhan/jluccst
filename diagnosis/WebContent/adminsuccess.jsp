<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
    
    <title>结果页面</title>
    
      <script type="text/javascript">
    	function confirmDel(){
			return confirm("确定删除？");
			
			    
			
    	}
    	function confirmReset(){
			return confirm("确认要重置密码吗？");
			
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

   <table width="100%" height="77" border="0" cellspacing="0">
      <tr>
        <td><div style="color: green;"> 
          <div align="right"><strong>
            <s:property value="#session.ad.username"/>
            :</strong> 您好
          </div>
       
        </div>
        <p align="right"><a href="adminaction!logoff.action"><u>注销登录</u></a></p></td>
      </tr>
    </table>
 
  <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">
		    <th>USERNAME</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th>JID</th>
			<th>DEPT</th>
			<th>管理员操作</th>
	  </tr>
    <s:iterator id="users" value="userlist" status="index1">
       
     <tr  align="center"  bordercolor="#FFFFFF" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
       <td><s:property value="username"/></td>
       <td><s:property value="name"/></td>
       <td><s:property value="email"/></td>
        <td><s:property value="phone"/></td>
       <td><s:property value="jid"/></td>
       <td><s:property value="dept"/></td>
      <td width="200" height="35">
						
							<s:a href="adminuseraction!chUser?user.id=%{#users.id}" onclick="return confirmReset();">重置密码</s:a>

						
						&nbsp;
						<s:a href="adminuseraction!deleteUser?user.id=%{#users.id}" onclick="return confirmDel();">
																						删除</s:a>

	   </td>
     </tr>
     </s:iterator>
  </table>
   
  </body>
</html>
