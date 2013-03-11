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
		
		$("#receipt").click(function(){
			if($("#receipt").attr("checked")){
				$("#arriveTime").attr("disabled","");
				$("#leaveTime").attr("disabled","");
				$("#actServiceUser").attr("disabled","");
				$("#actCharges").attr("disabled","");
				$("#problemDiagnosis").attr("disabled","");
				$("#solution").attr("disabled","");
				$("#returnVisitTime").attr("disabled","");
				$("#returnVisitType").attr("disabled","");
				$("#returnVisitUser").attr("disabled","");
				$("#degreeSatisfaction").attr("disabled","");
				$("#customerFeedback").attr("disabled","");
			}else{
				$("#arriveTime").attr("disabled","disabled");
				$("#leaveTime").attr("disabled","disabled");
				$("#actServiceUser").attr("disabled","disabled");
				$("#actCharges").attr("disabled","disabled");
				$("#problemDiagnosis").attr("disabled","disabled");
				$("#solution").attr("disabled","disabled");
				$("#returnVisitTime").attr("disabled","disabled");
				$("#returnVisitType").attr("disabled","disabled");
				$("#returnVisitUser").attr("disabled","disabled");
				$("#degreeSatisfaction").attr("disabled","disabled");
				$("#customerFeedback").attr("disabled","disabled");
			}
		});
		
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
	  				//$("#txt_contact").val(contractPerson);
	  				//$("#txt_mobilePhone").val(tel);
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
				alert("请输入并选择客户名称！");
				$("#customerName").focus();
				return false;
			}
			if($("#hdCompanyId").val()==""){
				alert("请输入并选择正确的客户名称！");
				$("#companyId").focus();
				return false;
			}//companyId
			if($("#receipt").attr("checked")){
				$("#hdReceipt").val(1);
				$("#hdDegreeSatisfaction").val($("#degreeSatisfaction").val());
			}else{
				$("#hdReceipt").val(0);
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
			var message = $("#message").val();
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

		var message = $("#message").val();
		if (message != null && $.trim(message) != "") {
			alert(message);
		}
		if($("#logCompnayId").val()!=""){
			$("#selCompany").val($("#logCompnayId").val());
		}
		if($("#tempReceipt").val()=="1"){
			$("#receipt").attr("checked","true")
		}
		
		if($("#receipt").attr("checked")){
			$("#arriveTime").attr("disabled","");
			$("#leaveTime").attr("disabled","");
			$("#actServiceUser").attr("disabled","");
			$("#actCharges").attr("disabled","");
			$("#problemDiagnosis").attr("disabled","");
			$("#solution").attr("disabled","");
			$("#returnVisitTime").attr("disabled","");
			$("#returnVisitType").attr("disabled","");
			$("#returnVisitUser").attr("disabled","");
			$("#degreeSatisfaction").attr("disabled","");
			$("#customerFeedback").attr("disabled","");
		}else{
			$("#arriveTime").attr("disabled","disabled");
			$("#leaveTime").attr("disabled","disabled");
			$("#actServiceUser").attr("disabled","disabled");
			$("#actCharges").attr("disabled","disabled");
			$("#problemDiagnosis").attr("disabled","disabled");
			$("#solution").attr("disabled","disabled");
			$("#returnVisitTime").attr("disabled","disabled");
			$("#returnVisitType").attr("disabled","disabled");
			$("#returnVisitUser").attr("disabled","disabled");
			$("#degreeSatisfaction").attr("disabled","disabled");
			$("#customerFeedback").attr("disabled","disabled");
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
		<s:hidden id="message" name="message" />
		<s:hidden id="logId" name="serviceLog.id"></s:hidden>
		<s:hidden id="logCompnayId" name="serviceLog.companyId"></s:hidden>
		<s:hidden id="hdCompanyId" name="companyId"></s:hidden>
		<s:hidden id="hdCompanyName" name="companyName"></s:hidden>
		<s:hidden id="tempReceipt" name="serviceLog.receipt"></s:hidden>
		<input type="hidden" name="receipt" value="" id="hdReceipt"/>
		<input type="hidden" name="degreeSatisfaction" value="" id="hdDegreeSatisfaction"/>
		<center>
			<table>
				<tr>
					<td><table>
							<tr>
							  <td style="padding:5px;"><fieldset>
										<legend>服务申请</legend>
										<table>
 
											<tr>
												<td><table cellpadding="0" cellspacing="3">
                                                  <tr>
                                                    <td align="right" nowrap="nowrap">客户名称</td>
                                                    <td colspan="5" nowrap="nowrap">
                                                    	<s:textfield type="text" style="width:668px" name="serviceLog.companyName" id="customerName"></s:textfield>
                                                        <span style="color:#ff0000">*</span> </td>
                                                  </tr>
                                                  <tr>
                                                    <td align="right" nowrap="nowrap">申 请 人</td>
                                                    <td align="left"><s:textfield type="text" style="width:150px" name="serviceLog.petitioner" id="petitioner"></s:textfield></td>
                                                    <td align="right" nowrap="nowrap">申请时间</td>
                                                    <td align="left"><s:textfield type="text" style="width:150px" name="serviceLog.petitionTimeString" id="petitionTime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"></s:textfield></td>
                                                    <td align="right" nowrap="nowrap">电　　话</td>
                                                    <td align="left"><s:textfield type="text" style="width:150px" name="serviceLog.telephone" id="telephone"></s:textfield></td>
                                                  </tr>
                                                  <tr>
                                                    <td align="right" nowrap="nowrap">服务人员</td>
                                                    <td align="left"><s:textfield type="text" style="width:150px" name="serviceLog.serviceUser" id="serviceUser"></s:textfield></td>
                                                    <td align="right" nowrap="nowrap">客服人员</td>
                                                    <td align="left"><s:textfield type="text" style="width:150px" name="serviceLog.customerService" id="customerService"></s:textfield></td>
                                                    <td align="right" nowrap="nowrap">预计收费</td>
                                                    <td align="left"><s:textfield type="text" style="width:150px" name="serviceLog.planCharges" id="planCharges"></s:textfield></td>
                                                  </tr>
                                                  <tr>
                                                    <td align="right" nowrap="nowrap">服务事项</td>
                                                    <td colspan="5" align="left"><s:textarea id="serviceMatter" name="serviceLog.serviceMatter" cssStyle="width:648px; height:35px"/></td>
                                                  </tr>

                                                </table></td>
											</tr>
										</table>
									</fieldset>
                                    <input type="checkbox" id="receipt" value="0" />是否收到回执
                                    <fieldset style="margin-top:5px;">
                                    <legend>现场服务</legend>
                                    <table>
                                      <tr>
                                        <td><table cellpadding="0" cellspacing="3">
                                            <tr>
                                              <td align="right" nowrap="nowrap">到达时间</td>
                                              <td nowrap="nowrap"><s:textfield type="text" style="width:150px" name="serviceLog.arriveTime" id="arriveTime" disabled="true" onClick="WdatePicker()"></s:textfield></td>
                                              <td align="right" nowrap="nowrap">离开时间</td>
                                              <td align="left"><s:textfield type="text" style="width:150px" name="serviceLog.leaveTime" id="leaveTime" disabled="true" onClick="WdatePicker()"></s:textfield></td>
                                              <td align="right" nowrap="nowrap">服务人员</td>
                                              <td align="left"><s:textfield type="text" style="width:150px" name="serviceLog.actServiceUser" disabled="true" id="actServiceUser"></s:textfield></td>
                                            </tr>
                                            <tr>
                                              <td align="right" nowrap="nowrap">实际收费</td>
                                              <td align="left"><s:textfield type="text" style="width:150px" name="serviceLog.actCharges" disabled="true" id="actCharges"></s:textfield></td>
                                              <td align="right" nowrap="nowrap" colspan="5">&nbsp</td>
                                            </tr>

                                            <tr>
                                              <td align="right" nowrap="nowrap">问题诊断</td>
                                              <td colspan="5" align="left"><s:textarea id="problemDiagnosis" name="serviceLog.problemDiagnosis" disabled="true" cssStyle="width:648px; height:35px"/></td>
                                            </tr>
                                            <tr>
                                              <td align="right" nowrap="nowrap">解决方案</td>
                                              <td colspan="5" align="left"><s:textarea id="solution" name="serviceLog.solution" disabled="true" cssStyle="width:648px; height:35px"/></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                    </table>
                                    </fieldset>
                                    <fieldset style="margin-top:5px;">
                                    <legend>服务回访</legend>
                                    <table>
                                      <tr>
                                        <td><table cellpadding="0" cellspacing="3">
                                            <tr>
                                              <td align="right" nowrap="nowrap">回访时间</td>
                                              <td nowrap="nowrap"><s:textfield type="text" style="width:150px" name="serviceLog.returnVisitTime" id="returnVisitTime" disabled="true" onClick="WdatePicker()"></s:textfield></td>
                                              <td align="right" nowrap="nowrap">回访方式</td>
                                              <td align="left">
                                              <s:select list="listHffs" theme="simple" id="returnVisitType" name="serviceLog.returnVisitType" listKey="name" listValue="name" headerKey="0" headerValue="请选择" cssStyle="width:150px" disabled="true" />
                                              </td>
                                              <td align="right" nowrap="nowrap">回访人员</td>
                                              <td align="left"><s:textfield type="text" style="width:150px" name="serviceLog.returnVisitUser" id="returnVisitUser" disabled="true"></s:textfield></td>
                                            </tr>
                                            <tr>
                                              <td align="right" nowrap="nowrap">客户满意度</td>
                                              <td colspan="5" align="left">
                                              	<s:select list="#{1:'非常满意',2:'满意',3:'不满意'}" theme="simple" id="degreeSatisfaction" name="serviceLog.degreeSatisfaction" headerKey="0" headerValue="请选择" cssStyle="width:150px" disabled="true" />
                                              </td>
                                            </tr>

                                            <tr>
                                              <td align="right" nowrap="nowrap">客户反馈</td>
                                              <td colspan="5" align="left"><s:textarea id="customerFeedback" name="serviceLog.customerFeedback" cssStyle="width:648px; height:35px" disabled="true"/></td>
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
			
		</center>
	</form>
</body>
</html>
