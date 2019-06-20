package servlets;

import daos.SubmitDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SubmitCartServlet")
public class SubmitCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8");
        PrintWriter out = response.getWriter();
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList session = (ArrayList)request.getSession().getAttribute("sessionCarts");
        String marketId = (String)request.getSession().getAttribute("id");
        SubmitDao submitDao = new SubmitDao();
        submitDao.submit(marketId, session);
        request.getSession().removeAttribute("sessionCarts");
        //request.getSession().setAttribute("sub", "yes");
        request.getRequestDispatcher("../cart.jsp").forward(request, response);
    }
}
