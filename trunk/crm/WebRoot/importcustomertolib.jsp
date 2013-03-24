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
					"provinceId":{required:true},
					"uploadFile":{required:true}
				},messages:{
					"provinceId":
					{
					    required:"选择省份！"
					},
					"uploadFile":
					{
					    required:"请选择文件！"
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
				$.fn.save();
		  		$.fn.close();
		  		$.fn.initpage();
		  		$("#sel_province").change(function() {
	                loadCity($("#sel_province").val());
	            });
		  	});
			function loadCity(parentid) {
                $.ajax({
                    url:"<%=basePath%>datadictionary/cityinfoservice.action?provinceId=" + parentid,
                    type: 'POST',
                    dataType: 'JSON',
                    timeout: 5000,
                    error: function() { alert('Error loading data!'); },
                    success: function(msg) {
                        $("#cityId").empty();
                        $("<option value=''>请选择...</option>").appendTo($("#cityId"));
                        $.each(eval(msg), function(i, item) {
                            $("<option value='" + item.id + "'>" + item.name + "</option>").appendTo($("#cityId"));
                        });
                    }
                });
            }
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
	               	if(confirm("您确定上传文件么？上传文件时请耐心等待，不要关闭窗口！谢谢！"))
	               	{
						form1.action = "importCustomerLib.action";
		               	form1.submit();
					}
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
		<style type="text/css">
		<!--
		.STYLE1 {
			color: #FFFFFF;
			font-weight: bold;
		}
		-->
		</style>
	</head>

	<body >
		<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td colspan="2" style="height:36px;"><table id="__01" width="100%" height="36" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="11"><img src="images/header_01.jpg" width="11" height="36" alt=""></td>
                <td background="images/header_02.jpg"><span class="STYLE1">您当前的位置：客户查找&gt;&gt;&gt;导入客户库</span></td>
                <td width="12"><img src="images/header_03.jpg" width="12" height="36" alt=""></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td valign="top" style="border-left:1px solid #54a4e3; border-bottom:1px solid #54a4e3; border-right:1px solid #54a4e3; padding:20px;">
          <s:form id="form1" name="form1" method="post" theme="simple" enctype="multipart/form-data">
			<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<fieldset  style="width:100%" >
		<legend>配置项</legend>
   		<span>
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
												<strong>选择省份名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:select id="sel_province"  name ="provinceId"  list="provinceList" listKey="id"  listValue="provinceName" cssStyle="width:230px" headerKey="" headerValue="--- 请选择 ---"></s:select>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>选择城市名称：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<select id="cityId" name="cityId" cssStyle="width:230px"></select>
											</td>
										</tr>
										<tr>
											<td height="26" align="right" bgcolor="#FFFFFF">
												<strong>选择导入文件：</strong>
											</td>
											<td height="26" align="left" bgcolor="#FFFFFF">
												<s:file name="uploadFile" id="uploadFile"/>
												<font color="red">*</font>
											</td>
										</tr>
										<tr>
											<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
												<input name="addBtn" type="button" class="btn_2_3"
													id="addBtn" value="确定">
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</span>
			</fieldset>
			<s:if test="hasFieldErrors()">
				<s:iterator value="fieldErrors">
					<s:label id="lb_error" name="value[0]" cssStyle="display:none"></s:label>
				</s:iterator>
			</s:if>
		</s:form>
          </td>
        </tr>
    </table></td>
  </tr>
</table>
	</body>
</html>