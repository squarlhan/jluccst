<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
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
    
    <title>手工数据报警日志</title>
  
    <sx:head/>
    
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
    			<s:iterator id="result" value="errorlist">
    				"<s:property value='#result.equipment'/>",
    			</s:iterator>
    		0);
    	var wrongs = new Array(
    			<s:iterator id="result" value="errorlist">
    				"<s:property value='#result.wrong'/>",
    			</s:iterator>
    		0);
    	var items = new Array(
    			<s:iterator id="result" value="errorlist">
    				"<s:property value='#result.item'/>",
    			</s:iterator>
    		0);
    	var levels = new Array(
    		    <s:iterator id="result" value="errorlist">
    			    "<s:property value='#result.level'/>",
    		    </s:iterator>
    	    0);  	
    	var times = new Array(
    		    <s:iterator id="result" value="errorlist">
    			    "<s:property value='#result.time'/>",
    		    </s:iterator>
    	    0);
    	var bids = new Array(
    		    <s:iterator id="result" value="errorlist">
    			    "<s:property value='#result.value'/>",
    		    </s:iterator>
    	    0);
    	var suggs = new Array(
    		    <s:iterator id="result" value="errorlist">
    			    "<s:property value='#result.sugg'/>",
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
    	    var td7 = tr.insertCell(-1);
			td1.align = "left";
			td2.align = "left";
			td3.align = "left";
			td4.align = "left";
			td5.align = "left";
			td6.align = "left";
			td7.align = "left";
    	    td1.innerHTML = eques[a]+"&nbsp;";
    	    td2.innerHTML = items[a]+"&nbsp;";
    	    td3.innerHTML = wrongs[a]+"&nbsp;";
    	    td4.innerHTML = times[a]+"&nbsp;";
    	    td5.innerHTML = bids[a]+"&nbsp;";
    	    td6.innerHTML = levels[a]+"&nbsp;";
    	    td7.innerHTML = suggs[a]+"&nbsp;";
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
	  <h2>手工数据报警日志</h2>
	  <s:form action="errorlogaction!findbypara.action">

<tr>
    
	
	<td align="center"> <select name="parameter"   style="width:110px">
                <option  value="PH">PH</option>
                <option  value="COD">COD</option>
                <option  value="碱度">碱度</option>
                 <option  value="BOD5">BOD5</option>
                <option  value="SS">SS</option>
                <option  value="NH3-N">NH3-N</option>
                <option  value="NO-N">NO-N</option>
                <option  value="水量">水量</option>
              </select></td>
	
	<td width="20%" align="center"><s:submit value="查询" theme="simple"  /></td>
    </tr>   </s:form>
    
    
    
    <s:form theme="simple" action="errorlogaction!findbytime?data1=.action"><tr>
    <td><sx:datetimepicker id="data1" name ="date1" label="请选择开始日期" displayFormat="yyyy-MM-dd"></sx:datetimepicker><td>
    <td><sx:datetimepicker  id="data2" name ="date2" label="请选择结束日期" displayFormat="yyyy-MM-dd"></sx:datetimepicker><td>
      <td width="20%" align="center"><s:submit value="查询" theme="simple"  /></td></tr>
      
<%//String data1=request.getElementById("data1"); 
  // String data2=request.getElementById("data2"); %>
      
 </s:form>
  <table bordercolor="#FFFFFF" rules="all"  id="mytable" class="list_table" align="center" width="100%" >
		<tr bgcolor="#4A708B">
		    <th width = "15%">设备名</th>
			<th width = "15%">参数名</th>
			<th width = "10%">报警现象</th>
			<th width = "15%">报警时间</th>
			<th width = "10%">报警值</th>
			<th width = "5%">报警级别</th>
			<th width = "30%">采取的建议</th>
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
