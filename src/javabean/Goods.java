package javabean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Goods {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleIntegerProperty classfiy = new SimpleIntegerProperty();
    private SimpleStringProperty goodname = new SimpleStringProperty();
    private SimpleStringProperty proNum = new SimpleStringProperty();
    private SimpleStringProperty price = new SimpleStringProperty();
    private SimpleIntegerProperty stock = new SimpleIntegerProperty();
    private SimpleStringProperty unit = new SimpleStringProperty();
    private SimpleStringProperty imgurl = new SimpleStringProperty();
    private SimpleStringProperty discount = new SimpleStringProperty();


    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getClassfiy() {
        return classfiy.get();
    }

    public SimpleIntegerProperty classfiyProperty() {
        return classfiy;
    }

    public void setClassfiy(int classfiy) {
        this.classfiy.set(classfiy);
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

    public String getProNum() {
        return proNum.get();
    }

    public SimpleStringProperty proNumProperty() {
        return proNum;
    }

    public void setProNum(String proNum) {
        this.proNum.set(proNum);
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

    public int getStock() {
        return stock.get();
    }

    public SimpleIntegerProperty stockProperty() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock.set(stock);
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

    public String getDiscount() {
        return discount.get();
    }

    public SimpleStringProperty discountProperty() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount.set(discount);
    }
}
