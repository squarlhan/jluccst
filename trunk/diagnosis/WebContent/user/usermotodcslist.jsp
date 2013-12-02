<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <%if(request.getSession().getAttribute("us")==null) 
  { 
  response.sendRedirect("user/userlogin.jsp"); 
   }  
                
   %>  
   
    <base href="<%=basePath%>">
    
    <title>DCS数据查看</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/diagnosis/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/diagnosis/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/diagnosis/css/demo.css">
    <script type="text/javascript" src="/diagnosis/js/jquery.min.js"></script>
    <script type="text/javascript" src="/diagnosis/js/jquery.easyui.min.js"></script>


  </head>
  
  <body>
	  <h2>DCS数据查询</h2>
	
 <table id="dg" style="width:1000px;height:500px" data-options="
                rownumbers:true,
                singleSelect:true,
                autoRowHeight:false,
                pagination:true,
                pageSize:20,
                loadMsg:'正在加载数据，请稍候……',
                url:'/diagnosis/dcsdataaction!showmotodcsdatas.action'">
        <thead>
            <tr>
                <th field="equipment" width="350">故障节点</th>
                <th field="item" width="300">控制参数</th>
                <th data-options="field:'value',width:300,align:'right',formatter:formatValue">参数值</th>
            </tr>
        </thead>
    </table>
    <script>
    function formatValue(val,row){
    	if(row.isok=="1"){
    		return '<span style="color:goldenrod;">('+val+')</span>';
		}else if(row.isok=="2"){
			return '<span style="color:chocolate;">('+val+')</span>';
		}else if(row.isok=="3"){
			return '<span style="color:red;">('+val+')</span>';
		}else{
			return val;
		}
    }
        function pagerFilter(data){
            if (typeof data.length == 'number' && typeof data.splice == 'function'){    // is array
                data = {
                    total: data.length,
                    rows: data
                }
            }
            var dg = $(this);
            var opts = dg.datagrid('options');
            var pager = dg.datagrid('getPager');
            pager.pagination({
                onSelectPage:function(pageNum, pageSize){
                    opts.pageNumber = pageNum;
                    opts.pageSize = pageSize;
                    pager.pagination('refresh',{
                        pageNumber:pageNum,
                        pageSize:pageSize
                    });
                    dg.datagrid('loadData',data);
                }
            });
            if (!data.originalRows){
                data.originalRows = (data.rows);
            }
            var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
            var end = start + parseInt(opts.pageSize);
            data.rows = (data.originalRows.slice(start, end));
            return data;
        }
             
        $(function(){
            $('#dg').datagrid({loadFilter:pagerFilter}).datagrid('loadData',motodcsdatalist.rows);
        });
    </script>
  </body>
</html>
