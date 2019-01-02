package service;

import javabean.CartItem;
import javabean.Goods;

import java.util.List;

public interface UserService {

    public boolean login(String username,String password);

    public int regist(String username,String password,String password4commmit) throws Exception;

    public int changePassword(String username,String oldPassword,String newPassword,String password4commmit) throws Exception;

    public int addGoodsToShopCart(int userId,int goodsId,int goodsNum);

    public List<CartItem> getCartItemMsg4show(int uid);

    public int deleteGoodFromCart(int gid,int uid);

    public int addOrderFromCart(int uid,List<CartItem> goodList);

    public int clearShopCartByUser(int uid);
}
