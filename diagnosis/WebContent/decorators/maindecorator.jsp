<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
response.setHeader("Pragma","No-cache");//HTTP 1.1
response.setHeader("Cache-Control","no-cache");//HTTP 1.0
response.setHeader("Expires","0");//防止被proxy
%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><decorator:title default="吉化污水处理过程模拟与优化系统" /></title>

<link href="/diagnosis/css/css.css" rel="stylesheet" type="text/css" />
<link href="/diagnosis/css/main.css" rel="stylesheet" type="text/css" />
<decorator:head />
</head>

<body>
<div id="maincontent">
<table align="center" width="1000">
	<tr>
		<td align="left" id="header"
			height="100">
		</td>
	</tr>
</table>
<table align="center" width="1000">
	<tr>
		<td valign="top">
		<div id="leftmenu">
		<page:applyDecorator page="/decorators/mainmenu.jsp" name="panel" />  
		</div>
		</td>
		<td width="100%">
		<table width="100%" height="100%">
			<tr>
				<td id="pageTitle"><!--decorator:title/--></td>
			</tr>
			<tr>
				<td valign="top" height="100%"><div id="rightmain"> <decorator:body/></div></td>
			</tr>

		</table>
		</td>
	</tr>

</table>
<table align="center" width="1000">
	<tr>
		<td id="footer">
		<div id="footer">
		   <p>使用单位: 中国石油吉林化工公司污水处理厂</p>
		   <p>COPYRIGHT&copy;2011 CNPC ALL RIGHT RESERVED</p>
		</div>
		<div id="banner"></div>
		</td>
	</tr>
</table>
</div>
</body>

</html>