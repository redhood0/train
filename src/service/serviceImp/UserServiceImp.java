package service.serviceImp;

import dao.UserDao;
import javabean.User;
import service.UserService;
import util.DbDirverFactory;

public class UserServiceImp implements UserService {

    private UserDao userDao = new UserDao(DbDirverFactory.getFactory());

    @Override
    public boolean login(String username, String password) {
        User user = userDao.getUserByName(username);
        if (user==null){
            return false;
        }else if(password.equals(user.getPassword())){
            //System.out.println("登陆成功");
            return true;
        }
        return false;
    }

    @Override
    public int regist(String username, String password, String password4commmit) throws Exception {

        if("".equals(username) || username==null){
            throw new Exception("用户名不能为空");
        }
        if("".equals(password) || password==null || "".equals(password4commmit) || password4commmit==null){
            throw new Exception("密码不能为空");
        }
        if(!password.equals(password4commmit)){
            throw new Exception("两次密码不一致");
        }
        User user = userDao.getUserByName(username);
        if(user != null){
            throw new Exception("用户名有重复");
        }
        int row = userDao.insertUSer(username,password);
        return row;
    }
}
