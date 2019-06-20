package beans;

import java.sql.*;

public class DatabaseConnection{
    private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";    //数据库驱动
    private static final String DBURL = "jdbc:mysql://localhost:3306/mldn";    //数据库URL
    private static final String DBUSER = "root";    //用户名
    private static final String DBPASSWORD = "root";    //密码

    private Connection conn = null;

    public DatabaseConnection() throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Stock;integratedSecurity=true;");
        } catch(Exception e){
            throw e;
        }
    }

    public Connection getConnection(){
        return this.conn;
    }

    public void close() throws Exception{
        if(this.conn != null){
            try{
                this.conn.close();
            } catch(Exception e){
                throw e;
            }
        }
    }

    public static void main(String args[]){
        try{
            System.out.println(new DatabaseConnection().getConnection());
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}