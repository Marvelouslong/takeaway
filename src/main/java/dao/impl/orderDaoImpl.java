package dao.impl;

import dao.BaseDao;
import dao.orderDao;
import pojo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class orderDaoImpl implements orderDao {
    public List<order> list(Integer s_id) {
        Connection connection = BaseDao.getConnection();
        String sql = "select o.s_id,o.id oid,o.status,o.money,o.checkout_time,r.phone rphone,o.order_time,re.name 'rename',re.phone rephone,re.address,u.id uid,u.name uname,u.phone uphone,o.notes from `order` o JOIN `user` u ON o.u_id = u.id JOIN receiver re ON o.re_id = re.id LEFT OUTER JOIN rider r ON o.r_id = r.id where s_id='"+s_id+"'and o.status='已接单' order by oid DESC";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<order> list = new ArrayList<>();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                 order _order=new order();
                _order.setId(rs.getInt("oid"));
                _order.setStatus(rs.getString("status"));
                _order.setMoney(rs.getDouble("money"));
                _order.setOrder_time(rs.getDate("order_time"));
                _order.setCheckout_time(rs.getDate("checkout_time"));
                _order.setNotes(rs.getString("notes"));
                user _user=new user();
                _user.setId(rs.getInt("uid"));
                _user.setPhone(rs.getLong("uphone"));
                _user.setName(rs.getString("uname"));
                _order.set_u(_user);
                rider _rider=new rider();
                long rphone = rs.getLong("rphone");
                if (rs.wasNull()) {
                    rphone=0;
                    _rider.setPhone(rphone);
                } else {
                    _rider.setPhone(rs.getLong("rphone"));
                }
                _order.set_r(_rider);
                receiver _receiver=new receiver();
                _receiver.setName(rs.getString("rename"));
                _receiver.setPhone(rs.getLong("rephone"));
                _receiver.setAddress(rs.getString("address"));
                _order.set_re(_receiver);
                list.add(_order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null, pstm, rs);
        }
        return list;
    }
    public List<order> list3(Integer s_id) {
        Connection connection = BaseDao.getConnection();
        String sql = "select o.s_id,o.id oid,o.status,o.money,o.checkout_time,r.phone rphone,o.order_time,re.name 'rename',re.phone rephone,re.address,u.id uid,u.name uname,u.phone uphone,o.notes from `order` o JOIN `user` u ON o.u_id = u.id JOIN receiver re ON o.re_id = re.id LEFT OUTER JOIN rider r ON o.r_id = r.id where s_id='"+s_id+"'and o.status='正在配送' order by oid DESC";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<order> list3 = new ArrayList<>();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                order _order=new order();
                _order.setId(rs.getInt("oid"));
                _order.setStatus(rs.getString("status"));
                _order.setMoney(rs.getDouble("money"));
                _order.setOrder_time(rs.getDate("order_time"));
                _order.setCheckout_time(rs.getDate("checkout_time"));
                _order.setNotes(rs.getString("notes"));
                user _user=new user();
                _user.setId(rs.getInt("uid"));
                _user.setPhone(rs.getLong("uphone"));
                _user.setName(rs.getString("uname"));
                _order.set_u(_user);
                rider _rider=new rider();
                long rphone = rs.getLong("rphone");
                if (rs.wasNull()) {
                    rphone=0;
                    _rider.setPhone(rphone);
                } else {
                    _rider.setPhone(rs.getLong("rphone"));
                }
                _order.set_r(_rider);
                receiver _receiver=new receiver();
                _receiver.setName(rs.getString("rename"));
                _receiver.setPhone(rs.getLong("rephone"));
                _receiver.setAddress(rs.getString("address"));
                _order.set_re(_receiver);
                list3.add(_order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null, pstm, rs);
        }
        return list3;
    }
    public List<order> list4(Integer s_id) {
        Connection connection = BaseDao.getConnection();
        String sql = "select o.s_id,o.id oid,o.status,o.money,o.checkout_time,r.phone rphone,o.order_time,re.name 'rename',re.phone rephone,re.address,u.id uid,u.name uname,u.phone uphone,o.notes from `order` o JOIN `user` u ON o.u_id = u.id JOIN receiver re ON o.re_id = re.id LEFT OUTER JOIN rider r ON o.r_id = r.id where s_id='"+s_id+"'and o.status='已完成' order by oid DESC";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<order> list4 = new ArrayList<>();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                order _order=new order();
                _order.setId(rs.getInt("oid"));
                _order.setStatus(rs.getString("status"));
                _order.setMoney(rs.getDouble("money"));
                _order.setOrder_time(rs.getDate("order_time"));
                _order.setCheckout_time(rs.getDate("checkout_time"));
                _order.setNotes(rs.getString("notes"));
                user _user=new user();
                _user.setId(rs.getInt("uid"));
                _user.setPhone(rs.getLong("uphone"));
                _user.setName(rs.getString("uname"));
                _order.set_u(_user);
                rider _rider=new rider();
                long rphone = rs.getLong("rphone");
                if (rs.wasNull()) {
                    rphone=0;
                    _rider.setPhone(rphone);
                } else {
                    _rider.setPhone(rs.getLong("rphone"));
                }
                _order.set_r(_rider);
                receiver _receiver=new receiver();
                _receiver.setName(rs.getString("rename"));
                _receiver.setPhone(rs.getLong("rephone"));
                _receiver.setAddress(rs.getString("address"));
                _order.set_re(_receiver);
                list4.add(_order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null, pstm, rs);
        }
        return list4;
    }
    public List<order> list1(Integer id) {
        Connection connection = BaseDao.getConnection();
        String sql = "select o.s_id,o.id oid,o.status,o.money,o.checkout_time,r.phone rphone,o.order_time,re.name 'rename',re.phone rephone,re.address,u.id uid,u.name uname,u.phone uphone,o.notes onotes from `order` o JOIN `user` u ON o.u_id = u.id JOIN receiver re ON o.re_id = re.id LEFT OUTER JOIN rider r ON o.r_id = r.id where o.id='"+id+"'  order by oid DESC";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<order> list1 = new ArrayList<>();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                order _order=new order();
                _order.setId(rs.getInt("oid"));
                _order.setStatus(rs.getString("status"));
                _order.setMoney(rs.getDouble("money"));
                _order.setOrder_time(rs.getDate("order_time"));
                _order.setCheckout_time(rs.getDate("checkout_time"));
                _order.setNotes(rs.getString("onotes"));
                user _user=new user();
                _user.setId(rs.getInt("uid"));
                _user.setPhone(rs.getLong("uphone"));
                _user.setName(rs.getString("uname"));
                _order.set_u(_user);
                rider _rider=new rider();
                long rphone = rs.getLong("rphone");
                if (rs.wasNull()) {
                    rphone=0;
                    _rider.setPhone(rphone);
                } else {
                    _rider.setPhone(rs.getLong("rphone"));
                }
                _order.set_r(_rider);
                receiver _receiver=new receiver();
                _receiver.setName(rs.getString("rename"));
                _receiver.setPhone(rs.getLong("rephone"));
                _receiver.setAddress(rs.getString("address"));
                _order.set_re(_receiver);
                list1.add(_order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null, pstm, rs);
        }
        return list1;}
    public List<order_dishes> list2(Integer id) {
        Connection connection = BaseDao.getConnection();
        String sql = "select o.id oid,o.money,o.checkout_time,d.id did,d.price dprice,d.name dname,os.taste from `order` o JOIN `order-dishes` os ON os.o_id = o.id JOIN dishes d ON d.id = os. d_id where o.id='"+id+"' order by oid DESC";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<order_dishes> list2 = new ArrayList<>();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                order_dishes order_dishes=new order_dishes();
                order_dishes.setTaste(rs.getString("taste"));
                order _o=new order();
                _o.setId(rs.getInt("oid"));
                order_dishes.set_o(_o);
                dishes _d=new dishes();
                _d.setId(rs.getInt("did"));
                _d.setName(rs.getString("dname"));
                _d.setPrice(rs.getDouble("dprice"));
                order_dishes.set_d(_d);
                list2.add(order_dishes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null, pstm, rs);
        }
        return list2;
    }
}
