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

    @Override
    public int reduceStock(int gid, int buynum) {
        //查出商品当前库存
        int stock = goodsDao.getGoodsByid(gid).getStock();

        //TODO:判断当前库存是否够减（不够可能还要进行回滚等操作，目前默认都是够的）
        if (stock < buynum) {
            //throw Exception
        } else {
            stock -= buynum;
            return goodsDao.updateGoodsStock(stock,gid);
        }
        return 0;
    }
}
