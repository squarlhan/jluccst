<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="p" uri="/page-tags"%>
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
<j:scriptlink css="true" jquery="true" jfunction="true" tipswindow="true"></j:scriptlink>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		
		$.fn.checkall("cbkAll");
		$.fn.uncheckall("userIds","cbkAll");
  		$.fn.deleteuser();
	});

	/**
	 * 添加修改
	 */
	$.fn.edit = function(cid){
		var param = "deptId="+$("#deptId").val() ;
		param += "&companyId="+$("#companyId").val();
		parent.parent.tipsWindown("用户信息","iframe:./userAction!showUser.action?user.id="+cid + "&" + param,"430","440","true","","true","no");
		parent.parent.$("#windown-close").bind('click',function(){
			window.location.href="./userAction!showUserList.action?" + param;
		});

	}
	
	/**
	 * 删除用户
	 */
	 $.fn.deleteuser = function(){
		$("#button2").click(function(){
			$.fn.delete_items("userIds", "./userAction!deleteUser.action");
		});
	}
	
	 /**
	 * 删除用户
	 */
	 $.fn.deleteitem = function(cid){
		if(confirm("确定要删除所选记录吗？")){
			$("#deleteId").val(cid);
			document.forms[0].action = "./userAction!delete.action";
			document.forms[0].submit();
		}
	}
	
//-->
</script>
<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
.STYLE2 {color: #FF0000}
-->
</style>
</head>
<body>
<s:form id="form1" name="form1" method="post" theme="simple">
<s:hidden name="companyId" id="companyId"></s:hidden>
<s:hidden name="deptId" id="deptId"></s:hidden>
<s:hidden name="deleteId" id="deleteId" value=""></s:hidden>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td><input name="button1" type="button" class="btn_2_3" id="button1" value="添加" onclick="$.fn.edit('')">
            <input name="button2" type="button" class="btn_4" id="button2" value="删除所选">
            <!-- 
            <input name="button3" type="button" class="btn_2_3" id="button" value="排序">
            <input name="button3" type="button" class="btn_2_3" id="button" value="锁定">
            <input name="button3" type="button" class="btn_2_3" id="button" value="解锁">
            <input name="button3" type="button" class="btn_4" id="button" value="初始化密码">
             -->
            </td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
            <tr>
              <td height="26" align="center" background="<%=path %>/images/headerbg.jpg"><input type="checkbox" name="cbkAll" value="true" id="cbkAll"/></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>用户名</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>中文姓名</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>办公电话</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>个人手机</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>职务</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>用户类型</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>操作</strong></td>
            </tr>
            <s:iterator value="pagination.data" status="obj">
            <tr>
              <td height="26" align="center" bgcolor="#FFFFFF">
               	<s:if test="id==sessionUserId">
         			<input type="checkbox" name="userIds" id="userId<s:property value="id"/>" value="<s:property value="id"/>" disabled="true" title="不能删除自己">
         		</s:if>
         		<s:else>
              		<input type="checkbox" name="userIds" id="userId<s:property value="id"/>" value="<s:property value="id"/>">
              	</s:else>
              </td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="username"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="userCName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="officePhone"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="phone"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="roleName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="userTypeName"/></td>
               <td height="26" align="center" bgcolor="#FFFFFF">
               	<A href="#" onclick="javascript:$.fn.edit('<s:property value="id"/>');">编辑</A>
               	<s:if test="id==sessionUserId">
         			<font color="#FF0000" title="不能删除自己">禁止删除</font>
         		</s:if>
         		<s:else>
               		<A href="#" onclick="javascript:$.fn.deleteitem('<s:property value="id"/>');">删除</A>
               	</s:else>
               </td>
            </tr>
            </s:iterator>
            <tr>
              <td height="26" colspan="8" align="center" bgcolor="#FFFFFF">
              		<p:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></p:pages>
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
