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
    <table width="800" border="0" align="center" cellpadding="0" cellspacing="0" class="dht">
          <tr align="center">
          <td><a href="adminuseraction!userList.action">管理用户</a></td>
           <td><a href="/diagnosis/admin/adminsearchuser.jsp">查找用户</a></td>
         <td><a href="/diagnosis/admin/adminadduser.jsp">添加用户</a></td>
          <td><a href="/diagnosis/admin/adminshow.jsp">个人信息</a></td>
          <td><a href="/diagnosis/user/userlogin.jsp">用户登录</a></td>
           <td><a href="/diagnosis/prof/proflogin.jsp">专家登录</a></td>
          <!-- <td><a href="adminaction!adminlogoff.action">注销登录</a></td> -->
          </tr>
    </table> 
  </body>
</html>