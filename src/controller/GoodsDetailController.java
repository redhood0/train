package controller;

import javabean.Goods;
import javabean.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.SceneFactory;
import util.ServiceManager;
import util.UserManager;

import java.net.URL;
import java.util.ResourceBundle;

import static javax.print.attribute.standard.MediaSizeName.A;

public class GoodsDetailController extends Controller {
    public Goods goods;
    @FXML
    public Label stock;
    @FXML
    private TextField buyNum;
    @FXML
    private ImageView goodimg;
    @FXML
    private Label goodname;
    @FXML
    private Label price;

    public void toHomePage(MouseEvent mouseEvent) {
        Stage newStage = new Stage();
        Scene scene = SceneFactory.createSence("/fxml/home.fxml");
        newStage.setScene(scene);
        newStage.show();

        Stage oldStage = (Stage) buyNum.getScene().getWindow();
        oldStage.close();
    }

    /**
     * 将获取到的商品信息载入页面节点
     *
     * @param goods
     */
    public void setDate(Goods goods) {
        this.goods = goods;
        goodname.setText(goods.getGoodname());
        stock.setText(String.valueOf(goods.getStock()));
        price.setText("￥" + goods.getPrice());
        goodimg.setImage(new Image(goods.getImgurl()));
    }

    /**
     * 减少按钮
     *
     * @param mouseEvent
     */
    public void minusBuyNum(MouseEvent mouseEvent) {
        String butNUm = buyNum.getText();
        int num = Integer.parseInt(butNUm);
        if (num <= 0) {
            return;
        } else {
            num--;
        }
        butNUm = String.valueOf(num);
        buyNum.setText(butNUm);
    }

    /**
     * 增加按钮
     *
     * @param mouseEvent
     */
    public void addBuyNum(MouseEvent mouseEvent) {
        String butNUm = buyNum.getText();
        int num = Integer.parseInt(butNUm);
        num++;
        butNUm = String.valueOf(num);
        buyNum.setText(butNUm);
    }

    public void addToCart(MouseEvent mouseEvent) {
        String num = buyNum.getText();
        ServiceManager.getUserService().addGoodsToShopCart(UserManager.getUser().getId(), goods.getId(), Integer.parseInt(num));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("信息");
        alert.setContentText("加入购物车成功");
        alert.showAndWait();
    }
}
