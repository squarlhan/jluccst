<%@page import="com.boan.crm.groupmanage.common.RoleFlag"%>
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
		//var ifrHeight = $("#leftFrame", parent.document).height();
		//var ifrHeightTemp = ifrHeight - 50;
		//$("#menuArea").height(ifrHeightTemp);

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
		//打开默认菜单
		<%
		if (RoleFlag.YE_WU_YUAN.equalsIgnoreCase(us.getRoleKey())) {
		%>
		$("strong[s='我的客户管理']").click();
		<%
		}else if(RoleFlag.BU_MEN_LING_DAO.equalsIgnoreCase(us.getRoleKey())) {
		%>
		$("strong[s='计划管理']").click();
		<%
		}else if(RoleFlag.GONG_SI_LING_DAO.equalsIgnoreCase(us.getRoleKey())) {
		%>
		$("strong[s='销售管理']").click();
		<%}%>
	});
	$(window).resize(function() {
		var ifrHeight = $("#leftFrame", parent.document).height();
		var ifrHeightTemp = ifrHeight - 50;
		$("#menuArea").height(ifrHeightTemp);
	});
//-->
</script>
</head>
<body>
	<table width="100%" border="0" cellspacing="5" cellpadding="0" style="height:100%;">
		<tr>
			<td style="background-image: url(images/jzywcd.jpg); height: 35px;"></td>
		</tr>
		<tr>
			<td align="center" style="vertical-align: top;">
				<div id="menuArea" style="overflow: auto; display: block; height: 100%">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<s:iterator value="menuList" status="status">
						<tr>
							<td height="24" align="left" background="images/menubg.jpg">
								<table width="100%" border="0" cellspacing="5" cellpadding="0">
									<tr>
										<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/up.gif" width="10" height="12" />
										</td>
										<td><strong name="menus" s="<s:property value="menuName"/>"><s:property value="menuName"/></strong>
										</td>
									</tr>
								</table>
							</td>
						</tr>
							<tbody name="submenus" style="display:none">
								<s:iterator value="subMenuList">
									<tr>
										<td align="left">
											<table width="100%" border="0" cellspacing="5" cellpadding="0">
												<tr>
													<td width="40" align="right" style="padding-bottom: 4px;"><img src="images/menuto.jpg" width="5" height="5" />
													</td>
													<td><a href="<s:property value="url"/>" target="mainFrame"><s:property value="menuName"/></a>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</s:iterator>
							</tbody>
					</s:iterator>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
