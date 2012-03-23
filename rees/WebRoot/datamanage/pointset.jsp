<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/script-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>图型方式设备监测点</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<j:scriptlink jquery="true" livequery="true" poshytip="true" contextmenu="true" jqueryui="true" tipswindow="true"/>
	<script type="text/javascript">
		$(function(){
			//动态绑定检测点
			$(".pointDiv").livequery(function () {
				//注册提示
				$(this).poshytip({
					className: 'tip-twitter',
					showTimeout: 0,
					showOn: 'none',
					alignTo: 'target',
					alignX: 'center',
					offsetY: 10,
					allowTipHover: true,
					fade: true
				});
				//直接显示提示
				$(this).poshytip('show');
				//注册拖动事件
                $(this).draggable({
                    stop: function (event, ui) {
                        var obj = this;
                        var x = $(obj).position().left;
                        var y = $(obj).position().top;
						$("#debug").html("X:" + x + ",Y:" + y);
						$(this).poshytip('show');
                    },
                    start: function () {
                        //将这个div放到最上层
                        $(".pointDiv").css("z-index", "99998");
                        $(this).css("z-index", "99999");
						$(this).poshytip('hide');
                    }
                });
				//检测点绑定右键菜单事件
				$(this).contextMenu('pointMenu', {
					bindings: {
						'delete': function(t) {
							var pointId = $(t).attr("id");
							//删除气泡提示（一定在在检测点删除之前删除）
							$(t).poshytip('hide');
							//删除检测点
							$(t).remove();
							if(pointId!=null&&pointId!=""){
								$.getJSON("deletepointajax.action", {pointId:pointId}, function(json){
									//
								});
							}
						}
					}
				});
            });
			
			//设备图片绑定右键菜单事件
			$('#picture').contextMenu('plantMenu', {
				bindings: {
					'new': function(t) {
						//判断菜单位置
						var x = $("#jqContextMenu").css("left");
						var y = $("#jqContextMenu").css("top");
						//新建检测点
						$("#picture").prepend('<div class="pointDiv" style="position:absolute; top:' + y + '; left:' + x + '" title="no data"><img src="${pageContext.request.contextPath}/images/ico/point.png"/></div>');
					},
					'save': function(t) {
						var position;
						var ids;
						var positionX;
						var positionY;
						var jsonstring = "";
						$.each($(".pointDiv"), function(i, domEle){
							position = $(domEle).position();
							if (i == 0)
								jsonstring = jsonstring + $("#picture").attr("deviceId") + '|' + $(domEle).attr("id") + '|' + position.left + '|' + position.top;
							else
								jsonstring = jsonstring + ',' + $("#picture").attr("deviceId") + '|' + $(domEle).attr("id") + '|' + position.left + '|' + position.top;
						});
						$.getJSON("positionsetajax.action", {datas:jsonstring,deviceId:$("#picture").attr("deviceId")}, function(json){
							alert("保存检测点信息成功！");
						});
					}
				}
			});
		});
	</script>
	<style type="text/css">
		body{ font-size: 12px; }
		.pointDiv{ width:16px; height:16px; cursor: pointer; }
		img{ border: none; }
		#picture{ position:relative; top:0px; width:1280px; height:1024px; margin:0px auto; background:#FFF url('${pageContext.request.contextPath}/uploadfiles/deviceimages/20090818_06277f0092db2d35de230oYpx0YhDCIy.jpg'); overflow:hidden; }
		.contextMenu{ display:none; }
	</style>
</head>

<body>
	<div class="contextMenu" id="pointMenu">
      <ul>
        <li id="delete"><img src="${pageContext.request.contextPath}/images/menu/bin_empty.png" />&nbsp;删除检测点</li>
      </ul>
    </div>
	<div class="contextMenu" id="plantMenu">
      <ul>
        <li id="new"><img src="${pageContext.request.contextPath}/images/menu/page_portrait.png" />&nbsp;新建检测点</li>
		<li id="save"><img src="${pageContext.request.contextPath}/images/menu/save.png" />&nbsp;保存检测点</li>
      </ul>
    </div>
	<div id="picture" deviceId="222" devicePic="">
		<div id="debug" style="color:white"></div>
		<s:iterator value="pointInfoList" status="st">
			<div id="<s:property value="id"/>" class="pointDiv" style="position:absolute; top:<s:property value='positionY'/>px; left:<s:property value='positionX'/>px" title="<div><s:property value='controlPointName'/></div><div>no data</div>">
				<img src="${pageContext.request.contextPath}/images/ico/point.png"/>
			</div>
   		</s:iterator>
	</div>
</body>
</html>
