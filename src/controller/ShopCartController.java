package controller;

import javabean.CartItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.SceneFactory;
import util.ServiceManager;
import util.SwitchUtil;
import util.UserManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShopCartController extends Controller  {
    @FXML
    private Label totalPrice;
    @FXML
    private ListView<CartItem> lv_cartList;
    private ObservableList<CartItem> observableList = FXCollections.observableArrayList();

    public ShopCartController(){
        ControllerMannager.setControllerHashMap("ShopCartController",this);
    }

    public void toHomePage(MouseEvent mouseEvent) {
        //弹出登录界面
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/home.fxml", "/css/type.css");
        stage.show();
        //删除旧界面
        Stage oldStage = (Stage) this.lv_cartList.getScene().getWindow();
        oldStage.close();
    }

    @FXML
    public void initialize() {
        initItem();
    }

    private void initItem() {
        double total = 0;
        //获取需要显示的信息列表
        List<CartItem> cartItems = ServiceManager.getUserService().getCartItemMsg4show(UserManager.getUser().getId());
        //清空控件内元素
        lv_cartList.getItems().removeAll();
        observableList.clear();
        //绑定数据源和listview
        for (CartItem item : cartItems) {
            observableList.add(item);
            total += (double) item.getBuyNum()*Double.parseDouble(item.getPrice());
        }
        lv_cartList.setItems(observableList);
        lv_cartList.setCellFactory(n -> {return new ColorCell();});
//        lv_cartList.setCellFactory(new Callback<ListView<CartItem>, ListCell<CartItem>>() {
//            @Override
////            public ListCell<CartItem> call(ListView<CartItem> param) {
////                return new ColorCell();
////            }
////        });
        totalPrice.setText("￥"+String.valueOf(total));


    }

    class ColorCell extends ListCell<CartItem> {
        @Override
        protected void updateItem(CartItem item, boolean empty) {
            super.updateItem(item, empty);
            AnchorPane anchorPane = (AnchorPane) SceneFactory.createPane("/fxml/shopCartItem.fxml");

            if (item != null) {
                ShopCartItemController shopCartItemController = SceneFactory.getLoader().getController();
                shopCartItemController.setValue(item,observableList);
                setGraphic(anchorPane);
            } else {
                setGraphic(null);
            }
        }
    }
}