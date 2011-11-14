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
    
    <title>1系列生化池</title>
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
	  <h2>1系列生化池</h2>
<div id="adddata">
<s:form action="wwdcsdataaction.action">
<table width="600" align="center" style="margin-left:30">
<tr>
    <td align="right">1#鼓风机分量</td>
	<td align="center"><s:textfield size="17" label="1#鼓风机分量" name="wwdcsdata.ITEM100" theme="simple" 
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>km/h</td>
	<td/>
	<td/>
	</tr>
	<tr>
	<td align="right">1号生化池PH</td>
	<td align="center"><s:textfield size="17" label="1号生化池PH" name="wwdcsdata.ITEM5" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td></td>
	<td align="right">2号生化池PH</td>
    <td align="center"><s:textfield size="17" label="2号生化池PH" name="wwdcsdata.ITEM6" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td></td>
    </tr>
	<tr>
	<td align="right">1号生化池温度</td>
	<td align="center"><s:textfield size="17" label="1号生化池温度" name="wwdcsdata.ITEM241" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>℃</td>
	<td align="right">2号生化池温度</td>
	<td align="center"><s:textfield size="17" label="2号生化池温度" name="wwdcsdata.ITEM242" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>℃</td>
	</tr>
	<tr>
	<td align="right">1号生化池2段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="1号生化池2段溶解氧DO" name="wwdcsdata.ITEM28" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	<td align="right">2号生化池2段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="2号生化池2段溶解氧DO" name="wwdcsdata.ITEM29" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	</tr>
	<tr>
	<td align="right">1号生化池3段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="1号生化池3段溶解氧DO" name="wwdcsdata.ITEM32" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	<td align="right">2号生化池3段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="2号生化池3段溶解氧DO" name="wwdcsdata.ITEM33" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	</tr>
	<tr>
	<td align="right">1号生化池5段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="1号生化池5段溶解氧DO" name="wwdcsdata.ITEM36" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	<td align="right">2号生化池5段溶解氧DO</td>
	<td align="center"><s:textfield size="17" label="2号生化池5段溶解氧DO" name="wwdcsdata.ITEM37" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	</tr>
    
	<tr/>

	<tr align="center">
	<td width="25%"/>
	<td width="20%" align="center"><s:submit value="提交" theme="simple" /></td>
	<td width="5%"/>
	
	<td width="25%" align="center"> <s:reset value="重置" theme="simple" /></td>
	<td width="20%"/>
	<td width="5%"/>
	</tr>
	</table>
</s:form></div>
</div>
   
  </body>
</html>
