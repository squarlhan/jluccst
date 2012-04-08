<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/page-tags"%> 
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author JiangMD
 * @version 1.0
 * @audit  
 */
/**
 * Modified Person：
 * Modified Time：
 * Modified Explain：
 */
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>设备管理列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"  jfunction="true"/>
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
			$.fn.uncheckall("ids","cbk_all");
			
			/**
	  		 * 添加设备信息
	  		 */
			$("#addbtn").click(function(){
				var factoryId = $("#hid_factoryId").val();
	  			var workshopId = $("#hid_workshopId").val();
				parent.parent.tipsWindown("添加设备信息","iframe:openAddDeviceAction.action?factoryId="+factoryId+"&workshopId="+workshopId,"480","400","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
			});

	  		/**
	  		 * 修改设备信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var factoryId = $("#hid_factoryId").val();
		  			var workshopId = $("#hid_workshopId").val();
	  				var url = $(this).attr("url")+"&factoryId="+factoryId+"&workshopId="+workshopId;
	  				parent.parent.tipsWindown("修改设备信息","iframe:"+url,"480","400","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
						window.location.href=window.location.href;
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
	  		 * 检查点维护
	  		 */
	  		$('a[name="edit_point"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("监测点信息","iframe:"+url,"550","350","true","","true","no");
	  			});
	  		});
	  		
	  		/**
	  		 * 删除所选设备信息
	  		 */
	  		$("#deleteselectedbtn").click(function(){
  				var url = "deleteDeviceAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
	  		});
	  		
	  		/**
	  		 * 打开设备排序窗口
	  		 */
	  		$("#sortbtn").click(function(){
	  			var factoryId = $("#hid_factoryId").val();
	  			var workshopId = $("#hid_workshopId").val();
	  			parent.parent.tipsWindown("设备排序","iframe:openSortDeviceAction.action?factoryId="+factoryId+"&workshopId="+workshopId,"350","420","true","","true","no");
	  			parent.parent.$("#windown-close").bind('click',function(){
					window.location.href=window.location.href;
				});
	  		});
		});
		
	//-->
	</script>

  </head>
  
  <body>
	<s:form id="form1" name="form1" method="post" theme="simple" >
	<s:hidden id="hid_factoryId" name="factoryId"></s:hidden>
	<s:hidden id="hid_workshopId" name="workshopId"></s:hidden>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
       		<input name="button" type="button" class="btn_4" id="addbtn" value="添加" >
            <input name="button" type="button" class="btn_4" id="deleteselectedbtn" value="删除所选">
            <input name="button3" type="button" class="btn_2_3" id="sortbtn" value="排序"></td>
        <td align="right"></td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
         <td align="center" >  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
   
		  <td width="15%" align="center" background="../images/headerbg.jpg"><strong>设备名称</strong></td>
          <td width="20%" align="center" background="../images/headerbg.jpg"><strong>设备编号</strong></td>
          <td width="10%" align="center" background="../images/headerbg.jpg"><strong>设备类型</strong></td>
		  <td width="20%" align="center" background="../images/headerbg.jpg"><strong>设备型号</strong></td>
		  <td width="20%" align="center" background="../images/headerbg.jpg"><strong>设备厂商</strong></td>
		  <td width="8%" align="center" background="../images/headerbg.jpg"><strong>监控点</strong></td>
		  <td width="10%" align="center" background="../images/headerbg.jpg"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
        	<td height="26" align="center" bgcolor="#FFFFFF" >  
				<s:checkbox id="%{id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
			</td>
			<td height="26" align="center" bgcolor="#FFFFFF" nowrap>
          	   <s:property value="deviceName"/>&nbsp;
           </td>
           <td height="26" align="center" bgcolor="#FFFFFF" nowrap>
              <s:property value="deviceNum"/>&nbsp;
          </td>
          <td height="26" align="center" bgcolor="#FFFFFF" nowrap>
          	<s:iterator value="deviceTypeList" status="type">
          		<s:if test="deviceTypeId==id">
          			<s:property value="typeName"/>&nbsp;
          		</s:if>
          	</s:iterator>
          </td>
            
          <td height="26" align="center" bgcolor="#FFFFFF" nowrap>
          	   <s:property value="deviceModel"/>&nbsp;
          </td>
           <td height="26" align="center" bgcolor="#FFFFFF" nowrap>
          	     <s:property value="deviceFactory"/>&nbsp;
          </td> 
          <td height="26" align="center" bgcolor="#FFFFFF">
          		<s:url id="edit_point_url" action="openAddPointAction">   
					<s:param name="device.id" value="id"></s:param>   
				</s:url>
				<a name="edit_point" href="javascript:void(0);" url="${edit_point_url}">维护</a> 
          </td> 
         
          
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF" nowrap>
          	<s:url id="edit_url" action="openModifyDeviceAction">   
				<s:param name="device.id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteDeviceAction">   
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
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
