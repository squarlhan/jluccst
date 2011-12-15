<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>功能菜单</title>
    <link href="/diagnosis/css/css.css" rel="stylesheet" type="text/css" />
    <link href="/diagnosis/css/main.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <table align="center" width="100%" id="nav">
          <!--<tr align="center"><td><li><a href="/diagnosis/userruleadd.jsp">录入规则</a></li></td></tr>  -->
         <!-- <tr align="center"><td><li><a href="/diagnosis/ruleaction!getall.action">规则维护</a></li></td></tr>
           <tr align="center"><td><li><a href="/diagnosis/dcsdscribaction.action">描述维护</a></li></td></tr>-->
          <tr align="center"><td><li><a href="/diagnosis/biocpool490/biocpool1.jsp">手工数据录入</a></li></td></tr>
         <tr align="center"><td><li><a href="/diagnosis/monitoraction.action">手工数据推理</a></li></td></tr>
         <tr align="center"><td><li><a href="/diagnosis/dcsdataaction!showdcsdata.action">手工数据查询</a></li></td></tr>
         <tr align="center"><td><li><a href="/diagnosis/errorlogaction.action">手工报警日志</a></li></td></tr>
         <!--<tr align="center"><td><li><a href="#">DCS数据推理</a></li></td></tr>
         <tr align="center"><td><li><a href="#">DCS数据查询</a></li></td></tr>
         <tr align="center"><td><li><a href="#">DCS日志查询</a></li></td></tr>-->
         <tr align="center"><td><li><a href="/diagnosis/interfaceaction.action">预警数据推理</a></li></td></tr>
         <tr align="center"><td><li><a href="/diagnosis/dcsdataaction!showgongyidata.action">预警数据查询</a></li></td></tr>
         <tr align="center"><td><li><a href="/diagnosis/dsshistoryaction.action">预警日志查询</a></li></td></tr>
         <!-- <tr align="center"><td><li><a href="/diagnosis/user/usernet.jsp">系统自学</a></li></td></tr> -->
         <tr align="center"><td><li><a href="/diagnosis/userbraction.action">智能诊断</a></li></td></tr>
          <tr align="center"><td><li><a href="/diagnosis/user/usershow.jsp">个人信息</a></li></td></tr>
          <tr align="center"><td><li><a href="/diagnosis/admin/adminlogin.jsp">管理员登录</a></li></td></tr>
           <tr align="center"><td><li><a href="/diagnosis/prof/proflogin.jsp">专家登陆</a></li></td></tr>
          <tr align="center"><td><li><a href="/diagnosis/useraction!logoff.action">注销登录</a></li></td></tr>
    </table> 
  </body>
</html>