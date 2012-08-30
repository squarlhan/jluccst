<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author zhuyf
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>销售记录编辑</title>
	<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.cookie.pack.js"></script>
	<style type="text/css"> 
		#ui-datepicker-div, .ui-datepicker{ font-size: 85%; }	
		.tips { color:#999; padding:0 5px; }
		.tips strong { color:#1E9300; }
		.tips .js_txtFull strong { color:#F00; }
		textarea.text { width:474px; }	
	</style> 
	<script type="text/javascript">
	
	  	$(function(){
	  		//日期控件
			$('#txt_bargainTime').datetimepicker({showTimepicker: false});
	  		$("#btn_add").click(function(){
				parent.parent.parent.tipsWindown("商品明细","iframe:openAddSellRecordDetialAction.action","750","300","true","","true","no");
				parent.parent.parent.$("#windown-close").bind('click',function(){
					var detials = $.cookie('detial'); // 读取 cookie中的被选择的人员Id
		  			$.cookie('detial', '', { expires: -1 }); //读取完毕后删除cookie
  					if(detials!=null){
  						var info = detials.split("☆");//☆
			  			var row="";
						row=row+"<tr>";
			  			row=row+"<td align='center' bgcolor='#FFFFFF' >";  
			  			row=row+"<input type='checkbox' name='ids'/>";
			  			row=row+"<input type='hidden' id='"+1+"' name='detials' value='"+detials+"'/>";
			  			row=row+"</td>";
			  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+info[0]+"</td>";
			  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+info[1]+"</td>";
			  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+info[2]+"</td>";
			  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+info[3]+"</td>";
			  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+info[4]+"</td>";
			  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+info[5]+"</td>";
			  			row=row+"<td align='center' bgcolor='#FFFFFF'><a name='del_one' href='javascript:void(0);' onclick='$.fn.deletetemp($(this));'>删除</a></td>";
			  			row=row+"</tr>";
			  			$("#no_data").hide();
			  		    $("#goodsList tr:eq(2)").append(row);
			  		    $("#cbk_all").attr("checked", false);
		  			    $("#cbk_all").attr("disabled",false);
  					}
				});
	  		});
	  		
	  		/**
	  		 *ajax删除数据库行
	  		*/
	  		$("a[name='del_one']").each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				$.post(url, null, function(data){});
	  				$(this).parent().parent().remove();
	  			});
	  		});
	  		
	  		
	  		$("#btn_save").click(function(){
	  			/*
	  			$.ajax({
  					type:"post",
  					url: "addSellRecordAction.action",
  					data:$("#form1").serialize(),
  					beforeSend: function(XMLHttpRequest){
  						
  					},
  					success: function(data, textStatus){
  						try{
  							data = eval("("+data+")");
  							alert(data.message);
  							parent.$.fn.selectTab(0);
  							parent.$.fn.showOrHideTab(1,false);
  						}catch(e){
  							alert(e.description);
  						}
  					},
  					complete: function(XMLHttpRequest, textStatus){
  					},
  					error: function(){
  					}
				});
	  			//*/
	  			$("#form1").attr("action","addSellRecordAction.action");
	  			$("#form1").submit();
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
		/**
	  	 * 删除临时行
	  	 * @param obj 元素本身
	  	 */
	  	$.fn.deletetemp = function(obj){
	  		obj.parent().parent().remove();
	  	};
		
	</script>
  </head>
  
  <body>
    <s:form id="form1" name="form1" method="post" theme="simple" action="">
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<fieldset >
					<legend>交易信息</legend>
						<span>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
							<tr>
								<td height="26" align="right" bgcolor="#FFFFFF">
									<strong>客户名称：</strong>
								</td>
								<td height="26" align="left" bgcolor="#FFFFFF">
									<s:select id="sel_customer"  name ="customer.id"  list="customerInfos" listKey="id"  listValue="customerName" cssStyle="width:200px" headerKey="" headerValue="--- 请选择客户 ---"></s:select>
								</td>
								<td height="26" align="right" bgcolor="#FFFFFF">
									<strong>交易日期：</strong>
								</td>
								<td height="26" align="left" bgcolor="#FFFFFF">
									<s:textfield id="txt_bargainTime" name="sellRecord.bargainTime" cssStyle="width:100px" ></s:textfield>
								</td>
								<td height="26" align="right" bgcolor="#FFFFFF">
									<strong>产品种类：</strong>
								</td>
								<td height="26" align="left" bgcolor="#FFFFFF">
									<s:textfield id="txt_goodsType" name="sellRecord.goodsType" cssStyle="width:100px" ></s:textfield>
								</td>
								<td height="26" align="right" bgcolor="#FFFFFF">
									<strong>销售单号：</strong>
								</td>
								<td height="26" align="left" bgcolor="#FFFFFF">
									<s:textfield id="txt_orderID" name="sellRecord.orderID" cssStyle="width:100px" ></s:textfield>
								</td>
							</tr>
						</table>
						</span>
					</fieldset>
					<fieldset >
					<legend>商品明细</legend>
						<table id="goodsList" width="100%" height="50%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
							<tr>
								<td colspan="12" align="center" width="50px" bgcolor="#FFFFFF">
									<table>
										<tr>
											<td>
												<input name="btn_add" type="button" class="btn_2_3" id="btn_add" value="添加">
											</td>
											<td>
												<input name="btn_delAll" type="button" class="btn_2_3" id="btn_delAll" value="删除所选">
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="center" width="50px" background="<%=basePath%>/images/headerbg.jpg">
		   							<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
		   						</td>
		              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>品 名</strong></td>
		              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>规 格</strong></td>
		              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>克 重</strong></td>
		              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>单 价</strong></td>
		              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>数 量</strong></td>
		              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>预 付</strong></td>
		              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>操作</strong></td>
							</tr>
							<s:if test="sellRecord!=null">
							<s:iterator value="sellRecord.goodsDetials" status="obj">
								<tr>
									 <td height="26" align="center" bgcolor="#FFFFFF" >  
										<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
									</td>
						            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="goodsName"/></td>
						            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="standard"/></td>
						            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="weight"/></td>
						            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="price"/></td>
						            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="number"/></td>
						            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="allPrice"/></td>
						            <td height="26" align="center" bgcolor="#FFFFFF">
										<s:url id="delete_url" action="deleteSellRecordDetialsAction">   
											<s:param name="ids" value="id"></s:param>   
										</s:url>
							         	<a name="del_one" href="javascript:void(0);" url="${delete_url}">删除</a>  
									</td>
					            </tr>
							</s:iterator>
							</s:if>
							<s:else>
							<tr id="no_data">
		              			<td align="center" bgcolor="#FFFFFF" colspan="8" >暂无记录</td>
		        			</tr>
							</s:else>
							
						</table>
					</fieldset>
					<fieldset >
					<legend>结算信息</legend>
						<span>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
							<tr>
								<td height="26" align="right" bgcolor="#FFFFFF">
									<strong>应收总计：</strong>
								</td>
								<td height="26" align="left" bgcolor="#FFFFFF">
									<s:textfield id="txt_receivable" name="sellRecord.receivable" cssStyle="width:250px" ></s:textfield>
								</td>
								<td height="26" align="right" bgcolor="#FFFFFF">
									<strong>实 收：</strong>
								</td>
								<td height="26" align="left" bgcolor="#FFFFFF">
									<s:textfield id="txt_realCollection" name="sellRecord.realCollection" cssStyle="width:250px" ></s:textfield>
								</td>
								<td height="26" align="right" bgcolor="#FFFFFF">
									<strong>欠 款：</strong>
								</td>
								<td height="26" align="left" bgcolor="#FFFFFF">
									<s:textfield  id="txt_debt" name="sellRecord.debt" cssStyle="width:250px" ></s:textfield>
								</td>
							</tr>
						</table>
						</span>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td align="center" >
					<table>
						<tr>
							<td>
								<input name="btn_save" type="button" class="btn_2_3" id="btn_save" value="保存">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</s:form>
  </body>
</html>
