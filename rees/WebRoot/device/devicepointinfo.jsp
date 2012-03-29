<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author JiangMD
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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>设备管理维护</title>
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true" jfunction="true"/>
		<script type="text/javascript">
	
		/**
	  	 * 验证条件
	  	 */
		var _device_submit = {
			rules: {
				"controlPointName":{required:true,maxlength:10}
			},messages:{
				"controlPointName":
				{
					required:"检测点1名称为必填项!",
					maxlength:"检测点1名称最多输入10个字符!"
				}
			}
		};
		
		$(function(){
			
			$.validator.setDefaults({
	  			//验证框架的验证器的默认设置区
				debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
			    errorPlacement:function(error, element) {},
				invalidHandler: function(form, validator) {
		        	$.each(validator.invalid,function(key,value){
		            	alert(value);document.getElementById(key).focus();return false;
		        	}); 
		    	}
			})
			
			/**
		  	 * 保存
		  	 */
			
			//如果有id就说明是修改action
			$("#addBtn").click(function() {
				var validate_settings_submit = jQuery.extend({}, _device_submit);
               	var validator = $("form").validate(validate_settings_submit);
               	if(!validator.form()){
					return false;
				}
               	var flag = true;
               	$("input[name='controlPointName']").each(function(i){
               		if($(this).val()==""){
               			alert("检测点"+(i+1)+"名称为必填项!");
               			$(this).focus();
               			flag = false;
               			return false;
               		}
               		if($.trim($(this).val()).length>10){
               			alert("检测点"+(i+1)+"名称最多输入10个字符!");
               			$(this).focus();
               			flag = false;
               			return false;
               		}
               	});
               	if(flag){
               		form1.submit();
               	}
           	});
			
			$("#addOtherBtn").click(function(){
				var row = $("#table1 tr:last").prev().clone();
				var i = $("#table1 tr").length-1;
				row.find("strong").replaceWith("<strong>检测点"+i+"名称：</strong>");
				$("#txt_pointNum").val(i);
				
				var newBtn ='<img id="delOtherBtn" name="delOtherBtn" onclick="$.fn.option3($(this))" src="<%=basePath%>/images/symbol-remove.png" height="18px" width="20px"></img>';
				row.find("img[id='firstDelBtn']").remove();
				row.find("img").replaceWith(newBtn); 
				row.find("input[type='hidden']").val("");
				row.find("input[type='text']").val("");
				$("#table1 tr:last").before(row);
			});
			
			/**
			 * 关闭
			 */
			$("#closeBtn").click(function(){
	  			parent.$("#windown-close").click();
	  		});
		});
		
		$.fn.option = function(id,obj){
			$("#txt_pointNum").val($("#txt_pointNum").val()-1);
			$.post("toDeletePointAction.action", {id:id}, function(data){});
			obj.parent().parent().remove();
			/*
			if($("input[name='delOtherBtn']").length==0){
				$("#addOtherBtn").parent().append('<img id="firstDelBtn" name="firstDelBtn" onclick="$.fn.option2($(this))" src="<%=basePath%>/images/symbol-remove.png" height="18px" width="20px"></img>');
			};
			//*/
		}
		
		$.fn.option2 = function(obj){
			var hiddenIdObj=$("#addOtherBtn").parent().children("input:first-child");
			var id=hiddenIdObj.val();
			hiddenIdObj.val("");
			$("#controlPointName").val("");
			$.post("toDeletePointAction.action", {id:id}, function(data){});
			$("#txt_pointNum").val(1);
			obj.remove();
		}
		
		$.fn.option3 = function(obj){
			$("#txt_pointNum").val($("#txt_pointNum").val()-1);
			obj.parent().parent().remove();
			/*
			if($("input[name='delOtherBtn']").length==0){
				var hiddenIdObj=$("#addOtherBtn").parent().children("input:first-child");
				var id=hiddenIdObj.val();
				if(id!=""){
					//$("#addOtherBtn").parent().append('<img id="firstDelBtn" name="firstDelBtn" onclick="$.fn.option2($(this))" src="<%=basePath%>/images/symbol-remove.png" height="18px" width="20px"></img>');
				}
			};
			//*/
		}
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple" action="toAddPointAction.action">
		<s:hidden id="hid_deviceId" name="device.id"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table id="table1" width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>监测点数量：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_pointNum" name="device.deviceNum" cssStyle="width: 250px;" maxlength="10" readonly="true" value="1"></s:textfield>
										</td>
									</tr>
									
									<s:iterator value="pointInfoList" status="pointInfo" step="1">
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap>
											<strong>检测点<s:property value="#pointInfo.index+1"/>名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" nowrap>
											<s:hidden name="id"></s:hidden>
											<s:textfield id="controlPointName" name="controlPointName" cssStyle="width: 250px;" maxlength="15"></s:textfield><font color="red">*</font>
											<s:if test="#pointInfo.index+1==1">
												<img id="addOtherBtn"  name="addOtherBtn" src="<%=basePath%>/images/symbol-add.png"  height="18px" width="20px"></img>
												<s:if test='id!=null'>
													<img id="firstDelBtn" name="firstDelBtn" onclick="$.fn.option2($(this))" src="<%=basePath%>/images/symbol-remove.png" height="18px" width="20px"></img>
												</s:if>
											</s:if>
											<s:else>
												<img id="addOtherBtn" name="delOtherBtn" onclick="$.fn.option('${id}',$(this));" src="<%=basePath%>/images/symbol-remove.png" height="18px" width="20px"></img>
											</s:else>
										</td>
									</tr>
									</s:iterator>
									<tr>
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="saveBtn" type="button" class="btn_2_3" id="addBtn" value="确定">
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