package service.serviceImp;

import dao.ShopCartDao;
import dao.UserDao;
import javabean.User;
import service.UserService;
import util.DbDirverFactory;
import util.ServiceManager;
import util.UserManager;

public class UserServiceImp implements UserService {

    private UserDao userDao = new UserDao(DbDirverFactory.getFactory());
    private ShopCartDao shopCartDao = new ShopCartDao(DbDirverFactory.getFactory());

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
}
