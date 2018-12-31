package service.serviceImp;

import dao.GoodsDao;
import dao.OrderDao;
import dao.ShopCartDao;
import dao.UserDao;
import javabean.CartItem;
import javabean.Goods;
import javabean.User;
import service.UserService;
import util.DbDirverFactory;
import util.ServiceManager;
import util.UserManager;

import java.util.Date;
import java.util.List;

public class UserServiceImp implements UserService {

    private UserDao userDao = new UserDao(DbDirverFactory.getFactory());
    private ShopCartDao shopCartDao = new ShopCartDao(DbDirverFactory.getFactory());
    private GoodsDao goodsDao = new GoodsDao(DbDirverFactory.getFactory());
    private OrderDao orderDao = new OrderDao(DbDirverFactory.getFactory());

    @Override
    public boolean login(String username, String password) {
        User user = userDao.getUserByName(username);
        if (user == null) {
            return false;
        } else if (password.equals(user.getPassword())) {
            //System.out.println("登陆成功");
            UserManager.setUser(user);
            return true;
        }
        return false;
    }

    @Override
    public int regist(String username, String password, String password4commmit) throws Exception {

        if ("".equals(username) || username == null) {
            throw new Exception("用户名不能为空");
        }
        if ("".equals(password) || password == null || "".equals(password4commmit) || password4commmit == null) {
            throw new Exception("密码不能为空");
        }
        if (!password.equals(password4commmit)) {
            throw new Exception("两次密码不一致");
        }
        User user = userDao.getUserByName(username);
        if (user != null) {
            throw new Exception("用户名有重复");
        }
        int row = userDao.insertUSer(username, password);
        if(row != 0 ){
            int id = userDao.getUserByName(username).getId();
            shopCartDao.insertCart4User(id);
            return row;
        }
        return row;
    }

    @Override
    public int changePassword(String username, String oldPassword, String newPassword, String password4commmit) throws Exception {
        if ("".equals(username) || username == null) {
            throw new Exception("用户名不能为空");
        }
        if ("".equals(oldPassword) || oldPassword == null || "".equals(password4commmit) || password4commmit == null || "".equals(newPassword) || newPassword == null) {
            throw new Exception("密码不能为空");
        }
        if (newPassword.equals(oldPassword)) {
            throw new Exception("新旧密码不能相同");
        }
        if (!newPassword.equals(password4commmit)) {
            throw new Exception("两次密码不一致");
        }
        User user = userDao.getUserByName(username);
        if (user == null) {
            throw new Exception("用户名不存在");
        }else if(!user.getPassword().equals(oldPassword)){
            throw new Exception("原始密码错误");
        }
        return userDao.updatePassword(username,newPassword);
    }

    @Override
    public int addGoodsToShopCart(int userId, int goodsId, int goodsNum) {
        int row = shopCartDao.insertGoodsToCart(userId,goodsId,goodsNum);
        return row;
    }

    /**
     * 获取用户的购物车的信息，包装成一个list传出。
     * @param uid
     * @return
     */
    @Override
    public List<CartItem> getCartItemMsg4show(int uid) {
        List<CartItem> cartItems = shopCartDao.getGoodsByUid(uid);
        for(CartItem item : cartItems){
            Goods good = goodsDao.getGoodsByid(item.getId());
            item.setGoodname(good.getGoodname());
            item.setImgurl(good.getImgurl());
            item.setPrice(good.getPrice());
            item.setUnit(good.getUnit());
        }
        return cartItems;
    }

    /**
     * 删除购物车中的特定商品，因为没有缓存的机制，所有还是走数据库
     * @param gid
     * @param uid
     * @return
     */
    @Override
    public int deleteGoodFromCart(int gid, int uid) {
        int row = shopCartDao.deleteByGoodsId(gid,uid);
        return row;
    }

    /**
     *
     * @param uid
     * @param goodList
     * @return
     */
    @Override
    public int addOrderFromCart(int uid, List<CartItem> goodList) {
        //create ordernum();
        int row = orderDao.addOrder(uid,String.valueOf(new Date().getTime()));
        //TODO:get orderid for add orderItem
        for(CartItem good : goodList){
            orderDao.addOrderItem(1,good.getId(),good.getGoodname());
        }
        return row;
    }
}
