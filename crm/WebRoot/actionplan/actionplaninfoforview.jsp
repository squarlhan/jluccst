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
		<title>行动管理维护</title>
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
					"actionPlan.submitTime":{required:true,strangecode:true},
					"actionPlan.planContent":{required:true,strangecode:true},
					"actionPlan.memo":{strangecode:true}
				}
			};
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
				if($("#hid_message").val()!="" && $("#hid_actionPlanId").val()!=null){
					alert($("#hid_message").val());
				}
				$('#txt_submitTime').val((new Date()).getFullYear()+"-"+(((new Date()).getMonth()+1)<10 ? "0"+((new Date()).getMonth()+1) : (new Date()).getMonth()+1)+"-"+((new Date()).getDate()<10 ? "0"+(new Date()).getDate() : (new Date()).getDate()));
		  		//日期控件
				$('#txt_submitTime').datetimepicker({showTimepicker: false});
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
					if( $.trim( $("#hid_actionPlanId").val() ) != ""){
						form1.action = "modifyActionPlanAction.action";
					}else{
		               	form1.action = "addActionPlanAction.action";					
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
		<s:hidden id="hid_actionPlanId" name="actionPlan.id"></s:hidden>
		<s:hidden id="hid_employeeName" name="actionPlan.employeeName"></s:hidden>
		<s:hidden id="hid_deptName" name="actionPlan.deptName"></s:hidden>
		<s:hidden id="hid_actionPlanCreateTime" name="actionPlan.createTime"></s:hidden>
		<s:hidden id="hid_personId" name="actionPlan.personId"></s:hidden>
		<s:hidden id="hid_organId" name="actionPlan.organId"></s:hidden>
		
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
								<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"> 
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
											<strong>员工姓名：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:select tabindex="-1" id="sel_employee"   name="actionPlan.employeeId" list="userList"  listKey="id"  listValue="userCName"  cssStyle="width: 160px;" ></s:select>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
											<strong>所属部门：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:select tabindex="-1"  id="sel_dept"  name="actionPlan.deptId" list="deptList" listKey="id"  listValue="deptName" cssStyle="width: 160px;" ></s:select>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
											<strong>行动类型：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:select id="sel_planType"  name="actionPlan.planType"  list="#{3:'跟进',4:'回访' }"  cssStyle="width: 160px;" ></s:select>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
											<strong>提交日期：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield tabindex="-1"  id="txt_submitTime" name="actionPlan.submitTime" cssStyle="width: 160px;" maxlength="25"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>总结：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="3">
											<s:textarea tabindex="-1"   id="txt_memo" name="actionPlan.memo" cssStyle="width: 438px;height:100px;resize:none;" maxlength="500"></s:textarea>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
											<strong>计划内容：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="3">
											<s:textarea tabindex="-1"   id="txt_planContent" name="actionPlan.planContent" cssStyle="width: 438px;height:100px;resize:none;" maxlength="500"></s:textarea>
										</td>
									</tr>
									
									</span>
									<tr>
										<td height="26" colspan="4" align="center" bgcolor="#FFFFFF">
											<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
		</s:form>
</body>
</html>
