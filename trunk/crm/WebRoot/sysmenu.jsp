<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 * All right reserved.
	 */
	/**
	 * @author XXX
	 * @version 1.0
	 * @audit  
	 */
	/**
	 * Modified Person：
	 * Modified Time：
	 * Modified Explain：
	 */
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	request.setCharacterEncoding("utf-8");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" jquery="true" />
		<script type="text/javascript">
		<!--
			$(document).ready(function() {
				var ifrHeight = $("#leftFrame", parent.parent.document).height();
				var ifrHeightTemp = ifrHeight - 50;
				$("#menuArea").height(ifrHeightTemp);
			});
			$(window).resize(function() {
				var ifrHeight = $("#leftFrame", parent.parent.document).height();
				var ifrHeightTemp = ifrHeight - 50;
				$("#menuArea").height(ifrHeightTemp);
			});
		//-->
		</script>
	</head>
	<body>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td style="background-image: url(images/jzywcd.jpg); height: 35px;"></td>
			</tr>
			<tr>
				<td align="center">
					<div id="menuArea" style="overflow: auto; display: block;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>后台管理</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="backstagemanage/companymanage.jsp" target="mainFrame">公司档案</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
											
												<a href="backstagemanage/companydeptmanage.jsp" target="mainFrame">公司部门</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="backstagemanage/companyusermanage.jsp" target="mainFrame">公司用户</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="groupmanage/rolemanage.jsp" target="mainFrame">职务管理</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="groupmanage/popedommanage.jsp" target="mainFrame">权限管理</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="backstagemanage/logmanage.jsp" target="mainFrame">系统日志</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong><a href="sysmanage/datamanage.html"
													target="mainFrame">组织机构</a>
												</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="groupmanage/deptmentmanage.jsp" target="mainFrame">部门管理</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="groupmanage/usermanage.jsp" target="mainFrame">用户管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>客户查找</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="customerReaserch.html" target="mainFrame">客户查找</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>

							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>客户管理</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="clientInformationlist.html" target="mainFrame">客户信息</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="customerFollowing.html" target="mainFrame">客户跟进</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="customerVisiting.html" target="mainFrame">客户回访</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="customerAssemessment.html" target="mainFrame">客户评估</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="resultAnlysis.html" target="mainFrame">评估分析</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>

							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>销售管理</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="sms/smstab.jsp" target="mainFrame">短信平台</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="staffManagement.html" target="mainFrame">时间管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="marketSurvey.html" target="mainFrame">市场调查</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="salesRecord.html" target="mainFrame">销售记录</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>服务管理</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="customertabService.html" target="mainFrame">服务记录</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="membeiship.html" target="mainFrame">会员管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="markCard.html" target="mainFrame">积分管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>数据字典</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="datadictionary/typemanage.jsp" target="mainFrame">客户分类</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="datadictionary/statemanage.jsp" target="mainFrame">客户状态</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="datadictionary/sourcemanage.jsp" target="mainFrame">客户来源</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="datadictionary/mainindustrymanage.jsp" target="mainFrame">主营行业</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="datadictionary/maturitymanage.jsp" target="mainFrame">客户成熟度</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
