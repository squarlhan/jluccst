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
		d.add(1013,101,'数据查看','<%=url%>?menuKey=<%=MenuKey.SHU_JU_CHA_KAN%>','','groupmain');
		d.add(1012,101,'设备管理','<%=url%>?menuKey=<%=MenuKey.SUB_SHE_BEI_GUAN_LI%>','','groupmain');
		d.add(1014,101,'特殊设备规则管理','<%=url%>?menuKey=<%=MenuKey.SUB_TE_SHU_SHE_BEI_GUI_ZE%>','','groupmain');
		
		d.add(102,0,'专家系统','<%=url%>?menuKey=<%=MenuKey.ZHUAN_JIA_XI_TONG%>','','groupmain');
		
		d.add(1021,102,'规则现象设置','<%=url%>?menuKey=<%=MenuKey.SUB_GUI_ZE_XIAN_XIANG%>','','groupmain');
		d.add(1022,102,'规则原因设置','<%=url%>?menuKey=<%=MenuKey.SUB_GUI_ZE_YUAN_YIN%>','','groupmain');
		d.add(1023,102,'规则建议设置','<%=url%>?menuKey=<%=MenuKey.SUB_GUI_ZE_JIAN_YI%>','','groupmain');
		d.add(1024,102,'规则设置','<%=url%>?menuKey=<%=MenuKey.SUB_GUI_ZE_SHE_ZHI%>','','groupmain');
		d.add(1025,102,'设备规则','<%=url%>?menuKey=<%=MenuKey.SUB_SHE_BEI_GUI_ZE%>','','groupmain');
		d.add(1026,102,'故障诊断','<%=url%>?menuKey=<%=MenuKey.SUB_GU_ZHANG_ZHEN_DUAN%>','','groupmain');
		d.add(1027,102,'报警管理','<%=url%>?menuKey=<%=MenuKey.SUB_BAO_JING_GUAN_LI%>','','groupmain');
		d.add(1028,102,'报警日志','<%=url%>?menuKey=<%=MenuKey.SUB_BAO_JING_RI_ZHI%>','','groupmain');
		
		d.add(103,0,'报表管理','<%=url%>?menuKey=<%=MenuKey.BAO_BIAO_GUAN_LI%>','','groupmain');
		d.add(104,0,'论坛区','<%=url%>?menuKey=<%=MenuKey.LUN_TAN_QU%>','','groupmain');
		d.add(1041,104,'论坛管理','<%=url%>?menuKey=<%=MenuKey.LUN_TAN_GUAN_LI%>','','groupmain');
		d.add(1042,104,'论坛','<%=url%>?menuKey=<%=MenuKey.LUN_TAN%>','','groupmain');
		d.add(105,0,'系统管理','<%=url%>?menuKey=<%=MenuKey.XI_TONG_GUAN_LI%>','','groupmain');
		d.add(106,0,'数据字典','<%=url%>?menuKey=<%=MenuKey.SHU_JU_ZI_DIAN%>','','groupmain');
		
		d.add(1,-1,'组织机构树型','','','Menu');
		
		d.add(201,1,'显示所有机构','<%=url%>?menuKey=<%=MenuKey.SHOW_ALL_GROUP%>','','groupmain');
		d.add(202,1,'显示当前机构','<%=url%>?menuKey=<%=MenuKey.SHOW_CURRENT_GROUP%>','','groupmain');
		d.add(203,1,'显示当前及以下机构','<%=url%>?menuKey=<%=MenuKey.SHOW_CURRENT_AND_SUB_GROUP%>','','groupmain');
		
		d.add(2,-1,'操作权限','','','Menu');
		d.add(301,2,'发表话题','<%=url%>?menuKey=<%=MenuKey.FA_BIAO_HUA_TI%>','','groupmain');
		document.write(d);
		d.openAll();
		//-->
	</script>
</div>
</body>
</html>
