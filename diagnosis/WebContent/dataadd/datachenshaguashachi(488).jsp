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
    
    <title>沉沙刮沙池(488)</title>                                 <!-- 标题名称 -->
    
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
	  <h2>沉沙刮沙池(488)</h2>                                                           <!-- 标题 -->
<div id="login">
<s:form action="dcsdataaction!listsave.action" theme = "simple">
<table width="1080"><tr><td>
<table width="300" align="center" style="margin-left:30">
<tr>
    
	<td align="left">请选择班次</td>
	<td align="center"> <select name="dcsdatalist[0].value"   style="width:110px">   
                 <option  value="00">夜班</option>
                <option  value="08">白班</option>
                <option  value="16">中班</option>
              </select></td>
	</tr>
	<tr >
	
	<td align="right" >                                                               <!-- 向dcsdata录入的每个设备的各项参数，dcsdata中equipment在此设为隐藏的文本；
	                                                                               item为各项控制参数-->
	<s:textfield  readonly="true" value="M488-1号刮沙机状态" name="dcsdatalist[1].item" theme="simple" style="width:120px;background:transparent;border:0px"/></td>
	<td align="center"><select name="dcsdatalist[1].value"   style="width:110px">   
                <option  value="0">运转</option>
                <option  value="1">停止</option>
                      </select>
     </td>
	
	</tr>
	
	<tr>
		<td align="right" >                                                               <!-- 向dcsdata录入的每个设备的各项参数，dcsdata中equipment在此设为隐藏的文本；
	                                                                               item为各项控制参数-->
	<s:textfield  readonly="true" value="M488-2号刮沙机状态" name="dcsdatalist[2].item" theme="simple" style="width:120px;background:transparent;border:0px"/></td>
	<td align="center"><select name="dcsdatalist[2].value"   style="width:110px">   
                <option  value="0">运转</option>
                <option  value="1">停止</option>
                      </select>
     </td>
	
	</tr>
	
	<tr>
		<td align="right" >                                                               <!-- 向dcsdata录入的每个设备的各项参数，dcsdata中equipment在此设为隐藏的文本；
	                                                                               item为各项控制参数-->
	<s:textfield  readonly="true" value="M488-3号刮沙机状态" name="dcsdatalist[3].item" theme="simple" style="width:120px;background:transparent;border:0px"/></td>
	<td align="center"><select name="dcsdatalist[3].value"   style="width:110px">   
                <option  value="0">运转</option>
                <option  value="1">停止</option>
                      </select>
     </td>
	</tr>
	
	<tr>
		<td align="right" >                                                               <!-- 向dcsdata录入的每个设备的各项参数，dcsdata中equipment在此设为隐藏的文本；
	                                                                               item为各项控制参数-->
	<s:textfield  readonly="true" value="M488-4号刮沙机状态" name="dcsdatalist[4].item" theme="simple" style="width:120px;background:transparent;border:0px"/></td>
	<td align="center"><select name="dcsdatalist[4].value"   style="width:110px">   
                <option  value="0">运转</option>
                <option  value="1">停止</option>
                      </select>
     </td>
		</tr>
	

	<s:hidden   value="沉沙刮沙池(488)" name="dcsdatalist[1].equipment" theme="simple" />
	<s:hidden   value="沉沙刮沙池(488)" name="dcsdatalist[2].equipment" theme="simple" />
	<s:hidden   value="沉沙刮沙池(488)" name="dcsdatalist[3].equipment" theme="simple" />
	<s:hidden   value="沉沙刮沙池(488)" name="dcsdatalist[4].equipment" theme="simple" />
	<s:hidden   value="沉沙刮沙池(488)" name="dcsdatalist[0].equipment" theme="simple" />
	<s:hidden   value="班次" name="dcsdatalist[0].item" theme="simple" />
	<tr align="center">

	<td width="20%" align="center"><s:submit value="推理" theme="simple" onclick="return confirmAdd();" /></td>    <!-- 界面上的按钮 按下“推理”时候弹出界面询问是否确定录入 -->
	
	
	<td width="25%" align="center"> <s:reset value="重置" theme="simple" /></td>
	
	
	</tr></table>
	</td></tr></table>
</s:form></div>
</div>
   
  </body>
</html>
