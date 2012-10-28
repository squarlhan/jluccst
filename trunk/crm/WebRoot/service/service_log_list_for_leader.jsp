<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/page-tags"%> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true" />
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
			$("#searchBtn").click(function(){
				form1.submit();
			});
			
	  		/**
	  		 * 查看信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("查看服务记录","iframe:" + url ,"785","350","true","","true","no");
					parent.parent.$("#windown-close").bind('click',function(){
						window.location.href="${pageContext.request.contextPath}/service/serviceloglistforleader.action?companyId=" + $("#companyId").val();
					});
	  			});
	  		});
	  		
	  		$("#searchCompanyName").focus();
		});
		//-->
		</script>
	</head>
	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
			<s:hidden name="companyId" id="companyId"></s:hidden>
			<table width="100%" style="height: 100%;" border="0" cellspacing="5"
				cellpadding="0">
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="5" cellpadding="0">
							<tr>
								<td>
									<table border="0" cellpadding="5" cellspacing="0">
							<tr>  		
								<td></td>
								<td align="center">客户名称</td>
								<td><s:textfield name="searchCompanyName" cssStyle="width:250px;" /></td>
								<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="searchBtn" value="快速查询" /></td>
							</tr>
						</table>
								</td>
							</tr>
						</table>
						<table width="100%" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#d5e4fd">
							<tr>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>客户名称</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>服务日期</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>维修员</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>故障情况</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>解决措施</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg" style="width:80px;">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td align="left" bgcolor="#FFFFFF">
										<s:property value="companyName" />&nbsp;
									</td>
									<td align="center" bgcolor="#FFFFFF">
										<s:property value="serviceTime" />&nbsp;
									</td>
									<td align="center" bgcolor="#FFFFFF">
										<s:property value="repairman" />&nbsp;
									</td>
									<td align="left" bgcolor="#FFFFFF">
										<s:property value="malfunction" />&nbsp;
									</td>
									<td align="left" bgcolor="#FFFFFF">
										<s:property value="solutions" />&nbsp;
									</td>
									<td align="center" bgcolor="#FFFFFF">
										<a name="edit" href="javascript:void(0);" url="<%=path%>/service/servicelogforleader.action?logId=<s:property value='id' />">查看</a>  
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
