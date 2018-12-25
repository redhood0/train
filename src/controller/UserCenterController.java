package controller;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.SwitchUtil;

public class UserCenterController {

    public Label title;

    /**
     * 跳转到密码修改页
     * @param mouseEvent
     */
    public void toChangePasswordPage(MouseEvent mouseEvent) {
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/changepassword.fxml", "/css/type.css");
        stage.show();

        Stage oldstage = (Stage)title.getScene().getWindow();
        oldstage.close();
    }

    /**
     * 跳转到用户信息页
     * @param mouseEvent
     */
    public void toUserMessage(MouseEvent mouseEvent) {

    }
    //@TODO：2018.12.26
    public void toShopCart(MouseEvent mouseEvent) {
    }
    //@TODO：2018.12.26
    public void toMyfavorit(MouseEvent mouseEvent) {
    }
    //@TODO：2018.12.26
    public void toBuyRecord(MouseEvent mouseEvent) {
    }
    //@TODO：2018.12.26
    public void toMyMessage(MouseEvent mouseEvent) {
    }

    /**
     * 跳转到主页
     * @param mouseEvent
     */
    public void toHomePage(MouseEvent mouseEvent) {
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/home.fxml", "/css/type.css");
        stage.show();

        Stage oldstage = (Stage)title.getScene().getWindow();
        oldstage.close();
    }
}
