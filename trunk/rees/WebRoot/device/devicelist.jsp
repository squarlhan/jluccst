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
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"/>
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
			$("#addbtn").click(function(){
				parent.parent.parent.tipsWindown("添加设备信息","iframe:openAddDeviceAction.action","460","350","true","","true","no");
			});

			$("#editpointbtn").click(function(){
				parent.parent.parent.tipsWindown("修改监控点","iframe:sysmanage/groupinfoedit.html","460","190","true","","true","no");
			});
			$.fn.CheckBoxAll("cbk_all");
	  		$.fn.UnCheckBoxAll("ids","cbk_all");

	  		/**
	  		 * 修改设备信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.parent.tipsWindown("修改设备信息","iframe:"+url,"460","350","true","","true","no");
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
  				var url = "deleteDeviceAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
  				}
	  		});
	  		
	  		$("#sortbtn").click(function(){
	  			parent.parent.parent.tipsWindown("设备排序","iframe:openSortDeviceAction.action","350","420","true","","true","no");
	  		});
		});
		
		
		/******************************************************************************************/
		/**
	  	 * 点击选复选框时，执行全选/取消全选功能
	  	 * @param chkallid
	  	 * 执行全选功能的checkbox的id值
	  	 */
	  	$.fn.CheckBoxAll = function (chkallid) {
	  		$("#" + chkallid).click(function () {
	  			var b = ($(this).attr("checked"));
	  			$(":checkbox").each(function () {
	  				if( !$(this).attr("disabled") ){
	  					$(this).attr("checked", b);
	  				}
	  			});
	  		});
	  		if($(":checkbox").length == 1){
	  			$("#" + chkallid).attr("disabled","true");
	  		}
	  	};

	  	/**
	  	 * 子复选框有一个处理非选中状态时，执行全选功能的复选框将置为非选中状态
	  	 * @param subchkname
	  	 * 子复选框的name
	  	 * @param chkallid
	  	 * 执行全选功能的复选框id
	  	 */
	  	$.fn.UnCheckBoxAll = function (subchkname, chkallid) {
	  		$(":checkbox[name='" + subchkname + "']").click(function () {
	  			var l = $(":checkbox[name='" + subchkname + "']").length;
	  			if (!$(this).attr("checked")) {
	  				$("#" + chkallid).attr("checked", false);
	  			} else {
	  				var i = 0;
	  				$(":checkbox[name='" + subchkname + "']").each(function () {
	  					if ($(this).attr("checked")) {
	  						i++;
	  					}
	  				});
	  				if (l == i) {
	  					$("#" + chkallid).attr("checked", true);
	  				}
	  			}
	  		});
	  	};
	  /******************************************************************************************/
	
	//-->
	</script>

  </head>
  
  <body>
  <s:form id="form1">
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
       		<input name="button" type="button" class="btn_4" id="addbtn" value="添加" >
    	
    		<input name="button" type="button" class="btn_4" id="addparambtn" value="添加阈值参数" >
            <input name="button" type="button" class="btn_4" id="editpointbtn" value="修改监控点" >
            <input name="button" type="button" class="btn_4" id="deletepointbtn" value="删除所选">
            <input name="button3" type="button" class="btn_2_3" id="sortbtn" value="排序"></td>
        <td align="right"></td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
         <td align="center" >  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
   
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备编号</strong></td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备类型</strong></td>
		  <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备名称</strong></td>
		  <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备型号</strong></td>
		  <td width="14%" align="center" background="../images/headerbg.jpg"><strong>设备厂商</strong></td>
		  <td width="14%" align="center" background="../images/headerbg.jpg"><strong>监控点数量</strong></td>
		  <td width="14%" align="center" background="../images/headerbg.jpg"><strong>操作</strong></td>
      	  <td width="16%" align="center" background="../images/headerbg.jpg"></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
        <td height="26" align="center" bgcolor="#FFFFFF" >  
				<s:checkbox id="%{id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
			</td>
           <td height="26" align="center" bgcolor="#FFFFFF">
              <s:property value="deviceNum"/>&nbsp;
          </td>
          <td height="26" align="center" bgcolor="#FFFFFF">
          	   <s:property value="deviceType"/>&nbsp;
          </td>
           <td height="26" align="center" bgcolor="#FFFFFF">
          	   <s:property value="deviceName"/>&nbsp;
          </td> 
          <td height="26" align="center" bgcolor="#FFFFFF">
          	   <s:property value="deviceModel"/>&nbsp;
          </td>
           <td height="26" align="center" bgcolor="#FFFFFF">
          	     <s:property value="deviceFactory"/>&nbsp;
          </td> 
          <td height="26" align="center" bgcolor="#FFFFFF">
          	   <s:property value="controlpoint"/>&nbsp;
          </td> 
         
          
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
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
