package sample;


import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.DbDirverFactory;
import util.SceneFactory;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //创建场景
        Scene scene = SceneFactory.createSence("/fxml/login.fxml",1600, 960);
        scene.getStylesheets().add( "/css/type.css");
        //舞台放入控制器
        LoginController loginController = SceneFactory.getLoader().getController();
        loginController.setStage(primaryStage);
        //设置舞台基本信息
        primaryStage.setTitle("Eshop");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        DbDirverFactory.driver();
        launch(args);
    }
}
