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
		<title>客户跟进信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<script src="/crm/js/ui/jquery.ui.core.js"></script>
		<script src="/crm/js/ui/jquery.ui.widget.js"></script>
		<script src="/crm/js/ui/jquery.ui.position.js"></script>
		<script src="/crm/js/ui/jquery.ui.autocomplete.js"></script>
		<script type="text/javascript">
		
			/**
		  	 * 验证条件
		  	 */
			var _customer_submit = {
				rules: {
					"customerTraceInfo.personId":{required:true},
					"customerTraceInfo.salesmanId":{required:true},
					"customerTraceInfo.traceOption":{required:true},
					"customerTraceInfo.tel":{strangecode:true},
					"customerTraceInfo.qq":{strangecode:true},
					"customerTraceInfo.email":{email:true},
					"customerTraceInfo.task":{strangecode:true},
					"customerTraceInfo.interest":{strangecode:true},
					"customerTraceInfo.objection":{strangecode:true}
				}
			};
			$(function() {
				$( "#customerName" ).autocomplete({
					source: function( request, response ) {
					$.ajax({
						url: "customer/getCustomerByName.action",
						dataType: "jsonp",
						data: {
							customerName: $( "#customerName" ).val(),
							iSearchMaxRecord: 12,
							name_startsWith: request.term
						},
						success: function( data ) {
							alert(data);
							response( $.map( data.customernames, function( item ) {
								return {
									label: item.id + (item.customerName ? ", " + item.contractPerson : "") + ", " + item.phone,
									value: item.id
								}
							}));
						}
					});
				},
				minLength: 2,
				select: function( event, ui ) {
				//	log( ui.item ?
				//		"Selected: " + ui.item.label :
				//		"Nothing selected, input was " + this.value);
				},
				open: function() {
					$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
				},
				close: function() {
					$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
				}
				});
			
				$.validator.setDefaults({
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
		.ui-autocomplete-loading { background: white url('images/ui-anim_basic_16x16.gif') right center no-repeat; }
		</style>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="id" name="customerTraceInfo.id"></s:hidden>
		<s:hidden id="customerId" name="customerTraceInfo.customerId"></s:hidden>
		<s:hidden id="customerId_t" name="customerId"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr><td><table><tr><td style="height: 12px"></td></tr>
			<tr><td><table>
			<tr><td><fieldset><legend><span>完善基本信息</span></legend><table>
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="right" style="width: 72px">客户名称：</td>
		<td >
		<s:textfield type="text" style="width:150px" name="customerInfo.customerName" id="customerName"></s:textfield>
		</td>
		<td align="right">业务员：</td>
		<td><s:textfield type="text" readOnly="true" style="width:150px" name="customerInfo.salesmanName" id="salesmanName"></s:textfield></td>
		<td align="right">业务进展：</td>
		<td style="width: 150px">
		<s:textfield type="text" readOnly="true" style="width:150px" name="customerInfo.progressId" id="progressId"></s:textfield>
		</td>
	</tr>
	<tr>
		<td></td>
		<td align="right" style="width: 72px">联系人：</td>
		<td><s:textfield type="text" readOnly="true" style="width:150px" name="customerInfo.contractPerson" id="contractPerson"></s:textfield></td>
		<td align="center">手　机：</td>
		<td>
		<s:textfield type="text" readOnly="true" style="width:150px" name="customerInfo.phone" id="phone"></s:textfield>
		</td>
		<td align="right">客户分类：</td>
		<td style="width: 150px">
		<s:textfield type="text" readOnly="true" style="width:150px" name="customerInfo.category" id="category"></s:textfield></td>
	</tr>
	</table></td></tr>

</table></fieldset></td></tr>
</table></td></tr>
<tr><td><table>
<tr><td style="height: 15px"></td></tr>			
<tr><td><fieldset><legend><span>添写跟进记录</span></legend><table>
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="right" nowrap>受访人：</td>
		<td ><s:select list="listPerson" listKey="id" listValue="personName" value="customerTraceInfo.tracePersonId" 
			id="personId" name="customerTraceInfo.tracePersonId" cssStyle="width:150px" headerKey="" headerValue="--请选择--"></s:select></td>
		<td align="right" nowrap>跟进人：</td>
		<td><s:select list="userList" listKey="id" listValue="userCName" value="customerTraceInfo.salesmanId" 
			id="salesmanId" name="customerTraceInfo.salesmanId" cssStyle="width:150px" headerKey="" headerValue="--请选择--"></s:select></td>
		<td align="right" nowrap>跟进方式：</td>
		<td ><s:select list="listTraceOption" listKey="id" listValue="name" value="customerTraceInfo.traceOption" 
			id="traceOption" name="customerTraceInfo.traceOption" cssStyle="width:150px" headerKey="" headerValue="--请选择--"></s:select></td>
	</tr>
	<tr>
		<td></td>
		<td align="right" nowrap>联系电话：</td>
		<td><s:textfield type="text" style="width:150px" name="customerTraceInfo.tel" id="tel"></s:textfield></td>
		<td align="right" nowrap>Q Q：</td>
		<td ><s:textfield type="text" style="width:150px" name="customerTraceInfo.qq" id="qq"></s:textfield></td>
		<td align="right" nowrap>邮 箱：</td>
		<td ><s:textfield type="text" style="width:150px" name="customerTraceInfo.email" id="email"></s:textfield></td>
	</tr>
	<tr>
		<td></td>
		<td align="right" nowrap>跟进时间：</td>
		<td><s:textfield type="text" style="width:150px" name="customerTraceInfo.traceTime" id="traceTime"></s:textfield></td>
		<td align="right">任务：</td>
		<td colspan="3"><s:textarea type="text" style="width:400px;height:60px" name="customerTraceInfo.task" id="task"></s:textarea></td>
	</tr>
	</table></td></tr>
</table></fieldset></td></tr>
</table></td></tr>

<tr><td><table>
<tr><td style="height: 15px"></td></tr>
<tr><td><fieldset><legend><span>填写跟进结果：</span></legend><table>
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="right" nowrap>兴趣点：</td>
		<td ><s:textarea type="text" style="width:646px;height:70px" name="customerTraceInfo.interest" id="interest"></s:textarea></td>
	</tr>
	<tr>
		<td></td>
		<td align="right" nowrap>异议点：</td>
		<td ><s:textarea type="text" style="width:646px;height:70px" name="customerTraceInfo.objection" id="objection"></s:textarea></td>
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