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
  			parent.$("#windown-close").click();
  			parent.location.href = $.fn.change_url(parent.location.href);
  		});
  		$("#btn_close").click(function(){
  			parent.$("#windown-close").click();
  		});
  	});
  	
  	/**
	 * 在原来url上加上随机时间
	 */
  	$.fn.change_url=function(old_url){
  		var url = old_url;
		if(url.split("?").length>1){//原来有参数
			tempArr = url.split("?");
			//?前的地址
			var url =  tempArr[0]; 
			//获取?号以后的参数
			var tail = tempArr[1];
        	var paramGroup = tail.split("&");            
        	for(var i=0, len=paramGroup.length; i<len; i++) {                
            	tempArr = paramGroup[i].split("=");
	            if(tempArr[0]!="time"){
	            	if(url.split("?").length==1)
	          			url = url + "?"+tempArr[0]+"="+ tempArr[1];
	          		else
	          			url = url + "&"+tempArr[0]+"="+ tempArr[1];
	          	}
       		}
       		if(url.split("?").length==1){
        		url = url+"?time="+(new Date()).getTime();
        	}else{
        		url = url+"&time="+(new Date()).getTime();
        	}
       		return url;
		}else{
			return url+"?time="+(new Date()).getTime();
		} 
  	}
  	</script>
  </head>
  
  <body>
    <s:form name="editForm" action="toAddDemoAction.action" theme="simple">
    	<table border="1">
    		<tr>
    			<td colspan="2" style="color:red">
	    			<s:property value="initString"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    			名称：
    			</td>
    			<td>
    			<s:textfield id="txt_name" name="demoModel.name"/>
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
