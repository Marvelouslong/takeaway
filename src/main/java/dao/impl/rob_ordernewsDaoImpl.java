package dao.impl;

import dao.BaseDao;
import dao.rob_ordernewsDao;
import pojo.order;
import pojo.receiver;
import pojo.rider;
import pojo.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class rob_ordernewsDaoImpl implements rob_ordernewsDao {
    public List<order> getorderlist(Connection connection) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<order> rob_orderlist = new ArrayList<order>();
        if(connection != null){
            String sql ="select o.id oid,o.status,o.money,o.order_time,o.payway,o.notes,s.con_telephone,s.shop_name,s.address saddress,r.phone rphone,r.name rname,re.name `rename`,re.phone rephone,re.address " +
                    "from `order` o " +
                    "JOIN user u ON o.u_id = u.id " +
                    "JOIN store s ON o.s_id = s.id " +
                    "JOIN receiver re ON o.re_id = re.id " +
                    "LEFT OUTER JOIN rider r ON o.r_id = r.id " +
                    "where o.r_id is null";

            pstm = connection.prepareStatement(sql);
//            pstm.setLong(1,phone);
            rs=pstm.executeQuery();
            while(rs.next()){
                order _order=new order();
                _order.setId(rs.getInt("oid"));
                _order.setStatus(rs.getString("status"));
                _order.setMoney(rs.getDouble("money"));
                _order.setOrder_time(rs.getDate("order_time"));
                _order.setPayway(rs.getString("payway"));
                _order.setNotes(rs.getString("notes"));
                store _store=new store();
//                _store.setId(rs.getInt("sid"));
                _store.setCon_telephone(rs.getLong("con_telephone"));
                _store.setShop_name(rs.getString("shop_name"));
                _store.setAddress(rs.getString("saddress"));
                _order.set_s(_store);
                rider _rider=new rider();
                long rphone = rs.getLong("rphone");
                if (rs.wasNull()) {
                    rphone=0;
                    _rider.setPhone(rphone);
                } else {
                    _rider.setPhone(rs.getLong("rphone"));
                }
                String rname=rs.getString("rname");
                if (rs.wasNull()) {
                    rname=null;
                    _rider.setName(rname);
                } else {
                    _rider.setName(rs.getString("rname"));
                }
                _order.set_r(_rider);
                receiver _receiver=new receiver();
                _receiver.setName(rs.getString("rename"));
                _receiver.setPhone(rs.getLong("rephone"));
                _receiver.setAddress(rs.getString("address"));
                _order.set_re(_receiver);
                rob_orderlist.add(_order);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return rob_orderlist;
    }
    //抢单
    public  int modify(Connection connection, rider Rider) throws Exception{
        PreparedStatement pstm=null;
        int updateNum=0;
        if(connection!=null) {
            String sql ="update `order` set r_id=(select id from rider where phone=?),status='已接单 where r_id is null ";
            Object[] params = {Rider.getPhone()};
            updateNum = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null,pstm,null);
        }
        return updateNum;
    }
    public int rob(Connection connection, rider Rider ,order Order) throws Exception{
        PreparedStatement pstm=null;
        int updateNum=0;
        if(connection!=null) {
            String sql ="update `order` o set r_id=(select id from rider  where id=?),status='已接单'  where o.id=? ";
            Object[] params = {Rider.getId(),Order.getId()};
            updateNum = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null,pstm,null);
        }
        return updateNum;
    }
}
