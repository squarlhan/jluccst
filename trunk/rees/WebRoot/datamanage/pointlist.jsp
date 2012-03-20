<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<j:scriptlink css="true" jquery="true" />
	<script type="text/javascript">
	<!--
	$(document).ready(function() {
		$("#addpointdata").click(function() {
			parent.parent.parent.tipsWindown("添加监测点数据", "iframe:datamanage/pointdatainfo.jsp", "400", "260", "true", "", "true", "");
		});
	});
	//-->
	</script>
	</head>
	<body>
		<table width="100%" style="height: 100%;" border="0" cellspacing="5"
			cellpadding="0">
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="5" cellpadding="0">
						<tr>
							<td>
								日期：
								<select name="">
									<option value="1">
										2012年2月
									</option>
								</select>
								<input name="打开设备图" class="btn_4" type="button" value="打开设备图"
									onClick="window.open('clickpicture.html')" />
								<input name="查看频谱图" class="btn_4" type="button" value="查看柱状图"
									onClick="window.open('../images/柱状图样子.png')" />
								<input class="btn_5" type="button" value="添加监测数据" id="addpointdata" />
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#d5e4fd">
						<tr>
							<td colspan="2" align="center"
								background="../images/headerbg.jpg">
								测点（A）
							</td>
							<td colspan="2" align="center"
								background="../images/headerbg.jpg">
								测点（B）
							</td>
							<td colspan="2" align="center"
								background="../images/headerbg.jpg">
								测点（C）
							</td>
						</tr>
						<tr>
							<td align="center" bgcolor="#FFFFFF">
								参数
							</td>
							<td align="center" bgcolor="#FFFFFF">
								数据
							</td>
							<td align="center" bgcolor="#FFFFFF">
								参数
							</td>
							<td align="center" bgcolor="#FFFFFF">
								数据
							</td>
							<td align="center" bgcolor="#FFFFFF">
								参数
							</td>
							<td align="center" bgcolor="#FFFFFF">
								数据
							</td>
						</tr>
						<tr>
							<td align="center" bgcolor="#FFFFFF">
								a
							</td>
							<td align="center" bgcolor="#FFFFFF">
								6.4
							</td>
							<td align="center" bgcolor="#FFFFFF">
								a
							</td>
							<td align="center" bgcolor="#FFFFFF">
								5.5
							</td>
							<td align="center" bgcolor="#FFFFFF">
								a
							</td>
							<td align="center" bgcolor="#FFFFFF">
								6.1
							</td>
						</tr>
						<tr>
							<td align="center" bgcolor="#FFFFFF">
								v
							</td>
							<td align="center" bgcolor="#FFFFFF">
								3.8
							</td>
							<td align="center" bgcolor="#FFFFFF">
								v
							</td>
							<td align="center" bgcolor="#FFFFFF">
								4.2
							</td>
							<td align="center" bgcolor="#FFFFFF">
								v
							</td>
							<td align="center" bgcolor="#FFFFFF">
								4.0
							</td>
						</tr>
						<tr>
							<td align="center" bgcolor="#FFFFFF">
								h
							</td>
							<td align="center" bgcolor="#FFFFFF">
								9.9
							</td>
							<td align="center" bgcolor="#FFFFFF">
								h
							</td>
							<td align="center" bgcolor="#FFFFFF">
								10.1
							</td>
							<td align="center" bgcolor="#FFFFFF">
								h
							</td>
							<td align="center" bgcolor="#FFFFFF">
								10.0
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>

