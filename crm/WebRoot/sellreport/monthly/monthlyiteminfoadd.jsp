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
					"monthlyItemInfo.sellDutyId":{required:true,strangecode:true},
					"monthlyItemInfo.monthResult":{required:true,strangecode:false}
				},messages:{
					"weeklyItemInfo.sellDutyId":
					{
					    required:"请选择职责类型！",
					    strangecode:"职责类型包含特殊字符！"
					},
					"weeklyItemInfo.monthResult":
					{
					    required:"结果定义为必填项！",
					    strangecode:"结果定义中包含特殊字符！"
					}
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
		  		
		  		//选中职责事件
		  		$("#sel_sellDuty").change(function(){
		  			var  dutyId= $("#sel_sellDuty option:selected").val();
		  			if($("#hid_idNumberTypeId").length!=0 && $("#hid_idNumberTypeId").val()==dutyId){
		  				if($("#mydiv").length==0){
		  					$("#myspan").append('<span id="mydiv"><strong>额度：</strong><input type="text" name="weeklyMainInfo.sellTarget" maxlength="25" value="" id="txt_sellTarget" style="width: 160px;"/>元</span>');
		  				}else{
		  					$("#mydiv").show();
		  				}
		  			}else{
		  				$("#mydiv").remove();
		  			}
		  		});
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
						form1.action = "modifyMonthlyItemAction.action";
					}else{
		               	form1.action = "addMonthlyItemAction.action";					
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
		<s:hidden id="hid_Id" name="monthlyItemInfo.id"></s:hidden>
		<s:hidden id="hid_mainInfoId" name="monthlyItemInfo.mainInfoId"></s:hidden>
		<s:hidden id="hid_sequence" name="monthlyItemInfo.sequence"></s:hidden>
		<s:hidden id="hid_sellDutyName" name="monthlyItemInfo.sellDutyName"></s:hidden>
		
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="120px" nowrap="nowrap">
						<strong>职责类型：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF"  colspan="4">
						<s:select id="sel_sellDuty"   name="monthlyItemInfo.sellDutyId" list="sellDutyList"  listKey="id"  listValue="name"  cssStyle="width: 160px;" headerKey="" headerValue="----请选择---" ></s:select><font color="red">*</font>
						 <span id="myspan">
							<s:iterator value="sellDutyList" status="obj">
								<s:if test="numberType==true">
									<s:hidden id="hid_idNumberTypeId" name="id"></s:hidden>
								</s:if>
								<s:if test="id==monthlyItemInfo.sellDutyId &&  numberType==true">
									<span id="mydiv"><strong>额度：</strong><s:textfield id="txt_sellTarget" name="monthlyItemInfo.sellTarget" cssStyle="width: 160px;" maxlength="25"></s:textfield>元</span>
								</s:if>
							</s:iterator>
						</span>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>结果定义：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea  id="txt_monthResult" name="monthlyItemInfo.monthResult" cssStyle="width: 610px;height:100px;resize:none;" maxlength="500"></s:textarea><font color="red">*</font>
					</td>
				</tr>

				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>第一周：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_firstWeek" name="monthlyItemInfo.firstWeek" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px"  nowrap="nowrap">
						<strong>第二周：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_secondWeek" name="monthlyItemInfo.secondWeek" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>第三周：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_thirdWeek" name="monthlyItemInfo.thirdWeek" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>第四周：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_fourthWeek" name="monthlyItemInfo.fourthWeek" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>实际结果：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_superiorResult" name="monthlyItemInfo.superiorResult" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" nowrap="nowrap">
						<strong>实际得分：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_factScore" name="monthlyItemInfo.factScore" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>延期原因：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_superiorReason" name="monthlyItemInfo.superiorReason" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>改进措施：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" >
						<s:textarea  id="txt_superiorMethod" name="monthlyItemInfo.superiorMethod" cssStyle="width: 250px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<!-- 
					<tr>
						<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
							<strong>KPI：</strong>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF" >
							<s:textfield id="txt_kpi" name="monthlyItemInfo.kpi" cssStyle="width: 250px;" maxlength="25"></s:textfield>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
							<strong>KPI公式：</strong>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF" >
							<s:textfield id="txt_kpiFormula" name="monthlyItemInfo.kpiFormula" cssStyle="width: 250px;" maxlength="25"></s:textfield>
						</td>
					</tr>
					<tr>
						<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
							<strong>标准绩效：</strong>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF" >
							<s:textfield id="txt_standardPerformance" name="monthlyItemInfo.standardPerformance" cssStyle="width: 250px;" maxlength="25"></s:textfield>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
							<strong>权重：</strong>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF" >
							<s:textfield id="txt_weight" name="monthlyItemInfo.weight" cssStyle="width: 250px;" maxlength="25"></s:textfield>
						</td>
					</tr>
				 -->
					<tr>
						<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
							<strong>实际绩效：</strong>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF" >
							<s:textfield id="txt_factPerformance" name="monthlyItemInfo.factPerformance" cssStyle="width: 250px;" maxlength="25"></s:textfield>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
							<strong>执行基金：</strong>
						</td>
						<td height="26" align="left" bgcolor="#FFFFFF">
							<s:textfield id="txt_executeMoney" name="monthlyItemInfo.executeMoney" cssStyle="width: 250px;" maxlength="25"></s:textfield>
						</td>
					</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px"  >
						<strong>下月目标：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea  id="txt_nextMonthlyResult" name="monthlyItemInfo.nextMonthlyResult" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
				<tr>
					<td height="26" align="left" bgcolor="#FFFFFF" width="80px" >
						<strong>备注：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="4">
						<s:textarea  id="txt_memo" name="monthlyItemInfo.memo" cssStyle="width: 610px;height:50px;resize:none;" maxlength="500"></s:textarea>
					</td>
				</tr>
			</table>
		<div align="center" style="height: 50px;vertical-align: middle;">
			<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="保存">&nbsp;&nbsp;
			<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
		</div>
	</s:form>
</body>
</html>
