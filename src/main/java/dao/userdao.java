package dao;

import pojo.store;

import java.sql.Connection;
import java.util.List;

public interface userdao {
    public int getstoreCount(Connection connection, String query) throws Exception;

    public List<store> getstorelist(Connection connection, String query, int currentPageNo, int pageSize)throws Exception;

}
