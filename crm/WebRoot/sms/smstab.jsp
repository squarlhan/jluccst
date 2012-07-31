<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" jquery="true" tab="true"/>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		$("#tt").css("width",$("#groupmain",parent.document).width());
		$("#tt").css("height",$("#groupmain",parent.document).height());
		$("#tt").tabs();
		$('.selector').tabs({ ajaxOptions: { async: false } });
		$("#tt").click(function(){
			$("#iframe3").attr("src","loadSendedRecordAction.action");
		});
	});
//-->
</script>
<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>
</head>
<body>
<!-- tab开始 -->
<div id="tt" class="tabs-container">
	<div title="短信群发"  style="padding: 1px; display: none;">
		<iframe id="iframe1" scrolling="auto" frameborder="0" style="width:100%; height:100%" src="openSendInfoAction.action" ></iframe>
	</div>
	<div title="生日提醒"  style="padding: 1px; display: none;">
		<iframe id="iframe2"  scrolling="auto" frameborder="0" style="width:100%; height:100%" src="openSendInfoBeforeTimeAction.action" ></iframe>
	</div>
	<div id="a"  title="发送记录" style="padding: 1px; display: none;">
		<iframe id="iframe3"  scrolling="auto" frameborder="0" style="width:100%; height:100%" src="" ></iframe>
	</div>
</div>
</body>
</html>
