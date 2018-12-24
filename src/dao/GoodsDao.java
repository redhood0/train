package dao;

import mapper.GoodsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import util.DbDirverFactory;

public class GoodsDao {
    private SqlSessionFactory sqlSessionFactory;

    public GoodsDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public String getGoodsNameByid(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        String goodsname = mapper.getGoodsNameByid(id);
        return goodsname;

    }

    public static void main(String[] args) {
        DbDirverFactory.driver();
        GoodsDao goodsDao = new GoodsDao(DbDirverFactory.getFactory());
        System.out.println(goodsDao.getGoodsNameByid(1));

    }



}
