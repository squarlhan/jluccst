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

    <div style="color: green;"> <strong><s:property value="#session.ad.username"/>:</strong>  ����
    <p class="STYLE1"><a href="adminshow.jsp">�޸ĸ�����Ϣ</a></p></div><br>
  
  <table bordercolor="#4A708B" rules="all"  id="mytable" class="list_table" align="center" width="100%">
		<tr bgcolor="#4A708B">
		    <th>USERNAME</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th>JID</th>
			<th>����Ա����</th>
	  </tr>
    <s:iterator id="users" value="userlist" status="index1">
       
     <tr  align="center"  bordercolor="#000000" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>">
       <td><s:property value="username"/></td>
       <td><s:property value="name"/></td>
       <td><s:property value="email"/></td>
        <td><s:property value="phone"/></td>
       <td><s:property value="jid"/></td>
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
      
      <input name="button" type=button onClick="window.location.href('searchuser.jsp')" value="�����û�">
      </div>
  </body>
</html>
