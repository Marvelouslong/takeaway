package dao.impl;

import com.mysql.cj.jdbc.Blob;
import dao.BaseDao;
import dao.riderregisterDao;
import pojo.rider;

import java.sql.*;

public class riderregisterDaoImpl implements riderregisterDao {

    @Override
    public Integer add(rider Rider) {
        Connection connection = BaseDao.getConnection();
        String sql = "insert into rider(phone,name,id_card,driver_license,bank_card,work_city,status,password,ad_id) values(?,?,?,?,?,?,?,?,?) ";
        PreparedStatement pstm = null;
        Integer rs = null;
        try {
            Blob blob = (Blob) connection.createBlob();
            blob.setBytes(1, Rider.driver_license());
            pstm = connection.prepareStatement(sql);
            pstm.setLong(1, Rider.getPhone());
            pstm.setString(2, Rider.getName());
            pstm.setString(3, Rider.getId_card());
            pstm.setLong(4, Rider.getBank_card());
            pstm.setString(5, Rider.getWork_city());
            pstm.setString(6,Rider.getStatus());
            pstm.setBlob(7,blob);
            pstm.setString(8,Rider.getPassword());
            pstm.setInt(9,Rider.getAd_id());
            rs = pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null,pstm, null);
        }
        return rs;
    }
}
