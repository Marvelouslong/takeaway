package dao.impl;

import dao.BaseDao;
import dao.dishesDao;
import pojo.dishes;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dishesDaoImpl implements dishesDao {
    @Override
    public List<dishes> list(Integer s_id) {
        Connection connection = BaseDao.getConnection();
        String sql = "select * from dishes where  s_id = '"+s_id+"'";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<dishes> list = new ArrayList<>();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String describe = rs.getString(4);
                String status = rs.getString(5);
                Double price= rs.getDouble(6);
                String category = rs.getString(7);
                list.add(new dishes());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null, null,null);
        }
        return list;
    }

    @Override
    public Integer add(dishes dishes) {
        Connection connection = BaseDao.getConnection();
        String sql = "insert into dishes(name,describe,status,price,category,picture,s_id) values(?,?,?,?,?,?,?) ";
        PreparedStatement pstm = null;
        Integer rs = null;
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, dishes.getName());
            pstm.setString(2, dishes.getDescribe());
            pstm.setString(3, dishes.getStatus());
            pstm.setDouble(4, dishes.getPrice());
            pstm.setString(5, dishes.getCategory());
            pstm.setBytes(6, dishes.getPicture());
            pstm.setInt(7,dishes.getS_id());
            rs = pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, pstm, null);
        }
        return rs;
    }
}
