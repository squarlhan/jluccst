<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<j:scriptlink css="true" jquery="true" />
<script type="text/javascript">
$(document).ready(function() {
	var ifrHeight = $("#mainFrame",parent.parent.document).height();
	var ifrHeightTemp = ifrHeight - 57;
	$("#devicemanage").height( ifrHeightTemp );
});
$(window).resize(function(){
	var ifrHeight = $("#mainFrame",parent.parent.document).height();
	var ifrHeightTemp = ifrHeight - 57;
	$("#devicemanage").height( ifrHeightTemp );
});
</script>
</head>
<body>
<table width="100%" style="height:100%;" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td colspan="2" style="height:36px;"><table id="__01" width="100%" height="36" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="11"><img src="../images/header_01.jpg" width="11" height="36" alt=""></td>
                <td background="../images/header_02.jpg"><span class="blackBold">您当前的位置：数据管理&gt;&gt;&gt;数据管理</span></td>
                <td width="12"><img src="../images/header_03.jpg" width="12" height="36" alt=""></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td width="200" valign="top" style="border-left:1px solid #54a4e3; border-bottom:1px solid #54a4e3; border-right:1px solid #54a4e3; padding:5px;"><iframe width="100%" height="100%" id="devicetree" name="devicetree" frameborder="0" scrolling="auto" src="devicetree.jsp"></iframe></td>
          <td valign="top" style="border-left:1px solid #54a4e3; border-bottom:1px solid #54a4e3; border-right:1px solid #54a4e3; padding:5px;"><iframe width="100%" height="100%" id="devicemanage" name="devicemanage" frameborder="0" scrolling="no" src="about:blank"></iframe></td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
