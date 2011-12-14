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
  
   
    <base href="<%=basePath%>">
    
    <title>错误日志</title>
    
    
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
	  <h2>手工数据报警日志</h2>
	
     
 
  <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">
		    <th width = "15%">设备名</th>
			<th width = "15%">参数名</th>
			<th width = "10%">故障现象</th>
			<th width = "20%">故障时间</th>
			<th width = "10%">故障值</th>
			<th width = "30%">采取的建议</th>
	  </tr>
    <s:iterator id="errors" value="errorlist" status="index1">
       
     <tr  align="center"  bordercolor="#FFFFFF" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
       <td><s:property value="equipment"/>&nbsp;</td>
       <td><s:property value="item"/>&nbsp;</td>
       <td><s:property value="level"/>&nbsp;</td>
        <td><s:property value="time"/>&nbsp;</td>
       <td><s:property value="value"/>&nbsp;</td>
       <td><s:property value="sugg"/>&nbsp;</td>
     </tr>
     </s:iterator>
  </table>
   
  </body>
</html>
