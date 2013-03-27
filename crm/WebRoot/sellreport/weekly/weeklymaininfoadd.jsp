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
					"weeklyMainInfo.planInterzoneBegin":{required:true,strangecode:true},
					"weeklyMainInfo.planInterzoneEnd":{required:true,strangecode:false}
				}
			};
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
				parent.$("#mainInfoId").val($("#hid_Id").val());
				if($("#hid_message").val()!="" && $("#hid_Id").val()!=null){
					alert($("#hid_message").val());
					var url = parent.$("#iframe2").attr("url");
					url = url+"?mainInfoId="+$("#hid_Id").val();
					parent.$("#iframe2").attr("url",url);
					parent.$.fn.showOrHideTab(1,true);
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
		  		$.fn.reference ();
		  		$.fn.selectPerson();
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
					if( $.trim( $("#hid_Id").val() ) != ""){
						form1.action = "modifyWeeklyMainInfoAction.action";
					}else{
		               	form1.action = "addWeeklyMainInfoAction.action";					
					}
	               	form1.submit();
          		});
          	};
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		 			parent.parent.$("#windown-close").click();
		  		});
			};
			
			$.fn.reference = function(){
				$("#referenceBtn").click(function() {
		            form1.action = "openAddWeeklyMainInfoAction.action?reference=true";					
	               	form1.submit();
          		});
          	};
          	
          	$.fn.selectPerson = function(){
	          	$("#sel_personId").change(function(){
	          		var personId = $("#sel_personId").val();
	          		$.ajax({
	  					type:"post",
	  					url: "queryPersonPostAction.action",
	  					data:{personId:personId,mainInfoId:'23423'},
	  					success: function(data, textStatus){
	  						try{
	  							$("#txt_position").val(data.postName);
	  						}catch(e){
	  							alert(e.description);
	  						}
	  					}
	  				});
	          	});
          	};
		</script>
	</head>

<body>
	<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="hid_message" name="message"></s:hidden>
		<s:hidden id="hid_Id" name="weeklyMainInfo.id"></s:hidden>
		<s:hidden id="hid_companyId" name="weeklyMainInfo.companyId"></s:hidden>
		<s:hidden id="hid_companyName" name="weeklyMainInfo.companyName"></s:hidden>
		<s:hidden id="hid_personName" name="weeklyMainInfo.personName"></s:hidden>
		<s:hidden id="hid_deptName" name="weeklyMainInfo.deptName"></s:hidden>
		<s:hidden id="hid_planInterzone" name="weeklyMainInfo.planInterzone"></s:hidden>
		<s:hidden id="hid_createTime" name="weeklyMainInfo.createTime"></s:hidden>
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
											<strong>计划人：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" >
											<s:select id="sel_personId"   name="weeklyMainInfo.personId" list="userList"  listKey="id"  listValue="userCName"  cssStyle="width: 160px;" ></s:select>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>职务：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="3">
											<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"> 
												<s:textfield id="txt_position" name="weeklyMainInfo.position" cssStyle="width: 160px;" maxlength="25" readonly="true"></s:textfield>
											</span>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>所属部门：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
												<s:select id="sel_dept"  name="weeklyMainInfo.deptId" list="deptList" listKey="id"  listValue="deptName" cssStyle="width: 160px;" ></s:select>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>直接上级：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="3">
											<s:textfield id="txt_superior" name="weeklyMainInfo.superior" cssStyle="width: 160px;" maxlength="25"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>计划开始时间：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" >
											<s:textfield id="txt_planInterzone_begin" name="weeklyMainInfo.planInterzoneBegin" cssStyle="width: 160px;" maxlength="25"></s:textfield>
											<font color="red">*</font>
										</td>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>计划结束时间：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="3">
											<s:textfield id="txt_planInterzone_end" name="weeklyMainInfo.planInterzoneEnd" cssStyle="width: 160px;" maxlength="25"></s:textfield>
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>检查人：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" colspan="8">
											<s:textfield id="txt_checker"  name="weeklyMainInfo.checker" cssStyle="width: 160px;" maxlength="25"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" colspan="8" align="center" bgcolor="#FFFFFF">
											<s:if test="weeklyMainInfo.id==null">
												<input name="referenceBtn" type="button" class="btn_5" id="referenceBtn" value="参考上次计划">
												&nbsp;&nbsp;
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
