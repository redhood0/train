package util;



import service.UserService;
import service.serviceImp.UserServiceImp;

public class ServiceManager {

    private static UserService userService;

    static {
        userService = new UserServiceImp();
    }


    public static UserService getUserService(){
        return userService;
    }

}
