<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%if(request.getSession().getAttribute("ad")==null) 
  { 
  response.sendRedirect("adminlogin.jsp"); 
   }  
                
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

    <div style="color: green;"> <strong><s:property value="#session.ad.username"/>:</strong>  ����
         <br><a href="adminshow.jsp"><U>�޸ĸ�����Ϣ</U></a></p></div>
 
  <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">
		    <th>USERNAME</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th>JID</th>
			<th>DEPT</th>
			<th>����Ա����</th>
	  </tr>
    <s:iterator id="users" value="userlist" status="index1">
       
     <tr  align="center"  bordercolor="#FFFFFF" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
       <td><s:property value="username"/></td>
       <td><s:property value="name"/></td>
       <td><s:property value="email"/></td>
        <td><s:property value="phone"/></td>
       <td><s:property value="jid"/></td>
       <td><s:property value="dept"/></td>
      <td width="200" height="35">
						
							<s:a href="useraction!chUser?user.id=%{#users.id}" onclick="return confirmReset();">��������</s:a>

						
						&nbsp;
						<s:a href="useraction!deleteUser?user.id=%{#users.id}" onclick="return confirmDel();">
																						ɾ��</s:a>

	   </td>
     </tr>
     </s:iterator>
  </table>
   
    <div align="center">
      <input type=button onclick="window.location.href('adminadduser.jsp')" value="�����û�"> 
      
      <input name="button" type=button onClick="window.location.href('usersearchuser.jsp')" value="�����û�">
      </div>
  </body>
</html>
