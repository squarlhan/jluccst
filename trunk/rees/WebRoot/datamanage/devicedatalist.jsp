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
		$("#addBtn").click(function(){
			parent.parent.tipsWindown("组织机构信息","iframe:sysmanage/groupinfo.html","400","260","true","","true","exa","no");
		});
		$("#tt").css("width",$("#groupmain",parent.document).width());
		$("#tt").css("height",$("#groupmain",parent.document).height());
		$("#tt").tabs();
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
	<s:iterator value="deviceInfos" status="st">
	<div title="<s:property value='deviceName'/>"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:95%"
			src="about:blank" url="pointdatalist.action?deviceId=<s:property value='id'/>"></iframe>
	</div>
	</s:iterator>
</div>
</body>
</html>
