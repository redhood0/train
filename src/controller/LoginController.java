package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.SceneFactory;
import util.ServiceManager;
import util.SwitchUtil;
import util.UserManager;

import static javafx.scene.control.Alert.AlertType.INFORMATION;

public class LoginController extends Controller {
    @FXML
    private TextField password;
    @FXML
    private TextField username;

    private Stage stage;

    /**
     * 注册功能
     * @param actionEvent
     */
    public void login(ActionEvent actionEvent) {
        String username = this.username.getText();
        String password = this.password.getText();
        boolean flag = ServiceManager.getUserService().login(username, password);

        Alert alert = new Alert(INFORMATION);
        alert.setTitle("提示");

        if (flag) {
            alert.setContentText("登陆成功");

            //弹出新界面
            Stage stage = new Stage();
            SwitchUtil.switchPage(stage, "/fxml/home.fxml", "/css/type.css");
            stage.show();
            //删除旧界面
            Stage loginStage = (Stage) this.username.getScene().getWindow();
            loginStage.close();
        } else {
            alert.setContentText("账号或密码错误，登陆失败");
        }
        alert.showAndWait();
    }

    /**
     * 跳转注册页面
     * @param mouseEvent
     */
    public void toRegistPage(MouseEvent mouseEvent) {
        Stage loginStage = (Stage) this.username.getScene().getWindow();
        SwitchUtil.switchPage(loginStage, "/fxml/register.fxml", "/css/type.css");
    }


    public void setStage(Stage stage) {
        stage = this.stage;
    }


}
