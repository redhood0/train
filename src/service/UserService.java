package service;

public interface UserService {
    public boolean login(String username,String password);

    public int regist(String username,String password,String password4commmit) throws Exception;
}