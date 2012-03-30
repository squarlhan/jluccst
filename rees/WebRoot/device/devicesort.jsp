<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author JiangMD
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

		<title>设备排序</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
		<script type="text/javascript">
		jQuery(function(){
			var message = $("#lb_message").html();
			if(message!=null && $.trim(message)!="" ){
				$('#select-to option').attr("selected","");
				alert(message);
			}
			/**
			 * 上移所选
			 */
			$('#btn-up').bind('click', function() {
				$('#select-to option:selected').each( function() {
					var newPos = $('#select-to option').index(this) - 1;
					if (newPos > -1) {
						$('#select-to option').eq(newPos).before("<option value='"+$(this).val()+"' selected='selected'>"+$(this).text()+"</option>");
						$(this).remove();
					}
				});
			});
			
			/**
			 * 所选置顶
			 */
			$('#btn-top').bind('click', function() {
				$('#select-to option:selected').each( function(i) {
					$('#select-to option:first').before("<option value='"+$(this).val()+"' selected='selected'>"+$(this).text()+"</option>");
					$(this).remove();
				});
			});

			/**
			 * 下移所选
			 */
			$("#btn-down").click(function(){
				var countOptions = $('#select-to option').size();
				var $arr = $.makeArray($("#select-to option:selected"));
				$arr.reverse();
				$.each($arr,function() {
					var newPos = $('#select-to option').index(this) + 1;
					if (newPos < countOptions) {
						$('#select-to option').eq(newPos).after("<option value='"+$(this).val()+"' selected='selected'>"+$(this).text()+"</option>");
						$(this).remove();
					}
				});
			});
			
			/**
			 * 所选置底
			 */
			$('#btn-bottom').bind('click', function() {
				var countOptions = $('#select-to option').size();
				var $arr = $.makeArray($("#select-to option:selected"));
				$arr.reverse();
				$.each($arr,function(i) {
					$('#select-to option:last').after("<option value='"+$(this).val()+"' selected='selected'>"+$(this).text()+"</option>");
					$(this).remove();
				});
			});
			
			/**
			 * 关闭窗口
			 */
			$("#addBtn").click(function(){
				$('#select-to option').attr("selected","selected");
				form1.submit();
				//parent.$("#windown-close").click();
			});
			
			/**
			 * 关闭窗口
			 */
			$("#closeBtn").click(function(){
				var message = $("#lb_message").html();
				
				if(message!=null && $.trim(message)!="" ){
					//刷新
					//parent.$("iframe[name='mainFrame']").attr("src","datamanage/devicemanage.jsp");
					alert("先手动刷新列表吧！！！");
				}
				parent.$("#windown-close").click();
			});
		});
		</script>
	</head>

	<body>
		<s:form id="form1" theme="simple" action="toSortDeviceAction" >
		<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
		<center>
		<table width="250px" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0" cellspacing="6" cellpadding="0">
						<tr>
							<td>
								<table width="50%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<tr>
										<td align="right" bgcolor="#FFFFFF" rowspan="6" width="200px">
											<s:select id="select-to" name="ids" list="deviceInfoList" listKey="id" listValue="deviceName" multiple="true" size="20" cssStyle="width:220;"></s:select>
										</td>
										<td height="100px" align="left" bgcolor="#FFFFFF" width="50px">
										</td>
									</tr>
									<tr>
										<td align="left" bgcolor="#FFFFFF">
											<input name="btn-top" type="button" class="btn_2_3" id="btn-top" value="置顶">
										</td>
									</tr>
									<tr>
										<td align="left" bgcolor="#FFFFFF">
											<input name="btn-top" type="button" class="btn_2_3" id="btn-up" value="向上">
										</td>
									</tr>
									<tr>
										<td align="left" bgcolor="#FFFFFF">
											<input name="btn-top" type="button" class="btn_2_3" id="btn-down" value="向下">
										</td>
									</tr>
									<tr>
										<td align="left" bgcolor="#FFFFFF">
											<input name="btn-top" type="button" class="btn_2_3" id="btn-bottom" value="置底">
										</td>
									</tr>
									<tr>
										<td height="100px" align="left" bgcolor="#FFFFFF">
										</td>
									</tr>
									<tr>
										<td height="26" align="center" bgcolor="#FFFFFF" colspan="2">
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
		</center>
		</s:form>
	</body>
</html>
