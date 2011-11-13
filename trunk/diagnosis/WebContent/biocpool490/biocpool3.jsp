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
    
    <title>3系列生化池</title>
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
	  <h2> 3系列生化池</h2>
<div id="login">
<s:form action="wwdcsdataaction.action">
<table width="300" align="center" style="margin-left:30">
<tr>
	<td align="center"><s:textfield size="17" label="3#鼓风机分量" name="wwdcsdata.ITEM102" /></td>
	</tr>
	<tr>
	<tr>
	<td align="center"><s:textfield size="17" label="5号生化池PH" name="wwdcsdata.ITEM9" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="5号生化池温度" name="wwdcsdata.ITEM245" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="5号生化池A段溶解氧DO" name="wwdcsdata.ITEM1" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="5号生化池4段溶解氧DO" name="wwdcsdata.ITEM40" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="5号生化池6段溶解氧DO" name="wwdcsdata.ITEM44" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="6号生化池PH" name="wwdcsdata.ITEM10" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="6号生化池温度" name="wwdcsdata.ITEM246" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="6号生化池A段溶解氧DO" name="wwdcsdata.ITEM2" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="6号生化池4段溶解氧DO" name="wwdcsdata.ITEM41" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="6号生化池6段溶解氧DO" name="wwdcsdata.ITEM45" /></td>
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
