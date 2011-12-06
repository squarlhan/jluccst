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
  response.sendRedirect("/diagnosis/userlogin.jsp"); 
   }  
                
   %>  
    
    <title> 进水提升泵房</title>                                 <!-- 标题名称 -->
    
                                                               <!-- 录入时候弹出的“确定录入”对话框 -->
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
	  <h2> 进水提升泵房</h2>                                                           <!-- 标题 -->
<div id="login">
<s:form action="dcsdataaction!listsave.action">
<table width="300" align="center" style="margin-left:30">
<tr>
    
	<td align="left">请选择班次</td>
	<td align="center"> <select name="dcsdatalist[0].value"   style="width:110px">   <!-- 班次，班次的值存入dcsdata的value里面 -->
                <option  value="00">零点班</option>
                <option  value="08">八点班</option>
                <option  value="16">十六点班</option>
              </select></td>
	</tr>
	<tr >
	
	<td align="right">                                                               <!-- 向dcsdata录入的每个设备的各项参数，dcsdata中equipment在此设为隐藏的文本；
	                                                                               item为各项控制参数-->
	<s:textfield size="5" readonly="true" value="1#潜水排污泵" name="dcsdatalist[1].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[1].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>PH</td>
	
	</tr>
	
	<tr>
	<td align="right">
	<s:textfield  readonly="true" value="2#潜水排污泵" name="dcsdatalist[2].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[2].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>PH</td>
	
	</tr>
	
	<tr>
	<td align="right">
	
	<s:textfield  readonly="true" value="3#潜水排污泵" name="dcsdatalist[3].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[3].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>PH</td>
	
	</tr>
	
	<tr>
	<td align="right">
	
	<s:textfield  readonly="true" value="4#潜水排污泵" name="dcsdatalist[4].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[4].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>mg/L</td>
		</tr>
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="5#潜水排污泵" name="dcsdatalist[5].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield  name="dcsdatalist[5].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>smu</td>
	</tr>
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="1#粗格栅前后液位差" name="dcsdatalist[6].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[6].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>PH</td>
		</tr>

	<tr>
	<td align="right"><s:textfield  readonly="true" value="2#粗格栅前后液位差" name="dcsdatalist[7].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[7].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>m3/h</td>
		</tr>
		<tr>
	<td align="right"><s:textfield  readonly="true" value="3#粗格栅前后液位差" name="dcsdatalist[8].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[8].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>m3/h</td>
		</tr>
	
	
	
	<tr>
	<td align="right"><s:textfield  readonly="true" value="PH" name="dcsdatalist[9].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[9].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>PH</td>
		</tr>
		
		<tr>
	<td align="right"><s:textfield  readonly="true" value="COD" name="dcsdatalist[10].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[10].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>PH</td>
		</tr>
		<tr>
	<td align="right"><s:textfield  readonly="true" value="SS" name="dcsdatalist[11].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[11].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>smu</td>
		</tr>
	<tr>
	<td align="right"><s:textfield  readonly="true" value="NH3-N" name="dcsdatalist[12].item" theme="simple" style="background:transparent;border:0px"/></td>
	<td align="center"><s:textfield name="dcsdatalist[12].value" theme="simple"
	onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td><td>PH</td>
		</tr>
	
    <tr/>
	<tr align="center">
	<s:hidden   value="进水提升泵房" name="dcsdatalist[1].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[2].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[3].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[4].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[5].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[6].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[7].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[0].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[8].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[9].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[10].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[11].equipment" theme="simple" />
	<s:hidden   value="进水提升泵房" name="dcsdatalist[12].equipment" theme="simple" />
	<s:hidden   value="班次" name="dcsdatalist[0].item" theme="simple" />
	

	<td width="20%" align="center"><s:submit value="推理" theme="simple" onclick="return confirmAdd();" /></td>    <!-- 界面上的按钮 按下“推理”时候弹出界面询问是否确定录入 -->
	
	
	<td width="25%" align="center"> <s:reset value="重置" theme="simple" /></td>
	
	
	</tr></table>
</s:form></div>
</div>
   
  </body>
</html>
