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
	String customerId = request.getParameter("customerId");
	if(customerId==null){
		customerId="";
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户信息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true"/>
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
	<script src="<%=basePath %>/js/ui/jquery.ui.core.js"></script>
		<script src="<%=basePath %>/js/ui/jquery.ui.widget.js"></script>
		<script src="<%=basePath %>/js/ui/jquery.ui.position.js"></script>
		<script src="<%=basePath %>/js/ui/jquery.autocomplete.js"></script>
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
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<script type="text/javascript">
	
		$(function(){
			$("#txt_queryCustomerName").autocomplete("../customer/getCustomerByName.action",
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
                  	 return $("#txt_queryCustomerName").val(); 
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
			$("#txt_queryCustomerName").result(function(event, itemname, formatted) {
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
					  }
				  }
				 });
			$.fn.CheckBoxAll("ids","cbk_all");
			$.fn.UnCheckBoxAll("ids","cbk_all");
			//日期控件
			$('#txt_queryBargainTimeBegin').datetimepicker({showTimepicker: false});
			$('#txt_queryBargainTimeEnd').datetimepicker({showTimepicker: false});
			$("#btn_add").click(function(){
				try{
					parent.$.fn.showOrHideTab(1,true);
					parent.$.fn.selectTab(1,'openAddSellRecordForOneCustomerAction.action?customerId=<%=customerId%>');
				}catch(e){
					alert(e.description);
				}
			});
			$("#btn_delAll").click(function(){
				var url = "deleteSellRecordAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
			});
			
			
			/**
	  		 * 修改信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				try{
						parent.$.fn.showOrHideTab(1,true);
						parent.$.fn.selectTab(1,url);
					}catch(e){
						alert(e.description);
					}
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个信息
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				if(window.confirm("您确定要删除这条信息吗？")){
	  					$.post(url, "", function(data){window.location.href=window.location.href;});
	  				}
	  			});
	  		});
		});
		/**
	  	 * 点击选复选框时，执行全选/取消全选功能
	  	 * @param chkallid
	  	 * 执行全选功能的checkbox的id值
	  	 */
	  	$.fn.CheckBoxAll = function (subchkname,chkallid) {
	  		$("#" + chkallid).click(function () {
	  			var b = ($(this).attr("checked"));
	  			$(":checkbox[name='" + subchkname + "']").each(function () {
	  				if( !$(this).attr("disabled") ){
	  					$(this).attr("checked", b);
	  				}
	  			});
	  		});
	  		if($(":checkbox[name='" + subchkname + "']").length ==0){
	  			$("#" + chkallid).attr("checked", false);
	  			$("#" + chkallid).attr("disabled",true);
	  		}
	  	};

	  	/**
	  	 * 子复选框有一个处理非选中状态时，执行全选功能的复选框将置为非选中状态
	  	 * @param subchkname
	  	 * 子复选框的name
	  	 * @param chkallid
	  	 * 执行全选功能的复选框id
	  	 */
	  	$.fn.UnCheckBoxAll = function (subchkname, chkallid) {
	  		$(":checkbox[name='" + subchkname + "']").live("click",function () {
	  			var l = $(":checkbox[name='" + subchkname + "']").length;
	  			if (!$(this).attr("checked")) {
	  				$("#" + chkallid).attr("checked", false);
	  			} else {
	  				var i = 0;
	  				$(":checkbox[name='" + subchkname + "']").each(function () {
	  					if ($(this).attr("checked")) {
	  						i++;
	  					}
	  				});
	  				if (l == i) {
	  					$("#" + chkallid).attr("checked", true);
	  				}
	  			}
	  		});
	  	};
	</script>
	</head>
  <body>
   <s:form id="form1" name="form1" method="post" theme="simple" action="">
   		<fieldset >
		<legend>查询条件</legend>
   		<span>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
				<tr>
					<td height="26" width="100" align="right" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>成交日期：</strong>
					</td>
					<td height="26"   width="220"  align="left" bgcolor="#FFFFFF"  nowrap="nowrap">
						<s:textfield id="txt_queryBargainTimeBegin" name="queryBargainTimeBegin" cssStyle="width:100px" ></s:textfield>
						- <s:textfield id="txt_queryBargainTimeEnd" name="queryBargainTimeEnd" cssStyle="width:100px" ></s:textfield>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" rowspan="2">
						<input name="queryBtn" type="submit" class="btn_2_3" id="queryBtn" value="查询">
					</td>
				</tr>
			</table>
		</span>
		</fieldset>
   		<table id="recordsList" width="100%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
			<tr>
           			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>销售单号</strong></td>
           			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>客户名称</strong></td>
           			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>业务员</strong></td>
           			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>成交日期</strong></td>
           			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>产品种类</strong></td>
           			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>交易总额（元）</strong></td>
           			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>实 收（元）</strong></td>
           			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>欠 款（元）</strong></td>
           			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>交回款情况</strong></td>
           			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>操作</strong></td>
			</tr>
			 <s:iterator value="pagination.data" status="obj">
	        	<tr>
           			<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="orderID"/></td>
           			<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="customerName"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="salesmanName"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="bargainTime"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF">
            		<s:iterator value="goodsTypes" status="temp">
            			<s:if test="id==goodsType">
            				<s:property value="name"/>
            			</s:if>
            		</s:iterator>
            		</td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="receivable"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="realCollection"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="debt"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="(realCollection/receivable)*100"/>%</td>
            		<td height="26" align="center" bgcolor="#FFFFFF" nowrap="nowrap">
							<s:url id="edit_url" action="openModifySellRecordForOneCustomerViewAction">   
								<s:param name="sellRecord.id" value="id"></s:param>   
							</s:url>
				         	<a name="edit" href="javascript:void(0);" url="${edit_url}">查看</a>  
					</td>
            </tr>
            </s:iterator>
			 <tr>
	          <td height="26" colspan="11" align="center" bgcolor="#FFFFFF">
				<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
			  </td>
	        </tr>
		</table>
	</s:form>
  </body>
</html>
