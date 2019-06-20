        <%@ page import="java.util.ArrayList" %>
<%@ page import="beans.CommodityStock" %>
<%@ page import="beans.Cart" %>
<%@ page import="beans.DealCart" %><%--
  Created by IntelliJ IDEA.
  User: Hanabi
  Date: 2019/6/18
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href=" <%=request.getContextPath()%>/layui/css/layui.css"  media="all">
    <script src="<%=request.getContextPath()%>/jquery-3.2.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>

    <style>
        .content {
            top: 180px;;
        }
    </style>
    <script>
        layui.use('element', function(){
            var element = layui.element,
                $ = layui.jquery;
        });
    </script>
    <%
        ArrayList requestCarts = null;
        ArrayList sessionCarts = null;
        try {
            requestCarts = (ArrayList) request.getAttribute("carts");
            sessionCarts = (ArrayList) session.getAttribute("sessionCarts");
            DealCart dealCart = new DealCart();
            sessionCarts = dealCart.Deal(sessionCarts, requestCarts);
            session.setAttribute("sessionCarts", sessionCarts);
        } finally {
        }
    %>
</head>
<body>
    <%
        //String submit = (String) request.getAttribute("sub");
    %>

<ul class="layui-nav layui-bg-cyan"lay-filter="">
    <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/menu.jsp">首页</a></li>
    <li class="layui-nav-item" id="market"><a href="<%=request.getContextPath()%>/market.jsp">超市信息</a></li>
    <li class="layui-nav-item">
        <a href="#">检索商品</a>
        <dl class="layui-nav-child">
            <dd><a href="<%=request.getContextPath()%>/commodity.jsp">按商品检索</a></dd>
            <dd><a href="<%=request.getContextPath()%>/stock.jsp">按供货商检索</a></dd>
        </dl></li>
    <li class="layui-nav-item layui-this" id="cart"><a href="<%=request.getContextPath()%>/cart.jsp">进货订单</a></li>
    <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/login.jsp">退出</a></li>
</ul>


<div class="layui-body content">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>订单信息</legend>
</fieldset>
<div class="layui-form">
    <form action="<%=request.getContextPath()%>/servlets/DeleteServlet">
        <table class="layui-table">
            <colgroup>
                <col width="50">
                <col width="80">
                <col width="150">
                <col width="100">
                <col width="80">
                <col width="130">
                <col width="100">
                <col width="100">
                <col width="100">
                <col width="100">
            </colgroup>
            <thead>
            <tr>
                <th>序号</th>
                <th>商品编号</th>
                <th>商品名</th>
                <th>单价</th>
                <th>供应商编号</th>
                <th>供应商名</th>
                <th>数量</th>
                <th>总价</th>
                <th>删除数量</th>
                <th>删除</th>
            </tr>
            </thead>
            <%


                session.setAttribute("carts", sessionCarts);
                Cart cart;
                int Total = 0;
                if (sessionCarts != null) {
                    out.print("共有" + sessionCarts.size() + "条记录");
                    for (int i = 0; i < sessionCarts.size(); i++) {
                        cart = (Cart) sessionCarts.get(i);
                        Total += cart.getTotalPrice();
            %>
            <tbody>
            <tr>
                <td><%=i + 1%></td>
                <td><%=cart.getComId()%></td>
                <td><%=cart.getComName()%></td>
                <td><%=cart.getUnitPrice()%></td>
                <td><%=cart.getStoId()%></td>
                <td><%=cart.getStoName()%></td>
                <td><%=cart.getQuantity()%></td>
                <td><%=cart.getTotalPrice()%></td>
                <td><input type="text" class="input" placeholder="请输入删除数量" name="<%=i%>" id="<%=i%>"></td>
                <td><input type="submit" value="删除" class="layui-btn layui-btn-primary"></td>
            </tr>
            </tbody>
            <%
                    }
                }
            %>
        </table>
    </form>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px; font-size: 8px">
        <legend>订单总金额为<%=Total%>元</legend>
    </fieldset>
    <div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">

        <button data-method="notice" class="layui-btn">清空订单</button>
        <button data-method="submit" class="layui-btn">提交订单</button>
    </div>

</div>
</div>
<script>
    layui.use('layer', function() {
        var $ = layui.jquery, layer = layui.layer;
        //触发事件
        var active = {
            notice: function () {
                //公告
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: false,
                    area: '300px;',
                    shade: 0.8,
                    id: 'LAY_layuipro',
                    btn: ['清空', '取消'],
                    btnAlign: 'c',
                    moveType: 1,
                    content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">您确定要清空订单？</div>'
                    , success: function (layero) {
                        var btn = layero.find('.layui-layer-btn');
                        btn.find('.layui-layer-btn0').attr({
                            href: '<%=request.getContextPath()%>/servlets/ClearCartServlet'
                        })

                    }
                });
            },
            submit: function () {
                //公告
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: false,
                    area: '300px;',
                    shade: 0.8,
                    id: 'LAY_layuipro',
                    btn: ['提交', '取消'],
                    btnAlign: 'c',
                    moveType: 1,
                    content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">您确定要提交订单？</div>'
                    , success: function (layero) {
                        var btn = layero.find('.layui-layer-btn');
                        btn.find('.layui-layer-btn0').attr({
                            href: '<%=request.getContextPath()%>/servlets/SubmitCartServlet'
                        })

                    }
                });
            }
        };
        $('#layerDemo .layui-btn').on('click', function () {
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });

</script>

</body>
</html>
