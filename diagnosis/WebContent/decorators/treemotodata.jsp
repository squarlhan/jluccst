<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DCS树</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/diagnosis/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/diagnosis/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/diagnosis/css/demo.css">
<script type="text/javascript" src="/diagnosis/js/jquery.min.js"></script>
<script type="text/javascript" src="/diagnosis/js/jquery.easyui.min.js"></script>
</head>
<body>

	<div style="margin-top: 16px; width: 200px; margin-left: 0px; overflow-y: auto; height: 400px; width: 220px;">
		<p>
			<!--<a href="javascript:void(0)" class="easyui-linkbutton" onclick="collapseAll()">全部折叠</a>  -->
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="getSelected()">展示</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="expandAll()">全部展开</a>
		</p>
		<ul id="tt" class="easyui-tree" data-options="animate:true">
			<li data-options="state:'closed'"><span>点源处理</span>
				<ul>
					<li><span>电石厂有机水</span></li>
					<li><span>有机合成厂有机水</span></li>
					<li><span>炼油厂有机水</span></li>
					<li><span>精细化工厂废水</span></li>
					<li><span>乙二醇废水</span></li>
					<li><span>环氧乙烷废水</span></li>
					<li><span>农药厂有机水</span></li>
					<li><span>含氮废水</span></li>
					<li><span>103厂碱水</span></li>
					<li><span>化肥厂丁辛醇</span></li>
					<li><span>丙烯腈废水</span></li>
					<li><span>合成树脂厂有机水</span></li>
					<li><span>龙潭区生活水</span></li>

				</ul>
			</li>
			<li data-options="state:'closed'"><span>中和处理</span>
				<ul>
					<li><span>染料厂酸水</span></li>
					<li><span>电石厂酸水</span></li>
					<li><span>铁运489沉淀池出水</span></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>生活水处理</span>
				<ul>
					<li><span>14a工业水</span></li>
					<li><span>14b生活水</span></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>预处理</span>
				<ul>
					<li><span>稳流池(477)进水</span></li>
					<li><span>进水提升泵房(462A)</span></li>
					<li><span>巴氏计量槽(499)</span></li>
					<li><span>除色池(414)</span></li>
					<li><span>沉沙刮沙池(488)</span></li>
					<li><span>初沉池(489B)</span></li>
					<li><span>事故池(489)</span></li>
					<li><span>14B生活水</span></li>
					<li><span>老水解酸化池</span></li>
					<li><span>新水解酸化池</span></li>
					<li><span>污泥泵房(466)</span></li>
					<li><span>浓缩池(491)</span></li>
					<li><span>脱水装置(495)</span></li>
				</ul>
			</li>
			<li data-options="state:'closed'"><span>生化处理</span>
				<ul>
					<li><span>1系列465回流泵房</span></li>
					<li><span>2系列465A回流泵房</span></li>
					<li><span>3系列465B回流泵房</span></li>
					<li><span>中间提升泵房(462B)</span></li>
					<li><span>鼓风机</span></li>
					<li><span>生化池系列1</span></li>
					<li><span>生化池系列2</span></li>
					<li><span>生化池系列3</span></li>
					<li><span>生化池系列4</span></li>
					<li><span>1系列二沉池</span></li>
					<li><span>2系列二沉池</span></li>
					<li><span>3系列二沉池</span></li>
					<li><span>4系列二沉池</span></li>
					<li><span>接触氧化池</span></li>
					<li><span>排江出口线</span></li>
				</ul>
			</li>
		</ul>
	</div>
	<script type="text/javascript">
        function collapseAll(){
            $('#tt').tree('collapseAll');
        }
        function expandAll(){
            $('#tt').tree('expandAll');
        }
        function expandTo(){
            var node = $('#tt').tree('find',113);
            $('#tt').tree('expandTo', node.target).tree('select', node.target);
        }
        function getSelected(){
            
		    var node = $('#tt').tree('getSelected');
			if (node) {
				var s = node.text;
				if ($('#tt').tree('isLeaf', node.target)) {
					s += "叶子";
			}

			alert(s);

			$.ajax({
				url : '/diagnosis/dcsdataaction!showmotodcsdata?keyword=' + s,
				cache : false,
				success : function(data) {
					eval('data=' + data);
					if (data.success) {
						alert('保存成功');
						window.location.href = 'Permission.aspx';
					}
				}
			});

			}
		}
		$(function() {
			$('#tt').tree({
				onClick : function(node) {
					getSelected();
				}
			});
		});
	</script>
</body>
</html>