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
  response.sendRedirect("user/userlogin.jsp"); 
   }  
                
   %>  
   <%//if(request.getSession().getAttribute("session_admin")==null) 
  //{ 
 // response.sendRedirect("adminlogin.jsp"); 
 //  }  
                
   %>  
    <base href="<%=basePath%>">
    
    <title>超标信息页面</title>
     
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
  <h2>超标信息页面</h2>
  <table bordercolor="#4A708B" rules="all"  id="mytable" class="list_table" align="center" width="100%">
		<tr bgcolor="#4A708B">
		    <th style="width:50%">报警节点</th>
			<th style="width:50%">报警现象</th>
			
	  </tr>
    <s:iterator id="bandr" value="backwardandResult" status="index1">
       
     <tr  align="left"  bordercolor="#000000" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>">
       <td><s:property value="memo"/></td><td><s:property value="nouns"/><s:property value="verb"/></td>
      
      
     
     </tr>
     </s:iterator>
  </table>
      
  <table bordercolor="#4A708B" rules="all"  id="mytable" class="list_table" align="center" width="100%">
		<tr bgcolor="#4A708B">
		    <th style="width:50%">报警原因</th>
			<th style="width:50%">相关建议</th>
			
	  </tr>
    <s:iterator id="reasons" value="reasonlist" status="index1">
       
     <tr  align="left"  bordercolor="#000000" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>">
       <td><s:property value="nouns"/><s:property value="verb"/></td>
       <td><s:property value="sugg"/></td>
      
     
     </tr>
     </s:iterator>
  </table>
   
  </body>
</html>
