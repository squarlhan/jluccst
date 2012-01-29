<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DCS树</title>
    <link href="/diagnosis/css/css.css" rel="stylesheet" type="text/css" />
    <link href="/diagnosis/css/main.css" rel="stylesheet" type="text/css" />
    <link href="/diagnosis/css/tree.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  
   <div class="CNLTreeMenu" id="CNLTreeMenu2"  style="   margin-top:36px; width:180px;margin-left:0px ;overflow-y:auto;height: 360px; width: 200px; ">
							<p>
								<a id="AllOpen_2"
									onclick="MyCNLTreeMenu2.SetNodes(0);Hd(this);Sw('AllClose_2');">全部展开</a><a
									id="AllClose_2"
									onclick="MyCNLTreeMenu2.SetNodes(1);Hd(this);Sw('AllOpen_2');"
									style="display: none;">全部折叠</a>
							</p>
							    <ul>
							  <li class="Closed"><a href="/diagnosis/dcsdataaction!showmotodcsdatap?papkey=<%=java.net.URLEncoder.encode("点源处理","UTF-8")%>">点源处理</a>
							    <ul>
							      
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("电石厂有机水","UTF-8")%>">电石厂有机水</a></li>
							      
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("有机合成厂有机水","UTF-8")%>">有机合成厂有机水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("炼油厂有机水","UTF-8")%>">炼油厂有机水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("精细化工厂废水","UTF-8")%>">精细化工厂废水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("乙二醇废水","UTF-8")%>">乙二醇废水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("环氧乙烷废水","UTF-8")%>">环氧乙烷废水</a></li>
							      
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("农药厂有机水","UTF-8")%>">农药厂有机水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("含氮废水","UTF-8")%>">含氮废水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("103厂碱水","UTF-8")%>">103厂碱水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("化肥厂丁辛醇","UTF-8")%>">化肥厂丁辛醇</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("丙烯腈废水","UTF-8")%>">丙烯腈废水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("合成树脂厂有机水","UTF-8")%>">合成树脂厂有机水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("龙潭区生活水","UTF-8")%>">龙潭区生活水</a></li>
							      
							    </ul>
							  </li>
							  <li class="Closed"><a href="/diagnosis/dcsdataaction!showmotodcsdatap?papkey=<%=java.net.URLEncoder.encode("中和处理","UTF-8")%>">中和处理</a>
							   <ul>
							      <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("染料厂酸水","UTF-8")%>">染料厂酸水</a></li>
							      <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("电石厂酸水","UTF-8")%>">电石厂酸水</a></li> 
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("铁运489沉淀池出水","UTF-8")%>">铁运489沉淀池出水</a></li>
							   </ul>
							  </li>
							  <li class="Closed"><a href="/diagnosis/dcsdataaction!showmotodcsdatap?papkey=<%=java.net.URLEncoder.encode("生活水处理","UTF-8")%>">生活水处理</a>
							   <ul>
							    <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("14a生活水","UTF-8")%>">14a工业水</a></li>
							   <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("14b生活水","UTF-8")%>">14b生活水</a></li>
							    </ul>
							  </li>
							  <li class="Closed"><a href="/diagnosis/dcsdataaction!showmotodcsdatap?papkey=<%=java.net.URLEncoder.encode("预处理","UTF-8")%>">预处理</a>
							    <ul>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("稳流池(477)进水","UTF-8")%>">稳流池(477)进水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("进水提升泵房(462A)","UTF-8")%>">进水提升泵房(462A)</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("巴氏计量槽(499)","UTF-8")%>">巴氏计量槽(499)</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("除色池(414)","UTF-8")%>">除色池(414)</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("沉沙刮沙池(488)","UTF-8")%>">沉沙刮沙池(488)</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("初沉池(489B)","UTF-8")%>">初沉池(489B)</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("事故池(489)","UTF-8")%>">事故池(489)</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("14B生活水","UTF-8")%>">14B生活水</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("老水解酸化池","UTF-8")%>">老水解酸化池</a></li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("新水解酸化池","UTF-8")%>">新水解酸化池</a></li>
							      
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("污泥泵房(466)","UTF-8")%>">污泥泵房(466)</a></li>
							       <li class="Child">浓缩池(491)</li>
							       <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("脱水装置(495)","UTF-8")%>">脱水装置(495)</a></li>
							    </ul>
							  </li>
								<li class="Closed"><a href="/diagnosis/dcsdataaction!showmotodcsdatap?papkey=<%=java.net.URLEncoder.encode("生化处理","UTF-8")%>">生化处理</a>
									<ul>
										 <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("1系列465回流泵房","UTF-8")%>">1系列465回流泵房</a></li>
								         <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("2系列465A回流泵房","UTF-8")%>">2系列465A回流泵房</a></li>
								         <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("3系列465B回流泵房","UTF-8")%>">3系列465B回流泵房</a></li>
										 <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("中间提升泵房(462B)","UTF-8")%>">中间提升泵房(462B)</a></li>
										  <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("鼓风机","UTF-8")%>">鼓风机</a></li>	
										 <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("生化池系列1","UTF-8")%>">生化池系列1</a></li>	
									     <li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("生化池系列2","UTF-8")%>">生化池系列2</a></li>
										<li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("生化池系列3","UTF-8")%>">生化池系列3</a></li>
										<li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("生化池系列4","UTF-8")%>">生化池系列4</a></li>
										<li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("1系列二沉池","UTF-8")%>">1系列二沉池</a></li>
										<li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("2系列二沉池","UTF-8")%>">2系列二沉池</a></li>
										<li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("3系列二沉池","UTF-8")%>">3系列二沉池</a></li>
										<li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("4系列二沉池","UTF-8")%>">4系列二沉池</a></li>
										<li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("接触氧化池","UTF-8")%>">接触氧化池</a></li>
										<li class="Child"><a href="/diagnosis/dcsdataaction!showmotodcsdata?keyword=<%=java.net.URLEncoder.encode("排江出口线","UTF-8")%>">排江出口线</a></li>
										
									</ul>
								</li>
								
							</ul>
						</div>
						<!-- CNLTreeMenu -->
  </body>
</html>