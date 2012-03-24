<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	<div title="C4401乙烯压缩机组"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="pointdatalist.jsp"></iframe>
	</div>
	<div title="C4401乙烯压缩机组工艺参数"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="pointdatalist.jsp"></iframe>
	</div>
	<div title="C4601丙烯压缩机组"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="pointdatalist.jsp"></iframe>
	</div>
	<div title="C4601丙烯压缩机组工艺参数"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="pointdatalist.jsp"></iframe>
	</div>
	<div title="C4111乙烯压缩机组"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="pointdatalist.jsp"></iframe>
	</div>
	<div title="C4611丙烯压缩机组"
		style="padding: 1px; display: none;">
		<iframe scrolling="auto" frameborder="0" style="width:100%; height:100%"
			src="about:blank" url="pointdatalist.jsp"></iframe>
	</div>
</div>
</body>
</html>
