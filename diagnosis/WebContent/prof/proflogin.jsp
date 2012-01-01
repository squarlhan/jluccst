<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>专家登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="/diagnosis/css/CSS1.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
  </head>
  
<body onload="MM_preloadImages('pic/an_pt_hui.jpg','pic/an_gl_hui.jpg','pic/an_zj_hui.jpg','pic/dl_an_dl_shen.jpg','pic/dl_an_zc_shen.jpg')">
<s:form action="profaction!exitsprof.action" theme = "simple">
<table width="1024" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="7"><img src="pic/dl_top.jpg" width="1024" height="516" /></td>
  </tr>
  <tr>
    <td width="268" height="377" rowspan="6"></td>
    <td width="131" height="22"><a href="/diagnosis/user/userlogin.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image2','','pic/an_pt_hui.jpg',1)"><img src="pic/an_pt_lan.jpg" name="Image2" width="131" height="37" border="0" id="Image2" /></a></td>
    <td width="48"></td>
    <td width="131"><a href="/diagnosis/admin/adminlogin.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image3','','pic/an_gl_hui.jpg',1)"><img src="pic/an_gl_lan.jpg" name="Image3" width="131" height="37" border="0" id="Image3" /></a></td>
    <td width="48"></td>
    <td width="131"><img src="pic/an_zj_hui.jpg" width="131" height="37" /></td>
    <td width="268" height="377" rowspan="6"></td>
  </tr>
  <tr>
    <td height="60" colspan="5"></td>
  </tr>
  <tr>
    <td colspan="5"><table width="180" align="center" cellspacing="10">
      <tr>
        <td width="73" align="right"><img src="pic/dl_yhm.jpg" width="61" height="20" /></td>
        <td width="12"></td>
        <td><input name="user.username" type="text" id="textfield2" size="10" /></td>
      </tr>
      <tr>
        <td align="right"><img src="pic/dl_mm.jpg" width="61" height="20" /></td>
        <td></td>
        <td><input name="user.password" type="password" id="textfield" size="11" /></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td align="right"><INPUT tabIndex="3"  type="submit" value="登录">&nbsp;&nbsp;&nbsp;</td>
        <td></td>
        <td align="center"><INPUT  tabIndex="4" type="reset" value="取消"  name="button"></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="60" colspan="5"></td>
  </tr>
  <tr>
    <td colspan="5"><div align="center"><img src="pic/zgsy_logo.jpg" width="340" height="53" /></div></td>
  </tr>
  <tr>
    <td colspan="5"></td>
  </tr>
</table>
</s:form>
</body>
</html>
