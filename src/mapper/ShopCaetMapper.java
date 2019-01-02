package mapper;

import javabean.CartItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCaetMapper {
    public List<Integer> getGoodsByUserId(int customerId);

    public int insertCart4User(int userId);

    public int getCidByUid(int uId);

    public int insertGoodsToCart(@Param("goodId") int goodId,@Param("goods_num")  int goods_num,@Param("cId")  int cId);

    public List<CartItem> getGoodsByCid(int cId);

    public int deleteByGoodsId(@Param("gid") int gid,@Param("customerId") int customerId);

    public int deleteAllByCId(int cid);

}
