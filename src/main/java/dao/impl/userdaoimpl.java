package dao.impl;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.util.StringUtils;
import dao.BaseDao;
import dao.userdao;
import pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userdaoimpl implements userdao {
    @Override
    public int getstoreCount(Connection connection, String query)throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(s.id) as count from store s,dishes d where s.id = d.s_id");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(query)){
                sql.append(" and (s.shop_name like ? or d.name like ?)");
                list.add("%"+query+"%");  //index：0
            }
            Object[] params = list.toArray();
            pstm = connection.prepareStatement(sql.toString());
            if(params.length != 0){
            pstm.setObject(1,params[0]);
            pstm.setObject(2,params[0]);}
            rs=pstm.executeQuery();
            if(rs.next()){
                //从结果集中获得的最终的数量
                count = rs.getInt("count");
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return count;
    }

    @Override
    public List<store> getstorelist(Connection connection, String query, int currentPageNo, int pageSize) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<store> storeList = new ArrayList<store>();
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select s.* from store s,dishes d where s.id = d.s_id");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(query)){
                sql.append(" and (s.shop_name like ? or d.name like ?)");
                list.add("%"+query+"%");
            }

            sql.append(" order by s.id limit ?,?");//跳过多少条记录，读多少条记录
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            pstm = connection.prepareStatement(sql.toString());
            if(params.length == 2){
            pstm.setObject(1,params[0]);
            pstm.setObject(2,params[1]);}
            else {
                pstm.setObject(1,params[0]);
                pstm.setObject(2,params[0]);
                pstm.setObject(3,params[1]);
                pstm.setObject(4,params[2]);
            }
            rs=pstm.executeQuery();

            while(rs.next()){
                store _store = new store();
                _store.setId(rs.getInt("id"));
                _store.setAddress(rs.getString("address"));
                _store.setShop_name(rs.getString("shop_name"));
                _store.setShop_picture(rs.getBytes("shop_picture"));
                storeList.add(_store);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return storeList;
    }

    @Override
    public List<talk> gettalklist(Connection connection) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<talk> talkList = new ArrayList<talk>();
        if(connection != null){
            String sql = "select t.context,t.picture,u.name from talk t,user u where t.u_id = u.id order by t.id DESC";
            pstm = connection.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next()){
                user _user=new user();
                _user.setName(rs.getString("name"));
                talk _talk = new talk();
                _talk.setContext(rs.getString("context"));
                _talk.setPicture(rs.getBytes("picture"));
                _talk.set_u(_user);
                talkList.add(_talk);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return talkList;
    }

    @Override
    public byte[] img(Connection connection,int id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select shop_picture from store where id = ? ";
        byte[] picture = null;
        try{
            Object[] params={id};
            rs=BaseDao.execute(connection,pstm,rs,sql,params);
            if(rs.next()){
                picture = rs.getBytes(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(null, pstm, rs);
        }

        return picture;
    }

    @Override
    public byte[] img1(Connection connection, int id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select picture from user where id = ? ";
        byte[] picture = null;
        try{
            Object[] params={id};
            rs=BaseDao.execute(connection,pstm,rs,sql,params);
            if(rs.next()){
                picture = rs.getBytes(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(null, pstm, rs);
        }

        return picture;
    }

    @Override
    public int saveUserImage(Connection connection, int id, byte[] imgdata) {
        PreparedStatement pstm = null;
        String sql = "update user set picture = ? where id = ?";
        int count=0;
        try{
            Blob blob = (Blob) connection.createBlob();
            blob.setBytes(1, imgdata);
            pstm = connection.prepareStatement(sql);
            pstm.setBlob(1,blob);
            pstm.setInt(2, id);
            count = pstm.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(null, pstm, null);
        }
        return count;
    }

    @Override
    public List<order_dishes> getorderlist(Connection connection,int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<order_dishes> orderlist = new ArrayList<order_dishes>();
        if(connection != null){
            String sql = "select o.status,o.money,o.order_time,s.id sid,s.con_telephone,s.shop_name,r.phone rphone,d.name dname,d.id did,re.name `rename`,re.phone rephone,re.address " +
                    "from `order` o,dishes d,store s,user u,rider r,receiver re,`order-dishes` od " +
                    "where o.u_id=u.id and o.s_id=s.id and o.r_id=r.id and o.re_id=re.id and d.id=od.d_id and o.id=od.o_id and u.id=? and re.u_id=u.id " +
                    "order by o.id DESC";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while(rs.next()){
                order _order=new order();
                _order.setStatus(rs.getString("status"));
                _order.setMoney(rs.getDouble("money"));
                _order.setOrder_time(rs.getDate("order_time"));
                store _store=new store();
                _store.setId(rs.getInt("sid"));
                _store.setCon_telephone(rs.getLong("con_telephone"));
                _store.setShop_name(rs.getString("shop_name"));
                _order.set_s(_store);
                rider _rider=new rider();
                _rider.setPhone(rs.getLong("rphone"));
                _order.set_r(_rider);
                dishes _dishes=new dishes();
                _dishes.setName("dname");
                _dishes.setId(rs.getInt("did"));
                receiver _receiver=new receiver();
                _receiver.setName(rs.getString("rename"));
                _receiver.setPhone(rs.getLong("rephone"));
                _receiver.setAddress(rs.getString("address"));
                _order.set_re(_receiver);
                order_dishes _od=new order_dishes();
                _od.set_d(_dishes);
                _od.set_o(_order);
                orderlist.add(_od);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return orderlist;
    }
}
