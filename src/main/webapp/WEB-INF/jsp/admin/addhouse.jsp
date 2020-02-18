<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0" />
    <style type="text/css">
        #l-map{height:300px;width:100%;}
        #r-result{width:100%;}
    </style>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=UyuVONEtIuG8g0RiR47I8e0alOjGG4cv"></script>
    <title>添加房源</title>
    <script type="text/javascript" src="/js/jquery.validate.min.js"></script>
   <style>
   

.error1 {
  
  font-size:13px;
  color: red;
  
}

   </style>
    <script type="text/javascript">
    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        $("#myform").validate({
        	
            rules : {
            	houseid : {
                    required : true,
                },
               
                address : {
                    required : true,
                  
                },
                area : {
                    required : true,
                    min: 0
                  
                },
                price: {
                    required : true,
                    min: 0
                  
                }
                
            },
            messages : {
            	houseid : {
                    required : "房屋id不能为空！",
                },
               
                address : {
                    required : "地址不能为空！",
                  
                },
                area : {
                    required : "面积不能为空！",
                    min:"请输入正确的面积"
                  
                },
                price: {
                    required :  "价格不能为空！",
                    min:"请输入正确的租金"
                  
                }
                
            }
        });
    })
	</script>
	
</head>
<body>

<div class="result-title">
<h1>添加房源</h1>
</div>
<div class="result-content">
<div class="sidebar-title">
        <form  method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                                <th><i class="require-red">*</i>房屋id：</th>
                                <td>
                                    <input class="common-text required" value="${houselist.houseid}" id="houseid" name="houseid" size="50" type="text">
                                </td>
                            </tr>
                                <div id="l-map"></div>
                                <div id="r-result">请输入地址:
                                    <input type="text" id="suggestId" size="20" value="百度" style="width:150px;"/>
                                <button id="getX" type="button">确认地址</button></div>
                                <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;" ></div>


                                <th><i class="require-red">*</i>面积：</th>
                                <td><input class="common-text" name="area" value="${houselist.area }" id="area" size="50" type="text" ></td>
                            </tr>
                           <tr>
                                <th><i class="require-red">*</i>租金：</th>
                                <td><input class="common-text" name="price" value="${houselist.price }" id="price" size="50" type="text"></td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>状态：</th>
                              <td>
                                <select name="status" id="status" class="required">
                                
                                <option value="已租赁" <c:if test="${houselist.status == '已租赁'}">selected</c:if>>已租赁</option>  
                            <option value="未租赁" <c:if test="${houselist.status == '未租赁'}">selected</c:if>>未租赁</option> 
                                </select>
                            </td>
                            </tr>
								<tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" id="toGetMapButton" value="提交" >
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
							<tr>
                                <font id="error1" color="red">${msg }</font>
                            </tr>	
                        </tbody></table>
                </form>
          </div>
          </div>
</body>
</html>

<script type="text/javascript">

    // 百度地图API功能
    function G(id) {
        return document.getElementById(id);
    }

    var map = new BMap.Map("l-map");
    map.centerAndZoom("西安",12);                   // 初始化地图,设置城市和地图级别。
    map.enableScrollWheelZoom(true);
    var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
        {"input" : "suggestId"
            ,"location" : map
        });

    ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
        var str = "";
        var _value = e.fromitem.value;
        var value = "";
        if (e.fromitem.index > -1) {
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }
        str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

        value = "";
        if (e.toitem.index > -1) {
            _value = e.toitem.value;
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }
        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
        G("searchResultPanel").innerHTML = str;
    });

    var myValue;
    ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
        var _value = e.item.value;
        myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

        setPlace();
    });
    var pp;
    function setPlace(){
        map.clearOverlays();    //清除地图上所有覆盖物
        function myFun(){
            pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
            map.centerAndZoom(pp, 18);

            map.addOverlay(new BMap.Marker(pp));    //添加标注
        }
        var local = new BMap.LocalSearch(map, { //智能搜索
            onSearchComplete: myFun
        });
        local.search(myValue);
    }
    $(getX).click(function(){
        $("#suggestId").prop('disabled','disabled');
        alert(pp.lng+"和维度"+pp.lat);
    });
    $(toGetMapButton).click(function () {
        var houseid=$('#houseid').val();
        var address=$('#suggestId').val();
        var area=$('#area').val();
        var price=$('#price').val();
        var status=$('#status').val();
        if (pp==null){
            alert("请确定地址！");
        }
        var x=pp.lng;
        var y=pp.lat;
        // var content="地址："+address+"<br/>价格："+price+"<br/>状态："+status;
        var content="地址："+address+"<br/>价格："+price+"<br/>状态："+status+"<br/><button id='btn'>我要租赁</button>"
         $.ajax({
             url:"addhouse",
             dataType:"text",
             type:"post",
             data:{
               "houseid":  houseid,
                 "address":  address,
                 "area":  area,
                 "price":  price,
                 "status":  status,
                 "x":  x,
                 "y":  y,
                 "content":  content
             },
             success:function (res) {
                 if (res=='添加成功！'){
                     alert("添加成功");
                 } else{
                     alert("添加失败："+res);
                 }

                 console.log("成功")
             },
             error:function () {
                 alert("请求失败！");
                 // alert("执行失败");
             }

         });

    });
</script>