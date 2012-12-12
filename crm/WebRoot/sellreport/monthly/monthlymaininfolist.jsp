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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true"/>
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
			$('#txt_query_beginTime').datetimepicker({showTimepicker: false});
			$('#txt_query_endTime').datetimepicker({showTimepicker: false});
			
			$("#addbtn").click(function(){
				parent.parent.tipsWindown("添加月计划","iframe:openTabPageAction.action","850","520","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					//window.location.href="./openMonthlyMainInfoListAction.action?companyId="+$("#hid_companyId").val()+"&deptId="+$("#hid_deptId").val()+"&personId="+$("#hid_personId").val();
					$("#form1").attr("openMonthlyMainInfoListAction.action");
					$("#form1").submit();
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
	  				parent.parent.tipsWindown("修改月计划","iframe:"+url,"850","520","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
	  					//window.location.href="./openMonthlyMainInfoListAction.action?companyId="+$("#hid_companyId").val()+"&deptId="+$("#hid_deptId").val()+"&personId="+$("#hid_personId").val();
	  					$("#form1").attr("openMonthlyMainInfoListAction.action");
						$("#form1").submit();
					});
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个设备信息
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				if(window.confirm("您确定要删除这条信息吗？")){
	  					$.post(url, "", function(data){
	  						window.location.href="./openMonthlyMainInfoListAction.action?companyId="+$("#hid_companyId").val()+"&deptId="+$("#hid_deptId").val()+"&personId="+$("#hid_personId").val();
	  					});
	  				}
	  			});
	  		});
	  		
	  		/**
	  		 * 删除所选设备信息
	  		 */
	  		$("#deletepointbtn").click(function(){
  				var url = "deleteTimePlanAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){
  						window.location.href="./openMonthlyMainInfoListAction.action?companyId="+$("#hid_companyId").val()+"&deptId="+$("#hid_deptId").val()+"&personId="+$("#hid_personId").val();
  					});
  				}
	  		});
		});
	</script>

  </head>
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple" >
<s:hidden id="hid_companyId" name="companyId"></s:hidden>
 <s:hidden id="hid_deptId" name="deptId"></s:hidden>
<s:hidden id="hid_personId" name="personId"></s:hidden>
<table width="100%"  border="0" cellspacing="5" cellpadding="0">
	<!-- 
	<tr>
		<td colspan="2">
		<fieldset >
		<legend>查询条件</legend>
   		<span>
      		<table   border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
		      <tr>
					<td height="26" width = "80px" align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>计划人：</strong>
					</td>
					<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_query_employee_name" name="employeeName" cssStyle="width:120px"></s:textfield>
					</td>
					<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>所在部门：</strong>
					</td>
					<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF">
						<s:select id="sel_dept"  name="monthlyMainInfo.deptId" list="deptList" listKey="id"  listValue="deptName" cssStyle="width: 160px;"  headerKey="" headerValue="---全部---"></s:select>
					</td>
					<td height="26"  align="left" bgcolor="#FFFFFF">
						<input name="queryBtn" type="submit" class="btn_2_3" id="queryBtn" value="查询">
					</td>
				</tr>
			</table>
			</span>
		</fieldset>
		</td>
	</tr>
	 -->
  <tr>
    <td valign="top">
    <input name="addbtn" type="button" class="btn_2_3" id="addbtn" value="添加" >
            <input name="deletepointbtn" type="button" class="btn_4" id="deletepointbtn" value="删除所选">
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
         	<td align="center" background="<%=path %>/images/headerbg.jpg">  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>计划人</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>计划时间</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>所在部门</strong></td>
               <td width="40%" align="center" background="<%=path %>/images/headerbg.jpg" ><strong>职务  </strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>直接上级</strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>检查人</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
        <td height="26" align="center" bgcolor="#FFFFFF" >  
        	<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
		</td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="personName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"  nowrap="nowrap"><s:property value="planInterzone"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="deptName"/></td>
                <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="position"/></td>
                <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="superior"/></td>
                <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="checker"/></td>
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF"  nowrap="nowrap">
          	<s:url id="edit_url" action="openTabPageAction">   
				<s:param name="monthlyMainInfo.id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteMonthlyMainInfoAction">   
				<s:param name="ids" value="id"></s:param>   
			</s:url>
         	<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>  
         	<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>
          </td>
        </tr>
        </s:iterator>        
        <tr>
          <td height="26" colspan="10" align="center" bgcolor="#FFFFFF">
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
