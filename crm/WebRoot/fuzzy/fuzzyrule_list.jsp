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
			
			/**
	  		 */
			$("#addbtn").click(function(){
				parent.parent.tipsWindown("添加模糊规则","iframe:fuzzy/fuzzyRuleInfo.action","650","420","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
			});
			
			/**
	  		 * 排序
	  		 */
			$("#sortbtn").click(function(){
				parent.parent.tipsWindown("模糊规则排序","iframe:fuzzy/citysort.action?fuzzyCategory=<s:property value='fuzzyCategory' />","370","320","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
			});
			
			$(".showInfo").css("cursor","hand").click(function(){
				parent.parent.tipsWindown("修改模糊规则","iframe:fuzzy/fuzzyRuleInfo.action?id=" + $(this).attr("tid") ,"650","420","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
			});
			/**
	  		 * 删除所选设备信息
	  		 */
	  		$("#deletebtn").click(function(){
  				if(window.confirm("您确定要删除所选信息吗？")){
  					document.forms[0].action = "deleteFuzzyRule.action";
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
								<td align="right"></td>
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
									<strong>条件</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>结论</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{iId}" name="ids" fieldValue="%{iId}"
											value="false" theme="simple" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<span class="showInfo" tid="<s:property value='iId' />">
										<s:iterator value="attachObject" status="obj1">
											<s:property value="fuzzyCategoryName" />&nbsp;&nbsp;<s:property value="ifFuzzyName" />
											<s:if test="#obj1.index < attachObject.size - 1">
											and
											</s:if>
										</s:iterator>
										</span>
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<span class="showInfo" tid="<s:property value='iId' />"><s:property value="caption" /></span>
										&nbsp;
									</td>
								</tr>
							</s:iterator>
							<tr>
					          <td height="26" colspan="3" align="center" bgcolor="#FFFFFF">
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
