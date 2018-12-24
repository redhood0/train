package util;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import sample.Main;

import java.io.IOException;
import java.net.URL;

public class SceneFactory {

    private static FXMLLoader loader;

    public static Scene createSence(String fxml,int width,int height){
        URL location = Main.class.getResource(fxml);
        loader = new FXMLLoader(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(pane,width, height);
        return scene;
    }

    public static Scene createSence(String fxml){
        URL location = Main.class.getResource(fxml);
        loader = new FXMLLoader(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(pane);
        return scene;
    }



    public  static FXMLLoader getLoader(){
        return loader;
    }
}
