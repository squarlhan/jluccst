<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"  import="java.util.Calendar"%>
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
<j:scriptlink css="true" tree="true"></j:scriptlink>
</head>
<body style="padding:5px;">
<div class="dtree">
  <!--a href="javascript: d.openAll();">展开</a> | <a href="javascript: d.closeAll();">关闭</a-->
  <script type="text/javascript">
		<!--
		d = new dTree('d','<%=path%>');
		d.add(0,-1,'<s:property value="companyName"/>','./openSellSalesPerformanceRankAction.action?companyId=<s:property value="companyId"/>&deptId=<s:property value="id"/>&statBeginDate=<%=Calendar.getInstance().get(Calendar.YEAR)+"-01-01"%>&statEndDate=<%=Calendar.getInstance().get(Calendar.YEAR)+"-12-31"%>','','groupmain');
		<s:iterator value="deptList">
			d.add("<s:property value="id"/>",0,'<s:property value="deptName"/>','./openSellSalesPerformanceRankAction.action?companyId=<s:property value="companyId"/>&deptId=<s:property value="id"/>&statBeginDate=<%=Calendar.getInstance().get(Calendar.YEAR)+"-01-01"%>&statEndDate=<%=Calendar.getInstance().get(Calendar.YEAR)+"-12-31"%>','','groupmain','<%=path%>/js/tree/img/group.gif','<%=path%>/js/tree/img/group.gif');
		</s:iterator>
		document.write(d);
		//-->
	</script>
</div>
</body>
</html>
