<%@page import="com.boan.crm.groupmanage.service.IPopedomService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.boan.crm.groupmanage.common.UserSession"%>
<%@page import="com.boan.crm.groupmanage.common.MenuKey"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
	String path = request.getContextPath();
	UserSession us = (UserSession) session.getAttribute("userSession");
	WebApplicationContext context = (WebApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	IPopedomService popedomService = (IPopedomService) context.getBean("popedomService");
	boolean b = false;
	boolean sub = false;
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
		
		$(document).find("strong[name='menus']").each(function(index,domEle){
			if(index==0){
				$("tbody[name='submenus']:first").css("display","block");
			}
			$(domEle).css("cursor","hand").click(function(){
				$(document).find("tbody[name='submenus']").each(function(indexSub,domEleSub){
					if(index==indexSub){
						$(domEleSub).css("display","block");
					}else{
						$(domEleSub).css("display","none");
					}
				});
			});
		});
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
						<%
							b = popedomService.isSuperAdministrator(us.getUserId(), String.valueOf(us.getUserType()));
							if (b) {
						%>
						<tr>
							<td height="24" align="left" background="images/menubg.jpg">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/up.gif" width="10" height="12" />
										</td>
										<td><strong name="menus">后台管理</strong>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tbody name="submenus" style="display:none">
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="backstagemanage/companymanage.jsp" target="mainFrame">公司档案</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="backstagemanage/companydeptmanage.jsp" target="mainFrame">公司部门</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="backstagemanage/companyusermanage.jsp" target="mainFrame">公司用户</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="backstagemanage/companyrolemanage.jsp" target="mainFrame">公司职务</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="backstagemanage/companypopedommanage.jsp" target="mainFrame">公司权限</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="backstagemanage/logmanage.jsp" target="mainFrame">系统日志</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						</tbody>
						<%
							}
						%>
						<%
							b = popedomService.isCompanyAdministrator(us.getUserId(), String.valueOf(us.getUserType()) );
							if (b) {
						%>
						<tr>
							<td height="24" align="left" background="images/menubg.jpg">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/up.gif" width="10" height="12" />
										</td>
										<td><strong name="menus">组织机构</strong>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tbody name="submenus" style="display:none">
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="backstagemanage/mycompanymanage.jsp" target="mainFrame">公司档案</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="groupmanage/deptmentmanage.jsp" target="mainFrame">部门管理</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="groupmanage/usermanage.jsp" target="mainFrame">用户管理</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="groupmanage/rolemanage.jsp" target="mainFrame">职务管理</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="groupmanage/popedommanage.jsp" target="mainFrame">权限管理</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						</tbody>
						<%
							}
						%>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.KE_HU_CHA_ZHAO, us.getPopedomKeys()) 
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_KE_HU_CHA_ZHAO, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_DAO_RU_KE_HU, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td height="24" align="left" background="images/menubg.jpg">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/up.gif" width="10" height="12" />
										</td>
										<td><strong name="menus">客户查找</strong>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tbody name="submenus" style="display:none">
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_KE_HU_CHA_ZHAO, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="openCustomerSearchAction.action" target="mainFrame">客户查找</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_DAO_RU_KE_HU, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="importcustomertolib.jsp" target="mainFrame">导入客户库</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						</tbody>
						<%
							}
						%>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.KE_HU_GUAN_LI, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_KE_HU_XIN_XI, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_KE_HU_GEN_JIN, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_KE_HU_HUI_FANG, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_KE_HU_PING_GU, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td height="24" align="left" background="images/menubg.jpg">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/up.gif" width="10" height="12" />
										</td>
										<td><strong name="menus">客户管理</strong>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tbody name="submenus" style="display:none">
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_KE_HU_XIN_XI, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="customer/customermanage.jsp" target="mainFrame">客户信息</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_KE_HU_GEN_JIN, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="customer/allcustomertracemanage.jsp" target="mainFrame">客户跟进</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_KE_HU_HUI_FANG, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="customer/allcustomervisitmanage.jsp" target="mainFrame">客户回访</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_KE_HU_PING_GU, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="customeranalysis/customeranalysismanage.jsp" target="mainFrame">客户评估</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						</tbody>
						<%
							}
						%>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.XIAO_SHOU_GUAN_LI, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_DUAN_XIN_PING_TAI, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_SHI_JIAN_GUAN_LI, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_SHI_CHANG_DIAO_CHA, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_XIAO_SHOU_JI_LU, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td height="24" align="left" background="images/menubg.jpg">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/up.gif" width="10" height="12" />
										</td>
										<td><strong name="menus">销售管理</strong>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tbody name="submenus" style="display:none">
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_DUAN_XIN_PING_TAI, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="sms/smstab.jsp" target="mainFrame">短信平台</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_SHI_JIAN_GUAN_LI, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="openTimePlanListAction.action" target="mainFrame">时间管理</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_SHI_CHANG_DIAO_CHA, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="openMarketInquiryListAction.action" target="mainFrame">市场调查</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_XIAO_SHOU_JI_LU, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="sellrecord/sellrecordtab.jsp" target="mainFrame">销售记录</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						</tbody>
						<%
							}
						%>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.FU_WU_GUAN_LI, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_FU_WU_JI_LU, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_HUI_YUAN_GUAN_LI, us.getPopedomKeys())
									||popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_JI_FEN_GUAN_LI, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td height="24" align="left" background="images/menubg.jpg">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/up.gif" width="10" height="12" />
										</td>
										<td><strong name="menus">服务管理</strong>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tbody name="submenus" style="display:none">
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_FU_WU_JI_LU, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="service/servicelogmanage.jsp" target="mainFrame">服务记录</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_HUI_YUAN_GUAN_LI, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="service/memberinfomanage.jsp" target="mainFrame">会员管理</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						<%
							b = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.SUB_JI_FEN_GUAN_LI, us.getPopedomKeys());
							if (b) {
						%>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="service/pointinfomanage.jsp" target="mainFrame">积分管理</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
						</tbody>
						<%
							}
						%>
						<%
							b = popedomService.isSuperAdministrator( us.getUserId(), String.valueOf(us.getUserType()) );
							if (b) {
						%>
						<tr>
							<td height="24" align="left" background="images/menubg.jpg">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/up.gif" width="10" height="12" />
										</td>
										<td><strong name="menus">数据字典</strong>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tbody name="submenus" style="display:none">
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="datadictionary/data_dict.jsp" target="mainFrame">数据字典</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="datadictionary/provincemanage.jsp" target="mainFrame">省份信息</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="datadictionary/citymanage.jsp" target="mainFrame">城市信息</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="datadictionary/areamanage.jsp" target="mainFrame">地区信息</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						</tbody>
					<%} %>
					<%
						b = popedomService.isCompanyAdministrator( us.getUserId(), String.valueOf(us.getUserType()) );
						if (b) {
					%>
						<tr>
							<td height="24" align="left" background="images/menubg.jpg">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/up.gif" width="10" height="12" />
										</td>
										<td><strong name="menus">数据字典</strong>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tbody name="submenus" style="display:none">
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="fuzzy/fuzzymanage.jsp" target="mainFrame">模糊项设置</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="fuzzy/fuzzyrulemanage.jsp" target="mainFrame">模糊规则设置</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
										</td>
										<td><a href="datadictionary/analysisresultmanage.jsp" target="mainFrame">评估结论设置</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						</tbody>
						<%
							}
						%>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
