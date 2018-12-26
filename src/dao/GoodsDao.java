package dao;

import javabean.Goods;
import mapper.GoodsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import util.DbDirverFactory;

import java.awt.print.Book;
import java.util.List;

public class GoodsDao {
    private SqlSessionFactory sqlSessionFactory;

    public GoodsDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public String getGoodsNameByid(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        String goodsname = mapper.getGoodsNameByid(id);
        sqlSession.close();
        return goodsname;
    }

    public List<Goods> getAllGoods(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goodsList = mapper.getAllGoods();
        sqlSession.close();
        return goodsList;
    }


    public Goods getGoodsByid(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        Goods goods = mapper.getGoodsByid(id);
        return goods;
    }

    public static void main(String[] args) {
        DbDirverFactory.driver();
        //GoodsDao goodsDao = new GoodsDao(DbDirverFactory.getFactory());
//        ShopCartDao shopCartDao = new ShopCartDao(DbDirverFactory.getFactory());
//        System.out.println(shopCartDao.getGoodsByUid(4));

        GoodsDao goodsDao = new GoodsDao(DbDirverFactory.getFactory());

        System.out.println(goodsDao.getGoodsByid(1).getGoodname());

    }



}
