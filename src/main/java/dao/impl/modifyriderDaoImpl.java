package dao.impl;

import dao.BaseDao;
import dao.modifyriderDao;
import pojo.rider;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class modifyriderDaoImpl implements modifyriderDao {
    public int modifyrider(Connection connection, rider Rider) throws Exception {
        int updateNum = 0;
        PreparedStatement pstm = null;
        if(null != connection){
            String sql = "update rider set status=? where id = ? ";
            Object[] params = {Rider.getStatus(),Rider.getId()};
            updateNum = BaseDao.execute(connection,pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateNum;
    }
}
