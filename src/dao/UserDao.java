package dao;

import javabean.User;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User getUserByName(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByName(username);
        return user;
    }

    public int insertUSer(String username,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545754596466&di=f361f566076bfcf0c82dcdd4c022bbff&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201505%2F04%2F20150504013225_XZNCu.jpeg";
        int row = mapper.insertUser(username,password,url);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    public int updatePassword(String username,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int row = mapper.updatePassword(username,password);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }
}
