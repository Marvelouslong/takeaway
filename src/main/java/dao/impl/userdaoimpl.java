package dao.impl;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.util.StringUtils;
import dao.BaseDao;
import dao.userdao;
import pojo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class userdaoimpl implements userdao {
    @Override
    public int getstoreCount(Connection connection, String query)throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(distinct s.id) as count from store s,dishes d where s.id = d.s_id");
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
            sql.append("select distinct s.* from store s,dishes d where s.id = d.s_id");
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
    public List<talk> gettalklist(Connection connection,int currentPageNo, int pageSize) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<talk> talkList = new ArrayList<talk>();
        if(connection != null){
            String sql = "select t.id tid,t.context,u.name,u.id uid from talk t,user u where t.u_id = u.id order by t.id DESC limit ?,?";
            pstm = connection.prepareStatement(sql);
            currentPageNo = (currentPageNo-1)*pageSize;
            pstm.setInt(1,currentPageNo);
            pstm.setObject(2,pageSize);
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
    public int saveUserImage(Connection connection, int id, byte[] imgdata,String name, Long phone1,String sex, String signature, String password) throws SQLException {
        PreparedStatement pstm = null;
        String sql = "update user set picture = ?,name=?,sex=?,signature=?,phone=?,password=? where id = ?";
        int count=0;
        Blob blob = (Blob) connection.createBlob();
        blob.setBytes(1, imgdata);
        pstm = connection.prepareStatement(sql);
        pstm.setBlob(1,blob);
        pstm.setString(2,name);
        pstm.setString(3,sex);
        pstm.setString(4,signature);
        pstm.setLong(5,phone1);
        pstm.setString(6,password);
        pstm.setInt(7, id);
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
    public List<taste> tastelist(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<taste> tasteList = new ArrayList<taste>();
        if(connection != null){
            String sql ="select * from taste where d_id = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while(rs.next()){
                taste _t=new taste();
                _t.setId(rs.getInt("id"));
                _t.setName(rs.getString("name"));
                _t.setD_id(rs.getInt("d_id"));
                tasteList.add(_t);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return tasteList;
    }

    @Override
    public List<receiver> getreceiverlist(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<receiver> receiverList = new ArrayList<receiver>();
        if(connection != null){
            String sql = "select * from receiver where u_id=?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while(rs.next()){
                receiver _re=new receiver();
                _re.setId(rs.getInt("id"));
                _re.setName(rs.getString("name"));
                _re.setAddress(rs.getString("address"));
                _re.setPhone(rs.getLong("phone"));
                receiverList.add(_re);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return receiverList;
    }

    @Override
    public int changeostatus(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        int count=0;
        if(connection != null){
            String sql ="update `order` set status = '已完成' checkout_time=NOW() where id = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            count=pstm.executeUpdate();
            BaseDao.closeResource(null, pstm, null);
        }
        return count;
    }
    public int change_receiver(Connection connection, int id,String name,Long phone,String address) throws Exception {
        PreparedStatement pstm = null;
        int count=0;
        if(connection != null){
            String sql ="update receiver set name=?,phone=?,address=? where id = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1,name);
            pstm.setLong(2,phone);
            pstm.setString(3,address);
            pstm.setInt(4,id);
            count=pstm.executeUpdate();
            BaseDao.closeResource(null, pstm, null);
        }
        return count;
    }

    @Override
    public int getreceiverCount(Connection connection) throws Exception {
        PreparedStatement pstm=null;
        int count=0;
        String sql="select count(id) as count from receiver";
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
    public int addre(Connection connection, int count, String name, Long phone, String address, int id) throws Exception {
        PreparedStatement pstm = null;
        int count1=0;
        if(connection != null){
            String sql ="insert into receiver values (?,?,?,?,?)";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,count);
            pstm.setString(2,name);
            pstm.setLong(3,phone);
            pstm.setString(4,address);
            pstm.setInt(5,id);
            count1=pstm.executeUpdate();
            BaseDao.closeResource(null, pstm, null);
        }
        return count1;
    }

    @Override
    public int upshop(Connection connection, int id, int id1,String taste) throws Exception {
        PreparedStatement pstm = null;
        int count=0;
        int count1=0;
        if(connection != null){
            String sql =" INSERT INTO `shopcar-dishes` (`d_id`, `shopcar_id`, `time`, `number`, `taste`) " +
                    "VALUES (?, ?, NOW(), 1, ?) " +
                    "ON DUPLICATE KEY UPDATE `number` = `number` + 1";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.setInt(2,id1);
            pstm.setString(3,taste);
            count=pstm.executeUpdate();
        }
        count1=this.addshopcar(connection,id1);
        if(count1!=0) {
            BaseDao.closeResource(null, pstm, null);
        }
        return count;
    }
    private int addshopcar(Connection connection, int id1) throws SQLException {
            int count=0;
            PreparedStatement pstm1 = null;
            PreparedStatement pstm2 = null;
            ResultSet rs1=null;
            double sum=0;
            int number1=0;
            if(connection != null){
                String sql1 ="select d.price,sd.number from dishes d,`shopcar-dishes` sd where d.id=sd.d_id and sd.shopcar_id=?";
                String sql2 ="update shopcar set total_amount = ?,total_number=? where id = ?";
                pstm1 = connection.prepareStatement(sql1);
                pstm1.setInt(1,id1);
                rs1=pstm1.executeQuery();
                while(rs1.next()){
                    double price=rs1.getDouble("price");
                    int number=rs1.getInt("number");
                    double a=price*number;
                    sum+=a;
                    number1+=number;
                }
                pstm2 = connection.prepareStatement(sql2);
                pstm2.setDouble(1,sum);
                pstm2.setInt(2, number1);
                pstm2.setInt(3, id1);
                count=pstm2.executeUpdate();
            }
            BaseDao.closeResource(null, pstm1, rs1);
            BaseDao.closeResource(null, pstm2, null);
            return count;
    }
    @Override
    public int getstoreid(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        int count=0;
        ResultSet rs=null;
        if(connection != null){
            String sql ="select s_id from dishes where id=?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            if(rs.next()){
                count=rs.getInt("s_id");
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return count;
    }

    @Override
    public int delevaluate(Connection connection, int id) throws Exception {
        PreparedStatement pstm = null;
        int count=0;
        if(connection != null){
            String sql ="delete from evaluate where id =?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            count=pstm.executeUpdate();
            BaseDao.closeResource(null, pstm, null);
        }
        return count;
    }

    @Override
    public List<shopcar_dishes> carlist(Connection connection, int id, int id1) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<shopcar_dishes> carlist = new ArrayList<shopcar_dishes>();
        if(connection != null){
            String sql = "select d.id did,d.name,sd.taste,sd.number,d.price,car.total_amount,car.total_number " +
                    "from `shopcar-dishes` sd,shopcar car,dishes d " +
                    "where sd.shopcar_id=car.id and sd.d_id=d.id and car.id=? and d.s_id=?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id1);
            pstm.setInt(2,id);
            rs=pstm.executeQuery();
            while(rs.next()){
                shopcar_dishes _sd=new shopcar_dishes();
                _sd.setTaste(rs.getString("taste"));
                _sd.setNumber(rs.getInt("number"));
                dishes _d=new dishes();
                _d.setId(rs.getInt("did"));
                _d.setName(rs.getString("name"));
                _d.setPrice(rs.getDouble("price"));
                _sd.set_d(_d);
                shopcar _car=new shopcar();
                _car.setTotal_amount(rs.getDouble("total_amount"));
                _car.setTotal_number(rs.getInt("total_number"));
                _sd.set_shopcar(_car);
                carlist.add(_sd);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return carlist;
    }

    @Override
    public int delshop(Connection connection, int sid, int id) throws Exception {
        PreparedStatement pstm = null;
        int count=0;
        int count1=0;
        if(connection != null){
            String sql ="delete sd from dishes d,`shopcar-dishes` sd where d.id=sd.d_id and sd.shopcar_id=? and d.s_id=?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.setInt(2,sid);
            count=pstm.executeUpdate();
            count1=this.addshopcar(connection,id);
            if(count1!=0) {
                BaseDao.closeResource(null, pstm, null);
            }
        }
        return count;
    }

    @Override
    public List<shopcar_dishes> shopcarlist(Connection connection, int id1) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<shopcar_dishes> carlist = new ArrayList<shopcar_dishes>();
        if(connection != null){
            String sql = "select s.shop_name,d.id did,d.name,d.s_id,car.total_amount,car.total_number " +
                    "from `shopcar-dishes` sd,shopcar car,dishes d,store s " +
                    "where sd.shopcar_id=car.id and sd.d_id=d.id and car.id=? and s.id=d.s_id " +
                    "order by d.s_id";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id1);
            rs=pstm.executeQuery();
            while(rs.next()){
                store _store=new store();
                _store.setShop_name(rs.getString("shop_name"));
                shopcar_dishes _sd=new shopcar_dishes();
                dishes _d=new dishes();
                _d.setId(rs.getInt("did"));
                _d.setName(rs.getString("name"));
                _d.setS_id(rs.getInt("s_id"));
                _d.set_s(_store);
                _sd.set_d(_d);
                shopcar _car=new shopcar();
                _car.setTotal_amount(rs.getDouble("total_amount"));
                _car.setTotal_number(rs.getInt("total_number"));
                _sd.set_shopcar(_car);
                carlist.add(_sd);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return carlist;
    }
}

