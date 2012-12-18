<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" jmessagebox="true" jquery="true"
			tipswindow="true" validate="true" jfunction="true" />
		<script type="text/javascript">
			function btnSave_OnClick()
			{
				
					var oListbox = document.getElementById( "areaIds" );
					if( oListbox.length >0 )
					{
						for( var i = 0; i < oListbox.length; i++ )
						{
							oListbox.options[i].selected = true;
						}
						document.forms[0].action="saveAreaSort.action";
						document.forms[0].submit();
						
					}
					else
					{
						alert( "暂无可排序的内容！" );
					}
	
			}
			function btnTop_OnClick()
			{
				var oListbox = document.getElementById( "areaIds" );
				for( var i = 0; i < oListbox.length; i++ ) 
				{
					if( oListbox.options[i].selected )
					{
						if( oListbox.options[i].index == 0 )
						{
							break;
						}
						shiftTop( oListbox, oListbox.options[i].index );
					}
				}
			}
			function btnUp_OnClick()
			{
				var oListbox = document.getElementById( "areaIds" );
	
				for( var i = 0; i < oListbox.length; i++ ) 
				{
					if( oListbox.options[i].selected )
					{
						if( oListbox.options[i].index == 0 )
						{
							break;
						}
						shiftUp( oListbox, oListbox.options[i].index );
					}
				}
			}
			function btnDown_OnClick()
			{
				var oListbox = document.getElementById( "areaIds" );
				for( i = oListbox.length -1; i >= 0; i-- ) 
				{
					if( oListbox.options[i].selected )
					{
						var iIndex = oListbox.options[i].index;
						if( iIndex == oListbox.length -1 )
						{
							break;
						}
						shiftDown( oListbox, iIndex );
					}
				}
			}
			function btnBottom_OnClick()
			{
				var oListbox = document.getElementById( "areaIds" );
				for( i = oListbox.length -1; i >= 0; i-- ) 
				{
					if( oListbox.options[i].selected )
					{
						var iIndex = oListbox.options[i].index;
						if( iIndex == oListbox.length -1)
						{
							break;
						}
						shiftBottom( oListbox, iIndex );
					}
				}
			}
			
			function shiftUp( oListbox, iIndex )
			{
				
				if ( iIndex > 0 )
				{
					var oOption = oListbox.options[ iIndex ];
					var oPrevOption = oListbox.options[ iIndex - 1 ];
					oListbox.insertBefore( oOption,oPrevOption );
				}
				oListbox.focus();
			}
			function shiftDown( oListbox, iIndex )
			{
				if ( iIndex < oListbox.options.length -1 )
				{
					var oOption = oListbox.options[ iIndex ];
					var oNextOption = oListbox.options[ iIndex + 1 ];
					oListbox.insertBefore( oNextOption,oOption );
				}
				oListbox.focus();
			}
			function shiftTop( oListbox, iIndex )
			{
				if ( iIndex > 0 )
				{
					var oOption = oListbox.options[ iIndex ];
					var oTopOption = oListbox.options[ 0 ];
					oListbox.insertBefore( oOption,oTopOption );
				}
				oListbox.focus();
			}
			function shiftBottom( oListbox, iIndex )
			{
				if ( iIndex < oListbox.options.length  )
				{
					var oOption = oListbox.options[ iIndex ];
					var oBottomOption = oListbox.options[ oListbox.options.length ];
					oListbox.insertBefore( oOption,oBottomOption );
				}
				oListbox.focus();
			}
			/**
		  	 * 准备工作
		  	 */
			$(document).ready(function(){
				
				$.fn.close();
		  	});
			
			/**
			 * 关闭
			 */
		 	$.fn.close = function(){
		 		$("#closeBtn").click(function(){
		  			var message = $("#lb_message").html();
					if(message!=null && $.trim(message)!="" ){
					}
					parent.$("#windown-close").click();
		  		});
			};
			
		</script>
	</head>

	<body>
		<s:form id="form1" name="form1" method="post" theme="simple">
			<s:label id="lb_message" name="message" cssStyle="display:none"></s:label>
			<s:hidden id="typeFlag" name="typeFlag"></s:hidden>
			<s:hidden id="cityId" name="cityId"></s:hidden>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td style="padding: 0px;">
						<table border="0" width="100%" cellspacing="5" cellpadding="5">
							<tr>
								<td colspan="4" nowrap="nowrap">

										<table width="100%" border="0" cellpadding="0" cellspacing="5">
											<tr>
												<td align="right" nowrap>
													<span class="shadow"> 
													  <select id="areaIds" name="areaIds" size="17" style="width: 250;" multiple="multiple">
															<s:iterator id="info" value="areaList" status="stat">
																<option value="<s:property value='#info.id'/>">
																	<s:property value="#info.areaName" />
																</option>
															</s:iterator>
													  </select> 
													</span>
												</td>
												<td nowrap>
													<table width="100%" height="100%" border="0"
														cellpadding="0" cellspacing="0">
														<tr>
															<td align="right" valign="top">
																<table width="100%" border="0" cellspacing="0"
																	cellpadding="0">
																	<tr>
																		<td>
																			<input type="button" name="btnUp" value="↑置顶" onclick="btnTop_OnClick();"
																				class="btn_2_3">
																		</td>
																	</tr>
																	<tr>
																		<td height="8">
																			
																		</td>
																	</tr>
																	<tr>
																		<td>
																			<input type="button" name="btnUp2" value="↑向上" onclick="btnUp_OnClick();"
																				class="btn_2_3">
																		</td>
																	</tr>
																	<tr>
																		<td height="8">
																	
																		</td>
																	</tr>
																	<tr>
																		<td>
																			<input type="button" name="btnDown" value="↓向下" onclick="btnDown_OnClick();"
																				class="btn_2_3">
																		</td>
																	</tr>
																	<tr>
																		<td height="8">
																			
																		</td>
																	</tr>
																	<tr>
																		<td>
																			<input type="button" name="btnDown2" value="↓置底" onclick="btnBottom_OnClick();"
																				class="btn_2_3">
																		</td>
																	</tr>
																	<tr>
																		<td height="64">
																			&nbsp;
																		</td>
																	</tr>
																	<tr>
																		<td>
																			<input type="button" name="btnSave2" value="确定" onclick="btnSave_OnClick()"
																	class="btn_2_3"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="8">
																		
																	</td>
																	</tr>
																	<tr>
																		<td>
																			<input type="button" id="closeBtn" name="closeBtn" value="关闭" class="btn_2_3">
																		</td>
																	</tr>
																	<tr>
																		<td height="12">
																		&nbsp;
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
													</table>
												</td>
											</tr>
											
										</table>
									
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<s:if test="hasFieldErrors()">
				<s:iterator value="fieldErrors">
					<s:label id="lb_error" name="value[0]" cssStyle="display:none"></s:label>
				</s:iterator>
			</s:if>
		</s:form>
	</body>
</html>