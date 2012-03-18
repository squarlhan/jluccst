<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 * All right reserved.
	 */
	/**
	 * @author XXX
	 * @version 1.0
	 * @audit  
	 */
	/**
	 * Modified Person：
	 * Modified Time：
	 * Modified Explain：
	 */
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="style.css"" rel="stylesheet" type="text/css" />
<link href="tipswindow.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.layout-latest.js"></script>
<script type="text/javascript" src="js/external/bgiframe/jquery.bgiframe.js"></script>
<script type="text/javascript" src="js/tipswindown.js"></script>
<script type="text/javascript" src="js/jmessagebox-1.0.1.js"></script>
<script type="text/javascript" src="js/jquery.messager.js"></script>
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
		,west__togglerLength_closed: 28
		,west__togglerLength_open:	 28
		,center__minHeight:		200
		,center__minWidth:		'30%'
		,spacing_closed:		8
		,spacing_open:			8
		,initClosed:			false
		//,west__initClosed:		true
	});
});
//-->
</script>
</head>
<body>
<iframe id="topFrame" name="topFrame" class="ui-layout-north" src="systop.jsp" frameborder="0" scrolling="no"></iframe>
<iframe id="leftFrame" name="leftFrame" class="ui-layout-west" src="sysmenu.jsp" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
<iframe id="mainFrame" name="mainFrame" class="ui-layout-center" src="sysdesktop.jsp" frameborder="0" scrolling="no"></iframe>
<iframe id="bottomFrame" name="bottomFrame" class="ui-layout-south" src="sysbottom.jsp" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
</body>
</html>
