<%@ page language="java"
import="com.boan.crm.groupmanage.common.UserSession,com.boan.crm.groupmanage.service.IPopedomService,com.boan.crm.groupmanage.service.impl.PopedomServiceImpl"
pageEncoding="UTF-8"%>
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
	IPopedomService popedomService = new PopedomServiceImpl();
	UserSession us = (UserSession) session.getAttribute("userSession");
	String deptId = us.getDeptId();
	//判断是否是公司管理员或公司级用户
	boolean popodomFlag = popedomService.isCompanyAdministrator(us.getUserId(), String.valueOf(us.getUserType()) ) 
			||popedomService.isHasCompanyPopedom(us.getRoleKey());
	String getUserNameUrl = "";
	if( popodomFlag ){
		//经理级人员
		getUserNameUrl = "getUserNameByCompany.action";
	}else{
		//部门人员
		getUserNameUrl = "getUserNameByDept.action";
	}
	//*/
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
	<script src="<%=basePath %>/js/ui/jquery.ui.core.js"></script>
	<script src="<%=basePath %>/js/ui/jquery.ui.position.js"></script>
	<script src="<%=basePath %>/js/ui/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.mergeCell.js"></script>
	<style type="text/css">
		.auto-style1 {
		background: #d3eaef; font-size: 18px; font-family: 仿宋;}
	
	.auto-style2 {
		font-size: x-large;
	}
	.auto-style3 {
		text-align: right;
	}
	.ui-autocomplete-loading { background: white url('images/ui-anim_basic_16x16.gif') right center no-repeat; }
	</style>
	<link rel='stylesheet' type='text/css'  href='<%=path %>/css/jquery.autocomplete.css' />
	
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
			$('#table1').mergeCell({
				cols: [0, 2, 3]
			}); 
			$('#txt_query_beginTime').datetimepicker({showTimepicker: false});
			$('#txt_query_endTime').datetimepicker({showTimepicker: false});
			
			$("#addbtn").click(function(){
				parent.parent.tipsWindown("添加行动计划","iframe:openAddActionPlanAction.action","580","380","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="./openActionPlanListAction.action";
				});
		
			});
			$.fn.checkall("cbk_all");
	  		$.fn.uncheckall("ids","cbk_all");

	  		$("#txt_query_employee_name").autocomplete("<%=getUserNameUrl%>",
		     {
	           minChars: 1,
	           max:5,
	           width: 150, 
	           matchContains: true,
	           autoFill: false,
	           extraParams: 
	           {   
	        	 userName: function() 
                 {
                  	 return $("#txt_query_employee_name").val(); 
                 }   
               },
	           parse: function(test) 
	           {
	               data = test;
	               var rows = [];
	               if(data != null)
	               {
	            	   allData = test;
		               for(var i=0; i<data.length; i++)
			           {
			              rows[rows.length] = 
			              {
			                   data: data[i].userCName,
			                   value:data[i],
			                   result:data[i].userCName
			               };
			            }
	           		}
		            return rows;
	           },
	           formatItem:function(item)
	           {
                   return item;
	           }
		     });
	  		/**
	  		 * 修改公司信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("查看行动计划","iframe:"+url,"620","380","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
						window.location.href="./openActionPlanListForViewAction.action";
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
  				var url = "deleteActionPlanAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
	  		});
		});
	</script>

  </head>
  
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple" action="openActionPlanListForViewAction.action">
 <s:hidden name="deptId"></s:hidden>
  <s:hidden name="userId"></s:hidden>
<table width="110%"  border="0" cellspacing="5" cellpadding="0">
	<tr>
		<td colspan="2">
		<fieldset >
		<legend>查询条件</legend>
   		<span>
      		<table   border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
		      <tr>
					<td height="26" width = "80px" align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>员工姓名：</strong>
					</td>
					<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_query_employee_name" name="employeeName" cssStyle="width:120px"></s:textfield>
					</td>
					<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>行动类型：</strong>
					</td>
					<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF">
						<s:select id="sel_query_planType"  name="planType"  list="#{-1:'--全部--',3:'跟进',4:'回访' }"  cssStyle="width: 120px;" ></s:select>
					</td>
					<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>提交时间：</strong>
					</td>
					<td height="26" width = "270px"  align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_query_beginTime" name="beginTime" cssStyle="width:120px"></s:textfield> -
						<s:textfield id="txt_query_endTime" name="endTime" cssStyle="width:120px"></s:textfield>
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
  <tr>
    <td valign="top">
      <table id="table1" width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>业务员</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>提交日期</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>计划类型</strong></td>
               <td width="40%"  align="center" background="<%=path %>/images/headerbg.jpg"><strong>计划内容</strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>总结</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="employeeName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"  nowrap="nowrap"><s:property value="submitTime"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF">
              	<s:if test="planType==3">
	              	跟进
	              	</s:if>
	              	<s:elseif test="planType==4">
	              	回访
	              	</s:elseif>
	              	<s:else>
	              	跟进
	              	</s:else>
              	</td>
                <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="planContent"/></td>
                <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="memo"/></td>
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
          	<s:url id="edit_url" action="openModifyActionPlanForViewAction">   
				<s:param name="actionPlan.id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteActionPlanAction">   
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
      </table>
      </td>
  </tr>
</table>
</s:form>
</body>
</html>
