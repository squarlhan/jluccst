<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	/**
	 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
	 * All right reserved.
	 */
	/**
	 * @author XXX
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
<title>添加论坛信息</title>
<link type="text/css" rel="stylesheet" href="../style.css" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		$("#closeBtn").click(function(){
			parent.$("#windown-close").click();
		});
	});
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
<s:form id="form1" action="toAddForumIssueInfoAction.action">
<table width="100%" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="6" cellpadding="0">
        <tr>
          <td style="height:36px;"><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

            <tr>
              <td width="69%" valign="top" bgcolor="#FFFFFF"><table width="100%" border="0">
                <tr>
                  <td height="321" colspan="2" valign="top" style="padding:5px;"><table width="100%" border="0" style="margin-top:10px;">
                    <tr>
                      <td class="STYLE1">这是一个技术问题，希望厂家能够派从来解决</td>
                    </tr>
                    <tr>
                      <td class="STYLE1"><strong>李四</strong>--二厂厂长　2012-2-16 11:12:25</td>
                    </tr>
                  </table>                    
                    <table width="100%" border="0" style="margin-top:10px;">
                      <tr>
                        <td class="STYLE1">这是一个技术问题，希望厂家能够派从来解决</td>
                      </tr>
                      <tr>
                        <td class="STYLE1"><strong>李四</strong>--二厂厂长　2012-2-16 11:12:25</td>
                      </tr>
                    </table>                    <p class="STYLE1">&nbsp;</p>                    </td>
                  </tr>
                <tr>
                  <td height="28" colspan="2" background="../images/bottombg.jpg">&nbsp;</td>
                  </tr>
                <tr>
                  <td>
                  	<s:textarea id="issueConteit" name="forumIssueInfo.issueConteit" cols="45" rows="3" theme="simple"></s:textarea>
                  </td>
                  <td align="center"><input name="addBtn2" type="submit" class="btn_4" id="addBtn2" value="提交">
                    <input name="addBtn3" type="reset" class="btn_4" id="addBtn3" value="清空" style="margin-top:5px"></td>
                </tr>
              </table></td>
              <td width="31%" valign="top" bgcolor="#FFFFFF"><table width="100%" height="396" border="0">
                <tr>
                  <td height="28" background="../images/bottombg.jpg"><strong>--通知公告--</strong></td>
                  </tr>
                <tr>
                  <td height="87" align="left" valign="top" style="padding:5px;"><p>请大家踊跃发言</p>                    </td>
                  </tr>
                <tr>
                  <td height="28" background="../images/bottombg.jpg"><strong>--在线用户--</strong></td>
                </tr>
                <tr>
                  <td height="205" valign="top" style="padding:5px;"><table width="100%" border="0">
                    <tr>
                      <td><span class="STYLE2"><strong>张三</strong>--一厂厂长</span></td>
                    </tr>
                    <tr>
                      <td><span class="STYLE2"><strong>李四</strong>--二厂厂长</span></td>
                    </tr>
                    <tr>
                      <td><span class="STYLE2"><strong>王五</strong>--三厂厂长</span></td>
                    </tr>
                    <tr>
                      <td><span class="STYLE2"><strong>沈六</strong>--四厂厂长</span></td>
                    </tr>
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
