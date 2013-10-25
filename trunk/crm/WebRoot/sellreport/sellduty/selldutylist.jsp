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
				parent.parent.tipsWindown("添加职责类型","iframe:openAddSellDutyAction.action","470","320","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="openSellDutyListAction.action";
				});
			});
			
			$(".showInfo").css("cursor","hand").click(function(){
				parent.parent.tipsWindown("修改职责类型","iframe:openModifySellDutyAction.action?sellDuty.id="+ $(this).attr("tid") ,"470","320","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="openSellDutyListAction.action";
				});
			});
			
			/**
	  		 * 修改职责类型
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("修改职责类型","iframe:"+url,"470","320","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
						window.location.href="./openSellDutyListAction.action";
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
	  		$("#deletebtn").click(function(){
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
  				var url = "deleteSellDutyAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
	  		});
		});
		//-->
		</script>
	</head>
	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
			<s:hidden id="typeFlag" name="typeFlag"></s:hidden>
			<s:hidden id="provinceId" name="provinceId"></s:hidden>
			<s:hidden id="companyId" name="companyId"></s:hidden>
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
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
							<tr>
								<td align="center" background="<%=path%>/images/headerbg.jpg">
									<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
								</td>

								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>职责类型</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>计划类型</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>销售额统计</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>职责说明</strong>
								</td>
								<td align="center"
									background="<%=path%>/images/headerbg.jpg">
									<strong>操作</strong>
								</td>
							</tr>
							<s:iterator value="pagination.data" status="obj">
								<tr>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<s:checkbox id="%{id}" name="ids" fieldValue="%{id}"
											value="false" theme="simple" />
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<span class="showInfo" tid="<s:property value='id' />"><s:property value="name" /></span>
										&nbsp;
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<span class="showInfo" tid="<s:property value='id' />">
										<s:if test="dutyType==0">
											<font color="green">
												周报/周计划
											</font>
										</s:if>
										<s:else>
											<font color="orange">
											月报/月计划
											</font>
										</s:else>
										</span>
										&nbsp;
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<span class="showInfo" tid="<s:property value=' id' />"><s:property value="numberType?'是':'否'" /></span>
										&nbsp;
									</td>
									<td height="26" align="center" bgcolor="#FFFFFF">
										<span class="showInfo" tid="<s:property value='id' />"><s:property value="remark" /></span>
										&nbsp;
									</td>
									<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
							          	<s:url id="edit_url" action="openModifySellDutyAction">   
											<s:param name="sellDuty.id" value="id"></s:param>   
										</s:url>
										<s:url id="delete_url" action="deleteSellDutyAction">   
											<s:param name="ids" value="id"></s:param>   
										</s:url>
							         	<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>  
							         	<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>
							          </td>
								</tr>
							</s:iterator>
							<tr>
					          <td height="26" colspan="9" align="center" bgcolor="#FFFFFF">
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
