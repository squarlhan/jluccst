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
    <table align="center" width="100%" id="nav">
          <tr align="center">
          <td><a href="/diagnosis/ruleaction!justgo.action">录入规则</a></td>
          <td><a href="/diagnosis/ruleaction!getall.action">规则维护</a></td>
          <td><a href="/diagnosis/dcsdscribaction!goadd.action">录入参数</a></td>
           <td><a href="/diagnosis/dcsdscribaction.action">参数维护</a></td>
            <td><a href="/diagnosis/rulebraction.action">智能诊断</a></td>
           <td><a href="/diagnosis/prof/profshow.jsp">个人信息</a></td>
           <td><a href="/diagnosis/user/userlogin.jsp">用户登录</a></td>
          <td><a href="/diagnosis/admin/adminlogin.jsp">管理员登录</a></td>
          <td><a href="/diagnosis/profaction!proflogoff.action">注销登录</a></td>
          </tr>
    </table> 
  </body>
</html>