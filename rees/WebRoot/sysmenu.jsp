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
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" jquery="true" />
		<script type="text/javascript">
<!--
	$(document).ready(function() {
		var ifrHeight = $("#leftFrame", parent.parent.document).height();
		var ifrHeightTemp = ifrHeight - 50;
		$("#menuArea").height(ifrHeightTemp);
	});
	$(window).resize(function() {
		var ifrHeight = $("#leftFrame", parent.parent.document).height();
		var ifrHeightTemp = ifrHeight - 50;
		$("#menuArea").height(ifrHeightTemp);
	});
//-->
</script>
	</head>
	<body>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td style="background-image: url(images/jzywcd.jpg); height: 35px;"></td>
			</tr>
			<tr>
				<td align="center">
					<div id="menuArea" style="overflow: auto; display: block;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>数据管理</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="datamanage/datamanage.jsp" target="mainFrame">数据管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="datamanage/devicemanage.jsp" target="mainFrame">设备管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>专家系统</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<!--tr>
            <td align="left"><table width="100%" border="0" cellspacing="5" cellpadding="0">
                <tr>
                  <td width="40" align="right" style="padding-bottom:4px;"><img src="images/menuto.jpg" width="5" height="5" /></td>
                  <td><a href="noticemanage/sendlist.html" target="mainFrame">已发通知</a></td>
                </tr>
              </table></td>
          </tr>
          <tr>
            <td height="1" align="left" background="images/menubg2.jpg"></td>
          </tr>
          <tr>
            <td align="left"><table width="100%" border="0" cellspacing="5" cellpadding="0">
                <tr>
                  <td width="40" align="right" style="padding-bottom:4px;"><img src="images/menuto.jpg" width="5" height="5" /></td>
                  <td><p><a href="noticemanage/receivelist.html" target="mainFrame">已收通知</a></p></td>
                </tr>
              </table></td>
          </tr-->
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="sysmanage/rulemanage.html" target="mainFrame">规则设置</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="sysmanage/errordiagnose.html" target="mainFrame">故障诊断</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="sysmanage/errorforecast.html" target="mainFrame">故障预测</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td height="12" align="left"></td>
							</tr>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>报表管理</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<!-- a href="reportmanage/reportmanage.jsp" target="mainFrame">个人报表</a> -->
												<a href="reportmanage/openReportAction.action" target="mainFrame">个人报表</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="reportmanage/reportsearchmanage.jsp"
													target="mainFrame">报表查询</a>
											</td>
										</tr>
										<!-- 
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="reportmanage/templatemanage.jsp" target="mainFrame">模板维护</a>
											</td>
										</tr>
										 -->
									</table>
								</td>
							</tr>

							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td height="12" align="left"></td>
							</tr>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>论坛区</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="bbs/bbslist.html" target="mainFrame">论坛区1</a>
											</td>
										</tr>
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="bbs/bbsinfo.html" target="mainFrame">论坛区2</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>

							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td height="12" align="left"></td>
							</tr>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/up.gif" width="10" height="12" />
											</td>
											<td>
												<strong>系统管理</strong>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/companymanage.jsp" target="mainFrame">公司管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/factorymanage.jsp" target="mainFrame">工厂管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/workshopmanage.jsp" target="mainFrame">车间管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/rolemanage.jsp" target="mainFrame">角色管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/usermanage.jsp" target="mainFrame">用户管理</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="systemmanage/popedommanage.jsp" target="mainFrame">权限分配</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="openAddTemplateAction.action" target="mainFrame">报表模板</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td align="left">
									<table width="100%" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="40" align="right" style="padding-bottom: 4px;">
												<img src="images/menuto.jpg" width="5" height="5" />
											</td>
											<td>
												<a href="openDeviceTypeAction.action" target="mainFrame">设备类型</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>

							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td height="1" align="left" background="images/menubg2.jpg"></td>
							</tr>
							<tr>
								<td height="24" align="left" background="images/menubg.jpg"></td>
						</table>
	</body>
</html>
