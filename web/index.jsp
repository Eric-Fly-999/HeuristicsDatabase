<%--
  Created by IntelliJ IDEA.
  User: Ms.Zhong
  Date: 2022/6/11
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<script>
    $(document).ready(function () {
        var whei = $(window).width()
        $("html").css({ fontSize: whei / 24 });
        $(window).resize(function () {
            var whei = $(window).width();
            $("html").css({ fontSize: whei / 24 })
        });
    });
</script>
<div class="main">
    <div class="header">
        <div class="header-center fl">
            <div class="header-title">
                登录界面
            </div>
            <div class="header-img"></div>
        </div>
        <div class="header-bottom fl"></div>
    </div>

    <div class="content">
        <div class="content-left">
        </div>
        <div class="content-right">
            <div class="right-infp">
                <div class="username">用户名</div>
                <div class="right-infp-name">
                    <input type="text" name="username" placeholder="请输入用户名" maxlength="12" required="" value="" autocomplete="off">
                </div>
                <div class="password">密码</div>
                <div class="right-infp-name">
                    <input type="text" name="name" placeholder="请输入密码" autocomplete="off">
                </div>

                <div class="right-infp-btn">
                    <a href="main.jsp" class="btn">登录</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
