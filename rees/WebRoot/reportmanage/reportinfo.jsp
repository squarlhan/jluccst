<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="p" uri="/WEB-INF/page-tags.tld"%>
<%
	/**
	 * All right reserved.
	 */
	/**
	 * @author zhaomengxue
	 * @version 1.0
	 * @audit  
	 */
	/**
	 * Modified Person：
	 * Modified Time：
	 * Modified Explain：
	 */
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>添加个人报表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"/>
	<link type="text/css" rel="stylesheet" href="../style.css" />
	<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript">

	$(document).ready(function() {
		$("#closeBtn").click(function(){
			parent.$("#windown-close").click();
		});
		$(".btn_2_3").click(function(){
			parent.$("#windown-close").click();
		});
	});

</script>
</head>
<body>
<s:form  name="repform" action="openAddReportAction.action" theme="simple">
<table width="100%" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="6" cellpadding="0">
        <tr>
          <td style="height:36px;"><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>汇报类别：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF">
                <s:textfield id="rep_type" name="personReport.reportType"/>
              </td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>汇报题目：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF">
              	<s:textfield id="rep_subject" name="personReport.reportSubject"/>
              </td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>汇报人：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF">
              	<s:textfield id="rep_person" name="personReport.reportPerson"/>
              </td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>汇报时间：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF">
              	<s:textfield id="rep_type" name="personReport.reportDate"/>
              </td>
            </tr>
             <tr>
              <td height="147" align="right" bgcolor="#FFFFFF"><strong>汇报内容：</strong></td>
              <td height="147" align="left" bgcolor="#FFFFFF">
              	<s:textfield id="rep_content" name="personReport.reportContent"/>
              </td>
            </tr>
            <tr>
              <td height="26" colspan="2" align="left" bgcolor="#FFFFFF">
<input name="保存模板" type="button" value="保存模板" class="btn_2_3"/>
&nbsp;&nbsp;
<input name="读取模板" type="button" value="读取模板" class="btn_2_3"/>
&nbsp;&nbsp;
	  <input name="提交" type="button" value="保存" class="btn_2_3"/>
&nbsp;&nbsp;
	  <input name="提交" type="button" value="提交" class="btn_2_3"/>
&nbsp;&nbsp;
 <input name="导出到Word" type="button" value="导出Word" class="btn_2_3"/>
&nbsp;&nbsp;
	<input name="退出" type="button" value="退出" class="btn_2_3"/>
                </td>
            </tr>
          </table></td>
        </tr>
        
    </table></td>
  </tr>
</table>
</s:form>
</body>
</html>

