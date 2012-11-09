<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author zhuyf
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
	String param = "onlycustomer="+request.getParameter("onlycustomer");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<title>选择接收人</title>
		<j:scriptlink css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true" />
		<link type="text/css" rel="stylesheet" href="<%=basePath%>js/friendsuggest/ui.friendsuggest.css" />
		<script type="text/javascript" src="<%=basePath%>js/friendsuggest/ui.friendsuggest.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery.cookie.pack.js"></script>
		<script>

	  	$(function(){
	  		//创建客户选择控件
	  		var friends = new giant.ui.friendsuggest({
	            'totalSelectNum' : 10,
	            'ajaxUrl' : '<%=basePath%>loadCustomersAction.action?<%=param%>',
	            'ajaxLoadAllUrl' : '<%=basePath%>loadCustomersAction.action?<%=param%>',
	            'ajaxGetCountUrl' : '<%=basePath%>loadCustomersCountAction.action?<%=param%>',
	            'ajaxGetFriendTypeUrl' : '<%=basePath%>loadCustomersAction.action?<%=param%>'
	        });
	  		//指定一下struts2返回json对应的属性
	  		friends.ajaxFriendsDataOperate=function(data) {
            	return data.customersJsonStr;
         	};
         	//指定一下struts2返回json对应的属性
	  		friends.ajaxFriendsCountOperate=function(data) {
            	return data.customersCountJsonStr;
         	};
         	//指定一下struts2返回json对应的属性
	  		friends.ajaxFriendsTypeOperate=function(data) {
            	return data.customersTypeJsonStr;
         	};
         	//显示朋友选择框列表
         	friends._formartAllFriend();
	  		//处理选择后的人员
	  		$("#img_btn_yes").click(function(){
	  			var idArray=friends.getResult();
	  			if(idArray.length==0){
	  				alert("没有选择");
	  			}else{
	  				$.cookie('personIds',idArray); 
	  				parent.parent.$("#windown-close").click();
	  			}
	  		});
		});
	</script>
	</head>

	<body style="margin: 20px; width: 400px;">
		<div id="ui-fs" class="ui-fs clearfix">
			<input type="hidden" name="box1" class="ui-fs-result-box" />
			<div class="ui-fs-input clearfix">
				<div class="ui-fs-result clearfix">
					<input type="text" value="输入人员姓名(支持全拼输入)" maxlength="30" />
				</div>
				<!-- a class="ui-fs-icon" href="javascript:void(0)" title="查看所有好友">查看所有好友</a> -->
			</div>
			<div class="ui-fs-list">
				数据加载中....
			</div>
			<div class="ui-fs-all">
				<div class="top">
					<select id="ui-fs-friendtype">
						<option value="-1">
							所有人员
						</option>
					</select>
					<!-- div class="close" title="关闭">关闭</div> -->
					<img id="img_btn_yes" src="../js/friendsuggest/images/button-ok-01.png" title="确定" style="right: -6px;top: -20px;width: 50px;height: 50px; position: absolute;cursor: pointer;"/>
				</div>
				<div class="ui-fs-allinner">
					<div class="page clearfix">
						<div class="llight1">   
							还有<b></b>人可选
						</div>
						<div class="button">
							<span class="prev"> <strong>上一页</strong></span><span class="next"><strong>下一页</strong></span>
						</div>
					</div>
					<div class="list clearfix">
						数据加载中...
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
