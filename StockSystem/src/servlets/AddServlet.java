package servlets;

import beans.Cart;
import beans.Commodity;
import beans.CommodityStock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8");
        PrintWriter out = response.getWriter();
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList comStocks = (ArrayList)request.getSession().getAttribute("comStocks") ;
        ArrayList carts = new ArrayList();

        for (int i = 0; i < comStocks.size(); i++) {
            String quantity = request.getParameter(String.valueOf(i));
            if (quantity != ""){
                System.out.println(quantity);
                CommodityStock commodityStock = (CommodityStock)comStocks.get(i);
                Cart cart = new Cart();
                cart.setComId(commodityStock.getComId());
                cart.setComName(commodityStock.getComName());
                cart.setStoId(commodityStock.getStockId());
                cart.setStoName(commodityStock.getStockName());
                cart.setUnitPrice(commodityStock.getPrice());
                cart.setQuantity(Integer.parseInt(quantity));
                cart.setTotalPrice(cart.getUnitPrice() * cart.getQuantity());
                carts.add(cart);
            }
        }
        request.setAttribute("carts",carts);
        request.getRequestDispatcher("../cart.jsp").forward(request, response);
    }
}
