package dao;

import pojo.store;
import pojo.talk;

import java.sql.Connection;
import java.util.List;

public interface userdao {
    public int getstoreCount(Connection connection, String query) throws Exception;

    public List<store> getstorelist(Connection connection, String query, int currentPageNo, int pageSize)throws Exception;
    public List<talk> getstorelist(Connection connection)throws Exception;
    public byte[] img(Connection connection,int id,String type,String table);
}
