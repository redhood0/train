package controller;

import javabean.CartItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShopCartItemController {
    @FXML
    private Label name;
    @FXML
    private Label price;
    @FXML
    private Label num;
    @FXML
    private Label total;
    @FXML
    private ImageView photo;

    private CartItem cartItem;

    public void setValue(CartItem value) {
        cartItem = value;
        name.setText(cartItem.getGoodname());
        price.setText("￥"+cartItem.getPrice());
        num.setText(String.valueOf(cartItem.getBuyNum()));
        total.setText("￥"+String.valueOf((double)cartItem.getBuyNum() * Double.parseDouble(cartItem.getPrice())));
        photo.setImage(new Image(cartItem.getImgurl()));
    }
}
