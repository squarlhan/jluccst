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
			$(".showInfo").css("cursor","hand").click(function(){
				parent.parent.tipsWindown("查看会员信息","iframe:service/memberinfo.action?infoId=" + $(this).attr("lid") ,"785","300","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="${pageContext.request.contextPath}/service/memberinfolist.action";
				});
			});
			/**
	  		 * 删除所选
	  		 */
	  		$("#deletebtn").click(function(){
  				if(window.confirm("您确定要取消所选信息会员信息吗？")){
  					document.forms[0].action = "cancelmemberinfo.action";
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
						
						<table width="100%" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#d5e4fd">
							<tr>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>客户名称</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>消费时间</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>消费金额</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>消费积分</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td align="left" bgcolor="#FFFFFF">
										<span class="showInfo" lid="<s:property value='id' />"><s:property value="companyName" />&nbsp;</span>
									</td>
									<td align="center" bgcolor="#FFFFFF">
										<s:property value="consumptionTime" />&nbsp;
									</td>
									<td align="center" bgcolor="#FFFFFF">
										<s:property value="consumptionMoney" />&nbsp;
									</td>
									<td align="center" bgcolor="#FFFFFF">
										<s:property value="point" />&nbsp;
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
