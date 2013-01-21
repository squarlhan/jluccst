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
							  $("#totalConsumption"+g_number).html(allData[i].totalConsumption);
							  $("#consumptionTimes"+g_number).html(allData[i].consumptionTimes);
							  $("#payments"+g_number).html(allData[i].payments);
							  $("#introducetimes"+g_number).html(allData[i].introduceTimes);
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
							  
							  $("#customerName").val("");
							  
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
									$("#result"+j).html("<font color='red'>评估值："+item.resultValue + "，结论：" + item.result+"</font>");
								}
                        	}
                        });
                        
                    }
                });
			});
			$("#delbtn").click(function(){
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
						  
						  $("#totalConsumption"+i).html("");
						  $("#consumptionTimes"+i).html("");
						  $("#payments"+i).html("");
						  $("#introducetimes"+i).html("");
						  $("#result"+i).html("");
						  g_number = g_number - 1;
					}
				}
			});
});
</script>
</head>

<body>
<form>
<table>	
<tr><td></td><td style="width:100%"><table>
<tr><td style="width: 10px"></td><td style="width:838px"><fieldset><legend><span>选择客户</span></legend><table style="width: 100%" cellpadding="5" cellspacing="3">
<tr><td style="width: 20px"></td><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td align="center">添加客户</td>
		<td style="width: 160px;"><s:textfield type="text" style="width:150px" name="customerInfo.customerName" id="customerName"></s:textfield></td>
		<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="delbtn" value="删除所选" /></td>
	</tr>
</table></td></tr>
<tr><td style="width: 20px"></td><td style="width: 100%"><table width="100%" border="0" cellpadding="0" cellspacing="1" style="background-color: #d5e4fd">
	<tr>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')"></td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">客户名称</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">联系人</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">业务员</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">客户分类</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">成熟度</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">消费总额</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">消费次数</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">回款情况</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">介绍客户次数</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">开发程度</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">评估结论</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="chk1" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="customerName1"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="contractPerson1"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="salesman1"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="category1"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="maturity1"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="totalConsumption1"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="consumptionTimes1"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="payments1"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="introducetimes1"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="levelId1"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="result1"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="chk2" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="customerName2"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="contractPerson2"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="salesman2"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="category2"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="maturity2"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="totalConsumption2"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="consumptionTimes2"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="payments2"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="introducetimes2"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="levelId2"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="result2"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="chk3" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="customerName3"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="contractPerson3"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="salesman3"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="category3"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="maturity3"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="totalConsumption3"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="consumptionTimes3"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="payments3"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="introducetimes3"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="levelId3"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="result3"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="chk4" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="customerName4"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="contractPerson4"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="salesman4"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="category4"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="maturity4"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="totalConsumption4"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="consumptionTimes4"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="payments4"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="introducetimes4"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="levelId4"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="result4"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="chk5" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="customerName5"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="contractPerson5"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="salesman5"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="category5"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="maturity5"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="totalConsumption5"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="consumptionTimes5"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="payments5"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="introducetimes5"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="levelId5"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF" id="result5"></td>
	</tr>
</table></td></tr>

</table></fieldset></td></tr>
</table></td></tr>
<tr><td style="width: 20px"></td>
<td><table>
<tr><td style="width: 10px"></td>
<td style="width:838px"><fieldset><legend><span>选择评估项目</span></legend><table style="width: 100%" cellpadding="5" cellspacing="3">
<tr><td style="width: 10px"></td><td style="width: 100%"><table width="100%" border="0" cellpadding="0" cellspacing="1" style="background-color: #d5e4fd">
	<tr>
		<td align="center" style="height: 36px; background-color:#FFFFFF">
		<input type="checkbox" name="checkbox" id="chkTotalComsumption" />消费总额
		<input type="checkbox" name="checkbox" id="chkConsumptionTimes" />消费次数
		<input type="checkbox" name="checkbox" id="chkIntroduceTimes" />转介绍客户情况
		<input type="checkbox" name="checkbox" id="chkPayments" />回款情况
		<input type="checkbox" name="checkbox" id="chkLevel" />开发程度</td>
	</tr>
	<tr>
		<td align="center" style="height: 36px; background-color:#FFFFFF"><input type="button" style="width: 80px;" class="btn_4" id="assessmentbtn" value="开始评估" /></td>
	</tr>
</table></td></tr>
</table>
</form>
</body>

</html>

