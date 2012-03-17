<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/page-tags.tld"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'devicelist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="../../style.css" />
	<script type="text/javascript" src="../../js/jquery-1.4.2.min.js"></script>
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<script type="text/javascript">
	<!--
		$(function(){
			$("#addbtn").click(function(){
				parent.parent.parent.tipsWindown("添加设备","iframe:openAddDeviceAction.action","460","250","true","","true","no");
			});
			$("#editbtn").click(function(){
				parent.parent.parent.tipsWindown("修改设备","iframe:sysmanage/groupinfo.html","460","250","true","","true","no");
			});
			$("#editpointbtn").click(function(){
				parent.parent.parent.tipsWindown("修改监控点","iframe:sysmanage/groupinfoedit.html","460","190","true","","true","no");
			});
		});
	//-->
	</script>

  </head>
  
  <body>
  <s:form>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
       		<input name="button" type="button" class="btn_4" id="addbtn" value="添加" >
    		<input name="button" type="button" class="btn_4" id="editbtn" value="修改" >
    		<input name="button" type="button" class="btn_4" id="editbtn" value="添加阈值参数" >
            <input name="button" type="button" class="btn_4" id="editpointbtn" value="修改监控点" >
            <input name="button2" type="button" class="btn_4" id="button2" value="删除所选">
            <input name="button3" type="button" class="btn_2_3" id="button" value="排序"></td>
        <td align="right"></td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
          <td width="8%" height="26" align="center" background="../images/headerbg.jpg">&nbsp;</td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备编号</strong></td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备类型</strong></td>
		  <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备名称</strong></td>
		  <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备型号</strong></td>
		  <td width="14%" align="center" background="../images/headerbg.jpg"><strong>设备厂商</strong></td>
		  <td width="14%" align="center" background="../images/headerbg.jpg"><strong>监控点数量</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
          <td height="26" align="center" bgcolor="#FFFFFF">
          	<input type="checkbox" name="checkbox" id="checkbox">
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
         
          
        </tr>
        </s:iterator>
        
        <tr>
          <td height="26" colspan="5" align="center" bgcolor="#FFFFFF">
			<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		  </td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
