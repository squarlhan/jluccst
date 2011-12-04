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
    
    <title>规则描述界面</title>
    <sx:head />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
 
 
 
 <s:form action="ruleaction!newAdd.action">
<table    width="100%"  rules="rows" border="1" bordercolor="#000000" cellpadding="0" cellspacing="0">
    <tr >
      <td height="54" colspan="2"><h2>规则描述界面</h2>
     <tr/>
    <tr/>
    <tr>
      <td colspan="2"><table bgcolor="#EDEDED" id="adreasontable"  width="100%" height="100%" border="0" cellspacing="0">
  <tr>
    <td width="30%" height="40%">故障节点：
      <select name="name" size="1" style="width:150px"> 
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
       <option>  1系列生化池 (1号生化池) </option>
       <option>  1系列生化池 (2号生化池) </option>
       <option>2系列生化池 (3号生化池)</option>
       <option>2系列生化池 (4号生化池)</option>
       <option>  3系列生化池 (5号生化池) </option>
       <option>  3系列生化池 (6号生化池) </option>
       <option>4系列生化池 (7号生化池)</option>
      <option>4系列生化池 (8号生化池)</option>
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
          </select> </td>
    <td width="30%" >控制参数：
             
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
    <td width="40%">对应名称：
      <select name="name" size="1" style="width:150px"> 
        <s:iterator id="backwardandResults" value="backwardandResultlist" status="index1">
       <option><s:property value="nouns"/> </option>
       
       </s:iterator> </select></td>
  </tr>
  <tr>
    <td height="40%" bgcolor=#CCCCCC> &nbsp;最大值：
      <input name="sugg[0]" type="text" size="12" />  </td>
    <td width="25%" bgcolor="#CCCCCC"> &nbsp;最小值：
      <input name="sugg[0]" type="text" size="12" />  </td>
    <td width="43%" bgcolor="#CCCCCC">&nbsp;</td>
  </tr>

</table></td>
    </tr>
    <tr>
      <td  height="33" colspan="2"><div align="center">
        <input name="Input22" type="submit" value="录入" />&nbsp;
        <input name="Input22" type="submit" value="取消" />&nbsp;
		 <input name="Input22" type="button" value="查看" onClick="window.location.href('dcsdscribaction!findall.action')"/>
      </div></td>
    </tr>
  </table>
</s:form>
 
  </body>
</html>
