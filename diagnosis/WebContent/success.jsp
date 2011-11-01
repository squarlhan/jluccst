<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>结果页面</title>
    <sx:head />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script  language="javascript">

  var count = 0; 
  function insertResult(){
      count+=1;
      var tb = document.getElementById("adresulttable");
     // var tb = table;
      var tr = tb.insertRow();  
      
		var td1 = tr.insertCell();
		var td2 = tr.insertCell();
		var td3 = tr.insertCell();
		
		var textfield1 = document.createElement("input");
		textfield1.setAttribute("id","result_noun["+count+"]");
		textfield1.setAttribute("name","result_noun["+count+"]");
		textfield1.setAttribute("size","12");
		
		var textfield2 = document.createElement("input");
		textfield2.setAttribute("id","result_verb["+count+"]");
		textfield2.setAttribute("name","result_verb["+count+"]");
		textfield2.setAttribute("size","12");
		
		td1.innerHTML  = "现象名词: ";
		td1.appendChild(textfield1);
		td2.innerHTML  = "现象动词: ";
		td2.appendChild(textfield2);
		td3.innerHTML = "-";
        count = 0;
	}

  function insertReason(){
      count+=1;
      var tb = document.getElementById("adreasontable");
     // var tb = table;
      var tr = tb.insertRow();  
      
		var td1 = tr.insertCell();
		var td2 = tr.insertCell();
		var td3 = tr.insertCell();
		var td4 = tr.insertCell();
		
		var textfield1 = document.createElement("input");
		textfield1.setAttribute("id","result_noun["+count+"]");
		textfield1.setAttribute("name","reason_noun["+count+"]");
		textfield1.setAttribute("size","12");
		
		var textfield2 = document.createElement("input");
		textfield2.setAttribute("id","result_verb["+count+"]");
		textfield2.setAttribute("name","reason_verb["+count+"]");
		textfield2.setAttribute("size","12");
		
		var textfield3 = document.createElement("input");
		textfield3.setAttribute("id","sugg["+count+"]");
		textfield3.setAttribute("name","sugg["+count+"]");
		textfield3.setAttribute("size","12");
		
		td1.innerHTML  = "原因名词: ";
		td1.appendChild(textfield1);
		td2.innerHTML  = "原因动词: ";
		td2.appendChild(textfield2);
		td3.innerHTML  = "规则建议: ";
		td3.appendChild(textfield3);
		td4.innerHTML = "-";
		count = 0;
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
    <div style="color: green;">success</div><br>
  
  <table id="mytable" class="list_table" align="center" width="100%">
		<tr bgcolor="#4A708B">
		    <th><p align="center">规则录入界面</p></th>
			
	  </tr>
    <s:iterator id="users" value="userlist" status="index1">
       
     <tr  align="center" bgcolor="<s:if test="#index1.odd == true">#ffffff</s:if><s:else>#EDEDED</s:else>">
       <td><s:property value="username"/></td>
       <td><s:property value="password"/></td>
     </tr>
     </s:iterator>
  </table>
 
 
 <s:form action="useraction!addRule.action">
<div id="addrule">
<table  align="center" width="100%" id="adruletable" class="list_table">
	<tr>
	<td align="center" width="543">规则名称: 
	  <input size="12" name="rule.name" /></td>
	<td align="center" width="554">规则备注: 
	  <input size="12" name="rule.memo" /></td>
	</tr>
</table>
</div>
<div id="addresult">
<table  align="center" width="100%" id="adresulttable" class="list_table">
	<tr>
	<td align="center" width="200">现象名词: <input size="12" name="result_noun[0]" /></td>
	<td align="center" width="200">现象动词: <input size="12" name="result_verb[0]" /></td>
	<td align="center" width="200">
	   <input type="button" name="addone" value="+ " onClick="insertResult()" />
       <input type="button" name="dele" value="- " onClick="deleteRecord(adresulttable)"/>
    </td>
	</tr>
	</table>
	</div>
<div id="addreason">
	<table  align="center" width="100%" id="adreasontable" class="list_table">
	<tr>
	<td align="center" width="200">原因名词: <input size="12"  name="reason_noun[0]" /></td>
	<td align="center" width="200">原因动词: <input size="12"  name="reason_verb[0]" /></td>
	<td align="center" width="200">规则建议: <input size="12"  name="sugg[0]" /></td>
	<td align="center" width="200">
	   <input type="button" name="addone" value="+ " onClick="insertReason()"/>
       <input type="button" name="dele" value="- "   onclick="deleteRecord(adreasontable)"/>
    </td>
	</tr>
	</table>
</div>
<div>
	<table  align="center" style="margin-left:0" class="list_table">
	<tr>
	<td align="left" width="200">-</td>
	<td  width="200"align="center"><s:submit value="新建 " theme="simple" /></td>	
	<td  width="200" align="center"> <s:reset value="取消 "  theme="simple" /></td>	
	<td align="left" width="200">-</td>
	</tr>
	</table>
	</div>
</s:form>
  
  <div style="float:left; margin-right: 50px;">
            <sx:tree label="parent" id="parentId"  templateCssPath="/struts/tree.CSS"
                showRootGrid="true" showGrid="true" treeSelectedTopic="treeSelected">
                <s:iterator value="backlist">
                    <sx:treenode  label="%{name}">
                        <s:iterator value="results">
                            <sx:treenode  label="%{nouns} %{verb}">
                                 <s:iterator value="reasons">
                                     <sx:treenode  label="%{nouns} %{verb} : %{sugg} " >
                                     </sx:treenode>
                                 </s:iterator>
                            </sx:treenode>
                         </s:iterator>
                     </sx:treenode>
                </s:iterator>
            </sx:tree>
        </div>

 
  </body>
</html>
