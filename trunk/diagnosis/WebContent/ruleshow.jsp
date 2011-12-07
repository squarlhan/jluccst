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
    
    <title>规则修改界面</title>
     <script type="text/javascript">
    	function confirmDel(){
			return confirm("确定删除？");
			
			    
			
    	}
    	function confirmReset(){
			return confirm("确认修改？");
			
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
	  <h2>规则修改界面</h2>
	  
   
<s:form action="useraction!alterUser.action">
<table width="320" align="center" style="margin-left:30">
	<tr>
	 <td ><label>
	   <s:property value="result.nouns+result.verb"/>
	  
	    </label></td>
	  </tr>
	
	 <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">

			<th width = "20%">原因名词</th>
			<th width = "20%">原因动词</th>
			<th width = "50%">相关建议</th>			
			<th width = "10%">相关操作</th>	
	  </tr>
    <s:iterator id="reasons" value="reasonlist" status="index1">
     <tr  align="center"  bordercolor="#FFFFFF" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
    
       <td><s:textfield name="nouns" value="%{nouns}" theme = "simple" size="10" style="background:transparent;border:0px" />&nbsp;</td>   
       <td><s:textfield name="verb" value="%{verb}" theme = "simple" size="10" id="verb[%{#id}] " style="background:transparent;border:0px" />&nbsp;</td>
       <td><s:textfield   name="sugg" value="%{sugg}" theme = "simple" size="40" id="upper[%{#id}]" style="background:transparent;border:0px"  />&nbsp;</td>
          <td>
		<s:a href="backwardresonaction!update?backwardandreason.id=%{id}" onclick="return confirmReset();">修改</s:a>

						
						&nbsp;
		<s:a href="backwardresonaction!delete?backwardandreason.id=%{id}" onclick="return confirmDel();">
																						删除</s:a>
       
	   </td>
     </tr>
     </s:iterator>
  </table>

	
</s:form></div>

   
  </body>
</html>
