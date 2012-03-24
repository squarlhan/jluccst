<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<j:scriptlink css="true" jquery="true" mztreeview="true" />
	</head>
	<body style="padding: 5px;">
		<div class="dtree">
			<script type="text/javascript">
			var data={};
	        data["-1_1"] = "text: 中石油;";
	        
	        Using("System.Web.UI.WebControls.MzTreeView");
	        var a = new MzTreeView();
	        a.dataSource = data
	        var jsPage = "${pageContext.request.contextPath}/js/mztreeview/csdn/community/treedata/jsdemo.js";
	        a.loadJsData(jsPage);
	        
	        //把指定节点id做为根节点显示
	        a.rootId="1";
	        
	        //自动排序
	        a.autoSort=false;
	        //是否显示checkbox
	        a.useCheckbox=false
	        a.canOperate=false;
	        document.write(a.render());
	        //默认展开层数
	        a.expandLevel(1);
		</script>
		</div>
	</body>
</html>
