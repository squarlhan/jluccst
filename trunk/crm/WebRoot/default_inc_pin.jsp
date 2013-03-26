<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	// 生成访问随机数
	char Upper = 'z';
	char Lower = 'a';
	String randomData = "";
	Random r = new Random();
	for (int i = 0; i < 20; i++) {
		int tempval = (int) ((int) Lower + (r.nextFloat() * ((int) (Upper - Lower))));
		randomData += new Character((char) tempval).toString();
	}
%>
<script type="text/javascript">

function message(msg){
	alert(msg);
}
function validUsbkey(){
	var randomData = document.getElementById("randomData");
	var hashToken = document.getElementById("hashToken");
	var keySn = document.getElementById("keySn");
	
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
		keySn.value = ePass.GetStrProperty(7, 0, 0) ;
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
	if(hashToken.value!="" && keySn.value!=""){
		//alert(keySn.value);
		//alert(hashToken.value);
	} else {
		message("读取USB锁过程中发生错误！如有问题请联系管理人员。");
		return false;
	}
	form1.submit();
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
<object classid="clsid:E740C5DF-3454-46A7-80EC-364D1ADB6CF0" id="ePass" name="ePass" style="left: 0px; top: 0px" width=0 height=0></object>
<form id="form1" name="form1" method="post" action="./pinLogonValidAction.action" target="iframe1">
	<input name="hashToken" id="hashToken" type="hidden" /> <input name="keySn" id="keySn" type="hidden" /> <input name="randomData" id="randomData" type="hidden" value="<%=randomData%>" />
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center"><table id="__01" width="968" height="598" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td colspan="3"><img src="images/login_01.jpg" width="968" height="216" alt="">
						</td>
					</tr>
					<tr>
						<td rowspan="2"><img src="images/login_02.jpg" width="367" height="382" alt="">
						</td>
						<td width="258" height="214"><table id="__" width="258" height="214" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td colspan="3"><img src="images/pinlg_01.jpg" width="258" height="84" alt="">
									</td>
								</tr>
								<tr>
									<td rowspan="2"><img src="images/pinlg_02.jpg" width="111" height="37" alt="">
									</td>
									<td width="110" height="21" background="images/pinlg_03.jpg"><input name="pin" id="pin" type="password" style="height:21px; width:110px" tabindex="1" /></td>
									<td rowspan="2"><img src="images/pinlg_04.jpg" width="37" height="37" alt="">
									</td>
								</tr>
								<tr>
									<td><img src="images/pinlg_05.jpg" width="110" height="16" alt="">
									</td>
								</tr>
								<tr>
									<td height="93" colspan="3" align="center" valign="top" background="images/pinlg_06.jpg" style="padding:5px;"><img src="images/login_dl.jpg" width="68" height="28" style="margin:3px;" style="cursor:pointer;" onclick="return validUsbkey();"> <img src="images/login_htdl.jpg" width="81" height="28" style="margin:3px;" style="cursor:pointer;" onclick="document.getElementById('pin').value='';">
									</td>
								</tr>
								<tr>
									<td height="26" align="center" colspan="2" bgcolor="#FFFFFF"><span style="font-size:9pt;color:#000000">第一次登录时，请先</span> <a href="tools/epass-setup.rar" target="iframe1" style="font-size:9pt;color:#FF0000">点击此处<a /> <span style="font-size:9pt;color:#000000">下载驱动安装。</span>
									</td>
								</tr>
							</table>
						</td>
						<td rowspan="2"><img src="images/login_04.jpg" width="343" height="382" alt="">
						</td>
					</tr>
					<tr>
						<td><img src="images/login_05.jpg" width="258" height="168" alt="">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>