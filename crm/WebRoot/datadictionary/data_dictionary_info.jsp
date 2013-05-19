<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" jmessagebox="true" jquery="true"
			tipswindow="true" validate="true" jfunction="true" />
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _device_submit = {
				rules: {
					"dataDictionary.name":{required:true,maxlength:25},
					"dataDictionary.remark":{maxlength:50}
				},messages:{
					"dataDictionary.name":
					{
					    required:"字典名称为必填项！",
						maxlength:"字典名称最多输入25个汉字！"
					},
					"dataDictionary.remark":
					{
						maxlength:"字典说明最多50个汉字！"
					}
				}
			};
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
				
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
				$.fn.addinfo();
				$.fn.save();
		  		$.fn.close();
		  		$.fn.initpage();
		  	});
			/**
		  	 * 添加
		  	 */
			$.fn.addinfo = function(){
				//如果有id就说明是修改action
				$("#addBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _device_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
	               	form1.dictId.value = "";
					form1.name.value = $("#dictName_t").val();
					form1.remark.value = $("#remark_t").val(); 
					form1.action = "datadictionary/savedatadictionary.action";
	               	form1.submit();
	           	});
          	};
          	
			/**
		  	 * 保存
		  	 */
			$.fn.save = function(){
				//如果有id就说明是修改action
				$("#saveBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _device_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
					form1.name.value = $("#dictName_t").val();
					form1.remark.value = $("#remark_t").val(); 
					form1.action = "datadictionary/savedatadictionary.action";
	               	form1.submit();
	           	});
          	};
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			var message = $("#lb_message").html();
					if(message!=null && $.trim(message)!="" ){
					}
					parent.$("#windown-close").click();
		  		});
			};
			/**
			 * 初始化页面
			 */
			$.fn.initpage = function(){
				$("#dictName_t").focus();
				//回显上传时的错误信息
				var uploadErr = $("#lb_error").html();
				if(uploadErr!=null && $.trim(uploadErr)!="" ){
					alert(uploadErr);
				}
				
				var message = $("#lb_message").html();
				if(message!=null && $.trim(message)!="" ){
					alert(message);
				}
			};
			
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
			<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
			<s:hidden id="dictId" name="dictId"></s:hidden>
			<s:hidden id="typeFlag" name="typeFlag"></s:hidden>
			<input type="hidden" name="name" value="" />
			<input type="hidden" name="remark" value="" />
			<table width="100%" border="0" cellspacing="5" cellpadding="0">
				<tr>
					<td>
						<table width="100%" style="height: 100%;" border="0"
							cellspacing="6" cellpadding="0">
							<tr>
								<td style="height: 36px;">
									<table id="table1" width="100%" border="0" cellpadding="5"
										cellspacing="1" bgcolor="#d5e4fd">
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>字典名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:if test="userType==9">
													<s:textfield id="dictName_t" name="dataDictionary.name" maxlength="25" readonly="false" cssStyle="width: 300px;"></s:textfield>
												</s:if>
												<s:else>
													<s:if test="typeFlag==4 || typeFlag==7 || typeFlag==10">
														<s:textfield id="dictName_t" name="dataDictionary.name" maxlength="25" readonly="true" cssStyle="width: 300px;"></s:textfield>
													</s:if>
													<s:else>
														<s:textfield id="dictName_t" name="dataDictionary.name" maxlength="25" readonly="false" cssStyle="width: 300px;"></s:textfield>
													</s:else>
												</s:else>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>字典说明：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:textarea id="remark_t" name="dataDictionary.remark" style="width:300px; height:200px;"></s:textarea>
											</td>
										</tr>
										<tr>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												<s:if test="userType==9">
													<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="添加">
												</s:if>
												<s:else>
													<s:if test="typeFlag==4 || typeFlag==7 || typeFlag==10">
													</s:if>
													<s:else>										
														<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="添加">
													</s:else>
												</s:else>
												<s:if test="dictId!=null">
												<input name="saveBtn" type="button" class="btn_2_3"
													id="saveBtn" value="保存">
												</s:if>
												<input name="closeBtn" type="button" class="btn_2_3"
													id="closeBtn" value="关闭">
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<s:if test="hasFieldErrors()">
				<s:iterator value="fieldErrors">
					<s:label id="lb_error" name="value[0]" cssStyle="display:none"></s:label>
				</s:iterator>
			</s:if>
		</s:form>
	</body>
</html>