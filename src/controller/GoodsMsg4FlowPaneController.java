package controller;

import javabean.Goods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class GoodsMsg4FlowPaneController {
    @FXML
    private ImageView goodsImg;
    public Label goodsname;
    public Label price;
    private Goods goods;

    public void setGoods(Goods goods){
        System.out.println("set----"+goods.getGoodname());
        //goods = this.goods;
        //initPage(goods);
        goodsImg.setImage(new Image(goods.getImgurl()));
       price.setText(goods.getPrice());
        goodsname.setText(goods.getGoodname());
    }


    public void initPage(Goods goods) {
 //       System.out.println(goods);
//      goodsImg.setImage(new Image(goods.getImgurl()));
//       price.setText(goods.getPrice());
//        goodsname.setText(goods.getGoodname());
    }
}
