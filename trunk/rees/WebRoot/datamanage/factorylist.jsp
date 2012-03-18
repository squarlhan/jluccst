<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" jquery="true" />
<script type="text/javascript">

	$(function(){
		$("#addbtn").click(function(){
			parent.parent.parent.tipsWindown("添加设备","iframe:device/deviceadd.jsp","460","250","true","","true","no");
		});
		$("#editbtn").click(function(){
			parent.parent.parent.tipsWindown("修改设备","iframe:sysmanage/groupinfo.html","460","250","true","","true","no");
		});
		$("#editpointbtn").click(function(){
			parent.parent.parent.tipsWindown("修改监控点","iframe:sysmanage/groupinfoedit.html","460","190","true","","true","no");
		});
	});
//-->
</script>
</head>
<body>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="5" cellpadding="0">
      <tr>
        <td>
     <!--   
     		<input name="button" type="button" class="btn_4" id="addbtn" value="添加" onClick="window.open('groupinfo.html')">
    		<input name="button" type="button" class="btn_4" id="addbtn" value="修改" onClick="window.open('groupinfo.html')">
            <input name="button" type="button" class="btn_4" id="addbtn" value="修改监控点" onClick="window.open('groupinfoedit.html')">
      -->
		    <input name="button" type="button" class="btn_2_3" id="addbtn" value="添加" >
    		<input name="button" type="button" class="btn_2_3" id="editbtn" value="修改" >
            <input name="button" type="button" class="btn_4" id="editpointbtn" value="修改监控点" >
            <input name="button2" type="button" class="btn_4" id="button2" value="删除所选">
            <input name="button3" type="button" class="btn_2_3" id="button" value="排序"></td>
        <td align="right"></td>
      </tr>
    </table>
      <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">
        <tr>
          <td width="8%" align="center" background="../images/headerbg.jpg">&nbsp;</td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备编号</strong></td>
          <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备类型</strong></td>
		  <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备名称</strong></td>
		  <td width="16%" align="center" background="../images/headerbg.jpg"><strong>设备型号</strong></td>
		  <td width="14%" align="center" background="../images/headerbg.jpg"><strong>设备厂商</strong></td>
		  <td width="14%" align="center" background="../images/headerbg.jpg"><strong>监控点数量</strong></td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox"></td>
          <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
		  <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
		  <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
		  <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox"></td>
          <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
		  <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
		  <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
		  <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox"></td>
          <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
		  <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
		  <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
		  <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
        
        <tr>
          <td colspan="7" align="center" bgcolor="#FFFFFF">共[1]条记录　<a href="#">首　页</a>　<a href="#">上一页</a>　<a href="#">下一页</a>　<a href="#">尾　页</a>　当前[1/1]页</td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
