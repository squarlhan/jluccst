<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" jquery="true" />
		<script type="text/javascript">
		<!--
			$(document).ready(function() {
				$("#closeBtn").click(function() {
					parent.$("#windown-close").click();
				});
			});
		//-->
		</script>
	</head>
	<body style="padding:5px;">
		<form>
			<table width="100%" border="0" cellpadding="5" cellspacing="1"
				bgcolor="#d5e4fd">
				<tr>
					<td height="26" colspan="2" align="center"
						background="../images/headerbg.jpg">
						测点（A）
					</td>
					<td colspan="2" align="center" background="../images/headerbg.jpg">
						测点（B）
					</td>
					<td colspan="2" align="center" background="../images/headerbg.jpg">
						测点（C）
					</td>
				</tr>
				<tr>
					<td align="center" bgcolor="#FFFFFF">
						参数
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						数据
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						参数
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						数据
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						参数
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						数据
					</td>
				</tr>
				<tr>
					<td align="center" bgcolor="#FFFFFF">
						a
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						<input name="" type="text" size="6" maxlength="6">
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						a
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						<input name="input3" type="text" size="6" maxlength="6">
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						a
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						<input name="input6" type="text" size="6" maxlength="6">
					</td>
				</tr>
				<tr>
					<td align="center" bgcolor="#FFFFFF">
						v
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						<input name="input" type="text" size="6" maxlength="6">
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						v
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						<input name="input4" type="text" size="6" maxlength="6">
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						v
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						<input name="input7" type="text" size="6" maxlength="6">
					</td>
				</tr>
				<tr>
					<td align="center" bgcolor="#FFFFFF">
						h
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						<input name="input2" type="text" size="6" maxlength="6">
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						h
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						<input name="input5" type="text" size="6" maxlength="6">
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						h
					</td>
					<td height="26" align="center" bgcolor="#FFFFFF">
						<input name="input8" type="text" size="6" maxlength="6">
					</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			<center style="padding:5px;">
				<input id="addBtn" type="button" value="保存" class="btn_2_3" />
				<input id="closeBtn" type="button" value="关闭" class="btn_2_3" />
			</center>
		</form>
	</body>
</html>