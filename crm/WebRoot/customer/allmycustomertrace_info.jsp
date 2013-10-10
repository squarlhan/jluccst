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
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true"/>
		<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
		<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
		
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
		
		<script src="<%=basePath %>/js/ui/jquery.ui.core.js"></script>
		<script src="<%=basePath %>/js/ui/jquery.ui.position.js"></script>
		<script src="<%=basePath %>/js/ui/jquery.autocomplete.js"></script>
		<script type="text/javascript">
		
			/**
		  	 * 验证条件
		  	 */
			var _customer_submit = {
				rules: {
					"customerTraceInfo.personId":{required:true},
					"customerTraceInfo.salesmanId":{required:true},
					"customerTraceInfo.traceOption":{required:true},
					"customerTraceInfo.qq":{strangecode:true},
					"traceTime":{required:true},
					"customerTraceInfo.email":{email:true},
					"customerTraceInfo.task":{strangecode:true},
					"customerTraceInfo.interest":{strangecode:true},
					"customerTraceInfo.objection":{strangecode:true}
				}
			};
			
			var allData;
			$(function() {
				<s:if test='%{customerTraceInfo.id.equals("")}'>
				$("#customerName").autocomplete("customer/getMyCustomerByName.action?type=visit",
			     {
		           minChars: 1,
		           max:5,
		           width: 150, 
		           matchContains: true,
		           autoFill: false,
		           dataType: "json",
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
		            	   allData = data;
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
			  				  if(allData[i].progressId == "NEW" || allData[i].progressId=="")
				  				  $("#progressName").val("新建");
				  			  if(allData[i].progressId == "TRACE")
				  				  $("#progressName").val("跟进");
				  			  if(allData[i].progressId == "DEALING")
				  				  $("#progressName").val("要成单");
				  			  if(allData[i].progressId == "DEALED")
				  				  $("#progressName").val("成单");
				  			  if(allData[i].progressId == "VISIT")
				  				  $("#progressName").val("回访");
				  			  if(allData[i].progressId == "LOYAL")
				  				  $("#progressName").val("忠诚客户");	  
				  				  
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
				//日期控件
		  		//$('#txt_begin').val((new Date()).getYear()+"-"+(((new Date()).getMonth()+1)<10 ? "0"+((new Date()).getMonth()+1) : (new Date()).getMonth()+1)+"-"+((new Date()).getDate()-15<10 ? "0"+(new Date()).getDate()-15 : (new Date()).getDate()-15));
		  		//$('#txt_end').val((new Date()).getYear()+"-"+(((new Date()).getMonth()+1)<10 ? "0"+((new Date()).getMonth()+1) : (new Date()).getMonth()+1)+"-"+((new Date()).getDate()<10 ? "0"+(new Date()).getDate() : (new Date()).getDate()));
				$('#traceTime').datetimepicker({showTimepicker: true});
				$('#actualTraceTime').datetimepicker({showTimepicker: true});
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
					form1.action = "customer/saveAllMyTraceInfo.action";
					form1.customerId.value  = form1.customerId_t.value;
	               	form1.submit();
          		});
				$("#traceFlag").click(function() {
					if($("#traceFlag").attr("checked"))
					{
						$("#actualTraceTime").attr("disabled",false);
						$("#interest").attr("disabled",false);
						$("#objection").attr("disabled",false);
						$("#dealingFlag").attr("disabled",false);
					}else
					{
						$("#actualTraceTime").attr("disabled",true);
						$("#interest").attr("disabled",true);
						$("#objection").attr("disabled",true);
						$("#dealingFlag").attr("disabled",true);
					}
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
				$("#tel").focus();
				//回显上传时的错误信息
				var uploadErr = $("#lb_error").html();
				if(uploadErr!=null && $.trim(uploadErr)!="" ){
					alert(uploadErr);
				}
				
				var message = $("#lb_message").html();
				if(message!=null && $.trim(message)!="" ){
					alert(message);
					
					parent.$("#windown-close").click();
				}
				if($("#traceFlag").attr("checked"))
				{
					$("#actualTraceTime").attr("disabled",false);
					$("#interest").attr("disabled",false);
					$("#objection").attr("disabled",false);
					$("#dealingFlag").attr("disabled",false);
				}else
				{
					$("#actualTraceTime").attr("disabled",true);
					$("#interest").attr("disabled",true);
					$("#objection").attr("disabled",true);
					$("#dealingFlag").attr("disabled",true);
				}
			};
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
		<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<s:hidden id="id" name="customerTraceInfo.id"></s:hidden>
		<s:hidden id="customerId" name="customerTraceInfo.customerId"></s:hidden>
		<s:hidden id="customerId_t" name="customerId"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr><td><fieldset><legend><span>完善基本信息</span></legend><table>
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="right" style="width: 72px">客户名称：</td>
		<td >
		<s:textfield type="text" style="width:150px" name="customerTraceInfo.customerName" id="customerName"></s:textfield><font color="red">*</font>
		</td>
		<td align="right">业务员：</td>
		<td><s:property value="sessionUserCName"/></td>
		<td align="right">业务进展：</td>
		<td style="width: 150px">
		<s:textfield type="text" readOnly="true" style="width:140px" name="progress" id="progressName"></s:textfield>
		<s:hidden name="customerInfo.progress" id="progressId" />
		</td>
	</tr>
	<tr>
		<td></td>
		<td align="right" style="width: 72px">联系人：</td>
		<td><s:textfield type="text" readOnly="true" style="width:150px" name="contractPerson" id="contractPerson"></s:textfield></td>
		<td align="center">手　机：</td>
		<td>
		<s:textfield type="text" readOnly="true" style="width:150px" name="contractTel" id="phone"></s:textfield>
		</td>
		<td align="right">客户分类：</td>
		<td style="width: 150px">
		<s:textfield type="text" readOnly="true" style="width:150px" name="customerInfo.category" id="category"></s:textfield></td>
	</tr>
	</table></td></tr>
</table></fieldset></td></tr>
<tr><td><fieldset><legend><span>添写跟进记录</span></legend><table>
<tr><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td></td>
		<td align="right" nowrap>受访人：</td>
		<td ><s:select list="listPerson" listKey="id" listValue="personName" value="customerTraceInfo.tracePersonId" 
			id="personId" name="customerTraceInfo.tracePersonId" cssStyle="width:135px" headerKey="" headerValue="--请选择--"></s:select><font color="red">*</font></td>
		<td align="right" nowrap>跟进人：</td>
		<td><s:property value="sessionUserCName"/></td>
		<td align="right" nowrap>跟进方式：</td>
		<td ><s:select list="listTraceOption" listKey="id" listValue="name" value="customerTraceInfo.traceOption" 
			id="traceOption" name="customerTraceInfo.traceOption" cssStyle="width:135px" headerKey="" headerValue="--请选择--"></s:select><font color="red">*</font></td>
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
		<td align="right" nowrap title="日期格式：<s:property value='traceTime'/>">预计跟进时间：</td>
		<td title="日期格式：<s:property value='traceTime'/>"><s:textfield type="text" style="width:150px" name="traceTime" id="traceTime" readOnly="true"></s:textfield><font color="red">*</font></td>
		<td align="right">任务：</td>
		<td colspan="3"><s:textarea type="text" style="width:400px;height:60px" name="customerTraceInfo.task" id="task"></s:textarea></td>
	</tr>
	</table></td></tr>
</table></fieldset></td></tr>
<tr><td><fieldset><legend><span>
<s:if test='%{customerTraceInfo.id != null && customerTraceInfo.id != ""}'>
	<s:if test='customerTraceInfo.traceFlag.equals("1")'>
		<input type="checkbox" name="traceFlag" id="traceFlag" value="1" checked/>
	</s:if>
	<s:else>
		<input type="checkbox" name="traceFlag" id="traceFlag" value="1"/>
	</s:else>
</s:if>
填写跟进结果</span></legend><table>
<tr><td width="15px"></td><td align="center" nowrap>实际跟进<br/>时间：</td>
			<td style="padding-left:26px">
			<s:if test='%{customerTraceInfo.id != null && customerTraceInfo.id != ""}'>
				<s:textfield readOnly="true" type="text" style="width:150px" name="actualTraceTime" id="actualTraceTime"></s:textfield>
			</s:if>
			<s:else>
				<s:textfield readOnly="true" type="text" style="width:150px" name="actualTraceTime" id="actualTraceTime"></s:textfield>
			</s:else>
			&nbsp;&nbsp;&nbsp;&nbsp;
				<s:if test='customerTraceInfo.dealingFlag.equals("1")'>
					<input type="checkbox" name="dealingFlag" id="dealingFlag" value="1" checked/>要成单
				</s:if>
				<s:else>
					<input title="请于跟进结束后填写" readOnly="true" type="checkbox" name="dealingFlag" id="dealingFlag" value="1"/>要成单
				</s:else>
				</td>
	</tr>
	<tr>
		<td></td><td align="center" nowrap>兴趣点：</td>
		<td  style="padding-left:26px">
			<s:if test='%{customerTraceInfo.id != null && customerTraceInfo.id != ""}'>
				<s:textarea type="text" style="width:640px;height:70px" name="customerTraceInfo.interest" id="interest"></s:textarea>
				</td>
			</s:if>
			<s:else>
				<s:textarea title="请于跟进结束后填写" readOnly="true" type="text" style="width:640px;height:70px" name="customerTraceInfo.interest" id="interest"></s:textarea></td>
			</s:else>
	</tr>
	<tr>
		<td></td><td align="center" nowrap>异议点：</td>
		<td style="padding-left:26px">
			<s:if test='%{customerTraceInfo.id != null && customerTraceInfo.id != ""}'>
			<s:textarea type="text"  style="width:640px;height:70px" name="customerTraceInfo.objection" id="objection"></s:textarea></td>
			</s:if>
			<s:else>
			<s:textarea title="请于跟进结束后填写" type="text" readOnly="true" style="width:640px;height:70px" name="customerTraceInfo.objection" id="objection"></s:textarea></td>
			</s:else>
	</tr>
</table></fieldset></td></tr>
<tr><td align="center"><table>
	<tr>
		<td align="center">
		<s:checkbox name="chkSMS" id="chkSMS" />短信提醒
		<input type="button" name="addBtn" id="addBtn" value="保存" style="width: 50px"/>
		<input type="button" name="closeBtn" id="closeBtn" value="关闭" style="width: 50px"/></td>
	</tr>
</table></td></tr>
		</table>
		</s:form>
	</body>
</html>
