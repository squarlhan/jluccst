<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" jquery="true" corner="true" />
		<script type="text/javascript">
		<!--
		$(document).ready(function() {
			$("#closeBtn").click(function() {
				parent.$("#windown-close").click();
			});
			$(".datadiv").corner("6px");
			reloadList();
			//加载数据
			function reloadList(){
				$(document).find("input[name='datainput']").each(function(index,domEle){
					if(index==0)
						$(domEle).focus();
					$.getJSON("getdataajax.action?rnd=" + Math.random(),{pointDataId:$("#pointDataId").val(), paramId:$(domEle).attr("paramid"), selectWeek:$("#selectWeek").val(), selectYear:$("#selectYear").val() }, function(json){
						if(json.pointDataValueInfo!=null){
							$(domEle).val(json.pointDataValueInfo.dataInfo);
						}else{
							$(domEle).val("");
						}
					});
				});
			}
			$("#saveBtn").click(function() {
				if(confirm("确定要保存监测点数据吗？")){
					var str = "";
					$(document).find("input[name='datainput']").each(function(index,domEle){
						if (index == 0)
							str = str + $(domEle).attr("pointid") + '|' + $(domEle).attr("paramid") + '|' + $(domEle).val();
						else
							str = str + ',' + $(domEle).attr("pointid") + '|' + $(domEle).attr("paramid") + '|' + $(domEle).val();
					});
					$.post("savedatainfoajax.action", {status:0, deviceId:$("#deviceId").val(), selectWeek:$("#selectWeek").val(), selectYear:$("#selectYear").val(), datas:str },function(json){
						if(json.result=="OK"){
							alert("保存成功！");
						}
			    	});
				};
			});
			$("#saveOverBtn").click(function() {
				var flag = false;
				$(document).find("input[name='datainput']").each(function(index,domEle){
					if($(domEle).val()==""){
						alert("监测点数据不能为空！");
						$(domEle).focus();
						flag = true;
					}
				});
				if(flag)
					return false;
				if(confirm("确定要录入完成监测点数据了吗？")){
					var obj = $(this);
					obj.attr("disabled","disabled");
					var str = "";
					$(document).find("input[name='datainput']").each(function(index,domEle){
						if (index == 0)
							str = str + $(domEle).attr("pointid") + '|' + $(domEle).attr("paramid") + '|' + $(domEle).val();
						else
							str = str + ',' + $(domEle).attr("pointid") + '|' + $(domEle).attr("paramid") + '|' + $(domEle).val();
					});
					$.post("savedatainfoajax.action", {status:1, pointDataId:$("#pointDataId").val(),deviceId:$("#deviceId").val(), selectWeek:$("#selectWeek").val(), selectYear:$("#selectYear").val(), datas:str },function(json){
						if(json.result=="OK"){
							alert("保存成功！");
							obj.removeAttr("disabled");
						}else
						{
							alert(json.result);
							obj.removeAttr("disabled");
						}
			    	});
				};
			});
		});
		//-->
		</script>
		<style type="text/css">
		.datadiv {
			background: #6af;
		}
		</style>
	</head>
	<body style="padding: 5px;">
		<form name="form1" method="post">
			<div style="float:right">（<s:property value="dataTypeString"/>）</div>
			<div style="clear:both;"></div>
			<s:iterator value="pointRelations" status="st">
			<fieldset style="margin:3px;">
				<legend>
					<strong><s:property value="pointInfo.controlPointName"/></strong>
				</legend>
				<s:iterator value="pointParamInfos">
				<div class="datadiv" style="float: left; margin: 3px;">
					<table width="100" border="0" cellpadding="3" cellspacing="0">
						<tr>
							<td align="center" valign="bottom">
								<s:property value="name"/>
							</td>
						</tr>
						<tr>
							<td align="center" valign="top">
								<input name="datainput" type="text" size="10" maxlength="10" pointid="<s:property value='pointInfo.id'/>" paramid="<s:property value='id'/>" onKeyPress="if((event.keyCode<48 || event.keyCode>57) && event.keyCode!=46 || /\.\d\d$/.test(value))event.returnValue=false" />
							</td>
						</tr>
					</table>
				</div>
				</s:iterator>
			</fieldset>
			</s:iterator>
			<center style="padding: 5px;">
				<s:hidden name="pointDataId" id="pointDataId" />
				<s:hidden name="deviceId" id="deviceId" />
				<s:hidden name="selectYear" id="selectYear" />
				<s:hidden name="selectWeek" id="selectWeek" />
				<!-- input id="saveBtn" type="button" value="保存" class="btn_2_3" / -->
				<input id="saveOverBtn" type="button" value="录入完毕" class="btn_4" />
				<input id="closeBtn" type="button" value="关闭" class="btn_2_3" />
			</center>
		</form>
	</body>
</html>