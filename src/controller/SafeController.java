package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.ServiceManager;
import util.SwitchUtil;

import static javafx.scene.control.Alert.AlertType.INFORMATION;

public class SafeController {
    @FXML
    private PasswordField passwordCommit;
    @FXML
    private PasswordField oldpassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private TextField username;


    public void changePassword(MouseEvent mouseEvent){
        String username = this.username.getText();
        String oldpassword = this.oldpassword.getText();
        String newPassword = this.newPassword.getText();
        String passwordCommit = this.passwordCommit.getText();

        Alert alert = new Alert(INFORMATION);
        alert.setTitle("提示");
        try {
            ServiceManager.getUserService().changePassword(username,oldpassword,newPassword,passwordCommit);
            alert.setContentText("修改成功");
            //弹出登录界面
            Stage stage = new Stage();
            SwitchUtil.switchPage(stage, "/fxml/home.fxml", "/css/type.css");
            stage.show();
            //删除旧界面
            Stage loginStage = (Stage) this.username.getScene().getWindow();
            loginStage.close();
        } catch (Exception e) {
            alert.setContentText("异常原因，修改失败:" + e.getMessage());
        }
        alert.showAndWait();

    }

    public void toAheadPage(MouseEvent mouseEvent) {
        //弹出登录界面
        Stage stage = new Stage();
        SwitchUtil.switchPage(stage, "/fxml/userCenter.fxml", "/css/type.css");
        stage.show();
        //删除旧界面
        Stage oldStage = (Stage) this.newPassword.getScene().getWindow();
        oldStage.close();
    }
}
