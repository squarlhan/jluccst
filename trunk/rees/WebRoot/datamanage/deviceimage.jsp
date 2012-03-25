<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>设备图</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<j:scriptlink css="true" jquery="true" livequery="true" poshytip="true" contextmenu="true" jqueryui="true" tipswindow="true"/>
	<script type="text/javascript">
		$(function(){
			$("#picture").width("600px").height("473px").css("background","url(" + $("#picture").attr("devicePic") + ")");
			//动态绑定检测点
			$(".pointDiv").livequery(function () {
				//注册提示
				$(this).poshytip({
					className: 'tip-twitter',
					showTimeout: 0,
					showOn: 'none',
					alignTo: 'target',
					alignX: 'center',
					offsetY: 10,
					allowTipHover: true,
					fade: true
				});
				//直接显示提示
				$(this).poshytip('show');
				$(document).find("span[name='dataspan']").each(function(index,domEle){
					$.getJSON("getdataajax.action",{ paramId:$(this).attr("paramid"), selectWeek:$("#selectWeek").val(), selectYear:$("#selectYear").val() }, function(json){
						if(json.pointDataInfo!=null){
							$(domEle).html(json.pointDataInfo.dataInfo);
						}else{
							$(domEle).html("");
						}
					});
				});
			});
		});
	</script>
	<style type="text/css">
		body{ font-size: 12px; }
		div,span{ color:#ffffff; }
		.pointDiv{ width:16px; height:16px; cursor: pointer; }
		img{ border: none; }
		#picture{ position:relative; top:0px; left:0px; margin:0px; background:#ffffff; background-repeat:no-repeat; overflow:hidden; }
	</style>
</head>

<body>
	<div id="picture" deviceId="<s:property value='deviceId'/>" devicePic="${pageContext.request.contextPath}/<s:property value='deviceInfo.filePath' />">
		<s:iterator value="pointRelations" status="st">
			<div id="<s:property value="pointInfo.id"/>" class="pointDiv" style="position:absolute; top:<s:property value='pointInfo.positionY'/>px; left:<s:property value='pointInfo.positionX'/>px" title="<div><s:property value='pointInfo.controlPointName'/></div><s:iterator value="pointParamInfos">
						<div><s:property value="name"/>:<span paramid='<s:property value="id"/>' name='dataspan'>...</span></div>
						</s:iterator>">
				<img src="${pageContext.request.contextPath}/images/ico/point.png"/>
			</div>
   		</s:iterator>
	</div>
	<s:hidden name="deviceId" id="deviceId" />
	<s:hidden name="selectYear" id="selectYear" />
	<s:hidden name="selectWeek" id="selectWeek" />
</body>
</html>
