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
	  		$('#txt_sendDay').val((new Date()).getFullYear()+"-"+(((new Date()).getMonth()+1)<10 ? "0"+((new Date()).getMonth()+1) : (new Date()).getMonth()+1)+"-"+((new Date()).getDate()<10 ? "0"+(new Date()).getDate() : (new Date()).getDate()));
	  		//日期控件
			$('#txt_sendDay').datetimepicker({showTimepicker: false});
	  		//时间控件
			$('#txt_sendTime').timepicker({
				hourGrid: 4,
				minuteGrid: 10
			});
	  		//字数控件
			$('#SMSContent').artTxtCount();
	  		//人员复选框控制
			$.fn.CheckBoxAll("ids","cbk_all");
			$.fn.UnCheckBoxAll("ids","cbk_all");
			
			$.fn.dynamicsAddPerson();
			
			$.fn.dynamicsAddAllPerson();
			
			$("#chk_use_appellation").click(function(){
				//激活文本框时间计算字数
				$('#SMSContent').trigger('change');
				if($("#chk_use_appellation").attr("checked")){
					$("#sel_one").attr("disabled",true);
					$("#sel_two").attr("disabled",true);
				}else{
					$("#sel_one").attr("disabled",false);
					$("#sel_two").attr("disabled",false);
				}
			});
			$("#sel_two").change(function(){
				//激活文本框时间计算字数
				$('#SMSContent').trigger('change');
			});
			$("#chk_use_hello").click(function(){
				//激活文本框时间计算字数
				$('#SMSContent').trigger('change');
				if($("#chk_use_hello").attr("checked")){
					$("#txt_hello").attr("disabled",true);
				}else{
					$("#txt_hello").attr("disabled",false);
				}
			});
			$("#txt_hello").blur(function(){
				//激活文本框时间计算字数
				$('#SMSContent').trigger('change');
			});
			/*
			$("#chk_use_company").click(function(){
				//激活文本框时间计算字数
				$('#SMSContent').trigger('change');
				
				if($("#chk_use_company").attr("checked")){
					$("#txt_company").attr("disabled",true);
				}else{
					$("#txt_company").attr("disabled",false);
				}
			});
			//*/
			$("#sel_sendType").change(function(){
				var type = $("#sel_sendType").val();
				if(type=="IMMEDIATELY"){
					$("#txt_sendDay").attr("disabled",true);
					$("#txt_sendTime").attr("disabled",true);
					$("#txt_sendDay").hide();
					$("#txt_sendTime").hide();
				}
				if(type=="SCHEDULED"){
					$("#txt_sendDay").attr("disabled",false);
					$("#txt_sendTime").attr("disabled",false);
					$("#txt_sendDay").show();
					$("#txt_sendTime").show();
				}
				if(type=="BIRTHDAY"){
					$("#txt_sendDay").attr("disabled",true);
					$("#txt_sendTime").attr("disabled",false);
					$("#txt_sendDay").hide();
					$("#txt_sendTime").show();
				}
			});
			/*
			$("#txt_company").blur(function(){
				//激活文本框时间计算字数
				$('#SMSContent').trigger('change');
			});
			//*/
	  		
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
	  			//找到所有名称为row_chb并且被选中的checkbox，然后删去其所在的行
	  			$(":checkbox[name='ids']:checked").parent().parent().remove();
	  			$.fn.CheckBoxAll("ids","cbk_all");
	  			if($("#personList tr:has(input[type='checkbox'])").length==1){
	  				$("#no_data").show();
	  			}
	  		});
	  		//发送信息
	  		$.fn.sendInfo ();
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
	  	 * 计算字数
	  	 */
	  	$.fn.artTxtCount = function(){
			var tipWrap = $('#tips');           // 提示消息的容器
			var maxNumber=500;                  // 最大输入字符
			var countClass = 'tips',		    // 定义内部容器的CSS类名
				fullClass = 'js_txtFull',		// 定义超出字符的CSS类名
				disabledClass = 'disabled';		// 定义不可用提交按钮CSS类名
			// 统计字数
			var count = function(){
				var btn = $("#btn_send"),
					val = $(this).val().length,
					
					// 是否禁用提交按钮
					disabled = {
						on: function(){
							btn.removeAttr('disabled').removeClass(disabledClass);
						},
						off: function(){
							btn.attr('disabled', 'disabled').addClass(disabledClass);
						}
					};
				//如果使用了敬语
				if($("#chk_use_appellation").attr("checked")==false){
					val=val + 1 + $("#sel_two option:selected").text().length;
				}
				//如果使用了问候语
				if($("#chk_use_hello").attr("checked")==false){
					val=val+$("#txt_hello").val().length;
				}
				//如果使用公司
				/*
				if($("#chk_use_company").attr("checked")==false){
					val=val+$("#txt_company").val().length;
				}
				//*/
					
				if (val == 0) disabled.off();
				if(val <= maxNumber){
					if (val > 0) disabled.on();
					//tipWrap.html('<span class="' + countClass + '">还能输入<strong>' + (maxNumber - val) + '</strong> 个字</span>');
					tipWrap.html('<span class="' + countClass + '">最多输入500字，已输入约 <strong>' + val + '</strong> 个字</span>');
				}else{
					disabled.off();
					tipWrap.html('<span class="' + countClass + ' ' + fullClass + '">最多输入500字，约超出 <strong>' + (val - maxNumber) + '</strong>个字</span>');
				};
			};
			$(this).bind('keyup change', count);
			
			return this;
		};
		
		/**
	  	 * 动态添加人员
	  	 */
		$.fn.dynamicsAddPerson = function(){
			$("#btn_AddPerson").click(function(){
				var param="?onlycustomer=no";
		  		parent.parent.tipsWindown("添加人员","iframe:sms/selectperson.jsp?"+param ,"650","450","true","","true","no");
		  		parent.parent.$("#windown-close").bind('click',function(){
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
		$.fn.dynamicsAddAllPerson = function(){
			$("#btn_AddAllPerson").click(function(){
				parent.parent.setPerson=function(queryType,queryProvince,querycCity,queryArea,queryCategoryId,queryProgress){
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
										//alert("有重复数据！");
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
				parent.parent.tipsWindown("查询条件","iframe:<%=basePath%>openSelectWindowAction.action","450","200","true","","true","no");
				
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
  					url: "sendInfoAction.action",
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
					<legend>发送内容</legend>
					<table width="100%" style="height: 100%;" border="0" cellspacing="6" cellpadding="0">
						<tr>
							<td colspan="3">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<tr>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<span>
												<select id="sel_one" name="headType" style="width:150px"  >
													<option selected>姓氏</option>
													<option>姓名</option>
													<option>昵称</option>
												</select>
												<select id="sel_two" name="headSuffix" style="width:60px" >
													<option selected>总</option>
													<option>先生</option>
													<option>小姐</option>
													<option>女士</option>
													<option></option>
												</select>
												<input type="checkbox" id="chk_use_appellation"/>不使用
											</span>
											<br/>
											<span>
												<s:textfield id="txt_hello" name="headHello" maxlength="50" cssStyle="width: 208px;" value="您好！"  />
												<input type="checkbox"  id="chk_use_hello"/>不使用
											</span>
											<table width="100%">
												<tr>
													<td colspan="2">
														<s:textarea id="SMSContent" name= "infoContent" cssStyle="width:100%;height:120px"></s:textarea>
														<span id="tips" class="tips"> 最多输入500字，已输入约 <strong>0</strong> 个字</span> </div>
													</td>
												</tr>
												<tr>
													<td>
														点击查询余额：<img src="<%=basePath%>/images/finger.png" ></img>
														<img src="<%=basePath%>/images/yen_coins.png" style="cursor: pointer;" id="getMoney" title="查询余额"></img>
														<strong  id="balance"></strong>
													</td>
													<td align="right">
														<span>
															<s:hidden id="txt_company" name="footContent" maxlength="50" cssStyle="width: 200px;"  ></s:hidden>
															<input type="checkbox"  id="chk_use_company"  style="display: none;"/>
															<!-- 
															<s:textfield id="txt_company" name="footContent" maxlength="50" cssStyle="width: 200px;"  />
															<input type="checkbox"  id="chk_use_company"/>不使用
															 -->
														</span>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<tr>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<span>
												<select id="sel_sendType" name="sendType" style="width:100px">
													<option value="IMMEDIATELY" selected>立即发送</option>
													<option value="SCHEDULED">定时发送</option>
													<option value="BIRTHDAY">按生日发送</option>
												</select>
												<s:textfield id="txt_sendDay" name="sendDay" maxlength="25" cssStyle="width: 100px;display:none;" disabled="true" />
												<s:textfield id="txt_sendTime" name="sendTime" maxlength="25" cssStyle="width: 80px;display:none;" value="09:00" disabled="true"/>
											</span>
											
											<span>
												<input name="btn_AddPerson" type="button" class="btn_5" id="btn_AddPerson" value="查询/添加人员">
												<input name="btn_AddAllPerson" type="button" class="btn_5" id="btn_AddAllPerson" value="添加全部人员">
												<!-- input name="btn_export" type="button" class="btn_2_3" id="btn_export" value="导入号码"> -->
												<input name="btn_send" type="button" class="btn_2_3" id="btn_send" disabled="true" value="发送">
											</span>
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
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>手机号</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>人员类型</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>公司</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>职务</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>昵称</strong></td>
	              			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>操作</strong></td>
						</tr>
						<tr id="no_data">
	              			<td align="center" bgcolor="#FFFFFF" colspan="8" >暂无任务</td>
	        			</tr>
					</table>
					</fieldset>
				</td>
			</tr>
		</table>
		</s:form>
  </body>
</html>
