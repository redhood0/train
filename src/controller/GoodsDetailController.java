package controller;

import javabean.Goods;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.SceneFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class GoodsDetailController extends Controller {

    public TextField buyNum;

    public Goods goods;
    public ImageView goodimg;
    public Label goodname;
    public Label price;


    public void toHomePage(MouseEvent mouseEvent) {
        Stage newStage = new Stage();
        Scene scene = SceneFactory.createSence("/fxml/home.fxml");
        newStage.setScene(scene);
        newStage.show();

        Stage oldStage = (Stage) buyNum.getScene().getWindow();
        oldStage.close();
    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println(goods);
//        goodimg.setImage(new Image("http://imglf6.nosdn0.126.net/img/blZEeUZPK3hmQ25hd05qbkFLK3Uvd3FvMC9vZmtMRHUvSzEwRUUzWGFZSUlYWHRMeFBqOWJBPT0.png?imageView&thumbnail=500x0&quality=96&stripmeta=0"));
//    }

    public void setDate(Goods goods) {
        this.goods = goods;
        goodname.setText(goods.getGoodname());
        price.setText("￥" + goods.getPrice());
        goodimg.setImage(new Image(goods.getImgurl()));
    }
}
