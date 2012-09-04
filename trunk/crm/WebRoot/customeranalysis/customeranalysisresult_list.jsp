<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/page-tags"%> 
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
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>客户基本信息</title>
<link type="text/css" rel="stylesheet" href="../style.css" />
</head>

<body>
<form>
<table>	
<tr><td style="height: 20px"></td></tr>

<tr><td></td><td style="width:100%"><table>
<tr><td style="width: 20px"></td><td style="width:838px"><fieldset><legend><span>选择客户</span></legend><table style="width: 100%" cellpadding="5" cellspacing="3">

<tr><td style="width: 20px"></td><td><table cellpadding="5" cellspacing="3">
	<tr>
		<td align="center">添加客户</td>
		<td style="width: 160px;"><select name="name" style="width:100%">
			<option value=""></option>
			<option value=""></option>
			<option value=""></option></select></td>
		<td><input type="button" style="width: 67px;" class="btn_2_3" id="addbtn" value="添加" /></td>
		<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="addbtn" value="全部添加" /></td>
		<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="addbtn" value="删除所选" /></td>
	</tr>
</table></td></tr>


<tr><td style="width: 20px"></td><td style="width: 100%"><table width="100%" border="0" cellpadding="0" cellspacing="1" style="background-color: #d5e4fd">
	<tr>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')"></td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">客户名称</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">联系人</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">业务员</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">客户分类</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">成熟度</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">开发程度</td>
	
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
</table></td></tr>

</table></fieldset></td></tr>
</table></td></tr>

<tr><td style="height: 20px"></td></tr>


<tr><td style="width: 20px"></td>
<td><table>
<tr><td style="width: 20px"></td>

<td style="width:400px"><fieldset><legend><span>选择评估项目</span></legend><table style="width: 100%" cellpadding="5" cellspacing="3">

<tr><td style="width: 10px"></td><td style="width: 100%"><table width="100%" border="0" cellpadding="0" cellspacing="1" style="background-color: #d5e4fd">
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF">消费总额</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF">消费次数</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF">转介绍客户情况</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF">回款情况</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF">开发程度</td>
	</tr>
</table></td></tr>

<tr><td colspan="3"><table>
	<tr>
		<td style="width: 240px"></td>
		<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="addbtn" value="开始评估" /></td>
	</tr>
</table></td></tr>

</table></fieldset></td>

<td style="width:30px"></td><td style="width:400px"><fieldset><legend><span>定期评估设置</span></legend><table style="width: 100%" cellpadding="5" cellspacing="3">

<tr><td style="width: 10px"></td><td style="width: 100%"><table width="100%" border="0" cellpadding="0" cellspacing="1">
	<tr><td colspan="3"><table><tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 50%;">选择评估时间</td>
		<td align="center" style="height: 26px; width:160px; background-color:#FFFFFF"><select name="name" style="width:100%">
			<option value=""></option>
			<option value="">9:00</option>
			<option value="">11:00</option></select></td>
		</tr></table></td>
	</tr>
	<tr>
		<td style="height:20px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; width:40%; background-color:#FFFFFF"><input type="radio"/></td>
		<td align="left" style="height: 26px; background-color:#FFFFFF">每日评估</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; width:40%; background-color:#FFFFFF"><input type="radio"/></td>
		<td align="left" style="height: 26px; background-color:#FFFFFF">每周评估</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; width:40%; background-color:#FFFFFF"><input type="radio"/></td>
		<td align="left" style="height: 26px; background-color:#FFFFFF">每月评估</td>
	</tr>
</table></td></tr>

<tr><td colspan="3"><table>
	<tr>
		<td style="width: 240px"></td>
		<td style="width: 65px"><input type="button" style="width: 67px;" class="btn_2_3" id="addbtn" value="保存" /></td>
	</tr>
</table></td></tr>

</table></fieldset></td>

</tr></table></td>
</tr>

<tr><td></td><td><table>
	<tr><td style="height: 10px"></td></tr>
	<tr>
		<td style="width: 700px"></td>
		<td style="width: 65px"><input type="button" style="width: 67px;" class="btn_2_3" onclick="window.history.go(-1)" value="保存" /></td>
		<td></td>
		<td style="width: 65px"><input type="button" style="width: 67px;" class="btn_2_3" onclick="window.history.go(-1)" value="关闭" /></td>
		<td></td>
	</tr>
</table></td></tr>

</table>
</form>
</body>

</html>

