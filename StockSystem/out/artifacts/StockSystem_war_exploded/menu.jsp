<%--
  Created by IntelliJ IDEA.
  User: Hanabi
  Date: 2019/6/6
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href=" <%=request.getContextPath()%>/layui/css/layui.css"  media="all">
    <script src="<%=request.getContextPath()%>/jquery-3.2.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <%
        String id = request.getParameter("id");
        if (id != null){
            session.setAttribute("id", id);
        }
    %>
    <style>
        .content {
            top: 180px;;
        }
    </style>
</head>
<body>

<ul class="layui-nav layui-bg-cyan"lay-filter="">
    <li class="layui-nav-item layui-this"><a href="menu.jsp">首页</a></li>
    <li class="layui-nav-item" id="market"><a href="market.jsp">超市信息</a></li>
    <li class="layui-nav-item">
        <a href="#">检索商品</a>
        <dl class="layui-nav-child">
            <dd><a href="commodity.jsp">按商品检索</a></dd>
            <dd><a href="stock.jsp">按供货商检索</a></dd>
        </dl></li>
    <li class="layui-nav-item" id="cart"><a href="cart.jsp">进货订单</a></li>
    <li class="layui-nav-item"><a href="login.jsp">退出</a></li>
</ul>

    <div class="layui-body content">
        <iframe src="welcome.jsp" frameborder="0" id="main"></iframe>
    </div>


<script>
    layui.use('element', function(){
        var element = layui.element,
            $ = layui.jquery;
    });

    $(function() {
        $('#market').on('click', function () {
            $(window.parent.document).find('#main').attr("src", "./market.jsp")
            $(this).addClass('layui-this').siblings().removeClass('layui-this');
        })
        $('#cart').on('click', function () {
            $(window.parent.document).find('#main').attr("src", "../market.jsp")
            $(this).addClass('layui-this').siblings().removeClass('layui-this');
        })
    })
</script>


</body>
</html>
