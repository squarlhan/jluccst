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
		<title>客户基本信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _customer_submit = {
				rules: {
					"customerInfo.customerName":{required:true,strangecode:true},
					"customerInfo.companyFullName":{strangecode:true},
					"customerInfo.fax":{strangecode:true},
					"customerInfo.sourceId":{required:true},
					"customerInfo.categoryId":{required:true},
					//customerInfo.progressId
					//customerInfo.maturityId
					//customerInfo.levelId
					"customerInfo.address":{required:true,strangecode:true}
					
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
		  		
		  		$("#province").change(function() {
	                loadCity($("#province").val());
	            });
		  		$("#city").change(function() {
	                loadArea($("#city").val());
	            });
		  		 function loadCity(parentid) {
		                $.ajax({
		                    url:"<%=basePath%>datadictionary/cityinfoservice.action?provinceId=" + parentid,
		                    type: 'POST',
		                    dataType: 'JSON',
		                    timeout: 5000,
		                    error: function() { alert('Error loading data!'); },
		                    success: function(msg) {
		                        $("#city").empty();
		                        $.each(eval(msg), function(i, item) {
		                            $("<option value='" + item.id + "'>" + item.name + "</option>").appendTo($("#city"));
		                        });
		                        
		                        loadArea($("#city").val());
		                    }
		                });
		                
		                
		            }
		  		function loadArea(parentid) {
	                $.ajax({
	                    url:"<%=basePath%>datadictionary/areainfoservice.action?cityId=" + parentid,
	                    type: 'POST',
	                    dataType: 'JSON',
	                    timeout: 5000,
	                    error: function() { alert('Error loading data!'); },
	                    success: function(msg) {
	                        $("#area").empty();
	                        $.each(eval(msg), function(i, item) {
	                            $("<option value='" + item.id + "'>" + item.name + "</option>").appendTo($("#area"));
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
					//if( $.trim( $("#companyId").val() ) != ""){
						form1.action = "customer/saveCustomer.action";
					//}else{
		             //  	form1.action = "saveCustomer.action";					
					//}
					//form1.target = "iframe1";
					form1.sourceName.value = $("#sourceId").text();
	               	//form1.submit();
          		});
          	}
			
			$("#addPersonBtn").click(function(){
				parent.parent.tipsWindown("添加联系人信息","iframe:openAddPersonAction.action","460","200","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="./customerList.action";
				});
				window.parent.location.href = "customertabinfo.jsp?id=";
		
			});
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			parent.$("#windown-close").click();
		  		});
			}
			/**
			 * 初始化页面
			 */
			$.fn.initpage = function(){
				$("#txt_companyName").focus();
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
		<s:hidden id="id" name="customerInfo.id"></s:hidden>
		<s:hidden id="sourceName" name="customerInfo.source"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr><td style="width: 10px"></td><td style="height: 50px"><table>
	<tr><td style="width: 600px; height: 21px"></td></tr>
	<tr>
		<td align="center" style="width: 100%">
			<strong><span class="auto-style2">客户信息编辑</span></strong></td>	
	</tr>
	<tr><td style="width: 600px"></td></tr>
</table></td></tr>

<tr><td style="width: 20px"></td><td><fieldset><legend><span>基本信息</span></legend><table>

<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="center">客户名称</td>
		<td><s:textfield style="width:160px" name="customerInfo.customerName"></s:textfield></td>
		<td align="center">公司全名</td>
		<td><s:textfield style="width:160px" name="customerInfo.companyFullName"></s:textfield></td>
		<td align="center">公司传真</td>
		<td><s:textfield style="width:160px"  name="customerInfo.fax"></s:textfield></td>
		<td align="center">客户来源</td>
		<td>
			<s:select list="listSource" listKey="id" listValue="name" value="customerInfo.sourceId" 
			id="sourceId" name="customerInfo.sourceId" cssStyle="width:150px" headerKey="" headerValue="--请选择客户来源--"></s:select>
			</td>
	</tr>
	<tr>
		<td></td>
		<td align="center">客户分类</td>
		<td>
			<s:select list="listCategory" listKey="id" listValue="name" value="customerInfo.categoryId" 
			id="categoryId" name="customerInfo.categoryId" cssStyle="width:150px" headerKey="" headerValue="--请选择客户分类--"></s:select>
			</td>
		<td align="center">业务进展</td>
		<td><select name="customerInfo.progressId"  style="width:100%">
			<option value=""></option>
			<option value="潜在客户">潜在客户</option>
			<option value="新建客户">新建客户</option>
			<option value="成熟客户">成熟客户</option></select></td>
		<td align="center">成熟度</td>
		<td><s:select list="listMaturity" listKey="id" listValue="name" value="customerInfo.maturityId" 
			id="categoryId" name="customerInfo.maturityId" cssStyle="width:150px" headerKey="" headerValue="--请选择成熟度--"></s:select></td>
		<td align="center">开发程度</td>
		<td style="width:150px"><select name="customerInfo.levelId" style="width:100%">
			<option value=""></option>
			<option value="10%">10%</option>
			<option value="20%">20%</option>
			<option value="30%">30%</option>
			<option value="40%">40%</option>
			<option value="50%">50%</option>
			<option value="60%">60%</option>
			<option value="70%">70%</option>
			<option value="80%">80%</option>
			<option value="90%">90%</option>
			<option value="100%">100%</option></select></td>
	</tr>
	<tr>
		<td></td>
		<td align="center">业务员</td>
		<td><select name="name" style="width:100%">
			<option value=""></option>
			<option value="小薛">小薛</option>
			<option value="小蒋">小蒋</option>
			<option value="小张小刘">小张小刘</option></select></td>
		<td align="center">其他业务员</td>
		<td><select name="name" style="width:100%">
			<option value=""></option>
			<option value="小薛">小薛</option>
			<option value="小蒋">小蒋</option>
			<option value="小张小刘">小张小刘</option></select></td>
		<td align="center">建档时间</td>
		<td><s:textfield type="text" style="width:100%" name="customerInfo.registerTime" id="registerTime"></s:textfield></td>
	</tr>
</table></td></tr>
		
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="center">公司所在地</td>
		<td><s:select list="listProvince" listKey="id" listValue="provinceName" value="customerInfo.province" 
			id="province" name="customerInfo.province" cssStyle="width:100px" headerKey="" headerValue="请选择省份"></s:select>
			</td>
		<td><select value="customerInfo.city" 
			id="city" name="customerInfo.city" style="width:100px" ></select></td>
		<td><select  value="customerInfo.district"  
			id="area" name="customerInfo.district" style="width:100px"  ></select></td>
		<td style="width: 510px">具体地址：<s:textfield type="text" style="width:60%" name="customerInfo.address" id="registerTime"></s:textfield></td>
	</tr>
</table></td></tr>

</table></fieldset></td></tr>
<tr><td style="height: 20px"></td></tr>
<s:if test='id!=null && id.length > 0'>
<tr><td style="width: 20px"></td><td><fieldset><legend><span>联系人信息</span></legend><table>
<s:iterator value="listPerson" status="obj">
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="center">姓 名</td>
		<td><s:property value="personName"/></td>
		<td align="center">部门/职务</td>
		<td><s:property value="deptOrDuty"/></td>
		<td align="center">手 机</td>
		<td><s:property value="phone"/></td>
		<td align="center">固定电话</td>
		<td><s:property value="tel"/></td>
	</tr>
	<tr>
		<td></td>
		<td align="center">昵 称</td>
		<td><s:property value="nickName"/></td>
		<td align="center">生 日</td>
		<td><s:property value="birthday"/></td>
		<td align="center">Q Q</td>
		<td><s:property value="qq"/></td>
		<td align="center">邮 箱</td>
		<td><s:property value="email"/></td>
		</td>
	</tr>
</table></td></tr>
</s:iterator>
</table></fieldset></td></tr>
</s:if>
<tr><td></td><td align="center"><table>
	<tr><td style="height: 10px"></td></tr>
	<tr>
		<td align="center">
		<input type="button" name="addBtn" id="addBtn" value="保存" style="width: 50px"/>
		<s:if test='id!=null&& id.length > 0'>
		<input type="button" name="addPersonBtn" value="添加联系人" style="width: 100px"/>
		</s:if>
		<input type="button" onclick="window.history.go(-1)" value="关闭" style="width: 50px"/></td>
	</tr>
</table></td></tr>
		</table>
		</s:form>
	</body>
</html>