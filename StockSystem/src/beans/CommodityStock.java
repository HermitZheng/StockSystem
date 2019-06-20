package beans;

public class CommodityStock {
    public String comId;
    public String comName;
    public int price;
    public String stockId;
    public String stockName;

    public String getComId() {
        return comId;
    }

    public String getComName() {
        return comName;
    }

    public int getPrice() {
        return price;
    }

    public String getStockId() {
        return stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
}
