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
    	function confirmChge(id){
    		if(confirm("确认修改？")){
				var nouns = document.getElementById("nouns["+id+"]");
				var verb = document.getElementById("verb["+id+"]");
				var sugg = document.getElementById("sugg["+id+"]");
				var url = "backwardresonaction!update?backwardandReason.id="+id+"&backwardandReason.nouns="+nouns.value+"&backwardandReason.verb="+verb.value+"&backwardandReason.sugg="+sugg.value;
				var a = document.getElementById("a["+id+"]");
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
	<script  language="javascript">

  var count1 = 0; 
  var count2 = 0; 
  function insertResult(){
      count1+=1;
      var tb = document.getElementById("adresulttable");
     // var tb = table;
      var tr = tb.insertRow();  
      
		var td1 = tr.insertCell();
		var td2 = tr.insertCell();
		var td3 = tr.insertCell();
		
		var textfield1 = document.createElement("input");
		textfield1.setAttribute("id","result_noun["+count1+"]");
		textfield1.setAttribute("name","result_noun["+count1+"]");
		textfield1.setAttribute("size","12");
		
		var textfield2 = document.createElement("input");
		textfield2.setAttribute("id","result_verb["+count1+"]");
		textfield2.setAttribute("name","result_verb["+count1+"]");
		textfield2.setAttribute("size","12");
		
		td1.innerHTML  = "现象名词： ";
		td1.appendChild(textfield1);
		td2.innerHTML  = "现象动词： ";
		td2.appendChild(textfield2);
		
	}

  function insertReason(){
      count2+=1;
      var tb = document.getElementById("adreasontable");
     // var tb = table;
      var tr = tb.insertRow();  
      
		var td1 = tr.insertCell();
		var td2 = tr.insertCell();
		var td3 = tr.insertCell();
		var td4 = tr.insertCell();
		
		var textfield1 = document.createElement("input");
		textfield1.setAttribute("id","result_noun["+count2+"]");
		textfield1.setAttribute("name","reason_noun["+count2+"]");
		textfield1.setAttribute("size","10");
		
		var textfield2 = document.createElement("input");
		textfield2.setAttribute("id","result_verb["+count2+"]");
		textfield2.setAttribute("name","reason_verb["+count2+"]");
		textfield2.setAttribute("size","10");
		
		var textfield3 = document.createElement("input");
		textfield3.setAttribute("id","sugg["+count2+"]");
		textfield3.setAttribute("name","sugg["+count2+"]");
		textfield3.setAttribute("size","40");
		
		//td1.innerHTML  = "原因名词： ";
		td1.appendChild(textfield1);
		//td2.innerHTML  = "原因动词： ";
		td2.appendChild(textfield2);
		//td3.innerHTML  = "规则建议： ";
		td3.appendChild(textfield3);
		
	}
  
	function deleteRecord(table){
		if(table.rows.length>1){
			table.deleteRow(table.rows.length-1);
			count--;
		}

	}
</script>
  </head>
  
  <body>
  <div id="rightmain">
	
	  
   
	   <h2><s:property value="result.nouns+result.verb" /></h2>
	 
<s:form action="useraction!alterUser.action">

	
	
	 <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">

			<th width = "15%">原因名词</th>
			<th width = "15%">原因动词</th>
			<th width = "50%">相关建议</th>			
			<th width = "20%">相关操作</th>	
	  </tr>
    <s:iterator id="reasons" value="reasonlist" status="index1">
     <tr  align="center"  bordercolor="#FFFFFF" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>" style="color: Black; ">
    
       <td><s:textfield value="%{nouns}" theme = "simple" size="10" id="nouns[%{#reasons.id}]"  style="background:transparent;border:0px" />&nbsp;</td>   
       <td><s:textfield name="backwardandReason.verb" value="%{verb}" theme = "simple" size="10" id="verb[%{#reasons.id}]" style="background:transparent;border:0px" />&nbsp;</td>
       <td><s:textfield   name="backwardandReason.sugg" value="%{sugg}" theme = "simple" size="40" id="sugg[%{#reasons.id}]" style="background:transparent;border:0px"  />&nbsp;</td>
          <td>
          <s:a id="a[%{#reasons.id}]"  href="#"  onclick="return confirmChge(%{#reasons.id});">修改</s:a>

						
						&nbsp;
		<s:a href="backwardresonaction!delete?backwardandReason.id=%{#reasons.id}" onclick="return confirmDel();">
																						删除</s:a>
       
	   </td>
     </tr>
     </s:iterator>
  </table>

</s:form>


  <s:form action="useraction!alterUser.action">
 <table bgcolor="#EDEDED" id="adreasontable" id="mytable" class="list_table"  style="margin-left:60" width="100%">
  <tr bgcolor="#4A708B">

			<th width = "15%">原因名词</th>
			<th width = "15%">原因动词</th>
			<th width = "50%">相关建议</th>			
			<th width = "20%">相关操作</th>	
	  </tr>
  
  <tr>
    <td width="15%" >
      <input name="reason_noun[0]" type="text" size="10" />
    </td>
    <td width="15%">
      <input name="reason_verb[0]" type="text" size="10" />
    </td>
    <td width="50%">
      <input name="sugg[0]" type="text" size="40" />
    </td>
    <td width="20%">
      <input name="addone" type="button" value=" + " onClick="insertReason()" />
      <input name="dele" type="button" value=" - "  onclick="deleteRecord(adreasontable)" />
   </td>
  </tr>
  
</table>
<table  width="100%">
 <tr>
      <td  height="33" >
         <div align="center">
        <input name="Input22" type="submit" value="增加" />
        <input name="Input22" type="reset" value="取消" /></div>
   </td>
    </tr>
  </table>

</s:form>
  


	
	
	





</div>

   
  </body>
</html>
