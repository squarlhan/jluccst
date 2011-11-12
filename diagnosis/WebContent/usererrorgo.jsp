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




  <table width="70%" height="43" align="right" bordercolor="#A4BEEA" rules="all"  border="1"  id="mytable">
		<tr bgcolor="#A4BEEA">
		    <th height="18">故障原因</th>
			<th>相关建议</th>
			
	  </tr>
    <s:iterator id="reasons" value="reasonlist" status="index1">
       
     <tr  align="center"  bordercolor="#FFFFFF" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
       <td><s:property value="nouns"/><s:property value="verb"/></td>
       <td><s:property value="sugg"/></td>
      
     
     </tr>
    </s:iterator>
</table>
   
    <div align="center">
      <table width="30%" border="1">
        <tr bgcolor="#A4BEEA">
          <td width="305" height="18"><div align="center"><b >设备故障</b></div></td>
        </tr>
        <tr>
          <td><s:iterator id="result" value="backwardandResult" status="index1">
		 <p> <div   style="color: red;"><s:property value="nouns"/><s:property value="verb"/></div></div></p>
		   </s:iterator></td>
        </tr>
      </table>
      
      <p>
        <input name="button" type=button onClick="window.location.href('rulebraction.action')" value="完成返回">
      </p>
</div>
</body>
</html>
