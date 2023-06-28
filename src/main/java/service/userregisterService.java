package service;

import pojo.rider;
import pojo.user;

import java.sql.SQLException;

public interface userregisterService {
    public void add(user User) throws SQLException;
}
