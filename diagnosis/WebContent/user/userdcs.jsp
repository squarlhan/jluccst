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
  response.sendRedirect("user/userlogin.jsp"); 
   }  
                
   %>  
  
   
    <base href="<%=basePath%>">
    
    <title>手工数据录入</title>
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
  
	  <h2>wwdcs数据录入界面</h2>
	   

<s:form action="adminaction.action">

   <p>&nbsp;</p>
  <table width=810 border="2"  cellspacing="0" class="list_table" style="color: Gray; ">
    
    <tr  bgcolor="#CCCCCC">
      <td width="6%">2号生化池PH</td>
      <td width="7%">462A进水提升泵房COD</td>
      <td width="7%">462A进水提升泵房SS</td>
      <td width="7%">2号生化池5段溶解氧DO</td>
      <td width="7%">5号生化池2段溶解氧DO</td>
      
    </tr>
    <tr>
      <td><input name="textfield" type="text" value=""    style=" border:#FFFFFF; text-align:center "/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
	 <td><input name="textfield" type="text" value=""   style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"  /></td>
     
    </tr>
    <tr  bgcolor="#CCCCCC">
      <td>6号生化池2段溶解氧DO</td>
      <td>7号生化池2段溶解氧DO</td>
      <td>8号生化池2段溶解氧DO</td>
      <td>487水解酸化流量</td>
      <td>P495A-1流量</td>
      
    </tr>
    <tr  >
       <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
	 <td><input name="textfield" type="text" value=""   style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"  /></td>
      
    </tr>
    <tr  bgcolor="#CCCCCC">
      <td>P495A-2流量</td>
      <td>P495A-3流量</td>
      <td>P495A-4流量</td>
      <td>P495A-5流量</td>
      <td>P495A-6流量</td>
    </tr>
    <tr>
       <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
	 <td><input name="textfield" type="text" value=""   style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"  /></td>
   
    </tr>
    <tr  bgcolor="#CCCCCC">
      <td>巴氏计量槽流量</td>
      <td>14b主线流量</td>
      <td>P466-1~4泵出口干管流量</td>
      <td>P466-1~4泵出口干管流量</td>
      <td>清水泵出口干管流量</td>
   
    </tr>
    <tr>
        <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
	 <td><input name="textfield" type="text" value=""   style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"  /></td>
     
    </tr>
    <tr  bgcolor="#CCCCCC">
      <td>出口干管流量</td>
      <td>465-1#泵出口管回流污泥量</td>
      <td>465-2#泵出口管回流污泥量</td>
      <td>泵室液位</td>
      <td>巴氏计量槽液位</td>
    
    </tr>
    <tr>
        <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
	 <td><input name="textfield" type="text" value=""   style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"  /></td>
     
    </tr>
    <tr  bgcolor="#CCCCCC">
      <td>V466污泥池后液位</td>
      <td>466地沟液位</td>
      <td>V495A-5液位</td>
      <td>药剂池V495-3液位</td>
      <td>药剂池V495-4液位</td>
     
    </tr>
    <tr >
      <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
	 <td><input name="textfield" type="text" value=""   style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"  /></td>
      
    </tr>
    <tr  bgcolor="#CCCCCC">
      <td>污泥脱水间地沟液位</td>
      <td>428加压泵房生活水池水位</td>
      <td>428加压泵房工业水池水位</td>
      <td>428加压泵房地面污水池液位</td>
      <td>3#潜水排污泵</td>
     
    </tr>
    <tr >
       <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
	 <td><input name="textfield" type="text" value=""   style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"  /></td>
    
    </tr>
    <tr  bgcolor="#CCCCCC">
      <td>C488-1-2出口干管温度</td>
      <td>5#鼓风机内瓦温度</td>
      <td>5#鼓风机外瓦温度</td>
      <td>5#鼓风机单机出口温度</td>
      <td>5#鼓风机内瓦温度</td>
     
    </tr>
    <tr  >
        <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
	 <td><input name="textfield" type="text" value=""   style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"  /></td>
     
    </tr>
    <tr  bgcolor="#CCCCCC">
      <td>5#鼓风机外瓦温度</td>
      <td>5#鼓风机单机出口温度</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    
    </tr>
    <tr>
       <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center"/></td>
     <td><input name="textfield" type="text" value=""  style="border:#FFFFFF; text-align:center" /></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      
    </tr>
    
  </table>
 <table width=800   cellspacing="0"  style="color: Gray; ">
  <tr>
      <td colspan="6"><div align="center">
        <input type="reset" name="Submit" value="确定" />
        <input type="reset" name="Submit2" value="取消" />
      </div></td>
    </tr>
    </table>
</s:form></div>
</div>
   
  </body>
</html>
