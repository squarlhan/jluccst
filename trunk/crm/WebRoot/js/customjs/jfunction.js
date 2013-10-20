
/**
 * 获取url中的参数
 * @param {Object} name 参数名称
 */
$.fn.getParamFromUrl=function(name){  
	name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");  
	var regexS = "[\\?&]" + name + "=([^&#]*)";  
	var regex = new RegExp(regexS);  
	var results = regex.exec(window.location.href);  
	if (results == null) {  
		return null;  
	}  
	else {  
		return results[1];  
	}  
}  

/**
 * 单选按钮选择，再次点击后反选
 * @param {Object} name 按钮名称
 * @memberOf {TypeName} 
 */
$.fn.radioCheckedAndUnChecked = function(name,type){
	if(typeof(type)=="undefined"){
		type = "click";
	}/*else if(type!="click" && type!="dblclick"){
		alert("不支持的事件");
	}//*/
	$(":radio[name='"+name+"']").each(function(){
		var flag=true;
		$(this).bind( type, function(){
			if( type!="click" ){
				$(this).attr("checked",false);
			}else{
				$(this).attr("checked",flag);
				flag=!flag;
			}
		});
	});
}

/**
 * 删除所有
 */
$.fn.delete_items = function(d_checkbox_name, d_url){
	var chknum = ($(":checkbox[name='"+ d_checkbox_name +"'][disabled=false]").length );
	if( chknum == 0 ){
		alert("暂无可操作的信息！");
		return false;
	}
	var chkchecknum = ($(":checkbox[name='"+d_checkbox_name+"']:checked").length );
	if( chkchecknum == 0 ){
		alert("请选择要操作的信息！");
		return false;
	}
	if(confirm("确定要删除所选记录吗？")){
		document.forms[0].action = d_url;
		document.forms[0].submit();
	}
}
/**
 * 获取当前选择的checkbox对应行的值
 */
$.fn.checkboxcurrentrow = function(checkboxname){
	var map = new Array();
	var n=0;
	$("input[name='"+checkboxname+"']").each(function(i){
		if ($(this).attr("checked")) {
			var row = new Array();
			var index=0;
			var id = $(this).attr("id");
			var len = $(this).parent().parent().children("td").length;
			for(var i=1;i<len;i++){
				var name = $(this).parent().parent().children("td").get(i).innerHTML;
				row[index] = name.replace("&nbsp;","");
				index=index+1;
			}
			map[n]= id+","+row;
			n=n+1;
		}
		
	});
	return map;
}
/**
 * 点击选复选框时，执行全选/取消全选功能
 * @param chkallid
 * 执行全选功能的checkbox的id值
 */
$.fn.checkall = function (chkallid) {
	$("#" + chkallid).click(function () {
		var b = ($(this).attr("checked"));
		$(":checkbox").each(function () {
			if( !$(this).attr("disabled") ){
				$(this).attr("checked", b);
			}
		});
	});
	if($(":checkbox[disabled=false]").length == 1){
		$("#" + chkallid).attr("disabled","true");
	}
};
/**
 * 点击选复选框时，执行只选一个复选功能
 * @param chkname
 * 复选框的name
 * @param chkid
 * 复选框的id
 * 选中功能的checkbox的id值
 */
$.fn.checkOnly = function (chkname, chkid) 
{
	$(":checkbox[name='" + chkname + "']").each(function () 
	{
		if( chkid != $(this).attr("id") )
		{
			$(this).attr("checked",false);
		}				
	});
};

/**
 * checkbox单选
 * @param {Object} chkname 复选框的name
 * @memberOf {TypeName} 
 */
$.fn.checkboxonly = function(chkname){
	$(":checkbox[name='"+chkname+"']").each(function(){
		$(this).click(function(){
			$(":checkbox[name='"+chkname+"']:checked").each(function(){
				$(this).attr("checked",false);
			});
			$(this).attr("checked",true);
		});
	});
}

/**
 * 子复选框有一个处理非选中状态时，执行全选功能的复选框将置为非选中状态
 * @param subchkname
 * 子复选框的name
 * @param chkallid
 * 执行全选功能的复选框id
 */
