package daos;

import beans.Cart;
import beans.CommodityStock;
import beans.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SubmitDao {
    public void submit(String marketId, ArrayList cartList) {

        try {
            DatabaseConnection dbcon = new DatabaseConnection();
            Connection conn = dbcon.getConnection();
            System.out.println("SQL Server连接成功："+ conn +"<br>");
            Statement stat = conn.createStatement();

            for (int i = 0; i < cartList.size(); i++) {
                System.out.println("Loop begin");
                Cart cart = (Cart) cartList.get(i);
                String comId = cart.getComId();
                int quantity = cart.getQuantity();
                System.out.println("数量：" + quantity + ",编号" + comId);
                String sql = "use stock update MarketCommodity set Storage = Storage + " + quantity + " where ComID = '" + comId + "'and MarID = '" + marketId + "'";
                stat.executeUpdate(sql);
                System.out.println("Loop Complete");
            }
            stat.close();
            conn.close();
        }catch(Exception e){
            System.out.print("DaoExeption");
        }
        return;
    }
}
