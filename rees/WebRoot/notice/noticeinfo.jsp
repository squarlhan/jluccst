<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author yangyj
 * @version 1.0
 * @audit  
 */
/**
 * Modified Person：
 * Modified Time：
 * Modified Explain：
 */
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>查看通知</title>
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<script type="text/javascript">
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
		  		$.fn.close();
		  	});
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			parent.$("#windown-close").click();
		  			parent.window.location.href=parent.window.location.href;
		  		});
			}
</script>
	</head>

	<body>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>通知标题：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:property value="noticeInfo.noticeTitle"></s:property>
										</td>
									</tr>
									<tr>
										<td height="26" align="right"  bgcolor="#FFFFFF">
											<strong>通知内容：</strong>
										</td>
										<td height="100" align="left" valign="top" bgcolor="#FFFFFF">
											<span><s:property value="noticeInfo.noticeContent"></s:property></span>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>通知发布人：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:property value="noticeInfo.publisher"></s:property>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF" nowrap>
											<strong>发布人所在单位：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:property value="noticeInfo.publisherDept"></s:property>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>通知发布时间：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:property value="noticeInfo.noticePublishtime"></s:property>
										</td>
									</tr>
									<tr>
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
										</td>
									</tr>
								</table>
							</td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
