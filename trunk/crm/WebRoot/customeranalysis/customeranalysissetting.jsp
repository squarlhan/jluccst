<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/page-tags"%> 
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
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>客户基本信息</title>
<link type="text/css" rel="stylesheet" href="../style.css" />
<link rel='stylesheet' type='text/css'  href='<%=path %>/css/jquery.autocomplete.css' />
<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
<script src="<%=path %>/js/ui/jquery.ui.core.js"></script>
<script src="<%=path %>/js/ui/jquery.ui.widget.js"></script>
<script src="<%=path %>/js/ui/jquery.ui.position.js"></script>
<script src="<%=path %>/js/ui/jquery.autocomplete.js"></script>
<script type="text/javascript">
var allData;
var g_number = 1;
$(function() {
	$("#customerName").autocomplete("../customer/getCustomerByName.action",
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
				  if(typeof(allData) == "object")
				  {
					  
					  for(var i=0; i<allData.length; i++)
					  {
						  if(allData[i].customerName == itemname)
						  {
							  $("#chk"+g_number).val(allData[i].id);
							  $("#chk"+g_number).attr("checked","true");
							  $("#customerName"+g_number).html(allData[i].customerName);
				  			  $("#salesman"+g_number).html(allData[i].salesman);
							  $("#levelId"+g_number).html(allData[i].levelId);
							  $("#maturity"+g_number).html(allData[i].maturity);
							  $("#category"+g_number).html(allData[i].category);
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
							  }
							  
							  $("#contractPerson"+g_number).html(contractPerson);
							  g_number = g_number + 1;
							  break;
						  }
					  }
				  }
			});
			
			$("#assessmentbtn").click(function(){
				var customerIds= "";
				var totalComsumption = "";
				var consumptionTimes = "";
				var introduceTimes = "";
				var payments = "";
				var level = "";
				for(var i=1;i<6;i++)
				{
					if($("#chk"+i).attr("checked"))
					{
						if(customerIds == "")
						{
							customerIds = $("#chk"+i).val();
						}else
						{
							customerIds = customerIds + "," + $("#chk"+i).val();
						}
					}
				}
				
				if($("#chkTotalComsumption").attr("checked"))
				{
					totalComsumption = 1;
				}
				if($("#chkConsumptionTimes").attr("checked"))
				{
					consumptionTimes = 1;
				}
				if($("#chkIntroduceTimes").attr("checked"))
				{
					introduceTimes = 1;
				}
				if($("#chkPayments").attr("checked"))
				{
					payments = 1;
				}
				if($("#chkLevel").attr("checked"))
				{
					level = 1;
				}
				if(customerIds == "")
				{
					alert("请先选择评估的客户！");
					return false;
				}
				$.ajax({
                    url:"<%=basePath%>customerassessment/customerAnalysis.action?customerIds="+customerIds+"&totalComsumption="+totalComsumption+"&consumptionTimes="+consumptionTimes+"&introduceTimes="+introduceTimes+"&payments="+payments+"&level="+level,
                    type: 'POST',
                    dataType: 'JSON',
                    timeout: 5000,
                    error: function() { alert('Error loading data!'); },
                    success: function(msg) {
                        $.each(eval(msg), function(i, item) {
                        	for(var j = 1;j<6;j++)
                        	{
								if($("#chk"+j).val() == item.id)
								{
									$("#result"+j).html("评估值："+item.resultValue + "，结论：" + item.result);
								}
                        	}
                        });
                        
                    }
                });
			});
			$("#addBtn").click(function() {
				form1.action = "<%=basePath%>customerassessment/customerAnalysisSettingSave.action";
		       	form1.submit();
			});
			$("#delbtn").click(function(){
				alert("123");
				for(var i=1;i<6;i++)
				{
					if($("#chk"+i).attr("checked"))
					{
						  $("#chk"+i).val("");
						  $("#customerName"+i).html("");
			  			  $("#salesman"+i).html("");
						  $("#levelId"+i).html("");
						  $("#maturity"+i).html("");
						  $("#category"+i).html("");
						  $("#contractPerson"+i).html("");
						  $("#result"+i).html("");
						  
						  g_number = g_number - 1;
					}
				}
			});
			
			
			
});


</script>
</head>

