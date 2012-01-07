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
    
    <title>生化池系列4</title>
    
    
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
	  <h2> 生化池系列4</h2>
<div id="login">
<s:form action="dcsdataaction!listsave.action" theme="simple">
<table width="1080"><tr><td>
<table width="600" align="center" style="margin-left:30">
<tr>
    	
	<td align="right"><s:textfield  readonly="true" value="7号鼓风机风量"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[27].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>m&sup3/h</td>
	<td align="left">请选择班次</td>
	<td align="left"> <select name="dcsdatalist[0].value"   style="width:110px">
                <option  value="00">夜班</option>
                <option  value="08">白班</option>
                <option  value="16">中班</option>
              </select></td><td></td>
	</tr>
	<tr>
	
	<td align="right">
	<s:textfield  readonly="true" value="7号生化池PH"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[1].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>pH</td>
	<td align="right">
	<s:textfield  readonly="true" value="8号生化池PH"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[2].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>pH</td>
	</tr>
	
	<tr>
	<td align="right">
	<s:textfield  readonly="true" value="7号生化池COD"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[3].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/l</td>
	<td align="right">
	<s:textfield  readonly="true" value="8号生化池COD"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[4].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/l</td>
	</tr>
	
	<tr>
	<td align="right">
	
	<s:textfield  readonly="true" value="7号生化池碱度"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[5].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mmol/l</td>
	<td align="right">
	
	<s:textfield  readonly="true" value="8号生化池碱度"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[6].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mmol/l</td>
	</tr>
	
	<tr>
	<td align="right">
	
	<s:textfield  readonly="true" value="7号生化池BOD5"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[7].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	<td align="right">
	<s:textfield  readonly="true" value="8号生化池BOD5"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[8].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	</tr>
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="7号生化池SS"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[9].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>smu</td>
	<td align="right"><s:textfield  readonly="true" value="8号生化池SS"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[10].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>smu</td>
	</tr>
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="7号生化池NH3-N"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[11].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/l</td>
	<td align="right"><s:textfield  readonly="true" value="8号生化池NH3-N"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[12].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/l</td>
	</tr>

	<tr>
	<td align="right"><s:textfield  readonly="true" value="7号生化池硝态氮"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[13].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	<td align="right"><s:textfield  readonly="true" value="8号生化池硝态氮"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[14].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	</tr>
	
	

<tr>
	<td align="right"><s:textfield  readonly="true" value="7号生化池2段溶解氧"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[15].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	<td align="right"><s:textfield  readonly="true" value="8号生化池2段溶解氧"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[16].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	</tr>
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="7号生化池4段溶解氧"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[17].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	<td align="right"><s:textfield  readonly="true" value="8号生化池4段溶解氧"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[18].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	</tr>
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="7号生化池6段溶解氧"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[19].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	<td align="right"><s:textfield  readonly="true" value="8号生化池6段溶解氧"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[20].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	</tr>
	<tr>
	<td align="right"><s:textfield  readonly="true" value="7号生化池A段溶解氧"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[21].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	<td align="right"><s:textfield  readonly="true" value="8号生化池A段溶解氧"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[22].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	</tr>
	

	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[1].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[2].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[3].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[4].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[5].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[6].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[7].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[8].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[9].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[10].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[11].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[12].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[13].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[14].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[15].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[16].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[17].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[18].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[19].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[20].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[21].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[22].equipment" theme="simple" />
    <s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[23].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[24].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[25].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(8号生化池)" name="dcsdatalist[26].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[27].equipment" theme="simple" />
	<s:hidden   value="生化池系列4(7号生化池)" name="dcsdatalist[0].equipment" theme="simple" />
	<s:hidden   value="班次" name="dcsdatalist[0].item" theme="simple" />
	<s:hidden   value="PH" name="dcsdatalist[1].item" theme="simple" />
	<s:hidden   value="PH" name="dcsdatalist[2].item" theme="simple" />
	<s:hidden   value="COD" name="dcsdatalist[3].item" theme="simple" />
	<s:hidden   value="COD" name="dcsdatalist[4].item" theme="simple" />
	<s:hidden   value="碱度" name="dcsdatalist[5].item" theme="simple" />
	<s:hidden   value="碱度" name="dcsdatalist[6].item" theme="simple" />
	<s:hidden   value="BOD5" name="dcsdatalist[7].item" theme="simple" />
	<s:hidden   value="BOD5" name="dcsdatalist[8].item" theme="simple" />
	<s:hidden   value="SS" name="dcsdatalist[9].item" theme="simple" />
	<s:hidden   value="SS" name="dcsdatalist[10].item" theme="simple" />
	<s:hidden   value="NH3-N" name="dcsdatalist[11].item" theme="simple" />
	<s:hidden   value="NH3-N" name="dcsdatalist[12].item" theme="simple" />
	<s:hidden   value="硝态氮" name="dcsdatalist[13].item" theme="simple" />
	<s:hidden   value="硝态氮" name="dcsdatalist[14].item" theme="simple" />
	<s:hidden   value="2段溶解氧" name="dcsdatalist[15].item" theme="simple" />
	<s:hidden   value="2段溶解氧" name="dcsdatalist[16].item" theme="simple" />
	<s:hidden   value="4段溶解氧" name="dcsdatalist[17].item" theme="simple" />
	<s:hidden   value="4段溶解氧" name="dcsdatalist[18].item" theme="simple" />
	<s:hidden   value="6段溶解氧" name="dcsdatalist[19].item" theme="simple" />
	<s:hidden   value="6段溶解氧" name="dcsdatalist[20].item" theme="simple" />
	<s:hidden   value="A段溶解氧" name="dcsdatalist[21].item" theme="simple" />
	<s:hidden   value="A段溶解氧" name="dcsdatalist[22].item" theme="simple" />
	<s:hidden   value="NO-N" name="dcsdatalist[23].item" theme="simple" />
	<s:hidden   value="NO-N" name="dcsdatalist[24].item" theme="simple" />
    <s:hidden   value="水量" name="dcsdatalist[25].item" theme="simple" />
	<s:hidden   value="水量" name="dcsdatalist[26].item" theme="simple" />
	<s:hidden   value="鼓风机风量" name="dcsdatalist[27].item" theme="simple" />
	<tr>
	<td align="right"><s:textfield  readonly="true" value="7号生化池NO-N"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[23].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	<td align="right"><s:textfield  readonly="true" value="8号生化池NO-N"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[24].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
	</tr>
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="7号生化池水量"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[25].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>m&sup3/h</td>
	<td align="right"><s:textfield  readonly="true" value="8号生化池水量"  theme="simple" style="width:150px;background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[26].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>m&sup3/h</td>
	</tr>
	
	
    <tr/>
	<tr align="center">
	<td width="25%"/>
	<td width="20%" align="center"><s:submit value="推理" theme="simple" onclick="return confirmAdd();" /></td>
	<td width="5%"/>
	
	<td width="25%" align="center"> <s:reset value="重置" theme="simple" /></td>
	<td width="20%"/>
	<td width="5%"/>
	</tr></table>
	</td></tr></table>
</s:form></div>
</div>
   
  </body>
</html>