<%@ page language="java" contentType="text/html; charset=utf-8"
import="java.util.Calendar,com.boan.crm.groupmanage.common.UserSession,com.boan.crm.groupmanage.service.IPopedomService,com.boan.crm.groupmanage.service.impl.PopedomServiceImpl,com.boan.crm.groupmanage.common.RoleFlag"
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
	IPopedomService popedomService = new PopedomServiceImpl();
	UserSession us = (UserSession) session.getAttribute("userSession");
	String deptId = us.getDeptId();
	String personId = us.getUserId();
	String companyId = us.getCompanyId();
	boolean popodomFlag = popedomService.isCompanyAdministrator(us.getUserId(), String.valueOf(us.getUserType()) ) 
			||popedomService.isHasDeptPopedom(us.getRoleKey()) || popedomService.isHasCompanyPopedom(us.getRoleKey());
	if( popodomFlag ){
		//经理级人员
	}else{
		//部门人员
	}
	//*/
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true"></j:scriptlink>
		<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>
	</head>
	<body>
		<table width="100%" style="height: 100%;" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="2" cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="3" style="height: 36px;">
								<table id="__01" width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="11">
											<img src="<%=path %>/images/header_01.jpg" width="11" height="36" alt="">
										</td>
										<td background="<%=path %>/images/header_02.jpg">
											<span class="STYLE1">您当前的位置：销售管理&gt;&gt;&gt;销售业绩排名</span>
										</td>
										<td width="12">
											<img src="<%=path %>/images/header_03.jpg" width="12" height="36" alt="">
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<%
								String roleKey= us.getRoleKey();
								if(!roleKey.equals(RoleFlag.BU_MEN_LING_DAO) && !roleKey.equals(RoleFlag.YE_WU_YUAN)){
									deptId="";
							%>
								<td width="200" valign="top" style="border-left: 1px solid #54a4e3; border-bottom: 1px solid #54a4e3; border-right: 1px solid #54a4e3; padding: 5px;"><iframe width="100%" height="100%" id="menutree" name="menutree"frameborder="0" scrolling="auto" src="<%=path %>/showGroupTreeForSalesPerformanceRankStatAction.action"></iframe></td>
							<% } %>
							<td valign="top" style="border-left: 1px solid #54a4e3; border-bottom: 1px solid #54a4e3; border-right: 1px solid #54a4e3; padding: 5px;">
								<iframe width="100%" height="100%" id="groupmain" name="groupmain" frameborder="0" scrolling="auto" src="openSellSalesPerformanceRankAction.action?companyId=<%=companyId %>&deptId=<%=deptId %>&statBeginDate=<%=Calendar.getInstance().get(Calendar.YEAR)+"-01-01"%>&statEndDate=<%=Calendar.getInstance().get(Calendar.YEAR)+"-12-31"%>"></iframe>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
