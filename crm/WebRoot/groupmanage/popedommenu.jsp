
<%@page import="org.apache.commons.lang.StringUtils"%>
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
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String companyId = StringUtils.defaultIfEmpty(request.getParameter("companyId"),"");
	String path = request.getContextPath();
	String url="./showAllPopedomListAction.action";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" tipswindow="true" jmessagebox="true"
			jquery="true" validate="true" jfunction="true" tree="true"/>
</head>
<body style="padding:5px;">
<div class="dtree">

  <!--a href="javascript: d.openAll();">展开</a> | <a href="javascript: d.closeAll();">关闭</a-->
  <script type="text/javascript">
		<!--
		d = new dTree('d','<%=path%>');
		d.add(-2,-1,'<s:property value="commpanyName"/>权限列表','','','groupmain');
		<s:iterator value="productList">
			d.add('0',-2,'<s:property value="name"/>菜单资源','','','groupmain','<%=path%>/js/tree/img/imgfolder.gif');
		</s:iterator>
		<s:iterator value="menuList">
		d.add('<s:property value="menuKey"/>','<s:property value="parentKey"/>','<s:property value="menuName"/>','<%=url%>?menuKey=<s:property value="menuKey"/>&companyId=<%=companyId%>','','groupmain');
		</s:iterator>
		
		d.add(-100,-1,'操作权限列表','','','Menu');
		d.add(201,-100,'本部门','<%=url%>?menuKey=<%=MenuKey.SELF_DEPT%>&companyId=<%=companyId%>','','groupmain','<%=path%>/js/tree/img/imgfolder.gif','<%=path%>/js/tree/img/imgfolder.gif');
		d.add(202,-100,'本公司','<%=url%>?menuKey=<%=MenuKey.SELF_COMPANY%>&companyId=<%=companyId%>','','groupmain','<%=path%>/js/tree/img/imgfolder.gif','<%=path%>/js/tree/img/imgfolder.gif');
		d.add(-200,-1,'登录默认桌面','','','Menu');
		d.add(301,-200,'客户管理','<%=url%>?menuKey=<%=MenuKey.DESKTOP_CUSTOMER%>&companyId=<%=companyId%>','','groupmain','<%=path%>/js/tree/img/imgfolder.gif','<%=path%>/js/tree/img/imgfolder.gif');
		d.add(302,-200,'月计划','<%=url%>?menuKey=<%=MenuKey.DESKTOP_MONTH_PLAN%>&companyId=<%=companyId%>','','groupmain','<%=path%>/js/tree/img/imgfolder.gif','<%=path%>/js/tree/img/imgfolder.gif');
		d.add(303,-200,'销售统计','<%=url%>?menuKey=<%=MenuKey.DESKTOP_SALES_STAT%>&companyId=<%=companyId%>','','groupmain','<%=path%>/js/tree/img/imgfolder.gif','<%=path%>/js/tree/img/imgfolder.gif');
		document.write(d);
		d.openAll();
		//-->
	</script>
</div>
</body>
</html>
