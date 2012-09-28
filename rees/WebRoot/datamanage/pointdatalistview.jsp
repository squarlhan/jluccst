<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<j:scriptlink css="true" jquery="true" />
	<script type="text/javascript">
	<!--
	$(document).ready(function() {
		$(document).find("input[name='showdevicepic']").click(function() {
			parent.parent.parent.tipsWindown("设备图", "iframe:datamanage/deviceimage.action?deviceId=<s:property value='deviceId'/>&pointDataId=" + $(this).attr("dataId"), "600", "473", "true", "", "true", "", "auto");
		});
		//打开统计图
		$(document).find("input[name='showstat']").click(function(){
			parent.parent.parent.tipsWindown("柱状图", "iframe:datamanage/devicestat.action?deviceId=<s:property value='deviceId'/>&pointDataId=" + $(this).attr("dataId"), "700", "673", "true", "", "true", "", "auto");
		});
		//打开线状图
		$("#showstatline").click(function(){
			parent.parent.parent.tipsWindown("线状图", "iframe:datamanage/devicestatline.action?deviceId=<s:property value='deviceId'/>", "870", "673", "true", "", "true", "", "auto");
		});
		//日期选择
		$("#yearlist").change(function(){
			$.post("getweeksajax.action", {selectYear:$("#yearlist").val()},function(json){
				if(json.weekList.length>0){
					//清空下拉列表
					$("#weeklist").empty();
					for(var i=json.weekList.length-1; i>-1; i--){
						if(json.selectWeek==json.weekList[i].value)
							$("#weeklist").prepend("<option value='" + json.weekList[i].value + "' seleced='selected'>" + json.weekList[i].text + "</option>");
						else
							$("#weeklist").prepend("<option value='" + json.weekList[i].value + "'>" + json.weekList[i].text + "</option>");
					}
					window.location.href="datamanage/pointdatalistview.action?deviceId=" + $("#deviceId").val() + "&selectYear=" + $("#yearlist").val() + "&selectWeek=" + $("#weeklist").val();
				}
	    	});
		});
		//周选择
		$("#weeklist").change(function(){
			window.location.href="datamanage/pointdatalistview.action?deviceId=" + $("#deviceId").val() + "&selectYear=" + $("#yearlist").val() + "&selectWeek=" + $("#weeklist").val();
		});
		reloadList();
		//加载数据
		function reloadList(){
			$(document).find("span[name='dataspan']").each(function(index,domEle){
				var pointDataId = $(domEle).parent().parent().parent().parent().parent().attr("dataId");
				$.getJSON("getdataajax.action",{ paramId:$(this).attr("paramid"), pointDataId:pointDataId }, function(json){
					if(json.pointDataValueInfo!=null){
						$(domEle).html(json.pointDataValueInfo.dataInfo);
					}else{
						$(domEle).html("");
					}
				});
			});
		}
	});
	//-->
	</script>
	</head>
	<body>
		<form name="form1" method="post">
		<s:hidden name="pointDataId" id="pointDataId" />
		<s:hidden name="deviceId" id="deviceId" />
		<s:hidden name="selectYear" id="selectYear" />
		<s:hidden name="selectWeek" id="selectWeek" />
		<table width="100%" style="height: 100%;" border="0" cellspacing="5"
			cellpadding="0">
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="5" cellpadding="0">
						<tr>
							<td>
								日期：
								<s:select name="yearlist" id="yearlist" list="yearList" cssStyle="width:70px;" listKey="value" listValue="text" value="selectYear"></s:select>
								<s:select name="weeklist" id="weeklist" list="weekList" cssStyle="width:180px;" listKey="value" listValue="text" value="selectWeek"></s:select>
								<input id="showstatline" class="btn_4" type="button" value="查看线状图"  />
								<input class="btn_5" type="button" value="添加监测点数据" id="addpointdata" />
							</td>
							<td align="right">
								（<s:property value="dataTypeString"/>）
							</td>
						</tr>
					</table>
					<s:iterator value="pointDataInfos">
					<fieldset style="margin:3px;" dataId="<s:property value='id'/>">
						<legend>
							<strong>
								<table width="100%" border="0" cellspacing="5" cellpadding="0"><tr><td>
								<input name="showdevicepic" dataId="<s:property value='id'/>" class="btn_4" type="button" value="打开设备图" />
								<input name="showstat" dataId="<s:property value='id'/>" class="btn_4" type="button" value="查看柱状图"  />
								</td><td style="text-align:right">
								录入时间：<s:property value="creatTimeString"/>
								</td></tr></table>
							</strong>
						</legend>
						<s:iterator value="pointRelations" status="st">
	                    <table width="180" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#d5e4fd" style="float:left; margin:5px;">
							<tr>
								<td colspan="2" align="center" background="../images/headerbg.jpg">
									<strong><s:property value="pointInfo.controlPointName"/></strong>
								</td>
							</tr>
							<tr>
								<td align="center" bgcolor="#FFFFFF" style="font-size:12px;">参数</td>
								<td align="center" bgcolor="#FFFFFF" style="font-size:12px;">数据</td>
							</tr>
							<s:iterator value="pointParamInfos">
							<tr>
								<td align="center" bgcolor="#FFFFFF">
									<s:property value="name"/>
								</td>
								<td align="center" bgcolor="#FFFFFF"">
									<span paramid="<s:property value='id'/>" name="dataspan">loading...</span>
								</td>
							</tr>
							</s:iterator>
						</table>
						</s:iterator>
					</fieldset>
					</s:iterator>
			  </td>
			</tr>
		</table>
		</form>
	</body>
</html>