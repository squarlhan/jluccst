<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author Luojx
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
		<title>客户回访信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _customer_submit = {
				rules: {
					"customerVisitInfo.personId":{required:true},
					"customerVisitInfo.salesmanId":{required:true},
					"customerVisitInfo.visitOption":{required:true},
					"customerVisitInfo.tel":{strangecode:true},
					"customerVisitInfo.qq":{strangecode:true},
					"customerVisitInfo.email":{email:true},
					"customerVisitInfo.task":{strangecode:true},
					"customerVisitInfo.interest":{required:true},
					"customerVisitInfo.objection":{required:true}
				}
			};
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
				$.validator.setDefaults({
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
		  		
		  		$("#personId").change(function() {
	                loadPerson($("#personId").val());
	            });
		  		 function loadPerson(personId) {
		                $.ajax({
		                    url:"<%=basePath%>customer/personservice.action?personId=" + personId,
		                    type: 'POST',
		                    dataType: 'JSON',
		                    timeout: 5000,
		                    error: function() { alert('Error loading data!'); },
		                    success: function(msg) {
		                        //$("#city").empty();
		                        $.each(eval(msg), function(i, item) {
		                            $("#tel").val(item.phone + " " +item.tel);
		                            $("#qq").val(item.qq);
		                            $("#email").val(item.email);
		                        });
		                        
		                    }
		                });
		                
		                
		            }
		  	});
			/**
		  	 * 保存
		  	 */
			$.fn.save = function(){
				$("#addBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _customer_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
					form1.action = "customer/saveTraceInfo.action";
					form1.customerId.value  = form1.customerId_t.value;
	               	form1.submit();
          		});
          	}
			
			
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			parent.$("#windown-close").click();
		  			//parent.location.href = "customermanage.jsp";
		  		});
			}
			/**
			 * 初始化页面
			 */
			$.fn.initpage = function(){
				//$("#personId").focus();
				
			}
		</script>
		<style type="text/css">
			.auto-style1 {
			background: #d3eaef; font-size: 18px; font-family: 仿宋;}
		
		.auto-style2 {
			font-size: x-large;
		}
		.auto-style3 {
			text-align: right;
		}
		</style>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="id" name="customerVisitInfo.id"></s:hidden>
		<s:hidden id="customerId" name="customerVisitInfo.customerId"></s:hidden>
		<s:hidden id="customerId_t" name="customerId"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr><td><table><tr><td style="height: 12px"></td></tr>
<tr><td><fieldset><legend><span>添写回访记录</span></legend><table>
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="center" nowrap>受访人：</td>
		<td><s:select list="listPerson" listKey="id" listValue="personName" value="customerVisitInfo.visitPersonId" 
			id="personId" name="customerVisitInfo.visitPersonId" cssStyle="width:150px" headerKey="" headerValue="--请选择--"></s:select></td>
		<td align="center" nowrap>回访人：</td>
		<td><s:select list="userList" listKey="id" listValue="userCName" value="customerVisitInfo.salesmanId" 
			id="salesmanId" name="customerVisitInfo.salesmanId" cssStyle="width:150px" headerKey="" headerValue="--请选择--"></s:select></td>
		<td align="center" nowrap>回访方式：</td>
		<td style="width: 150px"><s:select list="listTraceOption" listKey="id" listValue="name" value="customerVisitInfo.visitOption" 
			id="visitOption" name="customerVisitInfo.visitOption" cssStyle="width:150px" headerKey="" headerValue="--请选择--"></s:select></td>
	</tr>
	<tr>
		<td></td>
		<td align="center" nowrap>联系电话：</td>
		<td><s:textfield type="text" style="width:150px" name="customerVisitInfo.tel" id="tel"></s:textfield></td>
		<td align="center" nowrap>Q Q：</td>
		<td style="width: 150px"><s:textfield type="text" style="width:150px" name="customerVisitInfo.qq" id="qq"></s:textfield></td>
		<td align="center" nowrap>邮 箱：</td>
		<td style="width: 150px"><s:textfield type="text" style="width:150px" name="customerVisitInfo.email" id="email"></s:textfield></td>
	</tr>
	<tr>
		<td></td>
		<td align="center" nowrap>回访时间：</td>
		<td><s:textfield type="text" style="width:150px" name="customerVisitInfo.visitTime" id="visitTime"></s:textfield></td>
		<td align="center"  nowrap>回访任务：</td>
		<td colspan="3"><s:textarea type="text" style="width:400px;height:60px" name="customerVisitInfo.task" id="task"></s:textarea></td>
	</tr>
	</table></td></tr>

</table></fieldset></td></tr>
</table></td></tr>

<tr><td><table>
<tr><td style="height: 15px"></td></tr>
<tr><td><fieldset><legend><span>填写回访结果：</span></legend><table>
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td rowspan="2"><table>
			<tr><td align="center">兴趣点：</td></tr>
			<tr><td style="color:white">占行：</td></tr></table></td>
		<td rowspan="2"><table>
			<tr><td><s:textarea type="text" style="width:550px;height:70px" name="customerVisitInfo.interest" id="interest"></s:textarea></td></tr></table></td>
	</tr>
	<tr><td></td></tr>
	<tr>
		<td></td>
		<td rowspan="2"><table>
			<tr><td align="center">异议点：</td></tr>
			<tr><td style="color:white">占行</td></tr></table></td>
		<td rowspan="2"><table>
			<tr><td><s:textarea type="text" style="width:550px;height:70px" name="customerVisitInfo.objection" id="objection"></s:textarea></td></tr></table></td>
	</tr>
	<tr><td></td></tr>
</table></td></tr>
</table></fieldset></td></tr>
</table></td></tr>
<tr><td align="center"><table>
	<tr><td style="height: 10px"></td></tr>
	<tr>
		<td align="center">
		<input type="button" name="addBtn" id="addBtn" value="保存" style="width: 50px"/>
		<input type="button" name="closeBtn" id="closeBtn" value="关闭" style="width: 50px"/></td>
	</tr>
</table></td></tr>
		</table>
		</s:form>
	</body>
</html>
