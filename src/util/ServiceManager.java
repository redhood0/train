package util;


import service.GoodsService;
import service.UserService;
import service.serviceImp.GoodsServiceImp;
import service.serviceImp.UserServiceImp;

public class ServiceManager {

    private static UserService userService;
    private static GoodsService goodsService;

    static {
        userService = new UserServiceImp();
        goodsService = new GoodsServiceImp();
    }


    public static UserService getUserService() {
        return userService;
    }

    public static GoodsService getGoodsService() {
        return goodsService;
    }

}
