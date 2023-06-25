package dao.impl;

import com.mysql.cj.jdbc.Blob;
import dao.BaseDao;
import dao.adminregisterDao;
import pojo.administrators;
import pojo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class adminregisterDaoImpl implements adminregisterDao {
    @Override
    public Integer add(administrators Administrators) {
        Connection connection = BaseDao.getConnection();
        String sql = "insert into administrators(`name`,account_number,`password`) values(?,?,?) ";
        PreparedStatement pstm = null;
        Integer rs = null;
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, Administrators.getName());
            pstm.setLong(2, Administrators.getAccount_number());
            pstm.setString(3,Administrators.getPassword());
            rs = pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null,pstm, null);
        }
        return rs;
    }
}

