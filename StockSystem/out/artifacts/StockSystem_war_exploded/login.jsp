<%--
  Created by IntelliJ IDEA.
  User: Hanabi
  Date: 2019/6/6
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
    </style>
    <link href="css.css" rel="stylesheet" type="text/css">
</head>
<body style="background:url(img/stocking_img.jpg); background-size:cover;">

    <%
        String isTrue = null;
        isTrue = request.getParameter("isTrue");
    %>
    <div class='login'>
        <div class="login-panel">
            <div class="login-title">
                <h1>超市订货系统</h1>
            </div>
            <div class="login-title">
                <h2> 登录界面</h2>
            </div>

            <form action="servlets/LoginServlet">
                <div class="login-container">
                    <input type="text" class="input" placeholder="请输入用户名" name="account">
                </div>
                <div class="login-container">
                    <input type="text"  class="input" placeholder="请输入密码" name="password">
                </div>
                <%
                    if (isTrue != null){
                %>
                <div class="login-fail">登录失败，请重新输入</div>
                <%
                    }
                %>
                <br>
                <br>
                <div class="login-container">
                    <input type="submit" value="登录" class="sub-login">
                </div>
            </form>
        </div>
    </div>

</body>
</html>
