<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>功能菜单</title>
    <link href="/diagnosis/css/CSS1.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <table align="center" width="1280" id="nav">
     <tr align="center">
          <!--<td><a href="/diagnosis/userruleadd.jsp">录入规则</a></td>  -->
         <!-- <td><a href="/diagnosis/ruleaction!getall.action">规则维护</a></td>
           <td><a href="/diagnosis/dcsdscribaction.action">描述维护</a></td>-->
         <td><a href="/diagnosis/biocpool490/biocpool1.jsp">模拟数据推理</a></td>
         <td><a href="/diagnosis/dcsdataaction!showdcsdatas.action">模拟数据查询</a></td>
        <td><a href="/diagnosis/errorlogaction.action">模拟报警日志</a></td>
        
        <td><a href="/diagnosis/monitoraction.action">DCS数据推理</a></td>
       
       
        <td><a href="user/usermotodcslist.jsp">DCS数据查询</a></td>
        <td><a href="/diagnosis/motoerrorlogaction.action">DCS日志查询</a></td>
        <td><a href="/diagnosis/interfaceaction.action">预警数据推理</a></td>
        <td><a href="/diagnosis/dcsdataaction!showgongyidatas.action">预警数据查询</a></td>
        <td><a href="/diagnosis/dsshistoryaction.action">预警日志查询</a></td>
         <!--<td><a href="/diagnosis/user/usernet.jsp">系统自学</a></td> -->
        <td><a href="/diagnosis/userbraction.action">智能诊断</a></td>
         <td><a href="/diagnosis/user/usershow.jsp">个人信息</a></td>
        <!--  <td><a href="/diagnosis/admin/adminlogin.jsp">管理员登录</a></td>
          <td><a href="/diagnosis/prof/proflogin.jsp">专家登陆</a></td>
         <td><a href="/diagnosis/useraction!logoff.action">注销登录</a></td>--> 
         </tr>
    </table> 
  </body>
</html>