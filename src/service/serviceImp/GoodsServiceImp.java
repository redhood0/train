package service.serviceImp;

import dao.GoodsDao;
import dao.UserDao;
import javabean.Goods;
import service.GoodsService;
import util.DbDirverFactory;

import java.util.List;

public class GoodsServiceImp implements GoodsService {

    private GoodsDao goodsDao = new GoodsDao(DbDirverFactory.getFactory());

    @Override
    public List<Goods> showAllGoods() {
        List<Goods> goodsList = goodsDao.getAllGoods();
        return goodsList;
    }

    @Override
    public List<Goods> searchBykeyWord(String keyword) {
        List<Goods> goodsList = goodsDao.getGoodsByKeyWord(keyword);
        return goodsList;
    }
}
