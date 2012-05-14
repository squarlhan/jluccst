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
    
    <title>设备规则维护管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"/>

	<script type="text/javascript">
		/**
 		* 准备工作
 		*/
		$(document).ready(function(){
			$.fn.initPage();
			$("#sel_deviceType").change(function(){
				var url = "toGetRuleResultInfoAction.action";
				var deviceTypeId=$("#sel_deviceType").val();
				$.post(url, {deviceTypeId:deviceTypeId}, function(data){
					if(data!=null ){
						if( data.ruleResultInfoList!=null){
							$("#checkboxlist_td").html("");
							$.each(data.ruleResultInfoList,function(i,obj){
								$("#checkboxlist_td").append('<input type="checkbox" name="troubleIds" value="'+obj.id+'" id="troubleIds-'+obj.id+'"/><label for="troubleIds-'+obj.id+'" class="checkboxLabel">'+obj.result+'</label><br>');
							});
						}
					}
				});
			});
			
			$("#sel_thresholdCategory").change(function(){
				var url = "toGetThresholdAction.action";
				var thresholdCategoryId=$("#sel_thresholdCategory").val();
				$.post(url, {thresholdCategoryId:thresholdCategoryId}, function(data){
					if(data!=null ){
						if( data.thresholdList!=null){
							$.each(data.thresholdList,function(i,obj){
								$("#sel_threshold").append("<option value=\""+obj.id+"\">"+obj.thresholdName+"</option>");
							});
						}
					}
				});
			});
			$("#sel_threshold").change(function(){
				var url = "toGetThresholdItemAction.action";
				var thresholdId=$("#sel_threshold").val();
				$.post(url, {thresholdId:thresholdId}, function(data){
					if(data!=null ){
						if( data.thresholdItemList!=null){
							$.each(data.thresholdItemList,function(i,obj){
								$("#sel_thresholdItem").append("<option value=\""+obj.id+"\">"+obj.thresholdItemName+"</option>");
							});
						}
					}
				});
			});
			
			$.fn.save();
			$.fn.close();
		});
		
		/**
	  	 * 保存
	  	 */
		$.fn.save = function(){
			
			//如果有id就说明是修改action
			var deviceRuleId = $("#hid_deviceRuleInfoId").val();
			
			$("#addBtn").click(function() {
				var deviceType = $("#sel_deviceType").val();
				var thresholdCategory =$("#sel_thresholdCategory").val();
				var threshold =$("#sel_threshold").val();
				var thresholdItem =$("#sel_thresholdItem").val();
				
				if(deviceType==""){
					alert("请选择设备类别！");
					return false;
				}
				if(thresholdCategory==""){
					alert("请选择参考参数！");
					return false;
				}
				if(threshold==""){
					alert("请选择阈值！");
					return false;
				}
				if(thresholdItem==""){
					alert("请选择阈值范围！");
					return false;
				}
               	if( $.trim(deviceRuleId) == "" || $.trim(deviceRuleId) == "0" )
               	{
               		form1.action = "toAddDeviceRuleAction.action";
               	}
               	else
               	{
               		form1.action = "toModifyDeviceRuleAction.action";
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
		
	 	/**
		 * 初始化页面元素
		 */
		$.fn.initPage = function(){
	 		$("#sel_deviceType").focus();
			if($(".look").length>0){
				//得到checkboxlist的td,自定义td的id为checktd 
				var checktd = document.getElementById("checkboxlist_td"); 
				//得到一个checkbox数组 
				var checkboxs = checktd.getElementsByTagName("input"); 
				//最前面不需要br 从1开始 
				for ( var i = 1; i < checkboxs.length; i++) { 
					//每个br只能用一次,所以在循环内创建 
					var br = document.createElement("br"); 
					//checkbos前插入br 
					checktd.insertBefore(br, checkboxs[i]); 
				} 
				$("#readOnly").mousemove(function(){this.setCapture();});
				$("#readOnly").mouseout(function(){this.releaseCapture();});
				$("#readOnly").focus(function(){this.blur();});
			}
			var err = $("#lb_error").html();
			if(err!=null && $.trim(err)!="" ){
				alert(err);
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
	<s:form  id="form1"  theme="simple" >
		<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<s:hidden id="hid_deviceRuleInfoId" name="deviceRuleInfo.id"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table id="table1" width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<span id="readOnly">
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备类别：</strong>
										</td>
										<td height="26" align="left" colspan="3" bgcolor="#FFFFFF">
											<s:select id="sel_deviceType" list="deviceTypeList" listKey="id" listValue="typeName" headerKey="" headerValue="---请选择---" name="deviceRuleInfo.deviceTypeId" cssStyle="width: 250px;"></s:select><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>参考参数：</strong>
										</td>
										<td height="26" align="left" colspan="3" bgcolor="#FFFFFF">
											<s:select id="sel_thresholdCategory" list="thresholdCategoryList" listKey="id" listValue="categoryName" headerKey="" headerValue="---请选择---" name="deviceRuleInfo.thresholdCategoryId" cssStyle="width: 250px;"></s:select><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>阈值：</strong>
										</td>
										<td height="26" align="left" colspan="3" bgcolor="#FFFFFF">
											<s:if test="thresholdList!=null">
												<s:select id="sel_threshold" list="thresholdList" listKey="id" listValue="thresholdName" headerKey="" headerValue="---请选择---" name="deviceRuleInfo.thresholdId" cssStyle="width: 250px;"></s:select><font color="red">*</font>
											</s:if>
											<s:else>
												<select id="sel_threshold" name="deviceRuleInfo.thresholdId" style="width: 250px;">
													<option value="">---请选择---</option> 
												</select>&nbsp;<font color="red">*</font>
											</s:else>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>阈值范围：</strong>
										</td>
										<td height="26" align="left" colspan="3" bgcolor="#FFFFFF">
											<s:if test="thresholdItemList!=null">
												<s:select id="sel_thresholdItem" list="thresholdItemList" listKey="id" listValue="thresholdItemName" headerKey="" headerValue="---请选择---" name="deviceRuleInfo.thresholdItemId" cssStyle="width: 250px;"></s:select><font color="red">*</font>
											</s:if>
											<s:else>
												<select id="sel_thresholdItem" name="deviceRuleInfo.thresholdItemId" style="width: 250px;">
													<option value="">---请选择---</option> 
												</select>&nbsp;<font color="red">*</font>
											</s:else>
										</td>
									</tr>
									</span>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备故障：</strong>
										</td>
										<td height="26" align="left" colspan="3" bgcolor="#FFFFFF">
											<div id="checkboxlist_td" style="width:250px;height:100px; overflow:auto; border:0px solid;">
												<s:if test="ruleResultInfoList!=null">
													<s:checkboxlist list="ruleResultInfoList" listKey="id" listValue="result" name="troubleIds" value="_troubleIds" cssClass="look"></s:checkboxlist>
												</s:if>
												<s:else>
													<input type="hidden" id="__multiselect_form1_troubleIds" name="__multiselect_troubleIds" value=""/>
												</s:else>
											</div>
										</td>
									</tr>
									
									<tr>
										<td height="26" colspan="4" align="center" bgcolor="#FFFFFF">
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

