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
		<title>设备规则管理维护</title>
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true" jfunction="true"/>
	<script type="text/javascript">
		/**
			* 准备工作
			*/
		$(document).ready(function(){
			$.fn.initPage();
			$.fn.save();
	  		$.fn.close();
	  		$.fn.deviceTypeChange();
	  		$.fn.dynamicAddOther();
	  	});
		
		/**
	  	 * 保存
	  	 */
		$.fn.save = function(){
			//如果有id就说明是修改action
			var devicetype = $("#hid_ruleId").val();
				$("#addBtn").click(function() {
					var arry = new Array(); 
					var flag=true;
					$("select[name='ruleInfo.resultId']").each(function(i){
						if($(this).val()!=""){
							for(var j=0;j<arry.length;j++){
								if($(this).val()==arry[j]){
									alert("重复选择现象！");
									$(this).focus();
									flag=false;
									return false;
								}
							}
							arry[i]=$(this).val();
						}else{
							alert("请选择现象！");
							$(this).focus();
							flag=false;
							return false;
						}
					});
					for(var j=0;j<arry.length;j++){
						if("A"+$("#sel_reasonType").val()==arry[j]){
							alert("原因已作为现象，请重新选择原因！");
							$("#sel_reasonType").focus();
							flag=false;
						}
					}
					if(!flag){
						return false;
					}
		           	if( $.trim(devicetype) == "0" ){
		           		form1.action = "toAddRuleInfoAction.action";
		           	}
		           	else{
		           		form1.action = "toModifyRuleInfoAction.action";
		           	}
		           	$("#hid_reasonType").remove();
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
	 		
	 		//下拉列表分组
	 		
			$("select[name='ruleInfo.resultId']").each(function(i){
				var groupA="<option value=''>---请选择---</option><optgroup label='规则现象'>";
				var groupB="<optgroup label='规则原因'>";
				if($(this).prev().attr("name")=="hid_selectedResultItem"){
					var selected = $(this).prev().val();
					$(this).children("option").each(function(i){
						if($(this).val().substring(0,1)=="B"){
							if($(this).val()==selected){
								groupA = groupA+"<option selected='selected' value='"+$(this).val()+"'>"+$(this).html()+"</option>";
							}else{
								groupA = groupA+"<option value='"+$(this).val()+"'>"+$(this).html()+"</option>";
							}
						}else if($(this).val().substring(0,1)=="A"){
							if($(this).val()==selected){
								groupB = groupB+"<option selected='selected' value='"+$(this).val()+"'>"+$(this).html()+"</option>";
							}else{
								groupB = groupB+"<option value='"+$(this).val()+"'>"+$(this).html()+"</option>";
							}
						}
					 });
					 $(this).children().remove();
					 $(this).append(groupA);
					 $(this).append(groupB);
				}
			});

			$("#sel_reasonType option").each(function(){
				if($(this).val()==$("#sel_reasonType").prev().val().replace("A","")){
					$(this).attr("selected","selected");
				}
			 });
	 		
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
		
		/**
		 * 改变设备类型动作
		 */
		$.fn.deviceTypeChange = function(){
			$("#sel_deviceType").change(function(){
				var deviceTypeId =$('#sel_deviceType option:selected').attr("value");
				var url = "getDeviceTypeCascadeInfoAction.action";
				$.post(url, {deviceTypeId:deviceTypeId}, function(data){
					if(data!=null ){
						var groupA="<option value=''>---请选择---</option>";
						var groupB="";
						var advice="<option value=''>---请选择---</option>";
						var reason="<option value=''>---请选择---</option>";
						if(data.resultList!=null){
							//建议
							$.each(data.adviceList,function(i,obj){
								$("#sel_adviceType").children().remove();
								advice = advice+"<option value='"+obj.id+"'>"+obj.advice+"</option>";
								$("#sel_adviceType").append(advice);
							});
						}else{
							$("#sel_adviceType").children().remove();
							$("#sel_adviceType").append(advice);
						}
						if(data.resultList!=null){
							//现象
							$.each(data.resultList,function(i,obj){
								if(i==0){
									groupA = groupA+"<optgroup label='规则现象'>";
								}
								groupA = groupA+"<option value='B"+obj.id+"'>"+obj.result+"</option>";
							});
						}
						if(data.reasonList!=null){
							//原因
							$.each(data.reasonList,function(i,obj){
								if(i==0){
									 groupB=groupB+"<optgroup label='规则原因'>";
								}
								groupB = groupB+"<option value='A"+obj.id+"'>"+obj.reason+"</option>";
								reason= reason+"<option value='A"+obj.id+"'>"+obj.reason+"</option>";
							});
							$("#sel_reasonType").children().remove();
							$("#sel_reasonType").append(reason);
							
						}else{
							$("#sel_reasonType").children().remove();
							$("#sel_reasonType").append(reason);
						}
						$("select[name='ruleInfo.resultId']").each(function(){
							$(this).children().remove();
							$(this).append(groupA);
							if(groupB!=""){
						    	$(this).append(groupB);
							}
						});
					}else{
						$("select[name='ruleInfo.resultId']").each(function(){
							$(this).children().remove();
							$(this).append("<option value=''>---请选择---</option>");
						});
					}
				});
			});
		};
		
		/**
		 * 动态添加元素
		 */
		$.fn.dynamicAddOther =function(){
	  		$("#addOtherBtn").click(function(){
	  			$(".resultTr").eq(0).find("strong").replaceWith("<strong>现象1：</strong>");
	  			var row = $(".resultTr").eq(0).clone();
	  			var i = $(".resultTr").length;
	  			row.find("strong").replaceWith("<strong>现象"+(i+1)+"：</strong>");
	  			
	  			var newBtn ='<img id="delOtherBtn" name="delOtherBtn" onclick="$.fn.dynamicRemove($(this))" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>';
	  			row.find("select option:first").attr("selected","selected");
	  			row.find("img[id='firstDelBtn']").remove();
	  			row.find("img").replaceWith(newBtn); 
	  			row.find("input[type='hidden']").val("");
	  			$(".resultTr").eq(i-1).after(row);
	  		});
		};

		/**
		 * 删除原有非第一个检测点并移除页面元素
		 */
		$.fn.dynamicRemoveOther = function(id,obj){
			if(window.confirm("您确定要删除此参数吗？")){
				var ruleId = $("#hid_ruleId").val();
				$.post("toDeleteResultAction.action", {"resultId":id,"ruleInfo.id":ruleId}, function(data){});
				obj.parent().parent().remove();
				$.fn.columnRename();
			}
		};
		
		/**
		 * 删除原有的第一个检测点并移除页面元素
		 */
		$.fn.dynamicRemoveFirst = function(obj){
			if(window.confirm("您确定要删除此参数吗？")){
				var hiddenIdObj=$("#addOtherBtn").parent().children("input:first-child");
				var id=hiddenIdObj.val();
				var ruleId = $("#hid_ruleId").val();
				$("#addOtherBtn").parent().children("input[type='hidden']").val("");
				$("#sel_resultType").val("");
				$.post("toDeleteResultAction.action", {"resultId":id,"ruleInfo.id":ruleId}, function(data){});
				obj.remove();
				$.fn.columnRename();
			}
		};
		
		/**
		 * 动态添加的元素动态移除
		 */
		$.fn.dynamicRemove = function(obj){
			if(window.confirm("您确定要删除此参数吗？")){
				obj.parent().parent().remove();
				$.fn.columnRename();
			}
		};
		/**
		 * form列头重命名
		 */
		$.fn.columnRename = function(){
			$(".resultTr").each(function(i){
				$(this).find("strong").replaceWith("<strong>现象"+(i+1)+"：</strong>");
			});
		};
	</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple" enctype="multipart/form-data">
		<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<s:hidden id="hid_companyId" name="device.companyId"></s:hidden>
		<s:hidden id="hid_factoryId" name="device.factoryId"></s:hidden>
		<s:hidden id="hid_workshopId" name="device.workshopId"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0" cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table id="table1" width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<tr>
										<td height="26" width="80"  align="right" bgcolor="#FFFFFF">
											<strong>设备名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="txt_deviceName" name="device.deviceName" maxlength="25" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>设备类型：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:select id="sel_deviceType" list="deviceTypeList" listKey="id" listValue="typeName" headerKey="nothing" headerValue="---请选择---" name="device.deviceTypeId" cssStyle="width: 250px;"></s:select>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>监测点：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<fieldset  style="width:250px;">
												<legend>A<s:checkbox name="aa"></s:checkbox></legend>
												<span width="20px">
													<s:checkboxlist name="sds"  list="{'a','v','h'}" label="请选择你所喜欢的圣斗士"></s:checkboxlist>
												</span>
											</fieldset>
											<fieldset  style="width:250px;">
												<legend>B<s:checkbox name="aa"></s:checkbox></legend>
												<s:checkboxlist name="sds"  list="{'a','v','h'}" label="请选择你所喜欢的圣斗士"></s:checkboxlist>
											</fieldset>
										</td>
									</tr>
									
									<s:if test='true'>
						    			<tr class="resultTr">
							    			<td height="26" align="right" bgcolor="#FFFFFF">
							    				<strong>现象<s:property value="#result.index+1"/>：</strong>
							    			</td>
							    			<td height="26" align="left" bgcolor="#FFFFFF">
												<s:select id="sel_resultType" list="newResultMap" listKey="key" listValue="value" headerKey="" headerValue="---请选择---" name="ruleInfo.resultId" cssStyle="width: 250px;"></s:select>
												<s:hidden name="id"></s:hidden>
												<font color="red">*</font>
												<img id="addOtherBtn"  name="addOtherBtn" src="<%=basePath%>/images/symbol-add.png" style="height:18px;width:20px;cursor:pointer" title="添加"></img>
											</td>
							    		</tr>
						    		</s:if>
						    		<s:else>
							    		<s:iterator value="resultMap" status="result" step="1">
							    		<tr class="resultTr">
							    			<td height="26" align="right" bgcolor="#FFFFFF">
							    			<strong>现象<s:property value="#result.index+1"/>：</strong>
							    			</td>
							    			<td height="26" align="left" bgcolor="#FFFFFF">
							    			<input type="hidden" name="hid_selectedResultItem" value='${key}'/>
											<s:select id="sel_resultType" list="newResultMap" listKey="key" listValue="value" headerKey="" headerValue="---请选择---" name="ruleInfo.resultId" cssStyle="width: 250px;"></s:select>
											<font color="red">*</font>
											<input type="hidden" value="${value}"/>
											<s:if test="#result.index+1==1">
												<img id="addOtherBtn"  name="addOtherBtn" src="<%=basePath%>/images/symbol-add.png" style="height:18px;width:20px;cursor:pointer" title="添加"></img>
												<img id="firstDelBtn" name="firstDelBtn" onclick="$.fn.dynamicRemoveFirst($(this))" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>
											</s:if>
											<s:else>
												<img name="delOtherBtn" onclick="$.fn.dynamicRemoveOther('${value}',$(this));" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>
											</s:else>
											</td>
							    		</tr>
							    		</s:iterator>
									</s:else>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>原因：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:hidden id="hid_reasonType" type="hidden" name="ruleInfo.reasonId"/>
											<s:select id="sel_reasonType" list="reasonList" listKey="id" listValue="reason" headerKey="" headerValue="---请选择---" name="ruleInfo.reasonId" cssStyle="width: 250px;"></s:select>
										</td>
									</tr>
									
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>建议：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:select id="sel_adviceType" list="adviceList" listKey="id" listValue="advice" headerKey="" headerValue="---请选择---" name="ruleInfo.adviceId" cssStyle="width: 250px;"></s:select>
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