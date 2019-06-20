package servlets;

import beans.Cart;
import beans.CommodityStock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8");
        PrintWriter out = response.getWriter();
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList sessionCarts = (ArrayList)request.getSession().getAttribute("sessionCarts") ;

        for (int i = 0; i < sessionCarts.size(); i++) {
            String quantity = request.getParameter(String.valueOf(i));
            if (quantity != ""){
                System.out.println(quantity);
                Cart cart = (Cart)sessionCarts.get(i);
                cart.setQuantity(cart.getQuantity() - Integer.parseInt(quantity));
                cart.setTotalPrice(cart.getTotalPrice() - cart.getUnitPrice() * Integer.parseInt(quantity));
                sessionCarts.remove(i);
                sessionCarts.add(i, cart);
            }
        }
        request.setAttribute("sessionCarts",sessionCarts);
        request.getRequestDispatcher("../cart.jsp").forward(request, response);
    }
}
