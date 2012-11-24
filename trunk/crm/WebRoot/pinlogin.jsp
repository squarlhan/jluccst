<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>----用户登录----</title>
<j:scriptlink css="true" jquery="true" jfunction="true" tipswindow="true"></j:scriptlink>
<style type="text/css">
body{text-align:center;width:100%;}
#dialog{
text-align:center;
width:100%;
margin:0 auto;
}
</style> 
<script type="text/javascript">

function message(msg){
	alert(msg);
}
function validUsbkey(){
	var randomData = "<s:property value="randomData"/>";
	var hashToken = document.getElementById("hashToken");
	var sn_random = document.getElementById("sn_random");
	
	//检查ePass驱动及安全控件是否安装
	try{
		ePass.GetLibVersion();
	}catch(e) {
		message("请安装ePass 1000安全控件！如有问题请联系管理人员。");
		return false;
	}
	
	//检查USB锁是否连接正常
	try {
		ePass.OpenDevice(1, "");
	}catch(e) {
		message("请检查USB锁是否连接正确！");
		return false;
	}
	
	//获取SN
	try{
		sn_random.value = ePass.GetStrProperty(7, 0, 0) + "@" + randomData;
	}catch(e){
		ePass.CloseDevice();
		message("USB锁无效，请联系管理员！");
		hashToken.value="";
		pinInput.focus();
		return false;
	}
	
	//获取PIN值
	var pinInput = document.getElementById("pin");
	//PIN码长度校验
	if(pinInput.value.length < 4){
		ePass.CloseDevice();
		message("PIN码长度至少为4位！");
		pinInput.focus();
		return false;
	}
	//PIN码正确性校验
	try{
		ePass.VerifyPIN(0, pinInput.value);
	}catch(e){
		var maxCount  = ePass.GetIntProperty(3, 1, 0); 
    	var retryCount = ePass.GetIntProperty(3, 2, 0);
		ePass.CloseDevice();
    	if( retryCount == 0 ){
    		message("您的PIN码尝试次数已达到15次，身份锁已被禁用，请联系管理员！");
    	}else{
			message("PIN码输入有误，请重新输入！");
			pinInput.focus();
    	}
		hashToken.value="";
		document.getElementById("pin").value = "";
		pinInput.focus();
		return false;
	}
	
	//读取文件目录
	try{
		ePass.ChangeDir("&H300", 0, "CBIT-YLXT");
	}catch(e){
		ePass.CloseDevice();
		message("读取文件目录失败！如有问题请联系管理人员。");
		return false;
	}
	
	//读取第一个KEY文件
	try{
		ePass.OpenFile(0, "&H1234");
	}catch(e){
		ePass.CloseDevice();
		message("读取第一个KEY文件失败！如有问题请联系管理人员。");
		return false;
	}
	
	//计算散列值，并存入表单
	try{
		hashToken.value = ePass.HashToken (1, "&H2345", randomData);
	}catch(e){
		ePass.CloseDevice();
		message("计算散列值失败！如有问题请联系管理人员。");
		return false;
	}			
	ePass.CloseDevice();
	
	//关闭USB锁
	try{
		ePass.CloseDevice();
	}catch(e){}
	
	//验证表单值
	if(hashToken.value!="" && sn_random.value!="" && sn_random.value.indexOf("@")!=-1){
		//alert(sn_random.value);
		//alert(hashToken.value);
	} else {
		message("读取USB锁过程中发生错误！如有问题请联系管理人员。");
		return false;
	}
	return true;
}

function validmessage(){
	var url=window.location.href;
	var message = url.substr(url.indexOf('?')+1);
	if( message.indexOf("error=true") != -1){
		if(message.indexOf("User is disabled") != -1){
			alert("该用户已被锁定，请与系统管理员联系！");
			return false;
		}
		alert("该用户不存在，请与系统管理员联系！");
		return false;
	}
	document.getElementById("pin").focus();
}
</script>
</head>

<body class="bodybg" align="center" onload="validmessage()">
<object classid="clsid:E740C5DF-3454-46A7-80EC-364D1ADB6CF0" id="ePass" name="ePass" style="left: 0px; top: 0px" width=0 height=0></object>
<form id="form1" name="form1" method="post" onsubmit="return validUsbkey();" action="./pinLogonValidAction.action" target="iframe1">
<input name="hashToken" id="hashToken" type="hidden"/>
<input name="sn_random" id="sn_random" type="hidden"/>
		<table width="100%" border="0" cellspacing="5" cellpadding="0">
			<tr>
				<td>
					<table width="100%" style="height: 100%;" border="0"
						cellspacing="6" cellpadding="0">
						<tr>
							<td style="height: 36px;">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
									<tr>
										<td height="26"  align="center" bgcolor="#FFFFFF"  colspan="2" >
											<strong>PIN码：</strong>
											<input name="pin" id="pin" type="password" style="width:150px" tabindex="1"/>
										</td>
									</tr>
									<tr>
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<input name="login" type="submit" class="btn_2_3" id="login" value="确定">
											&nbsp;&nbsp;
											<input name="closewin" type="button" class="btn_2_3" id="closewin" value="取消" onclick='parent.$("#windown-close").click();'>
										</td>
									</tr>
									<tr>
										<td height="26" align="center" colspan="2"  bgcolor="#FFFFFF">
											<span style="font-size:9pt;color:#000000">第一次登录时，请先</span>
											<a href="tools/epass-setup.rar"  target="iframe1" style="font-size:9pt;color:#FF0000">点击此处<a/>
											<span style="font-size:9pt;color:#000000">下载驱动安装。</span>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<iframe width="1px" height="1px" id="iframe1" name="iframe1"></iframe>
		</form>
</body>
</html>
