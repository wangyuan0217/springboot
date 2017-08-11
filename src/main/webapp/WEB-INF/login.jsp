<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/11
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>
    <!--引入bootstrap样式-->
    <link href="${path}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body align="center">

<br><br>
<br><br>
<br><br>
<br><br>
<br><br>

<form action="" id="login"
      accept-charset="utf-8" method="post">

    <div>
        <label for="name">帐号：</label>
        <input class="btn btn-default" type="text" id="name" name="name"/>
    </div>
    <div style="margin-top:20px;">
        <label for="pass">密码：</label>
        <input class="btn btn-default" type="password" id="pass" name="pass"/>
    </div>

    <div style="margin-top:35px;">
        <input class="btn btn-default" type="button" value="登 录" style="width:220px;" onclick="webLogin()"/>
    </div>

    <img src="${path}/static/images/1.png"
         style="width: 200px;height: 100px;"/>

    <img src="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=611483611,2895064642&fm=117&gp=0.jpg"
         style="width: 200px;height: 100px;"/>

    <div style="margin-top:35px;">
        <span style="margin-top:35px;">${message}</span>
    </div>

</form>

<script type="text/javascript" src="${path}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.tips.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript">

    function webLogin() {
        if (checkNull()) {
            $.ajax({
                type: "GET",
                url: "/test/login",
                data: {
                    "name": $("#name").val(),
                    "pass": $("#pass").val()
                },
                dataType: "json",
                success: function (data) {
                    if (data.result == "1") {
                        window.location.href = "indexAction";  //??????
                    } else {
                        alert("error");
                    }
                }
            });
        }
    }

    function checkNull() {
        var name = $("#name").val();
        if ("" == name) {
            $("#name").tips({
                side: 3,
                msg: '账号不能为空',
                bg: '#AE81FF',
                time: 3
            });
//            $("#name").focus();    //让u标签获取输入焦点
            return false;   //返回false，打断js的执行
        }
        var pass = $("#pass").val();
        if (pass == "") {
            $("#pass").tips({
                side: 2,
                msg: '账号不能为空',
                bg: '#AE81FF',
                time: 3
            });
            $("#pass").focus();
            return false;
        }
        return true;
    }

</script>
</body>
</html>
