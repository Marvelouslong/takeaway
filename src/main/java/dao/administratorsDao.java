package dao;

import pojo.administrators;

import java.sql.Connection;

public interface administratorsDao {
    //得到登录的管理员
    public administrators getLoginAdmin(Connection connection, long account_number) throws  Exception;
}
