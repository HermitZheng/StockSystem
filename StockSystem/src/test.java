import beans.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;
import beans.DatabaseConnection;

public class test {
    private DatabaseConnection dbcon = null;

    public static void main(String args[]) throws Exception {
        DatabaseConnection dbcon = new DatabaseConnection();
        Connection conn = dbcon.getConnection();
        System.out.println("SQL Server连接成功："+ conn +"<br>");
        Statement stat = conn.createStatement();
    }
}
