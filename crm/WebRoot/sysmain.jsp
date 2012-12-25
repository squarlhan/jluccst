<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = "http://"+request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="suffix"/>销售团队智能管理系统</title>
<j:scriptlink css="true" jquery="true" jquerylayout="true" tipswindow="true" jmessagebox="true" jmessager="true" />
<script type="text/javascript">
<!--
var myLayout;
$( document ).ready( function() {
	myLayout = $("body").layout({
		north__size:			121
		,north__spacing_open:	0
		,north__resizable:		false
		,south__size:			26
		,south__spacing_open:	0
		,south__resizable:		false
		,west__size:			201
		,west__minSize:			201
		,west__togglerLength_closed: 30
		,west__togglerLength_open:	 30
		,center__minHeight:		200
		,center__minWidth:		'30%'
		,spacing_closed:		8
		,spacing_open:			8
		,initClosed:			false
	});
});
//-->
</script>
</head>
<body>
<input type="hidden" name="path" id="path" value="<%=path%>"/>
<iframe id="topFrame" name="topFrame" class="ui-layout-north" src="${pageContext.request.contextPath}/logonTopAction.action" frameborder="0" scrolling="no"></iframe>
<iframe id="leftFrame" name="leftFrame" class="ui-layout-west" src="${pageContext.request.contextPath}/sysmenu.action" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
<iframe id="mainFrame" name="mainFrame" class="ui-layout-center" src="${pageContext.request.contextPath}/blank.jsp" frameborder="0" scrolling="no"></iframe>
<iframe id="bottomFrame" name="bottomFrame" class="ui-layout-south" src="${pageContext.request.contextPath}/sysbottom.action" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
</body>
</html>
