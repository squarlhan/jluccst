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
				parent.parent.tipsWindown("添加服务记录","iframe:service/servicelog.action","785","350","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="serviceloglist.action";
				});
			});
			
			$(".showInfo").css("cursor","hand").click(function(){
				parent.parent.tipsWindown("修改服务记录","iframe:service/servicelog.action?logId=" + $(this).attr("lid") ,"785","350","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="serviceloglist.action";
				});
			});
			/**
	  		 * 删除所选设备信息
	  		 */
	  		$("#deletebtn").click(function(){
  				if(window.confirm("您确定要删除所选信息吗？")){
  					document.forms[0].action = "deleteservicelog.action";
					document.forms[0].submit();
  				}
	  		});
		});
		//-->
		</script>
	</head>
	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
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
								<td align="right"><table border="0" cellpadding="5" cellspacing="0">
							<tr>  		
								<td></td>
								<td align="center">客户名称</td>
								<td><s:textfield name="searchCompanyName" cssStyle="width:150px;" /></td>
								<td style="width: 80px"><input type="button" style="width: 80px;" class="btn_4" id="searchBtn" value="快速查询" /></td>
							</tr>
						</table></td>
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
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{id}" name="logIds" fieldValue="%{id}"
											value="false" theme="simple" />
									</td>
									<td align="left" bgcolor="#FFFFFF">
										<span class="showInfo" lid="<s:property value='id' />"><s:property value="companyName" />&nbsp;</span>
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
