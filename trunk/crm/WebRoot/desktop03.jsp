<%@page import="com.boan.crm.groupmanage.common.MenuKey"%>
<%@page import="com.boan.crm.groupmanage.service.impl.PopedomServiceImpl"%>
<%@page import="com.boan.crm.groupmanage.common.UserSession"%>
<%@page import="com.boan.crm.groupmanage.service.IPopedomService"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	//判断是否是公司管理员或公司级用户或部门级用户
	IPopedomService popedomService = new PopedomServiceImpl();
	UserSession us = (UserSession) session.getAttribute("userSession");
	boolean flag = false;
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>高层经理</title>
<link type="text/css" href="css/style.css" rel="stylesheet" />
<style type="text/css">
<!--
.STYLE1 {color: #EE8A3D}
-->
</style>
</head>

<body>
<table width="100%" style="height:100%; background-image:url(images/desktop/03_bg.jpg); background-position:bottom left; background-repeat:no-repeat;" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" style="padding:20 0 0 40">
        <table border="0" cellpadding="0" cellspacing="5" bgcolor="#FFFFFF">
         <s:if test="hashPopedom03">
          <tr>
          	<s:if test="hashPopedom01">
            <td width="60" height="8" bgcolor="#8B8B8B"></td>
            </s:if>
            <s:if test="hashPopedom02">
            <td width="60" height="8"  bgcolor="#8B8B8B"></td>
            </s:if>
            <td width="60" height="8"  bgcolor="#EE8A3D"></td>
          </tr>
          <tr>
          	<s:if test="hashPopedom01">
            <td align="center"><a href="./userLogonAction!showDesktopPage.action?desktopUrl=desktop01">客户管理</a></td>
            </s:if>
            <s:if test="hashPopedom02">
            <td align="center"><a href="./userLogonAction!showDesktopPage.action?desktopUrl=desktop02">计划管理</a></td>
            </s:if>
            <td align="center"><span class="STYLE1">销售统计</span></td>
          </tr>
          </s:if>
        </table></td>
        <td align="center"><table border="0" cellspacing="3" cellpadding="0">
          	<!-- 本月销售目标 -->
         <tr background-repeat:no-repeat;" title="本月销售目标"
         		<%
            	flag = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.DESKTOP_SUB_SALES_GOAL, us.getPopedomKeys());
            	if( flag ){
            	%>
            	onclick="window.location.href='sellreport/stat/sell-report-target-manager.jsp'" style="cursor:pointer"
            	<%} %>
            >
            <td style="width:340px; height:71px; background-image:url(images/desktop/03_01.jpg); background-repeat:no-repeat;"><table width="100%"  style="height:71px;" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="14%" align="right"><img src="images/desktop/1.png" width="24" height="38"></td>
                <td width="86%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <!-- 销售趋势 -->
          <tr background-repeat:no-repeat;" title="销售趋势"
          	<%
            	flag = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.DESKTOP_SUB_SALES_TREND, us.getPopedomKeys());
            	if( flag ){
            	%>
            	onclick="window.location.href='sellreport/stat/sell-report-trend-manager.jsp'" style="cursor:pointer"
            	<%} %>
            	>
            <td style="width:340px; height:71px; background-image:url(images/desktop/03_02.jpg); background-repeat:no-repeat;"><table width="100%"  style="height:71px;" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="14%" align="right"><img src="images/desktop/2.png" width="24" height="38"></td>
                <td width="86%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <!-- 客户来源 -->
          <tr background-repeat:no-repeat;"  title="客户来源"
          		<%
            	flag = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.DESKTOP_SUB_CUSTOMER_SOURCE, us.getPopedomKeys());
            	if( flag ){
            	%>
            	onclick="window.location.href='customer/customerStaticInfo.action?flag=source'" style="cursor:pointer"
            	<%} %>
            	>
            <td style="width:340px; height:71px; background-image:url(images/desktop/03_03.jpg); background-repeat:no-repeat;"><table width="100%"  style="height:71px;" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="14%" align="right"><img src="images/desktop/3.png" width="24" height="38"></td>
                <td width="86%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <!-- 业绩排名 -->
         <tr background-repeat:no-repeat;"  title="业绩排名"
         	<%
            	flag = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.DESKTOP_SUB_PERFORMANCE_RANKING, us.getPopedomKeys());
            	if( flag ){
            	%>
            	onclick="window.location.href='sellreport/stat/sell-report-sales-performance-rank-manager.jsp'" style="cursor:pointer"
            	<%} %>
            	>
            <td style="width:340px; height:71px; background-image:url(images/desktop/03_04.jpg); background-repeat:no-repeat;"><table width="100%"  style="height:71px;" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="14%" align="right"><img src="images/desktop/4.png" width="24" height="38"></td>
                <td width="86%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
