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
  
   
    <base href="<%=basePath%>">
    
    <title>���ҳ��</title>
    
      <script type="text/javascript">
    	function confirmDel(){
			return confirm("ȷ��ɾ����");
			
			    
			
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

     <div id="rightmain">
	  <h2>ʵʱ������ʾ</h2>
	
     
 
  <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">
		    <th>�豸����</th>
			<th>����</th>
			<th>��������</th>
			<th>�绰</th>
			<th>������</th>
			<th>����</th>
			<th>����Ա����</th>
	  </tr>
    <s:iterator id="users" value="userlist" status="index1">
       
     <tr  align="center"  bordercolor="#FFFFFF" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
       <td><s:property value="username"/>&nbsp;</td>
       <td><s:property value="name"/>&nbsp;</td>
       <td><s:property value="email"/>&nbsp;</td>
        <td><s:property value="phone"/>&nbsp;</td>
       <td><s:property value="jid"/>&nbsp;</td>
       <td><s:property value="dept"/>&nbsp;</td>
      <td width="200" height="35">
						
							<s:a href="adminuseraction!chUser?user.id=%{#users.id}" onclick="return confirmReset();">��������</s:a>

						
						&nbsp;
						<s:a href="adminuseraction!deleteUser?user.id=%{#users.id}" onclick="return confirmDel();">
																						ɾ��</s:a>

	   </td>
     </tr>
     </s:iterator>
  </table>
   
  </body>
</html>
