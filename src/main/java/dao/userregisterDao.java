package dao;

import pojo.store;
import pojo.user;

import java.sql.SQLException;

public interface userregisterDao {
    public Integer add(user User) throws SQLException;
}
