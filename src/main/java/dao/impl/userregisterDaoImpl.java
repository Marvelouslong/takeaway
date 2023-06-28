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
    public Integer add(user User) throws SQLException {
        Connection connection = BaseDao.getConnection();
        String sql = "insert into `user`(`name`,phone,`password`,signature,sex,picture) values(?,?,?,?,?,?) ";
        PreparedStatement pstm = null;
        Integer rs = null;

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
            int count1=0;
        try {
            count1=this.Shopcar(connection,User);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(null,pstm, null);
            return rs;
        }



    }
    private int Shopcar (Connection connection,user user) throws Exception{
        PreparedStatement pstm=null;
        int updateNum=0;
        if(connection!=null) {
            String sql = "insert into shopcar(total_amount,total_number,u_id) values(null,null,(SELECT u.id from `user` u where u.phone=?))";
            Object[] params = {user.getPhone()};
            updateNum = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null,pstm,null);
        }
        return updateNum;
    }
}


