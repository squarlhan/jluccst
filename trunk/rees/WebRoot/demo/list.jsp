<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/page-tags.tld"%> 
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
	<link href="<%=basePath%>/style.css"" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=basePath%>/tipswindow.css" type="text/css"></link>
  	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/tipswindown.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jmessagebox-1.0.1.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jquery.messager.js"></script>
  	<script type="text/javascript">
  	$(document).ready( function() {
  		$("#btn_add").click(function(){
  			tipsWindown("添加设备","iframe:openAddDemoAction.action","460","250","true","","true","no");
  			return false;
  		});
  		$.fn.CheckBoxAll("cbk_all");
  		$.fn.UnCheckBoxAll("ids","cbk_all");
  	});
  	
  	/**
  	 * 点击选复选框时，执行全选/取消全选功能
  	 * @param chkallid
  	 * 执行全选功能的checkbox的id值
  	 */
  	$.fn.CheckBoxAll = function (chkallid) {
  		$("#" + chkallid).click(function () {
  			var b = ($(this).attr("checked"));
  			$(":checkbox").each(function () {
  				if( !$(this).attr("disabled") ){
  					$(this).attr("checked", b);
  				}
  			});
  		});
  		if($(":checkbox").length == 1){
  			$("#" + chkallid).attr("disabled","true");
  		}
  	};

  	/**
  	 * 子复选框有一个处理非选中状态时，执行全选功能的复选框将置为非选中状态
  	 * @param subchkname
  	 * 子复选框的name
  	 * @param chkallid
  	 * 执行全选功能的复选框id
  	 */
  	$.fn.UnCheckBoxAll = function (subchkname, chkallid) {
  		$(":checkbox[name='" + subchkname + "']").click(function () {
  			var l = $(":checkbox[name='" + subchkname + "']").length;
  			if (!$(this).attr("checked")) {
  				$("#" + chkallid).attr("checked", false);
  			} else {
  				var i = 0;
  				$(":checkbox[name='" + subchkname + "']").each(function () {
  					if ($(this).attr("checked")) {
  						i++;
  					}
  				});
  				if (l == i) {
  					$("#" + chkallid).attr("checked", true);
  				}
  			}
  		});
  	};
  	</script>
  	</head>
  
  <body>
  	<s:form>
   	<table border="1">
   		<tr>
   			<td colspan="5">
   				<s:textfield name="param"></s:textfield>
   				<input type="button" id="btn_add" value="添加" />
   				<s:submit value="修改" theme="simple"></s:submit>
   				<s:submit value="删除所选" theme="simple" action="deleteDemoAction"></s:submit>
   			</td>
   		</tr>
		<tr>
   			<td align="center" >  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
   			<td>
   				序号
   			</td>
   			<td>
   				名称
   			</td>
   			<td>
   				年龄
   			</td>
 		</tr>
   		<s:iterator value="demoModelList" status="obj">
		<tr>
  			<td align="center" >  
				<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
			</td>
  				<td>
   				 <s:property value="#obj.index+1"/>
   			</td>
   			<td>
   				<s:property value="name"/>&nbsp;
   			</td>
   			<td>
   				<s:property value="age"/>&nbsp;
   			</td>
		</tr>
   		</s:iterator>
   		<tr>
			<td colspan="5">
			<page:pages pageNo="pageNo" total="total" styleClass="page" theme="text">
				<s:param name="param" value="param"></s:param>
			</page:pages> 
		   	</td>
		</tr>
   	</table>
   	</s:form>
  </body>
</html>
