package mapper;

import javabean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    String getGoodsNameByid(int id);
    List<Goods> getAllGoods();
    Goods getGoodsByid(int id);
    List<Goods>  getGoodsByKeyWord(@Param("keyword") String keyword);
}
