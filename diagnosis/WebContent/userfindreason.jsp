<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%
	if (request.getSession().getAttribute("us") == null) {
		response.sendRedirect("userlogin.jsp");
	}
%>
<base href="<%=basePath%>">

<title>专家系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style> 
    .nobr br{display:none}   
    </style>

	
</head>

<body>
	<div id="rightmain">

		  <h2>专家系统</h2>
		<p class="STYLE1">
			<br>
		</p>
	</div>
	<br>
	<div id="login">
		<s:form action="ruleaction">
			<table width="500" align="center" >
			    <tr>
					<td align = "right">故障设备现象：</td>
					<td>
					    <div class="nobr">
					    <s:doubleselect theme="simple" name = "result.nouns" list="#session.map.keySet()"  
					    doubleName="result.verb" doubleList="#session.map[top]" ></s:doubleselect>
					    </div>
					</td>
					<td align = "left"><s:submit value="开始推理" theme="simple"/></td>
				</tr>
			</table>
		
		</s:form>
	</div>

</body>
</html>
