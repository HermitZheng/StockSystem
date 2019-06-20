package beans;

import java.util.ArrayList;
import beans.Commodity;

public class Market {
    public String id;
    public String name;
    public String address;
    public ArrayList goods;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList getGoods() {
        return goods;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGoods(ArrayList goods) {
        this.goods = goods;
    }
}
