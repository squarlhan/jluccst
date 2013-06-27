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
			
			$("#queryBtn").click(function(){
				$("#form1").attr("action","customerSearchForCompanyManagerAction.action");
				$("#form1").submit();
			});
			
			/**
	  		 * 标为重要客户
	  		 */
	  		$('a[name="setImportant"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				var flag = $(this).attr("flag");
	  				var msg = "您确定要将这条信息标为重要客户吗？";
	  				if(flag==1){
	  					msg = "您确定要将这条信息标为普通客户吗？";
	  				}
	  				if(window.confirm(msg)){
	  					//$.post(url, "", function(data){window.location.href=window.location.href;});
	  					$("#form1").attr("action",url);
	  					$("#form1").submit();
	  				}
	  			});
	  		});
			/**
	  		 * 分配客户
	  		 */
	  		$('a[name="assignSeller"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("分配客户","iframe:"+url,"600","360","true","","true","no");
	  				/*
					parent.parent.$("#windown-close").bind('click',function(){
						$("#form1").attr("action","customerSearchForCompanyManagerAction.action");
						$("#form1").submit();
					});
	  				//*/
	  			});
	  		});
			
	  		//如果有id就说明是修改action
			$("#importBtn").click(function() {
               	if(confirm("您确定上传文件么？上传文件时请耐心等待，不要关闭窗口！谢谢！"))
               	{
					form1.action = "importCustomerInCompanyAction.action";
	               	form1.submit();
				}
           	});
		});
		
		</script>

  </head>
  
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple" action="customerSearchForCompanyManagerAction.action" enctype="multipart/form-data">
 <s:label  name="message" id ="message" cssStyle="display:none"></s:label>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top">
    <fieldset >
		<legend>公司客户导入</legend>
   		<span>
			<table width="100%" border="0" cellpadding="5" cellspacing="0" bgcolor="#d5e4fd">
				<tr>
					<td height="26" width="120" align="right" bgcolor="#FFFFFF">
						<strong>选择文件：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:file name="uploadFile" id="uploadFile"  cssStyle="width:275px" /><font color="red">*</font>
						<input name="importBtn" type="button" class="btn_2_3" id="importBtn" value="导入">
					</td>
				</tr>
			</table>
		</span>
		</fieldset>
    <fieldset >
		<legend>查询条件</legend>
   		<span>
			<table width="100%" border="0" cellpadding="5" cellspacing="0" bgcolor="#d5e4fd">
				<tr>
					<td height="26" width="120" align="right" bgcolor="#FFFFFF">
						<strong>主营行业：</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:textfield id="txt_mainIndustry" name="mainIndustry" cssStyle="width:200px" ></s:textfield>
					</td>
					<td height="26" align="right" bgcolor="#FFFFFF">
						<strong>省份</strong>
					</td>
					<td height="26" align="left" bgcolor="#FFFFFF">
						<s:select id="sel_province"  name ="provinceId"  list="provinceList" listKey="id"  listValue="provinceName" cssStyle="width:100px" headerKey="" headerValue="--- 请选择 ---"></s:select>
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
			<td align="center" style="height: 26px; background-image:url('<%=basePath%>/images/headerbg.jpg')" nowrap="nowrap">重要客户</td>
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
            <td height="26" align="center" bgcolor="#FFFFFF" >
            <s:property value="important"/>
				<s:if test="importantFlag==1">
					<font color="red"><strong>是</strong></font>
				</s:if>
				 <s:else>
				 	否
				 </s:else>
			</td>
	          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF"  nowrap="nowrap">
				<s:url id="assignSeller_url" action="openAssignSellerAction.action">   
					<s:param name="customerLibInfo.id" value="id"></s:param>   
				</s:url>
				<s:url id="setImportant_url" action="toSetImportantAction.action">   
					<s:param name="customerLibInfo.id" value="id"></s:param>   
					<s:param name="isCommonly" value="importantFlag"></s:param>
				</s:url>
				<s:if test="importantFlag==1">
					<a name="setImportant" href="javascript:void(0);" url="${setImportant_url}" flag="${importantFlag}"><strong>标为普通客户</strong></a>  
				</s:if>
				<s:else>
		         	<a name="setImportant" href="javascript:void(0);" url="${setImportant_url}" flag="${importantFlag}"><strong>标为重要客户</strong></a>  
				 </s:else>
	         	<a name="assignSeller" href="javascript:void(0);" url="${assignSeller_url}"><font color="blue"><strong>分配业务员</strong></font></a>
	          </td>
        </tr>
        </s:iterator>        
        <tr>
          <td height="26" colspan="11" align="center" bgcolor="#FFFFFF">
		  	<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages>
		  </td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
