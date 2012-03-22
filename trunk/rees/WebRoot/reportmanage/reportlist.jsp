<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/WEB-INF/page-tags.tld"%>

<%
	/**
	 * All right reserved.
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
    <base href="<%=basePath%>">
    <title>个人报表列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"/>

	<script type="text/javascript">

	$(function(){
		/**
		 * 添加报表
		 */
		$("#addbtn").click(function(){
			parent.parent.parent.tipsWindown("添加汇报","iframe:openAddReportAction.action","600","425","true","","true","no");
		});
		
		/**
		 * 修改报表
		 */
		$('a[name="edit"]').each(function(){
			$(this).click(function(){
				var url = $(this).attr("url");
				parent.parent.parent.tipsWindown("修改报表信息","iframe:"+url,"460","350","true","","true","no");
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
				$.post(url, $('#repform').serialize(), function(data){window.location.href=window.location.href;});
			}
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
<s:form action="openReportAction" id="replist">
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
		    <input name="button" type="button" class="btn_4" id="addbtn" value="添加" >
            <input name="button3" type="button" class="btn_4" id="button2" value="删除所选">
            <input name="button4" type="button" class="btn_4" id="output" value="导出Word">
          </td>
        <td align="right"></td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
          <td width="8%" height="26" align="center" background="../images/headerbg.jpg">
          	<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>&nbsp;
          </td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>汇报类别</strong></td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>汇报题目</strong></td>
		  <td width="16%" align="center" background="../images/headerbg.jpg"><strong>汇报人</strong></td>
		  <td width="16%" align="center" background="../images/headerbg.jpg"><strong>汇报时间</strong></td>
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
		  <td height="26" align="center" bgcolor="#FFFFFF">
		  	<s:date  name="reportDate" format="yyyy-MM-dd HH:mm" />&nbsp;
		  	</td>
		  
		  <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
          	<s:url id="edit_url" action="openModifyReportAction">   
				<s:param name="report.id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteReportAction">   
				<s:param name="ids" value="id"></s:param>   
			</s:url>
			
         	<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>  
         	<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>  
          </td>
	    </tr>
		</s:iterator>
        <tr>
        	<td height="26" colspan="9" align="center" bgcolor="#FFFFFF">
				<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" >
				</page:pages>
			</td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
