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
    <title>市场调查列表</title>
    
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
				parent.parent.tipsWindown("添加市场调查","iframe:openAddMarketInquiryAction.action?goodsId="+$("#goodsId").val(),"650","300","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="./openMarketInquiryListAction.action?goodsId="+$("#goodsId").val();
				});
		
			});
			$.fn.checkall("cbk_all");
	  		$.fn.uncheckall("ids","cbk_all");

	  		/**
	  		 * 修改市场调查
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("查看市场调查","iframe:"+url,"650","300","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
						window.location.href="./openMarketInquiryListForViewAction.action?goodsId="+$("#goodsId").val();
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
	  					$.post(url, "", function(data){window.location.href=window.location.href;});
	  				}
	  			});
	  		});
	  		
	  		/**
	  		 * 删除所选设备信息
	  		 */
	  		$("#deletepointbtn").click(function(){
  				var url = "deleteMarketInquiryAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
	  		});
		});
	</script>

  </head>
  
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple" action="openMarketInquiryListForViewAction.action">
 <s:hidden name="goodsId" id="goodsId"></s:hidden>
 
<table width="100%"  border="0" cellspacing="5" cellpadding="0">
<tr>
<td>
<fieldset >
		<legend>查询条件</legend>
   		<span>
   		<table width="100%" border="0" cellspacing="5" cellpadding="0">
       <tr>
       <td colspan="2">
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
	      <tr>
				<td height="26" width = "90px" align="left" bgcolor="#FFFFFF" nowrap="nowrap">
					<strong>商品名称：</strong>
				</td>
				<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF">
					<s:textfield id="txt_query_goods_name" name="goodsName" cssStyle="width:100px"></s:textfield>
				</td>
				<td height="26" width = "80px" align="left" bgcolor="#FFFFFF" nowrap="nowrap">
					<strong>调查人：</strong>
				</td>
				<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF">
					<s:textfield id="txt_query_inquiryPersonName" name="inquiryPersonName" cssStyle="width:100px"></s:textfield>
				</td>
				<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
					<strong>规 格：</strong>
				</td>
				<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF">
					<s:textfield id="sel_query_goodsStandard"  name="goodsStandard"  cssStyle="width: 100px;" />
				</td>
				<td height="26" width = "90px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
					<strong>调查日期：</strong>
				</td>
				<td height="26" width = "270px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
					<s:textfield id="txt_query_beginTime" name="beginTime" cssStyle="width:100px"></s:textfield> -
					<s:textfield id="txt_query_endTime" name="endTime" cssStyle="width:100px"></s:textfield>
				</td>
				<td height="26"  align="left" bgcolor="#FFFFFF">
					<input name="queryBtn" type="submit" class="btn_2_3" id="queryBtn" value="查询">
				</td>
			</tr>
		</table>
		</td>
	</tr>
    </table>
   		</span>
 </fieldset>
</td>

</tr>
  <tr>
    <td valign="top">
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>商品名称</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>规 格</strong></td>
              
               <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>价 格</strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>调查地点</strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>调查人</strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>调查日期</strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>备 注</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="goodsName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="goodsStandard"/></td>
                <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="goodsPrice"/></td>
                <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="inquiryAddress"/></td>
                <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="inquiryPersonName"/></td>
                <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="goodsWeight"/></td>
                <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="inquiryTime"/></td>
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
          	<s:url id="edit_url" action="openModifyMarketInquiryForViewAction">   
				<s:param name="marketInquiry.id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteMarketInquiryAction">   
				<s:param name="ids" value="id"></s:param>   
			</s:url>
         	<a name="edit" href="javascript:void(0);" url="${edit_url}">查看</a>  
          </td>
        </tr>
        </s:iterator>        
        <tr>
          <td height="26" colspan="9" align="center" bgcolor="#FFFFFF">
			<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		   
		  </td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
