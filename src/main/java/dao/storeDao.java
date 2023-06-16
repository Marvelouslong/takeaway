package dao;

import pojo.administrators;
import pojo.store;

import java.sql.Connection;

public interface storeDao {
    //得到登录的商家
    public store getLoginStore(Connection connection,long con_telephone ) throws  Exception;
}
