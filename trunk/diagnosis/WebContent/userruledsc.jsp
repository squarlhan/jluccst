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
      <td height="54" colspan="2"><h2>规则录入界面</h2>
       
       <!--  
       <tr>
      <td  height="35" style="width: 200px; "><div align="left" >规则名称：
        <input name="rule.name" type="text" size="12" />
      </div></td>
      <td height="35" style="width: 600px; "><div align="left"></div>规则备注：
      <input name="rule.memo" type="text" size="72"  /></td>
  
    </tr>
  -->
    <tr>
      <td colspan="2"><table id="adresulttable"  bgcolor="#EDEDED" width="100%" height="100%" border="0" cellspacing="0" >
        <tr>
          <td width="25%" >控制结点：
             
             <select name="resultn1" size="1" style="width:150px">
              <option>电石厂有机水 </option>
              <option>有机合成厂有机水 </option>
               <option>炼油厂有机水 </option>
               <option>精细化工厂废水 </option>
               <option>乙二醇废水 </option>
               <option>环氧乙烷废水 </option>
               <option>农药厂有机水 </option>
               <option>含氮废水 </option>
              <option>103厂碱水 </option>
              <option>化肥厂丁辛醇 </option>
             <option>丙烯腈废水 </option>
             <option>合成树脂厂有机水</option> 
             <option>龙潭区生活水 </option>
             
             <option> 染料厂酸水  </option>
             <option>电石厂酸水 </option>
            <option>铁运489沉淀池出水 </option>
          
            <option>14a </option>
            <option>14b</option> 
          
        
	         <option>稳流池(477)进水 </option>
             <option> 进水提升泵房(462A)</option> 
             <option>巴氏计量槽（499） </option>
            <option> 除色池(414) </option>
            <option>沉沙刮沙池(488) </option>
            <option>事故池(489) </option>
             <option>初沉池(489B) </option>
             <option>14B生活水 </option>
            <option>老水解酸化池 </option>
           <option>新水解酸化池 </option>
	         <option>污泥泵房(466) </option>
	         <option>浓缩池(491) </option>
            <option>脱水装置(495) </option>


         <option>中间提升泵房(462B)</option>
       <option>  生化池系列1 (1号生化池) </option>
       <option>  生化池系列1 (2号生化池) </option>
       <option>生化池系列2 (3号生化池)</option>
       <option>生化池系列2 (4号生化池)</option>
       <option>  生化池系列3 (5号生化池) </option>
       <option>  生化池系列3 (6号生化池) </option>
       <option>生化池系列4 (7号生化池)</option>
      <option>生化池系列4 (8号生化池)</option>
       <option>1系列二沉池 </option>
         <option>2系列二沉池 </option>
        <option>3系列二沉池 </option>
        <option>4系列二沉池 </option>
        <option>接触氧化池 </option>
        <option>3系列排江出口线 </option>
        <option>1、2、4系列排江出口线</option>
        <option>1、2系列465回流泵房 </option>
        <option>3系列465A回流泵房 </option>
        <option>3系列465B回流泵房 </option>



	         </select>
               </td>
          
           <td width="25%" >控制参数：
             
             <select name="resultn2" size="1" style="width:150px">
             <option> 溶解氧</option>
	       <option> PH</option>
	       <option> NH3-N</option>
	       <option> COD</option>
	       <option> SS</option>
	       <option> 碱度</option>
	       <option> BOD5</option>
	       <option> 硝态氮</option>
	       <option> 风量</option>
	       <option> NO-N</option>
	       <option> 水量</option>
	      </select>
              
             
          </td>
          <td width="25%" >参数状态：
           <select name="resultv_value" style="width:150px">
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
    <td width="43%">规则建议：
      <input name="sugg[0]" type="text" size="45" />
    </td>
    <td width="7%"><div align="left">
      <input name="addone" type="button" value=" + " onClick="insertReason()" />
      <input name="dele" type="button" value=" - "  onclick="deleteRecord(adreasontable)" />
    </div></td>
  </tr>
</table></td>
    </tr>
    <tr>
      <td  height="33" colspan="2"><div align="center">
        <input name="Input22" type="submit" value="录入" />
        <input name="Input22" type="submit" value="取消" />
      </div></td>
    </tr>
  </table>
</s:form>
 
  </body>
</html>
