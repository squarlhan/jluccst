<%@page import="com.boan.crm.utils.calendar.CurrentDateTime"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	response.setHeader( "Pragma", "No-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setHeader( "Expires", "0" );
	request.setCharacterEncoding( "utf-8" );
	String path = request.getContextPath();
	//2011年5月12日 星期六 四月初五
	StringBuffer sb = new StringBuffer();
	sb.append( CurrentDateTime.getCurrentDate());
	sb.append( "&nbsp;&nbsp;" );
	sb.append( CurrentDateTime.getCurrentWeek() );
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" jquery="true" jfunction="true" tipswindow="true"></j:scriptlink>
<SCRIPT language=javascript type=text/javascript>
	  function logout()
	  {
	      top.location.href="./logoutAction.action";
	  }
	  function myinfo()
	  {
		  parent.parent.tipsWindown("个人资料","iframe:./showMyInfoAction.action","400","525","true","","true","no");
	  }
	  function writeOpinion()
	  {
		  parent.parent.tipsWindown("提出意见","iframe:./suggestionAction!showInfo.action","600","320","true","","true","no");
		  parent.parent.$("#windown-close").bind('click', function() {
				window.open("./other/feedback/feedbackmanage.jsp","mainFrame");
		  });
	  }
	  function viewOpinion()
	  {
		  window.open("./other/feedback/opinionmanage.jsp","mainFrame");
	  }
	  function viewFeedback()
	  {
		  window.open("./other/feedback/feedbackmanage.jsp","mainFrame");
	  }
</SCRIPT>
<style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
-->
</style>
</head>
<body>
<table width="100%" height="85" border="0" cellpadding="0" cellspacing="0" id="__01">
  <tr>
    <td width="886"><img src="images/<s:property value="topImage"/>" width="886" height="85" alt=""></td>
    <td background="images/top_02.jpg">&nbsp;</td>
    <td width="138"><img src="images/top_03.jpg" width="138" height="85" alt=""></td>
  </tr>
  <tr>
    <td height="36" colspan="3" background="images/top_bg2.jpg" style="padding-left:20px;">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="20" style="padding-bottom:2px;"><img src="images/user.gif" width="16" height="16" /></td>
	        <td style="padding-top:2px;">
	        	<span class="STYLE1">
	        		今天是<%=sb.toString() %>  欢迎您：<s:property value="userCName"/>, 所在部门：<s:property value="fullGroupName"/>
	        	</span>
	        </td>
	        <td align="right" style="padding-top:2px; padding-right:10px;">
	        	<span class="STYLE1">
	        		<s:if test='isSuperUser!="true"'>
	        		[ <A href="javascript:writeOpinion();" style="color:yellow">提出意见</A> ]
	        		[ <A href="javascript:viewFeedback();" style="color:yellow">查看反馈</A> ]
	        		</s:if>
	        		<s:if test='isSuperUser=="true"'>
	        		[ <A href="javascript:viewOpinion();" style="color:yellow">意见反馈</A> ]
	        		</s:if>
	        		[ <A href="javascript:myinfo();" style="color:yellow">个人资料</A> ]
	        		[ <A href="./userLogonAction!showDesktop.action" style="color:yellow" target="mainFrame">首页</A> ]
	        		[ <A href="javascript:logout();" style="color:yellow">退出</A> ]
	        	</span>
	        </td>
	      </tr>
	    </table>
    </td>
  </tr>
</table>
</body>
</html>
