<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "No-cache");//HTTP 1.1
	response.setHeader("Cache-Control", "no-cache");//HTTP 1.0
	response.setHeader("Expires", "0");//防止被proxy
%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><decorator:title default="吉化污水处理过程模拟与优化系统" /></title>
<link href="/diagnosis/css/css.css" rel="stylesheet" type="text/css" />
<link href="/diagnosis/css/main.css" rel="stylesheet" type="text/css" />
<link href="/diagnosis/css/tree.css" rel="stylesheet" type="text/css" />
<decorator:head />
<style type="text/css">

</style>

</head>

<body>
	<div id="maincontent">
		<table align="center" width="1000">
			<tr>
				<td align="left" id="header" height="100"></td>
			</tr>
		</table>
		<table align="center" width="1000">
			<tr>
				<td valign="top">
					<div id="leftmenu" align="left">
					
						<div class="CNLTreeMenu" id="CNLTreeMenu2"  style="  width:180px;margin-left:18px;border:solid #90BADE thin ">
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
							       <li class="Child">染料厂酸水</li>
							       <li class="Child">电石厂酸水</li>
							       <li class="Child">电石厂有机水</li>
							       <li class="Child">有机合成厂有机水</li>
							       <li class="Child">炼油厂有机水</li>
							       <li class="Child">精细化工厂废水</li>
							       <li class="Child">乙二醇废水</li>
							       <li class="Child">环氧乙烷废水</li>
							       <li class="Child">农药厂有机水</li>
							       <li class="Child">铁运489沉淀池出水</li>
							       <li class="Child">含氮废水</li>
							       <li class="Child">103厂碱水</li>
							       <li class="Child">化肥厂丁辛醇</li>
							       <li class="Child">丙烯腈废水</li>
							       <li class="Child">合成树脂厂有机水</li>
							       <li class="Child">龙潭区生活水</li>
							       <li class="Child">中部基地有机水</li>
							    </ul>
							  </li>
							  <li class="Closed">中和处理</li>
							  <li class="Closed">生活水处理</li>
							  <li class="Closed">预处理
							    <ul>
							       <li class="Child">稳流池(477)进水</li>
							       <li class="Child">进水提升泵房(462A)</li>
							       <li class="Child">巴氏计量槽（499）</li>
							       <li class="Child">除色池(414)</li>
							       <li class="Child">沉沙刮沙池(488)</li>
							       <li class="Child">初沉池(489B)</li>
							       <li class="Child">事故池(489)</li>
							       <li class="Child">14B生活水</li>
							       <li class="Child">1#水解酸化池</li>
							       <li class="Child">2#水解酸化池</li>
							    </ul>
							  </li>
								<li class="Closed">生化处理
									<ul>
										<li class="Child">中间提升泵房(462)</li>
										<li class="Child">中间提升泵房(462B)</li>
										<li class="Child"><a href="/diagnosis/biocpool490/biocpool1.jsp">生化池系列1</a></li>	
									  <li class="Child"><a href="/diagnosis/biocpool490/biocpool2.jsp">生化池系列2</a></li>
										<li class="Child"><a href="/diagnosis/biocpool490/biocpool3.jsp">生化池系列3</a></li>
										<li class="Child"><a href="/diagnosis/biocpool490/biocpool4.jsp">生化池系列4</a></li>
										<li class="Child">1系列二沉池</li>
										<li class="Child">2系列二沉池</li>
										<li class="Child">3系列二沉池</li>
										<li class="Child">4系列二沉池</li>
										<li class="Child">接触氧化池</li>
										<li class="Child">2系列排江出口线</li>
										<li class="Child">1、3系列排江出口线</li>
									</ul>
								</li>
								<li class="Closed">污泥处理
									<ul>
										<li class="Child">1系列(465)回流泵房</li>
										<li class="Child">2系列(465A)回流泵房</li>
										<li class="Child">3系列(465B)回流泵房</li>
							       <li class="Child">污泥池(V466)</li>
							       <li class="Child">浓缩池(491)</li>
							       <li class="Child">脱水装置(495)</li>
									</ul>
								</li>
								
							</ul>
						</div>
						<!-- CNLTreeMenu -->
					</div>
				</td>
				<td width="100%">
					<table width="100%" height="100%">
						<tr>
							<td id="pageTitle">
								<!--decorator:title/-->
							</td>
						</tr>
						<tr>
							<td valign="top" height="100%"><div id="rightmain">
									<decorator:body />
								</div></td>
						</tr>

					</table>
				</td>
			</tr>

		</table>
		<table align="center" width="1000">
			<tr>
				<td id="footer">
					<div id="footer">
						<p>使用单位: 中国石油吉林化工公司污水处理厂</p>
						<p>COPYRIGHT&copy;2011 CNPC ALL RIGHT RESERVED</p>
					</div>
					<div id="banner"></div>
				</td>
			</tr>
		</table>
	</div>


	<script type="text/javascript">
	<!--
		function Ob(o) {
			var o = document.getElementById(o) ? document.getElementById(o) : o;
			return o;
		}
		function Hd(o) {
			Ob(o).style.display = "none";
		}
		function Sw(o) {
			Ob(o).style.display = "";
		}
		function ExCls(o, a, b, n) {
			var o = Ob(o);
			for (i = 0; i < n; i++) {
				o = o.parentNode;
			}
			o.className = o.className == a ? b : a;
		}
		function CNLTreeMenu(id, TagName0) {
			this.id = id;
			this.TagName0 = TagName0 == "" ? "li" : TagName0;
			this.AllNodes = Ob(this.id).getElementsByTagName(TagName0);
			this.InitCss = function(ClassName0, ClassName1, ClassName2, ImgUrl) {
				this.ClassName0 = ClassName0;
				this.ClassName1 = ClassName1;
				this.ClassName2 = ClassName2;
				this.ImgUrl = ImgUrl || "/diagnosis/images/s.gif";
				this.ImgBlankA = "<img src=\"" + this.ImgUrl
						+ "\" class=\"s\" onclick=\"ExCls(this,'" + ClassName0
						+ "','" + ClassName1 + "',1);\" alt=\"展开/折叠\" />";
				this.ImgBlankB = "<img src=\""+this.ImgUrl+"\" class=\"s\" />";
				for (i = 0; i < this.AllNodes.length; i++) {
					this.AllNodes[i].className == "" ? this.AllNodes[i].className = ClassName1
							: "";
					this.AllNodes[i].innerHTML = (this.AllNodes[i].className == ClassName2 ? this.ImgBlankB
							: this.ImgBlankA)
							+ this.AllNodes[i].innerHTML;
				}
			}
			this.SetNodes = function(n) {
				var sClsName = n == 0 ? this.ClassName0 : this.ClassName1;
				for (i = 0; i < this.AllNodes.length; i++) {
					this.AllNodes[i].className == this.ClassName2 ? ""
							: this.AllNodes[i].className = sClsName;
				}
			}
		}

		var MyCNLTreeMenu2 = new CNLTreeMenu("CNLTreeMenu2", "li");
		MyCNLTreeMenu2.InitCss("Opened", "Closed", "Child",
				"/diagnosis/images/s.gif");
	</script>

</body>

</html>