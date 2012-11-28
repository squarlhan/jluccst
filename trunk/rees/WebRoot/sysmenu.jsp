<%@page import="com.boan.rees.group.common.MenuKey"%>
<%@page import="com.boan.rees.group.service.IPopedomService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.boan.rees.group.common.UserSession"%>
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
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
	UserSession us = ( UserSession ) session.getAttribute( "userSession" );
	WebApplicationContext context = ( WebApplicationContext ) this.getServletContext().getAttribute( WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE );
	IPopedomService popedomService = ( IPopedomService ) context.getBean( "popedomService" );
	boolean b = false;
	boolean sub = false;
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" jquery="true" />
		<script type="text/javascript">

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
							<%
								b = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SHU_JU_GUAN_LI, us.getPopedomKeys() );
								if( b )
								{
							%>
							
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>数据管理</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
								<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_SHU_JU_GUAN_LI, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="datamanage/datamanage.jsp" target="mainFrame">数据管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
								<%} %>
								<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SHU_JU_CHA_KAN, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="datamanage/datamanageview.jsp" target="mainFrame">数据查看</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
								<%} %>
								<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_SHE_BEI_GUAN_LI, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="datamanage/devicemanage.jsp" target="mainFrame">设备管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
								<%} %>
								<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_TE_SHU_SHE_BEI_GUI_ZE, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="expertsystem/devicerule/special_device_rule_manage.jsp" target="mainFrame">特殊设备规则管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
								<%} %>
							<%
								}
							%>
							<%
								b = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.ZHUAN_JIA_XI_TONG, us.getPopedomKeys() );
								if( b )
								{
							%>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>专家系统</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_GUI_ZE_XIAN_XIANG, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="expertsystem/resultmanage.jsp" target="mainFrame">规则现象设置</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%} %>
							<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_GUI_ZE_YUAN_YIN, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="expertsystem/reasonmanage.jsp" target="mainFrame">规则原因设置</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%} %>
							<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_GUI_ZE_JIAN_YI, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="expertsystem/advicemanage.jsp" target="mainFrame">规则建议设置</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%} %>
							<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_GUI_ZE_SHE_ZHI, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="expertsystem/expertmanage.jsp" target="mainFrame">规则设置</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%} %>
							<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_SHE_BEI_GUI_ZE, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="base/devicerulemanage.jsp" target="mainFrame">设备规则</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%} %>
							<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_GU_ZHANG_ZHEN_DUAN, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="expertsystem/failurediagnosismanage.jsp"
													target="mainFrame">故障诊断</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%} %>
							<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_BAO_JING_GUAN_LI, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="errorlog/errorlogmanage.jsp?category=1"
													target="mainFrame">报警管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%} %>
							<%
									sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SUB_BAO_JING_RI_ZHI, us.getPopedomKeys() );
									if( b && sub )
									{
								%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="errorlog/errorlogmanage.jsp?category=2"
													target="mainFrame">报警日志</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%} %>
							<%
								}
							%>
							<%
								b = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.BAO_BIAO_GUAN_LI, us.getPopedomKeys() );
								if( b )
								{
							%>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>报表管理</strong>
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
												<a href="reportmanage/reportmanage.jsp" target="mainFrame">个人报表</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="reportmanage/reportsearchmanage.jsp"
													target="mainFrame">报表查询</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%
								}
							%>
							<%
								b = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.LUN_TAN_QU, us.getPopedomKeys() );
								if( b )
								{
							%>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>论坛区</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<%
								sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.LUN_TAN_GUAN_LI, us.getPopedomKeys() );
								if( b && sub){ 
							%>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="bbs/bbsmanage.jsp" target="mainFrame">论坛管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<%} %>
							<%
								sub = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.LUN_TAN, us.getPopedomKeys() );
								if( b && sub){ 
							%>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="bbs/bbsinfolist.jsp" target="mainFrame">论坛</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<%} %>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%
								}
							%>
							<%
								b = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.XI_TONG_GUAN_LI, us.getPopedomKeys() );
								if( b )
								{
							%>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>系统管理</strong>
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
												<a href="systemmanage/companymanage.jsp" target="mainFrame">级别管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/factorymanage.jsp" target="mainFrame">工厂管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/workshopmanage.jsp" target="mainFrame">车间管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/rolemanage.jsp" target="mainFrame">角色管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/usermanage.jsp" target="mainFrame">用户管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/popedommanage.jsp" target="mainFrame">权限分配</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<%
								}
							%>
							<%
								b = popedomService.isHasPopedom( us.getUserId(), String.valueOf( us.getUserType() ), MenuKey.SHU_JU_ZI_DIAN, us.getPopedomKeys() );
								if( b )
								{
							%>
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
												<a href="reportmanage/templatemanage.jsp" target="mainFrame">报表模板</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="base/devicetype/devicemanage.jsp"
													target="mainFrame">设备类型</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="base/thresholdcategorymanage.jsp"
													target="mainFrame">阈值类别</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="base/thresholdconfigmanage.jsp" target="mainFrame">阈值设置</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="base/thresholditemmanage.jsp" target="mainFrame">阈值项</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
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
