<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/page-tags"%> 
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author yangGY
 * @version 1.0
 * @audit  
 */
/**
 * Modified Person：
 * Modified Time：
 * Modified Explain：
 */
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>时间管理列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink css="true" tipswindow="false" jmessagebox="true" jquery="true" validate="true" jfunction="true"/>
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.css" />
	<link rel="stylesheet" media="all" type="text/css" href="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.css" />
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/timepicke/jquery-ui-sliderAccess.js"></script>
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
			$("#mainInfoId").val(parent.$("#mainInfoId").val());
			$('#txt_query_beginTime').datetimepicker({showTimepicker: false});
			$('#txt_query_endTime').datetimepicker({showTimepicker: false});
			
			$("#addbtn").click(function(){
				var mainInfoId = $("#mainInfoId").val();
				parent.tipsWindown("添加计划明细","iframe:openAddMonthlyItemAction.action?monthlyItemInfo.mainInfoId="+mainInfoId,"780","450","true","","true","no");
				parent.$("#windown-close").bind('click',function(){
					window.location.href="./openMonthlyItemListAction.action?mainInfoId="+mainInfoId;
				});
		
			});
			$.fn.checkall("cbk_all");
	  		$.fn.uncheckall("ids","cbk_all");

	  		/**
	  		 * 修改
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				var mainInfoId = $("#mainInfoId").val();
	  				parent.tipsWindown("修改计划明细","iframe:"+url,"780","450","true","","true","no");
	  				parent.$("#windown-close").bind('click',function(){
						window.location.href="./openMonthlyItemListAction.action?mainInfoId="+mainInfoId;
					});
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				if(window.confirm("您确定要删除这条信息吗？")){
	  					$.post(url, "", function(data){window.location.href=window.location.href;});
	  				}
	  			});
	  		});
	  		
	  		/**
	  		 * 删除所选
	  		 */
	  		$("#deletepointbtn").click(function(){
	  			var flag=true;
  				$("input[name='ids']").each(function(){
  					if($(this).attr('checked')){
  						flag=false;
  						return false;
  					}
  				});
  				if(flag){
  					alert('请选择所要删除记录！');
  					return false;
  				}
  				var url = "deleteMonthlyItemAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
	  		});
		});
	</script>

  </head>
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple" >
 <s:hidden id="mainInfoId" name = "mainInfoId" ></s:hidden>
<table width="100%"  border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top">
    <input name="addbtn" type="button" class="btn_2_3" id="addbtn" value="添加" >
            <input name="deletepointbtn" type="button" class="btn_4" id="deletepointbtn" value="删除所选">
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
         	<td align="center" background="<%=path %>/images/headerbg.jpg">  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>职责</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>结果定义</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>实际结果</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>执行基金</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
        <td height="26" align="center" bgcolor="#FFFFFF" >  
        	<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
		</td>
              <td height="26" align="left" bgcolor="#FFFFFF">
				<s:if test="sellTarget==null || sellTarget==''">
              		<s:property value="sellDutyName"/>
              	</s:if>
              	<s:else>
              		<s:property value="sellDutyName"/>：<s:property value="sellTarget"/> 元
              	</s:else>
			</td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="monthResult"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="superiorResult"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"  nowrap="nowrap"><s:property value="executeMoney"/></td>
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF"  nowrap="nowrap">
          	<s:url id="edit_url" action="openModifyMonthlyItemAction">   
				<s:param name="monthlyItemInfo.id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteMonthlyItemAction">   
				<s:param name="ids" value="id"></s:param>   
			</s:url>
         	<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>  
         	<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>
          </td>
        </tr>
        </s:iterator>        
        <tr>
          <td height="26" colspan="7" align="center" bgcolor="#FFFFFF">
			<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		  </td>
        </tr>
      </table>
      </td>
  </tr>
</table>
</s:form>
</body>
</html>
