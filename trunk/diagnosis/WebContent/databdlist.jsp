<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <%if(request.getSession().getAttribute("pr")==null) 
  { 
  response.sendRedirect("prof/proflogin.jsp"); 
   }  
                
   %>  
   
    <base href="<%=basePath%>">
    
    <title>数据描述维护</title>
    <script type="text/javascript">
    	function confirmDel(){
			return confirm("确定删除？");	
    	}
    	function confirmChge(did){
			if(confirm("确认修改？")){
				var upper = document.getElementById("upper["+did+"]");
				var lower = document.getElementById("lower["+did+"]");
				var url = "dcsdscribaction!chDscrib.action?dcsDscrib.lower="+lower.value+"&dcsDscrib.upper="+upper.value+"&dcsDscrib.did="+did;
				var a = document.getElementById("a["+did+"]");
				a.href = url;
				return true;
			}
			return false;
			
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
	  <h2>数据描述维护</h2>
	
    <!-- 
 <div align="right">
      <input name="button" type=button onClick="window.location.href('dcsdscribaction!goadd.action')" value="新建参数描述">
      </div> --> 
  <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">
		    <th width = "13%">故障节点</th>
			<th width = "15%">控制参数</th>
			<th width = "25%">对应名称</th>
			<th width = "10%">最小值</th>
			<th width = "10%">最大值</th>			
			<th width = "17%">相关操作</th>
	  </tr>
    <s:iterator id="dcsdscribs" value="dcsdscriblist" status="index1">
     <tr  align="center"  bordercolor="#FFFFFF" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
       <td><s:property value="eque"/>&nbsp;</td>
       <td><s:property value="item"/>&nbsp;</td>
       <td><s:property value="name"/>&nbsp;</td>       
       <td><s:textfield name="dcsDscrib.lower" value="%{#dcsdscribs.lower}" theme = "simple" size="10" id="lower[%{#dcsdscribs.did}]"/>&nbsp;</td>
       <td><s:textfield name="dcsDscrib.upper" value="%{#dcsdscribs.upper}" theme = "simple" size="10" id="upper[%{#dcsdscribs.did}]"/>&nbsp;</td>
        <td>
			<s:a id="a[%{#dcsdscribs.did}]" href="#" onclick="return confirmChge(%{#dcsdscribs.did});">修改</s:a>
             &nbsp;
			<s:a href="dcsdscribaction!deleteDscrib?dcsDscrib.did=%{#dcsdscribs.did}" onclick="return confirmDel();">删除</s:a>
	   </td>
     </tr>
     </s:iterator>
  </table>
   
  </body>
</html>
