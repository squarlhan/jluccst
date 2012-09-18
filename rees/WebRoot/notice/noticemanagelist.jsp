<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/page-tags.tld"%> 
<%@ taglib prefix="j" uri="/script-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'bbslist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"/>
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<style type="text/css">
	<!--
	.STYLE2 {color: #FF0000}
	.STYLE3 {color: #00FF00}
	-->
	</style>
	<script type="text/javascript">

		$(function(){
			/**
	  		 * 查看通知信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				//parent.parent.parent.tipsWindown("查看通知","iframe:"+url,"460","350","true","","true","no");
	  				//window.location.href=window.location.href;
	  				//parent.parent.$("#windown-close").bind('click',function(){
						parent.location.href=url;
					//});
	  			});
	  		});	
	  		
		});
		</script>

  </head>
  <body>
 <s:form id="form1"> 
<table width="100%" border="0" cellspacing="5" cellpadding="0">
    <tr><td><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
             <tr>
              <td align="center" background="images/headerbg.jpg"><strong>通知标题</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>发布时间</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>发布人姓名</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>发布人所在单位</strong></td>
            </tr>
            <s:iterator value="paginationNotice.data" status="obj">
            <tr>
              <td height="26" bgcolor="#FFFFFF">
               <s:url id="edit_url" action="openAddForumMessageInfoAction.action">   
				<s:param name="issueId" value="forumIssueId"></s:param>   
				<s:param name="noticeId" value="id"></s:param>  
			  </s:url>
         	  <a name="edit" href="javascript:void(0);" url="${edit_url}"><s:property value="noticeTitle"/></a>  
              </td>
               <td height="26" align="center" bgcolor="#FFFFFF">
               <s:property value="noticePublishtime"/>
               </td>
               <td height="26" align="center" bgcolor="#FFFFFF">
          	     <s:property value="publisher"/>&nbsp;      
               </td>
               <td height="26" align="center" bgcolor="#FFFFFF">
          	     <s:property value="publisherDept"/>&nbsp;      
               </td>
             </tr>
              </s:iterator>
            <tr>
			<td colspan="8" align="center"  background="images/headerbg.jpg">
			<page:pages currentPage="paginationNotice.currentPage" totalPages="paginationNotice.totalPages" totalRows="paginationNotice.totalRows" styleClass="page" theme="text" ></page:pages> 
		   	</td>
		  </tr>
   </table></td></tr>
</table>
</s:form>  
</body>
</html>
  
  
  
  
  
  
  
  
  
  
  
  
 