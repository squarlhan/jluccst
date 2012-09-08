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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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
			
			/**
			 * 动态添加检测点
			 */
			$("#addOtherBtn").click(function(){
				var row = $("#table1 tr:last").prev().clone();
				var i = $("#table1 tr").length-1;
				row.find("strong").replaceWith("<strong>检测点"+i+"名称：</strong>");
				$("#txt_pointNum").val(i);
				var previousVal = row.find("input[type='text']").val();
				var thisVal = String.fromCharCode(previousVal.charCodeAt(0)+1);
				var newBtn ='<img id="delOtherBtn" name="delOtherBtn" onclick="$.fn.dynamicRemove($(this))" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>';
				row.find("img[id='firstDelBtn']").remove();
				row.find("img[name='setParamBtn']").remove();
				row.find("img").replaceWith(newBtn); 
				row.find("input[type='hidden']").val("");
				row.find("input[type='text']").val(thisVal);
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
			var hiddenIdObj=$("#addOtherBtn").parent().children("input:first-child");
			var id=hiddenIdObj.val();
			if(id==""){
				$("#txt_pointNum").val(1);
			}
		}
		
		/**
		 * 删除原有非第一个检测点并移除页面元素
		 */
		$.fn.dynamicRemoveOther = function(id,obj){
			if(window.confirm("您确定要删除此检测点吗？")){
				$("#txt_pointNum").val($("#txt_pointNum").val()-1);
				$.post("toDeletePointAction.action", {id:id}, function(data){});
				obj.parent().parent().remove();
				$.fn.columnRename();
			}
		}
		
		/**
		 * 删除原有的第一个检测点并移除页面元素
		 */
		$.fn.dynamicRemoveFirst = function(obj){
			if(window.confirm("您确定要删除此检测点吗？")){
				var hiddenIdObj=$("#addOtherBtn").parent().children("input:first-child");
				var id=hiddenIdObj.val();
				$("#addOtherBtn").parent().children("input[type='hidden']").val("");
				$("#controlPointName").val("");
				$.post("toDeletePointAction.action", {id:id}, function(data){});
				$("#txt_pointNum").val($("#txt_pointNum").val()-1);
				obj.remove();
				$.fn.columnRename();
			}
		}
		
		/**
		 * 动态添加的元素动态移除
		 */
		$.fn.dynamicRemove = function(obj){
			if(window.confirm("您确定要删除此检测点吗？")){
				$("#txt_pointNum").val($("#txt_pointNum").val()-1);
				obj.parent().parent().remove();
				$.fn.columnRename();
			}
		}
		
		/**
		 * form列头重命名
		 */
		$.fn.columnRename = function(){
			$("#table1 tr").each(function(i){
				if(i>0){
					$(this).find("strong").replaceWith("<strong>检测点"+i+"名称：</strong>");
				}
			});
		}
		/**
		 * 检测点定位
		 */
		$.fn.setPosition =function(){
			var deviceId = $("#hid_deviceId").val();
			parent.tipsWindown("监测点定位", "iframe:datamanage/pointlist.action?deviceId=" + deviceId, "600", "473", "true", "", "true", "", "auto");
		}
		
		/**
		 * 设置检测点参数
		 */
		$.fn.setParam =function(pointId,obj){
			var deviceId = $("#hid_deviceId").val();
			tipsWindown("参数信息","iframe:openAddPointParamAction.action?device.id="+deviceId+"&pointId="+pointId,"430","260","true","","true","no");
		}
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple" action="toAddPointAction">
		<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
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
											</font><s:textfield id="txt_pointNum" value="%{pointInfoList.size}" cssStyle="width: 280px;color:red;" maxlength="10" readonly="true"></s:textfield>
										</td>
									</tr>
									
									<s:iterator value="pointInfoList" status="pointInfo" step="1">
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap>
											<strong>检测点<s:property value="#pointInfo.index+1"/>名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF" nowrap>
											<s:hidden name="id"></s:hidden>
											<s:hidden name="positionX"></s:hidden>
											<s:hidden name="positionY"></s:hidden>
											<s:textfield id="controlPointName" name="controlPointName" cssStyle="width: 280px;" maxlength="15"></s:textfield><font color="red">*</font>
											<s:if test="#pointInfo.index+1==1">
												<s:if test='id!=null'>
													<img name="setParamBtn" src="<%=basePath%>/images/item.png" style="height:18px;width:20px;cursor:pointer" title="参数" onclick="$.fn.setParam('${id}',$(this))"></img>
												</s:if>
												<img id="addOtherBtn"  name="addOtherBtn" src="<%=basePath%>/images/symbol-add.png" style="height:18px;width:20px;cursor:pointer" title="添加"></img>
												<s:if test='id!=null'>
													<img id="firstDelBtn" name="firstDelBtn" onclick="$.fn.dynamicRemoveFirst($(this))" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>
												</s:if>
											</s:if>
											<s:else>
												<img name="setParamBtn" src="<%=basePath%>/images/item.png" style="height:18px;width:20px;cursor:pointer" title="参数" onclick="$.fn.setParam('${id}',$(this))"></img>
												<img name="delOtherBtn" onclick="$.fn.dynamicRemoveOther('${id}',$(this));" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>
											</s:else>
										</td>
									</tr>
									</s:iterator>
									<tr>
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="saveBtn" type="button" class="btn_2_3" id="addBtn" value="确定">
											<input name="positionBtn" type="button" class="btn_2_3" id="positionBtn" value="定位" onclick="$.fn.setPosition()">
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