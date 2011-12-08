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

<title>规则描述录入</title>
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
</head>

<body>
	<div id="rightmain">
		<h2>规则描述录入</h2>
		
		<div id="login">
			<s:form action="dcsdscribaction!addDescrib.action">
				<table width="500" align="center" style="margin-left: 30">
					<tr>
						<td align="right">检测节点：</td>
						<td align="left">
							<div class="nobr">
								<s:doubleselect theme="simple" name="dcsDscrib.eque" 
									list="#session.map2.keySet()" doubleName="dcsDscrib.item"
									doubleList="#session.map2[top]"  ></s:doubleselect>
							</div>
						</td>
					</tr>
					<tr>
					<tr>
						<td align="right">对应规则节点：</td>
						<td align="left"> <s:set name="foobar"
               value="#{'点源':{'电石厂有机水', '有机合成厂有机水', '炼油厂有机水', '精细化工厂废水', '乙二醇废水', '有机合成厂有机水', '炼油厂有机水', '有机合成厂有机水', '炼油厂有机水'
                                 , '环氧乙烷废水', '农药厂有机水', '含氮废水', '103厂碱水', '化肥厂丁辛醇', '丙烯腈废水', '合成树脂厂有机水', '龙潭区生活水'},
                       '中和处理':{'染料厂酸水', ' 电石厂酸水', '铁运489沉淀池出水 '}, 
                       '生活水处理': {'14a', '14b'},
                       '预处理': {'稳流池(477)进水', '进水提升泵房(462A)', '巴氏计量槽(499)', '除色池(414)', 
                               '沉沙刮沙池(488)', '事故池(489)','初沉池(489B)', '14B生活水 老水解酸化池 ',' 新水解酸化池 污泥泵房(466)',' 浓缩池(491)','脱水装置(495)'},
                        '生化处理': {'中间提升泵房(462B)','生化池系列1(1号生化池)','生化池系列1(2号生化池)','生化池系列2(3号生化池)','生化池系列2(4号生化池)',
                                 '生化池系列3(5号生化池)','生化池系列3(6号生化池)','生化池系列4(7号生化池)','生化池系列4(8号生化池)','1系列二沉池 ','2系列二沉池',
                                  '3系列二沉池 ','4系列二沉池','接触氧化池 ','3系列排江出口线','1、2、4系列排江出口线 ','1、2系列465回流泵房 ','3系列465A回流泵房 ','3系列465B回流泵房'}}"  />
					  <div class="nobr"> 
                    
             <s:doubleselect list="#foobar.keySet()"
                          doubleName="resultn1"
                          doubleList="#foobar[top]"
                          theme="simple"/> 
                          </div>             
					
					</td>
					</tr>
					<tr>
						<td align="right">对应规则参数：</td>
						<td align="left"><select name="dcsDscribname2" size="1" style="width: 150px">
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
						<td align="right">参数最小值：</td>
						<td align="left"><s:textfield name="dcsDscrib.lower"  size ="17" theme = "simple" onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td>
					</tr>
					<tr>
						<td align="right">参数最大值：</td>
						<td align="left"><s:textfield name="dcsDscrib.upper"  size ="17" theme = "simple" onKeyPress="if (event.keyCode!=46 && event.keyCode!=45 && (event.keyCode<48 || event.keyCode>57)) event.returnValue=false"/></td>
					</tr>
					<tr>
						<td align="right"><s:submit value="录入" theme="simple" />

						<td  align="left"><s:reset value="重置" theme="simple" /></td>
					</tr>
					</table>
			</s:form>
		</div>
	</div>
</body>
</html>
