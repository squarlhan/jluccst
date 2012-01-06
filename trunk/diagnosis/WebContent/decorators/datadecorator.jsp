<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "No-cache");//HTTP 1.1
	response.setHeader("Cache-Control", "no-cache");//HTTP 1.0
	response.setHeader("Expires", "0");//防止被proxy
%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><decorator:title default="污水处理工艺专家决策支持系统" /></title>

<script type="text/javascript">
<!--
	function MM_preloadImages() { //v3.0
		var d = document;
		if (d.images) {
			if (!d.MM_p)
				d.MM_p = new Array();
			var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
			for (i = 0; i < a.length; i++)
				if (a[i].indexOf("#") != 0) {
					d.MM_p[j] = new Image;
					d.MM_p[j++].src = a[i];
				}
		}
	}
	function MM_swapImgRestore() { //v3.0
		var i, x, a = document.MM_sr;
		for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
			x.src = x.oSrc;
	}
	function MM_findObj(n, d) { //v4.01
		var p, i, x;
		if (!d)
			d = document;
		if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
			d = parent.frames[n.substring(p + 1)].document;
			n = n.substring(0, p);
		}
		if (!(x = d[n]) && d.all)
			x = d.all[n];
		for (i = 0; !x && i < d.forms.length; i++)
			x = d.forms[i][n];
		for (i = 0; !x && d.layers && i < d.layers.length; i++)
			x = MM_findObj(n, d.layers[i].document);
		if (!x && d.getElementById)
			x = d.getElementById(n);
		return x;
	}

	function MM_swapImage() { //v3.0
		var i, j = 0, x, a = MM_swapImage.arguments;
		document.MM_sr = new Array;
		for (i = 0; i < (a.length - 2); i += 3)
			if ((x = MM_findObj(a[i])) != null) {
				document.MM_sr[j++] = x;
				if (!x.oSrc)
					x.oSrc = x.src;
				x.src = a[i + 2];
			}
	}
//-->
</script>
<link href="/diagnosis/css/CSS1.css" rel="stylesheet" type="text/css" />
<link href="/diagnosis/css/tree.css" rel="stylesheet" type="text/css" />
<decorator:head />
</head>

<body>
	<table width="1298" border="0" align="center" cellpadding="0"
		cellspacing="0" bgcolor="#FFFFFF">
		<tr>
			<td width="9"><img src="pic/bj_zuo.jpg" width="10" height="890" /></td>
			<td width="1280" valign="top">
				<table width="1280" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td><img src="pic/top_pt.jpg" width="1280" height="131"  border="0" usemap="#Map" /></td>
					</tr>
					<tr>
						<td height="38" background="pic/dht_bj.jpg"><page:applyDecorator page="/decorators/mainmenu.jsp" name="panel" /></td>
					</tr>
					<tr>
						<td><img src="pic/top_gy.jpg" width="1280" height="41" /></td>
					</tr>
					<tr>
						<td height="612" valign="top">
						     <table width="10" 	align="center">
								<tr>
									<td height="5"></td>
								</tr>
							</table>
							<table border="0" align="center" cellpadding="0" cellspacing="0"
								class="bg1">
								<tr>
								<td height="38" class="table2"><page:applyDecorator page="/decorators/treedata.jsp" name="panel" /></td>
									<td height="81" colspan="10" class="table1"><decorator:body /></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td><img src="pic/end_logo.jpg" width="1280" height="48" /></td>
					</tr>
				</table>
			</td>
			<td width="10"><img src="pic/bj_you.jpg" width="10" height="890" /></td>
		</tr>
	</table>
	<script Language="JavaScript"><%@ include file="tree.js"%></script>
	<map name="Map" id="Map"><area shape="rect" coords="1165,20,1262,50" href="useraction!logoff.action" /></map>
</body>
</html>