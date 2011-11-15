<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%if(request.getSession().getAttribute("us")==null) 
  { 
  response.sendRedirect("userlogin.jsp"); 
   }  
                
   %>  
    <base href="<%=basePath%>">
    
    <title>DCS规则录入</title>
    <sx:head />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
		textfield1.setAttribute("size","12");
		
		var textfield2 = document.createElement("input");
		textfield2.setAttribute("id","result_verb["+count2+"]");
		textfield2.setAttribute("name","reason_verb["+count2+"]");
		textfield2.setAttribute("size","12");
		
		var textfield3 = document.createElement("input");
		textfield3.setAttribute("id","sugg["+count2+"]");
		textfield3.setAttribute("name","sugg["+count2+"]");
		textfield3.setAttribute("size","45");
		
		td1.innerHTML  = "原因名词： ";
		td1.appendChild(textfield1);
		td2.innerHTML  = "原因动词： ";
		td2.appendChild(textfield2);
		td3.innerHTML  = "规则建议： ";
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
 
 
 
 <s:form action="ruleaction!newAdd.action">
<table    width="100%"  rules="rows" border="1" bordercolor="#000000" cellpadding="0" cellspacing="0">
    <tr >
      <td height="54" colspan="2"><h2>规则描述界面</h2>
       
       
       <tr>
      <td  height="35" style="width: 200px; "><div align="left" >规则名称：
        <input name="rule.name" type="text" size="12" />
      </div></td>
      <td height="35" style="width: 600px; "><div align="left"></div>规则备注：
      <input name="rule.memo" type="text" size="72"  /></td>
  
    </tr>
  
    <tr>
      <td colspan="2"><table id="adresulttable"  bgcolor="#EDEDED" width="100%" height="100%" border="0" cellspacing="0" >
        <tr>
          <td width="25%" >现象名词：
             
             <select name="resultn" size="1" style="width:200px">
             <option> -请选择-</option>
	       <s:iterator id="names" value="namelist" status="index1">
	      <option> <s:property /> </option>
	      </s:iterator>
	      </select>
              
             
          </td>
          <td width="25%" >现象动词：
           <select name="resultv_value" style="width:200px">
                <option value="0">高于最高值</option>
                <option value="1">低于最低值</option>
              </select>
          
          </td>
        </tr>
      </table></td>
    </tr>
    <tr/>
    <tr/>
    <tr>
      <td colspan="2"><table bgcolor="#CCCCCC" id="adreasontable"  width="100%" height="100%" border="0" cellspacing="0">
  <tr>
    <td width="25%" height="80%">原因名词：
      <input name="reason_noun[0]" type="text" size="12" />
    </td>
    <td width="25%">原因动词：
      <input name="reason_verb[0]" type="text" size="12" />
    </td>
    <td width="45%">规则建议：
      <input name="sugg[0]" type="text" size="45" />
    </td>
    <td width="5%"><div align="center">
      <input name="addone" type="button" value=" + " onClick="insertReason()" />
      <input name="dele" type="button" value="-"  onclick="deleteRecord(adreasontable)" />
    </div></td>
  </tr>
</table></td>
    </tr>
    <tr>
      <td  height="33" colspan="2"><div align="center">
        <input name="Input22" type="submit" value="新建" />
        <input name="Input22" type="submit" value="取消" />
      </div></td>
    </tr>
  </table>
</s:form>
 
  </body>
</html>
