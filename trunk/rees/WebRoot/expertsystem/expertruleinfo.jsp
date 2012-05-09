<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" jquery="true" validate="true" />
	<script type="text/javascript">
	

	/**
  	 * 验证条件
  	 */
	var _devicetype_submit = {
		rules: {
           "ruleInfo.result":{required:true}
         
          
		},messages:{
			"ruleInfo.result":
			{
				required:" 建议为必填项！"
				
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

  		/**
  		 * 动态添加检测点
  		 */
  		$("#addOtherBtn").click(function(){
  			$(".resultTr").eq(0).find("strong").replaceWith("<strong>现象1：</strong>");
  			var row = $(".resultTr").eq(0).clone();
  			var i = $(".resultTr").length;
  			row.find("strong").replaceWith("<strong>现象"+(i+1)+"：</strong>");
  			
  			var newBtn ='<img id="delOtherBtn" name="delOtherBtn" onclick="$.fn.dynamicRemove($(this))" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>';
  			row.find("img[id='firstDelBtn']").remove();
  			row.find("img").replaceWith(newBtn); 
  			row.find("input[type='hidden']").val("");
  			
  			$(".resultTr").eq(i-1).after(row);
  		});
  		
  	});
	
	/**
  	 * 保存
  	 */
	$.fn.save = function(){
		
		//如果有id就说明是修改action
		var devicetype = $("#hid_ruleId").val();
		
			$("#btn_save").click(function() {
			var validate_settings_submit = jQuery.extend({}, _devicetype_submit);
           	var validator = $("form").validate(validate_settings_submit);
           	if(!validator.form()){
				return false;
			}
           	if( $.trim(devicetype) == "0" )
           	{
           		form1.action = "toAddRuleInfoAction.action";
           	}
           	else
           	{
           		form1.action = "toModifyRuleInfoAction.action";
           	}
           	form1.submit();
       	});
     	}
	
	/**
	 * 关闭
	 */
 	$.fn.close = function(){
 		$("#btn_close").click(function(){
  			parent.$("#windown-close").click();
  		});
	};
	
 	/**
	 * 初始化页面元素
	 */
	$.fn.initPage = function(){
 		
 		//下拉列表分组
		$("select[name='ruleInfo.resultId']").each(function(){
			var groupA="<option value=''>---请选择---</option><optgroup label='规则现象'>";
			var groupB="<optgroup label='规则原因'>";
			if($(this).prev().attr("name")=="hid_selectedResultItem"){
				 $('#'+$(this).attr("id")+' option').each(function(){
					if($(this).val().substring(0,1)=="a"){
						groupA = groupA+"<option value='"+$(this).val()+"'>"+$(this).html()+"</option>";
					}else if($(this).val().substring(0,1)=="b"){
						groupB = groupB+"<option value='"+$(this).val()+"'>"+$(this).html()+"</option>";
					}
				 });
				 $(this).children().remove();
				 $(this).append(groupA);
				 $(this).append(groupB);
			}
		});
 		
 		//下拉列表回显数据
		$("select[name='ruleInfo.resultId']").each(function(){
			if($(this).prev().attr("name")=="hid_selectedResultItem"){
				 $('#'+$(this).attr("id")+' option').each(function(){
					if($(this).val()==$("input[name='hid_selectedResultItem']").val()){
						$(this).attr("selected","selected");
					}
				 });
			}
		});
 		
		$("#txt_typeName").focus();
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
	}
	/**
	 * form列头重命名
	 */
	$.fn.columnRename = function(){
		$(".resultTr").each(function(i){
			$(this).find("strong").replaceWith("<strong>现象"+(i+1)+":</strong>");
		});
	}
</script>

  
  </head>
  
  <body>
    <s:form id="form1" name="form1" method="post"  theme="simple">
    <s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<s:hidden id="hid_ruleId" name="ruleInfo.id"></s:hidden>
    	<table width="100%" border="0" cellspacing="5" cellpadding="0">
    		<tr>
    			<td colspan="2" style="color:red">
	    			<s:property value="initString"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    			设备类型
    			</td>
    			<td height="26" align="left" bgcolor="#FFFFFF">
				<s:select id="sel_deviceType" list="deviceTypeList" listKey="id" listValue="typeName" headerKey="nothing" headerValue="---请选择---" name="ruleInfo.deviceTypeId" cssStyle="width: 250px;"></s:select>
				</td>
    		</tr>
    		
    		<s:if test='ruleInfo.resultId==null || ruleInfo.resultId.equals("")'>
    			<tr class="resultTr">
	    			<td>
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
	    			<td>
	    			<strong>现象<s:property value="#result.index+1"/>：</strong>
	    			</td>
	    			<td height="26" align="left" bgcolor="#FFFFFF">
	    			<input type="hidden" name="hid_selectedResultItem" value='${key}'/>
					<s:select id="sel_resultType" list="newResultMap" listKey="key" listValue="value" headerKey="" headerValue="---请选择---" name="ruleInfo.resultId" cssStyle="width: 250px;"></s:select>
					<font color="red">*</font>
					<s:hidden name="id"></s:hidden>
					<s:if test="#result.index+1==1">
						<img id="addOtherBtn"  name="addOtherBtn" src="<%=basePath%>/images/symbol-add.png" style="height:18px;width:20px;cursor:pointer" title="添加"></img>
						<s:if test='id!=null'>
							<img id="firstDelBtn" name="firstDelBtn" onclick="$.fn.dynamicRemoveFirst($(this))" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>
						</s:if>
					</s:if>
					<s:else>
						<img name="delOtherBtn" onclick="$.fn.dynamicRemoveOther('${value}',$(this));" src="<%=basePath%>/images/symbol-remove.png" style="height:18px;width:20px;cursor:pointer" title="删除"></img>
					</s:else>
					</td>
	    		</tr>
	    		</s:iterator>
			</s:else>
    		<tr>
    			<td>
    			原因
    			</td>
    			<td height="26" align="left" bgcolor="#FFFFFF">
				<s:select id="sel_reasonType" list="reasonList" listKey="id" listValue="reason" headerKey="nothing" headerValue="---请选择---" name="ruleInfo.reasonId" cssStyle="width: 250px;"></s:select>
				</td>
    		</tr>
    		<tr>
    			<td>
    			建议
    			</td>
    			<td height="26" align="left" bgcolor="#FFFFFF">
				<s:select id="sel_adviceType" list="adviceList" listKey="id" listValue="advice" headerKey="nothing" headerValue="---请选择---" name="ruleInfo.adviceId" cssStyle="width: 250px;"></s:select>
				</td>
    		</tr>
    		
    		<tr>
    			<td colspan="2">
    				<input type="button" id="btn_save" value="保存"/>
    				<input type="button" id="btn_close" value="关闭"/>
    			</td>
    		</tr>
    	</table>
	</s:form>
  </body>
</html>
