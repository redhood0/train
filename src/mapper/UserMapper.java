package mapper;

import javabean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getUserByName(String userName);
    int insertUser(@Param("username") String username,@Param("password") String password,@Param("url")String url);
    int updatePassword(@Param("username") String username,@Param("password") String password);
}
