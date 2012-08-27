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
		//$('.selector').tabs({ selected: 1 });
		$("#tt").click(function(){
			$("#iframe1").attr("src","openSellRecordListAction.action");
		});
	});
	$.fn.selectTab = function(index){
		$(document).find(".tabs-inner").each(function(index,domEle){
			if(index==1){
				$(domEle).click();
			}
		});
	};
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
	<div id="tab1" title="销售记录查看"  style="padding: 1px; display: none;">
		<iframe id="iframe1" scrolling="auto" frameborder="0" style="width:100%; height:100%" src="openSellRecordListAction.action" ></iframe>
	</div>
	<div id="tab2" title="销售记录编辑"  style="padding: 1px; display: none;">
		<iframe id="iframe2"  scrolling="auto" frameborder="0" style="width:100%; height:100%" src="openAddSellRecordAction.action" ></iframe>
	</div>
</div>
</body>
</html>
