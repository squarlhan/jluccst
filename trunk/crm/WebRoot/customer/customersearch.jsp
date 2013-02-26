<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ page import="com.boan.crm.groupmanage.common.UserSession"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.boan.crm.groupmanage.service.IPopedomService"%>
<%@ page import="com.boan.crm.groupmanage.service.impl.PopedomServiceImpl"%>
<%@ page import="com.boan.crm.groupmanage.common.RoleFlag"%>
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
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	UserSession userSession = (UserSession) session.getAttribute("userSession");
	String userId = "";
	String deptId = "";
	String companyId = "";
	int userType = 0;
	if (userSession != null) {
		userId = StringUtils.trimToEmpty(userSession.getUserId());
		deptId = StringUtils.trimToEmpty(userSession.getDeptId());
		companyId = StringUtils.trimToEmpty(userSession.getCompanyId());
		userType = userSession.getUserType();
	}
	
	
	IPopedomService service = new PopedomServiceImpl();
	boolean leaderFlag = service.isHasPopedomByRoleKey(userSession,RoleFlag.GONG_SI_LING_DAO);
%>
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
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td colspan="2" style="height:36px;"><table id="__01" width="100%" height="36" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="11"><img src="../images/header_01.jpg" width="11" height="36" alt=""></td>
                <td background="../images/header_02.jpg"><span class="STYLE1">您当前的位置：客户管理&gt;&gt;&gt;客户信息列表</span></td>
                <td width="12"><img src="../images/header_03.jpg" width="12" height="36" alt=""></td>
              </tr>
            </table></td>
        </tr>
        <tr>
        <%if(userType == 8 || leaderFlag){%>
        	 <td width="150" valign="top" style="border-left: 1px solid #54a4e3; border-bottom: 1px solid #54a4e3; border-right: 1px solid #54a4e3; padding: 5px;"><iframe width="100%" height="100%" id="menutree" name="menutree"frameborder="0" scrolling="auto" src="groupTreeForSearch.action"></iframe></td>
          <td valign="top" style="border-left:1px solid #54a4e3; border-bottom:1px solid #54a4e3; border-right:1px solid #54a4e3; padding:5px;"><iframe width="100%" height="100%"
          	 id="groupmain" name="groupmain" frameborder="0" scrolling="auto" src="../blank.jsp"></iframe></td>
		<%}else{%>
          <td valign="top" style="border-left:1px solid #54a4e3; border-bottom:1px solid #54a4e3; border-right:1px solid #54a4e3; padding:5px;"><iframe width="100%" height="100%"
          	 id="groupmain" name="groupmain" frameborder="0" scrolling="auto" src="searchCustomerList.action?companyId=<%=companyId%>&deptId=<%=deptId%>&who=session"></iframe></td>
        <%}%>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
