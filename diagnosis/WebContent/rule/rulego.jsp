<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%
	if (request.getSession().getAttribute("pr") == null) {
		response.sendRedirect("prof/proflogin.jsp");
	}
%>
   <%//if(request.getSession().getAttribute("session_admin")==null) 
  //{ 
 // response.sendRedirect("adminlogin.jsp"); 
 //  }  
                
   %>  
    <base href="<%=basePath%>">
    
    <title>结果页面</title>
     
    
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
     <h2><s:property value="result.nouns+result.verb" /></h2>
  
  <table bordercolor="#4A708B" rules="all"  id="mytable" class="list_table" align="center" width="100%">
		<tr bgcolor="#4A708B">
		    <th width="35%">报警原因</th>
			<th width="65%">相关建议</th>
			
	  </tr>
    <s:iterator id="reasons" value="reasonlist" status="index1">
       
     <tr  align="left"  bordercolor="#000000" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>">
       <td  align="left"><s:property value="nouns"/><s:property value="verb"/></td>
       <td  align="left"><s:property value="sugg"/></td>
      
     
     </tr>
     </s:iterator>
  </table>
   
    <div align="center">
      <input name="button" type=button onClick="window.location.href('rulebraction.action')" value="完成返回">
      </div>
 </div>
  </body>
</html>
