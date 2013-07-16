<%@page import="com.boan.crm.groupmanage.common.RoleFlag"%>
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
	String url =  "";
	//业务员
	if( popedomService.isHasPopedomByRoleKey(us, RoleFlag.YE_WU_YUAN) )
	{
		url = "customer/mycustomermanage.jsp?progress=";
	}
	//非业务员
	else
	{
		url= "customer/customermanage.jsp?progress=";
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>业务员</title>
<link type="text/css" href="css/style.css" rel="stylesheet" />
<style type="text/css">
<!--
.STYLE1 {color: #EE8A3D}
-->
</style>
</head>

<body>
<table width="100%" style="height:100%;" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" style="padding:20 0 0 40">
        <table border="0" cellpadding="0" cellspacing="5" bgcolor="#FFFFFF">
		 <s:if test="hashPopedom01">
          <tr>
            <td width="60" height="8" bgcolor="#EE8A3D"></td>
            <s:if test="hashPopedom02">
            <td width="60"  height="8" bgcolor="#8B8B8B"></td>
            </s:if>
            <s:if test="hashPopedom03">
            <td width="60"  height="8" bgcolor="#8B8B8B"></td>
            </s:if>
          </tr>
          <tr>
            <td align="center" class="STYLE1">客户管理</td>
            <s:if test="hashPopedom02">
            <td align="center"><a href="./userLogonAction!showDesktopPage.action?desktopUrl=desktop02">计划管理</a></td>
            </s:if>
            <s:if test="hashPopedom03">
            <td align="center"><span class="STYLE1"><a href="./userLogonAction!showDesktopPage.action?desktopUrl=desktop03">统计分析</a></span>
            </s:if>
            </td>
          </tr>
	      </s:if>
        </table>
        </td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr>
        <td align="right"><img src="images/desktop/01.jpg" width="501" height="420"></td>
        <td align="left"><table border="0" cellspacing="6" cellpadding="0">
          <!-- 新建客户 -->
          <tr  title="新建客户"
          	<%
            	flag = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.DESKTOP_SUB_NEW_CUSTOMER, us.getPopedomKeys());
            	if( flag ){
            	%>
            	onclick="window.location.href='<%=url %>NEW'" style="cursor:pointer"
            	<%} %>
          >
            <td style="width:312px; height:64px; background-image:url(images/desktop/01_01.jpg); background-repeat:no-repeat;">
            	<table width="100%"  style="height:64px;" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="14%" align="right"><img src="images/desktop/1.png" width="24" height="38"></td>
                  <td width="86%">&nbsp;</td>
                </tr>
            </table></td>
          </tr>
         <!-- 跟踪客户 -->
          <tr  title="跟踪客户"
          	<%
            	flag = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.DESKTOP_SUB_TRACE_CUSTOMER, us.getPopedomKeys());
            	if( flag ){
            	%>
            	onclick="window.location.href='<%=url %>TRACE'" style="cursor:pointer"
            	<%} %>
          >
            <td style="width:312px; height:64px; background-image:url(images/desktop/01_02.jpg); background-repeat:no-repeat;"><table width="100%"  style="height:64px;" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="14%" align="right"><img src="images/desktop/2.png" width="24" height="38"></td>
                  <td width="86%">&nbsp;</td>
                </tr>
            </table></td>
          </tr>
          <!-- 要成单客户 -->
          <tr  title="要成单客户"
          	<%
            	flag = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.DESKTOP_SUB_WILL_ORDER_FORM_CUSTOMER, us.getPopedomKeys());
            	if( flag ){
            	%>
            	onclick="window.location.href='<%=url %>DEALING'" style="cursor:pointer"
            	<%} %>
          >
            <td style="width:312px; height:64px; background-image:url(images/desktop/01_03.jpg); background-repeat:no-repeat;"><table width="100%"  style="height:64px;" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="14%" align="right"><img src="images/desktop/3.png" width="24" height="38"></td>
                  <td width="86%">&nbsp;</td>
                </tr>
            </table></td>
          </tr>
          <!-- 成单客户 -->
          <tr  title="成单客户"
          	<%
            	flag = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.DESKTOP_SUB_ORDER_FORM_CUSTOMER, us.getPopedomKeys());
            	if( flag ){
            	%>
            	onclick="window.location.href='<%=url %>DEALED'" style="cursor:pointer"
            	<%} %>
          >
            <td style="width:312px; height:64px; background-image:url(images/desktop/01_04.jpg); background-repeat:no-repeat;"><table width="100%"  style="height:64px;" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="14%" align="right"><img src="images/desktop/4.png" width="24" height="38"></td>
                  <td width="86%">&nbsp;</td>
                </tr>
            </table></td>
          </tr>
		  <!-- 回访客户 -->
          <tr  title="回访客户"
          	<%
            	flag = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.DESKTOP_SUB_VISIT_CUSTOMER, us.getPopedomKeys());
            	if( flag ){
            	%>
            	onclick="window.location.href='<%=url %>VISIT'" style="cursor:pointer"
            	<%} %>
          >
            <td style="width:312px; height:64px; background-image:url(images/desktop/01_05.jpg); background-repeat:no-repeat;"><table width="100%"  style="height:64px;" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="14%" align="right"><img src="images/desktop/5.png" width="24" height="38"></td>
                  <td width="86%">&nbsp;</td>
                </tr>
            </table></td>
          </tr>
		  <!-- 忠诚客户 -->
          <tr  title="忠诚客户"
          	<%
            	flag = popedomService.isHasPopedom(us.getUserId(), String.valueOf(us.getUserType()), MenuKey.DESKTOP_SUB_LOYAL_CUSTOMER, us.getPopedomKeys());
            	if( flag ){
            	%>
            	onclick="window.location.href='<%=url %>LOYAL'" style="cursor:pointer"
            	<%} %>
          >
            <td style="width:312px; height:64px; background-image:url(images/desktop/01_06.jpg); background-repeat:no-repeat;"><table width="100%"  style="height:64px;" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="14%" align="right"><img src="images/desktop/6.png" width="24" height="38"></td>
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
