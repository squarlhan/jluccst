<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 * All right reserved.
	 */
	/**
	 * @author 
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>进入论坛窗口</title>
<link type="text/css" rel="stylesheet" href="../style.css" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
<!--
//-->
</script>
<style type="text/css">
<!--
.STYLE1 {font-size: 12px}
.STYLE2 {font-size: 12}
-->
</style>
</head>
<body>
<s:debug/>
<s:form id="form1" action="toAddForumMessageInfoAction.action">
<table width="100%" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="6" cellpadding="0">
        <tr>
          <td style="height:36px;"><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

            <tr>
              <td width="69%" valign="top" bgcolor="#FFFFFF"><table width="100%" border="0">
                <tr>
                  <td height="321" colspan="2" valign="top" style="padding:5px;">
                  <table width="100%" border="0" style="margin-top:10px;">
                  <s:iterator value="pagination.data" status="obj">
                  <tr>
              			<td height="26" bgcolor="#FFFFFF">
	                       <s:property value="messageContent"/>&nbsp;
	                       <br> <s:property value="publisherDept"/>&nbsp;
	                       <s:property value="publisher"/>&nbsp;
	                       <s:property value="messageTime"/>&nbsp;
             			 </td>
                  </tr>
                  </s:iterator>
                    </table><p class="STYLE1">&nbsp;</p></td>
                  </tr>
                <tr>
                  <td height="28" colspan="2" background="../images/bottombg.jpg">&nbsp;</td>
                  </tr>
                <tr>
                  <td>
                  	<s:textarea id="messageContent" name="messageContent" cols="45" rows="3" theme="simple"></s:textarea>
                  </td>
                  <td align="center"><input name="addBtn2" type="submit" class="btn_4" id="addBtn2" value="提交">
                    <input name="addBtn3" type="reset" class="btn_4" id="addBtn3" value="清空" style="margin-top:5px"></td>
                </tr>
              </table></td>
              <td width="31%" valign="top" bgcolor="#FFFFFF"><table width="100%" height="396" border="0">
                <tr>
                  <td height="28" background="../images/bottombg.jpg"><strong>--<s:property value="forumIssueInfo.issueName"/>--</strong></td>
                  </tr>
                <tr>
                  <td height="87" align="left" valign="top" style="padding:5px;"><s:property value="forumIssueInfo.issueContent"/></td>
                  </tr>
                <tr>
                  <td height="28" background="../images/bottombg.jpg"><strong>--参与用户列表--</strong>&nbsp;</td>
                </tr>
                <tr>
                  <td height="205" valign="top" style="padding:5px;"><table width="78" border="0" height="140">
                  <%--<s:property value="joinPerson"/>--%>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
          </table></td>
        </tr>
        
    </table></td>
  </tr>
</table>
<s:property value="message"/>
</s:form>
</body>
</html>
