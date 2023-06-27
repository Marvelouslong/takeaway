package dao;

import pojo.administrators;


import java.sql.Connection;
import java.util.List;

public interface administratorsDao {
    //得到登录的管理员
    public administrators getLoginAdmin(Connection connection, long account_number) throws  Exception;
    //修改密码
    public int modifypassword(Connection connection,administrators admin)throws Exception;
}
