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
					"timePlan.submitTime":{required:true,strangecode:true},
					"timePlan.planContent":{required:true,strangecode:false},
					"timePlan.memo":{strangecode:true}
				}
			};
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
				
				if($("#sel_planType").val()==0){
					$("#aa").html("今日总结：");
					$("#bb").html("明日计划：");
				}
				if($("#sel_planType").val()==1){
					$("#aa").html("本周总结：");
					$("#bb").html("下周计划：");
				}
				if($("#sel_planType").val()==2){
					$("#aa").html("本月总结：");
					$("#bb").html("下月计划：");
				}
				
				$("#sel_planType").change(function(){
					if($("#sel_planType").val()==0){
						$("#aa").html("今日总结：");
						$("#bb").html("明日计划：");
					}
					if($("#sel_planType").val()==1){
						$("#aa").html("本周总结：");
						$("#bb").html("下周计划：");
					}
					if($("#sel_planType").val()==2){
						$("#aa").html("本月总结：");
						$("#bb").html("下月计划：");
					}
				});
				
				if($("#hid_message").val()!="" && $("#hid_timePlanId").val()!=null){
					alert($("#hid_message").val());
				}
				if($("#hid_timePlanId").val()==null || $("#hid_timePlanId").val()==""){
					$('#txt_submitTime').val((new Date()).getFullYear()+"-"+(((new Date()).getMonth()+1)<10 ? "0"+((new Date()).getMonth()+1) : (new Date()).getMonth()+1)+"-"+((new Date()).getDate()<10 ? "0"+(new Date()).getDate() : (new Date()).getDate()));
					//日期控件
					$('#txt_submitTime').datetimepicker({showTimepicker: false});
				}
		  		
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
		  		$.fn.reference();
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
					if( $.trim( $("#hid_timePlanId").val() ) != ""){
						form1.action = "modifyTimePlanAction.action";
					}else{
		               	form1.action = "addTimePlanAction.action";					
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
			
			$.fn.reference = function(){
				$("#referenceBtn").click(function() {
		            form1.action = "openAddTimePlanAction.action?reference=true";					
	               	form1.submit();
          		});
          	};
			
		</script>
	</head>

<body>
	<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="hid_message" name="message"></s:hidden>
		<s:hidden id="hid_timePlanId" name="timePlan.id"></s:hidden>
		<s:hidden id="hid_employeeName" name="timePlan.employeeName"></s:hidden>
		<s:hidden id="hid_deptName" name="timePlan.deptName"></s:hidden>
		<s:hidden id="hid_timePlanCreateTime" name="timePlan.createTime"></s:hidden>
		<s:hidden id="hid_personId" name="timePlan.personId"></s:hidden>
		<s:hidden id="hid_organId" name="timePlan.organId"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>提交人：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"> 
												<s:select tabindex="-1" id="sel_employee"   name="timePlan.employeeId" list="userList"  listKey="id"  listValue="userCName"  cssStyle="width: 160px;" ></s:select>
											</span>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>所属部门：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"> 
												<s:select tabindex="-1" id="sel_dept"  name="timePlan.deptId" list="deptList" listKey="id"  listValue="deptName" cssStyle="width: 160px;" ></s:select>
											</span>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>计划类型：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"> 
												<s:select tabindex="-1" id="sel_planType"  name="timePlan.planType"  list="#{0:'日计划',1:'周报',2:'月报' }"  cssStyle="width: 160px;" ></s:select>
											</span>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong >提交日期：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:if test='timePlan.id==null'>
												<s:textfield id="txt_submitTime" name="timePlan.submitTime" cssStyle="width: 160px;" maxlength="25"></s:textfield>
												<font color="red">*</font>
											</s:if>
											<s:else>
												<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"> 
													<s:textfield tabindex="-1" id="txt_submitTime" name="timePlan.submitTime" cssStyle="width: 160px;" maxlength="25"></s:textfield>
												</span>
											</s:else>
										</td>
									</tr>
									
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong id="aa">今日总结：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="3">
											<s:textarea  id="txt_memo" name="timePlan.memo" cssStyle="width: 438px;height:100px;resize:none;" maxlength="500"></s:textarea>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong  id="bb">明日计划：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="3">
											<s:textarea  id="txt_planContent" name="timePlan.planContent" cssStyle="width: 438px;height:100px;resize:none;" maxlength="500"></s:textarea>
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" colspan="4" align="center" bgcolor="#FFFFFF">
											<s:if test="timePlan.id==null">
												<input name="referenceBtn" type="button" class="btn_5" id="referenceBtn" value="参考上次计划">&nbsp;&nbsp;
											</s:if>
											<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="保存">
											&nbsp;&nbsp;
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
