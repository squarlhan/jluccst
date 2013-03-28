<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#username").focus();
	});
	function logon() {
		if ($.trim($("#username").val()) == "") {
			alert("请输入用户名！");
			$("#username").focus();
			return false;
		}
		if ($("#password").val() == "") {
			alert("请输入密码！");
			$("#password").focus();
			return false;
		}
		form1.action = "./logonValidAction.action";
		form1.target = "iframe1";
		form1.submit();
		//window.location.href="sysmain.action";
	}
	function mykeypress() {
		if (event.keyCode == 13) {
			logon();
		}
	}
	function superpin() {
		parent.parent.tipsWindown("超级管理员后台登录",
				"iframe:./pinLoginAction.action", "400", "150", "true", "",
				"true", "no");
	}
	function validmessage() {
		;
	}
</script>
<form id="form1" name="form1" method="post">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center"><table id="__01" width="968" height="598" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td colspan="3"><img src="images/login_01.jpg" width="968" height="216" alt=""></td>
					</tr>
					<tr>
						<td rowspan="2"><img src="images/login_02.jpg" width="367" height="382" alt=""></td>
						<td width="258" height="214"><table id="__" width="258" height="214" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td colspan="3"><img src="images/ptlg_01.jpg" width="258" height="50" alt=""></td>
								</tr>
								<tr>
									<td rowspan="4"><img src="images/ptlg_02.jpg" width="112" height="82" alt=""></td>
								  <td background="images/ptlg_03.jpg" style="width:111px;height:21px;"><input type="text" name="username" id="username" value="" style="width:111px;height:19px;" maxlength="20" onkeypress="mykeypress();"></td>
									<td rowspan="4"><img src="images/ptlg_04.jpg" width="35" height="82" alt=""></td>
								</tr>
								<tr>
									<td><img src="images/ptlg_05.jpg" width="111" height="25" alt=""></td>
								</tr>
								<tr>
									<td background="images/ptlg_06.jpg" style="width:111px;height:20px;"><input type="password" name="password" id="password" value="" style="width:111px;height:18px;" maxlength="20" onkeypress="mykeypress();"></td>
								</tr>
								<tr>
									<td><img src="images/ptlg_07.jpg" width="111" height="16" alt=""></td>
								</tr>
								<tr>
									<td height="82" colspan="3" align="center" valign="top" background="images/ptlg_08.jpg"><span style="padding:5px;"> <img src="images/login_dl.jpg" width="68" height="28" alt="登录" style="cursor:pointer;margin:3px;" onclick="logon();"> <img src="images/login_htdl.jpg" width="81" height="28" alt="后台登录" style="cursor:pointer;margin:3px;" onclick="superpin();"> </span></td>
								</tr>
							</table></td>
						<td rowspan="2"><img src="images/login_04.jpg" width="343" height="382" alt=""></td>
					</tr>
					<tr>
						<td><img src="images/login_05.jpg" width="258" height="168" alt=""></td>
					</tr>
				</table></td>
		</tr>
	</table>
</form>