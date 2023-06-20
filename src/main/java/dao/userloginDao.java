package dao;

import pojo.user;

import java.sql.Connection;

public interface userloginDao {
    //得到登录的用户
    public  user getLoginUser(Connection connection, long phone) throws  Exception;
}
