<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 * All right reserved.
	 */
	/**
	 * @author Luojx
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
<title>客户基本信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<j:scriptlink css="true" jmessagebox="true" jquery="true"
	tipswindow="true" validate="true" />
<style type="text/css">
.auto-style1 {
	background: #d3eaef;
	font-size: 18px;
	font-family: 仿宋;
}

.auto-style2 {
	font-size: x-large;
}

.auto-style3 {
	text-align: right;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$.fn.close();
});
/**
 * 关闭
 */
	$.fn.close = function(){
		$("#closeBtn").click(function(){
			window.close();
		});
};
</script>
</head>
<body>
	<s:form id="form1" name="form1" method="post" theme="simple">
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td style="height: 50px"><table width=100%>
						<tr>
							<td style="width: 600px; height: 21px"></td>
						</tr>
						<tr>
							<td align="center" style="width: 100%"><strong><span
									class="auto-style2">客户信息</span> </strong>
							</td>
						</tr>
						<tr>
							<td style="width: 600px"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><fieldset>
						<legend>
							<span></span>
						</legend>
						<table>
							<tr>
								<td height="200px" valign="top" style="padding-top:10px;padding-left:10px;">
								未找到匹配的客户信息！
								</td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
		</table>
		</td>
		</tr>
		<tr>
			<td style="height: 20px"></td>
		</tr>
		<tr>
			<td></td>
			<td align="center"><table align="center">
					<tr>
						<td style="height: 10px"></td>
					</tr>
					<tr>
						<td align="center">
						<input type="button" name="closeBtn" id="closeBtn" value="关闭" class="btn_2_3" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</table>
	</s:form>
</body>
</html>
