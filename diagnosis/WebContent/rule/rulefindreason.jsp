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
	if (request.getSession().getAttribute("pr") == null) {
		response.sendRedirect("prof/proflogin.jsp");
	}
%>
<base href="<%=basePath%>">

<title>智能诊断</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style> 
    .nobr br{display:none; texe-align: left;}   
    </style>

	
</head>

<body>
	<div id="rightmain">

		  <h2>智能诊断</h2>
	
	<div id="login">
		<s:form action="ruleaction"  theme="simple">
			<table width = "1080">
			    <tr>
					<td style="align:right;width:400">水质参数报警现象：</td>
					<td style="align:left;width:400">
					    <div class="nobr">
					    <s:doubleselect theme="simple" name = "result.nouns" list="#session.map.keySet()"  
					    doubleName="result.verb" doubleList="#session.map[top]" ></s:doubleselect>
					    </div>
					</td>
					<td style="align:left;width:100"><s:submit value="开始推理" theme="simple"/></td>
					<td style="align:left;width:280">&nbsp;</td>
				</tr>
			</table>
		
		</s:form>
	</div>
</div>
</body>
</html>
