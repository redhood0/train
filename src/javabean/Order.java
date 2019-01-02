package javabean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Order {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleIntegerProperty uid = new SimpleIntegerProperty();
    private SimpleStringProperty ordertime = new SimpleStringProperty();
    private SimpleStringProperty ordernum = new SimpleStringProperty();
    private SimpleIntegerProperty state = new SimpleIntegerProperty();

    public Order(){
    }

    public Order(int uid, String ordernum) {
        this.uid.set(uid);
        this.ordernum.set(ordernum);
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

    public int getUid() {
        return uid.get();
    }

    public SimpleIntegerProperty uidProperty() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid.set(uid);
    }

    public String getOrdertime() {
        return ordertime.get();
    }

    public SimpleStringProperty ordertimeProperty() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime.set(ordertime);
    }

    public String getOrdernum() {
        return ordernum.get();
    }

    public SimpleStringProperty ordernumProperty() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum.set(ordernum);
    }

    public int getState() {
        return state.get();
    }

    public SimpleIntegerProperty stateProperty() {
        return state;
    }

    public void setState(int state) {
        this.state.set(state);
    }
}
