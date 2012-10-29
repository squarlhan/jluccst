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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户档案管理</title>
<link type="text/css" rel="stylesheet" href="../style.css" />
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
/*
.STYLE2 {
background-color:#d3eaef}
*/
.STYLE6 {color: #000000; font-size: 12px; }
.STYLE10 {color: #000000; font-size: 12px; background:#d3eaef; 	letter-spacing: 2pt; padding:0px 20px}
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
/*字号，字间距，颜色黑，背景色，左右边距，是查询和列表项目 */
.style11{
	color: #000000;
	font-size: 12px;
	letter-spacing: 1pt;
	background-color:#d3eaef;
	padding: 0px 10px;
}
-->
</style>
<link rel="StyleSheet" href="tree.css" type="text/css">
	<script type="text/javascript" src="tree.js"></script>
	<script type="text/javascript">
		<!--
		var Tree = new Array;
		// nodeId | parentNodeId | nodeName | nodeUrl
		Tree[0]  = "1|0|长春分公司|#";
		Tree[1]	 = "2|1|销售部|#";
		Tree[2]  = "3|1|市场部|#";
		Tree[3]  = "4|1|采购部|#";
		Tree[4]  = "5|1|部门一|#";
		Tree[5] = "6|0|沈阳分公司|#";
		//-->


var  highlightcolor='#d5f4fe';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function showwin(){
	var url = "customerVisitingEdited.html";
	window.location.href = url;
}

function deleteAll(){
	if(window.confirm("您确定要删除信息吗！")){
		alert("删除成功！");
	}else{}
}

</script>


</head>

<body>

<table width="100%" >

<!--总框架下的第二行（第一列），查询条件与按钮-->
<tr><td><table border="0" cellpadding="5" cellspacing="0">
	<tr>  		
		<td></td>
		<td align="center">客户名称</td>
		<td><input type="text" /></td>
		<td></td>
		<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="addBtn" value="快速查询" /></td>
	</tr>
</table></td></tr>
<!--总框架下的第二行（第一列），查询条件与按钮   结束！-->
<!--总第三行第一列,表格主体-->
<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="1" style="background-color: #d5e4fd">
	<tr>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg'); width: 90px;"></td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">客户名称</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">成熟度</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">开发程度</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">消费额度</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">消费次数</td>
		<td align="center" style="height: 26px; background-image:url('../images/headerbg.jpg')">变化情况</td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
	<tr>
		<td align="center" style="height: 26px; background-color:#FFFFFF; width: 90px;" ><input type="checkbox" name="checkbox" id="checkbox" /></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
		<td align="center" style="height: 26px; background-color:#FFFFFF"></td>
	</tr>
</table></td></tr>
<!--总第三行第一列,表格主体   结束！-->

<!--总第四行第一列  表格分页-->
<tr><td style="width:100%"><table>
<tr>
<td align="right" style="height:26px; background-color:#FFFFFF; width: 1400px;"#">首　页</a>　<a href="#">上一页</a>　<a href="#">下一页</a>　<a href="#">尾　页</a>　当前[1/1]页</td>
</tr>
</table></td></tr>
<!--总第四行第一列  表格分页   结束！--> 

</table>
</body>
</html>
