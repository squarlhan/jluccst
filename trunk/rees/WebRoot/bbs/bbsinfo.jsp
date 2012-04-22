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
<body onload="document.getElementById('msg_end').click();">
<s:form id="form1" action="toAddForumMessageInfoAction.action">
<table width="100%" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="6" cellpadding="0">
        <tr>
          <td style="height:36px;"><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
            <tr>
              <td width="69%" valign="top" bgcolor="#FFFFFF"><table width="100%" border="0">
                <tr>
                  <td height="421" colspan="2" valign="top" style="padding:5px;">
                  <div style="height:420px;overflow-y:scroll;">
	                  <table width="100%" border="0" style="margin-top:10px;">
	                  <s:iterator value="pagination.data" status="obj">
	                  <tr>
	              			<td height="26" bgcolor="#FFFFFF">
		                       [<s:property value="messageTimeStr"/>]&nbsp;
		                       [<s:property value="publisherDept"/>]&nbsp;
		                       [<s:property value="publisher"/>]说：
		                       &nbsp; <s:property value="messageContent"/>
	             			 </td>
	                  </tr>
	                  </s:iterator>
	                  <tr><td>
	                  <a id="msg_end" name="1" href="#1">&nbsp;</a></td></tr>
	                    </table>
					</div>
				</td>
                  </tr>
                <tr>
                  <td height="28" colspan="2" background="../images/bottombg.jpg">&nbsp;</td>
                  </tr>
                <tr>
                  <td>
                  	<s:hidden id="hid_forumMessageInfoId" name="forumMessageInfo.issueId" value="%{issueId}"></s:hidden>
                  	<s:hidden id="hid_forumMessageInfoId" name="issueId" value="%{issueId}"></s:hidden>
                  	<s:textarea id="forumMessageInfo.messageContent" name="forumMessageInfo.messageContent" cols="85" rows="5" theme="simple"></s:textarea>
                  </td>
                  <td align="center"><input name="addBtn2" type="submit" class="btn_4" id="addBtn2" value="提交" onclick="if(document.all('forumMessageInfo.messageContent').value == '') return false;">
                    <input name="addBtn3" type="reset" class="btn_4" id="addBtn3" value="清空" style="margin-top:5px" onclick="document.all('forumMessageInfo.messageContent').value = '';"></td>
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
                   <s:iterator value="joinPersonList" status="of">  
			          <s:iterator value="top"><s:property />&nbsp;&nbsp;&nbsp;&nbsp;</s:iterator><br/>  
                    </s:iterator>  
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
          </table></td>
        </tr>
        
    </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
