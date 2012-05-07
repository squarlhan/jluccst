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
    
    <title>阈值维护管理</title>
    
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
		var _ThresholdCategory_submit = {
			rules: {
               "threshold.thresholdName":{required:true,maxlength:20},
               "threshold.unit":{required:true,maxlength:20}
			},messages:{
				"threshold.thresholdName":
				{
					required:"阈值名称为必填项！",
					maxlength:"阈值名称最多输入20个字符！"
				},
				"threshold.unit":
				{
					required:"阈值单位为必填项！",
					maxlength:"阈值单位最多输入20个字符！"
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
			});
			$.fn.save();
	  		$.fn.close();

	  		
	  		/**
			 * 动态添加检测点
			 */
			$("#addOtherBtn").click(function(){
				var row = $(this).parent().parent().clone();
				var i = $("strong[name='area']").length+1;
				row.find("strong").eq(0).replaceWith("<strong name=\"area\">取值范围"+i+"：</strong>");
				
				
				var newBtn ='<img id="delOtherBtn" name="delOtherBtn" onclick="$.fn.dynamicRemove($(this))" src="images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>';
				row.find("img[id='firstDelBtn']").remove();
				row.find("img").replaceWith(newBtn); 
				row.find("input[type='hidden']").val("");
				row.find("input[type='text']").val("");
				
				var row2 = $(this).parent().parent().next().clone();
				row2.find("input[type='text']").val("");
				row.append(row2);
				$("#table1 tr:last").before(row);
			});
	  	});
		
		
		/**
		 * 动态添加的元素动态移除
		 */
		$.fn.dynamicRemove = function(obj){
			if(window.confirm("您确定要删除此取值范围吗？")){
				obj.parent().parent().remove();
				$.fn.columnRename();
			}
		};
		
		/**
		 * form列头重命名
		 */
		$.fn.columnRename = function(){
			$("strong[name='area']").each(function(i){
				$(this).replaceWith("<strong name=\"area\">取值范围"+(i+1)+"：</strong>");
			});
		};
		
		/**
		 * 删除原有非第一个检测点并移除页面元素
		 */
		$.fn.dynamicRemoveOther = function(id,obj){
			if(window.confirm("您确定要删除此参数吗？")){
				$.post("toDeleteCenterHeightAndSpeed.action", {centerHeightAndSpeedId:id}, function(data){});
				var row = obj.parent().parent().next();
				row.remove();
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
				$("#centerHeightAndSpeedId").val("");
				$("#txt_centerHeight").val("");
				$("#txt_speed").val("");
				$.post("toDeleteCenterHeightAndSpeed.action", {centerHeightAndSpeedId:id}, function(data){});
				obj.remove();
				$.fn.columnRename();
			}
		};
		
		/**
	  	 * 保存
	  	 */
		$.fn.save = function(){
			
			//如果有id就说明是修改action
			var ThresholdCategory = $("#hid_thresholdId").val();
			
				$("#addBtn").click(function() {
				var validate_settings_submit = jQuery.extend({}, _ThresholdCategory_submit);
               	var validator = $("form").validate(validate_settings_submit);
               	if(!validator.form()){
					return false;
				}
               	if($("#sel_thresholdCategory").val()==""){
               		alert("请选择阈值类别！");
               		$("#sel_thresholdCategory").focus();
					return false;
				}
               	if( $.trim(ThresholdCategory) == "" )
               	{
               		repform.action = "toAddThresholdAction.action";
               	}
               	else
               	{
	               	repform.action = "toModifyThresholdAction.action";
               	}
               	repform.submit();
           	});
         };
		
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
			$("#txt_thresholdName").focus();
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
		<s:hidden id="hid_thresholdId" name="threshold.id"></s:hidden>
		<s:hidden id="hid_createTime" name="threshold.createTime"></s:hidden>
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
											<strong>阈值名称：</strong>
										</td>
										<td height="26" align="left" colspan="3" bgcolor="#FFFFFF">
											<s:textfield id="txt_thresholdName" name="threshold.thresholdName" maxlength="25" cssStyle="width: 250px;"/><font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>阈值类别：</strong>
										</td>
										<td height="26" align="left" colspan="3" bgcolor="#FFFFFF">
											<s:select id="sel_thresholdCategory" list="thresholdCategoryList" listKey="id" listValue="categoryName" headerKey="" headerValue="---请选择---" name="threshold.thresholdCategory.id" cssStyle="width: 250px;"></s:select>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>阈值单位：</strong>
										</td>
										<td height="26" align="left" colspan="3" bgcolor="#FFFFFF">
											<s:textfield id="txt_thresholdUnit" name="threshold.unit" maxlength="25" cssStyle="width: 250px;"/><font color="red">*</font>
										</td>
									</tr>
									
									
									<s:iterator value="centerHeightAndSpeedList" status="centerHeightAndSpeed" step="1">
									<tr>
										<td height="26" align="right" rowspan="2" bgcolor="#FFFFFF">
											<strong name="area">取值范围<s:property value="#centerHeightAndSpeed.index+1"/>：</strong>
										</td>
										<td bgcolor="#FFFFFF" width="80px">
											<strong>中心高(H):</strong>
										</td>
										<td bgcolor="#FFFFFF">
											<s:hidden id="centerHeightAndSpeedId" name="centerHeightAndSpeedId"></s:hidden>
											<s:textfield id="txt_centerHeight" name="centerHeightExpression" maxlength="25" cssStyle="width: 150px;" title="格式为：10<H<=100"/>
										</td>
										<td rowspan="2" bgcolor="#FFFFFF">
											<s:if test="#centerHeightAndSpeed.index+1==1">
												<img id="addOtherBtn"  name="addOtherBtn" src="images/symbol-add.png" style="height:18px;width:20px;cursor:pointer" title="添加"></img>
												<s:if test='id!=null && id!=0'>
													<img id="firstDelBtn" name="firstDelBtn" onclick="$.fn.dynamicRemoveFirst($(this))" src="images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>
												</s:if>
											</s:if>
											<s:else>
												<img name="delOtherBtn" onclick="$.fn.dynamicRemoveOther('${id}',$(this));" src="images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>
											</s:else>
										</td>
									</tr>
									<tr>
										<td bgcolor="#FFFFFF">
											<strong>转速(S)：</strong>
										</td>
										<td bgcolor="#FFFFFF">
											<s:textfield id="txt_speed" name="speedExpression" maxlength="25" cssStyle="width: 150px;"  title="格式为：10<S<=100"/>
										</td>
									</tr>
									</s:iterator>
									
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

