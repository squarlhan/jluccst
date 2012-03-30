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
		<title>监测点参数维护</title>
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true" jfunction="true"/>
		<script type="text/javascript">
	
		/**
	  	 * 验证条件
	  	 */
		var _device_submit = {
			rules: {
				"name":{required:true,maxlength:10}
			},messages:{
				"name":
				{
					required:"参数1名称为必填项!",
					maxlength:"参数1名称最多输入10个字符!"
				}
			}
		};
		
		$(function(){
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
			
			/**
		  	 * 保存
		  	 */
			$("#addBtn").click(function() {
				var validate_settings_submit = jQuery.extend({}, _device_submit);
               	var validator = $("form").validate(validate_settings_submit);
               	if(!validator.form()){
					return false;
				}
               	var flag = true;
               	$("input[name='name']").each(function(i){
               		if($(this).val()==""){
               			alert("参数"+(i+1)+"名称为必填项!");
               			$(this).focus();
               			flag = false;
               			return false;
               		}
               		if($.trim($(this).val()).length>10){
               			alert("参数"+(i+1)+"名称最多输入10个字符!");
               			$(this).focus();
               			flag = false;
               			return false;
               		}
               	});
               	if(flag){
               		form1.submit();
               	}
           	});
			
			/**
			 * 动态添加检测点
			 */
			$("#addOtherBtn").click(function(){
				var row = $("#table1 tr:first").clone();
				var i = $("#table1 tr").length;
				row.find("strong").replaceWith("<strong>参数"+i+"名称：</strong>");
				$("#txt_pointNum").val(i);
				
				var newBtn ='<img id="delOtherBtn" name="delOtherBtn" onclick="$.fn.dynamicRemove($(this))" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>';
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
		
		/**
		 * 初始化页面元素
		 */
		$.fn.initPage = function(){
			var message = $("#lb_message").html();
			if(message!=null && $.trim(message)!="" ){
				alert(message);
			}
		}
		
		/**
		 * 删除原有非第一个检测点并移除页面元素
		 */
		$.fn.dynamicRemoveOther = function(id,obj){
			if(window.confirm("您确定要删除此参数吗？")){
				$.post("toDeletePointParamAction.action", {pointId:id}, function(data){});
				obj.parent().parent().remove();
				$.fn.columnRename();
			}
		}
		
		/**
		 * 删除原有的第一个检测点并移除页面元素
		 */
		$.fn.dynamicRemoveFirst = function(obj){
			if(window.confirm("您确定要删除此参数吗？")){
				var hiddenIdObj=$("#addOtherBtn").parent().children("input:first-child");
				var id=hiddenIdObj.val();
				$("#addOtherBtn").parent().children("input[type='hidden']").val("");
				$("#name").val("");
				$.post("toDeletePointParamAction.action", {pointId:id}, function(data){});
				obj.remove();
				$.fn.columnRename();
			}
		}
		
		/**
		 * 动态添加的元素动态移除
		 */
		$.fn.dynamicRemove = function(obj){
			if(window.confirm("您确定要删除此参数吗？")){
				obj.parent().parent().remove();
				$.fn.columnRename();
			}
		}
		/**
		 * form列头重命名
		 */
		$.fn.columnRename = function(){
			$("#table1 tr").each(function(i){
				$(this).find("strong").replaceWith("<strong>参数"+(i+1)+"名称：</strong>");
			});
		}
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple" action="toAddPointParamAction">
		<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<s:hidden id="hid_deviceId" name="device.id"></s:hidden>
		<s:hidden id="hid_pointId" name="pointId"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table id="table1" width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<s:iterator value="pointParamInfoList" status="paramInfo" step="1">
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap>
											<strong>参数<s:property value="#paramInfo.index+1"/>名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" nowrap>
											<s:hidden name="id"></s:hidden>
											<s:textfield id="name" name="name" cssStyle="width: 200px;" maxlength="15"></s:textfield><font color="red">*</font>
											<s:if test="#paramInfo.index+1==1">
												<img id="addOtherBtn"  name="addOtherBtn" src="<%=basePath%>/images/symbol-add.png" style="height:18px;width:20px;cursor:pointer" title="添加"></img>
												<s:if test='id!=null'>
													<img id="firstDelBtn" name="firstDelBtn" onclick="$.fn.dynamicRemoveFirst($(this))" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>
												</s:if>
											</s:if>
											<s:else>
												<img name="delOtherBtn" onclick="$.fn.dynamicRemoveOther('${id}',$(this));" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>
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