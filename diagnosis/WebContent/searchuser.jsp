<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<base href="<%=basePath%>">

		<title>searchuser</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">



	    <style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
        </style>
</head>

	<body>
		<s:form action="useraction!searchUser.action" theme="simple" name="form1">
			<table align="center" width="50%" id="tb1">

				<tr>
					<td width="20%" height="29">
						�û���:					</td>
					<td width="80%">
						<s:textfield name="user.username" />					</td>
				</tr>
				<tr>
					<td height="31">
						email��					</td>
					<td>
						<s:textfield name="user.email" />					</td>
				</tr>

				<tr>
					<td height="31">
						�����ţ�					</td>
					<td>
						<s:textfield name="user.jid" />					</td>
				</tr>
				<tr>
					<td height="31">
						������					</td>
					<td>
						<s:textfield name="user.name" />					</td>
				</tr>
				<tr>
					<td height="31">
						�绰��					</td>
					<td>
						<s:textfield name="user.phone" />					</td>
				</tr>
                <tr>
					<td height="31">
					���� ��					</td>
					<td>
						<s:textfield name="user.dept" />					</td>
				</tr>
				
				<tr>
					<td height="33">
						<s:submit value="�����û�" />					</td>
				  <td>
						<s:reset value="ȡ��" />									</td>
				</tr>
				<tr>
				 <td height="33" colspan="2" bgcolor="#FFFFFF"><s:a href="useraction!userList.action"> 
						   <div align="center" class="STYLE1"><U>�����û��б�</U></div>
				  </s:a>		</td>
			  </tr>
			</table>
		</s:form>
	</body>
</html>
