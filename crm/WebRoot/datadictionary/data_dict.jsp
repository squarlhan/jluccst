<%@ page language="java" contentType="text/html; charset=utf-8"
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
	<body>
		<table width="100%" style="height: 100%;" border="0" cellspacing="5"
			cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="2" style="height: 36px;">
								<table id="__01" width="100%" height="36" border="0"
									cellpadding="0" cellspacing="0">
									<tr>
										<td width="11"><img src="../images/header_01.jpg" width="11" height="36"
												alt=""></td>
										<td background="../images/header_02.jpg">
											<span class="STYLE1">您当前的位置：数据字典&gt;&gt;&gt;数据字典</span>
										</td>
										<td width="12"><img src="../images/header_03.jpg" width="12" height="36"
												alt=""></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td width="200" valign="top" style="border-left: 1px solid #54a4e3; border-bottom: 1px solid #54a4e3; border-right: 1px solid #54a4e3; padding: 5px;">
								<div class="dtree" style="padding:5px">
								  <!--a href="javascript: d.openAll();">展开</a> | <a href="javascript: d.closeAll();">关闭</a-->
								  <script type="text/javascript">
										<!--
										d = new dTree('d','<%=path%>');
										d.add(0,-1,'数据字典类别','','','Menu');
										d.add(101,0,'客户分类','datadictionarylist.action?typeFlag=0','','groupmain');
										d.add(102,0,'客户状态','datadictionarylist.action?typeFlag=1','','groupmain');
										d.add(103,0,'客户来源','datadictionarylist.action?typeFlag=2','','groupmain');
										d.add(104,0,'主营行业','datadictionarylist.action?typeFlag=3','','groupmain');
										d.add(105,0,'客户成熟度','datadictionarylist.action?typeFlag=4','','groupmain');
										d.add(106,0,'回访方式','datadictionarylist.action?typeFlag=5','','groupmain');
										d.add(107,0,'跟进方式','datadictionarylist.action?typeFlag=6','','groupmain');
										d.add(108,0,'业务进展','datadictionarylist.action?typeFlag=7','','groupmain');
										//d.add(109,0,'经营产品','datadictionarylist.action?typeFlag=8','','groupmain');
										d.add(110,0,'会员类别','datadictionarylist.action?typeFlag=9','','groupmain');
										d.add(111,0,'销售设置','../openSellDutyListAction.action','','groupmain');
										d.add(112,0,'开发程度','datadictionarylist.action?typeFlag=10','','groupmain');
										document.write(d);
										d.openAll();
										//-->
									</script>
								</div>
																
							</td>
							<td valign="top" style="border-left: 1px solid #54a4e3; border-bottom: 1px solid #54a4e3; border-right: 1px solid #54a4e3; padding: 5px;"><iframe width="100%" height="100%" id="groupmain" name="groupmain" frameborder="0" scrolling="auto" src="about:blank"></iframe></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
