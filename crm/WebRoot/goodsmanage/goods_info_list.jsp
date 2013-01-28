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
    <title></title>
    
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
			
			$("#addbtn").click(function(){
				parent.parent.tipsWindown("添加产品信息","iframe:<%=path%>/goodsmanage/goodsinfobaseinfo.action?infoId=&typeId="+$("#typeId").val(),"460","300","true","","true","no");
				parent.parent.$("#windown-close").bind('click',function(){
					window.location.href="<%=path%>/goodsmanage/goodsinfobaselist.action?typeId="+$("#typeId").val();
					window.open("<%=path %>/goodsmanage/goodstypetreeview.action","goodstree");
				});
		
			});
			$.fn.checkall("cbk_all");
	  		$.fn.uncheckall("ids","cbk_all");

	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("修改产品信息","iframe:"+url +"&typeId="+$("#typeId").val(),"460","300","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
	  					window.location.href="<%=path%>/goodsmanage/goodsinfobaselist.action?typeId="+$("#typeId").val();
	  					window.open("<%=path %>/goodsmanage/goodstypetreeview.action","goodstree");
					});
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个信息
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				if(window.confirm("您确定要删除这条信息吗？")){
	  					$.post(url, "", function(data){
	  						window.location.href=window.location.href;
	  						window.open("<%=path %>/goodsmanage/goodstypetreeview.action","goodstree");
	  					});
	  				}
	  			});
	  		});
	  		
	  		/**
	  		 * 删除所选设备信息
	  		 */
	  		$("#deletepointbtn").click(function(){
  				var url = "<%=path%>/goodsmanage/delgoodsinfobase.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){
  						window.location.href=window.location.href;
  						window.open("<%=path %>/goodsmanage/goodstypetreeview.action","goodstree");	
  					});
  				}
	  		});
		});
	</script>

  </head>
  
  
  <body>
 <s:form id="form1" name="form1" method="post" theme="simple">
 <s:hidden name="typeId" id="typeId"></s:hidden>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
       		<input name="addbtn" type="button" class="btn_2_3" id="addbtn" value="添加" >
            <input name="deletepointbtn" type="button" class="btn_4" id="deletepointbtn" value="删除所选">
        <td align="right"></td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
         <td align="center" background="<%=path %>/images/headerbg.jpg">  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>商品名称</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>规格</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>厂家</strong></td>
              <td align="center" background="<%=path %>/images/headerbg.jpg"><strong>价格</strong></td>
              <td align="center" colspan="2" background="<%=path %>/images/headerbg.jpg"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
        <td height="26" align="center" bgcolor="#FFFFFF" >  
        		<s:checkbox id="%{#obj.id}" name="infoIds" fieldValue="%{id}" value="false" theme="simple"/>
			</td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="name"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="goodsStandard"/></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><s:property value="factoryName"/></td>
              <td height="26" align="center" bgcolor="#FFFFFF"><s:property value="goodsPrice"/></td>
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
          	<s:url id="edit_url" action="goodsinfobaseinfo">   
				<s:param name="infoId" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="delgoodsinfobase">   
				<s:param name="infoIds" value="id"></s:param>   
			</s:url>
         	<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>  
       		<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>
          </td>
        </tr>
        </s:iterator>
        <tr>
          <td height="26" colspan="7" align="center" bgcolor="#FFFFFF">
			<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		   
		  </td>
        </tr>     
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
