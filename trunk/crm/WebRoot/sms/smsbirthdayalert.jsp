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
    <title>短信维护</title>
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
	  		
	  		//时间控件
			$('#txt_sendTime').timepicker({
				hourGrid: 4,
				minuteGrid: 10
			});
	  		
	  		//人员复选框控制
			$.fn.CheckBoxAll("ids","cbk_all");
			$.fn.UnCheckBoxAll("ids","cbk_all");
			
			$.fn.dynamicsAddPerson();
			$.fn.dynamicsAddAllPerson();
			
			//清空按钮事件
	  		$("#btn_clear").click(function(){
	  			$("#no_data").show();
	  			$("#personList tr:has(input[type='checkbox'])").each(function(i){
	  				if(i!=0){
	  					$(this).remove();
	  				}
	  			});
	  			$.fn.CheckBoxAll("ids","cbk_all");
	  			
	  		});
	  		//单个删除行
	  		$("a:contains('删除')").live("click",function(){
	  			$(this).parent().parent().remove();
	  			$.fn.CheckBoxAll("ids","cbk_all");
	  			if($("#personList tr:has(input[type='checkbox'])").length==1){
	  				$("#no_data").show();
	  			}
	  			return false;
	  		});
	  		//删除所选
	  		$("#btn_delAll").click(function(){
	  			//找到所有名称为row_chb并且被选中的checkbox，然后删去其所在的行
	  			var flag=true;
  				$("input[name='ids']").each(function(){
  					if($(this).attr('checked')){
  						flag=false;
  						return false;
  					}
  				});
  				if(flag){
  					alert('请选择所要删除记录！');
  					return false;
  				}
	  			$(":checkbox[name='ids']:checked").parent().parent().remove();
	  			$.fn.CheckBoxAll("ids","cbk_all");
	  			if($("#personList tr:has(input[type='checkbox'])").length==1){
	  				$("#no_data").show();
	  			}
	  		});
	  		//发送信息
	  		$.fn.sendInfo();
	  		
	  		//查询余额
	  		$.fn.getMoney();
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
	  	 * 动态添加人员
	  	 */
		$.fn.dynamicsAddPerson = function(){
			$("#btn_AddPerson").click(function(){
		  		var param="?onlycustomer=yes";
		  		parent.parent.parent.tipsWindown("添加人员","iframe:sms/selectperson.jsp"+param ,"650","450","true","","true","no");
		  		parent.parent.parent.$("#windown-close").bind('click',function(){
		  			var personIds = $.cookie('personIds'); // 读取 cookie中的被选择的人员Id
		  			$.cookie('personIds', '', { expires: -1 }); //读取完毕后删除cookie
		  			if(personIds!=null && personIds.length>0){
		  				$.ajax({
		  					type:"post",
		  					url: "loadCustomerInfoForAjaxAction.action",
		  					data:{personIds:personIds},
		  					beforeSend: function(XMLHttpRequest){
		  					},
		  					success: function(data, textStatus){
		  						try{
		  							//将字符串转换为json对象
		  							data = eval("("+data+")");
		  							$.each(data.customerInfoList,function(i,value){
		  								if($("#"+value.id).length==0){ 
			  								var row="";
			  								row=row+"<tr>";
			  					  			row=row+"<td align='center' bgcolor='#FFFFFF' >";  
			  					  			row=row+"<input type='checkbox' name='ids'/>";
			  					  			row=row+"<input type='hidden' id='"+value.id+"' name='selectedIds' value='"+value.id+"'/>";
			  					  			row=row+"</td>";
			  					  		row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.name==null ? "" : value.name) +"</td>";
			  					  		var lunar = value.isLunarCalender=="0"?"(阴历)":"(阳历)";
			  					  		row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.birthday==null ? "" : value.birthday.substring(0,10)+"<font color='red'>"+lunar) +"</font></td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.phone==null ? "" : value.phone) +"</td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.categoryId==1 ? "客户" : "工作人员" )+"</td>";
		  					  		    row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.unit==null ? "" : value.unit )+"</td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.post==null ? "" : value.post)+"</td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.nickname==null ? "" : value.nickname)+"</td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'><a id='del_one' href='javascript:void(0);'>删除</a></td>";
			  					  			row=row+"</tr>";
			  					  			$("#no_data").hide();
			  					  		    $("#personList tr:first").append(row);
			  					  		    $("#cbk_all").attr("checked", false);
			  				  			    $("#cbk_all").attr("disabled",false);
		  								}else{
		  									alert("有重复数据！");
		  								}
	  							    });
		  						}catch(e){
		  							alert(e.description);
		  						}
		  					},
		  					complete: function(XMLHttpRequest, textStatus){
		  					},
		  					error: function(){
		  					}
		  				});
		  			}
		  			/*
		  			//刷新页面
					var url = window.location.href;
						var array=url.split("?");
						url = array[0]+"?"+param;
					window.location.href=url;
					*/
				});
			});
		};
		
		
		/**
	  	 * 动态添加全部人员
	  	 */
	  	 /*
		$.fn.dynamicsAddAllPerson = function(){
			$("#btn_AddAllPerson").click(function(){
 				$.ajax({
 					type:"post",
 					url: "loadCustomerInfoForAjaxAction.action",
 					data:{personIds:"customer"},
 					beforeSend: function(XMLHttpRequest){
 					},
 					success: function(data, textStatus){
 						try{
 							//将字符串转换为json对象
 							data = eval("("+data+")");
 							$.each(data.customerInfoList,function(i,value){
 								if($("#"+value.id).length==0){
  								var row="";
  								row=row+"<tr>";
  					  			row=row+"<td align='center' bgcolor='#FFFFFF' >";  
  					  			row=row+"<input type='checkbox' name='ids'/>";
  					  			row=row+"<input type='hidden' id='"+value.id+"' name='selectedIds' value='"+value.id+"'/>";
  					  			row=row+"</td>";
  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.name==null ? "" : value.name) +"</td>";
  					  			var lunar = value.isLunarCalender=="0"?"(阴历)":"(阳历)";
  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.birthday==null ? "" : value.birthday.substring(0,10)+"<font color='red'>"+lunar) +"</font></td>";
  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.phone==null ? "" : value.phone) +"</td>";
  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.categoryId==1 ? "客户" : "工作人员" )+"</td>";
  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.unit==null ? "" : value.unit )+"</td>";
  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.post==null ? "" : value.post)+"</td>";
  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.nickname==null ? "" : value.nickname)+"</td>";
  					  			row=row+"<td align='center' bgcolor='#FFFFFF'><a id='del_one' href='javascript:void(0);'>删除</a></td>";
  					  			row=row+"</tr>";
  					  			$("#no_data").hide();
  					  		    $("#personList tr:first").append(row);
  					  		    $("#cbk_all").attr("checked", false);
  				  			    $("#cbk_all").attr("disabled",false);
 								}else{
 									alert("有重复数据！");
 								}
							    });
 						}catch(e){
 							alert(e.description);
 						}
 					},
 					complete: function(XMLHttpRequest, textStatus){
 					},
 					error: function(){
 					}
 				});
			});
		};
		//*/
		/**
	  	 * 动态添加全部人员
	  	 */
		$.fn.dynamicsAddAllPerson = function(){
			$("#btn_AddAllPerson").click(function(){
				parent.parent.parent.setPerson=function(queryType,queryProvince,querycCity,queryArea,queryCategoryId,queryProgress){
					$.ajax({
						type:"post",
						url: "loadCustomerInfoForAjaxAction.action",
						data:{personIds:queryType,queryProvince:queryProvince,querycCity:querycCity,queryArea:queryArea,queryCategoryId:queryCategoryId,queryProgress:queryProgress},
						beforeSend: function(XMLHttpRequest){
						},
						success: function(data, textStatus){
							try{
								//将字符串转换为json对象
								data = eval("("+data+")");
								$.each(data.customerInfoList,function(i,value){
									if($("#"+value.id).length==0){
		  								var row="";
		  								row=row+"<tr>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF' >";  
		  					  			row=row+"<input type='checkbox' name='ids'/>";
		  					  			row=row+"<input type='hidden' id='"+value.id+"' name='selectedIds' value='"+value.id+"'/>";
		  					  			row=row+"</td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.name==null ? "" : value.name) +"</td>";
		  					  			var lunar = value.isLunarCalender=="0"?"(阴历)":"(阳历)";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.birthday==null ? "" : value.birthday.substring(0,10)+"<font color='red'>"+lunar) +"</font></td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.phone==null ? "" : value.phone) +"</td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.categoryId==1 ? "客户" : "工作人员" )+"</td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.unit==null ? "" : value.unit )+"</td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.post==null ? "" : value.post)+"</td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'>"+(value.nickname==null ? "" : value.nickname)+"</td>";
		  					  			row=row+"<td align='center' bgcolor='#FFFFFF'><a id='del_one' href='javascript:void(0);'>删除</a></td>";
		  					  			row=row+"</tr>";
		  					  			$("#no_data").hide();
		  					  		    $("#personList tr:first").append(row);
		  					  		    $("#cbk_all").attr("checked", false);
		  				  			    $("#cbk_all").attr("disabled",false);
		 								}else{
		 									alert("有重复数据！");
		 								}
								 });
							}catch(e){
								alert(e.description);
							}
						},
						complete: function(XMLHttpRequest, textStatus){
						},
						error: function(){
						}
					});
				};
				parent.parent.parent.tipsWindown("查询条件","iframe:<%=basePath%>openSelectWindowAction.action","450","200","true","","true","no");
				
			});
		};
		
		
		/**
	  	 * 发送信息
	  	 */
		$.fn.sendInfo = function(){
			$("#btn_send").click(function(){
				if($("input[name='selectedIds']").length==0){
					alert("您还没有添加人员！");
					$("#btn_AddPerson").focus();
					return false;
				}
				$.ajax({
  					type:"post",
  					url: "sendInfoBeforeTimeAction.action",
  					data:$("#form1").serialize(),
  					beforeSend: function(XMLHttpRequest){
  						
  					},
  					success: function(data, textStatus){
  						try{
  							data = eval("("+data+")");
  							if(data.SMSBalance!="303"){
  								$("#balance").html('<font color="red">&nbsp;&nbsp;当前短信余额：<strong>'+data.SMSBalance+'</strong>元，每条短信费用为0.1元。</font>');
  							}else{
  								$("#balance").html('<font color="red">网络故障，请稍后再试！</font>');
  							}
  						}catch(e){
  							alert(e.description);
  						}
  					},
  					complete: function(XMLHttpRequest, textStatus){
  						alert("发送完毕！");
  					},
  					error: function(){
  					}
				});
			});
		};
		
		/**
	  	 * 获取余额
	  	 */
		$.fn.getMoney = function(){
			$("#getMoney").click(function(){
				$.ajax({
  					type:"post",
  					url: "queryBalanceAction.action",
  					beforeSend: function(XMLHttpRequest){
  					},
  					success: function(data, textStatus){
  						try{
  							data = eval("("+data+")");
  							if(data.SMSBalance!="303"){
  								$("#balance").html('<font color="red">&nbsp;&nbsp;当前短信余额：<strong>'+data.SMSBalance+'</strong>元，每条短信费用为0.1元。</font>');
  							}else{
  								$("#balance").html('<font color="red">网络故障，请稍后再试！</font>');
  							}
  						}catch(e){
  							$("#balance").html('<font color="red">网络故障，请稍后再试！</font>');
  							alert(e.description);
  						}
  					},
  					complete: function(XMLHttpRequest, textStatus){
  					},
  					error: function(){
  						$("#balance").html('<font color="red">网络故障，请稍后再试！</font>');
  					}
				});
			});
		};
	</script>
  </head>
  
  <body>
    <s:form id="form1" name="form1" method="post" theme="simple" action="">
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<fieldset >
					<legend>发送设置</legend>
					<table width="100%" style="height: 100%;" border="0" cellspacing="6" cellpadding="0">
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<tr>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<span>
												提前
												<select id="sel_beforeTime" name="beforeTime" style="width:100px">
													<option value="ONE_DAY" selected>一天</option>
													<option value="TWO_DAY">两天</option>
													<option value="ONT_WEEK">一周</option>
													<option value="FIFTEEN_DAY">15天</option>
												</select>
												<s:textfield id="txt_sendTime" name="sendTime" maxlength="25" cssStyle="width: 80px;" value="09:00"/>
												通知工作人员
												&nbsp;&nbsp;&nbsp;
												<input name="btn_AddPerson" type="button" class="btn_5" id="btn_AddPerson" value="查询/选择客户">
												<input name="btn_AddAllPerson" type="button" class="btn_5" id="btn_AddAllPerson" value="选择全部客户">
												<input name="btn_send" type="button" class="btn_2_3" id="btn_send" value="确定">
											</span>
											<br/>
											<br/>
												<img src="<%=basePath%>/images/yen_coins.png" style="cursor: pointer;" id="getMoney"   title="查询余额"></img>
												<strong  id="balance"></strong>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td>
					<fieldset >
					<legend>发送任务</legend>
					<span>
						<input name="btn_clear" type="button" class="btn_2_3" id="btn_clear" value="清空">
						<input name="btn_delAll" type="button" class="btn_2_3" id="btn_delAll" value="删除所选">
					</span>
					<table id="personList" width="100%" height="50%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
						<tr>
							<td align="center" width="50px" background="<%=basePath%>/images/headerbg.jpg">
	   							<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
	   						</td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>接收人</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>生日</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>手机号</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>人员类型</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>公司</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>职务</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>昵称</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>操作</strong></td>
						</tr>
						<tr id="no_data">
	              			<td align="center" bgcolor="#FFFFFF" colspan="10" >暂无任务</td>
	        			</tr>
					</table>
					</fieldset>
				</td>
			</tr>
		</table>
		</s:form>
  </body>
</html>
