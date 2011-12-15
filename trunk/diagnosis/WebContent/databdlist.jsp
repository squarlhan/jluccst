<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <%if(request.getSession().getAttribute("pr")==null) 
  { 
  response.sendRedirect("prof/proflogin.jsp"); 
   }  
                
   %>  
   
    <base href="<%=basePath%>">
    
    <title>参数描述维护</title>
    <script language="JavaScript" type="text/javascript">
    	function confirmDel(){
			return confirm("确定删除？");	
    	}
    	function confirmChge(did){
			if(confirm("确认修改？")){
				var upper = document.getElementById("upper["+did+"]");
				var lower = document.getElementById("lower["+did+"]");
				var url = "dcsdscribaction!chDscrib.action?dcsDscrib.lower="+lower.value+"&dcsDscrib.upper="+upper.value+"&dcsDscrib.did="+did;
				location.href = url; 
				//return true;
			}
			//return false;
			
    	}
    	
    	//下面开始分页
      	 
        var perpage = 13;
        var names = new Array(
    			<s:iterator id="result" value="dcsdscriblist">
    				"<s:property value='#result.name'/>",
    			</s:iterator>
    		0);
    	var eques = new Array(
    			<s:iterator id="result" value="dcsdscriblist">
    				"<s:property value='#result.eque'/>",
    			</s:iterator>
    		0);
    	var items = new Array(
    			<s:iterator id="result" value="dcsdscriblist">
    				"<s:property value='#result.item'/>",
    			</s:iterator>
    		0);
    	var uppers = new Array(
    			<s:iterator id="result" value="dcsdscriblist">
    				"<s:property value='#result.upper'/>",
    			</s:iterator>
    		0);
    	var lowers = new Array(
    			<s:iterator id="result" value="dcsdscriblist">
    				"<s:property value='#result.lower'/>",
    			</s:iterator>
    		0);
    	var bids = new Array(
    		    <s:iterator id="result" value="dcsdscriblist">
    			    "<s:property value='#result.did'/>",
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
    	    var td4 = tr.insertCell(-1);
    	    var td5 = tr.insertCell(-1);
    	    var td6 = tr.insertCell(-1);
    	    var urlc = "javascript:confirmChge("+bids[a]+");";
    	    var urld = "dcsdscribaction!deleteDscrib?dcsDscrib.did="+bids[a];
			var ac = document.createElement("a");
			var ad = document.createElement("a");
			ac.innerHTML = "修改&nbsp;&nbsp;";
			ad.innerHTML = "&nbsp;&nbsp;删除";
			ac.href = urlc;
			ad.href = urld;
			ad.onclick=confirmDel;
			var upper = document.createElement("input");
			upper.setAttribute("id","upper["+bids[a]+"]");
			upper.setAttribute("size","10");
			upper.setAttribute("value",uppers[a]);
			var lower = document.createElement("input");
			lower.setAttribute("id","lower["+bids[a]+"]");
			lower.setAttribute("size","10");
			lower.setAttribute("value",lowers[a]);
			td1.align = "left";
			td2.align = "left";
			td3.align = "left";
    	    td1.innerHTML = eques[a];
    	    td2.innerHTML = items[a];
    	    td3.innerHTML = names[a];
    	    td4.appendChild(lower);
    	    td5.appendChild(upper);
    	    td6.appendChild(ac);
    	    td6.appendChild(ad);
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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	


  </head>
  
  <body>

     <div id="rightmain">
	  <h2>参数描述维护</h2>
	
    <!-- 
 <div align="right">
      <input name="button" type=button onClick="window.location.href('dcsdscribaction!goadd.action')" value="新建参数描述">
      </div> --> 
  <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">
		    <th width = "13%">故障节点</th>
			<th width = "15%">控制参数</th>
			<th width = "25%">对应名称</th>
			<th width = "10%">最小值</th>
			<th width = "10%">最大值</th>			
			<th width = "17%">相关操作</th>
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
