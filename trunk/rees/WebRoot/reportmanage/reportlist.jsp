<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/WEB-INF/page-tags.tld"%>

<%
	/**
	 * All right reserved.
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 */
	/**
	 * @author zhaomengxue
	 * @version 1.0
	 * @audit  
	 */
	/**
	 * Modified Person：
	 * Modified Time：
	 * Modified Explain：
	 */
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>个人报表列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"  jfunction="true"/>

	<script type="text/javascript">

	$(function(){
		/**
		 * 添加报表
		 */
		$("#addbtn").click(function(){
			parent.parent.tipsWindown("添加汇报","iframe:openAddReportAction.action","450","400","true","","true","no");
			parent.parent.$("#windown-close").bind('click',function(){
				window.location.href=window.location.href;
			});
		});
		
		/**
		 * 修改报表
		 */
		$('a[name="edit"]').each(function(){
			$(this).click(function(){
				var url = $(this).attr("url");
				parent.parent.tipsWindown("修改报表信息","iframe:"+url,"450","400","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
			});
		});
		
		/**
		 * 删除单个报表
		 */
		$('a[name="delete"]').each(function(){
			$(this).click(function(){
				var url = $(this).attr("url");
				if(window.confirm("您确定要删除这条信息吗？")){
					$.post(url, $('#repform').serialize(), function(data){window.location.href=window.location.href;});
				}
			});
		});
		
		/**
		 * 删除所选报表
		 */
		$("#deletepointbtn").click(function(){
			var url = "deleteReportAction.action";
			if(window.confirm("您确定要删除所选信息吗？")){
				$.post(url, $('#replist').serialize(), function(data){window.location.href=window.location.href;});
			}
		});

		$.fn.checkall("cbk_all");
		$.fn.uncheckall("ids","cbk_all");
		
		
		/**
		 * 删除单个报表
		 */
		$('a[name="download"]').each(function(){
			$(this).click(function(){
				var url = $(this).attr("url");
				var oldAction = replist.action;
				replist.action = url;
				replist.submit();
				replist.action = oldAction;
			});
		});
		
		$('a[name="export"]').each(function(){
			$(this).click(function(){
				var url = $(this).attr("url");
				var oldAction = replist.action;
				replist.action = url;
				replist.submit();
				replist.action = oldAction;
			});
		});
  	});
	
</script>
</head>
<body>
<s:form action="openReportAction" id="replist">
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
		    <input name="addbtn" type="button" class="btn_4" id="addbtn" value="添加" >
            <input name="deletepointbtn" type="button" class="btn_4" id="deletepointbtn" value="删除所选">

          </td>
        <td align="right"></td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
          <td width="8%" height="26" align="center" background="../images/headerbg.jpg">
          	<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
          </td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>汇报类别</strong></td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>汇报题目</strong></td>
		  <td width="16%" align="center" background="../images/headerbg.jpg"><strong>汇报人</strong></td>
		  <td width="16%" align="center" background="../images/headerbg.jpg"><strong>汇报时间</strong></td>
		   <td width="16%" align="center" background="../images/headerbg.jpg"><strong>操作</strong></td>
	    </tr>
	    <s:iterator value="pagination.data" status="obj">
        <tr>
          <td height="26" align="center" bgcolor="#FFFFFF">
            <s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
          </td>
          <td height="26" align="center" bgcolor="#FFFFFF">
          	<s:property value="reportType"/>&nbsp;
          	</td>
          <td height="26" align="center" bgcolor="#FFFFFF">
          	<s:property value="reportSubject"/>&nbsp;
          	</td>
          <td height="26" align="center" bgcolor="#FFFFFF">
			<s:property value="reportPerson"/>&nbsp;
			</td>
		  <td height="26" align="center" bgcolor="#FFFFFF"><!-- format="yyyy-MM-dd HH:mm" -->
		  	<s:date  name="reportDate" format="yyyy-MM-dd" />&nbsp;
		  	</td>
		  
		  <td height="26" colspan="2" align="left" bgcolor="#FFFFFF">
          	<s:url id="edit_url" action="openModifyReportAction">   
				<s:param name="report.id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteReportAction">   
				<s:param name="ids" value="id"></s:param>   
			</s:url>
			<s:url id="download_url" action="toDownloadReportAttachmentAction">   
				<s:param name="report.filePath" value="filePath"></s:param>   
				<s:param name="report.id" value="id"></s:param>   
			</s:url>
			<s:url id="export_url" action="toExportReportAction">   
				<s:param name="report.id" value="id"></s:param>   
			</s:url>
         	<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>  
         	<a name="export" href="javascript:void(0);" url="${export_url}">导出</a>  
         	<s:if test='filePath!=null  &&filePath!=""'>
         		<a name="download" href="javascript:void(0);" url="${download_url}">附件</a>  
         	</s:if>
         	<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>  
          </td>
	    </tr>
		</s:iterator>
        <tr>
        	<td height="26" colspan="9" align="center" bgcolor="#FFFFFF">
				<page:pages currentPage="pagination.currentPage"
					totalPages="pagination.totalPages"
					totalRows="pagination.totalRows" styleClass="page"
					theme="text">
				</page:pages>
			</td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
