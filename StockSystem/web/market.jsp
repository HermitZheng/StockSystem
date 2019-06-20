<%@ page import="daos.MarketDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Market" %>
<%@ page import="beans.Commodity" %><%--
  Created by IntelliJ IDEA.
  User: Hanabi
  Date: 2019/6/18
  Time: 15:56
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
</head>
<body>

<ul class="layui-nav layui-bg-cyan"lay-filter="">
    <li class="layui-nav-item"><a href="menu.jsp">首页</a></li>
    <li class="layui-nav-item layui-this" id="market"><a href="market.jsp">超市信息</a></li>
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
    <%
        String marketId = (String)session.getAttribute("id");
        MarketDao marketDao = new MarketDao();
        Market market = marketDao.queryMarket(marketId);
        ArrayList coms = market.getGoods();
    %>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>商店信息</legend>
    </fieldset>

    <div style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">商店编号</div>
                    <div class="layui-card-body">
                        <%=market.getId()%><br>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">商店名</div>
                    <div class="layui-card-body">
                        <%=market.getName()%><br>
                    </div>
                </div>
            </div>
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header">商店地址</div>
                    <div class="layui-card-body">
                        <%=market.getAddress()%>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>本商店所售商品信息</legend>
    </fieldset>
        <div class="layui-form">
            <table class="layui-table">
                <colgroup>
                    <col width="200">
                    <col width="200">
                    <col width="200">
                </colgroup>
                <thead>
                <tr>
                    <th>商品编号</th>
                    <th>商品名</th>
                    <th>库存量</th>
                </tr>
                </thead>
                <%
                    Commodity commodity;
                    for (int i = 0; i < coms.size(); i++) {
                        commodity = (Commodity)coms.get(i);
                %>
                <tbody>
                <tr>
                    <td><%=commodity.getId()%></td>
                    <td><%=commodity.getComName()%></td>
                    <td><%=commodity.getStorage()%></td>
                </tr>
                </tbody>
                <%
                    }
                %>
            </table>
        </div>

</div>




</body>
</html>
