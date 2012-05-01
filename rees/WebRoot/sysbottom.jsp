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
<title></title>
<j:scriptlink css="true" jquery="true" jfunction="true"></j:scriptlink>
<SCRIPT language=javascript type=text/javascript>
/**
 * 准备工作
 */
$(document).ready(function() {
	$.fn.initpage();
	$.fn.noticepage();
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
 * 调用通知页面
 */
$.fn.noticepage = function(){
$.ajax({
	type: "get",
	url: document.getElementById("path").value + "/getNewNoticeCounts",
	beforeSend: function(XMLHttpRequest){
	//ShowLoading();
	},
	success: function(data, textStatus){
		alert(data);
	},
	complete: function(XMLHttpRequest, textStatus){
	//HideLoading();
	},
	error: function(){
	//请求出错处理
	}
	});
};
</SCRIPT>
</head>
<body>
<input type="hidden" name="path" id="path" value="<%=path%>"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="__01">
  <tr>
    <td height="26" background="images/bottombg.jpg" style="padding-left:10px;"><p><strong>版权所有：吉林大学　技术支持：吉林大学</strong></p></td>
  </tr>
</table>
</body>
</html>
