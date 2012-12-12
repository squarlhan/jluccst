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
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
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
											<td align="right" nowrap><strong>客户名称：</strong></td>
<td>
												<s:label name="customerInfo.customerName"></s:label>											</td>
											<td align="right" nowrap><strong>公司全名：</strong></td>
			  <td><s:label name="customerInfo.companyFullName"></s:label>											</td>
											<td align="right" nowrap><strong>公司传真：</strong></td>
<td><s:label name="customerInfo.fax"></s:label>											</td>
											<td align="right" nowrap><strong>客户来源：</strong></td>
<td><span id="sourcename"></span>
											<s:select list="listSource" listKey="id"
													listValue="name" value="customerInfo.sourceId"
													id="sourceId" name="customerInfo.sourceId"
													cssStyle="width:130px; display:none" headerKey=""
													headerValue="--请选择客户来源--" disabled="true"></s:select>
												<script type="text/javascript">
													$("#sourcename").html($("#sourceId").find("option:selected").text());
												</script>												</td>
										</tr>
										<tr>
											<td></td>
											<td align="right"><strong>客户分类：</strong></td>
										  <td>
											<span id="categoryname"></span>
											<s:select list="listCategory" listKey="id"
													listValue="name" value="customerInfo.categoryId"
													id="categoryId" name="customerInfo.categoryId"
													cssStyle="width:140px; display:none" headerKey=""
													headerValue="--请选择客户分类--" disabled="true"></s:select>
													<script type="text/javascript">
													$("#categoryname").html($("#categoryId").find("option:selected").text());
												</script>													</td>
											<td align="right"><strong>业务进展：</strong></td>
										  <td>
											<span id="progressname"></span>
											<s:select list="listProgress" listKey="id"
													listValue="name" value="customerInfo.progressId"
													id="progressId" name="customerInfo.progressId"
													cssStyle="width:140px; display:none" headerKey=""
													headerValue="--请选择业务进展--" disabled="true"></s:select>
													<script type="text/javascript">
													$("#progressname").html($("#progressId").find("option:selected").text());
												</script>											</td>
											<td align="right"><strong>成熟度：</strong></td>
										  <td>
											<span id="maturityname"></span><s:select list="listMaturity" listKey="id"
													listValue="name" value="customerInfo.maturityId"
													id="maturityId" name="customerInfo.maturityId"
													cssStyle="width:140px; display:none" headerKey=""
													headerValue="--请选择成熟度--" disabled="true"></s:select>
													<script type="text/javascript">
													$("#maturityname").html($("#maturityId").find("option:selected").text());
												</script>											</td>
											<td align="right"><strong>开发程度：</strong></td>
										  <td>
											<span id="levelname"></span><s:select list="listLevel"
													listKey="id" listValue="name" value="customerInfo.levelId"
													id="levelId" name="customerInfo.levelId"
													cssStyle="width:130px; display:none" headerKey=""
													headerValue="--请选择开发程度--" disabled="true"></s:select>
													<script type="text/javascript">
													$("#levelname").html($("#levelId").find("option:selected").text());
												</script>											</td>
										</tr>
										<tr>
											<td></td>
											<td align="right"><strong>业务员：</strong></td>
<td><span id="salesmanname"></span><s:select list="userList" listKey="id"
													listValue="userCName" value="customerInfo.salesmanId"
													id="salesmanId" name="customerInfo.salesmanId"
													cssStyle="width:140px; display:none" headerKey=""
													headerValue="--请选择业务员--" disabled="true"></s:select>
													<script type="text/javascript">
													$("#salesmanname").html($("#salesmanId").find("option:selected").text());
												</script>											</td>
											<td align="right" nowrap><strong>其他业务员：</strong></td>
								  <td><span id="otherSalesmanName"></span><s:select list="userList" listKey="id"
													listValue="userCName" value="customerInfo.otherSalesmanId"
													id="otherSalesmanId" name="customerInfo.otherSalesmanId"
													cssStyle="width:140px; display:none" headerKey=""
													headerValue="--请选择业务员--" disabled="true"></s:select>
													<script type="text/javascript">
													if($("#otherSalesmanId").val()!="")
														$("#otherSalesmanName").html($("#otherSalesmanId").find("option:selected").text());
												</script>											</td>
											<td align="right"><strong>建档时间：</strong></td>
										  <td><s:label name="customerInfo.registerTime"></s:label>											</td>
										</tr>
									</table>
							  </td>
							</tr>
							<tr>
								<td><table cellpadding="5" cellspacing="3">
										<tr>
											<td></td>
											<td align="right"><strong>所 在 地：</strong></td>
<td><span id="provincename"></span><s:select list="listProvince" listKey="id"
													listValue="provinceName" value="customerInfo.province"
													id="province" name="customerInfo.province"
													cssStyle="width:130px; display:none" headerKey="" headerValue="请选择省份" disabled="true"></s:select>
												<script type="text/javascript">
													$("#provincename").html($("#province").find("option:selected").text());
												</script>
											</td>
											<td>
											<span id="cityname"></span><select value="customerInfo.city" id="city"
												name="customerInfo.city" style="width:126px; display:none" disabled="true">
											</select>
											<script type="text/javascript">
													$("#cityname").html($("#city").find("option:selected").text());
												</script>
											</td>
											<td><span id="areaname"></span><select value="customerInfo.district" id="area"
												name="customerInfo.district" style="width:126px; display:none" disabled="true">
											</select>
											<script type="text/javascript">
													$("#areaname").html($("#area").find("option:selected").text());
												</script>
											</td>
											<td align="right"><strong>具体地址：</strong></td>
										  <td><s:label name="customerInfo.address" ></s:label>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td><table cellpadding="5" cellspacing="3">
										<tr>
											<td></td>
											<td align="right"><strong>主营行业：</strong></td>
										  <td><s:label name="customerInfo.mainIndustry"></s:label>
											</td>
											<td align="right"><strong>邮 编：</strong></td>
										  <td><s:label name="customerInfo.postCode"></s:label>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td><table cellpadding="5" cellspacing="3">
										<tr>
											<td></td>
											<td align="right"><strong>介绍客户次数：</strong></td>
										  <td><s:label name="customerInfo.introduceTimes"></s:label>
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
					<table width="100%">
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
											<table width="100%">
										  <tr>
													<td>
														<table width="100%" cellpadding="5" cellspacing="3">
<tr>
																<td></td>
																<td align="right"><strong>姓 名：</strong></td>
<td><s:property value="personName" />																</td>
																<td align="right"><strong>部门/职务：</strong></td>
												  <td><s:property value="deptOrDuty" />																</td>
																<td align="right"><strong>手 机：</strong></td>
								  <td><s:property value="phone" />																</td>
																<td align="right"><strong>固定电话：</strong></td>
  <td><s:property value="tel" />																</td>
															</tr>
															<tr>
																<td></td>
																<td align="right"><strong>昵 称：</strong></td>
															  <td><s:property value="nickName" />																</td>
																<td align="right"><strong>生 日：</strong></td>
															  <td><s:property value="birthday" />																</td>
																<td align="right"><strong>Q Q：</strong></td>
															  <td><s:property value="qq" />																</td>
																<td align="right"><strong>邮 箱：</strong></td>
															  <td><s:property value="email" />																</td>
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
		</table>
	</s:form>
</body>
</html>
