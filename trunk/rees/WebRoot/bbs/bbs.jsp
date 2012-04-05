<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author yangyj
 * @version 1.0
 * @audit  
 */
/**
 * Modified Person：
 * Modified Time：
 * Modified Explain：
 */
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>话题编辑</title>
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<script type="text/javascript">
			/**
		  	 * 验证条件
		  	 */
			var _forumIssueInfo_submit = {
				rules: {
					//"forumIssueInfo.forumIssueInfoNum":{},
					//"forumIssueInfo.forumIssueInfoType":{},
					//"forumIssueInfo.issueName":{required:true},
					//"forumIssueInfo.creator":{required:true}
					//"forumIssueInfo.forumIssueInfoModel":{},
					//"forumIssueInfo.forumIssueInfoFactory":{},
					//"forumIssueInfo.controlpoint":{digits:true}
				
				}
			};
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
		  		$.validator.setDefaults({
		  			//验证框架的验证器的默认设置区
					debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
				    errorPlacement:function(error, element) {},
					invalidHandler: function(form, validator) {
			        	$.each(validator.invalid,function(key,value){
			            	alert(value);document.getElementById(key).focus();return false;
			        	}); 
			    	}
				})
				$.fn.save();
		  		$.fn.close();
		  		$.fn.initpage();
		  	});
			/**
		  	 * 保存
		  	 */
			$.fn.save = function(){
				//如果有id就说明是修改action
				$("#addBtn").click(function() {
					var validate_settings_submit = jQuery.extend({}, _forumIssueInfo_submit);
	               	var validator = $("form").validate(validate_settings_submit);
	               	if(!validator.form()){
						return false;
					}
	               	var forumIssueInfoId = $("#hid_forumIssueInfoId").val();
	               	if( $.trim(forumIssueInfoId) == "" )
	               	{
	               		form1.action = "toAddForumIssueInfoAction.action";
	               	}
	               	else
	               	{
		               	form1.action = "toModifyForumIssueInfoAction.action";
	               	}
	               	form1.submit();
	           	});
          	}
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			parent.$("#windown-close").click();
		  		});
			}
			/**
			 * 初始化页面
			 */
			$.fn.initpage = function(){
				$("#txt_forumIssueInfoNum").focus();
			}
</script>
	</head>

	<body>
		<s:form id="form1"   theme="simple" >
		<s:hidden id="hid_forumIssueInfoId" name="forumIssueInfo.id"></s:hidden>
		<s:hidden id="hid_forumIssueCreator" name="forumIssueInfo.creator"></s:hidden>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>话题名称：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="forumIssueInfo.issueName" name="forumIssueInfo.issueName" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>话题内容：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="forumIssueInfo.issueContent" name="forumIssueInfo.issueContent" cssStyle="width: 250px;"></s:textfield>
										</td>
									</tr>
									<!-- tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>话题创建人：</strong>
										</td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<s:textfield id="forumIssueInfo.creator" name="forumIssueInfo.creator" cssStyle="width: 250px;" readOnly= "true"></s:textfield>
										</td>
									</tr> -->
									<tr>
										<td height="26" align="right" bgcolor="#FFFFFF">
											<strong>话题状态：</strong>
											
                                        </td>
										<td height="26" align="left" bgcolor="#FFFFFF">
											<select name="forumIssueInfo.issueStatus"   style="width:110px">
											   <option  value="1">进行中</option>
                                                <option  value="0">已结束</option>
                                                
                                               </select>
										</td>
									<tr>
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="确定">
											&nbsp;&nbsp;
											<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
										</td>
									</tr>
								</table>
							</td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
		</s:form>
	</body>
</html>
