<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" jquery="true" tab="true"/>
<script type="text/javascript">
<!--
$(function(){ 
		$("#all").change(function(){
			if($("#customer").val()=='on'){
				$("#province").attr('disabled',false);
				$("#city").attr('disabled',false);
				$("#area").attr('disabled',false);
				$("#categoryId").attr('disabled',false);
				$("#progress").attr('disabled',false);
			}
		});
		$("#customer").change(function(){
			if($("#customer").val()=='on'){
				$("#province").attr('disabled',false);
				$("#city").attr('disabled',false);
				$("#area").attr('disabled',false);
				$("#categoryId").attr('disabled',false);
				$("#progress").attr('disabled',false);
			}
		});
		$("#seller").change(function(){
			if($("#seller").val()=='on'){
				$("#province").attr('disabled',true);
				$("#city").attr('disabled',true);
				$("#area").attr('disabled',true);
				$("#categoryId").attr('disabled',true);
				$("#progress").attr('disabled',true);
			}
		});
	
		$("#province").change(function() {
	        loadCity($("#province").val());
	    });
		$("#city").change(function() {
	        loadArea($("#city").val());
	    });
	
	$("#addBtn").click(function(){
		var queryType;
		var queryProvince=$("#province").val()==null ? '' : $("#province").val() ;
		var querycCity=$("#city").val() ==null ? '' : $("#city").val() ;
		var queryArea=$("#area").val() ==null ? '' : $("#area").val() ;
		var queryCategoryId=$("#categoryId").val() ==null ? '' : $("#categoryId").val() ;
		var queryProgress=$("#progress").val()==null ? '' : $("#progress").val() ;
		
		if(($("#customer").attr("checked")==true) && ($("#seller").attr("checked")==true)){
			queryType="all";
		}else{
			if($("#all").attr("checked")==true){
				queryType="all";
			}else if($("#customer").attr("checked")==true){
				queryType="customer";
			}else	if($("#seller").attr("checked")==true){
				queryType="seller";
			}
		}
		parent.parent.parent.setPerson(queryType,queryProvince,querycCity,queryArea,queryCategoryId,queryProgress);
		parent.parent.parent.$("#windown-close").click();
	});
	$("#closeBtn").click(function(){
		parent.parent.$("#windown-close").click();
	});
});
function loadCity(parentid) {
    $.ajax({
        url:"<%=basePath%>datadictionary/cityinfoservice.action?provinceId=" + parentid,
        type: 'POST',
        dataType: 'JSON',
        timeout: 5000,
        error: function() { alert('Error loading data!'); },
        success: function(msg) {
            $("#city").empty();
            $("<option value=''>--请选择--</option>").appendTo($("#city"));
            $.each(eval(msg), function(i, item) {
                $("<option value='" + item.id + "'>" + item.name + "</option>").appendTo($("#city"));
            });
            
            //loadArea($("#city").val());
        }
    });
}
function loadArea(parentid) {
    $.ajax({
        url:"<%=basePath%>datadictionary/areainfoservice.action?cityId=" + parentid,
        type: 'POST',
        dataType: 'JSON',
        timeout: 5000,
        error: function() { alert('Error loading data!'); },
        success: function(msg) {
            $("#area").empty();
            $("<option value=''>--请选择--</option>").appendTo($("#area"));
            $.each(eval(msg), function(i, item) {
                $("<option value='" + item.id + "'>" + item.name + "</option>").appendTo($("#area"));
            });
        }
    });
}
//-->
</script>
<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>
</head>
<body>
<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
		<tr>
		<td align="right" bgcolor="#FFFFFF" nowrap="nowrap">人员类型：</td>
			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap">
				<input  type="radio"  name="aa"  id="all" checked="checked">全部
				<input type="radio" name="aa"  id="customer">客户
				<input type="radio" name="aa"  id="seller">工作人员
			</td>
		</tr>
		<tr>
			<td align="right" bgcolor="#FFFFFF" nowrap="nowrap">所 在 地：</td>
			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap" >
				<s:select list="listProvince" listKey="id" listValue="provinceName"  id="province"  cssStyle="width:80px" headerKey="" headerValue="请选择"></s:select>
				<select id="city"  style="width:120px"></select>
				<select id="area" style="width:120px"></select>
			</td>
		</tr>
		<tr>
			<td align="right" bgcolor="#FFFFFF" nowrap="nowrap">客户分类：</td>
			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap">
				<s:select list="listCategory" listKey="id" listValue="name"  id="categoryId"  cssStyle="width:330px" headerKey="" headerValue="--请选择--"></s:select>
			</td>
			</tr>
			<tr>
			<td align="right" bgcolor="#FFFFFF" nowrap="nowrap">业务进展：</td>
			<td align="left" bgcolor="#FFFFFF" nowrap="nowrap">
				<s:select list="listProgress" listKey="id"
					listValue="name" value="customerInfo.province"
					id="progress" name="customerInfo.province"
					cssStyle="width:330px" headerKey="" headerValue="--请选择--"></s:select>
			</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#FFFFFF" nowrap="nowrap" colspan="20">
			<input name="addBtn" type="button" class="btn_2_3" id="addBtn" value="确定">
			&nbsp;&nbsp;
			<input name="closeBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭">
			</td>
		</tr>
	</table>
</body>
</html>
