package dao.impl;

import com.mysql.cj.jdbc.Blob;
import dao.BaseDao;
import dao.userregisterDao;
import pojo.rider;
import pojo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userregisterDaoImpl implements userregisterDao {
    @Override
    public Integer add(user User) {
        Connection connection = BaseDao.getConnection();
        String sql = "insert into user(name,phone,password,signature,sex,picture) values(id,?,?,?,?,?,?) ";
        PreparedStatement pstm = null;
        Integer rs = null;
        try {
            Blob blob = (Blob) connection.createBlob();
            blob.setBytes(1, User.picture());
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, User.getName());
            pstm.setLong(2, User.getPhone());
            pstm.setString(3,User.getPassword());
            pstm.setString(4, User.getSignature());
            pstm.setString(5, User.getSex());
            pstm.setBlob(6,blob);
            rs=pstm.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null,pstm, null);
        }
        return rs;
    }
}

