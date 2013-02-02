<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	/**
	 * Copyright (c) 2005 Changchun HuaZhan (HuaZhan) Co. Ltd.
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
		<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true" />
	</head>
	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
			<s:hidden name="menuKey" id="menuKey"></s:hidden>
			<s:hidden name="companyId" id="companyId"></s:hidden>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td style="padding: 5px;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						</table>
						<table class="GridViewStyle" border="1"
							style="BORDER-COLLAPSE: collapse" rules=all cellspacing="0"
							cellpadding="0" width="100%">
							<tr class="HeaderStyle">
								<td nowrap="NOWRAP" style="padding: 0px;">
									<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#d5e4fd">
										<tr>
											<td background="../images/headerbg.jpg" height="26">
												&nbsp;拥有该操作权限的职务
											</td>
											<td align="right" style="padding: 3px;" background="../images/headerbg.jpg">
												<input type="button" name="selectRole" value="选择职务"
													class="btn_4"
													onClick="popedomOpen('./showAllRoleListAction.action?menuKey=<s:property value="menuKey"/>&companyId=<s:property value="companyId"/>','350','460')">
												<input type="button" name="deleteSelect" value="删除所选"
													class="btn_4" onClick="delinfo(0);">
												<input type="button" name="selectAll" value="全选"
													class="btn_2_3" onClick="checkall(this,0);">
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="AlternatingRowStyle">
								<td>
									<s:iterator value="roleList">
										<div class="fLeft" style="width: 150px;">
											<table border="0" cellspacing="5" cellpadding="0">
												<tr>
													<td width="10">
														<input type="checkbox" name="roleIds"
															value="<s:property value="id"/>" class="checkbox">
													</td>
													<td>
														<s:property value="roleName" />
													</td>
												</tr>
											</table>
										</div>
									</s:iterator>
								</td>
							</tr>
						</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="5"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
<script language="javascript">
<!--
function delinfo(n){
	var checkObj;
	checkObj = document.getElementsByName("roleIds");
	var checkFlag = false;
	for(var i=0; i<checkObj.length; i++){
		if(checkObj[i].checked){
			checkFlag = true;
			break;
		}
	}
	if(!checkFlag){
		alert("请选择要删除的信息！");
		return false;
	}
    if (confirm("确定要删除选中的信息吗？")){
       	form1.action="./deletePopedomAction.action";
        form1.submit();
    }
}
function popedomOpen(url,iwidth,iheight){
	/*
	var result = window.showModalDialog(url,'','status=no;dialogWidth=' + iwidth + 'px;dialogHeight=' + iheight + 'px;center=yes;help=no;')
	if(typeof(result)=="string"){
		window.location.href = "./showAllPopedomListAction.action?menuKey=<s:property value="menuKey"/>&companyId=<s:property value="companyId"/>";
	}
	*/
	parent.parent.parent.tipsWindown("选择职务","iframe:"+url,iwidth,iheight,"true","","true","no");
	parent.parent.parent.$("#windown-close").bind('click',function(){
		window.location.href = "./showAllPopedomListAction.action?menuKey=<s:property value="menuKey"/>&companyId=<s:property value="companyId"/>";
	});
}

function checkall(obj,n){
	var checkObj;
	checkObj = document.getElementsByName("roleIds");
	for(var i=0; i<checkObj.length; i++){
		if( checkObj[i].value!="0" && checkObj[i].disabled!=true ){
			if(obj.value != "全选"){
				checkObj[i].checked = false;
			}else{
				checkObj[i].checked = true;
			}
		}
	}
	if(obj.value == "全选"){
		obj.value = "取消";
	}else{
		obj.value = "全选";
	}
}
//-->
</script>

