package daos;

import beans.Commodity;
import beans.Market;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MarketDao {
    public Market queryMarket(String id) throws Exception {
        Connection conn = null;

        Market market = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Stock;integratedSecurity=true;");
            System.out.println("SQL Server连接成功：" + conn);
            Statement stat = conn.createStatement();

            String mar_sql = "Select MarId, address, MarName  from Market where MarId = '" + id + "'";
            String com_sql = "Select ComId, ComName, Storage from MarketCommodity where MarId = '" + id + "'";

            ResultSet res = stat.executeQuery(mar_sql);
            market = new Market();
            while (res.next()) {
                market.setId(res.getString("MarId").replaceAll(" ", ""));
                market.setAddress(res.getString("address").replaceAll(" ", ""));
                market.setName(res.getString("MarName").replaceAll(" ", ""));
            }

            res = stat.executeQuery(com_sql);
            ArrayList coms = new ArrayList();
            while (res.next()) {
                Commodity commodity = new Commodity();
                commodity.setComName(res.getString("ComName").replaceAll(" ", ""));
                commodity.setId(res.getString("ComId").replaceAll(" ", ""));
                commodity.setQuantity(res.getInt("storage"));
                coms.add(commodity);
            }
            market.setGoods(coms);


            stat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Exeption");
            e.printStackTrace();
        }
        return market;
    }
}
