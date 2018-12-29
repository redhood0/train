package dao;

import javabean.CartItem;
import mapper.ShopCaetMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ShopCartDao {
    private SqlSessionFactory sqlSessionFactory;

    public ShopCartDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 根据用户id查看该用户购物车里有哪些商品
     * @param id
     * @return
     */
    public List<Integer> getGoodsByUserId(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopCaetMapper mapper = sqlSession.getMapper(ShopCaetMapper.class);
        List<Integer> goodsIdList = mapper.getGoodsByUserId(id);
        return goodsIdList;
    }

    /**
     * 给用户添加购物车(在用户注册成功后)
     * @param userId
     * @return
     */
    public int insertCart4User(int userId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopCaetMapper mapper = sqlSession.getMapper(ShopCaetMapper.class);
        int row = mapper.insertCart4User(userId);
        sqlSession.commit();
        return row;
    }

    /**
     * 向购物车中添加商品，暂时不判断重复数量叠加
     * TODO：相同商品进入购物车时，不是再开一列，而是数量叠加
     * @param userId
     * @param goodsId
     * @param goodsNum
     * @return
     */
    public int insertGoodsToCart(int userId,int goodsId,int goodsNum){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopCaetMapper mapper = sqlSession.getMapper(ShopCaetMapper.class);
        //先查出购物车id
        int cid = mapper.getCidByUid(userId);

        int row = mapper.insertGoodsToCart(goodsId,goodsNum,cid);
        sqlSession.commit();
        return row;
    }

    public int deleteByGoodsId(int gid, int uid){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopCaetMapper mapper = sqlSession.getMapper(ShopCaetMapper.class);
        int row = mapper.deleteByGoodsId(gid,uid);
        sqlSession.commit();
        return row;

    }

    public List<CartItem> getGoodsByUid(int userId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopCaetMapper mapper = sqlSession.getMapper(ShopCaetMapper.class);
        //先查出购物车id
        int cid = mapper.getCidByUid(userId);
        List<CartItem> cartItems = mapper.getGoodsByCid(cid);
        return cartItems;
    }

}
