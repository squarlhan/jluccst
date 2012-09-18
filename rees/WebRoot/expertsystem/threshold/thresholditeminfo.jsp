<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	/**
	 * All right reserved.
	 */
	/**
	 * @author zhuyf
	 * @version 1.0
	 * @audit  
	 */
	/**
	 * Modified Person：
	 * Modified Time：
	 * Modified Explain：
	 */
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>阈值项维护管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"/>

	<script type="text/javascript">

		/**
	  	 * 验证条件
	  	 */
		var _thresholdItem_submit = {
			rules: {
               "thresholdItem.thresholdItemName":{required:true,maxlength:20},
               "thresholdItem.dataType":{required:true}
			},messages:{
				"thresholdItem.thresholdItemName":
				{
					required:"阈值项名称为必填项！",
					maxlength:"阈值项名称最多输入20个字符！"
				},
				"thresholdItem.dataType":
				{
					required:"请选择数据类型！"
				}
			}
		};

		/**
 		* 准备工作
 		*/
		$(document).ready(function(){
			$.fn.initPage();
			
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
	  		if($("#sel_dataType").val()=="S"){
	  			$("#unit").html("mm/s");
	  		}else if($("#sel_dataType").val()=="D"){
	  			$("#unit").html("mm");
	  		}else if($("#sel_dataType").val()=="A"){
	  			$("#unit").html("mm/s2");
	  		}else{
	  			$("#unit").html("");
	  		}
	  		
	  		$("#sel_dataType").change(function(){
	  			if($(this).val()=="S"){
	  				$("#unit").html("mm/s");
	  			}
	  			if($(this).val()=="D"){
	  				$("#unit").html("mm");
	  			}
	  			if($(this).val()=="A"){
	  				$("#unit").html("mm/s2");
	  			}
	  			if($(this).val()==""){
	  				$("#unit").html("");
	  			}
	  		});

	  	});
		
		/**
	  	 * 保存
	  	 */
		$.fn.save = function(){
			
			//如果有id就说明是修改action
			var thresholdItemId = $("#hid_thresholdItemId").val();
			
				$("#addBtn").click(function() {
				var validate_settings_submit = jQuery.extend({}, _thresholdItem_submit);
               	var validator = $("form").validate(validate_settings_submit);
               	if(!validator.form()){
					return false;
				}
               	if($("#sel_threshold").val()==""){
               		alert("请选择阈值类别！");
               		$("#sel_threshold").focus();
					return false;
				}
               	if( $.trim(thresholdItemId) == "" )
               	{
               		repform.action = "toAddThresholdItemAction.action";
               	}
               	else
               	{
	               	repform.action = "toModifyThresholdItemAction.action";
               	}
               	repform.submit();
           	});
         	}
		
		/**
		 * 关闭
		 */
	 	$.fn.close = function(){
	 		$("#closeBtn").click(function(){
	  			parent.$("#windown-close").click();
	  		});
		}
		
	 	/**
		 * 初始化页面元素
		 */
		$.fn.initPage = function(){
			$("#txt_thresholdItemName").focus();
			var err = $("#lb_error").html();
			if(err!=null && $.trim(err)!="" ){
				alert(err);
			}
			var message = $("#lb_message").html();
			if(message!=null && $.trim(message)!="" ){
				alert(message);
				parent.$("#windown-close").click();
			}
		}
	</script>
</head>
<body>
	<s:form  id="repform"  theme="simple" >
		<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<s:hidden id="hid_thresholdItemId" name="thresholdItem.id"></s:hidden>
		<s:hidden id="hid_createTime" name="thresholdItem.createTime"></s:hidden>
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
											<strong>阈值项名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_thresholdItemName" name="thresholdItem.thresholdItemName" maxlength="25" cssStyle="width: 250px;"/><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>数据类型：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" nowrap="nowrap">
												<s:select id="sel_dataType" list="#{'S':'速度','D':'位移','A':'加速度'}"  headerKey="" headerValue="---请选择---" name="thresholdItem.dataType" cssStyle="width: 250px;"></s:select><font color="red">*</font>
												<b id='unit'></b>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>所属阈值：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:select id="sel_threshold" list="thresholdList" listKey="id" listValue="thresholdName" headerKey="" headerValue="---请选择---" name="thresholdItem.threshold.id" cssStyle="width: 250px;"></s:select>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>阈值项区间：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_thresholdItemExpression" name="thresholdItem.thresholdItemExpression" maxlength="25" cssStyle="width: 250px;ime-mode:disabled;" title="区间格式如： 0<X<100 ,X为阈值项名称"/><font color="red">*</font>
											<br>
											<font size="1px" color="red">区间格式如： 0&lt; X&lt; 100 ,X为阈值项名称</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>是否报警：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:checkbox id="chk_sign" name="sign" title="选中表示报警"></s:checkbox>
										</td>
									</tr>
									<tr>
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="确定">
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
		<s:if test="hasFieldErrors()">
			<s:iterator value="fieldErrors">
				<s:label id="lb_error" name="value[0]" cssStyle="display:none"></s:label>
			</s:iterator>
		</s:if>
	</s:form>
</body>
</html>

