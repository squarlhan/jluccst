<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据树</title>
    <link href="/diagnosis/css/css.css" rel="stylesheet" type="text/css" />
    <link href="/diagnosis/css/main.css" rel="stylesheet" type="text/css" />
    <link href="/diagnosis/css/tree.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  
   <div class="CNLTreeMenu" id="CNLTreeMenu2"  style=" margin-top:36px; width:180px;margin-left:0px;overflow-y:auto;height: 360px; width: 200px; ">
							<p>
								<a id="AllOpen_2"
									onclick="MyCNLTreeMenu2.SetNodes(0);Hd(this);Sw('AllClose_2');">全部展开</a><a
									id="AllClose_2"
									onclick="MyCNLTreeMenu2.SetNodes(1);Hd(this);Sw('AllOpen_2');"
									style="display: none;">全部折叠</a>
							</p>
							    <ul>
							  <li class="Closed">点源处理
							    <ul>
							      
							       <li class="Child"><a href="/diagnosis/dataadd/datadianshichang.jsp">电石厂有机水</a></li>
							      
							       <li class="Child"><a href="/diagnosis/dataadd/datahechengchang.jsp">有机合成厂有机水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datalianyouchang.jsp">炼油厂有机水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datajingxi.jsp">精细化工厂废水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datayierchun.jsp">乙二醇废水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datahuanyang.jsp">环氧乙烷废水</a></li>
							      
							       <li class="Child"><a href="/diagnosis/dataadd/datanongyaochang.jsp">农药厂有机水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datahandan.jsp">含氮废水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/data103.jsp">103厂碱水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datahuafei.jsp">化肥厂丁辛醇</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/databingxi.jsp">丙烯腈废水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datashuzhi.jsp">合成树脂厂有机水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datalongtan.jsp">龙潭区生活水</a></li>
							      
							    </ul>
							  </li>
							  <li class="Closed">中和处理
							   <ul>
							      <li class="Child"><a href="/diagnosis/dataadd/dataranliao.jsp">染料厂酸水</a></li>
							      <li class="Child"><a href="/diagnosis/dataadd/datadianshichang.jsp">电石厂酸水</a></li> 
							       <li class="Child"><a href="/diagnosis/dataadd/data489.jsp">铁运489沉淀池出水</a></li>
							   </ul>
							  </li>
							  <li class="Closed">生活水处理
							   <ul>
							    <li class="Child"><a href="/diagnosis/dataadd/data14a.jsp">14a工业水</a></li>
							   <li class="Child"><a href="/diagnosis/dataadd/data14b.jsp">14b生活水</a></li>
							    </ul>
							  </li>
							  <li class="Closed">预处理
							    <ul>
							       <li class="Child"><a href="/diagnosis/dataadd/datawenliuchi.jsp">稳流池(477)进水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datajinshui.jsp">进水提升泵房(462A)</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/databashi.jsp">巴氏计量槽（499）</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datachusechi(414).jsp">除色池(414)</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datachenshaguashachi(488).jsp">沉沙刮沙池(488)</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datachuchenshi(489B).jsp">初沉池(489B)</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datashuguchi(489).jsp">事故池(489)</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/data14Bshenghuoshui.jsp">14B生活水</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/datalaoshuijiesuanhuachi.jsp">老水解酸化池</a></li>
							       <li class="Child"><a href="/diagnosis/dataadd/dataxinshuijiesuanhuachi.jsp">新水解酸化池</a></li>
							      
							       <li class="Child"><a href="/diagnosis/dataadd/datawunichi(V466).jsp">污泥泵房(466)</a></li>
							       <li class="Child">浓缩池(491)</li>
							       <li class="Child"><a href="/diagnosis/dataadd/datatuoshuizhuangzhi(495).jsp">脱水装置(495)</a></li>
							    </ul>
							  </li>
								<li class="Closed">生化处理
									<ul>
										 <li class="Child"><a href="/diagnosis/dataadd/data465huiliubengfang--1.jsp">1系列465回流泵房</a></li>
								         <li class="Child"><a href="/diagnosis/dataadd/data465Ahuiliubengfang--2.jsp">2系列465A回流泵房</a></li>
								         <li class="Child"><a href="/diagnosis/dataadd/data465Bhuiliubengfang--3.jsp">3系列465B回流泵房</a></li>
										 <li class="Child"><a href="/diagnosis/dataadd/datazhongjiantishengbengfang(462B).jsp">中间提升泵房(462B)</a></li>
										 <li class="Child"><a href="/diagnosis/biocpool490/biocpool1.jsp">生化池系列1</a></li>	
									     <li class="Child"><a href="/diagnosis/biocpool490/biocpool2.jsp">生化池系列2</a></li>
										<li class="Child"><a href="/diagnosis/biocpool490/biocpool3.jsp">生化池系列3</a></li>
										<li class="Child"><a href="/diagnosis/biocpool490/biocpool4.jsp">生化池系列4</a></li>
										<li class="Child"><a href="/diagnosis/dataadd/dataerchenchi--1.jsp">1系列二沉池</a></li>
										<li class="Child"><a href="/diagnosis/dataadd/dataerchenchi--2.jsp">2系列二沉池</a></li>
										<li class="Child"><a href="/diagnosis/dataadd/dataerchenchi--3.jsp">3系列二沉池</a></li>
										<li class="Child"><a href="/diagnosis/dataadd/dataerchenchi--4.jsp">4系列二沉池</a></li>
										<li class="Child"><a href="/diagnosis/dataadd/datajiechuyanghuachi.jsp">接触氧化池</a></li>
										<li class="Child"><a href="/diagnosis/dataadd/datapaijiangxian.jsp">排江出口线</a></li>
										
									</ul>
								</li>
								
							</ul>
						</div>
						<!-- CNLTreeMenu -->
  </body>
</html>