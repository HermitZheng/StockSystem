package beans;

public class Cart {
    public String comId;
    public String comName;
    public String stoId;
    public String stoName;
    public int unitPrice;
    public int quantity;
    public int totalPrice;

    public void setComId(String comId){
        this.comId = comId;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStoId(String stoId) {
        this.stoId = stoId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStoName(String stoName) {
        this.stoName = stoName;
    }

    public String getStoId() {
        return stoId;
    }

    public String getStoName() {
        return stoName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getComId() {
        return comId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getComName() {
        return comName;
    }
}
