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
    <title>报表查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"/>
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#beginTime").click(function(){WdatePicker({el:'beginTime',dateFmt:'yyyy年MM月dd日'});});
		$("#endTime").click(function(){WdatePicker({el:'endTime',dateFmt:'yyyy年MM月dd日'});});
		
		$("#selectWay").change(function(){
			var i = eval($("#selectWay").val());
			switch(i){
				case 1:
					$("#beginTime").unbind("click");
					$("#endTime").unbind("click");
					$("#beginTime").val("");
					$("#endTime").val("");
					$("#beginTime").click(function(){WdatePicker({skin:'whyGreen',dateFmt:'yyyy年'});});
					$("#endTime").click(function(){WdatePicker({skin:'whyGreen',dateFmt:'yyyy年'});});
					break;
				case 2:
					$("#beginTime").unbind("click");
					$("#endTime").unbind("click");
					$("#beginTime").val("");
					$("#endTime").val("");
					$("#beginTime").click(function(){WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月'});});
					$("#endTime").click(function(){WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月'});});
					break;
				case 3:
					$("#beginTime").unbind("click");
					$("#endTime").unbind("click");
					$("#beginTime").val("");
					$("#endTime").val("");
					$("#beginTime").click(function(){WdatePicker({el:'beginTime',dateFmt:'yyyy年MM月dd日'});});
					$("#endTime").click(function(){WdatePicker({el:'endTime',dateFmt:'yyyy年MM月dd日'});});
					break;
				default:break;
			}
		});
		
		$("#selectBtn").click(function(){
			$("#form1").submit();
		});
		
		/**
  		 * 下载
  		 */
  		$('a[name="export"]').each(function(){
  			$(this).click(function(){
  				var url = $(this).attr("url");
  				var oldAction = form1.action;
  				form1.action = url;
  				form1.submit();
  				form1.action = oldAction;
  			});
  		});
	});
	
	function download(obj){
		var url = obj.attr("url");
		var oldAction = form1.action;
		form1.action = url;
		form1.submit();
		form1.action = oldAction;
	}
	</script>
  </head>
  
  <body>
   <s:form action="openReportSearchAction" id="form1" method="post">
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
			查询方式：
	        <s:select id="selectWay" list="selectWayList" listKey="key" listValue="value" name="selectWay"></s:select>
			开始日期: 
			<s:textfield id="beginTime" name="beginTime" cssClass="Wdate"/>
			结束日期: 
			<s:textfield id="endTime" name="endTime" cssClass="Wdate"/>
			<input name="selectBtn" id="selectBtn" type="button" class="btn_2_3" value="查询">
        </td>
        <td align="right"></td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
          <td width="16%" align="center" background="<%=path %>/images/headerbg.jpg" ><strong>汇报类别</strong></td>
          <td width="16%" align="center" background="<%=path %>/images/headerbg.jpg"><strong>汇报题目</strong></td>
		  <td width="16%" align="center" background="<%=path %>/images/headerbg.jpg"><strong>汇报人</strong></td>
		  <td width="16%" align="center" background="<%=path %>/images/headerbg.jpg"><strong>汇报时间</strong></td>
		  <td width="10%" align="center" background="<%=path %>/images/headerbg.jpg"><strong>操作</strong></td>
	    </tr>
	    <s:iterator value="pagination.data" status="obj">
        <tr>
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
		  <td height="26" colspan="2" align="left" bgcolor="#FFFFFF" nowrap>
          	<s:url id="export_url" action="toExportReportAction">   
				<s:param name="report.id" value="id"></s:param>   
				<s:param name="report.templateId" value="templateId"></s:param>   
			</s:url>
			<s:url id="download_url" action="toDownloadReportAttachmentAction">   
				<s:param name="report.filePath" value="filePath"></s:param>   
				<s:param name="report.id" value="id"></s:param>   
			</s:url>
         	<a name="export" href="javascript:void(0);" url="${export_url}">导出</a>  
         	<s:if test='filePath!=null  &&filePath!=""'>
         		<a name="download" href="javascript:void(0);" url="${download_url}"  onclick="download($(this));return false;">附件</a>  
         	</s:if>
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