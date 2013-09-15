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
<title>客户基本信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<j:scriptlink css="true" jmessagebox="true" jquery="true"
	tipswindow="true" validate="true" />
<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _customer_submit = {
				rules: {
					"customerInfo.customerName":{required:true,strangecode:true},
					"customerInfo.companyFullName":{strangecode:true},
					"customerInfo.fax":{strangecode:true},
					"customerInfo.sourceId":{required:true},
					"customerInfo.categoryId":{required:true},
					"customerInfo.progressId":{required:true},
					"customerInfo.maturityId":{required:true},
					"customerInfo.levelId":{required:true},
					"customerInfo.address":{required:true,strangecode:true},
					"customerInfo.mainIndustry":{required:true,strangecode:true},
					"customerInfo.introduceTimes":{number:true}
				}
			};
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
				$.validator.setDefaults({
					debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
				    errorPlacement:function(error, element) {},
					invalidHandler: function(form, validator) {
			        	$.each(validator.invalid,function(key,value){
			            	alert(value);document.getElementById(key).focus();return false;
			        	}); 
			    	}
				})
				$.fn.save();
		  		$.fn.close();
		  		$.fn.initpage();
		  		
		  		loadCity($("#province").val());
		  		
		  		$("#province").change(function() {
	                loadCity($("#province").val());
	            });
		  		$("#city").change(function() {
	                loadArea($("#city").val());
	            });
		  		 function loadCity(parentid) {
		                $.ajax({
		                    url:"<%=basePath%>datadictionary/cityinfoservice.action?provinceId=" + parentid,
		                    type: 'POST',
		                    dataType: 'JSON',
		                    timeout: 5000,
		                    error: function() { alert('Error loading data!'); },
		                    success: function(msg) {
		                        $("#city").empty();
		                        $.each(eval(msg), function(i, item) {
		                            $("<option value='" + item.id + "'>" + item.name + "</option>").appendTo($("#city"));
		                        });
		                        
		                        loadArea($("#city").val());
		                    }
		                });
		                
		                
		            }
		  		function loadArea(parentid) {
	                $.ajax({
	                    url:"<%=basePath%>datadictionary/areainfoservice.action?cityId=" + parentid,
	                    type: 'POST',
	                    dataType: 'JSON',
	                    timeout: 5000,
	                    error: function() { alert('Error loading data!'); },
	                    success: function(msg) {
	                        $("#area").empty();
	                        $.each(eval(msg), function(i, item) {
	                            $("<option value='" + item.id + "'>" + item.name + "</option>").appendTo($("#area"));
	                        });
	                    }
	                });
	            }
		  		
		  		$("#addPersonBtn").click(function(){
					parent.parent.parent.tipsWindown("添加联系人信息","iframe:customer/contractPersonInfo.action?customerId=" + $("#customerId").val(),"460","400","true","","true","no");
					parent.parent.parent.$("#windown-close").bind('click',function(){
						window.location.href= window.location.href;
					});
					//window.parent.location.href = "customertabinfo.action?id="+ form1.customerId.value;
			
				});
		  		
		  		/**
		  		 * 修改客户信息
		  		 */
		  		$('a[name="edit"]').each(function(){
		  			$(this).click(function(){
		  				var url = $(this).attr("url");
		  				parent.parent.tipsWindown("修改联系人信息","iframe:" + url + "&customerId=" + $("#customerId").val(),"460","400","true","","true","no");
		  				parent.parent.$("#windown-close").bind('click',function(){
		  					window.location.href= window.location.href;
						});
						
		  				//window.parent.location.href = url;
		  			});
		  		});
		  		
		  		
		  		/**
		  		 * 删除客户信息
		  		 */
		  		$('a[name="delRecord"]').each(function(){
		  			$(this).click(function(){
		  				var url = $(this).attr("url");
		  				var id = $(this).attr("id");
		  				/*form1.action = url;
						form1.customerId_t.value = $("#customerId").val();
						form1.target = "_parent";
		               	form1.submit();*/
		               	$.ajax({
		                    url:url,
		                    type: 'POST',
		                    dataType: 'JSON',
		                    timeout: 5000,
		                    error: function() { alert('Error loading data!'); },
		                    success: function(msg) {
		                    	alert("删除成功！");
		                        $("#tr"+id).empty();
		                    }
		                });
		  				//window.parent.location.href = url;
		  			});
		  		});

		  	});
			/**
		  	 * 保存
		  	 */
			$.fn.save = function(){
				$("#addBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _customer_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
					//if( $.trim( $("#companyId").val() ) != ""){
					form1.action = "customer/saveCustomer.action";
					//}else{
		             //  	form1.action = "saveCustomer.action";					
					//}
					form1.target = "_parent";
					form1.sourceName.value = $("#sourceId").text();
					form1.categoryName.value = $("#categoryId").text();
					form1.progressName.value = $("#progressId").text();
					form1.maturityName.value = $("#maturityId").text();
					form1.levelName.value = $("#levelId").text();
	               	form1.submit();
          		});
          	}
			
			
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			//parent.$("#windown-close").click();
		  			parent.location.href = "customersearch.jsp";
		  		});
			}
			/**
			 * 初始化页面
			 */
			$.fn.initpage = function(){
				$("#txt_companyName").focus();
				
			}
		</script>
