 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>净水厂设备诊断专家系统</title>
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
	  <h2>潜水排污泵</h2>
<div id="login">
<s:form action="wwdcsdataaction.action">
<table width="300" align="center" style="margin-left:30">
	<tr>
	<td align="center"><s:textfield size="17" label="1#潜水排污泵（运转）" name="wwdcsdata.ITEM174" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="1#潜水排污泵（开关）" name="wwdcsdata.ITEM175" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="2#潜水排污泵（运转）" name="wwdcsdata.ITEM176" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="2#潜水排污泵（开关）" name="wwdcsdata.ITEM177" /></td>
	</tr>
	
	
	<tr>
	<td align="center"><s:textfield size="17" label="3#潜水排污泵（运转）" name="wwdcsdata.ITEM178" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="3#潜水排污泵（开关）" name="wwdcsdata.ITEM179" /></td>
	</tr>
	
	
	


	
	</table>
	<br/>
	<table width="250" align="center" style="margin-left:30">
	<tr align="center">
	<td width="80" align="center"><s:submit value="提交" theme="simple" />
	</td>
	
	<td width="80" align="center"> <s:reset value="重置"
		theme="simple" /></td></tr></table>
</s:form></div>
</div>
   
  </body>
</html>
