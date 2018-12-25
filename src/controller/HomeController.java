package controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.SwitchUtil;

public class HomeController extends Controller{

    public TextField keyword;
    public Label nickname;


    //注销
    public void toLoginPage(MouseEvent mouseEvent) {
        //弹出登录界面
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/login.fxml", "/css/type.css");
        stage.show();
        //删除旧界面
        Stage oldStage = (Stage) this.keyword.getScene().getWindow();
        oldStage.close();
    }

    public void toUserCenter(MouseEvent mouseEvent) {
        //弹出登录界面
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/userCenter.fxml", "/css/type.css");
        stage.show();
        //删除旧界面
        Stage oldStage = (Stage) this.keyword.getScene().getWindow();
        oldStage.close();
    }
}
