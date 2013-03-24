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
  		$.fn.exportuser();
  		$.fn.importuser ();
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
	 * 导出用户
	 */
	 $.fn.exportuser = function(){
		$("#button1").click(function(){
			if( confirm("确定要导出当前部门所有用户吗？") ){
				form1.action = "./advancedAction!exportEkeyUser.action";
				form1.submit();
			}
		});
	}
		/**
		 * 导入用户
		 */
		 $.fn.importuser = function(){
			$("#button2").click(function(){
				if($("#uploadFile").val() == ""){
					alert("请选择您要导入的锁文件！");
					return false;
				}
				if( confirm("确定要导入所选的锁文件吗？") ){
					form2.action = "./advancedAction!importEkeyUser.action";
					form2.submit();
				}
			});
		}
	 /**
	 * 清除用户锁数据
	 */
	 $.fn.deleteitem = function(cid){
		if(confirm("确定要清除该用户的锁数据吗？")){
			$("#userId").val(cid);
			form1.action = "./advancedAction!clearEkeyData.action";
			form1.submit();
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


<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0" >
      <tr>
        <td>
        	<s:form id="form2" name="form2" method="post" theme="simple" enctype="multipart/form-data" target="iframe1">
        	<s:hidden name="companyId" id="companyId"></s:hidden>
			<s:hidden name="deptId" id="deptId"></s:hidden>
        	&nbsp;<input type="file" name="uploadFile" id="uploadFile" contenteditable="false" style="width:300px;">
            <input name="button2" type="button" class="btn_5" id="button2" value="开始导入锁数据" >
        	<input name="button1" type="button" class="btn_4" id="button1" value="导出公司用户">
            </s:form>
          </td>
      </tr>
    </table>
    <s:form id="form1" name="form1" method="post" theme="simple">
    <s:hidden name="companyId" id="companyId"></s:hidden>
	<s:hidden name="deptId" id="deptId"></s:hidden>
	<s:hidden name="userId" id="userId" value=""></s:hidden>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
            <tr>
              <td height="26" align="center" background="<%=path %>/images/headerbg.jpg">序号</td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>用户名</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>中文姓名</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>职务</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>用户类型</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>所属部门</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>身份锁SN</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>操作</strong></td>
            </tr>
            <s:iterator value="pagination.data" status="obj">
            <tr>
              <td height="26" align="center" bgcolor="#FFFFFF">
              		<s:property value="#obj.index+1"/>
              </td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="username"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="userCName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="roleName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="userTypeName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="dept.deptName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"  width="180px"><s:property value="ePassSN"/></td>
               <td height="26" align="center" bgcolor="#FFFFFF" width="110px">
              <!-- 
               <A href="#" onclick="javascript:$.fn.edit('<s:property value="id"/>');">编辑锁数据</A>
               -->	
               	<A href="#" onclick="javascript:$.fn.deleteitem('<s:property value="id"/>');">清除锁数据</A>
               </td>
            </tr>
            </s:iterator>
            <tr>
              <td height="26" colspan="8" align="center" bgcolor="#FFFFFF">
              		<p:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></p:pages>
              </td>
            </tr>
          </table>
          </s:form>
          </td>
        </tr>
      </table></td>
  </tr>
</table>
<iframe name="iframe1" id="iframe1" width="1px" height="1px"></iframe>
</body>
</html>
