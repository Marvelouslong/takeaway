package dao.impl;

import dao.BaseDao;
import dao.userloginDao;
import pojo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userloginDaoImpl implements userloginDao {
    //得到登录的用户
    public user getLoginUser(Connection connection, long phone) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        user visitor=null ;
        if (connection != null) {
            String sql= "select * from user where phone=?";
            Object[] params={phone};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            if(rs.next()){
                visitor=new user();
                visitor.setId(rs.getInt("id"));
                visitor.setName(rs.getString("name"));
                visitor.setPhone(rs.getLong("phone"));
                visitor.setPassword(rs.getString("password"));
                visitor.setSignature(rs.getString("signature"));
                visitor.setSex(rs.getString("sex"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return visitor;
    }
}
