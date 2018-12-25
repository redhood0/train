package controller;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.SwitchUtil;

public class UserCenterController {

    public Label title;

    public void toChangePasswordPage(MouseEvent mouseEvent) {
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/changepassword.fxml", "/css/type.css");
        stage.show();

        Stage oldstage = (Stage)title.getScene().getWindow();
        oldstage.close();
    }
}