<style type="text/css">
.auto-style1 {
	background: #d3eaef;
	font-size: 18px;
	font-family: 仿宋;
}

.auto-style2 {
	font-size: x-large;
}

.auto-style3 {
	text-align: right;
}
</style>
</head>
<body>
	<s:form id="form1" name="form1" method="post" theme="simple">
		<s:hidden id="customerId" name="customerInfo.id"></s:hidden>
		<s:hidden id="sourceName" name="customerInfo.source"></s:hidden>
		<s:hidden id="categoryName" name="customerInfo.category"></s:hidden>
		<s:hidden id="progressName" name="customerInfo.progress"></s:hidden>
		<s:hidden id="maturityName" name="customerInfo.maturity"></s:hidden>
		<s:hidden id="levelName" name="customerInfo.level"></s:hidden>
		<s:hidden id="customerId_t" name="customerId"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td style="height: 50px"><table width=100%>
						<tr>
							<td style="width: 600px; height: 21px"></td>
						</tr>
						<tr>
							<td align="center" style="width: 100%"><strong><span
									class="auto-style2">客户信息编辑</span> </strong>
							</td>
						</tr>
						<tr>
							<td style="width: 600px"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><fieldset>
						<legend>
							<span>基本信息</span>
						</legend>
						<table>
							<tr>
								<td><table cellpadding="5" cellspacing="3">
										<tr>
											<td></td>
											<td align="center" nowrap>客户名称：</td>
											<td><s:textfield style="width:140px"
													name="customerInfo.customerName" readOnly="true"></s:textfield>
											</td>
											<td align="center" nowrap>公司全名：</td>
											<td><s:textfield style="width:140px"
													name="customerInfo.companyFullName" readOnly="true"></s:textfield>
											</td>
											<td align="center" nowrap>公司传真：</td>
											<td><s:textfield style="width:140px"
													name="customerInfo.fax" readOnly="true"></s:textfield>
											</td>
											<td align="center" nowrap>客户来源：</td>
											<td><s:select list="listSource" listKey="id"
													listValue="name" value="customerInfo.sourceId"
													id="sourceId" name="customerInfo.sourceId"
													cssStyle="width:130px" headerKey=""
													headerValue="--请选择客户来源--" disabled="true"></s:select></td>
										</tr>
										<tr>
											<td></td>
											<td align="center">客户分类：</td>
											<td><s:select list="listCategory" listKey="id"
													listValue="name" value="customerInfo.categoryId"
													id="categoryId" name="customerInfo.categoryId"
													cssStyle="width:140px" headerKey=""
													headerValue="--请选择客户分类--" disabled="true"></s:select></td>
											<td align="center">业务进展：</td>
											<td><s:label name="customerInfo.progress"></s:label>
											</td>
											<td align="center">忠诚度：</td>
											<td><s:label name="customerInfo.maturityId"></s:label>
											</td>
											<td align="center">开发程度：</td>
											<td><s:select list="listLevel"
													listKey="id" listValue="name" value="customerInfo.levelId"
													id="levelId" name="customerInfo.levelId"
													cssStyle="width:130px" headerKey=""
													headerValue="--请选择开发程度--" disabled="true"></s:select>
											</td>
										</tr>
										<tr>
											<td></td>
											<td align="center">业务员：</td>
											<td><s:select list="userList" listKey="id"
													listValue="userCName" value="customerInfo.salesmanId"
													id="salesmanId" name="customerInfo.salesmanId"
													cssStyle="width:140px" headerKey=""
													headerValue="--请选择业务员--" disabled="true"></s:select>
											</td>
											<td align="center" nowrap>其他业务员：</td>
											<td><s:select list="userList" listKey="id"
													listValue="userCName" value="customerInfo.otherSalesmanId"
													id="salesmanId" name="customerInfo.otherSalesmanId"
													cssStyle="width:140px" headerKey=""
													headerValue="--请选择业务员--" disabled="true"></s:select>
											</td>
											<td align="center">建档时间：</td>
											<td><s:textfield type="text" style="width:140px"
													name="customerInfo.registerTime" id="registerTime" readOnly="true"></s:textfield>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td><table cellpadding="5" cellspacing="3">
										<tr>
											<td></td>
											<td align="center">所 在 地：</td>
											<td><s:select list="listProvince" listKey="id"
													listValue="provinceName" value="customerInfo.province"
													id="province" name="customerInfo.province"
													cssStyle="width:130px" headerKey="" headerValue="请选择省份" disabled="true"></s:select>
											</td>
											<td><select value="customerInfo.city" id="city"
												name="customerInfo.city" style="width:126px" disabled="true">
											</select>
											</td>
											<td><select value="customerInfo.district" id="area"
												name="customerInfo.district" style="width:126px" disabled="true">
											</select>
											</td>
											<td>具体地址：</td>
											<td><s:textfield type="text" style="width:380px"
													name="customerInfo.address" id="registerTime" readOnly="true"></s:textfield>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td><table cellpadding="5" cellspacing="3">
										<tr>
											<td></td>
											<td align="center">主营行业：</td>
											<td><s:textfield type="text" style="width:410px"
													name="customerInfo.mainIndustry" id="mainIndustry" readOnly="true"></s:textfield>
											</td>
											<td align="center">邮 编：</td>
											<td><s:textfield type="text" style="width:395px"
													name="customerInfo.postCode" id="postCode" readOnly="true"></s:textfield>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td><table cellpadding="5" cellspacing="3">
										<tr>
											<td></td>
											<td align="center">介绍客户次数：</td>
											<td><s:textfield type="text" style="width:140px"
													name="customerInfo.introduceTimes" id="introduceTimes" readOnly="true"></s:textfield>
											</td>
											<td align="center"></td>
											<td></td>
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
					<table>
						<s:if test='listPerson != null && listPerson.size() > 0'>
							<s:iterator value="listPerson" status="obj">
								<s:url id="del_url" action="customer/deletePersonInfo.action">
									<s:param name="personId" value="id"></s:param>
								</s:url>
								<tr id="tr<s:property value='id'/>">
									<td>
										<fieldset>
											<legend>
												<span>联系人信息</span> 
											</legend>
											<table>
												<tr>
													<td>
														<table cellpadding="5" cellspacing="3">
															<tr>
																<td></td>
																<td align="center" width="100px">姓 名：</td>
																<td width="200px"><s:property value="personName" />
																</td>
																<td align="center" width="100px">部门/职务：</td>
																<td width="200px"><s:property value="deptOrDuty" />
																</td>
																<td align="center" width="100px">手 机：</td>
																<td width="200px"><s:property value="phone" />
																</td>
																<td align="center" width="100px">固定电话：</td>
																<td width="200px"><s:property value="tel" />
																</td>
															</tr>
															<tr>
																<td></td>
																<td align="center" width="100px">昵 称：</td>
																<td width="200px"><s:property value="nickName" />
																</td>
																<td align="center" width="100px">生 日：</td>
																<td width="200px"><s:property value="birthday" />
																</td>
																<td align="center" width="100px">Q Q：</td>
																<td width="200px"><s:property value="qq" />
																</td>
																<td align="center" width="100px">邮 箱：</td>
																<td width="200px"><s:property value="email" />
																</td>
															</tr>
														</table></td>
												</tr>
											</table>
										</fieldset></td>
								</tr>
							</s:iterator>
						</s:if>
					</table></td>
			</tr>
		</table>
		</td>
		</tr>
		<tr>
			<td style="height: 20px"></td>
		</tr>
		<tr>
			<td></td>
			<td align="center"><table align="center">
					<tr>
						<td style="height: 10px"></td>
					</tr>
					<tr>
						<td align="center"><input type="button" name="closeBtn" id="closeBtn" value="关闭" class="btn_2_3" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</table>
	</s:form>
</body>
</html>
