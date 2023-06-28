package dao.impl;

import com.mysql.cj.jdbc.Blob;
import dao.BaseDao;
import dao.modifyriderDao;
import pojo.administrators;
import pojo.rider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modifyriderDaoImpl implements modifyriderDao {
    public int modifyrider(Connection connection, rider Rider, administrators admin) throws Exception {
        int updateNum = 0;
        PreparedStatement pstm = null;
        if(null != connection){
            String sql = "update rider set status=?,ad_id=(select id from administrators where account_number=?) where id = ? ";
            Object[] params = {Rider.getStatus(),admin.getAccount_number(),Rider.getId()};
            updateNum = BaseDao.execute(connection,pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateNum;
    }
    public int modifycontext(Connection connection, rider Rider) throws Exception {
            PreparedStatement pstm = null;
            String sql = "update rider set phone=?,bank_card=?,work_city=?,`password`=?  where id = ? ";
            Integer rs = null;
        try {
            pstm = connection.prepareStatement(sql);
            pstm = connection.prepareStatement(sql);
            pstm.setLong(1,Rider.getPhone());
            pstm.setLong(2,Rider.getBank_card());
            pstm.setString(3, Rider.getWork_city());
            pstm.setString(4,Rider.getPassword());
            pstm.setInt(5,Rider.getId());
            rs= pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null, pstm, null);
        }
            return rs;
    }
    public int modifydriver(Connection connection, rider Rider) throws Exception {
        PreparedStatement pstm = null;
        String sql = "update rider set driver_license=?  where id = ? ";
        Integer rs = null;
        try {
            pstm = connection.prepareStatement(sql);
            Blob blob = (Blob) connection.createBlob();
            blob.setBytes(1,Rider.driver_license);
            pstm = connection.prepareStatement(sql);
            pstm.setBlob(1,blob);
            pstm.setInt(2,Rider.getId());
            rs= pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null, pstm, null);
        }
        return rs;
    }
}
