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
    
    <title>������������</title>
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
	  <h2>������־</h2>
	
     
 
  <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">
		    <th width = "15%">���Ͻڵ�</th>
			<th width = "15%">���Ʋ���</th>
			<th width = "20%">��Ӧ����</th>
			<th width = "10%">���ֵ</th>
			<th width = "10%">��Сֵ</th>
			<th width = "20%">��ز���</th>
	  </tr>
    <s:iterator id="dcsdscribs" value="dcsdscriblist" status="index1">
       
     <tr  align="center"  bordercolor="#FFFFFF" rules="all" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
       <td><s:property value="eque"/>&nbsp;</td>
       <td><s:property value="item"/>&nbsp;</td>
       <td><s:property value="name"/>&nbsp;</td>
        <td><s:property value="upper"/>&nbsp;</td>
       <td><s:property value="lower"/>&nbsp;</td>
       
        <td width="200" height="35">
						
							<s:a href="adminuseraction!chUser?user.id=%{#users.id}" >�޸�</s:a>

						
						&nbsp;
						<s:a href="adminuseraction!deleteUser?user.id=%{#users.id}" onclick="return confirmDel();">
																						ɾ��</s:a>

	   </td>
     </tr>
     </s:iterator>
  </table>
   
  </body>
</html>
