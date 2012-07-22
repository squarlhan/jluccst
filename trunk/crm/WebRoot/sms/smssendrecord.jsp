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
 * @author zhuyf
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>短信记录</title>
	<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
	<script type="text/javascript">
	  	$(function(){
			
		});
	</script>
  </head>
  
  
  <body>
  <s:form>
	<fieldset >
		<legend>查询</legend>
		<span>
			<s:textfield id="txt_hello" maxlength="50" cssStyle="width: 200px;" value="您好！"/>
			<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="查询">
		</span>
	</fieldset>
    <table width="100%" height="50%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
		<thead>
			<td align="center" width="50px" background="<%=basePath%>/images/headerbg.jpg">
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>接收人</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>手机号</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>公司</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>职务</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>昵称</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>发送类型</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>发送时间</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>短信内容</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>操作</strong></td>
		</thead>
		<s:iterator value="pagination.data" status="obj">
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
			</td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap"><s:property value="customerInfo.name"/></td>
   			<td align="left" bgcolor="#FFFFFF" ><s:property value="phone"/></td>
   			<td align="left" bgcolor="#FFFFFF" ><s:property value="customerInfo.unit"/></td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap"><s:property value="customerInfo.post"/></td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap"><s:property value="customerInfo.nickname"/></td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap"><s:property value="isImmediately"/></td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap"><s:date  name="sendTime" format="yyyy-MM-dd hh:mm" /></td>
   			<td align="left" bgcolor="#FFFFFF" ><s:property value="info"/></td>
   			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap">
          	<s:url id="reSend_url" action="openModifyCompanyAction">   
				<s:param name="company.id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteCompanyAction">   
				<s:param name="ids" value="id"></s:param>   
			</s:url>
         	<a name="send" href="javascript:void(0);" url="${send_url}">发送</a>  
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
	 </s:form>
  </body>
</html>
