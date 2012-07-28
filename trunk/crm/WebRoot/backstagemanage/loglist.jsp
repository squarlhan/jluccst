<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>公司管理列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink css="true" jquery="true" jfunction="true" tipswindow="true"></j:scriptlink>
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<script type="text/javascript">
	
	function clearLog_click(){
 				if(window.confirm("您确定要清空日志吗？")){
 					var url = "./logAction!clearAllLog.action"
 					$.post(url, $('#form1').serialize(), function(data){window.location.href=window.location.href;});
 				}
	}
	</script>

  </head>
  
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple">
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
            <input name="clearLog" type="button" class="btn_4" id="clearLog" value="清空日志"  onclick="clearLog_click();">
        <td align="right"></td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
              <td align="center" background="<%=path %>/images/headerbg.jpg"   height="29" ><strong>类型</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>公司名称</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>部门名称</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>操作人</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>操作内容</strong></td>
               <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>记录时间</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
				 <td height="26" align="center" bgcolor="#FFFFFF">
				 	<img width="16px" height="16px" src="<%=path %>/images/log/log<s:property value="logType" />.gif">
					<s:property value="logTypeMean" />
				</td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="companyName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="deptName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="userName"/></td>
                <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="logContent"/></td>
                <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="createTimeEn"/></td>
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
