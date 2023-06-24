package dao.impl;

import com.mysql.cj.jdbc.Blob;
import dao.BaseDao;
import dao.tasteDao;
import pojo.dishes;
import pojo.taste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class tasteDaoImpl implements tasteDao {



    public List<taste> list(Integer d_id) {
        Connection connection = BaseDao.getConnection();
        String sql = "select * from taste where  d_id = '"+d_id+"'";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<taste> list = new ArrayList<>();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new taste(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null, null,null);
        }
        return list;
    }

    public Integer add(taste taste) {
        Connection connection = BaseDao.getConnection();
        String sql = "insert into taste(name,d_id)values(?,?) ";
        PreparedStatement pstm = null;
        Integer rs = null;
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, taste.getName());
            pstm.setInt(2, taste.getD_id());
            rs = pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null,pstm, null);
        }
        return rs;
    }
    public Integer update(taste taste){
        Connection connection = BaseDao.getConnection();
        String sql = "update taste set `name` =? where id=?";
        PreparedStatement pstm = null;
        Integer rs = null;
        try {
            pstm.setString(1, taste.getName());
            pstm.setInt(2,taste.getId());
            rs= pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null,pstm, null);
        }
        return rs;
    }
    public Integer del(Integer id){
        Connection connection = BaseDao.getConnection();
        String sql = "delete from taste where id ='"+id+"'";
        PreparedStatement pstm = null;
        Integer rs = null;
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(null,pstm, null);
        }
        return rs;
    }
}
