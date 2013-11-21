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
	    <script language="JavaScript" type="text/javascript">
    	
    	//下面开始分页      

        var perpage = 13;
    	var eques = new Array(
    			<s:iterator id="result" value="motodcsdatalist">
    				"<s:property value='#result.equipment'/>",
    			</s:iterator>
    		0);
    	var items = new Array(
    			<s:iterator id="result" value="motodcsdatalist">
    				"<s:property value='#result.item'/>",
    			</s:iterator>
    		0);
    	var bids = new Array(
    		    <s:iterator id="result" value="motodcsdatalist">
    			    "<s:property value='#result.value'/>",
    		    </s:iterator>
    	    0);
    	var isoks = new Array(
    		    <s:iterator id="result" value="motodcsdatalist">
    			    "<s:property value='#result.isok'/>",
    		    </s:iterator>
    	    0);
    	
    	function createrow(mytable,a)
    	{
    		var tr = mytable.insertRow(1);
    		if(a%2==1){
    			tr.style.backgroundColor="#ffffff";
    		}else{
    			tr.style.backgroundColor="#EDEDED";
    		}
    	    var td1 = tr.insertCell(-1);
    	    var td2 = tr.insertCell(-1);
    	    var td3 = tr.insertCell(-1);
			td1.align = "left";
			td2.align = "left";
			td3.align = "left";
			 if(isoks[a]=="1"){
    			td3.style.color="goldenrod";
    		}else if(isoks[a]=="2"){
    			td3.style.color="chocolate";
    		}else if(isoks[a]=="3"){
    			td3.style.color="red";
    		}else{
    			td3.style.color="black";
    		}
    	    td1.innerHTML = eques[a]+"&nbsp;";
    	    td2.innerHTML = items[a]+"&nbsp;";
    	    td3.innerHTML = "<b>"+bids[a]+"&nbsp;</b>";
    		}

    	function firstpage()
    	{
    		var mytable = document.getElementById("mytable");		
    		while(mytable.rows.length>1){
    			mytable.deleteRow(mytable.rows.length-1);
    		}
    		var stopnum;
    		if(bids.length<=perpage+1){
    			stopnum = bids.length-1;		
    		}else{
    			stopnum = perpage;			
    		}	
    		for(var a=0;a<stopnum;a++){
    			createrow(mytable,a);
    		}
    		var current = document.getElementById("current");
    		current.value = 1;
    		var sum = document.getElementById("sum");
    		sum.value = Math.ceil((bids.length-1)/perpage);
    		
    		var last = document.getElementById("last");
    		last.disabled=true;
    		var next = document.getElementById("next");
    		if(sum.value>1){
    			next.disabled=false;
    		}else{
    			next.disabled=true;
    		}
    		var myfinal = document.getElementById("final");
    		if(sum.value==0){
    			myfinal.disabled=true;
    		}
    		
    	}
    	function lastpage()
    	{
    		var current = document.getElementById("current").value;
    		var sum = document.getElementById("sum").value;
    		var mytable = document.getElementById("mytable");
    		while(mytable.rows.length>1){
    			mytable.deleteRow(mytable.rows.length-1);
    		}
    		var startnum = (current-2)*perpage;
    		var stopnum = (current-1)*perpage;	
    		if(current>=2){
    		    for(var a=startnum;a<stopnum;a++){
    		    	createrow(mytable,a);
    		    }
    		}
    		var next = document.getElementById("next");
    		next.disabled=false;		
    		var last = document.getElementById("last");
    		if(current==2){
    			last.disabled=true;
    		}else{			
    			last.disabled=false;
    		}
    		document.getElementById("current").value--;
    	}
    	function nextpage()
    	{
    		var current = document.getElementById("current").value;
    		var sum = document.getElementById("sum").value;
    		var mytable = document.getElementById("mytable");
    		while(mytable.rows.length>1){
    			mytable.deleteRow(mytable.rows.length-1);
    		}
    		var startnum = current*perpage;
    		var stopnum;
    		if(current==sum-1){
    			stopnum = bids.length-1;
    	    }else{
    	    	stopnum = startnum+perpage;
    	    }
    		for(var a=startnum;a<stopnum;a++){
    			createrow(mytable,a);
    		}
    		var last = document.getElementById("last");
    		last.disabled=false;		
    		var next = document.getElementById("next");
    		if(current==sum-1){
    			next.disabled=true;
    		}else{		
    			next.disabled=false;
    		}
    		document.getElementById("current").value++;
    	}
    	function finalpage()
    	{
    		var mytable = document.getElementById("mytable");
    		while(mytable.rows.length>1){
    			mytable.deleteRow(mytable.rows.length-1);
    		}
    		var sum = document.getElementById("sum").value;		
    		var startnum = (sum-1)*perpage;
    		for(var a=startnum;a<bids.length-1;a++){
    			createrow(mytable,a);
    			}	
    		document.getElementById("current").value = sum;
    		var last = document.getElementById("last");
    		if(sum!=1){
    			last.disabled=false;
    		}else{
    			last.disabled=true;
    		}
    		var next = document.getElementById("next");
    		next.disabled=true;
    	}
    	
    	
    </script>


  </head>
  
  <body>

     <div id="rightmain">
	  <h2>DCS数据查询</h2>
	
  <table bordercolor="#FFFFFF" id="mytable" class="list_table" align="center" >
		<tr bgcolor="#4A708B">
		    <th width = "35%">故障节点</th>
			<th width = "35%">控制参数</th>
			<th width = "30%">参数值</th>
	  </tr>
  </table>
   <div align="center">
       <input type="button" id="first" value="第一页" onclick="javascript:firstpage()"/>
       <input type="button" id="last" value="上一页" onclick="javascript:lastpage()"/>
       <input type="button" id="next" value="下一页" onclick="javascript:nextpage()"/>
       <input type="button" id="final" value="最后一页" onclick="javascript:finalpage()"/>
	       第<input align="MIDDLE" type="text" size="2" readonly="readonly" id="current"/>页 &nbsp;
	       共<input align="MIDDLE" type="text" size="2" readonly="readonly" id="sum"/>页
	</div>
</div>
  <script language="JavaScript" type="text/javascript">
     firstpage();
 </script>
  </body>
</html>
