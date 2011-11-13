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
    
    <title>预处理车间其他项</title>
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
	  <h2>预处理车间其他项</h2>
<div id="login">
<s:form action="wwdcsdataaction.action">
<table width="300" align="center" style="margin-left:30">
	<tr>
	<td align="center"><s:textfield size="17" label="14b主线流量" name="wwdcsdata.ITEM111" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="466-1P466-1~4泵出口干管流量" name="wwdcsdata.ITEM112" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="466-1P466-1~4泵出口干管流量" name="wwdcsdata.ITEM113" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="495A-1-2清水泵出口干管流量" name="wwdcsdata.ITEM114" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="M414-1~5加药间溶药池液位" name="wwdcsdata.ITEM136" /></td>
	</tr><tr>
	<td align="center"><s:textfield size="17" label="水解酸化池1#水解酸化池" name="wwdcsdata.ITEM137" /></td>
	</tr><tr>
	<td align="center"><s:textfield size="17" label="水解酸化池2#水解酸化池" name="wwdcsdata.ITEM138" /></td>
	</tr>
	
	
	
	
	
	
	<tr>
	<td align="center"><s:textfield size="17" label="V495A-3药剂池液位" name="wwdcsdata.ITEM150" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="V495A-4药剂池液位" name="wwdcsdata.ITEM151" /></td>
	</tr>

	<tr>
	<td align="center"><s:textfield size="17" label="462A吸水池液位" name="wwdcsdata.ITEM152" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="水解酸化池" name="wwdcsdata.ITEM537" /></td>
	</tr>

	<td align="center"><s:textfield size="17" label="V466污泥池前液位" name="wwdcsdata.ITEM157" /></td>
	</tr>
	
	<tr>
	<td align="center"><s:textfield size="17" label="P495A-15污泥脱水间地沟液位" name="wwdcsdata.ITEM158" /></td>
	</tr>

	
	
	<tr>
	<td align="center"><s:textfield size="17" label="P495A1-2泵出口干管压力" name="wwdcsdata.ITEM184" /></td>
	</tr>
	<tr>
	<td align="center"><s:textfield size="17" label="测空压站来空气干管压力" name="wwdcsdata.ITEM199" /></td>
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
