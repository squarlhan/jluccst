<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%//if(request.getSession().getAttribute("session_admin")==null) 
  //{ 
 // response.sendRedirect("adminlogin.jsp"); 
 //  }  
                
   %>  
    <base href="<%=basePath%>">
    
    <title>���ҳ��</title>
      <script type="text/javascript">
    	function confirmDel(){
			return confirm("ȷ��ɾ����");
			
			    
			
    	}
    	function confirmReset(){
			return confirm("ȷ��Ҫ����������");
			
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

    <div style="color: green;"> <strong><s:property value="#session.ad.username"/>:</strong>  �˴�Ϊǰ��
    
  
  <table bordercolor="#4A708B" rules="all"  id="mytable" class="list_table" align="center" width="100%">
		<tr bgcolor="#4A708B">
		    <th>����ԭ��</th>
			<th>��ؽ���</th>
			
	  </tr>
    <s:iterator id="users" value="userlist" status="index1">
       
     <tr  align="center"  bordercolor="#000000" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>">
       <td><s:property value="reason"/></td>
       <td><s:property value="adwive"/></td>
      
     
     </tr>
     </s:iterator>
  </table>
   
    <div align="center">
       
      
      <input name="button" type=button onClick="window.location.href('findreason.jsp')" value="��ɷ���">
      </div>
  </body>
</html>
