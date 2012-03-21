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
    
    <title>My JSP 'devicelist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="../../style.css" />
	<script type="text/javascript" src="../../js/jquery-1.4.2.min.js"></script>
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<script type="text/javascript">
	<!--
		$(function(){
			$("#addbtn").click(function(){
				parent.parent.parent.tipsWindown("添加设备","iframe:device/deviceadd.jsp","460","250","true","","true","no");
			});
			$("#editbtn").click(function(){
				parent.parent.parent.tipsWindown("修改设备","iframe:sysmanage/groupinfo.html","460","250","true","","true","no");
			});
			$("#editpointbtn").click(function(){
				parent.parent.parent.tipsWindown("修改监控点","iframe:sysmanage/groupinfoedit.html","460","190","true","","true","no");
			});
		});
	//-->
	</script>

  </head>
  
  <body>
 
 <s:form> 
  
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  	
  	
  	
  	
  	<tr><td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        	<td><input name="button" type="button" class="btn_4" id="addBtn" value="发起话题">
          		<input name="button3" type="button" class="btn_4" id="button" value="删除话题"></td>
      </tr>
    </table></td></tr>
    
    
    
    <tr><td><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
            
            
            <tr>
              <td height="26" align="center" background="../images/headerbg.jpg">&nbsp;</td>
              <td align="center" background="../images/headerbg.jpg"><strong>话题名称</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>在线人数</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>发起人</strong></td>
              <td align="center" background="../images/headerbg.jpg"><strong>状态</strong></td>
            </tr>
             <s:iterator value="pagination.data" status="obj">
            <tr>
            <td height="26" align="center" bgcolor="#FFFFFF" >  
				<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
			</td>
            <td height="26" bgcolor="#FFFFFF"><a href="javascript:void(0);" id="gotobbs">
              <s:property value="issueName"/>&nbsp;</a>
          </td>
             
 
              <td height="26" align="center" bgcolor="#FFFFFF"><A title="点击这里可查看在线人员名单" href="bbslist_">160/160(<span class="STYLE2">满员</span>)</A></td>
         	  <td height="26" align="center" bgcolor="#FFFFFF">管理员</td>
              <td height="26" align="center" bgcolor="#FFFFFF"><span class="STYLE3">进行中</span></td>
            </tr>
                </s:iterator>
            <s:iterator value="pagination.data" status="obj">
			<tr>
	  			
	   			<td>
	   				<s:property value="issueConteit"/>&nbsp;
	   			</td>
			</tr>
	   		</s:iterator>
            <tr>
			<td colspan="5">
			<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		   	</td>
		</tr>
    
    
    </table></td></tr>
   
     
</table>
  
  
  
  
  
</s:form>  
  </body>
</html>
  
  
  
  
  
  
  
  
  
  
  
  
 