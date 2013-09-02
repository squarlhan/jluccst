<%@ page language="java" contentType="text/html; charset=utf-8"
import="com.boan.crm.groupmanage.common.UserSession,com.boan.crm.groupmanage.service.IPopedomService,com.boan.crm.groupmanage.service.impl.PopedomServiceImpl"
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
	boolean popodomFlag = popedomService.isCompanyAdministrator(us.getUserId(), String.valueOf(us.getUserType()) ) 
			||popedomService.isHasCompanyPopedom(us.getRoleKey());
	if( popodomFlag ){
		//公司级
	}else{
		//部门级
	}
	//*/
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<j:scriptlink css="true" tree="true"></j:scriptlink>
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
</head>
<body style="padding:5px;">
<div class="dtree">
  <!--a href="javascript: d.openAll();">展开</a> | <a href="javascript: d.closeAll();">关闭</a-->
  <script type="text/javascript">
		<!--
		d = new dTree('d','<%=path%>');
		<% if( popodomFlag ){%>
			d.add(0,-1,'22222<s:property value="companyName"/>','./toTabPageAction.action?companyId=<s:property value="companyId"/>&deptId=<s:property value="id"/>&who=session','','groupmain');
		<% }else{%>
			d.add(0,-1,'<s:property value="companyName"/>','','','groupmain');
		<% }%>
		<s:iterator value="deptList">
			d.add("<s:property value="id"/>",0,'<s:property value="deptName"/>','./queryCustomerBySellAmountAction.action?companyId=<s:property value="companyId"/>&deptId=<s:property value="id"/>&who=session','','groupmain','<%=path%>/js/tree/img/group.gif','<%=path%>/js/tree/img/group.gif');
		</s:iterator>
		<s:iterator value="userList">
			d.add("<s:property value="id"/>","<s:property value="deptId"/>",'<s:property value="userCName"/>','./queryCustomerBySellAmountAction.action?companyId=<s:property value="companyId"/>&deptId=<s:property value="deptId"/>&userId=<s:property value="id"/>&salesmanId=<s:property value="id"/>&who=session','','groupmain','<%=path%>/js/tree/img/user.gif');
		</s:iterator>
		document.write(d);
		//-->
	</script>
</div>
</body>
</html>
