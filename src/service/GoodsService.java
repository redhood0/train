package service;

import javabean.Goods;

import java.util.List;

public interface GoodsService {
    public List<Goods> showAllGoods();

    List<Goods>  searchBykeyWord(String keyword);

    int reduceStock(int gid,int buynum);


}
