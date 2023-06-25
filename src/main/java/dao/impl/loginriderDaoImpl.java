package dao.impl;

import dao.BaseDao;
import dao.loginriderDao;
import pojo.rider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginriderDaoImpl  implements loginriderDao {
    private loginriderDao loginriderdao;
    public rider getLoginRider(Connection connection, long phone) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        rider Rider=null ;
        if (connection != null) {
            String sql= "select * from rider where phone=?";
            Object[] params={phone};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            if(rs.next()){
                Rider=new rider();
                Rider.setId(rs.getInt("id"));
                Rider.setPhone(rs.getLong("phone"));
                Rider.setName(rs.getString("name"));
                Rider.setId_card(rs.getString("id_card"));
//                Rider.setDriver_license(rs.getBytes("driver_license"));
                Rider.setBank_card(rs.getLong("bank_card"));
                Rider.setWork_city(rs.getString("work_city"));
                Rider.setStatus(rs.getString("status"));
                Rider.setPassword(rs.getString("password"));
                Rider.setAd_id(rs.getInt("ad_id"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return Rider;
    }
}