<body>
<form id="form1" name="form1">
<table>	
<tr><td></td><td style="width:100%"><table>
<tr><td style="width: 20px"></td><td style="width:838px"><fieldset><legend><span>选择客户</span></legend><table style="width: 100%" cellpadding="5" cellspacing="3">
<tr><td style="width: 20px"></td><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td align="center">添加客户</td>
		<td style="width: 160px;"><s:textfield type="text" style="width:150px" name="customerInfo.customerName" id="customerName"></s:textfield></td>
		<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="delbtn" value="删除所选" />
		</td>
		<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="allBtn" value="全部客户" />
		</td>
	</tr>
</table></td></tr>
</table></fieldset></td></tr>
</table></td></tr>
<tr><td style="width: 20px"></td>
<td><table>
<tr><td style="width: 20px"></td>
<td style="width:400px"><fieldset><legend><span>选择评估项目</span></legend><table style="width: 100%" cellpadding="5" cellspacing="3">
<tr><td style="width: 10px"></td><td style="width: 100%"><table width="100%" border="0" cellpadding="0" cellspacing="1" style="background-color: #d5e4fd">
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF">
		<s:if test='totalComsumption == "1"'>
		<input type="checkbox" name="totalComsumption" id="chkTotalComsumption" value="1" checked/></td>
		</s:if>
		<s:else>
		<input type="checkbox" name="totalComsumption" id="chkTotalComsumption" value="1"/></td>
		</s:else>
		<td align="center" style="height: 26px; background-color:#FFFFFF">消费总额</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF">
		<s:if test='consumptionTimes == "1"'>
		<input type="checkbox" name="consumptionTimes" id="chkConsumptionTimes" value="1" checked/></td>
		</s:if>
		<s:else>
		<input type="checkbox" name="consumptionTimes" id="chkConsumptionTimes" value="1" /></td>
		</s:else>
		
		<td align="center" style="height: 26px; background-color:#FFFFFF">消费次数</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF">
		<s:if test='introduceTimes == "1"'>
		<input type="checkbox" name="introduceTimes" id="chkIntroduceTimes" value="1" checked/></td>
		</s:if>
		<s:else>
		<input type="checkbox" name="introduceTimes" id="chkIntroduceTimes" value="1" /></td>
		</s:else>
		<td align="center" style="height: 26px; background-color:#FFFFFF">转介绍客户情况</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF">
		<s:if test='payments == "1"'>
		<input type="checkbox" name="payments" id="chkPayments" value="1" checked/></td>
		</s:if>
		<s:else>
		<input type="checkbox" name="payments" id="chkPayments" value="1" /></td>
		</s:else>
		<td align="center" style="height: 26px; background-color:#FFFFFF">回款情况</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF">
		<s:if test='level == "1"'>
		<input type="checkbox" name="level" id="chkLevel" value="1" checked/></td>
		</s:if>
		<s:else>
		<input type="checkbox" name="level" id="chkLevel" value="1" /></td>
		</s:else>
		<td align="center" style="height: 26px; background-color:#FFFFFF">开发程度</td>
	</tr>
</table></td></tr>
</table></fieldset></td>
<td style="width:30px"></td><td style="width:400px"><fieldset><legend><span>定期评估设置</span></legend><table style="width: 100%" cellpadding="5" cellspacing="3">

<tr><td style="width: 10px"></td><td style="width: 100%"><table width="100%" border="0" cellpadding="0" cellspacing="1">
	<tr><td colspan="3"><table><tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 50%;">评估开始时间</td>
		<td align="center" style="height: 26px; width:160px; background-color:#FFFFFF">
		<s:textfield  type="text" style="width:150px" name="beginTime" id="beginTime"></s:textfield><font color="red">*</font>
		</td>
		</tr></table></td>
	</tr>
	<tr>
		<td style="height:20px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; width:100%; background-color:#FFFFFF"> <s:radio name="autoAssessmentSetting.options" list="%{#{'1':'每日评估','2':'每周评估','3':'每月评估'}}"></s:radio>
		 <input type="button" style="width: 67px;" class="btn_2_3" id="addBtn" value="保存" />
		</td>
	</tr>
</table></td></tr>


</table></fieldset></td>

</tr></table></td>
</tr></table></td>
</tr>


</table>
</form>
</body>

</html>

