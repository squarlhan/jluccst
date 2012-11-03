<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" jmessagebox="true" jquery="true"
	tipswindow="true" validate="true" jfunction="true" />
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=basePath %>/js/ui/jquery.ui.core.js"></script>
<script src="<%=basePath %>/js/ui/jquery.ui.widget.js"></script>
<script src="<%=basePath %>/js/ui/jquery.ui.position.js"></script>
<script src="<%=basePath %>/js/ui/jquery.autocomplete.js"></script>
	<script type="text/javascript">
	/**
	 * 准备工作
	 */
	$(document).ready(function() {
		$.fn.save();
		$.fn.close();
		$.fn.initpage();
		
		var allData;
		$("#customerName").autocomplete("<%=basePath %>/customer/getCustomerByName.action",{
           minChars: 1,
           max:5,
           width: 150, 
           matchContains: true,
           autoFill: false,
           dataType: "json",
           extraParams: {
        	   customerName: function(){
        		   return $("#customerName").val();
        	   }   
           },
           parse: function(test){
        	   data = test;
               var rows = [];
               if(data != null){
            	   allData = data;
	               for(var i=0; i<data.length; i++){
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
					  form1.companyId.value = allData[i].id;
					  form1.companyName.value = allData[i].customerName;
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
	  				$("#txt_contact").val(contractPerson);
	  				$("#txt_mobilePhone").val(tel);
				  }
			  }
		});
	});
	/**
	 * 保存
	 */
	$.fn.save = function() {
		//如果有id就说明是修改action
		$("#saveBtn").click(function() {
			if($("#customerName").val()==""){
				alert("请输入客户名称！");
				$("#customerName").focus();
				return false;
			}
			form1.action = "${pageContext.request.contextPath}/service/saveservicelog.action";
			form1.submit();
		});
	};

	/**
	 * 关闭
	 */
	$.fn.close = function() {
		$("#closeBtn").click(function() {
			var message = $("#lb_message").html();
			if (message != null && $.trim(message) != "") {
			}
			parent.$("#windown-close").click();
		});
	};
	/**
	 * 初始化页面
	 */
	$.fn.initpage = function() {
		$("#customerName").focus();
		//回显上传时的错误信息
		var uploadErr = $("#lb_error").html();
		if (uploadErr != null && $.trim(uploadErr) != "") {
			alert(uploadErr);
		}

		var message = $("#lb_message").html();
		if (message != null && $.trim(message) != "") {
			alert(message);
		}
		if($("#logCompnayId").val()!=""){
			$("#selCompany").val($("#logCompnayId").val());
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
	<form id="form1" name="form1" method="post">
		<label id="lb_message" style="display:none"></label>
		<s:hidden id="logId" name="serviceLog.id"></s:hidden>
		<s:hidden id="logCompnayId" name="serviceLog.companyId"></s:hidden>
		<s:hidden id="hdCompanyId" name="companyId"></s:hidden>
		<s:hidden id="hdCompanyName" name="companyName"></s:hidden>
		<center>
			<table>
				<tr>
					<td><table>
							<tr>
								<td style="padding:10px;"><fieldset>
										<legend>
											<span>服务记录编辑</span>
										</legend>
										<table>

											<tr>
												<td><table cellpadding="3" cellspacing="3">
														<tr>
															<td align="center" nowrap="nowrap">客户名称</td>
															<td nowrap="nowrap">
																<s:textfield type="text" style="width:150px" name="serviceLog.companyName" id="customerName"></s:textfield>
																<span style="color:#ff0000">*</span>
															</td>
															<td align="center" nowrap="nowrap">联系人</td>
															<td align="left"><s:textfield id="txt_contact"
																	name="serviceLog.contact" cssStyle="width:150px;" /></td>
															<td align="center" nowrap="nowrap">联系人手机</td>
															<td align="left"><s:textfield id="txt_mobilePhone"
																	name="serviceLog.mobilePhone" cssStyle="width:150px;" />
															</td>
														</tr>
														<tr>
															<td align="center" nowrap="nowrap">服务日期</td>
															<td align="left"><s:textfield id="txt_serviceTime"
																	name="serviceLog.serviceTime" cssStyle="width:150px;" readonly="true" onClick="WdatePicker()"/>
															</td>
															<td align="center" nowrap="nowrap">到达时间</td>
															<td align="left"><s:textfield id="txt_arriveTime"
																	name="serviceLog.arriveTime" cssStyle="width:150px;" readonly="true" onClick="WdatePicker()"/>
															</td>
															<td align="center" nowrap="nowrap">完成时间</td>
															<td align="left"><s:textfield id="txt_finishTime"
																	name="serviceLog.finishTime" cssStyle="width:150px;" readonly="true" onClick="WdatePicker()"/></td>
														</tr>
														<tr>
															<td align="center" nowrap="nowrap">品牌型号</td>
															<td align="left"><s:textfield id="txt_brandModel"
																	name="serviceLog.brandModel" cssStyle="width:150px;" /></td>
															<td align="center" nowrap="nowrap">维修员</td>
															<td align="left" colspan="3"><s:textfield id="txt_repairman"
																	name="serviceLog.repairman" cssStyle="width:150px;" /></td>
														</tr>
														<tr>
															<td align="center" nowrap="nowrap">故障情况</td>
															<td colspan="5" align="left"><s:textarea id="txt_malfunction"
																	name="serviceLog.malfunction" cssStyle="width:648px; height:60px"/>
															</td>
														</tr>
														<tr>
															<td align="center" nowrap="nowrap">解决措施</td>
															<td colspan="5" align="left"><s:textarea id="txt_solutions"
																	name="serviceLog.solutions" cssStyle="width:648px; height:60px"/>
															</td>
														</tr>
													</table></td>
											</tr>
										</table>
									</fieldset></td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td align="center"><span style="width: 680px"> <input
							type="button" id="saveBtn" value="保存" class="btn_2_3" /> <input type="button"
							id="closeBtn" value="关闭" class="btn_2_3" /> </span>
					</td>
				</tr>
			</table>
			<s:if test="hasFieldErrors()">
				<s:iterator value="fieldErrors">
					<s:label id="lb_error" name="value[0]" cssStyle="display:none"></s:label>
				</s:iterator>
			</s:if>
		</center>
	</form>
</body>
</html>