$.fn.uncheckall = function (subchkname, chkallid) {
	$(":checkbox[name='" + subchkname + "']").click(function () {
		var l = $(":checkbox[name='" + subchkname + "'][disabled=false]").length;
		if (!$(this).attr("checked")) {
			$("#" + chkallid).attr("checked", false);
		} else {
			var i = 0;
			$(":checkbox[name='" + subchkname + "'][disabled=false]").each(function () {
				if ($(this).attr("checked")) {
					i++;
				}
			});
			if (l == i) {
				$("#" + chkallid).attr("checked", true);
			}
		}
	});
};
/**
 * 单击全选
 * @param subchkname
 * 子复选框的name
 * @param chkallid
 * 执行全选功能的复选框id
 */
$.fn.clickuncheckall = function(subchkname, chkallid){
	var t = $(":checkbox[name='" + subchkname + "']").length;
	var l = $(":checkbox[name='" + subchkname + "']:checked").length;
	if (l == t) {
		$("#" + chkallid).attr("checked", true);
	}else
	{
		$("#" + chkallid).attr("checked", false);
	}
}
/**
 * 取消，执行关闭窗口操作
 * @param btnid
 * 执行关闭窗口事件的按钮id
 */
$.fn.cancle = function (btnid) {
	$("#" + btnid).click(function () {
		window.close();
		return false;
	});
};
/**
 * 判断输入框中内容是否是数字，数字包括小数和负数
 * @param str
 * 需要判断是否为数值的串
 */
$.fn.isnumber = function (str) {
	str = str.toString();
	var re = /^[-]?\d*\.?\d*$/;
	if (!str.match(re)) {
		return false;
	}
	return true;
};
/**
 * 判断输入框中内容是否是正数，数字包括小数点
 * @param str
 * 需要判断是否为数值的串
 */
$.fn.isplusnumber = function (str) {
	str = str.toString();
	var re = /^\d*\.?\d*$/;
	if (!str.match(re)) {
		return false;
	}
	return true;
};
/**
 * 公共排序方法
 * @param btnId 
 * 排序按钮的id
 * @param modelName
 * 排序的模块名称，用于排序显示
 * @param showListUrl
 * 显示列表内容的URL，URL中可含参数
 * @param saveAction
 * 排序功能的保存Action
 */
$.fn.sort = function(btnId,modelName, showListUrl, saveAction){
	$("#" + btnId).click(function(){
		var myArray = new Array();
		myArray[myArray.length] = modelName;
		myArray[myArray.length] = saveAction;
		var flag = window.showModalDialog(showListUrl,myArray,'status=no;dialogWidth=330px;dialogHeight=440px;center=yes;help=no; scroll=no;location=no');
  		if(flag=="refresh")
	  	{
	  		window.location.href=window.location.href;
	  	}
	  	return false;
	});
};

/**
 * 很完美的JS判断日期函数   
 * 格式为：YYYY-MM-DD或YYYY/MM/DD   
 */
$.fn.isdate = function (INDate) {
	if (INDate == "") {
		return true;
	}
	subYY = INDate.substr(0, 4);
	if (isNaN(subYY) || subYY <= 0) {
		return true;
	}
 //转换月份
	if (INDate.indexOf("-", 0) != -1) {
		separate = "-";
	} else {
		if (INDate.indexOf("/", 0) != -1) {
			separate = "/";
		} else {
			return true;
		}
	}
	area = INDate.indexOf(separate, 0);
	subMM = INDate.substr(area + 1, INDate.indexOf(separate, area + 1) - (area + 1));
	if (isNaN(subMM) || subMM <= 0) {
		return true;
	}
	if (subMM.length < 2) {
		subMM = "0" + subMM;
	}
 //转换日
	area = INDate.lastIndexOf(separate);
	subDD = INDate.substr(area + 1, INDate.length - area - 1);
	if (isNaN(subDD) || subDD <= 0) {
		return true;
	}
	if (eval(subDD) < 10) {
		subDD = "0" + eval(subDD);
	}
	NewDate = subYY + "-" + subMM + "-" + subDD;
	if (NewDate.length != 10) {
		return true;
	}
	if (NewDate.substr(4, 1) != "-") {
		return true;
	}
	if (NewDate.substr(7, 1) != "-") {
		return true;
	}
	var MM = NewDate.substr(5, 2);
	var DD = NewDate.substr(8, 2);
	if ((subYY % 4 == 0 && subYY % 100 != 0) || subYY % 400 == 0) { //判断是否为闰年
		if (parseInt(MM) == 2) {
			if (DD > 29) {
				return true;
			}
		}
	} else {
		if (parseInt(MM) == 2) {
			if (DD > 28) {
				return true;
			}
		}
	}
	var mm = new Array(1, 3, 5, 7, 8, 10, 12); //判断每月中的最大天数
	var flag = false;
	for (i = 0; i < mm.length; i++) {
		if (parseInt(MM, 10) == mm[i]) {
			flag = true;
		}
	}
	if (flag == true) {
		if (parseInt(DD) > 31) {
			return true;
		}
	} else {
		if (parseInt(DD) > 30) {
			return true;
		}
	}
	if (parseInt(MM) > 12) {
		return true;
	}
	return false;
};

