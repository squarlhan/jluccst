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
		<script src="<%=path %>/js/ui/jquery.ui.core.js"></script>
		<script src="<%=path %>/js/ui/jquery.ui.widget.js"></script>
		<script src="<%=path %>/js/ui/jquery.ui.position.js"></script>
		<script src="<%=path %>/js/ui/jquery.autocomplete.js"></script>
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
					"customerVisitInfo.contentResult":{strangecode:true},
					"customerVisitInfo.remark":{strangecode:true}
				}
			};
			
			var allData;
			$(function() {
				<s:if test='%{customerVisitInfo.id.equals("")}'>
				$("#customerName").autocomplete("customer/getCustomerByName.action",
			     {
		           minChars: 1,
		           max:5,
		           width: 150, 
		           matchContains: true,
		           autoFill: false,
		           extraParams: 
		           {   
		        	 customerName: function() 
	                 {
	                  	 return $("#customerName").val(); 
	                 }   
	               },
		           parse: function(test) 
		           {
		               data = test;
		               var rows = [];
		               if(data != null)
		               {
		            	   allData = test;
			               for(var i=0; i<data.length; i++)
				           {
				              rows[rows.length] = 
				              {
				                   data: data[i].customerName,
				                   value:data[i],
				                   result:data[i].customerName
				               };
				            }
		           		}
			            return rows;
		           },
		           formatItem:function(item)
		           {
	                   return item;
		           }

			     });
				$("#customerName").result(function(event, itemname, formatted) {
					  //如选择后给其他控件赋值，触发别的事件等等
					  for(var i=0; i<allData.length; i++)
					  {
						  if(allData[i].customerName == itemname)
						  {
							  $("#customerId").val(allData[i].id);
							  $("#customerId_t").val(allData[i].id);
				  			  $("#salesman").val(allData[i].salesman);
			  				  $("#progressId").val(allData[i].progressId);
			  				  $("#category").val(allData[i].category);
			  				  var contractPerson = "";
			  				  var tel = "";
			  				  for(var j= 0;j<allData[i].contractPersonList.length; j++)
			  				  {
			  					  if(contractPerson == "")
			  					  {
			  						  contractPerson = allData[i].contractPersonList[j].personName;
			  					  }else
			  					  {
			  						contractPerson = contractPerson + "," + allData[i].contractPersonList[j].personName;
			  					  }
			  					  
			  					  
			  						  if(allData[i].contractPersonList[j].phone != "")
			  						  {
			  							if(tel == "")
					  					  {
					  					  	tel = allData[i].contractPersonList[j].phone;
					  					  }else
					  					  {
					  						tel = tel + "," + allData[i].contractPersonList[j].phone;
					  					  }
			  						  }
			  						if(allData[i].contractPersonList[j].tel != "")
			  						  {
			  							if(tel == "")
					  					  {
					  					  	tel = allData[i].contractPersonList[j].tel;
					  					  }else
					  					  {
					  						tel = tel + "," + allData[i].contractPersonList[j].tel;
					  					  }
			  						  }
			  					  
			  				  }
			  				$("#contractPerson").val(contractPerson);
			  				$("#phone").val(tel);
			  				
			  				$("#personId").empty();
			  				for(var j= 0;j<allData[i].contractPersonList.length; j++)
			  				{
	                            $("<option value='" + allData[i].contractPersonList[j].id + "'>" + allData[i].contractPersonList[j].personName + "</option>").appendTo($("#personId"));
	                        }
			  				$("#personId").change();
						  }
					  }
					 });
				</s:if> 
					
				
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
					if($("#customerId_t").val() == "")
					{
						alert("请选择客户！");
						return false;
					}
					var validate_settings_submit = jQuery.extend({}, _customer_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
					form1.action = "customer/saveAllVisitInfo.action";
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
		<link rel='stylesheet' type='text/css'  href='<%=path %>/css/jquery.autocomplete.css' />
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="id" name="customerVisitInfo.id"></s:hidden>
		<s:hidden id="customerId" name="customerVisitInfo.customerId"></s:hidden>
		<s:hidden id="customerId_t" name="customerId"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr><td><table><tr><td style="height: 12px"></td></tr>
			<tr><td><table>
			<tr><td><fieldset><legend><span>基本信息</span></legend><table>
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="right" style="width: 72px">客户名称：</td>
		<td >
		<s:textfield type="text" style="width:150px" name="customerInfo.customerName" id="customerName" readOnly="true"></s:textfield>
		</td>
		<td align="right">业务员：</td>
		<td><s:textfield type="text" readOnly="true" style="width:150px" name="customerInfo.salesman" id="salesman" readOnly="true"></s:textfield></td>
		<td align="right">业务进展：</td>
		<td style="width: 150px">
		<s:textfield type="text" readOnly="true" style="width:150px" name="customerInfo.progress" id="progressId" readOnly="true"></s:textfield>
		</td>
	</tr>
	<tr>
		<td></td>
		<td align="right" style="width: 72px">联系人：</td>
		<td><s:textfield type="text" readOnly="true" style="width:150px" name="contractPerson" id="contractPerson" readOnly="true"></s:textfield></td>
		<td align="center">手　机：</td>
		<td>
		<s:textfield type="text" readOnly="true" style="width:150px" name="contractTel" id="phone" readOnly="true"></s:textfield>
		</td>
		<td align="right">客户分类：</td>
		<td style="width: 150px">
		<s:textfield type="text" readOnly="true" style="width:150px" name="customerInfo.category" id="category" readOnly="true"></s:textfield></td>
	</tr>
	</table></td></tr>

</table></fieldset></td></tr>
</table></td></tr>
<tr><td><table>
<tr><td style="height: 15px"></td></tr>			
<tr><td><fieldset><legend><span>回访记录</span></legend><table>
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="right" nowrap>受访人：</td>
		<td ><s:select list="listPerson" listKey="id" listValue="personName" value="customerVisitInfo.visitPersonId" 
			id="personId" name="customerVisitInfo.visitPersonId" cssStyle="width:150px" headerKey="" headerValue="--请选择--" disabled="true"></s:select></td>
		<td align="right" nowrap>回访人：</td>
		<td><s:select list="userList" listKey="id" listValue="userCName" value="customerVisitInfo.salesmanId" 
			id="salesmanId" name="customerVisitInfo.salesmanId" cssStyle="width:150px" headerKey="" headerValue="--请选择--" disabled="true"></s:select></td>
		<td align="right" nowrap>回访方式：</td>
		<td ><s:select list="listVisitOption" listKey="id" listValue="name" value="customerVisitInfo.visitOption" 
			id="visitOption" name="customerVisitInfo.visitOption" cssStyle="width:150px" headerKey="" headerValue="--请选择--" disabled="true"></s:select></td>
	</tr>
	<tr>
		<td></td>
		<td align="right" nowrap>联系电话：</td>
		<td><s:textfield type="text" style="width:150px" name="customerVisitInfo.tel" id="tel" readOnly="true"></s:textfield></td>
		<td align="right" nowrap>Q Q：</td>
		<td ><s:textfield type="text" style="width:150px" name="customerVisitInfo.qq" id="qq" readOnly="true"></s:textfield></td>
		<td align="right" nowrap>邮 箱：</td>
		<td ><s:textfield type="text" style="width:150px" name="customerVisitInfo.email" id="email" readOnly="true"></s:textfield></td>
	</tr>
	<tr>
		<td></td>
		<td align="right" nowrap>预计回访时间：</td>
		<td><s:textfield type="text" style="width:150px" name="customerVisitInfo.visitTime" id="visitTime" readOnly="true"></s:textfield></td>
		<td align="right">任务：</td>
		<td colspan="3"><s:textarea type="text" style="width:400px;height:60px" name="customerVisitInfo.task" id="task" readOnly="true"></s:textarea></td>
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
		<td align="right" nowrap>了解内容<br/>及结果：</td>
		<td ><s:textarea type="text" style="width:646px;height:70px" name="customerVisitInfo.contentResult" id="contentResult" readOnly="true"></s:textarea></td>
	</tr>
	<tr>
		<td></td>
		<td align="right" nowrap>备 注：</td>
		<td ><s:textarea type="text" style="width:646px;height:70px" name="customerVisitInfo.remark" id="remark" readOnly="true"></s:textarea></td>
	</tr>
	<tr><td></td></tr>
</table></td></tr>
</table></fieldset></td></tr>
</table></td></tr>
<tr><td align="center"><table>
	<tr><td style="height: 10px"></td></tr>
	<tr>
		<td align="center">
		<input type="button" name="closeBtn" id="closeBtn" value="关闭" style="width: 50px"/></td>
	</tr>
</table></td></tr>
		</table>
		</s:form>
	</body>
</html>
