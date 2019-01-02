package dao;

import javabean.Order;
import mapper.OrderMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OrderDao {

    private SqlSessionFactory sqlSessionFactory;

    public OrderDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int addOrder(Order order){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        int row = orderMapper.addOrder(order);
        sqlSession.commit();
        sqlSession.close();
        return order.getId();
    }

    public int addOrderItem(int oid, int gid, int gnum){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        int row = orderMapper.addOrderItem(oid,gid,gnum);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }



}
