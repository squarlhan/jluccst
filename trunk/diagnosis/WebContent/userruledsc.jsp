<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%
	if (request.getSession().getAttribute("us") == null) {
		response.sendRedirect("userlogin.jsp");
	}
%>
<base href="<%=basePath%>">

<title>DCS规则录入</title>
<sx:head />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
.nobr br {
	display: none
}
</style>
<script language="javascript">
	var count1 = 0;
	var count2 = 0;
	function insertResult() {
		count1 += 1;
		var tb = document.getElementById("adresulttable");
		// var tb = table;
		var tr = tb.insertRow();

		var td1 = tr.insertCell();
		var td2 = tr.insertCell();
		var td3 = tr.insertCell();
		

		var textfield1 = document.createElement("input");
		textfield1.setAttribute("id", "result_noun[" + count1 + "]");
		textfield1.setAttribute("name", "result_noun[" + count1 + "]");
		textfield1.setAttribute("size", "12");

		var textfield2 = document.createElement("input");
		textfield2.setAttribute("id", "result_verb[" + count1 + "]");
		textfield2.setAttribute("name", "result_verb[" + count1 + "]");
		textfield2.setAttribute("size", "12");

		td1.innerHTML = "现象名词： ";
		td1.appendChild(textfield1);
		td2.innerHTML = "现象动词： ";
		td2.appendChild(textfield2);

	}

	function insertReason() {
		count2 += 1;
		var tb = document.getElementById("adreasontable");
		// var tb = table;
		var tr1 = tb.insertRow(tb.rows.length);
		var tr2 = tb.insertRow(tb.rows.length);
		var tr3 = tb.insertRow(tb.rows.length);

		var td1 = tr1.insertCell(0);
		var td2 = tr2.insertCell(0);
		var td3 = tr3.insertCell(0);
		var td11 = tr1.insertCell(1);
		var td21 = tr2.insertCell(1);
		var td31 = tr3.insertCell(1);
		td1.align="right";
		td2.align="right";
		td3.align="right";

		var t1 =  document.getElementById("reason_noun[0]");
		var textfield1 = t1.cloneNode(true);
		textfield1.setAttribute("id", "reason_noun[" + count2 + "]");
		textfield1.setAttribute("name", "reason_noun[" + count2 + "]");
		textfield1.setAttribute("value", "");

		var t2 = document.getElementById("reason_verb[0]");
		var textfield2 = t2.cloneNode(true);
		textfield2.setAttribute("id", "reason_verb[" + count2 + "]");
		textfield2.setAttribute("name", "reason_verb[" + count2 + "]");
		textfield2.setAttribute("value", "");

		var t3 = document.getElementById("sugg[0]");
		var textfield3 = t3.cloneNode(true);
		textfield3.setAttribute("id", "sugg[" + count2 + "]");
		textfield3.setAttribute("name", "sugg[" + count2 + "]");
		textfield3.setAttribute("value", "");

		td1.innerHTML = "原因名词： ";
		td11.appendChild(textfield1);
		td2.innerHTML = "原因动词： ";
		td21.appendChild(textfield2);
		td3.innerHTML = "规则建议： ";
		td31.appendChild(textfield3);

	}

	function deleteRecord(table) {
		if (table.rows.length > 6) {
			table.deleteRow(table.rows.length - 1);
			table.deleteRow(table.rows.length - 1);
			table.deleteRow(table.rows.length - 1);
			count2= count2-1;
		}

	}
</script>

</head>

<body>
	<div id="rightmain">
		<h2>规则录入界面</h2>
<div id="login">
		<s:form action="ruleaction!newAdd.action">
			
					<table width="500" align="center" id="adreasontable" >
						<tr><td align="right">选件检测节点：</td> 
							<td><s:set name="foobar"
									value="#{'点源':{'电石厂有机水', '有机合成厂有机水', '炼油厂有机水', '精细化工厂废水', '乙二醇废水', '有机合成厂有机水', '炼油厂有机水', '有机合成厂有机水', '炼油厂有机水'
                                 , '环氧乙烷废水', '农药厂有机水', '含氮废水', '103厂碱水', '化肥厂丁辛醇', '丙烯腈废水', '合成树脂厂有机水', '龙潭区生活水'},
                       '中和处理':{'染料厂酸水', ' 电石厂酸水', '铁运489沉淀池出水 '}, 
                       '生活水处理': {'14a', '14b'},
                       '预处理': {'稳流池(477)进水', '进水提升泵房(462A)', '巴氏计量槽(499)', '除色池(414)', 
                               '沉沙刮沙池(488)', '事故池(489)','初沉池(489B)', '14B生活水 老水解酸化池 ',' 新水解酸化池 污泥泵房(466)',' 浓缩池(491)','脱水装置(495)'},
                        '生化处理': {'中间提升泵房(462B)','生化池系列1(1号生化池)','生化池系列1(2号生化池)','生化池系列2(3号生化池)','生化池系列2(4号生化池)',
                                 '生化池系列3(5号生化池)','生化池系列3(6号生化池)','生化池系列4(7号生化池)','生化池系列4(8号生化池)','1系列二沉池 ','2系列二沉池',
                                  '3系列二沉池 ','4系列二沉池','接触氧化池 ','3系列排江出口线','1、2、4系列排江出口线 ','1、2系列465回流泵房 ','3系列465A回流泵房 ','3系列465B回流泵房'}}" />
								<div class="nobr">
									<s:doubleselect list="#foobar.keySet()" doubleName="resultn1"
										doubleList="#foobar[top]" theme="simple" />
								</div></td>
						</tr>
						<tr>
							<td align="right">选择节点参数：</td><td> <select name="resultn2" size="1" style="width: 150px">
									<option>溶解氧</option>
									<option>PH</option>
									<option>NH3-N</option>
									<option>COD</option>
									<option>SS</option>
									<option>碱度</option>
									<option>BOD5</option>
									<option>硝态氮</option>
									<option>风量</option>
									<option>NO-N</option>
									<option>水量</option>
							</select></td>
						</tr>

						<tr>
							<td align="right">选择参数状态：</td><td> <select name="resultv_value" style="width: 150px">
									<option value="0">高于最高值</option>
									<option value="1">低于最低值</option>
							</select></td>
						</tr>
				<tr><td align="right">原因名词：</td><td> <s:textfield name="reason_noun[0]"  id="reason_noun[0]"  theme = "simple" style="{width=300}"/> </td></tr>				
				<tr>	<td align="right">原因动词：</td><td> <s:textfield name="reason_verb[0]"  id="reason_verb[0]"  theme = "simple" style="{width=300}"/></td>
				<tr><td align="right">规则建议：</td><td> <s:textfield name="sugg[0]"  id="sugg[0]"  theme = "simple" style="{width=300}"/></td>	</tr>
			</table>
			<table>
				<tr>
					<td align="right"><input name="addone" type="button" value=" 新建一条 " onClick="insertReason()" /></td>
					<td align="right">&nbsp;&nbsp;</td>
					<td align="right"><input name="dele" type="button" value=" 删除一条 " onclick="deleteRecord(adreasontable)" /></td>
					<td align="right">&nbsp;&nbsp;</td>
					<td align="right"><input name="Input21" type="submit" value="录入" /></td>
					<td align="right">&nbsp;&nbsp;</td>
					<td align="left"><input name="Input22" type="submit" 	value="取消" /></td>
				</tr>
			</table>
		</s:form>
		</div>
	</div>
</body>
</html>
