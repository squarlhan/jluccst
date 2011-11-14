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
    
    <title>4系列生化池</title>
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
	  <h2> 4系列生化池</h2>
<div id="adddata">
<s:form action="wwdcsdataaction.action">
<table width="600" align="left" style="margin-left:0">
    <tr>
	<td align="right">4#鼓风机分量</td><td><s:textfield size="17" label="4#鼓风机分量" name="wwdcsdata.ITEM103"  theme="simple"/></td>
	<td/><td/>
    </tr>
	<tr>
	<td align="right">7号生化池PH</td><td><s:textfield size="17" label="7号生化池PH" name="wwdcsdata.ITEM11"  theme="simple"/></td>
    <td align="right">8号生化池PH</td><td><s:textfield size="17" label="8号生化池PH" name="wwdcsdata.ITEM12"   theme="simple"/></td>
    </tr>
	<tr>
	<td align="right">7号生化池温度</td><td><s:textfield size="17" label="7号生化池温度" name="wwdcsdata.ITEM247"   theme="simple"/></td>
	<td align="right">8号生化池温度</td><td><s:textfield size="17" label="8号生化池温度" name="wwdcsdata.ITEM248"   theme="simple"/></td>
	</tr>
	<tr>
	<td align="right">7号生化池A段溶解氧DO</td><td><s:textfield size="17" label="7号生化池A段溶解氧DO" name="wwdcsdata.ITEM3"   theme="simple"/></td>
	<td align="right">8号生化池A段溶解氧DO</td><td><s:textfield size="17" label="8号生化池A段溶解氧DO" name="wwdcsdata.ITEM4"   theme="simple"/></td>
	</tr>
	<tr>
	<td align="right">7号生化池4段溶解氧DO</td><td><s:textfield size="17" label="7号生化池4段溶解氧DO" name="wwdcsdata.ITEM42"   theme="simple"/></td>
	<td align="right">8号生化池4段溶解氧DO</td><td><s:textfield size="17" label="8号生化池4段溶解氧DO" name="wwdcsdata.ITEM43"   theme="simple"/></td>
	</tr>
	<tr>
	<td align="right">7号生化池6段溶解氧DO</td><td><s:textfield size="17" label="7号生化池6段溶解氧DO" name="wwdcsdata.ITEM46"   theme="simple"/></td>	
	<td align="right">8号生化池6段溶解氧DO</td><td><s:textfield size="17" label="8号生化池6段溶解氧DO" name="wwdcsdata.ITEM47"   theme="simple"/></td>
	</tr>
	<tr><td></td><td/><td/><td/></tr>
	<tr/>
	<tr align="center">
	<td/>
	<td width="25%" align="center"><s:submit value="提交" theme="simple" />
	</td>
	
	<td width="25%" align="center"> <s:reset value="重置"
		theme="simple" /></td>
		<td/>
		</tr>
		</table>
	
</s:form></div>
</div>
   
  </body>
</html>
