package daos;

import beans.CommodityStock;
import beans.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Hanabi
 */
public class StockDao {
    public ArrayList queryStock(String stoInfo){
        ArrayList comStocks = new ArrayList();
        try {
            DatabaseConnection dbcon = new DatabaseConnection();
            Connection conn = dbcon.getConnection();
            System.out.println("SQL Server连接成功："+ conn +"<br>");
            Statement stat = conn.createStatement();

            String sql = "use stock select StockCommodity.ComID, comname, price, stock.stockid, stockname from StockCommodity " +
                    "join stock on Stock.StockID = StockCommodity.StockID join MarketCommodity on MarketCommodity.ComID = StockCommodity.ComID " +
                    " where StockCommodity.StockID = '" + stoInfo + "'or StockName like '%"+ stoInfo + "%'";
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {
                CommodityStock comStock = new CommodityStock();
                comStock.setComId(res.getString("ComID").replaceAll(" ", ""));
                comStock.setComName(res.getString("comname").replaceAll(" ", ""));
                comStock.setPrice(res.getInt("price"));
                comStock.setStockId(res.getString("stockid").replaceAll(" ", ""));
                comStock.setStockName(res.getString("stockname").replaceAll(" ", ""));
                comStocks.add(comStock);

            }
            stat.close();
            conn.close();
        }catch(Exception e){
            System.out.print("Exeption");
        }
        return comStocks;
    }
}
