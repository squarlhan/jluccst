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
    
     <%if(request.getSession().getAttribute("us")==null) 
  { 
  response.sendRedirect("/diagnosis/user/userlogin.jsp"); 
   }  
                
   %>  
    
    <title>电石厂酸水</title>
    
    
     <script type="text/javascript">
    	function confirmAdd(){
			return confirm("确定录入？");
			
			    
			
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
	  <h2>电石厂酸水</h2>
<div id="login">
<s:form action="dcsdataaction!listsave.action" theme = "simple">
<table width="1080"><tr><td>
<table width="300" align="center" style="margin-left:30">
<tr>
    
	<td align="left">请选择班次</td>
	<td align="center"> <select name="dcsdatalist[0].value"   style="width:110px">
              <option  value="00">白班</option>
                <option  value="08">夜班</option>
                <option  value="16">中班</option>
              </select></td>
	</tr>
	<tr >
	
	<td align="right">
	<s:textfield size="5" readonly="true" value="PH" name="dcsdatalist[1].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[1].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>pH</td>
	
	</tr>
	
	<tr>
	<td align="right">
	<s:textfield  readonly="true" value="COD" name="dcsdatalist[2].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[2].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/l</td>
	
	</tr>
	
	<tr>
	<td align="right">
	
	<s:textfield  readonly="true" value="酸度" name="dcsdatalist[3].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[3].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mmol/l</td>
	
	</tr>
	
	<tr>
	<td align="right">
	
	<s:textfield  readonly="true" value="BOD5" name="dcsdatalist[4].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[4].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
		</tr>
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="SS" name="dcsdatalist[5].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[5].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>smu</td>
	</tr>
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="NH3-N" name="dcsdatalist[6].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[6].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/l</td>
		</tr>


	


	<s:hidden   value="电石厂酸水" name="dcsdatalist[1].equipment" theme="simple" />
	<s:hidden   value="电石厂酸水" name="dcsdatalist[2].equipment" theme="simple" />
	<s:hidden   value="电石厂酸水" name="dcsdatalist[3].equipment" theme="simple" />
	<s:hidden   value="电石厂酸水" name="dcsdatalist[4].equipment" theme="simple" />
	<s:hidden   value="电石厂酸水" name="dcsdatalist[5].equipment" theme="simple" />
	<s:hidden   value="电石厂酸水" name="dcsdatalist[6].equipment" theme="simple" />
	<s:hidden   value="电石厂酸水" name="dcsdatalist[7].equipment" theme="simple" />
	<s:hidden   value="电石厂酸水" name="dcsdatalist[0].equipment" theme="simple" />
	<s:hidden   value="班次" name="dcsdatalist[0].item" theme="simple" />
	
	
	
	
	
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="水量" name="dcsdatalist[7].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[7].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>m&sup3/h</td>
		</tr>
	
	
    <tr/>
	<tr align="center">

	<td width="20%" align="center"><s:submit value="推理" theme="simple" onclick="return confirmAdd();" /></td>
	
	
	<td width="25%" align="center"> <s:reset value="重置" theme="simple" /></td>
	
	
	</tr></table>
	</td></tr></table>
</s:form></div>
</div>
   
  </body>
</html>
