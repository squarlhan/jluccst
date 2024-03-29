<%@ page language="java" import="java.util.*" 
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
			$('#txt_queryTime').datetimepicker({showTimepicker: false});
			$.fn.checkall("cbk_all");
	  		$.fn.uncheckall("ids","cbk_all");
	  		//如果树节点上选择了具体的人，那么查询框的提交人设为不可输入
	  		if($("#hid_personId").val()!=""){
	  			$.fn.ReadOnly("txt_query_person_name");
	  		}
	  		
	  		$("#txt_query_person_name").autocomplete("<%=getUserNameUrl%>",
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
	  	                  	 return $("#txt_query_person_name").val(); 
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
	  		 * 查看
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("查看周计划","iframe:"+url,"850","520","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
	  					//window.location.href="./openWeeklyMainInfoListAction.action?companyId="+$("#hid_companyId").val()+"&deptId="+$("#hid_deptId").val()+"&personId="+$("#hid_personId").val();
	  					$("#form1").attr("openWeeklyMainInfoListViewAction.action");
						$("#form1").submit();
					});
	  			});
	  		});
	  		
	  		/**
	  		 * 查看报表
	  		 */
	  		$('a[name="seeAll"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("查看全部计划","iframe:"+url,"900","550","true","","true","no");
	  			});
	  		});
	  		
	  		/**
	  		 * 统计
	  		 */
	  		$('a[name="stat"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("查看统计","iframe:"+url,"850","520","true","","true","no");
	  			});
	  		});
		});
		
		/**
		 * 设置某元素或其下的子元素为只读
		 * @param {Object} id 参数Id
		*/
		$.fn.ReadOnly = function(id){
			var obj = $("#"+id) ;
			obj.wrap('<span id="readonly_span_for_'+id+'" onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"></span>');
			obj.find(":input").each(function(i){
				if($(this).is(":radio")){
					$(this).focus(function(){
						$(this).blur();
					});
				}
				$(this).attr("tabindex","-1");
			});
		};
	</script>

  </head>
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple" >
<s:hidden id="hid_companyId" name="companyId"></s:hidden>
 <s:hidden id="hid_deptId" name="deptId"></s:hidden>
<s:hidden id="hid_personId" name="personId"></s:hidden>
<table width="100%"  border="0" cellspacing="5" cellpadding="0">
	<tr>
		<td colspan="2">
		<fieldset >
		<legend>查询条件</legend>
   		<span>
      		<table   border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
		      <tr>
					<td height="26" width = "80px" align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>提交人：</strong>
					</td>
					<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_query_person_name" name="personName" cssStyle="width:120px"></s:textfield>
					</td>
					<td height="26" width = "120px"  align="left" bgcolor="#FFFFFF" nowrap="nowrap">
						<strong>计划开始时间：</strong>
					</td>
					<td height="26" width = "80px"  align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_queryTime" name="queryTime" cssStyle="width:120px"></s:textfield>
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
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>提交人</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>计划时间</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>所在部门</strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg" ><strong>职务  </strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>直接上级</strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>检查人</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg" nowrap="nowrap"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="personName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"  nowrap="nowrap"><s:property value="planInterzone"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="deptName"/></td>
                <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="position"/></td>
                <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="superior"/></td>
                <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="checker"/></td>
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF"  nowrap="nowrap">
          	<s:url id="edit_url" action="openWeeklyTabPageViewAction">   
				<s:param name="weeklyMainInfo.id" value="id"></s:param>   
			</s:url>
			<s:url id="stat_url" action="showWeeklyStatInfoAction">
				<s:param name="mainInfoId" value="id"></s:param>   
			</s:url>
			<s:url id="report_url" action="openWeeklyReportAction.action">   
				<s:param name="mainInfoId" value="id"></s:param>   
			</s:url>
			<a name="seeAll" href="javascript:void(0);" url="${report_url}">查看全部计划</a>  
         	<a name="edit" href="javascript:void(0);" url="${edit_url}">查看计划</a>  
         	<a name="stat" href="javascript:void(0);" url="${stat_url}">查看统计</a>
          </td>
        </tr>
        </s:iterator>        
        <tr>
          <td height="26" colspan="10" align="center" bgcolor="#FFFFFF">
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
