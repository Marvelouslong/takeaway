package dao.impl;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.util.StringUtils;
import dao.BaseDao;
import dao.userdao;
import pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                sql.append(" and (s.shop_name like ? or d.name like ? or s.main_category like ?)");
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
                pstm.setObject(3,params[0]);
                pstm.setObject(4,params[1]);
                pstm.setObject(5,params[2]);
            }
            rs=pstm.executeQuery();

            while(rs.next()){
                store _store = new store();
                _store.setId(rs.getInt("id"));
                _store.setAddress(rs.getString("address"));
                _store.setShop_name(rs.getString("shop_name"));
                _store.setMain_category(rs.getString("main_category"));
                _store.setAuxiliary_category(rs.getString("auxiliary_category"));
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
            String sql = "select t.id tid,t.context,u.name,u.id uid from talk t,user u where t.u_id = u.id order by t.id DESC";
            pstm = connection.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next()){
                user _user=new user();
                _user.setName(rs.getString("name"));
                _user.setId(rs.getInt("uid"));
                talk _talk = new talk();
                _talk.setContext(rs.getString("context"));
                _talk.setId(rs.getInt("tid"));
                _talk.set_u(_user);
                talkList.add(_talk);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return talkList;
    }

    @Override
    public byte[] img(Connection connection,int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select shop_picture from store where id = ? ";
        byte[] picture = null;
        Object[] params={id};
        rs=BaseDao.execute(connection,pstm,rs,sql,params);
        if(rs.next()){
            picture = rs.getBytes(1);
        }
        BaseDao.closeResource(null, pstm, rs);
        return picture;
    }

    @Override
    public byte[] img1(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select picture from user where id = ? ";
        byte[] picture = null;
        Object[] params={id};
        rs=BaseDao.execute(connection,pstm,rs,sql,params);
        if(rs.next()){
            picture = rs.getBytes(1);
        }
        BaseDao.closeResource(null, pstm, rs);
        return picture;
    }

    @Override
    public int saveUserImage(Connection connection, int id, byte[] imgdata) throws SQLException {
        PreparedStatement pstm = null;
        String sql = "update user set picture = ? where id = ?";
        int count=0;
        Blob blob = (Blob) connection.createBlob();
        blob.setBytes(1, imgdata);
        pstm = connection.prepareStatement(sql);
        pstm.setBlob(1,blob);
        pstm.setInt(2, id);
        count = pstm.executeUpdate();
        BaseDao.closeResource(null, pstm, null);
        return count;
    }

    @Override
    public List<order> getorderlist(Connection connection,int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<order> orderlist = new ArrayList<order>();
        if(connection != null){
            String sql = "select o.id oid,o.status,o.money,o.order_time,s.id sid,s.con_telephone,s.shop_name,r.phone rphone,r.name rname,re.name `rename`,re.phone rephone,re.address " +
                    "from `order` o " +
                    "JOIN user u ON o.u_id = u.id " +
                    "JOIN store s ON o.s_id = s.id " +
                    "JOIN receiver re ON o.re_id = re.id " +
                    "LEFT OUTER JOIN rider r ON o.r_id = r.id " +
                    "where u.id=? " +
                    "order by oid DESC";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while(rs.next()){
                order _order=new order();
                _order.setId(rs.getInt("oid"));
                _order.setStatus(rs.getString("status"));
                _order.setMoney(rs.getDouble("money"));
                _order.setOrder_time(rs.getDate("order_time"));
                store _store=new store();
                _store.setId(rs.getInt("sid"));
                _store.setCon_telephone(rs.getLong("con_telephone"));
                _store.setShop_name(rs.getString("shop_name"));
                _order.set_s(_store);
                rider _rider=new rider();
                String rname=rs.getString("rname");
                if (rs.wasNull()) {
                    rname=null;
                    _rider.setName(rname);
                } else {
                    _rider.setName(rs.getString("rname"));
                }
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
                orderlist.add(_order);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return orderlist;
    }

    @Override
    public List<dishes> showdish(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<dishes> dishesList = new ArrayList<dishes>();
        if(connection != null){
            String sql = "select d.id,d.name,d.price from `order-dishes` od,dishes d where od.d_id=d.id and od.o_id=? order by d.id";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while(rs.next()){
                dishes _d=new dishes();
                _d.setName(rs.getString("name"));
                _d.setId(rs.getInt("id"));
                _d.setPrice(rs.getDouble("price"));
                dishesList.add(_d);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return dishesList;
    }
    @Override
    public byte[] img2(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select picture from dishes where id = ? ";
        byte[] picture = null;
        Object[] params={id};
        rs=BaseDao.execute(connection,pstm,rs,sql,params);
        if(rs.next()){
            picture = rs.getBytes(1);
        }
        BaseDao.closeResource(null, pstm, rs);
        return picture;
    }

    @Override
    public int addevaluate(Connection connection, int id,byte[]imgdata,String evaluate,int count1) throws SQLException {
        PreparedStatement pstm = null;
        String sql = "insert into evaluate values (?,?,?,?)";
        int count=0;
        Blob blob = (Blob) connection.createBlob();
        blob.setBytes(1, imgdata);
        pstm = connection.prepareStatement(sql);
        pstm.setInt(1,count1);
        pstm.setBlob(2,blob);
        pstm.setString(3, evaluate);
        pstm.setInt(4,id);
        count = pstm.executeUpdate();
        BaseDao.closeResource(null, pstm, null);
        return count;
    }

    @Override
    public int getevaluateCount(Connection connection) throws Exception {
        PreparedStatement pstm=null;
        int count=0;
        String sql="select count(id) as count from evaluate";
        ResultSet rs=null;
        pstm=connection.prepareStatement(sql);
        rs = pstm.executeQuery();
        if(rs.next()){
            count = rs.getInt("count");
        }
        BaseDao.closeResource(null, pstm, rs);
        return count;
    }

    @Override
    public byte[] img3(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select picture from evaluate where id = ? ";
        byte[] picture = null;
        Object[] params={id};
        rs=BaseDao.execute(connection,pstm,rs,sql,params);
        if(rs.next()){
            picture = rs.getBytes(1);
        }
        BaseDao.closeResource(null, pstm, rs);
        return picture;
    }

    @Override
    public List<evaluate> showevaluate(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<evaluate> evaluateList = new ArrayList<evaluate>();
        if(connection != null){
            String sql = "select id,evaluate from evaluate where o_id=? order by id DESC";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while(rs.next()){
                evaluate _d=new evaluate();
                _d.setId(rs.getInt("id"));
                _d.setEvaluate(rs.getString("evaluate"));
                evaluateList.add(_d);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return evaluateList;
    }

    @Override
    public byte[] img4(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select picture from user where id = ? ";
        byte[] picture = null;
        Object[] params={id};
        rs=BaseDao.execute(connection,pstm,rs,sql,params);
        if(rs.next()){
            picture = rs.getBytes(1);
        }
        BaseDao.closeResource(null, pstm, rs);
        return picture;
    }

    @Override
    public byte[] img5(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select picture from talk where id = ? ";
        byte[] picture = null;
        Object[] params={id};
        rs=BaseDao.execute(connection,pstm,rs,sql,params);
        if(rs.next()){
            picture = rs.getBytes(1);
        }
        BaseDao.closeResource(null, pstm, rs);
        return picture;
    }

    @Override
    public int gettalkCount(Connection connection) throws Exception {
        PreparedStatement pstm=null;
        int count=0;
        String sql="select count(id) as count from talk";
        ResultSet rs=null;
        pstm=connection.prepareStatement(sql);
        rs = pstm.executeQuery();
        if(rs.next()){
            count = rs.getInt("count");
        }
        BaseDao.closeResource(null, pstm, rs);
        return count;
    }

    @Override
    public int savetalk(Connection connection, int id, byte[] bytes, String context, int count1) throws SQLException {
        PreparedStatement pstm = null;
        String sql = "insert into talk values (?,?,?,?)";
        int count=0;
        Blob blob = (Blob) connection.createBlob();
        blob.setBytes(1, bytes);
        pstm = connection.prepareStatement(sql);
        pstm.setInt(1,count1);
        pstm.setString(2, context);
        pstm.setBlob(3,blob);
        pstm.setInt(4,id);
        count = pstm.executeUpdate();
        BaseDao.closeResource(null, pstm, null);
        return count;
    }

    @Override
    public List<store> storelist(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<store> storeList = new ArrayList<store>();
        if(connection != null){
            String sql ="select * from store where id = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while(rs.next()){
                store _store = new store();
                _store.setId(rs.getInt("id"));
                _store.setAddress(rs.getString("address"));
                _store.setShop_name(rs.getString("shop_name"));
                _store.setMain_category(rs.getString("main_category"));
                _store.setAuxiliary_category(rs.getString("auxiliary_category"));
                storeList.add(_store);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return storeList;
    }
    @Override
    public List<dishes> dishlist(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<dishes> dishList = new ArrayList<dishes>();
        if(connection != null){
            String sql ="select * from dishes where s_id = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while(rs.next()){
                dishes _d = new dishes();
                _d.setId(rs.getInt("id"));
                _d.setName(rs.getString("name"));
                _d.setDescribe(rs.getString("describe"));
                _d.setStatus(rs.getString("status"));
                _d.setPrice(rs.getDouble("price"));
                _d.setCategory(rs.getString("category"));
                dishList.add(_d);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return dishList;
    }
}
