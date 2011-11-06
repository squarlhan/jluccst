<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%if(request.getSession().getAttribute("us")==null) 
  { 
  response.sendRedirect("userlogin.jsp"); 
   }  
                
   %>  
    <base href="<%=basePath%>">
    
    <title>净水厂设备诊断专家系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <div id="rightmain">
   
      <table width="80%" height="30" border="0" cellspacing="0">
       </div>
        <p align="right"><a href="useraction!logoff.action"><u>注销登录</u></a></p></td>
      </tr>
    </table>
    <p class="STYLE1"><br>
    </p>
    </div><br>
	  <div id="login">
<s:form action="ruleaction">

<table width="300" align="center" style="margin-left:30">
	<tr>
	<td >
	故障设备名称：
	 
	    <select name="result.nouns" size="1">
	     <s:iterator id="backs" value="backwardandResultlist1" status="index1">
	      <option><s:property /></option>
	      </s:iterator>
	      </select>
	    </td>
	</tr>
	<tr>
	<td >故障设备现象：
	  <select name="result.verb" size="1">
	       <s:iterator id="backs" value="backwardandResultlist2" status="index1">
	      <option><s:property /></option>
	      </s:iterator>
	    </select>
	  </td>
	</tr>
	</table>
	<br/>
	<table width="300" align="center" style="margin-left:10">
	<tr>
	<td width="80" ><s:submit value="开始推理" /></td>
	</tr></table>
</s:form></div>
</div>
   
  </body>
</html>
