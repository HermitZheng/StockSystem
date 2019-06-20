package beans;

public class Commodity {

    public String id;
    public String comName;
    public int price;
    public int storage;


    public int getPrice() {
        return price;
    }

    public String getComName() {
        return comName;
    }

    public String getId() {
        return id;
    }

    public int getStorage() {
        return storage;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int storage) {
        this.storage = storage;
    }
}
