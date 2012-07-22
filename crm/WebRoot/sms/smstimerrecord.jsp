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
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>已发短信</title>
	<j:scriptlink  css="true" jmessagebox="true" jquery="true" tipswindow="true" validate="true"/>
	<script type="text/javascript">
	  	$(function(){
			
		});
	</script>
  </head>
  
  
  <body>
  <s:form>
	<fieldset >
		<legend>查询</legend>
		<span>
			<s:textfield id="txt_hello" maxlength="50" cssStyle="width: 200px;" value="您好！"/>
			<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="查询">
		</span>
	</fieldset>
    <table width="100%" height="50%"  border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
		<thead>
			<td align="center" width="50px" background="<%=basePath%>/images/headerbg.jpg">
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>接收人</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>手机号</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>公司</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>职务</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>昵称</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>发送状态</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>发送时间</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>发送内容</strong></td>
   			<td align="center" background="<%=basePath%>/images/headerbg.jpg"><strong>操作</strong></td>
		</thead>
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" bgcolor="#FFFFFF" >张三</td>
   			<td align="center" bgcolor="#FFFFFF" >13514332222</td>
   			<td align="center" bgcolor="#FFFFFF" >长白信息</td>
   			<td align="center" bgcolor="#FFFFFF" >经理</td>
   			<td align="center" bgcolor="#FFFFFF" >小甜甜</td>
   			<td align="center" bgcolor="#FFFFFF" >等待发送</td>
   			<td align="center" bgcolor="#FFFFFF" >2012-01-01 17:40</td>
   			<td align="center" bgcolor="#FFFFFF" >短信内容。。。</td>
   			<td align="center" bgcolor="#FFFFFF" >重新发送</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" bgcolor="#FFFFFF" >张三</td>
   			<td align="center" bgcolor="#FFFFFF" >13514332222</td>
   			<td align="center" bgcolor="#FFFFFF" >长白信息</td>
   			<td align="center" bgcolor="#FFFFFF" >经理</td>
   			<td align="center" bgcolor="#FFFFFF" >小甜甜</td>
   			<td align="center" bgcolor="#FFFFFF" >已经发送</td>
   			<td align="center" bgcolor="#FFFFFF" >2012-01-01 17:40</td>
   			<td align="center" bgcolor="#FFFFFF" >短信内容。。。</td>
   			<td align="center" bgcolor="#FFFFFF" >重新发送</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" bgcolor="#FFFFFF" >张三</td>
   			<td align="center" bgcolor="#FFFFFF" >13514332222</td>
   			<td align="center" bgcolor="#FFFFFF" >长白信息</td>
   			<td align="center" bgcolor="#FFFFFF" >经理</td>
   			<td align="center" bgcolor="#FFFFFF" >小甜甜</td>
   			<td align="center" bgcolor="#FFFFFF" >常规短信</td>
   			<td align="center" bgcolor="#FFFFFF" >2012-01-01 17:40</td>
   			<td align="center" bgcolor="#FFFFFF" >短信内容。。。</td>
   			<td align="center" bgcolor="#FFFFFF" >重新发送</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" bgcolor="#FFFFFF" >张三</td>
   			<td align="center" bgcolor="#FFFFFF" >13514332222</td>
   			<td align="center" bgcolor="#FFFFFF" >长白信息</td>
   			<td align="center" bgcolor="#FFFFFF" >经理</td>
   			<td align="center" bgcolor="#FFFFFF" >小甜甜</td>
   			<td align="center" bgcolor="#FFFFFF" >常规短信</td>
   			<td align="center" bgcolor="#FFFFFF" >2012-01-01 17:40</td>
   			<td align="center" bgcolor="#FFFFFF" >短信内容。。。</td>
   			<td align="center" bgcolor="#FFFFFF" >重新发送</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" bgcolor="#FFFFFF" >张三</td>
   			<td align="center" bgcolor="#FFFFFF" >13514332222</td>
   			<td align="center" bgcolor="#FFFFFF" >长白信息</td>
   			<td align="center" bgcolor="#FFFFFF" >经理</td>
   			<td align="center" bgcolor="#FFFFFF" >小甜甜</td>
   			<td align="center" bgcolor="#FFFFFF" >常规短信</td>
   			<td align="center" bgcolor="#FFFFFF" >2012-01-01 17:40</td>
   			<td align="center" bgcolor="#FFFFFF" >短信内容。。。</td>
   			<td align="center" bgcolor="#FFFFFF" >重新发送</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" bgcolor="#FFFFFF" >张三</td>
   			<td align="center" bgcolor="#FFFFFF" >13514332222</td>
   			<td align="center" bgcolor="#FFFFFF" >长白信息</td>
   			<td align="center" bgcolor="#FFFFFF" >经理</td>
   			<td align="center" bgcolor="#FFFFFF" >小甜甜</td>
   			<td align="center" bgcolor="#FFFFFF" >常规短信</td>
   			<td align="center" bgcolor="#FFFFFF" >2012-01-01 17:40</td>
   			<td align="center" bgcolor="#FFFFFF" >短信内容。。。</td>
   			<td align="center" bgcolor="#FFFFFF" >重新发送</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" bgcolor="#FFFFFF" >张三</td>
   			<td align="center" bgcolor="#FFFFFF" >13514332222</td>
   			<td align="center" bgcolor="#FFFFFF" >长白信息</td>
   			<td align="center" bgcolor="#FFFFFF" >经理</td>
   			<td align="center" bgcolor="#FFFFFF" >小甜甜</td>
   			<td align="center" bgcolor="#FFFFFF" >常规短信</td>
   			<td align="center" bgcolor="#FFFFFF" >2012-01-01 17:40</td>
   			<td align="center" bgcolor="#FFFFFF" >短信内容。。。</td>
   			<td align="center" bgcolor="#FFFFFF" >重新发送</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" bgcolor="#FFFFFF" >张三</td>
   			<td align="center" bgcolor="#FFFFFF" >13514332222</td>
   			<td align="center" bgcolor="#FFFFFF" >长白信息</td>
   			<td align="center" bgcolor="#FFFFFF" >经理</td>
   			<td align="center" bgcolor="#FFFFFF" >小甜甜</td>
   			<td align="center" bgcolor="#FFFFFF" >常规短信</td>
   			<td align="center" bgcolor="#FFFFFF" >2012-01-01 17:40</td>
   			<td align="center" bgcolor="#FFFFFF" >短信内容。。。</td>
   			<td align="center" bgcolor="#FFFFFF" >重新发送</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" bgcolor="#FFFFFF" >张三</td>
   			<td align="center" bgcolor="#FFFFFF" >13514332222</td>
   			<td align="center" bgcolor="#FFFFFF" >长白信息</td>
   			<td align="center" bgcolor="#FFFFFF" >经理</td>
   			<td align="center" bgcolor="#FFFFFF" >小甜甜</td>
   			<td align="center" bgcolor="#FFFFFF" >常规短信</td>
   			<td align="center" bgcolor="#FFFFFF" >2012-01-01 17:40</td>
   			<td align="center" bgcolor="#FFFFFF" >短信内容。。。</td>
   			<td align="center" bgcolor="#FFFFFF" >重新发送</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#FFFFFF" >  
				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
			</td>
   			<td align="center" bgcolor="#FFFFFF" >张三</td>
   			<td align="center" bgcolor="#FFFFFF" >13514332222</td>
   			<td align="center" bgcolor="#FFFFFF" >长白信息</td>
   			<td align="center" bgcolor="#FFFFFF" >经理</td>
   			<td align="center" bgcolor="#FFFFFF" >小甜甜</td>
   			<td align="center" bgcolor="#FFFFFF" >常规短信</td>
   			<td align="center" bgcolor="#FFFFFF" >2012-01-01 17:40</td>
   			<td align="center" bgcolor="#FFFFFF" >短信内容。。。</td>
   			<td align="center" bgcolor="#FFFFFF" >重新发送</td>
		</tr>
		
	</table>
	 </s:form>
  </body>
</html>
