<%@page import="com.boan.rees.group.common.MenuKey"%>
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
		d.add(101,0,'数据管理','<%=url%>?menuKey=<%=MenuKey.SHU_JU_GUAN_LI%>','','groupmain');
		d.add(1011,101,'数据管理','<%=url%>?menuKey=<%=MenuKey.SUB_SHU_JU_GUAN_LI%>','','groupmain');
		d.add(1012,101,'设备管理','<%=url%>?menuKey=<%=MenuKey.SUB_SHE_BEI_GUAN_LI%>','','groupmain');
		d.add(102,0,'专家系统','<%=url%>?menuKey=<%=MenuKey.ZHUAN_JIA_XI_TONG%>','','groupmain');
		d.add(103,0,'报表管理','<%=url%>?menuKey=<%=MenuKey.BAO_BIAO_GUAN_LI%>','','groupmain');
		d.add(104,0,'论坛区','<%=url%>?menuKey=<%=MenuKey.LUN_TAN_QU%>','','groupmain');
		d.add(105,0,'系统管理','<%=url%>?menuKey=<%=MenuKey.XI_TONG_GUAN_LI%>','','groupmain');
		d.add(106,0,'数据字典','<%=url%>?menuKey=<%=MenuKey.SHU_JU_ZI_DIAN%>','','groupmain');
		d.add(1,-1,'组织机构树型','','','Menu');
		d.add(201,1,'显示所有机构','<%=url%>?menuKey=<%=MenuKey.SHOW_ALL_GROUP%>','','groupmain');
		d.add(202,1,'显示当前机构','<%=url%>?menuKey=<%=MenuKey.SHOW_CURRENT_GROUP%>','','groupmain');
		d.add(203,1,'显示当前及以下机构','<%=url%>?menuKey=<%=MenuKey.SHOW_CURRENT_AND_SUB_GROUP%>','','groupmain');
		document.write(d);
		d.openAll();
		//-->
	</script>
</div>
</body>
</html>