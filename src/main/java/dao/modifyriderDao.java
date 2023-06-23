package dao;

import pojo.rider;

import java.sql.Connection;

public interface modifyriderDao {
    //修改状态
    public int modifyrider(Connection connection, rider Rider)throws Exception;
}
