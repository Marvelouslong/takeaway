package dao.impl;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.util.StringUtils;
import dao.BaseDao;
import dao.userdao;
import pojo.store;
import pojo.talk;
import pojo.user;

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
//                _store.setId(rs.getInt("id"));
                _store.setAddress(rs.getString("address"));
                _store.setShop_name(rs.getString("shop_name"));
                _store.setShop_picture((Blob) rs.getBlob("Shop_picture"));
                storeList.add(_store);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return storeList;
    }

    @Override
    public List<talk> getstorelist(Connection connection) throws Exception {
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
                _talk.setPicture((Blob) rs.getBlob("picture"));
                _talk.set_u(_user);
                talkList.add(_talk);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return talkList;
    }
}
