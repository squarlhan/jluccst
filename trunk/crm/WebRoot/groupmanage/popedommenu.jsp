
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
		d.add(0,-1,'菜单资源列表','','','Menu');
		//d.add(101,0,'后台管理','<%=url%>?menuKey=<%=MenuKey.HOU_TAI_GUAN_LI%>&companyId=<%=companyId%>','','groupmain','<%=path%>/js/tree/img/imgfolder.gif');
		//d.add(102,0,'组织机构','<%=url%>?menuKey=<%=MenuKey.ZU_ZHI_JI_GOU%>&companyId=<%=companyId%>','','groupmain');
		//d.add(107,0,'数据字典','<%=url%>?menuKey=<%=MenuKey.SHU_JU_ZI_DIAN%>&companyId=<%=companyId%>','','groupmain');
		d.add(103,0,'客户查找','<%=url%>?menuKey=<%=MenuKey.KE_HU_CHA_ZHAO%>&companyId=<%=companyId%>','','groupmain');
				d.add(1031,103,'客户查找','<%=url%>?menuKey=<%=MenuKey.SUB_KE_HU_CHA_ZHAO%>&companyId=<%=companyId%>','','groupmain');
			//	d.add(1032,103,'导入客户库','<%=url%>?menuKey=<%=MenuKey.SUB_DAO_RU_KE_HU%>&companyId=<%=companyId%>','','groupmain');
		d.add(107,0,'我的客户管理','<%=url%>?menuKey=<%=MenuKey.MY_KE_HU_GUAN_LI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1071,107,'我的客户','<%=url%>?menuKey=<%=MenuKey.MY_KE_HU%>&companyId=<%=companyId%>','','groupmain');
				d.add(1072,107,'我的跟进','<%=url%>?menuKey=<%=MenuKey.MY_GEN_JIN%>&companyId=<%=companyId%>','','groupmain');
				d.add(1073,107,'我的回访','<%=url%>?menuKey=<%=MenuKey.MY_HUI_FANG%>&companyId=<%=companyId%>','','groupmain');
		d.add(104,0,'客户管理','<%=url%>?menuKey=<%=MenuKey.KE_HU_GUAN_LI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1041,104,'客户信息','<%=url%>?menuKey=<%=MenuKey.SUB_KE_HU_XIN_XI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1042,104,'客户跟进','<%=url%>?menuKey=<%=MenuKey.SUB_KE_HU_GEN_JIN%>&companyId=<%=companyId%>','','groupmain');
				d.add(1043,104,'客户回访','<%=url%>?menuKey=<%=MenuKey.SUB_KE_HU_HUI_FANG%>&companyId=<%=companyId%>','','groupmain');
				d.add(1044,104,'客户评估','<%=url%>?menuKey=<%=MenuKey.SUB_KE_HU_PING_GU%>&companyId=<%=companyId%>','','groupmain');
		/*
				d.add(108,0,'客户查询','<%=url%>?menuKey=<%=MenuKey.ZONG_HE_CHA_XUN%>&companyId=<%=companyId%>','','groupmain');//综合查询改为客户查询
				d.add(1081,108,'信息查询','<%=url%>?menuKey=<%=MenuKey.KE_HU_CHA_XUN%>&companyId=<%=companyId%>','','groupmain');//客户查询改为信息查询
				d.add(1082,108,'跟进查询','<%=url%>?menuKey=<%=MenuKey.GEN_JIN_CHA_XUN%>&companyId=<%=companyId%>','','groupmain');
				d.add(1083,108,'回访查询','<%=url%>?menuKey=<%=MenuKey.HUI_FANG_CHA_XUN%>&companyId=<%=companyId%>','','groupmain');
		*/
		d.add(105,0,'销售管理','<%=url%>?menuKey=<%=MenuKey.XIAO_SHOU_GUAN_LI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1051,105,'短信平台','<%=url%>?menuKey=<%=MenuKey.SUB_DUAN_XIN_PING_TAI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1052,105,'时间管理','<%=url%>?menuKey=<%=MenuKey.SUB_SHI_JIAN_GUAN_LI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1053,105,'时间管理查询','<%=url%>?menuKey=<%=MenuKey.SUB_SHI_JIAN_GUAN_LI_CHA_XUN%>&companyId=<%=companyId%>','','groupmain');
				d.add(1054,105,'市场调查','<%=url%>?menuKey=<%=MenuKey.SUB_SHI_CHANG_DIAO_CHA%>&companyId=<%=companyId%>','','groupmain');
				d.add(1055,105,'市场调查查询','<%=url%>?menuKey=<%=MenuKey.SUB_SHI_CHANG_DIAO_CHA_CHA_XUN%>&companyId=<%=companyId%>','','groupmain');
				d.add(1056,105,'销售记录','<%=url%>?menuKey=<%=MenuKey.SUB_XIAO_SHOU_JI_LU%>&companyId=<%=companyId%>','','groupmain');
				d.add(1057,105,'销售记录查询','<%=url%>?menuKey=<%=MenuKey.SUB_XIAO_SHOU_JI_LU_CHA_XUN%>&companyId=<%=companyId%>','','groupmain');
				d.add(1058,105,'部门周计划','<%=url%>?menuKey=<%=MenuKey.SUB_ZHOU_JI_HUA%>&companyId=<%=companyId%>','','groupmain');
				d.add(1059,105,'部门月计划','<%=url%>?menuKey=<%=MenuKey.SUB_YUE_JI_HUA%>&companyId=<%=companyId%>','','groupmain');
				d.add(1058,105,'周计划查询','<%=url%>?menuKey=<%=MenuKey.SUB_ZHOU_JI_HUA_CHA_XUN%>&companyId=<%=companyId%>','','groupmain');
				d.add(1059,105,'月计划查询','<%=url%>?menuKey=<%=MenuKey.SUB_YUE_JI_HUA_CHA_XUN%>&companyId=<%=companyId%>','','groupmain');
				d.add(1060,105,'销售职责设置','<%=url%>?menuKey=<%=MenuKey.SUB_XIAO_SHOU_ZHI_ZE_SHE_ZHI%>&companyId=<%=companyId%>','','groupmain');
		d.add(106,0,'服务管理','<%=url%>?menuKey=<%=MenuKey.FU_WU_GUAN_LI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1061,106,'服务记录','<%=url%>?menuKey=<%=MenuKey.SUB_FU_WU_JI_LU%>&companyId=<%=companyId%>','','groupmain');
				d.add(1062,106,'服务记录查询','<%=url%>?menuKey=<%=MenuKey.SUB_FU_WU_JI_LU_CHA_XUN%>&companyId=<%=companyId%>','','groupmain');
				d.add(1063,106,'会员管理','<%=url%>?menuKey=<%=MenuKey.SUB_HUI_YUAN_GUAN_LI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1064,106,'积分管理','<%=url%>?menuKey=<%=MenuKey.SUB_JI_FEN_GUAN_LI%>&companyId=<%=companyId%>','','groupmain');
		d.add(108,0,'进销存管理','<%=url%>?menuKey=<%=MenuKey.FU_WU_GUAN_LI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1081,108,'供应商管理','<%=url%>?menuKey=<%=MenuKey.SUB_GONG_YING_SHANG_GUAN_LI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1082,108,'采购管理','<%=url%>?menuKey=<%=MenuKey.SUB_CAI_GOU_GUAN_LI%>&companyId=<%=companyId%>','','groupmain');
				d.add(1083,108,'库存清单','<%=url%>?menuKey=<%=MenuKey.SUB_KU_CUN_QING_DAN%>&companyId=<%=companyId%>','','groupmain');
				d.add(1084,108,'财务清单','<%=url%>?menuKey=<%=MenuKey.SUB_CAI_WU_QING_DAN%>&companyId=<%=companyId%>','','groupmain');
		d.add(-2,-1,'操作权限列表','','','Menu');
		d.add(201,-2,'本部门','<%=url%>?menuKey=<%=MenuKey.SELF_DEPT%>&companyId=<%=companyId%>','','groupmain','<%=path%>/js/tree/img/imgfolder.gif','<%=path%>/js/tree/img/imgfolder.gif');
		d.add(202,-2,'本公司','<%=url%>?menuKey=<%=MenuKey.SELF_COMPANY%>&companyId=<%=companyId%>','','groupmain','<%=path%>/js/tree/img/imgfolder.gif','<%=path%>/js/tree/img/imgfolder.gif');
		document.write(d);
		//d.openAll();
		//-->
	</script>
</div>
</body>
</html>
