package dao;

import pojo.rider;

import java.sql.Connection;

public interface loginriderDao {
    //得到登录的骑手
    public rider getLoginRider(Connection connection, long telephone ) throws  Exception;
}
