<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.CommodityStock" %><%--
  Created by IntelliJ IDEA.
  User: Hanabi
  Date: 2019/6/18
  Time: 19:27
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
        ArrayList comStocks = (ArrayList)request.getAttribute("comStocks");
    %>
</head>
<body>

<ul class="layui-nav layui-bg-cyan"lay-filter="">
    <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/menu.jsp">首页</a></li>
    <li class="layui-nav-item" id="market"><a href="<%=request.getContextPath()%>/market.jsp">超市信息</a></li>
    <li class="layui-nav-item">
        <a href="#">检索商品</a>
        <dl class="layui-nav-child layui-this">
            <dd><a href="<%=request.getContextPath()%>/commodity.jsp">按商品检索</a></dd>
            <dd><a href="<%=request.getContextPath()%>/stock.jsp">按供货商检索</a></dd>
        </dl></li>
    <li class="layui-nav-item" id="cart"><a href="<%=request.getContextPath()%>/cart.jsp">进货订单</a></li>
    <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/login.jsp">退出</a></li>
</ul>

<div class="layui-body content">
    <form action="<%=request.getContextPath()%>/servlets/CommoditySearchServlet">
    <div class="layui-form-item">
        <label class="layui-form-label">检索</label>
        <div class="layui-input-block">
            <input type="text" name="comInfo" lay-verify="required" lay-reqtext="输入为空，请重新输入" placeholder="请输入商品名或者商品编号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即搜索</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    </form>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>商品信息</legend>
    </fieldset>
    <div class="layui-form">
        <form action="<%=request.getContextPath()%>/servlets/AddServlet">
        <table class="layui-table">
            <colgroup>
                <col width="50">
                <col width="100">
                <col width="150">
                <col width="100">
                <col width="130">
                <col width="130">
                <col width="130">
                <col width="130">
            </colgroup>
            <thead>
            <tr>
                <th>序号</th>
                <th>商品编号</th>
                <th>商品名</th>
                <th>价格</th>
                <th>供应商编号</th>
                <th>供应商名</th>
                <th>购买数量</th>
                <th>购买</th>
            </tr>
            </thead>
            <%
                session.setAttribute("comStocks", comStocks);
                CommodityStock commodityStock;
                if (comStocks != null){
                    out.print("共搜索到" + comStocks.size() + "条记录");
                    for (int i = 0; i < comStocks.size(); i++) {
                        commodityStock = (CommodityStock)comStocks.get(i);
            %>
            <tbody>
            <tr>
                <td><%=i+1%></td>
                <td><%=commodityStock.getComId()%></td>
                <td><%=commodityStock.getComName()%></td>
                <td><%=commodityStock.getPrice()%></td>
                <td><%=commodityStock.getStockId()%></td>
                <td><%=commodityStock.getStockName()%></td>
                <td><input type="text" class="input" placeholder="请输入购买数量" name="<%=i%>" id="<%=i%>"></td>
                <!-- <td><a href="<%=request.getContextPath()%>/servlets/AddServlet?number=<%=i%>">购买</a> </td>  -->
                <td><input type="submit" value="添加" class="layui-btn layui-btn-primary"></td>
            </tr>
            </tbody>
            <%
                    }
                }
            %>
        </table>
        </form>
    </div>
</div>


</body>
</html>
