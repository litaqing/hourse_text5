
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login</title>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <style type="text/css">
        body {
            background: url("img/book.jpg");
        }
        .form {
            background: rgba(255, 255, 255, 0.2);
            width: 400px;
            margin: 150px auto;
        }
    </style>
    <script type="text/javascript">
        function goback() {
            window.open("login.jsp", "_self");
        }


        function register() {
            //jQuery写法
            var user = $('#user').val();
            var password = $('#password').val();


            $.ajax({
                type: "post", //post put get 等等
                url: "register.ashx",
                //编写注册功能时，要将异步设置为false（缺省为true）
                //如果async是ture,对于FireFox浏览器，会刷新掉alert()弹出框的内容
                //对于Chrome浏览器，第一次注册时会执行error的回调函数，输出“请求在连接过程中出现错误..”
                async: false,
                data: { //要传入ashx文件的数据
                    "user": username,
                    "password": password
                },
                success: function(data, textStatus) {
                    //连接至ashx文件成功时，执行函数
                    //data是从ashx文件返回来的信息，可以是字符串也可以是一个对象
                    //如果data是字符串，则可以输出data的值
                    //如果data是对象，则可以将这个对象的各属性值赋给其他变量
                    //textStatus是表示状态的字符串，这里textStatus的值是"success"
                    alert(data);
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) { //连接至ashx文件失败时，执行函数
                    //XMLHttpRequest在这个例子里没有用到
                    //textStatus是表示状态的字符串，这里textStatus的值是"error"
                    //errorThrown包含连接失败的信息，可以输出查看
                    alert("请求在连接过程中出现错误..\n" + errorThrown);
                }
            });
        }
    </script>


</head>

<body>
<div class="container">



    <form role="form" class="form" id="loginform" action="logincheck.action" method="post">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">登陆</h3>
                <div class="col-md-9">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="用户名" id="username"  name="username" autofocus="autofocus" maxlength="20" />
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码" id="password" name="password" maxlength="8" />
                    </div>
                    <label>
                        <input type="radio" id="admin" type="radio" name="type" value="admin"  checked>
                        管理员
                    </label>
                    <label>
                        <input type="radio" id="zuke" type="radio" name="type" value="zuke">
                        租客
                    </label>
                    <div class="form-group col-md-offset-9">
                        <button type="submit"   id="login-button" class="btn btn-success pull-right" name="submit">确定</button>
                        <button type="button" class="btn btn-link" onclick="goback()">返回</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>