package dao;

import pojo.rider;

import java.sql.Connection;
import java.util.List;

public interface ridernewsDao {
    //查看骑手信息
    public List<rider> getriderList(Connection connection) throws  Exception;
}
