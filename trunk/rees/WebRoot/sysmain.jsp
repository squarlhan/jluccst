<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
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
	String path = "http://"+request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>旋转设备离线专家系统</title>
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
		,west__togglerLength_closed: 28
		,west__togglerLength_open:	 28
		,center__minHeight:		200
		,center__minWidth:		'30%'
		,spacing_closed:		8
		,spacing_open:			8
		,initClosed:			false
	});
	
	$.fn.initpage();
	//需要定时触发
	$.fn.notice();
	//定时获得通知
	window.setInterval("$.fn.notice()",15000);
});
/**
 * 初始化页面
 */
$.fn.initpage = function(){
	var err = $("#lb_error").html();
	if(err!=null && $.trim(err)!="" ){
		alert(err);
	}
	var message = $("#lb_message").html();
	if(message!=null && $.trim(message)!="" ){
		alert(message);
	}
};
/**
* 论坛通知
**/
$.fn.notice = function(){
	$.post("getNewNoticeCounts.action", function(text){
		if(text!=0)
			$.messager.show('<font color=red><strong>论坛通知</strong></font>', '<font color=green style="font-size:12px;font-weight:bold;">有新的通知，请注意查看！！！</font>');
	});
};
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
