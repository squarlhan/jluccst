<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <s:form name="editForm" action="toAddDemoAction.action" theme="simple">
    	<table border="1">
    		<tr>
    			<td colspan="2" style="color:red">
	    			<s:property value="initString"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    			名称：
    			</td>
    			<td>
    			<s:textfield id="txt_name" name="demoModel.name"/>
    			</td>
    		</tr>
    		
    		<tr>
    			<td>
    			年龄：
    			</td>
    			<td>
    			<s:textfield id="txt_age" name="demoModel.age"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<s:submit id="btn_save" value="保存"></s:submit>
    			</td>
    		</tr>
    	</table>
	</s:form>
  </body>
</html>
