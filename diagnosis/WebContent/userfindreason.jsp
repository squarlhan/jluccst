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
    
    <title>净水厂设备诊断专家系统</title>
   
   
   
    <script language="JavaScript" type="text/javascript"> 
<!-- 
  
/* 
 * 说明：将指定下拉列表的选项值清空 
 * 作者：CodeBit.cn ( http://www.CodeBit.cn ) 
 * 
 * @param {String || Object]} selectObj 目标下拉选框的名称或对象，必须 
 */
function removeOptions(selectObj) 
{ 
    if (typeof selectObj != 'object') 
    { 
        selectObj = document.getElementById(selectObj); 
    } 
  
    // 原有选项计数 
    var len = selectObj.options.length; 
  
    for (var i=0; i < len; i++) 
    { 
        // 移除当前选项 
        selectObj.options[0] = null; 
    } 
} 
  
/* 
 * 说明：设置传入的选项值到指定的下拉列表中 
 * 作者：CodeBit.cn ( http://www.CodeBit.cn ) 
 * 
 * @param {String || Object]} selectObj 目标下拉选框的名称或对象，必须 
 * @param {Array} optionList 选项值设置 格式：[{txt:'北京', val:'010'}, {txt:'上海', val:'020'}] ，必须 
 * @param {String} firstOption 第一个选项值，如：“请选择”，可选，值为空 
 * @param {String} selected 默认选中值，可选 
 */
function setSelectOption(selectObj, optionList, firstOption, selected) 
{ 
    if (typeof selectObj != 'object') 
    { 
        selectObj = document.getElementById(selectObj); 
    } 
  
    // 清空选项 
    removeOptions(selectObj); 
  
    // 选项计数 
    var start = 0; 
  
    // 如果需要添加第一个选项 
    if (firstOption) 
    { 
        selectObj.options[0] = new Option(firstOption, ''); 
  
        // 选项计数从 1 开始 
        start ++; 
    } 
  
    var len = optionList.length; 
  
    for (var i=0; i < len; i++) 
    { 
        // 设置 option 
        selectObj.options[start] = new Option(optionList[i].txt, optionList[i].val); 
  
        // 选中项 
        if(selected == optionList[i].val) 
        { 
            selectObj.options[start].selected = true; 
        } 
  
        // 计数加 1 
        start ++; 
    } 
  
} 
  
//--> 
</script>

   <script language="JavaScript" type="text/javascript">   
  
  <s:iterator id="nverb" value="nb">
  cityArr['<s:property value="nouns"/>'] = [      <s:iterator id="verbs" value="nb">     
                  {txt:'<s:property value="verb"/>', val:'<s:property value="verb"/>'}        
                     </s:iterator> ];   
    </s:iterator>
function setCity(nouns) {    
                         setSelectOption('verb', cityArr[nouns], '-请选择-'); }  
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
   
      <table width="80%" height="77" border="0" cellspacing="0">
      <tr>
        <td><div style="color: green;"> 
          <strong>
            <s:property value="#session.us.username"/>
            :</strong> 您好
          </div>
       
        </div>
     
      </tr>
    </table>
    <p class="STYLE1"><br>
    </p>
    </div><br>
	  <div id="login">
<s:form action="ruleaction">
<select name="nouns" id="nouns" onchange="if(this.value != '') setCity(this.options[this.selectedIndex].value);">   
   <s:iterator id="nverb" value="nb">
     <option value="<s:property value="nouns"/>"><s:property value="nouns"/></option>     
    </s:iterator>
 </select> 省 
 <select name="verb" id="verb">
      <s:iterator id="nverb" value="nb">
     <option value="<s:property value="verb"/>"><s:property value="verb"/></option>     
    </s:iterator>
</select>
<!--  <table width="300" align="center" style="margin-left:30">
	<tr>
	<td >
	故障设备名称：
	 
	    <select name="result.nouns" size="1" style="width:150px">
	     <s:iterator id="backs" value="backwardandResultlist1" status="index1">
	      <option><s:property /></option>
	      </s:iterator>
	      </select>
	    </td>
	</tr>
	<tr>
	<td >故障设备现象：
	  <select name="result.verb" size="1" style="width:150px">
	       <s:iterator id="backs" value="backwardandResultlist2" status="index1">
	      <option><s:property /></option>
	      </s:iterator>
	    </select>
	  </td>
	</tr>
	</table>-->
	<br/>
	<table width="300" align="center" style="margin-left:10">
	<tr>
	<td width="80" ><s:submit value="开始推理" /></td>
	</tr></table>
</s:form></div>
</div>
   
  </body>
</html>
