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
					"ruleInfo.fuzzyCategory":{required:true},
					"ruleInfo.ifFuzzyId":{required:true},
					"ruleInfo.resultFuzzyId":{required:true,number:true}
				},messages:{
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
				$.fn.save();
		  		$.fn.close();
		  		$.fn.initpage();
		  		
		  		loadFuzzy($("#fuzzyCategory"),$("#ifFuzzyId"),0);
		  		
		  		if($("#fuzzyCategory1").val() != "")
		  		{
		  			loadFuzzy($("#fuzzyCategory1"),$("#ifFuzzyId1"),1);
		  		}
		  		if($("#fuzzyCategory2").val() != "")
		  		{
		  			loadFuzzy($("#fuzzyCategory2"),$("#ifFuzzyId2"),2);
		  		}
		  		if($("#fuzzyCategory3").val() != "")
		  		{
		  			loadFuzzy($("#fuzzyCategory3"),$("#ifFuzzyId3"),3);
		  		}
		  		if($("#fuzzyCategory4").val() != "")
		  		{
		  			loadFuzzy($("#fuzzyCategory4"),$("#ifFuzzyId4"),4);
		  		}
		  		$("#fuzzyCategory").change(function() {
	                loadFuzzy2($("#fuzzyCategory"),$("#ifFuzzyId"));
	            });
		  		
		  		$("#fuzzyCategory1").change(function() {
	                loadFuzzy2($("#fuzzyCategory1"),$("#ifFuzzyId1"));
	            });
		  		$("#fuzzyCategory2").change(function() {
	                loadFuzzy2($("#fuzzyCategory2"),$("#ifFuzzyId2"));
	            });
		  		$("#fuzzyCategory3").change(function() {
	                loadFuzzy2($("#fuzzyCategory3"),$("#ifFuzzyId3"));
	            });
		  		$("#fuzzyCategory4").change(function() {
	                loadFuzzy2($("#fuzzyCategory4"),$("#ifFuzzyId4"));
	            });
		  		function loadFuzzy(obj,obj2,num) {
	                $.ajax({
	                    url:"<%=basePath%>fuzzy/fuzzyinfoservice.action?companyId=<s:property value='companyId'/>&fuzzyCategory=" + obj.val(),
	                    type: 'POST',
	                    dataType: 'JSON',
	                    timeout: 1000,
	                    error: function(XMLHttpRequest, textStatus, errorThrown) { 
	                    	   alert(XMLHttpRequest.status);
						       alert(XMLHttpRequest.readyState);
						       alert(textStatus);
						 },
	                    success: function(msg) {
	                    	obj2.empty();
	                        $.each(eval(msg), function(i, item) {
	                            $("<option value='" + item.id + "'>" + item.name + "</option>").appendTo(obj2);
	                        });
	                        obj2.val('<s:property value="ifFuzzyId" />');
	                        
	                        if(num == 1)
	                        	obj2.val('<s:property value="ifFuzzyId1" />');
	                        if(num == 2)
	                        	obj2.val('<s:property value="ifFuzzyId2" />');
	                        if(num == 3)
	                        	obj2.val('<s:property value="ifFuzzyId3" />');
	                        if(num == 4)
	                        	obj2.val('<s:property value="ifFuzzyId4" />');
	                    }
	                });
	            }
		  		
		  		function loadFuzzy2(obj,obj2) {
	                $.ajax({
	                    url:"<%=basePath%>fuzzy/fuzzyinfoservice.action?companyId=<s:property value='companyId'/>&fuzzyCategory=" + obj.val(),
	                    type: 'POST',
	                    dataType: 'JSON',
	                    timeout: 5000,
	                    error: function() { alert('Error loading data!'); },
	                    success: function(msg) {
	                    	obj2.empty();
	                        $.each(eval(msg), function(i, item) {
	                            $("<option value='" + item.id + "'>" + item.name + "</option>").appendTo(obj2);
	                        });
	                    }
	                });
	            }
		  	});
			/**
		  	 * 保存
		  	 */
			$.fn.save = function(){
				//如果有id就说明是修改action
				$("#addBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _device_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
					form1.fuzzyName.value = $("#dictName_t").val();
					form1.action = "fuzzy/saveRule.action";
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
					parent.$("#windown-close").click();
				}
			};
			
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
			<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
			<s:hidden id="id" name="id"></s:hidden>
			<s:hidden name="companyId" />
			<input type="hidden" name="fuzzyName" value="" />
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
												<strong>模糊分类<br/>（if）</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF" id="ifCondition">
													<s:select list="categoryList" listKey="id" listValue="caption" value="ruleInfo.fuzzyCategory" 
													id="fuzzyCategory" name="ruleInfo.fuzzyCategory" cssStyle="width:150px" headerKey="" headerValue="--请选择模糊分类--"></s:select>
													<font color="red">*</font>
													&nbsp;&nbsp;模糊项：<select value="ruleInfo.ifFuzzyId" id="ifFuzzyId" name="ruleInfo.ifFuzzyId" style="width:150px" ></select>
													<font color="red">*</font>
													&nbsp;&nbsp;并且(and)
													<br/><br/>
													<s:select list="categoryList" listKey="id" listValue="caption" value="ifFuzzyCategory1" 
													id="fuzzyCategory1" name="ifFuzzyCategory1" cssStyle="width:150px" headerKey="" headerValue="--请选择模糊分类--"></s:select>
													&nbsp;&nbsp;&nbsp;&nbsp;模糊项：<select  id="ifFuzzyId1" name="ifFuzzyId1" style="width:150px" ></select>
													&nbsp;&nbsp;并且(and)
													<br/><br/>
													<s:select list="categoryList" listKey="id" listValue="caption" value="ifFuzzyCategory2" 
													id="fuzzyCategory2" name="ifFuzzyCategory2" cssStyle="width:150px" headerKey="" headerValue="--请选择模糊分类--"></s:select>
													&nbsp;&nbsp;&nbsp;&nbsp;模糊项：<select id="ifFuzzyId2" name="ifFuzzyId2" style="width:150px" ></select>
													&nbsp;&nbsp;并且(and)
													<br/><br/>
													<s:select list="categoryList" listKey="id" listValue="caption" value="ifFuzzyCategory3" 
													id="fuzzyCategory3" name="ifFuzzyCategory3" cssStyle="width:150px" headerKey="" headerValue="--请选择模糊分类--"></s:select>
													&nbsp;&nbsp;&nbsp;&nbsp;模糊项：<select  id="ifFuzzyId3" name="ifFuzzyId3" style="width:150px" ></select>
													&nbsp;&nbsp;并且(and)
													<br/><br/>
													<s:select list="categoryList" listKey="id" listValue="caption" value="ifFuzzyCategory4" 
													id="fuzzyCategory4" name="ifFuzzyCategory4" cssStyle="width:150px" headerKey="" headerValue="--请选择模糊分类--"></s:select>
													&nbsp;&nbsp;&nbsp;&nbsp;模糊项：<select id="ifFuzzyId4" name="ifFuzzyId4" style="width:150px" ></select>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>结论<br/>（then）</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:select list="listResultFuzzy" listKey="id" listValue="fuzzyName" value="ruleInfo.resultFuzzyId" 
												id="resultFuzzyId" name="ruleInfo.resultFuzzyId" cssStyle="width:150px" headerKey="" headerValue="--请选择结论--"></s:select>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												<input name="addBtn" type="button" class="btn_2_3"
													id="addBtn" value="确定">
												&nbsp;&nbsp;
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