package mapper;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int addOrder(@Param("uid")int uid,@Param("ordernum") String ordernum);

    int addOrderItem(@Param("uid")int uid,@Param("gid") int gid,@Param("gnum") String gnum);
}
