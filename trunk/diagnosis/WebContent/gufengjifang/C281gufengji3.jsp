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
	  <h2>3#鼓风机</h2>
<div id="login">
<s:form action="wwdcsdataaction.action">
<table width="300" align="center" style="margin-left:30">
	
	<tr>
	<td align="center"><s:textfield size="17" label="前压力" name="wwdcsdata.ITEM188" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="后压力" name="wwdcsdata.ITEM192" /></td>
	</tr>

	<tr>
	<td align="center"><s:textfield size="17" label="增速机轴承温度" name="wwdcsdata.ITEM209" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="电机轴承温度" name="wwdcsdata.ITEM213" /></td>
	</tr>

	<td align="center"><s:textfield size="17" label="电机定子温度" name="wwdcsdata.ITEM217" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="出口管温度" name="wwdcsdata.ITEM221" /></td>
	</tr>

	<tr>
	<td align="center"><s:textfield size="17" label="入口管温度" name="wwdcsdata.ITEM225" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="润滑油管温度" name="wwdcsdata.ITEM229" /></td>
	</tr>
  <tr>
	<td align="center"><s:textfield size="17" label="冷却回水温度" name="wwdcsdata.ITEM233" /></td>
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
