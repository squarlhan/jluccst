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
    
    <title>修改成功</title>
    
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
	  <h2>确定录入？</h2>
<div id="login">
<s:form action="wwdcsdataaction!save.action">
<table width="200" align="center" style="margin-left:30">
	<tr>
	<td >1#鼓风机分量:  <s:property value="#session.wc.ITEM100"/></td>
	</tr>
	<tr>
	<td >1号生化池PH:  <s:property value="#session.wc.ITEM5"/></td>
	</tr>
	<tr>
	<td >2号生化池PH  <s:property value="#session.wc.ITEM6"/></td>
	</tr>
	<tr>
	<td >1号生化池温度:  <s:property value="#session.wc.ITEM241"/></td>
	</tr>
	<tr>
	<td >2号生化池温度:  <s:property value="#session.wc.ITEM242"/></td>
	</tr>
	<tr>
	<td >1号生化池2段溶解氧DO:  <s:property value="#session.wc.ITEM28"/></td>
	</tr>
	<tr>
	<td >2号生化池2段溶解氧DO:  <s:property value="#session.wc.ITEM29"/></td>
	</tr>
	<tr>
	<td >1号生化池3段溶解氧DO:  <s:property value="#session.wc.ITEM32"/></td>
	</tr>
	<tr>
	<td >2号生化池3段溶解氧DO:  <s:property value="#session.wc.ITEM33"/></td>
	</tr>
	<tr>
	<td >1号生化池5段溶解氧DO:  <s:property value="#session.wc.ITEM36"/></td>
	</tr>
	<tr>
	<td >2号生化池5段溶解氧DO:  <s:property value="#session.wc.ITEM37"/></td>
	</tr>
	
	
	
	
	</table>
	<br/>
	<table width="150" align="center">
	<tr> 
	<td width="80" align="center"><s:submit value="确定" theme="simple" />
	</td>
	
	<td width="80" align="center"> <input  type='button' onclick='javascript:history.go(-1)' value='取消' /> </td></tr></table>
</s:form></div>
</div>
   
  </body>
</html>
