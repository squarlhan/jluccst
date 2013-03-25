<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
		d.add(0,-1,'<s:property value="commpanyName"/>公司产品','./openMarketInquiryListForViewAction.action?companyId=<s:property value="commpanyId"/>&goodsId=<s:property value="id"/>&who=session','','groupmain');
		<s:iterator value="goodsList">
			d.add('<s:property value="id"/>','<s:property value="fatherId"/>','<s:property value="name"/>','./openMarketInquiryListForViewAction.action?companyId=<s:property value="commpanyId"/>&goodsId=<s:property value="id"/>&who=session','','groupmain','<%=path%>/js/tree/img/folder.gif');
		</s:iterator>
		document.write(d);
		d.openAll();
		//-->
	</script>
</div>
</body>
</html>
