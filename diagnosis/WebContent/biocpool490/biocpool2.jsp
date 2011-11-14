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
    
    <title>2系列生化池</title>
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
	  <h2> 2系列生化池</h2>
<div id="adddata">
<s:form action="wwdcsdataaction.action">
<table width="600" align="center" style="margin-left:30">
<tr>
    <td align="right">2#鼓风机分量</td>
	<td align="center"><s:textfield size="17" label="2#鼓风机分量" name="wwdcsdata.ITEM101" theme="simple"/></td>
	<td/>
	<td/>
	</tr>
	<tr>
	<td align="right">3号生化池PH</td>
	<td align="center"><s:textfield size="17" label="3号生化池PH" name="wwdcsdata.ITEM7" theme="simple"/></td>
	<td align="right">4号生化池PH</td>
	<td align="center"><s:textfield size="17" label="4号生化池PH" name="wwdcsdata.ITEM8" theme="simple"/></td>
	</tr>
	<tr>
	<td align="right">3号生化池温度</td>
	<td align="center"><s:textfield size="17" label="3号生化池温度" name="wwdcsdata.ITEM243" theme="simple"/></td>
	<td align="right">4号生化池温度</td>
	<td align="center"><s:textfield size="17" label="4号生化池温度" name="wwdcsdata.ITEM244" theme="simple"/></td>
	</tr>
	<tr>
	<td align="right">3号生化池2段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="3号生化池2段溶解氧DO" name="wwdcsdata.ITEM30" theme="simple"/></td>
	<td align="right">4号生化池2段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="4号生化池2段溶解氧DO" name="wwdcsdata.ITEM31" theme="simple"/></td>
	</tr>
	<tr>
	<td align="right">3号生化池3段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="3号生化池3段溶解氧DO" name="wwdcsdata.ITEM34" theme="simple"/></td>
	<td align="right">4号生化池3段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="4号生化池3段溶解氧DO" name="wwdcsdata.ITEM35" theme="simple"/></td>
	</tr>
	<tr>
	<td align="right">3号生化池5段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="3号生化池5段溶解氧DO" name="wwdcsdata.ITEM38" theme="simple"/></td>
	<td align="right">4号生化池5段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="4号生化池5段溶解氧DO" name="wwdcsdata.ITEM39" theme="simple"/></td>
	</tr>
    <tr/>
	<tr align="center">
	<td/>
	<td width="25%" align="center"><s:submit value="提交" theme="simple" />
	</td>
	
	<td width="25%" align="center"> <s:reset value="重置"
		theme="simple" /></td>
		<td/></tr></table>
</s:form></div>
</div>
   
  </body>
</html>
