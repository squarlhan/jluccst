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
	<script type="text/javascript">

		$(function(){
		
			$("#addbtn").click(function(){
				parent.parent.parent.tipsWindown("添加话题","iframe:openAddForumIssueInfoAction.action","460","250","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
			});			
            $("#gotobtn").click(function(){
				parent.parent.parent.tipsWindown("进入聊天室","iframe:openAddForumMessageInfoAction.action","460","250","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
			});
			$.fn.CheckBoxAll("cbk_all");
	  		$.fn.UnCheckBoxAll("ids","cbk_all");

	  		/**
	  		 * 修改话题信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.parent.tipsWindown("修改话题","iframe:"+url,"460","350","true","","true","no");
	  				window.location.href=window.location.href;
	  				parent.parent.$("#windown-close").bind('click',function(){
						window.location.href=window.location.href;
					});
	  			});
	  		});
	  		
	  		/**
	  		 * 删除话题信息
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				if(window.confirm("您确定要删除这条信息吗？")){
	  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
	  				}
	  				parent.parent.$("#windown-close").bind('click',function(){
						window.location.href=window.location.href;
					});
	  			});
	  		});
	  		
	  		/**
	  		 * 删除话题信息
	  		 */
	  		$("#deletepointbtn").click(function(){
  				var url = "deleteForumIssueInfoAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
  				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
	  		});
	  		
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
 <s:form id="form1"> 
  
<table width="100%" border="0" cellspacing="5" cellpadding="0">
    <tr><td><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
             <tr>
              <td align="center" background="images/headerbg.jpg"><strong>话题名称</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>参与人数</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>发起人</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>发起时间</strong></td>
              <td align="center" background="images/headerbg.jpg"><strong>状态</strong></td>
            </tr>
            <s:iterator value="pagination.data" status="obj">
            <tr>
              <td height="26" bgcolor="#FFFFFF"><a href="openAddForumMessageInfoAction.action?issueId=<s:property value="id"/>" id="gotobbs">
                       <s:property value="issueName"/>&nbsp;</a>
              </td>
               <td height="26" align="center" bgcolor="#FFFFFF">
               <s:property value="joinPersonCount"/>
               </td>
               <td height="26" align="center" bgcolor="#FFFFFF">
          	     <s:property value="creator"/>&nbsp;      
               </td>
               <td height="26" align="center" bgcolor="#FFFFFF">
          	     <s:property value="createTimeStr"/>&nbsp;      
               </td>
               <td height="26" align="center" bgcolor="#FFFFFF">
               <s:if test="issueStatus==1">进行中</s:if><s:if test="issueStatus==0">已结束</s:if>&nbsp;
                </td>
             </tr>
              </s:iterator>
            <tr>
			<td colspan="8" align="center"  background="images/headerbg.jpg">
			<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		   	</td>
		  </tr>
   </table></td></tr>
</table>
</s:form>  
</body>
</html>
  
  
  
  
  
  
  
  
  
  
  
  
 