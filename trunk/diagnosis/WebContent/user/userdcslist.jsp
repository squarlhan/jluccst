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
    
    <title>DCS数据</title>
    
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
	  <h2>DCS数据</h2>
	
  <table bordercolor="#FFFFFF" id="mytable" class="list_table" align="center" >
		<tr bgcolor="#4A708B">
		    <th width = "35%">故障节点</th>
			<th width = "35%">控制参数</th>
			<th width = "30%">参数值</th>
	  </tr>
    <s:iterator id="dcsdata" value="dcsdatalist" status="index1">
     <tr  align="center"  bordercolor="#FFFFFF" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
       <td><s:property value="equipment"/>&nbsp;</td>
       <td><s:property value="item"/>&nbsp;</td>
       <td style="color:<s:if test="%{#dcsdata.isok}">black</s:if><s:else>red</s:else>"><s:property value="value"/>&nbsp;</td>       
       
     </tr>
     </s:iterator>
  </table>
   
  </body>
</html>
