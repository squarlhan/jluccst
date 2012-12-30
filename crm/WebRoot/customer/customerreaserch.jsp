<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/page-tags"%> 
<%
/**
 * Copyright (c) 2010 Changchun Boan (BOAN) Co. Ltd.
 * All right reserved.
 */
/**
 * @author Luojx
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
    <title>客户信息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true" jfunction="true"/>
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<script type="text/javascript">
	
		$(function(){
			
			if($("#message").html()!=null && $("#message").html()!=""){
				alert( $("#message").html());
			}
			
			$("#sel_province").change(function(){
				var provinceId =  $("#sel_province").val();
				var url = "getCityAction.action";
				if(provinceId!=""){
					$("#sel_city option").each(function(i){
						if(i!=0){
							$(this).remove();
						}
					});
					$.post(url, {provinceId:provinceId}, function(data){
						$.each(data,function(i,value){
							$("#sel_city").append("<option value="+value.id+">"+value.cityName+"</option>"); 
						});
					});
				}
			});
			$("#sel_city").change(function(){
				var cityId =  $("#sel_city").val();
				var url = "getAreaAction.action";
				if(cityId!=""){
					$("#sel_area option").each(function(i){
						if(i!=0){
							$(this).remove();
						}
					});
					$.post(url, {cityId:cityId}, function(data){
						$.each(data,function(i,value){
							$("#sel_area").append("<option value="+value.id+">"+value.areaName+"</option>"); 
						});
					});
				}
			});
			
			/**
	  		 * 转为客户信息
	  		 */
	  		 /*
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				$.post(url, {}, function(data){
						alert(data);
					});
	  			});
	  		});
			//*/
			/*
			$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				$("#form1").attr("action",url);
	  				$("#form1").submit();
	  			});
	  		});
			//*/
			$("#queryBtn").click(function(){
				if($.trim($("#txt_mainIndustry").val())==""){
					alert("请输入您要查询的主营行业信息！");
					return false;
				}
				if($.trim($("#sel_province").val())==""){
					alert("请选择您要查询的省份！");
					return false;
				}
				$("#form1").submit();
			});
			
			/**
	  		 * 不再客户信息
	  		 */
	  		 /*
	  		$('a[name="nosearch"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				$("#form1").attr("action",url);
	  				$("#form1").submit();
	  			});
	  		});
			//*/
		});
		
		function toCustomer(obj){
			var url = obj.attr("url");
			$("#form1").attr("action",url);
			$("#form1").submit();
		}
		
		function noSearch(obj){
			var url = obj.attr("url");
			$("#form1").attr("action",url);
			$("#form1").submit();
		}
		</script>

  </head>
  
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple" action="customerSearchAction.action">
 <s:label  name="message" id ="message" cssStyle="display:none"></s:label>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><fieldset >
		<legend>查询条件</legend>
   		<span>
			<table width="100%" border="0" cellpadding="5" cellspacing="0" bgcolor="#d5e4fd">
				<tr>
					<td height="26" align="right" bgcolor="#FFFFFF">
						<strong>主营行业：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_mainIndustry" name="mainIndustry" cssStyle="width:200px" ></s:textfield><font color="red">*</font>
					</td>
					<td height="26" align="right" bgcolor="#FFFFFF">
						<strong>省份</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:select id="sel_province"  name ="provinceId"  list="provinceList" listKey="id"  listValue="provinceName" cssStyle="width:100px" headerKey="" headerValue="--- 请选择 ---"></s:select><font color="red">*</font>
					</td>
					<td height="26" align="right" bgcolor="#FFFFFF">
						<strong>城市：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF"  >
						<s:select id="sel_city"  name ="cityId"  list="cityList" listKey="id"  listValue="cityName" cssStyle="width:100px" headerKey="" headerValue="--- 请选择 ---"></s:select>
					</td>
<%--					<td height="26" align="right" bgcolor="#FFFFFF">--%>
<%--						<strong>地区：</strong>--%>
<%--					</td>--%>
<%--					<td height="26" align="left" bgcolor="#FFFFFF"  >--%>
<%--						<s:select id="sel_area"  name ="areaId"  list="areaList" listKey="id"  listValue="areaName" cssStyle="width:100px" headerKey="" headerValue="--- 请选择 ---"></s:select>--%>
<%--					</td>--%>
					<td height="26" align="right" bgcolor="#FFFFFF" rowspan="2">
						<input name="queryBtn" type="button" class="btn_2_3" id="queryBtn" value="查询">
					</td>
				</tr>
			</table>
		</span>
		</fieldset>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd" style="margin-top:5px;">
        <tr>
         <td align="center" background="<%=basePath%>/images/headerbg.jpg">  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
              <td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>客户名称</strong></td>
              <td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')" nowrap="nowrap">主营行业</td>
              <td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')" nowrap="nowrap">联系人</td>
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')" nowrap="nowrap">公司电话</td>
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')" nowrap="nowrap">公司传真</td>
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')" nowrap="nowrap">详细地址</td>
            <td align="center" background="<%=basePath%>/images/headerbg.jpg" nowrap="nowrap"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
        <td height="26" align="center" bgcolor="#FFFFFF" >  
				<s:checkbox id="%{#obj.id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
			</td>
            <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="customerName"/></td>
            <td height="26" align="center" bgcolor="#FFFFFF">
				<s:property value="mainIndustry"/>
			</td>
            <td height="26" align="center" bgcolor="#FFFFFF">
	            <s:iterator value="contractPersonList" status="obj1">
	            	<s:property value="personName"/>&nbsp;
	            </s:iterator>
            </td>
            <td height="26" align="center" bgcolor="#FFFFFF">
				<s:iterator value="contractPersonList" status="obj1">
            		<s:property value="phone"/>&nbsp;<s:property value="tel"/>
            	</s:iterator>
			</td>
            <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="fax"/></td>
            <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="address"/></td>
	          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF"  nowrap="nowrap">
	          	<s:url id="edit_url" action="toCustomerAction.action">   
					<s:param name="customerLibInfo.id" value="id"></s:param>   
				</s:url>
				<s:url id="nosearch_url" action="toNoSearchCustomerAction.action">   
					<s:param name="customerLibInfo.id" value="id"></s:param>   
				</s:url>
	         	<a name="edit" href="javascript:void(0);" url="${edit_url}"  onclick="toCustomer($(this));return false;"><font color="green"><strong>转为客户</strong></font></a>  
	         	
	         	<a name="nosearch" href="javascript:void(0);" url="${nosearch_url}"  onclick="noSearch($(this));return false;"><font color="red"><strong>不再查询</strong></font></a>  
	          </td>
        </tr>
        </s:iterator>        
        <tr>
          <td height="26" colspan="11" align="center" bgcolor="#FFFFFF">
          	<s:if test="session.companyTrialFlag==1">
          	<span onmousemove="this.setCapture();" onmouseout="this.releaseCapture();" onfocus="this.blur();"  title="您当前使用的是试用版，不提供翻页功能！"> 
          		<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text"  url="customerSearchAction.action"></page:pages>
          	</span>
          	</s:if>
          	<s:else>
		  		<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text"  url="customerSearchAction.action"></page:pages>
		  	</s:else>
		  </td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
