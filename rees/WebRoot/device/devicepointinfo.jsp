<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="../style.css" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
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
<!--
	$(document).ready(function() {
		$(".btn_2_3").click(function(){
			parent.$("#windown-close").click();
		});
	});
//-->
</script>
</head>
<body><form action="" method="get">
<table width="100%" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td><table width="100%" style="height:100%;" border="0" cellspacing="6" cellpadding="0">
        <tr>
          <td style="height:36px;"><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#d5e4fd">

            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>设备编号：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield" id="textfield" style="width:250px;"></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>设备类型：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield2" id="textfield2" style="width:250px;"></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>设备名称：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield2" id="textfield3" style="width:250px;"></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>设备型号：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield2" id="textfield3" style="width:250px;"></td>
            </tr>
            <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>设备厂商：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield2" id="textfield3" style="width:250px;"></td>
            </tr>
             <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>检测点数量：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield2" id="textfield3" style="width:250px;"></td>
            </tr>
             <tr>
              <td height="26" align="right" bgcolor="#FFFFFF"><strong>上传设备图：</strong></td>
              <td height="26" align="left" bgcolor="#FFFFFF"><input type="text" name="textfield2" id="textfield3" style="width:250px;"></td>
            </tr>
            <tr>
              <td height="26" colspan="2" align="center" bgcolor="#FFFFFF">	<s:submit id="addBtn" value="确定"  class="btn_2_3"></s:submit>&nbsp;&nbsp;
                <input name="addBtn" type="button" class="btn_2_3" id="closeBtn" value="关闭"></td>
            </tr>
          </table></td>
        </tr>
        
    </table></td>
  </tr>
</table></form>
</body>
</html>
