
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
		d.add(0,-1,'菜单资源列表','','','Menu');
		d.add(101,0,'后台管理','<%=url%>?menuKey=<%=MenuKey.HOU_TAI_GUAN_LI%>','','groupmain','<%=path%>/js/tree/img/imgfolder.gif');
		d.add(102,0,'组织机构','<%=url%>?menuKey=<%=MenuKey.ZU_ZHI_JI_GOU%>','','groupmain');
		d.add(103,0,'客户查找','<%=url%>?menuKey=<%=MenuKey.KE_HU_CHA_ZHAO%>','','groupmain');
		d.add(104,0,'客户管理','<%=url%>?menuKey=<%=MenuKey.KE_HU_GUAN_LI%>','','groupmain');
		d.add(105,0,'销售管理','<%=url%>?menuKey=<%=MenuKey.XIAO_SHOU_GUAN_LI%>','','groupmain');
		d.add(106,0,'服务管理','<%=url%>?menuKey=<%=MenuKey.FU_WU_GUAN_LI%>','','groupmain');
		d.add(107,0,'数据字典','<%=url%>?menuKey=<%=MenuKey.SHU_JU_ZI_DIAN%>','','groupmain');
		document.write(d);
		d.openAll();
		//-->
	</script>
</div>
</body>
</html>