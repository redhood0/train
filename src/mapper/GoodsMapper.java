package mapper;

import javabean.Goods;

import java.util.List;

public interface GoodsMapper {
    String getGoodsNameByid(int id);
    List<Goods> getAllGoods();
    Goods getGoodsByid(int id);
}
