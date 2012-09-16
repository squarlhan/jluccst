<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<%@ taglib prefix="page" uri="/page-tags"%> 
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>设备管理列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<j:scriptlink css="true" tipswindow="true" jmessagebox="true" jquery="true" validate="true"  jfunction="true"/>
	<style type="text/css">
	<!--
	.STYLE1 {
		color: #FFFFFF;
		font-weight: bold;
	}
	-->
	</style>
	<script type="text/javascript">
	(function($) {
	    // 看过jquery源码就可以发现$.fn就是$.prototype, 只是为了兼容早期版本的插件
	    // 才保留了jQuery.prototype这个形式
	    $.fn.mergeCell = function(options) {
	        return this.each(function() {
	            var cols = options.cols;
	            for ( var i = cols.length - 1; cols[i] != undefined; i--) {
	              // fixbug console调试
	              // console.debug(cols[i]);
	              mergeCell($(this), cols[i]);
	            }
	            dispose($(this));
	        });
	    };
	    // 如果对javascript的closure和scope概念比较清楚, 这是个插件内部使用的private方法
	    // 具体可以参考本人前一篇随笔里介绍的那本书
	    function mergeCell($table, colIndex) {
	 
	        $table.data('col-content', ''); // 存放单元格内容
	        $table.data('col-rowspan', 1);  // 存放计算的rowspan值  默认为1
	        $table.data('col-td', $());     // 存放发现的第一个与前一行比较结果不同td(jQuery封装过的), 默认一个"空"的jquery对象
	        $table.data('trNum', $('tbody tr', $table).length); // 要处理表格的总行数, 用于最后一行做特殊处理时进行判断之用
	         
	        // 我们对每一行数据进行"扫面"处理 关键是定位col-td, 和其对应的rowspan
	        $('tbody tr', $table).each(function(index) {
	            // td:eq中的colIndex即列索引
	            var $td = $('td:eq(' + colIndex + ')', this);
	 
	            // 取出单元格的当前内容
	            var currentContent = $td.html();
	 
	            // 第一次时走此分支
	            if ($table.data('col-content') == '') {
	 
	                $table.data('col-content', currentContent);
	                $table.data('col-td', $td);
	 
	            } else {
	                // 上一行与当前行内容相同
	                if ($table.data('col-content') == currentContent) {
	                    // 上一行与当前行内容相同则col-rowspan累加, 保存新值
	                    var rowspan = $table.data('col-rowspan') + 1;
	                    $table.data('col-rowspan', rowspan);
	                    // 值得注意的是  如果用了$td.remove()就会对其他列的处理造成影响
	                    $td.hide();
	 
	                    // 最后一行的情况比较特殊一点
	                    // 比如最后2行 td中的内容是一样的, 那么到最后一行就应该把此时的col-td里保存的td设置rowspan
	                    if (++index == $table.data('trNum'))
	                        $table.data('col-td').attr('rowspan', $table.data('col-rowspan'));
	             
	                } else { // 上一行与当前行内容不同
	                    // col-rowspan默认为1, 如果统计出的col-rowspan没有变化, 不处理
	                    if ($table.data('col-rowspan') != 1) {
	                        $table.data('col-td').attr('rowspan', $table.data('col-rowspan'));
	                    }
	                    // 保存第一次出现不同内容的td, 和其内容, 重置col-rowspan
	                    $table.data('col-td', $td); 
	                    $table.data('col-content', $td.html());
	                    $table.data('col-rowspan', 1);
	                }
	            }
	        });
	    }
	     
	    // 同样是个private函数  清理内存之用
	    function dispose($table) {
	        $table.removeData();
	    }
	})(jQuery);
	
	
		$(function(){
			$('#table1').mergeCell({
	            // 然后根据指定列来处理(合并)相同内容单元格
	            cols: [1]  
	        });
			
			$.fn.checkall("cbk_all");
			$.fn.uncheckall("ids","cbk_all");
			
			/**
	  		 * 修改设备信息
	  		 */
	  		$('a[name="add"]').each(function(){
	  			$(this).click(function(){
	  				var companyId = $("#hid_companyId").val();
					var factoryId = $("#hid_factoryId").val();
		  			var workshopId = $("#hid_workshopId").val();
		  			var param = "factoryId="+factoryId+"&workshopId="+workshopId +"&companyId=" + companyId;
	  				var url = $(this).attr("url")+"&"+param;
	  				parent.parent.tipsWindown("添加设备规则","iframe:"+url,"480","420","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
	  					var url = window.location.href;
	  					var array=url.split("?");
	  					url = array[0]+"?"+param;
						window.location.href=url;
					});
	  			});
	  		});
			
	  		/**
	  		 * 修改设备信息
	  		 */
	  		$('a[name="edit"]').each(function(){
	  			$(this).click(function(){
	  				var companyId = $("#hid_companyId").val();
					var factoryId = $("#hid_factoryId").val();
		  			var workshopId = $("#hid_workshopId").val();
		  			var param = "factoryId="+factoryId+"&workshopId="+workshopId +"&companyId=" + companyId;
	  				var url = $(this).attr("url")+"&"+param;
	  				parent.parent.tipsWindown("修改设备规则","iframe:"+url,"480","420","true","","true","no");
	  				parent.parent.$("#windown-close").bind('click',function(){
	  					var url = window.location.href;
	  					var array=url.split("?");
	  					url = array[0]+"?"+param;
						window.location.href=url;
					});
	  			});
	  		});
	  		
	  		/**
	  		 * 删除单个设备信息
	  		 */
	  		$('a[name="delete"]').each(function(){
	  			$(this).click(function(){
	  				var companyId = $("#hid_companyId").val();
		  			var factoryId = $("#hid_factoryId").val();
		  			var workshopId = $("#hid_workshopId").val();
		  			var param = "factoryId="+factoryId+"&workshopId="+workshopId +"&companyId=" + companyId;
	  				var url = $(this).attr("url");
	  				if(window.confirm("您确定要删除这条信息吗？")){
	  					$.post(url, "", function(data){
	  						url = window.location.href;
	  	  					var array=url.split("?");
	  	  					url = array[0]+"?"+param;
	  						window.location.href=url;
	  					});
	  				}
	  			});
	  		});
	  		
	  		/**
	  		 * 检查点维护
	  		 */
	  		$('a[name="edit_point"]').each(function(){
	  			$(this).click(function(){
	  				var url = $(this).attr("url");
	  				parent.parent.tipsWindown("监测点信息","iframe:"+url,"550","350","true","","true","no");
	  			});
	  		});
	  		
	  		/**
	  		 * 删除所选设备信息
	  		 */
	  		$("#deleteselectedbtn").click(function(){
	  			var companyId = $("#hid_companyId").val();
	  			var factoryId = $("#hid_factoryId").val();
	  			var workshopId = $("#hid_workshopId").val();
	  			var param = "factoryId="+factoryId+"&workshopId="+workshopId +"&companyId=" + companyId;
  				var url = "deleteDeviceAction.action";
  				if(window.confirm("您确定要删除所选信息吗？")){
  					$.post(url, $('#form1').serialize(), function(data){
  						url = window.location.href;
  	  					var array=url.split("?");
  	  					url = array[0]+"?"+param;
  						window.location.href=url;
  					});
  				}
	  		});
		});
		
	//-->
	</script>

  </head>
  
  <body>
	<s:form id="form1" name="form1" method="post" theme="simple" >
	<s:hidden id="hid_companyId" name="companyId"></s:hidden>
	<s:hidden id="hid_factoryId" name="factoryId"></s:hidden>
	<s:hidden id="hid_workshopId" name="workshopId"></s:hidden>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
            <input name="button" type="button" class="btn_4" id="deleteselectedbtn" value="删除所选">
        <td align="right"></td>
      </tr>
    </table>
      <table id="table1" width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
         <td  width="5%"  align="center"  background="<%=path %>/images/headerbg.jpg">  
   				<s:checkbox theme="simple" id="cbk_all" name="all"></s:checkbox>
   			</td>
   
		  <td width="15%" align="center" background="<%=path %>/images/headerbg.jpg"><strong>设备名称</strong></td>
          <td width="20%" align="center" background="<%=path %>/images/headerbg.jpg"><strong>设备类型</strong></td>
          <td width="20%" align="center" background="<%=path %>/images/headerbg.jpg"><strong>因子组合</strong></td>
		  <td width="10%" align="center" background="<%=path %>/images/headerbg.jpg"><strong>操作</strong></td>
        </tr>
        <s:iterator value="pagination.data" status="obj">
        <tr>
        	<td height="26" align="center" bgcolor="#FFFFFF" >  
				<s:checkbox id="%{id}" name="ids" fieldValue="%{id}" value="false" theme="simple"/>
			</td>
			<td height="26" align="center" bgcolor="#FFFFFF" nowrap>
          	   <s:property value="deviceName"/>&nbsp;
           </td>
          <td height="26" align="center" bgcolor="#FFFFFF" nowrap>
          	<s:property value="deviceTypeName"/>&nbsp;
          </td>
          <td height="26" align="center" bgcolor="#FFFFFF" nowrap>
          	<s:property value="pointStr"/>&nbsp;
          </td>
          <td height="26" colspan="2" align="center" bgcolor="#FFFFFF" nowrap>
          	<s:url id="add_url" action="openAddSpecialDeviceRuleAction">   
				<s:param name="ruleInfo.deviceId" value="deviceId"></s:param>   
			</s:url>
			<s:url id="edit_url" action="openModifyDeviceRuleInfoAction">   
				<s:param name="ruleInfo.id" value="id"></s:param>   
			</s:url>
			<s:url id="delete_url" action="deleteDeviceRuleInfoAction">   
				<s:param name="ids" value="id"></s:param>   
			</s:url>
			
			<a name="add" href="javascript:void(0);" url="${add_url}">添加</a>  
			<s:if test="id!=null">
         		<a name="edit" href="javascript:void(0);" url="${edit_url}">编辑</a>  
         	</s:if>
         	<s:if test="id!=null">
         		<a name="delete" href="javascript:void(0);" url="${delete_url}">删除</a>  
         	</s:if>
          </td>
        </tr>
        </s:iterator>
        
        <tr>
          <td height="26" colspan="9" align="center" bgcolor="#FFFFFF">
			<page:pages currentPage="pagination.currentPage" totalPages="pagination.totalPages" totalRows="pagination.totalRows" styleClass="page" theme="text" ></page:pages> 
		  </td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
