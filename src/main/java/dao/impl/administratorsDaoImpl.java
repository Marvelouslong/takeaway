package dao.impl;

import dao.BaseDao;
import dao.administratorsDao;
import pojo.administrators;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class administratorsDaoImpl implements administratorsDao {
    public administrators getLoginAdmin(Connection connection, long account_number) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        administrators admin=null ;
        if (connection != null) {
            String sql= "select * from administrators where account_number=?";
            Object[] params={account_number};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            if(rs.next()){
                admin=new administrators();
                admin.setId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setAccount_number(rs.getLong("account_number"));
                admin.setPassword(rs.getString("password"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return admin;
    }
    public int modifypassword(Connection connection,administrators admin) throws Exception {
        int updateNum = 0;
        PreparedStatement pstm = null;
        if(null != connection){
            String sql = "update administrators set password=? where account_number = ? ";
            Object[] params = {admin.getPassword(),admin.getAccount_number()};
            updateNum = BaseDao.execute(connection,pstm, sql,params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateNum;
    }
}