/**
 * 验证是否有特殊字符
 * @param str
 * 要进行验证的字符串
 * @param msg 
 * 要验证的字符串对应的控件名称
 */
$.fn.strangecode = function( str,msg )
{
	var regExpress =  /[\'\"\\\/<>*:?|%$#@&~^_]/;
    var flag = str.search(regExpress);
    if(flag == -1){
    	return false;
    }else{
    	alert("【" + msg + "】中存在 \'\"\\/<>*:?|%$#@&~^_ 非法字符， \n\n请更正或以中文符号替换 ！");
    	return true;
    }
};
/**
 * 验证时间日期是否有特殊字符
 * @param str
 * 要进行验证的字符串
 * @param msg 
 * 要验证的字符串对应的控件名称
 */
$.fn.timestrangecode = function( str,msg )
{
	var regExpress =  /[\'\"\\\/<>*?|%$#@&~^_]/;
    var flag = str.search(regExpress);
    if(flag == -1){
    	return false;
    }else{
    	alert("【" + msg + "】中存在 \'\"\\/<>*?|%$#@&~^_ 非法字符， \n\n请更正或以中文符号替换 ！");
    	return true;
    }
};
/**
 * 查询中验证是否有特殊字符
 * @param str
 * 要进行验证的字符串
 * @param msg 
 * 要验证的字符串对应的控件名称
 */
$.fn.querystrangecode = function( str,msg )
{
	var regExpress =  /[\'\"\\\/<>*:?|%$#@&~_+^_]/;
    var flag = str.search(regExpress);
    if(flag == -1){
    	return false;
    }else{
    	alert("【" + msg + "】中存在 \'\"\\/<>*:?|%$#@&~_+^_ 非法字符， \n\n请更正或以中文符号替换 ！");
    	return true;
    }
};
/**
 * 备注中验证是否有特殊字符
 * @param str
 * 要进行验证的字符串
 * @param msg 
 * 要验证的字符串对应的控件名称
 */
$.fn.memostrangecode = function( str,msg )
{
	var regExpress =  /[\'\"\\\/<>*:?|%$#&~_+^_]/;
    var flag = str.search(regExpress);
    if(flag == -1){
    	return false;
    }else{
    	alert("【" + msg + "】中存在 \'\"\\/<>*:?|%$#&~_+^_ 非法字符， \n\n请更正或以中文符号替换 ！");
    	return true;
    }
};
/**
 * 判断输入框中内容是否是0-9的数字
 * @param str
 * 需要判断是否为0-9的数值型串
 * @param msg
 * 要验证的字符串对应的控件名称 
 */
$.fn.isnumber2 = function(str, msg)
{
    var regExpress = /[^0-9]/;
    var flag = str.search(regExpress);
    if(flag == -1){
    	return true;
    }else{
    	alert("【" + msg + "】中只可以输入0~9的数字！");
    	return false;
    }
}
/**
 * 将页面中a的href值为#的链接改为href="javascript:void(0);"
 */
$.fn.resethref = function(){
	$(":a").each(function(){
		if( $(this).attr("href") == "#" )
		{
			$(this).attr("href","javascript:void(0);");
		}
	});
}

//判断是否是时间格式，格式为hh:mm
$.fn.isTime=function (str)
{
	var r=str.split(":");
	if(r==null)
	{
		return false;
	}
	var d=new Date();
	d.setHours(r[0]);
	d.setMinutes(r[1]);
	return (d.getHours()==r[0]&&d.getMinutes()==r[1])
}
//提交前清除前后空格
$.fn.trimSpaceAtSub=function ()
{
	$("input[type='text']").each
	(
		function(i)
		{
			$(this).val($.trim($(this).val()));
		}
	);
	$("textarea").each
	(
		function(i)
		{
			$(this).val($.trim($(this).val()));
		}
	);
}
//提交前过滤非法字符，主要用于查询前
$.fn.isexiststrangecodeforsearch=function ()
{
	var isexist = false;
	$("input[type='text']").each
	(
		function(i)
		{
			$(this).val($.trim($(this).val()));
			if( $(this).val() != ""){
				var isExist = $.fn.strangecode( $(this).val(),"文本框" );
				if(isExist ){
					//存在非法字符
					isexist = true;
					//跳出each必须用 return false;
					return false;
				}
			}
		}
	);
	return isexist;
}
//光标移到int型输入域自动选中
$.fn.focusOnIntSelected=function (id)
{
	$("#"+id).focus(function ()
	{
		$(this).select();
	});
}
/**
 * 屏掉页面按钮，将文本框置为只读
 */
$.fn.masking = function(){
	$(":input").each(function(){
		if( $(this).attr("type") == "text" || $(this).attr("type") == "textarea" ){
			$(this).attr("readonly",true);
		}
		else{
			if( $(this).attr("type")!= "hidden" )
			{
				$(this).attr("disabled",true);
				//$(this).remove();
			}
		}
	});
}
/**
 * 取得当前时间字符串，用于出现缓存的超链接
 */
$.fn.getNow = function(){
	var now = new Date();
	var nowstr = now.getFullYear() + "" + now.getMonth() + "" + now.getDate();
	nowstr += "" + now.getHours() +"" + now.getMinutes() +"" + now.getSeconds();
	nowstr + "" + now.getMilliseconds();
	return nowstr;
}
/**
 * 取得Url中的参数值
 * @parma paras 参数名称
 * @return 参数值
 */
$.fn.request=function (paras)
{
	var url = location.href;  
	var paraString = url.substring(url.indexOf("?")+1,url.length).split("&");  
	var paraObj = {}  
	for (i=0; j=paraString[i]; i++){  
		paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length);  
	}  
	var returnValue = paraObj[paras.toLowerCase()];  
	if(typeof(returnValue)=="undefined"){  
		return "";  
	}else{  
		return returnValue; 
	}
}
/**
 * 找到名称为parentTagName的父节点
 */
$.fn.findParent = function(object, parentTagName){
	var obj;
	if(typeof(object) == "string") obj = $("#"+object);
	else if(object instanceof jQuery) obj = object;
	else obj = $(object);
	if(obj instanceof jQuery){
		parentTagName = parentTagName.toUpperCase();
		while(obj.attr("tagName").toUpperCase()!=parentTagName){
			if(obj.attr("tagName").toUpperCase()=="BODY") break;
			obj = obj.parent();
		}
	}
	return obj;
}
/**
 *  页面自适应滚动条，默认放到ready方法中
 */
$.fn.autoScroll = function(parentFrame, scrollHeight){
	var ifrHeight = $("#mainFrame",parentFrame.document).height();
	$("#divList").height( ifrHeight-scrollHeight );
	$(window).resize(function(){
		var ifrHeight = $("#mainFrame",parentFrame.document).height();
		$("#divList").height( ifrHeight-scrollHeight );
	});
}
/**
 *  页面自适应滚动条，默认放到ready方法中
 */
$.fn.autoScrollByName = function(parentFrame, divName, scrollHeight){
	var ifrHeight = $("#mainFrame",parentFrame.document).height();
	$("#" + divName).height( ifrHeight-scrollHeight );
	$(window).resize(function(){
		var ifrHeight = $("#mainFrame",parentFrame.document).height();
		$("#" + divName).height( ifrHeight-scrollHeight );
	});
}
/**
 *  四舍五入后返回
 *  参数how：默认为0，可以传负数
 */
$.fn.round = function(value,how) {
	if(how==undefined || how==null || how=="" || isNaN(how)){
		how = 0;
	}
	if(value==undefined || value==null || value=="" || isNaN(value)){
		return value;
	} else {
		return Math.round(value*Math.pow(10,how))/Math.pow(10,how); 
	}
}