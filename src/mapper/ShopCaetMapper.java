package mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCaetMapper {
    public List<Integer> getGoodsByUserId(int customerId);

    public int insertCart4User(int userId);

    public int getCidByUid(int uId);

    public int insertGoodsToCart(@Param("goodId") int goodId,@Param("goods_num")  int goods_num,@Param("cId")  int cId);

}
