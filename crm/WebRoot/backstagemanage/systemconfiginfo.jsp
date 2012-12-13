<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author yangGY
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
		<title>公司信息管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/timepicke/jquery-ui-1.7.3.custom.css" />
		<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/timepicke/jquery-ui-timepicker-addon.css" />
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-1.7.3.custom.min.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-timepicker-addon.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-timepicker-zh-CN.js"></script>
		<script type="text/javascript" src="<%=path %>/js/timepicke/jquery-ui-sliderAccess.js"></script>
		<script type="text/javascript">
		/**
	  	 * 准备工作
	  	 */
		$(document).ready(function(){
			$.validator.setDefaults({
				debug: false,onkeyup: false,onfocusout:false,focusCleanup: true,
			    errorPlacement:function(error, element) {},
				invalidHandler: function(form, validator) {
		        	$.each(validator.invalid,function(key,value){
		            	alert(value);document.getElementById(key).focus();return false;
		        	}); 
		    	}
			})
			$.fn.save();
			$.fn.clearpart();
			$.fn.initpage();
	  	});
		/**
	  	 * 清理数据
	  	 */
		$.fn.save = function(){
			$("#addBtn").click(function() {
				if( confirm("该操作将清空数据库中所有表的数据，同时将数据库还原至初始状态，\n\n确定要进行此操作吗？") ){
					$("#tdmsg").html("数据库正在初始化，请稍候……");
					$("#addBtn").attr("disabled",true);
					form1.action = "systemConfigAction!initSystemData.action";
               		form1.submit();
				}
      		});
      	}
		/**
		 * 清理部分表
		 */
		$.fn.clearpart = function(){
			$("#clearBtn").click(function() {
				if( confirm("该操作将保留数据库中部分表数据，\n\n确定要进行此操作吗？") ){
					$("#tdmsg").html("数据库正在清理部分表的数据，请稍候……");
					$("#clearBtn").attr("disabled",true);
					form1.action = "systemConfigAction!clearPartData.action";
               		form1.submit();
				}
      		});
      	}
		/**
		 * 初始化
		 */
		$.fn.initpage = function(){
			<s:if test='message != ""'>
			$("#tdmsg").html("<s:property value="message"/>");
			</s:if>
		}
		</script>
	</head>

	<body>
		<form id="form1" name="form1" method="post" >
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td height="26" align="center" bgcolor="#FFFFFF" style="font-size:18pt;">
								<strong>系统配置</strong>
							</td>
						</tr>
						<tr>
							<td style="height: 36px;">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<tr>
										<td height="30" colspan="2" align="center" bgcolor="#FFFFFF" id="tdmsg" style="color:#ff0000">
											请点击下面按钮进行操作
										</td>
									</tr>
									<tr>
										<td height="50" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="addBtn" type="button" class="btn_5" id="addBtn" value="初始化数据库">
											&nbsp;&nbsp;
											<input name="clearBtn" type="button" class="btn_5" id="clearBtn" value="清理部分表">
											<!-- 
											&nbsp;&nbsp;
											<input name="closeBtn" type="button" class="btn_5" id="closeBtn" value="录入客户数据">
											 -->
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<iframe id="iframe1" name="iframe1" width="1px" height="1px"></iframe>
		</form>
	</body>
</html>
