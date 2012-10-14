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
			$.fn.checkall("cbk_all");
			$.fn.uncheckall("dictIds","cbk_all");
			$("#searchBtn").click(function(){
				form1.submit();
			});
			/**
	  		 */
			$("#addbtn").click(function(){
				parent.parent.tipsWindown("添加服务记录","iframe:${pageContext.request.contextPath}/service/servicelogbycustomer.action?companyId=" + $("#companyId").val(),"785","350","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="${pageContext.request.contextPath}/service/serviceloglistbycustomer.action?companyId=" + $("#companyId").val();
				});
			});
			
			/**
	  		 * 删除所选设备信息
	  		 */
	  		$("#deletebtn").click(function(){
  				if(window.confirm("您确定要删除所选信息吗？")){
  					var url = "<%=path%>/service/deleteservicelog.action?logIds=";
  					var values = "";
  					$('input[name="logIds"]').each(function(){
  						if($(this).attr("checked")){
  							if(values==""){
  								values = $(this).val();
  							}else{
  								values = values + "," + $(this).val();
  							}
  						}
  					});
  					$.post(url + values, "", function(data){window.location.href="${pageContext.request.contextPath}/service/serviceloglistbycustomer.action?companyId=" + $("#companyId").val();});
  				}
	  		});
			
	  		/**
	  		 * 修改信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("修改服务记录","iframe:" + url ,"785","350","true","","true","no");
					parent.parent.$("#windown-close").bind('click',function(){
						window.location.href="${pageContext.request.contextPath}/service/serviceloglistbycustomer.action?companyId=" + $("#companyId").val();
					});
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个信息
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				if(window.confirm("您确定要删除这条信息吗？")){
	  					$.post(url, "", function(data){window.location.href="${pageContext.request.contextPath}/service/serviceloglistbycustomer.action?companyId=" + $("#companyId").val();});
	  				}
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
									<input name="button" type="button" class="btn_2_3" id="addbtn"
										value="添加">
									<input name="button" type="button" class="btn_4"
										id="deletebtn" value="删除所选">
								</td>
							</tr>
						</table>
						<table width="100%" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#d5e4fd">
							<tr>
								<td align="center" background="<%=path%>/images/headerbg.jpg">
									<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
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
									background="<%=path%>/images/headerbg.jpg" style="width:100px;">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{id}" name="logIds" fieldValue="%{id}"
											value="false" theme="simple" />
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
										<a name="edit" href="javascript:void(0);" url="<%=path%>/service/servicelogbycustomer.action?logId=<s:property value='id' />&companyId=<s:property value='companyId' />">编辑</a>  
         								<a name="delete" href="javascript:void(0);" url="<%=path%>/service/deleteservicelog.action?logIds=<s:property value='id' />">删除</a>&nbsp;
									</td>
								</tr>
							</s:iterator>
							<tr>
					          <td height="26" colspan="6" align="center" bgcolor="#FFFFFF">
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
