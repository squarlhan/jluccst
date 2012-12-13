<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author yangGY
 * @version 1.0
 * @audit  
 */
/**
 * Modified Person：
 * Modified Time：
 * Modified Explain：
 */
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>时间管理维护</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
		<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _customer_submit = {
				rules: {
					"weeklyItemInfo.sellDutyId":{required:true,strangecode:true},
					"weeklyItemInfo.monthResult":{required:true,strangecode:false}
				}
			};
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
				if($("#hid_message").val()!="" && $("#hid_Id").val()!=null){
					alert($("#hid_message").val());
					parent.$("#windown-close").click();
				}
		  		//日期控件
				$('#txt_planInterzone_begin').datetimepicker({showTimepicker: false});
				$('#txt_planInterzone_end').datetimepicker({showTimepicker: false});
				$.validator.setDefaults({
					debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
				    errorPlacement:function(error, element) {},
					invalidHandler: function(form, validator) {
			        	$.each(validator.invalid,function(key,value){
			            	alert(value);document.getElementById(key).focus();return false;
			        	}); 
			    	}
				});
				$.fn.save();
		  		$.fn.close();
		  	});
			/**
		  	 * 保存
		  	 */
			$.fn.save = function(){
				$("#addBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _customer_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
	               	var  duty= $("#sel_sellDuty option:selected").text();
	               	if(duty!=""){
	              	 	$("#hid_sellDutyName").val(duty);
	               	}else{
	               		alert("请选择职责类型！");
	               		$("#hid_sellDutyName").focus();
	               		return false;
	               	}
					if( $.trim( $("#hid_Id").val() ) != ""){
						form1.action = "modifyWeeklyItemAction.action";
					}else{
		               	form1.action = "addWeeklyItemAction.action";					
					}
	               	form1.submit();
          		});
          	};
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			parent.$("#windown-close").click();
		  		});
			};
		</script>
	</head>

<body>
	<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="hid_message" name="message"></s:hidden>
		<s:hidden id="hid_Id" name="weeklyItemInfo.id"></s:hidden>
		<s:hidden id="hid_mainInfoId" name="weeklyItemInfo.mainInfoId"></s:hidden>
		<s:hidden id="hid_sequence" name="weeklyItemInfo.sequence"></s:hidden>
		<s:hidden id="hid_sellDutyName" name="weeklyItemInfo.sellDutyName"></s:hidden>
		<fieldset >
		<legend><span style="cursor:pointer;"><strong>职责信息</strong></span></legend>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>职责类型：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:select id="sel_sellDuty"   name="weeklyItemInfo.sellDutyId" list="sellDutyList"  listKey="id"  listValue="name"  cssStyle="width: 160px;" headerKey="" headerValue="----请选择---" ></s:select><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>本周计划：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_monthResult" name="weeklyItemInfo.monthResult" cssStyle="width: 610px;height:100px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset >
		<legend><span style="cursor:pointer;"><strong>过程结果</strong></span></legend>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd" style="display:block;">
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周一：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_monday" name="weeklyItemInfo.monday" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周二：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_tuesday" name="weeklyItemInfo.tuesday" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周三：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_wednesday" name="weeklyItemInfo.wednesday" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周四：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_thursday" name="weeklyItemInfo.thursday" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周五：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_friday" name="weeklyItemInfo.friday" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周六：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_saturday" name="weeklyItemInfo.saturday" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周日：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_sunday" name="weeklyItemInfo.sunday" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
		<legend><span style="cursor:pointer;"><strong>总经理</strong></span></legend>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd" style="display:block;">
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>实际结果：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_superiorResult" name="weeklyItemInfo.superiorResult" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>实际得分：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_factScore" name="weeklyItemInfo.factScore" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>延期原因：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_superiorReason" name="weeklyItemInfo.superiorReason" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>改进措施：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_superiorMethod" name="weeklyItemInfo.superiorMethod" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
			</table>
		</fieldset>
		
		<fieldset >
		<legend><span style="cursor:pointer;"><strong>绩效相关</strong></span></legend>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd" style="display:block;">
					<tr>
						<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
							<strong>执行基金：</strong>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF">
							<s:textfield id="txt_executeMoney" name="weeklyItemInfo.executeMoney" cssStyle="width: 250px;" maxlength="25"></s:textfield>
						</td>
					</tr>
				</table>
		</fieldset>
		<fieldset>
		<legend><span style="cursor:pointer;"><strong>检查人</strong></span></legend>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd" style="display:block;">
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>下周目标：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_nextWeeklyResult" name="weeklyItemInfo.nextWeeklyResult" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>备注：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_memo" name="weeklyItemInfo.memo" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
			</table>
		</fieldset>
		<div align="center" style="height: 50px;vertical-align: middle;">
			<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="保存">&nbsp;&nbsp;
			<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
		</div>
	</s:form>
</body>
</html>