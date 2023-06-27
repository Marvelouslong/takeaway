package dao.impl;

import com.mysql.cj.jdbc.Blob;
import dao.BaseDao;
import dao.evaluateDao;
import pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class evaluateDaoImpl implements evaluateDao {
    public List<evaluate> list(Integer s_id) {
        Connection connection = BaseDao.getConnection();
        String sql = "select o.s_id,o.id oid,o.status,o.checkout_time,u.id uid,u.name uname,u.phone uphone,e.picture epicture,e.evaluate,e.shop_evaluate  from `order` o  JOIN `user` u ON o.u_id = u.id JOIN evaluate e ON e.o_id = o.id where s_id='"+s_id+"'and o.status='已完成' order by oid DESC";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<evaluate> list = new ArrayList<>();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                evaluate _eva=new evaluate();
                _eva.setEvaluate(rs.getString("evaluate"));
                _eva.setShop_evaluate(rs.getString("shop_evaluate"));
                order _order=new order();
                _order.setId(rs.getInt("oid"));
                _order.setStatus(rs.getString("status"));
                _order.setCheckout_time(rs.getDate("checkout_time"));
                user _user=new user();
                _user.setId(rs.getInt("uid"));
                _user.setPhone(rs.getLong("uphone"));
                _user.setName(rs.getString("uname"));
                _order.set_u(_user);
                _eva.set_o(_order);
                list.add(_eva);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null, pstm, rs);
        }
        return list;
    }
    public Integer update(evaluate evaluate){
        Connection connection = BaseDao.getConnection();
        String sql = "update evaluate set shop_evaluate = ? where id=?";
        PreparedStatement pstm = null;
        Integer rs = null;
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, evaluate.getShop_evaluate());
            pstm.setInt(2,evaluate.getId());
            rs= pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null,pstm, null);
        }
        return rs;
    }
    public Integer del(Integer id){
        Connection connection = BaseDao.getConnection();
        String sql = "delete from evaluate where id ='"+id+"'";
        PreparedStatement pstm = null;
        Integer rs = null;
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null,pstm, null);
        }
        return rs;
    }
}
