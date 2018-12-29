package controller;

import java.util.HashMap;

public class ControllerMannager {
    private static HashMap<String,Controller> controllerHashMap = new HashMap<>();

    public static void setControllerHashMap(String key,Controller controller){
        controllerHashMap.put(key,controller);
    }

    public static Controller getController(String key){
        return controllerHashMap.get(key);
    }

}
