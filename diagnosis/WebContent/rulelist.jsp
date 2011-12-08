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
    
    <title>规则维护</title>
    <script type="text/javascript">
    	function confirmDel(){
			return confirm("确定删除？");	
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
	  <h2>规则维护</h2>
	
     
 <div align="right">
      <input name="button" type=button onClick="window.location.href('ruleaction!justgo.action')" value="新建规则">
      </div>
  <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">
		     <th width = "10%">排号</th>
		    <th width = "40%">规则对应故障节点</th>
			<th width = "30%">规则对应控制参数</th>		
			<th width = "20%">相关操作</th>
	  </tr>
    <s:iterator id="backs" value="backlist" status="index1">
     <tr  align="center"  bordercolor="#FFFFFF" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
       <td><s:a href="ruleaction!godetail?rule.bid=%{#backs.bid}" ><s:property value="bid"/></s:a></td>
       <td><s:property value="name"/>&nbsp;</td>
       <td><s:property value="memo"/>&nbsp;</td>       
        <td>
			<s:a href="ruleaction!delRule?rule.bid=%{#backs.bid}" onclick="return confirmDel();">删除</s:a>
	   </td>
     </tr>
     </s:iterator>
  </table>
   
  </body>
</html>
