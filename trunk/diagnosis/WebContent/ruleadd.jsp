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
   <%if(request.getSession().getAttribute("ad")==null) 
  { 
  response.sendRedirect("adminlogin.jsp"); 
   }  
                
   %>  
    <base href="<%=basePath%>">
    
    <title>结果页面</title>
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
		textfield3.setAttribute("size","12");
		
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
 
 
 
 <s:form action="ruleaction!addRule.action">
<table    width="100%"  rules="rows" border="1" bordercolor="#000000" cellpadding="0" cellspacing="0">
    <tr >
      <td height="54" colspan="2"><h2>规则录入界面</h2></div></td>
    </tr>
    <tr>
      <td  height="35" style="width: 200px; "><div align="left" >规则名称：
        <input name="rule.name" type="text" size="12" />
      </div></td>
      <td height="35" style="width: 600px; "><div align="left"></div>规则备注：
      <input name="rule.memo" type="text" size="72"  /></td>
  
    </tr>
    <tr>
      <td height="56" colspan="2"><table id="adresulttable"  bgcolor="#EDEDED" width="100%" height="100%" border="0" cellspacing="0" >
        <tr>
          <td width="25%" >现象名词：
              <input name="result_noun[0]" type="text" size="12" />
          </div></td>
          <td width="25%" >现象动词：
            <input name="result_verb[0]" type="text" size="12" />
          </div></td>
          <td width="25%">&nbsp;</td>
          <td width="25%"><div align="center">
            <input name="addone" type="button" value="增加" onClick="insertResult()" />
            <input name="dele" type="button" value="删除" onClick="deleteRecord(adresulttable)"/>
          </div></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="45" colspan="2"><table bgcolor="#CCCCCC" id="adreasontable"  width="100%" height="100%" border="0" cellspacing="0">
  <tr>
    <td width="25%" height="80%">原因名词：
      <input name="reason_noun[0]" type="text" size="12" />
    </div></td>
    <td width="25%">原因动词：
      <input name="reason_verb[0]" type="text" size="12" />
    </div></td>
    <td width="25%">规则建议：
      <input name="sugg[0]" type="text" size="12" />
    </div></td>
    <td width="25%"><div align="center">
      <input name="addone" type="button" value="增加" onClick="insertReason()" />
      <input name="dele" type="button" value="删除"  onclick="deleteRecord(adreasontable)" />
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
