package controller;

import javabean.CartItem;
import javabean.Goods;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import util.ServiceManager;
import util.UserManager;

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

    private ShopCartController shopCartController;
    private ObservableList<CartItem> observableList;

    public void setValue(CartItem value, ObservableList<CartItem> observableList) {
        cartItem = value;
        name.setText(cartItem.getGoodname());
        price.setText("￥"+cartItem.getPrice());
        num.setText(String.valueOf(cartItem.getBuyNum()));
        total.setText("￥"+String.valueOf((double)cartItem.getBuyNum() * Double.parseDouble(cartItem.getPrice())));
        photo.setImage(new Image(cartItem.getImgurl()));

        this.observableList = observableList ;
    }

    public void deleteItemFromCart(MouseEvent mouseEvent) {
        ServiceManager.getUserService().deleteGoodFromCart(cartItem.getId(), UserManager.getUser().getId());
        //System.out.println(observableList);
        //observableList.clear();
        ShopCartController shopCartController = (ShopCartController) ControllerMannager.getController("ShopCartController");
        System.out.println(shopCartController);
        shopCartController.initialize();
    }
}
