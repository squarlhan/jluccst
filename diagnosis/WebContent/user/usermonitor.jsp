<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
    
    <title>结果页面</title>
     <meta http-equiv="refresh" content="10" />
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
    
  <h2>超标信息页面</h2>
  <table bordercolor="#4A708B" rules="all"  id="mytable" class="list_table" align="center" width="100%">
		<tr bgcolor="#4A708B">
		    <th style="width:50%">故障设备</th>
			<th style="width:50%">故障现象</th>
			
	  </tr>
    <s:iterator id="bandr" value="backwardandResult" status="index1">
       
     <tr  align="left"  bordercolor="#000000" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>">
       <td><s:property value="memo"/></td><td><s:property value="nouns"/><s:property value="verb"/></td>
      
      
     
     </tr>
     </s:iterator>
  </table>
    
  
  <table bordercolor="#4A708B" rules="all"  id="mytable" class="list_table" align="center" width="100%">
		<tr bgcolor="#4A708B">
		    <th style="width:50%">故障原因</th>
			<th style="width:50%">相关建议</th>
			
	  </tr>
    <s:iterator id="reasons" value="reasonlist" status="index1">
       
     <tr  align="left"  bordercolor="#000000" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>">
       <td><s:property value="nouns"/><s:property value="verb"/></td>
       <td><s:property value="sugg"/></td>
      
     
     </tr>
     </s:iterator>
  </table>
   
    <div align="center">
      <input name="button" type=button onClick="window.location.href('errorlogaction.action')" value="故障日志">
      </div>
  </body>
</html>
