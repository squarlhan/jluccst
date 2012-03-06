<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/page-tags.tld"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>/style.css"" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=basePath%>/tipswindow.css" type="text/css"></link>
  	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/tipswindown.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jmessagebox-1.0.1.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jquery.messager.js"></script>
  	<script type="text/javascript">
  	$(document).ready( function() {
  		$("#btn_add").click(function(){
  			tipsWindown("添加设备","iframe:openAddDemoAction.action","460","250","true","","true","no");
  			//window.location.href="./openAddDemoAction.action";
  			return false;
  		});
  	});
  	</script>
  	</head>
  
  <body>
  
   	<table border="1">
   		<tr>
   			<td colspan="5">
   				<input type="button" id="btn_add" value="添加" />
   				<s:submit value="修改" theme="simple"></s:submit>
   				<s:submit value="删除所选" theme="simple"></s:submit>
   			</td>
   		</tr>
		<tr>
   			<td align="center" >  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
   			<td>
   				序号
   			</td>
   			<td>
   				名称
   			</td>
   			<td>
   				年龄
   			</td>
 		</tr>
   		<s:iterator value="demoModelList" status="obj">
		<tr>
  			<td align="center" >  
				<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{#obj.id}" value="false" theme="simple"/>
			</td>
  				<td>
   				 <s:property value="#obj.index+1"/>
   			</td>
   			<td>
   				<s:property value="name"/>&nbsp;
   			</td>
   			<td>
   				<s:property value="age"/>&nbsp;
   			</td>
		</tr>
   		</s:iterator>
   		<tr>
			<td colspan="5">
			<page:pages pageNo="pageNo" total="total" styleClass="page" theme="text">
				<s:param name="dd">ddd</s:param>
			</page:pages> 
		   	</td>
		</tr>
   	</table>
  </body>
</html>
