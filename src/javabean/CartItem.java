package javabean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CartItem {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty goodname = new SimpleStringProperty();
    private SimpleStringProperty price = new SimpleStringProperty();
    private SimpleIntegerProperty buyNum = new SimpleIntegerProperty();
    private SimpleStringProperty unit = new SimpleStringProperty();
    private SimpleStringProperty imgurl = new SimpleStringProperty();

    public CartItem(int id, int buyNum) {
        this.id.set(id);
        this.buyNum.set(buyNum);
    }

    public CartItem(int id, String goodname, String price, int buyNum, String unit, String imgurl) {
        this.id.set(id);
        this.goodname.set(goodname);
        this.buyNum.set(buyNum);
        this.unit.set(unit);
        this.imgurl.set(imgurl);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getGoodname() {
        return goodname.get();
    }

    public SimpleStringProperty goodnameProperty() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname.set(goodname);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public int getBuyNum() {
        return buyNum.get();
    }

    public SimpleIntegerProperty buyNumProperty() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum.set(buyNum);
    }

    public String getUnit() {
        return unit.get();
    }

    public SimpleStringProperty unitProperty() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit.set(unit);
    }

    public String getImgurl() {
        return imgurl.get();
    }

    public SimpleStringProperty imgurlProperty() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl.set(imgurl);
    }
}
