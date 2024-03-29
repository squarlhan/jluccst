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
		<script type="text/javascript" src="<%=basePath%>js/jquery-formatcurrency.js"></script>
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _customer_submit = {
				rules: {
					"weeklyItemInfo.sellDutyId":{required:true,strangecode:true},
					"weeklyItemInfo.weekResult":{required:true,strangecode:false}
				},messages:{
					"weeklyItemInfo.sellDutyId":
					{
					    required:"请选择职责类型！",
					    strangecode:"职责类型包含特殊字符！"
					},
					"weeklyItemInfo.weekResult":
					{
					    required:"结果定义为必填项！",
					    strangecode:"结果定义中包含特殊字符！"
					}
				}
			};
			
			function onlyNumbers(id) {
				re = /^\d+\.?\d*$/;
				var str = $("#"+id).val();
				if(str!=""){
					if (!re.test(str)) {
						$("#"+id).focus();
						$("#"+id).select();
						return false;
					}else{
						return true;
					}
				}else{
					return true;
				}
			}
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
		  		$.fn.close();
		  		//选中职责事件
		  		$("#sel_sellDuty").change(function(){
		  			var  dutyId= $("#sel_sellDuty option:selected").val();
		  			
		  			if($(".hid_idNumberTypeId").length!=0 ){
		  				$(".hid_idNumberTypeId").each(function(){
		  					if($(this).val()==dutyId){
		  						if($("#mydiv").length==0){
				  					$("#myspan").append('<span id="mydiv"><strong>额度：</strong><input type="text" name="weeklyItemInfo.sellTarget" maxlength="25" value="" id="txt_sellTarget" style="width: 160px;" class="currenciesOnly"/>元</span>');
				  				}else{
				  					$("#mydiv").show();
				  				}
		  					}else{
		  						$("#mydiv").remove();
		  					}
		  				});
		  			}
		  		});
		  	});
			
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
		 
		<fieldset style="margin-top: 15px">
				<legend><b><strong><font color="red">【周计划】</font></strong></b></legend>
				<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px"  nowrap="nowrap">
						<strong>职责类型：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF"  colspan="4">
					<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();">
						<s:select tabindex="-1"  id="sel_sellDuty"   name="weeklyItemInfo.sellDutyId" list="sellDutyList"  listKey="id"  listValue="name"  cssStyle="width: 160px;" headerKey="" headerValue="----请选择---" ></s:select>
						<span id="myspan">
							<s:iterator value="sellDutyList" status="obj">
								<s:if test="numberType==true">
									<s:hidden name="id" cssClass="hid_idNumberTypeId"></s:hidden>
								</s:if>
								<s:if test="id==weeklyItemInfo.sellDutyId &&  numberType==true">
									<span id="mydiv"><strong>额度：</strong><s:textfield  tabindex="-1"  id="txt_sellTarget" name="weeklyItemInfo.sellTarget" cssStyle="width: 160px;"  cssClass="currenciesOnly"  maxlength="25"></s:textfield>元</span>
								</s:if>
							</s:iterator>
						</span>
						</span>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>结果定义：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea readonly="true"  tabindex="-1"  id="txt_weekResult" name="weeklyItemInfo.weekResult" cssStyle="width: 630px;height:100px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周一：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea readonly="true"  tabindex="-1"  id="txt_monday" name="weeklyItemInfo.monday" cssStyle="width: 630px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周二：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF"  colspan="4">
						<s:textarea readonly="true"  tabindex="-1"  id="txt_tuesday" name="weeklyItemInfo.tuesday" cssStyle="width: 630px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周三：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea readonly="true"  tabindex="-1"  id="txt_wednesday" name="weeklyItemInfo.wednesday" cssStyle="width: 630px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周四：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea readonly="true"  tabindex="-1"  id="txt_thursday" name="weeklyItemInfo.thursday" cssStyle="width: 630px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周五：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea readonly="true"  tabindex="-1"  id="txt_friday" name="weeklyItemInfo.friday" cssStyle="width: 630px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周六：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea readonly="true"  tabindex="-1"  id="txt_saturday" name="weeklyItemInfo.saturday" cssStyle="width: 630px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>周日：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea readonly="true"  tabindex="-1"  id="txt_sunday" name="weeklyItemInfo.sunday" cssStyle="width: 630px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				</table>
		</fieldset>
		
		<fieldset style="margin-top: 15px">
				<legend><b><strong><font color="red">【周报】</font></strong></b></legend>
				<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px"  nowrap="nowrap">
						<strong>实际结果：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea readonly="true"  tabindex="-1"  id="txt_superiorResult" name="weeklyItemInfo.superiorResult" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" nowrap="nowrap">
						<strong>延期原因：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea readonly="true"  tabindex="-1"   id="txt_superiorReason" name="weeklyItemInfo.superiorReason" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" nowrap="nowrap">
						<strong>改进措施：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea readonly="true"  tabindex="-1"  id="txt_superiorMethod" name="weeklyItemInfo.superiorMethod" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
							<strong>执行基金：</strong>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF" >
							<s:textfield readonly="true"   tabindex="-1"  id="txt_executeMoney" name="weeklyItemInfo.executeMoney" cssStyle="width: 250px;" maxlength="25"></s:textfield>
						</td>
					</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF"  nowrap="nowrap">
						<strong>新结果定义：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF"  colspan="4">
						<s:textarea readonly="true"  tabindex="-1"   id="txt_checkerResult" name="weeklyItemInfo.checkerResult" cssStyle="width: 630px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>备注：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea readonly="true"  tabindex="-1"  id="txt_memo" name="weeklyItemInfo.memo" cssStyle="width: 630px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
			</table>
		</fieldset>
		<div align="center" style="height: 50px;vertical-align: middle;">
			<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
		</div>
	</s:form>
</body>
</html>
