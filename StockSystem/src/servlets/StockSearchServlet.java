package servlets;

import daos.CommodityDao;
import daos.StockDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "StockSearchServlet")
public class StockSearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8");
        PrintWriter out = response.getWriter();
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset = utf-8");
            PrintWriter out = response.getWriter();

            String stoInfo = request.getParameter("stoInfo");
            if (stoInfo != ""){
                StockDao stockDao = new StockDao();
                ArrayList comStocks = stockDao.queryStock(stoInfo);

                request.setAttribute("comStocks",comStocks);
            }
            request.getRequestDispatcher("../stock.jsp").forward(request, response);
        }catch(Exception e){
            PrintWriter out = response.getWriter();
            out.print("ServletExeption");
        }
    }
}
