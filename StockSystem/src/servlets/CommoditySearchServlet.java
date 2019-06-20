package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import daos.CommodityDao;

public class CommoditySearchServlet extends HttpServlet {
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

            String comInfo = request.getParameter("comInfo");
            if (comInfo != ""){
                CommodityDao comDao = new CommodityDao();
                ArrayList comStocks = comDao.queryCommodity(comInfo);

                request.setAttribute("comStocks",comStocks);
            }
            request.getRequestDispatcher("../commodity.jsp").forward(request, response);
        }catch(Exception e){
            PrintWriter out = response.getWriter();
            out.print("ServletExeption");
        }
    }
}
