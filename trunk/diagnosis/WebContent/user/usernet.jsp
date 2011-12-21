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
    
    <title>前馈型神经网络</title>
    
    
    
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
  <form id="form1" name="form1" method="post" action="">
  <p align="center"><h2>前馈型神经网络</h2></p>
  <table  width="100%" height="247" border="20" bordercolor="#000000" align="center" cellspacing="0" >
    <tr>
      <td height="20"><strong>应用网络数：</strong>
        <input type="text" name="textfield" />      </td>
    </tr>
    <tr>
      <td height="114"><table width="100%" height="126" border="0" cellspacing="0">
        <tr>
          <td height="15" colspan="9" bgcolor="#4A708B"><div align="center"><strong>参数设置</strong></div></td>
          </tr>
        <tr>
         
          <td>训练误差：</td>
          <td height="40"><div align="center">
            <input type="text" name="textfield3" size="18" />          
          </div></td>
          <td>迭代数：</td>
          <td><div align="center">
            <input type="text" name="textfield32" size="12" />          
          </div></td>
          <td>连接权参数：</td>
          <td><div align="center">
            <input type="text" name="textfield322" size="12" />          
          </div></td>
          <td>阈值参数:</td>
          <td><div align="center">
            <input type="text" name="textfield323" size="12" />
          </div></td>
        </tr>
       
      </table></td>
    </tr>
    <tr>
      <td height="77"><table width="100%" height="72" border="0" cellspacing="0">
        <tr>
          <td height="27" colspan="4" bgcolor="#4A708B"><strong>操作&nbsp;&nbsp;
            </strong>
            <select name="select" size="1">
              <option>BP</option>
                                          </select>
          </td>
        </tr>
        <tr>
          <td width="35%"><div align="center">
            <input type="submit" name="Submit" value="录入信号" />
            <input type="submit" name="Submit2" value=".." />
          </div></td>
          <td width="32%"><div align="center">
            <input type="submit" name="Submit3" value="教师信号" />
            <input type="submit" name="Submit22" value=".." />
          </div></td>
          <td width="18%"><div align="center">
            <input type="submit" name="Submit32" value="训练" />
          </div></td>
          <td width="15%"><div align="center">
            <input type="submit" name="Submit33" value="应用" />
          </div></td>
        </tr>
      </table></td>

    </tr>
  </table>
</form>
   
  </body>
</html>
