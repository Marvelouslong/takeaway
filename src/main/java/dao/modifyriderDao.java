package dao;

import pojo.administrators;
import pojo.rider;

import java.sql.Connection;

public interface modifyriderDao {
    //修改状态
    public int modifyrider(Connection connection, rider Rider, administrators admin)throws Exception;
    public int modifycontext(Connection connection, rider Rider)throws Exception;
}
