<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/WEB-INF/page-tags.tld"%>
<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
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
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>故障日志</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true"
			jquery="true" validate="true" />
	 	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		$(document).ready( function() {
		
		/**
		 * 添加
		 */
		$("#addbtn").click(function(){
			parent.parent.tipsWindown("添加","iframe:openAddErrorLogAction.action","450","400","true","","true","no");
			parent.parent.$("#windown-close").bind('click',function(){
				window.location.href=window.location.href;
			});
		});
		/**
		 * 解除警报
		 */
		$('a[name="remove"]').each(function(){
			$(this).click(function(){
				var url = $(this).attr("url");
				if(window.confirm("您确定要解除警报？")){
					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
				}
			});
		});
		/**
  		 * 查看信息
  		 */
  		$('a[name="edit"]').each(function(){
  			$(this).click(function(){
  				var url = $(this).attr("url");
  				parent.parent.parent.tipsWindown("查看报警信息","iframe:"+url,"460","350","true","","true","no");
  				//window.location.href=window.location.href;
  				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
  			});
  		});
  	});
		</script>

  </head>
<body> 
<s:form id="form1" name="form1" >
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top">
    <!-- table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
		    <input name="addbtn" type="button" class="btn_4" id="addbtn" value="添加" >
        </td>
        <td align="right"></td>
      </tr>
    </table> -->
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备编号</strong></td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备名称</strong></td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>所属单位</strong></td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>报警时间</strong></td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>是否解除</strong></td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>解除时间</strong></td>
	      <td width="16%" align="center" background="../images/headerbg.jpg"><strong>操作</strong></td>
	    </tr>
	    <s:iterator value="pagination.data" status="obj">
        <tr>
          <td height="26" align="center" bgcolor="#FFFFFF">
          	<s:property value="deviceNum"/>&nbsp;
          </td>
          <td height="26" align="center" bgcolor="#FFFFFF">
          	<s:property value="deviceName"/>&nbsp;
          </td>
          <td height="26" align="center" bgcolor="#FFFFFF">
          	<s:property value="deptName"/>&nbsp;
          </td>
          <td height="26" align="center" bgcolor="#FFFFFF">     	
          	<s:date  name="errorTime" format="yyyy-MM-dd" />&nbsp;
          </td>
          <td height="26" align="center" bgcolor="#FFFFFF">
            <s:if test="isRemove==1"><span class="STYLE3">已解除</span></s:if><s:if test="isRemove==0"><span class="STYLE2">未解除</span></s:if>&nbsp;
          </td>
          <td height="26" align="center" bgcolor="#FFFFFF">
          	<s:date  name="removeTime" format="yyyy-MM-dd" />&nbsp;
          </td>
		  <td height="26" nowrap colspan="2" align="center" bgcolor="#FFFFFF">
		  	 <s:url id="edit_url" action="openAddErrorLogAction">   
				<s:param name="errorLog.id" value="id"></s:param>   
			      </s:url>
         	  <a name="edit" href="javascript:void(0);" url="${edit_url}">查看警报</a>
			<s:url id="remove_url" action="toSetIsRemoveAction">   
				<s:param name="errorLog.id" value="id"></s:param>   
			</s:url>
         	<a name="remove" href="javascript:void(0);" url="${remove_url}">解除警报</a>  
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
      </table>
      </td>
  </tr>
</table>
</s:form>
</body>
</html>
