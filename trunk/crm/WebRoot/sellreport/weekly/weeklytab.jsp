<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true" tab="true"/>
<script type="text/javascript">
<!--
	$(document).ready(function() {
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
<s:hidden id="mainInfoId" name = "mainInfoId"></s:hidden>
<!-- tab开始 -->
<div id="tt" class="tabs-container">
	<div title="周计划主信息"  style="padding: 1px; display: none;" id="main">
		<%
			String mainInfoId = request.getParameter("weeklyMainInfo.id");
			String src="openAddWeeklyMainInfoAction.action";
			if(mainInfoId!=null && !mainInfoId.equals("")){
				mainInfoId = "?mainInfoId="+mainInfoId;
				src="openModifyWeeklyMainInfoAction.action";
			}else{
				mainInfoId="";
			}
			src=src+mainInfoId;
		%>
		<iframe id="iframe1" scrolling="none" frameborder="0" style="width:100%; height:100%" src="<%=src %>" ></iframe>
	</div>
	<div title="周计划明细"  style="padding: 1px; display:none;" id="item">
		<iframe id="iframe2"  scrolling="auto" frameborder="0" style="width:100%; height:100%" src="about:blank" url="openWeeklyItemListAction.action<%=mainInfoId %>"/></iframe>
	</div>
</div>
</body>
</html>
