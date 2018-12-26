package controller;

import javabean.Goods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import util.SceneFactory;
import util.ServiceManager;
import util.SwitchUtil;
import util.UserManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController extends Controller implements Initializable {
    @FXML
    private TextField keyword;
    @FXML
    private Label nickname;
    @FXML
    private FlowPane flowPane;
    @FXML
    private ImageView img;
    private ObservableList<Goods> goodsObservableList = FXCollections.observableArrayList();

    /**
     * 注销
     * @param mouseEvent
     */
    public void toLoginPage(MouseEvent mouseEvent) {
        //弹出登录界面
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/login.fxml", "/css/type.css");
        stage.show();
        //删除旧界面
        Stage oldStage = (Stage) this.keyword.getScene().getWindow();
        oldStage.close();
    }

    /**
     * 跳转至用户中心
     * @param mouseEvent
     */
    public void toUserCenter(MouseEvent mouseEvent) {
        //弹出登录界面
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/userCenter.fxml", "/css/type.css");
        stage.show();
        //删除旧界面
        Stage oldStage = (Stage) this.keyword.getScene().getWindow();
        oldStage.close();
    }

    /**
     * 初始化页面，加载商品列表和头像
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //获得当前用户，然后把昵称注入,头像进行加载
        nickname.setText(UserManager.getUser().getNickname());
        img.setImage(new Image(UserManager.getUser().getUrl()));
        //初始化商品列表
        initGoodsList();
    }

    public void initGoodsList(){
        //通过service获取一个商品list
        List<Goods> goodsList = ServiceManager.getGoodsService().showAllGoods();
        for(Goods goods : goodsList){
//            -------------------------------
//            goodsObservableList.add(goods);
//            AnchorPane anchorPane = (AnchorPane)SceneFactory.createPane("/fxml/goodsMsg4Flowpane.fxml");
//            GoodsMsg4FlowPaneController goodsMsg4FlowPaneController = SceneFactory.getLoader().getController();
//            goodsMsg4FlowPaneController.setGoods(goods);
//            flowPane.getChildren().add(anchorPane);
//            ------------------------------------
            //垂直布局放商品图和名称
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.TOP_CENTER);
            vBox.setSpacing(15);
            ImageView imageView = new ImageView(new Image(goods.getImgurl()));
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            Label nameLabel = new Label(goods.getGoodname());
            Label priceLabel = new Label("￥"+goods.getPrice());
            vBox.getChildren().addAll(imageView, nameLabel,priceLabel);
            imageView.setOnMouseClicked(event -> {
               // System.out.println("页面跳转至："+goods.getGoodname());

                Stage newStage = new Stage();
                Scene scene = SceneFactory.createSence("/fxml/goodsDetail.fxml");
                newStage.setScene(scene);
                GoodsDetailController goodsDetailController = SceneFactory.getLoader().getController();
                goodsDetailController.setDate(goods);
                newStage.show();

                Stage oldStage = (Stage) nickname.getScene().getWindow();
                oldStage.close();
            });
            //水平布局加入大的内容容器
            flowPane.getChildren().add(vBox);
        }

    }

    /**
     * 到购物车页面
     * @param mouseEvent
     */
    public void toShopCartPage(MouseEvent mouseEvent) {
        //弹出登录界面
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/shopCart.fxml", "/css/type.css");
        stage.show();
        //删除旧界面
        Stage oldStage = (Stage) this.keyword.getScene().getWindow();
        oldStage.close();
    }

    /**
     * 到我的收藏页面
     * @param mouseEvent
     */
    public void toMyFavoritPage(MouseEvent mouseEvent) {

    }
}
