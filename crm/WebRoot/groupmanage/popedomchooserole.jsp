<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	/**
	 * Copyright (c) 2005 Changchun HuaZhan (HuaZhan) Co. Ltd.
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
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true" />
		<script language="javascript" type="text/JavaScript">
            function winclose()
            {
            	/*
                parent.returnValue=0;
                parent.close();
                */
            	parent.$("#windown-close").click();
            }
            function gosubmit()
            {
				if((form1.roleIds.value)==""){
					alert("请选择要添加的职务！");
					return false;
				}
				form1.action="./saveOrUpdatePopedomAction.action";
				form1.target="iframe1";
				form1.submit();
            }
        </script>
	</head>
	<body class="body">
		<s:form id="form1" name="form1" method="post" theme="simple">
			<s:hidden id="menuKey" name="menuKey"></s:hidden>
			<s:hidden id="companyId" name="companyId"></s:hidden>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td style="padding: 5px;">
						<table border="0" width="100%" cellspacing="5" cellpadding="5">
							<tr>
								<td nowrap="nowrap">
									<table width="100%" border="0" cellpadding="1" cellspacing="5">
										<tr>
											<td align="center" nowrap background="../images/headerbg.jpg" height="22px">
												<DIV class="fLe textDiv" style="padding-left: 5px;">
													<SPAN class=titleB id=Label1>请选择职务</SPAN>
												</DIV>
											</td>
										</tr>
										<tr>
											<td align="center" nowrap="nowrap">
												<span class="shadow">
													<s:select list="roleList"
														listKey="id" listValue="roleName" id="roleIds"
														name="roleIds" cssStyle="width:280;" multiple="true" size="20">
													</s:select> </span>
											</td>
										</tr>
										<tr>
											<td align="center" nowrap height="20px">
												<input type="button" name="btnSave" value="确定"
													class="btn_2_3" onClick="gosubmit();">
												<input type="button" name="btnCancel" value="关闭"
													class="btn_2_3" onClick="winclose();">
											</td>
										</tr>
									</table>
								</td>
							</tr>

						</table>
					</td>
				</tr>
			</table>
		</s:form>
		<iframe id="iframe1" name="iframe1" width="1px" height="1px"></iframe>
	</body>
</html>
