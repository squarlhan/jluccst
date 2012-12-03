<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	//错误信息代码
	String errorCode = StringUtils.trimToEmpty( request.getParameter( "errorCode" ) );
	//英文错误
	String enMessage = ""; 
	//中文错误
	String cnMessage = "";
	//样式
	String styleClass = "";
	//（0000）默认出错信息
	if( StringUtils.isBlank( errorCode ) )
	{
		cnMessage = "您所请求的资源不可用！";
		enMessage = "The requested resource is not available.";
		styleClass = "error";
	}else if( errorCode.equals("noSubSystem") )
	{
		cnMessage = "您没有可用的系统和功能，请联系管理员！";
		enMessage = "Sorry,you do not have systems and functions that are available,please contact the administrator!";
		styleClass = "error";
	}else if( errorCode.equals("noUnitOrDept") )
	{
		cnMessage = "您当前所在单位和部门已经被删除或锁定，请联系管理员！";
		enMessage = "Your units and departments have been deleted or locked out, please contact the administrator.";
		styleClass = "error";
	}else if( errorCode.equals("userIsNull") )
	{
		cnMessage = "当前用户已被删除或锁定，请联系管理员！";
		enMessage = "Current user has been deleted or locked out, please contact the administrator.";
		styleClass = "error";
	}
	else if( errorCode.equals("noPopedom") )
	{
		cnMessage = "您没有权限访问，请联系管理员！";
		enMessage = "Sorry, you do not have permission to access, please contact the administrator.";
		styleClass = "error";
	}
	else if( errorCode.equals("noFile") )
	{
		cnMessage = "文件不存在！";
		enMessage = "Sorry, the file not exist.";
		styleClass = "error";
	}
	else if( errorCode.equals("isNotCountryDept") )
	{
		cnMessage = "请选择乡镇！";
		enMessage = "please select a country dept.";
		styleClass = "error";
	}
	else if( errorCode.equals("notCountryDept") )
	{
		cnMessage = "您当前所在部门不是乡镇部门！";
		enMessage = "Your department isn't a country dept.";
		styleClass = "error";
	}
	else if( errorCode.equals("noCountryDeptCode") )
	{
		cnMessage = "您当前所在部门没有乡镇编号！";
		enMessage = "Your department didn't have code of country dept.";
		styleClass = "error";
	}else if( errorCode.equals("userNotLogin") )
	{
		cnMessage = "单点登录失败，该用户未在门户登录，请确认用户登录是否过期！";
		enMessage = "Single sign - on fails, the user is not in the Portal login, please confirm that the user login has expired.";
		styleClass = "error";
	}else if( errorCode.equals("notUserSSO") )
	{
		cnMessage = "单点登录被禁用，请启用单点登录！";
		enMessage = "Single sign - on is disabled, enable single sign on.";
		styleClass = "error";
	}else if( errorCode.equals("SSOError") )
	{
		cnMessage = "单点登录异常，请联系长白公司人员！";
		enMessage = "Single sign - on exception, please contact changbai company personnel.";
		styleClass = "error";
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误信息</title>
<uitag:csslink></uitag:csslink>
<style type="text/css">
	<!--
	.prominence {color: #FF0000}
	-->
</style>
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center"><table border="0" cellspacing="0" cellpadding="0" width="60%">
      <tr>
        <td><table border="0" cellspacing="0" cellpadding="0" class="GridViewStyle">
          <tr class="FooterStyle">
            <td align="center" style="height:180px;">
            <span class="prominence">
              <div class="<%=styleClass%>"></div>
             <br>
              <strong>
				<%=cnMessage %>
             	<br>
             	<%=enMessage %>
              </strong>
              </span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
