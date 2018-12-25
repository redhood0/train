package util;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchUtil {

    public static void switchPage(Stage stage, String url,String css){
        Scene scene = SceneFactory.createSence(url);
        if(!css.equals("") && css != null){
            scene.getStylesheets().add(css);
        }
        stage.setScene(scene);
    }
}
