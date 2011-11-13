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
    
    <title>回流泵</title>
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
	  <h2>回流泵</h2>
<div id="login">
<s:form action="wwdcsdataaction.action">
<table width="300" align="center" style="margin-left:30">
	
	<tr>
	<td align="center"><s:textfield size="17" label="前压力" name="wwdcsdata.ITEM186" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="后压力" name="wwdcsdata.ITEM190" /></td>
	</tr>

	<tr>
	<td align="center"><s:textfield size="17" label="增速机轴承温度" name="wwdcsdata.ITEM207" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="电机轴承温度" name="wwdcsdata.ITEM211" /></td>
	</tr>

	<td align="center"><s:textfield size="17" label="电机定子温度" name="wwdcsdata.ITEM215" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="出口管温度" name="wwdcsdata.ITEM219" /></td>
	</tr>

	<tr>
	<td align="center"><s:textfield size="17" label="入口管温度" name="wwdcsdata.ITEM223" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="润滑油管温度" name="wwdcsdata.ITEM227" /></td>
	</tr>
  <tr>
	<td align="center"><s:textfield size="17" label="冷却回水温度" name="wwdcsdata.ITEM231" /></td>
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
