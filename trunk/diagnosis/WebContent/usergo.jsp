<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
   <%//if(request.getSession().getAttribute("session_admin")==null) 
  //{ 
 // response.sendRedirect("adminlogin.jsp"); 
 //  }  
                
   %>  
    <base href="<%=basePath%>">
    
    <title>结果页面</title>
      <script type="text/javascript">
    	function confirmDel(){
			return confirm("确定删除？");
			
			    
			
    	}
    	function confirmReset(){
			return confirm("确认要重置密码吗？");
			
    	}
    	
    </script>
    
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

     <p align="right" style="margin-right:100"><a href="useraction!logoff.action"><u>注销登录</u></a></p>
  
  <table bordercolor="#4A708B" rules="all"  id="mytable" class="list_table" align="center" width="100%">
		<tr bgcolor="#4A708B">
		    <th>故障原因</th>
			<th>相关建议</th>
			
	  </tr>
    <s:iterator id="reasons" value="reasonlist" status="index1">
       
     <tr  align="center"  bordercolor="#000000" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>">
       <td><s:property value="reason"/><s:property value="verb"/></td>
       <td><s:property value="sugg"/></td>
      
     
     </tr>
     </s:iterator>
  </table>
   
    <div align="center">
       
      
      <input name="button" type=button onClick="window.location.href('rulebraction.action')" value="完成返回">
      </div>
  </body>
</html>
