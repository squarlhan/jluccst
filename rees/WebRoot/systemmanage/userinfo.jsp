<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" jquery="true"></j:scriptlink>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		$("#closeBtn").click(function(){
			parent.$("#windown-close").click();
		});
	});
//-->
</script>
</head>
<body>
<table width="100%" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="6" cellpadding="0">
        <tr>
          <td style="height:36px;"><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>用户编号：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield" id="textfield" style="width:250px;"></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>用户名：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield2" id="textfield2" style="width:250px;"></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>所在组：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield2" id="textfield3" style="width:250px;"></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>所属角色：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield3" id="textfield5" style="width:250px;"></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>状态：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox">
                选中为锁定</td>
            </tr>
            <tr>
              <td height="26" colspan="2" align="center" bgcolor="#FFFFFF"><input name="button" type="button" class="btn_2_3" id="addBtn" value="确定">
                <input name="addBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭"></td>
            </tr>
          </table></td>
        </tr>
        
    </table></td>
  </tr>
</table>
</body>
</html>
