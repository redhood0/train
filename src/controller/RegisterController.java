package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.ServiceManager;
import util.SwitchUtil;

import static javafx.scene.control.Alert.AlertType.INFORMATION;

public class RegisterController extends Controller {

    public TextField username;
    public PasswordField password;
    public PasswordField password4commit;

    public void regist(MouseEvent mouseEvent) {

        String username = this.username.getText();
        String password = this.password.getText();
        String password4commit = this.password4commit.getText();

        Alert alert = new Alert(INFORMATION);
        alert.setTitle("提示");
        try {
            ServiceManager.getUserService().regist(username, password, password4commit);
            alert.setContentText("注册成功");
            //弹出登录界面
            Stage stage = new Stage();
            SwitchUtil.switchPage(stage, "/fxml/login.fxml", "/css/type.css");
            stage.show();
            //删除旧界面
            Stage loginStage = (Stage) this.username.getScene().getWindow();
            loginStage.close();
        } catch (Exception e) {
            alert.setContentText("异常原因，注册失败:" + e.getMessage());
        }
        alert.showAndWait();
    }

    //返回到登录页面
    public void toLoginPage(MouseEvent mouseEvent) {
        //弹出登录界面
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/login.fxml", "/css/type.css");
        stage.show();
        //删除旧界面
        Stage loginStage = (Stage) this.username.getScene().getWindow();
        loginStage.close();
    }

}
