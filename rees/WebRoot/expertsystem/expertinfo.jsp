<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" jquery="true" validate="true" />
	<script type="text/javascript">
  	$(document).ready( function() {
  		$("#btn_save").click(function(){
  		
  			parent.location.href = $.fn.change_url(parent.location.href);
  		});
  		$("#btn_close").click(function(){
  			parent.$("#windown-close").click();
  		});
  	});
  	

  	</script>
  </head>
  
  <body>
    <s:form name="editForm" action="toAddRuleAdviceInfoAction.action" theme="simple">
    	<table border="1">
    		<tr>
    			<td colspan="2" style="color:red">
	    			<s:property value="initString"/>
    			</td>
    		</tr>
    		<tr>请选择设备类型
    			<td>
    			
    			</td>
    			<td height="26" align="left" bgcolor="#FFFFFF">
				<s:select id="sel_deviceType" list="deviceTypeList" listKey="id" listValue="typeName" headerKey="nothing" headerValue="---请选择---" name="ruleAdviceInfo.deviceTypeId" cssStyle="width: 250px;"></s:select>
				</td>
    		</tr>
    		
    		<tr> 
    			<td>
    			年龄：
    			</td>
    			<td>
    			<s:textfield id="txt_age" name="demoModel.age"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<s:submit id="btn_save" value="保存"></s:submit>
    				<input type="button" id="btn_close" value="关闭"/>
    			</td>
    		</tr>
    	</table>
	</s:form>
  </body>
</html>
