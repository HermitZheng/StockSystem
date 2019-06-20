package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import beans.DatabaseConnection;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
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

            DatabaseConnection dbcon = new DatabaseConnection();
            Connection conn = dbcon.getConnection();
            out.println("SQL Server连接成功："+ conn +"<br>");
            Statement stat = conn.createStatement();

            String id = request.getParameter("account");
            String pass = request.getParameter("password");
            String sql = "USE Stock Select MarID, Password FROM Market";
            ResultSet res = stat.executeQuery(sql);

            String account = null;
            String password = null;

            while (res.next()) {
                account = res.getString("MarID").replaceAll(" ", "");
                password = res.getString("Password").replaceAll(" ", "");
                if(id.equals(account) && pass.equals(password)){
                    response.sendRedirect("../menu.jsp?id=" + account);

                }else{
                    response.sendRedirect("../login.jsp?isTrue=no");
                }
            }

            stat.close();
            conn.close();
        }catch(Exception e){
            PrintWriter out = response.getWriter();
            out.print("Exeption");
        }
    }
}
