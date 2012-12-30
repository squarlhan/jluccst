<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>销售团队智能管理系统</title>
		<j:scriptlink css="true" jquery="true" jfunction="true" tipswindow="true"></j:scriptlink>
		<style type="text/css">
		<!--
		.STYLE1 {
			color: #FFFFFF
		}
		
		body {
			background-color: #1675b7;
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		td{
			margin:0px;
			padding:0px;
		}
		-->
		</style>
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
			function superpin(){
				parent.parent.tipsWindown("超级管理员登录","iframe:./pinLoginAction.action","400","150","true","","true","no");
			}
		</script>
	</head>
	<body>
		<form id="form1" name="form1" method="post">
		<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0"
			style="height: 613px;">
	  		<tr>
				<td align="center" valign="middle">
					<table id="__01" width="1003" height="614" border="0"
						cellpadding="0" cellspacing="0">
						<tr>
							<td height="290" colspan="9" background="images/login_01.png">&nbsp;</td>
					  </tr>
						<tr>
							<td height="90" colspan="3" rowspan="4" background="images/login_02.png">&nbsp;</td>
							<td height="22" colspan="3" background="images/login_03.png"><input type="text" name="username" id="username" value=""
										style="width:100px;height:13px;" maxlength="20"  onkeypress="mykeypress();"></td>
							<td height="90" colspan="3" rowspan="4" background="images/login_04.png">&nbsp;</td>
					  </tr>
						<tr>
							<td height="22" colspan="3" background="images/login_05.png">&nbsp;</td>
					  </tr>
						<tr>
							<td height="22" colspan="3" background="images/login_06.png"><input type="password" name="password" id="password" value=""
										style="width:100px;height:13px;" maxlength="20" onkeypress="mykeypress();"></td>
					  </tr>
						<tr>
							<td height="24" colspan="3" background="images/login_07.png">&nbsp;</td>
					  </tr>
						<tr>
							<td height="159" colspan="2" rowspan="2" background="images/login_08.png">&nbsp;</td>
							<td height="28" colspan="2"><img src="images/login_09.png" width="68" height="28" 
								alt="登录" style="cursor:pointer;" onclick="logon();"></td>
			  				<td height="159" rowspan="2" background="images/login_10.png">&nbsp;</td>
							<td height="28" colspan="2"><img src="images/login_11.png" width="68" height="28" 
								alt="后台登录"  style="cursor:pointer;" onclick="superpin();"></td>
							<td height="159" colspan="2" rowspan="2" background="images/login_12.png">&nbsp;</td>
					  </tr>
						<tr>
							<td height="131" colspan="2" background="images/login_13.png">&nbsp;</td>
							<td height="131" colspan="2" background="images/login_14.png">&nbsp;</td>
					  </tr>
						<tr>
							<td width="352" height="74" rowspan="2" background="images/login_15.png">&nbsp;</td>
							<td height="25" colspan="7" background="images/login_16.png">&nbsp;</td>
							<td width="319" height="74" rowspan="2" background="images/login_17.png">&nbsp;</td>
					  </tr>
						<tr>
							<td height="49" colspan="7" background="images/login_18.png">&nbsp;</td>
					  </tr>
						<tr>
							<td>
								<img src="images/point.gif" width="352" height="1" alt="">
							</td>
							<td>
								<img src="images/point.gif" width="93" height="1" alt="">
							</td>
							<td>
								<img src="images/point.gif" width="34" height="1" alt="">
							</td>
							<td>
								<img src="images/point.gif" width="34" height="1" alt="">
							</td>
							<td>
								<img src="images/point.gif" width="16" height="1" alt="">
							</td>
							<td>
								<img src="images/point.gif" width="59" height="1" alt="">
							</td>
							<td>
								<img src="images/point.gif" width="9" height="1" alt="">
							</td>
							<td>
								<img src="images/point.gif" width="87" height="1" alt="">
							</td>
							<td>
								<img src="images/point.gif" width="319" height="1" alt="">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<iframe width="1px" height="1px" id="iframe1" name="iframe1"></iframe>
	</form>
</body>
</html>