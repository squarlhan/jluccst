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
 * @author Luojx
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
    <title>客户信息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true"/>
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
			$("#btn_add").click(function(){
				try{
					parent.$.fn.showOrHideTab(1,true);
					parent.$.fn.selectTab(1);
				}catch(e){
					alert(e.description);
				}
			});
		});
	</script>
	</head>
  <body>
   <s:form id="form1" name="form1" method="post" theme="simple" action="">
   		<table id="recordsList" width="100%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
			<tr>
				<td colspan="12" align="center" width="50px" bgcolor="#FFFFFF">
					<table>
						<tr>
							<td>
								<input name="btn_add" type="button" class="btn_2_3" id="btn_add" value="添加">
							</td>
							<td>
								<input name="btn_delAll" type="button" class="btn_2_3" id="btn_delAll" value="删除所选">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</table>
   		<fieldset >
		<legend>查询条件</legend>
   		<span>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
				<tr>
					<td height="26" align="right" bgcolor="#FFFFFF">
						<strong>客户名称：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_bargainTime" name="sellRecord.bargainTime" cssStyle="width:200px" ></s:textfield>
					</td>
					<td height="26" align="right" bgcolor="#FFFFFF">
						<strong>联 系 人：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_bargainTime" name="sellRecord.bargainTime" cssStyle="width:200px" ></s:textfield>
					</td>
					<td height="26" align="right" bgcolor="#FFFFFF">
						<strong>所属业务员：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_bargainTime" name="sellRecord.bargainTime" cssStyle="width:200px" ></s:textfield>
					</td>
					<td height="26" align="right" bgcolor="#FFFFFF" rowspan="2">
						<input name="queryBtn" type="submit" class="btn_2_3" id="queryBtn" value="查询">
					</td>
				</tr>
				<tr>
					<td height="26" align="right" bgcolor="#FFFFFF">
						<strong>回款情况：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_bargainTime" name="sellRecord.bargainTime" cssStyle="width:200px" ></s:textfield>
					</td>
					<td height="26" align="right" bgcolor="#FFFFFF">
						<strong>成交日期：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF" colspan="3">
						<s:textfield id="txt_orderID" name="sellRecord.orderID" cssStyle="width:200px" ></s:textfield>
						— <s:textfield id="txt_orderID" name="sellRecord.orderID" cssStyle="width:200px" ></s:textfield>
					</td>
				</tr>
			</table>
		</span>
		</fieldset>
   		<table id="recordsList" width="100%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
			<tr>
				<td align="center" width="50px" background="<%=basePath%>/images/headerbg.jpg">
 							<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
 						</td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>客户名称</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>业务员</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>成交日期</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>产品种类</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>交易总额</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>实 收</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>欠 款</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>交回款情况</strong></td>
            			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>操作</strong></td>
			</tr>
			 <s:iterator value="pagination.data" status="obj">
	        	<tr>
	        		<td height="26" align="center" bgcolor="#FFFFFF" >  
						<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
					</td>
           			<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="customerName"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="salesmanName"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="bargainTime"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="goodsType"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="receivable"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="realCollection"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="debt"/></td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="receivable/realCollection"/>%</td>
            		<td height="26" align="center" bgcolor="#FFFFFF"><s:property value="salesman"/></td>
            </tr>
            </s:iterator>
			 <tr>
	          <td height="26" colspan="11" align="center" bgcolor="#FFFFFF">
				<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
			  </td>
	        </tr>
		</table>
	</s:form>
  </body>
</html>
