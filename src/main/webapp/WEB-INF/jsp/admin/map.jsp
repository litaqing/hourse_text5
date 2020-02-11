<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0" />

    <style type="text/css">
      #allmap {width: 1200px;height: 400px;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=UyuVONEtIuG8g0RiR47I8e0alOjGG4cv"></script>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="//api.map.baidu.com/library/TextIconOverlay/1.2/src/TextIconOverlay_min.js"></script>
    <script type="text/javascript" src="//api.map.baidu.com/library/MarkerClusterer/1.2/src/MarkerClusterer_min.js"></script>
    <title>地图展示</title>
</head>
<body>
<div id="allmap"></div>
<H1>横坐标是：${mapList[0].x}</H1>


<button id="getM">获取</button>
</body>
</html>

<script type="text/javascript">

    <%--$(document).ready(function () {--%>
        <%--var data = [[${mapList}]];--%>
        <%--alert(data);--%>
      <%----%>
    <%--});--%>
        var data = eval('${mapList}');

        for (var i = 0; i < data.length; i++) {
            var array_element = data[i];
            console.log(array_element.x);

        }

    // 百度地图API功能
    var map = new BMap.Map("allmap");    // 创建Map实例
    map.centerAndZoom(new BMap.Point(118.871327,32.151263), 12);  // 初始化地图,设置中心点坐标和地图级别
    map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
    map.addControl(new BMap.NavigationControl({enableGeolocation:true}));
    map.addControl(new BMap.OverviewMapControl());
    map.setCurrentCity("南京");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

    //===================
    var xy = [
        {'x':118.777882,'y':32.059839},
        {'x':118.457882,'y':32.049839},
        {'x':118.62882,'y':32.039839},
        {'x':118.3882,'y':32.029839},
        {'x':118.6666,'y':32.019839},
        {'x':118.577882,'y':32.051839},
        {'x':118.377882,'y':32.052839},
        {'x':118.277882,'y':32.053839},
        {'x':118.177882,'y':32.054839},
        {'x':118.077882,'y':31.055839},
        {'x':118.795394,'y':32.027002}
    ];

    // var data_info = [[118.777882,32.059839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"],
    //     [118.457882,32.049839,"地址：北京市东城区东华门大街"],
    //     [118.62882,32.039839,"地址：北京市东城区正义路甲5号"],
    //     [118.3882,32.059839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"],
    //     [118.6666,32.019839,"地址：北京市东城区东华门大街"],
    //     [118.577882,32.051839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"],
    //     [118.377882,32.052839,"地址：北京市东城区东华门大街"],
    //     [118.277882,32.053839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"],
    //     [118.177882,32.054839,"地址：北京市东城区东华门大街"],
    //     [118.077882,31.055839,"地址：北京市东城区王府井大街88号乐天银泰百货八层"],
    //     [118.795394,32.027002,"地址：北京市东城区东华门大街"]
    // ];
    var markers = [];
    var pt = null;
    for (var i = 0; i < data.length; i++) {
        pt = new BMap.Point(data[i].x ,data[i].y);
        var ma=new BMap.Marker(pt);
        addClickHandler(data[i].content,ma);
        markers.push(ma);
    }

    //最简单的用法，生成一个marker数组，然后调用markerClusterer类即可。
    var markerClusterer = new BMapLib.MarkerClusterer(map,
        {
            markers:markers,
            girdSize : 100,
            styles : [{
                url:'./img/red.png',
                size: new BMap.Size(92, 92),
                backgroundColor : '#E64B4E'
            }],
        });
    markerClusterer.setMaxZoom(13);
    markerClusterer.setGridSize(100);

    var opts = {
        width : 250,     // 信息窗口宽度
        height: 80,     // 信息窗口高度
        title : "信息窗口" , // 信息窗口标题
        enableMessage:true//设置允许信息窗发送短息
    };
    //	for(var i=0;i<data_info.length;i++){
    //		var marker = new BMap.Marker(new BMap.Point(data_info[i][0],data_info[i][1]));  // 创建标注
    //		markers.push(marker);
    //		var content = data_info[i][2];
    //		map.addOverlay(marker);               // 将标注添加到地图中
    //		addClickHandler(content,marker);
    //	}
    function addClickHandler(content,marker){
        marker.addEventListener("click",function(e){
            openInfo(content,e)}
        );
    }
    function openInfo(content,e){
        var p = e.target;
        var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
        var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象
        map.openInfoWindow(infoWindow,point); //开启信息窗口
    }
    //
    //



    //================================================
    //	var xy1 = [	{'x':118.85952,'y':32.0711},
    //		{'x':118.651976,'y':32.047353},
    //		{'x':118.735051,'y':32.059839},
    //		{'x':118.777882,'y':32.054019},
    //		{'x':118.677882,'y':32.059839},
    //		{'x':118.787882,'y':32.079839},
    //		{'x':118.777982,'y':32.069839}];
    //	var markers1 = [];
    //	var pt = null;
    //	for (var i in xy1) {
    //	   pt = new BMap.Point(xy1[i].x , xy1[i].y);
    //	   markers1.push(new BMap.Marker(pt));
    //	}
    //
    //
    //	//最简单的用法，生成一个marker数组，然后调用markerClusterer类即可。
    //	var markerClusterer1 = new BMapLib.MarkerClusterer(map,
    //		{
    //			markers:markers1,
    //			girdSize : 100,
    //			styles : [{
    //	            url:'./img/blue.png',
    //	            size: new BMap.Size(92, 92),
    //				backgroundColor : '#4783E7'
    //			}],
    //		});
    //		markers1.forEach( function(item){
    //
    //          var label = new BMap.Label("我是文字标注哦",{offset:new BMap.Size(20,-10)});
    //			item.setLabel(label);
    //			console.log(item);
    //      })
    //	console.log(markers1);
    //	markerClusterer1.setMaxZoom(13);
    //	markerClusterer1.setGridSize(100);
    //	console.log(markerClusterer1);
    //	console.log(markerClusterer);

    //	Cluster.prototype.addLabel = function (marker) {
    //      //获取marker的坐标
    //      var position = marker.getPosition();
    //      //创建label
    //      var label = new BMap.Label({position : position});
    //      label.setStyle({
    //          height : '25px',
    //          color : "#fff",
    //          backgroundColor : this._styles[0].backgroundColor,
    //          border : 'none',
    //          borderRadius : "25px",
    //          fontWeight : 'bold',
    //      });
    //      var content = '<span style="color:'+this._styles[0].backgroundColor+'"><i class="fa fa-map-marker"></i></span>'+'<p style="padding:0px 13px;text-align:center;margin-top:5px;">哈哈这是一sssssssssssssss个点</p>';
    //      label.setContent(content)
    //      label.setPosition(position);
    //      this._labels.push(label);
    //      this._map.addOverlay(label);
    //  }

</script>
