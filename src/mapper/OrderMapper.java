package mapper;

import javabean.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int addOrder(Order order);

    int addOrderItem(@Param("oid")int oid,@Param("gid") int gid,@Param("gnum") int gnum);
}
